/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
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
package net.runelite.client.plugins.droptracker;

import lombok.Getter;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.ItemPrice;
import static net.runelite.api.ItemID.COINS_995;
import static net.runelite.api.ItemID.PLATINUM_TOKEN;

import java.io.IOException;

public class ItemData
{
	@Getter
	private int id;
	@Getter
	private int amount;
	@Getter
	private String name;
	@Getter
	private long price;

	public ItemData(int id, int amount, ItemManager itemManager)
	{
		this.id = id;
		ItemComposition itemComposition = itemManager.getItemComposition(this.id);
		this.amount = amount;
		this.name = itemComposition.getName();
		if (COINS_995 == id)
		{
			this.price = this.amount;
			return;
		}
		if (PLATINUM_TOKEN == id)
		{
			this.price = this.amount * 1000L;
			return;
		}
		ItemPrice itemPrice = new ItemPrice();
		try
		{
			itemPrice = itemManager.getItemPrice(this.id);
		}
		catch (IOException ex)
		{
		}
		this.price = itemPrice != null ? itemPrice.getPrice() : itemComposition.getPrice();
		this.price *= this.amount;
	}

	public ItemData(Item item, ItemManager itemManager)
	{
		this.id = item.getId();
		ItemComposition itemComposition = itemManager.getItemComposition(id);
		this.amount = item.getQuantity();
		this.name = itemComposition.getName();
		if (COINS_995 == id)
		{
			this.price = this.amount;
			return;
		}
		if (PLATINUM_TOKEN == id)
		{
			this.price = this.amount * 1000L;
			return;
		}
		ItemPrice itemPrice = new ItemPrice();
		try
		{
			itemPrice = itemManager.getItemPrice(this.id);
		}
		catch (IOException ex)
		{
		}
		this.price = itemPrice != null ? itemPrice.getPrice() : itemComposition.getPrice();
		this.price *= this.amount;
	}

	public void addAmount(int amount)
	{
		this.amount += amount;
	}

	@Override
	public String toString()
	{
		return name + " (" + amount + ")";
	}
}
