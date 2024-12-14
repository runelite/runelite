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
		name = "Enable tooltips",
		description = "Configures whether or not to show tooltips.",
		position = 0
	)
	default boolean enableTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showXpLeft",
		name = "Show XP left",
		description = "Shows XP left inside the globe tooltip box.",
		position = 1
	)
	default boolean showXpLeft()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showActionsLeft",
		name = "Show actions left",
		description = "Shows the number of actions left inside the globe tooltip box.",
		position = 2
	)
	default boolean showActionsLeft()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showXpHour",
		name = "Show XP/hr",
		description = "Shows XP per hour inside the globe tooltip box.",
		position = 3
	)
	default boolean showXpHour()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTimeTilGoal",
		name = "Show time til goal",
		description = "Shows the amount of time until goal level in the globe tooltip box.",
		position = 4
	)
	default boolean showTimeTilGoal()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideMaxed",
		name = "Hide maxed skills",
		description = "Stop globes from showing up for level 99 skills.",
		position = 14
	)
	default boolean hideMaxed()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showVirtualLevel",
		name = "Show virtual level",
		description = "Shows virtual level if over 99 in a skill and 'Hide maxed skills' is not checked.",
		position = 15
	)
	default boolean showVirtualLevel()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enableCustomArcColor",
		name = "Enable custom arc color",
		description = "Enables the custom coloring of the globe's arc instead of using the skill's default color.",
		position = 16
	)
	default boolean enableCustomArcColor()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "Progress arc color",
		name = "Progress arc color",
		description = "Change the color of the progress arc in the XP orb.",
		position = 17
	)
	default Color progressArcColor()
	{
		return Color.ORANGE;
	}

	@Alpha
	@ConfigItem(
		keyName = "Progress orb outline color",
		name = "Progress orb outline color",
		description = "Change the color of the progress orb outline.",
		position = 18
	)
	default Color progressOrbOutLineColor()
	{
		return Color.BLACK;
	}

	@Alpha
	@ConfigItem(
		keyName = "Progress orb background color",
		name = "Progress orb background color",
		description = "Change the color of the progress orb background.",
		position = 19
	)
	default Color progressOrbBackgroundColor()
	{
		return new Color(128, 128, 128, 127);
	}

	@ConfigItem(
		keyName = "Progress arc width",
		name = "Progress arc width",
		description = "Change the stroke width of the progress arc.",
		position = 20
	)
	@Units(Units.PIXELS)
	default int progressArcStrokeWidth()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "Orb size",
		name = "Size of orbs",
		description = "Change the size of the XP orbs.",
		position = 21
	)
	@Units(Units.PIXELS)
	default int xpOrbSize()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "Orb duration",
		name = "Duration of orbs",
		description = "Change the duration the XP orbs are visible.",
		position = 22
	)
	@Units(Units.SECONDS)
	default int xpOrbDuration()
	{
		return 10;
	}

	@ConfigItem(
		keyName = "alignOrbsVertically",
		name = "Vertical orbs",
		description = "Aligns the orbs vertically instead of horizontally.",
		hidden = true
	)
	default boolean alignOrbsVertically()
	{
		return false;
	}

	@ConfigItem(
		keyName = "alignOrbsVertically",
		name = "",
		description = ""
	)
	void setAlignOrbsVertically(Boolean alignOrbsVertically);
}
