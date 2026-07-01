/*
 * Copyright (c) 2024, Hexagon <hexagon@fking.work>
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


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;

@Slf4j
@Singleton
class RuntimeConfigRefresher
{
	@Nullable
	private final RuntimeConfig managedRuntimeConfig;
	private final RuntimeConfigLoader configLoader;

	private Instant nextRefreshAt = nextRefreshTime();

	@Inject
	private RuntimeConfigRefresher(
		@Nullable RuntimeConfig managedRuntimeConfig,
		RuntimeConfigLoader configLoader,
		EventBus eventBus
	)
	{
		this.managedRuntimeConfig = managedRuntimeConfig;
		this.configLoader = configLoader;
		eventBus.register(this);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGIN_SCREEN)
		{
			return;
		}

		if (Instant.now().isBefore(nextRefreshAt))
		{
			log.debug("Skipping runtimeConfig refresh, next refresh at {}", nextRefreshAt);
			return;
		}

		if (managedRuntimeConfig == null)
		{
			log.debug("Skipping runtimeConfig refresh, current one is null");
			return;
		}

		configLoader.fetch().thenAccept(this::refreshConfig);
		nextRefreshAt = nextRefreshTime();
	}

	private Instant nextRefreshTime()
	{
		return Instant.now().plus(10, ChronoUnit.MINUTES);
	}

	private void refreshConfig(RuntimeConfig runtimeConfig)
	{
		managedRuntimeConfig.refresh(runtimeConfig);
		log.debug("Successfully refreshed the runtimeConfig");
	}
}
