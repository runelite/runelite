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
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
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
@Singleton
public class LearnToClickPlugin extends Plugin
{
	private static final ImmutableList<WidgetInfo> ORB_WIDGETS = ImmutableList.of(WidgetInfo.MINIMAP_WORLDMAP_ORB,
		WidgetInfo.MINIMAP_SPEC_ORB);

	@Inject
	private LearnToClickConfig config;

	@Inject
	private Client client;

	private boolean forceRightClickFlag;

	private boolean shouldBlockCompass;
	private boolean shouldRightClickMap;
	private boolean shouldRightClickXp;
	private boolean shouldRightClickRetaliate;
	private boolean hideOrbs;

	@Provides
	LearnToClickConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LearnToClickConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
	}

	@Override
	protected void shutDown()
	{
		forceRightClickFlag = false;
		hideOrbWidgets(false);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("learntoclick"))
		{
			return;
		}

		updateConfig();

		if (this.hideOrbs)
		{
			hideOrbWidgets(true);
		}
		else
		{
			hideOrbWidgets(false);
		}

	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (!this.hideOrbs)
		{
			return;
		}
		if (event.getGroupId() == WidgetID.MINIMAP_GROUP_ID)
		{
			hideOrbWidgets(true);
		}
	}

	@Subscribe
	private void onMenuShouldLeftClick(MenuShouldLeftClick event)
	{
		if (!forceRightClickFlag)
		{
			return;
		}
		forceRightClickFlag = false;
		MenuEntry[] menuEntries = client.getMenuEntries();
		for (MenuEntry entry : menuEntries)
		{
			if ((entry.getOption().equals("Floating <col=ff9040>World Map</col>") && this.shouldRightClickMap) ||
				(entry.getTarget().equals("<col=ff9040>XP drops</col>") && this.shouldRightClickXp) ||
				(entry.getOption().equals("Auto retaliate") && this.shouldRightClickRetaliate))
			{
				event.setForceRightClick(true);
				return;
			}
		}
	}

	@Subscribe
	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if ((event.getOption().equals("Floating <col=ff9040>World Map</col>") && this.shouldRightClickMap) ||
			(event.getTarget().equals("<col=ff9040>XP drops</col>") && this.shouldRightClickXp) ||
			(event.getOption().equals("Auto retaliate") && this.shouldRightClickRetaliate))
		{
			forceRightClickFlag = true;
		}
		MenuEntry[] entries = client.getMenuEntries();
		if (this.shouldBlockCompass)
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
	 *
	 * @param hidden - hides the Widgets if true, un-hides them if false
	 */
	private void hideOrbWidgets(boolean hidden)
	{
		ORB_WIDGETS.forEach(widgetInfo -> client.getWidget(widgetInfo).setHidden(hidden));
	}

	private void updateConfig()
	{
		this.shouldBlockCompass = config.shouldBlockCompass();
		this.shouldRightClickMap = config.shouldRightClickMap();
		this.shouldRightClickXp = config.shouldRightClickXp();
		this.shouldRightClickRetaliate = config.shouldRightClickRetaliate();
		this.hideOrbs = config.hideOrbs();
	}
}
