/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.chatnotifications;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Notification;

@ConfigGroup("chatnotification")
public interface ChatNotificationsConfig extends Config
{
	@ConfigSection(
		name = "Highlight lists",
		description = "Custom single word and regex filter lists.",
		position = 0
	)
	String highlightLists = "highlightLists";

	@ConfigItem(
		position = 1,
		keyName = "highlightWordsString",
		name = "Highlight words",
		description = "Highlights the following words in chat, separated by commas.",
		section = highlightLists
	)
	default String highlightWordsString()
	{
		return "";
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightRegexString",
		name = "Highlight regex",
		description = "Highlights the following regular expressions in chat, one per line.",
		section = highlightLists
	)
	default String highlightRegexString()
	{
		return "";
	}

	@ConfigItem(
		position = 1,
		keyName = "highlightOwnName",
		name = "Highlight own name",
		description = "Highlights any instance of your username in chat."
	)
	default boolean highlightOwnName()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "notifyOnOwnName",
		name = "Notify on own name",
		description = "Notifies you whenever someone mentions you by name."
	)
	default Notification notifyOnOwnName()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 3,
		keyName = "notifyOnHighlight",
		name = "Notify on highlight",
		description = "Notifies you whenever a highlighted word is matched."
	)
	default Notification notifyOnHighlight()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 4,
		keyName = "notifyOnTrade",
		name = "Notify on trade",
		description = "Notifies you whenever you are traded."
	)
	default Notification notifyOnTrade()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 5,
		keyName = "notifyOnDuel",
		name = "Notify on duel",
		description = "Notifies you whenever you are challenged to a duel."
	)
	default Notification notifyOnDuel()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 6,
		keyName = "notifyOnBroadcast",
		name = "Notify on broadcast",
		description = "Notifies you whenever you receive a broadcast message."
	)
	default Notification notifyOnBroadcast()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 7,
		keyName = "notifyOnPM",
		name = "Notify on private message",
		description = "Notifies you whenever you receive a private message."
	)
	default Notification notifyOnPM()
	{
		return Notification.OFF;
	}
}
