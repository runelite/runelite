/*
 * Copyright (c) 2018, Danny <DannysPVM@gmail.com>
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
package net.runelite.client.plugins.deathindicator;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.Timer;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

@PluginDescriptor(
	name = "Death Indicator"
)
public class DeathIndicatorPlugin extends Plugin
{
	static BufferedImage BONES;

	@Inject
	private Client client;

	@Inject
	private DeathIndicatorConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	private Timer deathTimer;

	private boolean hasRespawned = true;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				BONES = ImageIO.read(DeathIndicatorPlugin.class.getResourceAsStream("bones.png"));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Provides
	DeathIndicatorConfig deathIndicatorConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DeathIndicatorConfig.class);
	}

	@Override
	protected void startUp()
	{
		if (!hasDied())
		{
			return;
		}

		resetInfobox();

		if (client.getWorld() != config.deathWorld())
		{
			return;
		}

		if (config.showDeathHintArrow())
		{
			if (!client.hasHintArrow())
			{
				client.setHintArrow(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane()));
			}
		}

		if (config.showDeathOnWorldMap())
		{
			worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			worldMapPointManager.add(new DeathWorldMapPoint(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane())));
		}
	}

	@Override
	protected void shutDown()
	{
		if (client.hasHintArrow())
		{
			client.clearHintArrow();
		}

		if (deathTimer != null)
		{
			infoBoxManager.removeInfoBox(deathTimer);
			deathTimer = null;
		}

		worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
	}

	@Subscribe
	public void onLocalPlayerDeath(LocalPlayerDeath event)
	{
		if (client.isInInstancedRegion())
		{
			return;
		}

		hasRespawned = false;

		config.deathLocationX(client.getLocalPlayer().getWorldLocation().getX());
		config.deathLocationY(client.getLocalPlayer().getWorldLocation().getY());
		config.deathLocationPlane(client.getLocalPlayer().getWorldLocation().getPlane());
		config.deathWorld(client.getWorld());
		config.timeOfDeath(Instant.now());

		if (config.showDeathHintArrow())
		{
			client.setHintArrow(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane()));
		}

		if (config.showDeathOnWorldMap())
		{
			worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			worldMapPointManager.add(new DeathWorldMapPoint(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane())));
		}

		resetInfobox();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SERVER)
		{
			if (event.getMessage().equals("Oh dear, you are dead!"))
			{
				hasRespawned = true;
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!hasDied() || !hasRespawned || (client.getWorld() != config.deathWorld()))
		{
			return;
		}

		// Check if the player is at their death location, or timer has passed
		WorldPoint deathPoint = new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane());
		if (deathPoint.equals(client.getLocalPlayer().getWorldLocation()) || (deathTimer != null && deathTimer.cull()))
		{
			client.clearHintArrow();

			if (deathTimer != null)
			{
				infoBoxManager.removeInfoBox(deathTimer);
				deathTimer = null;
			}

			worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);

			resetDeath();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("deathIndicator"))
		{
			if (!config.showDeathHintArrow() && hasDied())
			{
				client.clearHintArrow();
			}

			if (!config.showDeathInfoBox() && deathTimer != null)
			{
				infoBoxManager.removeInfoBox(deathTimer);
				deathTimer = null;
			}

			if (!config.showDeathOnWorldMap())
			{
				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			}

			if (!hasDied())
			{
				client.clearHintArrow();

				resetInfobox();

				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (!hasDied())
		{
			return;
		}

		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (client.getWorld() == config.deathWorld())
			{
				WorldPoint deathPoint = new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane());

				if (config.showDeathHintArrow())
				{
					client.setHintArrow(deathPoint);
				}

				if (config.showDeathOnWorldMap())
				{
					worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
					worldMapPointManager.add(new DeathWorldMapPoint(deathPoint));
				}
			}
			else
			{
				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			}
		}
	}

	private boolean hasDied()
	{
		return config.timeOfDeath() != null;
	}

	private void resetDeath()
	{
		config.deathLocationX(0);
		config.deathLocationY(0);
		config.deathLocationPlane(0);
		config.deathWorld(0);
		config.timeOfDeath(null);

		hasRespawned = false;
	}

	private void resetInfobox()
	{
		if (deathTimer != null)
		{
			infoBoxManager.removeInfoBox(deathTimer);
			deathTimer = null;
		}

		if (hasDied() && config.showDeathInfoBox())
		{
			Instant now = Instant.now();
			Duration timeLeft = Duration.ofHours(1).minus(Duration.between(config.timeOfDeath(), now));
			if (!timeLeft.isNegative() && !timeLeft.isZero())
			{
				deathTimer = new Timer(timeLeft.getSeconds(), ChronoUnit.SECONDS, BONES, this);
				deathTimer.setTooltip("Died on world: " + config.deathWorld());
				infoBoxManager.addInfoBox(deathTimer);
			}
		}
	}
}
