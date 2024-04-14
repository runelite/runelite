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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.*;

import static net.runelite.api.ObjectID.BARRONITE_ROCKS;
import static net.runelite.api.ObjectID.BARRONITE_ROCKS_41548;
import static net.runelite.api.ObjectID.DEPLETED_VEIN;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import static net.runelite.api.ObjectID.GOLD_VEIN;
import static net.runelite.api.ObjectID.GOLD_VEIN_5990;
import static net.runelite.api.ObjectID.GOLD_VEIN_5991;
import static net.runelite.api.ObjectID.ORE_VEIN;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import static net.runelite.api.ObjectID.ROCKS_41549;
import static net.runelite.api.ObjectID.ROCKS_41550;

import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Mining",
	description = "Show mining statistics and ore respawn timers",
	tags = {"overlay", "skilling", "timers", "cam torum"},
	enabledByDefault = false
)
@PluginDependency(XpTrackerPlugin.class)
public class MiningPlugin extends Plugin
{
	private static final Pattern MINING_PATTERN = Pattern.compile(
		"You " +
			"(?:manage to|just)" +
			" (?:mined?|quarry|chip off) " +
			"(?:some|an?) " +
			"(?:copper|tin|clay|iron|silver|coal|gold|mithril|adamantite|runite|amethyst|sandstone|granite|barronite shards|barronite deposit|Opal|piece of Jade|Red Topaz|Emerald|Sapphire|Ruby|Diamond|bone shards)" +
			"(?:\\.|!)");

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiningOverlay overlay;

	@Inject
	private MiningRocksOverlay rocksOverlay;

	@Inject
	private MiningConfig config;

	@Inject
	private Notifier notifier;

	@Getter
	@Nullable
	@Setter(AccessLevel.PACKAGE)
	private MiningSession session;

	@Getter(AccessLevel.PACKAGE)
	private final List<RockRespawn> respawns = new ArrayList<>();
	private boolean recentlyLoggedIn;

	private static final int CAM_TORUM_REGION = 6037;
	@Getter(AccessLevel.PACKAGE)
	private boolean inCamTorumMiningRegion;

