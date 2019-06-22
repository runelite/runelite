/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2018, lucouswin <https://github.com/lucouswin>
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
import net.runelite.client.plugins.menuentryswapper.util.BurningAmuletMode;
import net.runelite.client.plugins.menuentryswapper.util.CombatBraceletMode;
import net.runelite.client.plugins.menuentryswapper.util.DigsitePendantMode;
import net.runelite.client.plugins.menuentryswapper.util.DuelingRingMode;
import net.runelite.client.plugins.menuentryswapper.util.FairyRingMode;
import net.runelite.client.plugins.menuentryswapper.util.GamesNecklaceMode;
import net.runelite.client.plugins.menuentryswapper.util.GloryMode;
import net.runelite.client.plugins.menuentryswapper.util.HouseMode;
import net.runelite.client.plugins.menuentryswapper.util.MaxCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.NecklaceOfPassageMode;
import net.runelite.client.plugins.menuentryswapper.util.ObeliskMode;
import net.runelite.client.plugins.menuentryswapper.util.OccultAltarMode;
import net.runelite.client.plugins.menuentryswapper.util.QuestCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.RingOfWealthMode;
import net.runelite.client.plugins.menuentryswapper.util.SkillsNecklaceMode;
import net.runelite.client.plugins.menuentryswapper.util.SlayerRingMode;
import net.runelite.client.plugins.menuentryswapper.util.XericsTalismanMode;



