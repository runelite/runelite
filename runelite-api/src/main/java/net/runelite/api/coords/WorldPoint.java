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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.Value;
import net.runelite.api.Client;
import static net.runelite.api.Constants.CHUNK_SIZE;
import net.runelite.api.Perspective;

/**
<<<<<<< HEAD
 * WorldPoint is a Three-Dimensional point representing the location of a Tile
=======
 * A three-dimensional point representing the coordinate of a Tile.
 * <p>
 * WorldPoints are immutable. Methods that modify the properties create a new
 * instance.
>>>>>>> upstream/master
 */
@Value
public class WorldPoint
{
	/**
<<<<<<< HEAD
	 * The X coordinate of the Point.
	 * Units are in tiles
=======
	 * X-axis coordinate.
>>>>>>> upstream/master
	 */
	private final int x;

	/**
<<<<<<< HEAD
	 * The Y coordinate of the Point.
	 * Units are in tiles
=======
	 * Y-axis coordinate.
>>>>>>> upstream/master
	 */
	private final int y;

	/**
<<<<<<< HEAD
	 * The plane coordinate of the Point.
=======
	 * The plane level of the Tile, also referred as z-axis coordinate.
	 *
	 * @see Client#getPlane()
>>>>>>> upstream/master
	 */
	private final int plane;

	/**
<<<<<<< HEAD
	 * Returns a WorldPoint offset on x from this point
	 * @param dx offset
	 * @return
=======
	 * Offsets the x-axis coordinate by the passed value.
	 *
	 * @param dx the offset
	 * @return new instance
>>>>>>> upstream/master
	 */
	public WorldPoint dx(int dx)
	{
		return new WorldPoint(x + dx, y, plane);
	}

	/**
<<<<<<< HEAD
	 * Returns a WorldPoint offset on y from this point
	 * @param dy offset
	 * @return
=======
	 * Offsets the y-axis coordinate by the passed value.
	 *
	 * @param dy the offset
	 * @return new instance
>>>>>>> upstream/master
	 */
	public WorldPoint dy(int dy)
	{
		return new WorldPoint(x, y + dy, plane);
	}

	/**
<<<<<<< HEAD
	 * Returns a WorldPoint offset on z from this point
	 * @param dz offset
	 * @return
=======
	 * Offsets the plane by the passed value.
	 *
	 * @param dz the offset
	 * @return new instance
>>>>>>> upstream/master
	 */
	public WorldPoint dz(int dz)
	{
		return new WorldPoint(x, y, plane + dz);
	}

<<<<<<< HEAD
=======
	/**
	 * Checks whether a tile is located in the current scene.
	 *
	 * @param client the client
	 * @param x the tiles x coordinate
	 * @param y the tiles y coordinate
	 * @return true if the tile is in the scene, false otherwise
	 */
>>>>>>> upstream/master
	public static boolean isInScene(Client client, int x, int y)
	{
		int baseX = client.getBaseX();
		int baseY = client.getBaseY();

		int maxX = baseX + Perspective.SCENE_SIZE;
		int maxY = baseY + Perspective.SCENE_SIZE;

		return x >= baseX && x < maxX && y >= baseY && y < maxY;
	}

<<<<<<< HEAD
=======
	/**
	 * Checks whether this tile is located in the current scene.
	 *
	 * @param client the client
	 * @return true if this tile is in the scene, false otherwise
	 */
>>>>>>> upstream/master
	public boolean isInScene(Client client)
	{
		return client.getPlane() == plane && isInScene(client, x, y);
	}

	/**
<<<<<<< HEAD
	 * Returns a WorldPoint containing the passed LocalPoint
=======
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param client the client
	 * @param local the local coordinate
	 * @return the tile coordinate containing the local point
>>>>>>> upstream/master
	 */
	public static WorldPoint fromLocal(Client client, LocalPoint local)
	{
		return fromLocal(client, local.getX(), local.getY(), client.getPlane());
	}

