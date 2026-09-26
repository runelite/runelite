/*
 * Copyright (c) 2026, Jonathan Garelick <https://github.com/jonathangarelick>
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

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.loottracker.LootRecordType;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LootTrackerPanelTest
{
	@Mock
	private LootTrackerPlugin plugin;

	@Mock
	private ItemManager itemManager;

	@Mock
	private LootTrackerConfig config;

	private LootTrackerPanel panel;

	@Before
	public void before() throws Exception
	{
		// the loot boxes aren't under test, so hide every event to avoid building them
		when(plugin.isEventIgnored(anyString())).thenReturn(true);
		SwingUtilities.invokeAndWait(() -> panel = new LootTrackerPanel(plugin, itemManager, config));
	}

	@Test
	public void testRemoveKill()
	{
		panel.add("Goblin", LootRecordType.NPC, 2, new LootTrackerItem[]{bones(1), coins(5)}, 1);
		panel.add("Goblin", LootRecordType.NPC, 2, new LootTrackerItem[]{bones(1), coins(10)}, 1);
		panel.add("Goblin", LootRecordType.NPC, 2, new LootTrackerItem[]{bones(1)}, 1);
		panel.add("Cow", LootRecordType.NPC, 2, new LootTrackerItem[]{cowhide(1)}, 1);

		List<LootTrackerRecord> session = new ArrayList<>(panel.getSessionRecords());
		panel.removeKill(session.get(1));

		// only the removed kill is gone from the session records
		List<LootTrackerRecord> remaining = new ArrayList<>(panel.getSessionRecords());
		assertEquals(3, remaining.size());
		assertSame(session.get(0), remaining.get(0));
		assertSame(session.get(2), remaining.get(1));
		assertSame(session.get(3), remaining.get(2));

		// and its loot is removed from the aggregate
		LootTrackerRecord goblin = aggregate("Goblin");
		assertEquals(2, goblin.getKills());
		assertArrayEquals(new LootTrackerItem[]{bones(2), coins(5)}, goblin.getItems());

		LootTrackerRecord cow = aggregate("Cow");
		assertEquals(1, cow.getKills());
		assertArrayEquals(new LootTrackerItem[]{cowhide(1)}, cow.getItems());
	}

	@Test
	public void testRemoveOnlyKill()
	{
		panel.add("Goblin", LootRecordType.NPC, 2, new LootTrackerItem[]{bones(1)}, 1);

		panel.removeKill(panel.getSessionRecords().getFirst());

		assertTrue(panel.getSessionRecords().isEmpty());
		assertFalse(panel.hasRecord(LootRecordType.NPC, "Goblin"));
	}

	@Test
	public void testSessionRecordNotMutatedByMerge()
	{
		panel.add("Goblin", LootRecordType.NPC, 2, new LootTrackerItem[]{bones(1)}, 1);
		panel.add("Goblin", LootRecordType.NPC, 2, new LootTrackerItem[]{bones(1)}, 1);

		for (LootTrackerRecord record : panel.getSessionRecords())
		{
			assertArrayEquals(new LootTrackerItem[]{bones(1)}, record.getItems());
		}
		assertArrayEquals(new LootTrackerItem[]{bones(2)}, aggregate("Goblin").getItems());
	}

	private LootTrackerRecord aggregate(String name)
	{
		return panel.getAggregateRecords().get(new LootTrackerRecord(name, null, LootRecordType.NPC, null, 0));
	}

	private static LootTrackerItem bones(int qty)
	{
		return new LootTrackerItem(ItemID.BONES, "Bones", qty, 50, 1, false);
	}

	private static LootTrackerItem coins(int qty)
	{
		return new LootTrackerItem(ItemID.COINS, "Coins", qty, 1, 1, false);
	}

	private static LootTrackerItem cowhide(int qty)
	{
		return new LootTrackerItem(ItemID.COW_HIDE, "Cowhide", qty, 100, 1, false);
	}
}
