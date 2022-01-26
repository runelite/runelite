/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.discord;

import lombok.AllArgsConstructor;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("discord")
public interface DiscordConfig extends Config
{
	@AllArgsConstructor
	enum ElapsedTimeType
	{
		TOTAL("Total elapsed time"),
		ACTIVITY("Per activity"),
		HIDDEN("Hide elapsed time");

		private final String value;

		@Override
		public String toString()
		{
			return value;
		}
	}

	@ConfigItem(
		keyName = "elapsedTime",
		name = "Elapsed Time",
		description = "Configures elapsed time shown.",
		position = 1
	)
	default ElapsedTimeType elapsedTimeType()
	{
		return ElapsedTimeType.ACTIVITY;
	}

	@ConfigItem(
		keyName = "actionTimeout",
		name = "Activity timeout",
		description = "Configures after how long of not updating activity will be reset (in minutes)",
		position = 2
	)
	@Units(Units.MINUTES)
	default int actionTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "showMainMenu",
		name = "Main Menu",
		description = "Show status when in main menu",
		position = 3
	)
	default boolean showMainMenu()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSkillActivity",
		name = "Skilling",
		description = "Show your activity while training skills",
		position = 4
	)
	default boolean showSkillingActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBossActivity",
		name = "Bosses",
		description = "Show your activity and location while at bosses",
		position = 5
	)
	default boolean showBossActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCityActivity",
		name = "Cities",
		description = "Show your activity and location while in cities",
		position = 6
	)
	default boolean showCityActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDungeonActivity",
		name = "Dungeons",
		description = "Show your activity and location while in dungeons",
		position = 7
	)
	default boolean showDungeonActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMinigameActivity",
		name = "Minigames",
		description = "Show your activity and location while in minigames",
		position = 8
	)
	default boolean showMinigameActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRaidingActivity",
		name = "Raids",
		description = "Show your activity and location while in Raids",
		position = 9
	)
	default boolean showRaidingActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRegionsActivity",
		name = "Regions",
		description = "Show your activity and location while in other regions",
		position = 10
	)
	default boolean showRegionsActivity()
	{
		return true;
	}
}
