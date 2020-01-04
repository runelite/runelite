/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.tearsofguthix;

import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.http.api.chat.ChatClient;
import javax.inject.Inject;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@PluginDescriptor(
	name = "Tears Of Guthix",
	description = "Show timers for the Tears Of Guthix streams and time left",
	tags = {"minigame", "overlay", "skilling", "timers", "tog"}
)
public class TearsOfGuthixPlugin extends Plugin
{
	private static final int TOG_REGION = 12948;
	private boolean hasCreatedTimer = false;
	private boolean timerRunning = false;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TearsOfGuthixOverlay overlay;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private TearsOfGuthixConfig tearsOfGuthixConfig;

	@Inject
	private ChatClient chatClient;

	@Inject
	private TearsOfGuthixTimerOverlay timer;

	@Inject
	private SpriteManager spriteManager;

	@Provides
	TearsOfGuthixConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TearsOfGuthixConfig.class);
	}

	@Getter
	private final Map<DecorativeObject, Instant> streams = new HashMap<>();

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		infoBoxManager.removeInfoBox(timer);
		streams.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
			case LOGIN_SCREEN:
			case HOPPING:
				streams.clear();
		}
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		DecorativeObject object = event.getDecorativeObject();

		if (event.getDecorativeObject().getId() == ObjectID.BLUE_TEARS ||
			event.getDecorativeObject().getId() == ObjectID.BLUE_TEARS_6665)
		{
			if (client.getLocalPlayer().getWorldLocation().getRegionID() == TOG_REGION)
			{
				streams.put(event.getDecorativeObject(), Instant.now());
			}
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		if (streams.isEmpty())
		{
			return;
		}

		DecorativeObject object = event.getDecorativeObject();
		streams.remove(object);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!hasCreatedTimer)
		{
			if (client.getLocalPlayer().getWorldLocation().getRegionID() == 12948 && client.getLocalPlayer().getWorldLocation().getX() >= 3254 && client.getLocalPlayer().getWorldLocation().getX() <= 3262)
			{
				timer = new TearsOfGuthixTimerOverlay(this);
				spriteManager.getSpriteAsync(SpriteID.TAB_QUESTS_RED_MINIGAMES, 0, timer);
				timer.setTooltip("Tears of Guthix");
				if (tearsOfGuthixConfig.time())
				{
					infoBoxManager.addInfoBox(timer);
					timerRunning = true;
				}
				hasCreatedTimer = true;
			}

		}
		else if (timer != null)
		{
			if (client.getLocalPlayer().getWorldLocation().getX() <= 3253)
			{
				infoBoxManager.removeInfoBox(timer);
				timer = null;
				timerRunning = false;
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (tearsOfGuthixConfig.time() && !timerRunning && hasCreatedTimer)
		{
			if (client.getLocalPlayer().getWorldLocation().getRegionID() == 12948 && client.getLocalPlayer().getWorldLocation().getX() >= 3254 && client.getLocalPlayer().getWorldLocation().getX() <= 3262)
			{
				infoBoxManager.addInfoBox(timer);
				timerRunning = true;
			}

		}
		else if (!tearsOfGuthixConfig.time() && timerRunning)
		{
			infoBoxManager.removeInfoBox(timer);
			timerRunning = false;
		}
	}

	int getQp()
	{
		try
		{
			int qp = client.getVar(VarPlayer.QUEST_POINTS);
			chatClient.submitQp(client.getLocalPlayer().getName(), qp);
			return chatClient.getQp(client.getLocalPlayer().getName());
		}
		catch (IOException | NullPointerException e)
		{
			return -1;
		}
	}

}
