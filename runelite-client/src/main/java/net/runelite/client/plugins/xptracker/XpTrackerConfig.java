/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
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

import lombok.AllArgsConstructor;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("xpTracker")
public interface XpTrackerConfig extends Config
{
	@AllArgsConstructor
	enum OnScreenDisplayMode
	{
		XP_GAINED,
		XP_LEFT,
		ACTIONS_DONE,
		ACTIONS_LEFT
	}

	@AllArgsConstructor
	enum OnScreenDisplayModeBottom
	{
		XP_HOUR,
		ACTIONS_HOUR,
	}

	@ConfigItem(
		position = 0,
		keyName = "hideMaxed",
		name = "Hide maxed skills",
		description = "Stop globes from showing up for level 99 skills "
	)
	default boolean hideMaxed()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "logoutPausing",
		name = "Pause on Logout",
		description = "Configures whether skills should pause on logout"
	)
	default boolean pauseOnLogout()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "intermediateLevelMarkers",
		name = "Show intermediate level markers",
		description = "Marks intermediate levels on the progressbar"
	)
	default boolean showIntermediateLevels()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "pauseSkillAfter",
		name = "Auto pause after",
		description = "Configures how many minutes passes before pausing a skill while in game and there's no XP, 0 means disabled"
	)
	@Units(Units.MINUTES)
	default int pauseSkillAfter()
	{
		return 0;
	}

	@ConfigItem(
		position = 4,
		keyName = "skillTabOverlayMenuOptions",
		name = "Add skill tab canvas menu option",
		description = "Configures whether a menu option to show/hide canvas XP trackers will be added to skills on the skill tab"
	)
	default boolean skillTabOverlayMenuOptions()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "onScreenDisplayMode",
		name = "On-screen tracker display mode (top)",
		description = "Configures the information displayed in the first line of on-screen XP overlays"
	)
	default OnScreenDisplayMode onScreenDisplayMode()
	{
		return OnScreenDisplayMode.XP_GAINED;
	}

	@ConfigItem(
		position = 6,
		keyName = "onScreenDisplayModeBottom",
		name = "On-screen tracker display mode (bottom)",
		description = "Configures the information displayed in the second line of on-screen XP overlays"
	)
	default OnScreenDisplayModeBottom onScreenDisplayModeBottom()
	{
		return OnScreenDisplayModeBottom.XP_HOUR;
	}
}
