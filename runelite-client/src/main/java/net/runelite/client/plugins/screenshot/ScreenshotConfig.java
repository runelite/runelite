/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.screenshot;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("It's coming home")
public interface ScreenshotConfig extends Config
{
	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 0
	)
	default boolean includeFrame()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 1
	)
	default boolean displayDate()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 2
	)
	default boolean notifyWhenTaken()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 3
	)
	default boolean screenshotRewards()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 4
	)
	default boolean screenshotLevels()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 5
	)
	default boolean screenshotKingdom()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 6
	)
	default boolean screenshotPet()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 7
	)
	default boolean uploadScreenshot()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 10
	)
	default Keybind hotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 9
	)
	default boolean screenshotKills()
	{
		return false;
	}
}
