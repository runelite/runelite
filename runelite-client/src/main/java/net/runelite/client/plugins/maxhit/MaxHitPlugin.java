/*
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.maxhit;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Skill;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.config.ConfigManager;

@PluginDescriptor(
	name = "Max Hit"
)

public class MaxHitPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private MaxHitCalc maxHit;

	@Inject
	private MaxHitConfig config;

	@Provides
	MaxHitConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MaxHitConfig.class);
	}

	private static final int HELM_SLOT = 0;
	private static final int CAPE_SLOT = 1;
	private static final int NECK_SLOT = 2;
	private static final int WEAPON_SLOT = 3;
	private static final int CHEST_SLOT = 4;
	private static final int SHIELD_SLOT = 5;
	private static final int LEG_SLOT = 7;
	private static final int GLOVE_SLOT = 9;
	private static final int BOOT_SLOT = 10;
	private static final int RING_SLOT = 12;

	public static double void_melee_bonus;
	public static double void_ranged_bonus;
	public static double melee_prayer;
	public static double ranged_prayer;
	public static double magic_boost;
	public static double ranged_boost;
	public static double melee_boost;
	public static double dh_boost;

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		updateWidget();
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged event)
	{
		updateWidget();
	}

	private void updateWidget()
	{
		Widget equipYourCharacter = client.getWidget(WidgetInfo.EQUIP_YOUR_CHARACTER);
		Widget meleeStr = client.getWidget(WidgetInfo.EQUIPMENT_MELEE_STRENGTH);
		Widget rangedStr = client.getWidget(WidgetInfo.EQUIPMENT_RANGED_STRENGTH);
		Widget magicDmg = client.getWidget(WidgetInfo.EQUIPMENT_MAGIC_DAMAGE);
		ItemContainer equipContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		void_melee_bonus = 1;
		void_ranged_bonus = 1;

		updateBoost();

		if (equipContainer != null && equipYourCharacter != null)
		{
			Item[] equip = equipContainer.getItems();

			if (contains(HELM_SLOT, "void", equip) && contains(CHEST_SLOT, "void", equip) && contains(LEG_SLOT, "void", equip) && contains(GLOVE_SLOT, "void", equip))
			{
				void_melee_bonus = 1.1;
				void_ranged_bonus = 1.1;

				if (contains(CHEST_SLOT, "elite", equip) && contains(LEG_SLOT, "elite", equip))
				{
					void_ranged_bonus = 1.125;
				}
			}

			if (contains(WEAPON_SLOT, "trident ", equip) || contains(WEAPON_SLOT, "uncharged trident", equip))
			{
				if (contains(WEAPON_SLOT, "swamp", equip) || contains(WEAPON_SLOT, "toxic", equip))
				{
					equipYourCharacter.setText("Equip Your Character...<br><br>Trident Max Hit: " + maxHit.trident(client, magicDmg, 2));
					return;
				}
				equipYourCharacter.setText("Equip Your Character...<br><br>Trident Max Hit: " + maxHit.trident(client, magicDmg, 5));
				return;
			}
			if (contains(WEAPON_SLOT, " dart", equip) || contains(WEAPON_SLOT, " knife", equip) || contains(WEAPON_SLOT, "throwing axe", equip) || contains(WEAPON_SLOT, "bow", equip) || contains(WEAPON_SLOT, "chinchompa", equip) || contains(WEAPON_SLOT, "blowpipe", equip))
			{
				equipYourCharacter.setText("Equip Your Character...<br><br>Ranged Max Hit: " + maxHit.ranged(client, rangedStr));
				return;
			}

			if (contains(HELM_SLOT, "dharok", equip) && contains(CHEST_SLOT, "dharok", equip) && contains(LEG_SLOT, "dharok", equip) && contains(WEAPON_SLOT, "dharok", equip))
			{
				equipYourCharacter.setText("Equip Your Character...<br><br>Melee Max Hit: " + maxHit.melee(client, meleeStr) + " - " + maxHit.dharok(client, meleeStr));
				return;
			}
			equipYourCharacter.setText("Equip Your Character...<br><br>Melee Max Hit: " + maxHit.melee(client, meleeStr));
		}
	}

	private boolean contains(int slot, String string, Item[] equip)
	{
		return client.getItemDefinition(equip[slot].getId()).getName().toLowerCase().contains(string);
	}


	private void updateBoost()
	{
		double hp_lvl = client.getRealSkillLevel(Skill.HITPOINTS);

		magic_boost = 0;
		ranged_boost = 0;
		melee_boost = 0;
		dh_boost = (99 + hp_lvl) / 100;

		if (config.potion())
		{
			magic_boost = 1 + client.getRealSkillLevel(Skill.MAGIC) / 10;
			ranged_boost = 4 + client.getRealSkillLevel(Skill.RANGED) / 10;
			melee_boost = 4 + client.getRealSkillLevel(Skill.RANGED) * 15 / 100;
		}

		switch (config.rangedprayer())
		{
			case DEFAULT:
				ranged_prayer = 1;
				break;
			case SE:
				ranged_prayer = 1.05;
				break;
			case HE:
				ranged_prayer = 1.1;
				break;
			case EE:
				ranged_prayer = 1.15;
				break;
			case RIGOUR:
				ranged_prayer = 1.23;
				break;
		}

		switch (config.meleeprayer())
		{
			case DEFAULT:
				melee_prayer = 1;
				break;
			case BOS:
				melee_prayer = 1.05;
				break;
			case SS:
				melee_prayer = 1.1;
				break;
			case US:
				melee_prayer = 1.15;
				break;
			case CHIVALRY:
				melee_prayer = 1.18;
				break;
			case PIETY:
				melee_prayer = 1.23;
				break;
		}
	}
}