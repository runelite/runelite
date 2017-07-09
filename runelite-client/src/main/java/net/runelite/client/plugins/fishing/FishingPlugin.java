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
package net.runelite.client.plugins.fishing;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.ChatMessageType;
import net.runelite.client.RuneLite;
import net.runelite.client.events.ChatMessage;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FishingPlugin extends Plugin
{
	private static final int CHECK_INTERVAL = 1;

	private final RuneLite runelite = RuneLite.getRunelite();
	private final FishingConfig config = runelite.getConfigManager().getConfig(FishingConfig.class);
	private final FishingOverlay overlay = new FishingOverlay(this);
	private final FishingSpotOverlay spotOverlay = new FishingSpotOverlay(this);

	private ScheduledFuture<?> future;

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, spotOverlay);
	}

	@Override
	protected void startUp() throws Exception
	{
		ScheduledExecutorService executor = runelite.getExecutor();
		future = executor.scheduleAtFixedRate(this::checkFishing, CHECK_INTERVAL, CHECK_INTERVAL, TimeUnit.SECONDS);
	}

	@Override
	protected void shutDown() throws Exception
	{
		future.cancel(true);
	}

	public FishingConfig getConfig()
	{
		return config;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		if (event.getMessage().contains("You catch a") || event.getMessage().contains("You catch some"))
		{
			overlay.lastFishCaught = Instant.now();
			overlay.totalFished++;

			if (overlay.recentFished == 0)
			{
				overlay.recentFishCaught = Instant.now();
			}
			overlay.recentFished++;

			if (overlay.recentFishCaught != null)
			{
				overlay.perHour = (int) ((double) overlay.recentFished * 3600000.0D / ((double) Instant.now().toEpochMilli() - overlay.recentFishCaught.toEpochMilli()));
			}
		}
	}

	@Subscribe
	public void updateConfig(ConfigChanged event)
	{
		spotOverlay.updateConfig();
	}

	private void checkFishing()
	{
		//reset recentcaught if you haven't caught anything in 5 minutes
		if (overlay.lastFishCaught == null || Instant.now().compareTo(overlay.lastFishCaught.plus(Duration.ofMinutes(config.statTimeout()))) >= 0 && overlay.recentFished != 0)
		{
			overlay.recentFished = 0;
		}
	}
}
