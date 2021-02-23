/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.game;

import java.io.IOException;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.WorldsFetch;
import net.runelite.client.util.RunnableExceptionLogger;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;
import okhttp3.OkHttpClient;

@Singleton
@Slf4j
public class WorldService
{
	private static final int WORLD_FETCH_TIMER = 10; // minutes

	private final Client client;
	private final ScheduledExecutorService scheduledExecutorService;
	private final WorldClient worldClient;
	private final EventBus eventBus;
	private final CompletableFuture<WorldResult> firstRunFuture = new CompletableFuture<>();

	private WorldResult worlds;

	@Inject
	private WorldService(Client client, ScheduledExecutorService scheduledExecutorService, OkHttpClient okHttpClient,
		EventBus eventBus)
	{
		this.client = client;
		this.scheduledExecutorService = scheduledExecutorService;
		this.worldClient = new WorldClient(okHttpClient);
		this.eventBus = eventBus;

		scheduledExecutorService.scheduleWithFixedDelay(RunnableExceptionLogger.wrap(this::tick), 0, WORLD_FETCH_TIMER, TimeUnit.MINUTES);
	}

	private void tick()
	{
		try
		{
			if (worlds == null || client.getGameState() == GameState.LOGGED_IN)
			{
				fetch();
			}
		}
		finally
		{
			firstRunFuture.complete(worlds);
		}
	}

	private void fetch()
	{
		log.debug("Fetching worlds");

		try
		{
			WorldResult worldResult = worldClient.lookupWorlds();
			worldResult.getWorlds().sort(Comparator.comparingInt(World::getId));
			worlds = worldResult;
			eventBus.post(new WorldsFetch(worldResult));
		}
		catch (IOException ex)
		{
			log.warn("Error looking up worlds", ex);
		}
	}

	public void refresh()
	{
		scheduledExecutorService.execute(this::fetch);
	}

	@Nullable
	public WorldResult getWorlds()
	{
		if (!firstRunFuture.isDone())
		{
			try
			{
				return firstRunFuture.get(10, TimeUnit.SECONDS);
			}
			catch (InterruptedException | ExecutionException | TimeoutException e)
			{
				log.warn("Failed to retrieve worlds on first run", e);
			}
		}

		return worlds;
	}
}
