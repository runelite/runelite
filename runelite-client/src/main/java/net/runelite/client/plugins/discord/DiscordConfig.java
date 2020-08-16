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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("discord")
public interface DiscordConfig extends Config
{
	@ConfigItem(
		keyName = "actionTimeout",
		name = "Action timeout",
		description = "Configures after how long of not updating status will be reset (in minutes)",
		position = 1
	)
	@Units(Units.MINUTES)
	default int actionTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "hideElapsedTime",
		name = "Hide elapsed time",
		description = "Configures if the elapsed time of your activity should be hidden.",
		position = 2
	)
	default boolean hideElapsedTime()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showSkillActivity",
		name = "Skilling",
		description = "Show your activity while training skills",
		position = 3
	)
	default boolean showSkillingActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBossActivity",
		name = "Bosses",
		description = "Show your activity and location while at bosses",
		position = 4
	)
	default boolean showBossActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCityActivity",
		name = "Cities",
		description = "Show your activity and location while in cities",
		position = 5
	)
	default boolean showCityActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDungeonActivity",
		name = "Dungeons",
		description = "Show your activity and location while in dungeons",
		position = 6
	)
	default boolean showDungeonActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMinigameActivity",
		name = "Minigames",
		description = "Show your activity and location while in minigames",
		position = 7
	)
	default boolean showMinigameActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRaidingActivity",
		name = "Raids",
		description = "Show your activity and location while in Raids",
		position = 8
	)
	default boolean showRaidingActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRegionsActivity",
		name = "Regions",
		description = "Show your activity and location while in other regions",
		position = 9
	)
	default boolean showRegionsActivity()
	{
		return true;
	}
}
