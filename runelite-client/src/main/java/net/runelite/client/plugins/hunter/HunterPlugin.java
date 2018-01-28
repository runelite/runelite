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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.api.queries.PlayerQuery;
import net.runelite.client.config.ConfigManager;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

@Slf4j
@PluginDescriptor(
	name = "Hunter plugin"
)
public class HunterPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private HunterConfig config;

	@Inject
	private TrapOverlay trapOverlay;

	@Inject
	private CatchrateOverlay catchrateOverlay;

	@Getter
	private final Set<HunterTrap> traps = new HashSet<>();

	private double catchAtempts = 0;
	private double catchSuccess = 0;

	@Getter
	private Instant lastActionTime = Instant.ofEpochMilli(0);

	@Override
	public void configure(Binder binder)
	{
		binder.bind(TrapOverlay.class);
		binder.bind(CatchrateOverlay.class);
	}

	@Provides
	HunterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HunterConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(trapOverlay, catchrateOverlay);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!config.enabled())
		{
			return;
		}

		GameObject gameObject = event.getGameObject();

		HunterTrap myTrap = getTrapFromCollection(gameObject);

		Player localPlayer = client.getLocalPlayer();

		switch (gameObject.getId())
		{
			case ObjectID.DEADFALL: //Deadfall trap placed
				if (localPlayer.getWorldLocation().distanceTo(gameObject.getWorldLocation()) <= 2
					&& localPlayer.getAnimation() == AnimationID.HUNTER_LAY_DEADFALLTRAP)
				{
					log.debug("Deadfall trap placed by \"{}\" on {}", localPlayer.getName(), gameObject.getWorldLocation());
					traps.add(new HunterTrap(gameObject));
					lastActionTime = Instant.now();
				}
				break;
			case ObjectID.BOX_TRAP_9380: //Box trap placed
			case ObjectID.BIRD_SNARE_9345: //Bird snare placed
			case ObjectID.NET_TRAP_9343: //Net trap placed at green sallys
			case ObjectID.NET_TRAP: //Net trap placed at orange sallys
			case ObjectID.NET_TRAP_8992: //Net trap placed at red sallys
			case ObjectID.NET_TRAP_9002: //Net trap placed at black sallys
				//Look for players that are on the same tile
				PlayerQuery playerQuery = new PlayerQuery().atLocalLocation(gameObject.getLocalLocation());
				List<Player> possiblePlayers = Arrays.asList(queryRunner.runQuery(playerQuery));

				/* If the player is on that tile, and it has the correct animation, assume he is the one that placed the trap
                                 * Special case: if you herb+tar, then move and place the trap, it does not detect laying the trap. It does work
                                 * if you herb+tar en then place the trap.
				 */
				if (possiblePlayers.contains(localPlayer))
				{
					switch (localPlayer.getAnimation())
					{
						case AnimationID.HUNTER_LAY_BOXTRAP_BIRDSNARE:
						case AnimationID.HUNTER_LAY_NETTRAP:
						case AnimationID.HERBLORE_MAKE_TAR: // When 3 ticking
							log.debug("Trap placed by \"{}\" on {}", localPlayer.getName(), localPlayer.getWorldLocation());
							traps.add(new HunterTrap(gameObject));

							lastActionTime = Instant.now();
							break;
					}

				}
				break;
			case ObjectID.SHAKING_BOX: //Black chinchompa caught
			case ObjectID.SHAKING_BOX_9382: // Grey chinchompa caught
			case ObjectID.SHAKING_BOX_9383: //Red chinchompa caught
			case ObjectID.BOULDER_20648: //Prickly kebbit caught
			case ObjectID.BOULDER_20649: //Sabre-tooth kebbit caught
			case ObjectID.BOULDER_20650: //Barb-tailed kebbit caught
			case ObjectID.BOULDER_20651: //Wild kebbit caught
			case ObjectID.BIRD_SNARE_9373: //Crimson swift caught
			case ObjectID.BIRD_SNARE_9375: //Cerulean twitch caught
			case ObjectID.BIRD_SNARE_9377: //Golden warbler caught
			case ObjectID.BIRD_SNARE_9379: //Copper longtail caught
			case ObjectID.BIRD_SNARE_9348: //Tropical wagtail caught
			case ObjectID.NET_TRAP_9004: //Green sally caught
			case ObjectID.NET_TRAP_8986: //Red sally caught
			case ObjectID.NET_TRAP_8734: //Orange sally caught
			case ObjectID.NET_TRAP_8996: //Black sally caught
				if (myTrap != null)
				{
					log.debug("Yay, you caught something");
					myTrap.setState(HunterTrap.State.FULL);
					catchAtempts++;
					catchSuccess++;

					lastActionTime = Instant.now();
				}
				break;
			case ObjectID.BOX_TRAP_9385: //Empty box trap
			case ObjectID.BIRD_SNARE: //Empty box trap
				if (myTrap != null)
				{
					log.debug("Your trap didn't catch anything");
					myTrap.setState(HunterTrap.State.EMPTY);
					myTrap.resetTimer();
					catchAtempts++;

					lastActionTime = Instant.now();
				}
				break;
			//Black chin shaking box	
			case ObjectID.BOX_TRAP:
			case ObjectID.BOX_TRAP_2026:
			case ObjectID.BOX_TRAP_2028:
			case ObjectID.BOX_TRAP_2029:

			//Red chin shaking box
			case ObjectID.BOX_TRAP_9381:
			case ObjectID.BOX_TRAP_9390:
			case ObjectID.BOX_TRAP_9391:
			case ObjectID.BOX_TRAP_9392:
			case ObjectID.BOX_TRAP_9393:

			//Grey chin shaking box
			case ObjectID.BOX_TRAP_9386:
			case ObjectID.BOX_TRAP_9387:
			case ObjectID.BOX_TRAP_9388:

			//Bird traps
			case ObjectID.BIRD_SNARE_9346:
			case ObjectID.BIRD_SNARE_9347:
			case ObjectID.BIRD_SNARE_9349:
			case ObjectID.BIRD_SNARE_9374:
			case ObjectID.BIRD_SNARE_9376:
			case ObjectID.BIRD_SNARE_9378:

			//Deadfall trap
			case ObjectID.DEADFALL_19218:
			case ObjectID.DEADFALL_19851:
			case ObjectID.DEADFALL_20128:
			case ObjectID.DEADFALL_20129:
			case ObjectID.DEADFALL_20130:
			case ObjectID.DEADFALL_20131:

			//Net trap
			case ObjectID.NET_TRAP_9003:
			case ObjectID.NET_TRAP_9005:
			case ObjectID.NET_TRAP_8972:
			case ObjectID.NET_TRAP_8974:
			case ObjectID.NET_TRAP_8985:
			case ObjectID.NET_TRAP_8987:
			case ObjectID.NET_TRAP_8993:
			case ObjectID.NET_TRAP_8997:
				if (myTrap != null)
				{
					myTrap.setState(HunterTrap.State.TRANSITION);
				}
				break;
		}
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState().equals(GameState.LOGIN_SCREEN))
		{
			trapOverlay.updateConfig();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("hunterplugin"))
		{
			trapOverlay.updateConfig();
		}
	}

	/**
	 * Iterates over all the traps that were placed by the local player and
	 * checks if the trap is still there. If the trap is gone, it removes
	 * the trap from the local players trap collection.
	 */
	@Schedule(
		period = 500,
		unit = ChronoUnit.MILLIS
	)
	public void updateTraps()
	{
		if (!config.enabled())
		{
			return;
		}

		//Check if all traps are still there, and remove the ones that are not.
		//TODO: use despawn events
		Iterator<HunterTrap> it = traps.iterator();
		while (it.hasNext())
		{
			HunterTrap trap = it.next();

			//Look for gameobjects that are on the same location as the trap
			GameObjectQuery goQuery = new GameObjectQuery()
				.atWorldLocation(trap.getGameObject().getWorldLocation());
			//This is for placeable traps like box traps. There are no gameobjects on that location if the trap collapsed
			if (queryRunner.runQuery(goQuery).length == 0)
			{
				it.remove();
				log.debug("Trap removed from personal trap collection, {} left", traps.size());
			}
			else //For traps like deadfalls. This is different because when the trap is gone, there is still a GameObject (boulder)
			{
				goQuery = goQuery
					.idEquals(ObjectID.BOULDER_19215); //Deadfalls are the only ones (that i can test) that have this behaviour. I think maniacal monkeys have this too.
				if (queryRunner.runQuery(goQuery).length != 0)
				{
					it.remove();
					log.debug("Special trap removed from personal trap collection, {} left", traps.size());
				}
			}
		}

	}

	/**
	 * Looks for a trap in the local players trap collection, on the same
	 * place as the given GameObject.
	 *
	 * @param gameObject
	 * @return A HunterTrap object if the player has a trap on the same
	 * location as the GameObject. Otherwise it returns null.
	 */
	private HunterTrap getTrapFromCollection(GameObject gameObject)
	{
		Point gameObjectLocation = gameObject.getWorldLocation();
		for (HunterTrap trap : traps)
		{
			if (gameObjectLocation.equals(trap.getGameObject().getWorldLocation()))
			{
				return trap;
			}
		}
		return null;
	}

	/**
	 * Calculates the catch rate, i.e. the attempts to catch something
	 * compared to the times you succeed.
	 *
	 * @return Value between 0 (none) and 1 (all).
	 */
	public double getCatchRate()
	{
		return catchAtempts != 0 ? catchSuccess / catchAtempts : 0;
	}

}
