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
		keyName = "swapBank",
		name = "Bank",
		description = "Swap Talk-to with Bank on NPCs<br>Example: Banker"
	)
	default boolean swapBank()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "swapExchange",
		name = "Exchange",
		description = "Swap Talk-to with Exchange on NPCs<br>Example: Grand Exchange Clerk, Tool Leprechaun, Void Knight"
	)
	default boolean swapExchange()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "swapTrade",
		name = "Trade",
		description = "Swap Talk-to with Trade on NPCs<br>Example: Shop keeper, Shop assistant"
	)
	default boolean swapTrade()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "swapPay",
		name = "Pay",
		description = "Swap Talk-to with Pay on NPCs<br>Example: Elstan, Heskel, Fayeth"
	)
	default boolean swapPay()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "swapPickpocket",
		name = "Pickpocket",
		description = "Swap Talk-to with Pickpocket on NPCs<br>Example: Man, Woman"
	)
	default boolean swapPickpocket()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "swapTravel",
		name = "Travel",
		description = "Swap Talk-to with Travel, Pay-fare, Take-boat, Charter, Tickets on NPCs<br>Example: Squire, Monk of Entrana, Customs officer, Trader Crewmember"
	)
	default boolean swapTravel()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "swapKitten",
		name = "Kitten",
		description = "Swap Talk-to with Kitten on Gertrude<br>Also hides Investigate on Watchtower"
	)
	default boolean swapKitten()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "swapSlayerMaster",
		name = "Slayer Master",
		description = "Select left click option for Slayer masters"
	)
	default SlayerMaster swapSlayerMaster()
	{
		return SlayerMaster.DEFAULT;
	}
	enum SlayerMaster
	{
		DEFAULT("Talk-to"),
		ASSIGNMENT("Assignment"),
		TRADE("Trade"),
		REWARDS("Rewards");

		private final String name;
		SlayerMaster(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}
		public boolean isSet()
		{
			return this != DEFAULT;
		}
	}

	@ConfigItem(
		position = 8,
		keyName = "swapSawmillOperator",
		name = "Sawmill",
		description = "Select left click option for Sawmill operators"
	)
	default SawmillOperator swapSawmillOperator()
	{
		return SawmillOperator.DEFAULT;
	}
	enum SawmillOperator
	{
		DEFAULT("Talk-to"),
		BUY_PLANK("Buy-plank"),
		TRADE("Trade");

		private final String name;
		SawmillOperator(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}
		public boolean isSet()
		{
			return this != DEFAULT;
		}
	}

	@ConfigItem(
		position = 9,
		keyName = "swapShantay",
		name = "Shantay",
		description = "Select left click option for Shantay"
	)
	default Shantay swapShantay()
	{
		return Shantay.DEFAULT;
	}
	enum Shantay
	{
		DEFAULT("Talk-to"),
		TRADE("Trade"),
		BUY_PASS("Buy-pass");

		private final String name;
		Shantay(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}
		public boolean isSet()
		{
			return this != DEFAULT;
		}
	}

	@ConfigItem(
		position = 10,
		keyName = "swapCatacombEntrance",
		name = "Catacomb entrance",
		description = "Swap Read with Investigate on Catacombs of Kourend entrance"
	)
	default boolean swapCatacombEntrance()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "swapHarpoon",
		name = "Harpoon",
		description = "Swap Cage, Big Net with Harpoon on Fishing spots"
	)
	default boolean swapHarpoon()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "swapBoxTrap",
		name = "Reset Box trap",
		description = "Swap Take, Check, Dismantle with Lay, Reset, Investigate on Box traps"
	)
	default boolean swapBoxTrap()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "swapBones",
		name = "Use Bones",
		description = "Swap Bury with Use on Bones"
	)
	default boolean swapBones()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "hideChopDown",
		name = "Hide Chop down",
		description = "Hide Chop down on trees unless you have an axe"
	)
	default boolean hideChopDown()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "swapHousePortal",
		name = "House Portal",
		description = "Select left click option for House Portals"
	)
	default HousePortal swapHousePortal()
	{
		return HousePortal.DEFAULT;
	}
	enum HousePortal
	{
		DEFAULT("Enter"),
		HOME("Home"),
		BUILD_MODE("Build mode"),
		FRIENDS_HOUSE("Friend's house");

		private final String name;
		HousePortal(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}
		public boolean isSet()
		{
			return this != DEFAULT;
		}
	}

	@ConfigItem(
		position = 16,
		keyName = "swapFairyRing",
		name = "Fairy Ring",
		description = "Select left click option for Fairy Rings"
	)
	default FairyRing swapFairyRing()
	{
		return FairyRing.DEFAULT;
	}
	enum FairyRing
	{
		DEFAULT("Zanaris"),
		CONFIGURE("Configure"),
		LAST_DESTINATION("Last-destination");

		private final String name;
		FairyRing(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}
		public boolean isSet()
		{
			return this != DEFAULT;
		}
	}
}
