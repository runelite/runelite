/*
 * Copyright (c) 2018, Forsco <https://github.com/forsco>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
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

package net.runelite.http.api.discord;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class DiscordMessage
{
	String username;
	String content;
	@SerializedName("avatar_url")
	String avatarUrl;
	@SerializedName("tts")
	boolean textToSpeech;
	List<DiscordEmbed> embeds = new ArrayList<>();

	public DiscordMessage()
	{

	}

	public DiscordMessage(String username, String content, String avatar_url)
	{
		this(username, content, avatar_url, false);
	}

	public DiscordMessage(String username, String content, String avatar_url, boolean tts)
	{
		setUsername(username);
		setContent(content);
		setAvatarUrl(avatar_url);
		setTextToSpeech(tts);
	}

	public void setUsername(String username)
	{
		if (username != null)
		{
			this.username = username.substring(0, Math.min(31, username.length()));
		}
		else
		{
			this.username = null;
		}
	}

	public static class DiscordMessageBuilder
	{
		List<DiscordEmbed> embeds = new ArrayList<>();

		public DiscordMessageBuilder embed(DiscordEmbed embed)
		{
			embeds.add(embed);
			return this;
		}
	}
}