@ConfigGroup("menuentryswapper")
public interface MenuEntrySwapperConfig extends Config
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
		group = "Banking",
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
		group = "Banking",
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
		group = "Banking",
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
		group = "Banking",
		hidden = true,
		unhide = "withdrawX"
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
		group = "Banking",
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
		group = "Banking",
		hidden = true,
		unhide = "withdrawAll"
	)
	default String getWithdrawAllItems()
	{
		return "";
	}

	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "swapMax",
		name = "Swap Max Cape",
		description = "Enables swapping max cape options in worn interface.",
		position = 11,
		group = "Equipment swapper"
	)
	default boolean swapMax()
	{
		return false;
	}

	@ConfigItem(
		keyName = "maxMode",
		name = "Mode",
		description = "",
		position = 12,
		group = "Equipment swapper",
		hidden = true,
		unhide = "swapMax"
	)
	default MaxCapeMode maxMode()
	{
		return MaxCapeMode.CRAFTING_GUILD;
	}

	@ConfigItem(
		keyName = "swapArdougneCape",
		name = "Swap Ardougne Cape",
		description = "Enables swapping of 'Teleport' and 'Wear'.",
		position = 13,
		group = "Equipment swapper"
	)
	default boolean getSwapArdougneCape()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapConstructionCape",
		name = "Swap Construction Cape",
		description = "Enables swapping of 'Teleport' and 'Wear'.",
		position = 14,
		group = "Equipment swapper"
	)
	default boolean getSwapConstructionCape()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapCraftingCape",
		name = "Swap Crafting Cape",
		description = "Enables swapping of 'Teleport' and 'Wear'.",
		position = 15,
		group = "Equipment swapper"
	)
	default boolean getSwapCraftingCape()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapMagicCape",
		name = "Swap Magic Cape",
		description = "Enables swapping of 'Spellbook' and 'Wear'.",
		position = 16,
		group = "Equipment swapper"
	)
	default boolean getSwapMagicCape()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapExplorersRing",
		name = "Swap Explorer's Ring",
		description = "Enables swapping of 'Spellbook' and 'Wear'.",
		position = 17,
		group = "Equipment swapper"
	)
	default boolean getSwapExplorersRing()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAdmire",
		name = "Admire",
		description = "Swap 'Admire' with 'Teleport', 'Spellbook' and 'Perks' (max cape) for mounted skill capes.",
		position = 18,
		group = "Equipment swapper"
	)
	default boolean swapAdmire()
	{
		return true;
	}
	
	@ConfigItem(
		keyName = "swapQuestCape",
		name = "Swap Quest Cape",
		description = "Enables swapping Quest cape options in worn interface.",
		position = 19,
		group = "Equipment swapper"
	)
	default boolean swapQuestCape()
	{
		return false;
	}

	@ConfigItem(
		keyName = "questCapeMode",
		name = "Mode",
		description = "",
		position = 20,
		group = "Equipment swapper",
		hidden = true,
		unhide = "swapQuestCape"
	)
	default QuestCapeMode questCapeMode()
	{
		return QuestCapeMode.TELEPORT;
	}

	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "customSwaps",
		name = "Custom Swaps",
		description = "Add custom swaps here, 1 per line. Syntax: option, target : option, target<br>Note that the first entry should be the left click one!",
		position = 19,
		group = "Miscellaneous",
		parse = true,
		clazz = Parse.class,
		method = "parse"
	)
	default String customSwaps()
	{
		return "";
	}

	@ConfigItem(
		keyName = "shiftClickCustomization",
		name = "Customizable Shift-click",
		description = "Allows customization of shift-clicks on items.",
		position = 20,
		group = "Miscellaneous"
	)
	default boolean shiftClickCustomization()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBirdhouseEmpty",
		name = "Birdhouse",
		description = "Swap 'Interact' with 'Empty' for birdhouses on Fossil Island.",
		position = 21,
		group = "Miscellaneous"
	)
	default boolean swapBirdhouseEmpty()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBones",
		name = "Bury",
		description = "Swap 'Bury' with 'Use' on Bones.",
		position = 22,
		group = "Miscellaneous"
	)
	default boolean swapBones()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapChase",
		name = "Chase",
		description = "Allows to left click your cat to chase rats.",
		position = 23,
		group = "Miscellaneous"
	)
	default boolean swapChase()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap 'Cage', 'Big Net' with 'Harpoon' on Fishing spots.",
		position = 24,
		group = "Miscellaneous"
	)
	default boolean swapHarpoon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapOccult",
		name = "Occult Altar",
		description = "Swap 'Venerate' with 'Ancient', 'Lunar', or 'Arceuus' on an Altar of the Occult.",
		position = 25,
		group = "Miscellaneous"
	)
	default boolean swapOccult()
	{
		return false;
	}

	@ConfigItem(
		keyName = "occultalter",
		name = "Mode",
		description = "",
		position = 26,
		group = "Miscellaneous",
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
		position = 27,
		group = "Miscellaneous"
	)
	default boolean swapHomePortal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "home",
		name = "Mode",
		description = "",
		position = 28,
		group = "Miscellaneous",
		hidden = true,
		unhide = "swapHomePortal"
	)
	default HouseMode swapHomePortalMode()
	{
		return HouseMode.HOME;
	}

	@ConfigItem(
		keyName = "swapPrivate",
		name = "Private",
		description = "Swap 'Shared' with 'Private' on the Chambers of Xeric storage units.",
		position = 29,
		group = "Miscellaneous"
	)
	default boolean swapPrivate()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPick",
		name = "Pick",
		description = "Swap 'Pick' with 'Pick-lots' of the Gourd tree in the Chambers of Xeric.",
		position = 30,
		group = "Miscellaneous"
	)
	default boolean swapPick()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapQuick",
		name = "Quick Pass/Open/Start/Travel",
		description = "Swap 'Pass' with 'Quick-Pass', 'Open' with 'Quick-Open', 'Ring' with 'Quick-Start' and 'Talk-to' with 'Quick-Travel'.",
		position = 31,
		group = "Miscellaneous"
	)
	default boolean swapQuick()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBoxTrap",
		name = "Reset",
		description = "Swap 'Check' with 'Reset' on box traps.",
		position = 32,
		group = "Miscellaneous"
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "rockCake",
		name = "Rock Cake Guzzle",
		description = "Enables Left Click 'Guzzle' on the Dwarven Rock Cake.",
		position = 33,
		group = "Miscellaneous"
	)
	default boolean rockCake()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapRogueschests",
		name = "Rogues Chests",
		description = "Swap Rogues Chests from 'Open' to 'Search for traps'.",
		position = 34,
		group = "Miscellaneous"
	)
	default boolean swapRogueschests()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapClimbUpDown",
		name = "Climb",
		description = "Swap 'Climb-Up'/'Climb-Down' depending on Shift or Control key.",
		position = 35,
		group = "Miscellaneous"
	)
	default boolean swapClimbUpDown()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapStun",
		name = "Stun Hoop Snakes",
		description = "Swap 'Attack' with 'Stun'.",
		position = 36,
		group = "Miscellaneous"
	)
	default boolean swapStun()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapSearch",
		name = "Search",
		description = "Swap 'Close', 'Shut' with 'Search' on chests, cupboards, etc.",
		position = 37,
		group = "Miscellaneous"
	)
	default boolean swapSearch()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHardWoodGrove",
		name = "Hardwood Grove",
		description = "Swap 'Quick-Pay(100)' and 'Send-Parcel' at Hardwood Grove.",
		position = 38,
		group = "Miscellaneous"
	)
	default boolean swapHardWoodGrove()
	{
		return true;
	}


	@ConfigItem(
		keyName = "removeObjects",
		name = "Remove Objects",
		description = "Removes interaction with the listed objects.",
		position = 39,
		group = "Miscellaneous"
	)
	default boolean getRemoveObjects()
	{
		return false;
	}

	@ConfigItem(
		keyName = "removedObjects",
		name = "Objects",
		description = "Objects listed here will have all interaction be removed.",
		position = 40,
		group = "Miscellaneous",
		hidden = true,
		unhide = "removeObjects"
	)
	default String getRemovedObjects()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapslayer",
		name = "Swap Slayer Ring",
		description = "",
		position = 41,
		group = "Teleportation"
	)
	default boolean getSlayerRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "slayerringmode",
		name = "Mode",
		description = "",
		position = 42,
		group = "Teleportation",
		hidden = true,
		unhide = "swapslayer"
	)
	default SlayerRingMode getSlayerRingMode()
	{
		return SlayerRingMode.CHECK;
	}

	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "swapBuyOne",
		name = "Swappable Buy One",
		description = "",
		position = 43,
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
		group = "Shop / stores",
		position = 44,
		hidden = true,
		unhide = "swapBuyOne"
	)
	default String getBuyOneItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyFive",
		name = "Swappable Buy Five",
		description = "",
		position = 45,
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
		position = 46,
		group = "Shop / stores",
		hidden = true,
		unhide = "swapBuyFive"
	)
	default String getBuyFiveItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyTen",
		name = "Swappable Buy Ten",
		description = "",
		position = 47,
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
		position = 48,
		group = "Shop / stores",
		hidden = true,
		unhide = "swapBuyTen"
	)
	default String getBuyTenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapBuyFifty",
		name = "Swappable Buy Fifty",
		description = "",
		position = 49,
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
		position = 50,
		group = "Shop / stores",
		hidden = true,
		unhide = "swapBuyFifty"
	)
	default String getBuyFiftyItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellOne",
		name = "Swappable Sell One",
		description = "",
		position = 51,
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
		position = 52,
		group = "Shop / stores",
		hidden = true,
		unhide = "swapSellOne"
	)
	default String getSellOneItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellFive",
		name = "Swappable Sell Five",
		description = "",
		position = 53,
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
		position = 54,
		group = "Shop / stores",
		hidden = true,
		unhide = "swapSellFive"
	)
	default String getSellFiveItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellTen",
		name = "Swappable Sell Ten",
		description = "",
		position = 55,
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
		position = 56,
		group = "Shop / stores",
		hidden = true,
		unhide = "swapSellTen"
	)
	default String getSellTenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSellFifty",
		name = "Swappable Sell Fifty",
		description = "",
		position = 57,
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
		position = 58,
		group = "Shop / stores",
		hidden = true,
		unhide = "swapSellFifty"
	)
	default String getSellFiftyItems()
	{
		return "";
	}

	//------------------------------------------------------------//

