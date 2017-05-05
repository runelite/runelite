/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import java.util.Arrays;

public class Tile
{
	private final Client client;
	private final net.runelite.rs.api.Tile tile;

	public Tile(Client client, net.runelite.rs.api.Tile tile)
	{
		this.client = client;
		this.tile = tile;
	}

	/**
	 * Get the decorative object for this tile.
	 *
	 * @return
	 */
	public DecorativeObject getDecorativeObject()
	{
		net.runelite.rs.api.DecorativeObject decorativeObject = tile.getDecorativeObject();

		if (decorativeObject == null)
		{
			return null;
		}

		return new DecorativeObject(client, decorativeObject);
	}

	public GameObject[] getGameObjects()
	{
		net.runelite.rs.api.GameObject[] objects = tile.getObjects();

		if (objects == null)
		{
			return null;
		}

		return Arrays.stream(tile.getObjects())
				.map(go -> go != null ? new GameObject(client, go) : null)
				.toArray(i -> new GameObject[i]);
	}

	public ItemLayer getItemLayer()
	{
		net.runelite.rs.api.ItemLayer itemLayer = tile.getItemLayer();

		if (itemLayer == null)
		{
			return null;
		}

		return new ItemLayer(client, itemLayer);
	}

	public GroundObject getGroundObject()
	{
		net.runelite.rs.api.GroundObject groundObject = tile.getGroundObject();

		if (groundObject == null)
		{
			return null;
		}

		return new GroundObject(client, groundObject);
	}

	public WallObject getWallObject()
	{
		net.runelite.rs.api.WallObject wallObject = tile.getWallObject();

		if (wallObject == null)
		{
			return null;
		}

		return new WallObject(client, wallObject);
	}
}