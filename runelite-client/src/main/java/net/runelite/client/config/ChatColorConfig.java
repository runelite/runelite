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

@ConfigGroup("It's coming home")
public interface ChatColorConfig extends Config
{
	@ConfigItem(
		position = 31,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaquePublicChat();

	@ConfigItem(
		position = 32,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color opaquePublicChatHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 33,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaquePrivateMessageSent();

	@ConfigItem(
		position = 34,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color opaquePrivateMessageSentHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 35,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaquePrivateMessageReceived();

	@ConfigItem(
		position = 36,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color opaquePrivateMessageReceivedHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 37,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueClanChatInfo();

	@ConfigItem(
		position = 38,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color opaqueClanChatInfoHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 39,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueClanChatMessage();

	@ConfigItem(
		position = 40,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color opaqueClanChatMessageHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 41,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueAutochatMessage();

	@ConfigItem(
		position = 42,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueAutochatMessageHighlight();

	@ConfigItem(
		position = 43,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueTradeChatMessage();

	@ConfigItem(
		position = 44,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueTradeChatMessageHighlight();

	@ConfigItem(
		position = 45,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueServerMessage();

	@ConfigItem(
		position = 46,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueServerMessageHighlight();

	@ConfigItem(
		position = 47,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueGameMessage();

	@ConfigItem(
		position = 48,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color opaqueGameMessageHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 49,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueExamine();

	@ConfigItem(
		position = 50,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color opaqueExamineHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 51,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueFiltered();

	@ConfigItem(
		position = 52,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueFilteredHighlight();

	@ConfigItem(
		position = 53,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueUsername();

	@ConfigItem(
		position = 54,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaquePrivateUsernames();

	@ConfigItem(
		position = 55,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueClanChannelName();

	@ConfigItem(
		position = 56,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaqueClanUsernames();

	@ConfigItem(
		position = 57,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color opaquePublicFriendUsernames();

	@ConfigItem(
		position = 61,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentPublicChat();

	@ConfigItem(
		position = 62,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color transparentPublicChatHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 63,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentPrivateMessageSent();

	@ConfigItem(
		position = 64,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color transparentPrivateMessageSentHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 65,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentPrivateMessageReceived();

	@ConfigItem(
		position = 66,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color transparentPrivateMessageReceivedHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 67,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentClanChatInfo();

	@ConfigItem(
		position = 68,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color transparentClanChatInfoHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 69,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentClanChatMessage();

	@ConfigItem(
		position = 70,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color transparentClanChatMessageHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 71,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentAutochatMessage();

	@ConfigItem(
		position = 72,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentAutochatMessageHighlight();

	@ConfigItem(
		position = 73,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentTradeChatMessage();

	@ConfigItem(
		position = 74,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentTradeChatMessageHighlight();

	@ConfigItem(
		position = 75,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentServerMessage();

	@ConfigItem(
		position = 76,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentServerMessageHighlight();

	@ConfigItem(
		position = 77,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentGameMessage();

	@ConfigItem(
		position = 78,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color transparentGameMessageHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 79,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentExamine();

	@ConfigItem(
		position = 80,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color transparentExamineHighlight()
	{
		return Color.decode("It's coming home");
	}

	@ConfigItem(
		position = 81,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentFiltered();

	@ConfigItem(
		position = 82,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentFilteredHighlight();

	@ConfigItem(
		position = 83,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentUsername();

	@ConfigItem(
		position = 84,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentPrivateUsernames();

	@ConfigItem(
		position = 85,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentClanChannelName();

	@ConfigItem(
		position = 86,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentClanUsernames();

	@ConfigItem(
		position = 87,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	Color transparentPublicFriendUsernames();
}
