/*
 * Copyright (c) 2018, Tanner <https://github.com/Reasel>
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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "chatnotifier",
	name = "Chat Notifier",
	description = "Configuration for the chat notifier plugin"
)
public interface ChatNotifierConfig extends Config
{
	@ConfigItem(
		keyName = "messageNotification",
		name = "Notified messages",
		description = "Configures specifically which messages to notify you of. Leave blank to disable. Format: message, message",
		position = 1
	)
	default String getMessageNotification()
	{
		return "";
	}

	@ConfigItem(
		keyName = "ignoreFiltered",
		name = "Ignore filtered",
		description = "Configures whether or not to ignore messages that are being filtered.",
		position = 2
	)
	default boolean ignoreFiltered()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notifyTrade",
		name = "Notify trades",
		description = "Configures whether or not to send a notification on incoming trade requests",
		position = 3
	)
	default boolean notifyTrade()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notifyDuel",
		name = "Notify duels",
		description = "Configures whether or not to send a notification on incoming duels",
		position = 4
	)
	default boolean notifyDuel()
	{
		return false;
	}
}
