/*
 * Copyright (c) 2020 Mitchell <https://github.com/Mitchell-Kovacs>
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
import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("pyramidplunder")
public interface PyramidPlunderConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "hideTimer",
		name = "Hide default timer",
		description = "Hides the default pyramid plunder timer"
	)
	default boolean hideTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "showExactTimer",
		name = "Show exact timer",
		description = "Displays the amount of time remaining as an infobox"
	)
	default boolean showExactTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "timerLowWarning",
		name = "Timer low warning",
		description = "Determines the time when the timers color will change"
	)
	default int timerLowWarning()
	{
		return 30;
	}

	@Alpha
	@ConfigItem(
		position = 3,
		keyName = "highlightDoorsColor",
		name = "Highlight doors",
		description = "Selects the color for highlighting tomb doors"
	)
	default Color highlightDoorsColor()
	{
		return Color.green;
	}

	@ConfigItem(
		position = 4,
		keyName = "highlightDoors",
		name = "Highlight doors",
		description = "Highlights the four tomb doors in each room"
	)
	default boolean highlightDoors()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 5,
		keyName = "highlightSpeartrapColor",
		name = "Highlight speartrap",
		description = "Selects the color for highlighting speartraps"
	)
	default Color highlightSpeartrapsColor()
	{
		return Color.orange;
	}

	@ConfigItem(
		position = 6,
		keyName = "highlightSpeartraps",
		name = "Highlight speartraps",
		description = "Highlight the spear traps at the entrance of each room"
	)
	default boolean highlightSpeartraps()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 7,
		keyName = "highlightContainersColor",
		name = "Highlight containers",
		description = "Selects the color for highlighting urns, chests and sarcophagus"
	)
	default Color highlightContainersColor()
	{
		return Color.yellow;
	}

	@ConfigItem(
		position = 8,
		keyName = "highlightUrnsFloor",
		name = "Highlight urns floor",
		description = "Highlight the urns starting at selected floor and up"
	)
	default int highlightUrnsFloor()
	{
		return 9;
	}

	@ConfigItem(
		position = 9,
		keyName = "highlightedChestFloor",
		name = "Highlight chest floor",
		description = "Highlight the Grand Gold Chest starting at selected floor and up"
	)
	default int highlightChestFloor()
	{
		return 9;
	}

	@ConfigItem(
		position = 10,
		keyName = "highlightedSarcophagusFloor",
		name = "Highlight sarcophagus floor",
		description = "Highlight the sarcophagus starting at selected floor and up"
	)
	default int highlightSarcophagusFloor()
	{
		return 9;
	}
}
