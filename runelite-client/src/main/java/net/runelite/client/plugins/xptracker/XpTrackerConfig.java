/*
 * Copyright (c) 2017, Steve <steve.rs.dev@gmail.com>
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
package net.runelite.client.plugins.xptracker;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "xptracker",
	name = "XP Tracker",
	description = "Configuration for the XP tracker plugin"
)
public interface XpTrackerConfig extends Config
{
	@ConfigItem(
		keyName = "enableProgressOrbs",
		name = "Enable progress orbs",
		description = "Configures whether or not to progress orbs are enabled",
		position = 0
	)
	default boolean enableProgressOrbs()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableTooltips",
		name = "Enable tooltips",
		description = "Configures whether or not to show tooltips",
		position = 1
	)
	default boolean enableTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = "progressOrbArcColor",
		name = "Progress orb arc color",
		description = "Change the color of the progress arc in the xp orb",
		position = 2
	)
	default Color progressOrbArcColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "progressOrbOutlineColor",
		name = "Progress orb outline color",
		description = "Change the color of the progress orb outline",
		position = 3
	)
	default Color progressOrbOutLineColor()
	{
		return Color.BLACK;
	}

	@ConfigItem(
		keyName = "progressOrbBackgroundColor",
		name = "Progress orb background color",
		description = "Change the color of the progress orb background",
		position = 4
	)
	default Color progressOrbBackgroundColor()
	{
		return new Color(128, 128, 128, 127);
	}

	@ConfigItem(
		keyName = "progressOrbArcWidth",
		name = "Progress orb arc width",
		description = "Change the stroke width of the progress arc",
		position = 5
	)
	default int progressOrbArcStrokeWidth()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "progressOrbSize",
		name = "Progress orb size",
		description = "Change the size of the xp orbs",
		position = 6
	)
	default int progressOrbSize()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "progressOrbPosition",
		name = "Progress orbs positions",
		description = "Where to center the xp orbs around",
		position = 7
	)
	default ProgressOrbPosition progressOrbPosition()
	{
		return ProgressOrbPosition.DYNAMIC;
	}
}
