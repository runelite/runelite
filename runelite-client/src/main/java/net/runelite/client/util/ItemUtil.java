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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import net.runelite.api.Item;
import net.runelite.http.api.loottracker.GameItem;

/**
 * Utility class for Item arrays.
 */
public class ItemUtil
{
	/**
	 * Converts itemArray into a GameItem collection limited to the passed ids
	 * Consolidates all matching Item's qty, by id
	 * @param itemArray item array to work on
	 * @param ids item ids to include in result
	 * @return Map of GameItem by item id
	 */
	public static Map<Integer, GameItem> toGameItemMap(Item[] itemArray, @Nullable Set<Integer> ids)
	{
		final Map<Integer, GameItem> map = new HashMap<>();
		for (Item i : itemArray)
		{
			final int id = i.getId();
			if (ids == null || ids.contains(id))
			{
				int qty = i.getQuantity();
				if (map.containsKey(id))
				{
					qty += map.get(id).getQty();
				}
				map.put(id, new GameItem(id, qty));
			}
		}

		return map;
	}

	/**
	 * Converts itemArray into a GameItem collection
	 * Consolidates all matching Item's qty, by id
	 * @param itemArray item array to work on
	 * @return Map of GameItem by item id
	 */
	public static Map<Integer, GameItem> toGameItemMap(Item[] itemArray)
	{
		return toGameItemMap(itemArray, null);
	}

	/**
	 * Checks that the itemArray contains the all of the requested ids
	 * @param itemArray item array to work on
	 * @param ids item ids to check for
	 * @return true if itemArray contains all requested item ids
	 */
	public static boolean containsAllItemIds(Item[] itemArray, Set<Integer> ids)
	{
		final Set<Integer> found = new HashSet<>();
		for (Item i : itemArray)
		{
			final int id = i.getId();
			if (ids.contains(id))
			{
				found.add(id);
				// Early break if possible
				if (found.size() == ids.size())
				{
					return true;
				}
			}

		}

		return found.size() == ids.size();
	}

	/**
	 * Checks if itemArray contains any item id that also exists in ids
	 * @param itemArray item array to work on
	 * @param ids item ids to check for
	 * @return true if any item in itemArray contains any id from ids
	 */
	public static boolean containsAnyItemId(Item[] itemArray, Set<Integer> ids)
	{
		for (Item i : itemArray)
		{
			final int id = i.getId();
			if (ids.contains(id))
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if any item id in itemArray matches itemID
	 * @param itemArray item array to work on
	 * @param itemID item id to check for
	 * @return true if any item in itemArray matches itemID
	 */
	public static boolean containsItemId(Item[] itemArray, int itemID)
	{
		for (Item i : itemArray)
		{
			if (i.getId() == itemID)
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns null if index is bigger than array otherwise array content.
	 * @param itemArray item array to check
	 * @param index index to grab
	 * @return null if index is bigger than array otherwise array content
	 */
	public static Item safeGetItemAtIndex(Item[] itemArray, int index)
	{
		if (itemArray.length <= index)
		{
			return null;
		}

		return itemArray[index];
	}

	/**
	 * Returns -1 if index is bigger than array otherwise array contents `id` value
	 * @param itemArray item array to check
	 * @param index index to grab
	 * @return -1 if index is bigger than array otherwise array contents `id` value
	 */
	public static Integer safeGetItemIdAtIndex(Item[] itemArray, int index)
	{
		if (itemArray.length <= index)
		{
			return -1;
		}

		return itemArray[index].getId();
	}

	/**
	 * Checks that the itemArray contains all requestedItems. Must contain >= the requested qty for each id
	 * Uses GameItem to represent the requestedItems since we can't easily create Item instances
	 * @param itemArray item array to check against
	 * @param requestedItems Collection of GameItems which contain the item id & minimum qty
	 * @return true if contains all requestedItems
	 */
	public static boolean containsAllGameItems(Item[] itemArray, Collection<GameItem> requestedItems)
	{
		final Map<Integer, GameItem> map = toGameItemMap(itemArray, null);
		for (GameItem i : requestedItems)
		{
			final int id = i.getId();
			GameItem item = map.get(id);
			if (item == null)
			{
				return false;
			}

			if (item.getQty() < i.getQty())
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks that the itemArray contains all requestedItems. Must contain >= the requested qty for each id
	 * Uses GameItem to represent the requestedItems since we can't easily create Item instances
	 * @param itemArray item array to check against
	 * @param requestedItems GameItem(s) to request
	 * @return true if contains all requestedItems
	 */
	public static boolean containsAllGameItems(Item[] itemArray, GameItem... requestedItems)
	{
		return containsAllGameItems(itemArray, Arrays.asList(requestedItems));
	}
}
