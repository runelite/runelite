/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, alanbaumgartner <https://github.com/alanbaumgartner>
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package net.runelite.client.plugins.menuentryswapper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.plugins.menuentryswapper.util.ArdougneCloakMode;
import net.runelite.client.plugins.menuentryswapper.util.BurningAmuletMode;
import net.runelite.client.plugins.menuentryswapper.util.CharterOption;
import net.runelite.client.plugins.menuentryswapper.util.CombatBraceletMode;
import net.runelite.client.plugins.menuentryswapper.util.ConstructionCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.ConstructionMode;
import net.runelite.client.plugins.menuentryswapper.util.DigsitePendantMode;
import net.runelite.client.plugins.menuentryswapper.util.DuelingRingMode;
import net.runelite.client.plugins.menuentryswapper.util.FairyRingMode;
import net.runelite.client.plugins.menuentryswapper.util.FairyTreeMode;
import net.runelite.client.plugins.menuentryswapper.util.GamesNecklaceMode;
import net.runelite.client.plugins.menuentryswapper.util.GloryMode;
import net.runelite.client.plugins.menuentryswapper.util.HouseAdvertisementMode;
import net.runelite.client.plugins.menuentryswapper.util.HouseMode;
import net.runelite.client.plugins.menuentryswapper.util.MaxCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.NecklaceOfPassageMode;
import net.runelite.client.plugins.menuentryswapper.util.ObeliskMode;
import net.runelite.client.plugins.menuentryswapper.util.OccultAltarMode;
import net.runelite.client.plugins.menuentryswapper.util.QuestCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.RingOfWealthMode;
import net.runelite.client.plugins.menuentryswapper.util.SkillsNecklaceMode;
import net.runelite.client.plugins.menuentryswapper.util.SlayerRingMode;
import net.runelite.client.plugins.menuentryswapper.util.SwapGrimyHerbMode;
import net.runelite.client.plugins.menuentryswapper.util.XericsTalismanMode;


