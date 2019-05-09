/*
 * Copyright (c) 2018, https://runelitepl.us
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
 
package net.runelite.client.plugins.hideprayers;

import com.google.common.collect.ImmutableList;
import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@PluginDescriptor 
(
	name = "Hide Prayers",
	description = "Hides specific Prayers in the Prayer tab.",
	type = PluginType.UTILITY
)
public class HidePrayersPlugin extends Plugin 
{
	private static final int PRAYER_COUNT = Prayer.values().length;
	
	private static final List<WidgetInfo> PRAYER_WIDGET_INFO_LIST = ImmutableList.of(
	WidgetInfo.PRAYER_THICK_SKIN, //0
	WidgetInfo.PRAYER_BURST_OF_STRENGTH, //1
	WidgetInfo.PRAYER_CLARITY_OF_THOUGHT, //2
	WidgetInfo.PRAYER_SHARP_EYE, //3
	WidgetInfo.PRAYER_MYSTIC_WILL, //4
	WidgetInfo.PRAYER_ROCK_SKIN, //5
	WidgetInfo.PRAYER_SUPERHUMAN_STRENGTH, //6
	WidgetInfo.PRAYER_IMPROVED_REFLEXES, //7
	WidgetInfo.PRAYER_RAPID_RESTORE, //8
	WidgetInfo.PRAYER_RAPID_HEAL, //9
	WidgetInfo.PRAYER_PROTECT_ITEM, //10
	WidgetInfo.PRAYER_HAWK_EYE, //11
	WidgetInfo.PRAYER_MYSTIC_LORE, //12
	WidgetInfo.PRAYER_STEEL_SKIN, //13
	WidgetInfo.PRAYER_ULTIMATE_STRENGTH, //14
	WidgetInfo.PRAYER_INCREDIBLE_REFLEXES, //15
	WidgetInfo.PRAYER_PROTECT_FROM_MAGIC, //16
	WidgetInfo.PRAYER_PROTECT_FROM_MISSILES, //17
	WidgetInfo.PRAYER_PROTECT_FROM_MELEE, //18
	WidgetInfo.PRAYER_EAGLE_EYE, //19
	WidgetInfo.PRAYER_MYSTIC_MIGHT, //20
	WidgetInfo.PRAYER_RETRIBUTION, //21
	WidgetInfo.PRAYER_REDEMPTION, //22
	WidgetInfo.PRAYER_SMITE, //23
	WidgetInfo.PRAYER_PRESERVE, //24
	WidgetInfo.PRAYER_CHIVALRY, //25
	WidgetInfo.PRAYER_PIETY,  //26
	WidgetInfo.PRAYER_RIGOUR, //27
	WidgetInfo.PRAYER_AUGURY); //28

	@Inject
	private Client client;

	@Inject
	private HidePrayersConfig config;

	@Provides
	HidePrayersConfig provideConfig(ConfigManager configManager) 
	{
		return configManager.getConfig(HidePrayersConfig.class);
	}

	@Override
	protected void startUp() throws Exception 
	{
		hidePrayers();
	}

	@Override
	protected void shutDown() throws Exception 
	{
		restorePrayers();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event) 
	{
		if (event.getGameState() == GameState.LOGGED_IN) 
		{
			hidePrayers();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event) 
	{
		if (event.getGroup().equals("hideprayers")) 
		{
			hidePrayers();
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event) 
	{
		if (event.getGroupId() == WidgetID.PRAYER_GROUP_ID || event.getGroupId() == WidgetID.QUICK_PRAYERS_GROUP_ID) 
		{
			hidePrayers();
		}
	}

	private PrayerTabState getPrayerTabState() 
	{
		HashTable<WidgetNode> componentTable = client.getComponentTable();
		for (WidgetNode widgetNode : componentTable.getNodes()) 
		{
			if (widgetNode.getId() == WidgetID.PRAYER_GROUP_ID) 
			{
				return PrayerTabState.PRAYERS;
			} 
			else if (widgetNode.getId() == WidgetID.QUICK_PRAYERS_GROUP_ID) 
			{
				return PrayerTabState.QUICK_PRAYERS;
			}
		}
		return PrayerTabState.NONE;
	}

	private void restorePrayers() 
	{
		if (client.getGameState() != GameState.LOGGED_IN)
			return;

		PrayerTabState prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabState.PRAYERS) 
		{
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
					.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size())
				return;

			for (int index = 0; index < PRAYER_COUNT; index++)
				prayerWidgets.get(Prayer.values()[index].ordinal()).setHidden(false);
		}
	}

	private void hidePrayers() 
	{
		if (client.getGameState() != GameState.LOGGED_IN)
			return;

		PrayerTabState prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabState.PRAYERS) 
		{
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
					.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size())
				return;

			for (int index = 0; index < PRAYER_COUNT; index++) 
			{
				Prayer prayer = Prayer.values()[index];
				Widget prayerWidget = prayerWidgets.get(prayer.ordinal());
				
				if (!config.showPrayers() && !config.showEagle())
					prayerWidget.setHidden(false);
				if (!config.showPrayers() && !config.showMystic())
					prayerWidget.setHidden(false);
				if (!config.showPrayers() && !config.showUltStrength())
					prayerWidget.setHidden(false);
				if (!config.showPrayers() && !config.showPreserve())
					prayerWidget.setHidden(false);
				if (!config.showPrayers() && !config.showRapidHeal())
					prayerWidget.setHidden(false);
				if (!config.showPrayers() && !config.showRapidRestore())
					prayerWidget.setHidden(false);
				if (!config.showPrayers() && !config.showRedemption())
					prayerWidget.setHidden(false);
				
				if (config.showPrayers()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[10].ordinal()).setHidden(false);// protect item
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// mage
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// range
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// melee
					prayerWidgets.get(Prayer.values()[23].ordinal()).setHidden(false);// smite
					if (config.showEagle()) 
					{
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(true);// rigour
					} 
					else 
					{
						prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(false);// rigour
					}
					if (config.showMystic()) 
					{
					prayerWidgets.get(Prayer.values()[28].ordinal()).setHidden(true);// augury
					} 
					else 
					{
						prayerWidgets.get(Prayer.values()[28].ordinal()).setHidden(false);// augury
					}
					if (config.showUltStrength()) 
					{
					prayerWidgets.get(Prayer.values()[26].ordinal()).setHidden(true);// piety
					} 
					else 
					{
						prayerWidgets.get(Prayer.values()[26].ordinal()).setHidden(false);// piety
					}
					if (config.showPreserve()) 
					{
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(true);// Preserve
					} 
					else 
					{
						prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					}
					if (config.showRedemption()) 
					{
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(true);// Redemption
					} 
					else 
					{
						prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					}
					if (config.showRapidRestore()) 
					{
					prayerWidgets.get(Prayer.values()[8].ordinal()).setHidden(true);// Rapid Restore
					} 
					else 
					{
						prayerWidgets.get(Prayer.values()[8].ordinal()).setHidden(false);// Rapid Restore
					}
					if (config.showRapidHeal()) 
					{
					prayerWidgets.get(Prayer.values()[9].ordinal()).setHidden(true);// Rapid Heal
					} 
					else 
					{
						prayerWidgets.get(Prayer.values()[9].ordinal()).setHidden(false);// Rapid Heal
					}
				}
				if (config.showEagle()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[19].ordinal()).setHidden(false);// eagle
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(true);// rigour
				}
				if (config.showMystic()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[20].ordinal()).setHidden(false);// mystic
					prayerWidgets.get(Prayer.values()[28].ordinal()).setHidden(true);// augury
				}
				if (config.showUltStrength()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[13].ordinal()).setHidden(false);// Steel Skin
					prayerWidgets.get(Prayer.values()[14].ordinal()).setHidden(false);// Ult Strength
					prayerWidgets.get(Prayer.values()[15].ordinal()).setHidden(false);// Incredible Reflexes
					prayerWidgets.get(Prayer.values()[26].ordinal()).setHidden(true);// piety
				}
				if (config.showPreserve()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}
				if (config.showRedemption()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
				}
				if (config.showRapidRestore()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[8].ordinal()).setHidden(false);// Rapid Restore
				}
				if (config.showRapidHeal()) 
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[9].ordinal()).setHidden(false);// Rapid Heal
				}
			}
		}
	}
}
