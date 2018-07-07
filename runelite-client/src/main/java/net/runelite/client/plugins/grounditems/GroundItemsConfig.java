/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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

package net.runelite.client.plugins.grounditems;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.grounditems.config.ItemHighlightMode;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import net.runelite.client.plugins.grounditems.config.PriceDisplayMode;

@ConfigGroup("It's coming home")
public interface GroundItemsConfig extends Config
{
	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 0
	)
	default String getHighlightItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "",
		description = ""
	)
	void setHighlightedItem(String key);

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 1
	)
	default String getHiddenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "",
		description = ""
	)
	void setHiddenItems(String key);

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 2
	)
	default boolean showHighlightedOnly()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 3
	)
	default boolean dontHideUntradeables()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 4
	)
	default boolean showMenuItemQuantities()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 5
	)
	default boolean recolorMenuHiddenItems()
	{
		return false;
	}
	
	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 6
	)
	default boolean highlightTiles() 
	{ 
		return false; 
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 7
	)
	default PriceDisplayMode priceDisplayMode()
	{
		return PriceDisplayMode.BOTH;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 8
	)
	default ItemHighlightMode itemHighlightMode()
	{
		return ItemHighlightMode.BOTH;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 9
	)
	default MenuHighlightMode menuHighlightMode()
	{
		return MenuHighlightMode.NAME;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 10
	)
	default int getHighlightOverValue()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 11
	)
	default int getHideUnderValue()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 12
	)
	default Color defaultColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 13
	)
	default Color highlightedColor()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 14
	)
	default Color hiddenColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 15
	)
	default Color lowValueColor()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 16
	)
	default int lowValuePrice()
	{
		return 20000;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 17
	)
	default Color mediumValueColor()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 18
	)
	default int mediumValuePrice()
	{
		return 100000;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 19
	)
	default Color highValueColor()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 20
	)
	default int highValuePrice()
	{
		return 1000000;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 21
	)
	default Color insaneValueColor()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 22
	)
	default int insaneValuePrice()
	{
		return 10000000;
	}
}
