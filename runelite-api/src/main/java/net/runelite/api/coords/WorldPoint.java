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
import static net.runelite.api.Constants.REGION_SIZE;
import static net.runelite.api.Constants.SCENE_SIZE;
import net.runelite.api.Perspective;
import net.runelite.api.Scene;
import net.runelite.api.WorldView;

/**
 * A three-dimensional point representing the coordinate of a Tile.
 * <p>
 * WorldPoints are immutable. Methods that modify the properties create a new
 * instance.
 */
@Value
public class WorldPoint
{
	private static final int[] REGION_MIRRORS = {
		// Prifddinas
		12894, 8755,
		12895, 8756,
		13150, 9011,
		13151, 9012
	};

	/**
	 * X-axis coordinate.
	 */
	private final int x;

	/**
	 * Y-axis coordinate.
	 */
	private final int y;

	/**
	 * The plane level of the Tile, also referred as z-axis coordinate.
	 */
	private final int plane;

	/**
	 * Offsets the x-axis coordinate by the passed value.
	 *
	 * @param dx the offset
	 * @return new instance
	 */
	public WorldPoint dx(int dx)
	{
		return new WorldPoint(x + dx, y, plane);
	}

	/**
	 * Offsets the y-axis coordinate by the passed value.
	 *
	 * @param dy the offset
	 * @return new instance
	 */
	public WorldPoint dy(int dy)
	{
		return new WorldPoint(x, y + dy, plane);
	}

	/**
	 * Offsets the plane by the passed value.
	 *
	 * @param dz the offset
	 * @return new instance
	 */
	public WorldPoint dz(int dz)
	{
		return new WorldPoint(x, y, plane + dz);
	}

	/**
	 * Checks whether a tile is located in the current scene.
	 *
	 * @param scene the scene
	 * @param x the tiles x coordinate
	 * @param y the tiles y coordinate
	 * @return true if the tile is in the scene, false otherwise
	 */
	public static boolean isInScene(Scene scene, int x, int y)
	{
		int baseX = scene.getBaseX();
		int baseY = scene.getBaseY();

		int maxX = baseX + Perspective.SCENE_SIZE;
		int maxY = baseY + Perspective.SCENE_SIZE;

		return x >= baseX && x < maxX && y >= baseY && y < maxY;
	}

	/**
	 * Checks whether a tile is located in the current scene.
	 *
	 * @param client the client
	 * @param x the tiles x coordinate
	 * @param y the tiles y coordinate
	 * @return true if the tile is in the scene, false otherwise
	 */
	@Deprecated
	public static boolean isInScene(Client client, int x, int y)
	{
		return isInScene(client.getTopLevelWorldView(), x, y);
	}

	/**
	 * Checks whether a tile is located in the current scene.
	 *
	 * @param wv the client
	 * @param x the tiles x coordinate
	 * @param y the tiles y coordinate
	 * @return true if the tile is in the scene, false otherwise
	 */
	public static boolean isInScene(WorldView wv, int x, int y)
	{
		int baseX = wv.getBaseX();
		int baseY = wv.getBaseY();

		int maxX = baseX + wv.getSizeX();
		int maxY = baseY + wv.getSizeY();

		return x >= baseX && x < maxX && y >= baseY && y < maxY;
	}

	/**
	 * Checks whether this tile is located in the current scene.
	 *
	 * @param client the client
	 * @return true if this tile is in the scene, false otherwise
	 */
	@Deprecated
	public boolean isInScene(Client client)
	{
		return client.getPlane() == plane && isInScene(client, x, y);
	}

	/**
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param client the client
	 * @param local the local coordinate
	 * @return the tile coordinate containing the local point
	 */
	public static WorldPoint fromLocal(Client client, LocalPoint local)
	{
		var wv = client.getWorldView(local.getWorldView());
		return fromLocal(wv, local.getX(), local.getY(), wv.getPlane());
	}

