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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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

/**
 * Handles sidebar icon reordering via drag and drop.
 */
@Slf4j
class ReorderSidebar
{
	// TODO: find way to restore default order when plugin is disabled
	private static final String CONFIG_KEY_CUSTOM_ORDER = "customOrder";

	/**
	 * Maps Keybind modifier keys to their corresponding MouseEvent modifier masks.
	 * TODO: enable any key to be the drag hot key.
	 */
	private static final Map<Keybind, Integer> MODIFIER_MASKS = Map.of(
		Keybind.SHIFT, MouseEvent.SHIFT_DOWN_MASK,
		Keybind.CTRL, MouseEvent.CTRL_DOWN_MASK,
		Keybind.ALT, MouseEvent.ALT_DOWN_MASK
	);

	private final ConfigManager configManager;
	private final Gson gson;
	@Getter
	private final ReorderSidebarConfig config;
	private final ClientUI clientUI;

	private JTabbedPane sidebar;
	private List<NavigationButton> sidebarTabOrder;
	private DropIndicatorGlassPane glassPane;
	private MouseAdapter dragMouseListener;
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

	/**
	 * Clear the pending drag source index after it has been used.
	 */
	void clearPendingDragSourceIndex()
	{
		pendingDragSourceIndex = -1;
	}

	/**
	 * Check if the configured drag hotkey is currently pressed.
	 * Uses the MouseEvent modifiers since Swing components don't use the game's KeyManager.
	 */
	private boolean isHotkeyPressed(MouseEvent e)
	{
		Keybind hotkey = config.dragHotkey();
		if (hotkey == null || hotkey.equals(Keybind.NOT_SET))
		{
			return true;
		}

		int modifiers = e.getModifiersEx();

		// Check if the hotkey is a known modifier key
		Integer mask = MODIFIER_MASKS.get(hotkey);
		if (mask != null)
		{
			return (modifiers & mask) != 0;
		}

		// For other keys, check the hotkey's modifiers against the event
		int requiredModifiers = hotkey.getModifiers();
		return requiredModifiers != 0 && (modifiers & requiredModifiers) == requiredModifiers;
	}

	void startUp()
	{
		sidebar = clientUI.getSidebar();
		sidebarTabOrder = clientUI.getSidebarTabOrder();

		if (sidebar == null || sidebarTabOrder == null)
		{
			return;
		}

		installDragHandler();

		// Apply saved custom order on startup if enabled
		if (config.useCustomTabOrder())
		{
			applyCustomOrder();
		}
	}

	void shutDown()
	{
		if (sidebar != null)
		{
			sidebar.setTransferHandler(null);
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
		configManager.unsetConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
		clientUI.rebuildSidebar(clientUI.getSidebarEntries());
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

	/**
	 * Apply the saved custom order to the sidebar, or use default if none saved.
	 */
	private void applyCustomOrder()
	{
		List<NavigationButton> orderedButtons = getCustomOrderTabs();
		if (!orderedButtons.isEmpty())
		{
			clientUI.rebuildSidebar(orderedButtons);
		}
	}

	void setCustomOrderTabs(List<NavigationButton> entries)
	{
		if (entries == null || entries.isEmpty())
		{
			return;
		}

		List<String> tabList = new ArrayList<>();
		for (NavigationButton btn : entries)
		{
			tabList.add(btn.getTooltip());
		}

		String json = gson.toJson(tabList);
		configManager.setConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, json);
		log.debug("set custom order: {} entries", tabList.size());
	}

	/**
	 * Get the saved custom order as list of NavigationButtons.
	 * Returns buttons in saved order, with any new plugins appended.
	 */
	private List<NavigationButton> getCustomOrderTabs()
	{
		String tabListJson = configManager.getConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);

		if (tabListJson == null || tabListJson.isEmpty())
		{
			return new ArrayList<>();
		}

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
		List<NavigationButton> result = new ArrayList<>();

		// Add buttons in saved order
		for (String tab : tabList)
		{
			for (NavigationButton btn : allButtons)
			{
				if (btn.getTooltip().equals(tab))
				{
					result.add(btn);
					break;
				}
			}
		}

		// Append any new buttons not in saved order
		for (NavigationButton btn : allButtons)
		{
			if (!result.contains(btn))
			{
				result.add(btn);
			}
		}

		return result;
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

		dragMouseListener = new MouseAdapter()
		{
			private boolean dragInitiated = false;
			private int dragStartIndex = -1;

			@Override
			public void mousePressed(MouseEvent e)
			{
				// Only prepare for drag if custom order is enabled
				if (!config.useCustomTabOrder())
				{
					dragStartIndex = -1;
					return;
				}

				// Only prepare for drag if hotkey requirement is met
				if (config.dragRequiresHotkey() && !isHotkeyPressed(e))
				{
					dragStartIndex = -1;
					return;
				}

				// Capture the index at the moment of mouse press (before any dragging)
				dragStartIndex = sidebar.indexAtLocation(e.getX(), e.getY());
				dragInitiated = false;
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
				// Don't allow dragging if custom order is disabled
				if (!config.useCustomTabOrder())
				{
					return;
				}

				// Don't allow dragging if hotkey is required but not pressed
				if (config.dragRequiresHotkey() && !isHotkeyPressed(e))
				{
					return;
				}

				// Use the index captured at mouse press, not current location
				if (dragStartIndex != -1 && !dragInitiated)
				{
					dragInitiated = true;
					pendingDragSourceIndex = dragStartIndex;
					sidebar.getTransferHandler().exportAsDrag(sidebar, e, TransferHandler.MOVE);
				}
			}
		};
		sidebar.addMouseListener(dragMouseListener);
		sidebar.addMouseMotionListener(dragMouseListener);
	}
}
