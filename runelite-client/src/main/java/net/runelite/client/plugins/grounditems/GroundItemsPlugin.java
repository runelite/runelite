/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.grounditems;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Map;
import java.util.Optional;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemLayer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Ground Items"
)
public class GroundItemsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private GroundItemsOverlay overlay;

	@Inject
	private GroundItemsConfig config;

	@Inject
	private GroundItemsService groundItemsService;

	@Provides
	GroundItemsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundItemsConfig.class);
	}

	@Override
	protected void startUp()
	{
		groundItemsService.reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		groundItemsService.close();
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("grounditems"))
		{
			return;
		}

		groundItemsService.reset();
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if ((!config.highlightMenuOption() && !config.highlightMenuItemName()) || !event.getOption().equals("Take")
			|| event.getType() != MenuAction.GROUND_ITEM_THIRD_OPTION.getId())
		{
			return;
		}

		final int itemId = event.getIdentifier();
		final ItemComposition itemComposition = client.getItemDefinition(itemId);
		final Region region = client.getRegion();
		final Tile tile = region.getTiles()[client.getPlane()][event.getActionParam0()][event.getActionParam1()];
		final ItemLayer itemLayer = tile.getItemLayer();

		if (itemLayer == null)
		{
			return;
		}

		final Optional<Map.Entry<String, GroundItem>> groundItemEntry = groundItemsService
			.filterAndCollect(itemLayer.getBottom())
			.entrySet()
			.stream()
			.filter(entry -> entry.getKey().equals(Text.removeTags(event.getTarget())))
			.findAny();

		if (!groundItemEntry.isPresent())
		{
			return;
		}

		final Map.Entry<String, GroundItem> groundItem = groundItemEntry.get(); // Here we will have single item
		final String name = groundItem.getKey();
		final int cost = groundItem.getValue().getGePrice();
		final int quantity = groundItem.getValue().getQuantity();
		final Color color = groundItemsService.getCostColor(name, cost);
		final MenuEntry[] menuEntries = client.getMenuEntries();
		final MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

		if (!color.equals(config.defaultColor()))
		{
			final String hexColor = Integer.toHexString(color.getRGB() & 0xFFFFFF);
			final String colTag = "<col=" + hexColor + ">";

			if (config.highlightMenuOption())
			{
				lastEntry.setOption(colTag + "Take");
			}

			if (config.highlightMenuItemName())
			{
				String target = lastEntry.getTarget().substring(lastEntry.getTarget().indexOf(">") + 1);
				lastEntry.setTarget(colTag + target);
			}
		}

		if (config.showMenuItemQuantities() && itemComposition.isStackable() && quantity > 1)
		{
			lastEntry.setTarget(lastEntry.getTarget() + " (" + quantity + ")");
		}

		client.setMenuEntries(menuEntries);
	}
}
