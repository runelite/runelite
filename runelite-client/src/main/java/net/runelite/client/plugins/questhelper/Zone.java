/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.questhelper;

import static net.runelite.api.Constants.REGION_SIZE;
import net.runelite.api.coords.WorldPoint;

public class Zone
{
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	private int minPlane = 0;
	private int maxPlane = 2;

	//The first plane of the "Overworld"
	public Zone()
	{
		minX = 1152;
		maxX = 3903;
		minY = 2496;
		maxY = 4159;
		maxPlane = 0;
	}

	public Zone(WorldPoint p1, WorldPoint p2)
	{
		minX = Math.min(p1.getX(), p2.getX());
		maxX = Math.max(p1.getX(), p2.getX());
		minY = Math.min(p1.getY(), p2.getY());
		maxY = Math.max(p1.getY(), p2.getY());
		minPlane = Math.min(p1.getPlane(), p2.getPlane());
		maxPlane = Math.max(p1.getPlane(), p2.getPlane());
	}

	public Zone(int regionID)
	{
		int regionX = (regionID >> 8) & 0xff;
		int regionY = regionID & 0xff;
		minX = regionX >> 6;
		maxX = minX + REGION_SIZE;
		minY = regionY >> 6;
		maxY = minY + REGION_SIZE;
	}

	public Zone(int regionID, int plane)
	{
		this(regionID);
		minPlane = plane;
		maxPlane = plane;
	}

	public boolean contains(WorldPoint worldPoint)
	{
		if (minX <= worldPoint.getX()
			&& worldPoint.getX() <= maxX
			&& minY <= worldPoint.getY()
			&& worldPoint.getY() <= maxY
			&& minPlane <= worldPoint.getPlane()
			&& worldPoint.getPlane() <= maxPlane)
		{
			return true;
		}

		return false;
	}
}
