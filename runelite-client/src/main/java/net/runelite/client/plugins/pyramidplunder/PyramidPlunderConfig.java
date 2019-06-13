/*
 * Copyright (c) 2018, Steffen Hauge <steffen.oerum.hauge@hotmail.com>
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
package net.runelite.client.plugins.pyramidplunder;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("pyramidplunder")
public interface PyramidPlunderConfig extends Config
{

	@ConfigItem(
			position = 1,
			keyName = "showPlunderStatus",
			name = "Show session stats",
			description = "Configures whether to display pyramid plunder session stats"
	)
	default boolean showPlunderStatus()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightDoors",
		name = "Highlights doors",
		description = "Highlights the four doors in each room"
	)
	default boolean highlightDoors()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "highlightSpearTrap",
		name = "Highlights spear traps",
		description = "Highlights the spear traps in each room"
	)
	default boolean highlightSpearTrap()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "showTimer",
		name = "Display numerical timer",
		description = "Displays a numerical timer instead of the default timer"
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
			position = 5,
			keyName = "hideWidget",
			name = "Hide default widget",
			description = "Hide the default widget"
	)
	default boolean hideWidget()
	{
		return true;
	}

	@ConfigItem(
			position = 6,
			keyName = "firstWarningTime",
			name = "First warning time",
			description = "Recolor time left(s)"
	)
	default int firstWarningTime()
	{
		return 90;
	}

	@ConfigItem(
			position = 7,
			keyName = "secondWarningTime",
			name = "Second warning time",
			description = "Recolor time left(s)"
	)
	default int secondWarningTime()
	{
		return 30;
	}

}
