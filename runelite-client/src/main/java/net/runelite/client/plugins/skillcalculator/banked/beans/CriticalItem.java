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
package net.runelite.client.plugins.skillcalculator.banked.beans;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.game.ItemManager;

@Getter(AccessLevel.PUBLIC)
public enum CriticalItem
{
	/**
	 * Construction Items
	 */
	// Logs
	LOGS(ItemID.LOGS, Skill.CONSTRUCTION, "Logs"),
	OAK_LOGS(ItemID.OAK_LOGS, Skill.CONSTRUCTION, "Logs"),
	TEAK_LOGS(ItemID.TEAK_LOGS, Skill.CONSTRUCTION, "Logs"),
	MAHOGANY_LOGS(ItemID.MAHOGANY_LOGS, Skill.CONSTRUCTION, "Logs"),
	// Planks
	PLANK(ItemID.PLANK, Skill.CONSTRUCTION, "Planks"),
	OAK_PLANK(ItemID.OAK_PLANK, Skill.CONSTRUCTION, "Planks"),
	TEAK_PLANK(ItemID.TEAK_PLANK, Skill.CONSTRUCTION, "Planks"),
	MAHOGANY_PLANK(ItemID.MAHOGANY_PLANK, Skill.CONSTRUCTION, "Planks"),

