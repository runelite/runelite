/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.plugins.minimap;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(MinimapConfig.GROUP)
public interface MinimapConfig extends Config
{
	String GROUP = "minimap";

	@ConfigSection(
		name = "Minimap dot colors",
		description = "The colors of dots on the minimap.",
		position = 0
	)
	String minimapDotSection = "minimapDotSection";

	@ConfigSection(
		name = "Minimap icons",
		description = "The control of icons on the minimap.",
		position = 1
	)
	String minimapIconSection = "minimapIconSection";

	@ConfigItem(
		keyName = "zoom",
		name = "Zoom",
		description = "Enables zooming on the minimap."
	)
	default boolean zoom()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideMinimap",
		name = "Hide minimap",
		description = "Do not show the minimap on screen (resizable only)."
	)
	default boolean hideMinimap()
	{
		return false;
	}

	@ConfigItem(
		keyName = "item",
		name = "Item color",
		description = "Set the minimap color items are drawn in.",
		section = minimapDotSection
	)
	Color itemColor();

	@ConfigItem(
		keyName = "npc",
		name = "NPC color",
		description = "Set the minimap color NPCs are drawn in.",
		section = minimapDotSection
	)
	Color npcColor();

	@ConfigItem(
		keyName = "player",
		name = "Player color",
		description = "Set the minimap color players are drawn in.",
		section = minimapDotSection
	)
	Color playerColor();

	@ConfigItem(
		keyName = "friend",
		name = "Friends color",
		description = "Set the minimap color your friends are drawn in.",
		section = minimapDotSection
	)
	Color friendColor();

	@ConfigItem(
		keyName = "team",
		name = "Team color",
		description = "Set the minimap color your team is drawn in.",
		section = minimapDotSection
	)
	Color teamColor();

	@ConfigItem(
		keyName = "clan", // old name from prior to clans
		name = "Friends chat color",
		description = "Set the minimap color your friends chat members are drawn in.",
		section = minimapDotSection
	)
	Color friendsChatColor();

	@ConfigItem(
		keyName = "clanchat",
		name = "Clan chat color",
		description = "Set the minimap color your clan chat members are drawn in.",
		section = minimapDotSection
	)
	Color clanChatColor();

	@ConfigItem(
		keyName = "agilityCourseIcon",
		name = "Hide Agility Course icons",
		description = "Choose whether to view or hide the Agility Course icons.",
		position = 1,
		section = minimapIconSection
	)
	default boolean agilityCourseIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "agilityShortcutIcon",
		name = "Hide Agility Shortcut icons",
		description = "Choose whether to view or hide the Agility Shortcut icons.",
		position = 2,
		section = minimapIconSection
	)
	default boolean agilityShortcutIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "altarIcon",
		name = "Hide Altar icons",
		description = "Choose whether to view or hide the Altar icons (includes normal and Zalcano).",
		position = 3,
		section = minimapIconSection
	)
	default boolean altarIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "amuletShopIcon",
		name = "Hide Amulet Shop icon",
		description = "Choose whether to view or hide the Amulet Shop icon.",
		position = 4,
		section = minimapIconSection
	)
	default boolean amuletShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "anvilIcon",
		name = "Hide Anvil icons",
		description = "Choose whether to view or hide the Anvil icons.",
		position = 5,
		section = minimapIconSection
	)
	default boolean anvilIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "apothecaryIcon",
		name = "Hide Apothecary icons",
		description = "Choose whether to view or hide the Apothecary icons.",
		position = 6,
		section = minimapIconSection
	)
	default boolean apothecaryIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "archeryShopIcon",
		name = "Hide Archery Shop icons",
		description = "Choose whether to view or hide the Archery Shop icons.",
		position = 7,
		section = minimapIconSection
	)
	default boolean archeryShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "axeShopIcon",
		name = "Hide Axe Shop icons",
		description = "Choose whether to view or hide the Axe Shop icons.",
		position = 8,
		section = minimapIconSection
	)
	default boolean axeShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bankIcon",
		name = "Hide Bank icons",
		description = "Choose whether to view or hide the Bank icons.",
		position = 9,
		section = minimapIconSection
	)
	default boolean bankIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bankTutorIcon",
		name = "Hide Bank Tutor icon",
		description = "Choose whether to view or hide the Bank Tutor icon.",
		position = 10,
		section = minimapIconSection
	)
	default boolean bankTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "birdHouseSiteIcon",
		name = "Hide Bird House Site icons",
		description = "Choose whether to view or hide the Bird House Site icons.",
		position = 11,
		section = minimapIconSection
	)
	default boolean birdHouseSiteIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bondTutorIcon",
		name = "Hide Bond Tutor icon",
		description = "Choose whether to view or hide the Bond Tutor icon.",
		position = 12,
		section = minimapIconSection
	)
	default boolean bondTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bountyHunterTraderIcon",
		name = "Hide Bounty Hunter Trader icon",
		description = "Choose whether to view or hide the Bounty Hunter Trader icon.",
		position = 13,
		section = minimapIconSection
	)
	default boolean bountyHunterTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "breweryIcon",
		name = "Hide Brewery icons",
		description = "Choose whether to view or hide the Brewery icons.",
		position = 14,
		section = minimapIconSection
	)
	default boolean breweryIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "candleShopIcon",
		name = "Hide Candle Shop icons",
		description = "Choose whether to view or hide the Candle Shop icons.",
		position = 15,
		section = minimapIconSection
	)
	default boolean candleShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "chainbodyShopIcon",
		name = "Hide Chainbody Shop icon",
		description = "Choose whether to view or hide the Chainbody Shop icon.",
		position = 16,
		section = minimapIconSection
	)
	default boolean chainbodyShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "clanHubIcon",
		name = "Hide Clan Hub icon",
		description = "Choose whether to view or hide the Clan Hub icon.",
		position = 17,
		section = minimapIconSection
	)
	default boolean clanHubIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "clothesShopIcon",
		name = "Hide Clothes Shop icons",
		description = "Choose whether to view or hide the Clothes Shop icons.",
		position = 18,
		section = minimapIconSection
	)
	default boolean clothesShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "clueTutorIcon",
		name = "Hide Clue Tutor icon",
		description = "Choose whether to view or hide the Clue Tutor icon.",
		position = 19,
		section = minimapIconSection
	)
	default boolean clueTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "combatAchievementsIcon",
		name = "Hide Combat Achievements icon",
		description = "Choose whether to view or hide the Combat Achievements icon.",
		position = 20,
		section = minimapIconSection
	)
	default boolean combatAchievementsIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "combatTrainingIcon",
		name = "Hide Combat Training icons",
		description = "Choose whether to view or hide the Combat Training icons.",
		position = 21,
		section = minimapIconSection
	)
	default boolean combatTrainingIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "combatTutorIcon",
		name = "Hide Combat Tutor icon",
		description = "Choose whether to view or hide the Combat Tutor icon.",
		position = 22,
		section = minimapIconSection
	)
	default boolean combatTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "cookingRangeIcon",
		name = "Hide Cooking Range icons",
		description = "Choose whether to view or hide the Cooking Range icons.",
		position = 23,
		section = minimapIconSection
	)
	default boolean cookingRangeIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "cookingTutorIcon",
		name = "Hide Cooking Tutor icon",
		description = "Choose whether to view or hide the Cooking Tutor icon.",
		position = 24,
		section = minimapIconSection
	)
	default boolean cookingTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "craftingShopIcon",
		name = "Hide Crafting Shop icons",
		description = "Choose whether to view or hide the Crafting Shop icons.",
		position = 25,
		section = minimapIconSection
	)
	default boolean craftingShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "craftingTutorIcon",
		name = "Hide Crafting Tutor icon",
		description = "Choose whether to view or hide the Crafting Tutor icon.",
		position = 26,
		section = minimapIconSection
	)
	default boolean craftingTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dairyChurnIcon",
		name = "Hide Dairy Churn icons",
		description = "Choose whether to view or hide the Dairy Churn icons.",
		position = 27,
		section = minimapIconSection
	)
	default boolean dairyChurnIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dairyCowIcon",
		name = "Hide Dairy Cow icons",
		description = "Choose whether to view or hide the Dairy Cow icons.",
		position = 28,
		section = minimapIconSection
	)
	default boolean dairyCowIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dangerTutorIcon",
		name = "Hide Danger Tutor icon",
		description = "Choose whether to view or hide the Danger Tutor icon.",
		position = 29,
		section = minimapIconSection
	)
	default boolean dangerTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "deadmanTutorIcon",
		name = "Hide Deadman Tutor icon",
		description = "Choose whether to view or hide the Deadman Tutor icon.",
		position = 30,
		section = minimapIconSection
	)
	default boolean deadmanTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "deathsOfficeIcon",
		name = "Hide Deaths Office icons",
		description = "Choose whether to view or hide the Deaths Office icons.",
		position = 31,
		section = minimapIconSection
	)
	default boolean deathsOfficeIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "distractionAndDiversionIcon",
		name = "Hide Distraction And Diversion icons",
		description = "Choose whether to view or hide the Distraction And Diversion icons.",
		position = 32,
		section = minimapIconSection
	)
	default boolean distractionAndDiversionIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dungeonIcon",
		name = "Hide Dungeon icons",
		description = "Choose whether to view or hide the Dungeon icons.",
		position = 33,
		section = minimapIconSection
	)
	default boolean dungeonIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dyeTraderIcon",
		name = "Hide Dye Trader icons",
		description = "Choose whether to view or hide the Dye Trader icons.",
		position = 34,
		section = minimapIconSection
	)
	default boolean dyeTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "estateAgentIcon",
		name = "Hide Estate Agent icons",
		description = "Choose whether to view or hide the Estate Agent icons.",
		position = 35,
		section = minimapIconSection
	)
	default boolean estateAgentIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "farmingPatchIcon",
		name = "Hide Farming Patch icons",
		description = "Choose whether to view or hide the Farming Patch icons.",
		position = 36,
		section = minimapIconSection
	)
	default boolean farmingPatchIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "farmingShopIcon",
		name = "Hide Farming Shop icons",
		description = "Choose whether to view or hide the Farming Shop icons.",
		position = 37,
		section = minimapIconSection
	)
	default boolean farmingShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fishingShopIcon",
		name = "Hide Fishing Shop icons",
		description = "Choose whether to view or hide the Fishing Shop icons.",
		position = 38,
		section = minimapIconSection
	)
	default boolean fishingShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fishingSpotIcon",
		name = "Hide Fishing Spot icons",
		description = "Choose whether to view or hide the Fishing Spot icons.",
		position = 39,
		section = minimapIconSection
	)
	default boolean fishingSpotIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fishingTutorIcon",
		name = "Hide Fishing Tutor icon",
		description = "Choose whether to view or hide the Fishing Tutor icon.",
		position = 40,
		section = minimapIconSection
	)
	default boolean fishingTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "foodShopIcon",
		name = "Hide Food Shop icons",
		description = "Choose whether to view or hide the Food Shop icons (includes Cooking shop, Kebab shop, Food shop and Vegetable store).",
		position = 41,
		section = minimapIconSection
	)
	default boolean foodShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "forestryShopIcon",
		name = "Hide Forestry Shop icons",
		description = "Choose whether to view or hide the Forestry Shop icons.",
		position = 42,
		section = minimapIconSection
	)
	default boolean forestryShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "furTraderIcon",
		name = "Hide Fur Trader icons",
		description = "Choose whether to view or hide the Fur Trader icons.",
		position = 43,
		section = minimapIconSection
	)
	default boolean furTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "furnaceIcon",
		name = "Hide Furnace icons",
		description = "Choose whether to view or hide the Furnace icons.",
		position = 44,
		section = minimapIconSection
	)
	default boolean furnaceIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gardenSupplierIcon",
		name = "Hide Garden Supplier icons",
		description = "Choose whether to view or hide the Garden Supplier icons.",
		position = 45,
		section = minimapIconSection
	)
	default boolean gardenSupplierIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gemShopIcon",
		name = "Hide Gem Shop icons",
		description = "Choose whether to view or hide the Gem Shop icons.",
		position = 46,
		section = minimapIconSection
	)
	default boolean gemShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "generalStoreIcon",
		name = "Hide General Store icons",
		description = "Choose whether to view or hide the General Store icons.",
		position = 47,
		section = minimapIconSection
	)
	default boolean generalStoreIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "grandExchangeIcon",
		name = "Hide Grand Exchange icons",
		description = "Choose whether to view or hide the Grand Exchange icons (includes Grand Exchange and Pricing Experts).",
		position = 48,
		section = minimapIconSection
	)
	default boolean grandExchangeIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "grindstoneIcon",
		name = "Hide Grindstone icon",
		description = "Choose whether to view or hide the Grindstone icon.",
		position = 49,
		section = minimapIconSection
	)
	default boolean grindstoneIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hairdresserIcon",
		name = "Hide Hairdresser icons",
		description = "Choose whether to view or hide the Hairdresser icons.",
		position = 50,
		section = minimapIconSection
	)
	default boolean hairdresserIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "helmetShopIcon",
		name = "Hide Helmet Shop icons",
		description = "Choose whether to view or hide the Helmet Shop icons.",
		position = 51,
		section = minimapIconSection
	)
	default boolean helmetShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "herbalistIcon",
		name = "Hide Herbalist icons",
		description = "Choose whether to view or hide the Herbalist icons.",
		position = 52,
		section = minimapIconSection
	)
	default boolean herbalistIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "holidayEventIcon",
		name = "Hide Holiday Event icons",
		description = "Choose whether to view or hide the Holiday Event icons.",
		position = 53,
		section = minimapIconSection
	)
	default boolean holidayEventIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "holidayItemTraderIcon",
		name = "Hide Holiday Item Trader icon",
		description = "Choose whether to view or hide the Holiday Item Trader icon.",
		position = 54,
		section = minimapIconSection
	)
	default boolean holidayItemTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "housePortalIcon",
		name = "Hide House Portal icons",
		description = "Choose whether to view or hide the House Portal icons.",
		position = 55,
		section = minimapIconSection
	)
	default boolean housePortalIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hunterShopIcon",
		name = "Hide Hunter Shop icons",
		description = "Choose whether to view or hide the Hunter Shop icons.",
		position = 56,
		section = minimapIconSection
	)
	default boolean hunterShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hunterTrainingIcon",
		name = "Hide Hunter Training icons",
		description = "Choose whether to view or hide the Hunter Training icons.",
		position = 57,
		section = minimapIconSection
	)
	default boolean hunterTrainingIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hunterTutorIcon",
		name = "Hide Hunter Tutor icon",
		description = "Choose whether to view or hide the Hunter Tutor icon.",
		position = 58,
		section = minimapIconSection
	)
	default boolean hunterTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "ironmanTutorIcon",
		name = "Hide Ironman Tutor icon",
		description = "Choose whether to view or hide the Ironman Tutor icon.",
		position = 59,
		section = minimapIconSection
	)
	default boolean ironmanTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "jewelleryShopIcon",
		name = "Hide Jewellery Shop icon",
		description = "Choose whether to view or hide the Jewellery Shop icon.",
		position = 60,
		section = minimapIconSection
	)
	default boolean jewelleryShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "junkCheckerIcon",
		name = "Hide Junk Checker icon",
		description = "Choose whether to view or hide the Junk Checker icon.",
		position = 61,
		section = minimapIconSection
	)
	default boolean junkCheckerIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "leaguesTutorIcon",
		name = "Hide Leagues Tutor icon",
		description = "Choose whether to view or hide the Leagues Tutor icon.",
		position = 63,
		section = minimapIconSection
	)
	default boolean leaguesTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "loomIcon",
		name = "Hide Loom icons",
		description = "Choose whether to view or hide the Loom icons.",
		position = 64,
		section = minimapIconSection
	)
	default boolean loomIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "lumbridgeGuideIcon",
		name = "Hide Lumbridge Guide icon",
		description = "Choose whether to view or hide the Lumbridge Guide icon.",
		position = 65,
		section = minimapIconSection
	)
	default boolean lumbridgeGuideIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "maceShopIcon",
		name = "Hide Mace Shop icons",
		description = "Choose whether to view or hide the Mace Shop icons.",
		position = 66,
		section = minimapIconSection
	)
	default boolean maceShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "magicShopIcon",
		name = "Hide Magic Shop icons",
		description = "Choose whether to view or hide the Magic Shop icons.",
		position = 67,
		section = minimapIconSection
	)
	default boolean magicShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "makeoverMageIcon",
		name = "Hide Makeover Mage icon",
		description = "Choose whether to view or hide the Makeover Mage icon.",
		position = 68,
		section = minimapIconSection
	)
	default boolean makeoverMageIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "minigameIcon",
		name = "Hide Minigame icons",
		description = "Choose whether to view or hide the Minigame icons.",
		position = 70,
		section = minimapIconSection
	)
	default boolean minigameIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "miningShopIcon",
		name = "Hide Mining Shop icons",
		description = "Choose whether to view or hide the Mining Shop icons.",
		position = 71,
		section = minimapIconSection
	)
	default boolean miningShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "miningSiteIcon",
		name = "Hide Mining Site icons",
		description = "Choose whether to view or hide the Mining Site icons.",
		position = 72,
		section = minimapIconSection
	)
	default boolean miningSiteIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "miningTutorIcon",
		name = "Hide Mining Tutor icon",
		description = "Choose whether to view or hide the Mining Tutor icon.",
		position = 73,
		section = minimapIconSection
	)
	default boolean miningTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "newspaperTraderIcon",
		name = "Hide Newspaper Trader icon",
		description = "Choose whether to view or hide the Newspaper Trader icon.",
		position = 74,
		section = minimapIconSection
	)
	default boolean newspaperTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "petInsuranceIcon",
		name = "Hide Pet Insurance icon",
		description = "Choose whether to view or hide the Pet Insurance icon.",
		position = 75,
		section = minimapIconSection
	)
	default boolean petInsuranceIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "platebodyShopIcon",
		name = "Hide Platebody Shop icons",
		description = "Choose whether to view or hide the Platebody Shop icons.",
		position = 76,
		section = minimapIconSection
	)
	default boolean platebodyShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "platelegsShopIcon",
		name = "Hide Platelegs Shop icon",
		description = "Choose whether to view or hide the Platelegs Shop icon.",
		position = 77,
		section = minimapIconSection
	)
	default boolean platelegsShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "plateskirtShopIcon",
		name = "Hide Plateskirt Shop icon",
		description = "Choose whether to view or hide the Plateskirt Shop icon.",
		position = 78,
		section = minimapIconSection
	)
	default boolean plateskirtShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "polishingWheelIcon",
		name = "Hide Polishing Wheel icon",
		description = "Choose whether to view or hide the Polishing Wheel icon.",
		position = 79,
		section = minimapIconSection
	)
	default boolean polishingWheelIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "pollBoothIcon",
		name = "Hide Poll Booth icons",
		description = "Choose whether to view or hide the Poll Booth icons.",
		position = 80,
		section = minimapIconSection
	)
	default boolean pollBoothIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "potteryWheelIcon",
		name = "Hide Pottery Wheel icons",
		description = "Choose whether to view or hide the Pottery Wheel icons.",
		position = 81,
		section = minimapIconSection
	)
	default boolean potteryWheelIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "prayerTutorIcon",
		name = "Hide Prayer Tutor icon",
		description = "Choose whether to view or hide the Prayer Tutor icon.",
		position = 82,
		section = minimapIconSection
	)
	default boolean prayerTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "pubIcon",
		name = "Hide Pub icons",
		description = "Choose whether to view or hide the Pub icons.",
		position = 84,
		section = minimapIconSection
	)
	default boolean pubIcon()
	{
		return false;
	}

	enum questIconEnum
	{
		VIEW_ALL,
		VIEW_INCOMPLETE,
		HIDE_ALL
	}

	@ConfigItem(
		keyName = "questStartIcon",
		name = "Hide Quest Start icons",
		description = "Choose how to display the Quest Start icons.",
		position = 85,
		section = minimapIconSection
	)
	default questIconEnum questStartIcon()
	{
		return questIconEnum.VIEW_ALL;
	}

	@ConfigItem(
		keyName = "raidIcon",
		name = "Hide Raid icons",
		description = "Choose whether to view or hide the Raid icons.",
		position = 86,
		section = minimapIconSection
	)
	default boolean raidIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rareTreesIcon",
		name = "Hide Rare Trees icons",
		description = "Choose whether to view or hide the Rare Trees icons.",
		position = 87,
		section = minimapIconSection
	)
	default boolean rareTreesIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "ropeTraderIcon",
		name = "Hide Rope Trader icon",
		description = "Choose whether to view or hide the Rope Trader icon.",
		position = 88,
		section = minimapIconSection
	)
	default boolean ropeTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sandpitIcon",
		name = "Hide Sandpit icons",
		description = "Choose whether to view or hide the Sandpit icons.",
		position = 89,
		section = minimapIconSection
	)
	default boolean sandpitIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "sawmillIcon",
		name = "Hide Sawmill icons",
		description = "Choose whether to view or hide the Sawmill icons.",
		position = 90,
		section = minimapIconSection
	)
	default boolean sawmillIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "scimitarShopIcon",
		name = "Hide Scimitar Shop icons",
		description = "Choose whether to view or hide the Scimitar Shop icons.",
		position = 91,
		section = minimapIconSection
	)
	default boolean scimitarShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "securityTutorIcon",
		name = "Hide Security Tutor icon",
		description = "Choose whether to view or hide the Security Tutor icon.",
		position = 92,
		section = minimapIconSection
	)
	default boolean securityTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "shieldShopIcon",
		name = "Hide Shield Shop icons",
		description = "Choose whether to view or hide the Shield Shop icons.",
		position = 93,
		section = minimapIconSection
	)
	default boolean shieldShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "silkTraderIcon",
		name = "Hide Silk Trader icons",
		description = "Choose whether to view or hide the Silk Trader icons.",
		position = 94,
		section = minimapIconSection
	)
	default boolean silkTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "silverShopIcon",
		name = "Hide Silver Shop icons",
		description = "Choose whether to view or hide the Silver Shop icons.",
		position = 95,
		section = minimapIconSection
	)
	default boolean silverShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "singingBowlIcon",
		name = "Hide Singing Bowl icons",
		description = "Choose whether to view or hide the Singing Bowl icons.",
		position = 96,
		section = minimapIconSection
	)
	default boolean singingBowlIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "slayerMasterIcon",
		name = "Hide Slayer Master icons",
		description = "Choose whether to view or hide the Slayer Master icons.",
		position = 97,
		section = minimapIconSection
	)
	default boolean slayerMasterIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "smithingTutorIcon",
		name = "Hide Smithing Tutor icon",
		description = "Choose whether to view or hide the Smithing Tutor icon.",
		position = 98,
		section = minimapIconSection
	)
	default boolean smithingTutorIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "speedrunningShopIcon",
		name = "Hide Speedrunning Shop icon",
		description = "Choose whether to view or hide the Speedrunning Shop icon.",
		position = 99,
		section = minimapIconSection
	)
	default boolean speedrunningShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "spiceShopIcon",
		name = "Hide Spice Shop icons",
		description = "Choose whether to view or hide the Spice Shop icons.",
		position = 100,
		section = minimapIconSection
	)
	default boolean spiceShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "spinningWheelIcon",
		name = "Hide Spinning Wheel icons",
		description = "Choose whether to view or hide the Spinning Wheel icons.",
		position = 101,
		section = minimapIconSection
	)
	default boolean spinningWheelIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "staffShopIcon",
		name = "Hide Staff Shop icons",
		description = "Choose whether to view or hide the Staff Shop icons.",
		position = 102,
		section = minimapIconSection
	)
	default boolean staffShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "stagnantWaterSourceIcon",
		name = "Hide Stagnant Water Source icon",
		description = "Choose whether to view or hide the Stagnant Water Source icon.",
		position = 103,
		section = minimapIconSection
	)
	default boolean stagnantWaterSourceIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "stonemasonIcon",
		name = "Hide Stonemason icons",
		description = "Choose whether to view or hide the Stonemason icons.",
		position = 104,
		section = minimapIconSection
	)
	default boolean stonemasonIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swordShopIcon",
		name = "Hide Sword Shop icons",
		description = "Choose whether to view or hide the Sword Shop icons.",
		position = 105,
		section = minimapIconSection
	)
	default boolean swordShopIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "tanneryIcon",
		name = "Hide Tannery icons",
		description = "Choose whether to view or hide the Tannery icons.",
		position = 106,
		section = minimapIconSection
	)
	default boolean tanneryIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "taskMasterIcon",
		name = "Hide Task Master icons",
		description = "Choose whether to view or hide the Task Master icons.",
		position = 107,
		section = minimapIconSection
	)
	default boolean taskMasterIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "taxidermistIcon",
		name = "Hide Taxidermist icon",
		description = "Choose whether to view or hide the Taxidermist icon.",
		position = 108,
		section = minimapIconSection
	)
	default boolean taxidermistIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "teaTraderIcon",
		name = "Hide Tea Trader icon",
		description = "Choose whether to view or hide the Tea Trader icon.",
		position = 109,
		section = minimapIconSection
	)
	default boolean teaTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "thievingActivityIcon",
		name = "Hide Thieving Activity icons",
		description = "Choose whether to view or hide the Thieving Activity icons.",
		position = 110,
		section = minimapIconSection
	)
	default boolean thievingActivityIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "transportationIcon",
		name = "Hide Transportation icons",
		description = "Choose whether to view or hide the Transportation icons.",
		position = 111,
		section = minimapIconSection
	)
	default boolean transportationIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fairyRingTransportationIcon",
		name = "Hide Transportation (Fairy Ring) icons",
		description = "Choose whether to view or hide the Transportation (Fairy Ring) icons.",
		position = 112,
		section = minimapIconSection
	)
	default boolean fairyRingTransportationIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "tripHammerIcon",
		name = "Hide Trip Hammer icon",
		description = "Choose whether to view or hide the Trip Hammer icon.",
		position = 114,
		section = minimapIconSection
	)
	default boolean tripHammerIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "valeTotemIcon",
		name = "Hide Vale Totem icons",
		description = "Choose whether to view or hide the Vale Totem icons.",
		position = 115,
		section = minimapIconSection
	)
	default boolean valeTotemIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "waterSourceIcon",
		name = "Hide Water Source icons",
		description = "Choose whether to view or hide the Water Source icons.",
		position = 116,
		section = minimapIconSection
	)
	default boolean waterSourceIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "windmillIcon",
		name = "Hide Windmill icons",
		description = "Choose whether to view or hide the Windmill icons.",
		position = 117,
		section = minimapIconSection
	)
	default boolean windmillIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "wineTraderIcon",
		name = "Hide Wine Trader icons",
		description = "Choose whether to view or hide the Wine Trader icons.",
		position = 118,
		section = minimapIconSection
	)
	default boolean wineTraderIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "woodcuttingStumpIcon",
		name = "Hide Woodcutting Stump icon",
		description = "Choose whether to view or hide the Woodcutting Stump icon.",
		position = 119,
		section = minimapIconSection
	)
	default boolean woodcuttingStumpIcon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "woodcuttingTutorIcon",
		name = "Hide Woodcutting Tutor icon",
		description = "Choose whether to view or hide the Woodcutting Tutor icon.",
		position = 120,
		section = minimapIconSection
	)
	default boolean woodcuttingTutorIcon()
	{
		return false;
	}
}
