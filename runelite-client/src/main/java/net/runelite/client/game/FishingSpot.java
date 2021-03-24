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
package net.runelite.client.game;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;
import static net.runelite.api.NpcID.*;

@Getter
public enum FishingSpot
{
	SHRIMP("Shrimp, Anchovies", "Anchovies", ItemID.RAW_SHRIMPS,
		FISHING_SPOT_1514, FISHING_SPOT_1517, FISHING_SPOT_1518,
		FISHING_SPOT_1521, FISHING_SPOT_1523, FISHING_SPOT_1524,
		FISHING_SPOT_1525, FISHING_SPOT_1528, FISHING_SPOT_1530,
		FISHING_SPOT_1544, FISHING_SPOT_3913, FISHING_SPOT_7155,
		FISHING_SPOT_7459, FISHING_SPOT_7462, FISHING_SPOT_7467,
		FISHING_SPOT_7469, FISHING_SPOT_7947, FISHING_SPOT_10513
	),
	LOBSTER("Lobster, Swordfish, Tuna", "Lobster", ItemID.RAW_LOBSTER,
		FISHING_SPOT_1510, FISHING_SPOT_1519, FISHING_SPOT_1522,
		FISHING_SPOT_3914, FISHING_SPOT_5820, FISHING_SPOT_7199,
		FISHING_SPOT_7460, FISHING_SPOT_7465, FISHING_SPOT_7470,
		FISHING_SPOT_7946, FISHING_SPOT_9173, FISHING_SPOT_9174,
		FISHING_SPOT_10515, FISHING_SPOT_10635
	),
	SHARK("Shark, Bass", "Shark", ItemID.RAW_SHARK,
		FISHING_SPOT_1511, FISHING_SPOT_1520, FISHING_SPOT_3419,
		FISHING_SPOT_3915, FISHING_SPOT_4476, FISHING_SPOT_4477,
		FISHING_SPOT_5233, FISHING_SPOT_5234, FISHING_SPOT_5821,
		FISHING_SPOT_7200, FISHING_SPOT_7461, FISHING_SPOT_7466,
		FISHING_SPOT_8525, FISHING_SPOT_8526, FISHING_SPOT_8527,
		FISHING_SPOT_9171, FISHING_SPOT_9172, FISHING_SPOT_10514
	),
	MONKFISH("Monkfish", ItemID.RAW_MONKFISH,
		FISHING_SPOT_4316
	),
	SALMON("Salmon, Trout", "Salmon", ItemID.RAW_SALMON,
		ROD_FISHING_SPOT, ROD_FISHING_SPOT_1506, ROD_FISHING_SPOT_1507,
		ROD_FISHING_SPOT_1508, ROD_FISHING_SPOT_1509, ROD_FISHING_SPOT_1513,
		ROD_FISHING_SPOT_1515, ROD_FISHING_SPOT_1516, ROD_FISHING_SPOT_1526,
		ROD_FISHING_SPOT_1527, ROD_FISHING_SPOT_3417, ROD_FISHING_SPOT_3418,
		ROD_FISHING_SPOT_7463, ROD_FISHING_SPOT_7464, ROD_FISHING_SPOT_7468,
		ROD_FISHING_SPOT_8524
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
	HARPOONFISH("Harpoonfish", ItemID.RAW_HARPOONFISH,
		FISHING_SPOT_10565, FISHING_SPOT_10568, FISHING_SPOT_10569
	),
	INFERNAL_EEL("Infernal Eel", ItemID.INFERNAL_EEL,
		ROD_FISHING_SPOT_7676
	),
	KARAMBWAN("Karambwan", ItemID.RAW_KARAMBWAN,
		FISHING_SPOT_4712, FISHING_SPOT_4713
	),
	KARAMBWANJI("Karambwanji, Shrimp", "Karambwanji", ItemID.KARAMBWANJI,
		FISHING_SPOT_4710
	),
	SACRED_EEL("Sacred eel", ItemID.SACRED_EEL,
		FISHING_SPOT_6488
	),
	CAVE_EEL("Cave eel", ItemID.RAW_CAVE_EEL,
		FISHING_SPOT_1497, FISHING_SPOT_1498, FISHING_SPOT_1499
	),
	SLIMY_EEL("Slimy eel", ItemID.RAW_SLIMY_EEL,
		FISHING_SPOT_2653, FISHING_SPOT_2654, FISHING_SPOT_2655
	),
	DARK_CRAB("Dark Crab", ItemID.RAW_DARK_CRAB,
		FISHING_SPOT_1535, FISHING_SPOT_1536
	),
	COMMON_TENCH("Common tench, Bluegill, Greater siren, Mottled eel", "Greater siren", ItemID.COMMON_TENCH,
		FISHING_SPOT_8523
	),
	TUTORIAL_SHRIMP("Shrimp", ItemID.RAW_SHRIMPS,
		FISHING_SPOT_3317
	),
	ETCETERIA_LOBSTER("Lobster", "Lobster (Approval only)", ItemID.RAW_LOBSTER,
		FISHING_SPOT_3657
	),
	QUEST_RUM_DEAL("Sluglings", "Rum deal (Quest)", ItemID.SLUGLINGS,
		FISHING_SPOT
	),
	QUEST_TAI_BWO_WANNAI_TRIO("Karambwan", "Tai Bwo Wannai Trio (Quest)", ItemID.RAW_KARAMBWAN,
		FISHING_SPOT_4714
	),
	QUEST_FISHING_CONTEST("Giant carp", "Fishing Contest (Quest)", ItemID.GIANT_CARP,
		FISHING_SPOT_4079, FISHING_SPOT_4080, FISHING_SPOT_4081, FISHING_SPOT_4082
	),
	;

	private static final Map<Integer, FishingSpot> SPOTS;

	private final String name;
	private final String worldMapTooltip;
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
		this(spot, spot, fishSpriteId, ids);
	}

	FishingSpot(String spot, String worldMapTooltip, int fishSpriteId, int... ids)
	{
		this.name = spot;
		this.worldMapTooltip = worldMapTooltip;
		this.fishSpriteId = fishSpriteId;
		this.ids = ids;
	}

	public static FishingSpot findSpot(int id)
	{
		return SPOTS.get(id);
	}
}
