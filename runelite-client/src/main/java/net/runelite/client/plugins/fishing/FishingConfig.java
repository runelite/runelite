/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.fishing;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("fishing")
public interface FishingConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "onlyCurrent",
		name = "Display only currently fished fish",
		description = "Configures whether only current fished fish's fishing spots are displayed"
	)
	default boolean onlyCurrentSpot()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "showTiles",
		name = "Display spot tiles",
		description = "Configures whether tiles for fishing spots are highlighted"
	)
	default boolean showSpotTiles()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "showIcons",
		name = "Display spot icons",
		description = "Configures whether icons for fishing spots are displayed"
	)
	default boolean showSpotIcons()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showNames",
		name = "Display spot names",
		description = "Configures whether names for fishing spots are displayed"
	)
	default boolean showSpotNames()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "overlayColor",
		name = "Overlay Color",
		description = "Color of overlays",
		position = 4
	)
	default Color getOverlayColor()
	{
		return Color.CYAN;
	}

	@Alpha
	@ConfigItem(
		keyName = "minnowsOverlayColor",
		name = "Minnows Overlay",
		description = "Color of overlays for Minnows",
		position = 5
	)
	default Color getMinnowsOverlayColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		keyName = "aerialOverlayColor",
		name = "Aerial Overlay",
		description = "Color of overlays when 1-tick aerial fishing",
		position = 6
	)
	default Color getAerialOverlayColor()
	{
		return Color.GREEN;
	}

	@Alpha
	@ConfigItem(
		keyName = "harpoonfishOverlayColor",
		name = "Harpoonfish Overlay",
		description = "Color of overlays for bubbling Harpoonfish spots",
		position = 6
	)
	default Color getHarpoonfishOverlayColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		position = 7,
		keyName = "statTimeout",
		name = "Reset stats",
		description = "The time until fishing session data is reset in minutes."
	)
	@Units(Units.MINUTES)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		position = 8,
		keyName = "showFishingStats",
		name = "Show Fishing session stats",
		description = "Display the fishing session stats."
	)
	default boolean showFishingStats()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "showMinnowOverlay",
		name = "Show Minnow Movement overlay",
		description = "Display the minnow progress pie overlay."
	)
	default boolean showMinnowOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "flyingFishNotification",
		name = "Flying fish notification",
		description = "Send a notification when a flying fish spawns on your fishing spot."
	)
	default boolean flyingFishNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 11,
		keyName = "trawlerTimer",
		name = "Trawler timer in M:SS",
		description = "Trawler timer will display a more accurate timer in M:SS format."
	)
	default boolean trawlerTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "trawlerContribution",
		name = "Trawler contribution",
		description = "Display the exact number of trawler contribution points gained."
	)
	default boolean trawlerContribution()
	{
		return true;
	}
}
