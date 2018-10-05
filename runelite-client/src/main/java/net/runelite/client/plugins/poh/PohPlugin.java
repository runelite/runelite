/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.poh;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.ObjectID;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.HiscoreManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.Skill;

@PluginDescriptor(
	name = "Player-owned House",
	description = "Show minimap icons and mark unlit/lit burners",
	tags = {"construction", "poh", "minimap", "overlay"}
)

@Slf4j
public class PohPlugin extends Plugin
{
	private static final double ESTIMATED_TICK_LENGTH = 0.6;
	private final HiscoreClient hiscoreClient = new HiscoreClient();

	@Getter(AccessLevel.PACKAGE)
	private final Set<Integer> burnerUnlit = Sets.newHashSet(ObjectID.INCENSE_BURNER, ObjectID.INCENSE_BURNER_13210, ObjectID.INCENSE_BURNER_13212);

	@Getter(AccessLevel.PACKAGE)
	private final Set<Integer> burnerLit = Sets.newHashSet(ObjectID.INCENSE_BURNER_13209, ObjectID.INCENSE_BURNER_13211, ObjectID.INCENSE_BURNER_13213);

	@Getter(AccessLevel.PACKAGE)
	private double countdownTimer;

	@Getter(AccessLevel.PACKAGE)
	private double randomTimer;

	@Getter(AccessLevel.PACKAGE)
	private final Map<TileObject, Tile> pohObjects = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final Multimap<TileObject, Tile> burnerLocs =  ArrayListMultimap.create();

	@Getter(AccessLevel.PACKAGE)
	//Map for the timers that we know the length of
	private Map<Tile, Double> countdownTimerMap = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	//Map for the random timers we don't know the length of
	private Map<Tile, Double> randomTimerMap = new HashMap<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PohOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private HiscoreManager hiscoreManager;

	@Inject
	private BurnerOverlay burnerOverlay;

	@Provides
	PohConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PohConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(burnerOverlay);
		overlay.updateConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(burnerOverlay);
		pohObjects.clear();
		burnerLocs.clear();
		countdownTimerMap.clear();
		randomTimerMap.clear();
	}

	@Subscribe
	public void updateConfig(ConfigChanged event)
	{
		overlay.updateConfig();
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
		if (burnerLit.contains(gameObject.getId()) || burnerUnlit.contains(gameObject.getId()) || PohIcons.getIcon(gameObject.getId()) != null)
		{
			countdownTimer = 130.0; //Minimum amount of seconds a burner will light
			randomTimer = 30.0; //Minimum amount of seconds a burner will light
			pohObjects.put(gameObject, event.getTile());
			//Found a new burner in the POH (on load or on relight)
			if (burnerLit.contains(gameObject.getId()) ||  burnerUnlit.contains(gameObject.getId()))
			{
				countdownTimerMap.replace(event.getTile(), countdownTimer);
				randomTimerMap.replace(event.getTile(), randomTimer);
				log.debug("Setting burner at tile '{}' to '{}' seconds and '{}' random seconds", event.getTile().getWorldLocation(), countdownTimer, randomTimer);
				//Add burner to burnerLocs if it isn't already in there
				if (!burnerLocs.containsValue(event.getTile()))
				{
					burnerLocs.put(gameObject, event.getTile());
					//Add the new burner to timeMap and set secondsLeft
					countdownTimerMap.put(event.getTile(), countdownTimer);
					randomTimerMap.put(event.getTile(), randomTimer);
				}
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		//Countdown for both timers
		for (Tile t : countdownTimerMap.keySet())
		{
			double certainSec = countdownTimerMap.get(t);
			double certainNewSec = Math.max(certainSec - ESTIMATED_TICK_LENGTH, 0);
			countdownTimerMap.replace(t, certainSec, certainNewSec);
			if (certainNewSec == 0)
			{
				double randomSec = randomTimerMap.get(t);
				double randomNewSec = Math.max(randomSec - ESTIMATED_TICK_LENGTH, 0);
				randomTimerMap.replace(t, randomSec, randomNewSec);
			}
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();
		pohObjects.remove(gameObject);
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		if (PohIcons.getIcon(decorativeObject.getId()) != null)
		{
			pohObjects.put(decorativeObject, event.getTile());
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		pohObjects.remove(decorativeObject);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			pohObjects.clear();
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();
		String actorName = actor.getName();
		//Get actor who is doing light_burner anim
		if (actor.getAnimation() == AnimationID.INCENSE_BURNER)
		{
			if (actor == client.getLocalPlayer())
			{
				int level = client.getRealSkillLevel(net.runelite.api.Skill.FIREMAKING);
				countdownTimer = (200 + level) * ESTIMATED_TICK_LENGTH;
				randomTimer = level * ESTIMATED_TICK_LENGTH;
			}
			else try
			{
				//On initial lookup client will freeze for ~1 tick to generate HiscoreKey,
				//after that the hiscore lookup is mapped to a HiscoreKey (see HiscoreManager.java)
				HiscoreResult playerStats = hiscoreManager.lookup(actorName, HiscoreEndpoint.NORMAL);
				Skill fm = playerStats.getFiremaking();
				int level = fm.getLevel();
				log.debug("Succesfully looked up '{}' with firemaking level '{}'", actorName, level);
				//Burn time is : 200 + Fm level + (random number between 0 and Fm level) game ticks
				countdownTimer = (200 + level) * ESTIMATED_TICK_LENGTH;
				randomTimer = level * ESTIMATED_TICK_LENGTH;
			}
			catch (IOException ex)
			{
				log.debug("Unable to lookup '{}' : exeption '{}'", actorName, ex);
			}
		}
	}
}