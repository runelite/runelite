/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum ThievingAction implements NamedSkillAction
{
	MAN_OR_WOMAN("Man / Woman", 1, 8, ItemID.MAN),
	WINTER_SQIRKJUICE("Winter Sq'irkjuice", 1, 350, ItemID.WINTER_SQIRKJUICE),
	VEGETABLE_STALL("Vegetable Stall", 2, 10, ItemID.CABBAGE),
	CAKE_STALL("Cake Stall", 5, 16, ItemID.CAKE),
	MONKEY_FOOD_STALL("Monkey Food Stall", 5, 16, ItemID.BANANA),
	TEA_STALL("Tea Stall", 5, 16, ItemID.CUP_OF_TEA_4242),
	CRAFTING_STALL("Crafting Stall", 5, 20, ItemID.CHISEL_5601),
	MONKEY_GENERAL_STALL("Monkey General Stall", 5, 25, ItemID.POT),
	FARMER("Farmer", 10, 14.5f, ItemID.FARMER),
	CHEST_10_COINS("Chest (10 Coins)", 13, 7.8f, ItemID.COINS),
	HAM_MEMBER("H.A.M. Member", 15, 22.2f, ItemID.MALE_HAM),
	SILK_STALL("Silk Stall", 20, 24, ItemID.SILK),
	WINE_STALL("Wine Stall", 22, 27, ItemID.BOTTLE_OF_WINE),
	WARRIOR_WOMEN_OR_AL_KHARID_WARRIOR("Warrior Women / Al-Kharid Warrior", 25, 26, ItemID.WARRIOR_WOMAN),
	FRUIT_STALL("Fruit Stall", 25, 28.5f, ItemID.STRANGE_FRUIT),
	SPRING_SQIRKJUICE("Spring Sq'irkjuice", 25, 1350, ItemID.SPRING_SQIRKJUICE),
	SEED_STALL("Seed Stall", 27, 10, ItemID.POTATO_SEED),
	NATURE_RUNE_CHEST("Nature Rune Chest", 28, 25, ItemID.NATURE_RUNE),
	ISLE_OF_SOULS_CHEST("Isle of Souls Dungeon Chest", 28, 150, ItemID.DARK_KEY),
	ROGUE("Rogue", 32, 36.5f, ItemID.ROGUE),
	FUR_STALL("Fur Stall", 35, 45, ItemID.GREY_WOLF_FUR),
	CAVE_GOBLIN("Cave Goblin", 36, 40, ItemID.CAVE_GOBLIN),
	MASTER_FARMER("Master Farmer", 38, 43, ItemID.MASTER_FARMER),
	GUARD("Guard", 40, 46.8f, ItemID.GUARD),
	FISH_STALL("Fish Stall", 42, 42, ItemID.RAW_SALMON),
	CHEST_50_COINS("Chest (50 Coins)", 43, 125, ItemID.COINS),
	BEARDED_POLLNIVNIAN_BANDIT("Bearded Pollnivnian Bandit", 45, 65, ItemID.BANDIT_6782),
	FREMENNIK_CITIZEN("Fremennik Citizen", 45, 65, ItemID.FREMENNIK),
	AUTUMN_SQIRKJUICE("Autumn Sq'irkjuice", 45, 2350, ItemID.AUTUMN_SQIRKJUICE),
	CHEST_STEEL_ARROWTIPS("Chest (Steel Arrowtips)", 47, 150, ItemID.STEEL_ARROWTIPS),
	CROSSBOW_STALL("Crossbow Stall", 49, 52, ItemID.CROSSBOW),
	WALL_SAFE("Wall Safe", 50, 70, ItemID.STETHOSCOPE),
	WEALTHY_CITIZEN("Wealthy Citizen", 50, 96, ItemID.WEALTHY_CITIZEN),
	SILVER_STALL("Silver Stall", 50, 205, ItemID.SILVER_BAR),
	DORGESH_KAAN_AVERAGE_CHEST("Dorgesh-Kaan Average Chest", 52, 200, ItemID.OIL_LANTERN),
	DESERT_BANDIT("Desert Bandit", 53, 79.4f, ItemID.BANDIT),
	KNIGHT("Knight", 55, 84.3f, ItemID.KNIGHT),
	POLLNIVNIAN_BANDIT("Pollnivnian Bandit", 55, 84.3f, ItemID.BANDIT_6781),
	STONE_CHEST("Stone Chest", 64, 280, ItemID.XERICIAN_FABRIC),
	MAGIC_STALL("Magic Stall", 65, 90, ItemID.AIR_RUNE_6422),
	SPICE_STALL("Spice Stall", 65, 92, ItemID.SPICE),
	MENAPHITE_THUG("Menaphite Thug", 65, 137.5f, ItemID.MENAPHITE_THUG),
	YANILLE_WATCHMAN("Yanille Watchman", 65, 137.5f, ItemID.WATCHMAN),
	SCIMITAR_STALL("Scimitar Stall", 65, 210, ItemID.STEEL_SCIMITAR),
	SUMMER_SQIRKJUICE("Summer Sq'irkjuice", 65, 3000, ItemID.SUMMER_SQIRKJUICE),
	PALADIN("Paladin", 70, 131.8f, ItemID.PALADIN),
	GNOME("Gnome", 75, 133.5f, ItemID.GNOME),
	GEM_STALL("Gem Stall", 75, 408, ItemID.SAPPHIRE),
	DORGESH_KAAN_RICH_CHEST("Dorgesh-Kaan Rich Chest", 78, 650, ItemID.MINING_HELMET),
	HERO("Hero", 80, 163.3f, ItemID.HERO),
	VYRE("Vyre", 82, 306.9f, ItemID.VYRE),
	ORE_STALL("Ore Stall", 82, 350, ItemID.RUNITE_ORE),
	ROGUES_CASTLE_CHEST("Wilderness Rogues' Chest", 84, 701.7f, ItemID.DRAGONSTONE),
	ELF("Elf", 85, 353.3f, ItemID.ELF),
	TZHAAR_HUR("TzHaar-Hur", 90, 103.4f, ItemID.TZHAARHUR),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;

	@Override
	public boolean isMembers(final ItemManager itemManager)
	{
		return true;
	}
}
