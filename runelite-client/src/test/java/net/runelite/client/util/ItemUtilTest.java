/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.util;

import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.http.api.loottracker.GameItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemUtilTest
{
	private static final Set<Integer> SOME_IDS = ImmutableSet.of(ItemID.MITHRIL_BAR, ItemID.DRAGON_BONES);
	private static final Set<Integer> WRONG_IDS = ImmutableSet.of(ItemID.SCYTHE_OF_VITUR, ItemID.TWISTED_BOW);
	private static final Set<Integer> MIX_IDS = ImmutableSet.of(
		ItemID.MITHRIL_BAR, ItemID.DRAGON_BONES,
		ItemID.SCYTHE_OF_VITUR, ItemID.TWISTED_BOW
	);

	private static final Map<Integer, GameItem> SOME_MAP = new HashMap<>();
	private static final Map<Integer, GameItem> ALL_MAP = new HashMap<>();

	private static final Item[] items = new Item[6];

	static
	{
		SOME_MAP.put(ItemID.MITHRIL_BAR, new GameItem(ItemID.MITHRIL_BAR, 6));
		SOME_MAP.put(ItemID.DRAGON_BONES, new GameItem(ItemID.DRAGON_BONES, 2));

		ALL_MAP.putAll(SOME_MAP);
		ALL_MAP.put(ItemID.COINS_995, new GameItem(ItemID.COINS_995, 1000));
		ALL_MAP.put(ItemID.CHEWED_BONES, new GameItem(ItemID.CHEWED_BONES, 1));

		items[0] = createItem(ItemID.MITHRIL_BAR, 3);
		items[1] = createItem(ItemID.DRAGON_BONES, 1);
		items[2] = createItem(ItemID.COINS_995, 1000);

		items[3] = createItem(ItemID.MITHRIL_BAR, 3);
		items[4] = createItem(ItemID.DRAGON_BONES, 1);
		items[5] = createItem(ItemID.CHEWED_BONES, 1);
	}

	private static Item createItem(int id, int qty)
	{
		Item i = mock(Item.class);
		when(i.getId())
			.thenReturn(id);
		when(i.getQuantity())
			.thenReturn(qty);

		return i;
	}

	@Test
	public void toGameItemMap()
	{
		Map<Integer, GameItem> itemMap = ItemUtil.toGameItemMap(items, SOME_IDS);
		assertEquals(SOME_MAP, itemMap);
		assertNotEquals(ALL_MAP, itemMap);

		Map<Integer, GameItem> itemMap2 = ItemUtil.toGameItemMap(items);
		assertNotEquals(SOME_MAP, itemMap2);
		assertEquals(ALL_MAP, itemMap2);
	}

	@Test
	public void containsAllItemIds()
	{
		assertTrue(ItemUtil.containsAllItemIds(items, SOME_IDS));
		assertFalse(ItemUtil.containsAllItemIds(items, WRONG_IDS));
		assertFalse(ItemUtil.containsAllItemIds(items, MIX_IDS));
	}

	@Test
	public void containsAnyItemId()
	{
		assertTrue(ItemUtil.containsAnyItemId(items, SOME_IDS));
		assertFalse(ItemUtil.containsAnyItemId(items, WRONG_IDS));
		assertTrue(ItemUtil.containsAnyItemId(items, MIX_IDS));
	}

	@Test
	public void containsItemId()
	{
		assertTrue(ItemUtil.containsItemId(items, ItemID.COINS_995));
		assertFalse(ItemUtil.containsItemId(items, ItemID.TWISTED_BOW));
	}

	@Test
	public void containsAllGameItems()
	{
		assertTrue(ItemUtil.containsAllGameItems(items, SOME_MAP.values()));
		assertTrue(ItemUtil.containsAllGameItems(items, ALL_MAP.values()));

		Collection<GameItem> wrongItems = new ArrayList<>(SOME_MAP.values());
		wrongItems.add(new GameItem(ItemID.TWISTED_BOW, 1));
		assertFalse(ItemUtil.containsAllGameItems(items, wrongItems));

		assertFalse(ItemUtil.containsAllGameItems(items, new GameItem(ItemID.MITHRIL_BAR, 7)));
		assertTrue(ItemUtil.containsAllGameItems(items, new GameItem(ItemID.MITHRIL_BAR, 6)));
		assertTrue(ItemUtil.containsAllGameItems(items, new GameItem(ItemID.MITHRIL_BAR, 5)));
		assertFalse(ItemUtil.containsAllGameItems(items, new GameItem(ItemID.MITHRIL_BAR, 5), new GameItem(ItemID.TWISTED_BOW, 1)));
	}
}
