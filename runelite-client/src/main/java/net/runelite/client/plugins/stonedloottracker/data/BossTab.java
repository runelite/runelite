/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.stonedloottracker.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum BossTab
{
	// Chest Rewards
	BARROWS("Barrows", ItemID.BARROWS_TELEPORT, "Other"),
	RAIDS("Chambers of Xeric", ItemID.OLMLET, "Other"),
	RAIDS_2("Theatre of Blood", ItemID.LIL_ZIK, "Other"),

	// Loot received on NPC death
	ZULRAH("Zulrah", ItemID.PET_SNAKELING, "Other"),
	VORKATH("Vorkath", ItemID.VORKI, "Other"),

	// God wars dungeon
	ARMADYL("Kree'arra", ItemID.PET_KREEARRA , "God Wars Dungeon"),
	BANDOS("General Graardor", ItemID.PET_GENERAL_GRAARDOR , "God Wars Dungeon"),
	SARADOMIN("Commander Zilyana", ItemID.PET_ZILYANA , "God Wars Dungeon"),
	ZAMMY("K'ril Tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH , "God Wars Dungeon"),

	// Wildy Bosses
	VETION("Vet'ion", ItemID.VETION_JR , "Wilderness"),
	VENENATIS("Venenatis", ItemID.VENENATIS_SPIDERLING , "Wilderness"),
	CALLISTO("Callisto", ItemID.CALLISTO_CUB , "Wilderness"),
	CHAOS_ELEMENTAL("Chaos Elemental", ItemID.PET_CHAOS_ELEMENTAL , "Wilderness"),
	// Wildy Demi-Bosses
	SCORPIA("Scorpia", ItemID.SCORPIAS_OFFSPRING, "Wilderness"),
	CHAOS_FANATIC("Chaos Fanatic", ItemID.ANCIENT_STAFF , "Wilderness"),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist", ItemID.FEDORA , "Wilderness"),
	// Wildy Other
	KING_BLACK_DRAGON("King Black Dragon", ItemID.PRINCE_BLACK_DRAGON , "Wilderness"),

	// Slayer Bosses
	KALPHITE_QUEEN("Kalphite Queen", ItemID.KALPHITE_PRINCESS, "Other"),
	SKOTIZO("Skotizo", ItemID.SKOTOS, "Slayer"),
	GROTESQUE_GUARDIANS("Dusk", ItemID.NOON, "Slayer"),
	ABYSSAL_SIRE("Abyssal Sire", ItemID.ABYSSAL_ORPHAN, "Slayer"),
	KRAKEN("Kraken", ItemID.PET_KRAKEN, "Slayer"),
	CERBERUS("Cerberus", ItemID.HELLPUPPY, "Slayer"),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil", ItemID.PET_SMOKE_DEVIL, "Slayer"),

	// Other Bosses
	GIANT_MOLE("Giant Mole", ItemID.BABY_MOLE, "Other"),
	CORPOREAL_BEAST("Corporeal Beast", ItemID.PET_CORPOREAL_CRITTER, "Other"),
	// Dagannoth Kings
	DAGANNOTH_REX("Dagannoth Rex", ItemID.PET_DAGANNOTH_REX, "Dagannoth Kings"),
	DAGANNOTH_PRIME("Dagannoth Prime", ItemID.PET_DAGANNOTH_PRIME, "Dagannoth Kings"),
	DAGANNOTH_SUPREME("Dagannoth Supreme", ItemID.PET_DAGANNOTH_SUPREME, "Dagannoth Kings"),

	// Clue scrolls
	CLUE_SCROLL_BEGINNER("Clue Scroll (Beginner)", ItemID.CLUE_SCROLL_BEGINNER, "Clue Scrolls"),
	CLUE_SCROLL_EASY("Clue Scroll (Easy)", ItemID.CLUE_SCROLL_EASY, "Clue Scrolls"),
	CLUE_SCROLL_MEDIUM("Clue Scroll (Medium)", ItemID.CLUE_SCROLL_MEDIUM, "Clue Scrolls"),
	CLUE_SCROLL_HARD("Clue Scroll (Hard)", ItemID.CLUE_SCROLL_HARD, "Clue Scrolls"),
	CLUE_SCROLL_ELITE("Clue Scroll (Elite)", ItemID.CLUE_SCROLL_ELITE, "Clue Scrolls"),
	CLUE_SCROLL_MASTER("Clue Scroll (Master)", ItemID.CLUE_SCROLL_MASTER, "Clue Scrolls"),

	// Hunter
	HERBIBOAR("Herbiboar", ItemID.HERBI, "Hunter");

	BossTab(String name, int iconItem, String category)
	{
		this.name = name;
		this.itemID = iconItem;
		this.category = category;
	}

	private final String name;
	private final int itemID;
	private final String category;

	// By Boss Name
	private static final Map<String, BossTab> byName = buildMap();
	public static BossTab getByName(String name)
	{
		return byName.get(name.toUpperCase());
	}
	private static Map<String, BossTab> buildMap()
	{
		Map<String, BossTab> byName = new HashMap<>();
		for (BossTab tab : values())
		{
			byName.put(tab.getName().toUpperCase(), tab);
		}

		return byName;
	}

	// By Category Name
	private static final Map<String, ArrayList<BossTab>> byCategoryName = buildCategoryMap();
	public static ArrayList<BossTab> getByCategoryName(String name)
	{
		return byCategoryName.get(name.toUpperCase());
	}
	private static Map<String, ArrayList<BossTab>> buildCategoryMap()
	{
		Map<String, ArrayList<BossTab>> map = new HashMap<>();
		for (BossTab tab : values())
		{
			map.computeIfAbsent(tab.getCategory().toUpperCase(), e -> new ArrayList<>()).add(tab);
		}

		return map;
	}

	// All Categories
	public static final Set<String> categories = getCategories();
	private static Set<String> getCategories()
	{
		Set<String> s = new TreeSet<>();
		for (BossTab tab : values())
		{
			s.add(tab.getCategory());
		}
		return s;
	}
}