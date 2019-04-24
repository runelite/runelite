/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.questhelper;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;

public class ItemRequirement
{
	@Getter
	private int id;
	@Getter
	private int quantity;
	private boolean equip;

	public ItemRequirement(int id)
	{
		this(id, 1);
	}

	public ItemRequirement(int id, int quantity)
	{
		this.id = id;
		this.quantity = quantity;
		equip = false;
	}

	public ItemRequirement(int id, int quantity, boolean equip)
	{
		this(id, quantity);
		this.equip = equip;
	}

	public boolean check(Client client)
	{
		Item[] items;
		if (equip)
		{
			items = client.getItemContainer(InventoryID.EQUIPMENT).getItems();
		}
		else
		{
			items = client.getItemContainer(InventoryID.INVENTORY).getItems();
		}

		int tempQuantity = quantity;
		for (Item item : items)
		{
			if (item.getId() == id)
			{
				if (item.getQuantity() >= tempQuantity)
				{
					return true;
				}
				else
				{
					tempQuantity -= item.getQuantity();
				}
			}
		}
		return false;
	}
}
