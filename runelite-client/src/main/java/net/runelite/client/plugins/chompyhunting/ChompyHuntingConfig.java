/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.chompyhunting;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(
	keyName = "chompyhunting",
	name = "Chompy Hunting",
	description = "Configuration for the Chompy Hunting plugin"
)
public interface ChompyHuntingConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "displaySessionKillCount",
		name = "Display session kill count",
		description = "Displays number of kills in the given session"
	)
	default boolean displaySessionKillCount()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "displayLifetimeKillCount",
		name = "Display lifetime kill count",
		description = "Displays number of lifetime chompy kills, check with ogre bow"
	)
	default boolean displayLifetimeKillCount()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "displayKillsPerHour",
		name = "Display kills per hour",
		description = "Displays number of chompy kills per hour"
	)
	default boolean displayKillsPerHour()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showMinimapOverlay",
		name = "Show minimap overlay",
		description = "Configures whether or not to show the chompies on the minimap"
	)
	default boolean showMinimapOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "showBellowsOverlay",
		name = "Show bellows uses left",
		description = "Configures whether or not the number of bellow uses are shown"
	)
	default boolean showBellowsOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "highlightDeadChompies",
		name = "Highlight dead chompies",
		description = "Configures whether or not dead chompies should be highlighted"
	)
	default boolean highlightDeadChompies()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "highlightBloatedToads",
		name = "Highlight bloated toads",
		description = "Configures whether or not bloated toads should be highlighted," +
			"also shows explosion timer on each toad"
	)
	default boolean highlightBloatedToads()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "showExplosionTimer",
		name = "Show explosion timer",
		description = "Configures whether or not the explosion timer should be shown"
	)
	default boolean showExplosionTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "liveChompyColor",
		name = "Live Chompy Color",
		description = "Color of the live chompies"
	)
	default Color liveChompyColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		position = 9,
		keyName = "deadChompyColor",
		name = "Dead Chompy Color",
		description = "Color of the dead chompies, if configured to be highlighted"
	)
	default Color deadChompyColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 10,
		keyName = "toadColor",
		name = "Bloated Toad Color",
		description = "Color of the bloated toads, if configured to be highlighted"
	)
	default Color toadColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		position = 11,
		keyName = "explosionTimerColor",
		name = "Explosion Timer Color",
		description = "Color of the bloated toad explosion timer, if configured to be shown"
	)
	default Color explosionTimerColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		position = 12,
		keyName = "chompyMinimapColor",
		name = "Chompy Minimap Color",
		description = "Color of the chompies on the minimap, if chompies are configured to be shown on the minimap"
	)
	default Color chompyMinimapColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		position = 13,
		keyName = "statTimeout",
		name = "Reset stats (minutes)",
		description = "Configures the time until statistics are reset"
	)
	default int statTimeout()
	{
		return 5;
	}
}
