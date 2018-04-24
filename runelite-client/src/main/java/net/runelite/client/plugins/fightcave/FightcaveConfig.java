/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.fightcave;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "fightcave",
		name = "Fightcave",
		description = "Configuration for the Fightcave plugin"
)
public interface FightcaveConfig extends Config
{
	@ConfigItem(
			keyName = "showCurrentWave",
			name = "Show the current wave",
			description = "Configures whether to show the current wave inside the cave",
			position = 1
	)
	default boolean showCurrentWave()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showCaveTimer",
			name = "Show timer while in cave",
			description = "Configures whether to show a timer of the elapsed time inside the cave",
			position = 2
	)
	default boolean showCaveTimer()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showJadHelper",
			name = "Enable TzTok-Jad prayer helper",
			description = "Configures whether to show a prayer helper during wave 63",
			position = 3
	)
	default boolean showJadHelper()
	{
		return true;
	}
}
