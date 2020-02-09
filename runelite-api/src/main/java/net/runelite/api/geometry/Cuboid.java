/*
 * Copyright (c) 2020 ThatGamerBlue
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
package net.runelite.api.geometry;

import net.runelite.api.coords.WorldPoint;

public class Cuboid
{
	private WorldPoint southWest;
	private WorldPoint northEast;

	public Cuboid(int x1, int y1, int z1, int x2, int y2, int z2)
	{
		this(new WorldPoint(x1, y1, z1), new WorldPoint(x2, y2, z2));
	}

	public Cuboid(WorldPoint southWest, WorldPoint northEast)
	{
		this.southWest = southWest;
		this.northEast = northEast;
	}

	public boolean contains(WorldPoint worldPoint)
	{
		if (worldPoint.getPlane() < southWest.getPlane() || worldPoint.getPlane() > northEast.getPlane())
		{
			return false;
		}
		if (worldPoint.getY() < southWest.getY() || worldPoint.getY() > northEast.getY())
		{
			return false;
		}
		return worldPoint.getX() >= southWest.getX() && worldPoint.getX() <= northEast.getX();
	}
}
