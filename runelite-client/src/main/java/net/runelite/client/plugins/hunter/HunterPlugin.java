/*
 * Copyright (c) 2017, Robin Weymans <Robin.weymans@gmail.com>
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
package net.runelite.client.plugins.hunter;

import com.google.inject.Provides;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.coords.Direction;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Hunter",
	description = "Show the state of your traps",
	tags = {"overlay", "skilling", "timers"}
)
public class HunterPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TrapOverlay overlay;

	@Inject
	private Notifier notifier;

	@Inject
	private HunterConfig config;

	@Getter
	private final Map<WorldPoint, HunterTrap> traps = new HashMap<>();

	@Getter
	private Instant lastActionTime = Instant.ofEpochMilli(0);

	private WorldPoint lastTickLocalPlayerLocation;

	@Provides
	HunterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HunterConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlay.updateConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		lastActionTime = Instant.ofEpochMilli(0);
		traps.clear();
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();
		final WorldPoint trapLocation = gameObject.getWorldLocation();
		final HunterTrap myTrap = traps.get(trapLocation);
		final Player localPlayer = client.getLocalPlayer();

		switch (gameObject.getId())
		{
			/*
			 * ------------------------------------------------------------------------------
			 * Placing traps
			 * ------------------------------------------------------------------------------
			 */
			case ObjectID.DEADFALL: // Deadfall trap placed
				if (localPlayer.getWorldLocation().distanceTo(trapLocation) <= 2)
				{
					log.debug("Trap placed by \"{}\" on {}", localPlayer.getName(), trapLocation);
					traps.put(trapLocation, new HunterTrap(gameObject));
					lastActionTime = Instant.now();
				}
				break;

			case ObjectID.MONKEY_TRAP: // Maniacal monkey trap placed
				// If player is right next to "object" trap assume that player placed the trap
				if (localPlayer.getWorldLocation().distanceTo(trapLocation) <= 2)
				{
					log.debug("Trap placed by \"{}\" on {}", localPlayer.getName(), trapLocation);
					traps.put(trapLocation, new HunterTrap(gameObject));
					lastActionTime = Instant.now();
				}
				break;

			case ObjectID.MAGIC_BOX: // Imp box placed
			case ObjectID.BOX_TRAP_9380: // Box trap placed
			case ObjectID.BIRD_SNARE_9345: // Bird snare placed
				// If the player is on that tile, assume he is the one that placed the trap
				// Note that a player can move and set up a trap in the same tick, and this
				// event runs after the player movement has been updated, so we need to
				// compare to the trap location to the last location of the player.
				if (lastTickLocalPlayerLocation != null
					&& trapLocation.distanceTo(lastTickLocalPlayerLocation) == 0)
				{
					log.debug("Trap placed by \"{}\" on {}", localPlayer.getName(), localPlayer.getWorldLocation());
					traps.put(trapLocation, new HunterTrap(gameObject));
					lastActionTime = Instant.now();
				}
				break;

			case ObjectID.NET_TRAP_9343: // Net trap placed at green sallys
			case ObjectID.NET_TRAP: // Net trap placed at orange sallys
			case ObjectID.NET_TRAP_8992: // Net trap placed at red sallys
			case ObjectID.NET_TRAP_9002: // Net trap placed at black sallys
				if (lastTickLocalPlayerLocation != null
						&& trapLocation.distanceTo(lastTickLocalPlayerLocation) == 0)
				{
					// Net traps facing to the north and east must have their tile translated.
					// As otherwise, the wrong tile is stored.
					Direction trapOrientation = gameObject.getOrientation().getNearestDirection();
					WorldPoint translatedTrapLocation = trapLocation;

					switch (trapOrientation)
					{
						case NORTH:
							translatedTrapLocation = trapLocation.dy(1);
							break;
						case EAST:
							translatedTrapLocation = trapLocation.dx(1);
							break;
					}

					log.debug("Trap placed by \"{}\" on {}", localPlayer.getName(), translatedTrapLocation);
					traps.put(translatedTrapLocation, new HunterTrap(gameObject));
					lastActionTime = Instant.now();
				}
				break;

			/*
			 * ------------------------------------------------------------------------------
			 * Catching stuff
			 * ------------------------------------------------------------------------------
			 */
			case ObjectID.MAGIC_BOX_19226: // Imp caught
			case ObjectID.SHAKING_BOX: // Black chinchompa caught
			case ObjectID.SHAKING_BOX_9382: // Grey chinchompa caught
			case ObjectID.SHAKING_BOX_9383: // Red chinchompa caught
			case ObjectID.BOULDER_20648: // Prickly kebbit caught
			case ObjectID.BOULDER_20649: // Sabre-tooth kebbit caught
			case ObjectID.BOULDER_20650: // Barb-tailed kebbit caught
			case ObjectID.BOULDER_20651: // Wild kebbit caught
			case ObjectID.BIRD_SNARE_9373: // Crimson swift caught
			case ObjectID.BIRD_SNARE_9375: // Cerulean twitch caught
			case ObjectID.BIRD_SNARE_9377: // Golden warbler caught
			case ObjectID.BIRD_SNARE_9379: // Copper longtail caught
			case ObjectID.BIRD_SNARE_9348: // Tropical wagtail caught
			case ObjectID.NET_TRAP_9004: // Green sally caught
			case ObjectID.NET_TRAP_8986: // Red sally caught
			case ObjectID.NET_TRAP_8734: // Orange sally caught
			case ObjectID.NET_TRAP_8996: // Black sally caught
			case ObjectID.LARGE_BOULDER_28830: // Maniacal monkey tail obtained
			case ObjectID.LARGE_BOULDER_28831: // Maniacal monkey tail obtained
				if (myTrap != null)
				{
					myTrap.setState(HunterTrap.State.FULL);
					myTrap.resetTimer();
					lastActionTime = Instant.now();

					if (config.maniacalMonkeyNotify() && myTrap.getObjectId() == ObjectID.MONKEY_TRAP)
					{
						notifier.notify("You've caught part of a monkey's tail.");
					}
				}

				break;
			/*
			 * ------------------------------------------------------------------------------
			 * Failed catch
			 * ------------------------------------------------------------------------------
			 */
			case ObjectID.MAGIC_BOX_FAILED: //Empty imp box
			case ObjectID.BOX_TRAP_9385: //Empty box trap
			case ObjectID.BIRD_SNARE: //Empty box trap
				if (myTrap != null)
				{
					myTrap.setState(HunterTrap.State.EMPTY);
					myTrap.resetTimer();
					lastActionTime = Instant.now();
				}

				break;
			/*
			 * ------------------------------------------------------------------------------
			 * Transitions
			 * ------------------------------------------------------------------------------
			 */
			// Imp entering box
			case ObjectID.MAGIC_BOX_19225:

			// Black chin shaking box
			case ObjectID.BOX_TRAP:
			case ObjectID.BOX_TRAP_2026:
			case ObjectID.BOX_TRAP_2028:
			case ObjectID.BOX_TRAP_2029:

			// Red chin shaking box
			case ObjectID.BOX_TRAP_9381:
			case ObjectID.BOX_TRAP_9390:
			case ObjectID.BOX_TRAP_9391:
			case ObjectID.BOX_TRAP_9392:
			case ObjectID.BOX_TRAP_9393:

			// Grey chin shaking box
			case ObjectID.BOX_TRAP_9386:
			case ObjectID.BOX_TRAP_9387:
			case ObjectID.BOX_TRAP_9388:

			// Bird traps
			case ObjectID.BIRD_SNARE_9346:
			case ObjectID.BIRD_SNARE_9347:
			case ObjectID.BIRD_SNARE_9349:
			case ObjectID.BIRD_SNARE_9374:
			case ObjectID.BIRD_SNARE_9376:
			case ObjectID.BIRD_SNARE_9378:

			// Deadfall trap
			case ObjectID.DEADFALL_19218:
			case ObjectID.DEADFALL_19851:
			case ObjectID.DEADFALL_20128:
			case ObjectID.DEADFALL_20129:
			case ObjectID.DEADFALL_20130:
			case ObjectID.DEADFALL_20131:

			// Net trap
			case ObjectID.NET_TRAP_9003:
			case ObjectID.NET_TRAP_9005:
			case ObjectID.NET_TRAP_8972:
			case ObjectID.NET_TRAP_8974:
			case ObjectID.NET_TRAP_8985:
			case ObjectID.NET_TRAP_8987:
			case ObjectID.NET_TRAP_8993:
			case ObjectID.NET_TRAP_8997:

			// Maniacal monkey boulder trap
			case ObjectID.MONKEY_TRAP_28828:
			case ObjectID.MONKEY_TRAP_28829:
				if (myTrap != null)
				{
					myTrap.setState(HunterTrap.State.TRANSITION);
				}
				break;
		}
	}

	/**
	 * Iterates over all the traps that were placed by the local player and
	 * checks if the trap is still there. If the trap is gone, it removes
	 * the trap from the local players trap collection.
	 */
	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Check if all traps are still there, and remove the ones that are not.
		Iterator<Map.Entry<WorldPoint, HunterTrap>> it = traps.entrySet().iterator();
		Tile[][][] tiles = client.getScene().getTiles();

		Instant expire = Instant.now().minus(HunterTrap.TRAP_TIME.multipliedBy(2));

		while (it.hasNext())
		{
			Map.Entry<WorldPoint, HunterTrap> entry = it.next();
			HunterTrap trap = entry.getValue();
			WorldPoint world = entry.getKey();
			LocalPoint local = LocalPoint.fromWorld(client, world);

			// Not within the client's viewport
			if (local == null)
			{
				// Cull very old traps
				if (trap.getPlacedOn().isBefore(expire))
				{
					log.debug("Trap removed from personal trap collection due to timeout, {} left", traps.size());
					it.remove();
					continue;
				}
				continue;
			}

			Tile tile = tiles[world.getPlane()][local.getSceneX()][local.getSceneY()];
			GameObject[] objects = tile.getGameObjects();

			boolean containsBoulder = false;
			boolean containsAnything = false;
			boolean containsYoungTree = false;
			for (GameObject object : objects)
			{
				if (object != null)
				{
					containsAnything = true;
					if (object.getId() == ObjectID.BOULDER_19215 || object.getId() == ObjectID.LARGE_BOULDER)
					{
						containsBoulder = true;
						break;
					}

					// Check for young trees (used while catching salamanders) in the tile.
					// Otherwise, hunter timers will never disappear after a trap is dismantled
					if (object.getId() == ObjectID.YOUNG_TREE_8732 || object.getId() == ObjectID.YOUNG_TREE_8990 ||
						object.getId() == ObjectID.YOUNG_TREE_9000 || object.getId() == ObjectID.YOUNG_TREE_9341)
					{
						containsYoungTree = true;
					}
				}
			}

			if (!containsAnything || containsYoungTree)
			{
				it.remove();
				log.debug("Trap removed from personal trap collection, {} left", traps.size());
			}
			else if (containsBoulder) // For traps like deadfalls. This is different because when the trap is gone, there is still a GameObject (boulder)
			{
				it.remove();
				log.debug("Special trap removed from personal trap collection, {} left", traps.size());

				// Case we have notifications enabled and the action was not manual, throw notification
				if (config.maniacalMonkeyNotify() && trap.getObjectId() == ObjectID.MONKEY_TRAP &&
					!trap.getState().equals(HunterTrap.State.FULL) && !trap.getState().equals(HunterTrap.State.OPEN))
				{
					notifier.notify("The monkey escaped.");
				}
			}
		}

		lastTickLocalPlayerLocation = client.getLocalPlayer().getWorldLocation();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("hunterplugin"))
		{
			overlay.updateConfig();
		}
	}
}
