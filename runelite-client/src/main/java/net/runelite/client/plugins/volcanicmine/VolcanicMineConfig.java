/*
 * Copyright (c) 2017. l2-
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.volcanicmine;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "VolcanicMine",
	name = "Volcanic mine",
	description = "Configuration for the volcanic mine plugin"
)
public interface VolcanicMineConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "enabled",
		name = "Enable",
		description = "Configures whether the volcanic mine plugin is displayed"
	)
	default boolean enabled()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "tray",
		name = "Send Tray Notification",
		description = "Toggles tray notifications"
	)
	default boolean sendTrayNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "focused",
		name = "Alert When Focused",
		description = "Toggles idle notifications for when the client is focused"
	)
	default boolean alertWhenFocused()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "request",
		name = "Request Window Focus",
		description = "Toggles window focus request"
	)
	default boolean requestFocus()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "prayerHelper",
		name = "shows prayer",
		description = "Shows when you need to use protection prayers"
	)
	default boolean prayerHelperEnabled()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "timerOverlay",
		name = "timer overlay",
		description = "The overlay showing the timers"
	)
	default boolean timerOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "optimalPathOverlay",
		name = "show optimal Paths",
		description = "The overlay showing the optimal paths"
	)
	default boolean optimalPaths()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "platformColorLow",
		name = "PlatformColor low risk",
		description = "Configures the color for the platformOverlay"
	)
	default Color platformColorLow()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		position = 8,
		keyName = "platformColorMed",
		name = "PlatformColor med risk",
		description = "Configures the color for the platformOverlay"
	)
	default Color platformColorMed()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		position = 9,
		keyName = "platformColorHigh",
		name = "PlatformColor high risk",
		description = "Configures the color for the platformOverlay"
	)
	default Color platformColorHigh()
	{
		return Color.decode("#FF3333");
	}

	@ConfigItem(
		position = 10,
		keyName = "platformTimerThreshold",
		name = "Platform timer notification threshold",
		description = "At what time does the plugin notify (in seconds), set to -1 to disable"
	)
	default int platformTimerThreshold()
	{
		return 20;
	}

	@ConfigItem(
		position = 11,
		keyName = "timeLeftThreshold",
		name = "Time left threshold",
		description = "At what time does the plugin notify (in seconds), set to -1 to disable"
	)
	default int timerThreshold()
	{
		return 40;
	}

	@ConfigItem(
		position = 12,
		keyName = "stabilityThreshold",
		name = "Stability threshold",
		description = "At what stability does the plugin notify (in percentage), set to -1 to disable"
	)
	default int stabilityPercentageThreshold()
	{
		return 30;
	}

	@ConfigItem(
		position = 13,
		keyName = "prayer",
		name = "Prayer warning",
		description = "Protect prayer warning setting"
	)
	default WarningMode prayerWarning()
	{
		return WarningMode.INGAME_AND_NOTIFICATION;
	}

	@ConfigItem(
		position = 14,
		keyName = "hotTiles",
		name = "Hot Tile warning",
		description = "Hot tile warning setting"
	)
	default WarningMode hotTileWarning()
	{
		return WarningMode.INGAME_AND_NOTIFICATION;
	}

	@ConfigItem(
		position = 15,
		keyName = "timerWarning",
		name = "timer warning",
		description = "timer low warning setting"
	)
	default WarningMode timerWarning()
	{
		return WarningMode.INGAME_AND_NOTIFICATION;
	}

	@ConfigItem(
		position = 16,
		keyName = "stabilityWarning",
		name = "stability warning",
		description = "stability low warning setting"
	)
	default WarningMode stabilityWarning()
	{
		return WarningMode.INGAME_AND_NOTIFICATION;
	}
}
