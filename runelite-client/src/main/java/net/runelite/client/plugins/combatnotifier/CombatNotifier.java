/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
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
package net.runelite.client.plugins.combatnotifier;

import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CombatNotifier extends Plugin
{
	private static final int CHECK_INTERVAL = 1;

	private final Client client = RuneLite.getClient();
	private final RuneLite runelite = RuneLite.getRunelite();
	private final CombatNotifierConfig config = runelite.getConfigManager()
		.getConfig(CombatNotifierConfig.class);

	private ScheduledFuture<?> future;
	private Instant lastInteracting;

	@Override
	protected void startUp() throws Exception
	{
		ScheduledExecutorService executor = RuneLite.getRunelite().getExecutor();
		future = executor.scheduleAtFixedRate(this::checkIdle, CHECK_INTERVAL, CHECK_INTERVAL, TimeUnit.SECONDS);
	}

	@Override
	protected void shutDown() throws Exception
	{
		future.cancel(true);
	}

	private void checkIdle()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.isEnabled())
		{
			return;
		}

		Player local = client.getLocalPlayer();
		Actor opponent = local.getInteracting();
		if (opponent != null && opponent.getCombatLevel() > 0)
		{
			lastInteracting = Instant.now();
		}

		Duration waitDuration = Duration.ofMillis(config.getTimeout());
		if (lastInteracting != null && Instant.now().compareTo(lastInteracting.plus(waitDuration)) >= 0)
		{
			runelite.notify("[" + local.getName() + "] is now out of combat!");
			lastInteracting = null;
		}
	}

}