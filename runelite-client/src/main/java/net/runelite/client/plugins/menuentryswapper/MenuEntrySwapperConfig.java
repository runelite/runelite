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

@ConfigGroup(
	keyName = "menuentryswapper",
	name = "Menu Entry Swapper",
	description = "Swap menu entry options"
)
public interface MenuEntrySwapperConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "swapPickpocket",
		name = "Pickpocket",
		description = "Swap Talk-to with Pickpocket on NPC<br>Example: Man, Woman"
	)
	default boolean swapPickpocket()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "swapBanker",
		name = "Bank",
		description = "Swap Talk-to with Bank on Bank NPC<br>Example: Banker"
	)
	default boolean swapBank()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "swapExchange",
		name = "Exchange",
		description = "Swap Talk-to with Exchange on NPC<br>Example: Grand Exchange Clerk, Tool Leprechaun, Void Knight"
	)
	default boolean swapExchange()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap Cage, Big Net with Harpoon on Fishing spot"
	)
	default boolean swapHarpoon()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap Talk-to with Trade on NPC<br>Example: Shop keeper, Shop assistant"
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap Talk-to with Travel, Take-boat, Pay-fare, Charter on NPC<br>Example: Squire, Monk of Entrana, Customs officer, Trader Crewmember"
	)
	default boolean swapTravel()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "swapPay",
		name = "Pay",
		description = "Swap Talk-to with Pay on NPC<br>Example: Elstan, Heskel, Fayeth"
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "swapHome",
		name = "Home",
		description = "Swap Enter with Home on Portal"
	)
	default boolean swapHome()
	{
		return true;
	}

	@ConfigItem(
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
		keyName = "swapBoxTrap",
		name = "Reset",
		description = "Swap Check with Reset on box trap"
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "swapCatacombEntrance",
		name = "Catacomb entrance",
		description = "Swap Read with Investigate on Catacombs of Kourend entrance"
	)
	default boolean swapCatacombEntrance()
	{
		return true;
	}

	@ConfigItem(
		position = 11,
		keyName = "swapTeleportItem",
		name = "Teleport item",
		description = "Swap Wear, Wield with Rub, Teleport on teleport item<br>Example: Amulet of glory, Ardougne cloak, Chronicle"
	)
	default boolean swapTeleportItem()
	{
		return true;
	}
}
