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
package net.runelite.client.plugins.defaultworld;

import com.google.inject.Provides;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.WorldUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;

@PluginDescriptor(
	name = "Default World",
	description = "Enable a default world to be selected when launching the client",
	tags = {"home"}
)
@Slf4j
public class DefaultWorldPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DefaultWorldConfig config;

	private final WorldClient worldClient = new WorldClient();
	private int worldCache;
	private boolean worldChangeRequired;

	@Override
	protected void startUp() throws Exception
	{
		worldChangeRequired = true;
		applyWorld();
	}

	@Override
	protected void shutDown() throws Exception
	{
		worldChangeRequired = true;
		changeWorld(worldCache);
	}

	@Provides
	DefaultWorldConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DefaultWorldConfig.class);
	}

	@Subscribe
	public void onSessionOpen(SessionOpen event)
	{
		worldChangeRequired = true;
		applyWorld();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		applyWorld();
	}

	private void changeWorld(int newWorld)
	{
		if (!worldChangeRequired || client.getGameState() != GameState.LOGIN_SCREEN)
		{
			return;
		}

		worldChangeRequired = false;
		int correctedWorld = newWorld < 300 ? newWorld + 300 : newWorld;

		// Old School RuneScape worlds start on 301 so don't even bother trying to find lower id ones
		// and also do not try to set world if we are already on it
		if (correctedWorld <= 300 || client.getWorld() == correctedWorld)
		{
			return;
		}

		try
		{
			final WorldResult worldResult = worldClient.lookupWorlds();
			final World world = worldResult.findWorld(correctedWorld);

			if (world != null)
			{
				final net.runelite.api.World rsWorld = client.createWorld();
				rsWorld.setActivity(world.getActivity());
				rsWorld.setAddress(world.getAddress());
				rsWorld.setId(world.getId());
				rsWorld.setPlayerCount(world.getPlayers());
				rsWorld.setLocation(world.getLocation());
				rsWorld.setTypes(WorldUtil.toWorldTypes(world.getTypes()));

				client.changeWorld(rsWorld);
				log.debug("Applied new world {}", correctedWorld);
			}
			else
			{
				log.warn("World {} not found.", correctedWorld);
			}
		}
		catch (IOException e)
		{
			log.warn("Error looking up world {}. Error: {}", correctedWorld, e);
		}
	}

	private void applyWorld()
	{
		if (worldCache == 0)
		{
			worldCache = client.getWorld();
			log.debug("Stored old world {}", worldCache);
		}

		final int newWorld = config.getWorld();
		changeWorld(newWorld);
	}
}
