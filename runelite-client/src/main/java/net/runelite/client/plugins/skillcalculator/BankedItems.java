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
package net.runelite.client.plugins.skillcalculator;

import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum BankedItems
{
	/*
	 * Construction Items
	 */
	// Planks
	PLANK(ItemID.PLANK, "Planks", Skill.CONSTRUCTION, 29.0),
	OAK_PLANK(ItemID.OAK_PLANK, "Planks", Skill.CONSTRUCTION, 60.0),
	TEAK_PLANK(ItemID.TEAK_PLANK, "Planks", Skill.CONSTRUCTION, 90.0),
	MAHOGANY_PLANK(ItemID.MAHOGANY_PLANK, "Planks", Skill.CONSTRUCTION, 140.0),
	// Logs
	LOGS(ItemID.LOGS, "Logs", Skill.CONSTRUCTION, 29.0),
	OAK_LOGS(ItemID.OAK_LOGS, "Logs", Skill.CONSTRUCTION, 60.0),
	TEAK_LOGS(ItemID.TEAK_LOGS, "Logs", Skill.CONSTRUCTION, 90.0),
	MAHOGANY_LOGS(ItemID.MAHOGANY_LOGS, "Logs", Skill.CONSTRUCTION, 140.0),

	/*
	 * Prayer Items
	 */
	// Bones
	BONES(ItemID.BONES, "Bones", Skill.PRAYER, 4.5),
	WOLF_BONES(ItemID.WOLF_BONES, "Bones", Skill.PRAYER, 4.5),
	BURNT_BONES(ItemID.BURNT_BONES, "Bones", Skill.PRAYER, 4.5),
	MONKEY_BONES(ItemID.MONKEY_BONES, "Bones", Skill.PRAYER, 5.0),
	BAT_BONES(ItemID.BAT_BONES, "Bones", Skill.PRAYER, 5.3),
	JOGRE_BONES(ItemID.JOGRE_BONES, "Bones", Skill.PRAYER, 15.0),
	BIG_BONES(ItemID.BIG_BONES, "Bones", Skill.PRAYER, 15.0),
	ZOGRE_BONES(ItemID.ZOGRE_BONES, "Bones", Skill.PRAYER, 22.5),
	SHAIKAHAN_BONES(ItemID.SHAIKAHAN_BONES, "Bones", Skill.PRAYER, 25.0),
	BABYDRAGON_BONES(ItemID.BABYDRAGON_BONES, "Bones", Skill.PRAYER, 30.0),
	WYVERN_BONES(ItemID.WYVERN_BONES, "Bones", Skill.PRAYER, 72.0),
	DRAGON_BONES(ItemID.DRAGON_BONES, "Bones", Skill.PRAYER, 72.0),
	FAYRG_BONES(ItemID.FAYRG_BONES, "Bones", Skill.PRAYER, 84.0),
	LAVA_DRAGON_BONES(ItemID.LAVA_DRAGON_BONES, "Bones", Skill.PRAYER, 85.0),
	RAURG_BONES(ItemID.RAURG_BONES, "Bones", Skill.PRAYER, 96.0),
	DAGANNOTH_BONES(ItemID.DAGANNOTH_BONES, "Bones", Skill.PRAYER, 125.0),
	OURG_BONES(ItemID.OURG_BONES, "Bones", Skill.PRAYER, 140.0),
	SUPERIOR_DRAGON_BONES(ItemID.SUPERIOR_DRAGON_BONES, "Bones", Skill.PRAYER, 150.0),
	// Shade Remains (Pyre Logs)
	LOAR_REMAINS(ItemID.LOAR_REMAINS, "Shades", Skill.PRAYER, 33.0, true),
	PHRIN_REMAINS(ItemID.PHRIN_REMAINS, "Shades", Skill.PRAYER, 46.5, true),
	RIYL_REMAINS(ItemID.RIYL_REMAINS, "Shades", Skill.PRAYER, 59.5, true),
	ASYN_REMAINS(ItemID.ASYN_REMAINS, "Shades", Skill.PRAYER, 82.5, true),
	FIYR_REMAINS(ItemID.FIYR_REMAINS, "Shades", Skill.PRAYER, 84.0, true),
	// Ensouled Heads
	ENSOULED_GOBLIN_HEAD(ItemID.ENSOULED_GOBLIN_HEAD_13448, "Ensouled Heads", Skill.PRAYER, 130.0, true),
	ENSOULED_MONKEY_HEAD(ItemID.ENSOULED_MONKEY_HEAD_13451, "Ensouled Heads", Skill.PRAYER, 182.0, true),
	ENSOULED_IMP_HEAD(ItemID.ENSOULED_IMP_HEAD_13454, "Ensouled Heads", Skill.PRAYER, 286.0, true),
	ENSOULED_MINOTAUR_HEAD(ItemID.ENSOULED_MINOTAUR_HEAD_13457, "Ensouled Heads", Skill.PRAYER, 364.0, true),
	ENSOULED_SCORPION_HEAD(ItemID.ENSOULED_SCORPION_HEAD_13460, "Ensouled Heads", Skill.PRAYER, 454.0, true),
	ENSOULED_BEAR_HEAD(ItemID.ENSOULED_BEAR_HEAD_13463, "Ensouled Heads", Skill.PRAYER, 480.0, true),
	ENSOULED_UNICORN_HEAD(ItemID.ENSOULED_UNICORN_HEAD_13466, "Ensouled Heads", Skill.PRAYER, 494.0, true),
	ENSOULED_DOG_HEAD(ItemID.ENSOULED_DOG_HEAD_13469, "Ensouled Heads", Skill.PRAYER, 520.0, true),
	ENSOULED_CHAOS_DRUID_HEAD(ItemID.ENSOULED_CHAOS_DRUID_HEAD_13472, "Ensouled Heads", Skill.PRAYER, 584.0, true),
	ENSOULED_GIANT_HEAD(ItemID.ENSOULED_GIANT_HEAD_13475, "Ensouled Heads", Skill.PRAYER, 650.0, true),
	ENSOULED_OGRE_HEAD(ItemID.ENSOULED_OGRE_HEAD_13478, "Ensouled Heads", Skill.PRAYER, 716.0, true),
	ENSOULED_ELF_HEAD(ItemID.ENSOULED_ELF_HEAD_13481, "Ensouled Heads", Skill.PRAYER, 754.0, true),
	ENSOULED_TROLL_HEAD(ItemID.ENSOULED_TROLL_HEAD_13484, "Ensouled Heads", Skill.PRAYER, 780.0, true),
	ENSOULED_HORROR_HEAD(ItemID.ENSOULED_HORROR_HEAD_13487, "Ensouled Heads", Skill.PRAYER, 832.0, true),
	ENSOULED_KALPHITE_HEAD(ItemID.ENSOULED_KALPHITE_HEAD_13490, "Ensouled Heads", Skill.PRAYER, 884.0, true),
	ENSOULED_DAGANNOTH_HEAD(ItemID.ENSOULED_DAGANNOTH_HEAD_13493, "Ensouled Heads", Skill.PRAYER, 936.0, true),
	ENSOULED_BLOODVELD_HEAD(ItemID.ENSOULED_BLOODVELD_HEAD_13496, "Ensouled Heads", Skill.PRAYER, 1040.0, true),
	ENSOULED_TZHAAR_HEAD(ItemID.ENSOULED_TZHAAR_HEAD_13499, "Ensouled Heads", Skill.PRAYER, 1104.0, true),
	ENSOULED_DEMON_HEAD(ItemID.ENSOULED_DEMON_HEAD_13502, "Ensouled Heads", Skill.PRAYER, 1170.0, true),
	ENSOULED_AVIANSIE_HEAD(ItemID.ENSOULED_AVIANSIE_HEAD_13505, "Ensouled Heads", Skill.PRAYER, 1234.0, true),
	ENSOULED_ABYSSAL_HEAD(ItemID.ENSOULED_ABYSSAL_HEAD_13508, "Ensouled Heads", Skill.PRAYER, 1300.0, true),
	ENSOULED_DRAGON_HEAD(ItemID.ENSOULED_DRAGON_HEAD_13511, "Ensouled Heads", Skill.PRAYER, 1560.0, true),

	/*
	 * Cooking Items
	 */
	RAW_HERRING(ItemID.RAW_HERRING, "Fish", Skill.COOKING, 50.0),
	RAW_MACKEREL(ItemID.RAW_MACKEREL, "Fish", Skill.COOKING, 60.0),
	RAW_TROUT(ItemID.RAW_TROUT, "Fish", Skill.COOKING, 70.0),
	RAW_COD(ItemID.RAW_COD, "Fish", Skill.COOKING, 75.0),
	RAW_PIKE(ItemID.RAW_PIKE, "Fish", Skill.COOKING, 80.0),
	RAW_SALMON(ItemID.RAW_SALMON, "Fish", Skill.COOKING, 90.0),
	RAW_TUNA(ItemID.RAW_TUNA, "Fish", Skill.COOKING, 100.0),
	RAW_KARAMBWAN(ItemID.RAW_KARAMBWAN, "Fish", Skill.COOKING, 190.0),
	RAW_LOBSTER(ItemID.RAW_LOBSTER, "Fish", Skill.COOKING, 120.0),
	RAW_BASS(ItemID.RAW_BASS, "Fish", Skill.COOKING, 130.0),
	RAW_SWORDFISH(ItemID.RAW_SWORDFISH, "Fish", Skill.COOKING, 140.0),
	RAW_MONKFISH(ItemID.RAW_MONKFISH, "Fish", Skill.COOKING, 150.0),
	RAW_SHARK(ItemID.RAW_SHARK, "Fish", Skill.COOKING, 210.0),
	RAW_SEA_TURTLE(ItemID.RAW_SEA_TURTLE, "Fish", Skill.COOKING, 211.3),
	RAW_ANGLERFISH(ItemID.RAW_ANGLERFISH, "Fish", Skill.COOKING, 230.0),
	RAW_DARK_CRAB(ItemID.RAW_DARK_CRAB, "Fish", Skill.COOKING, 215.0),
	RAW_MANTA_RAY(ItemID.RAW_MANTA_RAY, "Fish", Skill.COOKING, 216.2),

	/*
	 * Crafting Items
	 */
	// D'hide/Dragon Leather
	GREEN_DRAGONHIDE(ItemID.GREEN_DRAGONHIDE, "D'hide", Skill.CRAFTING, 62.0),
	GREEN_DRAGON_LEATHER(ItemID.GREEN_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 62.0),
	BLUE_DRAGONHIDE(ItemID.BLUE_DRAGONHIDE, "D'hide", Skill.CRAFTING, 70.0),
	BLUE_DRAGON_LEATHER(ItemID.BLUE_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 70.0),
	RED_DRAGONHIDE(ItemID.RED_DRAGONHIDE, "D'hide", Skill.CRAFTING, 78.0),
	RED_DRAGON_LEATHER(ItemID.RED_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 78.0),
	BLACK_DRAGONHIDE(ItemID.BLACK_DRAGONHIDE, "D'hide", Skill.CRAFTING, 86.0),
	BLACK_DRAGON_LEATHER(ItemID.BLACK_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 86.0),
	// Uncut Gems
	UNCUT_OPAL(ItemID.UNCUT_OPAL, "Gems", Skill.CRAFTING, 15.0),
	UNCUT_JADE(ItemID.UNCUT_JADE, "Gems", Skill.CRAFTING, 20.0),
	UNCUT_RED_TOPAZ(ItemID.UNCUT_RED_TOPAZ, "Gems", Skill.CRAFTING, 25.0),
	UNCUT_SAPPHIRE(ItemID.UNCUT_SAPPHIRE, "Gems", Skill.CRAFTING, 50.0),
	UNCUT_EMERALD(ItemID.UNCUT_EMERALD, "Gems", Skill.CRAFTING, 67.5),
	UNCUT_RUBY(ItemID.UNCUT_RUBY, "Gems", Skill.CRAFTING, 85),
	UNCUT_DIAMOND(ItemID.UNCUT_DIAMOND, "Gems", Skill.CRAFTING, 107.5),
	UNCUT_DRAGONSTONE(ItemID.UNCUT_DRAGONSTONE, "Gems", Skill.CRAFTING, 137.5),
	UNCUT_ONYX(ItemID.UNCUT_ONYX, "Gems", Skill.CRAFTING, 167.5),
	UNCUT_ZENYTE(ItemID.UNCUT_ZENYTE, "Gems", Skill.CRAFTING, 200.0),

	/*
	 * Smithing Items
	 */
	BRONZE_BAR(ItemID.BRONZE_BAR, "Bars", Skill.SMITHING, 12.5),
	IRON_BAR(ItemID.IRON_BAR, "Bars", Skill.SMITHING, 25.0),
	STEEL_BAR(ItemID.STEEL_BAR, "Bars", Skill.SMITHING, 37.5),
	//GOLD_ORE(ItemID.GOLD_ORE, "Bars", Skill.SMITHING, 56.2),
	MITHRIL_BAR(ItemID.MITHRIL_BAR, "Bars", Skill.SMITHING, 50.0),
	ADAMANTITE_BAR(ItemID.ADAMANTITE_BAR, "Bars", Skill.SMITHING, 62.5),
	RUNITE_BAR(ItemID.RUNITE_BAR, "Bars", Skill.SMITHING, 75.0);

	@Getter
	private final int itemID;
	@Getter
	private final String category;
	@Getter
	private final Skill skill;
	@Getter
	private final double basexp;
	@Getter
	private final boolean bonusExempt;

	BankedItems(int itemID, String category, Skill skill, double xp)
	{
		this.itemID = itemID;
		this.category = category;
		this.skill = skill;
		this.basexp = xp;
		this.bonusExempt = false;
	}

	BankedItems(int itemID, String category, Skill skill, double xp, boolean exemptFlag)
	{
		this.itemID = itemID;
		this.category = category;
		this.skill = skill;
		this.basexp = xp;
		this.bonusExempt = exemptFlag;
	}

	// Return the items that we should be searching for inside the bank by skill
	// Unused atm
	private static final Map<Skill, ArrayList<BankedItems>> bySkillName = buildSkillItemMap();

	public static ArrayList<BankedItems> getBySkillName(Skill skill)
	{
		return bySkillName.get(skill);
	}

	private static Map<Skill, ArrayList<BankedItems>> buildSkillItemMap()
	{
		Map<Skill, ArrayList<BankedItems>> map = new HashMap<>();
		for (BankedItems item : values())
		{
			map.computeIfAbsent(item.getSkill(), e -> new ArrayList<BankedItems>()).add(item);
		}

		return map;
	}

	// Return the different item categories for this skill
	private static final Map<Skill, Set<String>> bySkillCategory = buildSkillCategoryMap();

	public static Set<String> getSkillCategories(Skill skill)
	{
		return bySkillCategory.get(skill);
	}

	private static Map<Skill, Set<String>> buildSkillCategoryMap()
	{
		Map<Skill, Set<String>> map = new HashMap<>();
		for (BankedItems item : values())
		{
			map.computeIfAbsent(item.getSkill(), k -> new HashSet<String>()).add(item.category);
		}

		return map;
	}

	// Return the items that we should be searching for by skill & category name
	private static final Map<String, ArrayList<BankedItems>> itemsBySkillCategory = buildItemSkillCategoryMap();

	public static ArrayList<BankedItems> getItemsForSkillCategories(Skill skill, String category)
	{
		return itemsBySkillCategory.get(category.replace(" ", "") + skill.getName());
	}

	private static Map<String, ArrayList<BankedItems>> buildItemSkillCategoryMap()
	{
		Map<String, ArrayList<BankedItems>> map = new HashMap<>();
		for (BankedItems item : values())
		{
			String key = item.getCategory().replace(" ", "") + item.skill.getName();
			map.computeIfAbsent(key, e -> new ArrayList<BankedItems>()).add(item);
		}

		return map;
	}
}
