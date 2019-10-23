/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.TileItem;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Node;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.events.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;

@Singleton
public class GameEventManager
{
	private final EventBus eventBus = new EventBus();
	private final Client client;
	private final ClientThread clientThread;

	@Inject
	private GameEventManager(Client client, ClientThread clientThread)
	{
		this.client = client;
		this.clientThread = clientThread;
	}

	/**
	 * Iterates over each tile in the scene if player is logged in
	 *
	 * @param consumer consumer accepting tile as parameter
	 */
	private void forEachTile(Consumer<Tile> consumer)
	{
		final Scene scene = client.getScene();
		final Tile[][][] tiles = scene.getTiles();

		for (int z = 0; z < Constants.MAX_Z; ++z)
		{
			for (int x = 0; x < Constants.SCENE_SIZE; ++x)
			{
				for (int y = 0; y < Constants.SCENE_SIZE; ++y)
				{
					Tile tile = tiles[z][x][y];

					if (tile == null)
					{
						continue;
					}

					consumer.accept(tile);
				}
			}
		}
	}

	
	private void fireEventForEachInventoryUpdate(EventBus eventBus, InventoryID[] inventories)
	{
		for (final InventoryID inventory : inventories)
		{
			final ItemContainer itemContainer = client.getItemContainer(inventory);

			if (itemContainer != null)
			{
				eventBus.post(new ItemContainerChanged(inventory.getId(), itemContainer));
			}
		}
	}
	
	private void fireEventForEachNpcSpawn(EventBus eventBus, NPC[] npcs)
	{
		for (NPC npc : npcs)
		{
			if (npc != null)
			{
				final NpcSpawned npcSpawned = new NpcSpawned(npc);
				eventBus.post(npcSpawned);
			}
		}
	}
	
	private void fireEventForEachPlayerSpawn(EventBus eventBus, Player[] players)
	{
		for (Player player : players)
		{
			if (player != null)
			{
				final PlayerSpawned playerSpawned = new PlayerSpawned(player);
				eventBus.post(playerSpawned);
			}
		}
	}
	
	private void fireEventForWallObjectOnTile(EventBus eventBus, Tile tile)
	{
		 Optional.ofNullable(tile.getWallObject()).ifPresent(object ->
		{
			final WallObjectSpawned objectSpawned = new WallObjectSpawned();
			objectSpawned.setTile(tile);
			objectSpawned.setWallObject(object);
			eventBus.post(objectSpawned);
		});
	}
	
	private void fireEventForDecorativeObjectOnTile(EventBus eventBus, Tile tile)
	{
		Optional.ofNullable(tile.getDecorativeObject()).ifPresent(object ->
		{
			final DecorativeObjectSpawned objectSpawned = new DecorativeObjectSpawned();
			objectSpawned.setTile(tile);
			objectSpawned.setDecorativeObject(object);
			eventBus.post(objectSpawned);
		});
	}
	
	private void fireEventForEachGroundObjectOnTile(EventBus eventBus, Tile tile) 
	{
		Optional.ofNullable(tile.getGroundObject()).ifPresent(object ->
		{
			final GroundObjectSpawned objectSpawned = new GroundObjectSpawned();
			objectSpawned.setTile(tile);
			objectSpawned.setGroundObject(object);
			eventBus.post(objectSpawned);
		});
	}
	
	private void fireEventForEachGameObjectOnTile(EventBus eventBus, Tile tile)
	{
		Arrays.stream(tile.getGameObjects())
		.filter(Objects::nonNull)
		.forEach(object ->
		{
			final GameObjectSpawned objectSpawned = new GameObjectSpawned();
			objectSpawned.setTile(tile);
			objectSpawned.setGameObject(object);
			eventBus.post(objectSpawned);
		});
	}
	
	private void fireEventForEachTileItemSpawn(EventBus eventBus, Tile tile)
	{
		Optional.ofNullable(tile.getItemLayer()).ifPresent(itemLayer ->
		{
			Node current = itemLayer.getBottom();

			while (current instanceof TileItem)
			{
				final TileItem item = (TileItem) current;

				current = current.getNext();

				final ItemSpawned itemSpawned = new ItemSpawned(tile, item);
				eventBus.post(itemSpawned);
			}
		});
		
	}
	/**
	 * Simulate game events for EventBus subscriber
	 *
	 * @param plugin EventBus subscriber
	 */
	public void registerAllGameEvents(Plugin plugin)
	{
		if (!isLoggedIn())
		{
			return;
		}

		clientThread.invoke(() ->
		{

			eventBus.register(plugin);

			fireEventForEachInventoryUpdate(eventBus, InventoryID.values());
			fireEventForEachNpcSpawn(eventBus, client.getCachedNPCs());
			fireEventForEachPlayerSpawn(eventBus, client.getCachedPlayers());

			forEachTile(tile ->
			{
				fireEventForWallObjectOnTile(eventBus, tile);
				fireEventForDecorativeObjectOnTile(eventBus, tile);
				fireEventForEachGroundObjectOnTile(eventBus, tile);
				fireEventForEachGameObjectOnTile(eventBus, tile);
				fireEventForEachTileItemSpawn(eventBus, tile);
			});

			eventBus.unregister(plugin);
		});
	}
	
	private boolean isLoggedIn() {
		return client.getGameState() == GameState.LOGGED_IN;
	}
}