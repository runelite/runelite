/*
 * Copyright (c) 2020 ThatGamerBlue
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
package net.runelite.client.plugins.freezetimersv2;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;
import java.awt.Color;

@ConfigGroup("freezetimersv2")
public interface FreezeTimersV2Config extends Config
{
	@ConfigItem(
		name = "Show NPCs",
		keyName = "showNpcs",
		description = "Should we show the overlay on NPCs?",
		position = 1
	)
	default boolean showNpcs()
	{
		return false;
	}

	@ConfigItem(
		name = "Show Players",
		keyName = "showPlayers",
		description = "Should we show the overlay on players?",
		position = 2
	)
	default boolean showPlayers()
	{
		return true;
	}

	@ConfigItem(
		name = "Time Mode",
		keyName = "timeMode",
		description = "How should we display the time?",
		position = 3
	)
	default TimeMode timeMode()
	{
		return TimeMode.TICKS;
	}

	@ConfigItem(
		name = "Timer Color",
		keyName = "timerColor",
		description = "Color for timers not on cooldown",
		position = 4
	)
	default Color timerColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		name = "Cooldown Color",
		keyName = "cooldownColor",
		description = "Color for timers on cooldown",
		position = 5
	)
	default Color cooldownColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		name = "Freeze Timers",
		keyName = "freezeTimers",
		description = "Should we render freeze timers?",
		position = 6
	)
	default boolean freezeTimers()
	{
		return true;
	}

	@ConfigItem(
		name = "Teleblock Timers",
		keyName = "teleblockTimers",
		description = "Should we render teleblock timers?",
		position = 7
	)
	default boolean teleblockTimers()
	{
		return true;
	}

	@ConfigItem(
		name = "Vengeance Timers",
		keyName = "vengTimers",
		description = "Should we render vengeance timers?",
		position = 8
	)
	default boolean vengTimers()
	{
		return true;
	}

	@ConfigItem(
		name = "Show Icons",
		keyName = "showIcons",
		description = "Should we render the icons? Note disabling this will override all colors",
		position = 9
	)
	default boolean showIcons()
	{
		return true;
	}

	@ConfigItem(
		name = "Debug Keybind",
		keyName = "debugKeybind",
		description = "Don't press this unless you know what it does :)",
		position = 10,
		hidden = true
	)
	default Keybind debugKeybind()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		name = "Debug Integer",
		keyName = "debugInteger",
		description = "Related to the keybind in some way :)",
		position = 11,
		hidden = true
	)
	default int debugInteger()
	{
		return -1;
	}
}
