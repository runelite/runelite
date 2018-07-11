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
package net.runelite.client.plugins.bosslogger;

import lombok.Getter;
import net.runelite.api.ItemID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Getter
public enum Tab
{
	// Chest Rewards
	BARROWS("Barrows", ItemID.BARROWS_TELEPORT, "Other"),
	RAIDS("Raids", ItemID.OLMLET, "Other"),
	RAIDS_2("Raids 2", ItemID.LIL_ZIK, "Other"),

	// Loot received on NPC death
	// Special Drops  (How loot is dropped)
	ZULRAH("Zulrah", ItemID.PET_SNAKELING, "Other", WatchNpcs.ZULRAH),
	VORKATH("Vorkath", ItemID.VORKI, "Other", WatchNpcs.VORKATH),

	// Normal Drops (How loot is dropped)
	// God wars dungeon
	ARMADYL("Armadyl", ItemID.PET_KREEARRA , "God Wars Dungeon", WatchNpcs.ARMADYL),
	BANDOS("Bandos", ItemID.PET_GENERAL_GRAARDOR , "God Wars Dungeon", WatchNpcs.BANDOS),
	SARADOMIN("Saradomin", ItemID.PET_ZILYANA , "God Wars Dungeon", WatchNpcs.SARADOMIN),
	ZAMMY("Zammy", ItemID.PET_KRIL_TSUTSAROTH , "God Wars Dungeon", WatchNpcs.ZAMMY),

	// Wildy Bosses
	VETION("Vet'ion", ItemID.VETION_JR , "Wilderness", WatchNpcs.VETION),
	VENENATIS("Venenatis", ItemID.VENENATIS_SPIDERLING , "Wilderness", WatchNpcs.VENENATIS),
	CALLISTO("Callisto", ItemID.CALLISTO_CUB , "Wilderness", WatchNpcs.CALLISTO),
	CHAOS_ELEMENTAL("Chaos Elemental", ItemID.PET_CHAOS_ELEMENTAL , "Wilderness", WatchNpcs.CHAOS_ELEMENTAL),
	// Wildy Demi-Bosses
	SCORPIA("Scorpia", ItemID.SCORPIAS_OFFSPRING, "Wilderness", WatchNpcs.SCORPIA),
	CHAOS_FANATIC("Chaos Fanatic", ItemID.ANCIENT_STAFF , "Wilderness", WatchNpcs.CHAOS_FANATIC),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist", ItemID.FEDORA , "Wilderness", WatchNpcs.CRAZY_ARCHAEOLOGIST),
	// Wildy Other
	KING_BLACK_DRAGON("King Black Dragon", ItemID.PRINCE_BLACK_DRAGON , "Wilderness", WatchNpcs.KING_BLACK_DRAGON),

	// Slayer Bosses
	KALPHITE_QUEEN("Kalphite Queen", ItemID.KALPHITE_PRINCESS, "Other", WatchNpcs.KALPHITE_QUEEN),
	SKOTIZO("Skotizo", ItemID.SKOTOS, "Slayer", WatchNpcs.SKOTIZO),
	GROTESQUE_GUARDIANS("Grotesque Guardians", ItemID.NOON, "Slayer", WatchNpcs.GROTESQUE_GUARDIANS),
	ABYSSAL_SIRE("Abyssal Sire", ItemID.ABYSSAL_ORPHAN, "Slayer", WatchNpcs.ABYSSAL_SIRE),
	KRAKEN("Kraken", ItemID.PET_KRAKEN, "Slayer", WatchNpcs.KRAKEN),
	CERBERUS("Cerberus", ItemID.HELLPUPPY, "Slayer", WatchNpcs.CERBERUS),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil", ItemID.PET_SMOKE_DEVIL, "Slayer", WatchNpcs.THERMONUCLEAR_SMOKE_DEVIL),