	@Getter(AccessLevel.PACKAGE)
	private final Map<TileObject, Tile> camTorumStreams = new HashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private final Map<WorldPoint, TileObject> camTorumDepletedRocks = new HashMap<>();
	private static final Set<Integer> CAM_TORUM_DEPLETED_ROCK_IDS = ImmutableSet.of(
		ObjectID.ROCKS_51486,
		ObjectID.ROCKS_51488,
		ObjectID.ROCKS_51490,
		ObjectID.ROCKS_51492
	);
	private int camTorumLastNotificationTick;

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
		initializeCamTorumState();
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
		camTorumStreams.clear();
		camTorumDepletedRocks.clear();
		inCamTorumMiningRegion = false;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
				respawns.clear();
				initializeCamTorumState();
				break;
			case LOGGED_IN:
				// After login rocks that are depleted will be changed,
				// so wait for the next game tick before watching for
				// rocks to deplete
				recentlyLoggedIn = true;
				initializeCamTorumState();
				break;
		}
	}

	private void initializeCamTorumState()
	{
		camTorumStreams.clear();
		camTorumDepletedRocks.clear();
		inCamTorumMiningRegion = client.getLocalPlayer().getWorldLocation().getRegionID() == CAM_TORUM_REGION;
		camTorumLastNotificationTick = -100; // negative value so instant logging in on water will still notify
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

		if (inCamTorumMiningRegion)
		{
			handleCamTorumStreamNotifications();
		}

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

	private void handleCamTorumStreamNotifications()
	{
		if (camTorumStreams.isEmpty() || !config.camTorumNotifyWaterSpawn())
		{
			return;
		}
		int ticksSinceNotif = client.getTickCount() - camTorumLastNotificationTick;
		if (ticksSinceNotif < 52)
		{ // streams last for about 45 or 50 game ticks
			return; // skip, already notified for the current streams
		}
		camTorumLastNotificationTick = client.getTickCount();

		boolean alreadyMiningStream = false;
		boolean inCamTorumMine = false;
		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		for (Map.Entry<TileObject, Tile> entry : camTorumStreams.entrySet())
		{
			Tile tile = entry.getValue();
			int distanceToStream = Math.abs(wp.getX() - tile.getWorldLocation().getX()) + Math.abs(wp.getY() - tile.getWorldLocation().getY());
			if (distanceToStream <= config.camTorumMaxDistanceHighlight())
			{
				inCamTorumMine = true;
			}
			if (distanceToStream == 1 && pickaxe != null && pickaxe.matchesMiningAnimation(client.getLocalPlayer()))
			{ // if stream is directly adjacent to player and player is in mining animation
				alreadyMiningStream = true;
				break;
			}
		}

		if (inCamTorumMine && !alreadyMiningStream)
		{
			notifier.notify("Watery rocks spawned!");
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
		if (inCamTorumMiningRegion && CAM_TORUM_DEPLETED_ROCK_IDS.contains(object.getId()))
		{
			camTorumDepletedRocks.remove(object.getWorldLocation());
		}
	}

	private void clearHintArrowAt(WorldPoint worldPoint)
	{
		if (client.getHintArrowType() == HintArrowType.COORDINATE && client.getHintArrowPoint().equals(worldPoint))
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
		else if (rock == Rock.LOVAKITE || rock == Rock.CALCIFIED_ROCK)
		{
			final WorldPoint point = object.getWorldLocation();
			respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
		}
		if (inCamTorumMiningRegion && CAM_TORUM_DEPLETED_ROCK_IDS.contains(object.getId()))
		{
			camTorumDepletedRocks.put(object.getWorldLocation(), object);
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
			case ROCKS_41549: // Depleted barronite vein
			case ROCKS_41550: // Depleted barronite vein
			{
				Rock rock = Rock.BARRONITE;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
				break;
			}
			case DEPLETED_VEIN: // Depleted gold vein
			{
				Rock rock = Rock.MINERAL_VEIN;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
				break;
			}
			case ORE_VEIN: // Motherlode vein
			case ORE_VEIN_26662: // Motherlode vein
			case ORE_VEIN_26663: // Motherlode vein
			case ORE_VEIN_26664: // Motherlode vein
			case BARRONITE_ROCKS: // Barronite vein
			case BARRONITE_ROCKS_41548: // Barronite vein
			case GOLD_VEIN: // Arzinian gold vein
			case GOLD_VEIN_5990: // Gold vein
			case GOLD_VEIN_5991: // Gold vein
			{
				// If the vein respawns before the timer is up, remove it
				final WorldPoint point = object.getWorldLocation();
				respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
				break;
			}
		}
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		DecorativeObject object = event.getDecorativeObject();
		if (inCamTorumMiningRegion && object.getId() == 51493)
		{
			camTorumStreams.put(object, event.getTile());
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		if (inCamTorumMiningRegion)
		{
			camTorumStreams.remove(event.getDecorativeObject());
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SPAM || event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (MINING_PATTERN.matcher(event.getMessage()).matches())
			{
				if (session == null)
				{
					session = new MiningSession();
				}

				session.setLastMined();
			}
		}
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		if (scriptPreFired.getScriptId() == ScriptID.ADD_OVERLAYTIMER_LOC)
		{
			var args = scriptPreFired.getScriptEvent().getArguments();
			int locCoord = (int) args[1];
			int locId = (int) args[2];
			int ticks = (int) args[5];

			switch (locId)
			{
				case DEPLETED_VEIN_26665: // Depleted motherlode vein
				case DEPLETED_VEIN_26666: // Depleted motherlode vein
				case DEPLETED_VEIN_26667: // Depleted motherlode vein
				case DEPLETED_VEIN_26668: // Depleted motherlode vein
				{
					WorldPoint worldPoint = new WorldPoint((locCoord >>> 14) & 0x3FFF, locCoord & 0x3FFF, (locCoord >>> 28) & 0x3);
					Rock rock = Rock.ORE_VEIN;
					RockRespawn rockRespawn = new RockRespawn(rock, worldPoint, Instant.now(), ticks * Constants.GAME_TICK_LENGTH, rock.getZOffset());
					respawns.add(rockRespawn);
					break;
				}
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (inCamTorumMiningRegion && config.camTorumDynamicMenuEntrySwap())
		{
			swapRockMenuEntries(event);
		}
	}

	private void swapRockMenuEntries(MenuEntryAdded event)
	{
		String target = event.getTarget();
		if (target.contains("Rocks"))
		{
			MenuEntry entry = event.getMenuEntry();
			WorldPoint entryTargetPoint = WorldPoint.fromScene(client, entry.getParam0(), entry.getParam1(), client.getPlane());
			if (camTorumDepletedRocks.get(entryTargetPoint) != null)
			{
				entry.setDeprioritized(true);
			}
		}
	}
}
