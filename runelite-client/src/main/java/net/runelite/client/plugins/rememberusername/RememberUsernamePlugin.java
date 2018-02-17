/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.rememberusername;

import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.Objects;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Remember username"
)
@Slf4j
public class RememberUsernamePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private RememberUsernameConfig config;

	@Override
	protected void startUp() throws Exception
	{
		applyUsername();
	}

	protected void shutDown() throws Exception
	{
		GameState gameState = client.getGameState();
		if (gameState == GameState.LOGIN_SCREEN)
		{
			if (Objects.equals(config.username(), client.getUsername()))
			{
				client.setUsername("");
			}
		}
	}

	@Provides
	RememberUsernameConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RememberUsernameConfig.class);
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			applyUsername();
		}
		else if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (config.username().equals(client.getUsername()))
			{
				return;
			}

			log.debug("Saving username: {}", client.getUsername());
			config.username(client.getUsername());
		}
	}

	@Subscribe
	public void onSessionOpen(SessionOpen event)
	{
		// configuation for the account is available now, so update the username
		applyUsername();
	}

	private void applyUsername()
	{
		GameState gameState = client.getGameState();
		if (gameState == GameState.LOGIN_SCREEN)
		{
			String username = config.username();
			if (Strings.isNullOrEmpty(username))
			{
				return;
			}

			client.setUsername(username);
		}
	}
}
