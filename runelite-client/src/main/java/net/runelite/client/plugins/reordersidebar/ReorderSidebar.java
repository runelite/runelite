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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.DragAndDropTabbedPane;

@Slf4j
class ReorderSidebar
{
	private static final String CONFIG_KEY_CUSTOM_ORDER = "customOrder";

	private final ConfigManager configManager;
	private final Gson gson;
	@Getter
	private final ReorderSidebarConfig config;
	private final ClientUI clientUI;

	private DragAndDropTabbedPane sidebar;
	private List<NavigationButton> sidebarTabOrder;
	private KeyEventDispatcher keyDispatcher;
	private volatile boolean hotkeyDown;
	private DragAndDropTabbedPane.TabDragListener tabDragListener;
	private boolean reorderPending;

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
		sidebarTabOrder = clientUI.getSidebarTabOrder();

		if (sidebar == null || sidebarTabOrder == null)
		{
			return;
		}

		installKeyDispatcher();
		installDragHandler();

		if (config.useCustomTabOrder())
		{
			applyCustomOrder();
		}
	}

	void shutDown()
	{
		removeKeyDispatcher();

		if (sidebar != null)
		{
			sidebar.setDragEnabled(false);
			sidebar.setDragAllowedSupplier(null);
			if (tabDragListener != null)
			{
				sidebar.removeTabDragListener(tabDragListener);
				tabDragListener = null;
			}
			applyDefaultOrder();
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

	@Subscribe
	public void onPluginChanged(PluginChanged event)
	{
		if (!event.isLoaded() || !config.useCustomTabOrder())
		{
			return;
		}

		// Coalesce multiple PluginChanged events into a single reorder.
		// During startup, startPlugins() fires PluginChanged for each plugin via
		// invokeAndWait, so an invokeLater posted here will run after the entire
		// batch of synchronous plugin starts completes.
		if (!reorderPending)
		{
			reorderPending = true;
			SwingUtilities.invokeLater(() ->
			{
				reorderPending = false;
				// Don't rebuild the sidebar while a drag is in progress
				if (sidebar != null && sidebar.isDragging())
				{
					return;
				}
				applyCustomOrder();
			});
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
			.collect(Collectors.toList());

		configManager.setConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, gson.toJson(tabList));
	}

	private List<NavigationButton> getCustomOrderTabs()
	{
		String customTabOrderListJson = configManager.getConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);

		if (customTabOrderListJson == null || customTabOrderListJson.isEmpty())
		{
			return new ArrayList<>();
		}

		// Don't blame me, I followed the pattern from ChatCommandsPlugin.java for list deserialization
		List<String> customTabOrderList;
		try
		{
			// CHECKSTYLE:OFF
			customTabOrderList = gson.fromJson(customTabOrderListJson, new TypeToken<List<String>>()
			{
			}.getType());
			// CHECKSTYLE:ON
		}
		catch (Exception e)
		{
			log.warn("Corrupted custom order config, clearing it: {}", e.getMessage());
			configManager.unsetConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
			return new ArrayList<>();
		}

		if (customTabOrderList == null || customTabOrderList.isEmpty())
		{
			return new ArrayList<>();
		}
		log.info("Retrieved stored custom tab order: {}", customTabOrderList);

		Collection<NavigationButton> currentSidebarTabs = clientUI.getSidebarEntries();

		// Build assembledTabList: saved order first, then append any new buttons
		List<NavigationButton> assembledTabList = customTabOrderList.stream()
			.map(tab -> currentSidebarTabs.stream()
				.filter(btn -> btn.getTooltip().equals(tab))
				.findFirst()
				.orElse(null))
			.filter(Objects::nonNull)
			.collect(Collectors.toList());

		currentSidebarTabs.stream()
			.filter(btn -> !assembledTabList.contains(btn))
			.forEach(assembledTabList::add);

		List<String> resultTooltips = assembledTabList.stream()
			.map(NavigationButton::getTooltip)
			.collect(Collectors.toList());
		log.info("Order comparison between customTabOrderList and assembledTabList: {}",
			customTabOrderList.equals(resultTooltips));
		return assembledTabList;
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

	private void installDragHandler()
	{
		// Enable drag on the sidebar
		sidebar.setDragEnabled(true);

		// Set up drag allowed supplier to check hotkey requirement
		sidebar.setDragAllowedSupplier(this::isDragAllowed);

		// Listen for tab drag events to save the new order
		tabDragListener = (fromIndex, toIndex) ->
		{
			// Update the sidebarTabOrder to match the new visual order
			if (fromIndex >= 0 && fromIndex < sidebarTabOrder.size() &&
				toIndex >= 0 && toIndex < sidebarTabOrder.size())
			{
				NavigationButton moved = sidebarTabOrder.remove(fromIndex);
				sidebarTabOrder.add(toIndex, moved);
				setCustomOrderTabs(sidebarTabOrder);
			}
		};
		sidebar.addTabDragListener(tabDragListener);
	}

	private boolean isDragAllowed()
	{
		if (!config.useCustomTabOrder())
		{
			return false;
		}

		Keybind hotkey = config.dragHotkey();
		boolean hotkeyRequired = config.dragRequiresHotkey() && hotkey != null && !hotkey.equals(Keybind.NOT_SET);
		return !hotkeyRequired || hotkeyDown;
	}
}
