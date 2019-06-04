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

package net.runelite.client.plugins.hideprayers;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HashTable;
import net.runelite.api.WidgetNode;
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

@PluginDescriptor(
	name = "Show/Hide Prayers",
	description = "Hides specific Prayers.",
	type = PluginType.UTILITY,
	enabledByDefault = false
)

public class HidePrayersPlugin extends Plugin
{
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
			WidgetInfo.PRAYER_AUGURY //28
		);

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
		{
			return;
		}

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS)
		{
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
				.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size())
			{
				return;
			}

			for (Widget w : prayerWidgets)
			{
				w.setHidden(false);
			}
		}
	}

	private void reallyHidePrayers()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS)
		{
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
				.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size())
			{
				return;
			}

			for (Widget w : prayerWidgets)
			{
				w.setHidden(true);
			}
		}
	}

	private void hidePrayers()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		PrayerTabStates prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabStates.PRAYERS)
		{
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream().map(client::getWidget)
				.filter(Objects::nonNull).collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size())
			{
				return;
			}

			if ( !config.showindividualprayers()
				&& !config.getarmadylprayers()
				&& !config.getbarrowsprayers()
				&& !config.getbandosprayers()
				&& !config.getcerberusprayers()
				&& !config.getsaradominprayers()
				&& !config.getvorkathprayers()
				&& !config.getzamorakprayers()
				&& !config.getzulrahprayers()
				&& !config.getpvpprayers())
			{
				restorePrayers();
				return;
			}

			reallyHidePrayers();

			if (config.showindividualprayers())
			{
				prayerWidgets.get(0).setHidden(!config.HideTHICK_SKIN());	// Thick Skin
				prayerWidgets.get(1).setHidden(!config.HideBURST_OF_STRENGTH());	// Burst of Strength
				prayerWidgets.get(2).setHidden(!config.HideCLARITY_OF_THOUGHT());	// Clarity of Thought
				prayerWidgets.get(3).setHidden(!config.HideSHARP_EYE());	// Sharp Eye
				prayerWidgets.get(4).setHidden(!config.HideMYSTIC_WILL());	// Mystic Will
				prayerWidgets.get(5).setHidden(!config.HideROCK_SKIN());	// Rock Skin
				prayerWidgets.get(6).setHidden(!config.HideSUPERHUMAN_STRENGTH());	// Super Human Strength
				prayerWidgets.get(7).setHidden(!config.HideIMPROVED_REFLEXES());	// Improved_Reflexes
				prayerWidgets.get(8).setHidden(!config.HideRapidRestore());	// Rapid Restore
				prayerWidgets.get(9).setHidden(!config.HideRapidHeal());	// Rapid Heal
				prayerWidgets.get(10).setHidden(!config.HideProtectItem());	// Protect Item
				prayerWidgets.get(11).setHidden(!config.HideHAWK_EYE());	// Hawk Eye
				prayerWidgets.get(12).setHidden(!config.HideMYSTIC_LORE());	// Mystic Lore
				prayerWidgets.get(13).setHidden(!config.HideSteelSkin());	// Steel Skin
				prayerWidgets.get(14).setHidden(!config.HideUltimateStrength());	// Ultimate Strength
				prayerWidgets.get(15).setHidden(!config.HideIncredibleReflex());	// Incredible Reflexes
				prayerWidgets.get(16).setHidden(!config.HidePTFMagic());	// Protect from Magic
				prayerWidgets.get(17).setHidden(!config.HidePTFRange());	// Protect from Range
				prayerWidgets.get(18).setHidden(!config.HidePTFMelee());	// Protect from Melee
				prayerWidgets.get(19).setHidden(!config.HideEagle());	// eagle eye
				prayerWidgets.get(20).setHidden(!config.HideMystic());	// Mystic Might
				prayerWidgets.get(21).setHidden(!config.HideRETRIBUTION());	// Retribution
				prayerWidgets.get(22).setHidden(!config.HideRedemption());	// Redemption
				prayerWidgets.get(23).setHidden(!config.HideSmite());	// Smite
				prayerWidgets.get(24).setHidden(!config.HidePreserve());	// Preserve
				prayerWidgets.get(25).setHidden(!config.HideChivalry());	// Chivalry
				prayerWidgets.get(26).setHidden(!config.HidePiety());	// Piety
				prayerWidgets.get(27).setHidden(!config.HideRigour());	// Rigour
				prayerWidgets.get(28).setHidden(!config.HideAugury());	// Augury
			}

			else if (config.getarmadylprayers())
			{
				switch (config.armadyl())
				{
					case DISABLED:
						break;
					case ARMADYL_CHEAP:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(19).setHidden(false);    // eagle eye
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case ARMADYL_EXPENSIVE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(27).setHidden(false);    // Rigour
						break;
				}
			}

			else if (config.getbandosprayers())
			{
				switch (config.bandos())
				{
					case DISABLED:
						break;
					case BANDOS_CHEAP:
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflex
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case BANDOS_EXPENSIVE:
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(26).setHidden(false);    // Piety
						break;
				}
			}

			else if (config.getbarrowsprayers())
			{
				switch (config.barrows())
				{
					case DISABLED:
						break;
					case BARROWS_CHEAP:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // eagle eye
						prayerWidgets.get(20).setHidden(false);    // mystic might
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case BARROWS_EXPENSIVE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(27).setHidden(false);    // Rigour
						prayerWidgets.get(28).setHidden(false);    // Augury
						break;
				}
			}

			else if (config.getcerberusprayers())
			{
				switch (config.cerberus())
				{
					case DISABLED:
						break;
					case CERBERUS_CHEAP:
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflex
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case CERBERUS_EXPENSIVE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(26).setHidden(false);    // Piety
						break;
					case CERBERUS_CHEAP_RANGE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // eagle eye
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case CERBERUS_EXPENSIVE_RANGE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(27).setHidden(false);    // Rigour
						break;
				}
			}

			else if (config.getsaradominprayers())
			{
				switch (config.saradomin())
				{
					case DISABLED:
						break;
					case SARDOMIN_CHEAP:
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflex
						prayerWidgets.get(16).setHidden(false);    // Protect from magic
						prayerWidgets.get(19).setHidden(false);    // eagle eye
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case SARADOMIN_EXPENSIVE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(26).setHidden(false);    // Piety
						prayerWidgets.get(27).setHidden(false);    // Rigour
						break;
				}
			}
			else if (config.getvorkathprayers())
			{
				switch (config.vorkath())
				{
					case DISABLED:
						break;
					case VORKATH_CHEAP:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(19).setHidden(false);    // eagle eye
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case VORKATH_EXPENSIVE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(27).setHidden(false);    // Rigour
						break;
				}
			}
			
			else if (config.getzamorakprayers())
			{
				switch (config.zamorak())
				{
					case DISABLED:
						break;
					case ZAMORAK_CHEAP:
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflex
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case ZAMORAK_EXPENSIVE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(26).setHidden(false);    // Piety
						break;
				}
			}

			else if (config.getzulrahprayers())
			{
				switch (config.zulrah())
				{
					case DISABLED:
						break;
					case ZULRAH_CHEAP:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(19).setHidden(false);    // eagle eye
						prayerWidgets.get(20).setHidden(false);    // mystic might
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case ZULRAH_EXPENSIVE:
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(27).setHidden(false);    // Rigour
						prayerWidgets.get(28).setHidden(false);    // Augury
						break;
				}
			}

			else if (config.getpvpprayers())
			{
				if (config.HideRapidHealRestore())
				{
					prayerWidgets.get(8).setHidden(true);    // Rapid Restore
					prayerWidgets.get(9).setHidden(true);    // Rapid Heal
				}
				else
				{
					prayerWidgets.get(8).setHidden(false);    // Rapid Restore
					prayerWidgets.get(9).setHidden(false);    // Rapid Heal
				}

				switch (config.pvpprayers())
				{
					case DISABLED:
						break;
					case PRAY1:
						prayerWidgets.get(0).setHidden(false);    // Thick Skin
						break;
					case PRAY13:
						prayerWidgets.get(0).setHidden(false);    // Thick Skin
						prayerWidgets.get(3).setHidden(false);    // Sharp Eye
						prayerWidgets.get(4).setHidden(false);    // Mystic Will
						prayerWidgets.get(5).setHidden(false);    // Rock Skin
						prayerWidgets.get(6).setHidden(false);    // Super Human Strength
						break;
					case PRAY16:
						prayerWidgets.get(3).setHidden(false);    // Sharp Eye
						prayerWidgets.get(4).setHidden(false);    // Mystic Will
						prayerWidgets.get(5).setHidden(false);    // Rock Skin
						prayerWidgets.get(6).setHidden(false);    // Super Human Strength
						prayerWidgets.get(7).setHidden(false);    // Improved Reflexed
						break;
					case PRAY25:
						prayerWidgets.get(3).setHidden(false);    // Sharp Eye
						prayerWidgets.get(4).setHidden(false);    // Mystic Will
						prayerWidgets.get(5).setHidden(false);    // Rock Skin
						prayerWidgets.get(6).setHidden(false);    // Super Human Strength
						prayerWidgets.get(7).setHidden(false);    // Improved Reflexed
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						break;
					case PRAY31:
						prayerWidgets.get(7).setHidden(false);    // Improved Reflexed
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(11).setHidden(false);    // Hawk Eye
						prayerWidgets.get(12).setHidden(false);    // Mystic Lore
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						break;
					case PRAY43:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(11).setHidden(false);    // Hawk Eye
						prayerWidgets.get(12).setHidden(false);    // Mystic Lore
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflexes
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						break;
					case PRAY44:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(12).setHidden(false);    // Mystic Lore
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflexes
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // Eagle Eye
						break;
					case PRAY45:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflexes
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // Eagle Eye
						prayerWidgets.get(20).setHidden(false);    // Mystic Might
						break;
					case PRAY52:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflexes
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // Eagle Eye
						prayerWidgets.get(20).setHidden(false);    // Mystic Might
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(23).setHidden(false);    // Smite
						break;
					case PRAY55:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						prayerWidgets.get(15).setHidden(false);    // Incredible Reflexes
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // Eagle Eye
						prayerWidgets.get(20).setHidden(false);    // Mystic Might
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(23).setHidden(false);    // Smite
						prayerWidgets.get(24).setHidden(false);    // Preserve
						break;
					case PRAY60:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // Eagle Eye
						prayerWidgets.get(20).setHidden(false);    // Mystic Might
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(23).setHidden(false);    // Smite
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(25).setHidden(false);    // Chivalry
						break;
					case PRAY70:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(19).setHidden(false);    // Eagle Eye
						prayerWidgets.get(20).setHidden(false);    // Mystic Might
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(23).setHidden(false);    // Smite
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(26).setHidden(false);    // Piety
						break;
					case PRAY74:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(20).setHidden(false);    // Mystic Might
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(23).setHidden(false);    // Smite
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(26).setHidden(false);    // Piety
						prayerWidgets.get(27).setHidden(false);    // Rigour
						break;
					case PRAY77:
						prayerWidgets.get(10).setHidden(false);    // Protect Item
						prayerWidgets.get(16).setHidden(false);    // Protect from Magic
						prayerWidgets.get(17).setHidden(false);    // Protect from Range
						prayerWidgets.get(18).setHidden(false);    // Protect from Melee
						prayerWidgets.get(22).setHidden(false);    // Redemption
						prayerWidgets.get(23).setHidden(false);    // Smite
						prayerWidgets.get(24).setHidden(false);    // Preserve
						prayerWidgets.get(26).setHidden(false);    // Piety
						prayerWidgets.get(27).setHidden(false);    // Rigour
						prayerWidgets.get(28).setHidden(false);    // Augury
						break;
				}
			}
		}
	}
}
