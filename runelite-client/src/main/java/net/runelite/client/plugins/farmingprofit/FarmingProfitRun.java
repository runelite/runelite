/*
 * Copyright (c) 2018, Mika Kuijpers <github.com/mkuijpers>
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
package net.runelite.client.plugins.farmingprofit;

import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;

import java.time.LocalDateTime;
import net.runelite.client.util.StackFormatter;

class FarmingProfitRun
{

	// Class variables
	@Getter
	private Crop crop;
	@Getter
	private int gameObjClicked;
	@Getter
	private int amount;
	@Getter
	private WorldPoint latestHarvestWorldPoint;
	@Getter
	private LocalDateTime latestHarvestTime;

	// Util variables
	@Getter
	private int profit;
	@Getter
	private String tooltip;

	// Item manager
	private ItemManager itemManager;


	FarmingProfitRun(ItemManager itemManager, Crop crop, int amount, WorldPoint latestHarvest, int gameObjClicked)
	{
		this.itemManager = itemManager;
		this.crop = crop;
		this.gameObjClicked = gameObjClicked;
		updateRun(amount, latestHarvest);
	}

	/**
	 * Update various variables of the farming run which have to be updated after the amount changes
	 *
	 * @param amount            The new amount for the farming run
	 * @param harvestWorldPoint The new location of the farming run
	 */
	private void updateRun(int amount, WorldPoint harvestWorldPoint)
	{
		this.amount = amount;
		latestHarvestWorldPoint = harvestWorldPoint;
		updateProfit();
		latestHarvestTime = LocalDateTime.now();
	}

	/**
	 * Add a certain amount of products to the run, with a new location
	 *
	 * @param toAdd             Amount of products to add
	 */
	void addAmount(int toAdd)
	{
		updateRun(amount + toAdd, latestHarvestWorldPoint);
	}

	/**
	 * Update the profit variable, followed by updating the tooltip string
	 * <p>
	 * Created a separate updateRun and getter for the profit because getting the item prices has to be done on
	 * the client thread, which is not possible when the UI tries to access the profit.
	 */
	private void updateProfit()
	{
		int seedPrice = itemManager.getItemPrice(crop.getSeedId());
		int productPrice = itemManager.getItemPrice(crop.getProductId());

		profit = productPrice * amount - seedPrice * crop.getSeedAmount();
		updateTooltip();
	}

	/**
	 * Update the tooltip variable.
	 * <p>
	 * Created a separate updateRun and getter for the tooltip because getting the item compositions has to be done on
	 * the client thread, which is not possible when the UI tries to access the tooltip.
	 */
	private void updateTooltip()
	{
		ItemComposition seed = itemManager.getItemComposition(crop.getSeedId());
		int seedPrice = itemManager.getItemPrice(crop.getSeedId());
		ItemComposition product = itemManager.getItemComposition(crop.getProductId());
		int productPrice = itemManager.getItemPrice(crop.getProductId());
		tooltip = "<html>Cost: " + crop.getSeedAmount() + "x " + seed.getName() + " " +
			StackFormatter.quantityToStackSize(seedPrice * crop.getSeedAmount()) + "gp<br>" +
			"Products: " + amount + "x " + product.getName() + " " +
			StackFormatter.quantityToStackSize(productPrice * amount) + "gp<br>" +
			"Profit: " + StackFormatter.quantityToStackSize(getProfit()) + "gp</html>";
	}

	public String toString()
	{
		return "[" + this.crop.getDisplayName() + ", amount: " + this.amount + "x]";
	}

}
