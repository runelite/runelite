/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

@ConfigGroup(MenuEntrySwapperConfig.GROUP)
public interface MenuEntrySwapperConfig extends Config
{
	String GROUP = "menuentryswapper";

	@ConfigSection(
		name = "Item swaps",
		description = "All options that swap item menu entries.",
		position = 0,
		closedByDefault = true
	)
	String itemSection = "items";

	@ConfigSection(
		name = "NPC swaps",
		description = "All options that swap NPC menu entries.",
		position = 1,
		closedByDefault = true
	)
	String npcSection = "npcs";

	@ConfigSection(
		name = "Object swaps",
		description = "All options that swap object menu entries.",
		position = 2,
		closedByDefault = true
	)
	String objectSection = "objects";

	@ConfigSection(
		name = "UI swaps",
		description = "All options that swap entries in the UI (except items).",
		position = 3,
		closedByDefault = true
	)
	String uiSection = "ui";

	@ConfigSection(
		name = "Ground item swaps",
		description = "All options that swap ground item menu entries.",
		position = 4,
		closedByDefault = true
	)
	String groundItemSection = "groundItems";

	enum ArdougneCloakMode
	{
		WEAR,
		MONASTERY,
		FARM,
	}

	enum KaramjaGlovesMode
	{
		WEAR,
		GEM_MINE,
		SLAYER_MASTER,
	}

	enum MorytaniaLegsMode
	{
		WEAR,
		ECTOFUNTUS,
		BURGH_DE_ROTT;

		@Override
		public String toString()
		{
			switch (this)
			{
				case BURGH_DE_ROTT:
					return "Burgh de Rott";
				default:
					return name();
			}
		}
	}

	enum RadasBlessingMode
	{
		EQUIP,
		KOUREND_WOODLAND,
		MOUNT_KARUULM,
	}

	enum DesertAmuletMode
	{
		WEAR,
		NARDAH,
		KALPHITE_CAVE,
	}

	@ConfigItem(
		position = -3,
		keyName = "leftClickCustomization",
		name = "Customizable left-click",
		description = "Allows customization of left-clicks on items.",
		section = itemSection
	)
	default boolean leftClickCustomization()
	{
		return true;
	}

	@ConfigItem(
		position = -2,
		keyName = "shiftClickCustomization",
		name = "Customizable shift-click",
		description = "Allows customization of shift-clicks on items.",
		section = itemSection
	)
	default boolean shiftClickCustomization()
	{
		return true;
	}

	@ConfigItem(
		position = -2,
		keyName = "objectLeftClickCustomization",
		name = "Customizable left- and shift-click",
		description = "Allows customization of left-clicks on objects.",
		section = objectSection
	)
	default boolean objectCustomization()
	{
		return true;
	}

	@ConfigItem(
		position = -2,
		keyName = "objectShiftClickWalkHere",
		name = "Shift-click Walk here",
		description = "Swaps Walk here on shift-click on all objects.",
		section = objectSection
	)
	default boolean objectShiftClickWalkHere()
	{
		return false;
	}

	@ConfigItem(
		position = -3,
		keyName = "npcLeftClickCustomization",
		name = "Customizable left- and shift-click",
		description = "Allows customization of left-clicks on NPCs.",
		section = npcSection
	)
	default boolean npcCustomization()
	{
		return true;
	}

