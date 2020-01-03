/*
 * Copyright (c) 2020, chestnut1693 <chestnut1693@gmail.com>
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
package net.runelite.client.plugins.raids.bats;

import java.util.Comparator;
import net.runelite.api.coords.WorldPoint;

public class WorldPointComparator implements Comparator<Chest>
{
	private int rotation;

	public WorldPointComparator(int rotation)
	{
		this.rotation = rotation;
	}

	@Override
	public int compare(Chest chestA, Chest chestB)
	{
		WorldPoint worldPointA = chestA.getLocation();
		WorldPoint worldPointB = chestB.getLocation();

		switch (rotation)
		{
			case 0:
				if (worldPointA.getY() < worldPointB.getY())
				{
					return -1;
				}
				else if (worldPointA.getY() > worldPointB.getY())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getX() < worldPointB.getX())
					{
						return -1;
					}
					if (worldPointA.getX() > worldPointB.getX())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			case 1:
				if (worldPointA.getX() < worldPointB.getX())
				{
					return -1;
				}
				else if (worldPointA.getX() > worldPointB.getX())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getY() > worldPointB.getY())
					{
						return -1;
					}
					if (worldPointA.getY() < worldPointB.getY())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			case 2:
				if (worldPointA.getY() > worldPointB.getY())
				{
					return -1;
				}
				else if (worldPointA.getY() < worldPointB.getY())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getX() > worldPointB.getX())
					{
						return -1;
					}
					if (worldPointA.getX() < worldPointB.getX())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			case 3:
				if (worldPointA.getX() > worldPointB.getX())
				{
					return -1;
				}
				else if (worldPointA.getX() < worldPointB.getX())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getY() < worldPointB.getY())
					{
						return -1;
					}
					if (worldPointA.getY() > worldPointB.getY())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
		}
		//This should never be reached.
		return 0;
	}
}
