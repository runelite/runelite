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
	BARROWS("Barrows", "Barrows", ItemID.BARROWS_TELEPORT, "Other"),
	RAIDS("Raids", "Raids", ItemID.OLMLET, "Other"),
	RAIDS_2("Raids 2", "Raids 2", 22473, "Other"),

	// Special Drops  (How loot is dropped)
	ZULRAH("Zulrah", "Zulrah", ItemID.PET_SNAKELING, "Other"),
	VORKATH("Vorkath", "Vorkath", ItemID.VORKI, "Other"),

	// Normal Drops (How loot is dropped)
	// God wars dungeon
	ARMADYL("Armadyl", "Kree'arra", ItemID.PET_KREEARRA , "God Wars Dungeon"),
	BANDOS("Bandos", "General Graardor", ItemID.PET_GENERAL_GRAARDOR , "God Wars Dungeon"),
	SARADOMIN("Saradomin", "Commander Zilyana", ItemID.PET_ZILYANA , "God Wars Dungeon"),
	ZAMMY("Zammy", "K'ril Tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH , "God Wars Dungeon"),


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
	GROTESQUE_GUARDIANS("Grotesque Guardians", ItemID.NOON, "Slayer"),		// Special Drop
	ABYSSAL_SIRE("Abyssal Sire", ItemID.ABYSSAL_ORPHAN, "Slayer"),			// Special Drop
	KRAKEN("Kraken", ItemID.PET_KRAKEN, "Slayer"),							// Special Drop
	CERBERUS("Cerberus", ItemID.HELLPUPPY, "Slayer"),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil", ItemID.PET_SMOKE_DEVIL, "Slayer"),

	// Other Bosses
	GIANT_MOLE("Giant Mole", ItemID.BABY_MOLE, "Other"),
	CORPOREAL_BEAST("Corporeal Beast", ItemID.PET_CORPOREAL_CRITTER, "Other"),
	// Dagannoth Kings
	DAGANNOTH_REX("Dagannoth Rex", ItemID.PET_DAGANNOTH_REX, "Dagannoth Kings"),
	DAGANNOTH_PRIME("Dagannoth Prime", ItemID.PET_DAGANNOTH_PRIME, "Dagannoth Kings"),
	DAGANNOTH_SUPREME("Dagannoth Supreme", ItemID.PET_DAGANNOTH_SUPREME, "Dagannoth Kings");

	Tab(String name, String bossName, int itemID, String category)
	{
		this.name = name;
		this.bossName = bossName;
		this.itemID = itemID;
		this.category = category;
	}

	Tab(String name, int itemID, String category)
	{
		this.name = name;
		this.bossName = name;
		this.itemID = itemID;
		this.category = category;
	}

	private final String name;
	private final String bossName;
	private final int itemID;
	private final String category;

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

	public int getIndex()
	{
		return -1;
	}
}