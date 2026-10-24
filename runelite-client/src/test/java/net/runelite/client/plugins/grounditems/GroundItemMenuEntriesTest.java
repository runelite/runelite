/*
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
package net.runelite.client.plugins.grounditems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.menus.TestMenuEntry;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class GroundItemMenuEntriesTest
{
	@Test
	public void testKeepsLastDuplicateAndMenuOrder()
	{
		MenuEntry first = entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1);
		MenuEntry walk = entry(MenuAction.WALK, 0);
		MenuEntry last = entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1);
		MenuEntry examine = entry(MenuAction.EXAMINE_ITEM_GROUND, 1);
		MenuEntry[] collapsed = GroundItemsPlugin.collapseEntries(new MenuEntry[]{first, walk, last, examine});
		assertArrayEquals(new MenuEntry[]{walk, last, examine}, collapsed);
		assertSame(last, collapsed[1]);
		assertEquals("Item 1 x 2", last.getTarget());
		assertEquals("Item 1", first.getTarget());
	}

	@Test
	public void testOnlyCollapsesGroundActions()
	{
		for (MenuAction action : new MenuAction[]{MenuAction.GROUND_ITEM_FIRST_OPTION,
			MenuAction.GROUND_ITEM_SECOND_OPTION, MenuAction.GROUND_ITEM_THIRD_OPTION,
			MenuAction.GROUND_ITEM_FOURTH_OPTION, MenuAction.GROUND_ITEM_FIFTH_OPTION,
			MenuAction.EXAMINE_ITEM_GROUND})
		{
			MenuEntry last = entry(action, 1);
			MenuEntry[] collapsed = GroundItemsPlugin.collapseEntries(new MenuEntry[]{entry(action, 1), last});
			assertEquals(1, collapsed.length);
			assertSame(last, collapsed[0]);
			assertEquals("Item 1 x 2", last.getTarget());
		}

		MenuEntry[] entries = {entry(MenuAction.WALK, 1), entry(MenuAction.WALK, 1),
			entry(MenuAction.WIDGET_TARGET_ON_GROUND_ITEM, 1), entry(MenuAction.WIDGET_TARGET_ON_GROUND_ITEM, 1)};
		assertArrayEquals(entries, GroundItemsPlugin.collapseEntries(entries));
	}

	@Test
	public void testDistinctActionMetadataIsPreserved()
	{
		MenuEntry[] entries = {
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 2),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setParam0(2),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setParam1(2),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setItemId(2),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setWorldViewId(2),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setForceLeftClick(true),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setDeprioritized(true),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setOption("Different"),
			entry(MenuAction.GROUND_ITEM_THIRD_OPTION, 1).setTarget("Different")
		};
		assertArrayEquals(entries, GroundItemsPlugin.collapseEntries(entries));
	}

	@Test
	public void testHashCollisionsStillCheckEquality()
	{
		MenuEntry[] entries = new MenuEntry[35];
		for (int i = 0; i < entries.length; i++)
		{
			entries[i] = new TestMenuEntry()
			{
				@Override
				public int hashCode()
				{
					return 1;
				}
			}.setType(MenuAction.GROUND_ITEM_THIRD_OPTION).setIdentifier(i % 34)
				.setOption("Take").setTarget("Item");
		}
		MenuEntry[] collapsed = GroundItemsPlugin.collapseEntries(entries);
		assertArrayEquals(Arrays.copyOfRange(entries, 1, entries.length), collapsed);
		assertEquals("Item x 2", entries[34].getTarget());
	}

	@Test
	public void testMatchesOriginalCollapse()
	{
		MenuAction[] actions = {MenuAction.WALK, MenuAction.RUNELITE, MenuAction.GROUND_ITEM_THIRD_OPTION,
			MenuAction.EXAMINE_ITEM_GROUND, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM};
		Random random = new Random(0xC011A95E);
		for (int iteration = 0; iteration < 100; iteration++)
		{
			int size = random.nextInt(501);
			MenuEntry[] original = new MenuEntry[size];
			MenuEntry[] optimized = new MenuEntry[size];
			for (int i = 0; i < size; i++)
			{
				MenuAction action = actions[random.nextInt(actions.length)];
				int id = random.nextInt(20);
				int x = random.nextInt(3);
				int worldView = random.nextInt(2);
				original[i] = entry(action, id).setParam0(x).setWorldViewId(worldView);
				optimized[i] = entry(action, id).setParam0(x).setWorldViewId(worldView);
			}
			assertArrayEquals(originalCollapse(original), GroundItemsPlugin.collapseEntries(optimized));
		}
		assertEquals(0, GroundItemsPlugin.collapseEntries(new MenuEntry[0]).length);
	}

	private static MenuEntry entry(MenuAction action, int id)
	{
		return new TestMenuEntry().setOption("Option").setTarget("Item " + id)
			.setIdentifier(id).setType(action).setParam0(1).setParam1(1);
	}

	private static MenuEntry[] originalCollapse(MenuEntry[] menuEntries)
	{
		List<MenuEntryWithCount> entries = new ArrayList<>();
		outer:
		for (int i = menuEntries.length - 1; i >= 0; i--)
		{
			MenuEntry candidate = menuEntries[i];
			MenuAction action = candidate.getType();
			if (action == MenuAction.GROUND_ITEM_FIRST_OPTION || action == MenuAction.GROUND_ITEM_SECOND_OPTION
				|| action == MenuAction.GROUND_ITEM_THIRD_OPTION || action == MenuAction.GROUND_ITEM_FOURTH_OPTION
				|| action == MenuAction.GROUND_ITEM_FIFTH_OPTION || action == MenuAction.EXAMINE_ITEM_GROUND)
			{
				for (MenuEntryWithCount retained : entries)
				{
					if (retained.getEntry().equals(candidate))
					{
						retained.increment();
						continue outer;
					}
				}
			}
			entries.add(new MenuEntryWithCount(candidate));
		}
		Collections.reverse(entries);
		return entries.stream().map(e ->
		{
			MenuEntry entry = e.getEntry();
			if (e.getCount() > 1)
			{
				entry.setTarget(entry.getTarget() + " x " + e.getCount());
			}
			return entry;
		}).toArray(MenuEntry[]::new);
	}
}
