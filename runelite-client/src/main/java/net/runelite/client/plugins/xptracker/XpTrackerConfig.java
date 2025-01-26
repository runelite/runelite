/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Units;

@ConfigGroup("xpTracker")
public interface XpTrackerConfig extends Config
{
	@ConfigSection(
		name = "Overlay",
		description = "Canvas overlay options.",
		position = 99
	)
	String overlaySection = "overlay";

	@ConfigItem(
		keyName = "saveState",
		name = "Save between sessions",
		description = "Saves xp trackers between sessions."
	)
	default boolean saveState()
	{
		return true;
	}

	@ConfigItem(
		position = 0,
		keyName = "hideMaxed",
		name = "Hide maxed skills",
		description = "XP tracker will no longer track level 99 skills."
	)
	default boolean hideMaxed()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "logoutPausing",
		name = "Pause on logout",
		description = "Configures whether skills should pause on logout."
	)
	default boolean pauseOnLogout()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "intermediateLevelMarkers",
		name = "Show intermediate level markers",
		description = "Marks intermediate levels on the progress bar."
	)
	default boolean showIntermediateLevels()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "pauseSkillAfter",
		name = "Auto pause after",
		description = "Configures how many minutes passes before pausing a skill while in game and there's no XP, 0 means disabled."
	)
	@Units(Units.MINUTES)
	default int pauseSkillAfter()
	{
		return 0;
	}

	@ConfigItem(
		position = 4,
		keyName = "resetSkillRateAfter",
		name = "Auto reset after",
		description = "Configures how many minutes passes before resetting a skill's per hour rates while in game and there's no XP, 0 means disabled."
	)
	@Units(Units.MINUTES)
	default int resetSkillRateAfter()
	{
		return 0;
	}

	@ConfigItem(
		position = 5,
		keyName = "skillTabOverlayMenuOptions",
		name = "Add skill tab canvas menu option",
		description = "Configures whether a menu option to show/hide canvas XP trackers will be added to skills on the skill tab.",
		section = overlaySection
	)
	default boolean skillTabOverlayMenuOptions()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "onScreenDisplayMode",
		name = "On-screen tracker display mode (top)",
		description = "Configures the information displayed in the first line of on-screen XP overlays.",
		section = overlaySection
	)
	default XpPanelLabel onScreenDisplayMode()
	{
		return XpPanelLabel.XP_GAINED;
	}

	@ConfigItem(
		position = 7,
		keyName = "onScreenDisplayModeBottom",
		name = "On-screen tracker display mode (bottom)",
		description = "Configures the information displayed in the second line of on-screen XP overlays.",
		section = overlaySection
	)
	default XpPanelLabel onScreenDisplayModeBottom()
	{
		return XpPanelLabel.XP_HOUR;
	}

	@ConfigItem(
		position = 8,
		keyName = "xpPanelLabel1",
		name = "Top-left XP info label",
		description = "Configures the information displayed in the top-left of XP info box."
	)
	default XpPanelLabel xpPanelLabel1()
	{
		return XpPanelLabel.XP_GAINED;
	}

	@ConfigItem(
		position = 9,
		keyName = "xpPanelLabel2",
		name = "Top-right XP info label",
		description = "Configures the information displayed in the top-right of XP info box."
	)

	default XpPanelLabel xpPanelLabel2()
	{
		return XpPanelLabel.XP_LEFT;
	}

	@ConfigItem(
		position = 10,
		keyName = "xpPanelLabel3",
		name = "Bottom-left XP info label",
		description = "Configures the information displayed in the bottom-left of XP info box."
	)
	default XpPanelLabel xpPanelLabel3()
	{
		return XpPanelLabel.XP_HOUR;
	}

	@ConfigItem(
		position = 11,
		keyName = "xpPanelLabel4",
		name = "Bottom-right XP info label",
		description = "Configures the information displayed in the bottom-right of XP info box."
	)
	default XpPanelLabel xpPanelLabel4()
	{
		return XpPanelLabel.ACTIONS_LEFT;
	}

	@ConfigItem(
		position = 12,
		keyName = "progressBarLabel",
		name = "Progress bar label",
		description = "Configures the info box progress bar to show time to goal or percentage complete."
	)
	default XpProgressBarLabel progressBarLabel()
	{
		return XpProgressBarLabel.PERCENTAGE;
	}

	@ConfigItem(
		position = 13,
		keyName = "progressBarTooltipLabel",
		name = "Tooltip label",
		description = "Configures the info box progress bar tooltip to show time to goal or percentage complete."
	)
	default XpProgressBarLabel progressBarTooltipLabel()
	{
		return XpProgressBarLabel.TIME_TO_LEVEL;
	}

	@ConfigItem(
		position = 14,
		keyName = "prioritizeRecentXpSkills",
		name = "Move recently trained skills to top",
		description = "Configures whether skills should be organized by most recently gained XP."
	)
	default boolean prioritizeRecentXpSkills()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "wiseOldManOpenOption",
		name = "Wise Old Man option",
		description = "Adds an option to the XP info box right-click menu to open Wise Old Man."
	)
	default boolean wiseOldManOpenOption()
	{
		return true;
	}
}
