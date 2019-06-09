/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.skillcalculator.banked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.game.ItemManager;

public enum CriticalItem
{
	/**
	 * Construction Items
	 */
	// Planks
	PLANK(ItemID.PLANK, "Planks", Skill.CONSTRUCTION),
	OAK_PLANK(ItemID.OAK_PLANK, "Planks", Skill.CONSTRUCTION),
	TEAK_PLANK(ItemID.TEAK_PLANK, "Planks", Skill.CONSTRUCTION),
	MAHOGANY_PLANK(ItemID.MAHOGANY_PLANK, "Planks", Skill.CONSTRUCTION),
	// Logs
	LOGS(ItemID.LOGS, "Logs", Skill.CONSTRUCTION, ItemID.PLANK),
	OAK_LOGS(ItemID.OAK_LOGS, "Logs", Skill.CONSTRUCTION, ItemID.OAK_PLANK),
	TEAK_LOGS(ItemID.TEAK_LOGS, "Logs", Skill.CONSTRUCTION, ItemID.TEAK_PLANK),
	MAHOGANY_LOGS(ItemID.MAHOGANY_LOGS, "Logs", Skill.CONSTRUCTION, ItemID.MAHOGANY_PLANK),

	/**
	 * Herblore Items
	 */
	// Grimy Herbs
	GRIMY_GUAM_LEAF(ItemID.GRIMY_GUAM_LEAF, "Grimy Herbs", Skill.HERBLORE, ItemID.GUAM_LEAF),
	GRIMY_MARRENTILL(ItemID.GRIMY_MARRENTILL, "Grimy Herbs", Skill.HERBLORE, ItemID.MARRENTILL),
	GRIMY_TARROMIN(ItemID.GRIMY_TARROMIN, "Grimy Herbs", Skill.HERBLORE, ItemID.TARROMIN),
	GRIMY_HARRALANDER(ItemID.GRIMY_HARRALANDER, "Grimy Herbs", Skill.HERBLORE, ItemID.HARRALANDER),
	GRIMY_RANARR_WEED(ItemID.GRIMY_RANARR_WEED, "Grimy Herbs", Skill.HERBLORE, ItemID.RANARR_WEED),
	GRIMY_TOADFLAX(ItemID.GRIMY_TOADFLAX, "Grimy Herbs", Skill.HERBLORE, ItemID.TOADFLAX),
	GRIMY_IRIT_LEAF(ItemID.GRIMY_IRIT_LEAF, "Grimy Herbs", Skill.HERBLORE, ItemID.IRIT_LEAF),
	GRIMY_AVANTOE(ItemID.GRIMY_AVANTOE, "Grimy Herbs", Skill.HERBLORE, ItemID.AVANTOE),
	GRIMY_KWUARM(ItemID.GRIMY_KWUARM, "Grimy Herbs", Skill.HERBLORE, ItemID.KWUARM),
	GRIMY_SNAPDRAGON(ItemID.GRIMY_SNAPDRAGON, "Grimy Herbs", Skill.HERBLORE, ItemID.SNAPDRAGON),
	GRIMY_CADANTINE(ItemID.GRIMY_CADANTINE, "Grimy Herbs", Skill.HERBLORE, ItemID.CADANTINE),
	GRIMY_LANTADYME(ItemID.GRIMY_LANTADYME, "Grimy Herbs", Skill.HERBLORE, ItemID.LANTADYME),
	GRIMY_DWARF_WEED(ItemID.GRIMY_DWARF_WEED, "Grimy Herbs", Skill.HERBLORE, ItemID.DWARF_WEED),
	GRIMY_TORSTOL(ItemID.GRIMY_TORSTOL, "Grimy Herbs", Skill.HERBLORE, ItemID.TORSTOL),
	// Clean Herbs
	GUAM_LEAF(ItemID.GUAM_LEAF, "Cleaned Herbs", Skill.HERBLORE, ItemID.GUAM_POTION_UNF),
	MARRENTILL(ItemID.MARRENTILL, "Cleaned Herbs", Skill.HERBLORE, ItemID.MARRENTILL_POTION_UNF),
	TARROMIN(ItemID.TARROMIN, "Cleaned Herbs", Skill.HERBLORE, ItemID.TARROMIN_POTION_UNF),
	HARRALANDER(ItemID.HARRALANDER, "Cleaned Herbs", Skill.HERBLORE, ItemID.HARRALANDER_POTION_UNF),
	RANARR_WEED(ItemID.RANARR_WEED, "Cleaned Herbs", Skill.HERBLORE, ItemID.RANARR_POTION_UNF),
	TOADFLAX(ItemID.TOADFLAX, "Cleaned Herbs", Skill.HERBLORE, ItemID.TOADFLAX_POTION_UNF),
	IRIT_LEAF(ItemID.IRIT_LEAF, "Cleaned Herbs", Skill.HERBLORE, ItemID.IRIT_POTION_UNF),
	AVANTOE(ItemID.AVANTOE, "Cleaned Herbs", Skill.HERBLORE, ItemID.AVANTOE_POTION_UNF),
	KWUARM(ItemID.KWUARM, "Cleaned Herbs", Skill.HERBLORE, ItemID.KWUARM_POTION_UNF),
	SNAPDRAGON(ItemID.SNAPDRAGON, "Cleaned Herbs", Skill.HERBLORE, ItemID.SNAPDRAGON_POTION_UNF),
	CADANTINE(ItemID.CADANTINE, "Cleaned Herbs", Skill.HERBLORE, ItemID.CADANTINE_POTION_UNF),
	LANTADYME(ItemID.LANTADYME, "Cleaned Herbs", Skill.HERBLORE, ItemID.LANTADYME_POTION_UNF),
	DWARF_WEED(ItemID.DWARF_WEED, "Cleaned Herbs", Skill.HERBLORE, ItemID.DWARF_WEED_POTION_UNF),
	TORSTOL(ItemID.TORSTOL, "Cleaned Herbs", Skill.HERBLORE, ItemID.TORSTOL_POTION_UNF),
	// Unfinished Potions
	GUAM_LEAF_POTION_UNF(ItemID.GUAM_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	MARRENTILL_POTION_UNF(ItemID.MARRENTILL_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	TARROMIN_POTION_UNF(ItemID.TARROMIN_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	HARRALANDER_POTION_UNF(ItemID.HARRALANDER_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	RANARR_POTION_UNF(ItemID.RANARR_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	TOADFLAX_POTION_UNF(ItemID.TOADFLAX_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	IRIT_POTION_UNF(ItemID.IRIT_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	AVANTOE_POTION_UNF(ItemID.AVANTOE_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	KWUARM_POTION_UNF(ItemID.KWUARM_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	SNAPDRAGON_POTION_UNF(ItemID.SNAPDRAGON_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	CADANTINE_POTION_UNF(ItemID.CADANTINE_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	LANTADYME_POTION_UNF(ItemID.LANTADYME_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	DWARF_WEED_POTION_UNF(ItemID.DWARF_WEED_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),
	TORSTOL_POTION_UNF(ItemID.TORSTOL_POTION_UNF, "Unfinished Potions", Skill.HERBLORE),

	/**
	 * Prayer Items
	 */
	// Bones
	BONES(ItemID.BONES, "Bones", Skill.PRAYER),
	WOLF_BONES(ItemID.WOLF_BONES, "Bones", Skill.PRAYER),
	BURNT_BONES(ItemID.BURNT_BONES, "Bones", Skill.PRAYER),
	MONKEY_BONES(ItemID.MONKEY_BONES, "Bones", Skill.PRAYER),
	BAT_BONES(ItemID.BAT_BONES, "Bones", Skill.PRAYER),
	JOGRE_BONES(ItemID.JOGRE_BONES, "Bones", Skill.PRAYER),
	BIG_BONES(ItemID.BIG_BONES, "Bones", Skill.PRAYER),
	ZOGRE_BONES(ItemID.ZOGRE_BONES, "Bones", Skill.PRAYER),
	SHAIKAHAN_BONES(ItemID.SHAIKAHAN_BONES, "Bones", Skill.PRAYER),
	BABYDRAGON_BONES(ItemID.BABYDRAGON_BONES, "Bones", Skill.PRAYER),
	WYVERN_BONES(ItemID.WYVERN_BONES, "Bones", Skill.PRAYER),
	DRAGON_BONES(ItemID.DRAGON_BONES, "Bones", Skill.PRAYER),
	FAYRG_BONES(ItemID.FAYRG_BONES, "Bones", Skill.PRAYER),
	LAVA_DRAGON_BONES(ItemID.LAVA_DRAGON_BONES, "Bones", Skill.PRAYER),
	RAURG_BONES(ItemID.RAURG_BONES, "Bones", Skill.PRAYER),
	DAGANNOTH_BONES(ItemID.DAGANNOTH_BONES, "Bones", Skill.PRAYER),
	OURG_BONES(ItemID.OURG_BONES, "Bones", Skill.PRAYER),
	SUPERIOR_DRAGON_BONES(ItemID.SUPERIOR_DRAGON_BONES, "Bones", Skill.PRAYER),
	// Shade Remains (Pyre Logs)
	LOAR_REMAINS(ItemID.LOAR_REMAINS, "Shades", Skill.PRAYER, true),
	PHRIN_REMAINS(ItemID.PHRIN_REMAINS, "Shades", Skill.PRAYER, true),
	RIYL_REMAINS(ItemID.RIYL_REMAINS, "Shades", Skill.PRAYER, true),
	ASYN_REMAINS(ItemID.ASYN_REMAINS, "Shades", Skill.PRAYER, true),
	FIYR_REMAINS(ItemID.FIYR_REMAINS, "Shades", Skill.PRAYER, true),
	// Ensouled Heads
	ENSOULED_GOBLIN_HEAD(ItemID.ENSOULED_GOBLIN_HEAD_13448, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_MONKEY_HEAD(ItemID.ENSOULED_MONKEY_HEAD_13451, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_IMP_HEAD(ItemID.ENSOULED_IMP_HEAD_13454, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_MINOTAUR_HEAD(ItemID.ENSOULED_MINOTAUR_HEAD_13457, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_SCORPION_HEAD(ItemID.ENSOULED_SCORPION_HEAD_13460, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_BEAR_HEAD(ItemID.ENSOULED_BEAR_HEAD_13463, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_UNICORN_HEAD(ItemID.ENSOULED_UNICORN_HEAD_13466, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_DOG_HEAD(ItemID.ENSOULED_DOG_HEAD_13469, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_CHAOS_DRUID_HEAD(ItemID.ENSOULED_CHAOS_DRUID_HEAD_13472, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_GIANT_HEAD(ItemID.ENSOULED_GIANT_HEAD_13475, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_OGRE_HEAD(ItemID.ENSOULED_OGRE_HEAD_13478, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_ELF_HEAD(ItemID.ENSOULED_ELF_HEAD_13481, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_TROLL_HEAD(ItemID.ENSOULED_TROLL_HEAD_13484, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_HORROR_HEAD(ItemID.ENSOULED_HORROR_HEAD_13487, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_KALPHITE_HEAD(ItemID.ENSOULED_KALPHITE_HEAD_13490, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_DAGANNOTH_HEAD(ItemID.ENSOULED_DAGANNOTH_HEAD_13493, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_BLOODVELD_HEAD(ItemID.ENSOULED_BLOODVELD_HEAD_13496, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_TZHAAR_HEAD(ItemID.ENSOULED_TZHAAR_HEAD_13499, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_DEMON_HEAD(ItemID.ENSOULED_DEMON_HEAD_13502, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_AVIANSIE_HEAD(ItemID.ENSOULED_AVIANSIE_HEAD_13505, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_ABYSSAL_HEAD(ItemID.ENSOULED_ABYSSAL_HEAD_13508, "Ensouled Heads", Skill.PRAYER, true),
	ENSOULED_DRAGON_HEAD(ItemID.ENSOULED_DRAGON_HEAD_13511, "Ensouled Heads", Skill.PRAYER, true),

	/**
	 * Cooking Items
	 */
	RAW_HERRING(ItemID.RAW_HERRING, "Fish", Skill.COOKING),
	RAW_MACKEREL(ItemID.RAW_MACKEREL, "Fish", Skill.COOKING),
	RAW_TROUT(ItemID.RAW_TROUT, "Fish", Skill.COOKING),
	RAW_COD(ItemID.RAW_COD, "Fish", Skill.COOKING),
	RAW_PIKE(ItemID.RAW_PIKE, "Fish", Skill.COOKING),
	RAW_SALMON(ItemID.RAW_SALMON, "Fish", Skill.COOKING),
	RAW_TUNA(ItemID.RAW_TUNA, "Fish", Skill.COOKING),
	RAW_KARAMBWAN(ItemID.RAW_KARAMBWAN, "Fish", Skill.COOKING),
	RAW_LOBSTER(ItemID.RAW_LOBSTER, "Fish", Skill.COOKING),
	RAW_BASS(ItemID.RAW_BASS, "Fish", Skill.COOKING),
	RAW_SWORDFISH(ItemID.RAW_SWORDFISH, "Fish", Skill.COOKING),
	RAW_MONKFISH(ItemID.RAW_MONKFISH, "Fish", Skill.COOKING),
	RAW_SHARK(ItemID.RAW_SHARK, "Fish", Skill.COOKING),
	RAW_SEA_TURTLE(ItemID.RAW_SEA_TURTLE, "Fish", Skill.COOKING),
	RAW_ANGLERFISH(ItemID.RAW_ANGLERFISH, "Fish", Skill.COOKING),
	RAW_DARK_CRAB(ItemID.RAW_DARK_CRAB, "Fish", Skill.COOKING),
	RAW_MANTA_RAY(ItemID.RAW_MANTA_RAY, "Fish", Skill.COOKING),

	GRAPES(ItemID.GRAPES, "Other", Skill.COOKING),

	/**
	 * Crafting Items
	 */
	WOOL(ItemID.WOOL, "Misc", Skill.CRAFTING),
	FLAX(ItemID.FLAX, "Misc", Skill.CRAFTING),
	MOLTEN_GLASS(ItemID.MOLTEN_GLASS, "Misc", Skill.CRAFTING),
	BATTLESTAFF(ItemID.BATTLESTAFF, "Misc", Skill.CRAFTING),

	// D'hide/Dragon Leather
	GREEN_DRAGONHIDE(ItemID.GREEN_DRAGONHIDE, "D'hide", Skill.CRAFTING, ItemID.GREEN_DRAGON_LEATHER),
	GREEN_DRAGON_LEATHER(ItemID.GREEN_DRAGON_LEATHER, "D'hide", Skill.CRAFTING),
	BLUE_DRAGONHIDE(ItemID.BLUE_DRAGONHIDE, "D'hide", Skill.CRAFTING, ItemID.BLUE_DRAGON_LEATHER),
	BLUE_DRAGON_LEATHER(ItemID.BLUE_DRAGON_LEATHER, "D'hide", Skill.CRAFTING),
	RED_DRAGONHIDE(ItemID.RED_DRAGONHIDE, "D'hide", Skill.CRAFTING, ItemID.RED_DRAGON_LEATHER),
	RED_DRAGON_LEATHER(ItemID.RED_DRAGON_LEATHER, "D'hide", Skill.CRAFTING),
	BLACK_DRAGONHIDE(ItemID.BLACK_DRAGONHIDE, "D'hide", Skill.CRAFTING, ItemID.BLACK_DRAGON_LEATHER),
	BLACK_DRAGON_LEATHER(ItemID.BLACK_DRAGON_LEATHER, "D'hide", Skill.CRAFTING),

	// Uncut Gems
	UNCUT_OPAL(ItemID.UNCUT_OPAL, "Gems", Skill.CRAFTING, ItemID.OPAL),
	UNCUT_JADE(ItemID.UNCUT_JADE, "Gems", Skill.CRAFTING, ItemID.JADE),
	UNCUT_RED_TOPAZ(ItemID.UNCUT_RED_TOPAZ, "Gems", Skill.CRAFTING, ItemID.RED_TOPAZ),
	UNCUT_SAPPHIRE(ItemID.UNCUT_SAPPHIRE, "Gems", Skill.CRAFTING, ItemID.SAPPHIRE),
	UNCUT_EMERALD(ItemID.UNCUT_EMERALD, "Gems", Skill.CRAFTING, ItemID.EMERALD),
	UNCUT_RUBY(ItemID.UNCUT_RUBY, "Gems", Skill.CRAFTING, ItemID.RUBY),
	UNCUT_DIAMOND(ItemID.UNCUT_DIAMOND, "Gems", Skill.CRAFTING, ItemID.DIAMOND),
	UNCUT_DRAGONSTONE(ItemID.UNCUT_DRAGONSTONE, "Gems", Skill.CRAFTING, ItemID.DRAGONSTONE),
	UNCUT_ONYX(ItemID.UNCUT_ONYX, "Gems", Skill.CRAFTING, ItemID.ONYX),
	UNCUT_ZENYTE(ItemID.UNCUT_ZENYTE, "Gems", Skill.CRAFTING, ItemID.ZENYTE),

	// Cut Gems
	OPAL(ItemID.OPAL, "Gems", Skill.CRAFTING),
	JADE(ItemID.JADE, "Gems", Skill.CRAFTING),
	RED_TOPAZ(ItemID.RED_TOPAZ, "Gems", Skill.CRAFTING),
	SAPPHIRE(ItemID.SAPPHIRE, "Gems", Skill.CRAFTING),
	EMERALD(ItemID.EMERALD, "Gems", Skill.CRAFTING),
	RUBY(ItemID.RUBY, "Gems", Skill.CRAFTING),
	DIAMOND(ItemID.DIAMOND, "Gems", Skill.CRAFTING),
	DRAGONSTONE(ItemID.DRAGONSTONE, "Gems", Skill.CRAFTING),
	ONYX(ItemID.ONYX, "Gems", Skill.CRAFTING),
	ZENYTE(ItemID.ZENYTE, "Gems", Skill.CRAFTING),

	/**
	 * Smithing Items
	 */

	// Ores
	IRON_ORE(ItemID.IRON_ORE, "Ore", Skill.SMITHING),
	SILVER_ORE(ItemID.SILVER_ORE, "Ore", Skill.SMITHING),
	GOLD_ORE(ItemID.GOLD_ORE, "Ore", Skill.SMITHING),
	MITHRIL_ORE(ItemID.MITHRIL_ORE, "Ore", Skill.SMITHING),
	ADAMANTITE_ORE(ItemID.ADAMANTITE_ORE, "Ore", Skill.SMITHING),
	RUNITE_ORE(ItemID.RUNITE_ORE, "Ore", Skill.SMITHING),

	// Bars
	BRONZE_BAR(ItemID.BRONZE_BAR, "Bars", Skill.SMITHING),
	IRON_BAR(ItemID.IRON_BAR, "Bars", Skill.SMITHING),
	STEEL_BAR(ItemID.STEEL_BAR, "Bars", Skill.SMITHING),
	MITHRIL_BAR(ItemID.MITHRIL_BAR, "Bars", Skill.SMITHING),
	ADAMANTITE_BAR(ItemID.ADAMANTITE_BAR, "Bars", Skill.SMITHING),
	RUNITE_BAR(ItemID.RUNITE_BAR, "Bars", Skill.SMITHING),

	/**
	 * Farming Items
	 */
	// Seeds
	ACORN(ItemID.ACORN, "Seeds", Skill.FARMING),
	WILLOW_SEED(ItemID.WILLOW_SEED, "Seeds", Skill.FARMING),
	MAPLE_SEED(ItemID.MAPLE_SEED, "Seeds", Skill.FARMING),
	YEW_SEED(ItemID.YEW_SEED, "Seeds", Skill.FARMING),
	MAGIC_SEED(ItemID.MAGIC_SEED, "Seeds", Skill.FARMING),
	APPLE_TREE_SEED(ItemID.APPLE_TREE_SEED, "Seeds", Skill.FARMING),
	BANANA_TREE_SEED(ItemID.BANANA_TREE_SEED, "Seeds", Skill.FARMING),
	ORANGE_TREE_SEED(ItemID.ORANGE_TREE_SEED, "Seeds", Skill.FARMING),
	CURRY_TREE_SEED(ItemID.CURRY_TREE_SEED, "Seeds", Skill.FARMING),
	PINEAPPLE_SEED(ItemID.PINEAPPLE_SEED, "Seeds", Skill.FARMING),
	PAPAYA_TREE_SEED(ItemID.PAPAYA_TREE_SEED, "Seeds", Skill.FARMING),
	PALM_TREE_SEED(ItemID.PALM_TREE_SEED, "Seeds", Skill.FARMING),
	CALQUAT_TREE_SEED(ItemID.CALQUAT_TREE_SEED, "Seeds", Skill.FARMING),
	TEAK_SEED(ItemID.TEAK_SEED, "Seeds", Skill.FARMING),
	MAHOGANY_SEED(ItemID.MAHOGANY_SEED, "Seeds", Skill.FARMING),
	SPIRIT_SEED(ItemID.SPIRIT_SEED, "Seeds", Skill.FARMING),

	// Saplings
	OAK_SAPLING(ItemID.OAK_SAPLING, "Saplings", Skill.FARMING, ItemID.ACORN),
	WILLOW_SAPLING(ItemID.WILLOW_SAPLING, "Saplings", Skill.FARMING, ItemID.WILLOW_SEED),
	MAPLE_SAPLING(ItemID.MAPLE_SAPLING, "Saplings", Skill.FARMING, ItemID.MAPLE_SEED),
	YEW_SAPLING(ItemID.YEW_SAPLING, "Saplings", Skill.FARMING, ItemID.YEW_SEED),
	MAGIC_SAPLING(ItemID.MAGIC_SAPLING, "Saplings", Skill.FARMING, ItemID.MAGIC_SEED),
	APPLE_TREE_SAPLING(ItemID.APPLE_SAPLING, "Saplings", Skill.FARMING, ItemID.APPLE_TREE_SEED),
	BANANA_TREE_SAPLING(ItemID.BANANA_SAPLING, "Saplings", Skill.FARMING, ItemID.BANANA_TREE_SEED),
	ORANGE_TREE_SAPLING(ItemID.ORANGE_SAPLING, "Saplings", Skill.FARMING, ItemID.ORANGE_TREE_SEED),
	CURRY_TREE_SAPLING(ItemID.CURRY_SAPLING, "Saplings", Skill.FARMING, ItemID.CURRY_TREE_SEED),
	PINEAPPLE_SAPLING(ItemID.PINEAPPLE_SAPLING, "Saplings", Skill.FARMING, ItemID.PINEAPPLE_SEED),
	PAPAYA_TREE_SAPLING(ItemID.PAPAYA_SAPLING, "Saplings", Skill.FARMING, ItemID.PAPAYA_TREE_SEED),
	PALM_TREE_SAPLING(ItemID.PALM_SAPLING, "Saplings", Skill.FARMING, ItemID.PALM_TREE_SEED),
	CALQUAT_TREE_SAPLING(ItemID.CALQUAT_SAPLING, "Saplings", Skill.FARMING, ItemID.CALQUAT_TREE_SEED),
	TEAK_SAPLING(ItemID.TEAK_SAPLING, "Saplings", Skill.FARMING, ItemID.TEAK_SEED),
	MAHOGANY_SAPLING(ItemID.MAHOGANY_SAPLING, "Saplings", Skill.FARMING, ItemID.MAHOGANY_SEED),
	SPIRIT_SAPLING(ItemID.SPIRIT_SAPLING, "Saplings", Skill.FARMING, ItemID.SPIRIT_SEED),
	;

	@Getter
	private final int itemID;
	@Getter
	private final String category;
	@Getter
	private final Skill skill;

	/**
	 * Should be operated on and then treated like this item or does nothing if null.
	 * Used mostly for things like herblore where you want Grimy, Clean, and UNF to count for creating potions.
	 * To do this GRIMY links to CLEAN which links to UNFINISHED which links to null
	 */
	@Getter
	private final int linkedItemId;

	@Getter
	private boolean ignoreBonus;

	@Getter
	private ItemDefinition definition;

	CriticalItem(int itemID, String category, Skill skill, int linkedItem)
	{
		this.itemID = itemID;
		this.category = category;
		this.skill = skill;
		this.linkedItemId = linkedItem;
		this.definition = null;
		this.ignoreBonus = false;
	}

	CriticalItem(int itemID, String category, Skill skill)
	{
		this(itemID, category, skill, -1);
	}

	CriticalItem(int itemID, String category, Skill skill, boolean ignoreBonusXp)
	{
		this(itemID, category, skill, -1);
		this.ignoreBonus = ignoreBonusXp;
	}

	// Builds a Map to reduce looping frequency
	private static Map<Skill, ArrayList<CriticalItem>> buildSkillItemMap()
	{
		Map<Skill, ArrayList<CriticalItem>> map = new HashMap<>();
		for (CriticalItem item : values())
		{
			map.computeIfAbsent(item.getSkill(), e -> new ArrayList<>()).add(item);
		}

		return map;
	}

	private static final Map<Skill, ArrayList<CriticalItem>> bySkillName = buildSkillItemMap();

	public static ArrayList<CriticalItem> getBySkillName(Skill skill)
	{
		return bySkillName.get(skill);
	}

	// Builds a Map to reduce looping frequency
	private static Map<Skill, Set<String>> buildSkillCategoryMap()
	{
		Map<Skill, Set<String>> map = new HashMap<>();
		for (CriticalItem item : values())
		{
			map.computeIfAbsent(item.getSkill(), k -> new HashSet<>()).add(item.category);
		}

		return map;
	}

	private static final Map<Skill, Set<String>> bySkillCategory = buildSkillCategoryMap();

	public static Set<String> getSkillCategories(Skill skill)
	{
		return bySkillCategory.get(skill);
	}

	// Builds a Map to reduce looping frequency
	private static Map<String, ArrayList<CriticalItem>> buildItemSkillCategoryMap()
	{
		Map<String, ArrayList<CriticalItem>> map = new HashMap<>();
		for (CriticalItem item : values())
		{
			String key = item.getCategory() + item.skill.getName();
			map.computeIfAbsent(key, e -> new ArrayList<>()).add(item);
		}

		return map;
	}

	private static final Map<String, ArrayList<CriticalItem>> itemsBySkillCategory = buildItemSkillCategoryMap();

	public static ArrayList<CriticalItem> getItemsForSkillCategories(Skill skill, String category)
	{
		return itemsBySkillCategory.get(category + skill.getName());
	}

	// Builds a Map to reduce looping frequency
	private static Map<Integer, CriticalItem> buildItemsByIdMap()
	{
		Map<Integer, CriticalItem> map = new HashMap<>();
		for (CriticalItem item : values())
		{
			map.put(item.getItemID(), item);
		}

		return map;
	}

	private static final Map<Integer, CriticalItem> itemsById = buildItemsByIdMap();

	public static CriticalItem getByItemId(int id)
	{
		return itemsById.get(id);
	}

	/**
	 * Attaches the Item Composition to each Critical Item on client initial load
	 *
	 * @param m ItemManager
	 */
	public static void prepareItemDefinitions(ItemManager m)
	{
		for (CriticalItem i : values())
		{
			i.definition = m.getItemDefinition(i.getItemID());
		}
	}

	@Override
	public String toString()
	{
		return "CriticalItem=(name=" + this.name() + ",id=" + this.itemID + ",category=" + this.category + ")";
	}
}
