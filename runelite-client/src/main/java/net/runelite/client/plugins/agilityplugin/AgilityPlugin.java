/*
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
package net.runelite.client.plugins.agilityplugin;

import com.google.common.eventbus.Subscribe;
import java.util.HashMap;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameState;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.events.DecorativeObjectChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Agility"
)
@Slf4j
public class AgilityPlugin extends Plugin
{
	@Getter
	private final HashMap<TileObject, Tile> obstacles = new HashMap<>();

	@Inject
	@Getter
	private AgilityOverlay overlay;

	@Override
	protected void shutDown() throws Exception
	{
		obstacles.clear();
	}

	// This code, brought to you, in part, by the letters C and V
	// ... and the words "search" and "replace"
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
	public void onGameObjectDeSpawned(GameObjectDespawned event)
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
	public void onGroundObjectDeSpawned(GroundObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGroundObject(), null);
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getWallObject());
	}

	@Subscribe
	public void onWallObjectChanged(WallObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getWallObject());
	}

	@Subscribe
	public void onWallObjectDeSpawned(WallObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getWallObject(), null);
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectChanged(DecorativeObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectDeSpawned(DecorativeObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getDecorativeObject(), null);
	}

	private void onTileObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		obstacles.remove(oldObject);

		if (newObject != null && Obstacles.OBSTACLE_IDS.contains(newObject.getId()))
		{
			obstacles.put(newObject, tile);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			obstacles.clear();
		}
	}

}
