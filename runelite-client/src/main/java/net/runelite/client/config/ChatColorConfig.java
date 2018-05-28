/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.config;

import java.awt.Color;

@ConfigGroup(
	keyName = "textrecolor",
	name = "Chat Text Recolor",
	description = "Configuration for chat text recoloring"
)
public interface ChatColorConfig extends Config
{
	@ConfigItem(
		position = 31,
		keyName = "opaquePublicChat",
		name = "Public chat",
		description = "Color of Public chat"
	)
	Color opaquePublicChat();

	@ConfigItem(
		position = 32,
		keyName = "opaquePublicChatHighlight",
		name = "Public chat highlight",
		description = "Color of highlights in Public chat"
	)
	default Color opaquePublicChatHighlight()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 33,
		keyName = "opaquePrivateMessageSent",
		name = "Sent private messages",
		description = "Color of Private messages you've sent"
	)
	Color opaquePrivateMessageSent();

	@ConfigItem(
		position = 34,
		keyName = "opaquePrivateMessageSentHighlight",
		name = "Sent private messages highlight",
		description = "Color of highlights in Private messages you've sent"
	)
	default Color opaquePrivateMessageSentHighlight()
	{
		return Color.decode("#002783");
	}

	@ConfigItem(
		position = 35,
		keyName = "opaquePrivateMessageReceived",
		name = "Recieved private messages",
		description = "Color of Private messages you've received"
	)
	Color opaquePrivateMessageReceived();

	@ConfigItem(
		position = 36,
		keyName = "opaquePrivateMessageReceivedHighlight",
		name = "Received private messages highlight",
		description = "Color of highlights in Private messages you've received"
	)
	default Color opaquePrivateMessageReceivedHighlight()
	{
		return Color.decode("#002783");
	}

	@ConfigItem(
		position = 37,
		keyName = "opaqueClanChatInfo",
		name = "Clan chat info",
		description = "Clan Chat Information (eg. when joining a channel)"
	)
	Color opaqueClanChatInfo();

	@ConfigItem(
		position = 38,
		keyName = "opaqueClanChatMessage",
		name = "Clan chat message",
		description = "Color of Clan Chat Messages"
	)
	Color opaqueClanChatMessage();

	@ConfigItem(
		position = 39,
		keyName = "opaqueClanChatMessageHighlight",
		name = "Clan chat message highlight",
		description = "Color of highlights in Clan Chat Messages"
	)
	default Color opaqueClanChatMessageHighlight()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 40,
		keyName = "opaqueAutochatMessage",
		name = "Autochat",
		description = "Color of Autochat messages"
	)
	Color opaqueAutochatMessage();

	@ConfigItem(
		position = 41,
		keyName = "opaqueAutochatMessageHighlight",
		name = "Autochat highlight",
		description = "Color of highlights in Autochat messages"
	)
	Color opaqueAutochatMessageHighlight();

	@ConfigItem(
		position = 42,
		keyName = "opaqueTradeChatMessage",
		name = "Trade chat",
		description = "Color of Trade Chat Messages"
	)
	Color opaqueTradeChatMessage();

	@ConfigItem(
		position = 43,
		keyName = "opaqueTradeChatMessageHighlight",
		name = "Trade chat highlight",
		description = "Color of highlights in Trade Chat Messages"
	)
	Color opaqueTradeChatMessageHighlight();

	@ConfigItem(
		position = 44,
		keyName = "opaqueServerMessage",
		name = "Server message",
		description = "Color of Server Messages (eg. 'Welcome to Runescape')"
	)
	Color opaqueServerMessage();

	@ConfigItem(
		position = 45,
		keyName = "opaqueServerMessageHighlight",
		name = "Server message highlight",
		description = "Color of highlights in Server Messages"
	)
	Color opaqueServerMessageHighlight();

	@ConfigItem(
		position = 46,
		keyName = "opaqueGameMessage",
		name = "Game message",
		description = "Color of Game Messages"
	)
	Color opaqueGameMessage();

	@ConfigItem(
		position = 47,
		keyName = "opaqueGameMessageHighlight",
		name = "Game message highlight",
		description = "Color of highlights in Game Messages"
	)
	Color opaqueGameMessageHighlight();

	@ConfigItem(
		position = 48,
		keyName = "opaqueExamine",
		name = "Examine",
		description = "Color of Examine Text"
	)
	Color opaqueExamine();

	@ConfigItem(
		position = 49,
		keyName = "opaqueExamineHighlight",
		name = "Examine Highlight",
		description = "Color of highlights in Examine Text"
	)
	Color opaqueExamineHighlight();

	@ConfigItem(
		position = 50,
		keyName = "opaqueFiltered",
		name = "Filtered",
		description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered)"
	)
	Color opaqueFiltered();

	@ConfigItem(
		position = 51,
		keyName = "opaqueFilteredHighlight",
		name = "Filtered Highlight",
		description = "Color of highlights in Filtered Text"
	)
	Color opaqueFilteredHighlight();

	@ConfigItem(
		position = 52,
		keyName = "opaqueUsername",
		name = "Usernames",
		description = "Color of Usernames"
	)
	Color opaqueUsername();

	@ConfigItem(
		position = 53,
		keyName = "opaquePrivateUsernames",
		name = "Private chat usernames",
		description = "Color of Usernames in Private Chat"
	)
	Color opaquePrivateUsernames();

	@ConfigItem(
		position = 54,
		keyName = "opaqueClanChannelName",
		name = "Chan channel Name",
		description = "Color of Clan Channel Name"
	)
	Color opaqueClanChannelName();

	@ConfigItem(
		position = 55,
		keyName = "opaqueClanUsernames",
		name = "Clan usernames",
		description = "Color of Usernames in Clan Chat"
	)
	Color opaqueClanUsernames();

	@ConfigItem(
		position = 61,
		keyName = "transparentPublicChat",
		name = "Public chat (transparent)",
		description = "Color of Public chat (transparent)"
	)
	Color transparentPublicChat();

	@ConfigItem(
		position = 62,
		keyName = "transparentPublicChatHighlight",
		name = "Public chat highlight (transparent)",
		description = "Color of highlights in Public chat (transparent)"
	)
	default Color transparentPublicChatHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 63,
		keyName = "transparentPrivateMessageSent",
		name = "Sent private messages (transparent)",
		description = "Color of Private messages you've sent (transparent)"
	)
	Color transparentPrivateMessageSent();

	@ConfigItem(
		position = 64,
		keyName = "transparentPrivateMessageSentHighlight",
		name = "Sent private messages highlight (transparent)",
		description = "Color of highlights in Private messages you've sent (transparent)"
	)
	default Color transparentPrivateMessageSentHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 65,
		keyName = "transparentPrivateMessageReceived",
		name = "Received private messages (transparent)",
		description = "Color of Private messages you've received (transparent)"
	)
	Color transparentPrivateMessageReceived();

	@ConfigItem(
		position = 66,
		keyName = "transparentPrivateMessageReceivedHighlight",
		name = "Received private messages highlight (transparent)",
		description = "Color of highlights in Private messages you've received (transparent)"
	)
	default Color transparentPrivateMessageReceivedHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 67,
		keyName = "transparentClanChatInfo",
		name = "Clan chat info (transparent)",
		description = "Clan Chat Information (eg. when joining a channel) (transparent)"
	)
	Color transparentClanChatInfo();

	@ConfigItem(
		position = 68,
		keyName = "transparentClanChatMessage",
		name = "Clan chat message (transparent)",
		description = "Color of Clan Chat Messages (transparent)"
	)
	Color transparentClanChatMessage();

	@ConfigItem(
		position = 69,
		keyName = "transparentClanChatMessageHighlight",
		name = "Clan chat message highlight (transparent)",
		description = "Color of highlights in Clan Chat Messages (transparent)"
	)
	default Color transparentClanChatMessageHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 70,
		keyName = "transparentAutochatMessage",
		name = "Autochat (transparent)",
		description = "Color of Autochat messages (transparent)"
	)
	Color transparentAutochatMessage();

	@ConfigItem(
		position = 71,
		keyName = "transparentAutochatMessageHighlight",
		name = "Autochat highlight (transparent)",
		description = "Color of highlights in Autochat messages (transparent)"
	)
	Color transparentAutochatMessageHighlight();

	@ConfigItem(
		position = 72,
		keyName = "transparentTradeChatMessage",
		name = "Trade chat (transparent)",
		description = "Color of Trade Chat Messages (transparent)"
	)
	Color transparentTradeChatMessage();

	@ConfigItem(
		position = 73,
		keyName = "transparentTradeChatMessageHighlight",
		name = "Trade chat highlight (transparent)",
		description = "Color of highlights in Trade Chat Messages (transparent)"
	)
	Color transparentTradeChatMessageHighlight();

	@ConfigItem(
		position = 74,
		keyName = "transparentServerMessage",
		name = "Server message (transparent)",
		description = "Color of Server Messages (eg. 'Welcome to Runescape') (transparent)"
	)
	Color transparentServerMessage();

	@ConfigItem(
		position = 75,
		keyName = "transparentServerMessageHighlight",
		name = "Server message highlight (transparent)",
		description = "Color of highlights in Server Messages (transparent)"
	)
	Color transparentServerMessageHighlight();

	@ConfigItem(
		position = 76,
		keyName = "transparentGameMessage",
		name = "Game message (transparent)",
		description = "Color of Game Messages (transparent)"
	)
	Color transparentGameMessage();

	@ConfigItem(
		position = 77,
		keyName = "transparentGameMessageHighlight",
		name = "Game message highlight (transparent)",
		description = "Color of highlights in Game Messages (transparent)"
	)
	Color transparentGameMessageHighlight();

	@ConfigItem(
		position = 78,
		keyName = "transparentExamine",
		name = "Examine (transparent)",
		description = "Color of Examine Text (transparent)"
	)
	Color transparentExamine();

	@ConfigItem(
		position = 79,
		keyName = "transparentExamineHighlight",
		name = "Examine Highlight (transparent)",
		description = "Color of highlights in Examine Text (transparent)"
	)
	Color transparentExamineHighlight();

	@ConfigItem(
		position = 80,
		keyName = "transparentFiltered",
		name = "Filtered (transparent)",
		description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered) (transparent)"
	)
	Color transparentFiltered();

	@ConfigItem(
		position = 81,
		keyName = "transparentFilteredHighlight",
		name = "Filtered Highlight (transparent)",
		description = "Color of highlights in Filtered Text (transparent)"
	)
	Color transparentFilteredHighlight();

	@ConfigItem(
		position = 82,
		keyName = "transparentUsername",
		name = "Usernames (transparent)",
		description = "Color of Usernames (transparent)"
	)
	Color transparentUsername();

	@ConfigItem(
		position = 83,
		keyName = "transparentPrivateUsernames",
		name = "Private chat usernames (transparent)",
		description = "Color of Usernames in Private Chat (transparent)"
	)
	Color transparentPrivateUsernames();

	@ConfigItem(
		position = 84,
		keyName = "transparentClanChannelName",
		name = "Chan channel Name (transparent)",
		description = "Color of Clan Channel Name (transparent)"
	)
	Color transparentClanChannelName();

	@ConfigItem(
		position = 85,
		keyName = "transparentClanUsernames",
		name = "Clan usernames (transparent)",
		description = "Color of Usernames in Clan Chat (transparent)"
	)
	Color transparentClanUsernames();
}
