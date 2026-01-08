/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

@ConfigGroup("chathistory")
public interface ChatHistoryConfig extends Config
{
	@ConfigItem(
		keyName = "retainChatHistory",
		name = "Retain chat history",
		description = "Retains chat history when logging in/out or world hopping.",
		position = 0
	)
	default boolean retainChatHistory()
	{
		return true;
	}

	@ConfigItem(
		keyName = "pmTargetCycling",
		name = "PM target cycling",
		description = "Pressing tab while sending a PM will cycle the target username based on PM history.",
		position = 1
	)
	default boolean pmTargetCycling()
	{
		return true;
	}

	@ConfigItem(
		keyName = "copyToClipboard",
		name = "Copy to clipboard",
		description = "Add option on chat messages to copy them to clipboard.",
		position = 2
	)
	default boolean copyToClipboard()
	{
		return true;
	}

	@ConfigItem(
		keyName = "clearHistory",
		name = "Clear history option for all tabs",
		description = "Add 'Clear history' option chatbox tab buttons.",
		position = 3
	)
	default boolean clearHistory()
	{
		return true;
	}
}
