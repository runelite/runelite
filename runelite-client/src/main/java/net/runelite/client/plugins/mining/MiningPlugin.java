/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.mining;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.HintArrowType.WORLD_POSITION;
import net.runelite.api.MenuAction;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import net.runelite.api.Player;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayMenuEntry;

@PluginDescriptor(
	name = "Mining",
	description = "Show mining statistics and ore respawn timers",
	tags = {"overlay", "skilling", "timers"},
	enabledByDefault = false
)
@PluginDependency(XpTrackerPlugin.class)
public class MiningPlugin extends Plugin
{
	private static final Pattern MINING_PATERN = Pattern.compile(
		"You " +
			"(?:manage to|just)" +
			" (?:mined?|quarry) " +
			"(?:some|an?) " +
			"(?:copper|tin|clay|iron|silver|coal|gold|mithril|adamantite|runeite|amethyst|sandstone|granite|Opal|piece of Jade|Red Topaz|Emerald|Sapphire|Ruby|Diamond)" +
			"(?:\\.|!)");

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiningOverlay overlay;

	@Inject
	private MiningRocksOverlay rocksOverlay;

	@Inject
	private MiningConfig config;

	@Getter
	@Nullable
	private MiningSession session;

	@Getter(AccessLevel.PACKAGE)
	private final List<RockRespawn> respawns = new ArrayList<>();
	private boolean recentlyLoggedIn;

	@Getter
	@Nullable
	private Pickaxe pickaxe;

	@Provides
	MiningConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MiningConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(rocksOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		session = null;
		pickaxe = null;
		overlayManager.remove(overlay);
		overlayManager.remove(rocksOverlay);
		respawns.forEach(respawn -> clearHintArrowAt(respawn.getWorldPoint()));
		respawns.clear();
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
	{
		OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
		if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY
			&& overlayMenuClicked.getEntry().getOption().equals(MiningOverlay.MINING_RESET)
			&& overlayMenuClicked.getOverlay() == overlay)
		{
			session = null;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
				respawns.clear();
				break;
			case LOGGED_IN:
				// After login rocks that are depleted will be changed,
				// so wait for the next game tick before watching for
				// rocks to deplete
				recentlyLoggedIn = true;
				break;
		}
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		Player local = client.getLocalPlayer();

		if (event.getActor() != local)
		{
			return;
		}

		int animId = local.getAnimation();
		if (animId == AnimationID.DENSE_ESSENCE_CHIPPING)
		{
			// Can't use chat messages to start mining session on Dense Essence as they don't have a chat message when mined,
			// so we track the session here instead.
			if (session == null)
			{
				session = new MiningSession();
			}

			session.setLastMined();
		}
		else
		{
			Pickaxe pickaxe = Pickaxe.fromAnimation(animId);
			if (pickaxe != null)
			{
				this.pickaxe = pickaxe;
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		clearExpiredRespawns();
		recentlyLoggedIn = false;

		if (session == null || session.getLastMined() == null)
		{
			return;
		}

		if (pickaxe != null && pickaxe.matchesMiningAnimation(client.getLocalPlayer()))
		{
			session.setLastMined();
			return;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceMined = Duration.between(session.getLastMined(), Instant.now());

		if (sinceMined.compareTo(statTimeout) >= 0)
		{
			resetSession();
		}
	}

	/**
	 * Clears expired respawns and removes the hint arrow from expired Daeyalt essence rocks.
	 */
	private void clearExpiredRespawns()
	{
		respawns.removeIf(rockRespawn ->
		{
			final boolean expired = rockRespawn.isExpired();

			if (expired && rockRespawn.getRock() == Rock.DAEYALT_ESSENCE)
			{
				clearHintArrowAt(rockRespawn.getWorldPoint());
			}

			return expired;
		});
	}

	public void resetSession()
	{
		session = null;
		pickaxe = null;
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || recentlyLoggedIn)
		{
			return;
		}

		final GameObject object = event.getGameObject();
		final int region = client.getLocalPlayer().getWorldLocation().getRegionID();

		Rock rock = Rock.getRock(object.getId());
		if (rock != null)
		{
			final WorldPoint point = object.getWorldLocation();

			if (rock == Rock.DAEYALT_ESSENCE)
			{
				respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
				clearHintArrowAt(point);
			}
			else
			{
				RockRespawn rockRespawn = new RockRespawn(rock, point, Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
			}
		}
	}

	private void clearHintArrowAt(WorldPoint worldPoint)
	{
		if (client.getHintArrowType() == WORLD_POSITION && client.getHintArrowPoint().equals(worldPoint))
		{
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || recentlyLoggedIn)
		{
			return;
		}

		GameObject object = event.getGameObject();
		Rock rock = Rock.getRock(object.getId());

		// Inverse timer to track daeyalt essence active duration
		if (rock == Rock.DAEYALT_ESSENCE)
		{
			final int region = client.getLocalPlayer().getWorldLocation().getRegionID();
			RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
			respawns.add(rockRespawn);
			client.setHintArrow(object.getWorldLocation());
		}
		// If the Lovakite ore respawns before the timer is up, remove it
		else if (rock == Rock.LOVAKITE)
		{
			final WorldPoint point = object.getWorldLocation();
			respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final WallObject object = event.getWallObject();
		final int region = client.getLocalPlayer().getWorldLocation().getRegionID();

		switch (object.getId())
		{
			case EMPTY_WALL:
			{
				Rock rock = Rock.AMETHYST;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
				break;
			}
			case DEPLETED_VEIN_26665: // Depleted motherlode vein
			case DEPLETED_VEIN_26666: // Depleted motherlode vein
			case DEPLETED_VEIN_26667: // Depleted motherlode vein
			case DEPLETED_VEIN_26668: // Depleted motherlode vein
			{
				Rock rock = Rock.ORE_VEIN;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
				break;
			}
			case ORE_VEIN_26661: // Motherlode vein
			case ORE_VEIN_26662: // Motherlode vein
			case ORE_VEIN_26663: // Motherlode vein
			case ORE_VEIN_26664: // Motherlode vein
			{
				// If the vein respawns before the timer is up, remove it
				final WorldPoint point = object.getWorldLocation();
				respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
				break;
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SPAM || event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (MINING_PATERN.matcher(event.getMessage()).matches())
			{
				if (session == null)
				{
					session = new MiningSession();
				}

				session.setLastMined();
			}
		}
	}
}