/*
 * Copyright (c) 2024, Smoke (Smoked today) <https://github.com/Varietyz>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.reordersidebar;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;

@Slf4j
class ReorderSidebar
{
	private static final String CONFIG_KEY_CUSTOM_ORDER = "customOrder";

	private final ConfigManager configManager;
	private final Gson gson;
	@Getter
	private final ReorderSidebarConfig config;
	// TODO: check that this clientUI is synced with the real clientUI and isn't a separate duplicated clientUI
	private final ClientUI clientUI;

	// TODO: remove and use singleton clientUI.sidebar or synchronize with clientUI.getSidebar()
	private JTabbedPane sidebar;
	// TODO: remove and use singleton clientUI.sidebarTabOrder or synchronize with clientUI.getSidebarTabOrder()
	private List<NavigationButton> sidebarTabOrder;
	private DropIndicatorGlassPane glassPane;
	private MouseAdapter dragMouseListener;
	private KeyEventDispatcher keyDispatcher;
	private volatile boolean hotkeyDown;
	@Getter
	private int pendingDragSourceIndex = -1;

	@Inject
	ReorderSidebar(ConfigManager configManager, Gson gson, ReorderSidebarConfig config, ClientUI clientUI)
	{
		this.configManager = configManager;
		this.gson = gson;
		this.config = config;
		this.clientUI = clientUI;
	}

	void startUp()
	{

		sidebar = clientUI.getSidebar();
		this.sidebarTabOrder = clientUI.getSidebarTabOrder();

		if (sidebar == null || sidebarTabOrder == null)
		{
			return;
		}

		installKeyDispatcher();
		installDragHandler();

		if (config.useCustomTabOrder())
		{
			log.info("Reorder Sidebar applying custom order on startup.");
			applyCustomOrder();
		}
	}

	void shutDown()
	{
		removeKeyDispatcher();

		if (sidebar != null)
		{
			sidebar.setTransferHandler(null);
			applyDefaultOrder();
			if (dragMouseListener != null)
			{
				sidebar.removeMouseListener(dragMouseListener);
				sidebar.removeMouseMotionListener(dragMouseListener);
				dragMouseListener = null;
			}
		}
	}

	void reset()
	{
		// TODO: when disabling the plugin, sometimes we encounter an IllegalComponentStateException("component must
		//  be showing on the screen to determine its location") from java/awt/Component.java:2101
		configManager.unsetConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);

		// TODO: fix this as this doesn't include newly installed plugin tabs when installed. It only checks for the
		//  current sidebar entries, which do not include any newly installed plugins.
		clientUI.rebuildSidebar(clientUI.getSidebarEntries());
	}

	private void installKeyDispatcher()
	{
		keyDispatcher = e ->
		{
			if (matchesHotkey(e))
			{
				hotkeyDown = e.getID() == KeyEvent.KEY_PRESSED;
			}
			return false;
		};
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyDispatcher);
	}

	private void removeKeyDispatcher()
	{
		if (keyDispatcher != null)
		{
			KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyDispatcher);
			keyDispatcher = null;
		}
		hotkeyDown = false;
	}

	void clearPendingDragSourceIndex()
	{
		pendingDragSourceIndex = -1;
	}

	private boolean matchesHotkey(KeyEvent e)
	{
		Keybind hotkey = config.dragHotkey();
		if (hotkey == null || hotkey.equals(Keybind.NOT_SET))
		{
			return false;
		}
		return hotkey.matches(e);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(ReorderSidebarConfig.CONFIG_GROUP) ||
			!event.getKey().equals("useCustomTabOrder"))
		{
			return;
		}

		if (config.useCustomTabOrder())
		{
			applyCustomOrder();
		}
		else
		{
			clientUI.rebuildSidebar(clientUI.getSidebarEntries());
		}
	}

	void setCustomOrderTabs(List<NavigationButton> entries)
	{
		if (entries == null || entries.isEmpty())
		{
			return;
		}

		List<String> tabList = entries.stream()
			.map(NavigationButton::getTooltip)
			.collect(java.util.stream.Collectors.toList());

		configManager.setConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, gson.toJson(tabList));
	}

	private List<NavigationButton> getCustomOrderTabs()
	{
		String tabListJson = configManager.getConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);

		if (tabListJson == null || tabListJson.isEmpty())
		{
			return new ArrayList<>();
		}

		// Don't blame me, I followed the pattern from ChatCommandsPlugin.java for this deserialization
		List<String> tabList;
		try
		{
			// CHECKSTYLE:OFF
			tabList = gson.fromJson(tabListJson, new TypeToken<List<String>>(){}.getType());
			// CHECKSTYLE:ON
		}
		catch (Exception e)
		{
			log.warn("Corrupted custom order config, clearing it: {}", e.getMessage());
			configManager.unsetConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
			return new ArrayList<>();
		}

		if (tabList == null || tabList.isEmpty())
		{
			return new ArrayList<>();
		}

		Collection<NavigationButton> allButtons = clientUI.getSidebarEntries();

		// Build result: saved order first, then append any new buttons
		List<NavigationButton> result = tabList.stream()
			.map(tab -> allButtons.stream()
				.filter(btn -> btn.getTooltip().equals(tab))
				.findFirst()
				.orElse(null))
			.filter(Objects::nonNull)
			.collect(java.util.stream.Collectors.toList());

		allButtons.stream()
			.filter(btn -> !result.contains(btn))
			.forEach(result::add);

		return result;
	}

	private void applyCustomOrder()
	{
		List<NavigationButton> orderedButtons = getCustomOrderTabs();
		if (!orderedButtons.isEmpty())
		{
			clientUI.rebuildSidebar(orderedButtons);
		}
	}

	private void applyDefaultOrder()
	{
		clientUI.rebuildSidebar(clientUI.getSidebarEntries());
	}

	private void ensureGlassPane()
	{
		if (glassPane == null && sidebar != null)
		{
			JRootPane rootPane = SwingUtilities.getRootPane(sidebar);
			if (rootPane != null)
			{
				glassPane = new DropIndicatorGlassPane();
				rootPane.setGlassPane(glassPane);
			}
		}
	}

	private void installDragHandler()
	{
		if (dragMouseListener != null)
		{
			sidebar.removeMouseMotionListener(dragMouseListener);
		}

		ensureGlassPane();
		TabReorderHandler transferHandler = new TabReorderHandler(this, sidebar, sidebarTabOrder, glassPane);
		sidebar.setTransferHandler(transferHandler);
		transferHandler.installDropIndicator();

		dragMouseListener = new DragMouseListener();
		sidebar.addMouseListener(dragMouseListener);
		sidebar.addMouseMotionListener(dragMouseListener);
	}

	private class DragMouseListener extends MouseAdapter
	{
		private boolean dragInitiated;
		private int dragStartIndex = -1;

		@Override
		public void mousePressed(MouseEvent e)
		{
			dragStartIndex = -1;
			dragInitiated = false;

			if (!config.useCustomTabOrder() || isDragBlocked())
			{
				return;
			}

			dragStartIndex = sidebar.indexAtLocation(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			dragStartIndex = -1;
			dragInitiated = false;
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if (!config.useCustomTabOrder() || isDragBlocked())
			{
				return;
			}

			if (dragStartIndex != -1 && !dragInitiated)
			{
				dragInitiated = true;
				pendingDragSourceIndex = dragStartIndex;
				sidebar.getTransferHandler().exportAsDrag(sidebar, e, TransferHandler.MOVE);
			}
		}

		private boolean isDragBlocked()
		{
			Keybind hotkey = config.dragHotkey();
			boolean hotkeyRequired = config.dragRequiresHotkey() && hotkey != null && !hotkey.equals(Keybind.NOT_SET);
			return hotkeyRequired && !hotkeyDown;
		}
	}
}
