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
import lombok.Value;
import net.runelite.api.Client;
import net.runelite.api.Perspective;

/**
 * A LocolPoint is a Two-Dimensional point in the local coordinate space. Because the local coordinate space moves,
 * it is not safe to keep a LocalPoint after a loading zone. The unit is 1/128th of a Tile
 */
@Value
public class LocalPoint
{
	private final int x, y;

	/**
	 * Returns a LocalPoint of the center of the passed tile
	 *
	 * @return LocalPoint if in scene, otherwise null
	 */
	@Nullable
	public static LocalPoint fromWorld(Client client, WorldPoint world)
	{
		if (client.getPlane() != world.getPlane())
		{
			return null;
		}
		return fromWorld(client, world.getX(), world.getY());
	}

	/**
	 * Returns a LocalPoint of the center of the passed tile
	 *
	 * @return LocalPoint if in scene, otherwise null
	 */
	public static LocalPoint fromWorld(Client client, int x, int y)
	{
		if (!WorldPoint.isInScene(client, x, y))
		{
			return null;
		}

		int baseX = client.getBaseX();
		int baseY = client.getBaseY();

		return fromRegion(x - baseX, y - baseY);
	}

	/**
	 * Find the distance from this point to another point
	 *
	 * @param other
	 * @return
	 */
	public int distanceTo(LocalPoint other)
	{
		return (int) Math.hypot(getX() - other.getX(), getY() - other.getY());
	}

	/**
	 * Returns a LocalPoint of the center of the passed tile
	 */
	public static LocalPoint fromRegion(int x, int y)
	{
		return new LocalPoint(
			(x << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1) - 1,
			(y << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1) - 1
		);
	}

	/**
	 * Returns the X coordinate in Scene space (tiles)
	 */
	public int getRegionX()
	{
		return x >>> Perspective.LOCAL_COORD_BITS;
	}


	/**
	 * Returns the Y coordinate in Scene space (tiles)
	 */
	public int getRegionY()
	{
		return y >>> Perspective.LOCAL_COORD_BITS;
	}
}
