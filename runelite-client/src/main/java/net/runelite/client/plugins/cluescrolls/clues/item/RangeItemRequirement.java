/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls.clues.item;

import java.util.ArrayList;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.client.plugins.banktags.CustomBankTabItem;
import net.runelite.client.plugins.banktags.CustomBankTabItems;

public class RangeItemRequirement implements ItemRequirement
{
	@Getter
	private final String name;
	private final int startItemId;
	private final int endItemId;

	public RangeItemRequirement(String name, int startItemId, int endItemId)
	{
		this.name = name;
		this.startItemId = startItemId;
		this.endItemId = endItemId;
	}

	@Override
	public boolean fulfilledBy(int itemId)
	{
		return itemId >= startItemId && itemId <= endItemId;
	}

	@Override
	public boolean fulfilledBy(Item[] items)
	{
		for (Item item : items)
		{
			if (item.getId() >= startItemId && item.getId() <= endItemId)
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public ArrayList<CustomBankTabItems> getPluginBankTabItems(Client client)
	{
		String name = getCollectiveName(client);

		if (name == null)
		{
			name = client.getItemDefinition(startItemId).getName();
		}

		CustomBankTabItem items = new CustomBankTabItem(1, name, startItemId);
		for (int i = startItemId + 1; i <= endItemId; i++)
		{
			items.addItemIDs(i);
		}

		ArrayList<CustomBankTabItems> itemsList = new ArrayList<>();
		itemsList.add(new CustomBankTabItems(name, items));

		return itemsList;
	}

	@Override
	public String getCollectiveName(Client client)
	{
		return name;
	}
}