@ConfigGroup("menuentryswapper")
public interface MenuEntrySwapperConfig extends Config
{
	@ConfigSection(
		name = "Banking",
		description = "",
		position = 0,
		keyName = "bankingSection"
	)
	default boolean bankingSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Equipment Swapper",
		description = "",
		position = 1,
		keyName = "equipmentSwapperSection"
	)
	default boolean equipmentSwapperSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Miscellaneous",
		description = "",
		position = 1,
		keyName = "miscellaneousSection"
	)
	default boolean miscellaneousSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Shop / Stores",
		description = "",
		position = 1,
		keyName = "shopStoresSection"
	)
	default boolean shopStoresSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Skilling",
		description = "",
		position = 1,
		keyName = "skillingSection"
	)
	default boolean skillingSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Talk-To",
		description = "",
		position = 1,
		keyName = "talkSection"
	)
	default boolean talkSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Teleportation",
		description = "",
		position = 1,
		keyName = "teleportationSection"
	)
	default boolean teleportationSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Right Click Options",
		description = "",
		position = 1,
		keyName = "rightClickOptionsSection"
	)
	default boolean rightClickOptionsSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Untradeables",
		description = "",
		position = 1,
		keyName = "untradeablesSection"
	)
	default boolean untradeablesSection()
	{
		return false;
	}

	@ConfigSection(
		name = "PvM",
		description = "",
		position = 1,
		keyName = "pvmSection"
	)
	default boolean pvmSection()
	{
		return false;
	}

	//------------------------------------------------------------//
	// Banking
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "withdrawOne",
		name = "Withdraw/Deposit One",
		description = "",
		position = 0,
		section = "bankingSection"
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
		section = "bankingSection",
		hidden = true,
		unhide = "withdrawOne"
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
		section = "bankingSection"
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
		section = "bankingSection",
		hidden = true,
		unhide = "withdrawFive"
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
		section = "bankingSection"
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
		section = "bankingSection",
		hidden = true,
		unhide = "withdrawTen"
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
		section = "bankingSection"
	)
	default boolean getWithdrawX()
	{
		return false;
	}

	@ConfigItem(
		keyName = "withdrawXItems",
		name = "Items",
		description = "",
		position = 8,
		section = "bankingSection",
		hidden = true,
		unhide = "withdrawX"
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
		section = "bankingSection"
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
		section = "bankingSection",
		hidden = true,
		unhide = "withdrawAll"
	)
	default String getWithdrawAllItems()
	{
		return "";
	}

	//------------------------------------------------------------//
	// Equipment Swapper
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "swapMax",
		name = "Max Cape",
		description = "Enables swapping max cape options in worn interface.",
		position = 0,
		section = "equipmentSwapperSection"
	)
	default boolean swapMax()
	{
		return false;
	}

	@ConfigItem(
		keyName = "maxMode",
		name = "Mode",
		description = "",
		position = 1,
		section = "equipmentSwapperSection",
		hidden = true,
		unhide = "swapMax"
	)
	default MaxCapeMode maxMode()
	{
		return MaxCapeMode.CRAFTING_GUILD;
	}

	@ConfigItem(
		keyName = "swapArdougneCloak",
		name = "Ardougne Cloak",
		description = "Enables swapping of 'Teleport' and 'Wear'.",
		position = 2,
		section = "equipmentSwapperSection"
	)
	default boolean getSwapArdougneCloak()
	{
		return false;
	}

	@ConfigItem(
		keyName = "ardougneCloakMode",
		name = "Mode",
		description = "",
		position = 3,
		section = "equipmentSwapperSection",
		hidden = true,
		unhide = "swapArdougneCloak"
	)
	default ArdougneCloakMode ardougneCloakMode()
	{
		return ArdougneCloakMode.TELE_TO_MONASTERY;
	}

	@ConfigItem(
		keyName = "swapConstructionCape",
		name = "Construction Cape",
		description = "Enables swapping of 'Teleport' and 'Wear'.",
		position = 4,
		section = "equipmentSwapperSection"
	)
	default boolean getSwapConstructionCape()
	{
		return true;
	}

	@ConfigItem(
		keyName = "constructionCapeMode",
		name = "Mode",
		description = "",
		position = 5,
		section = "equipmentSwapperSection",
		hidden = true,
		unhide = "swapConstructionCape"
	)
	default ConstructionCapeMode constructionCapeMode()
	{
		return ConstructionCapeMode.TELE_TO_POH;
	}

	@ConfigItem(
		keyName = "swapCraftingCape",
		name = "Crafting Cape",
		description = "Enables swapping of 'Teleport' and 'Wear'.",
		position = 6,
		section = "equipmentSwapperSection"
	)
	default boolean getSwapCraftingCape()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapMagicCape",
		name = "Magic Cape",
		description = "Enables swapping of 'Spellbook' and 'Wear'.",
		position = 7,
		section = "equipmentSwapperSection"
	)
	default boolean getSwapMagicCape()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapExplorersRing",
		name = "Explorer's Ring",
		description = "Enables swapping of 'Spellbook' and 'Wear'.",
		position = 8,
		section = "equipmentSwapperSection"
	)
	default boolean getSwapExplorersRing()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAdmire",
		name = "Admire",
		description = "Swap 'Admire' with 'Teleport', 'Spellbook' and 'Perks' (max cape) for mounted skill capes.",
		position = 9,
		section = "equipmentSwapperSection"
	)
	default boolean swapAdmire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapQuestCape",
		name = "Quest Cape",
		description = "Enables swapping Quest cape options in worn interface.",
		position = 10,
		section = "equipmentSwapperSection"
	)
	default boolean swapQuestCape()
	{
		return false;
	}

	@ConfigItem(
		keyName = "questCapeMode",
		name = "Mode",
		description = "",
		position = 11,
		section = "equipmentSwapperSection",
		hidden = true,
		unhide = "swapQuestCape"
	)
	default QuestCapeMode questCapeMode()
	{
		return QuestCapeMode.TELEPORT;
	}

	//------------------------------------------------------------//
	// Miscellaneous
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "hotkeyMod",
		name = "Hotkey for Swaps",
		description = "Set this hotkey to do custom swaps on hotkeys.",
		position = 0,
		section = "miscellaneousSection"
	)
	default Keybind hotkeyMod()
	{
		return Keybind.SHIFT;
	}

	@ConfigItem(
		keyName = "customSwaps",
		name = "Custom Swaps",
		description = "Add custom swaps here, 1 per line. Syntax: option,target:priority" +
			"<br>Note that the higher your set the priority, the more it will overtake over swaps.",
		position = 1,
		section = "miscellaneousSection",
		parse = true,
		clazz = CustomSwapParse.class,
		method = "parse"
	)
	default String customSwaps()
	{
		return "";
	}

	@ConfigItem(
		keyName = "shiftCustomSwaps",
		name = "Hotkey Swaps",
		description = "Add custom swaps here that will only be activated when you press your hotkey." +
			"<br>1 per line. Syntax: option,target:priority" +
			"<br>Note that the higher your set the priority, the more it will overtake over swaps.",
		position = 2,
		section = "miscellaneousSection",
		parse = true,
		clazz = CustomSwapParse.class,
		method = "parse"
	)
	default String shiftCustomSwaps()
	{
		return "";
	}

	@ConfigItem(
		keyName = "prioEntry",
		name = "Prioritize Entry",
		description = "This section is mainly for prioritizing entries. For example" +
			"<br>ignoring attack on snakelings at zulrah." +
			"<br>Example Syntax: walk here, snakeling" +
			"<br>Example Syntax: follow, friendsnamehere" +
			"<br>It's important to note that these will not take precedent over other swaps.",
		position = 2,
		section = "miscellaneousSection",
		parse = true,
		clazz = PrioParse.class,
		method = "parse"
	)
	default String prioEntry()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapCoalBag",
		name = "Coal Bag",
		description = "Makes Empty the left click option when in a bank",
		position = 3,
		section = "miscellaneousSection"
	)
	default boolean swapCoalBag()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBirdhouseEmpty",
		name = "Birdhouse",
		description = "Swap 'Interact' with 'Empty' for birdhouses on Fossil Island.",
		position = 4,
		section = "miscellaneousSection"
	)
	default boolean swapBirdhouseEmpty()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBones",
		name = "Bury",
		description = "Swap 'Bury' with 'Use' on Bones.",
		position = 5,
		section = "miscellaneousSection"
	)
	default boolean swapBones()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapChase",
		name = "Chase",
		description = "Allows to left click your cat to chase rats.",
		position = 6,
		section = "miscellaneousSection"
	)
	default boolean swapChase()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap 'Cage', 'Big Net' with 'Harpoon' on Fishing spots.",
		position = 7,
		section = "miscellaneousSection"
	)
	default boolean swapHarpoon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapOccult",
		name = "Occult Altar",
		description = "Swap 'Venerate' with 'Ancient', 'Lunar', or 'Arceuus' on an Altar of the Occult.",
		position = 8,
		section = "miscellaneousSection"
	)
	default boolean swapOccult()
	{
		return false;
	}

	@ConfigItem(
		keyName = "occultalter",
		name = "Mode",
		description = "",
		position = 9,
		section = "miscellaneousSection",
		hidden = true,
		unhide = "swapOccult"
	)
	default OccultAltarMode swapOccultMode()
	{
		return OccultAltarMode.VENERATE;
	}

	@ConfigItem(
		keyName = "swapHomePortal",
		name = "Home",
		description = "Swap 'Enter' with 'Home', 'Build' or 'Friend's house' on Portal.",
		position = 10,
		section = "miscellaneousSection"
	)
	default boolean swapHomePortal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "home",
		name = "Mode",
		description = "",
		position = 11,
		section = "miscellaneousSection",
		hidden = true,
		unhide = "swapHomePortal"
	)
	default HouseMode swapHomePortalMode()
	{
		return HouseMode.HOME;
	}

	@ConfigItem(
		keyName = "swapHouseAd",
		name = "House Ad",
		description = "Swap your house advertisement entries.",
		position = 12,
		section = "miscellaneousSection"
	)
	default boolean swapHouseAd()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapHouseAdMode",
		name = "Mode",
		description = "",
		position = 13,
		section = "miscellaneousSection",
		hidden = true,
		unhide = "swapHouseAd"
	)
	default HouseAdvertisementMode swapHouseAdMode()
	{
		return HouseAdvertisementMode.VIEW;
	}

	@ConfigItem(
		keyName = "swapPrivate",
		name = "Private",
		description = "Swap 'Shared' with 'Private' on the Chambers of Xeric storage units.",
		position = 15,
		section = "miscellaneousSection"
	)
	default boolean swapPrivate()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPick",
		name = "Pick",
		description = "Swap 'Pick' with 'Pick-lots' of the Gourd tree in the Chambers of Xeric.",
		position = 15,
		section = "miscellaneousSection"
	)
	default boolean swapPick()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapQuick",
		name = "Quick Pass/Open/Start/Travel",
		description = "Swap 'Pass' with 'Quick-Pass', 'Open' with 'Quick-Open', 'Ring' with 'Quick-Start' and 'Talk-to' with 'Quick-Travel'.",
		position = 16,
		section = "miscellaneousSection"
	)
	default boolean swapQuick()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBoxTrap",
		name = "Reset",
		description = "Swap 'Check' with 'Reset' on box traps.",
		position = 17,
		section = "miscellaneousSection"
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "rockCake",
		name = "Rock Cake Guzzle",
		description = "Enables Left Click 'Guzzle' on the Dwarven Rock Cake.",
		position = 18,
		section = "miscellaneousSection"
	)
	default boolean rockCake()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapRogueschests",
		name = "Rogues Chests",
		description = "Swap Rogues Chests from 'Open' to 'Search for traps'.",
		position = 19,
		section = "miscellaneousSection"
	)
	default boolean swapRogueschests()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapClimbUpDown",
		name = "Climb",
		description = "Swap 'Climb-Up'/'Climb-Down' depending on Shift or Control key.",
		position = 20,
		section = "miscellaneousSection"
	)
	default boolean swapClimbUpDown()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapStun",
		name = "Stun Hoop Snakes",
		description = "Swap 'Attack' with 'Stun'.",
		position = 21,
		section = "miscellaneousSection"
	)
	default boolean swapStun()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapSearch",
		name = "Search",
		description = "Swap 'Close', 'Shut' with 'Search' on chests, cupboards, etc.",
		position = 22,
		section = "miscellaneousSection"
	)
	default boolean swapSearch()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHardWoodGrove",
		name = "Hardwood Grove",
		description = "Swap 'Quick-Pay(100)' and 'Send-Parcel' at Hardwood Grove.",
		position = 23,
		section = "miscellaneousSection"
	)
	default boolean swapHardWoodGrove()
	{
		return true;
	}


	@ConfigItem(
		keyName = "removeObjects",
		name = "Remove Objects",
		description = "Removes interaction with the listed objects.",
		position = 24,
		section = "miscellaneousSection"
	)
	default boolean getRemoveObjects()
	{
		return false;
	}

	@ConfigItem(
		keyName = "removedObjects",
		name = "Objects",
		description = "Objects listed here will have all interaction be removed.",
		position = 25,
		section = "miscellaneousSection",
		hidden = true,
		unhide = "removeObjects"
	)
	default String getRemovedObjects()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapImps",
		name = "Impling Jars",
		description = "Don't open implings if bank has a clue.",
		position = 26,
		section = "miscellaneousSection"
	)
	default boolean swapImps()
	{
		return false;
	}

	@ConfigItem(
		keyName = "charterOption",
		name = "Trader Crew",
		description = "Configure whether you want Charter or Trade to be the first option of Trader Crewmembers.",
		position = 27,
		section = "miscellaneousSection"
	)
	default CharterOption charterOption()
	{
		return CharterOption.TRADE;
	}

	//------------------------------------------------------------//
	// Shop / Stores
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "swapBuyOne",
		name = "Buy One",
		description = "",
		position = 0,
		section = "shopStoresSection"
	)
	default boolean getSwapBuyOne()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyOneItems",
		name = "Items",
		description = "",
		section = "shopStoresSection",
		position = 1,
		hidden = true,
		unhide = "swapBuyOne"
	)
	default String getBuyOneItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyFive",
		name = "Buy Five",
		description = "",
		position = 2,
		section = "shopStoresSection"
	)
	default boolean getSwapBuyFive()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyFiveItems",
		name = "Items",
		description = "",
		position = 3,
		section = "shopStoresSection",
		hidden = true,
		unhide = "swapBuyFive"
	)
	default String getBuyFiveItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyTen",
		name = "Buy Ten",
		description = "",
		position = 4,
		section = "shopStoresSection"
	)
	default boolean getSwapBuyTen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyTenItems",
		name = "Items",
		description = "",
		position = 5,
		section = "shopStoresSection",
		hidden = true,
		unhide = "swapBuyTen"
	)
	default String getBuyTenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyFifty",
		name = "Buy Fifty",
		description = "",
		position = 6,
		section = "shopStoresSection"
	)
	default boolean getSwapBuyFifty()
	{
		return false;
	}

	@ConfigItem(
		keyName = "buyFiftyItems",
		name = "Items",
		description = "",
		position = 7,
		section = "shopStoresSection",
		hidden = true,
		unhide = "swapBuyFifty"
	)
	default String getBuyFiftyItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellOne",
		name = "Sell One",
		description = "",
		position = 8,
		section = "shopStoresSection"
	)
	default boolean getSwapSellOne()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellOneItems",
		name = "Items",
		description = "",
		position = 9,
		section = "shopStoresSection",
		hidden = true,
		unhide = "swapSellOne"
	)
	default String getSellOneItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellFive",
		name = "Sell Five",
		description = "",
		position = 10,
		section = "shopStoresSection"
	)
	default boolean getSwapSellFive()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellFiveItems",
		name = "Items",
		description = "",
		position = 11,
		section = "shopStoresSection",
		hidden = true,
		unhide = "swapSellFive"
	)
	default String getSellFiveItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellTen",
		name = "Sell Ten",
		description = "",
		position = 12,
		section = "shopStoresSection"
	)
	default boolean getSwapSellTen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellTenItems",
		name = "Items",
		description = "",
		position = 13,
		section = "shopStoresSection",
		hidden = true,
		unhide = "swapSellTen"
	)
	default String getSellTenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellFifty",
		name = "Sell Fifty",
		description = "",
		position = 14,
		section = "shopStoresSection"
	)
	default boolean getSwapSellFifty()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sellFiftyItems",
		name = "Items",
		description = "",
		position = 15,
		section = "shopStoresSection",
		hidden = true,
		unhide = "swapSellFifty"
	)
	default String getSellFiftyItems()
	{
		return "";
	}

	//------------------------------------------------------------//
	// Skilling
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "getEasyConstruction",
		name = "Easy Construction",
		description = "Makes 'Remove'/'Build' the default option for listed items.",
		position = 0,
		section = "skillingSection"
	)
	default boolean getEasyConstruction()
	{
		return true;
	}

	@ConfigItem(
		keyName = "getConstructionMode",
		name = "EZ Construction Type",
		description = "",
		position = 1,
		section = "skillingSection",
		hidden = true,
		unhide = "getEasyConstruction"
	)
	default ConstructionMode getConstructionMode()
	{
		return ConstructionMode.LARDER;
	}

	@ConfigItem(
		keyName = "swapTanning",
		name = "Tanning",
		description = "Enables swapping of 'Tan-1' and 'Tan-all' options.",
		position = 2,
		section = "skillingSection"
	)
	default boolean getSwapTanning()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapSawmill",
		name = "Sawmill Operator",
		description = "Makes 'Buy-plank' the default option on the Sawmill Operator.",
		position = 3,
		section = "skillingSection"
	)
	default boolean getSwapSawmill()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapSawmillPlanks",
		name = "Buy Planks",
		description = "Makes 'Buy All' the default option when buying planks.",
		position = 4,
		section = "skillingSection"
	)
	default boolean getSwapSawmillPlanks()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPuroPuro",
		name = "Puro-Puro Wheat",
		description = "",
		position = 5,
		section = "skillingSection"
	)
	default boolean getSwapPuro()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapGrimyHerb",
		name = "Grimy Herbs",
		description = "",
		position = 6,
		section = "skillingSection"
	)
	default boolean getSwapGrimyHerb()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapGrimyHerbMode",
		name = "Mode",
		description = "",
		position = 7,
		section = "skillingSection",
		hidden = true,
		unhide = "swapGrimyHerb"
	)
	default SwapGrimyHerbMode swapGrimyHerbMode()
	{
		return SwapGrimyHerbMode.DYNAMIC;
	}

	//------------------------------------------------------------//
	// Talk-To
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "swapAssignment",
		name = "Assignment",
		description = "Swap 'Talk-to' with 'Assignment' for Slayer Masters. This will take priority over swapping Trade.",
		position = 0,
		section = "talkSection"
	)
	default boolean swapAssignment()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBankExchange",
		name = "Bank/Exchange",
		description = "Swap Talk-to with Bank or Exchange on NPC<br>Example: Banker, Grand Exchange Clerk, Tool Leprechaun, Void Knight",
		position = 1,
		section = "talkSection"
	)
	default boolean swapBankExchange()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapContract",
		name = "Contract",
		description = "Swap 'Talk-to' with 'Contract' on Guildmaster Jane.",
		position = 2,
		section = "talkSection"
	)
	default boolean swapContract()
	{
		return true;
	}


	@ConfigItem(
		keyName = "swapInteract",
		name = "Interact",
		description = "Swap options for generic interactions on NPCs<br>Example: Decant for Bob Barter, Repairs for Dark Mage, Claim Slime for Robin, Claim Dynamite",
		position = 3,
		section = "talkSection"
	)
	default boolean swapInteract()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPickpocket",
		name = "Pickpocket",
		description = "Swap Talk-to with Pickpocket on NPC<br>Example: Man, Woman",
		position = 4,
		section = "talkSection"
	)
	default boolean swapPickpocket()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPay",
		name = "Pay",
		description = "Swap 'Talk-to' with 'Pay' on various NPCs.<br>Example: Elstan, Heskel, Fayeth.",
		position = 5,
		section = "talkSection"
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAbyssTeleport",
		name = "Teleport to Abyss",
		description = "Swap 'Talk-to' with 'Teleport' for the Mage of Zamorak.",
		position = 6,
		section = "talkSection"
	)
	default boolean swapAbyssTeleport()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap 'Talk-to' with 'Trade' on various NPCs.<br>Example: Shop keeper, Shop assistant.",
		position = 7,
		section = "talkSection"
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap 'Talk-to' with 'Travel', 'Take-boat', 'Pay-fare', 'Charter' on various NPCs.<br>Example: Squire, Monk of Entrana, Customs officer, Trader Crewmember.",
		position = 8,
		section = "talkSection"
	)
	default boolean swapTravel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapMinigame",
		name = "Minigames",
		description = "Swap Talk-to with Start-Minigame, Story, Dream on NPC<br>Example: Guardian mummy, Juna, Dominic Onion",
		position = 9,
		section = "talkSection"
	)
	default boolean swapMinigame()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPlank",
		name = "Buy Planks",
		description = "Swap 'Talk-to' with 'Buy-planks' at the Lumber Yard.",
		position = 10,
		section = "talkSection"
	)
	default boolean swapPlank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapMetamorphosis",
		name = "Metamorphosis",
		description = "Swap 'Talk-to' with 'Metamorphosis' for Baby Chinchompa pet.",
		position = 11,
		section = "talkSection"
	)
	default boolean swapMetamorphosis()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapEnchant",
		name = "Enchant",
		description = "Swap Talk-to with Enchant for Eluned",
		position = 12,
		section = "talkSection"
	)
	default boolean swapEnchant()
	{
		return true;
	}

	//------------------------------------------------------------//
	// Teleportation
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "lastJewel",
		name = "Last Destination for Jewellery Box",
		description = "Adds a \"Last-destination\" menu option when Jewellery Boxes are right clicked",
		section = "teleportationSection"
	)
	default boolean lastJewel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapFairyRing",
		name = "Fairy Ring",
		description = "Swap 'Zanaris' with 'Last-destination' or 'Configure' on Fairy rings.",
		position = 0,
		section = "teleportationSection"
	)
	default boolean swapFairyRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fairyring",
		name = "Mode",
		description = "",
		position = 1,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapFairyRing"
	)
	default FairyRingMode swapFairyRingMode()
	{
		return FairyRingMode.LAST_DESTINATION;
	}

	@ConfigItem(
			keyName = "swapFairyTree",
			name = "Fairy Tree",
			description = "Swap options on PoH Fairy Tree",
			position = 2,
			section = "teleportationSection"
	)
	default boolean swapFairyTree()
	{
		return false;
	}

	@ConfigItem(
			keyName = "fairyTree",
			name = "Mode",
			description = "",
			position = 3,
			section = "teleportationSection",
			hidden = true,
			unhide = "swapFairyTree"
	)
	default FairyTreeMode swapFairyTreeMode()
	{
		return FairyTreeMode.RING_LAST_DESTINATION;
	}

	@ConfigItem(
		keyName = "swapObelisk",
		name = "Obelisk",
		description = "Swap the options on wilderness obelisks between 'Activate', 'Set destination' or 'Teleport to destination'.",
		position = 4,
		section = "teleportationSection"
	)
	default boolean swapObelisk()
	{
		return false;
	}

	@ConfigItem(
		keyName = "obelisk",
		name = "Mode",
		description = "",
		position = 5,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapObelisk"
	)
	default ObeliskMode swapObeliskMode()
	{
		return ObeliskMode.ACTIVATE;
	}

	@ConfigItem(
		keyName = "swapTeleportItem",
		name = "Teleport Items",
		description = "Swap 'Wear' or 'Wield' with 'Rub' or 'Teleport' on teleport items.<br>Example: Amulet of glory, Explorer's ring, Chronicle.",
		position = 6,
		section = "teleportationSection"
	)
	default boolean swapTeleportItem()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapWildernessLever",
		name = "Wilderness Lever",
		description = "Swap the wilderness lever left click to be Edgeville/Ardougne.",
		position = 7,
		section = "teleportationSection"
	)
	default boolean swapWildernessLever()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapNexus",
		name = "Portal Nexus",
		description = "Makes the teleport menu have priority over the left click destination on the portal nexus.",
		position = 8,
		section = "teleportationSection"
	)
	default boolean swapNexus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapGamesNecklace",
		name = "Games Necklace",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Games Necklace.",
		position = 9,
		section = "teleportationSection"
	)
	default boolean getGamesNecklace()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gamesNecklaceMode",
		name = "Mode",
		description = "",
		position = 10,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapGamesNecklace"
	)
	default GamesNecklaceMode getGamesNecklaceMode()
	{
		return GamesNecklaceMode.BURTHORPE;
	}

	@ConfigItem(
		keyName = "swapDuelingRing",
		name = "Dueling Ring",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Ring of Dueling.",
		position = 11,
		section = "teleportationSection"
	)
	default boolean getDuelingRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "duelingRingMode",
		name = "Mode",
		description = "",
		position = 12,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapDuelingRing"
	)
	default DuelingRingMode getDuelingRingMode()
	{
		return DuelingRingMode.DUEL_ARENA;
	}

	@ConfigItem(
		keyName = "swapGlory",
		name = "Glory",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Amulet of Glory / Amulet of Eternal Glory.",
		position = 13,
		section = "teleportationSection"
	)
	default boolean getGlory()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gloryMode",
		name = "Mode",
		description = "",
		position = 14,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapGlory"
	)
	default GloryMode getGloryMode()
	{
		return GloryMode.EDGEVILLE;
	}

	@ConfigItem(
		keyName = "swapSkill",
		name = "Skills Necklace",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Skills Necklace.",
		position = 15,
		section = "teleportationSection"
	)
	default boolean getSkillsNecklace()
	{
		return false;
	}

	@ConfigItem(
		keyName = "skillsnecklacemode",
		name = "Mode",
		description = "",
		position = 16,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapSkill"
	)
	default SkillsNecklaceMode getSkillsNecklaceMode()
	{
		return SkillsNecklaceMode.FARMING_GUILD;
	}

	@ConfigItem(
		keyName = "swapPassage",
		name = "Passage Necklace",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Necklace of Passage.",
		position = 17,
		section = "teleportationSection"
	)
	default boolean getNecklaceofPassage()
	{
		return false;
	}

	@ConfigItem(
		keyName = "necklaceofpassagemode",
		name = "Mode",
		description = "",
		position = 18,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapPassage"
	)
	default NecklaceOfPassageMode getNecklaceofPassageMode()
	{
		return NecklaceOfPassageMode.WIZARDS_TOWER;
	}

	@ConfigItem(
		keyName = "swapDigsite",
		name = "Digsite Pendant",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Digsite Pendant.",
		position = 19,
		section = "teleportationSection"
	)
	default boolean getDigsitePendant()
	{
		return false;
	}

	@ConfigItem(
		keyName = "digsitependantmode",
		name = "Mode",
		description = "",
		position = 20,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapDigsite"
	)
	default DigsitePendantMode getDigsitePendantMode()
	{
		return DigsitePendantMode.FOSSIL_ISLAND;
	}

	@ConfigItem(
		keyName = "swapCombat",
		name = "Combat Bracelet",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Combat Bracelet.",
		position = 21,
		section = "teleportationSection"
	)
	default boolean getCombatBracelet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "combatbraceletmode",
		name = "Mode",
		description = "",
		position = 22,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapCombat"
	)
	default CombatBraceletMode getCombatBraceletMode()
	{
		return CombatBraceletMode.WARRIORS_GUILD;
	}

	@ConfigItem(
		keyName = "swapburning",
		name = "Burning Amulet",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Burning Amulet.",
		position = 23,
		section = "teleportationSection"
	)
	default boolean getBurningAmulet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "burningamuletmode",
		name = "Mode",
		description = "",
		position = 24,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapburning"
	)
	default BurningAmuletMode getBurningAmuletMode()
	{
		return BurningAmuletMode.BANDIT_CAMP;
	}

	@ConfigItem(
		keyName = "swapxeric",
		name = "Xeric's Talisman",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Xeric's Talisman.",
		position = 25,
		section = "teleportationSection"
	)
	default boolean getXericsTalisman()
	{
		return false;
	}

	@ConfigItem(
		keyName = "xericstalismanmode",
		name = "Mode",
		description = "",
		position = 26,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapxeric"
	)
	default XericsTalismanMode getXericsTalismanMode()
	{
		return XericsTalismanMode.XERICS_LOOKOUT;
	}

	@ConfigItem(
		keyName = "swapwealth",
		name = "Ring of Wealth",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Ring of Wealth.",
		position = 27,
		section = "teleportationSection"
	)
	default boolean getRingofWealth()
	{
		return false;
	}

	@ConfigItem(
		keyName = "ringofwealthmode",
		name = "Mode",
		description = "",
		position = 28,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapwealth"
	)
	default RingOfWealthMode getRingofWealthMode()
	{
		return RingOfWealthMode.GRAND_EXCHANGE;
	}

	@ConfigItem(
		keyName = "swapslayer",
		name = "Slayer Ring",
		description = "",
		position = 29,
		section = "teleportationSection"
	)
	default boolean getSlayerRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "slayerringmode",
		name = "Mode",
		description = "",
		position = 30,
		section = "teleportationSection",
		hidden = true,
		unhide = "swapslayer"
	)
	default SlayerRingMode getSlayerRingMode()
	{
		return SlayerRingMode.CHECK;
	}

	//------------------------------------------------------------//
	// Right Click Options
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "hideExamine",
		name = "Examine",
		description = "Hides the 'Examine' option from the right click menu.",
		position = 0,
		section = "rightClickOptionsSection"
	)
	default boolean hideExamine()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideTradeWith",
		name = "Trade With",
		description = "Hides the 'Trade with' option from the right click menu.",
		position = 1,
		section = "rightClickOptionsSection"
	)
	default boolean hideTradeWith()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideReport",
		name = "Report",
		description = "Hides the 'Report' option from the right click menu.",
		position = 2,
		section = "rightClickOptionsSection"
	)
	default boolean hideReport()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideLookup",
		name = "Lookup",
		description = "Hides the 'Lookup' option from the right click menu.",
		position = 3,
		section = "rightClickOptionsSection"
	)
	default boolean hideLookup()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideNet",
		name = "Net",
		description = "Hides the 'Net' option from the right click menu.",
		position = 4,
		section = "rightClickOptionsSection"
	)
	default boolean hideNet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideBait",
		name = "Bait",
		description = "Hides the 'Bait' option from the right click menu.",
		position = 5,
		section = "rightClickOptionsSection"
	)
	default boolean hideBait()
	{
		return false;
	}

	//------------------------------------------------------------//
	// Untradeables
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "hideDestroyRunepouch",
		name = "Destroy on Rune Pouch",
		description = "Hides the 'Destroy' option when right clicking a Rune pouch.",
		position = 0,
		section = "untradeablesSection"
	)
	default boolean hideDestroyRunepouch()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDestroyCoalbag",
		name = "Destroy on Coal bag",
		description = "Hides the 'Destroy' option when right clicking a Coal bag.",
		position = 1,
		section = "untradeablesSection"
	)
	default boolean hideDestroyCoalbag()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDestroyHerbsack",
		name = "Destroy on Herb sack",
		description = "Hides the 'Destroy' option when right clicking a Herb sack.",
		position = 2,
		section = "untradeablesSection"
	)
	default boolean hideDestroyHerbsack()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDestroyBoltpouch",
		name = "Destroy on Bolt pouch",
		description = "Hides the 'Destroy' option when right clicking a Bolt pouch.",
		position = 3,
		section = "untradeablesSection"
	)
	default boolean hideDestroyBoltpouch()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDestroyGembag",
		name = "Destroy on Gem bag",
		description = "Hides the 'Destroy' option when right clicking a Gem bag.",
		position = 4,
		section = "untradeablesSection"
	)
	default boolean hideDestroyGembag()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDestroyLootingBag",
		name = "Destroy on Looting bag",
		description = "Hides the 'Destroy' option when right clicking a Looting bag.",
		position = 5,
		section = "untradeablesSection"
	)
	default boolean hideDestroyLootingBag()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDropRunecraftingPouch",
		name = "Drop on RC pouches",
		description = "Hides the 'Drop' option when right clicking a Small, Medium, Large, or Giant pouch.",
		position = 6,
		section = "untradeablesSection"
	)
	default boolean hideDropRunecraftingPouch()
	{
		return false;
	}

	//------------------------------------------------------------//
	// PVM
	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "hideCastToB",
		name = "Hide cast in ToB",
		description = "Hides the cast option for clanmates and friends in ToB",
		position = 0,
		section = "pvmSection"
	)

	default boolean hideCastToB()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideCastIgnoredToB",
		name = "Ignored spells",
		description = "Spells that should not be hidden from being cast, separated by a comma",
		position = 1,
		section = "pvmSection",
		hidden = true,
		unhide = "hideCastToB"
	)
	default String hideCastIgnoredToB()
	{
		return "cure other, energy transfer, heal other, vengeance other";
	}

	@ConfigItem(
		keyName = "hideCastCoX",
		name = "Hide cast in CoX",
		description = "Hides the cast option for clanmates and friends in CoX",
		position = 2,
		section = "pvmSection"
	)

	default boolean hideCastCoX()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideCastIgnoredCoX",
		name = "Ignored spells",
		description = "Spells that should not be hidden from being cast, separated by a comma",
		position = 3,
		section = "pvmSection",
		hidden = true,
		unhide = "hideCastCoX"
	)
	default String hideCastIgnoredCoX()
	{
		return "cure other, energy transfer, heal other, vengeance other";
	}

	@ConfigItem(
		keyName = "lastDes",
		name = "",
		description = "Last jewellery box destination (option)",
		hidden = true
	)
	default String lastDes()
	{
		return "";
	}

	@ConfigItem(
		keyName = "lastDes",
		name = "",
		description = "Last jewellery box destination (option)",
		hidden = true
	)
	void lastDes(String des);
}