	/**
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param wv the scene
	 * @param x the local x-axis coordinate
	 * @param y the local x-axis coordinate
	 * @param plane the plane
	 * @return the tile coordinate containing the local point
	 */
	public static WorldPoint fromLocal(WorldView wv, int x, int y, int plane)
	{
		return new WorldPoint(
			(x >> Perspective.LOCAL_COORD_BITS) + wv.getBaseX(),
			(y >> Perspective.LOCAL_COORD_BITS) + wv.getBaseY(),
			plane
		);
	}

	/**
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param scene the scene
	 * @param x the local x-axis coordinate
	 * @param y the local x-axis coordinate
	 * @param plane the plane
	 * @return the tile coordinate containing the local point
	 */
	public static WorldPoint fromLocal(Scene scene, int x, int y, int plane)
	{
		return new WorldPoint(
			(x >> Perspective.LOCAL_COORD_BITS) + scene.getBaseX(),
			(y >> Perspective.LOCAL_COORD_BITS) + scene.getBaseY(),
			plane
		);
	}

	/**
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param client the client
	 * @param x the local x-axis coordinate
	 * @param y the local x-axis coordinate
	 * @param plane the plane
	 * @return the tile coordinate containing the local point
	 */
	@Deprecated
	public static WorldPoint fromLocal(Client client, int x, int y, int plane)
	{
		return fromLocal(client.getTopLevelWorldView(), x, y, plane);
	}

	/**
	 * Gets the coordinate of the tile that contains the passed local point,
	 * accounting for instances.
	 *
	 * @param client the client
	 * @param localPoint the local coordinate
	 * @return the tile coordinate containing the local point
	 */
	public static WorldPoint fromLocalInstance(Client client, LocalPoint localPoint)
	{
		var wv = client.getWorldView(localPoint.getWorldView());
		return fromLocalInstance(client, localPoint, wv.getPlane());
	}

	/**
	 * Gets the coordinate of the tile that contains the passed local point,
	 * accounting for instances.
	 *
	 * @param client the client
	 * @param localPoint the local coordinate
	 * @param plane the plane the localpoint is on
	 * @return the tile coordinate containing the local point
	 */
	public static WorldPoint fromLocalInstance(Client client, LocalPoint localPoint, int plane)
	{
		var wv = client.getWorldView(localPoint.getWorldView());

		if (wv.isInstance())
		{
			return fromLocalInstance(wv.getInstanceTemplateChunks(), localPoint, plane);
		}
		else
		{
			return fromLocal(client, localPoint.getX(), localPoint.getY(), plane);
		}
	}

	/**
	 * Gets the coordinate of the tile that contains the passed local point,
	 * accounting for instances.
	 *
	 * @param scene      the scene
	 * @param localPoint the local coordinate
	 * @param plane      the plane for the returned point, if it is not an instance
	 * @return the tile coordinate containing the local point
	 */
	public static WorldPoint fromLocalInstance(Scene scene, LocalPoint localPoint, int plane)
	{
		if (scene.isInstance())
		{
			return fromLocalInstance(scene.getInstanceTemplateChunks(), localPoint, plane);
		}
		else
		{
			return fromLocal(scene, localPoint.getX(), localPoint.getY(), plane);
		}
	}