	/**
<<<<<<< HEAD
	 * Returns a WorldPoint containing the passed local coordinates
=======
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param client the client
	 * @param x the local x-axis coordinate
	 * @param y the local x-axis coordinate
	 * @param plane the plane
	 * @return the tile coordinate containing the local point
>>>>>>> upstream/master
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
<<<<<<< HEAD
<<<<<<< HEAD
	 * Find the shortest distance from this point to a WorldArea
	 *
	 * @param other The WorldArea to find the distance to
	 * @return Returns the shortest distance
=======
=======
	 * Gets the coordinate of the tile that contains the passed local point,
	 * accounting for instances.
	 *
	 * @param client the client
	 * @param localPoint the local coordinate
	 * @return the tile coordinate containing the local point
	 */
	public static WorldPoint fromLocalInstance(Client client, LocalPoint localPoint)
	{
		if (client.isInInstancedRegion())
		{
			// get position in the scene
			int sceneX = localPoint.getSceneX();
			int sceneY = localPoint.getSceneY();

			// get chunk from scene
			int chunkX = sceneX / CHUNK_SIZE;
			int chunkY = sceneY / CHUNK_SIZE;

			// get the template chunk for the chunk
			int[][][] instanceTemplateChunks = client.getInstanceTemplateChunks();
			int templateChunk = instanceTemplateChunks[client.getPlane()][chunkX][chunkY];

			int rotation = templateChunk >> 1 & 0x3;
			int templateChunkY = (templateChunk >> 3 & 0x7FF) * CHUNK_SIZE;
			int templateChunkX = (templateChunk >> 14 & 0x3FF) * CHUNK_SIZE;
			int plane = templateChunk >> 24 & 0x3;

			// calculate world point of the template
			int x = templateChunkX + (sceneX & (CHUNK_SIZE - 1));
			int y = templateChunkY + (sceneY & (CHUNK_SIZE - 1));

			// create and rotate point back to 0, to match with template
			return rotate(new WorldPoint(x, y, plane), 4 - rotation);
		}
		else
		{
			return fromLocal(client, localPoint);
		}
	}

	/**
	 * Get occurrences of a tile on the scene, accounting for instances. There may be
	 * more than one if the same template chunk occurs more than once on the scene.
	 * @param client
	 * @param worldPoint
	 * @return
	 */
	public static Collection<WorldPoint> toLocalInstance(Client client, WorldPoint worldPoint)
	{
		if (!client.isInInstancedRegion())
		{
			return Collections.singleton(worldPoint);
		}

		// find instance chunks using the template point. there might be more than one.
		List<WorldPoint> worldPoints = new ArrayList<>();
		final int z = worldPoint.getPlane();
		int[][][] instanceTemplateChunks = client.getInstanceTemplateChunks();
		for (int x = 0; x < instanceTemplateChunks[z].length; ++x)
		{
			for (int y = 0; y < instanceTemplateChunks[z][x].length; ++y)
			{
				int chunkData = instanceTemplateChunks[z][x][y];
				int rotation = chunkData >> 1 & 0x3;
				int templateChunkY = (chunkData >> 3 & 0x7FF) * CHUNK_SIZE;
				int templateChunkX = (chunkData >> 14 & 0x3FF) * CHUNK_SIZE;
				if (worldPoint.getX() >= templateChunkX && worldPoint.getX() < templateChunkX + CHUNK_SIZE
					&& worldPoint.getY() >= templateChunkY && worldPoint.getY() < templateChunkY + CHUNK_SIZE)
				{
					WorldPoint p = new WorldPoint(client.getBaseX() + x * CHUNK_SIZE + (worldPoint.getX() & (CHUNK_SIZE - 1)),
						client.getBaseY() + y * CHUNK_SIZE + (worldPoint.getY() & (CHUNK_SIZE - 1)),
						worldPoint.getPlane());
					p = rotate(p, rotation);
					worldPoints.add(p);
				}
			}
		}
		return worldPoints;
	}

