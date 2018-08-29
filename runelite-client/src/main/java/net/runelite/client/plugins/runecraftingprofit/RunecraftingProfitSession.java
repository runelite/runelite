/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Dalton <delps1001@gmail.com>
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
package net.runelite.client.plugins.runecraftingprofit;


import net.runelite.api.Item;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.ItemPrice;
import javax.inject.Inject;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static net.runelite.client.callback.Hooks.log;


public class RunecraftingProfitSession
{


	private final RunecraftingProfitPlugin plugin;
	private HashMap<Integer, Integer> previousRunesInInventory = new HashMap<>();
	private HashMap<Integer, Integer> numberOfTotalRunesCrafted = new HashMap<>();
	private HashMap<Runes, Integer> profitPerRuneType = new HashMap<>();
	private HashSet<Integer> runesSet = new HashSet<>();
	private HashMap<Integer, Integer> runePrices = new HashMap<>();
	private int totalProfit = 0;
	private int totalRunesCrafted = 0;
	private double totalProfitPerHour = 0.0;


	@Inject
	public RunecraftingProfitSession(RunecraftingProfitPlugin plugin, ItemManager itemManager)
	{
		for (Runes rune : Runes.values())
		{
			previousRunesInInventory.put(rune.getItemId(), 0);
			runesSet.add(rune.getItemId());
			numberOfTotalRunesCrafted.put(rune.getItemId(), 0);
			profitPerRuneType.put(rune, 0);
			try
			{
				ItemPrice price = itemManager.getItemPrice(rune.getItemId());
				runePrices.put(rune.getItemId(), price.getPrice());
			}
			catch (IOException e)
			{
				log.debug(Arrays.asList(e.getStackTrace()).toString());
			}
		}
		this.plugin = plugin;
	}

	void updatePreviousRunesInInventory(ArrayList<Item> items)
	{
		clearPreviousRunesInInventory();
		for (Item item : items)
		{
			this.previousRunesInInventory.replace(item.getId(), item.getQuantity());
		}
	}

	void updateTotalCraftedRunes(ArrayList<Item> items)
	{
		for (Item item : items)
		{
			if (runesSet.contains(item.getId()))
			{
				int updatedRuneCount = this.numberOfTotalRunesCrafted.get(item.getId()) + (item.getQuantity() - this.previousRunesInInventory.get(item.getId()));
				this.numberOfTotalRunesCrafted.replace(item.getId(), updatedRuneCount);
			}
		}
		updateProfitPerRuneType();
	}

	private void clearPreviousRunesInInventory()
	{
		for (Map.Entry<Integer, Integer> entry : this.previousRunesInInventory.entrySet())
		{
			this.previousRunesInInventory.replace(entry.getKey(), 0);
		}
	}

	private void updateProfitPerRuneType()
	{
		totalProfit = 0;
		totalRunesCrafted = 0;
		for (Map.Entry<Runes, Integer> entry : profitPerRuneType.entrySet())
		{
			int runeId = entry.getKey().getItemId();
			int numberOfRunesCrafted = this.numberOfTotalRunesCrafted.get(runeId);
			int profitForRuneType = this.runePrices.get(runeId) * numberOfRunesCrafted;
			profitPerRuneType.replace(entry.getKey(), profitForRuneType);
			totalProfit += profitForRuneType;
			totalRunesCrafted += numberOfRunesCrafted;
		}
		updateTotalProfitPerHour();
	}

	int getTotalProfit()
	{
		return totalProfit;
	}

	int getTotalRunesCrafted()
	{
		return totalRunesCrafted;
	}

	HashMap<Runes, Integer> getProfitPerRuneType()
	{
		return profitPerRuneType;
	}

	HashMap<Integer, Integer> getNumberOfTotalRunesCrafted()
	{
		return numberOfTotalRunesCrafted;
	}

	public double getTotalProfitPerHour()
	{
		return totalProfitPerHour;
	}

	void clearSession()
	{
		for (Runes rune : Runes.values())
		{
			previousRunesInInventory.replace(rune.getItemId(), 0);
			numberOfTotalRunesCrafted.replace(rune.getItemId(), 0);
			profitPerRuneType.replace(rune, 0);
		}
		this.totalProfit = 0;
		this.totalRunesCrafted = 0;
		this.totalProfitPerHour = 0;
	}

	private void updateTotalProfitPerHour()
	{
		double timeElapsedHours = (double) ChronoUnit.SECONDS.between(plugin.getStartTime(), Instant.now()) / 3600.0;
		this.totalProfitPerHour = this.totalProfit / timeElapsedHours;
	}
}
