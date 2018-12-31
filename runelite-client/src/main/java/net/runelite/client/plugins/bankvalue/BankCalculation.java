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
package net.runelite.client.plugins.bankvalue;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.COINS_995;
import static net.runelite.api.ItemID.PLATINUM_TOKEN;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.util.QueryRunner;

@Slf4j
class BankCalculation
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	private final QueryRunner queryRunner;
	private final BankValueConfig config;
	private final ItemManager itemManager;

	// Used to avoid extra calculation if the bank has not changed
	private int itemsHash;

	// Used to track most valuable items
	Pair[] PairList;

	//used to reduce function calls
	private boolean showGE, showHA, showHV;

	@Getter
	private long gePrice;

	@Getter
	private long haPrice;

	@Inject
	BankCalculation(QueryRunner queryRunner, ItemManager itemManager, BankValueConfig config)
	{
		this.queryRunner = queryRunner;
		this.itemManager = itemManager;
		this.config = config;
	}

	/**
	 * Calculate the bank based on the cache, price can be 0 if bank not active, or cache not set
	 */
	void calculate()
	{

		showGE = config.showGE();
		showHA = config.showHA();
		showHV = config.showHV();

		WidgetItem[] widgetItems = queryRunner.runQuery(new BankItemQuery());

		if (widgetItems.length == 0 || !isBankDifferent(widgetItems))
		{
			return;
		}

		log.debug("Calculating new bank value...");

		PairList = new Pair[config.NumberOfItemsToHighlight()];

		gePrice = haPrice = 0;

		List<Integer> itemIds = new ArrayList<>();

		// Generate our lists (and do some quick price additions)
		for (WidgetItem widgetItem : widgetItems)
		{
			int quantity = widgetItem.getQuantity();

			if (widgetItem.getId() <= 0 || quantity == 0)
			{
				continue;
			}

			if (widgetItem.getId() == COINS_995)
			{
				gePrice += quantity;
				haPrice += quantity;
				continue;
			}

			if (widgetItem.getId() == PLATINUM_TOKEN)
			{
				gePrice += quantity * 1000L;
				haPrice += quantity * 1000L;
				continue;
			}

			final ItemComposition itemComposition = itemManager.getItemComposition(widgetItem.getId());

			if (showGE)
			{
				itemIds.add(widgetItem.getId());
			}

			if (showHA)
			{
				int price = itemComposition.getPrice();

				if (price > 0)
				{
					haPrice += (long) Math.round(price * HIGH_ALCHEMY_CONSTANT) *
						(long) quantity;
				}
			}

			if (showHV)
			{
				PairList = insertToList(PairList, widgetItem);
			}

		}

		// Now do the calculations
		if (showGE && !itemIds.isEmpty())
		{
			for (WidgetItem widgetItem : widgetItems)
			{
				int itemId = widgetItem.getId();
				int quantity = widgetItem.getQuantity();

				if (itemId <= 0 || quantity == 0
					|| itemId == ItemID.COINS_995 || itemId == ItemID.PLATINUM_TOKEN)
				{
					continue;
				}

				gePrice += (long) itemManager.getItemPrice(itemId) * quantity;
			}
		}

	}

	private boolean isBankDifferent(WidgetItem[] widgetItems)
	{
		Map<Integer, Integer> mapCheck = new HashMap<>();

		for (WidgetItem widgetItem : widgetItems)
		{
			mapCheck.put(widgetItem.getId(), widgetItem.getQuantity());
		}

		int curHash = mapCheck.hashCode();

		if (curHash != itemsHash)
		{
			itemsHash = curHash;
			return true;
		}

		return false;
	}

	private Pair[] insertToList(Pair[] list, WidgetItem item)
	{

		long price = (long) itemManager.getItemPrice(item.getId()) * item.getQuantity();
		int i, j;

		for (i = 0; i < list.length; i++)
		{
			if (list[i] == null || price > list[i].value)
			{
				for (j = list.length - 1; j > i; j--)
				{
					list[j] = list[j - 1];
				}

				list[i] = new Pair(item, price);
				i = list.length;

			}
		}
		return list;
	}

	final class Pair
	{
		private WidgetItem key;
		private Long value;

		Pair(WidgetItem key, Long value)
		{
			this.key = key;
			this.value = value;
		}

		public WidgetItem getKey()
		{
			return key;
		}

		public Long getValue()
		{
			return value;
		}
	}
}
