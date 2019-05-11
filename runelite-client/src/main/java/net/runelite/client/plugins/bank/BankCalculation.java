/*
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
package net.runelite.client.plugins.bank;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/plugins/bankvalue/BankCalculation.java
<<<<<<< HEAD
=======
=======
import net.runelite.api.ItemContainer;
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/bank/BankCalculation.java
import net.runelite.api.ItemID;
>>>>>>> upstream/master
import static net.runelite.api.ItemID.COINS_995;
import static net.runelite.api.ItemID.PLATINUM_TOKEN;
import net.runelite.api.Varbits;
import net.runelite.client.game.ItemManager;
<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/plugins/bankvalue/BankCalculation.java
<<<<<<< HEAD
=======
import net.runelite.client.game.ItemMapping;
>>>>>>> upstream/master
import net.runelite.client.util.QueryRunner;
import net.runelite.http.api.item.ItemPrice;
=======
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/bank/BankCalculation.java

@Slf4j
class BankCalculation
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private static final ImmutableList<Varbits> TAB_VARBITS = ImmutableList.of(
		Varbits.BANK_TAB_ONE_COUNT,
		Varbits.BANK_TAB_TWO_COUNT,
		Varbits.BANK_TAB_THREE_COUNT,
		Varbits.BANK_TAB_FOUR_COUNT,
		Varbits.BANK_TAB_FIVE_COUNT,
		Varbits.BANK_TAB_SIX_COUNT,
		Varbits.BANK_TAB_SEVEN_COUNT,
		Varbits.BANK_TAB_EIGHT_COUNT,
		Varbits.BANK_TAB_NINE_COUNT
	);

	private final BankConfig config;
	private final ItemManager itemManager;
	private final Client client;

	// Used to avoid extra calculation if the bank has not changed
	private int itemsHash;

	@Getter
	private long gePrice;

	@Getter
	private long haPrice;

	@Inject
	BankCalculation(ItemManager itemManager, BankConfig config, Client client)
	{
		this.itemManager = itemManager;
		this.config = config;
		this.client = client;
	}

	/**
	 * Calculate the bank based on the cache, price can be 0 if bank not active, or cache not set
	 */
	void calculate()
	{
		ItemContainer bankInventory = client.getItemContainer(InventoryID.BANK);

		if (bankInventory == null)
		{
			return;
		}

		Item[] items = bankInventory.getItems();
		int currentTab = client.getVar(Varbits.CURRENT_BANK_TAB);

		if (currentTab > 0)
		{
			int startIndex = 0;

			for (int i = currentTab - 1; i > 0; i--)
			{
				startIndex += client.getVar(TAB_VARBITS.get(i - 1));
			}

			int itemCount = client.getVar(TAB_VARBITS.get(currentTab - 1));
			items = Arrays.copyOfRange(items, startIndex, startIndex + itemCount);
		}

		if (items.length == 0 || !isBankDifferent(items))
		{
			return;
		}

		log.debug("Calculating new bank value...");

		gePrice = haPrice = 0;

<<<<<<< HEAD
		List<ItemComposition> itemCompositions = new ArrayList<>();
		Map<Integer, WidgetItem> itemMap = new HashMap<>();
=======
>>>>>>> upstream/master
		List<Integer> itemIds = new ArrayList<>();

		// Generate our lists (and do some quick price additions)
		for (Item item : items)
		{
<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/plugins/bankvalue/BankCalculation.java
<<<<<<< HEAD
			if (widgetItem.getId() <= 0 || widgetItem.getQuantity() == 0)
=======
			int quantity = widgetItem.getQuantity();

			if (widgetItem.getId() <= 0 || quantity == 0)
>>>>>>> upstream/master
=======
			int quantity = item.getQuantity();

			if (item.getId() <= 0 || quantity == 0)
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/bank/BankCalculation.java
			{
				continue;
			}

			if (item.getId() == COINS_995)
			{
<<<<<<< HEAD
				gePrice += widgetItem.getQuantity();
				haPrice += widgetItem.getQuantity();
=======
				gePrice += quantity;
				haPrice += quantity;
>>>>>>> upstream/master
				continue;
			}

			if (item.getId() == PLATINUM_TOKEN)
			{
<<<<<<< HEAD
				gePrice += widgetItem.getQuantity() * 1000L;
				haPrice += widgetItem.getQuantity() * 1000L;
=======
				gePrice += quantity * 1000L;
				haPrice += quantity * 1000L;
>>>>>>> upstream/master
				continue;
			}

<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/plugins/bankvalue/BankCalculation.java
			final ItemComposition itemComposition = itemManager.getItemComposition(widgetItem.getId());
<<<<<<< HEAD
			itemCompositions.add(itemComposition);
			itemMap.put(widgetItem.getId(), widgetItem);
=======
>>>>>>> upstream/master
=======
			final ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/bank/BankCalculation.java

			if (config.showGE())
			{
				itemIds.add(item.getId());
			}
<<<<<<< HEAD
=======

			if (config.showHA())
			{
				int price = itemComposition.getPrice();

				if (price > 0)
				{
					haPrice += (long) Math.round(price * HIGH_ALCHEMY_CONSTANT) *
						(long) quantity;
				}
			}
>>>>>>> upstream/master
		}

		// Now do the calculations
		if (config.showGE() && !itemIds.isEmpty())
		{
			for (Item item : items)
			{
				int itemId = item.getId();
				int quantity = item.getQuantity();

				if (itemId <= 0 || quantity == 0
					|| itemId == ItemID.COINS_995 || itemId == ItemID.PLATINUM_TOKEN)
				{
					continue;
				}

<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/plugins/bankvalue/BankCalculation.java
				log.debug("Price lookup is complete. {} prices.", itemPrices.length);

				try
				{
<<<<<<< HEAD
					for (ItemPrice itemPrice : itemPrices)
					{
						if (itemPrice.getItem() == null)
						{
							continue; // cached no price
						}

						gePrice += (long) itemPrice.getPrice() * (long) itemMap.get(itemPrice.getItem().getId()).getQuantity();
=======
					for (WidgetItem widgetItem : widgetItems)
					{
						int itemId = widgetItem.getId();
						int quantity = widgetItem.getQuantity();

						if (itemId <= 0 || quantity == 0
							|| itemId == ItemID.COINS_995 || itemId == ItemID.PLATINUM_TOKEN)
						{
							continue;
						}

						long price = 0;
						for (int mappedItemId : ItemMapping.map(itemId))
						{
							ItemPrice cachedItemPrice = itemManager.getCachedItemPrice(mappedItemId);
							if (cachedItemPrice == null)
							{
								// this happens to items which have no ge price
								continue;
							}

							price += cachedItemPrice.getPrice();
						}

						gePrice += price * quantity;
>>>>>>> upstream/master
					}
				}
				catch (Exception ex2)
				{
					log.warn("error calculating price", ex2);
				}
				finally
				{
					finished = true;
				}
			});
		}
		else
		{
			finished = true;
=======
				gePrice += (long) itemManager.getItemPrice(itemId) * quantity;
			}
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/bank/BankCalculation.java
		}
<<<<<<< HEAD

		if (config.showHA())
		{
			for (ItemComposition itemComposition : itemCompositions)
			{
				int price = itemComposition.getPrice();

				if (price > 0)
				{
					haPrice += (long) Math.round(price * HIGH_ALCHEMY_CONSTANT) *
						(long) itemMap.get(itemComposition.getId()).getQuantity();
				}
			}
		}
=======
>>>>>>> upstream/master
	}

	private boolean isBankDifferent(Item[] items)
	{
		Map<Integer, Integer> mapCheck = new HashMap<>();

		for (Item item : items)
		{
			mapCheck.put(item.getId(), item.getQuantity());
		}

		int curHash = mapCheck.hashCode();

		if (curHash != itemsHash)
		{
			itemsHash = curHash;
			return true;
		}

		return false;
	}
}
