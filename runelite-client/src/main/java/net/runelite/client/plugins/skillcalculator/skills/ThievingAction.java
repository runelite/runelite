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
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum ThievingAction implements NamedSkillAction
{
	MAN_OR_WOMAN("Man / Woman", 1, 8, ItemID.PICKPOCKET_GUIDE_MAN),
	WINTER_SQIRKJUICE("Winter Sq'irkjuice", 1, 350, ItemID.OSMAN_SQUIRK_J_WINTER),
	VEGETABLE_STALL("Vegetable Stall", 2, 10, ItemID.CABBAGE),
	CAKE_STALL("Cake Stall", 5, 16, ItemID.CAKE),
	MONKEY_FOOD_STALL("Monkey Food Stall", 5, 16, ItemID.BANANA),
	TEA_STALL("Tea Stall", 5, 16, ItemID.CUP_OF_NETTLETEA),
	CRAFTING_STALL("Crafting Stall", 5, 20, ItemID.RD_CHISEL),
	MONKEY_GENERAL_STALL("Monkey General Stall", 5, 25, ItemID.POT_EMPTY),
	FARMER("Farmer", 10, 14.5f, ItemID.PICKPOCKET_GUIDE_FARMER),
	CHEST_10_COINS("Chest (10 Coins)", 13, 7.8f, ItemID.FAKE_COINS),
	HAM_MEMBER("H.A.M. Member", 15, 22.2f, ItemID.PICKPOCKET_GUIDE_MHAM),
	SILK_STALL("Silk Stall", 20, 24, ItemID.SILK),
	WINE_STALL("Wine Stall", 22, 27, ItemID.RAG_BOTTLE_WINE),
	WARRIOR_WOMEN_OR_AL_KHARID_WARRIOR("Warrior Women / Al-Kharid Warrior", 25, 26, ItemID.PICKPOCKET_GUIDE_WARRIOR),
	FRUIT_STALL("Fruit Stall", 25, 28.5f, ItemID.MACRO_TRIFFIDFRUIT),
	SPRING_SQIRKJUICE("Spring Sq'irkjuice", 25, 1350, ItemID.OSMAN_SQUIRK_J_SPRING),
	SEED_STALL("Seed Stall", 27, 10, ItemID.POTATO_SEED),
	NATURE_RUNE_CHEST("Nature Rune Chest", 28, 25, ItemID.NATURERUNE),
	ISLE_OF_SOULS_CHEST("Isle of Souls Dungeon Chest", 28, 150, ItemID.SW_DUNGEON_CHEST_KEY),
	ROGUE("Rogue", 32, 36.5f, ItemID.PICKPOCKET_GUIDE_ROGUE),
	FUR_STALL("Fur Stall", 35, 45, ItemID.GREY_WOLF_FUR),
	CAVE_GOBLIN("Cave Goblin", 36, 40, ItemID.PICKPOCKET_GUIDE_DORGESH),
	MASTER_FARMER("Master Farmer", 38, 43, ItemID.PICKPOCKET_GUIDE_MASTER_FARMER),
	GUARD("Guard", 40, 46.8f, ItemID.PICKPOCKET_GUIDE_GUARD),
	FISH_STALL("Fish Stall", 42, 42, ItemID.RAW_SALMON),
	CHEST_50_COINS("Chest (50 Coins)", 43, 125, ItemID.FAKE_COINS),
	BEARDED_POLLNIVNIAN_BANDIT("Bearded Pollnivnian Bandit", 45, 65, ItemID.PICKPOCKET_GUIDE_FEUD_ARABIAN_GUARD2),
	FREMENNIK_CITIZEN("Fremennik Citizen", 45, 65, ItemID.PICKPOCKET_GUIDE_FREMENNIK_CITIZEN),
	AUTUMN_SQIRKJUICE("Autumn Sq'irkjuice", 45, 2350, ItemID.OSMAN_SQUIRK_J_AUTUMN),
	CHEST_STEEL_ARROWTIPS("Chest (Steel Arrowtips)", 47, 150, ItemID.STEEL_ARROWHEADS),
	CROSSBOW_STALL("Crossbow Stall", 49, 52, ItemID.CROSSBOW),
	WALL_SAFE("Wall Safe", 50, 70, ItemID.ROGUESDEN_STETHOSCOPE),
	WEALTHY_CITIZEN("Wealthy Citizen", 50, 96, ItemID.PICKPOCKET_GUIDE_WEALTHY_CITIZEN),
	SILVER_STALL("Silver Stall", 50, 205, ItemID.SILVER_BAR),
	DORGESH_KAAN_AVERAGE_CHEST("Dorgesh-Kaan Average Chest", 52, 200, ItemID.OIL_LANTERN_UNLIT),
	DESERT_BANDIT("Desert Bandit", 53, 79.4f, ItemID.PICKPOCKET_GUIDE_DESERT_BANDIT),
	KNIGHT("Knight", 55, 84.3f, ItemID.PICKPOCKET_GUIDE_KNIGHT),
	POLLNIVNIAN_BANDIT("Pollnivnian Bandit", 55, 84.3f, ItemID.PICKPOCKET_GUIDE_FEUD_ARABIAN_GUARD1),
	STONE_CHEST("Stone Chest", 64, 280, ItemID.XERIC_FABRIC),
	MAGIC_STALL("Magic Stall", 65, 90, ItemID.ROGUETRADER_AIRRUNE),
	SPICE_STALL("Spice Stall", 65, 92, ItemID.SPICESPOT),
	MENAPHITE_THUG("Menaphite Thug", 65, 137.5f, ItemID.PICKPOCKET_GUIDE_FEUD_EGYPTIAN_DOORMAN),
	YANILLE_WATCHMAN("Yanille Watchman", 65, 137.5f, ItemID.PICKPOCKET_GUIDE_WATCHMAN),
	SCIMITAR_STALL("Scimitar Stall", 65, 210, ItemID.STEEL_SCIMITAR),
	SUMMER_SQIRKJUICE("Summer Sq'irkjuice", 65, 3000, ItemID.OSMAN_SQUIRK_J_SUMMER),
	PALADIN("Paladin", 70, 131.8f, ItemID.PICKPOCKET_GUIDE_PALADIN),
	GNOME("Gnome", 75, 133.5f, ItemID.PICKPOCKET_GUIDE_GNOME),
	GEM_STALL("Gem Stall", 75, 408, ItemID.SAPPHIRE),
	DORGESH_KAAN_RICH_CHEST("Dorgesh-Kaan Rich Chest", 78, 650, ItemID.CAVE_GOBLIN_MINING_HELMET_LIT),
	HERO("Hero", 80, 163.3f, ItemID.PICKPOCKET_GUIDE_HERO),
	VYRE("Vyre", 82, 306.9f, ItemID.PICKPOCKET_GUIDE_VYRE),
	ORE_STALL("Ore Stall", 82, 350, ItemID.RUNITE_ORE),
	ROGUES_CASTLE_CHEST("Wilderness Rogues' Chest", 84, 701.7f, ItemID.DRAGONSTONE),
	ELF("Elf", 85, 353.3f, ItemID.PICKPOCKET_GUIDE_WOODELF),
	TZHAAR_HUR("TzHaar-Hur", 90, 103.4f, ItemID.PICKPOCKET_GUIDE_TZHAAR),
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
