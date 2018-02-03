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
package net.runelite.client.plugins.woodcutting;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Woodcutting plugin"
)
public class WoodcuttingPlugin extends Plugin
{
	@Inject
	private Notifier notifier;

	@Inject
	private WoodcuttingOverlay overlay;

	@Inject
	private WoodcuttingConfig config;

	private final WoodcuttingSession session = new WoodcuttingSession();

	@Override
	public void configure(Binder binder)
	{
		binder.bind(WoodcuttingOverlay.class);
	}

	@Provides
	WoodcuttingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WoodcuttingConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public WoodcuttingSession getSession()
	{
		return session;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.FILTERED || event.getType() == ChatMessageType.SERVER)
		{
			if (event.getMessage().startsWith("You get some") && event.getMessage().endsWith("logs."))
			{
				session.incrementLogCut();
			}

			if (event.getMessage().contains("A bird's nest falls out of the tree") && config.showNestNotification())
			{
				notifier.notify("A bird nest has spawned!");
			}
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void checkCutting()
	{
		Instant lastLogCut = session.getLastLogCut();
		if (lastLogCut == null)
		{
			return;
		}

		// reset recentCut if you haven't cut anything recently
		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(lastLogCut, Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			session.resetRecent();
		}
	}
}
