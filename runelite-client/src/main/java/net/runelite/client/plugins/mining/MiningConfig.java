/*
 * Copyright (c) 2020, Jordan Zomerlei <https://github.com/JZomerlei>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.mining;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Units;

@ConfigGroup("mining")
public interface MiningConfig extends Config
{
	@ConfigItem(
		keyName = "statTimeout",
		name = "Reset stats",
		description = "Duration the mining indicator and session stats are displayed before being reset."
	)
	@Units(Units.MINUTES)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "showMiningStats",
		name = "Show session stats",
		description = "Configures whether to display mining session stats."
	)
	default boolean showMiningStats()
	{
		return true;
	}

	@ConfigSection(
		name = "Respawn timers",
		description = "Configures whether to display respawn timers for the given category.",
		position = 0,
		closedByDefault = true
	)
	String respawnTimersSection = "respawnTimersSection";

	@ConfigItem(
		position = 0,
		keyName = "rock",
		name = "Rocks",
		description = "General rocks that aren't within a specific category",
		section = respawnTimersSection
	)
	default boolean showRockRespawns()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "motherlodeMine",
		name = "Motherlode Mine",
		description = "Ore veins within Motherlode Mine",
		section = respawnTimersSection
	)
	default boolean showMotherlodeMineRespawns()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "oreVeins",
		name = "Ore veins",
		description = "Ore veins such as gold veins or calcified rocks",
		section = respawnTimersSection
	)
	default boolean showOreVeinRespawns()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "amethyst",
		name = "Amethyst",
		description = "Amethyst crystals",
		section = respawnTimersSection
	)
	default boolean showAmethystRespawns()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "barronite",
		name = "Barronite",
		description = "Barronite rocks",
		section = respawnTimersSection
	)
	default boolean showBarroniteRespawns()
	{
		return true;
	}
}