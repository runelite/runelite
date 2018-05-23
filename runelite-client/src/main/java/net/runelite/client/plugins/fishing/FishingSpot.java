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
import net.runelite.api.ItemID;
import static net.runelite.api.NpcID.FISHING_SPOT_1510;
import static net.runelite.api.NpcID.FISHING_SPOT_1511;
import static net.runelite.api.NpcID.FISHING_SPOT_1518;
import static net.runelite.api.NpcID.FISHING_SPOT_1519;
import static net.runelite.api.NpcID.FISHING_SPOT_1520;
import static net.runelite.api.NpcID.FISHING_SPOT_1521;
import static net.runelite.api.NpcID.FISHING_SPOT_1522;
import static net.runelite.api.NpcID.FISHING_SPOT_1523;
import static net.runelite.api.NpcID.FISHING_SPOT_1525;
import static net.runelite.api.NpcID.FISHING_SPOT_1528;
import static net.runelite.api.NpcID.FISHING_SPOT_1530;
import static net.runelite.api.NpcID.FISHING_SPOT_1542;
import static net.runelite.api.NpcID.FISHING_SPOT_1544;
import static net.runelite.api.NpcID.FISHING_SPOT_3913;
import static net.runelite.api.NpcID.FISHING_SPOT_3914;
import static net.runelite.api.NpcID.FISHING_SPOT_3915;
import static net.runelite.api.NpcID.FISHING_SPOT_4316;
import static net.runelite.api.NpcID.FISHING_SPOT_4710;
import static net.runelite.api.NpcID.FISHING_SPOT_4712;
import static net.runelite.api.NpcID.FISHING_SPOT_4713;
import static net.runelite.api.NpcID.FISHING_SPOT_5233;
import static net.runelite.api.NpcID.FISHING_SPOT_5234;
import static net.runelite.api.NpcID.FISHING_SPOT_6488;
import static net.runelite.api.NpcID.FISHING_SPOT_7155;
import static net.runelite.api.NpcID.FISHING_SPOT_7199;
import static net.runelite.api.NpcID.FISHING_SPOT_7200;
import static net.runelite.api.NpcID.FISHING_SPOT_7323;
import static net.runelite.api.NpcID.FISHING_SPOT_7469;
import static net.runelite.api.NpcID.FISHING_SPOT_7470;
import static net.runelite.api.NpcID.FISHING_SPOT_7730;
import static net.runelite.api.NpcID.FISHING_SPOT_7731;
import static net.runelite.api.NpcID.FISHING_SPOT_7732;
import static net.runelite.api.NpcID.FISHING_SPOT_7733;
import static net.runelite.api.NpcID.FISHING_SPOT_7946;
import static net.runelite.api.NpcID.FISHING_SPOT_7947;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_1508;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_1509;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_1513;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_1515;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_1526;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_1527;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_6825;
import static net.runelite.api.NpcID.ROD_FISHING_SPOT_7676;

public enum FishingSpot
{
	SHRIMP("Shrimp, Anchovies", ItemID.RAW_SHRIMPS,
		FISHING_SPOT_1518, FISHING_SPOT_1521, FISHING_SPOT_1525,
		FISHING_SPOT_1528, FISHING_SPOT_1530, FISHING_SPOT_1544,
		FISHING_SPOT_3913, FISHING_SPOT_7155, FISHING_SPOT_7469,
		FISHING_SPOT_7947, FISHING_SPOT_1523
	),
	LOBSTER("Lobster, Swordfish, Tuna", ItemID.RAW_LOBSTER,
		FISHING_SPOT_1510, FISHING_SPOT_1519, FISHING_SPOT_1522,
		FISHING_SPOT_3914, FISHING_SPOT_7199, FISHING_SPOT_7470,
		FISHING_SPOT_7946
	),
	SHARK("Shark, Bass", ItemID.RAW_SHARK,
		FISHING_SPOT_1511, FISHING_SPOT_1520, FISHING_SPOT_3915,
		FISHING_SPOT_7200, FISHING_SPOT_5233, FISHING_SPOT_5234
	),
	MONKFISH("Monkfish", ItemID.RAW_MONKFISH,
		FISHING_SPOT_4316
	),
	SALMON("Salmon, Trout", ItemID.RAW_SALMON,
		ROD_FISHING_SPOT, ROD_FISHING_SPOT_1508, ROD_FISHING_SPOT_1509,
		ROD_FISHING_SPOT_1513, ROD_FISHING_SPOT_1515, ROD_FISHING_SPOT_1526,
		ROD_FISHING_SPOT_1527
	),
	BARB_FISH("Sturgeon, Salmon, Trout", ItemID.LEAPING_STURGEON,
		FISHING_SPOT_1542, FISHING_SPOT_7323
	),
	ANGLERFISH("Anglerfish", ItemID.RAW_ANGLERFISH,
		ROD_FISHING_SPOT_6825
	),
	MINNOW("Minnow", ItemID.MINNOW,
		FISHING_SPOT_7730, FISHING_SPOT_7731, FISHING_SPOT_7732, FISHING_SPOT_7733
	),
	INFERNAL_EEL("Infernal Eel", ItemID.INFERNAL_EEL,
		ROD_FISHING_SPOT_7676
	),
	KARAMBWAN("Karambwan", ItemID.RAW_KARAMBWAN,
		FISHING_SPOT_4712, FISHING_SPOT_4713
	),
	KARAMBWANJI("Karambwanji, Shrimp", ItemID.KARAMBWANJI,
		FISHING_SPOT_4710
	),
	SACRED_EEL("Sacred eel", ItemID.SACRED_EEL,
		FISHING_SPOT_6488
	);

	private static final Map<Integer, FishingSpot> fishingSpots = new HashMap<>();

	private final String name;
	private final int fishSpriteId;
	private final int[] spots;

	static
	{
		FishingSpot[] spots = values();

		for (FishingSpot spot : spots)
		{
			for (int spotId : spot.getIds())
			{
				fishingSpots.put(spotId, spot);
			}
		}
	}

	FishingSpot(String spot, int fishSpriteId, int... spots)
	{
		this.name = spot;
		this.fishSpriteId = fishSpriteId;
		this.spots = spots;
	}

	public String getName()
	{
		return name;
	}

	public int getFishSpriteId()
	{
		return fishSpriteId;
	}

	public int[] getIds()
	{
		return spots;
	}

	public static FishingSpot getSpot(int npcId)
	{
		return fishingSpots.get(npcId);
	}
}