/*	@ConfigItem(
			keyName = "easyConstruction",
			name = "Easy Construction",
			description = "Makes 'Remove'/'Build' the default option for listed item ID's in build mode.<br>Tip: Use dev tools \"'Game Objects\" to find out the ID!",
			position = 59,
			group = "Skilling"
	)
	default boolean getEasyConstruction()
	{
		return false;
	}

	@ConfigItem(
			keyName = "constructionItems",
			name = "Construction Items",
			description = "Makes 'Remove'/'Build' the default option for listed item ID's in build mode.<br>Tip: Use dev tools \"Game Objects\" to find out the ID, and separate values with a ','",
			position = 60,
			group = "Skilling",
			hidden = true,
			unhide = "easyConstruction"
	)
	default String getConstructionItems()
	{
		return "";
	}*/

	@ConfigItem(
		keyName = "getTempConstruction",
		name = "Easy Construction",
		description = "Makes 'Remove'/'Build' the default option for listed items.",
		position = 59,
		group = "Skilling"
	)

	default boolean getTempConstruction()
	{
		return true;
	}

	@ConfigItem(
		keyName = "getTempConstructionItems",
		name = "Build Items",
		description = "",
		position = 60,
		group = "Skilling",
		hidden = true,
		unhide = "getTempConstruction"
	)
	default String getTempConstructionItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "swapSmithing",
		name = "Swap Smithing",
		description = "Enables swapping of 'Smith-1' and 'Smith-all' options.",
		position = 61,
		group = "Skilling"
	)
	default boolean getSwapSmithing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapTanning",
		name = "Swap Tanning",
		description = "Enables swapping of 'Tan-1' and 'Tan-all' options.",
		position = 62,
		group = "Skilling"
	)
	default boolean getSwapTanning()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapSawmill",
		name = "Swap Sawmill Operator",
		description = "Makes 'Buy-plank' the default option on the Sawmill Operator.",
		position = 63,
		group = "Skilling"
	)
	default boolean getSwapSawmill()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapSawmillPlanks",
		name = "Swap Buy Planks",
		description = "Makes 'Buy All' the default option when buying planks.",
		position = 64,
		group = "Skilling"
	)
	default boolean getSwapSawmillPlanks()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPuroPuro",
		name = "Swap Puro-Puro Wheat",
		description = "",
		position = 65,
		group = "Skilling"
	)
	default boolean getSwapPuro()
	{
		return false;
	}

	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "swapAssignment",
		name = "Assignment",
		description = "Swap 'Talk-to' with 'Assignment' for Slayer Masters. This will take priority over swapping Trade.",
		position = 66,
		group = "Talk-To"
	)
	default boolean swapAssignment()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBanker",
		name = "Bank",
		description = "Swap 'Talk-to' with 'Bank' on Bank NPCs.<br>Example: Banker.",
		position = 67,
		group = "Talk-To"
	)
	default boolean swapBank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapContract",
		name = "Contract",
		description = "Swap 'Talk-to' with 'Contract' on Guildmaster Jane.",
		position = 68,
		group = "Talk-To"
	)
	default boolean swapContract()
	{
		return true;
	}

	@ConfigItem(
		keyName = "claimDynamite",
		name = "Claim Dynamite",
		description = "Swap 'Talk-to' with 'Claim Dynamite' on Thirus.",
		position = 69,
		group = "Talk-To"
	)
	default boolean claimDynamite()
	{
		return true;
	}

	@ConfigItem(
		keyName = "claimSlime",
		name = "Claim Slime",
		description = "Swap 'Talk-to' with 'Claim Slime' from Morytania diaries.",
		position = 70,
		group = "Talk-To"
	)
	default boolean claimSlime()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapDarkMage",
		name = "Repairs",
		description = "Swap 'Talk-to' with 'Repairs' for Dark Mage.",
		position = 71,
		group = "Talk-To"
	)
	default boolean swapDarkMage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapDecant",
		name = "Decant",
		description = "Swap 'Talk-to' with 'Decant' for Bob Barter and Murky Matt at the Grand Exchange.",
		position = 72,
		group = "Talk-To"
	)
	default boolean swapDecant()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapExchange",
		name = "Exchange",
		description = "Swap 'Talk-to' with 'Exchange' on various NPCs.<br>Example: Grand Exchange Clerk, Tool Leprechaun, Void Knight.",
		position = 73,
		group = "Talk-To"
	)
	default boolean swapExchange()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPickpocket",
		name = "Pickpocket on H.A.M.",
		description = "Swap 'Talk-to' with 'Pickpocket' on H.A.M members.",
		position = 74,
		group = "Talk-To"
	)
	default boolean swapPickpocket()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPay",
		name = "Pay",
		description = "Swap 'Talk-to' with 'Pay' on various NPCs.<br>Example: Elstan, Heskel, Fayeth.",
		position = 75,
		group = "Talk-To"
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAbyssTeleport",
		name = "Teleport to Abyss",
		description = "Swap 'Talk-to' with 'Teleport' for the Mage of Zamorak.",
		position = 76,
		group = "Talk-To"
	)
	default boolean swapAbyssTeleport()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap 'Talk-to' with 'Trade' on various NPCs.<br>Example: Shop keeper, Shop assistant.",
		position = 77,
		group = "Talk-To"
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap 'Talk-to' with 'Travel', 'Take-boat', 'Pay-fare', 'Charter' on various NPCs.<br>Example: Squire, Monk of Entrana, Customs officer, Trader Crewmember.",
		position = 78,
		group = "Talk-To"
	)
	default boolean swapTravel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapDream",
		name = "Dream",
		description = "Swap 'Talk-to' with 'Dream' for Dominic Onion.",
		position = 79,
		group = "Talk-To"
	)
	default boolean swapDream()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapStory",
		name = "Story",
		description = "Swap 'Talk-to' with 'Story' for Juna at Tears of Guthix.",
		position = 80,
		group = "Talk-To"
	)
	default boolean swapStory()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPlank",
		name = "Buy Planks",
		description = "Swap 'Talk-to' with 'Buy-planks' at the Lumber Yard.",
		position = 81,
		group = "Talk-To"
	)
	default boolean swapPlank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapMetamorphosis",
		name = "Metamorphosis",
		description = "Swap 'Talk-to' with 'Metamorphosis' for Baby Chinchompa pet.",
		position = 82,
		group = "Talk-To"
	)
	default boolean swapMetamorphosis()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapEscort",
		name = "Escort",
		description = "Swap 'Talk-to' with 'Escort' for the Temple Trekking mini-game.",
		position = 83,
		group = "Talk-To"
	)
	default boolean swapEscort()
	{
		return true;
	}

	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "swapFairyRing",
		name = "Fairy Ring",
		description = "Swap 'Zanaris' with 'Last-destination' or 'Configure' on Fairy rings.",
		position = 84,
		group = "Teleportation"
	)
	default boolean swapFairyRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fairyring",
		name = "Mode",
		description = "",
		position = 85,
		group = "Teleportation",
		hidden = true,
		unhide = "swapFairyRing"
	)
	default FairyRingMode swapFairyRingMode()
	{
		return FairyRingMode.LAST_DESTINATION;
	}

	@ConfigItem(
		keyName = "swapObelisk",
		name = "Obelisk",
		description = "Swap the options on wilderness obelisks between 'Activate', 'Set destination' or 'Teleport to destination'.",
		position = 86,
		group = "Teleportation"
	)
	default boolean swapObelisk()
	{
		return false;
	}

	@ConfigItem(
		keyName = "obelisk",
		name = "Mode",
		description = "",
		position = 87,
		group = "Teleportation",
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
		position = 88,
		group = "Teleportation"
	)
	default boolean swapTeleportItem()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapWildernessLever",
		name = "Wilderness Lever",
		description = "Swap the wilderness lever left click to be Edgeville/Ardougne.",
		position = 89,
		group = "Teleportation"
	)
	default boolean swapWildernessLever()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapNexus",
		name = "Portal Nexus",
		description = "Makes the teleport menu have priority over the left click destination on the portal nexus.",
		position = 90,
		group = "Teleportation"
	)
	default boolean swapNexus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapGamesNecklace",
		name = "Swap Games Necklace",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Games Necklace.",
		position = 91,
		group = "Teleportation"
	)
	default boolean getGamesNecklace()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gamesNecklaceMode",
		name = "Mode",
		description = "",
		position = 92,
		group = "Teleportation",
		hidden = true,
		unhide = "swapGamesNecklace"
	)
	default GamesNecklaceMode getGamesNecklaceMode()
	{
		return GamesNecklaceMode.BURTHORPE;
	}

	@ConfigItem(
		keyName = "swapDuelingRing",
		name = "Swap Dueling Ring",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Ring of Dueling.",
		position = 93,
		group = "Teleportation"
	)
	default boolean getDuelingRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "duelingRingMode",
		name = "Mode",
		description = "",
		position = 94,
		group = "Teleportation",
		hidden = true,
		unhide = "swapDuelingRing"
	)
	default DuelingRingMode getDuelingRingMode()
	{
		return DuelingRingMode.DUEL_ARENA;
	}

	@ConfigItem(
		keyName = "swapGlory",
		name = "Swap Glory",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Amulet of Glory / Amulet of Eternal Glory.",
		position = 95,
		group = "Teleportation"
	)
	default boolean getGlory()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gloryMode",
		name = "Mode",
		description = "",
		position = 96,
		group = "Teleportation",
		hidden = true,
		unhide = "swapGlory"
	)
	default GloryMode getGloryMode()
	{
		return GloryMode.EDGEVILLE;
	}

	@ConfigItem(
		keyName = "swapSkill",
		name = "Swap Skill",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Skills Necklace.",
		position = 97,
		group = "Teleportation"
	)
	default boolean getSkillsNecklace()
	{
		return false;
	}

	@ConfigItem(
		keyName = "skillsnecklacemode",
		name = "Mode",
		description = "",
		position = 98,
		group = "Teleportation",
		hidden = true,
		unhide = "swapSkill"
	)
	default SkillsNecklaceMode getSkillsNecklaceMode()
	{
		return SkillsNecklaceMode.FARMING_GUILD;
	}

	@ConfigItem(
		keyName = "swapPassage",
		name = "Swap Passage",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Necklace of Passage.",
		position = 99,
		group = "Teleportation"
	)
	default boolean getNecklaceofPassage()
	{
		return false;
	}

	@ConfigItem(
		keyName = "necklaceofpassagemode",
		name = "Mode",
		description = "",
		position = 100,
		group = "Teleportation",
		hidden = true,
		unhide = "swapPassage"
	)
	default NecklaceOfPassageMode getNecklaceofPassageMode()
	{
		return NecklaceOfPassageMode.WIZARDS_TOWER;
	}

	@ConfigItem(
		keyName = "swapDigsite",
		name = "Swap Digsite",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Digsite Pendant.",
		position = 101,
		group = "Teleportation"
	)
	default boolean getDigsitePendant()
	{
		return false;
	}

	@ConfigItem(
		keyName = "digsitependantmode",
		name = "Mode",
		description = "",
		position = 102,
		group = "Teleportation",
		hidden = true,
		unhide = "swapDigsite"
	)
	default DigsitePendantMode getDigsitePendantMode()
	{
		return DigsitePendantMode.FOSSIL_ISLAND;
	}

	@ConfigItem(
		keyName = "swapCombat",
		name = "Swap Combat",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Combat Bracelet.",
		position = 103,
		group = "Teleportation"
	)
	default boolean getCombatBracelet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "combatbraceletmode",
		name = "Mode",
		description = "",
		position = 104,
		group = "Teleportation",
		hidden = true,
		unhide = "swapCombat"
	)
	default CombatBraceletMode getCombatBraceletMode()
	{
		return CombatBraceletMode.WARRIORS_GUILD;
	}

	@ConfigItem(
		keyName = "swapburning",
		name = "Swap Burning",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Burning Amulet.",
		position = 105,
		group = "Teleportation"
	)
	default boolean getBurningAmulet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "burningamuletmode",
		name = "Mode",
		description = "",
		position = 106,
		group = "Teleportation",
		hidden = true,
		unhide = "swapburning"
	)
	default BurningAmuletMode getBurningAmuletMode()
	{
		return BurningAmuletMode.BANDIT_CAMP;
	}

	@ConfigItem(
		keyName = "swapxeric",
		name = "Swap Xeric's",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Xeric's Talisman.",
		position = 107,
		group = "Teleportation"
	)
	default boolean getXericsTalisman()
	{
		return false;
	}

	@ConfigItem(
		keyName = "xericstalismanmode",
		name = "Mode",
		description = "",
		position = 108,
		group = "Teleportation",
		hidden = true,
		unhide = "swapxeric"
	)
	default XericsTalismanMode getXericsTalismanMode()
	{
		return XericsTalismanMode.XERICS_LOOKOUT;
	}

	@ConfigItem(
		keyName = "swapwealth",
		name = "Swap Wealth",
		description = "Swap the left click 'remove' option with the desired teleport location on a worn Ring of Wealth.",
		position = 109,
		group = "Teleportation"
	)
	default boolean getRingofWealth()
	{
		return false;
	}

	@ConfigItem(
		keyName = "ringofwealthmode",
		name = "Mode",
		description = "",
		position = 110,
		group = "Teleportation",
		hidden = true,
		unhide = "swapwealth"
	)
	default RingOfWealthMode getRingofWealthMode()
	{
		return RingOfWealthMode.GRAND_EXCHANGE;
	}

	//------------------------------------------------------------//

	@ConfigItem(
		keyName = "hideExamine",
		name = "Hide Examine",
		description = "Hides the 'Examine' option from the right click menu.",
		position = 111,
		group = "Right Click Options"
	)
	default boolean hideExamine()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideTradeWith",
		name = "Hide Trade With",
		description = "Hides the 'Trade with' option from the right click menu.",
		position = 112,
		group = "Right Click Options"
	)
	default boolean hideTradeWith()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideReport",
		name = "Hide Report",
		description = "Hides the 'Report' option from the right click menu.",
		position = 113,
		group = "Right Click Options"
	)
	default boolean hideReport()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideLookup",
		name = "Hide Lookup",
		description = "Hides the 'Lookup' option from the right click menu.",
		position = 114,
		group = "Right Click Options"
	)
	default boolean hideLookup()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideNet",
		name = "Hide Net",
		description = "Hides the 'Net' option from the right click menu.",
		position = 115,
		group = "Right Click Options"
	)
	default boolean hideNet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideBait",
		name = "Hide Bait",
		description = "Hides the 'Bait' option from the right click menu.",
		position = 116,
		group = "Right Click Options"
	)
	default boolean hideBait()
	{
		return false;
	}

	//----------------------Untradeables---------------------------//

	@ConfigItem(
			keyName = "hideDestroyRunepouch",
			name = "Hide Destroy on Rune Pouch",
			description = "Hides the 'Destroy' option when right clicking a Rune pouch.",
			position = 117,
			group = "Untradeables"
	)
	default boolean hideDestroyRunepouch()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideDestroyCoalbag",
			name = "Hide Destroy on Coal bag",
			description = "Hides the 'Destroy' option when right clicking a Coal bag.",
			position = 118,
			group = "Untradeables"
	)
	default boolean hideDestroyCoalbag()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideDestroyHerbsack",
			name = "Hide Destroy on Herb sack",
			description = "Hides the 'Destroy' option when right clicking a Herb sack.",
			position = 119,
			group = "Untradeables"
	)
	default boolean hideDestroyHerbsack()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideDestroyBoltpouch",
			name = "Hide Destroy on Bolt pouch",
			description = "Hides the 'Destroy' option when right clicking a Bolt pouch.",
			position = 120,
			group = "Untradeables"
	)
	default boolean hideDestroyBoltpouch()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideDestroyGembag",
			name = "Hide Destroy on Gem bag",
			description = "Hides the 'Destroy' option when right clicking a Gem bag.",
			position = 121,
			group = "Untradeables"
	)
	default boolean hideDestroyGembag()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideDropRunecraftingPouch",
			name = "Hide Drop on RC pouches",
			description = "Hides the 'Drop' option when right clicking a Small, Medium, Large, or Giant pouch.",
			position = 122,
			group = "Untradeables"
	)
	default boolean hideDropRunecraftingPouch()
	{
		return false;
	}

	//------------------------------------------------------------//

	@ConfigItem(
			keyName = "swapImps",
			name = "Impling Jars",
			description = "Don't open implings if bank has a clue.",
			position = 123,
			group = "Miscellaneous"
	)
	default boolean swapImps()
	{
		return false;
	}

	//------------------------------------------------------------//
}
