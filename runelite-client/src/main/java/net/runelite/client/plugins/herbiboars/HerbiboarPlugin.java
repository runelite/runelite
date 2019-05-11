/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.herbiboars;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import static net.runelite.api.ObjectID.DRIFTWOOD_30523;
import static net.runelite.api.ObjectID.MUSHROOM_30520;
import static net.runelite.api.ObjectID.ROCK_30519;
import static net.runelite.api.ObjectID.ROCK_30521;
import static net.runelite.api.ObjectID.ROCK_30522;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Herbiboar",
	description = "Highlight starting rocks, trails, and the objects to search at the end of each trail",
	tags = {"herblore", "hunter", "skilling", "overlay"}
)
public class HerbiboarPlugin extends Plugin
{
	private static final List<WorldPoint> END_LOCATIONS = Arrays.asList(
		new WorldPoint(3693, 3798, 0),
		new WorldPoint(3702, 3808, 0),
		new WorldPoint(3703, 3826, 0),
		new WorldPoint(3710, 3881, 0),
		new WorldPoint(3700, 3877, 0),
		new WorldPoint(3715, 3840, 0),
		new WorldPoint(3751, 3849, 0),
		new WorldPoint(3685, 3869, 0),
		new WorldPoint(3681, 3863, 0)
	);

	private static final List<Integer> START_OBJECT_IDS = Arrays.asList(
		ROCK_30519,
		MUSHROOM_30520,
		ROCK_30521,
		ROCK_30522,
		DRIFTWOOD_30523
	);

	private static final int[] HERBIBOAR_REGIONS = {
		14652,
		14651,
		14908,
		14907
	};

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private HerbiboarOverlay overlay;

	@Inject
	private HerbiboarMinimapOverlay minimapOverlay;

	@Getter
	private boolean inHerbiboarArea;

	@Getter
	private Map<WorldPoint, TileObject> trails = new HashMap<>();

	@Getter
	private Map<WorldPoint, TileObject> tunnels = new HashMap<>();

	@Getter
	private Map<WorldPoint, TileObject> starts = new HashMap<>();

	@Getter
	private Map<WorldPoint, TileObject> trailObjects = new HashMap<>();

	@Getter
	@Setter
	private Set<Integer> shownTrails = new HashSet<>();

	@Getter
	@Setter
	private HerbiboarTrail currentTrail;

	@Getter
	@Setter
	private int currentPath;

	@Getter
	@Setter
	private int finishId;

	@Provides
	HerbiboarConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HerbiboarConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(minimapOverlay);
		inHerbiboarArea = checkArea();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(minimapOverlay);
	}

	private void updateTrailData()
	{
		currentTrail = null;
		currentPath = -1;

		// Get trail data
		for (HerbiboarTrail trail : HerbiboarTrail.values())
		{
			int trailId = trail.getTrailId();
			int value = client.getVar(trail.getVarbit());

			if (value > 0)
			{
				shownTrails.add(trailId);
				shownTrails.add(trailId + 1);
			}
			if (value == 1 || value == 2)
			{
				currentTrail = trail;
				currentPath = value;
			}
		}

		// Get finish data
		finishId = client.getVar(Varbits.HB_FINISH);
		if (finishId > 0 && currentTrail != null)
		{
			shownTrails.add(currentTrail.getTrailId());
			shownTrails.add(currentTrail.getTrailId() + 1);
			currentTrail = null;
			currentPath = -1;
		}

		int started = client.getVar(Varbits.HB_STARTED);
		if (currentPath == -1 && finishId == 0 && started == 0)
		{
			resetTrailData();
		}
	}

	private void resetTrailData()
	{
		currentPath = 0;
		currentTrail = null;
		finishId = 0;
		shownTrails.clear();
	}

	private void clearCache()
	{
		starts.clear();
		trailObjects.clear();
		trails.clear();
		tunnels.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				resetTrailData();
				break;
			case LOADING:
				clearCache();
				inHerbiboarArea = checkArea();
				break;
			default:
				break;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (isInHerbiboarArea())
		{
			updateTrailData();
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		onGameObject(event.getTile(), null, event.getGameObject());
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		onGameObject(event.getTile(), event.getPrevious(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		onGameObject(event.getTile(), event.getGameObject(), null);
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		onGroundObject(event.getTile(), null, event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectChanged(GroundObjectChanged event)
	{
		onGroundObject(event.getTile(), event.getPrevious(), event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectDespawned(GroundObjectDespawned event)
	{
		onGroundObject(event.getTile(), event.getGroundObject(), null);
	}

	// Store relevant GameObjects (starts, objects used to trigger next trails, and some tunnels)
	private void onGameObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		if (oldObject != null)
		{
			WorldPoint oldLocation = oldObject.getWorldLocation();
			trailObjects.remove(oldLocation);
			tunnels.remove(oldLocation);
			starts.remove(oldLocation);
		}

		if (newObject == null)
		{
			return;
		}

		// Starts
		if (START_OBJECT_IDS.contains(newObject.getId()))
		{
			starts.put(newObject.getWorldLocation(), newObject);
			return;
		}

		// GameObject to trigger next trail (mushrooms, mud, seaweed, etc)
		if (HerbiboarTrail.getAllObjectLocs().contains(newObject.getWorldLocation()))
		{
			trailObjects.put(newObject.getWorldLocation(), newObject);
			return;
		}

		// Herbiboar tunnel
		if (END_LOCATIONS.contains(newObject.getWorldLocation()))
		{
			tunnels.put(newObject.getWorldLocation(), newObject);
		}
	}

	// Store relevant GroundObjects (tracks on trails, and some tunnels)
	private void onGroundObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		if (oldObject != null)
		{
			WorldPoint oldLocation = oldObject.getWorldLocation();
			trails.remove(oldLocation);
			tunnels.remove(oldLocation);
		}

		if (newObject == null)
		{
			return;
		}

		//Trails
		if (HerbiboarTrail.getTrailIds().contains(newObject.getId()))
		{
			trails.put(newObject.getWorldLocation(), newObject);
			return;
		}

		//Herbiboar tunnel
		if (END_LOCATIONS.contains(newObject.getWorldLocation()))
		{
			tunnels.put(newObject.getWorldLocation(), newObject);
		}
	}

	private boolean checkArea()
	{
		return client.getMapRegions() != null && Arrays.stream(client.getMapRegions())
				.filter(x -> Arrays.stream(HERBIBOAR_REGIONS).anyMatch(y -> y == x))
				.toArray().length > 0;
	}

	public List<WorldPoint> getEndLocations()
	{
		return END_LOCATIONS;
	}
}