	// Other Bosses
	GIANT_MOLE("Giant Mole", ItemID.BABY_MOLE, "Other", WatchNpcs.GIANT_MOLE),
	CORPOREAL_BEAST("Corporeal Beast", ItemID.PET_CORPOREAL_CRITTER, "Other", WatchNpcs.CORPOREAL_BEAST),
	// Dagannoth Kings
	DAGANNOTH_REX("Dagannoth Rex", ItemID.PET_DAGANNOTH_REX, "Dagannoth Kings", WatchNpcs.DAGANNOTH_REX),
	DAGANNOTH_PRIME("Dagannoth Prime", ItemID.PET_DAGANNOTH_PRIME, "Dagannoth Kings", WatchNpcs.DAGANNOTH_PRIME),
	DAGANNOTH_SUPREME("Dagannoth Supreme", ItemID.PET_DAGANNOTH_SUPREME, "Dagannoth Kings", WatchNpcs.DAGANNOTH_SUPREME),

	// Clue scrolls
	CLUE_SCROLL_EASY("Clue Scroll Easy", ItemID.CLUE_BOTTLE_EASY, "Clue Scrolls"),
	CLUE_SCROLL_MEDIUM("Clue Scroll Medium", ItemID.CLUE_BOTTLE_MEDIUM, "Clue Scrolls"),
	CLUE_SCROLL_HARD("Clue Scroll Hard", ItemID.CLUE_BOTTLE_HARD, "Clue Scrolls"),
	CLUE_SCROLL_ELITE("Clue Scroll Elite", ItemID.CLUE_BOTTLE_ELITE, "Clue Scrolls"),
	CLUE_SCROLL_MASTER("Clue Scroll Master", ItemID.BLOODHOUND, "Clue Scrolls");

	Tab(String name, int iconItem, String category)
	{
		this.name = name;
		this.itemID = iconItem;
		this.category = category;
		this.bossName = name;
		this.watchNpcs = null;
	}

	Tab(String name, int iconItem, String category, WatchNpcs npcs)
	{
		this.name = name;
		this.itemID = iconItem;
		this.category = category;
		this.bossName = npcs.getName();
		this.watchNpcs = npcs;
	}

	private final String name;
	private final String bossName;
	private final int itemID;
	private final String category;
	private final WatchNpcs watchNpcs;

	private static final Map<String, Tab> byName = buildMap();

	public static Tab getByName(String name)
	{
		return byName.get(name.toUpperCase());
	}

	private static Map<String, Tab> buildMap()
	{
		Map<String, Tab> byName = new HashMap<>();
		for (Tab tab : values())
		{
			byName.put(tab.getName().toUpperCase(), tab);
		}

		return byName;
	}

	private static final Map<String, Tab> byBossName = buildBossMap();

	public static Tab getByBossName(String name)
	{
		return byBossName.get(name.toUpperCase());
	}

	private static Map<String, Tab> buildBossMap()
	{
		Map<String, Tab> byName = new HashMap<>();
		for (Tab tab : values())
		{
			byName.put(tab.getBossName().toUpperCase(), tab);
		}

		return byName;
	}

	private static final Map<String, ArrayList<Tab>> byCategoryName = buildCategoryMap();

	public static ArrayList<Tab> getByCategoryName(String name)
	{
		return byCategoryName.get(name.toUpperCase());
	}

	private static Map<String, ArrayList<Tab>> buildCategoryMap()
	{
		Map<String, ArrayList<Tab>> map = new HashMap<>();
		for (Tab tab : values())
		{
			map.computeIfAbsent(tab.getCategory().toUpperCase(), e -> new ArrayList<Tab>()).add(tab);
		}

		return map;
	}

	public static final Set<String> categories = getCategories();
	private static Set<String> getCategories()
	{
		Set<String> s = new TreeSet<String>();
		for (Tab tab : values())
		{
			s.add(tab.getCategory());
		}
		return s;
	}
}