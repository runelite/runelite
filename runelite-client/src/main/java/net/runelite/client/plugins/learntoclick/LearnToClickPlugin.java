/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 * Plugin by Tom C (@tomcylke on GitHub)
 */

package net.runelite.client.plugins.learntoclick;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import org.apache.commons.lang3.ArrayUtils;


@PluginDescriptor(
	name = "Learn to Click",
	description = "A few modifications to prevent misclicks",
	tags = {"pk", "misclick", "compass", "map", "auto retaliate"},
	type = PluginType.PVP,
	enabledByDefault = false
)

@Slf4j
public class LearnToClickPlugin extends Plugin
{
	private static final ImmutableList<WidgetInfo> ORB_WIDGETS = ImmutableList.of(WidgetInfo.MINIMAP_WORLDMAP_ORB,
		WidgetInfo.MINIMAP_SPEC_ORB);

	@Inject
	private LearnToClickConfig config;
	private boolean forceRightClickFlag;
	@Inject
	private Client client;

	@Provides
	LearnToClickConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LearnToClickConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{
		forceRightClickFlag = false;
		hideOrbWidgets(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("learntoclick") && !event.getKey().equals("hideOrbs"))
		{
			return;
		}
		if (config.hideOrbs())
		{
			hideOrbWidgets(true);
		}
		else
		{
			hideOrbWidgets(false);
		}

	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (!config.hideOrbs())
		{
			return;
		}
		if (event.getGroupId() == WidgetID.MINIMAP_GROUP_ID)
		{
			hideOrbWidgets(true);
		}
	}

	@Subscribe
	public void onMenuShouldLeftClick(MenuShouldLeftClick event)
	{
		if (!forceRightClickFlag)
		{
			return;
		}
		forceRightClickFlag = false;
		MenuEntry[] menuEntries = client.getMenuEntries();
		for (MenuEntry entry : menuEntries)
		{
			if ((entry.getOption().equals("Floating") && config.shouldRightClickMap()) ||
				(entry.getOption().equals("Hide") && config.shouldRightClickXp()) || (entry.getOption().equals("Show")
				&& config.shouldRightClickXp()) || (entry.getOption().equals("Auto retaliate")
				&& config.shouldRightClickRetaliate()))
			{
				event.setForceRightClick(true);
				return;
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if ((event.getOption().equals("Floating") && config.shouldRightClickMap()) || (event.getOption().equals("Hide")
			&& config.shouldRightClickXp()) || (event.getOption().equals("Show") && config.shouldRightClickXp()) ||
			(event.getOption().equals("Auto retaliate") && config.shouldRightClickRetaliate()))
		{
			forceRightClickFlag = true;
		}
		MenuEntry[] entries = client.getMenuEntries();
		if (config.shouldBlockCompass())
		{
			for (int i = entries.length - 1; i >= 0; i--)
			{
				if (entries[i].getOption().equals("Look North"))
				{
					entries = ArrayUtils.remove(entries, i);
					i--;
				}
			}
			client.setMenuEntries(entries);
		}
	}

	/**
	 * Toggles hiding the World map and special attack orb widgets
	 * @param hidden - hides the Widgets if true, un-hides them if false
	 */
	private void hideOrbWidgets(boolean hidden)
	{
		ORB_WIDGETS.forEach(widgetInfo -> client.getWidget(widgetInfo).setHidden(hidden));
	}
}
