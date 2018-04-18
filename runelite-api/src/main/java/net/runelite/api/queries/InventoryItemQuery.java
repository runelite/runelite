/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.api.queries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Query;

public class InventoryItemQuery extends Query<Item, InventoryItemQuery>
{
	private final InventoryID[] inventories;
	private boolean findAll = false;
	private Integer[] itemIDs;

	public InventoryItemQuery(InventoryID... inventories)
	{
		this.inventories = inventories;
	}

	@Override
	public Item[] result(Client client)
	{
		List<Integer> inputIDs = itemIDs == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(itemIDs));
		List<Integer> foundIDs = new ArrayList<>();
		List<Item> inputItems = new ArrayList<>();
		List<Item> foundItems = new ArrayList<>();

		for (InventoryID inventory : inventories)
		{
			ItemContainer container = client.getItemContainer(inventory);
			if (container != null)
			{
				inputItems.addAll(Arrays.asList(container.getItems()));
			}
		}

		for (Item item : inputItems)
		{
			if (item != null)
			{
				if (inputIDs.contains(item.getId()) || (inputIDs.isEmpty() && item.getId() > 0))
				{
					foundIDs.add(item.getId());
					foundItems.add(item);
				}
			}
		}

		//todo: make this work with multiples of the same item in inputIDs
		if (foundItems.isEmpty() || (findAll && !foundIDs.containsAll(inputIDs)))
		{
			return null;
		}

		return foundItems.toArray(new Item[0]);
	}

	public InventoryItemQuery findAll()
	{
		this.findAll = true;
		return this;
	}

	public InventoryItemQuery idEquals(Integer... itemIDs)
	{
		this.itemIDs = itemIDs;
		return this;
	}
}
