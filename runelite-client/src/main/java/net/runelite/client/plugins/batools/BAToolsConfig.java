/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.batools;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("BATools")
public interface BAToolsConfig extends Config
{
	@ConfigItem(
		keyName = "defTimer",
		name = "Defender Tick Timer",
		description = "Shows the current cycle tick of runners."
	)
	default boolean defTimer()
	{
		return false;
	}

	@ConfigItem(
		keyName = "calls",
		name = "Remove Incorrect Calls",
		description = "Remove incorrect calls."
	)
	default boolean calls()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapLadder",
		name = "Swap ladder option",
		description = "Swap Climb-down with Quick-start in the wave lobbies"
	)
	default boolean swapLadder()
	{
		return true;
	}

	@ConfigItem(
		keyName = "healerCodes",
		name = "Healer Codes",
		description = "Overlay to show healer codes"
	)
	default boolean healerCodes()
	{
		return false;
	}

	@ConfigItem(
		keyName = "healerMenuOption",
		name = "Healer menu options",
		description = "asd"
	)
	default boolean healerMenuOption()
	{
		return false;
	}

	@ConfigItem(
		keyName = "antiDrag",
		name = "Anti Drag",
		description = "asd"
	)
	default boolean antiDrag()
	{
		return false;
	}

	@ConfigItem(
		keyName = "antiDragDelay",
		name = "Anti Drag Delay",
		description = "asd"
	)
	default int antiDragDelay()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "eggBoi",
		name = "Collector helper",
		description = "asd"
	)
	default boolean eggBoi()
	{
		return false;
	}

	@ConfigItem(
		keyName = "osHelp",
		name = "Shift OS",
		description = "asd"
	)
	default boolean osHelp()
	{
		return false;
	}

	@ConfigItem(
		keyName = "prayerMetronome",
		name = "Prayer Metronome",
		description = "asd"
	)
	default boolean prayerMetronome()
	{
		return false;
	}

	@ConfigItem(
		keyName = "prayerMetronomeVolume",
		name = "Prayer Metronome Volume",
		description = "asd"
	)
	default int prayerMetronomeVolume()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "attackStyles",
		name = "Attack Styles",
		description = "Hide attack styles depending on weapon."
	)
	default boolean attackStyles()
	{
		return false;
	}

	@ConfigItem(
		keyName = "removeBA",
		name = "*Barbarian Assault Helper*",
		description = "Remove unnecessary menu options in Barbarian Assault depending on role<br>Examples: Remove attack options when not attacker<br>Remove take options when not collector"
	)
	default boolean removeBA()
	{
		return true;
	}

	@ConfigItem(
		keyName = "removeWrongEggs",
		name = "Remove wrong eggs - *Barbarian Assault Helper*",
		description = "Remove unnecessary menu options in Barbarian Assault depending on role<br>Examples: Remove attack options when not attacker<br>Remove take options when not collector"
	)
	default boolean removeWrongEggs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "removeWrongHealFood",
		name = "Remove wrong Heal Food - *Barbarian Assault Helper*",
		description = "Remove unnecessary menu options in Barbarian Assault depending on role<br>Examples: Remove attack options when not attacker<br>Remove take options when not collector"
	)
	default boolean removeHealWrongFood()
	{
		return false;
	}

}