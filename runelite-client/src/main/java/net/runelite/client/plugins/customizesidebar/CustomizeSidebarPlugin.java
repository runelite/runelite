/*
 * Copyright (c) 2026, Swirle13 <https://github.com/swirle13>
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
package net.runelite.client.plugins.customizesidebar;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.DragAndDropTabbedPane;

@PluginDescriptor(
	name = "Customize Sidebar",
	description = "Allows customizing sidebar icons via drag and drop",
	tags = {"sidebar", "icons", "customize", "reorder", "drag", "drop"},
	enabledByDefault = false
)
@Slf4j
public class CustomizeSidebarPlugin extends Plugin
{
	private static final String CONFIG_KEY_CUSTOM_ORDER = "customOrder";

	@Inject
	private ConfigManager configManager;

	@Inject
	private Gson gson;

	@Inject
	private CustomizeSidebarConfig config;

	@Inject
	private ClientUI clientUI;

	private DragAndDropTabbedPane sidebar;
	private List<NavigationButton> sidebarTabOrder;
	private SidebarDragManager dragManager;
	private boolean reorderPending;

	@Provides
	CustomizeSidebarConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CustomizeSidebarConfig.class);
	}

	@Subscribe
	public void onPluginChanged(PluginChanged event)
	{
		if (!event.isLoaded())
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
				applyCustomOrder();
			});
		}
	}

	@Override
	protected void startUp()
	{
		sidebar = clientUI.getSidebar();
		sidebarTabOrder = clientUI.getSidebarTabOrder();

		if (sidebar == null || sidebarTabOrder == null)
		{
			return;
		}

		dragManager = new SidebarDragManager(
			config,
			sidebar,
			sidebarTabOrder,
			(from, to) -> saveCustomOrder(sidebarTabOrder)
		);
		dragManager.install();

		// Enable custom ordering for future tab insertions
		clientUI.setCustomOrderingActiveSupplier(() -> true);

		// Apply custom order via invokeLater to run after current event processing
		SwingUtilities.invokeLater(this::applyCustomOrder);
	}

	@Override
	protected void shutDown()
	{
		clientUI.setCustomOrderingActiveSupplier(null);

		if (dragManager != null)
		{
			dragManager.uninstall();
			dragManager = null;
		}

		if (sidebar != null)
		{
			applyDefaultOrder();
		}
	}

	@Override
	public void resetConfiguration()
	{
		configManager.unsetConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
		applyDefaultOrder();
	}

	private void saveCustomOrder(List<NavigationButton> entries)
	{
		if (entries == null || entries.isEmpty())
		{
			return;
		}

		List<String> tabList = entries.stream()
			.map(NavigationButton::getTooltip)
			.collect(Collectors.toList());

		configManager.setConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, gson.toJson(tabList));
	}

	private List<NavigationButton> loadCustomOrder()
	{
		String customTabOrderListJson = configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);

		if (customTabOrderListJson == null || customTabOrderListJson.isEmpty())
		{
			return new ArrayList<>();
		}

		List<String> customTabOrderList;
		try
		{
			// CHECKSTYLE:OFF
			customTabOrderList = gson.fromJson(customTabOrderListJson, new TypeToken<List<String>>(){}.getType());
			// CHECKSTYLE:ON
		}
		catch (Exception e)
		{
			log.warn("Corrupted custom order config, clearing: {}", e.getMessage());
			configManager.unsetConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
			return new ArrayList<>();
		}

		if (customTabOrderList == null || customTabOrderList.isEmpty())
		{
			return new ArrayList<>();
		}

		Collection<NavigationButton> currentSidebarTabs = clientUI.getSidebarEntries();

		// Reconstruct order: saved tabs first, then any new tabs appended
		List<NavigationButton> assembledTabList = customTabOrderList.stream()
			.map(tooltip -> currentSidebarTabs.stream()
				.filter(btn -> btn.getTooltip().equals(tooltip))
				.findFirst()
				.orElse(null))
			.filter(Objects::nonNull)
			.collect(Collectors.toList());

		// Append any tabs not in saved order
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
		List<NavigationButton> orderedButtons = loadCustomOrder();
		if (!orderedButtons.isEmpty())
		{
			clientUI.rebuildSidebar(orderedButtons);
		}
	}

	private void applyDefaultOrder()
	{
		clientUI.rebuildSidebar(clientUI.getSidebarEntries());
	}
}

