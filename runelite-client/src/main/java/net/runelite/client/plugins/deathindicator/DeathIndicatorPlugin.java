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

import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.api.AnimationID.DEATH;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.Timer;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

@PluginDescriptor(
	name = "Death Indicator",
	description = "Show where you last died, and on what world",
	tags = {"arrow", "hints", "world", "map", "overlay"}
)
@Slf4j
public class DeathIndicatorPlugin extends Plugin
{
	private static final Set<Integer> RESPAWN_REGIONS = ImmutableSet.of(
		12850, // Lumbridge
		11828, // Falador
		12342, // Edgeville
		11062 // Camelot
	);
	static BufferedImage BONES;

	@Inject
	private Client client;

	@Inject
	private DeathIndicatorConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private DeathIndicatorOverlay deathIndicatorOverlay;

	@Inject
	private DeathMiniMapOverlay deathMiniMapOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	private Timer deathTimer;

	private WorldPoint lastDeath;
	private Instant lastDeathTime;
	private int lastDeathWorld;

	private boolean hasSentMessage = false;

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
		overlayManager.add(deathIndicatorOverlay);
		overlayManager.add(deathMiniMapOverlay);

		if (!hasDied() || !isDeadPlayer())
		{
			return;
		}

		resetInfobox();

		if (!onDeathWorld())
		{
			return;
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
		overlayManager.removeIf(DeathIndicatorOverlay.class::isInstance);
		overlayManager.removeIf(DeathMiniMapOverlay.class::isInstance);

		if (deathTimer != null)
		{
			infoBoxManager.removeInfoBox(deathTimer);
			deathTimer = null;
		}

		worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged animationChanged)
	{
		Player local = client.getLocalPlayer();
		if (animationChanged.getActor() != local
			|| local.getAnimation() != DEATH
			|| client.isInInstancedRegion()
			|| local.getHealthRatio() != 0)
		{
			return;
		}

		lastDeath = client.getLocalPlayer().getWorldLocation();
		lastDeathWorld = client.getWorld();
		lastDeathTime = Instant.now();
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Check if player respawned in a death respawn location
		if (lastDeath != null && !client.getLocalPlayer().getWorldLocation().equals(lastDeath))
		{
			if (!RESPAWN_REGIONS.contains(client.getLocalPlayer().getWorldLocation().getRegionID()))
			{
				log.debug("Died, but did not respawn in a known respawn location: {}",
					client.getLocalPlayer().getWorldLocation().getRegionID());

				lastDeath = null;
				lastDeathTime = null;
				return;
			}

			log.debug("Died! Grave at {}", lastDeath);

			// Save death to config
			config.deathLocationX(lastDeath.getX());
			config.deathLocationY(lastDeath.getY());
			config.deathLocationPlane(lastDeath.getPlane());
			config.timeOfDeath(lastDeathTime);
			config.deathWorld(lastDeathWorld);
			config.deadPlayerName(client.getUsername().replaceAll(" ", "_"));

			if (config.showDeathOnWorldMap())
			{
				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
				worldMapPointManager.add(new DeathWorldMapPoint(lastDeath));
			}

			resetInfobox();

			lastDeath = null;
			lastDeathTime = null;
			hasSentMessage = false;
		}

		if (!hasDied() || !isDeadPlayer() || !onDeathWorld())
		{
			return;
		}

		// Check if the player is at their death location, if it's been over an hour since death, or timer has passed
		WorldPoint deathPoint = new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane());
		if (deathPoint.equals(client.getLocalPlayer().getWorldLocation())
			|| Instant.now().isAfter(config.timeOfDeath().plusSeconds(3600))
			|| (deathTimer != null && deathTimer.cull()))
		{
			if (deathTimer != null)
			{
				infoBoxManager.removeInfoBox(deathTimer);
				deathTimer = null;
			}

			worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);

			resetDeath();

			hasSentMessage = false;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("deathIndicator"))
		{
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
			if (onDeathWorld() && isDeadPlayer())
			{
				WorldPoint deathPoint = new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane());

				if (config.showDeathOnWorldMap())
				{
					worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
					worldMapPointManager.add(new DeathWorldMapPoint(deathPoint));
				}

				resetInfobox();
			}
			else
			{
				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
				resetInfobox();
			}

			// Check if the player wants the message and has not received it yet and if it has been less than one hour since death
			if (config.showDeathChatMessage() && !hasSentMessage && Instant.now().isBefore(config.timeOfDeath().plusSeconds(3600)))
			{
				String deadPlayersName = config.deadPlayerName();
				Duration timeSinceDeath = Duration.between(config.timeOfDeath(), Instant.now());
				long minutes = timeSinceDeath.toMinutes();
				int world = config.deathWorld();

				// Check if the current player is the dead player
				if (deadPlayersName.equalsIgnoreCase(client.getUsername().replaceAll(" ", "_")))
				{
					sendChatMessage("You died " + minutes + " minutes ago on world " + world + ".");
					hasSentMessage = true;
				}
				else
				{
					sendChatMessage("You died on account '" + deadPlayersName + "' " + minutes + " minutes ago on world " + world + ".");
					hasSentMessage = true;
				}
			}
		}
	}

	boolean hasDied()
	{
		return config.timeOfDeath() != null;
	}

	boolean onDeathWorld()
	{
		return client.getWorld() == config.deathWorld();
	}

	boolean isDeadPlayer()
	{
		return config.deadPlayerName().equalsIgnoreCase(client.getUsername().replaceAll(" ", "_"));
	}

	private void resetDeath()
	{
		config.deathLocationX(0);
		config.deathLocationY(0);
		config.deathLocationPlane(0);
		config.deathWorld(0);
		config.timeOfDeath(null);
		config.deadPlayerName("");
	}

	private void resetInfobox()
	{
		if (deathTimer != null)
		{
			infoBoxManager.removeInfoBox(deathTimer);
			deathTimer = null;
		}

		if (hasDied() && isDeadPlayer() && config.showDeathInfoBox())
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

	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(chatMessage)
				.build();

		chatMessageManager.queue(
				QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(message)
				.build()
		);
	}
}
