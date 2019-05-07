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

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
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
	private static final String WINE_MESSAGE = "You squeeze the grapes into the jug";

	@Inject
	private CookingConfig config;

	@Inject
	private CookingOverlay cookingOverlay;

	@Inject
	private FermentTimerOverlay fermentTimerOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Getter(AccessLevel.PACKAGE)
	private CookingSession cookingSession;

	@Getter(AccessLevel.PACKAGE)
	private FermentTimerSession fermentTimerSession;

	@Provides
	CookingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CookingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		cookingSession = null;
		fermentTimerSession = null;
		overlayManager.add(cookingOverlay);
		overlayManager.add(fermentTimerOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(fermentTimerOverlay);
		overlayManager.remove(cookingOverlay);
		fermentTimerSession = null;
		cookingSession = null;
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (config.statTimeout() == 0)
		{
			return;
		}

		if (cookingSession != null)
		{
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());
			Duration sinceCut = Duration.between(cookingSession.getLastCookingAction(), Instant.now());

			if (sinceCut.compareTo(statTimeout) >= 0)
			{
				cookingSession = null;
			}
		}
		if (fermentTimerSession != null)
		{
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());
			Duration sinceCut = Duration.between(fermentTimerSession.getLastWineMakingAction(), Instant.now());

			if (sinceCut.compareTo(statTimeout) >= 0)
			{
				fermentTimerSession = null;
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.startsWith(WINE_MESSAGE) && config.fermentTimer())
		{
			if (fermentTimerSession == null)
			{
				fermentTimerSession = new FermentTimerSession();
			}

			fermentTimerSession.updateLastWineMakingAction();
		}

		if (message.startsWith("You successfully cook")
			|| message.startsWith("You successfully bake")
			|| message.startsWith("You manage to cook")
			|| message.startsWith("You roast a")
			|| message.startsWith("You cook")
			|| message.startsWith(WINE_MESSAGE))
		{
			if (cookingSession == null)
			{
				cookingSession = new CookingSession();
			}

			cookingSession.updateLastCookingAction();
			cookingSession.increaseCookAmount();

		}
		else if (message.startsWith("You accidentally burn"))
		{
			if (cookingSession == null)
			{
				cookingSession = new CookingSession();
			}

			cookingSession.updateLastCookingAction();
			cookingSession.increaseBurnAmount();
		}
	}
}
