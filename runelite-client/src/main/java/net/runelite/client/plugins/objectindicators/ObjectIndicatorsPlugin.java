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
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.Constants.REGION_SIZE;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.MenuOpcode;
import net.runelite.api.MenuEntry;
import net.runelite.api.ObjectDefinition;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Object Markers",
	description = "Enable marking of objects using the Shift key",
	tags = {"overlay", "objects", "mark", "marker"},
	enabledByDefault = false
)
@Singleton
public class ObjectIndicatorsPlugin extends Plugin implements KeyListener
{
	private static final String CONFIG_GROUP = "objectindicators";
	private static final String MARK = "Mark object";
	private static final String UNMARK = "Unmark object";

	private final Gson GSON = new Gson();
	@Getter(AccessLevel.PACKAGE)
	private final List<TileObject> objects = new ArrayList<>();
	private final Map<Integer, Set<ObjectPoint>> points = new HashMap<>();
	private boolean hotKeyPressed;

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
	private KeyManager keyManager;

	@Inject
	private EventBus eventbus;

	@Getter(AccessLevel.PACKAGE)
	private RenderStyle objectMarkerRenderStyle;
	@Getter(AccessLevel.PACKAGE)
	private OutlineRenderStyle objectMarkerOutlineRenderStyle;
	@Getter(AccessLevel.PACKAGE)
	private Color objectMarkerColor;
	@Getter(AccessLevel.PACKAGE)
	private int objectMarkerAlpha;

	@Provides
	ObjectIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ObjectIndicatorsConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		keyManager.registerKeyListener(this);
	}

	@Override
	protected void shutDown()
	{
		eventbus.unregister(this);

		overlayManager.remove(overlay);
		keyManager.unregisterKeyListener(this);
		points.clear();
		objects.clear();
		hotKeyPressed = false;
	}

	private void addSubscriptions()
	{
		eventbus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventbus.subscribe(FocusChanged.class, this, this::onFocusChanged);
		eventbus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventbus.subscribe(DecorativeObjectSpawned.class, this, this::onDecorativeObjectSpawned);
		eventbus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventbus.subscribe(DecorativeObjectDespawned.class, this, this::onDecorativeObjectDespawned);
		eventbus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventbus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventbus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			hotKeyPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			hotKeyPressed = false;
		}
	}

	private void onFocusChanged(final FocusChanged event)
	{
		if (!event.isFocused())
		{
			hotKeyPressed = false;
		}
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject eventObject = event.getGameObject();
		checkObjectPoints(eventObject);
	}

	private void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		final DecorativeObject eventObject = event.getDecorativeObject();
		checkObjectPoints(eventObject);
	}

	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		objects.remove(event.getGameObject());
	}

	private void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		objects.remove(event.getDecorativeObject());
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
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

		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			objects.clear();
		}
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!hotKeyPressed || event.getOpcode() != MenuOpcode.EXAMINE_OBJECT.getId())
		{
			return;
		}

		final Tile tile = client.getScene().getTiles()[client.getPlane()][event.getParam0()][event.getParam1()];

		MenuEntry[] menuEntries = client.getMenuEntries();
		menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);
		MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();

		menuEntry.setOption(objects.contains(findTileObject(tile, event.getIdentifier())) ? UNMARK : MARK);
		menuEntry.setTarget(event.getTarget());
		menuEntry.setParam0(event.getParam0());
		menuEntry.setParam1(event.getParam1());
		menuEntry.setIdentifier(event.getIdentifier());
		menuEntry.setOpcode(MenuOpcode.RUNELITE.getId());
		client.setMenuEntries(menuEntries);
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuOpcode() != MenuOpcode.RUNELITE
			|| !(event.getOption().equals(MARK) || event.getOption().equals(UNMARK)))
		{
			return;
		}

		Scene scene = client.getScene();
		Tile[][][] tiles = scene.getTiles();
		final int x = event.getParam0();
		final int y = event.getParam1();
		final int z = client.getPlane();
		final Tile tile = tiles[z][x][y];

		TileObject object = findTileObject(tile, event.getIdentifier());
		if (object == null)
		{
			return;
		}

		ObjectDefinition objectDefinition = client.getObjectDefinition(object.getId());
		String name = objectDefinition.getName();
		if (Strings.isNullOrEmpty(name))
		{
			return;
		}

		markObject(name, object);
	}

	private void checkObjectPoints(TileObject object)
	{
		final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, object.getLocalLocation());
		final Set<ObjectPoint> objectPoints = points.get(worldPoint.getRegionID());

		if (objectPoints == null)
		{
			return;
		}

		for (ObjectPoint objectPoint : objectPoints)
		{
			if ((worldPoint.getX() & (REGION_SIZE - 1)) == objectPoint.getRegionX()
				&& (worldPoint.getY() & (REGION_SIZE - 1)) == objectPoint.getRegionY()
				&& objectPoint.getName().equals(client.getObjectDefinition(object.getId()).getName()))
			{
				objects.add(object);
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

		if (tileDecorativeObject != null && tileDecorativeObject.getId() == id)
		{
			return tileDecorativeObject;
		}

		for (GameObject object : tileGameObjects)
		{
			if (object == null)
			{
				continue;
			}

			if (object.getId() == id)
			{
				return object;
			}

			// Check impostors
			final ObjectDefinition comp = client.getObjectDefinition(object.getId());

			if (comp.getImpostorIds() != null)
			{
				for (int impostorId : comp.getImpostorIds())
				{
					if (impostorId == id)
					{
						return object;
					}
				}
			}
		}

		return null;
	}

	private void markObject(String name, final TileObject object)
	{
		if (object == null)
		{
			return;
		}

		final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, object.getLocalLocation());
		final int regionId = worldPoint.getRegionID();
		final ObjectPoint point = new ObjectPoint(
			name,
			regionId,
			worldPoint.getX() & (REGION_SIZE - 1),
			worldPoint.getY() & (REGION_SIZE - 1),
			client.getPlane());

		Set<ObjectPoint> objectPoints = points.computeIfAbsent(regionId, k -> new HashSet<>());

		if (objectPoints.contains(point))
		{
			objectPoints.remove(point);
			objects.remove(object);
		}
		else
		{
			objectPoints.add(point);
			objects.add(object);
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
			final String json = GSON.toJson(points);
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

		return GSON.fromJson(json, new TypeToken<Set<ObjectPoint>>()
		{
		}.getType());
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("objectindicators"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.objectMarkerRenderStyle = config.objectMarkerRenderStyle();
		this.objectMarkerOutlineRenderStyle = config.objectMarkerOutlineRenderStyle();
		this.objectMarkerColor = config.objectMarkerColor();
		this.objectMarkerAlpha = config.objectMarkerAlpha();
	}
}