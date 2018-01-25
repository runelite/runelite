/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;

@PluginDescriptor(
	name = "Motherlode plugin"
)
public class MotherlodePlugin extends Plugin
{
	@Getter
	private BufferedImage mineIcon;

	@Inject
	MotherlodeOverlay overlay;

	@Inject
	MotherlodeRocksOverlay rocksOverlay;

	@Inject
	MotherlodeSackOverlay motherlodeSackOverlay;

	@Inject
	MotherlodeConfig config;

	private final MotherlodeSession session = new MotherlodeSession();

	@Override
	public void configure(Binder binder)
	{
		binder.bind(MotherlodeOverlay.class);
	}

	@Provides
	MotherlodeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MotherlodeConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, rocksOverlay, motherlodeSackOverlay);
	}

	@Override
	protected void startUp() throws Exception
	{
		mineIcon = ImageIO.read(MotherlodePlugin.class.getResourceAsStream("/skill_icons/mining.png"));
	}

	public MotherlodeSession getSession()
	{
		return session;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.FILTERED)
		{
			if (event.getMessage().equals("You manage to mine some pay-dirt."))
			{
				session.incrementPayDirtMined();
			}
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void checkMining()
	{
		Instant lastPayDirtMined = session.getLastPayDirtMined();
		if (lastPayDirtMined == null)
		{
			return;
		}

		// reset recentPayDirtMined if you haven't mined anything recently
		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceMined = Duration.between(lastPayDirtMined, Instant.now());

		if (sinceMined.compareTo(statTimeout) >= 0)
		{
			session.resetRecent();
		}
	}
}
