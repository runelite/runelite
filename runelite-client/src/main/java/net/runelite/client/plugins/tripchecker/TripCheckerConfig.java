/*
 * Copyright (c) 2018, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.tripchecker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "tripChecker",
	name = "Trip Checker",
	description = "Configuration for the Trip Checker plugin"
)
public interface TripCheckerConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "displayMode",
		name = "Notification Style",
		description = "Configures how to display missing items."
	)
	default DisplayMode getNotificationStyle()
	{
		return DisplayMode.BOTH;
	}

	@ConfigItem(
		position = 2,
		keyName = "checkItemQuantities",
		name = "Check item quantities",
		description = "Configures if loadouts should care about item quantities."
	)
	default boolean checkItemQuantities()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "ignoreItemCharges",
		name = "Ignore item charges",
		description = "Configures if item charges should be ignored."
	)
	default boolean ignoreItemCharges()
	{
		return false;
	}

	@ConfigItem(
		keyName = "loadouts",
		name = "",
		description = "",
		hidden = true
	)
	default String loadouts()
	{
		return "";
	}

	@ConfigItem(
		keyName = "loadouts",
		name = "",
		description = ""
	)
	void loadouts(String loadouts);
}

