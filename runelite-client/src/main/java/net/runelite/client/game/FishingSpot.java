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
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.plugins.fishing.FishingTools;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static net.runelite.api.NpcID.*;


@SuppressWarnings("SpellCheckingInspection")
@Getter
public enum FishingSpot
{
	SHRIMP("Net/Bait", "Anchovies", new LinkedHashMap<>(){{
		put(FishingTools.SMALL_FISHING_NET, new Catches("Shrimp, Anchovies", ItemID.RAW_ANCHOVIES));
		put(FishingTools.FISHING_ROD, new Catches("Sardines, Herring", ItemID.RAW_HERRING));
	}},
		FISHING_SPOT_1514, FISHING_SPOT_1517, FISHING_SPOT_1518,
		FISHING_SPOT_1521, FISHING_SPOT_1523, FISHING_SPOT_1524,
		FISHING_SPOT_1525, FISHING_SPOT_1528, FISHING_SPOT_1530,
		FISHING_SPOT_1544, FISHING_SPOT_3913, FISHING_SPOT_7155,
		FISHING_SPOT_7459, FISHING_SPOT_7462, FISHING_SPOT_7467,
		FISHING_SPOT_7469, FISHING_SPOT_7947, FISHING_SPOT_10513
	),
	LOBSTER("Cage/Harpoon", "Lobster", new LinkedHashMap<>(){{
		put(FishingTools.LOBSTER_POT, new Catches("Lobster", ItemID.RAW_LOBSTER));
		put(FishingTools.HARPOON, new Catches("Tuna, Swordfish", ItemID.RAW_SWORDFISH));
	}},
		FISHING_SPOT_1510, FISHING_SPOT_1519, FISHING_SPOT_1522,
		FISHING_SPOT_3914, FISHING_SPOT_5820, FISHING_SPOT_7199,
		FISHING_SPOT_7460, FISHING_SPOT_7465, FISHING_SPOT_7470,
		FISHING_SPOT_7946, FISHING_SPOT_9173, FISHING_SPOT_9174,
		FISHING_SPOT_10515, FISHING_SPOT_10635
	),
	SHARK("Big Net/Harpoon", "Shark", new LinkedHashMap<>(){
		{
			put(FishingTools.HARPOON, new Catches("Shark", ItemID.RAW_SHARK));
			put(FishingTools.BIG_FISHING_NET, new Catches("Mackerel, Cod, Bass, Misc.", ItemID.RAW_COD));
		}},
		FISHING_SPOT_1511, FISHING_SPOT_1520, FISHING_SPOT_3419,
		FISHING_SPOT_3915, FISHING_SPOT_4476, FISHING_SPOT_4477,
		FISHING_SPOT_5233, FISHING_SPOT_5234, FISHING_SPOT_5821,
		FISHING_SPOT_7200, FISHING_SPOT_7461, FISHING_SPOT_7466,
		FISHING_SPOT_8525, FISHING_SPOT_8526, FISHING_SPOT_8527,
		FISHING_SPOT_9171, FISHING_SPOT_9172, FISHING_SPOT_10514
	),
	MONKFISH("Net/Harpoon","Monkfish", new LinkedHashMap<>(){{
		put(FishingTools.SMALL_FISHING_NET, new Catches("Monkfish", ItemID.RAW_MONKFISH));
		put(FishingTools.HARPOON, new Catches("Tuna, Swordfish", ItemID.RAW_SWORDFISH));
	}},
		FISHING_SPOT_4316
	),
	SALMON("Salmon, Trout", "Salmon", new LinkedHashMap<>(){{
		put(FishingTools.FLY_FISHING_ROD, new Catches("Salmon, Trout, Rainbow Fish", ItemID.RAW_SALMON));
		put(FishingTools.FISHING_ROD, new Catches("Pike", ItemID.RAW_PIKE));
	}},
		ROD_FISHING_SPOT, ROD_FISHING_SPOT_1506, ROD_FISHING_SPOT_1507,
		ROD_FISHING_SPOT_1508, ROD_FISHING_SPOT_1509, ROD_FISHING_SPOT_1513,
		ROD_FISHING_SPOT_1515, ROD_FISHING_SPOT_1516, ROD_FISHING_SPOT_1526,
		ROD_FISHING_SPOT_1527, ROD_FISHING_SPOT_3417, ROD_FISHING_SPOT_3418,
		ROD_FISHING_SPOT_7463, ROD_FISHING_SPOT_7464, ROD_FISHING_SPOT_7468,
		ROD_FISHING_SPOT_8524
	),
	LAVA_EEL("Bait (Lava)","Lava Eel", new LinkedHashMap<>(){{
		put(FishingTools.OILY_FISHING_ROD, new Catches("Lava Eel", ItemID.RAW_LAVA_EEL));
	}},
		FISHING_SPOT_4928, FISHING_SPOT_6784
	),
	BARB_FISH("Use-rod (Barbarian)", "Sturgeon, Salmon, Trout", new LinkedHashMap<>(){{
		put(FishingTools.BARBARIAN_ROD, new Catches("Leaping Trout, Salmon, Sturgeon", ItemID.LEAPING_STURGEON));
	}},
		FISHING_SPOT_1542, FISHING_SPOT_7323
	),
	ANGLERFISH("Bait (Anglerfish)", "Anglerfish", new LinkedHashMap<>(){{
		put(FishingTools.FISHING_ROD, new Catches("Anglerfish", ItemID.RAW_ANGLERFISH));
	}},
		ROD_FISHING_SPOT_6825
	),
	MINNOW("Net (Minnow)", "Minnow", new LinkedHashMap<>(){{
		put(FishingTools.SMALL_FISHING_NET, new Catches("Minnow", ItemID.MINNOW));
	}},
		FISHING_SPOT_7730, FISHING_SPOT_7731, FISHING_SPOT_7732, FISHING_SPOT_7733
	),
	HARPOONFISH("Tempoross Cove", "Harpoonfish", new LinkedHashMap<>(){{
		put(FishingTools.HARPOON, new Catches("Harpoonfish", ItemID.HARPOONFISH));
	}},
		FISHING_SPOT_10565, FISHING_SPOT_10568, FISHING_SPOT_10569
	),
	INFERNAL_EEL("Bait (Infernal)", "Infernal Eel", new LinkedHashMap<>(){{
		put(FishingTools.OILY_FISHING_ROD, new Catches("Infernal Eel", ItemID.INFERNAL_EEL));
	}},
		ROD_FISHING_SPOT_7676
	),
	KARAMBWAN("Fish (Karambwan)", "Karambwan", new LinkedHashMap<>(){{
		put(FishingTools.KARAMBWAN_VESSEL, new Catches("Karambwan", ItemID.RAW_KARAMBWAN));
	}},
		FISHING_SPOT_4712, FISHING_SPOT_4713
	),
	KARAMBWANJI("Net (Karambwanji)", "Karambwanji", new LinkedHashMap<>(){{
		put(FishingTools.SMALL_FISHING_NET, new Catches("Karambwanji, Shrimp", ItemID.KARAMBWANJI));
	}},
		FISHING_SPOT_4710
	),
	SACRED_EEL("Bait (Sacred)", "Sacred eel", new LinkedHashMap<>(){{
		put(FishingTools.FISHING_ROD, new Catches("Sacred Eel", ItemID.SACRED_EEL));
	}},
		FISHING_SPOT_6488
	),
	CAVE_EEL("Net/Bait (Frogspawn)", "Frog Spawn, Cave Eel", new LinkedHashMap<>(){{
		put(FishingTools.SMALL_FISHING_NET, new Catches("Frog Spawn", ItemID.FROG_SPAWN));
		put(FishingTools.FISHING_ROD, new Catches("Slimy Eel, Cave Eel", ItemID.RAW_CAVE_EEL));
	}},
		FISHING_SPOT_1497, FISHING_SPOT_1498, FISHING_SPOT_1499, FISHING_SPOT_1500
	),
	SLIMY_EEL("Bait (Swamp)", "Slimy Eel", new LinkedHashMap<>(){{
		put(FishingTools.FISHING_ROD, new Catches("Slimy Eel", ItemID.RAW_SLIMY_EEL));
	}},
		FISHING_SPOT_2653, FISHING_SPOT_2654, FISHING_SPOT_2655
	),
	DARK_CRAB("Cage/Harpoon (Wilderness)", "Dark Crab", new LinkedHashMap<>(){{
		put(FishingTools.LOBSTER_POT, new Catches("Dark Crab, Lobster", ItemID.RAW_DARK_CRAB));
		put(FishingTools.HARPOON, new Catches("Tuna, Swordfish", ItemID.RAW_SWORDFISH));
	}},
		FISHING_SPOT_1535, FISHING_SPOT_1536
	),
	COMMON_TENCH("Catch (Aerial Fishing)", "Aerial Fishing", new LinkedHashMap<>(){{
		put(FishingTools.CORMORANTS_GLOVE, new Catches("Bluegill, Common Tench, Mottled Eel, Greater Siren", ItemID.COMMON_TENCH));
	}},
		FISHING_SPOT_8523
	),
	TUTORIAL_SHRIMP("Fish (Tutorial Island)", "Shrimp", new LinkedHashMap<>(){{
		put(FishingTools.SMALL_FISHING_NET, new Catches("Your first catch", ItemID.RAW_SHRIMPS));
	}},
		FISHING_SPOT_3317
	),
	ETCETERIA_LOBSTER("Cage/Harpoon (Approval only)", "Lobster (Approval only)", new LinkedHashMap<>(){{
		put(FishingTools.LOBSTER_POT, new Catches("Lobster (Approval only)", ItemID.RAW_LOBSTER));
		put(FishingTools.HARPOON, new Catches("Tuna, Swordfish (Approval only)", ItemID.RAW_SWORDFISH));
	}},
		FISHING_SPOT_3657
	),
	QUEST_RUM_DEAL("Fish (Braindeath Island)", "Rum Deal (Quest)", new LinkedHashMap<>(){{
		put(FishingTools.FISHBOWL_NET, new Catches("Sluglings, Karamthulhu", ItemID.SLUGLINGS));
	}},
		FISHING_SPOT
	),
	QUEST_TAI_BWO_WANNAI_TRIO("Fish (Tai Bwo Wannai Trio)", "Tai Bwo Wannai Trio (Quest)", new LinkedHashMap<>(){{
		put(FishingTools.KARAMBWAN_VESSEL, new Catches("Karambwan", ItemID.RAW_KARAMBWAN));
	}},
		FISHING_SPOT_4714
	),
	QUEST_FISHING_CONTEST("Fish (Hemenster)", "Fishing Contest (Quest)", new LinkedHashMap<>(){{
		put(FishingTools.FISHING_ROD, new Catches("Giant Carp", ItemID.RAW_GIANT_CARP));
	}},
		FISHING_SPOT_4079, FISHING_SPOT_4080, FISHING_SPOT_4081, FISHING_SPOT_4082
	),
	;

