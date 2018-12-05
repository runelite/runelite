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
package net.runelite.client.plugins.roguesden;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.MYSTIC_JEWEL;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
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

	@Schedule(period = 600, unit = ChronoUnit.MILLIS)
	public void checkGem()
	{
		hasGem = hasGem();
	}

	private boolean hasGem()
	{
		ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);
		if (container == null)
		{
			return false;
		}

		for (Item item : container.getItems())
		{
			if (item.getId() == MYSTIC_JEWEL)
			{
				return true;
			}
		}

		return false;
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
