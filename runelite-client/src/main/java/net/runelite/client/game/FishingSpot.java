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
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

@Getter
public enum FishingSpot
{
	SHRIMP("Shrimp, Anchovies, Sardine, Herring", "Anchovies", ItemID.RAW_SHRIMP,
		NpcID._0_43_51_SALTFISH, NpcID._0_44_52_SALTFISH, NpcID._0_44_53_SALTFISH,
		NpcID._0_45_49_SALTFISH, NpcID._0_46_49_SALTFISH, NpcID._0_47_57_SALTFISH,
		NpcID._0_48_50_SALTFISH, NpcID._0_51_49_SALTFISH, NpcID._0_50_49_SALTFISH,
		NpcID._0_39_55_SALTFISH, NpcID._0_41_57_SALTFISH, NpcID._0_28_56_SALTFISH,
		NpcID._0_23_53_SALTFISH, NpcID._0_24_53_SALTFISH, NpcID._0_26_54_SALTFISH,
		NpcID._0_27_59_SALTFISH, NpcID._0_39_44_SALTFISH, NpcID._0_33_43_SALTFISH,
		NpcID._0_27_46_SALTFISH, NpcID._0_24_51_SALTFISH, NpcID._0_21_46_SALTFISH,
		NpcID._0_20_46_SALTFISH, NpcID._0_20_47_SALTFISH
	),
	LOBSTER("Lobster, Swordfish, Tuna", "Lobster", ItemID.RAW_LOBSTER,
		NpcID._0_40_53_RAREFISH, NpcID._0_44_53_RAREFISH, NpcID._0_45_49_RAREFISH,
		NpcID._52_59_RAREFISH, // f2p wilderness
		NpcID._0_41_57_RAREFISH, NpcID._0_37_59_LOBSTER, NpcID._0_28_56_RAREFISH,
		NpcID._0_23_53_RAREFISH, NpcID._0_26_54_RAREFISH, NpcID._0_27_59_RAREFISH,
		NpcID._0_38_45_RAREFISH, NpcID._0_33_52_RAREFISH, NpcID._0_34_53_RAREFISH,
		NpcID._0_35_46_RAREFISH, NpcID._0_49_43_RAREFISH, NpcID._0_24_46_RAREFISH,
		NpcID._0_21_44_RAREFISH
	),
	SHARK("Shark, Bass", "Shark", ItemID.RAW_SHARK,
		NpcID._0_40_53_MEMBERFISH, NpcID._0_44_53_MEMBERFISH, NpcID._0_33_51_MEMBERFISH,
		NpcID._0_41_57_MEMBERFISH, NpcID._0_54_49_MEMBERFISH, NpcID._0_55_49_MEMBERFISH,
		NpcID._0_43_42_MEMBERFISH, NpcID._0_42_42_MEMBERFISH, NpcID._0_37_59_TUNA,
		NpcID._0_28_56_MEMBERFISH, NpcID._0_23_53_MEMBERFISH, NpcID._0_26_54_MEMBERFISH,
		NpcID._0_18_57_MEMBERFISH, NpcID._0_19_58_MEMBERFISH, NpcID._0_18_58_MEMBERFISH,
		NpcID._0_33_52_MEMBERFISH, NpcID._0_34_53_MEMBERFISH, NpcID._0_35_44_MEMBERFISH,
		NpcID._0_24_46_MEMBERFISH, NpcID._0_27_46_MEMBERFISH, NpcID._0_24_51_MEMBERFISH,
		NpcID._0_19_49_MEMBERFISH
	),
	MONKFISH("Monkfish", ItemID.RAW_MONKFISH,
		NpcID.SWAN_FISHINGSPOT
	),
	SALMON("Salmon, Trout, Pike", "Salmon", ItemID.RAW_SALMON,
		NpcID._0_26_57_FRESHFISH, NpcID._0_37_53_FRESHFISH, NpcID._0_38_49_FRESHFISH,
		NpcID._0_39_53_FRESHFISH, NpcID._0_40_52_FRESHFISH, NpcID._0_42_55_FRESHFISH,
		NpcID._0_44_46_FRESHFISH, NpcID._0_44_52_FRESHFISH, NpcID._0_48_53_FRESHFISH,
		NpcID._0_50_50_FRESHFISH, NpcID._0_34_50_FRESHFISH, NpcID._0_35_50_FRESHFISH,
		NpcID._0_24_55_FRESHFISH, NpcID._0_25_55_FRESHFISH, NpcID._0_26_56_FRESHFISH,
		NpcID._0_19_57_FRESHFISH, NpcID._0_24_49_FRESHFISH, NpcID._0_25_50_FRESHFISH,
		NpcID._0_19_53_FRESHFISH, NpcID._0_20_52_FRESHFISH, NpcID._0_21_51_FRESHFISH,
		NpcID._0_22_52_FRESHFISH
	),
	LAVA_EEL("Lava eel", ItemID.LAVA_EEL,
		NpcID._0_45_152_LAVAFISH, NpcID._0_47_59_LAVAFISH
	),
	BARB_FISH("Sturgeon, Salmon, Trout", ItemID.BRUT_STURGEON,
		NpcID._0_39_54_BRUT_FISHING_SPOT, NpcID._0_19_55_BRUT_FISHING_SPOT
	),
	ANGLERFISH("Anglerfish", ItemID.RAW_ANGLERFISH,
		NpcID.PISCARILIUSFISH
	),
	MINNOW("Minnow", ItemID.MINNOW,
		NpcID.MINNOW_FISHINGSPOT1, NpcID.MINNOW_FISHINGSPOT2, NpcID.MINNOW_FISHINGSPOT3, NpcID.MINNOW_FISHINGSPOT4
	),
	HARPOONFISH("Harpoonfish", ItemID.TEMPOROSS_RAW_HARPOONFISH,
		NpcID.TEMPOROSS_HARPOONFISH_FISHINGSPOT_NORTH, NpcID.TEMPOROSS_HARPOONFISH_FISHINGSPOT_SOUTH, NpcID.TEMPOROSS_HARPOONFISH_FISHINGSPOT_SPECIAL
	),
	INFERNAL_EEL("Infernal Eel", ItemID.INFERNAL_EEL,
		NpcID.MORULREK_EELS_FISHINGSPOT
	),
	KARAMBWAN("Karambwan", ItemID.TBWT_RAW_KARAMBWAN,
		NpcID._0_45_48_KARAMBWAN, NpcID.GENERAL_KARAMBWAN
	),
	KARAMBWANJI("Karambwanji, Shrimp", "Karambwanji", ItemID.TBWT_RAW_KARAMBWANJI,
		NpcID._0_43_47_KARAMBWANJI
	),
	SACRED_EEL("Sacred eel", ItemID.SNAKEBOSS_EEL,
		NpcID.SNAKEBOSS_FISHINGSPOT
	),
	CAVE_EEL("Frog spawn, Cave eel", ItemID.RAW_CAVE_EEL,
		NpcID._0_49_149_CAVEFISH, NpcID._0_50_149_CAVEFISH, NpcID._0_42_81_CAVEFISH_EAST, NpcID._0_42_81_CAVEFISH_WEST
	),
	SLIMY_EEL("Slimy eel", ItemID.MORT_SLIMEY_EEL,
		NpcID._0_54_53_SLIMEY_EEL, NpcID._0_53_53_SLIMEY_EEL, NpcID._0_53_51_SLIMEY_EEL
	),
	DARK_CRAB("Dark Crab", ItemID.RAW_DARK_CRAB,
		NpcID._52_59_CRABS, NpcID._49_61_CRABS
	),
	COMMON_TENCH("Common tench, Bluegill, Greater siren, Mottled eel", "Greater siren", ItemID.AERIAL_FISHING_COMMON_TENCH,
		NpcID.FISHING_SPOT_AERIAL
	),
	CAMDOZAAL_TETRA("Guppy, Cavefish, Tetra, Catfish, Barronite shards, Barronite handle", "Tetra", ItemID.TETRA,
		NpcID.CAMDOZAAL_FISHINGSPOT_1
	),
	CAMDOZAAL_CAVE_EEL("Slimy eel, Cave eel", "Cave eel", ItemID.CAVE_EEL,
		NpcID._0_45_90_CAVEFISH
	),
	TUTORIAL_SHRIMP("Shrimp", ItemID.RAW_SHRIMP,
		NpcID._0_48_48_NEWBIEFISHING
	),
	ETCETERIA_LOBSTER("Lobster", "Lobster (Approval only)", ItemID.RAW_LOBSTER,
		NpcID._0_40_60_RAREFISH
	),
	QUEST_RUM_DEAL("Sluglings", "Rum deal (Quest)", ItemID.DEAL_SLUGLING,
		NpcID.DEAL_SQUID
	),
	QUEST_TAI_BWO_WANNAI_TRIO("Karambwan", "Tai Bwo Wannai Trio (Quest)", ItemID.TBWT_RAW_KARAMBWAN,
		NpcID.LUBUFU_KARAMBWAN
	),
	QUEST_FISHING_CONTEST("Giant carp", "Fishing Contest (Quest)", ItemID.GIANT_CARP,
		NpcID._0_41_53_COMPOFISHSPOT, NpcID._0_41_53_SINISTERFISHSPOT, NpcID._0_41_53_BIGDAVEFISHSPOT, NpcID._0_41_53_JOSHUAFISHSPOT
	),
	CIVITAS_ILLA_FORTIS_PARK("House Keys", "House Keys", ItemID.VARLAMORE_THIEVING_HOUSE_KEY,
		NpcID.CIVITAS_PARK_FISHINGSPOT_HMM
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
