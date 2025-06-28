/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.lowmemory;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Scene;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Low Detail",
	description = "Turn off ground decorations and certain textures, reducing memory usage",
	tags = {"memory", "usage", "ground", "decorations"},
	enabledByDefault = false
)
public class LowMemoryPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private LowMemoryConfig config;

	@Override
	protected void startUp()
	{
		clientThread.invoke(() ->
		{
			// When the client starts it initializes the texture size based on the memory mode setting.
			// Don't set low memory before the login screen is ready to prevent loading the low detail textures,
			// which breaks the gpu plugin due to it requiring the 128x128px textures
			if (client.getGameState().getState() >= GameState.LOGIN_SCREEN.getState())
			{
				client.changeMemoryMode(config.lowDetail());
			}
		});
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(() -> client.changeMemoryMode(false));
	}

	@Provides
	LowMemoryConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LowMemoryConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.STARTING)
		{
			client.changeMemoryMode(false);
		}
		else if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			client.changeMemoryMode(config.lowDetail());
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals(LowMemoryConfig.GROUP))
		{
			clientThread.invoke(() ->
			{
				if (client.getGameState().getState() >= GameState.LOGIN_SCREEN.getState())
				{
					client.changeMemoryMode(config.lowDetail());
				}
			});
		}
	}

	@Subscribe
	public void onBeforeRender(BeforeRender beforeRender)
	{
		// This needs to be set to the current plane, but there is no event for plane change, so
		// just set it each render.
		final Scene scene = client.getScene();
		if (scene == null)
		{
			return;
		}

		scene.setMinLevel(config.hideLowerPlanes() ? client.getPlane() : 0);
	}
}
