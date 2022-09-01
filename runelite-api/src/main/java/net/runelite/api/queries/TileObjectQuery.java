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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import net.runelite.api.*;

public abstract class TileObjectQuery<EntityType extends TileObject & Locatable, QueryType> extends LocatableQuery<EntityType, QueryType>
{
	protected List<Tile> getTiles(Client client)
	{
		List<Tile> tilesList = new ArrayList<>();
		Scene scene = client.getScene();
		Tile[][][] tiles = scene.getTiles();
		int z = client.getPlane();
		for (int x = 0; x < Constants.SCENE_SIZE; ++x)
		{
			for (int y = 0; y < Constants.SCENE_SIZE; ++y)
			{
				Tile tile = tiles[z][x][y];
				if (tile == null)
				{
					continue;
				}
				tilesList.add(tile);
			}
		}
		return tilesList;
	}

	@SuppressWarnings("unchecked")
	public QueryType idEquals(int... ids)
	{
		predicate = and(object ->
		{
			for (int id : ids)
			{
				if (object.getId() == id)
				{
					return true;
				}
			}
			return false;
		});
		return (QueryType) this;
	}

	public QueryType nameEquals(String... names)
	{
		predicate = and(object ->
		{
			for (String name : names)
			{
				String objectName = object.getName();
				if (objectName != null && objectName.equals(name))
				{
					return true;
				}
			}
			return false;
		});
		return (QueryType) this;
	}

	public QueryType actionEquals(String... actions)
	{
		predicate = and(object ->
		{
			for (String action : actions)
			{
				String[] objectActions = object.getActions();
				for (String objectAction : objectActions)
				{
					if (objectAction != null && objectAction.equals(action))
					{
						return true;
					}
				}
			}
			return false;
		});
		return (QueryType) this;
	}

	@SuppressWarnings("unchecked")
	public QueryType idEquals(Collection<Integer> ids)
	{
		predicate = and((object) -> ids.contains(object.getId()));
		return (QueryType) this;
	}

	@SuppressWarnings("unchecked")
	public QueryType filter(Predicate<EntityType> other)
	{
		predicate = and(other);
		return (QueryType) this;
	}
}
