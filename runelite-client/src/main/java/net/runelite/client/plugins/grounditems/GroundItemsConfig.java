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
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;
import net.runelite.client.plugins.grounditems.config.ItemHighlightMode;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import net.runelite.client.plugins.grounditems.config.PriceDisplayMode;
import net.runelite.client.plugins.grounditems.config.TimerDisplayMode;
import net.runelite.client.plugins.grounditems.config.ValueCalculationMode;

@ConfigGroup("grounditems")
public interface GroundItemsConfig extends Config
{
	@ConfigTitleSection(
		keyName = "colorsTitle",
		name = "Colors",
		description = "",
		position = 1
	)
	default Title colorsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "defaultColor",
		name = "Default items",
		description = "Configures the color for default, non-highlighted items",
		position = 2,
		titleSection = "colorsTitle"
	)
	@Alpha
	default Color defaultColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "highlightedColor",
		name = "Highlighted items",
		description = "Configures the color for highlighted items",
		position = 3,
		titleSection = "colorsTitle"
	)
	@Alpha
	default Color highlightedColor()
	{
		return Color.decode("#C46AFF");
	}

	@ConfigItem(
		keyName = "hiddenColor",
		name = "Hidden items",
		description = "Configures the color for hidden items in right-click menu and when holding ALT",
		position = 4,
		titleSection = "colorsTitle"
	)
	@Alpha
	default Color hiddenColor()
	{
		return Color.GRAY;
	}

	@ConfigTitleSection(
		keyName = "highlightedTitle",
		name = "Highlighted",
		description = "",
		position = 5
	)
	default Title highlightedTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "highlightedItems",
		name = "Highlighted Items",
		description = "Configures specifically highlighted ground items. Format: (item), (item)",
		position = 6,
		titleSection = "highlightedTitle"
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
		titleSection = "highlightedTitle"
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
		titleSection = "highlightedTitle"
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
		titleSection = "highlightedTitle"
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
		titleSection = "highlightTitle"
	)
	default boolean notifyHighlightedDrops()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "hiddenTitle",
		name = "Hidden",
		description = "",
		position = 11
	)
	default Title hiddenTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "dontHideUntradeables",
		name = "Do not hide untradeables",
		description = "Configures whether or not untradeable items ignore hiding under settings",
		position = 12,
		titleSection = "hiddenTitle"
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
		titleSection = "hiddenTitle"
	)
	default String getHiddenItems()
	{
		return "Vial, Ashes, Coins, Bones, Bucket, Jug, Seaweed";
	}

	@ConfigItem(
		keyName = "hiddenItems",
		name = "",
		description = "",
		titleSection = "hiddenTitle"
	)
	void setHiddenItems(String key);

	@ConfigItem(
		keyName = "recolorMenuHiddenItems",
		name = "Recolor Menu Hidden Items",
		description = "Configures whether or not hidden items in right click menu will be recolored",
		position = 14,
		titleSection = "hiddenTitle"
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
		titleSection = "hiddenTitle"
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
		titleSection = "hiddenTitle"
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
		titleSection = "hiddenTitle"
	)
	default boolean rightClickHidden()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "highlightTitle",
		name = "Highlight",
		description = "",
		position = 18
	)
	default Title highlightTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "highlightTiles",
		name = "Highlight Tiles",
		description = "Configures whether or not to highlight tiles containing ground items",
		position = 19,
		titleSection = "highlightTitle"
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
		titleSection = "highlightTitle"
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
		titleSection = "highlightTitle"
	)
	default MenuHighlightMode menuHighlightMode()
	{
		return MenuHighlightMode.NAME;
	}

	@ConfigTitleSection(
		keyName = "lowValueTitle",
		name = "Low value",
		description = "",
		position = 22
	)
	default Title lowValueTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "lowValueColor",
		name = "Low value color",
		description = "Configures the color for low value items",
		position = 23,
		titleSection = "lowValueTitle"
	)
	@Alpha
	default Color lowValueColor()
	{
		return Color.decode("#66B2FF");
	}

	@ConfigItem(
		keyName = "lowValuePrice",
		name = "Low value price",
		description = "Configures the start price for low value items",
		position = 24,
		titleSection = "lowValueTitle"
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
		titleSection = "lowValueTitle"
	)
	default boolean notifyLowValueDrops()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "mediumValueTitle",
		name = "Medium value",
		description = "",
		position = 26
	)
	default Title mediumValueTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "mediumValueColor",
		name = "Medium value color",
		description = "Configures the color for medium value items",
		position = 27,
		titleSection = "mediumValueTitle"
	)
	@Alpha
	default Color mediumValueColor()
	{
		return Color.decode("#99FF99");
	}

	@ConfigItem(
		keyName = "mediumValuePrice",
		name = "Medium value price",
		description = "Configures the start price for medium value items",
		position = 28,
		titleSection = "mediumValueTitle"
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
		titleSection = "mediumValueTitle"
	)
	default boolean notifyMediumValueDrops()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "highValueTitle",
		name = "High value",
		description = "",
		position = 30
	)
	default Title highValueTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "highValueColor",
		name = "High value color",
		description = "Configures the color for high value items",
		position = 31,
		titleSection = "highValueTitle"
	)
	@Alpha
	default Color highValueColor()
	{
		return Color.decode("#FF9600");
	}

	@ConfigItem(
		keyName = "highValuePrice",
		name = "High value price",
		description = "Configures the start price for high value items",
		position = 32,
		titleSection = "highValueTitle"
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
		titleSection = "highValueTitle"
	)
	default boolean notifyHighValueDrops()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "insaneValueTitle",
		name = "Insane value",
		description = "",
		position = 34
	)
	default Title insaneValueTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "insaneValueColor",
		name = "Insane value items color",
		description = "Configures the color for insane value items",
		position = 35,
		titleSection = "insaneValueTitle"
	)
	@Alpha
	default Color insaneValueColor()
	{
		return Color.decode("#FF66B2");
	}

	@ConfigItem(
		keyName = "insaneValuePrice",
		name = "Insane value price",
		description = "Configures the start price for insane value items",
		position = 36,
		titleSection = "insaneValueTitle"
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
		titleSection = "insaneValueTitle"
	)
	default boolean notifyInsaneValueDrops()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "priceTitle",
		name = "Price",
		description = "",
		position = 38
	)
	default Title priceTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "priceDisplayMode",
		name = "Price Display Mode",
		description = "Configures what price types are shown alongside of ground item name",
		position = 39,
		titleSection = "priceTitle"
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
		titleSection = "priceTitle"
	)
	default boolean sortByGEPrice()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "miscTitle",
		name = "Miscellaneous",
		description = "",
		position = 41
	)
	default Title miscTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "showMenuItemQuantities",
		name = "Show Menu Item Quantities",
		description = "Configures whether or not to show the item quantities in the menu",
		position = 42,
		titleSection = "miscTitle"
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
		titleSection = "miscTitle"
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
		titleSection = "miscTitle"
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
		titleSection = "miscTitle"
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
		titleSection = "miscTitle"
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
		titleSection = "miscTitle"
	)
	default boolean toggleOutline()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "bordercolor",
		name = "Border color",
		description = "Change the border color",
		position = 48,
		titleSection = "miscTitle"
	)
	default Color bordercolor()
	{
		return new Color(0, 0, 0, 150);
	}

	@ConfigItem(
		keyName = "showTimer",
		name = "Show ground item tick countdown timer",
		description = "Shows how many ticks left until disappearing.",
		position = 49,
		titleSection = "miscTitle"
	)
	default boolean showTimer()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "xpTitle",
		name = "XP",
		description = "Highlights various items that give xp",
		position = 50
	)
	default Title xpTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "highlightHerblore",
		name = "Highlight Herblore xp",
		description = "Highlight Herblore xp related items.",
		position = 51,
		titleSection = "xpTitle"
	)
	default boolean highlightHerblore()
	{
		return false;
	}

	@ConfigItem(
		keyName = "herbloreColor",
		name = "Herblore Color",
		description = "Color of Herblore xp items.",
		position = 52,
		titleSection = "xpTitle"
	)
	@Alpha
	default Color herbloreColor()
	{
		return Color.GREEN.darker();
	}

	@ConfigItem(
		keyName = "highlightPrayer",
		name = "Highlight Prayer xp",
		description = "Highlight Prayer xp related items.",
		position = 53,
		titleSection = "xpTitle"
	)
	default boolean highlightPrayer()
	{
		return false;
	}

	@ConfigItem(
		keyName = "prayerColor",
		name = "Prayer Color",
		description = "Color of Prayer xp items.",
		position = 54,
		titleSection = "xpTitle"
	)
	@Alpha
	default Color prayerColor()
	{
		return Color.YELLOW;
	}
}