	/**
	 * Herblore Items
	 */
	// Grimy Herbs
	GRIMY_GUAM_LEAF(ItemID.GRIMY_GUAM_LEAF, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_MARRENTILL(ItemID.GRIMY_MARRENTILL, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_TARROMIN(ItemID.GRIMY_TARROMIN, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_HARRALANDER(ItemID.GRIMY_HARRALANDER, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_RANARR_WEED(ItemID.GRIMY_RANARR_WEED, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_TOADFLAX(ItemID.GRIMY_TOADFLAX, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_IRIT_LEAF(ItemID.GRIMY_IRIT_LEAF, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_AVANTOE(ItemID.GRIMY_AVANTOE, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_KWUARM(ItemID.GRIMY_KWUARM, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_SNAPDRAGON(ItemID.GRIMY_SNAPDRAGON, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_CADANTINE(ItemID.GRIMY_CADANTINE, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_LANTADYME(ItemID.GRIMY_LANTADYME, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_DWARF_WEED(ItemID.GRIMY_DWARF_WEED, Skill.HERBLORE, "Grimy Herbs"),
	GRIMY_TORSTOL(ItemID.GRIMY_TORSTOL, Skill.HERBLORE, "Grimy Herbs"),
	// Clean Herbs
	GUAM_LEAF(ItemID.GUAM_LEAF, Skill.HERBLORE, "Cleaned Herbs"),
	MARRENTILL(ItemID.MARRENTILL, Skill.HERBLORE, "Cleaned Herbs"),
	TARROMIN(ItemID.TARROMIN, Skill.HERBLORE, "Cleaned Herbs"),
	HARRALANDER(ItemID.HARRALANDER, Skill.HERBLORE, "Cleaned Herbs"),
	RANARR_WEED(ItemID.RANARR_WEED, Skill.HERBLORE, "Cleaned Herbs"),
	TOADFLAX(ItemID.TOADFLAX, Skill.HERBLORE, "Cleaned Herbs"),
	IRIT_LEAF(ItemID.IRIT_LEAF, Skill.HERBLORE, "Cleaned Herbs"),
	AVANTOE(ItemID.AVANTOE, Skill.HERBLORE, "Cleaned Herbs"),
	KWUARM(ItemID.KWUARM, Skill.HERBLORE, "Cleaned Herbs"),
	SNAPDRAGON(ItemID.SNAPDRAGON, Skill.HERBLORE, "Cleaned Herbs"),
	CADANTINE(ItemID.CADANTINE, Skill.HERBLORE, "Cleaned Herbs"),
	LANTADYME(ItemID.LANTADYME, Skill.HERBLORE, "Cleaned Herbs"),
	DWARF_WEED(ItemID.DWARF_WEED, Skill.HERBLORE, "Cleaned Herbs"),
	TORSTOL(ItemID.TORSTOL, Skill.HERBLORE, "Cleaned Herbs"),
	// Unfinished Potions
	GUAM_LEAF_POTION_UNF(ItemID.GUAM_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	MARRENTILL_POTION_UNF(ItemID.MARRENTILL_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	TARROMIN_POTION_UNF(ItemID.TARROMIN_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	HARRALANDER_POTION_UNF(ItemID.HARRALANDER_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	RANARR_POTION_UNF(ItemID.RANARR_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	TOADFLAX_POTION_UNF(ItemID.TOADFLAX_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	IRIT_POTION_UNF(ItemID.IRIT_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	AVANTOE_POTION_UNF(ItemID.AVANTOE_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	KWUARM_POTION_UNF(ItemID.KWUARM_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	SNAPDRAGON_POTION_UNF(ItemID.SNAPDRAGON_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	CADANTINE_POTION_UNF(ItemID.CADANTINE_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	LANTADYME_POTION_UNF(ItemID.LANTADYME_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	DWARF_WEED_POTION_UNF(ItemID.DWARF_WEED_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),
	TORSTOL_POTION_UNF(ItemID.TORSTOL_POTION_UNF, Skill.HERBLORE, "Unfinished Potions"),

	/**
	 * Prayer Items
	 */
	// Bones
	BONES(ItemID.BONES, Skill.PRAYER, "Bones"),
	WOLF_BONES(ItemID.WOLF_BONES, Skill.PRAYER, "Bones"),
	BURNT_BONES(ItemID.BURNT_BONES, Skill.PRAYER, "Bones"),
	MONKEY_BONES(ItemID.MONKEY_BONES, Skill.PRAYER, "Bones"),
	BAT_BONES(ItemID.BAT_BONES, Skill.PRAYER, "Bones"),
	JOGRE_BONES(ItemID.JOGRE_BONES, Skill.PRAYER, "Bones"),
	BIG_BONES(ItemID.BIG_BONES, Skill.PRAYER, "Bones"),
	ZOGRE_BONES(ItemID.ZOGRE_BONES, Skill.PRAYER, "Bones"),
	SHAIKAHAN_BONES(ItemID.SHAIKAHAN_BONES, Skill.PRAYER, "Bones"),
	BABYDRAGON_BONES(ItemID.BABYDRAGON_BONES, Skill.PRAYER, "Bones"),
	WYRM_BONES(ItemID.WYRM_BONES, Skill.PRAYER, "Bones"),
	WYVERN_BONES(ItemID.WYVERN_BONES, Skill.PRAYER, "Bones"),
	DRAGON_BONES(ItemID.DRAGON_BONES, Skill.PRAYER, "Bones"),
	DRAKE_BONES(ItemID.DRAKE_BONES, Skill.PRAYER, "Bones"),
	FAYRG_BONES(ItemID.FAYRG_BONES, Skill.PRAYER, "Bones"),
	LAVA_DRAGON_BONES(ItemID.LAVA_DRAGON_BONES, Skill.PRAYER, "Bones"),
	RAURG_BONES(ItemID.RAURG_BONES, Skill.PRAYER, "Bones"),
	HYDRA_BONES(ItemID.HYDRA_BONES, Skill.PRAYER, "Bones"),
	DAGANNOTH_BONES(ItemID.DAGANNOTH_BONES, Skill.PRAYER, "Bones"),
	OURG_BONES(ItemID.OURG_BONES, Skill.PRAYER, "Bones"),
	SUPERIOR_DRAGON_BONES(ItemID.SUPERIOR_DRAGON_BONES, Skill.PRAYER, "Bones"),
	// Shade Remains (Pyre Logs)
	LOAR_REMAINS(ItemID.LOAR_REMAINS, Skill.PRAYER, "Shades", true),
	PHRIN_REMAINS(ItemID.PHRIN_REMAINS, Skill.PRAYER, "Shades", true),
	RIYL_REMAINS(ItemID.RIYL_REMAINS, Skill.PRAYER, "Shades", true),
	ASYN_REMAINS(ItemID.ASYN_REMAINS, Skill.PRAYER, "Shades", true),
	FIYR_REMAINS(ItemID.FIYR_REMAINS, Skill.PRAYER, "Shades", true),
	// Ensouled Heads
	ENSOULED_GOBLIN_HEAD(ItemID.ENSOULED_GOBLIN_HEAD_13448, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_MONKEY_HEAD(ItemID.ENSOULED_MONKEY_HEAD_13451, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_IMP_HEAD(ItemID.ENSOULED_IMP_HEAD_13454, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_MINOTAUR_HEAD(ItemID.ENSOULED_MINOTAUR_HEAD_13457, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_SCORPION_HEAD(ItemID.ENSOULED_SCORPION_HEAD_13460, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_BEAR_HEAD(ItemID.ENSOULED_BEAR_HEAD_13463, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_UNICORN_HEAD(ItemID.ENSOULED_UNICORN_HEAD_13466, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_DOG_HEAD(ItemID.ENSOULED_DOG_HEAD_13469, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_CHAOS_DRUID_HEAD(ItemID.ENSOULED_CHAOS_DRUID_HEAD_13472, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_GIANT_HEAD(ItemID.ENSOULED_GIANT_HEAD_13475, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_OGRE_HEAD(ItemID.ENSOULED_OGRE_HEAD_13478, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_ELF_HEAD(ItemID.ENSOULED_ELF_HEAD_13481, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_TROLL_HEAD(ItemID.ENSOULED_TROLL_HEAD_13484, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_HORROR_HEAD(ItemID.ENSOULED_HORROR_HEAD_13487, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_KALPHITE_HEAD(ItemID.ENSOULED_KALPHITE_HEAD_13490, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_DAGANNOTH_HEAD(ItemID.ENSOULED_DAGANNOTH_HEAD_13493, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_BLOODVELD_HEAD(ItemID.ENSOULED_BLOODVELD_HEAD_13496, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_TZHAAR_HEAD(ItemID.ENSOULED_TZHAAR_HEAD_13499, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_DEMON_HEAD(ItemID.ENSOULED_DEMON_HEAD_13502, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_AVIANSIE_HEAD(ItemID.ENSOULED_AVIANSIE_HEAD_13505, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_ABYSSAL_HEAD(ItemID.ENSOULED_ABYSSAL_HEAD_13508, Skill.PRAYER, "Ensouled Heads", true),
	ENSOULED_DRAGON_HEAD(ItemID.ENSOULED_DRAGON_HEAD_13511, Skill.PRAYER, "Ensouled Heads", true),

	/**
	 * Cooking Items
	 */
	RAW_HERRING(ItemID.RAW_HERRING, Skill.COOKING, "Fish"),
	RAW_MACKEREL(ItemID.RAW_MACKEREL, Skill.COOKING, "Fish"),
	RAW_TROUT(ItemID.RAW_TROUT, Skill.COOKING, "Fish"),
	RAW_COD(ItemID.RAW_COD, Skill.COOKING, "Fish"),
	RAW_PIKE(ItemID.RAW_PIKE, Skill.COOKING, "Fish"),
	RAW_SALMON(ItemID.RAW_SALMON, Skill.COOKING, "Fish"),
	RAW_TUNA(ItemID.RAW_TUNA, Skill.COOKING, "Fish"),
	RAW_KARAMBWAN(ItemID.RAW_KARAMBWAN, Skill.COOKING, "Fish"),
	RAW_LOBSTER(ItemID.RAW_LOBSTER, Skill.COOKING, "Fish"),
	RAW_BASS(ItemID.RAW_BASS, Skill.COOKING, "Fish"),
	RAW_SWORDFISH(ItemID.RAW_SWORDFISH, Skill.COOKING, "Fish"),
	RAW_MONKFISH(ItemID.RAW_MONKFISH, Skill.COOKING, "Fish"),
	RAW_SHARK(ItemID.RAW_SHARK, Skill.COOKING, "Fish"),
	RAW_SEA_TURTLE(ItemID.RAW_SEA_TURTLE, Skill.COOKING, "Fish"),
	RAW_ANGLERFISH(ItemID.RAW_ANGLERFISH, Skill.COOKING, "Fish"),
	RAW_DARK_CRAB(ItemID.RAW_DARK_CRAB, Skill.COOKING, "Fish"),
	RAW_MANTA_RAY(ItemID.RAW_MANTA_RAY, Skill.COOKING, "Fish"),

	GRAPES(ItemID.GRAPES, Skill.COOKING, "Other"),

	/**
	 * Crafting Items
	 */
	WOOL(ItemID.WOOL, Skill.CRAFTING, "Misc"),
	FLAX(ItemID.FLAX, Skill.CRAFTING, "Misc"),
	MOLTEN_GLASS(ItemID.MOLTEN_GLASS, Skill.CRAFTING, "Misc"),
	BATTLESTAFF(ItemID.BATTLESTAFF, Skill.CRAFTING, "Misc"),

	// D'hide/Dragon Leather
	GREEN_DRAGONHIDE(ItemID.GREEN_DRAGONHIDE, Skill.CRAFTING, "D'hide"),
	GREEN_DRAGON_LEATHER(ItemID.GREEN_DRAGON_LEATHER, Skill.CRAFTING, "D'hide"),
	BLUE_DRAGONHIDE(ItemID.BLUE_DRAGONHIDE, Skill.CRAFTING, "D'hide"),
	BLUE_DRAGON_LEATHER(ItemID.BLUE_DRAGON_LEATHER, Skill.CRAFTING, "D'hide"),
	RED_DRAGONHIDE(ItemID.RED_DRAGONHIDE, Skill.CRAFTING, "D'hide"),
	RED_DRAGON_LEATHER(ItemID.RED_DRAGON_LEATHER, Skill.CRAFTING, "D'hide"),
	BLACK_DRAGONHIDE(ItemID.BLACK_DRAGONHIDE, Skill.CRAFTING, "D'hide"),
	BLACK_DRAGON_LEATHER(ItemID.BLACK_DRAGON_LEATHER, Skill.CRAFTING, "D'hide"),

	// Uncut Gems
	UNCUT_OPAL(ItemID.UNCUT_OPAL, Skill.CRAFTING, "Gems"),
	UNCUT_JADE(ItemID.UNCUT_JADE, Skill.CRAFTING, "Gems"),
	UNCUT_RED_TOPAZ(ItemID.UNCUT_RED_TOPAZ, Skill.CRAFTING, "Gems"),
	UNCUT_SAPPHIRE(ItemID.UNCUT_SAPPHIRE, Skill.CRAFTING, "Gems"),
	UNCUT_EMERALD(ItemID.UNCUT_EMERALD, Skill.CRAFTING, "Gems"),
	UNCUT_RUBY(ItemID.UNCUT_RUBY, Skill.CRAFTING, "Gems"),
	UNCUT_DIAMOND(ItemID.UNCUT_DIAMOND, Skill.CRAFTING, "Gems"),
	UNCUT_DRAGONSTONE(ItemID.UNCUT_DRAGONSTONE, Skill.CRAFTING, "Gems"),
	UNCUT_ONYX(ItemID.UNCUT_ONYX, Skill.CRAFTING, "Gems"),
	UNCUT_ZENYTE(ItemID.UNCUT_ZENYTE, Skill.CRAFTING, "Gems"),

	// Cut Gems
	OPAL(ItemID.OPAL, Skill.CRAFTING, "Gems"),
	JADE(ItemID.JADE, Skill.CRAFTING, "Gems"),
	RED_TOPAZ(ItemID.RED_TOPAZ, Skill.CRAFTING, "Gems"),
	SAPPHIRE(ItemID.SAPPHIRE, Skill.CRAFTING, "Gems"),
	EMERALD(ItemID.EMERALD, Skill.CRAFTING, "Gems"),
	RUBY(ItemID.RUBY, Skill.CRAFTING, "Gems"),
	DIAMOND(ItemID.DIAMOND, Skill.CRAFTING, "Gems"),
	DRAGONSTONE(ItemID.DRAGONSTONE, Skill.CRAFTING, "Gems"),
	ONYX(ItemID.ONYX, Skill.CRAFTING, "Gems"),
	ZENYTE(ItemID.ZENYTE, Skill.CRAFTING, "Gems"),

	/**
	 * Smithing Items
	 */

	// Ores
	IRON_ORE(ItemID.IRON_ORE, Skill.SMITHING, "Ore"),
	SILVER_ORE(ItemID.SILVER_ORE, Skill.SMITHING, "Ore"),
	GOLD_ORE(ItemID.GOLD_ORE, Skill.SMITHING, "Ore"),
	MITHRIL_ORE(ItemID.MITHRIL_ORE, Skill.SMITHING, "Ore"),
	ADAMANTITE_ORE(ItemID.ADAMANTITE_ORE, Skill.SMITHING, "Ore"),
	RUNITE_ORE(ItemID.RUNITE_ORE, Skill.SMITHING, "Ore"),

	// Bars
	BRONZE_BAR(ItemID.BRONZE_BAR, Skill.SMITHING, "Bars"),
	IRON_BAR(ItemID.IRON_BAR, Skill.SMITHING, "Bars"),
	STEEL_BAR(ItemID.STEEL_BAR, Skill.SMITHING, "Bars"),
	MITHRIL_BAR(ItemID.MITHRIL_BAR, Skill.SMITHING, "Bars"),
	ADAMANTITE_BAR(ItemID.ADAMANTITE_BAR, Skill.SMITHING, "Bars"),
	RUNITE_BAR(ItemID.RUNITE_BAR, Skill.SMITHING, "Bars"),

	/**
	 * Farming Items
	 */
	// Seeds
	ACORN(ItemID.ACORN, Skill.FARMING, "Seeds"),
	WILLOW_SEED(ItemID.WILLOW_SEED, Skill.FARMING, "Seeds"),
	MAPLE_SEED(ItemID.MAPLE_SEED, Skill.FARMING, "Seeds"),
	YEW_SEED(ItemID.YEW_SEED, Skill.FARMING, "Seeds"),
	MAGIC_SEED(ItemID.MAGIC_SEED, Skill.FARMING, "Seeds"),
	APPLE_TREE_SEED(ItemID.APPLE_TREE_SEED, Skill.FARMING, "Seeds"),
	BANANA_TREE_SEED(ItemID.BANANA_TREE_SEED, Skill.FARMING, "Seeds"),
	ORANGE_TREE_SEED(ItemID.ORANGE_TREE_SEED, Skill.FARMING, "Seeds"),
	CURRY_TREE_SEED(ItemID.CURRY_TREE_SEED, Skill.FARMING, "Seeds"),
	PINEAPPLE_SEED(ItemID.PINEAPPLE_SEED, Skill.FARMING, "Seeds"),
	PAPAYA_TREE_SEED(ItemID.PAPAYA_TREE_SEED, Skill.FARMING, "Seeds"),
	PALM_TREE_SEED(ItemID.PALM_TREE_SEED, Skill.FARMING, "Seeds"),
	CALQUAT_TREE_SEED(ItemID.CALQUAT_TREE_SEED, Skill.FARMING, "Seeds"),
	TEAK_SEED(ItemID.TEAK_SEED, Skill.FARMING, "Seeds"),
	MAHOGANY_SEED(ItemID.MAHOGANY_SEED, Skill.FARMING, "Seeds"),
	SPIRIT_SEED(ItemID.SPIRIT_SEED, Skill.FARMING, "Seeds"),

	// Saplings
	OAK_SAPLING(ItemID.OAK_SAPLING, Skill.FARMING, "Saplings"),
	WILLOW_SAPLING(ItemID.WILLOW_SAPLING, Skill.FARMING, "Saplings"),
	MAPLE_SAPLING(ItemID.MAPLE_SAPLING, Skill.FARMING, "Saplings"),
	YEW_SAPLING(ItemID.YEW_SAPLING, Skill.FARMING, "Saplings"),
	MAGIC_SAPLING(ItemID.MAGIC_SAPLING, Skill.FARMING, "Saplings"),
	APPLE_TREE_SAPLING(ItemID.APPLE_SAPLING, Skill.FARMING, "Saplings"),
	BANANA_TREE_SAPLING(ItemID.BANANA_SAPLING, Skill.FARMING, "Saplings"),
	ORANGE_TREE_SAPLING(ItemID.ORANGE_SAPLING, Skill.FARMING, "Saplings"),
	CURRY_TREE_SAPLING(ItemID.CURRY_SAPLING, Skill.FARMING, "Saplings"),
	PINEAPPLE_SAPLING(ItemID.PINEAPPLE_SAPLING, Skill.FARMING, "Saplings"),
	PAPAYA_TREE_SAPLING(ItemID.PAPAYA_SAPLING, Skill.FARMING, "Saplings"),
	PALM_TREE_SAPLING(ItemID.PALM_SAPLING, Skill.FARMING, "Saplings"),
	CALQUAT_TREE_SAPLING(ItemID.CALQUAT_SAPLING, Skill.FARMING, "Saplings"),
	TEAK_SAPLING(ItemID.TEAK_SAPLING, Skill.FARMING, "Saplings"),
	MAHOGANY_SAPLING(ItemID.MAHOGANY_SAPLING, Skill.FARMING, "Saplings"),
	SPIRIT_SAPLING(ItemID.SPIRIT_SAPLING, Skill.FARMING, "Saplings"),
	;

	private final int itemID;
	private final Skill skill;
	private final String category;
	private boolean ignoreBonus;

	@Setter
	// Stores the item composition info we use since we don't operate on the game thread
	private ItemInfo itemInfo = null;

	@Setter
	private Activity selectedActivity;

	private static final Multimap<Skill, CriticalItem> SKILL_MAP = ArrayListMultimap.create();
	private static final Map<Integer, CriticalItem> ITEM_ID_MAP = new HashMap<>();

	static
	{
		for (CriticalItem i : values())
		{
			Skill s = i.getSkill();
			SKILL_MAP.put(s, i);
			ITEM_ID_MAP.put(i.getItemID(), i);
		}
	}

	CriticalItem(int itemID, Skill skill, String category, boolean ignoreBonus)
	{
		this.itemID = itemID;
		this.category = category;
		this.skill = skill;
		this.ignoreBonus = ignoreBonus;
	}

	CriticalItem(int itemID, Skill skill, String category)
	{
		this(itemID, skill, category, false);
	}

	public static Collection<CriticalItem> getBySkill(Skill skill)
	{
		Collection<CriticalItem> items = SKILL_MAP.get(skill);
		if (items == null)
		{
			items = new ArrayList<>();
		}

		return items;
	}

	public static CriticalItem getByItemId(int id)
	{
		return ITEM_ID_MAP.get(id);
	}

	/**
	 * Attaches the Item Composition to each CriticalItem on client initial load
	 *
	 * @param m ItemManager
	 */
	public static void prepareItemDefinitions(ItemManager m)
	{
		for (CriticalItem i : values())
		{
			if (i.itemInfo != null)
			{
				return;
			}

			final ItemDefinition c = m.getItemDefinition(i.getItemID());
			i.itemInfo = new ItemInfo(c.getName(), c.isStackable());
		}
	}
}
