/*
 * Copyright (c) 2018 Ben Dol <dolb90@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.iteminfo;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

/**
 * @author Ben Dol
 */
@ConfigGroup("iteminfo")
public interface ItemInfoConfig extends Config
{
	@ConfigItem(
		keyName = "showBonuses",
		name = "Show Bonuses",
		description = "Show an items bonus stats"
	)
	default boolean showBonuses()
	{
		return true;
	}

	@ConfigItem(
		keyName = "useHotkeyToShow",
		name = "Use Hotkey To Show (Ctrl)",
		description = "Use Ctrl hotkey when hovering an item to show."
	)
	default boolean useHotkeyToShow()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEmptyBonuses",
		name = "Show Empty Bonuses",
		description = "Show bonuses that are equal to zero."
	)
	default boolean showEmptyBonuses()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enableOnFloorItems",
		name = "Enable On Floor Items",
		description = "Try to retrieve information on the top most floor item."
	)
	default boolean enableOnFloorItems()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableOnBankItems",
		name = "Enable On Bank Items",
		description = "Retrieve item information for bank items."
	)
	default boolean enableOnBankItems()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAlchemyInfo",
		name = "Show Alchemy Info",
		description = "Show low & high alchemy values."
	)
	default boolean showAlchemyInfo()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBuyLimit",
		name = "Show Buy Limit",
		description = "Show GE buy limit amount."
	)
	default boolean showBuyLimit()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWeight",
		name = "Show Weight",
		description = "Show the items weight."
	)
	default boolean showWeight()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDescription",
		name = "Show Item Description",
		description = "Show the items description."
	)
	default boolean showDescription()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCost",
		name = "Show Item Cost",
		description = "Show the base cost of the item."
	)
	default boolean showCost()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showIsMemberOrFreeToPlay",
		name = "Show Member / F2P",
		description = "Shows whether an item is members or free to play."
	)
	default boolean showIsMemberOrFreeToPlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showIsTradable",
		name = "Show Is Tradeable",
		description = "Shows whether an item is tradeable or not."
	)
	default boolean showIsTradable()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showIsQuestItem",
		name = "Show Is Quest Item",
		description = "Shows if it's a quest item."
	)
	default boolean showIsQuestItem()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showIsNoteable",
		name = "Show Is Noteable",
		description = "Shows whether an item is noteable or not."
	)
	default boolean showIsNoteable()
	{
		return false;
	}
}
