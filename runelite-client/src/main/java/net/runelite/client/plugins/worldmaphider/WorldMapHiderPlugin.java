/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.worldmaphider;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

@PluginDescriptor(
	name = "Hide Worldmap Button",
	description = "Hides the world map button",
	type = PluginType.PVM,
	tags = {"world", "world map", "hide", "button", "map", "hide world map", "pklite"}
)
public class WorldMapHiderPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private MenuManager menuManager;

	@Inject
	private WorldMapHiderConfig config;

	@Inject
	private ConfigManager configManager;

	private WidgetMenuOption hideWidgetMenuOption = new WidgetMenuOption("Hide Map Button",
		"Hide Map Button", WidgetInfo.WORLD_MAP_OPTION);

	private ImmutableList<WidgetInfo> widgetList =
		ImmutableList.of(WidgetInfo.WORLD_MAP_OPTION, WidgetInfo.WORLD_MAP_BUTTON_BORDER,
			WidgetInfo.MINIMAP_WORLD_ORB);

	@Provides
	WorldMapHiderConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldMapHiderConfig.class);
	}

	@Override
	protected void startUp()
	{
		menuManager.addManagedCustomMenu(hideWidgetMenuOption);
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (config.hideWorldMapButton())
		{
			setMapHidden(false);
		}
		menuManager.removeManagedCustomMenu(hideWidgetMenuOption);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (config.hideWorldMapButton())
		{
			setMapHidden(true);
		}
		if (!config.hideWorldMapButton())
		{
			setMapHidden(false);
		}
	}

	@Subscribe
	public void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getMenuOption().equals("Hide Map Button"))
		{
			configManager.setConfiguration("worldMapHider", "hideWorldMapButton", true);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (config.hideWorldMapButton() && event.getGroupId() == WidgetID.MINIMAP_GROUP_ID)
		{
			setMapHidden(true);
		}
	}

	private void setMapHidden(Boolean hidden)
	{
		if (widgetList.size() > 0)
		widgetList.forEach(widgetInfo ->
		{
			if (widgetInfo != null && client.getWidget(widgetInfo) != null)
			{
				client.getWidget(widgetInfo).setHidden(hidden);
			}
		});
	}

}
