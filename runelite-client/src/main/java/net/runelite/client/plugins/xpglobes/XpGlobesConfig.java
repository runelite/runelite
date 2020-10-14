/*
 * Copyright (c) 2017, Steve <steve.rs.dev@gmail.com>
 * Copyright (c) 2019, Slay to Stay <github.com/slaytostay>
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
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("xpglobes")
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
		keyName = "showXpLeft",
		name = "Show XP Left",
		description = "Shows XP Left inside the globe tooltip box",
		position = 1
	)
	default boolean showXpLeft()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showActionsLeft",
		name = "Show actions left",
		description = "Shows the number of actions left inside the globe tooltip box",
		position = 2
	)
	default boolean showActionsLeft()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showXpHour",
		name = "Show XP/hr",
		description = "Shows XP per hour inside the globe tooltip box",
		position = 3
	)
	default boolean showXpHour()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideMaxed",
		name = "Hide maxed skills",
		description = "Stop globes from showing up for level 99 skills",
		position = 4
	)
	default boolean hideMaxed()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enableCustomArcColor",
		name = "Enable custom arc color",
		description = "Enables the custom coloring of the globe's arc instead of using the skill's default color.",
		position = 5
	)
	default boolean enableCustomArcColor()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "Progress arc color",
		name = "Progress arc color",
		description = "Change the color of the progress arc in the xp orb",
		position = 6
	)
	default Color progressArcColor()
	{
		return Color.ORANGE;
	}

	@Alpha
	@ConfigItem(
		keyName = "Progress orb outline color",
		name = "Progress orb outline color",
		description = "Change the color of the progress orb outline",
		position = 7
	)
	default Color progressOrbOutLineColor()
	{
		return Color.BLACK;
	}

	@Alpha
	@ConfigItem(
		keyName = "Progress orb background color",
		name = "Progress orb background color",
		description = "Change the color of the progress orb background",
		position = 8
	)
	default Color progressOrbBackgroundColor()
	{
		return new Color(128, 128, 128, 127);
	}

	@ConfigItem(
		keyName = "Progress arc width",
		name = "Progress arc width",
		description = "Change the stroke width of the progress arc",
		position = 9
	)
	@Units(Units.PIXELS)
	default int progressArcStrokeWidth()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "Orb size",
		name = "Size of orbs",
		description = "Change the size of the xp orbs",
		position = 10
	)
	@Units(Units.PIXELS)
	default int xpOrbSize()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "Orb duration",
		name = "Duration of orbs",
		description = "Change the duration the xp orbs are visible",
		position = 11
	)
	@Units(Units.SECONDS)
	default int xpOrbDuration()
	{
		return 10;
	}

	@ConfigItem(
		keyName = "trackNextLevelOnly",
		name = "Track next level only",
		description = "Ignore the in-game skill goals for xp orbs",
		position = 9
	)
	default boolean trackNextLevelOnly()
	{
		return false;
	}
}
