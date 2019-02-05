/*
 * Copyright (c) 2019, Spedwards <https://github.com/Spedwards>
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
package net.runelite.client.plugins.pohhosts;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("pohhosts")
public interface POHHostsConfig extends Config
{
	@ConfigItem(
		position = -2,
		keyName = "location",
		name = "House Location",
		description = "Select the location for the house"
	)
	default HouseLocation location()
	{
		return HouseLocation.RIMMINGTON;
	}
	@ConfigItem(
		keyName = "gildedAltar",
		name = "Gilded Altar",
		description = "Asks that a Gilded Altar is required to show host in command output"
	)
	default boolean gildedAltar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "occultAltar",
		name = "Occult Altar",
		description = "Asks that an Occult Altar is required to show host in command output"
	)
	default boolean occultAltar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "spiritTree",
		name = "Spirit Tree",
		description = "Asks that a Spirit Tree is required to show host in command output"
	)
	default boolean spiritTree()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fairyRing",
		name = "Fairy Ring",
		description = "Asks that a Fairy Ring is required to show host in command output"
	)
	default boolean fairyRing()
	{
		return false;
	}

	@ConfigItem(
		keyName = "wildernessObelisk",
		name = "Wilderness Obelisk",
		description = "Asks that a Wilderness Obelisk is required to show host in command output"
	)
	default boolean wildernessObelisk()
	{
		return false;
	}

	@ConfigItem(
		keyName = "repairStand",
		name = "Repair Stand",
		description = "Asks that a Repair Stand is required to show host in command output"
	)
	default boolean repairStand()
	{
		return false;
	}

	@ConfigItem(
		keyName = "combatDummy",
		name = "Combat Dummy",
		description = "Asks that a Combat Dummy is required to show host in command output"
	)
	default boolean combatDummy()
	{
		return false;
	}
}
