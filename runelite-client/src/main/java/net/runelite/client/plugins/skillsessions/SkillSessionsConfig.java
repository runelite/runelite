/*
 * Copyright (c) 2018, Desetude <harry@desetude.com>
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
package net.runelite.client.plugins.skillsessions;

import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "skillsessions",
		name = "Skill Session",
		description = "Configuration for the skill sessions plugin"
)
public interface SkillSessionsConfig
{
	@ConfigItem(
			keyName = "statTimeout",
			name = "Session statistics timeout (minutes)",
			description = "Configures the time since an action for the session statistics to no longer displayed"
	)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
			keyName = "timeoutStatReset",
			name = "Reset the statistics when the session times out",
			description = "Configures whether the statistics of a session should be reset when the session times out"
	)
	default boolean statTimeoutReset()
	{
		return false;
	}

	@ConfigItem(
			keyName = "showFishing",
			name = "Display your fishing session statistics",
			description = "Configures whether your fishing session statistics are displayed"
	)
	default boolean showFishing()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showCooking",
			name = "Display your cooking session statistics",
			description = "Configures whether your cooking session statistics are displayed"
	)
	default boolean showCooking()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showAgility",
			name = "Display your agility session statistics",
			description = "Configures whether your agility session statistics are displayed"
	)
	default boolean showAgility()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showWoodcutting",
			name = "Display your woodcutting session statistics",
			description = "Configures whether your woodcutting session statistics are displayed"
	)
	default boolean showWoodcutting()
	{
		return true;
	}
}
