/*
 * Copyright (c) 2018, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.tripchecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;

/**
 * Wrapper around the items in a trip setup
 */
class TripItemList
{
	@Getter(AccessLevel.PACKAGE)
	private HashMap<Integer, Integer> inventoryItems;

	@Getter(AccessLevel.PACKAGE)
	private int[] equipmentIds;

	/**
	 * Sets the inventory in this loadout. For non-stacking items like food, keep
	 * track of how many there are in one key.
	 *
	 * @param inventoryContainer The inventory items
	 */
	void setInventory(ItemContainer inventoryContainer)
	{
		inventoryItems = new HashMap<>();
		for (Item item : inventoryContainer.getItems())
		{
			int key = item.getId();
			if (key == -1)
			{
				continue;
			}

			if (inventoryItems.containsKey(key))
			{
				inventoryItems.put(key, inventoryItems.get(key) + item.getQuantity());
			}
			else
			{
				inventoryItems.put(key, item.getQuantity());
			}
		}
	}

	/**
	 * Sets the equipment in this loadout.
	 *
	 * @param equipmentContainer The equipment items
	 */
	void setEquipment(ItemContainer equipmentContainer)
	{
		List<Integer> tempEquipmentIds = new ArrayList<>();
		//equipmentIds = new int[equipmentContainer.getItems().length];
		for (int i = 0; i < equipmentContainer.getItems().length; i++)
		{
			int equipmentId = equipmentContainer.getItems()[i].getId();
			if (equipmentId == -1)
			{
				continue;
			}

			tempEquipmentIds.add(equipmentId);
		}

		equipmentIds = tempEquipmentIds.stream().mapToInt(i -> i).toArray();
	}
}
