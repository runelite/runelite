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
package net.runelite.client.plugins.xpglobes;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "xpglobes",
	name = "XP Globes",
	description = "Configuration for the XP globes plugin"
)
public interface XpGlobesConfig extends Config
{
	@ConfigItem(
		keyName = "enableTooltips",
		name = "Enable Tooltips",
		description = "Configures whether or not to show tooltips",
		position = 0
	)
	default boolean enableTooltips()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showSkillName",
			name = "Show skill name",
			description = "Configures whether or not to show skill name",
			position = 1
	)
	default boolean enableSkillName()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showCurrentXp",
			name = "Show current xp",
			description = "Configures whether or not to show current xp",
			position = 2
	)
	default boolean enableCurrentXp()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showXpToLevel",
			name = "Show xp to level",
			description = "Configures whether or not to show xp to level",
			position = 3
	)
	default boolean enableXpToLevel()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showXpPerHour",
			name = "Show xp per hour",
			description = "Configures whether or not to show xp per hour",
			position = 4
	)
	default boolean enableXpPerHour()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showActionsLeft",
			name = "Show actions left",
			description = "Configures whether or not to show actions left",
			position = 5
	)
	default boolean enableActionsLeft()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showProgressBar",
			name = "Show progress bar",
			description = "Configures whether or not to show progress bar",
			position = 6
	)
	default boolean enableProgressBar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "Progress arc color",
		name = "Progress arc color",
		description = "Change the color of the progress arc in the xp orb",
		position = 7
	)
	default Color progressArcColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "Progress orb outline color",
		name = "Progress orb outline color",
		description = "Change the color of the progress orb outline",
		position = 8
	)
	default Color progressOrbOutLineColor()
	{
		return Color.BLACK;
	}

	@ConfigItem(
		keyName = "Progress orb background color",
		name = "Progress orb background color",
		description = "Change the color of the progress orb background",
		position = 9
	)
	default Color progressOrbBackgroundColor()
	{
		return new Color(128, 128, 128, 127);
	}

	@ConfigItem(
		keyName = "Progress arc width",
		name = "Progress arc width",
		description = "Change the stroke width of the progress arc",
		position = 10
	)
	default int progressArcStrokeWidth()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "Orb size",
		name = "Size of orbs",
		description = "Change the size of the xp orbs",
		position = 11
	)
	default int xpOrbSize()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "Center orbs",
		name = "Center orbs",
		description = "Where to center the xp orbs around",
		position = 12
	)
	default OrbCentering centerOrbs()
	{
		return OrbCentering.DYNAMIC;
	}

}
