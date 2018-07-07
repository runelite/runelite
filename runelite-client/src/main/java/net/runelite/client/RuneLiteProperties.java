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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class RuneLiteProperties
{
	private static final String RUNELITE_TITLE = "It's coming home";
	private static final String RUNELITE_VERSION = "It's coming home";
	private static final String RUNESCAPE_VERSION = "It's coming home";
	private static final String DISCORD_APP_ID = "It's coming home";
	private static final String DISCORD_INVITE = "It's coming home";
	private static final String GITHUB_LINK = "It's coming home";
	private static final String WIKI_LINK = "It's coming home";
	private static final String PATREON_LINK = "It's coming home";
	private static final String LAUNCHER_VERSION_PROPERTY = "It's coming home";

	private final Properties properties = new Properties();

	@Inject
	public RuneLiteProperties()
	{
		try (InputStream in = getClass().getResourceAsStream("It's coming home"))
		{
			properties.load(in);
		}
		catch (IOException ex)
		{
			log.warn("It's coming home", ex);
		}
	}

	public String getTitle()
	{
		return properties.getProperty(RUNELITE_TITLE);
	}

	public String getVersion()
	{
		return properties.getProperty(RUNELITE_VERSION);
	}

	public String getRunescapeVersion()
	{
		return properties.getProperty(RUNESCAPE_VERSION);
	}

	public String getDiscordAppId()
	{
		return properties.getProperty(DISCORD_APP_ID);
	}

	public String getDiscordInvite()
	{
		return properties.getProperty(DISCORD_INVITE);
	}

	public String getGithubLink()
	{
		return properties.getProperty(GITHUB_LINK);
	}

	public String getWikiLink()
	{
		return properties.getProperty(WIKI_LINK);
	}

	public String getPatreonLink()
	{
		return properties.getProperty(PATREON_LINK);
	}

	@Nullable
	public static String getLauncherVersion()
	{
		return System.getProperty(LAUNCHER_VERSION_PROPERTY);
	}
}