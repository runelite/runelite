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

import javax.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Scene;
import net.runelite.api.WorldView;

/**
 * A two-dimensional point in the local coordinate space.
 * <p>
 * Local points are immutable, however since the local coordinate space moves,
 * it is not safe to keep a LocalPoint after a loading zone.
 * <p>
 * The unit of a LocalPoint is 1/128th of a tile.
 */
@Value
@RequiredArgsConstructor
public class LocalPoint
{
	/**
	 * X and Y axis coordinates.
	 */
	private final int x, y;
	private final int worldView;

	public LocalPoint(int x, int y, WorldView wv)
	{
		this(x, y, wv.getId());
	}

	@Deprecated
	public LocalPoint(int x, int y)
	{
		this(x, y, -1);
	}

	@Nullable
	@Deprecated
	public static LocalPoint fromWorld(Client client, WorldPoint world)
	{
		return fromWorld(client.getTopLevelWorldView(), world);
	}

	/**
	 * Gets the local coordinate at the center of the passed tile.
	 *
	 * @return coordinate if the tile is in the world view, otherwise null
	 */
	@Nullable
	public static LocalPoint fromWorld(WorldView wv, WorldPoint world)
	{
		if (wv.getPlane() != world.getPlane())
		{
			return null;
		}
		return fromWorld(wv, world.getX(), world.getY());
	}

	@Deprecated
	@Nullable
	public static LocalPoint fromWorld(Client client, int x, int y)
	{
		return fromWorld(client.getTopLevelWorldView(), x, y);
	}

	/**
	 * Gets the local coordinate at the center of the passed tile.
	 *
	 * @param wv     the scene
	 * @param x      x-axis coordinate of the tile
	 * @param y      y-axis coordinate of the tile
	 * @return coordinate if the tile is in the current scene, otherwise null
	 */
	@Nullable
	public static LocalPoint fromWorld(WorldView wv, int x, int y)
	{
		if (!WorldPoint.isInScene(wv, x, y))
		{
			return null;
		}

		int baseX = wv.getBaseX();
		int baseY = wv.getBaseY();

		return fromScene(x - baseX, y - baseY, wv);
	}

	/**
	 * Gets the local coordinate at the center of the passed tile.
	 *
	 * @param scene  the scene
	 * @param x      x-axis coordinate of the tile
	 * @param y      y-axis coordinate of the tile
	 * @return coordinate if the tile is in the current scene, otherwise null
	 */
	@Nullable
	public static LocalPoint fromWorld(Scene scene, int x, int y)
	{
		if (!WorldPoint.isInScene(scene, x, y))
		{
			return null;
		}

		int baseX = scene.getBaseX();
		int baseY = scene.getBaseY();

		return fromScene(x - baseX, y - baseY, scene);
	}

	/**
	 * Gets the distance between this point and another.
	 *
	 * @param other other point
	 * @return the distance
	 */
	public int distanceTo(LocalPoint other)
	{
		if (worldView != other.worldView)
		{
			assert false;
			return Integer.MAX_VALUE;
		}

		return (int) Math.hypot(getX() - other.getX(), getY() - other.getY());
	}

	/**
	 * Test if this point is in the basic 104x104 tile scene.
	 * @return
	 */
	public boolean isInScene()
	{
		return x >= 0 && x < Perspective.SCENE_SIZE << Perspective.LOCAL_COORD_BITS
			&& y >= 0 && y < Perspective.SCENE_SIZE << Perspective.LOCAL_COORD_BITS;
	}

	/**
	 * Gets the coordinate at the center of the passed tile.
	 *
	 * @param x      x-axis coordinate of the tile in Scene coords
	 * @param y      y-axis coordinate of the tile in Scene coords
	 * @return true coordinate of the tile
	 */
	@Deprecated
	public static LocalPoint fromScene(int x, int y)
	{
		return new LocalPoint(
			(x << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1),
			(y << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1)
		);
	}

	/**
	 * Gets the coordinate at the center of the passed tile.
	 *
	 * @param x      x-axis coordinate of the tile in Scene coords
	 * @param y      y-axis coordinate of the tile in Scene coords
	 * @param scene  scene containing the tile
	 * @return true coordinate of the tile
	 */
	public static LocalPoint fromScene(int x, int y, Scene scene)
	{
		return new LocalPoint(
			(x << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1),
			(y << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1),
			scene.getWorldViewId()
		);
	}

	/**
	 * Gets the coordinate at the center of the passed tile.
	 *
	 * @param x      x-axis coordinate of the tile in Scene coords
	 * @param y      y-axis coordinate of the tile in Scene coords
	 * @param wv     wv containing the tile
	 * @return true coordinate of the tile
	 */
	public static LocalPoint fromScene(int x, int y, WorldView wv)
	{
		return new LocalPoint(
			(x << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1),
			(y << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1),
			wv.getId()
		);
	}

	/**
	 * Gets the x-axis coordinate in scene space (tiles).
	 *
	 * @return x-axis coordinate
	 */
	public int getSceneX()
	{
		return x >> Perspective.LOCAL_COORD_BITS;
	}

	/**
	 * Gets the y-axis coordinate in scene space (tiles).
	 *
	 * @return y-axis coordinate
	 */
	public int getSceneY()
	{
		return y >> Perspective.LOCAL_COORD_BITS;
	}

	public LocalPoint dx(int dx)
	{
		return plus(dx, 0);
	}

	public LocalPoint dy(int dy)
	{
		return plus(0, dy);
	}

	public LocalPoint plus(int dx, int dy)
	{
		return new LocalPoint(x + dx, y + dy, worldView);
	}
}
