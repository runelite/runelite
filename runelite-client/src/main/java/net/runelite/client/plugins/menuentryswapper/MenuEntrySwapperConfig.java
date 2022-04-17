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
		name = "Item Swaps",
		description = "All options that swap item menu entries",
		position = 0,
		closedByDefault = true
	)
	String itemSection = "items";

	@ConfigSection(
		name = "NPC Swaps",
		description = "All options that swap NPC menu entries",
		position = 1,
		closedByDefault = true
	)
	String npcSection = "npcs";

	@ConfigSection(
		name = "Object Swaps",
		description = "All options that swap object menu entries",
		position = 2,
		closedByDefault = true
	)
	String objectSection = "objects";

	@ConfigSection(
		name = "UI Swaps",
		description = "All options that swap entries in the UI (except Items)",
		position = 3,
		closedByDefault = true
	)
	String uiSection = "ui";

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
		DURADEL,
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
		description = "Allows customization of left-clicks on items",
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
		description = "Allows customization of shift-clicks on items",
		section = itemSection
	)
	default boolean shiftClickCustomization()
	{
		return true;
	}

	@ConfigItem(
		position = -2,
		keyName = "objectLeftClickCustomization",
		name = "Customizable left-click",
		description = "Allows customization of left-clicks on objects",
		section = objectSection
	)
	default boolean objectLeftClickCustomization()
	{
		return true;
	}

	@ConfigItem(
		position = -2,
		keyName = "npcLeftClickCustomization",
		name = "Customizable left-click",
		description = "Allows customization of left-clicks on NPCs",
		section = npcSection
	)
	default boolean npcLeftClickCustomization()
	{
		return true;
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
		description = "Swap Talk-to with Assignment for Slayer Masters. This will take priority over swapping Trade.",
		section = npcSection
	)
	default boolean swapAssignment()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBanker",
		name = "Bank",
		description = "Swap Talk-to with Bank on Bank NPC<br>Example: Banker",
		section = npcSection
	)
	default boolean swapBank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBirdhouseEmpty",
		name = "Birdhouse",
		description = "Swap Interact with Empty for birdhouses on Fossil Island",
		section = objectSection
	)
	default boolean swapBirdhouseEmpty()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBones",
		name = "Bury",
		description = "Swap Bury with Use on Bones",
		section = itemSection
	)
	default boolean swapBones()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapHerbs",
		name = "Clean",
		description = "Swap Clean with Use on Herbs",
		section = itemSection
	)
	default boolean swapHerbs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapBattlestaves",
		name = "Battlestaff",
		description = "Swap Wield with Use on Battlestaves without orbs",
		section = itemSection
	)
	default boolean swapBattlestaves()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPrayerBook",
		name = "Recite-Prayer",
		description = "Swap Read with Recite-prayer on the Prayer Book from The Great Brain Robbery quest",
		section = itemSection
	)
	default boolean swapPrayerBook()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapContract",
		name = "Contract",
		description = "Swap Talk-to with Contract on Guildmaster Jane",
		section = npcSection
	)
	default boolean swapContract()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapChase",
		name = "Chase",
		description = "Allows to left click your cat to chase",
		section = npcSection
	)
	default boolean swapChase()
	{
		return true;
	}

	@ConfigItem(
		keyName = "claimSlime",
		name = "Claim Slime",
		description = "Swap Talk-to with Claim Slime from Morytania diaries",
		section = npcSection
	)
	default boolean claimSlime()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapDarkMage",
		name = "Repairs",
		description = "Swap Talk-to with Repairs for Dark Mage",
		section = npcSection
	)
	default boolean swapDarkMage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapCaptainKhaled",
		name = "Task",
		description = "Swap Talk-to with Task for Captain Khaled in Port Piscarilius",
		section = npcSection
	)
	default boolean swapCaptainKhaled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapDecant",
		name = "Decant",
		description = "Swap Talk-to with Decant for Bob Barter and Murky Matt at the Grand Exchange.",
		section = npcSection
	)
	default boolean swapDecant()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapExchange",
		name = "Exchange",
		description = "Swap Talk-to with Exchange on NPC<br>Example: Grand Exchange Clerk, Tool Leprechaun, Void Knight",
		section = npcSection
	)
	default boolean swapExchange()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapFairyRing",
		name = "Fairy ring",
		description = "Swap Zanaris with Last-destination or Configure on Fairy rings",
		section = objectSection
	)
	default FairyRingMode swapFairyRing()
	{
		return FairyRingMode.LAST_DESTINATION;
	}

	@ConfigItem(
		keyName = "swapHardWoodGrove",
		name = "Hardwood Grove Quick-Pay",
		description = "Swap Quick-Pay(100) at the Hardwood Grove",
		section = objectSection
	)
	default boolean swapHardWoodGrove()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHardWoodGroveParcel",
		name = "Hardwood Grove Send-Parcel",
		description = "Swap Send-Parcel at the Hardwood Grove",
		section = npcSection
	)
	default boolean swapHardWoodGroveParcel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap Cage, Big Net with Harpoon on Fishing spot",
		section = objectSection
	)
	default boolean swapHarpoon()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapBait",
		name = "Bait",
		description = "Swap Lure, Small Net with Bait on Fishing spot",
		section = objectSection
	)
	default boolean swapBait()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapHelp",
		name = "Help",
		description = "Swap Talk-to with Help on Arceuus library customers",
		section = npcSection
	)
	default boolean swapHelp()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHomePortal",
		name = "Home",
		description = "Swap Enter with Home or Build or Friend's house on Portal",
		section = objectSection
	)
	default HouseMode swapHomePortal()
	{
		return HouseMode.HOME;
	}

	@ConfigItem(
		keyName = "swapHouseAdvertisement",
		name = "House Advertisement",
		description = "Swap View with Add-House or Visit-Last on House Advertisement board",
		section = objectSection
	)
	default HouseAdvertisementMode swapHouseAdvertisement()
	{
		return HouseAdvertisementMode.VIEW;
	}

	@ConfigItem(
		keyName = "swapPay",
		name = "Pay",
		description = "Swap Talk-to with Pay on NPC<br>Example: Elstan, Heskel, Fayeth",
		section = npcSection
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapJewelleryBox",
		name = "Jewellery Box",
		description = "Swap Teleport Menu with previous destination on Jewellery Box",
		section = objectSection
	)
	default boolean swapJewelleryBox()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPortalNexus",
		name = "Portal Nexus",
		description =  "Swap Teleport options with Teleport Menu on the Portal Nexus",
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
		description = "Swap Pick with Pick-lots of the Gourd tree in the Chambers of Xeric",
		section = objectSection
	)
	default boolean swapPick()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapQuick",
		name = "Quick Pass/Open/Start/Travel",
		description = "Swap Pass with Quick-Pass, Open with Quick-Open, Ring with Quick-Start and Talk-to with Quick-Travel",
		section = objectSection
	)
	default boolean swapQuick()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBoxTrap",
		name = "Reset",
		description = "Swap Check with Reset on box trap",
		section = objectSection
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTeleportItem",
		name = "Teleport item",
		description = "Swap Wear, Wield with Rub, Teleport on teleport item<br>Example: Amulet of glory, Explorer's ring, Chronicle",
		section = itemSection
	)
	default boolean swapTeleportItem()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapTeleToPoh",
		name = "Tele to POH",
		description = "Swap Wear with Tele to POH on the construction cape",
		section = itemSection
	)
	default boolean swapTeleToPoh()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapKaramjaGloves",
		name = "Karamja Gloves",
		description = "Swap Wear with the Gem Mine or Duradel teleport on the Karamja Gloves 3 and 4",
		section = itemSection
	)
	default KaramjaGlovesMode swapKaramjaGlovesMode()
	{
		return KaramjaGlovesMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapArdougneCloak",
		name = "Ardougne Cloak",
		description = "Swap Wear with Monastery Teleport or Farm Teleport on the Ardougne cloak.",
		section = itemSection
	)
	default ArdougneCloakMode swapArdougneCloakMode()
	{
		return ArdougneCloakMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapRadasBlessing",
		name = "Rada's Blessing",
		description = "Swap Equip with the Woodland or Mount Karuulm teleport on Rada's Blessing.",
		section = itemSection
	)
	default RadasBlessingMode swapRadasBlessingMode()
	{
		return RadasBlessingMode.EQUIP;
	}

	@ConfigItem(
		keyName = "swapMorytaniaLegs",
		name = "Morytania Legs",
		description = "Swap Wear with the Ectofunctus or Burgh de Rott teleport on the Morytania Legs.",
		section = itemSection
	)
	default MorytaniaLegsMode swapMorytaniaLegsMode()
	{
		return MorytaniaLegsMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapDesertAmulet",
		name = "Desert Amulet",
		description = "Swap Wear with the Nardah or Kalphite Cave teleport on Desert Amulet 4.",
		section = itemSection
	)
	default DesertAmuletMode swapDesertAmuletMode()
	{
		return DesertAmuletMode.WEAR;
	}

	@ConfigItem(
		keyName = "swapAbyssTeleport",
		name = "Teleport to Abyss",
		description = "Swap Talk-to with Teleport for the Mage of Zamorak",
		section = npcSection
	)
	default boolean swapAbyssTeleport()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap Talk-to with Trade on NPC<br>Example: Shop keeper, Shop assistant",
		section = npcSection
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap Talk-to with Travel, Take-boat, Pay-fare, Charter on NPC<br>Example: Squire, Monk of Entrana, Customs officer, Trader Crewmember",
		section = npcSection
	)
	default boolean swapTravel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapEnchant",
		name = "Enchant",
		description = "Swap Talk-to with Enchant for Eluned",
		section = npcSection
	)
	default boolean swapEnchant()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTeleportSpell",
		name = "Shift-click teleport spells",
		description = "Swap teleport spells that have a second destination on shift",
		section = uiSection
	)
	default boolean swapTeleportSpell()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapStartMinigame",
		name = "Pyramid Plunder Start-minigame",
		description = "Swap Talk-to with Start-minigame at the Guardian Mummy",
		section = npcSection
	)
	default boolean swapStartMinigame()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapQuickleave",
		name = "Quick-Leave",
		description = "Swap Leave Tomb with Quick-Leave at Pyramid Plunder",
		section = objectSection
	)
	default boolean swapQuickLeave()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapGEItemCollect",
		name = "GE Item Collect",
		description = "Swap Collect-notes, Collect-items, or Bank options from GE offer",
		section = uiSection
	)
	default GEItemCollectMode swapGEItemCollect()
	{
		return GEItemCollectMode.DEFAULT;
	}

	@ConfigItem(
		keyName = "swapGEAbort",
		name = "GE Abort",
		description = "Swap abort offer on Grand Exchange offers when shift-clicking"
		,
		section = uiSection
	)
	default boolean swapGEAbort()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapNpcContact",
		name = "NPC Contact",
		description = "Swap NPC Contact with last contacted NPC when shift-clicking",
		section = uiSection
	)
	default boolean swapNpcContact()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bankWithdrawShiftClick",
		name = "Bank Withdraw Shift-Click",
		description = "Swaps the behavior of shift-click when withdrawing from bank.",
		section = itemSection
	)
	default ShiftWithdrawMode bankWithdrawShiftClick()
	{
		return ShiftWithdrawMode.OFF;
	}

	@ConfigItem(
		keyName = "bankDepositShiftClick",
		name = "Bank Deposit Shift-Click",
		description = "Swaps the behavior of shift-click when depositing to bank.",
		section = itemSection
	)
	default ShiftDepositMode bankDepositShiftClick()
	{
		return ShiftDepositMode.OFF;
	}

	@ConfigItem(
		keyName = "shopBuy",
		name = "Shop Buy Shift-Click",
		description = "Swaps the Buy options with Value on items in shops when shift is held.",
		section = uiSection
	)
	default BuyMode shopBuy()
	{
		return BuyMode.OFF;
	}

	@ConfigItem(
		keyName = "shopSell",
		name = "Shop Sell Shift-Click",
		description = "Swaps the Sell options with Value on items in your inventory when selling to shops when shift is held.",
		section = uiSection
	)
	default SellMode shopSell()
	{
		return SellMode.OFF;
	}

	@ConfigItem(
		keyName = "swapEssenceMineTeleport",
		name = "Essence Mine Teleport",
		description = "Swaps Talk-To with Teleport for NPCs which teleport you to the essence mine",
		section = npcSection
	)
	default boolean swapEssenceMineTeleport()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapNets",
		name = "Nets",
		description = "Swap Talk-to with Nets on Annette",
		section = npcSection
	)
	default boolean swapNets()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapGauntlet",
		name = "Corrupted Gauntlet",
		description = "Swap Enter with Enter-corrupted when entering The Gauntlet",
		section = objectSection
	)
	default boolean swapGauntlet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapTan",
		name = "Tan",
		description = "Swap Tan 1 with Tan All",
		section = uiSection
	)
	default boolean swapTan()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapCollectMiscellania",
		name = "Miscellania",
		description = "Swap Talk-to with Collect for Advisor Ghrim",
		section = npcSection
	)
	default boolean swapCollectMiscellania()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapDepositItems",
		name = "Deposit Items",
		description = "Swap Talk-to with Deposit-items",
		section = npcSection
	)
	default boolean swapDepositItems()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapRockCake",
		name = "Dwarven rock cake",
		description = "Swap Eat with Guzzle on the Dwarven rock cake",
		section = itemSection
	)
	default boolean swapRockCake()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapRowboatDive",
		name = "Fossil Island Rowboat Dive",
		description = "Swap Travel with Dive on the rowboat found on the small island north-east of Fossil Island",
		section = objectSection
	)
	default boolean swapRowboatDive()
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
		name = "Tempoross Leave",
		description = "Swap Talk-to with Leave after subduing Tempoross",
		section = npcSection
	)
	default boolean swapTemporossLeave()
	{
		return false;
	}
}