	private static WorldPoint fromLocalInstance(int[][][] instanceTemplateChunks, LocalPoint localPoint, int plane)
	{
		// get position in the scene
		int sceneX = localPoint.getSceneX();
		int sceneY = localPoint.getSceneY();

		// get chunk from scene
		int chunkX = sceneX / CHUNK_SIZE;
		int chunkY = sceneY / CHUNK_SIZE;

		int templateChunk = -1;
		if (chunkX >= 0 && chunkX < (SCENE_SIZE / CHUNK_SIZE) && chunkY >= 0 && chunkY < (SCENE_SIZE / CHUNK_SIZE))
		{
			templateChunk = instanceTemplateChunks[plane][chunkX][chunkY];
		}

		int rotation = templateChunk >> 1 & 0x3;
		int templateChunkY = (templateChunk >> 3 & 0x7FF) * CHUNK_SIZE;
		int templateChunkX = (templateChunk >> 14 & 0x3FF) * CHUNK_SIZE;
		int templateChunkPlane = templateChunk >> 24 & 0x3;

		// calculate world point of the template
		int x = templateChunkX + (sceneX & (CHUNK_SIZE - 1));
		int y = templateChunkY + (sceneY & (CHUNK_SIZE - 1));

		// create and rotate point back to 0, to match with template
		return rotate(new WorldPoint(x, y, templateChunkPlane), 4 - rotation);
	}

	/**
	 * Get occurrences of a tile on the scene, accounting for instances. There may be
	 * more than one if the same template chunk occurs more than once on the scene.
	 */
	@Deprecated
	public static Collection<WorldPoint> toLocalInstance(Client client, WorldPoint worldPoint)
	{
		return toLocalInstance(client.getTopLevelWorldView(), worldPoint);
	}

	/**
	 * Get occurrences of a tile on the scene, accounting for instances. There may be
	 * more than one if the same template chunk occurs more than once on the scene.
	 */
	public static Collection<WorldPoint> toLocalInstance(WorldView wv, WorldPoint worldPoint)
	{
		if (wv.isInstance())
		{
			return toLocalInstance(wv.getInstanceTemplateChunks(), wv.getBaseX(), wv.getBaseY(), worldPoint);
		}
		else if (wv.contains(worldPoint))
		{
			return Collections.singleton(worldPoint);
		}
		else
		{
			return Collections.emptyList();
		}
	}

	/**
	 * Get occurrences of a tile on the scene, accounting for instances. There may be
	 * more than one if the same template chunk occurs more than once on the scene.
	 */
	@Deprecated
	public static Collection<WorldPoint> toLocalInstance(Scene scene, WorldPoint worldPoint)
	{
		if (scene.isInstance())
		{
			return toLocalInstance(scene.getInstanceTemplateChunks(), scene.getBaseX(), scene.getBaseY(), worldPoint);
		}
		else if (isInScene(scene, worldPoint.getX(), worldPoint.getY()))
		{
			return Collections.singleton(worldPoint);
		}
		else
		{
			return Collections.emptyList();
		}
	}

