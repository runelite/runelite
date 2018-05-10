/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.chatnotifier;

import net.runelite.api.ChatMessageType;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;


@ConfigGroup(
		keyName = "chatnotifier",
		name = "Chat Notifier",
		description = "Configuration for the Chat Notifier plugin"
)
public interface ChatNotifierConfig extends Config {
	@ConfigItem(
		keyName = "customMessages",
		name = "Input Custom Messages",
		description = "Input the precise messages that you want to get a notification for. Split with decimal.  Leave empty to disable.",
		position = 1
	)
	default String customMessages()
	{
		return "";
	}

	@ConfigItem(
			keyName = "onlySpecificMessages",
			name = "Enable only specific message type",
			description = "Enable this option to only show messages sent from one specific source. Select type below in option 3.",
			position = 2
	)
	default boolean onlySpecificMessages()
	{
		return false;
	}
	@ConfigItem(
			keyName = "onlyServerMessages",
			name = "Select message type",
			description = "Enable this option to only show messages sent from the server.",
			position = 3
	)
	default ChatMessageType onlyTypeMessage()
	{
		return ChatMessageType.GAME;
	}

	@ConfigItem(
			keyName = "notifyOnTrade",
			name = "Get notified on trade request",
			description = "Enable this option to get notified when a trade request have been received.",
			position = 4
	)
	default boolean notifyOnTrade()
	{
		return true;
	}

	@ConfigItem(
			keyName = "notifyOnDuel",
			name = "Get notified on duel request",
			description = "Enable this option to get notified when a duel request have been received.",
			position = 5
	)
	default boolean notifyOnDuel()
	{
		return true;
	}
}
