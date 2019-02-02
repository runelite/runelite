/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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

package net.runelite.client.plugins.bankcontents;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.client.game.ItemManager;
import net.runelite.api.InventoryID;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import net.runelite.client.Notifier;
import java.util.ArrayList;
import net.runelite.client.util.Text;
import java.util.List;

class BankContents
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private final BankContentsConfig config;
	private final ItemManager itemManager;
	private final Client client;
	private final Notifier notifier;

	@Inject
	BankContents(ItemManager itemManager, BankContentsConfig config, Client client, Notifier notifier)
	{
		this.itemManager = itemManager;
		this.config = config;
		this.client = client;
		this.notifier = notifier;
	}

	void export()
	{
		ItemContainer bankInventory = client.getItemContainer(InventoryID.BANK);

		if (bankInventory == null)
		{
			return;
		}

		Item[] items = bankInventory.getItems();
		final List<String> data = new ArrayList<>();

		for (Item item : items)
		{
			final ItemComposition itemComposition = itemManager.getItemComposition(item.getId());

			data.add(String.valueOf(itemComposition.getId()));
			data.add(String.valueOf(itemComposition.getName()));
			data.add(String.valueOf(item.getQuantity()));
			data.add(String.valueOf(itemManager.getItemPrice(itemComposition.getId())));
			data.add(String.valueOf(Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT)));
			data.add("\n");
		}
		
		final StringSelection stringSelection = new StringSelection(Text.toCSV(data));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
		notifier.notify("Bank contents copied to clipboard!");
	}
}
