/*
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
package net.runelite.client.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;

public class ItemFinder
{
	@Inject
	private Client client;

	public List<Item> find(Container container, Match match, Integer... itemIDs)
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		List<Integer> inputIDs = new ArrayList<>(Arrays.asList(itemIDs));
		List<Integer> foundIDs = new ArrayList<>();
		List<Item> foundItems = new ArrayList<>();
		List<Item> items = new ArrayList<>();

		if (inventory != null && equipment != null)
		{
			if (container == Container.INVENTORY || container == Container.INVENTORY_AND_EQUIPMENT)
			{
				items.addAll(Arrays.asList(inventory.getItems()));
			}

			if (container == Container.EQUIPMENT || container == Container.INVENTORY_AND_EQUIPMENT)
			{
				items.addAll(Arrays.asList(equipment.getItems()));
			}

			for (Item item : items)
			{
				if (inputIDs.contains(item.getId()))
				{
					foundIDs.add(item.getId());
					foundItems.add(item);
				}
			}

			//todo: make this work with multiples of the same item in inputIDs
			if (match == Match.ALL_ITEMS && !foundIDs.containsAll(inputIDs))
			{
				foundItems = Collections.emptyList();
			}
		}

		return foundItems;
	}

	public enum Container
	{
		INVENTORY,
		EQUIPMENT,
		INVENTORY_AND_EQUIPMENT
	}

	public enum Match
	{
		ALL_ITEMS,
		ANY_ITEM
	}
}
