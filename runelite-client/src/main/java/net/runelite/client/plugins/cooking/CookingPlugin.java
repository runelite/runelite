/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
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
package net.runelite.client.plugins.cooking;

import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Cooking",
	description = "Show cooking statistics",
	tags = {"overlay", "skilling", "cook"}
)
@PluginDependency(XpTrackerPlugin.class)
public class CookingPlugin extends Plugin
{
	@Inject
	private CookingConfig config;

	@Inject
	private CookingOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Getter(AccessLevel.PACKAGE)
	private CookingSession session;

	@Provides
	CookingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CookingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		session = null;
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		session = null;
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (session == null || config.statTimeout() == 0)
		{
			return;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastCookingAction(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			session = null;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.startsWith("You successfully cook") || message.startsWith("You successfully bake") || message.startsWith("You manage to cook") || message.startsWith("You roast a"))
		{
			if (session == null)
			{
				session = new CookingSession();
			}

			session.updateLastCookingAction();
			session.increaseCookAmount();

		}
		else if (message.startsWith("You accidentally burn"))
		{
			if (session == null)
			{
				session = new CookingSession();
			}

			session.updateLastCookingAction();
			session.increaseBurnAmount();
		}
	}
}
