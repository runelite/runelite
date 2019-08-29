/*
 * Copyright (c) 2018 Charlie Waters
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
package net.runelite.client.plugins.itemprices;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("itemprices")
public interface ItemPricesConfig extends Config
{
	@ConfigItem(
		keyName = "showGEPrice",
		name = "Show Grand Exchange Prices",
		description = "Grand exchange prices should be shown on tooltips",
		position = 1
	)
	default boolean showGEPrice()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHAValue",
		name = "Show High Alchemy Values",
		description = "High Alchemy values should be shown on tooltips",
		position = 2
	)
	default boolean showHAValue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEA",
		name = "Show Price Each on Stacks",
		description = "The price/value of each item should be shown on stacks",
		position = 3
	)
	default boolean showEA()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideInventory",
		name = "Hide Tooltips on Inventory Items",
		description = "Tooltips should be hidden on items in the inventory",
		position = 4
	)
	default boolean hideInventory()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAlchProfit",
		name = "Show High Alchemy Profit",
		description = "Show the profit from casting high alchemy on items",
		position = 5
	)
	default boolean showAlchProfit()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showWhileAlching",
		name = "Show prices while alching",
		description = "Show the price overlay while using High Alchemy",
		position = 6
	)
	default boolean showWhileAlching()
	{
		return true;
	}
}
