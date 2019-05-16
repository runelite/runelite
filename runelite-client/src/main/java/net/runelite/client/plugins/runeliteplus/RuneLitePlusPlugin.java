/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.runeliteplus;


import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientUI;

@PluginDescriptor(
	loadWhenOutdated = true, // prevent users from disabling
	hidden = true, // prevent users from disabling
	name = "RuneLitePlus",
	description = "Configures various aspects of RuneLitePlus",
	type = PluginType.EXTERNAL
)

@Slf4j
public class RuneLitePlusPlugin extends Plugin
{
	public static boolean customPresenceEnabled = false;
	public static String rlPlusDiscordApp = "560644885250572289";
	public static String rlDiscordApp = "409416265891971072";

	@Inject
	public RuneLitePlusConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	public DiscordService discordService;


	@Provides
	RuneLitePlusConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RuneLitePlusConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		if (getConfig(configManager).customPresence())
		{
			ClientUI.currentPresenceName = ("RuneLitePlus");
			ClientUI.frame.setTitle(ClientUI.currentPresenceName);
		}

		if (config.customPresence())
		{
			RuneLiteProperties.discordAppID = rlPlusDiscordApp;
			discordService.close();
			discordService.init();
		}
		else
		{
			RuneLiteProperties.discordAppID = rlDiscordApp;
			discordService.close();
			discordService.init();
		}
	}

	@Subscribe
	protected void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("customPresence"))
		{
			if (config.customPresence())
			{
				ClientUI.currentPresenceName = ("RuneLitePlus");
				ClientUI.frame.setTitle(ClientUI.currentPresenceName);
			}
			else
			{
				ClientUI.currentPresenceName = ("RuneLite");
				ClientUI.frame.setTitle(ClientUI.currentPresenceName);
			}

			if (config.customPresence())
			{
				RuneLiteProperties.discordAppID = rlPlusDiscordApp;
				discordService.close();
				discordService.init();
			}
			else
			{
				RuneLiteProperties.discordAppID = rlDiscordApp;
				discordService.close();
				discordService.init();
			}
		}
	}

	@Override
	protected void shutDown() throws Exception
	{

	}

}
