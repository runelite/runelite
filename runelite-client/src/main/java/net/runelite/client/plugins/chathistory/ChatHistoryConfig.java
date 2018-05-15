/*
 * Copyright (c) 2018, Brandon Scott <http://github.com/brandongregoryscott>
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
package net.runelite.client.plugins.chathistory;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	name = "Chat History",
	keyName = "chathistory",
	description = "Configuration for the chat history plugin"
)
public interface ChatHistoryConfig extends Config
{
	@ConfigItem(
		keyName = "savePublicChat",
		name = "Save public chat",
		description = "Configures whether or not to save history for the public chat"
	)
	default boolean savePublicChat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "savePrivateChat",
		name = "Save private chat",
		description = "Configures whether or not to save history for the private chat"
	)
	default boolean savePrivateChat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "saveClanChat",
		name = "Save clan chat",
		description = "Configures whether or not to save history for the clan chat"
	)
	default boolean saveClanChat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "saveGameMessages",
		name = "Save game messages",
		description = "Configures whether or not to save history for messages from the game tab (does not include filtered ones)"
	)
	default boolean saveGameMessages()
	{
		return false;
	}

	@ConfigItem(
		keyName = "saveExamineMessages",
		name = "Save examine messages",
		description = "Configures whether or not to save history for examine messages (items, objects, NPCs) from the game tab"
	)
	default boolean saveExamineMessages()
	{
		return false;
	}

	@ConfigItem(
		keyName = "saveFilteredMessages",
		name = "Save filtered messages",
		description = "Configures whether or not to save history for filtered messages from the game tab"
	)
	default boolean saveFilteredMessages()
	{
		return false;
	}

	@ConfigItem(
		keyName = "saveTradeMessages",
		name = "Save trade messages",
		description = "Configures whether or not to save history for trade messages"
	)
	default boolean saveTradeMessages()
	{
		return false;
	}

	@ConfigItem(
		keyName = "saveDuelMessages",
		name = "Save duel messages",
		description = "Configures whether or not to save history for duel messages"
	)
	default boolean saveDuelMessages()
	{
		return false;
	}
}
