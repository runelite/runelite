/*
 * Copyright (c) 2019, Owain van Brakel <https://github.com/Owain94>
 * Copyright (c) 2019, Alan Baumgartner <https://github.com/alanbaumgartner>
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
package net.runelite.client.plugins.easyscape;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.easyscape.util.DuelingRingMode;
import net.runelite.client.plugins.easyscape.util.EssenceMode;
import net.runelite.client.plugins.easyscape.util.GamesNecklaceMode;
import net.runelite.client.plugins.easyscape.util.GloryMode;


@ConfigGroup("easyscape")
public interface EasyscapeConfig extends Config
{
	@ConfigItem(
		keyName = "withdrawOne",
		name = "Withdraw/Deposit One",
		description = "",
		position = 0,
		group = "Banking"
	)
	default boolean getWithdrawOne()
	{
		return false;
	}

	@ConfigItem(
		keyName = "withdrawOneItems",
		name = "Items",
		description = "",
		position = 1,
		group = "Banking"
	)
	default String getWithdrawOneItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "withdrawFive",
		name = "Withdraw/Deposit Five",
		description = "",
		position = 2,
		group = "Banking"
	)
	default boolean getWithdrawFive()
	{
		return false;
	}

	@ConfigItem(
		keyName = "withdrawFiveItems",
		name = "Items",
		description = "",
		position = 3,
		group = "Banking"
	)
	default String getWithdrawFiveItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "withdrawTen",
		name = "Withdraw/Deposit Ten",
		description = "",
		position = 4,
		group = "Banking"
	)
	default boolean getWithdrawTen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "withdrawTenItems",
		name = "Items",
		description = "",
		position = 5,
		group = "Banking"
	)
	default String getWithdrawTenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "withdrawX",
		name = "Withdraw/Deposit X",
		description = "",
		position = 6,
		group = "Banking"
	)
	default boolean getWithdrawX()
	{
		return false;
	}

	@ConfigItem(
		keyName = "withdrawXAmount",
		name = "Amount",
		description = "",
		position = 7,
		group = "Banking"
	)
	default String getWithdrawXAmount()
	{
		return "";
	}

	@ConfigItem(
		keyName = "withdrawXItems",
		name = "Items",
		description = "",
		position = 8,
		group = "Banking"
	)
	default String getWithdrawXItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "withdrawAll",
		name = "Withdraw/Deposit All",
		description = "",
		position = 9,
		group = "Banking"
	)
	default boolean getWithdrawAll()
	{
		return false;
	}

	@ConfigItem(
		keyName = "withdrawAllItems",
		name = "Items",
		description = "",
		position = 10,
		group = "Banking"
	)
	default String getWithdrawAllItems()
	{
		return "";
	}

// ----------------------------------------------------------- //

	@ConfigItem(
		keyName = "removeObjects",
		name = "Remove Objects",
		description = "Removes interaction with the listed objects.",
		position = 12,
		group = "Miscellaneous easyscape"
	)
	default boolean getRemoveObjects()
	{
		return false;
	}

	@ConfigItem(
		keyName = "removedObjects",
		name = "Objects",
		description = "Objects listed here will have all interaction be removed.",
		position = 13,
		group = "Miscellaneous easyscape"
	)
	default String getRemovedObjects()
	{
		return "";
	}

// ----------------------------------------------------------- //

	@ConfigItem(
		keyName = "swapBuyOne",
		name = "Swappable Buy One",
		description = "",
		position = 14,
		group = "Shop / stores"
	)
	default boolean getSwapBuyOne()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyOneItems",
		name = "Items",
		description = "",
		position = 15,
		group = "Shop / stores"
	)
	default String getBuyOneItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyFive",
		name = "Swappable Buy Five",
		description = "",
		position = 16,
		group = "Shop / stores"
	)
	default boolean getSwapBuyFive()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyFiveItems",
		name = "Items",
		description = "",
		position = 17,
		group = "Shop / stores"
	)
	default String getBuyFiveItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyTen",
		name = "Swappable Buy Ten",
		description = "",
		position = 18,
		group = "Shop / stores"
	)
	default boolean getSwapBuyTen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyTenItems",
		name = "Items",
		description = "",
		position = 19,
		group = "Shop / stores"
	)
	default String getBuyTenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyFifty",
		name = "Swappable Buy Fifty",
		description = "",
		position = 20,
		group = "Shop / stores"
	)
	default boolean getSwapBuyFifty()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyFiftyItems",
		name = "Items",
		description = "",
		position = 21,
		group = "Shop / stores"
	)
	default String getBuyFiftyItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellOne",
		name = "Swappable Sell One",
		description = "",
		position = 22,
		group = "Shop / stores"
	)
	default boolean getSwapSellOne()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellOneItems",
		name = "Items",
		description = "",
		position = 23,
		group = "Shop / stores"
	)
	default String getSellOneItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellFive",
		name = "Swappable Sell Five",
		description = "",
		position = 24,
		group = "Shop / stores"
	)
	default boolean getSwapSellFive()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellFiveItems",
		name = "Items",
		description = "",
		position = 25,
		group = "Shop / stores"
	)
	default String getSellFiveItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellTen",
		name = "Swappable Sell Ten",
		description = "",
		position = 26,
		group = "Shop / stores"
	)
	default boolean getSwapSellTen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellTenItems",
		name = "Items",
		description = "",
		position = 27,
		group = "Shop / stores"
	)
	default String getSellTenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellFifty",
		name = "Swappable Sell Fifty",
		description = "",
		position = 28,
		group = "Shop / stores"
	)
	default boolean getSwapSellFifty()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellFiftyItems",
		name = "Items",
		description = "",
		position = 29,
		group = "Shop / stores"
	)
	default String getSellFiftyItems()
	{
		return "";
	}

// ----------------------------------------------------------- //

	@ConfigItem(
		keyName = "easyConstruction",
		name = "Easy Construction",
		description = "Makes \"Remove\" the default option for listed items in build mode.",
		position = 30,
		group = "Miscellaneous swapper"
	)
	default boolean getEasyConstruction()
	{
		return false;
	}

	@ConfigItem(
		keyName = "constructionItems",
		name = "Construction Items",
		description = "Items listed here will have the default option set to \"Removed\" in build mode.",
		position = 31,
		group = "Miscellaneous swapper"
	)
	default String getConstructionItems()
	{
		return "";
	}


	@ConfigItem(
		keyName = "swapSmithing",
		name = "Swap Smithing",
		description = "Enables swapping of smith-1 and smith-all options.",
		position = 32,
		group = "Miscellaneous swapper"
	)
	default boolean getSwapSmithing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapTanning",
		name = "Swap Tanning",
		description = "Enables swapping of tan-1 and tan-all options.",
		position = 33,
		group = "Miscellaneous swapper"
	)
	default boolean getSwapTanning()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapArdougneCape",
		name = "Swap Ardougne Cape",
		description = "Enables swapping of teleport and wear.",
		position = 34,
		group = "Miscellaneous swapper"
	)
	default boolean getSwapArdougneCape()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapSawmill",
		name = "Swap Sawmill Operator",
		description = "Makes Buy-plank the default option on the sawmill operator.",
		position = 35,
		group = "Miscellaneous swapper"
	)
	default boolean getSwapSawmill()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapSawmillPlanks",
		name = "Swap Buy Planks",
		description = "Makes Buy All the default option in buy planks.",
		position = 36,
		group = "Miscellaneous swapper"
	)
	default boolean getSwapSawmillPlanks()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPuroPuro",
		name = "Swap Puro Puro Wheat",
		description = "",
		position = 37,
		group = "Miscellaneous swapper"
	)
	default boolean getSwapPuro()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapEssencePounch",
		name = "Swap Essence Pouch",
		description = "",
		position = 38,
		group = "Miscellaneous swapper"
	)
	default boolean getSwapEssencePouch()
	{
		return false;
	}

	@ConfigItem(
		keyName = "essenceMode",
		name = "Mode",
		description = "",
		position = 39,
		group = "Miscellaneous swapper"
	)
	default EssenceMode getEssenceMode()
	{
		return EssenceMode.RUNECRAFTING;
	}

	@ConfigItem(
		keyName = "swapGamesNecklace",
		name = "Swap Games Necklace",
		description = "",
		position = 40,
		group = "Miscellaneous swapper"
	)
	default boolean getGamesNecklace()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gamesNecklaceMode",
		name = "Mode",
		description = "",
		position = 41,
		group = "Miscellaneous swapper"
	)
	default GamesNecklaceMode getGamesNecklaceMode()
	{
		return GamesNecklaceMode.BURTHORPE;
	}

	@ConfigItem(
		keyName = "swapDuelingRing",
		name = "Swap Dueling Ring",
		description = "",
		position = 42,
		group = "Miscellaneous swapper"
	)
	default boolean getDuelingRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "duelingRingMode",
		name = "Mode",
		description = "",
		position = 43,
		group = "Miscellaneous swapper"
	)
	default DuelingRingMode getDuelingRingMode()
	{
		return DuelingRingMode.DUEL_ARENA;
	}

	@ConfigItem(
		keyName = "swapGlory",
		name = "Swap Glory",
		description = "",
		position = 44,
		group = "Miscellaneous swapper"
	)
	default boolean getGlory()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gloryMode",
		name = "Mode",
		description = "",
		position = 45,
		group = "Miscellaneous swapper"
	)
	default GloryMode getGloryMode()
	{
		return GloryMode.EDGEVILLE;
	}
}