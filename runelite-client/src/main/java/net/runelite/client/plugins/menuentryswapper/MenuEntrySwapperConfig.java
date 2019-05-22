
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

@ConfigGroup("menuentryswapper")
public interface MenuEntrySwapperConfig extends Config
{
	@ConfigItem(
		position = -3,
		keyName = "customSwaps",
		name = "Custom swaps",
		description = "Add custom swaps here, 1 per line. Syntax: option, target : option, target<br>Note that the first entry should be the left click one!"
	)
	default String customSwaps()
	{
		return "";
	}

	@ConfigItem(
		position = -2,
		keyName = "shiftClickCustomization",
		name = "Customizable shift-click",
		description = "Allows customization of shift-clicks on items"
	)
	default boolean shiftClickCustomization()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAdmire",
		name = "Admire",
		description = "Swap Admire with Teleport, Spellbook and Perks (max cape) for mounted skill capes.",
		group = "Swap Teleport"
	)
	default boolean swapAdmire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAssignment",
		name = "Assignment",
		description = "Swap Talk-to with Assignment for Slayer Masters. This will take priority over swapping Trade.",
		group = "Swap Talk-To"
	)
	default boolean swapAssignment()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBanker",
		name = "Bank",
		description = "Swap Talk-to with Bank on Bank NPC<br>Example: Banker",
		group = "Swap Talk-To"
	)
	default boolean swapBank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBirdhouseEmpty",
		name = "Birdhouse",
		description = "Swap Interact with Empty for birdhouses on Fossil Island"
	)
	default boolean swapBirdhouseEmpty()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBones",
		name = "Bury",
		description = "Swap Bury with Use on Bones"
	)
	default boolean swapBones()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapContract",
		name = "Contract",
		description = "Swap Talk-to with Contract on Guildmaster Jane",
		group = "Swap Talk-To"
	)
	default boolean swapContract()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapChase",
		name = "Chase",
		description = "Allows to left click your cat to chase"
	)
	default boolean swapChase()
	{
		return true;
	}

	@ConfigItem(
		keyName = "claimDynamite",
		name = "Claim Dynamite",
		description = "Swap Talk-to with Claim Dynamite on Thirus",
		group = "Swap Talk-To"
	)		
	default boolean claimDynamite()
	{
		return true;
	}

	@ConfigItem(
		keyName = "claimSlime",
		name = "Claim Slime",
		description = "Swap Talk-to with Claim Slime from Morytania diaries",
		group = "Swap Talk-To"
	)
	default boolean claimSlime()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapDarkMage",
		name = "Repairs",
		description = "Swap Talk-to with Repairs for Dark Mage",
		group = "Swap Talk-To"
	)
	default boolean swapDarkMage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapDecant",
		name = "Decant",
		description = "Swap Talk-to with Decant for Bob Barter and Murky Matt at the Grand Exchange.",
		group = "Swap Talk-To"
	)
	default boolean swapDecant()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapExchange",
		name = "Exchange",
		description = "Swap Talk-to with Exchange on NPC<br>Example: Grand Exchange Clerk, Tool Leprechaun, Void Knight",
		group = "Swap Talk-To"
	)
	default boolean swapExchange()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapFairyRing",
		name = "Fairy ring",
		description = "Swap Zanaris with Last-destination or Configure on Fairy rings",
		group = "Swap Teleport"
	)
	default FairyRingMode swapFairyRing()
	{
		return FairyRingMode.LAST_DESTINATION;
	}

	@ConfigItem(
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap Cage, Big Net with Harpoon on Fishing spot"
	)
	default boolean swapHarpoon()
	{
		return false;
	}
	
	@ConfigItem(
		keyName = "swapOccult",
		name = "Occult Altar",
		description = "Swap Venerate with Ancient, Lunar, or Arceuus on an Altar of the Occult"
	)
	default OccultAltarMode swapOccult()
	{
		return OccultAltarMode.VENERATE;
	}

	@ConfigItem(
		keyName = "swapObelisk",
		name = "Obelisk",
		description = "Swap the options on wilderness obelisks between Activate, Set destination or Teleport to destination",
		group = "Swap Teleport"
	)
	default ObeliskMode swapObelisk()
	{
		return ObeliskMode.ACTIVATE;
	}

	@ConfigItem(
		keyName = "swapHomePortal",
		name = "Home",
		description = "Swap Enter with Home or Build or Friend's house on Portal"
	)
	default HouseMode swapHomePortal()
	{
		return HouseMode.HOME;
	}

	@ConfigItem(
		keyName = "swapPickpocket",
		name = "Pickpocket on H.A.M.",
		description = "Swap Talk-to with Pickpocket on H.A.M members",
		group = "Swap Talk-To"
	)
	default boolean swapPickpocket()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPay",
		name = "Pay",
		description = "Swap Talk-to with Pay on NPC<br>Example: Elstan, Heskel, Fayeth",
		group = "Swap Talk-To"
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPrivate",
		name = "Private",
		description = "Swap Shared with Private on the Chambers of Xeric storage units."
	)
	default boolean swapPrivate()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapPick",
		name = "Pick",
		description = "Swap Pick with Pick-lots of the Gourd tree in the Chambers of Xeric"
	)
	default boolean swapPick()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapQuick",
		name = "Quick Pass/Open/Start/Travel",
		description = "Swap Pass with Quick-Pass, Open with Quick-Open, Ring with Quick-Start and Talk-to with Quick-Travel"
	)
	default boolean swapQuick()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBoxTrap",
		name = "Reset",
		description = "Swap Check with Reset on box trap"
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTeleportItem",
		name = "Teleport item",
		description = "Swap Wear, Wield with Rub, Teleport on teleport item<br>Example: Amulet of glory, Explorer's ring, Chronicle"
	)
	default boolean swapTeleportItem()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapAbyssTeleport",
		name = "Teleport to Abyss",
		description = "Swap Talk-to with Teleport for the Mage of Zamorak",
		group = "Swap Talk-To"
	)
	default boolean swapAbyssTeleport()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap Talk-to with Trade on NPC<br>Example: Shop keeper, Shop assistant",
		group = "Swap Talk-To"
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap Talk-to with Travel, Take-boat, Pay-fare, Charter on NPC<br>Example: Squire, Monk of Entrana, Customs officer, Trader Crewmember",
		group = "Swap Talk-To"
	)
	default boolean swapTravel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "rockCake",
		name = "Rock Cake Guzzle",
		description = "Enables Left Click Guzzle to Rock Cake"
	)
	default boolean rockCake()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapRogueschests",
		name = "Rogueschests",
		description = "Swap Rogueschests from open to Search for traps"
	)
	default boolean swapRogueschests()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapClimbUpDown",
		name = "Climb",
		description = "Swap Climb-Up/Down depending on Shift or Control key									"
	)
	default boolean swapClimbUpDown()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapDream",
		name = "Dream",
		description = "Swap Talk-to with Dream for Dominic Onion",
		group = "Swap Talk-To"
	)
	default boolean swapDream()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapStory",
		name = "Story",
		description = "Swap Talk-to with Story for Juna at Tears of Guthix",
		group = "Swap Talk-To"
	)
	default boolean swapStory()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapPlank",
		name = "Buy Planks",
		description = "Swap Talk-to with Buy-planks at the Lumber Yard.",
		group = "Swap Talk-To"
	)
	default boolean swapPlank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapStun",
		name = "Stun Hoop Snakes",
		description = "Swap Attack with Stun"
	)
	default boolean swapStun()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapMetamorphosis",
		name = "Metamorphosis",
		description = "Swap Talk-to with Metamorphosis for Baby Chinchompa pet.",
		group = "Swap Talk-To"
	)
	default boolean swapMetamorphosis()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapEscort",
		name = "Escort",
		description = "Swap Talk-to with Escort for the Temple Trekking mini-game.",
		group = "Swap Talk-To"
	)
	default boolean swapEscort()
	{
		return true;
	}	

	@ConfigItem(
		keyName = "swapWildernessLever",
		name = "Wilderness Lever",
		description = "Swap wilderness lever left click to be Edgeville/Ardougne.",
		group = "Swap Teleport"
	)
	default boolean swapWildernessLever()
	{
		return true;
	}
	
	@ConfigItem(
		keyName = "swapNexus",
		name = "Portal Nexus",
		description = "Makes the teleport menu have priority over the left click destination on the portal nexus",
		group = "Swap Teleport"
	)
	default boolean swapNexus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapSearch",
		name = "Search",
		description = "Swap Close, Shut with Search on chests, cupboards, etc."
	)
	default boolean swapSearch()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapHardWoodGrove",
		name = "Hardwood Grove",
		description =  "Swap Quick-Pay(100) and Send-Parcel at Hardwood Grove"
	)
	default boolean swapHardWoodGrove()
	{
		return true;
	}
}