	private static Collection<WorldPoint> toLocalInstance(int[][][] instanceTemplateChunks, int baseX, int baseY, WorldPoint worldPoint)
	{
		// find instance chunks using the template point. there might be more than one.
		List<WorldPoint> worldPoints = new ArrayList<>();
		for (int z = 0; z < instanceTemplateChunks.length; z++)
		{
			for (int x = 0; x < instanceTemplateChunks[z].length; ++x)
			{
				for (int y = 0; y < instanceTemplateChunks[z][x].length; ++y)
				{
					int chunkData = instanceTemplateChunks[z][x][y];
					int rotation = chunkData >> 1 & 0x3;
					int templateChunkY = (chunkData >> 3 & 0x7FF) * CHUNK_SIZE;
					int templateChunkX = (chunkData >> 14 & 0x3FF) * CHUNK_SIZE;
					int plane = chunkData >> 24 & 0x3;
					if (worldPoint.getX() >= templateChunkX && worldPoint.getX() < templateChunkX + CHUNK_SIZE
						&& worldPoint.getY() >= templateChunkY && worldPoint.getY() < templateChunkY + CHUNK_SIZE
						&& plane == worldPoint.getPlane())
					{
						WorldPoint p = new WorldPoint(baseX + x * CHUNK_SIZE + (worldPoint.getX() & (CHUNK_SIZE - 1)),
							baseY + y * CHUNK_SIZE + (worldPoint.getY() & (CHUNK_SIZE - 1)),
							z);
						p = rotate(p, rotation);
						worldPoints.add(p);
					}
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
	 * Gets the shortest distance from this point to a WorldArea.
	 *
	 * @param other the world area
	 * @return the shortest distance
	 */
	public int distanceTo(WorldArea other)
	{
		return this.toWorldArea().distanceTo(other);
	}

	/**
	 * Gets the distance between this point and another.
	 * <p>
	 * If the other point is not on the same plane, this method will return
	 * {@link Integer#MAX_VALUE}. If ignoring the plane is wanted, use the
	 * {@link #distanceTo2D(WorldPoint)} method.
	 *
	 * @param other other point
	 * @return the distance
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
	 * <p>
	 * This method disregards the plane value of the two tiles and returns
	 * the simple distance between the X-Z coordinate pairs.
	 *
	 * @param other other point
	 * @return the distance
	 */
	public int distanceTo2D(WorldPoint other)
	{
		return Math.max(Math.abs(getX() - other.getX()), Math.abs(getY() - other.getY()));
	}

	@Deprecated
	public static WorldPoint fromScene(Client client, int x, int y, int plane)
	{
		return fromScene(client.getTopLevelWorldView(), x, y, plane);
	}

	/**
	 * Converts the passed scene coordinates to a world space
	 */
	public static WorldPoint fromScene(WorldView wv, int x, int y, int plane)
	{
		return new WorldPoint(
			x + wv.getBaseX(),
			y + wv.getBaseY(),
			plane
		);
	}

	/**
	 * Converts the passed scene coordinates to a world space
	 */
	public static WorldPoint fromScene(Scene scene, int x, int y, int plane)
	{
		return new WorldPoint(
			x + scene.getBaseX(),
			y + scene.getBaseY(),
			plane
		);
	}

	/**
	 * Gets the ID of the region containing this tile.
	 *
	 * @return the region ID
	 */
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
		return position & (REGION_SIZE - 1);
	}

	/**
	 * Translate a coordinate either between overworld and real, or real and overworld
	 *
	 * @param worldPoint
	 * @param toOverworld whether to convert to overworld coordinates, or to real coordinates
	 * @return
	 */
	public static WorldPoint getMirrorPoint(WorldPoint worldPoint, boolean toOverworld)
	{
		int region = worldPoint.getRegionID();
		for (int i = 0; i < REGION_MIRRORS.length; i += 2)
		{
			int real = REGION_MIRRORS[i];
			int overworld = REGION_MIRRORS[i + 1];

			// Test against what we are converting from
			if (region == (toOverworld ? real : overworld))
			{
				return fromRegion(toOverworld ? overworld : real,
					worldPoint.getRegionX(), worldPoint.getRegionY(), worldPoint.getPlane());
			}
		}
		return worldPoint;
	}

	/**
	 * Checks whether this tile is located within any of the given areas.
	 *
	 * @param worldAreas areas to check within
	 * @return {@code true} if any area contains this point, {@code false} otherwise.
	 */
	public boolean isInArea(WorldArea... worldAreas)
	{
		for (WorldArea area : worldAreas)
		{
			if (area.contains(this))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether this tile is located within any of the given areas, disregarding any plane differences.
	 *
	 * @param worldAreas areas to check within
	 * @return {@code true} if any area contains this point, {@code false} otherwise.
	 */
	public boolean isInArea2D(WorldArea... worldAreas)
	{
		for (WorldArea area : worldAreas)
		{
			if (area.contains2D(this))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves an area consisting of only this point.
	 *
	 * @return A {@link WorldArea} of width and height 1, encompassing only this point.
	 */
	public WorldArea toWorldArea()
	{
		return new WorldArea(this, 1, 1);
	}

	/**
	 * Create a WorldPoint from a packed Jagex coordinate
	 */
	public static WorldPoint fromCoord(int c)
	{
		return new WorldPoint((c >>> 14) & 0x3FFF, c & 0x3FFF, (c >>> 28) & 0x3);
	}
}
