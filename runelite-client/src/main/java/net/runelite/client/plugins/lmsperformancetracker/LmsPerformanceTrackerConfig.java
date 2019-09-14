/*
 * Copyright (c) 2019, Matsyir <https://github.com/Matsyir>
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
package net.runelite.client.plugins.lmsperformancetracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("lmsPerformanceTracker")
public interface LmsPerformanceTrackerConfig extends Config
{
	@ConfigItem(
		keyName = "restrictToLms",
		name = "Restrict to LMS",
		description = "Restricts use within the LMS area. WARNING: inaccurate outside LMS, as each weapon's combat style has to be manually specified.",
		position = 0
	)
	default boolean restrictToLms()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCurrentFightOverlay",
		name = "Current Fight Overlay",
		description = "Display an overlay of statistics while fighting.",
		position = 1
	)
	default boolean showCurrentFightOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverlayTitle",
		name = "Show Overlay Title",
		description = "The overlay will have a title to say it's the LMS Performance Tracker.",
		position = 2
	)
	default boolean showOverlayTitle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "saveFightHistory",
		name = "Save Fight History",
		description = "Enables the Panel which displays previous fight statistics.",
		position = 3
	)
	default boolean saveFightHistory()
	{
		return true;
	}
}