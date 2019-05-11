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
		description = "Swap Admire with Teleport, Spellbook and Perks (max cape) for mounted skill capes."
	)
	default boolean swapAdmire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapAssignment",
		name = "Assignment",
		description = "Swap Talk-to with Assignment for Slayer Masters. This will take priority over swapping Trade."
	)
	default boolean swapAssignment()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapBanker",
		name = "Bank",
		description = "Swap Talk-to with Bank on Bank NPC<br>Example: Banker"
	)
	default boolean swapBank()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 1,
<<<<<<< HEAD
=======
=======
>>>>>>> upstream/master
		keyName = "swapBirdhouseEmpty",
		name = "Birdhouse",
		description = "Swap Interact with Empty for birdhouses on Fossil Island"
	)
	default boolean swapBirdhouseEmpty()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 2,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapBones",
		name = "Bury",
		description = "Swap Bury with Use on Bones"
	)
	default boolean swapBones()
	{
		return false;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 2,
=======
		position = 3,
>>>>>>> upstream/master
		keyName = "swapCatacombEntrance",
		name = "Catacomb entrance",
		description = "Swap Read with Investigate on Catacombs of Kourend entrance"
=======
		keyName = "swapContract",
		name = "Contract",
		description = "Swap Talk-to with Contract on Guildmaster Jane"
>>>>>>> upstream/master
	)
	default boolean swapContract()
	{
		return true; 
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 3,
=======
		position = 4,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapChase",
		name = "Chase",
		description = "Allows to left click your cat to chase"
	)
	default boolean swapChase()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 4,
=======
		position = 5,
=======
>>>>>>> upstream/master
		keyName = "claimSlime",
		name = "Claim Slime",
		description = "Swap Talk-to with Claim Slime from Morytania diaries"
	)
	default boolean claimSlime()
	{
		return true;
	}

<<<<<<< HEAD
	@ConfigItem(
		position = 6,
>>>>>>> upstream/master
		keyName = "shiftClickCustomization",
		name = "Customizable shift-click",
		description = "Allows customization of shift-clicks on items"
=======
	@ConfigItem(		
		keyName = "swapDarkMage",
		name = "Repairs",
		description = "Swap Talk-to with Repairs for Dark Mage"
>>>>>>> upstream/master
	)
	default boolean swapDarkMage()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 5,
=======
		position = 7,
>>>>>>> upstream/master
=======
		keyName = "swapDecant",
		name = "Decant",
		description = "Swap Talk-to with Decant for Bob Barter and Murky Matt at the Grand Exchange."
	)
	default boolean swapDecant()
	{
		return false;
	}

	@ConfigItem(
>>>>>>> upstream/master
		keyName = "swapExchange",
		name = "Exchange",
		description = "Swap Talk-to with Exchange on NPC<br>Example: Grand Exchange Clerk, Tool Leprechaun, Void Knight"
	)
	default boolean swapExchange()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 6,
=======
		position = 8,
=======
>>>>>>> upstream/master
		keyName = "swapFairyRing",
		name = "Fairy ring",
		description = "Swap Zanaris with Last-destination or Configure on Fairy rings"
	)
	default FairyRingMode swapFairyRing()
	{
		return FairyRingMode.LAST_DESTINATION;
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 9,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap Cage, Big Net with Harpoon on Fishing spot"
	)
	default boolean swapHarpoon()
	{
		return false;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 7,
=======
		position = 10,
>>>>>>> upstream/master
		keyName = "swapHome",
=======
		keyName = "swapHomePortal",
>>>>>>> upstream/master
		name = "Home",
		description = "Swap Enter with Home or Build or Friend's house on Portal"
	)
	default HouseMode swapHomePortal()
	{
		return HouseMode.HOME;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 8,
		keyName = "swapLastDestination",
		name = "Last-destination (XXX)",
		description = "Swap Zanaris with Last-destination on Fairy ring"
	)
	default boolean swapLastDestination()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
=======
		position = 11,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapPickpocket",
		name = "Pickpocket on H.A.M.",
		description = "Swap Talk-to with Pickpocket on H.A.M members"
	)
	default boolean swapPickpocket()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 10,
=======
		position = 12,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapPay",
		name = "Pay",
		description = "Swap Talk-to with Pay on NPC<br>Example: Elstan, Heskel, Fayeth"
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 11,
=======
		position = 13,
>>>>>>> upstream/master
=======
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
>>>>>>> upstream/master
		keyName = "swapBoxTrap",
		name = "Reset",
		description = "Swap Check with Reset on box trap"
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 12,
=======
		position = 14,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapTeleportItem",
		name = "Teleport item",
		description = "Swap Wear, Wield with Rub, Teleport on teleport item<br>Example: Amulet of glory, Explorer's ring, Chronicle"
	)
	default boolean swapTeleportItem()
	{
		return false;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 13,
=======
		position = 15,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapAbyssTeleport",
		name = "Teleport to Abyss",
		description = "Swap Talk-to with Teleport for the Mage of Zamorak"
	)
	default boolean swapAbyssTeleport()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 14,
=======
		position = 16,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap Talk-to with Trade on NPC<br>Example: Shop keeper, Shop assistant"
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
<<<<<<< HEAD
		position = 15,
=======
		position = 17,
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap Talk-to with Travel, Take-boat, Pay-fare, Charter on NPC<br>Example: Squire, Monk of Entrana, Customs officer, Trader Crewmember"
	)
	default boolean swapTravel()
	{
		return true;
	}
<<<<<<< HEAD

	@ConfigItem(
		position = 16,
		keyName = "claimSlime",
		name = "Claim Slime",
		description = "Swap Talk-to with Claim Slime from Morytania diaries"
	)
	default boolean claimSlime()
	{
		return true;
	}
=======
>>>>>>> upstream/master
}
