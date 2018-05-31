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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.Timer;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

@PluginDescriptor(
	name = "Death Indicator"
)
@Slf4j
public class DeathIndicatorPlugin extends Plugin
{
	public static final BufferedImage MAP_ARROW;
	public static final BufferedImage BONES;

	private Timer deathTimer;

	@Inject
	private Client client;

	@Inject
	private DeathIndicatorConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private static ItemManager itemManager;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				MAP_ARROW = ImageIO.read(ClueScrollPlugin.class.getResourceAsStream("clue_arrow.png"));
				BONES = itemManager.getImage(ItemID.BONES);
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
	protected void shutDown() throws Exception
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

		config.hasDied(true);

		config.hasRespawned(false);

		config.deathLocationX(client.getLocalPlayer().getWorldLocation().getX());
		config.deathLocationY(client.getLocalPlayer().getWorldLocation().getY());
		config.deathLocationPlane(client.getLocalPlayer().getWorldLocation().getPlane());

		config.deathWorld(client.getWorld());

		if (config.showDeathHintArrow())
		{
			client.setHintArrow(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane()));
		}

		if (config.showDeathOnWorldMap())
		{
			worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			worldMapPointManager.add(new DeathWorldMapPoint(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane())));
		}

		if (deathTimer != null)
		{
			infoBoxManager.removeInfoBox(deathTimer);
			deathTimer = null;
		}

		if (config.showDeathInfoBox())
		{
			config.timeOfDeath(Instant.now());
			deathTimer = new Timer(60, ChronoUnit.MINUTES, BONES, this);
			deathTimer.setTooltip("Died on world: " + config.deathWorld());
			infoBoxManager.addInfoBox(deathTimer);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SERVER)
		{
			if (event.getMessage().equals("Oh dear, you are dead!"))
			{
				config.hasRespawned(true);
			}

			if ((!config.hasDied()) && (config.timeOfDeath() == null))
			{
				return;
			}

			if (event.getMessage().equals("Welcome to RuneScape.") && config.showDeathInfoBox())
			{
				if (Instant.now().isBefore(config.timeOfDeath().plus(1, ChronoUnit.HOURS)))
				{
					if (deathTimer != null)
					{
						infoBoxManager.removeInfoBox(deathTimer);
						deathTimer = null;
					}
					deathTimer = new Timer(Duration.ofHours(1).minus(Duration.between(config.timeOfDeath(), Instant.now())).getSeconds(), ChronoUnit.SECONDS, BONES, this);
					deathTimer.setTooltip("Died on world: " + config.deathWorld());
					infoBoxManager.addInfoBox(deathTimer);
				}
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!config.hasDied() || !config.hasRespawned() || (client.getWorld() != config.deathWorld()))
		{
			return;
		}

		if ((client.getLocalPlayer().getWorldLocation().getX() == config.deathLocationX())
			&& (client.getLocalPlayer().getWorldLocation().getY() == config.deathLocationY())
			&& (client.getLocalPlayer().getWorldLocation().getPlane() == config.deathLocationPlane())
			|| ((deathTimer != null) && (deathTimer.getText().equals("0:00"))))
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
			config.deathMarkerReset(true);
		}

		if (config.deathMarkerReset())
		{
			config.hasDied(false);
			config.hasRespawned(true);
			config.deathMarkerReset(false);
			config.deathWorld(-1);
			config.deathLocationX(-1);
			config.deathLocationY(-1);
			config.deathLocationPlane(-1);
			config.timeOfDeath(null);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("deathIndicator"))
		{
			if (!config.showDeathHintArrow() && client.hasHintArrow())
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

			// Simulates hitting the reset button, removes death info!
			if ((config.deathLocationX() == -1)
				&& (config.deathLocationY() == -1)
				&& (config.deathLocationPlane() == -1)
				&& (!config.hasDied())
				&& (config.hasRespawned())
				&& (!config.deathMarkerReset())
				&& (config.deathWorld() == -1)
				&& (config.timeOfDeath() == null))
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
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (!config.hasDied())
		{
			return;
		}

		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (client.getWorld() == config.deathWorld())
			{
				if (config.showDeathHintArrow())
				{
					client.setHintArrow(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane()));
				}

				if (config.showDeathOnWorldMap())
				{
					worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
					worldMapPointManager.add(new DeathWorldMapPoint(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane())));
				}
			}
			else
			{
				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			}
		}
	}
}
