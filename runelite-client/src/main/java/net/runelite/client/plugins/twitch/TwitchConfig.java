/*
 * Copyright (c) 2018, William Gray <wgray5093@gmail.com>
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

package net.runelite.client.plugins.twitch;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "twitch",
		name = "Twitch",
		description = "Used to see Twitch chat in game"
)

public interface TwitchConfig extends Config
{
	@ConfigItem( //Stream chat user wants to see goes here
			keyName = "channel",
			name = "Channel",
			description = "Enter the channel you wish to view the chat of",
			position = 0
	)
	default String nickName()
	{
		return "";
	}

	@ConfigItem( //User's OAuth Token goes here
			keyName = "oauth",
			name = "OAuth Token",
			description = "Enter your OAuth token here. This can be found at http://www.twitchapps.com/tmi/",
			position = 1
	)
	default String oauthToken()
	{
		return "";
	}

	@ConfigItem( //User's twitch username goes here
			keyName = "nick",
			name = "Twitch Username",
			description = "Your twitch username",
			position = 2
	)
	default String channelName()
	{
		return "";
	}

	@ConfigItem( //Stream transparent chat color
			keyName = "chattcolor",
			name = "Transparent chat color",
			description = "The color of chat in game",
			position = 3
	)
	default Color chatTColor()
	{
		return Color.decode("#350059");
	}

	@ConfigItem( //Stream opaque chat color
			keyName = "chatocolor",
			name = "Opaque chat color",
			description = "The color of chat in game",
			position = 4
	)
	default Color chatOColor()
	{
		return Color.decode("#350059");
	}

	@ConfigItem( //Subscriber notifications
			keyName = "subnotifications",
			name = "Sub notifications",
			description = "Toggles sub notifications",
			position = 5
	)
	default boolean subNotifs()
	{
		return true;
	}

	@ConfigItem( //Subscriber opaque notification color
			keyName = "subocolor",
			name = "Subscriber notification opaque color",
			description = "Color of the sub notifications in chat when using opaque chat",
			position = 6
	)
	default Color subsOColor()
	{
		return Color.decode("#000000");
	}

	@ConfigItem( //Subscriber transparent notification color
			keyName = "subtcolor",
			name = "Subscriber notification transparent color",
			description = "Color of the sub notifications in chat when using transparent chat",
			position = 7
	)
	default Color subsTColor()
	{
		return Color.decode("#FFFFFF");
	}
}
