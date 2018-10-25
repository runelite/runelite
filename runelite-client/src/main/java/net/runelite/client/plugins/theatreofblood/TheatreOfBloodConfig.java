/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.theatreofblood;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("TheatreOfBlood")
public interface TheatreOfBloodConfig extends Config
{
	@ConfigItem(
		keyName = "showRoomOverlay",
		name = "Show Room Overlay",
		description = "Toggles whether the Room overlay is displayed or not",
		position = 0,
		hidden = true
	)
	default boolean showRoomOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showRoomChatMessages",
		name = "Room Chat Messages",
		description = "Should in-game chat messages displaying Room stats be shown upon competition",
		position = 1
	)
	default boolean showRoomChatMessages()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCurrentRaidOverlay",
		name = "Show Current Raid Overlay",
		description = "Toggles whether the Current Raid overlay is displayed or not",
		position = 2,
		hidden = true
	)
	default boolean showCurrentRaidOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showCurrentRaidChatMessages",
		name = "Current Raid Chat Messages",
		description = "Should in-game chat messages displaying Current Raid stats be shown upon competition",
		position = 3
	)
	default boolean showCurrentRaidChatMessages()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTotalRaidOverlay",
		name = "Show Total Raid Overlay",
		description = "Toggles whether the Total Raid overlay is displayed or not",
		position = 4,
		hidden = true
	)
	default boolean showTotalRaidOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showTotalRaidChatMessages",
		name = "Total Raid Chat Messages",
		description = "Should in-game chat messages displaying Total Raid stats be shown upon competition",
		position = 5
	)
	default boolean showTotalRaidChatMessages()
	{
		return true;
	}
}
