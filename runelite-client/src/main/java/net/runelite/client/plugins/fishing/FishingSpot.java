/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.fishing;

import java.util.HashMap;
import java.util.Map;

public enum  FishingSpot
{
	SHRIMP("Shrimp, Anchovies", "shrimp", new int[]{1518, 1525, 1528, 1530, 1544, 7155, 7469}),
	LOBSTER("Lobster, Swordfish, Tuna", "lobster", new int[]{1510, 1519, 1521, 1522, 7199, 7470}),
	SHARK("Shark, Bass", "shark", new int[]{1511, 1520, 7200}),
	MONKFISH("Monkfish", "monkfish", new int[]{4316}),
	SALMON("Salmon, Trout", "salmon", new int[]{1506, 1508, 1515, 1526, 1527, }),
	BARB_FISH("Sturgeon, Salmon, Trout", "barb", new int[]{1542}),
	ANGLERFISH("Anglerfish", "anglerfish", new int[]{6825}),
	MINNOW("Minnow", "minnow", new int[] {7730, 7731, 7732, 7733, 7734});

	public String name;
	public String image;
	public int[] spots;
	private static Map fishingSpots;

	static
	{
		fishingSpots = new HashMap();
		FishingSpot[] spots = values();
		int spotsSize = spots.length;

		for (FishingSpot spot : spots)
		{
			int[] spotIds = spot.getIds();
			int size = spot.getIds().length;

			for (int j = 0; j < size; ++j)
			{
				int spotID = spotIds[j];
				fishingSpots.put(spotID, spot);
			}
		}
	}

	FishingSpot(String spot, String image, int[] spots)
	{
		this.name = spot;
		this.image = image;
		this.spots = spots;
	}

	public String getName()
	{
		return name;
	}

	public String getImage()
	{
		return image;
	}

	public int[] getIds()
	{
		return spots;
	}

	public static FishingSpot getSpot(int id)
	{
		return (FishingSpot) fishingSpots.get(id);
	}
}
