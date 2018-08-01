/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018 Jeff LaJoie
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
package net.runelite.client.plugins.huntertracker;

import java.time.Duration;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "huntertracker",
	name = "Hunter Tracker",
	description = "Configuration for the Hunter Tracker plugin"
)
public interface HunterTrackerConfig extends Config
{
	String KEY_NAME = "huntertracker";
	Duration DURATION = Duration.ofMinutes(50); // constant for how long in minutes it takes to harvest 10 birds

	@ConfigItem(
			keyName = "region",
			name = "Default Region",
			description = "Default huntertracker region tab on opening the panel",
			hidden = true
	)
	default Tab region()
	{
		return Tab.FOSSIL_ISLAND;
	}

	@ConfigItem(
			keyName = "region",
			name = "Default Region",
			description = "Default region of birdhouses (in case Jagex adds more in the future)",
			hidden = true
	)
	void setRegion(Tab t);
}
