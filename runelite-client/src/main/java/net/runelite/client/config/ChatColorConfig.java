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

@ConfigGroup("textrecolor")
public interface ChatColorConfig extends Config
{
	@ConfigSection(
		name = "Opaque",
		description = "The options that control the colors for the opaque chatbox.",
		position = 0,
		closedByDefault = true
	)
	String opaqueSection = "opaqueSection";

	@ConfigSection(
		name = "Transparent",
		description = "The options that control the colors for the transparent chatbox.",
		position = 50,
		closedByDefault = true
	)
	String transparentSection = "transparentSection";

	@ConfigItem(
		position = 1,
		keyName = "opaquePublicChat",
		name = "Public chat",
		description = "Color of public chat.",
		section = opaqueSection
	)
	Color opaquePublicChat();

	@ConfigItem(
		position = 2,
		keyName = "opaquePublicChatHighlight",
		name = "Public chat highlight",
		description = "Color of highlights in public chat.",
		section = opaqueSection
	)
	default Color opaquePublicChatHighlight()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 3,
		keyName = "opaquePrivateMessageSent",
		name = "Sent private messages",
		description = "Color of private messages you've sent.",
		section = opaqueSection
	)
	Color opaquePrivateMessageSent();

	@ConfigItem(
		position = 4,
		keyName = "opaquePrivateMessageSentHighlight",
		name = "Sent private messages highlight",
		description = "Color of highlights in private messages you've sent.",
		section = opaqueSection
	)
	default Color opaquePrivateMessageSentHighlight()
	{
		return Color.decode("#002783");
	}

	@ConfigItem(
		position = 5,
		keyName = "opaquePrivateMessageReceived",
		name = "Received private messages",
		description = "Color of private messages you've received.",
		section = opaqueSection
	)
	Color opaquePrivateMessageReceived();

	@ConfigItem(
		position = 6,
		keyName = "opaquePrivateMessageReceivedHighlight",
		name = "Received private messages highlight",
		description = "Color of highlights in private messages you've received.",
		section = opaqueSection
	)
	default Color opaquePrivateMessageReceivedHighlight()
	{
		return Color.decode("#002783");
	}

	//region opaque friends chat
	@ConfigItem(
		position = 7,
		keyName = "opaqueFriendsChatInfo",
		name = "Friends chat info",
		description = "Friends chat information (eg. when joining a channel).",
		section = opaqueSection
	)
	Color opaqueFriendsChatInfo();

	@ConfigItem(
		position = 8,
		keyName = "opaqueClanChatInfoHighlight",
		name = "Friends chat info highlight",
		description = "Friends chat information highlight.",
		section = opaqueSection
	)
	default Color opaqueFriendsChatInfoHighlight()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 9,
		keyName = "opaqueClanChatMessage",
		name = "Friends chat message",
		description = "Color of friends chat messages.",
		section = opaqueSection
	)
	Color opaqueFriendsChatMessage();

	@ConfigItem(
		position = 10,
		keyName = "opaqueClanChatMessageHighlight",
		name = "Friends chat message highlight",
		description = "Color of highlights in friends chat messages.",
		section = opaqueSection
	)
	default Color opaqueFriendsChatMessageHighlight()
	{
		return Color.decode("#000000");
	}
	//endregion

	//region opaque clan chat
	@ConfigItem(
		position = 11,
		keyName = "opaqueClanInfo",
		name = "Clan chat info",
		description = "Clan chat information (eg. when joining a channel).",
		section = opaqueSection
	)
	Color opaqueClanChatInfo();

	@ConfigItem(
		position = 12,
		keyName = "opaqueClanInfoHighlight",
		name = "Clan chat info highlight",
		description = "Clan chat information highlight.",
		section = opaqueSection
	)
	default Color opaqueClanChatInfoHighlight()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 13,
		keyName = "opaqueClanMessage",
		name = "Clan chat message",
		description = "Color of clan chat messages.",
		section = opaqueSection
	)
	Color opaqueClanChatMessage();

	@ConfigItem(
		position = 14,
		keyName = "opaqueClanMessageHighlight",
		name = "Clan chat message highlight",
		description = "Color of highlights in clan chat messages.",
		section = opaqueSection
	)
	default Color opaqueClanChatMessageHighlight()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 15,
		keyName = "opaqueClanGuestInfo",
		name = "Guest clan chat info",
		description = "Guest clan chat information (eg. when joining a channel).",
		section = opaqueSection
	)
	Color opaqueClanChatGuestInfo();

	@ConfigItem(
		position = 16,
		keyName = "opaqueClanGuestInfoHighlight",
		name = "Guest clan chat info highlight",
		description = "Guest clan chat information highlight.",
		section = opaqueSection
	)
	default Color opaqueClanChatGuestInfoHighlight()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 17,
		keyName = "opaqueClanGuestMessage",
		name = "Guest clan chat message",
		description = "Color of guest clan chat messages.",
		section = opaqueSection
	)
	Color opaqueClanChatGuestMessage();

	@ConfigItem(
		position = 18,
		keyName = "opaqueClanChatGuestMessageHighlight",
		name = "Guest clan chat message highlight",
		description = "Color of highlights in guest clan chat messages.",
		section = opaqueSection
	)
	default Color opaqueClanChatGuestMessageHighlight()
	{
		return Color.decode("#000000");
	}
	//endregion

	@ConfigItem(
		position = 19,
		keyName = "opaqueAutochatMessage",
		name = "Autochat",
		description = "Color of autochat messages.",
		section = opaqueSection
	)
	Color opaqueAutochatMessage();

	@ConfigItem(
		position = 20,
		keyName = "opaqueAutochatMessageHighlight",
		name = "Autochat highlight",
		description = "Color of highlights in autochat messages.",
		section = opaqueSection
	)
	Color opaqueAutochatMessageHighlight();

	@ConfigItem(
		position = 21,
		keyName = "opaqueTradeChatMessage",
		name = "Trade chat",
		description = "Color of trade chat messages.",
		section = opaqueSection
	)
	Color opaqueTradeChatMessage();

	@ConfigItem(
		position = 22,
		keyName = "opaqueTradeChatMessageHighlight",
		name = "Trade chat highlight",
		description = "Color of highlights in trade chat messages.",
		section = opaqueSection
	)
	Color opaqueTradeChatMessageHighlight();

	@ConfigItem(
		position = 23,
		keyName = "opaqueServerMessage",
		name = "Server message",
		description = "Color of server messages (eg. 'Welcome to RuneScape').",
		section = opaqueSection
	)
	Color opaqueServerMessage();

	@ConfigItem(
		position = 24,
		keyName = "opaqueServerMessageHighlight",
		name = "Server message highlight",
		description = "Color of highlights in server messages.",
		section = opaqueSection
	)
	Color opaqueServerMessageHighlight();

	@ConfigItem(
		position = 25,
		keyName = "opaqueGameMessage",
		name = "Game message",
		description = "Color of game messages.",
		section = opaqueSection
	)
	Color opaqueGameMessage();

	@ConfigItem(
		position = 26,
		keyName = "opaqueGameMessageHighlight",
		name = "Game message highlight",
		description = "Color of highlights in game messages.",
		section = opaqueSection
	)
	default Color opaqueGameMessageHighlight()
	{
		return Color.decode("#EF1020");
	}

	@ConfigItem(
		position = 27,
		keyName = "opaqueExamine",
		name = "Examine",
		description = "Color of examine text.",
		section = opaqueSection
	)
	Color opaqueExamine();

	@ConfigItem(
		position = 28,
		keyName = "opaqueExamineHighlight",
		name = "Examine highlight",
		description = "Color of highlights in examine text.",
		section = opaqueSection
	)
	default Color opaqueExamineHighlight()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 29,
		keyName = "opaqueFiltered",
		name = "Filtered",
		description = "Color of filtered text (messages that aren't shown when game messages are filtered).",
		section = opaqueSection
	)
	Color opaqueFiltered();

	@ConfigItem(
		position = 30,
		keyName = "opaqueFilteredHighlight",
		name = "Filtered highlight",
		description = "Color of highlights in filtered text.",
		section = opaqueSection
	)
	Color opaqueFilteredHighlight();

	@ConfigItem(
		position = 31,
		keyName = "opaqueUsername",
		name = "Usernames",
		description = "Color of usernames.",
		section = opaqueSection
	)
	Color opaqueUsername();

	@ConfigItem(
		position = 32,
		keyName = "opaquePrivateUsernames",
		name = "Private chat usernames",
		description = "Color of usernames in private chat.",
		section = opaqueSection
	)
	Color opaquePrivateUsernames();

	@ConfigItem(
		position = 33,
		keyName = "opaqueClanChannelName",
		name = "Friends chat channel name",
		description = "Color of friends chat channel name.",
		section = opaqueSection
	)
	Color opaqueFriendsChatChannelName();

	@ConfigItem(
		position = 34,
		keyName = "opaqueClanChatChannelName",
		name = "Clan chat channel name",
		description = "Color of clan chat channel name.",
		section = opaqueSection
	)
	Color opaqueClanChannelName();

	@ConfigItem(
		position = 35,
		keyName = "opaqueClanChatGuestChannelName",
		name = "Guest clan chat channel name",
		description = "Color of guest clan chat channel name.",
		section = opaqueSection
	)
	Color opaqueClanGuestChatChannelName();

	@ConfigItem(
		position = 36,
		keyName = "opaqueClanUsernames",
		name = "Friends chat usernames",
		description = "Color of usernames in friends chat.",
		section = opaqueSection
	)
	Color opaqueFriendsChatUsernames();

	@ConfigItem(
		position = 37,
		keyName = "opaqueClanChatUsernames",
		name = "Clan chat usernames",
		description = "Color of usernames in clan chat.",
		section = opaqueSection
	)
	Color opaqueClanChatUsernames();

	@ConfigItem(
		position = 38,
		keyName = "opaqueClanChatGuestUsernames",
		name = "Guest clan chat usernames",
		description = "Color of usernames in guest clan chat.",
		section = opaqueSection
	)
	Color opaqueClanChatGuestUsernames();

	@ConfigItem(
		position = 39,
		keyName = "opaquePublicFriendUsernames",
		name = "Public friend usernames",
		description = "Color of friend usernames in public chat.",
		section = opaqueSection
	)
	Color opaquePublicFriendUsernames();

	@ConfigItem(
		position = 40,
		keyName = "opaquePlayerUsername",
		name = "Your username",
		description = "Color of your username.",
		section = opaqueSection
	)
	Color opaquePlayerUsername();

	@ConfigItem(
		position = 51,
		keyName = "transparentPublicChat",
		name = "Public chat (transparent)",
		description = "Color of public chat (transparent).",
		section = transparentSection
	)
	Color transparentPublicChat();

	@ConfigItem(
		position = 52,
		keyName = "transparentPublicChatHighlight",
		name = "Public chat highlight (transparent)",
		description = "Color of highlights in public chat (transparent).",
		section = transparentSection
	)
	default Color transparentPublicChatHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 53,
		keyName = "transparentPrivateMessageSent",
		name = "Sent private messages (transparent)",
		description = "Color of private messages you've sent (transparent).",
		section = transparentSection
	)
	Color transparentPrivateMessageSent();

	@ConfigItem(
		position = 54,
		keyName = "transparentPrivateMessageSentHighlight",
		name = "Sent private messages highlight (transparent)",
		description = "Color of highlights in private messages you've sent (transparent).",
		section = transparentSection
	)
	default Color transparentPrivateMessageSentHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 55,
		keyName = "transparentPrivateMessageReceived",
		name = "Received private messages (transparent)",
		description = "Color of private messages you've received (transparent).",
		section = transparentSection
	)
	Color transparentPrivateMessageReceived();

	@ConfigItem(
		position = 56,
		keyName = "transparentPrivateMessageReceivedHighlight",
		name = "Received private messages highlight (transparent)",
		description = "Color of highlights in private messages you've received (transparent).",
		section = transparentSection
	)
	default Color transparentPrivateMessageReceivedHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	//region transparent friends chat
	@ConfigItem(
		position = 57,
		keyName = "transparentFriendsChatInfo",
		name = "Friends chat info (transparent)",
		description = "Friends chat information (eg. when joining a channel) (transparent).",
		section = transparentSection
	)
	Color transparentFriendsChatInfo();

	@ConfigItem(
		position = 58,
		keyName = "transparentClanChatInfoHighlight",
		name = "Friends chat info highlight (transparent)",
		description = "Friends chat information highlight (transparent).",
		section = transparentSection
	)
	default Color transparentFriendsChatInfoHighlight()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 59,
		keyName = "transparentClanChatMessage",
		name = "Friends chat message (transparent)",
		description = "Color of friends chat messages (transparent).",
		section = transparentSection
	)
	Color transparentFriendsChatMessage();

	@ConfigItem(
		position = 60,
		keyName = "transparentClanChatMessageHighlight",
		name = "Friends chat message highlight (transparent)",
		description = "Color of highlights in friends chat messages (transparent).",
		section = transparentSection
	)
	default Color transparentFriendsChatMessageHighlight()
	{
		return Color.decode("#FFFFFF");
	}
	//endregion

	//region transparent clan chat
	@ConfigItem(
		position = 61,
		keyName = "transparentClanInfo",
		name = "Clan chat info (transparent)",
		description = "Clan chat information (eg. when joining a channel) (transparent).",
		section = transparentSection
	)
	Color transparentClanChatInfo();

	@ConfigItem(
		position = 62,
		keyName = "transparentClanInfoHighlight",
		name = "Clan chat info highlight (transparent)",
		description = "Clan chat information highlight (transparent).",
		section = transparentSection
	)
	default Color transparentClanChatInfoHighlight()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 63,
		keyName = "transparentClanMessage",
		name = "Clan chat message (transparent)",
		description = "Color of clan chat messages (transparent).",
		section = transparentSection
	)
	Color transparentClanChatMessage();

	@ConfigItem(
		position = 64,
		keyName = "transparentClanMessageHighlight",
		name = "Clan chat message highlight (transparent)",
		description = "Color of highlights in clan chat messages (transparent).",
		section = transparentSection
	)
	default Color transparentClanChatMessageHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 65,
		keyName = "transparentClanGuestInfo",
		name = "Guest clan chat info (transparent)",
		description = "Guest clan chat information (eg. when joining a channel) (transparent).",
		section = transparentSection
	)
	Color transparentClanChatGuestInfo();

	@ConfigItem(
		position = 66,
		keyName = "transparentClanGuestInfoHighlight",
		name = "Guest clan chat info highlight (transparent)",
		description = "Guest clan chat information highlight (transparent).",
		section = transparentSection
	)
	default Color transparentClanChatGuestInfoHighlight()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 67,
		keyName = "transparentClanGuestMessage",
		name = "Guest clan chat message (transparent)",
		description = "Color of guest clan chat messages (transparent).",
		section = transparentSection
	)
	Color transparentClanChatGuestMessage();

	@ConfigItem(
		position = 68,
		keyName = "transparentClanChatGuestMessageHighlight",
		name = "Guest clan chat message highlight (transparent)",
		description = "Color of highlights in guest clan chat messages (transparent).",
		section = transparentSection
	)
	default Color transparentClanChatGuestMessageHighlight()
	{
		return Color.decode("#FFFFFF");
	}
	//endregion

	@ConfigItem(
		position = 69,
		keyName = "transparentAutochatMessage",
		name = "Autochat (transparent)",
		description = "Color of autochat messages (transparent).",
		section = transparentSection
	)
	Color transparentAutochatMessage();

	@ConfigItem(
		position = 70,
		keyName = "transparentAutochatMessageHighlight",
		name = "Autochat highlight (transparent)",
		description = "Color of highlights in autochat messages (transparent).",
		section = transparentSection
	)
	Color transparentAutochatMessageHighlight();

	@ConfigItem(
		position = 71,
		keyName = "transparentTradeChatMessage",
		name = "Trade chat (transparent)",
		description = "Color of trade chat messages (transparent).",
		section = transparentSection
	)
	Color transparentTradeChatMessage();

	@ConfigItem(
		position = 72,
		keyName = "transparentTradeChatMessageHighlight",
		name = "Trade chat highlight (transparent)",
		description = "Color of highlights in trade chat messages (transparent).",
		section = transparentSection
	)
	Color transparentTradeChatMessageHighlight();

	@ConfigItem(
		position = 73,
		keyName = "transparentServerMessage",
		name = "Server message (transparent)",
		description = "Color of server messages (eg. 'Welcome to RuneScape') (transparent).",
		section = transparentSection
	)
	Color transparentServerMessage();

	@ConfigItem(
		position = 74,
		keyName = "transparentServerMessageHighlight",
		name = "Server message highlight (transparent)",
		description = "Color of highlights in server messages (transparent).",
		section = transparentSection
	)
	Color transparentServerMessageHighlight();

	@ConfigItem(
		position = 75,
		keyName = "transparentGameMessage",
		name = "Game message (transparent)",
		description = "Color of game messages (transparent).",
		section = transparentSection
	)
	Color transparentGameMessage();

	@ConfigItem(
		position = 76,
		keyName = "transparentGameMessageHighlight",
		name = "Game message highlight (transparent)",
		description = "Color of highlights in game messages (transparent).",
		section = transparentSection
	)
	default Color transparentGameMessageHighlight()
	{
		return Color.decode("#EF1020");
	}

	@ConfigItem(
		position = 77,
		keyName = "transparentExamine",
		name = "Examine (transparent)",
		description = "Color of examine text (transparent).",
		section = transparentSection
	)
	Color transparentExamine();

	@ConfigItem(
		position = 78,
		keyName = "transparentExamineHighlight",
		name = "Examine highlight (transparent)",
		description = "Color of highlights in examine text (transparent).",
		section = transparentSection
	)
	default Color transparentExamineHighlight()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		position = 79,
		keyName = "transparentFiltered",
		name = "Filtered (transparent)",
		description = "Color of filtered text (messages that aren't shown when game messages are filtered) (transparent).",
		section = transparentSection
	)
	Color transparentFiltered();

	@ConfigItem(
		position = 80,
		keyName = "transparentFilteredHighlight",
		name = "Filtered highlight (transparent)",
		description = "Color of highlights in filtered text (transparent).",
		section = transparentSection
	)
	Color transparentFilteredHighlight();

	@ConfigItem(
		position = 81,
		keyName = "transparentUsername",
		name = "Usernames (transparent)",
		description = "Color of usernames (transparent).",
		section = transparentSection
	)
	Color transparentUsername();

	@ConfigItem(
		position = 82,
		keyName = "transparentPrivateUsernames",
		name = "Private chat usernames (transparent)",
		description = "Color of usernames in private chat (transparent).",
		section = transparentSection
	)
	Color transparentPrivateUsernames();

	@ConfigItem(
		position = 83,
		keyName = "transparentClanChannelName",
		name = "Friends chat channel name (transparent)",
		description = "Color of friends chat channel name (transparent).",
		section = transparentSection
	)
	Color transparentFriendsChatChannelName();

	@ConfigItem(
		position = 84,
		keyName = "transparentClanChatChannelName",
		name = "Clan chat channel name (transparent)",
		description = "Color of clan chat channel name (transparent).",
		section = transparentSection
	)
	Color transparentClanChannelName();

	@ConfigItem(
		position = 85,
		keyName = "transparentClanChatGuestChannelName",
		name = "Guest clan chat channel name (transparent)",
		description = "Color of guest clan chat channel name (transparent).",
		section = transparentSection
	)
	Color transparentClanChannelGuestName();

	@ConfigItem(
		position = 86,
		keyName = "transparentClanUsernames",
		name = "Friends chat usernames (transparent)",
		description = "Color of usernames in friends chat (transparent).",
		section = transparentSection
	)
	Color transparentFriendsChatUsernames();

	@ConfigItem(
		position = 87,
		keyName = "transparentClanClanUsernames",
		name = "Clan chat usernames (transparent)",
		description = "Color of usernames in clan chat (transparent).",
		section = transparentSection
	)
	Color transparentClanChatUsernames();

	@ConfigItem(
		position = 88,
		keyName = "transparentClanClanGuestUsernames",
		name = "Guest clan chat usernames (transparent)",
		description = "Color of usernames in guest clan chat (transparent).",
		section = transparentSection
	)
	Color transparentClanChatGuestUsernames();

	@ConfigItem(
		position = 89,
		keyName = "transparentPublicFriendUsernames",
		name = "Public friend usernames (transparent)",
		description = "Color of friend usernames in public chat (transparent).",
		section = transparentSection
	)
	Color transparentPublicFriendUsernames();

	@ConfigItem(
		position = 90,
		keyName = "transparentPlayerUsername",
		name = "Your username (transparent)",
		description = "Color of your username (transparent).",
		section = transparentSection
	)
	Color transparentPlayerUsername();
}
