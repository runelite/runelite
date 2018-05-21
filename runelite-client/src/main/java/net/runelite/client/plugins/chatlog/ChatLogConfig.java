/*
 * Copyright (c) 2018, Rprrr <https://github.com/rprrr>
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
package net.runelite.client.plugins.chatlog;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "instanceMap",
		name = "Instance Map",
		description = "Configuration for the Instance Map plugin"
)
public interface ChatLogConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "public",
			name = "Public Chat",
			description = "Configures whether or not to log public chat messages."
	)
	default boolean savePublicChat()
	{
		return true;
	}

	@ConfigItem(
			position = 2,
			keyName = "private",
			name = "Private Chat",
			description = "Configures whether or not to log private chat messages."
	)
	default boolean savePrivateChat()
	{
		return true;
	}

	@ConfigItem(
			position = 3,
			keyName = "clan",
			name = "Clan Chat",
			description = "Configures whether or not to log clan chat messages."
	)
	default boolean saveClanChat()
	{
		return true;
	}

	@ConfigItem(
			position = 4,
			keyName = "auto",
			name = "Auto Chat",
			description = "Configures whether or not to log auto chat messages."
	)
	default boolean saveAutoChat()
	{
		return false;
	}

	@ConfigItem(
			position = 5,
			keyName = "game",
			name = "Game Info",
			description = "Configures whether or not to log game info messages."
	)
	default boolean saveGameInfo()
	{
		return false;
	}
}

