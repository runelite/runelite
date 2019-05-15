/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2018, Raiever <https://github.com/Raieverr>
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
 
package net.runelite.client.plugins.hideprayers.PVM;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.hideprayers.util.PrayerTabStates;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@PluginDescriptor 
	(
		name = "Show/Hide PVM Prayers",
		description = "Hides specific Prayers in the Prayer tab for PVM.",
		enabledByDefault = false,
		type = PluginType.PVM
	)

public class HidePrayersPVMPlugin extends Plugin
{
	private static final int PRAYER_COUNT = Prayer.values().length;

	private static final List<WidgetInfo> PRAYER_WIDGET_INFO_LIST = ImmutableList.of
	(
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
		WidgetInfo.PRAYER_AUGURY //28
	);

	@Inject
	private Client client;

	@Inject
	private HidePrayersPVMConfig config;

	@Inject
	private ConfigManager configManager;

	@Provides
	HidePrayersPVMConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HidePrayersPVMConfig.class);
	}

	@Override
	protected void startUp() throws Exception 
	{
		hidePrayers();
		configManager.setConfiguration("runelite", "hideprayerspvmplugin", false);
		configManager.setConfiguration("runelite", "hideprayerspvpplugin", false);
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
		if (event.getGroup().equals("hideprayersPVM"))
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

	private PrayerTabStates getPrayerTabState()
	{
		HashTable<WidgetNode> componentTable = client.getComponentTable();
		for (WidgetNode widgetNode : componentTable.getNodes())
		{
			if (widgetNode.getId() == WidgetID.PRAYER_GROUP_ID)
			{
				return PrayerTabStates.PRAYERS;
			}
			else if (widgetNode.getId() == WidgetID.QUICK_PRAYERS_GROUP_ID)
			{
				return PrayerTabStates.QUICK_PRAYERS;
			}
		}
		return PrayerTabStates.NONE;
	}

	private void restorePrayers()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
			return;

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS)
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

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS)
		{
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
					.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size())
				return;

			for (int index = 0; index < PRAYER_COUNT; index++) 
			{
				Prayer prayer = Prayer.values()[index];
				Widget prayerWidget = prayerWidgets.get(prayer.ordinal());

				if (config.Armadyl() == Armadyl.DISABLED
					&& config.Bandos() == Bandos.DISABLED
					&& config.Barrows() == Barrows.DISABLED
					&& config.Cerberus() == Cerberus.DISABLED
					&& config.Saradomin() == Saradomin.DISABLED
					&& config.Vorkath() == Vorkath.DISABLED
					&& config.Zamorak() == Zamorak.DISABLED
					&& config.Zulrah() == Zulrah.DISABLED
				)
				prayerWidget.setHidden(false);

				if (config.Zulrah() == Zulrah.ZULRAH_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[19].ordinal()).setHidden(false);// eagle eye
					prayerWidgets.get(Prayer.values()[20].ordinal()).setHidden(false);// mystic might
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Zulrah() == Zulrah.ZULRAH_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(false);// Rigour
					prayerWidgets.get(Prayer.values()[28].ordinal()).setHidden(false);// Augury
				}

				if (config.Barrows() == Barrows.BARROWS_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[19].ordinal()).setHidden(false);// eagle eye
					prayerWidgets.get(Prayer.values()[20].ordinal()).setHidden(false);// mystic might
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Barrows() == Barrows.BARROWS_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(false);// Rigour
					prayerWidgets.get(Prayer.values()[28].ordinal()).setHidden(false);// Augury
				}

				if (config.Vorkath() == Vorkath.VORKATH_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[19].ordinal()).setHidden(false);// eagle eye
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Vorkath() == Vorkath.VORKATH_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(false);// Rigour
				}

				if (config.Cerberus() == Cerberus.CERBERUS_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[13].ordinal()).setHidden(false);// Steel PVM
					prayerWidgets.get(Prayer.values()[14].ordinal()).setHidden(false);// Ultimate Strength
					prayerWidgets.get(Prayer.values()[15].ordinal()).setHidden(false);// Incredible Reflex
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Cerberus() == Cerberus.CERBERUS_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[26].ordinal()).setHidden(false);// Piety
				}

				if (config.Cerberus() == Cerberus.CERBERUS_CHEAP_RANGE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[19].ordinal()).setHidden(false);// eagle eye
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Cerberus() == Cerberus.CERBERUS_EXPENSIVE_RANGE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(false);// Rigour
				}

				if (config.Armadyl() == Armadyl.ARMADYL_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[19].ordinal()).setHidden(false);// eagle eye
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Armadyl() == Armadyl.ARMADYL_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[17].ordinal()).setHidden(false);// Protect from Range
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(false);// Rigour
				}

				if (config.Bandos() == Bandos.BANDOS_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[13].ordinal()).setHidden(false);// Steel PVM
					prayerWidgets.get(Prayer.values()[14].ordinal()).setHidden(false);// Ultimate Strength
					prayerWidgets.get(Prayer.values()[15].ordinal()).setHidden(false);// Incredible Reflex
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Bandos() == Bandos.BANDOS_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[26].ordinal()).setHidden(false);// Piety
				}

				if (config.Saradomin() == Saradomin.SARDOMIN_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[13].ordinal()).setHidden(false);// Steel PVM
					prayerWidgets.get(Prayer.values()[14].ordinal()).setHidden(false);// Ultimate Strength
					prayerWidgets.get(Prayer.values()[15].ordinal()).setHidden(false);// Incredible Reflex
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from magic
					prayerWidgets.get(Prayer.values()[19].ordinal()).setHidden(false);// eagle eye
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Saradomin() == Saradomin.SARADOMIN_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[26].ordinal()).setHidden(false);// Piety
					prayerWidgets.get(Prayer.values()[27].ordinal()).setHidden(false);// Rigour
				}

				if (config.Zamorak() == Zamorak.ZAMORAK_CHEAP)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[13].ordinal()).setHidden(false);// Steel Skin
					prayerWidgets.get(Prayer.values()[14].ordinal()).setHidden(false);// Ultimate Strength
					prayerWidgets.get(Prayer.values()[15].ordinal()).setHidden(false);// Incredible Reflex
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
				}

				if (config.Zamorak() == Zamorak.ZAMORAK_EXPENSIVE)
				{
					prayerWidget.setHidden(true);
					prayerWidgets.get(Prayer.values()[16].ordinal()).setHidden(false);// Protect from Magic
					prayerWidgets.get(Prayer.values()[18].ordinal()).setHidden(false);// Protect from Melee
					prayerWidgets.get(Prayer.values()[22].ordinal()).setHidden(false);// Redemption
					prayerWidgets.get(Prayer.values()[24].ordinal()).setHidden(false);// Preserve
					prayerWidgets.get(Prayer.values()[26].ordinal()).setHidden(false);// Piety
				}
			}
		}
	}
}