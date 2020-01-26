/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.loottracker;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
enum LootEvent
{
	BARROWS("Barrows"),
	BRIMSTONE_CHEST("Brimstone Chest"),
	CHAMBERS_OF_XERIC("Chambers of Xeric"),
	CLUE_SCROLL_BEGINNER("Clue Scroll (Beginner)"),
	CLUE_SCROLL_EASY("Clue Scroll (Easy)"),
	CLUE_SCROLL_MEDIUM("Clue Scroll (Medium)"),
	CLUE_SCROLL_HARD("Clue Scroll (Hard)"),
	CLUE_SCROLL_ELITE("Clue Scroll (Elite)"),
	CLUE_SCROLL_MASTER("Clue Scroll (Master)"),
	CRYSTAL_CHEST("Crystal Chest"),
	ELVEN_CRYSTAL_CHEST("Elven Crystal Chest"),
	FISHING_TRAWLER("Fishing Trawler"),
	GAUNTLET("The Gauntlet"),
	HESPORI("Hespori"),
	HERBIBOAR("Herbiboar"),
	KINGDOM_OF_MISCELLANIA("Kingdom of Miscellania"),
	LARRANS_CHEST_BIG("Larran's big chest"),
	LARRANS_CHEST_SMALL("Larran's small chest"),
	// Pickpocket-able NPCs who give loot other than coin pouches
	PICKPOCKET_BANDIT("Bandit (Pickpocket)"),
	PICKPOCKET_CAVE_GOBLIN("Cave Goblin (Pickpocket)"),
	PICKPOCKET_ELF("Elf (Pickpocket)"),
	PICKPOCKET_GNOME("Gnome (Pickpocket)"),
	PICKPOCKET_HAM_MEMBER("H.A.M. Member (Pickpocket)"),
	PICKPOCKET_HERO("Hero (Pickpocket)"),
	PICKPOCKET_MASTER_FARMER("Master Farmer (Pickpocket)"),
	PICKPOCKET_ROGUE("Rogue (Pickpocket)"),
	PICKPOCKET_TZHAAR_HUR("TzHaar-Hur (Pickpocket)"),
	THEATRE_OF_BLOOD("Theatre of Blood");

	@Getter
	private final String name;

	static final Map<Integer, LootEvent> CHEST_EVENT_LOOKUP_TABLE = ImmutableMap.of(
		5179, LootEvent.BRIMSTONE_CHEST,
		11573, LootEvent.CRYSTAL_CHEST,
		12093, LootEvent.LARRANS_CHEST_BIG,
		13113, LootEvent.LARRANS_CHEST_SMALL,
		13151, LootEvent.ELVEN_CRYSTAL_CHEST
	);

	static final Map<String, LootEvent> PICKPOCKET_EVENT_LOOKUP_TABLE = ImmutableMap.<String, LootEvent>builder()
		.put("Master Farmer", PICKPOCKET_MASTER_FARMER)
		.put("Martin", PICKPOCKET_MASTER_FARMER)
		.put("TzHaar-Hur", PICKPOCKET_TZHAAR_HUR)
		.put("Elf", PICKPOCKET_ELF)
		.put("Hero", PICKPOCKET_HERO)
		.put("Gnome", PICKPOCKET_GNOME)
		.put("Bandit", PICKPOCKET_BANDIT)
		.put("Cave Goblin", PICKPOCKET_CAVE_GOBLIN)
		.put("Rogue", PICKPOCKET_ROGUE)
		.put("H.A.M. Member", PICKPOCKET_HAM_MEMBER)
		.build();

	static final List<LootEvent> DIRECT_TO_INVENTORY_EVENTS = ImmutableList.<LootEvent>builder()
		.add(HERBIBOAR, HESPORI, GAUNTLET)
		.addAll(CHEST_EVENT_LOOKUP_TABLE.values())
		.addAll(PICKPOCKET_EVENT_LOOKUP_TABLE.values())
		.build();

	static final Map<String, LootEvent> CLUE_SCROLL_LOOKUP_TABLE = ImmutableMap.<String, LootEvent>builder()
		.put("beginner", CLUE_SCROLL_BEGINNER)
		.put("easy", CLUE_SCROLL_EASY)
		.put("medium", CLUE_SCROLL_MEDIUM)
		.put("hard", CLUE_SCROLL_HARD)
		.put("elite", CLUE_SCROLL_ELITE)
		.put("master", CLUE_SCROLL_MASTER)
		.build();
}
