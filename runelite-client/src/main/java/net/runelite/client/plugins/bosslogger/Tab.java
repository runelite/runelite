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

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Tab
{
	// Chest Rewards
	BARROWS("Barrows", "Barrows", ItemID.BARROWS_TELEPORT, 0),
	RAIDS("Raids", "Raids", ItemID.OLMLET, 1),

	// Special Drops  (How loot is dropped)
	ZULRAH("Zulrah", "Zulrah", ItemID.PET_SNAKELING, 2),
	VORKATH("Vorkath", "Vorkath", ItemID.VORKI, 3),

	// Normal Drops (How loot is dropped)
	// God wars dungeon
	ARMADYL("Armadyl", "Kree'arra", ItemID.PET_KREEARRA , 4),
	BANDOS("Bandos", "General Graardor", ItemID.PET_GENERAL_GRAARDOR , 5),
	SARADOMIN("Saradomin", "Commander Zilyana", ItemID.PET_ZILYANA , 6),
	ZAMMY("Zammy", "K'ril Tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH , 7),


	// Wildy Bosses
	VETION("Vet'ion", ItemID.VETION_JR , 8),
	VENENATIS("Venenatis", ItemID.VENENATIS_SPIDERLING , 9),
	CALLISTO("Callisto", ItemID.CALLISTO_CUB , 10),
	CHAOS_ELEMENTAL("Chaos Elemental", ItemID.PET_CHAOS_ELEMENTAL , 11),
	// Wildy Demi-Bosses
	SCORPIA("Scorpia", ItemID.SCORPIAS_OFFSPRING, 12),
	CHAOS_FANATIC("Chaos Fanatic", ItemID.ANCIENT_STAFF , 13),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist", ItemID.FEDORA , 14),
	// Wildy Other
	KING_BLACK_DRAGON("King Black Dragon", ItemID.PRINCE_BLACK_DRAGON , 15),


	// Slayer Bosses
	SKOTIZO("Skotizo", ItemID.SKOTOS, 16),
	GROTESQUE_GUARDIANS("Grotesque Guardians", ItemID.NOON, 17),		// Special Drop
	ABYSSAL_SIRE("Abyssal Sire", ItemID.ABYSSAL_ORPHAN, 18),			// Special Drop
	KRAKEN("Kraken", ItemID.PET_KRAKEN, 19),							// Special Drop
	CERBERUS("Cerberus", ItemID.HELLPUPPY, 20),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil", ItemID.PET_SMOKE_DEVIL, 21),

	// Other Bosses
	GIANT_MOLE("Giant Mole", ItemID.BABY_MOLE, 22),
	KALPHITE_QUEEN("Kalphite Queen", ItemID.KALPHITE_PRINCESS, 23),
	CORPOREAL_BEAST("Corporeal Beast", ItemID.PET_CORPOREAL_CRITTER, 24),
	DAGANNOTH_REX("Dagannoth Rex", ItemID.PET_DAGANNOTH_REX, 25),
	DAGANNOTH_PRIME("Dagannoth Prime", ItemID.PET_DAGANNOTH_PRIME, 26),
	DAGANNOTH_SUPREME("Dagannoth Supreme", ItemID.PET_DAGANNOTH_SUPREME, 27);

	Tab(String name, String bossName, int itemID, int index)
	{
		this.name = name;
		this.bossName = bossName;
		this.itemID = itemID;
		this.index = index;
	}

	Tab(String name, int itemID, int index)
	{
		this.name = name;
		this.bossName = name;
		this.itemID = itemID;
		this.index = index;
	}

	private final String name;
	private final String bossName;
	private final int itemID;
	private final int index;

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
}