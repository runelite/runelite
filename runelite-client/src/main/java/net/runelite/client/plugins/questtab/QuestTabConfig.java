/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.questtab;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "questtab",
	name = "Quest Tab",
	description = "Choose filtering options for the quest tab."
)
public interface QuestTabConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "hideCompleted",
		name = "Hide Completed Quests",
		description = "Configures whether or not completed quests are hidden"
	)
	default boolean hideCompleted()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "hideInProgress",
		name = "Hide In-Progress Quests",
		description = "Configures whether or not in-progress quests are hidden"
	)
	default boolean hideInProgress()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "hideNotStarted",
		name = "Hide Not Started Quests",
		description = "Configures whether or not quest that have not been started are hidden"
	)

	default boolean hideNotStarted()
	{
		return false;
	}
	@ConfigItem(
		position = 4,
		keyName = "hideFree",
		name = "Hide F2P Quests",
		description = "Configures whether or not f2p quests are hidden"
	)
	default boolean hideFree()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "hideMembers",
		name = "Hide Members Quests",
		description = "Configures whether or not members quests are hidden"
	)
	default boolean hideMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "hideMiniquests",
		name = "Hide Miniquests",
		description = "Configures whether or not miniquests are hidden"
	)
	default boolean hideMiniquests()
	{
		return false;
	}

}