	@ConfigItem(
		position = -2,
		keyName = "npcShiftClickWalkHere",
		name = "Shift-click Walk here",
		description = "Swaps Walk here on shift-click on all NPCs.",
		section = npcSection
	)
	default boolean npcShiftClickWalkHere()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapAdmire",
		name = "Admire",
		description = "Swap Admire with Teleport, Spellbook and Perks (max cape) for mounted skill capes.",
		section = objectSection
	)
	default boolean swapAdmire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAssignment",
		name = "Assignment",
		description = "Swap Talk-to with Assignment for slayer masters. This will take priority over swapping Trade.",
		section = npcSection
	)
	default boolean swapAssignment()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBanker",
		name = "Bank",
		description = "Swap Talk-to with Bank.",
		section = npcSection
	)
	default boolean swapBank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBirdhouseEmpty",
		name = "Birdhouse",
		description = "Swap Interact with Empty for birdhouses on Fossil Island.",
		section = objectSection
	)
	default boolean swapBirdhouseEmpty()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBones",
		name = "Bury",
		description = "Swap Bury with Use on bones.",
		section = itemSection
	)
	default boolean swapBones()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapHerbs",
		name = "Clean",
		description = "Swap Clean with Use on herbs.",
		section = itemSection
	)
	default boolean swapHerbs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapChase",
		name = "Chase",
		description = "Allows to left-click your cat to Chase.",
		section = npcSection
	)
	default boolean swapChase()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapExchange",
		name = "Exchange",
		description = "Swap Talk-to with Exchange.",
		section = npcSection
	)
	default boolean swapExchange()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapFairyRing",
		name = "Fairy ring",
		description = "Swap Zanaris with Last-destination or Configure on fairy rings.",
		section = objectSection
	)
	default FairyRingMode swapFairyRing()
	{
		return FairyRingMode.LAST_DESTINATION;
	}

	@ConfigItem(
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap Cage and N with Harpoon on fishing spots.",
		section = objectSection
	)
	default boolean swapHarpoon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapBait",
		name = "Bait",
		description = "Swap Lure and Net with Bait on fishing spots.",
		section = objectSection
	)
	default boolean swapBait()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapHelp",
		name = "Help",
		description = "Swap Talk-to with Help on Arceuus library customers.",
		section = npcSection
	)
	default boolean swapHelp()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHomePortal",
		name = "Home",
		description = "Swap enter with home or build or friend's house on portal.",
		section = objectSection
	)
	default HouseMode swapHomePortal()
	{
		return HouseMode.HOME;
	}

	@ConfigItem(
		keyName = "swapPay",
		name = "Pay",
		description = "Swap Talk-to with Pay.",
		section = npcSection
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapJewelleryBox",
		name = "Jewellery box",
		description = "Swap Teleport with Previous destination on jewellery box.",
		section = objectSection
	)
	default boolean swapJewelleryBox()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPortalNexus",
		name = "Portal nexus",
		description =  "Swap Teleport options with Teleport menu on the Portal Nexus",
		section = objectSection
	)
	default boolean swapPortalNexus()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPrivate",
		name = "Private",
		description = "Swap Shared with Private on the Chambers of Xeric storage units.",
		section = objectSection
	)
	default boolean swapPrivate()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPick",
		name = "Pick",
		description = "Swap Pick with Pick-lots of the Gourd tree in the Chambers of Xeric.",
		section = objectSection
	)
	default boolean swapPick()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapQuick",
		name = "Quick pass/open/start/travel",
		description = "Swap Pass with Quick-pass, Open with Quick-open, Ring with Quick-start and Talk-to with Quick-travel.",
		section = objectSection
	)
	default boolean swapQuick()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBoxTrap",
		name = "Reset",
		description = "Swap Check with Reset on box trap.",
		section = objectSection
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTeleportItem",
		name = "Teleport item",
		description = "Swap Wear and Wield with Rub, Teleport, and Invoke.",
		section = itemSection
	)
	default boolean swapTeleportItem()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapTeleToPoh",
		name = "Tele to POH",
		description = "Swap Wear with Tele to POH on the construction cape.",
		section = itemSection
	)
	default boolean swapTeleToPoh()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapKaramjaGloves",
		name = "Karamja gloves",
		description = "Swap Wear with the Gem Mine or the Slayer master teleport on the Karamja gloves 3 and 4.",
		section = itemSection
	)
	default KaramjaGlovesMode swapKaramjaGlovesMode()
	{
		return KaramjaGlovesMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapArdougneCloak",
		name = "Ardougne cloak",
		description = "Swap Wear with Monastery teleport or Farm teleport on the Ardougne cloak.",
		section = itemSection
	)
	default ArdougneCloakMode swapArdougneCloakMode()
	{
		return ArdougneCloakMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapRadasBlessing",
		name = "Rada's blessing",
		description = "Swap Equip with the Woodland or Mount Karuulm teleport on Rada's blessing.",
		section = itemSection
	)
	default RadasBlessingMode swapRadasBlessingMode()
	{
		return RadasBlessingMode.EQUIP;
	}

	@ConfigItem(
		keyName = "swapMorytaniaLegs",
		name = "Morytania legs",
		description = "Swap Wear with the Ectofuntus or Burgh de Rott teleport on the Morytania legs.",
		section = itemSection
	)
	default MorytaniaLegsMode swapMorytaniaLegsMode()
	{
		return MorytaniaLegsMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapDesertAmulet",
		name = "Desert amulet",
		description = "Swap Wear with the Nardah or Kalphite cave teleport on Desert amulet 4.",
		section = itemSection
	)
	default DesertAmuletMode swapDesertAmuletMode()
	{
		return DesertAmuletMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapAbyssTeleport",
		name = "Teleport to abyss",
		description = "Swap Talk-to with Teleport for the Mage of Zamorak.",
		section = npcSection
	)
	default boolean swapAbyssTeleport()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap Talk-to with Trade.",
		section = npcSection
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap Talk-to with Travel, Take-boat, Pay-fare, Charter, etc.",
		section = npcSection
	)
	default boolean swapTravel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapGEItemCollect",
		name = "GE item collect",
		description = "Swap Collect-notes, Collect-items, or Bank options from GE offer.",
		section = uiSection
	)
	default GEItemCollectMode swapGEItemCollect()
	{
		return GEItemCollectMode.DEFAULT;
	}

	@ConfigItem(
		keyName = "swapGEAbort",
		name = "GE abort",
		description = "Swap Abort offer on Grand Exchange offers when shift-clicking.",
		section = uiSection
	)
	default boolean swapGEAbort()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bankWithdrawShiftClick",
		name = "Bank withdraw shift-click",
		description = "Swaps the behavior of shift-click when withdrawing from bank.",
		section = uiSection
	)
	default ShiftWithdrawMode bankWithdrawShiftClick()
	{
		return ShiftWithdrawMode.OFF;
	}

	@ConfigItem(
		keyName = "bankDepositShiftClick",
		name = "Bank deposit shift-click",
		description = "Swaps the behavior of shift-click when depositing to bank.",
		section = uiSection
	)
	default ShiftDepositMode bankDepositShiftClick()
	{
		return ShiftDepositMode.OFF;
	}

	@ConfigItem(
		keyName = "shopBuy",
		name = "Shop buy shift-click",
		description = "Swaps the Buy options with Value on items in shops when shift is held.",
		section = uiSection
	)
	default BuyMode shopBuy()
	{
		return BuyMode.OFF;
	}

	@ConfigItem(
		keyName = "shopSell",
		name = "Shop sell shift-click",
		description = "Swaps the Sell options with Value on items in your inventory when selling to shops when shift is held.",
		section = uiSection
	)
	default SellMode shopSell()
	{
		return SellMode.OFF;
	}

	@ConfigItem(
		keyName = "swapEssenceMineTeleport",
		name = "Essence mine teleport",
		description = "Swaps Talk-to with Teleport for NPCs which teleport you to the essence mine.",
		section = npcSection
	)
	default boolean swapEssenceMineTeleport()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapTan",
		name = "Tan",
		description = "Swap Tan 1 with Tan All.",
		section = uiSection
	)
	default boolean swapTan()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapDepositItems",
		name = "Deposit items",
		description = "Swap Talk-to with Deposit-items.",
		section = npcSection
	)
	default boolean swapDepositItems()
	{
		return false;
	}

	enum StairsMode
	{
		CLIMB,
		CLIMB_UP,
		CLIMB_DOWN,
	}

	@ConfigItem(
		keyName = "swapStairsLeftClick",
		name = "Stairs left-click",
		description = "Swap this option when left-clicking stairs. Also works on ladders.",
		section = objectSection
	)
	default StairsMode swapStairsLeftClick()
	{
		return StairsMode.CLIMB;
	}

	@ConfigItem(
		keyName = "swapStairsShiftClick",
		name = "Stairs shift-click",
		description = "Swap this option when shift-clicking stairs. Also works on ladders.",
		section = objectSection
	)
	default StairsMode swapStairsShiftClick()
	{
		return StairsMode.CLIMB;
	}

	@ConfigItem(
		keyName = "swapTemporossLeave",
		name = "Tempoross leave",
		description = "Swap Talk-to with Leave after subduing Tempoross.",
		section = npcSection
	)
	default boolean swapTemporossLeave()
	{
		return false;
	}

	@ConfigItem(
		keyName = "removeDeadNpcMenus",
		name = "Remove dead NPC menus",
		description = "Remove menu options such as Attack and Talk-to from dead NPCs.",
		section = npcSection
	)
	default boolean removeDeadNpcMenus()
	{
		return false;
	}

	@ConfigItem(
		position = -1,
		keyName = "groundItemShiftClickWalkHere",
		name = "Shift-click Walk here",
		description = "Swaps Walk here on shift-click on all ground items.",
		section = groundItemSection
	)
	default boolean groundItemShiftClickWalkHere()
	{
		return false;
	}
}
