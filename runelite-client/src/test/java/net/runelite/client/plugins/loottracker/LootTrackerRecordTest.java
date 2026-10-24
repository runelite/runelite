/*
 * Copyright (c) 2026, Chris Hassell <chrisjameshassell@gmail.com>
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

import net.runelite.api.gameval.ItemID;
import net.runelite.http.api.loottracker.LootRecordType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LootTrackerRecordTest
{
	private static final LootTrackerRecord BARROWS = new LootTrackerRecord("Barrows", "", LootRecordType.EVENT, new LootTrackerItem[]{
		new LootTrackerItem(ItemID.COINS, "Coins", 3_000, 1, 0, false),
		new LootTrackerItem(ItemID.DEATHRUNE, "Death rune", 150, 200, 108, false),
		new LootTrackerItem(ItemID.BARROWS_DHAROK_HEAD, "Dharok's helm", 1, 1_000_000, 60_000, false),
	}, 3);

	private static final LootTrackerRecord HILL_GIANT = new LootTrackerRecord("Hill Giant", "(lvl-28)", LootRecordType.NPC, new LootTrackerItem[]{
		new LootTrackerItem(ItemID.BIG_BONES, "Big bones", 2, 300, 0, false),
		new LootTrackerItem(ItemID.UNCUT_RUBY, "Uncut ruby", 1, 900, 60, false),
	}, 2);

	private static final LootTrackerRecord MOSS_GIANT = new LootTrackerRecord("Moss giant", "(lvl-42)", LootRecordType.NPC, new LootTrackerItem[]{
		new LootTrackerItem(ItemID.BIG_BONES, "Big bones", 1, 300, 0, false),
		new LootTrackerItem(ItemID.UNCUT_SAPPHIRE, "Uncut sapphire", 1, 300, 30, false),
	}, 1);

	@Test
	public void testMatchesSearchEmpty()
	{
		assertTrue(BARROWS.matchesSearch(null, true));
		assertTrue(BARROWS.matchesSearch("", true));
		assertTrue(HILL_GIANT.matchesSearch("", false));
	}

	@Test
	public void testMatchesSearchTitle()
	{
		assertTrue(BARROWS.matchesSearch("Barrows", true));
		assertTrue(BARROWS.matchesSearch("barrows", true));
		assertTrue(BARROWS.matchesSearch("BARR", true));
		assertTrue(HILL_GIANT.matchesSearch("hill g", true));

		assertFalse(HILL_GIANT.matchesSearch("Barrows", true));
		assertFalse(MOSS_GIANT.matchesSearch("Barrows", true));
	}

	@Test
	public void testMatchesSearchItemName()
	{
		assertTrue(HILL_GIANT.matchesSearch("Uncut ruby", true));
		assertTrue(HILL_GIANT.matchesSearch("uncut RUBY", true));
		assertFalse(BARROWS.matchesSearch("Uncut ruby", true));
		assertFalse(MOSS_GIANT.matchesSearch("Uncut ruby", true));

		// partial item names
		assertTrue(BARROWS.matchesSearch("dharok", true));
		assertTrue(HILL_GIANT.matchesSearch("uncut", true));
		assertTrue(MOSS_GIANT.matchesSearch("uncut", true));
		assertFalse(BARROWS.matchesSearch("uncut", true));

		// the search is for a single phrase, not independent words
		assertFalse(MOSS_GIANT.matchesSearch("uncut bones", true));
	}

	@Test
	public void testMatchesSearchIgnoredItems()
	{
		final LootTrackerRecord record = new LootTrackerRecord("Guard", "(lvl-21)", LootRecordType.NPC, new LootTrackerItem[]{
			new LootTrackerItem(ItemID.COINS, "Coins", 30, 1, 0, false),
			new LootTrackerItem(ItemID.UNCUT_RUBY, "Uncut ruby", 1, 900, 60, true),
		}, 1);

		// ignored items are only searched when they are being shown
		assertFalse(record.matchesSearch("Uncut ruby", true));
		assertTrue(record.matchesSearch("Uncut ruby", false));

		assertTrue(record.matchesSearch("Coins", true));
		assertTrue(record.matchesSearch("Guard", true));
	}

	@Test
	public void testMatchesSearchIgnoresTitleTags()
	{
		final LootTrackerRecord record = new LootTrackerRecord("<col=ff0000>Scurrius</col>", "", LootRecordType.NPC, new LootTrackerItem[0], 1);

		assertTrue(record.matchesSearch("scurrius", true));
		assertFalse(record.matchesSearch("col", true));
	}
}
