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
import net.runelite.client.plugins.grounditems.config.ValueCalculationMode;

@ConfigGroup("grounditems")
public interface GroundItemsConfig extends Config
{
	@ConfigItem(
<<<<<<< HEAD
		keyName = "showHighlightedOnly",
		name = "Show Highlighted items only",
		description = "Configures whether or not to draw items only on your highlighted list",
		position = 1
=======
		keyName = "highlightedItems",
		name = "Highlighted Items",
		description = "Configures specifically highlighted ground items. Format: (item), (item)",
		position = 0
	)
	default String getHighlightItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "highlightedItems",
		name = "",
		description = ""
	)
	void setHighlightedItem(String key);

	@ConfigItem(
		keyName = "hiddenItems",
		name = "Hidden Items",
		description = "Configures hidden ground items. Format: (item), (item)",
		position = 1
	)
	default String getHiddenItems()
	{
		return "Vial, Ashes, Coins, Bones, Bucket, Jug, Seaweed";
	}

	@ConfigItem(
		keyName = "hiddenItems",
		name = "",
		description = ""
	)
	void setHiddenItems(String key);

	@ConfigItem(
		keyName = "showHighlightedOnly",
		name = "Show Highlighted items only",
		description = "Configures whether or not to draw items only on your highlighted list",
<<<<<<< HEAD
		position = 3
>>>>>>> upstream/master
=======
		position = 2
>>>>>>> upstream/master
	)
	default boolean showHighlightedOnly()
	{
		return false;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "showGEPrice",
		name = "Show Grand Exchange Prices",
		description = "Configures whether or not to draw GE prices alongside ground items",
<<<<<<< HEAD
		position = 2
=======
=======
		keyName = "dontHideUntradeables",
		name = "Do not hide untradeables",
		description = "Configures whether or not untradeable items ignore hiding under settings",
		position = 3
	)
	default boolean dontHideUntradeables()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMenuItemQuantities",
		name = "Show Menu Item Quantities",
		description = "Configures whether or not to show the item quantities in the menu",
>>>>>>> upstream/master
		position = 4
>>>>>>> upstream/master
	)
	default boolean showMenuItemQuantities()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "showHAValue",
		name = "Show High Alchemy Values",
		description = "Configures whether or not to draw High Alchemy values alongside ground items",
<<<<<<< HEAD
		position = 3
=======
=======
		keyName = "recolorMenuHiddenItems",
		name = "Recolor Menu Hidden Items",
		description = "Configures whether or not hidden items in right click menu will be recolored",
>>>>>>> upstream/master
		position = 5
