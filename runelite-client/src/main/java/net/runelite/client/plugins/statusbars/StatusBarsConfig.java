/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
package net.runelite.client.plugins.statusbars;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.statusbars.config.BarMode;

@ConfigGroup("statusbars")
public interface StatusBarsConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "enableCounter",
		name = "Show counters",
		description = "Shows the numeric value of HP and Prayer on the status bar"
	)
	default boolean enableCounter()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "enableSkillIcon",
		name = "Show icons",
		description = "Adds skill icons at the top of the bars."
	)
	default boolean enableSkillIcon()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "enableRestorationBars",
		name = "Show restores",
		description = "Visually shows how much will be restored to your status bar."
	)
	default boolean enableRestorationBars()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "leftBarMode",
		name = "Left Status Bar",
		description = "Configures the left status bar"
	)
	default BarMode leftBarMode()
	{
		return BarMode.HITPOINTS;
	}

	@ConfigItem(
		position = 5,
		keyName = "rightBarMode",
		name = "Right Status Bar",
		description = "Configures the right status bar"
	)
	default BarMode rightBarMode()
	{
		return BarMode.PRAYER;
	}

	@ConfigItem(
		position = 6,
		keyName = "toggleRestorationBars",
		name = "Toggle to hide when not in combat",
		description = "Visually hides the Status Bars when player is out of combat."
	)
	default boolean toggleRestorationBars()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "hideStatusBarDelay",
		name = "Delay (seconds)",
		description = "Number of seconds after combat to hide the status bars."
	)
	default int hideStatusBarDelay()
	{
		return 3;
	}
}
