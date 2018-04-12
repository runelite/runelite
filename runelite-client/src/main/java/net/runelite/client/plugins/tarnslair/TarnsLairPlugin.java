/*
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.tarnslair;

import com.google.common.eventbus.Subscribe;
import java.util.HashMap;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Tarn's Lair"
)
@Slf4j
public class TarnsLairPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, Tile> staircases = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, Tile> wallTraps = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, Tile> floorTraps = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean inLair;

	@Inject
	private Client client;

	@Inject
	@Getter
	private TarnsLairOverlay overlay;

	@Override
	protected void shutDown()
	{
		staircases.clear();
		wallTraps.clear();
		floorTraps.clear();
		inLair = false;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		//todo: get the current region id from somewhere else
		WorldPoint localWorld = client.getLocalPlayer().getWorldLocation();
		int regionX = localWorld.getX() >> 6;
		int regionY = localWorld.getY() >> 6;
		int regionID = regionX << 8 | regionY;

		if (regionID == 12615 || regionID == 12616)
		{
			inLair = true;
		}
		else
		{
			inLair = false;
		}
	}

	@Subscribe
	public void GameObjectSpawned(GameObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGameObject());
	}

	@Subscribe
	public void GameObjectChanged(GameObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGameObject());
	}

	@Subscribe
	public void GameObjectDespawned(GameObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGameObject(), null);
	}

	@Subscribe
	public void GroundObjectSpawned(GroundObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGroundObject());
	}

	@Subscribe
	public void GroundObjectChanged(GroundObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGroundObject());
	}

	@Subscribe
	public void GroundObjectDespawned(GroundObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGroundObject(), null);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			staircases.clear();
			wallTraps.clear();
			floorTraps.clear();
		}
	}

	private void onTileObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		staircases.remove(oldObject);
		if (newObject != null && Obstacles.STAIRCASE_IDS.contains(newObject.getId()))
		{
			staircases.put(newObject, tile);
		}

		wallTraps.remove(oldObject);
		if (newObject != null && Obstacles.WALL_TRAP_IDS.contains(newObject.getId()))
		{
			wallTraps.put(newObject, tile);
		}

		floorTraps.remove(oldObject);
		if (newObject != null && Obstacles.FLOOR_TRAP_IDS.contains(newObject.getId()))
		{
			floorTraps.put(newObject, tile);
		}
	}
}
