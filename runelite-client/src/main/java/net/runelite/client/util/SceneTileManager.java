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

import com.google.common.eventbus.EventBus;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.Node;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.WallObjectSpawned;

@Singleton
public class SceneTileManager
{
	private final EventBus eventBus = new EventBus();
	private final Client client;

	@Inject
	private SceneTileManager(Client client)
	{
		this.client = client;
	}

	/**
	 * Iterates over each tile in the scene if player is logged in
	 *
	 * @param consumer consumer accepting tile as parameter
	 */
	public void forEachTile(Consumer<Tile> consumer)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

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

	/**
	 * Simulate object spawns for EventBus subscriber
	 *
	 * @param subscriber EventBus subscriber
	 */
	public void simulateObjectSpawns(Object subscriber)
	{
		eventBus.register(subscriber);

		forEachTile((tile) ->
		{
			Optional.ofNullable(tile.getWallObject()).ifPresent(object ->
			{
				final WallObjectSpawned objectSpawned = new WallObjectSpawned();
				objectSpawned.setTile(tile);
				objectSpawned.setWallObject(object);
				eventBus.post(objectSpawned);
			});

			Optional.ofNullable(tile.getDecorativeObject()).ifPresent(object ->
			{
				final DecorativeObjectSpawned objectSpawned = new DecorativeObjectSpawned();
				objectSpawned.setTile(tile);
				objectSpawned.setDecorativeObject(object);
				eventBus.post(objectSpawned);
			});

			Optional.ofNullable(tile.getGroundObject()).ifPresent(object ->
			{
				final GroundObjectSpawned objectSpawned = new GroundObjectSpawned();
				objectSpawned.setTile(tile);
				objectSpawned.setGroundObject(object);
				eventBus.post(objectSpawned);
			});

			Arrays.stream(tile.getGameObjects())
				.filter(Objects::nonNull)
				.forEach(object ->
				{
					final GameObjectSpawned objectSpawned = new GameObjectSpawned();
					objectSpawned.setTile(tile);
					objectSpawned.setGameObject(object);
					eventBus.post(objectSpawned);
				});

			Optional.ofNullable(tile.getItemLayer()).ifPresent(itemLayer ->
			{
				Node current = itemLayer.getBottom();

				while (current instanceof Item)
				{
					final Item item = (Item) current;

					current = current.getNext();

					final ItemSpawned itemSpawned = new ItemSpawned(tile, item);
					eventBus.post(itemSpawned);
				}
			});
		});

		eventBus.unregister(subscriber);
	}
}