	/**
	 * Rotate the coordinates in the chunk according to chunk rotation
	 *
	 * @param point point
	 * @param rotation rotation
	 * @return world point
	 */
	private static WorldPoint rotate(WorldPoint point, int rotation)
	{
		int chunkX = point.getX() & ~(CHUNK_SIZE - 1);
		int chunkY = point.getY() & ~(CHUNK_SIZE - 1);
		int x = point.getX() & (CHUNK_SIZE - 1);
		int y = point.getY() & (CHUNK_SIZE - 1);
		switch (rotation)
		{
			case 1:
				return new WorldPoint(chunkX + y, chunkY + (CHUNK_SIZE - 1 - x), point.getPlane());
			case 2:
				return new WorldPoint(chunkX + (CHUNK_SIZE - 1 - x), chunkY + (CHUNK_SIZE - 1 - y), point.getPlane());
			case 3:
				return new WorldPoint(chunkX + (CHUNK_SIZE - 1 - y), chunkY + x, point.getPlane());
		}
		return point;
	}

	/**
>>>>>>> upstream/master
	 * Gets the shortest distance from this point to a WorldArea.
	 *
	 * @param other the world area
	 * @return the shortest distance
>>>>>>> upstream/master
	 */
	public int distanceTo(WorldArea other)
	{
		return new WorldArea(this, 1, 1).distanceTo(other);
	}

	/**
<<<<<<< HEAD
	 * Find the distance from this point to another point. Returns Integer.MAX_VALUE if other is on
	 * a different plane.
	 *
	 * @param other
	 * @return
=======
	 * Gets the distance between this point and another.
	 * <p>
	 * If the other point is not on the same plane, this method will return
	 * {@link Integer#MAX_VALUE}. If ignoring the plane is wanted, use the
	 * {@link #distanceTo2D(WorldPoint)} method.
	 *
	 * @param other other point
	 * @return the distance
>>>>>>> upstream/master
	 */
	public int distanceTo(WorldPoint other)
	{
		if (other.plane != plane)
		{
			return Integer.MAX_VALUE;
		}

		return distanceTo2D(other);
	}

<<<<<<< HEAD

	/**
	 * Find the distance from this point to another point.
	 *
	 * @param other
	 * @return
=======
	/**
	 * Find the distance from this point to another point.
	 * <p>
	 * This method disregards the plane value of the two tiles and returns
	 * the simple distance between the X-Z coordinate pairs.
	 *
	 * @param other other point
	 * @return the distance
>>>>>>> upstream/master
	 */
	public int distanceTo2D(WorldPoint other)
	{
		return Math.max(Math.abs(getX() - other.getX()), Math.abs(getY() - other.getY()));
	}

	/**
<<<<<<< HEAD
<<<<<<< HEAD
	 * Returns a WorldPoint from the passed region coords
=======
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param client the client
	 * @param x the local x-axis coordinate
	 * @param y the local x-axis coordinate
	 * @param plane the plane
	 * @return the tile coordinate containing the local point
>>>>>>> upstream/master
=======
	 * Converts the passed scene coordinates to a world space
>>>>>>> upstream/master
	 */
	public static WorldPoint fromScene(Client client, int x, int y, int plane)
	{
		return new WorldPoint(
			x + client.getBaseX(),
			y + client.getBaseY(),
			plane
		);
	}

<<<<<<< HEAD
	@Deprecated
	public Point toPoint()
	{
		return new Point(x, y);
	}

<<<<<<< HEAD
=======
=======
>>>>>>> upstream/master
	/**
	 * Gets the ID of the region containing this tile.
	 *
	 * @return the region ID
	 */
>>>>>>> upstream/master
	public int getRegionID()
	{
		return ((x >> 6) << 8) | (y >> 6);
	}

	/**
	 * Converts the passed region ID and coordinates to a world coordinate
	 */
	public static WorldPoint fromRegion(int regionId, int regionX, int regionY, int plane)
	{
		return new WorldPoint(
			((regionId >>> 8) << 6) + regionX,
			((regionId & 0xff) << 6) + regionY,
			plane);
	}

	/**
	 * Gets the X-axis coordinate of the region coordinate
	 */
	public int getRegionX()
	{
		return getRegionOffset(x);
	}

	/**
	 * Gets the Y-axis coordinate of the region coordinate
	 */
	public int getRegionY()
	{
		return getRegionOffset(y);
	}

	private static int getRegionOffset(final int position)
	{
		return position & 0x3f;
	}
}