>>>>>>> upstream/master
	)
	default boolean recolorMenuHiddenItems()
	{
		return false;
	}
	
	@ConfigItem(
<<<<<<< HEAD
		keyName = "showMenuItemQuantities",
		name = "Show Menu Item Quantities",
		description = "Configures whether or not to show the item quantities in the menu",
<<<<<<< HEAD
		position = 4
=======
=======
		keyName = "highlightTiles",
		name = "Highlight Tiles",
		description = "Configures whether or not to highlight tiles containing ground items",
>>>>>>> upstream/master
		position = 6
>>>>>>> upstream/master
	)
	default boolean highlightTiles() 
	{ 
		return false; 
	}

	@ConfigItem(
		keyName = "notifyHighlightedDrops",
		name = "Notify for Highlighted drops",
		description = "Configures whether or not to notify for drops on your highlighted list",
		position = 7
	)
	default boolean notifyHighlightedDrops()
	{
		return false;
	}

	@ConfigItem(
		keyName = "priceDisplayMode",
		name = "Price Display Mode",
		description = "Configures what price types are shown alongside of ground item name",
		position = 8
	)
	default PriceDisplayMode priceDisplayMode()
	{
		return PriceDisplayMode.BOTH;
	}

	@ConfigItem(
		keyName = "itemHighlightMode",
		name = "Item Highlight Mode",
		description = "Configures how ground items will be highlighted",
<<<<<<< HEAD
<<<<<<< HEAD
		position = 5
=======
		position = 7
>>>>>>> upstream/master
=======
		position = 9
>>>>>>> upstream/master
	)
	default ItemHighlightMode itemHighlightMode()
	{
		return ItemHighlightMode.BOTH;
	}

	@ConfigItem(
		keyName = "menuHighlightMode",
		name = "Menu Highlight Mode",
		description = "Configures what to highlight in right-click menu",
<<<<<<< HEAD
<<<<<<< HEAD
		position = 6
=======
		position = 8
>>>>>>> upstream/master
=======
		position = 10
>>>>>>> upstream/master
	)
	default MenuHighlightMode menuHighlightMode()
	{
		return MenuHighlightMode.NAME;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "hideUnderGeValue",
		name = "Hide < GE Value",
		description = "Configures hidden ground items under GE value",
<<<<<<< HEAD
		position = 7
=======
		position = 9
>>>>>>> upstream/master
=======
		keyName = "highlightValueCalculation",
		name = "Highlight Value Calculation",
		description = "Configures which coin value is used to determine highlight color",
		position = 11
>>>>>>> upstream/master
	)
	default ValueCalculationMode valueCalculationMode()
	{
		return ValueCalculationMode.HIGHEST;
	}

	@ConfigItem(
		keyName = "highlightOverValue2",
		name = "Highlight > Value",
		description = "Configures highlighted ground items over either GE or HA value",
		position = 12
	)
	default int getHighlightOverValue()
	{
		return 0;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "hideUnderHaValue",
		name = "Hide < HA Value",
		description = "Configures hidden ground items under High Alch value",
<<<<<<< HEAD
		position = 8
=======
		position = 10
>>>>>>> upstream/master
=======
		keyName = "hideUnderValue",
		name = "Hide < Value",
		description = "Configures hidden ground items under both GE and HA value",
		position = 13
>>>>>>> upstream/master
	)
	default int getHideUnderValue()
	{
		return 0;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "highlightedItems",
		name = "Highlighted Items",
		description = "Configures specifically highlighted ground items. Format: (item), (item)",
		position = 9
	)
	default String getHighlightItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "highlightedItems",
		name = "",
		description = ""
	)
	void setHighlightedItem(String key);

	@ConfigItem(
		keyName = "hiddenItems",
		name = "Hidden Items",
		description = "Configures hidden ground items. Format: (item), (item)",
		position = 10
	)
	default String getHiddenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "hiddenItems",
		name = "",
		description = ""
	)
	void setHiddenItems(String key);

	@ConfigItem(
=======
>>>>>>> upstream/master
		keyName = "defaultColor",
		name = "Default items color",
		description = "Configures the color for default, non-highlighted items",
		position = 14
	)
	default Color defaultColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "highlightedColor",
		name = "Highlighted items color",
		description = "Configures the color for highlighted items",
		position = 15
	)
	default Color highlightedColor()
	{
		return Color.decode("#AA00FF");
	}

	@ConfigItem(
		keyName = "hiddenColor",
		name = "Hidden items color",
		description = "Configures the color for hidden items in right-click menu and when holding ALT",
		position = 16
	)
	default Color hiddenColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "lowValueColor",
		name = "Low value items color",
		description = "Configures the color for low value items",
		position = 17
	)
	default Color lowValueColor()
	{
		return Color.decode("#66B2FF");
	}

	@ConfigItem(
		keyName = "lowValuePrice",
		name = "Low value price",
		description = "Configures the start price for low value items",
		position = 18
	)
	default int lowValuePrice()
	{
		return 20000;
	}

	@ConfigItem(
		keyName = "mediumValueColor",
		name = "Medium value items color",
		description = "Configures the color for medium value items",
		position = 19
	)
	default Color mediumValueColor()
	{
		return Color.decode("#99FF99");
	}

	@ConfigItem(
		keyName = "mediumValuePrice",
		name = "Medium value price",
		description = "Configures the start price for medium value items",
		position = 20
	)
	default int mediumValuePrice()
	{
		return 100000;
	}

	@ConfigItem(
		keyName = "highValueColor",
		name = "High value items color",
		description = "Configures the color for high value items",
		position = 21
	)
	default Color highValueColor()
	{
		return Color.decode("#FF9600");
	}

	@ConfigItem(
		keyName = "highValuePrice",
		name = "High value price",
		description = "Configures the start price for high value items",
		position = 22
	)
	default int highValuePrice()
	{
		return 1000000;
	}

	@ConfigItem(
		keyName = "insaneValueColor",
		name = "Insane value items color",
		description = "Configures the color for insane value items",
		position = 23
	)
	default Color insaneValueColor()
	{
		return Color.decode("#FF66B2");
	}

	@ConfigItem(
		keyName = "insaneValuePrice",
		name = "Insane value price",
		description = "Configures the start price for insane value items",
		position = 24
	)
	default int insaneValuePrice()
	{
		return 10000000;
	}

	@ConfigItem(
		keyName = "onlyShowLoot",
		name = "Only show loot",
		description = "Only shows drops from NPCs and players",
		position = 25
	)
	default boolean onlyShowLoot()
	{
		return false;
	}

	@ConfigItem(
		keyName = "doubleTapDelay",
		name = "Delay for double-tap ALT to hide",
		description = "Decrease this number if you accidentally hide ground items often. (0 = Disabled)",
		position = 26
	)
	default int doubleTapDelay()
	{
		return 250;
	}

	@ConfigItem(
		keyName = "collapseEntries",
		name = "Collapse ground item menu entries",
		description = "Collapses ground item menu entries together and appends count",
		position = 27
	)
	default boolean collapseEntries()
	{
		return false;
	}
}
