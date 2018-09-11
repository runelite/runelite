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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("fishing")
public interface FishingConfig extends Config
{
	@ConfigItem(
		keyName = "showIcons",
		name = "Display Fish icons",
		description = "Configures whether icons or text is displayed",
		position = 1
	)
	default boolean showIcons()
	{
		return true;
	}

	@ConfigItem(
		keyName = "statTimeout",
		name = "Reset stats (minutes)",
		description = "Configures the time until statistic is reset",
		position = 2
	)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "showFishingStats",
		name = "Show Fishing session stats",
		description = "Configures whether to display the fishing session stats",
		position = 3
	)
	default boolean showFishingStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMinnowOverlay",
		name = "Show Minnow Movement overlay",
		description = "Configures whether to display the minnow progress pie overlay",
		position = 4
	)
	default boolean showMinnowOverlay()
	{
		return true;
	}
}
