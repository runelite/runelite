/*
 * Copyright (c) 2019, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Constants;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;

public class HeatmapCalculation
{
	private final ItemManager itemManager;

	@Getter
	private final Map<Integer, HeatmapItem> heatmapItems = new HashMap<>();

	@Inject
	private HeatmapCalculation(ItemManager itemManager)
	{
		this.itemManager = itemManager;
	}

	void calculate(Item[] items)
	{
		heatmapItems.clear();

		for (final Item item : items)
		{
			final int qty = item.getQuantity();
			final int id = item.getId();

			final HeatmapItem hItem = new HeatmapItem();
			hItem.setId(id);
			hItem.setQuantity(qty);
			heatmapItems.put(item.getId(), hItem);

			if (id <= 0 || qty == 0)
			{
				continue;
			}

			switch (id)
			{
				case ItemID.COINS_995:
					hItem.setAlchPrice(qty);
					hItem.setGePrice(qty);
					break;
				case ItemID.PLATINUM_TOKEN:
					hItem.setGePrice(qty * 1000L);
					hItem.setAlchPrice(qty * 1000L);
					break;
				default:
					final long storePrice = itemManager.getItemComposition(id).getPrice();
					final long alchPrice = (long) (storePrice * Constants.HIGH_ALCHEMY_MULTIPLIER);

					hItem.setGePrice(itemManager.getItemPrice(id) * qty);
					hItem.setAlchPrice(alchPrice * qty);
					break;
			}
		}

		normalizeItems();
	}

	private void normalizeItems()
	{
		long minAlch = Long.MAX_VALUE, minGe = Long.MAX_VALUE;
		long maxAlch = Long.MIN_VALUE, maxGe = Long.MIN_VALUE;

		for (HeatmapItem hItem : heatmapItems.values())
		{
			minGe = Math.min(minGe, hItem.getGePrice());
			minAlch = Math.min(minAlch, hItem.getAlchPrice());

			maxGe = Math.max(maxGe, hItem.getGePrice());
			maxAlch = Math.max(maxAlch, hItem.getAlchPrice());
		}

		for (HeatmapItem hItem : heatmapItems.values())
		{
			hItem.setAlchFactor(normalize(0, 1, minAlch, maxAlch, hItem.getAlchPrice()));
			hItem.setGeFactor(normalize(0, 1, minGe, maxGe, hItem.getGePrice()));
		}
	}

	private static float normalize(int a, int b, long min, long max, long x)
	{
		return (b - a) * ((float) (x - min) / (max - min)) + a;
	}
}
