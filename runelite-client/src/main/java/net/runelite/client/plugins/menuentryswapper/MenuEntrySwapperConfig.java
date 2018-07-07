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

@ConfigGroup("It's coming home")
public interface MenuEntrySwapperConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean shiftClickCustomization()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapBank()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapBirdhouseEmpty()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapBones()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapCatacombEntrance()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapChase()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean claimSlime()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapExchange()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default FairyRingMode swapFairyRing()
	{
		return FairyRingMode.LAST_DESTINATION;
	}

	@ConfigItem(
		position = 9,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapHarpoon()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default HouseMode swapHomePortal()
	{
		return HouseMode.HOME;
	}

	@ConfigItem(
		position = 11,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapPickpocket()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapPay()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapBoxTrap()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapTeleportItem()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapAbyssTeleport()
	{
		return true;
	}

	@ConfigItem(
		position = 16,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapTrade()
	{
		return true;
	}

	@ConfigItem(
		position = 17,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapTravel()
	{
		return true;
	}

	@ConfigItem(
		position = 18,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean swapAssignment()
	{
		return true;
	}
}
