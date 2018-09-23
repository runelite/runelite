/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.api.queries;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Used for getting game objects in view,deprecated as of existence of GameObject spawn events
 *
 * @see net.runelite.api.events.GameObjectSpawned
 * @see net.runelite.api.events.GameObjectDespawned
 * @see net.runelite.api.events.GameObjectChanged
 */
@Deprecated
public class GameObjectQuery extends TileObjectQuery<GameObject, GameObjectQuery>
{
	@Override
	public GameObject[] result(Client client)
	{
		return getGameObjects(client).stream()
			.filter(Objects::nonNull)
			.filter(predicate)
			.distinct()
			.toArray(GameObject[]::new);
	}

	private Collection<GameObject> getGameObjects(Client client)
	{
		Collection<GameObject> objects = new ArrayList<>();
		for (Tile tile : getTiles(client))
		{
			GameObject[] gameObjects = tile.getGameObjects();
			if (gameObjects != null)
			{
				objects.addAll(Arrays.asList(gameObjects));
			}
		}
		return objects;
	}
}
