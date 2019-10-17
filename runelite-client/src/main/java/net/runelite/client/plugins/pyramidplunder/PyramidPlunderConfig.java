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
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("pyramidplunder")
public interface PyramidPlunderConfig extends Config
{
	@ConfigTitleSection(
		keyName = "overlaysTitle",
		name = "Overlays",
		description = "",
		position = 1
	)
	default Title overlaysTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 2,
		keyName = "showPlunderStatus",
		name = "Show session stats",
		description = "Configures whether to display pyramid plunder session stats",
		titleSection = "overlaysTitle"
	)
	default boolean showPlunderStatus()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "hideWidget",
		name = "Hide default widget",
		description = "Hide the default widget",
		titleSection = "overlaysTitle"
	)
	default boolean hideWidget()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "showTimer",
		name = "Display numerical timer",
		description = "Displays a numerical timer instead of the default timer",
		titleSection = "overlaysTitle"
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "highlightsTitle",
		name = "Highlights",
		description = "",
		position = 5
	)
	default Title highlightsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 6,
		keyName = "highlightDoors",
		name = "Highlights doors",
		description = "Highlights the four doors in each room",
		titleSection = "highlightsTitle"
	)
	default boolean highlightDoors()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "highlightSpearTrap",
		name = "Highlights spear traps",
		description = "Highlights the spear traps in each room",
		titleSection = "highlightsTitle"
	)
	default boolean highlightSpearTrap()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "warningsTitle",
		name = "Warnings",
		description = "",
		position = 8
	)
	default Title warningsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 9,
		keyName = "firstWarningTime",
		name = "First warning time",
		description = "Recolor time left(s)",
		titleSection = "warningsTitle"
	)
	default int firstWarningTime()
	{
		return 90;
	}

	@ConfigItem(
		position = 10,
		keyName = "secondWarningTime",
		name = "Second warning time",
		description = "Recolor time left(s)",
		titleSection = "warningsTitle"
	)
	default int secondWarningTime()
	{
		return 30;
	}
}
