/*
 * Copyright (c) 2018 Abex
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
package net.runelite.api.coords;

import lombok.Value;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;

/**
 * WorldPoint is a Three-Dimensional point representing the location of a Tile
 */
@Value
public class WorldPoint
{
	/**
	 * The X coordinate of the Point.
	 * Units are in tiles
	 */
	private final int x;

	/**
	 * The Y coordinate of the Point.
	 * Units are in tiles
	 */
	private final int y;

	/**
	 * The plane coordinate of the Point.
	 */
	private final int plane;

	/**
	 * Returns a WorldPoint offset on x from this point
	 * @param dx offset
	 * @return
	 */
	public WorldPoint dx(int dx)
	{
		return new WorldPoint(x + dx, y, plane);
	}

	/**
	 * Returns a WorldPoint offset on y from this point
	 * @param dy offset
	 * @return
	 */
	public WorldPoint dy(int dy)
	{
		return new WorldPoint(x, y + dy, plane);
	}

	/**
	 * Returns a WorldPoint offset on z from this point
	 * @param dz offset
	 * @return
	 */
	public WorldPoint dz(int dz)
	{
		return new WorldPoint(x, y, plane + dz);
	}

	public static boolean isInScene(Client client, int x, int y)
	{
		int baseX = client.getBaseX();
		int baseY = client.getBaseY();

		int maxX = baseX + Perspective.SCENE_SIZE;
		int maxY = baseY + Perspective.SCENE_SIZE;

		return x >= baseX && x < maxX && y >= baseY && y < maxY;
	}

	public boolean isInScene(Client client)
	{
		return client.getPlane() == plane && isInScene(client, x, y);
	}

	/**
	 * Returns a WorldPoint containing the passed LocalPoint
	 */
	public static WorldPoint fromLocal(Client client, LocalPoint local)
	{
		return fromLocal(client, local.getX(), local.getY(), client.getPlane());
	}

	/**
	 * Returns a WorldPoint containing the passed local coordinates
	 */
	public static WorldPoint fromLocal(Client client, int x, int y, int plane)
	{
		return new WorldPoint(
			(x >>> Perspective.LOCAL_COORD_BITS) + client.getBaseX(),
			(y >>> Perspective.LOCAL_COORD_BITS) + client.getBaseY(),
			plane
		);
	}

	/**
	 * Find the shortest distance from this point to a WorldArea
	 *
	 * @param other The WorldArea to find the distance to
	 * @return Returns the shortest distance
	 */
	public int distanceTo(WorldArea other)
	{
		return new WorldArea(this, 1, 1).distanceTo(other);
	}

	/**
	 * Find the distance from this point to another point. Returns Integer.MAX_VALUE if other is on
	 * a different plane.
	 *
	 * @param other
	 * @return
	 */
	public int distanceTo(WorldPoint other)
	{
		if (other.plane != plane)
		{
			return Integer.MAX_VALUE;
		}

		return distanceTo2D(other);
	}


	/**
	 * Find the distance from this point to another point.
	 *
	 * @param other
	 * @return
	 */
	public int distanceTo2D(WorldPoint other)
	{
		return Math.max(Math.abs(getX() - other.getX()), Math.abs(getY() - other.getY()));
	}

	/**
	 * Returns a WorldPoint from the passed region coords
	 */
	public static WorldPoint fromRegion(Client client, int x, int y, int plane)
	{
		return new WorldPoint(
			x + client.getBaseX(),
			y + client.getBaseY(),
			plane
		);
	}

	@Deprecated
	public Point toPoint()
	{
		return new Point(x, y);
	}

	public int getRegionID()
	{
		return ((x >> 6) << 8) | (y >> 6);
	}
}
