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
package net.runelite.client.plugins.lootrecorder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
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
	ZAMMY("Zammy", "K'ril Tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH , 7);

	/*
	// Wildy Bosses
	VETION("Vet'ion", ItemID.VETION_JR , 4),
	VENENATIS("Venenatis", ItemID.VENENATIS_SPIDERLING , 5),
	CALLISTO("Callisto", ItemID.CALLISTO_CUB , 6),
	// Wildy Demi-Bosses
	SCORPIA("Scorpia", ItemID.SCORPIAS_OFFSPRING , 7),
	CHAOS_FANATIC("Chaos Fanatic", ItemID.PET_CHAOS_ELEMENTAL , 8),
	CRAZED_ARCHAEOLOGIST("Crazed Archaeologist", ItemID.FEDORA , 11),
	// Wildy Other
	CHAOS_ELEMENTAL("Chaos Elemental", ItemID.PET_CHAOS_ELEMENTAL , 9),
	KING_BLACK_DRAGON("King Black Dragon", ItemID.PRINCE_BLACK_DRAGON , 10),
	aa("", ItemID. , 4);
	*/

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
}