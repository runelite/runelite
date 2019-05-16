/*
 * Copyright (c) 2019, gregg1494 <https://github.com/gregg1494>
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
package net.runelite.client.plugins.ping;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.ping.ping.Ping;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@PluginDescriptor(
	name = "Ping",
	description = "Show current world ping",
	tags = {"Ping", "overlay"},
	enabledByDefault = false
)

@Slf4j
public class PingPlugin extends Plugin
{
	private static final int WORLD_FETCH_TIMER = 600;
	private static final int WORLD_PING_TIMER = 60;

	private ScheduledFuture<?> worldResultFuture, pingFuture;
	private WorldResult worldResult;

	private int currentPing;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PingOverlay overlay;

	@Inject
	private ScheduledExecutorService executorService;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		worldResultFuture = executorService.scheduleAtFixedRate(this::fetchWorlds, 0, WORLD_FETCH_TIMER, TimeUnit.SECONDS);
		pingFuture = executorService.scheduleAtFixedRate(this::pingWorld, 0, WORLD_PING_TIMER, TimeUnit.SECONDS);
	}

	@Override
	protected void shutDown() throws Exception
	{
		pingFuture.cancel(true);
		pingFuture = null;

		overlayManager.remove(overlay);

		worldResultFuture.cancel(true);
		worldResultFuture = null;
		worldResult = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			pingFuture.cancel(true);
			worldResultFuture.cancel(true);
			return;
		}

		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			worldResultFuture = executorService.scheduleAtFixedRate(this::fetchWorlds, 0, WORLD_FETCH_TIMER, TimeUnit.SECONDS);
			pingFuture = executorService.scheduleAtFixedRate(this::pingWorld, 0, WORLD_PING_TIMER, TimeUnit.SECONDS);
		}
	}

	public int getCurrentPing()
	{
		return currentPing;
	}

	private void fetchWorlds()
	{
		try
		{
			worldResult = new WorldClient().lookupWorlds();

			if (worldResult != null)
			{
				worldResult.getWorlds();
			}
		}
		catch (IOException ex)
		{
			log.warn("Error looking up worlds", ex);
		}
	}

	private void pingWorld()
	{
		if (worldResult == null)
		{
			return;
		}

		World currentWorld = worldResult.findWorld(client.getWorld());
		currentPing = Ping.ping(currentWorld);
	}
}
