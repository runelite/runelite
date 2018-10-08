/*
 * Copyright (c) 2017, Ron <https://github.com/raiyni>
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
package net.runelite.client.plugins.clanchat;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("clanchat")
public interface ClanChatConfig extends Config
{
	@ConfigItem(
		keyName = "rankIcons",
		name = "Rank Icons",
		description = "Add rank icons to users talking in clan chat.",
		position = 1
	)
	default boolean rankIcons()
	{
		return true;
	}

	@ConfigItem(
		keyName = "mobileChat",
		name = "Mobile Chat",
		description = "Swap default chat while clan chat tab is open. <br> Disable for default chat behaviour.",
		position = 2
	)
	default boolean mobileChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapChat",
		name = "Swap Chat",
		description = "Swap default chat to always be clan chat. <br> Disable for default chat behaviour.",
		position = 3
	)
	default boolean swapChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "recentChats",
		name = "Recent Chats",
		description = "Show recent clan chats.",
		position = 4
	)
	default boolean recentChats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "chatsData",
		name = "",
		description = "",
		hidden = true
	)
	default String chatsData()
	{
		return "";
	}

	@ConfigItem(
		keyName = "chatsData",
		name = "",
		description = ""
	)
	void chatsData(String str);
}