	private static class Catches{
		private final String fishName;
		private final int fishSpriteId;

		Catches(String fish, int spriteId) {
			this.fishName = fish;
			this.fishSpriteId = spriteId;
		}
	}

	private static final Map<Integer, FishingSpot> SPOTS;

	private final String name;
	private final String worldMapTooltip;
	private final LinkedHashMap<FishingTools, Catches> catchMap;
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

	FishingSpot(String style, String worldMapTooltip, LinkedHashMap<FishingTools, Catches> catchMap, int... ids)
	{
		this.name = style;
		this.worldMapTooltip = worldMapTooltip;
		this.catchMap = catchMap;
		this.ids = ids;
	}

	public static FishingSpot findSpot(int id)
	{
		return SPOTS.get(id);
	}
	public boolean isEquippedToFish(Set<FishingTools> usableGear)
	{
		for (FishingTools gear : usableGear)
		{
			for (FishingTools neededGear : this.catchMap.keySet())
			{
				if (gear.equals(neededGear)){
					return true;
				}
			}
		}
		return false;
	}
	public int getFishSpriteId()
	{
		int id = 0;
		for (Map.Entry<FishingTools, Catches> catchEntry : this.catchMap.entrySet()){
			if (id == 0) {
				id = catchEntry.getValue().fishSpriteId;
			}
		}
		return id;
	}
	public int getFishSpriteId(Set<FishingTools> usableGear)
	{
		int id = 0;
		for (Map.Entry<FishingTools, Catches> catchEntry : this.catchMap.entrySet()){
			if (usableGear.contains(catchEntry.getKey()) && id == 0) {
				id = catchEntry.getValue().fishSpriteId;
			}
		}
		return id;
	}
	public String getFishNames(){
		String str = "";
		for (Map.Entry<FishingTools, Catches> catchEntry : this.catchMap.entrySet()){
			str = str.concat(catchEntry.getValue().fishName);
			str = str.concat(", ");
		}

		str = str.substring(0, str.length() - 2);

		return str;
	}

	public String getFishNames(Set<FishingTools> usableGear){
		String str = "";
		for (Map.Entry<FishingTools, Catches> catchEntry : this.catchMap.entrySet()){
			if (usableGear.contains(catchEntry.getKey())){
				str = str.concat(catchEntry.getValue().fishName);
				str = str.concat(", ");
			}
		}
		if (!str.equals("")){
			str = str.substring(0, str.length() - 2);
		}

		return str;
	}

}
