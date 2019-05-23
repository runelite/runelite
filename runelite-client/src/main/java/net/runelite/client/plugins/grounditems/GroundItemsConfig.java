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
import net.runelite.client.config.Stub;
import net.runelite.client.plugins.grounditems.config.ItemHighlightMode;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import net.runelite.client.plugins.grounditems.config.PriceDisplayMode;
import net.runelite.client.plugins.grounditems.config.TimerDisplayMode;
import net.runelite.client.plugins.grounditems.config.ValueCalculationMode;

@ConfigGroup("grounditems")
public interface GroundItemsConfig extends Config
{
	@ConfigItem(
		keyName = "colorsStub",
		name = "Colors",
		description = "",
		position = 1
	)
	default Stub colorsStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "defaultColor",
		name = "Default items",
		description = "Configures the color for default, non-highlighted items",
		position = 2,
		parent = "colorsStub"
	)
	default Color defaultColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "highlightedColor",
		name = "Highlighted items",
		description = "Configures the color for highlighted items",
		position = 3,
		parent = "colorsStub"
	)
	default Color highlightedColor()
	{
		return Color.decode("#AA00FF");
	}

	@ConfigItem(
		keyName = "hiddenColor",
		name = "Hidden items",
		description = "Configures the color for hidden items in right-click menu and when holding ALT",
		position = 4,
		parent = "colorsStub"
	)
	default Color hiddenColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "highlightedStub",
		name = "Highlighted",
		description = "",
		position = 5
	)
	default Stub highlightedStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "highlightedItems",
		name = "Highlighted Items",
		description = "Configures specifically highlighted ground items. Format: (item), (item)",
		position = 6,
		parent = "highlightedStub"
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
		keyName = "showHighlightedOnly",
		name = "Show Highlighted items only",
		description = "Configures whether or not to draw items only on your highlighted list",
		position = 7,
		parent = "highlightedStub"
	)
	default boolean showHighlightedOnly()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightValueCalculation",
		name = "Highlighted Value Calculation",
		description = "Configures which coin value is used to determine highlight color",
		position = 8,
		parent = "highlightedStub"
	)
	default ValueCalculationMode valueCalculationMode()
	{
		return ValueCalculationMode.HIGHEST;
	}

	@ConfigItem(
		keyName = "highlightOverValue2",
		name = "Highlight > Value",
		description = "Configures highlighted ground items over either GE or HA value",
		position = 9,
		parent = "highlightedStub"
	)
	default int getHighlightOverValue()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "notifyHighlightedDrops",
		name = "Notify for Highlighted drops",
		description = "Configures whether or not to notify for drops on your highlighted list",
		position = 10,
		parent = "highlightStub"
	)
	default boolean notifyHighlightedDrops()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hiddenStub",
		name = "Hidden",
		description = "",
		position = 11
	)
	default Stub hiddenStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "dontHideUntradeables",
		name = "Do not hide untradeables",
		description = "Configures whether or not untradeable items ignore hiding under settings",
		position = 12,
		parent = "hiddenStub"
	)
	default boolean dontHideUntradeables()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hiddenItems",
		name = "Hidden Items",
		description = "Configures hidden ground items. Format: (item), (item)",
		position = 13,
		parent = "hiddenStub"
	)
	default String getHiddenItems()
	{
		return "Vial, Ashes, Coins, Bones, Bucket, Jug, Seaweed";
	}

	@ConfigItem(
		keyName = "hiddenItems",
		name = "",
		description = "",
		parent = "hiddenStub"
	)
	void setHiddenItems(String key);

	@ConfigItem(
		keyName = "recolorMenuHiddenItems",
		name = "Recolor Menu Hidden Items",
		description = "Configures whether or not hidden items in right click menu will be recolored",
		position = 14,
		parent = "hiddenStub"
	)
	default boolean recolorMenuHiddenItems()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideUnderValue",
		name = "Hide < Value",
		description = "Configures hidden ground items under both GE and HA value",
		position = 15,
		parent = "hiddenStub"
	)
	default int getHideUnderValue()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "removeIgnored",
		name = "Hide Hidden",
		description = "Remove take option for items that are on the hidden items list.",
		position = 16,
		parent = "hiddenStub"
	)
	default boolean removeIgnored()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickHidden",
		name = "Right click hidden items",
		description = "Places hidden items below the 'Walk here' option, making it so that you need to right click to pick them up",
		position = 17,
		parent = "hiddenStub"
	)
	default boolean rightClickHidden()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightStub",
		name = "Highlight",
		description = "",
		position = 18
	)
	default Stub highlightStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "highlightTiles",
		name = "Highlight Tiles",
		description = "Configures whether or not to highlight tiles containing ground items",
		position = 19,
		parent = "highlightStub"
	)
	default boolean highlightTiles()
	{
		return false;
	}
	@ConfigItem(
		keyName = "itemHighlightMode",
		name = "Item Highlight Mode",
		description = "Configures how ground items will be highlighted",
		position = 20,
		parent = "highlightStub"
	)
	default ItemHighlightMode itemHighlightMode()
	{
		return ItemHighlightMode.BOTH;
	}

	@ConfigItem(
		keyName = "menuHighlightMode",
		name = "Menu Highlight Mode",
		description = "Configures what to highlight in right-click menu",
		position = 21,
		parent = "highlightStub"
	)
	default MenuHighlightMode menuHighlightMode()
	{
		return MenuHighlightMode.NAME;
	}

	@ConfigItem(
		keyName = "lowValueStub",
		name = "Low value",
		description = "",
		position = 22
	)
	default Stub lowValueStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "lowValueColor",
		name = "Low value color",
		description = "Configures the color for low value items",
		position = 23,
		parent = "lowValueStub"
	)
	default Color lowValueColor()
	{
		return Color.decode("#66B2FF");
	}

	@ConfigItem(
		keyName = "lowValuePrice",
		name = "Low value price",
		description = "Configures the start price for low value items",
		position = 24,
		parent = "lowValueStub"
	)
	default int lowValuePrice()
	{
		return 20000;
	}

	@ConfigItem(
		keyName = "notifyLowValueDrops",
		name = "Notify for low value drops",
		description = "Configures whether or not to notify for drops of low value",
		position = 25,
		parent = "lowValueStub"
	)
	default boolean notifyLowValueDrops()
	{
		return false;
	}

	@ConfigItem(
		keyName = "mediumValueStub",
		name = "Medium value",
		description = "",
		position = 26
	)
	default Stub mediumValueStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "mediumValueColor",
		name = "Medium value color",
		description = "Configures the color for medium value items",
		position = 27,
		parent = "mediumValueStub"
	)
	default Color mediumValueColor()
	{
		return Color.decode("#99FF99");
	}

	@ConfigItem(
		keyName = "mediumValuePrice",
		name = "Medium value price",
		description = "Configures the start price for medium value items",
		position = 28,
		parent = "mediumValueStub"
	)
	default int mediumValuePrice()
	{
		return 100000;
	}

	@ConfigItem(
		keyName = "notifyMediumValueDrops",
		name = "Notify for medium value drops",
		description = "Configures whether or not to notify for drops of medium value",
		position = 29,
		parent = "mediumValueStub"
	)
	default boolean notifyMediumValueDrops()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highValueStub",
		name = "High value",
		description = "",
		position = 30
	)
	default Stub highValueStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "highValueColor",
		name = "High value color",
		description = "Configures the color for high value items",
		position = 31,
		parent = "highValueStub"
	)
	default Color highValueColor()
	{
		return Color.decode("#FF9600");
	}

	@ConfigItem(
		keyName = "highValuePrice",
		name = "High value price",
		description = "Configures the start price for high value items",
		position = 32,
		parent = "highValueStub"
	)
	default int highValuePrice()
	{
		return 1000000;
	}

	@ConfigItem(
		keyName = "notifyHighValueDrops",
		name = "Notify for high value drops",
		description = "Configures whether or not to notify for drops of high value",
		position = 33,
		parent = "highValueStub"
	)
	default boolean notifyHighValueDrops()
	{
		return false;
	}

	@ConfigItem(
		keyName = "insaneValueStub",
		name = "Insane value",
		description = "",
		position = 34
	)
	default Stub insaneValueStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "insaneValueColor",
		name = "Insane value items color",
		description = "Configures the color for insane value items",
		position = 35,
		parent = "insaneValueStub"
	)
	default Color insaneValueColor()
	{
		return Color.decode("#FF66B2");
	}

	@ConfigItem(
		keyName = "insaneValuePrice",
		name = "Insane value price",
		description = "Configures the start price for insane value items",
		position = 36,
		parent = "insaneValueStub"
	)
	default int insaneValuePrice()
	{
		return 10000000;
	}

	@ConfigItem(
		keyName = "notifyInsaneValueDrops",
		name = "Notify for insane value drops",
		description = "Configures whether or not to notify for drops of insane value",
		position = 37,
		parent = "insaneValueStub"
	)
	default boolean notifyInsaneValueDrops()
	{
		return false;
	}

	@ConfigItem(
		keyName = "priceStub",
		name = "Price",
		description = "",
		position = 38
	)
	default Stub priceStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "priceDisplayMode",
		name = "Price Display Mode",
		description = "Configures what price types are shown alongside of ground item name",
		position = 39,
		parent = "priceStub"
	)
	default PriceDisplayMode priceDisplayMode()
	{
		return PriceDisplayMode.BOTH;
	}

	@ConfigItem(
		keyName = "sortByGEPrice",
		name = "Sort by GE price",
		description = "Sorts ground items by GE price, instead of alch value",
		position = 40,
		parent = "priceStub"
	)
	default boolean sortByGEPrice()
	{
		return false;
	}

	@ConfigItem(
		keyName = "miscStub",
		name = "Miscellaneous",
		description = "",
		position = 41
	)
	default Stub miscStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "showMenuItemQuantities",
		name = "Show Menu Item Quantities",
		description = "Configures whether or not to show the item quantities in the menu",
		position = 42,
		parent = "miscStub"
	)
	default boolean showMenuItemQuantities()
	{
		return true;
	}

	@ConfigItem(
		keyName = "collapseEntries",
		name = "Collapse ground item menu entries",
		description = "Collapses ground item menu entries together and appends count",
		position = 43,
		parent = "miscStub"
	)
	default boolean collapseEntries()
	{
		return false;
	}

	@ConfigItem(
		keyName = "onlyShowLoot",
		name = "Only show loot",
		description = "Only shows drops from NPCs and players",
		position = 44,
		parent = "miscStub"
	)
	default boolean onlyShowLoot()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showGroundItemDuration",
		name = "Show time remaining",
		description = "Turn on a countdown timer to show how long an item will remain on the ground",
		position = 45,
		parent = "miscStub"
	)
	default TimerDisplayMode showGroundItemDuration()
	{
		return TimerDisplayMode.HOTKEY_PRESSED;
	}

	@ConfigItem(
		keyName = "doubleTapDelay",
		name = "Delay for double-tap ALT to hide",
		description = "Decrease this number if you accidentally hide ground items often. (0 = Disabled)",
		position = 46,
		parent = "miscStub"
	)
	default int doubleTapDelay()
	{
		return 250;
	}

	@ConfigItem(
		keyName = "toggleOutline",
		name = "Text Outline",
		description = "Use an outline around text instead of a text shadow",
		position = 47,
		parent = "miscStub"
	)
	default boolean toggleOutline()
	{
		return false;
	}
}
