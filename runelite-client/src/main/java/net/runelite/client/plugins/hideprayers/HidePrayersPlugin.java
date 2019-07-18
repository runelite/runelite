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
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HashTable;
import net.runelite.api.Skill;
import net.runelite.api.WidgetNode;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.hideprayers.util.Armadyl;
import net.runelite.client.plugins.hideprayers.util.Bandos;
import net.runelite.client.plugins.hideprayers.util.Barrows;
import net.runelite.client.plugins.hideprayers.util.Cerberus;
import net.runelite.client.plugins.hideprayers.util.PVPPrayers;
import net.runelite.client.plugins.hideprayers.util.PrayerTabStates;
import net.runelite.client.plugins.hideprayers.util.Saradomin;
import net.runelite.client.plugins.hideprayers.util.Vorkath;
import net.runelite.client.plugins.hideprayers.util.Zamorak;
import net.runelite.client.plugins.hideprayers.util.Zulrah;

@PluginDescriptor(
	name = "Show/Hide Prayers",
	description = "Hides specific Prayers.",
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
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

	@Inject
	private EventBus eventBus;

	private boolean showindividualprayers;
	private boolean ShowTHICK_SKIN;
	private boolean ShowBURST_OF_STRENGTH;
	private boolean ShowCLARITY_OF_THOUGHT;
	private boolean ShowSHARP_EYE;
	private boolean ShowMYSTIC_WILL;
	private boolean ShowROCK_SKIN;
	private boolean ShowSUPERHUMAN_STRENGTH;
	private boolean ShowIMPROVED_REFLEXES;
	private boolean ShowRapidRestore;
	private boolean ShowRapidHeal;
	private boolean ShowProtectItem;
	private boolean ShowHAWK_EYE;
	private boolean ShowMYSTIC_LORE;
	private boolean ShowSteelSkin;
	private boolean ShowUltimateStrength;
	private boolean ShowIncredibleReflex;
	private boolean ShowPTFMagic;
	private boolean ShowPTFRange;
	private boolean ShowPTFMelee;
	private boolean ShowEagle;
	private boolean ShowMystic;
	private boolean ShowRETRIBUTION;
	private boolean ShowRedemption;
	private boolean ShowSmite;
	private boolean ShowPreserve;
	private boolean ShowChivalry;
	private boolean ShowPiety;
	private boolean ShowRigour;
	private boolean ShowAugury;
	private boolean getarmadylprayers;
	private Armadyl armadyl;
	private boolean getbarrowsprayers;
	private Barrows barrows;
	private boolean getbandosprayers;
	private Bandos bandos;
	private boolean getcerberusprayers;
	private Cerberus cerberus;
	private boolean getsaradominprayers;
	private Saradomin saradomin;
	private boolean getvorkathprayers;
	private Vorkath vorkath;
	private boolean getzamorakprayers;
	private Zamorak zamorak;
	private boolean getzulrahprayers;
	private Zulrah zulrah;
	private boolean getpvpprayers;
	private PVPPrayers pvpprayers;
	private boolean HideRapidHealRestore;

	@Provides
	HidePrayersConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HidePrayersConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		hidePrayers();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		restorePrayers();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			reallyHidePrayers();
			hidePrayers();
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("hideprayers"))
		{
			updateConfig();
			hidePrayers();
		}
	}

	private void onWidgetLoaded(WidgetLoaded event)
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

			if ( !this.showindividualprayers
				&& !this.getarmadylprayers
				&& !this.getbarrowsprayers
				&& !this.getbandosprayers
				&& !this.getcerberusprayers
				&& !this.getsaradominprayers
				&& !this.getvorkathprayers
				&& !this.getzamorakprayers
				&& !this.getzulrahprayers
				&& !this.getpvpprayers)
			{
				restorePrayers();
				return;
			}

			reallyHidePrayers();

			if (this.showindividualprayers)
			{
				prayerWidgets.get(0).setHidden(!this.ShowTHICK_SKIN);	// Thick Skin
				prayerWidgets.get(1).setHidden(!this.ShowBURST_OF_STRENGTH);	// Burst of Strength
				prayerWidgets.get(2).setHidden(!this.ShowCLARITY_OF_THOUGHT);	// Clarity of Thought
				prayerWidgets.get(3).setHidden(!this.ShowSHARP_EYE);	// Sharp Eye
				prayerWidgets.get(4).setHidden(!this.ShowMYSTIC_WILL);	// Mystic Will
				prayerWidgets.get(5).setHidden(!this.ShowROCK_SKIN);	// Rock Skin
				prayerWidgets.get(6).setHidden(!this.ShowSUPERHUMAN_STRENGTH);	// Super Human Strength
				prayerWidgets.get(7).setHidden(!this.ShowIMPROVED_REFLEXES);	// Improved_Reflexes
				prayerWidgets.get(8).setHidden(!this.ShowRapidRestore);	// Rapid Restore
				prayerWidgets.get(9).setHidden(!this.ShowRapidHeal);	// Rapid Heal
				prayerWidgets.get(10).setHidden(!this.ShowProtectItem);	// Protect Item
				prayerWidgets.get(11).setHidden(!this.ShowHAWK_EYE);	// Hawk Eye
				prayerWidgets.get(12).setHidden(!this.ShowMYSTIC_LORE);	// Mystic Lore
				prayerWidgets.get(13).setHidden(!this.ShowSteelSkin);	// Steel Skin
				prayerWidgets.get(14).setHidden(!this.ShowUltimateStrength);	// Ultimate Strength
				prayerWidgets.get(15).setHidden(!this.ShowIncredibleReflex);	// Incredible Reflexes
				prayerWidgets.get(16).setHidden(!this.ShowPTFMagic);	// Protect from Magic
				prayerWidgets.get(17).setHidden(!this.ShowPTFRange);	// Protect from Range
				prayerWidgets.get(18).setHidden(!this.ShowPTFMelee);	// Protect from Melee
				prayerWidgets.get(19).setHidden(!this.ShowEagle);	// eagle eye
				prayerWidgets.get(20).setHidden(!this.ShowMystic);	// Mystic Might
				prayerWidgets.get(21).setHidden(!this.ShowRETRIBUTION);	// Retribution
				prayerWidgets.get(22).setHidden(!this.ShowRedemption);	// Redemption
				prayerWidgets.get(23).setHidden(!this.ShowSmite);	// Smite
				prayerWidgets.get(24).setHidden(!this.ShowPreserve);	// Preserve
				prayerWidgets.get(25).setHidden(!this.ShowChivalry);	// Chivalry
				prayerWidgets.get(26).setHidden(!this.ShowPiety);	// Piety
				prayerWidgets.get(27).setHidden(!this.ShowRigour);	// Rigour
				prayerWidgets.get(28).setHidden(!this.ShowAugury);	// Augury
			}

			else if (this.getarmadylprayers)
			{
				switch (this.armadyl)
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

			else if (this.getbandosprayers)
			{
				switch (this.bandos)
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

			else if (this.getbarrowsprayers)
			{
				switch (this.barrows)
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

			else if (this.getcerberusprayers)
			{
				switch (this.cerberus)
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

			else if (this.getsaradominprayers)
			{
				switch (this.saradomin)
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
			else if (this.getvorkathprayers)
			{
				switch (this.vorkath)
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
			
			else if (this.getzamorakprayers)
			{
				switch (this.zamorak)
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

			else if (this.getzulrahprayers)
			{
				switch (this.zulrah)
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

			else if (this.getpvpprayers)
			{
				if (this.HideRapidHealRestore)
				{
					prayerWidgets.get(8).setHidden(true);    // Rapid Restore
					prayerWidgets.get(9).setHidden(true);    // Rapid Heal
				}
				else
				{
					prayerWidgets.get(8).setHidden(false);    // Rapid Restore
					prayerWidgets.get(9).setHidden(false);    // Rapid Heal
				}

				if (WorldType.isAllHighRiskWorld(client.getWorldType()) || client.getRealSkillLevel(Skill.PRAYER) <= 24)
				{
					prayerWidgets.get(10).setHidden(true);    // Protect Item
				}
				else
				{
					prayerWidgets.get(10).setHidden(false);    // Protect Item
				}

				switch (this.pvpprayers)
				{
					case DISABLED:
						reallyHidePrayers();
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
					case PRAY25:
						prayerWidgets.get(3).setHidden(false);    // Sharp Eye
						prayerWidgets.get(4).setHidden(false);    // Mystic Will
						prayerWidgets.get(5).setHidden(false);    // Rock Skin
						prayerWidgets.get(6).setHidden(false);    // Super Human Strength
						prayerWidgets.get(7).setHidden(false);    // Improved Reflexed
						break;
					case PRAY31:
						prayerWidgets.get(7).setHidden(false);    // Improved Reflexed
						prayerWidgets.get(11).setHidden(false);    // Hawk Eye
						prayerWidgets.get(12).setHidden(false);    // Mystic Lore
						prayerWidgets.get(13).setHidden(false);    // Steel Skin
						prayerWidgets.get(14).setHidden(false);    // Ultimate Strength
						break;
					case PRAY43:
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

	private void updateConfig()
	{
		this.showindividualprayers = config.showindividualprayers();
		this.ShowTHICK_SKIN = config.ShowTHICK_SKIN();
		this.ShowBURST_OF_STRENGTH = config.ShowBURST_OF_STRENGTH();
		this.ShowCLARITY_OF_THOUGHT = config.ShowCLARITY_OF_THOUGHT();
		this.ShowSHARP_EYE = config.ShowSHARP_EYE();
		this.ShowMYSTIC_WILL = config.ShowMYSTIC_WILL();
		this.ShowROCK_SKIN = config.ShowROCK_SKIN();
		this.ShowSUPERHUMAN_STRENGTH = config.ShowSUPERHUMAN_STRENGTH();
		this.ShowIMPROVED_REFLEXES = config.ShowIMPROVED_REFLEXES();
		this.ShowRapidRestore = config.ShowRapidRestore();
		this.ShowRapidHeal = config.ShowRapidHeal();
		this.ShowProtectItem = config.ShowProtectItem();
		this.ShowHAWK_EYE = config.ShowHAWK_EYE();
		this.ShowMYSTIC_LORE = config.ShowMYSTIC_LORE();
		this.ShowSteelSkin = config.ShowSteelSkin();
		this.ShowUltimateStrength = config.ShowUltimateStrength();
		this.ShowIncredibleReflex = config.ShowIncredibleReflex();
		this.ShowPTFMagic = config.ShowPTFMagic();
		this.ShowPTFRange = config.ShowPTFRange();
		this.ShowPTFMelee = config.ShowPTFMelee();
		this.ShowEagle = config.ShowEagle();
		this.ShowMystic = config.ShowMystic();
		this.ShowRETRIBUTION = config.ShowRETRIBUTION();
		this.ShowRedemption = config.ShowRedemption();
		this.ShowSmite = config.ShowSmite();
		this.ShowPreserve = config.ShowPreserve();
		this.ShowChivalry = config.ShowChivalry();
		this.ShowPiety = config.ShowPiety();
		this.ShowRigour = config.ShowRigour();
		this.ShowAugury = config.ShowAugury();
		this.getarmadylprayers = config.getarmadylprayers();
		this.armadyl = config.armadyl();
		this.getbarrowsprayers = config.getbarrowsprayers();
		this.barrows = config.barrows();
		this.getbandosprayers = config.getbandosprayers();
		this.bandos = config.bandos();
		this.getcerberusprayers = config.getcerberusprayers();
		this.cerberus = config.cerberus();
		this.getsaradominprayers = config.getsaradominprayers();
		this.saradomin = config.saradomin();
		this.getvorkathprayers = config.getvorkathprayers();
		this.vorkath = config.vorkath();
		this.getzamorakprayers = config.getzamorakprayers();
		this.zamorak = config.zamorak();
		this.getzulrahprayers = config.getzulrahprayers();
		this.zulrah = config.zulrah();
		this.getpvpprayers = config.getpvpprayers();
		this.pvpprayers = config.pvpprayers();
		this.HideRapidHealRestore = config.HideRapidHealRestore();
	}
}
