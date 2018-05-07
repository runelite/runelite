package net.runelite.client.plugins.textrecolor;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(
	keyName = "textrecolor",
	name = "Chat Text Recolor",
	description = "Configuration for chat text recoloring"
)
public interface TextRecolorConfig extends Config
{
	@ConfigItem(
		position = 30,
		keyName = "__dummyTitleOpaque",
		name = "Opaque Chat Colors",
		description = ""
	)
	default long __dummyTitleOpaque()
	{
		return 0;
	}

	@ConfigItem(
		position = 31,
		keyName = "opaquePublicChat",
		name = "Public chat",
		description = "Color of Public chat"
	)
	default Color opaquePublicChat()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 32,
		keyName = "opaquePublicChatHighlight",
		name = "Public chat highlight",
		description = "Color of highlights in Public chat"
	)
	default Color opaquePublicChatHighlight()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 33,
		keyName = "opaquePrivateMessageSent",
		name = "Sent private messages",
		description = "Color of Private messages you've sent"
	)
	default Color opaquePrivateMessageSent()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 34,
		keyName = "opaquePrivateMessageSentHighlight",
		name = "Sent private messages highlight",
		description = "Color of highlights in Private messages you've sent"
	)
	default Color opaquePrivateMessageSentHighlight()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 35,
		keyName = "opaquePrivateMessageReceived",
		name = "Recieved private messages",
		description = "Color of Private messages you've received"
	)
	default Color opaquePrivateMessageReceived()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 36,
		keyName = "opaquePrivateMessageReceivedHighlight",
		name = "Received private messages highlight",
		description = "Color of highlights in Private messages you've received"
	)
	default Color opaquePrivateMessageReceivedHighlight()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 37,
		keyName = "opaqueClanChatInfo",
		name = "Clan chat info",
		description = "Clan Chat Information (eg. when joining a channel)"
	)
	default Color opaqueClanChatInfo()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 38,
		keyName = "opaqueClanChatMessage",
		name = "Clan chat message",
		description = "Color of Clan Chat Messages"
	)
	default Color opaqueClanChatMessage()
	{
		return Color.decode("#7F0000");
	}

	@ConfigItem(
		position = 39,
		keyName = "opaqueClanChatMessageHighlight",
		name = "Clan chat message highlight",
		description = "Color of highlights in Clan Chat Messages"
	)
	default Color opaqueClanChatMessageHighlight()
	{
		return Color.decode("#7F0000");
	}

	@ConfigItem(
		position = 40,
		keyName = "opaqueAutochatMessage",
		name = "Autochat",
		description = "Color of Autochat messages"
	)
	default Color opaqueAutochatMessage()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 41,
		keyName = "opaqueAutochatMessageHighlight",
		name = "Autochat highlight",
		description = "Color of highlights in Autochat messages"
	)
	default Color opaqueAutochatMessageHighlight()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 42,
		keyName = "opaqueTradeChatMessage",
		name = "Trade chat",
		description = "Color of Trade Chat Messages"
	)
	default Color opaqueTradeChatMessage()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 43,
		keyName = "opaqueTradeChatMessageHighlight",
		name = "Trade chat highlight",
		description = "Color of highlights in Trade Chat Messages"
	)
	default Color opaqueTradeChatMessageHighlight()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 44,
		keyName = "opaqueServerMessage",
		name = "Server message",
		description = "Color of Server Messages (eg. 'Welcome to Runescape')"
	)
	default Color opaqueServerMessage()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 45,
		keyName = "opaqueServerMessageHighlight",
		name = "Server message highlight",
		description = "Color of highlights in Server Messages"
	)
	default Color opaqueServerMessageHighlight()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
		position = 46,
		keyName = "opaqueGameMessage",
		name = "Game message",
		description = "Color of Game Messages"
	)
	default Color opaqueGameMessage()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 47,
		keyName = "opaqueGameMessageHighlight",
		name = "Game message highlight",
		description = "Color of highlights in Game Messages"
	)
	default Color opaqueGameMessageHighlight()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
		position = 48,
		keyName = "opaqueExamine",
		name = "Examine",
		description = "Color of Examine Text"
	)
	default Color opaqueExamine()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 49,
		keyName = "opaqueExamineHighlight",
		name = "Examine Highlight",
		description = "Color of highlights in Examine Text"
	)
	default Color opaqueExamineHighlight()
	{
		return Color.decode("#0000ff");
	}

	@ConfigItem(
		position = 50,
		keyName = "opaqueFiltered",
		name = "Filtered",
		description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered)"
	)
	default Color opaqueFiltered()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 51,
		keyName = "opaqueFilteredHighlight",
		name = "Filtered Highlight",
		description = "Color of highlights in Filtered Text"
	)
	default Color opaqueFilteredHighlight()
	{
		return Color.decode("#0000ff");
	}

	@ConfigItem(
		position = 52,
		keyName = "opaqueUsername",
		name = "Usernames",
		description = "Color of Usernames"
	)
	default Color opaqueUsername()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 53,
		keyName = "opaquePrivateUsernames",
		name = "Private chat usernames",
		description = "Color of Usernames in Private Chat"
	)
	default Color opaquePrivateUsernames()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 54,
		keyName = "opaqueClanChannelName",
		name = "Chan channel Name",
		description = "Color of Clan Channel Name"
	)
	default Color opaqueClanChannelName()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 55,
		keyName = "opaqueClanUsernames",
		name = "Clan usernames",
		description = "Color of Usernames in Clan Chat"
	)
	default Color opaqueClanUsernames()
	{
		return Color.decode("#000000");
	}


	@ConfigItem(
		position = 60,
		keyName = "__dummyTitleResizeableMode",
		name = "Transparent Chat Box",
		description = ""
	)
	default long __dummyTitleResizeableMode()
	{
		return 0;
	}

	@ConfigItem(
		position = 61,
		keyName = "transparentPublicChat",
		name = "Public chat",
		description = "Color of Public chat"
	)
	default Color transparentPublicChat()
	{
		return Color.decode("#9090FF");
	}

	@ConfigItem(
		position = 62,
		keyName = "transparentPublicChatHighlight",
		name = "Public chat highlight",
		description = "Color of highlights in Public chat"
	)
	default Color transparentPublicChatHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 63,
		keyName = "transparentPrivateMessageSent",
		name = "Sent private messages",
		description = "Color of Private messages you've sent"
	)
	default Color transparentPrivateMessageSent()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 64,
		keyName = "transparentPrivateMessageSentHighlight",
		name = "Sent private messages highlight",
		description = "Color of highlights in Private messages you've sent"
	)
	default Color transparentPrivateMessageSentHighlight()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 65,
		keyName = "transparentPrivateMessageReceived",
		name = "Received private messages",
		description = "Color of Private messages you've received"
	)
	default Color transparentPrivateMessageReceived()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 66,
		keyName = "transparentPrivateMessageReceivedHighlight",
		name = "Received private messages highlight",
		description = "Color of highlights in Private messages you've received"
	)
	default Color transparentPrivateMessageReceivedHighlight()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 67,
		keyName = "transparentClanChatInfo",
		name = "Clan chat info",
		description = "Clan Chat Information (eg. when joining a channel)"
	)
	default Color transparentClanChatInfo()
	{
		return Color.decode("#ffffff");
	}

	@ConfigItem(
		position = 68,
		keyName = "transparentClanChatMessage",
		name = "Clan chat message",
		description = "Color of Clan Chat Messages"
	)
	default Color transparentClanChatMessage()
	{
		return Color.decode("#7F0000");
	}

	@ConfigItem(
		position = 69,
		keyName = "transparentClanChatMessageHighlight",
		name = "Clan chat message highlight",
		description = "Color of highlights in Clan Chat Messages"
	)
	default Color transparentClanChatMessageHighlight()
	{
		return Color.decode("#7F0000");
	}

	@ConfigItem(
		position = 70,
		keyName = "transparentAutochatMessage",
		name = "Autochat",
		description = "Color of Autochat messages"
	)
	default Color transparentAutochatMessage()
	{
		return Color.decode("#4040FF");
	}

	@ConfigItem(
		position = 71,
		keyName = "transparentAutochatMessageHighlight",
		name = "Autochat highlight",
		description = "Color of highlights in Autochat messages"
	)
	default Color transparentAutochatMessageHighlight()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 72,
		keyName = "transparentTradeChatMessage",
		name = "Trade chat",
		description = "Color of Trade Chat Messages"
	)
	default Color transparentTradeChatMessage()
	{
		return Color.decode("#9090FF");
	}

	@ConfigItem(
		position = 73,
		keyName = "transparentTradeChatMessageHighlight",
		name = "Trade chat highlight",
		description = "Color of highlights in Trade Chat Messages"
	)
	default Color transparentTradeChatMessageHighlight()
	{
		return Color.decode("#FFFFFF");
	}


	@ConfigItem(
		position = 74,
		keyName = "transparentServerMessage",
		name = "Server message",
		description = "Color of Server Messages (eg. 'Welcome to Runescape')"
	)
	default Color transparentServerMessage()
	{
		return Color.decode("#ffffff");
	}

	@ConfigItem(
		position = 75,
		keyName = "transparentServerMessageHighlight",
		name = "Server message highlight",
		description = "Color of highlights in Server Messages"
	)
	default Color transparentServerMessageHighlight()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
		position = 76,
		keyName = "transparentGameMessage",
		name = "Game message",
		description = "Color of Game Messages"
	)
	default Color transparentGameMessage()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
		position = 77,
		keyName = "transparentGameMessageHighlight",
		name = "Game message highlight",
		description = "Color of highlights in Game Messages"
	)
	default Color transparentGameMessageHighlight()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
		position = 78,
		keyName = "transparentExamine",
		name = "Examine",
		description = "Color of Examine Text"
	)
	default Color transparentExamine()
	{
		return Color.decode("#ffffff");
	}

	@ConfigItem(
		position = 79,
		keyName = "transparentExamineHighlight",
		name = "Examine Highlight",
		description = "Color of highlights in Examine Text"
	)
	default Color transparentExamineHighlight()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
		position = 80,
		keyName = "transparentFiltered",
		name = "Filtered",
		description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered)"
	)
	default Color transparentFiltered()
	{
		return Color.decode("#ffffff");
	}

	@ConfigItem(
		position = 81,
		keyName = "transparentFilteredHighlight",
		name = "Filtered Highlight",
		description = "Color of highlights in Filtered Text"
	)
	default Color transparentFilteredHighlight()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
		position = 82,
		keyName = "transparentUsername",
		name = "Usernames",
		description = "Color of Usernames"
	)
	default Color transparentUsername()
	{
		return Color.decode("#ffffff");
	}

	@ConfigItem(
		position = 83,
		keyName = "transparentPrivateUsernames",
		name = "Private chat usernames",
		description = "Color of Usernames in Private Chat"
	)
	default Color transparentPrivateUsernames()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 84,
		keyName = "transparentClanChannelName",
		name = "Chan channel Name",
		description = "Color of Clan Channel Name"
	)
	default Color transparentClanChannelName()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 85,
		keyName = "transparentClanUsernames",
		name = "Clan usernames",
		description = "Color of Usernames in Clan Chat"
	)
	default Color transparentClanUsernames()
	{
		return Color.decode("#000000");
	}
}
