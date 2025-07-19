/*
 * Copyright (c) 2020, Adam <Adam@sigterm.info>
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

import java.util.Arrays;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.loottracker.LootRecordType;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class LootTrackerBoxTest
{
	@Test
	public void testAddKill()
	{
		LootTrackerBox lootTrackerBox = new LootTrackerBox(
			mock(ItemManager.class),
			"Theatre of Blood",
			LootRecordType.EVENT,
			null,
			false,
			LootTrackerPriceType.GRAND_EXCHANGE,
			false,
			null, null,
			false);

		LootTrackerItem[] items = new LootTrackerItem[]{
			new LootTrackerItem(ItemID.TRAIL_CLUE_MEDIUM_SEXTANT001, "Clue scroll (medium)", 1, 0, 0, false),
			new LootTrackerItem(ItemID.TRAIL_CLUE_MEDIUM_MAP007, "Clue scroll (medium)", 1, 0, 0, false),
			new LootTrackerItem(ItemID.ZEAH_GRACEFUL_HOOD_ARCEUUS, "Graceful hood", 1, 0, 0, false),
		};
		LootTrackerRecord lootTrackerRecord = new LootTrackerRecord(
			"Theatre of Blood",
			null,
			LootRecordType.EVENT,
			items,
			42
		);

		lootTrackerBox.addKill(lootTrackerRecord);

		assertEquals(Arrays.asList(
			new LootTrackerItem(ItemID.TRAIL_CLUE_MEDIUM_SEXTANT001, "Clue scroll (medium)", 2, 0, 0, false),
			new LootTrackerItem(ItemID.ZEAH_GRACEFUL_HOOD_ARCEUUS, "Graceful hood", 1, 0, 0, false)
		), lootTrackerBox.getItems());
	}
}