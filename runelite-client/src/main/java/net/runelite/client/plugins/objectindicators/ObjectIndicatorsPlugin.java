/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.objectindicators;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Object Markers",
	description = "Enable marking of objects using the Shift key",
	tags = {"overlay", "objects", "mark", "marker"},
	enabledByDefault = false
)
@Slf4j
public class ObjectIndicatorsPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "objectindicators";
	private static final String MARK = "Mark object";
	private static final String UNMARK = "Unmark object";

	@Getter(AccessLevel.PACKAGE)
	private final List<ColorTileObject> objects = new ArrayList<>();
	private final Map<Integer, Set<ObjectPoint>> points = new HashMap<>();

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ObjectIndicatorsOverlay overlay;

	@Inject
	private ObjectIndicatorsConfig config;

	@Inject
	private Gson gson;

	@Provides
	ObjectIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ObjectIndicatorsConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		points.clear();
		objects.clear();
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		checkObjectPoints(event.getWallObject());
	}

	@Subscribe
	public void onWallObjectChanged(WallObjectChanged event)
	{
		WallObject previous = event.getPrevious();
		WallObject wallObject = event.getWallObject();

		objects.removeIf(o -> o.getTileObject() == previous);
		checkObjectPoints(wallObject);
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		objects.removeIf(o -> o.getTileObject() == event.getWallObject());
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		checkObjectPoints(event.getGameObject());
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		checkObjectPoints(event.getDecorativeObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		objects.removeIf(o -> o.getTileObject() == event.getGameObject());
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		objects.removeIf(o -> o.getTileObject() == event.getDecorativeObject());
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		checkObjectPoints(event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectDespawned(GroundObjectDespawned event)
	{
		objects.removeIf(o -> o.getTileObject() == event.getGroundObject());
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState gameState = gameStateChanged.getGameState();
		if (gameState == GameState.LOADING)
		{
			// Reload points with new map regions

			points.clear();
			for (int regionId : client.getMapRegions())
			{
				// load points for region
				final Set<ObjectPoint> regionPoints = loadPoints(regionId);
				if (regionPoints != null)
				{
					points.put(regionId, regionPoints);
				}
			}
		}

		if (gameStateChanged.getGameState() != GameState.LOGGED_IN && gameStateChanged.getGameState() != GameState.CONNECTION_LOST)
		{
			objects.clear();
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (event.getType() != MenuAction.EXAMINE_OBJECT.getId() || !client.isKeyPressed(KeyCode.KC_SHIFT))
		{
			return;
		}

		final Tile tile = client.getScene().getTiles()[client.getPlane()][event.getActionParam0()][event.getActionParam1()];
		final TileObject tileObject = findTileObject(tile, event.getIdentifier());

		if (tileObject == null)
		{
			return;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();
		menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);
		MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();
		menuEntry.setOption(objects.stream().anyMatch(o -> o.getTileObject() == tileObject) ? UNMARK : MARK);
		menuEntry.setTarget(event.getTarget());
		menuEntry.setParam0(event.getActionParam0());
		menuEntry.setParam1(event.getActionParam1());
		menuEntry.setIdentifier(event.getIdentifier());
		menuEntry.setType(MenuAction.RUNELITE.getId());
		client.setMenuEntries(menuEntries);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction() != MenuAction.RUNELITE
			|| !(event.getMenuOption().equals(MARK) || event.getMenuOption().equals(UNMARK)))
		{
			return;
		}

		Scene scene = client.getScene();
		Tile[][][] tiles = scene.getTiles();
		final int x = event.getActionParam();
		final int y = event.getWidgetId();
		final int z = client.getPlane();
		final Tile tile = tiles[z][x][y];

		TileObject object = findTileObject(tile, event.getId());
		if (object == null)
		{
			return;
		}

		// object.getId() is always the base object id, getObjectComposition transforms it to
		// the correct object we see
		ObjectComposition objectDefinition = getObjectComposition(object.getId());
		String name = objectDefinition.getName();
		// Name is probably never "null" - however prevent adding it if it is, as it will
		// become ambiguous as objects with no name are assigned name "null"
		if (Strings.isNullOrEmpty(name) || name.equals("null"))
		{
			return;
		}

		markObject(objectDefinition, name, object);
	}

	private void checkObjectPoints(TileObject object)
	{
		final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, object.getLocalLocation(), object.getPlane());
		final Set<ObjectPoint> objectPoints = points.get(worldPoint.getRegionID());

		if (objectPoints == null)
		{
			return;
		}

		for (ObjectPoint objectPoint : objectPoints)
		{
			if (worldPoint.getRegionX() == objectPoint.getRegionX()
					&& worldPoint.getRegionY() == objectPoint.getRegionY()
					&& worldPoint.getPlane() == objectPoint.getZ()
					&& objectPoint.getId() == object.getId())
			{
				log.debug("Marking object {} due to matching {}", object, objectPoint);
				objects.add(new ColorTileObject(object,
					client.getObjectDefinition(object.getId()),
					objectPoint.getName(),
					objectPoint.getColor()));
				break;
			}
		}
	}

	private TileObject findTileObject(Tile tile, int id)
	{
		if (tile == null)
		{
			return null;
		}

		final GameObject[] tileGameObjects = tile.getGameObjects();
		final DecorativeObject tileDecorativeObject = tile.getDecorativeObject();
		final WallObject tileWallObject = tile.getWallObject();
		final GroundObject groundObject = tile.getGroundObject();

		if (objectIdEquals(tileWallObject, id))
		{
			return tileWallObject;
		}

		if (objectIdEquals(tileDecorativeObject, id))
		{
			return tileDecorativeObject;
		}

		if (objectIdEquals(groundObject, id))
		{
			return groundObject;
		}

		for (GameObject object : tileGameObjects)
		{
			if (objectIdEquals(object, id))
			{
				return object;
			}
		}

		return null;
	}

	private boolean objectIdEquals(TileObject tileObject, int id)
	{
		if (tileObject == null)
		{
			return false;
		}

		if (tileObject.getId() == id)
		{
			return true;
		}

		// Menu action EXAMINE_OBJECT sends the transformed object id, not the base id, unlike
		// all of the GAME_OBJECT_OPTION actions, so check the id against the impostor ids
		final ObjectComposition comp = client.getObjectDefinition(tileObject.getId());

		if (comp.getImpostorIds() != null)
		{
			for (int impostorId : comp.getImpostorIds())
			{
				if (impostorId == id)
				{
					return true;
				}
			}
		}

		return false;
	}

	/** mark or unmark an object
	 *
	 * @param objectComposition transformed composition of object based on vars
	 * @param name name of objectComposition
	 * @param object tile object, for multilocs object.getId() is the base id
	 */
	private void markObject(ObjectComposition objectComposition, String name, final TileObject object)
	{
		final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, object.getLocalLocation());
		final int regionId = worldPoint.getRegionID();
		final Color color = config.markerColor();
		final ObjectPoint point = new ObjectPoint(
			object.getId(),
			name,
			regionId,
			worldPoint.getRegionX(),
			worldPoint.getRegionY(),
			worldPoint.getPlane(),
			color);

		Set<ObjectPoint> objectPoints = points.computeIfAbsent(regionId, k -> new HashSet<>());

		if (objects.removeIf(o -> o.getTileObject() == object))
		{
			// Find the object point that caused this object to be marked, there are two cases:
			// 1) object is a multiloc, the name may have changed since marking - match from base id
			// 2) not a multiloc, but an object has spawned with an identical name and a different
			//    id as what was originally marked
			if (!objectPoints.removeIf(op -> ((op.getId() == -1 || op.getId() == object.getId()) || op.getName().equals(objectComposition.getName()))
				&& op.getRegionX() == worldPoint.getRegionX()
				&& op.getRegionY() == worldPoint.getRegionY()
				&& op.getZ() == worldPoint.getPlane()))
			{
				log.warn("unable to find object point for unmarked object {}", object.getId());
			}

			log.debug("Unmarking object: {}", point);
		}
		else
		{
			objectPoints.add(point);
			objects.add(new ColorTileObject(object,
				client.getObjectDefinition(object.getId()),
				name,
				color));
			log.debug("Marking object: {}", point);
		}

		savePoints(regionId, objectPoints);
	}

	private void savePoints(final int id, final Set<ObjectPoint> points)
	{
		if (points.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, "region_" + id);
		}
		else
		{
			final String json = gson.toJson(points);
			configManager.setConfiguration(CONFIG_GROUP, "region_" + id, json);
		}
	}

	private Set<ObjectPoint> loadPoints(final int id)
	{
		final String json = configManager.getConfiguration(CONFIG_GROUP, "region_" + id);

		if (Strings.isNullOrEmpty(json))
		{
			return null;
		}

		Set<ObjectPoint> points = gson.fromJson(json, new TypeToken<Set<ObjectPoint>>()
		{
		}.getType());
		// Prior to multiloc support the plugin would mark objects named "null", which breaks
		// in most cases due to the specific object being identified being ambiguous, so remove
		// them
		return points.stream()
			.filter(point -> !point.getName().equals("null"))
			.collect(Collectors.toSet());
	}

	@Nullable
	private ObjectComposition getObjectComposition(int id)
	{
		ObjectComposition objectComposition = client.getObjectDefinition(id);
		return objectComposition.getImpostorIds() == null ? objectComposition : objectComposition.getImpostor();
	}
}