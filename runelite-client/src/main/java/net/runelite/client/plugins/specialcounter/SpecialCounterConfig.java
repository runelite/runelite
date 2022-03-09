/*
 * Copyright (c) 2020, Dylan <dylanhe@umich.edu>
 * Copyright (c) 2020, Jacob <jgozon@umich.edu>
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
package net.runelite.client.plugins.specialcounter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("specialcounter")
public interface SpecialCounterConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "thresholdNotification",
		name = "Threshold Notifications",
		description = "Sends a notification when your special attack counter exceeds the threshold"
	)
	default boolean thresholdNotification()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "dragonWarhammerThreshold",
		name = "Dragon Warhammer",
		description = "Threshold for Dragon Warhammer (0 to disable)"
	)
	default int dragonWarhammerThreshold()
	{
		return 0;
	}

	@ConfigItem(
		position = 2,
		keyName = "arclightThreshold",
		name = "Arclight",
		description = "Threshold for Arclight (0 to disable)"
	)
	default int arclightThreshold()
	{
		return 0;
	}

	@ConfigItem(
		position = 3,
		keyName = "darklightThreshold",
		name = "Darklight",
		description = "Threshold for Darklight (0 to disable)"
	)
	default int darklightThreshold()
	{
		return 0;
	}

	@ConfigItem(
		position = 4,
		keyName = "bandosGodswordThreshold",
		name = "Bandos Godsword",
		description = "Threshold for Bandos Godsword (0 to disable)"
	)
	default int bandosGodswordThreshold()
	{
		return 0;
	}

	@ConfigItem(
		position = 5,
		keyName = "bulwarkThreshold",
		name = "Dinh's Bulwark",
		description = "Threshold for Dinh's Bulwark (0 to disable)"
	)
	default int bulwarkThreshold()
	{
		return 0;
	}
}
