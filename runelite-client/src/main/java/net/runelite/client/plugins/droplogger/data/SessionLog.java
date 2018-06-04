/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger.data;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public abstract class SessionLog
{
	@Getter
	private Instant instant;

	@Getter
	private Map<Integer, Integer> allItems;

	private Map<Integer, Integer> pickedUpItems; // Items that are picked up but may be dropped again

	private Map<Integer, Integer> finalizedItems; // Items that were picked up and banked

	private Map<Integer, Integer> disappearedItems; // Items that were not picked up and disappeared

	SessionLog(Map<Integer, Integer> allItems)
	{
		this.instant = Instant.now();
		this.allItems = allItems;
		this.pickedUpItems = new HashMap<>();
		this.finalizedItems = new HashMap<>();
		this.disappearedItems = new HashMap<>();
	}

	public Map<Integer, Integer> getPickedUpItems()
	{
		Map<Integer, Integer> map = new HashMap<>(finalizedItems);
		pickedUpItems.forEach((key, value) ->
		{
			int count = map.getOrDefault(key, 0);
			map.put(key, value + count);
		});
		return map;
	}

	public Map<Integer, Integer> getLeftOnGroundItems()
	{
		Map<Integer, Integer> map = new HashMap<>(allItems);
		pickedUpItems.forEach((key, value) ->
		{
			int count = map.get(key);
			int nextCount = count - value;
			if (nextCount == 0)
			{
				map.remove(key);
			}
			else
			{
				map.put(key, nextCount);
			}
		});
		finalizedItems.forEach((key, value) ->
		{
			int count = map.get(key);
			int nextCount = count - value;
			if (nextCount == 0)
			{
				map.remove(key);
			}
			else
			{
				map.put(key, nextCount);
			}
		});
		return map;
	}

	public int pickUpItemStack(int itemId, int quantity)
	{
		int maxCount = allItems.getOrDefault(itemId, 0);
		int currCount = pickedUpItems.getOrDefault(itemId, 0);
		if (currCount >= maxCount)
		{
			return 0;
		}

		quantity = Math.min(quantity, maxCount - currCount);
		pickedUpItems.put(itemId, currCount + quantity);
		return quantity;
	}

	/**
	 * If the user drops items that were previously picked up, they will
	 * no longer count as being picked up.
	 */
	public int dropItemStack(int itemId, int quantity)
	{
		int count = pickedUpItems.getOrDefault(itemId, 0);
		if (count - quantity <= 0)
		{
			pickedUpItems.remove(itemId);
			return count;
		}
		else
		{
			pickedUpItems.put(itemId, count - quantity);
			return quantity;
		}
	}

	/**
	 * We consider items that have been picked up that left the inventory
	 * without being dropped are finalized. So if the user later takes out
	 * another stack of items from his bank and drops them, they do not
	 * disappear from the picked up item list.
	 */
	public int finalizeItemStack(int itemId, int quantity)
	{
		int count = pickedUpItems.getOrDefault(itemId, 0);
		if (count == 0)
		{
			return 0;
		}

		quantity = Math.min(quantity, count);
		int newCount = count - quantity;
		if (newCount == 0)
		{
			pickedUpItems.remove(itemId);
		}
		else
		{
			pickedUpItems.put(itemId, newCount);
		}

		int finalizedCount = finalizedItems.getOrDefault(itemId, 0);
		finalizedItems.put(itemId, finalizedCount + quantity);
		return quantity;
	}

	public void disappearItems(int itemId, int quantity)
	{
		int count = disappearedItems.getOrDefault(itemId, 0);
		disappearedItems.put(itemId, quantity + count);
	}

	public boolean isEverythingFinalized()
	{
		Map<Integer, Integer> unfinalizedDrops = new HashMap<>(allItems);
		finalizedItems.forEach((key, value) ->
		{
			int count = unfinalizedDrops.getOrDefault(key, 0);
			if (count - value <= 0)
			{
				unfinalizedDrops.remove(key);
			}
			else
			{
				unfinalizedDrops.put(key, count - value);
			}
		});
		disappearedItems.forEach((key, value) ->
		{
			int count = unfinalizedDrops.getOrDefault(key, 0);
			if (count - value <= 0)
			{
				unfinalizedDrops.remove(key);
			}
			else
			{
				unfinalizedDrops.put(key, count - value);
			}
		});
		return finalizedItems.isEmpty();
	}
}