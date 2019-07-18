/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGroundItem;
import net.runelite.rs.api.RSItemContainer;

@Mixin(RSItemContainer.class)
public abstract class RSItemContainerMixin implements RSItemContainer
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	static private int rl$lastCycle;

	@Inject
	static private int rl$lastContainer;

	@Inject
	@Override
	public Item[] getItems()
	{
		int[] itemIds = getItemIds();
		int[] stackSizes = getStackSizes();
		Item[] items = new Item[itemIds.length];

		for (int i = 0; i < itemIds.length; ++i)
		{
			RSGroundItem item = client.createItem();
			item.setId(itemIds[i]);
			item.setQuantity(stackSizes[i]);
			items[i] = item;
		}

		return items;
	}

	@Copy("itemContainerSetItem")
	static void rs$itemContainerSetItem(int itemContainerId, int index, int itemId, int itemQuantity)
	{

	}

	@Replace("itemContainerSetItem")
	static void rl$itemContainerSetItem(int itemContainerId, int index, int itemId, int itemQuantity)
	{
		rs$itemContainerSetItem(itemContainerId, index, itemId, itemQuantity);

		int cycle = client.getGameCycle();

		if (rl$lastCycle == cycle && rl$lastContainer == itemContainerId)
		{
			// Limit item container updates to one per cycle per container
			return;
		}

		InventoryID container = InventoryID.getValue(itemContainerId);

		if (container == null)
		{
			return;
		}

		rl$lastCycle = cycle;
		rl$lastContainer = itemContainerId;

		ItemContainerChanged event = new ItemContainerChanged(itemContainerId, client.getItemContainer(container));
		client.getCallbacks().postDeferred(ItemContainerChanged.class, event);
	}
}
