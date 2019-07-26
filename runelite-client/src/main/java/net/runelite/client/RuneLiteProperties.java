/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client;

import java.util.Properties;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.RuneLitePlusConfig;
import net.runelite.http.api.RuneLiteAPI;

@Singleton
@Slf4j
public class RuneLiteProperties
{
	private static final String DISCORD_APP_ID_PLUS = "560644885250572289";

	private final Properties properties = new Properties();

	private final RuneLitePlusConfig runeLitePlusConfig;

	@Inject
	public RuneLiteProperties(final RuneLitePlusConfig runeLiteConfig)
	{
		this.runeLitePlusConfig = runeLiteConfig;
	}

	public RuneLiteProperties()
	{
		runeLitePlusConfig = null;
	}

	public String getTitle()
	{
		final StringBuilder sb = new StringBuilder("RuneLitePlus");
		String proxy;
		if ((proxy = System.getProperty("socksProxyHost")) != null)
		{
			sb.append(String.format(" (%s)", proxy));
		}
		return sb.toString();
	}

	public String getVersion()
	{
		return RuneLiteAPI.getVersion();
	}

	public String getPlusVersion()
	{
		return RuneLite.PLUS_VERSION;
	}

	public String getRunescapeVersion()
	{
		return "" + RuneLiteAPI.getRsVersion();
	}

	public String getDiscordAppId()
	{
		return DISCORD_APP_ID_PLUS;
	}

	public String getDiscordInvite()
	{
		return "https://discord.gg/HN5gf3m";
	}

	public String getGithubLink()
	{
		return "https://github.com/runelite-extended/runelite";
	}

	public String getWikiLink()
	{
		return "https://github.com/runelite-extended/runelite/wiki";
	}

	public String getPatreonLink()
	{
		return "https://www.patreon.com/RuneLitePlus";
	}
}
