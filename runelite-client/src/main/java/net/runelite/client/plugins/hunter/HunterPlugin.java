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
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.Direction;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.gameval.ObjectID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
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
			case ObjectID.HUNTING_DEADFALL_TRAP: // Deadfall trap placed
			case ObjectID.HUNTING_MONKEYTRAP_SET: // Maniacal monkey trap placed
				// If player is right next to "object" trap assume that player placed the trap
				if (localPlayer.getWorldLocation().distanceTo(trapLocation) <= 2)
				{
					log.debug("Trap placed by \"{}\" on {}", localPlayer.getName(), trapLocation);
					traps.put(trapLocation, new HunterTrap(gameObject));
				}
				break;

			case ObjectID.HUNTING_IMPTRAP_EMPTY: // Imp box placed
			case ObjectID.HUNTING_BOXTRAP_EMPTY: // Box trap placed
			case ObjectID.HUNTING_OJIBWAY_TRAP: // Bird snare placed
				// If the player is on that tile, assume he is the one that placed the trap
				// Note that a player can move and set up a trap in the same tick, and this
				// event runs after the player movement has been updated, so we need to
				// compare to the trap location to the last location of the player.
				if (lastTickLocalPlayerLocation != null
					&& trapLocation.distanceTo(lastTickLocalPlayerLocation) == 0)
				{
					log.debug("Trap placed by \"{}\" on {}", localPlayer.getName(), localPlayer.getWorldLocation());
					traps.put(trapLocation, new HunterTrap(gameObject));
				}
				break;

			case ObjectID.HUNTING_SAPLING_NET_SET_SWAMP: // Net trap placed at Green salamanders
			case ObjectID.HUNTING_SAPLING_NET_SET_ORANGE: // Net trap placed at Orange salamanders
			case ObjectID.HUNTING_SAPLING_NET_SET_RED: // Net trap placed at Red salamanders
			case ObjectID.HUNTING_SAPLING_NET_SET_BLACK: // Net trap placed at Black salamanders
			case ObjectID.HUNTING_SAPLING_NET_SET_MOUNTAIN: // Net trap placed at Tecu salamanders
				if (lastTickLocalPlayerLocation != null
						&& trapLocation.distanceTo(lastTickLocalPlayerLocation) == 0)
				{
					// Net traps facing to the north and east must have their tile translated.
					// As otherwise, the wrong tile is stored.
					Direction trapOrientation = new Angle(gameObject.getOrientation()).getNearestDirection();
					WorldPoint translatedTrapLocation = trapLocation;

					switch (trapOrientation)
					{
						case SOUTH:
							translatedTrapLocation = trapLocation.dy(-1);
							break;
						case WEST:
							translatedTrapLocation = trapLocation.dx(-1);
							break;
					}

					log.debug("Trap placed by \"{}\" on {} facing {}", localPlayer.getName(), translatedTrapLocation, trapOrientation);
					traps.put(translatedTrapLocation, new HunterTrap(gameObject));
				}
				break;

			/*
			 * ------------------------------------------------------------------------------
			 * Catching stuff
			 * ------------------------------------------------------------------------------
			 */
			case ObjectID.HUNTING_IMPTRAP_FULL: // Imp caught
			case ObjectID.HUNTING_BOXTRAP_FULL_CHINCHOMPA_BLACK: // Black chinchompa caught
			case ObjectID.HUNTING_BOXTRAP_FULL_CHINCHOMPA: // Grey chinchompa caught
			case ObjectID.HUNTING_BOXTRAP_FULL_CHINCHOMPA_BIG: // Red chinchompa caught
			case ObjectID.HUNTING_BOXTRAP_FULL_FERRET: // Ferret caught
			case ObjectID.HUNTING_BOXTRAP_FULL_JERBOA: // Embertailed jerboa caught
			case ObjectID.HUNTING_DEADFALL_FULL_SPIKE: // Prickly kebbit caught
			case ObjectID.HUNTING_DEADFALL_FULL_SABRE: // Sabre-tooth kebbit caught
			case ObjectID.HUNTING_DEADFALL_FULL_BARBED: // Barb-tailed kebbit caught
			case ObjectID.HUNTING_DEADFALL_FULL_CLAW: // Wild kebbit caught
			case ObjectID.HUNTING_DEADFALL_FULL_FENNEC: // Pyre fox caught
			case ObjectID.HUNTING_OJIBWAY_TRAP_FULL_JUNGLE: // Crimson swift caught
			case ObjectID.HUNTING_OJIBWAY_TRAP_FULL_POLAR: // Cerulean twitch caught
			case ObjectID.HUNTING_OJIBWAY_TRAP_FULL_DESERT: // Golden warbler caught
			case ObjectID.HUNTING_OJIBWAY_TRAP_FULL_WOODLAND: // Copper longtail caught
			case ObjectID.HUNTING_OJIBWAY_TRAP_FULL_COLOURED: // Tropical wagtail caught
			case ObjectID.HUNTING_SAPLING_FULL_GREEN: // Green salamander caught
			case ObjectID.HUNTING_SAPLING_FULL_RED: // Red salamander caught
			case ObjectID.HUNTING_SAPLING_FULL_ORANGE: // Orange salamander caught
			case ObjectID.HUNTING_SAPLING_FULL_BLACK: // Black salamander caught
			case ObjectID.HUNTING_SAPLING_FULL_MOUNTAIN: // Tecu salamander caught
			case ObjectID.HUNTING_MONKEYTRAP_FULL_0: // Maniacal monkey tail obtained
			case ObjectID.HUNTING_MONKEYTRAP_FULL_1: // Maniacal monkey tail obtained
				if (myTrap != null)
				{
					myTrap.setState(HunterTrap.State.FULL);
					myTrap.resetTimer();

					if (myTrap.getObjectId() == ObjectID.HUNTING_MONKEYTRAP_SET)
					{
						notifier.notify(config.maniacalMonkeyNotify(), "You've caught part of a monkey's tail.");
					}
				}

				break;
			/*
			 * ------------------------------------------------------------------------------
			 * Failed catch
			 * ------------------------------------------------------------------------------
			 */
			case ObjectID.HUNTING_IMPTRAP_FAILED: //Empty imp box
			case ObjectID.HUNTING_BOXTRAP_FAILED: //Empty box trap
			case ObjectID.HUNTING_OJIBWAY_TRAP_BROKEN: //Empty box trap
			case ObjectID.HUNTING_DEADFALL_BOULDER: //Empty deadfall trap
			case ObjectID.HUNTING_SAPLING_FAILED_MOUNTAIN: //Empty net trap
				if (myTrap != null)
				{
					myTrap.setState(HunterTrap.State.EMPTY);
					myTrap.resetTimer();
				}

				break;
			/*
			 * ------------------------------------------------------------------------------
			 * Transitions
			 * ------------------------------------------------------------------------------
			 */
			// Imp entering box
			case ObjectID.HUNTING_IMPTRAP_TRAPPING:

			// Black chin shaking box
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BLACK_N:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BLACK_E:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BLACK_S:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BLACK_W:

			// Red chin shaking box
			case ObjectID.HUNTING_BOXTRAP_FAILING:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BIG_N:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BIG_E:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BIG_S:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_BIG_W:

			// Grey chin shaking box
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_N:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_E:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_CHINCHOMPA_S:

			// Ferret shaking box
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_FERRET_N:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_FERRET_S:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_FERRET_W:

			// Embertailed Jerboa box
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_JERBOA_N:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_JERBOA_E:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_JERBOA_S:
			case ObjectID.HUNTING_BOXTRAP_TRAPPING_JERBOA_W:

			// Bird traps
			case ObjectID.HUNTING_OJIBWAY_TRAP_FAILING:
			case ObjectID.HUNTING_OJIBWAY_TRAP_TRAPPING_COLOURED:
			case ObjectID.HUNTING_OJIBWAY_TRAP_TRAPPING_JUNGLE:
			case ObjectID.HUNTING_OJIBWAY_TRAP_TRAPPING_POLAR:
			case ObjectID.HUNTING_OJIBWAY_TRAP_TRAPPING_DESERT:
			case ObjectID.HUNTING_OJIBWAY_TRAP_TRAPPING_WOODLAND:

			// Deadfall trap
			case ObjectID.HUNTING_DEADFALL_TRAPPING_SPIKE:
			case ObjectID.HUNTING_DEADFALL_TRAPPING_SABRE:
			case ObjectID.HUNTING_DEADFALL_TRAPPING_SABRE_M:
			case ObjectID.HUNTING_DEADFALL_TRAPPING_BARBED:
			case ObjectID.HUNTING_DEADFALL_TRAPPING_BARBED_M:
			case ObjectID.HUNTING_DEADFALL_TRAPPING_CLAW:
			case ObjectID.HUNTING_DEADFALL_TRAPPING_FENNEC:
			case ObjectID.HUNTING_DEADFALL_TRAPPING_FENNEC_M:

			// Net trap
			case ObjectID.HUNTING_SAPLING_CATCHING_GREEN:
			case ObjectID.HUNTING_SAPLING_FAILING_SWAMP:
			case ObjectID.HUNTING_SAPLING_CATCHING_ORANGE:
			case ObjectID.HUNTING_SAPLING_FAILING_ORANGE:
			case ObjectID.HUNTING_SAPLING_CATCHING_RED:
			case ObjectID.HUNTING_SAPLING_FAILING_RED:
			case ObjectID.HUNTING_SAPLING_CATCHING_BLACK:
			case ObjectID.HUNTING_SAPLING_FAILING_BLACK:
			case ObjectID.HUNTING_SAPLING_CATCHING_MOUNTAIN:
			case ObjectID.HUNTING_SAPLING_FAILING_MOUNTAIN:

			// Maniacal monkey boulder trap
			case ObjectID.HUNTING_MONKEYTRAP_TRAPPING_0:
			case ObjectID.HUNTING_MONKEYTRAP_TRAPPING_1:
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
					if (object.getId() == ObjectID.HUNTING_DEADFALL_BOULDER || object.getId() == ObjectID.HUNTING_MONKEYTRAP_UNSET)
					{
						containsBoulder = true;
						break;
					}

					// Check for young trees (used while catching salamanders) in the tile.
					// Otherwise, hunter timers will never disappear after a trap is dismantled
					if (object.getId() == ObjectID.HUNTING_SAPLING_UP_ORANGE || object.getId() == ObjectID.HUNTING_SAPLING_UP_RED ||
						object.getId() == ObjectID.HUNTING_SAPLING_UP_BLACK || object.getId() == ObjectID.HUNTING_SAPLING_UP_SWAMP ||
						object.getId() == ObjectID.HUNTING_SAPLING_UP_MOUNTAIN || object.getId() == ObjectID.HUNTING_SAPLING_SETTING_MOUNTAIN)
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
				if (trap.getObjectId() == ObjectID.HUNTING_MONKEYTRAP_SET &&
					!trap.getState().equals(HunterTrap.State.FULL) && !trap.getState().equals(HunterTrap.State.OPEN))
				{
					notifier.notify(config.maniacalMonkeyNotify(), "The monkey escaped.");
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
