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

	private double currentStrength;
	private double currentRanged;
	private double currentMagic;
	private double meleePrayerBonus;
	private double rangedPrayerBonus;
	private double dharokSetBoost;
	private double multiplier;
	private int set;

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
		Widget meleeStrength = client.getWidget(WidgetInfo.EQUIPMENT_MELEE_STRENGTH);
		Widget rangedStrength = client.getWidget(WidgetInfo.EQUIPMENT_RANGED_STRENGTH);
		Widget magicDamage = client.getWidget(WidgetInfo.EQUIPMENT_MAGIC_DAMAGE);
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);

		String maxHitText = "Equip Your Character...<br><br>Melee Max Hit: ";

		if (equipmentContainer != null && equipYourCharacter != null)
		{
			Item[] equip = equipmentContainer.getItems();

			updateBoost();
			updateSet(equip);

			if (contains(WEAPON_SLOT, "trident ", equip) || contains(WEAPON_SLOT, "uncharged trident", equip))
			{
				if (contains(WEAPON_SLOT, "swamp", equip) || contains(WEAPON_SLOT, "toxic", equip))
				{
					maxHitText = maxHitText.replace("Melee", "Trident") + maxHit.maxHit(magicDamage, currentMagic, 1, set, 1, 2);
				}

				else
				{
					maxHitText = maxHitText.replace("Melee", "Trident") + maxHit.maxHit(magicDamage, currentMagic, 1, set, 1, 5);
				}
			}
			else if (contains(WEAPON_SLOT, " dart", equip) || contains(WEAPON_SLOT, " knife", equip) || contains(WEAPON_SLOT, "throwing axe", equip) || contains(WEAPON_SLOT, "bow", equip) || contains(WEAPON_SLOT, "chinchompa", equip) || contains(WEAPON_SLOT, "blowpipe", equip))
			{
				maxHitText = maxHitText.replace("Melee", "Ranged") + maxHit.maxHit(rangedStrength, currentRanged, rangedPrayerBonus, set, 1);
			}
			else
			{
				maxHitText = maxHitText + maxHit.maxHit(meleeStrength, currentStrength, meleePrayerBonus, set, multiplier);
			}

			if (contains(HELM_SLOT, "dharok", equip) && contains(CHEST_SLOT, "dharok", equip) && contains(LEG_SLOT, "dharok", equip) && contains(WEAPON_SLOT, "dharok", equip))
			{
				maxHitText = maxHitText + " - " + maxHit.maxHit(meleeStrength, currentStrength, meleePrayerBonus, 1, dharokSetBoost);
			}

			equipYourCharacter.setText(maxHitText);
		}
	}

	private void updateSet(Item[] equip)
	{
		set = 1;
		multiplier = 1;
		if (contains(HELM_SLOT, "void", equip) && contains(CHEST_SLOT, "void", equip) && contains(LEG_SLOT, "void", equip) && contains(GLOVE_SLOT, "void", equip))
		{
			if (contains(HELM_SLOT, "melee", equip))
			{
				set = 2;
			}

			if (contains(HELM_SLOT, "ranger", equip))
			{
				set = 2;

				if (contains(CHEST_SLOT, "elite", equip) && contains(LEG_SLOT, "elite", equip))
				{
					set = 3;
				}
			}
		}

		if (contains(HELM_SLOT, "slayer", equip) || contains(HELM_SLOT, "black mask", equip))
		{
			set = 4;

			if (contains(HELM_SLOT, "(i)", equip))
			{
				set = 5;
			}
		}

		boolean obsidianWeapon = false;

		if (contains(WEAPON_SLOT, "tzhaar-ket", equip) || contains(WEAPON_SLOT, "toktz-xil", equip))
		{
			obsidianWeapon = true;
		}

		if (contains(HELM_SLOT, "obsidian", equip) && contains(CHEST_SLOT, "obsidian", equip) && contains(LEG_SLOT, "obsidian", equip) && obsidianWeapon)
		{
			multiplier = 1.1;
		}

		if (contains(NECK_SLOT, "berserker necklace", equip) && obsidianWeapon)
		{
			multiplier = multiplier + 0.2;
		}
	}


	private boolean contains(int slot, String string, Item[] equip)
	{
		return client.getItemDefinition(equip[slot].getId()).getName().toLowerCase().contains(string);
	}

	private void updateBoost()
	{
		double hitpointsLevel = client.getRealSkillLevel(Skill.HITPOINTS);
		double strenghtLevel = client.getRealSkillLevel(Skill.STRENGTH);
		double magicLevel = client.getRealSkillLevel(Skill.MAGIC);
		double rangedLevel = client.getRealSkillLevel(Skill.RANGED);

		currentStrength = strenghtLevel;
		currentMagic = magicLevel;
		currentRanged = rangedLevel;
		dharokSetBoost = 1 + (hitpointsLevel - 1) / 100 * hitpointsLevel / 100;

		if (config.potion())
		{
			currentStrength = strenghtLevel + 4 + strenghtLevel * 15 / 100;
			currentMagic = magicLevel + 1 + magicLevel / 10;
			currentRanged = rangedLevel + 4 + rangedLevel / 10;
		}

		switch (config.rangedprayer())
		{
			case DEFAULT:
				rangedPrayerBonus = 1;
				break;
			case SHARP_EYE:
				rangedPrayerBonus = 1.05;
				break;
			case HAWK_EYE:
				rangedPrayerBonus = 1.1;
				break;
			case EAGLE_EYE:
				rangedPrayerBonus = 1.15;
				break;
			case RIGOUR:
				rangedPrayerBonus = 1.23;
				break;
		}

		switch (config.meleeprayer())
		{
			case DEFAULT:
				meleePrayerBonus = 1;
				break;
			case BURST_OF_STRENGTH:
				meleePrayerBonus = 1.05;
				break;
			case SUPERHUMAN_STRENGTH:
				meleePrayerBonus = 1.1;
				break;
			case ULTIMATE_STRENGTH:
				meleePrayerBonus = 1.15;
				break;
			case CHIVALRY:
				meleePrayerBonus = 1.18;
				break;
			case PIETY:
				meleePrayerBonus = 1.23;
				break;
		}
	}
}