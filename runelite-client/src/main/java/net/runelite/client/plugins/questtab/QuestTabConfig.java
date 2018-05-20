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
	description = "Choose filter and sorting options for the quest tab."
)
public interface QuestTabConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "hideFree",
		name = "Hide F2P Quests",
		description = "Configures whether or not f2p quests are hidden"
	)
	default boolean hideFree()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "hideMembers",
		name = "Hide Members Quests",
		description = "Configures whether or not members quests are hidden"
	)
	default boolean hideMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "hideMiniquests",
		name = "Hide Miniquests",
		description = "Configures whether or not miniquests are hidden"
	)
	default boolean hideMiniquests()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "hideCompleted",
		name = "Hide Completed Quests",
		description = "Configures whether or not completed quests are hidden"
	)
	default boolean hideCompleted()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "hideInProgress",
		name = "Hide In-Progress Quests",
		description = "Configures whether or not in-progress quests are hidden"
	)
	default boolean hideInProgress()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "hideNotStarted",
		name = "Hide Not Started Quests",
		description = "Configures whether or not quest that have not been started are hidden"
	)
	default boolean hideNotStarted()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "hideCantDo",
		name = "Hide Can't Do",
		description = "Configures whether or not quests that cannot be done because of missing reqs will be hidden"
	)
	default boolean hideCantDo()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "showDifficulty",
		name = "Show Difficulty",
		description = "Configures whether or not to show a letter signifying difficulty next to quest list items"
	)
	default boolean showDifficulty()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "sortDifficulty",
		name = "Sort on Difficulty",
		description = "Configures whether or not quests are sorted from least difficult to most difficult"
	)
	default boolean sortDifficulty()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "showLength",
		name = "Show Length",
		description = "Configures whether or not to show a letter signifying length next to quest list items"
	)
	default boolean showLength()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "sortLength",
		name = "Sort on Length",
		description = "Configures whether or not quests are sorted from shortest to longest"
	)
	default boolean sortLength()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "menuOption",
		name = "Menu option",
		description = "Show filter and sort options when right clicking quest tab"
	)
	default boolean menuOption()
	{
		return true;
	}

}
