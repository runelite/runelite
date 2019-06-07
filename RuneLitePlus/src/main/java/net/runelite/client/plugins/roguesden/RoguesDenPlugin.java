/*
 * Copyright (c) 2018-2019, Shaun Dreclin <https://github.com/ShaunDreclin>
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
package net.runelite.client.plugins.roguesden;

import java.util.HashMap;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import api.Client;
import api.GameState;
import api.InventoryID;
import api.Item;
import api.ItemID;
import api.Tile;
import api.TileObject;
import api.events.GameObjectChanged;
import api.events.GameObjectDespawned;
import api.events.GameObjectSpawned;
import api.events.GameStateChanged;
import api.events.GroundObjectChanged;
import api.events.GroundObjectDespawned;
import api.events.GroundObjectSpawned;
import api.events.ItemContainerChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Rogues' Den",
		description = "Mark tiles and clickboxes to help traverse the maze",
		tags = {"agility", "maze", "minigame", "overlay", "thieving"}
)
public class RoguesDenPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, Tile> obstaclesHull = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, Tile> obstaclesTile = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean hasGem;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RoguesDenOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		obstaclesHull.clear();
		obstaclesTile.clear();
		hasGem = false;
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		for (Item item : event.getItemContainer().getItems())
		{
			if (item.getId() == ItemID.MYSTIC_JEWEL)
			{
				hasGem = true;
				return;
			}
		}

		hasGem = false;
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGameObject());
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGameObject(), null);
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectChanged(GroundObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectDespawned(GroundObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGroundObject(), null);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			obstaclesHull.clear();
			obstaclesTile.clear();
		}
	}

	private void onTileObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		obstaclesHull.remove(oldObject);
		if (newObject != null && Obstacles.OBSTACLE_IDS_HULL.contains(newObject.getId()))
		{
			obstaclesHull.put(newObject, tile);
		}

		obstaclesTile.remove(oldObject);
		if (newObject != null && Obstacles.OBSTACLE_IDS_TILE.contains(newObject.getId()))
		{
			obstaclesTile.put(newObject, tile);
		}
	}
}