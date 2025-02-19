/*
 * Copyright (c) 2018, Magic fTail
 * Copyright (c) 2019, osrs-music-map <osrs-music-map@users.noreply.github.com>
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
package net.runelite.client.plugins.chatfilter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("chatfilter")
public interface ChatFilterConfig extends Config
{
	@ConfigSection(
		name = "Filter lists",
		description = "Custom word, regex, and username filter lists.",
		position = 0,
		closedByDefault = true
	)
	String filterLists = "filterLists";

	@ConfigItem(
		keyName = "filteredWords",
		name = "Filtered words",
		description = "List of filtered words, separated by commas.",
		position = 1,
		section = filterLists
	)
	default String filteredWords()
	{
		return "";
	}

	@ConfigItem(
		keyName = "filteredRegex",
		name = "Filtered regex",
		description = "List of regular expressions to filter, one per line.",
		position = 2,
		section = filterLists
	)
	default String filteredRegex()
	{
		return "";
	}

	@ConfigItem(
		keyName = "filteredNames",
		name = "Filtered names",
		description = "List of filtered names, one per line. Accepts regular expressions.",
		position = 3,
		section = filterLists
	)
	default String filteredNames()
	{
		return "";
	}

	@ConfigItem(
		keyName = "filterType",
		name = "Filter type",
		description = "Configures how the messages are filtered.",
		position = 4
	)
	default ChatFilterType filterType()
	{
		return ChatFilterType.CENSOR_WORDS;
	}

	@ConfigItem(
		keyName = "filterFriends",
		name = "Filter friends",
		description = "Filter your friends' messages.",
		position = 5
	)
	default boolean filterFriends()
	{
		return false;
	}

	@ConfigItem(
		keyName = "filterClan",
		name = "Filter friends chat members",
		description = "Filter your friends chat members' messages.",
		position = 6
	)
	default boolean filterFriendsChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "filterClanChat",
		name = "Filter clan chat members",
		description = "Filter your clan chat members' messages.",
		position = 7
	)
	default boolean filterClanChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "filterGameChat",
		name = "Filter game chat",
		description = "Filter your game chat messages.",
		position = 9
	)
	default boolean filterGameChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "collapseGameChat",
		name = "Collapse game chat",
		description = "Collapse duplicate game chat messages into a single line.",
		position = 10
	)
	default boolean collapseGameChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "collapsePlayerChat",
		name = "Collapse player chat",
		description = "Collapse duplicate player chat messages into a single line.",
		position = 11
	)
	default boolean collapsePlayerChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "maxRepeatedPublicChats",
		name = "Repeat filter",
		description = "Block player chat message if repeated this many times. 0 is off.",
		position = 12
	)
	default int maxRepeatedPublicChats()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "stripAccents",
		name = "Strip accents",
		description = "Remove accents before applying filters.",
		position = 13
	)
	default boolean stripAccents()
	{
		return false;
	}
}
