/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.barbarianassault;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("barbarianAssault")
public interface BarbarianAssaultConfig extends Config
{
	@ConfigItem(
		keyName = "showTimer",
		name = "Show call change timer",
		description = "Show time to next call change",
		position = 0
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "waveTimes",
		name = "Show wave and game duration",
		description = "Displays wave and game duration",
		position = 1
	)
	default boolean waveTimes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEggCountMessage",
		name = "Show count of eggs collected as collector.",
		description = "Display egg count as collector after each wave",
		position = 2
	)
	default boolean showEggCount()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showEggCountOverlay",
		name = "Overlay of eggs counted",
		description = "Display current egg count as collector",
		position = 3
	)
	default boolean showEggCountOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showHpCountMessage",
		name = "Show count of Hp healed as healer.",
		description = "Display healed count as healer after each wave",
		position = 4
	)
	default boolean showHpCount()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showHpCountOverlay",
		name = "Overlay of Hp counted",
		description = "Display current healed count as healer",
		position = 5
	)
	default boolean showHpCountOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightCollectorEggs",
		name = "Highlight collector eggs",
		description = "Highlight called egg colors",
		position = 6
	)
	default boolean highlightCollectorEggs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showTotalRewards",
		name = "Summarize total reward points",
		description = "Displays total eggs/healed hp and missed attacks/lost runners",
		position = 7
	)
	default boolean showTotalRewards()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showSummaryOfPoints",
		name = "Display summary of advanced points",
		description = "Gives summary of advanced points breakdown in chat log",
		position = 8
	)
	default boolean showSummaryOfPoints()
	{
		return false;
	}

	@ConfigItem(
		keyName = "wrongPoisonFoodTextColor",
		name = "Change healer wrong poison pack color",
		description = "Change healer wrong poison pack color",
		position = 9
	)
	default Color wrongPoisonFoodTextColor()
	{
		return Color.BLACK;
	}

	@ConfigItem(
		keyName = "highlightItems",
		name = "Highlight called poison/bait",
		description = "Highlights the poison or bait that was called by your teammate",
		position = 10
	)
	default boolean highlightItems()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightColor",
		name = "Highlight color",
		description = "Configures the color to highlight the called poison/bait",
		position = 11
	)
	default Color highlightColor()
	{
		return Color.GREEN;
	}
}
