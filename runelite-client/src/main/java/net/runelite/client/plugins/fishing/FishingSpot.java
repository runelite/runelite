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

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ItemID;
import static net.runelite.api.NpcID.*;

@Getter(AccessLevel.PACKAGE)
enum FishingSpot
{
	SHRIMP("Shrimp, Anchovies", ItemID.RAW_SHRIMPS,
		FISHING_SPOT_1514, FISHING_SPOT_1518, FISHING_SPOT_1521,
		FISHING_SPOT_1523, FISHING_SPOT_1524, FISHING_SPOT_1525,
		FISHING_SPOT_1528, FISHING_SPOT_1530, FISHING_SPOT_1544,
		FISHING_SPOT_3913, FISHING_SPOT_7155, FISHING_SPOT_7459,
		FISHING_SPOT_7462, FISHING_SPOT_7467, FISHING_SPOT_7469,
		FISHING_SPOT_7947
	),
	LOBSTER("Lobster, Swordfish, Tuna", ItemID.RAW_LOBSTER,
		FISHING_SPOT_1510, FISHING_SPOT_1519, FISHING_SPOT_1522,
		FISHING_SPOT_3914, FISHING_SPOT_5820, FISHING_SPOT_7199,
		FISHING_SPOT_7460, FISHING_SPOT_7465, FISHING_SPOT_7470,
		FISHING_SPOT_7946
	),
	SHARK("Shark, Bass", ItemID.RAW_SHARK,
		FISHING_SPOT_1511, FISHING_SPOT_1520, FISHING_SPOT_3915,
		FISHING_SPOT_4476, FISHING_SPOT_4477, FISHING_SPOT_5233,
		FISHING_SPOT_5234, FISHING_SPOT_5821, FISHING_SPOT_7200,
		FISHING_SPOT_7461, FISHING_SPOT_7466, FISHING_SPOT_8525,
		FISHING_SPOT_8526, FISHING_SPOT_8527
	),
	MONKFISH("Monkfish", ItemID.RAW_MONKFISH,
		FISHING_SPOT_4316
	),
	SALMON("Salmon, Trout", ItemID.RAW_SALMON,
		ROD_FISHING_SPOT, ROD_FISHING_SPOT_1508, ROD_FISHING_SPOT_1509,
		ROD_FISHING_SPOT_1513, ROD_FISHING_SPOT_1515, ROD_FISHING_SPOT_1516,
		ROD_FISHING_SPOT_1526, ROD_FISHING_SPOT_1527, ROD_FISHING_SPOT_7463,
		ROD_FISHING_SPOT_7464, ROD_FISHING_SPOT_7468, ROD_FISHING_SPOT_8524
	),
	LAVA_EEL("Lava eel", ItemID.LAVA_EEL,
		FISHING_SPOT_4928, FISHING_SPOT_6784
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
	),
	CAVE_EEL("Cave eel", ItemID.RAW_CAVE_EEL,
		FISHING_SPOT_1497, FISHING_SPOT_1498
	),
	SLIMY_EEL("Slimy eel", ItemID.RAW_SLIMY_EEL,
		FISHING_SPOT_2653, FISHING_SPOT_2654, FISHING_SPOT_2655
	),
	DARK_CRAB("Dark Crab", ItemID.RAW_DARK_CRAB,
		FISHING_SPOT_1536
	),
	COMMON_TENCH("Common tench, Bluegill, Greater siren, Mottled eel", ItemID.COMMON_TENCH,
		FISHING_SPOT_8523);

	private static final Map<Integer, FishingSpot> SPOTS;

	private final String name;
	private final int fishSpriteId;
	private final int[] ids;

	static
	{
		ImmutableMap.Builder<Integer, FishingSpot> builder = new ImmutableMap.Builder<>();

		for (FishingSpot spot : values())
		{
			for (int spotId : spot.getIds())
			{
				builder.put(spotId, spot);
			}
		}

		SPOTS = builder.build();
	}

	FishingSpot(String spot, int fishSpriteId, int... ids)
	{
		this.name = spot;
		this.fishSpriteId = fishSpriteId;
		this.ids = ids;
	}

	static FishingSpot findSpot(int id)
	{
		return SPOTS.get(id);
	}
}
