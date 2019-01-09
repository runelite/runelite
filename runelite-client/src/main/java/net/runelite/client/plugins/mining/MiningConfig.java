/*
 * Copyright (c) 2018, Craftiii4 <Craftiii4@gmail.com>
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
package net.runelite.client.plugins.mining;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("miningplugin")
public interface MiningConfig extends Config
{

	@ConfigItem(
		position = 1,
		keyName = "statTimeout",
		name = "Reset stats (minutes)",
		description = "The time until mining session data is reset in minutes."
	)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		position = 2,
		keyName = "showRespawn",
		name = "Show ore respawn timers",
		description = "If the amount of seconds left until a ore respawns should be shown."
	)
	default boolean showRespawnTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showAllRespawns",
		name = "Show timers for every ore",
		description = "Show timers for every ore mined in your nearby vicinity"
	)
	default boolean showAllRespawnTimers()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "showMiningStats",
		name = "Show mining session stats",
		description = "Configures whether to display mining session stats"
	)
	default boolean showMiningStats()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "showMiningState",
		name = "Show current mining state",
		description = "Shows current mining state. 'You are currently mining' / 'You are currently NOT mining'"
	)
	default boolean showMiningState()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "disableInMLM",
		name = "Disable in MLM",
		description = "Disables the trackers if you're in the motherloade mine"
	)
	default boolean disableInMLM()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "trackWorldRock",
		name = "World Tracker",
		description = "Tracks the respawn time of a certain ore as you switch worlds"
	)
	default MiningRockType.WorldRock trackWorldRock()
	{
		return MiningRockType.WorldRock.None;
	}

	@ConfigItem(
		position = 8,
		keyName = "trackTimeout",
		name = "Stop tracking (seconds)",
		description = "The time a world will keep on displaying after the ore has respawned in seconds"
	)
	default int trackTimeout()
	{
		return 60;
	}

}
