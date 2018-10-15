/*
 * Copyright (c) 2018, DrizzyBot <https://github.com/drizzybot>
 *               2018, DaveInga <https://github.com/daveinga>
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

import java.awt.*;

@ConfigGroup("fightcaves")
public interface FightCaveConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "showCurrentWave",
		name = "Show current wave",
		description = "Shows monsters that will spawn on the current wave."
	)
	default boolean showCurrentWave()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "showNextWave",
		name = "Show next wave",
		description = "Shows monsters that will be spawning on the wave after your current one."
	)
	default boolean showNextWave()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showMinimapOverlay",
		name = "Show minimap overlay",
		description = "Provides NPC names on the minimap"
	)
	default boolean showMinimapOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "getMinimapNPCNameColor",
		name = "Minimap Name",
		description = "Color for NPC Names on Minimap"
	)
	default Color getMinimapNPCNameColor()
	{
		return Color.WHITE;
	}

}
