/*
 * Copyright (c) 2020, melky <https://github.com/melkypie>
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
package net.runelite.client.plugins.worldmap;

import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.FishingSpot;

@Getter
enum FishingSpotLocation
{
	ALDARIN_NORTH(FishingSpot.SHRIMP, new WorldPoint(1372, 2985, 0)),
	ALDARIN_WEST(FishingSpot.SHRIMP, new WorldPoint(1313, 2963, 0)),
	AL_KHARID(FishingSpot.SHRIMP,
		new WorldPoint(3274, 3140, 0), new WorldPoint(3266, 3148, 0)),
	APE_ATOLL_SOUTH_WEST(FishingSpot.SHARK, new WorldPoint(2698, 2703, 0)),
	AVIUM_SAVANNAH_EAST_1(FishingSpot.SHRIMP, new WorldPoint(1774, 2993, 0)),
	AVIUM_SAVANNAH_EAST_2(FishingSpot.SHARK, new WorldPoint(1769, 2966, 0)),
	AVIUM_SAVANNAH_SOUTH_WEST_1(FishingSpot.SHARK, new WorldPoint(1573, 2954, 0)),
	AVIUM_SAVANNAH_SOUTH_WEST_2(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER},
		new WorldPoint(1579, 2963, 0), new WorldPoint(1585, 2951, 0)),
	AUBURNVALE(FishingSpot.SALMON, new WorldPoint(1393, 3313, 0),
		new WorldPoint(1396, 3304, 0), new WorldPoint(1458, 3330, 0)),
	BARBARIAN_OUTPOST(FishingSpot.SHRIMP,
		new WorldPoint(2497, 3548, 0), new WorldPoint(2509, 3562, 0),
		new WorldPoint(2514, 3575, 0)),
	BARBARIAN_VILLAGE(FishingSpot.SALMON,
		new WorldPoint(3103, 3424, 0), new WorldPoint(3109, 3433, 0)),
	BRAINDEATH_ISLAND(FishingSpot.QUEST_RUM_DEAL,
		new WorldPoint(2112, 5074, 0), new WorldPoint(2161, 5061, 0),
		new WorldPoint(2172, 5074, 0)),
	BRIMHAVEN_QUEST(FishingSpot.QUEST_TAI_BWO_WANNAI_TRIO, new WorldPoint(2767, 3165, 0)),
	BURGH_DE_ROTT_SOUTH(FishingSpot.SHARK,
		new WorldPoint(3472, 3192, 0), new WorldPoint(3486, 3182, 0),
		new WorldPoint(3497, 3174, 0), new WorldPoint(3513, 3177, 0),
		new WorldPoint(3528, 3164, 0), new WorldPoint(3537, 3177, 0),
		new WorldPoint(3545, 3179, 0), new WorldPoint(3553, 3177, 0),
		new WorldPoint(3559, 3173, 0), new WorldPoint(3564, 3174, 0)),
	CATHERBY(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER, FishingSpot.SHRIMP},
		new WorldPoint(2836, 3431, 0), new WorldPoint(2844, 3429, 0),
		new WorldPoint(2853, 3423, 0), new WorldPoint(2859, 3426, 0)),
	CAMDOZAAL_NORTH(FishingSpot.CAMDOZAAL_CAVE_EEL, new WorldPoint(2921, 5808, 0)),
	CAMDOZAAL_SOUTH(FishingSpot.CAMDOZAAL_TETRA, new WorldPoint(2927, 5778, 0),
		new WorldPoint(2921, 5787, 0)),
	CIVITAS_ILLA_FORTIS_PARK(FishingSpot.CIVITAS_ILLA_FORTIS_PARK, new WorldPoint(1737, 3101, 0)),
	CUSTODIA(FishingSpot.SALMON, new WorldPoint(1290, 3382, 0),
		new WorldPoint(1260, 3408, 0), new WorldPoint(1250, 3400, 0)),
	DRAYNOR_VILLAGE(FishingSpot.SHRIMP, new WorldPoint(3084, 3228, 0)),
	ENTRANA_CENTER(FishingSpot.SALMON,
		new WorldPoint(2841, 3356, 0), new WorldPoint(2842, 3359, 0),
		new WorldPoint(2847, 3361, 0)),
	ENTRANA_DOCK(FishingSpot.SHRIMP,
		new WorldPoint(2875, 3331, 0), new WorldPoint(2878, 3334, 0),
		new WorldPoint(2878, 3339, 0), new WorldPoint(2875, 3342, 0)),
	ETCETERIA_DOCK(FishingSpot.ETCETERIA_LOBSTER, new WorldPoint(2577, 3854, 0)),
	FAIRY_RING_CKR(FishingSpot.KARAMBWANJI, new WorldPoint(2806, 3014, 0)),
	FAIRY_RING_DKP(FishingSpot.KARAMBWAN,
		new WorldPoint(2898, 3119, 0), new WorldPoint(2911, 3119, 0)),
	FARMING_GUILD_SOUTH_EAST(FishingSpot.SALMON, new WorldPoint(1269, 3707, 0)),
	FARMING_GUILD_SOUTH_WEST1(FishingSpot.SHARK, new WorldPoint(1209, 3687, 0)),
	FARMING_GUILD_SOUTH_WEST2(FishingSpot.SHARK, new WorldPoint(1221, 3714, 0)),
	FARMING_GUILD_WEST(FishingSpot.SHARK,
		new WorldPoint(1199, 3736, 0), new WorldPoint(1208, 3749, 0)),
	FELDIP_HILLS_SOUTH(FishingSpot.SHRIMP, new WorldPoint(2511, 2838, 0)),
	FISHING_CONTEST(FishingSpot.QUEST_FISHING_CONTEST,
		new WorldPoint(2626, 3415, 0), new WorldPoint(2631, 3425, 0),
		new WorldPoint(2629, 3435, 0), new WorldPoint(2636, 3444, 0)),
	FISHING_GUILD(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER},
		new WorldPoint(2604, 3423, 0), new WorldPoint(2605, 3417, 0),
		new WorldPoint(2611, 3413, 0)),
	FISHING_GUILD_PLATFORM(FishingSpot.MINNOW,
		new WorldPoint(2609, 3444, 0), new WorldPoint(2617, 3444, 0)),
	FISHING_PLATFORM(FishingSpot.SHRIMP,
		new WorldPoint(2788, 3273, 0), new WorldPoint(2794, 3279, 0),
		new WorldPoint(2793, 3283, 0)),
	HOSIDIUS_CENTER(FishingSpot.SALMON, new WorldPoint(1715, 3612, 0)),
	HOSIDIUS_EAST(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER, FishingSpot.SHRIMP},
		new WorldPoint(1817, 3603, 0), new WorldPoint(1827, 3605, 0),
		new WorldPoint(1828, 3614, 0), new WorldPoint(1840, 3619, 0),
		new WorldPoint(1838, 3595, 0)),
	INFIRMARY_SOUTH(FishingSpot.SALMON, new WorldPoint(1584, 3566, 0)),
	IORWERTH_CAMP_INSIDE(FishingSpot.SALMON, new WorldPoint(3239, 5997, 0)),
	IORWERTH_CAMP_NORTH_INSIDE(FishingSpot.SHARK, new WorldPoint(3185, 6027, 0)),
	IORWERTH_CAMP_NORTH_OUTSIDE(FishingSpot.SHARK, new WorldPoint(2161, 3275, 0)),
	IORWERTH_CAMP_OUTSIDE(FishingSpot.SALMON, new WorldPoint(2215, 3245, 0)),
	ISAFDAR_NORTH_EAST_INSIDE(FishingSpot.SALMON, new WorldPoint(3293, 6005, 0)),
	ISAFDAR_NORTH_EAST_OUTSIDE(FishingSpot.SALMON, new WorldPoint(2269, 3253, 0)),
	ISLE_OF_SOULS_EAST(FishingSpot.SHARK, new WorldPoint(2281, 2841, 0)),
	ISLE_OF_SOULS_NORTH(FishingSpot.LOBSTER, new WorldPoint(2280, 2975, 0)),
	ISLE_OF_SOULS_SOUTH_WEST(FishingSpot.SHRIMP, new WorldPoint(2162, 2782, 0)),
	JATISZO(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER},
		new WorldPoint(2400, 3780, 0), new WorldPoint(2412, 3780, 0),
		new WorldPoint(2419, 3789, 0)),
	KASTORI(FishingSpot.SHRIMP, new WorldPoint(1329, 3010, 0)),
	KHARIDIAN_DESERT_SOUTH_WEST(FishingSpot.LOBSTER,
		new WorldPoint(3139, 2800, 0)),
	KINGSTOWN_EAST(FishingSpot.SALMON, new WorldPoint(1723, 3685, 0)),
	LANDS_END_EAST(FishingSpot.SHRIMP, new WorldPoint(1534, 3414, 0)),
	LANDS_END_WEST(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER, FishingSpot.SHRIMP},
		new WorldPoint(1484, 3432, 0)),
	LUMBRIDGE_RIVER(FishingSpot.SALMON,
		new WorldPoint(3238, 3241, 0), new WorldPoint(3237, 3253, 0)),
	LUMBRIDGE_SWAMP_CAVE_EAST(FishingSpot.CAVE_EEL, new WorldPoint(3244, 9570, 0)),
	LUMBRIDGE_SWAMP_CAVE_WEST(FishingSpot.CAVE_EEL, new WorldPoint(3153, 9544, 0)),
	LUMBRIDGE_SWAMP_SOUTH_EAST(FishingSpot.SHRIMP, new WorldPoint(3244, 3153, 0)),
	MARIM(FishingSpot.SHARK, new WorldPoint(2774, 2740, 0)),
	MISTROCK(FishingSpot.LOBSTER, new WorldPoint(1374, 2841, 0)),
	MOLCH_ISLAND(FishingSpot.COMMON_TENCH, new WorldPoint(1370, 3632, 0)),
	MORTTON(FishingSpot.SLIMY_EEL, new WorldPoint(3439, 3273, 0)),
	MORT_MYRE_SWAMP_NORTH(FishingSpot.SLIMY_EEL,
		new WorldPoint(3480, 3433, 0), new WorldPoint(3485, 3448, 0)),
	MORT_MYRE_SWAMP_WEST(FishingSpot.SLIMY_EEL,
		new WorldPoint(3425, 3409, 0), new WorldPoint(3432, 3415, 0)),
	MOR_UL_REK(FishingSpot.INFERNAL_EEL,
		new WorldPoint(2443, 5104, 0), new WorldPoint(2476, 5077, 0),
		new WorldPoint(2537, 5086, 0)),
	MOUNT_QUIDAMORTEM(FishingSpot.BARB_FISH,
		new WorldPoint(1271, 3546, 0), new WorldPoint(1265, 3541, 0),
		new WorldPoint(1253, 3542, 0)),
	MUDSKIPPER_POINT(FishingSpot.SHRIMP,
		new WorldPoint(2995, 3158, 0), new WorldPoint(2985, 3176, 0)),
	MUSA_POINT(new FishingSpot[]{FishingSpot.LOBSTER, FishingSpot.SHRIMP}, new WorldPoint(2925, 3179, 0)),
	MYTHS_GUILD_NORTH(FishingSpot.LOBSTER, new WorldPoint(2456, 2893, 0)),
	OBSERVATORY_EAST(FishingSpot.SALMON, new WorldPoint(2466, 3151, 0)),
	OTTOS_GROTTO(FishingSpot.BARB_FISH,
		new WorldPoint(2500, 3509, 0), new WorldPoint(2504, 3495, 0),
		new WorldPoint(2505, 3515, 0), new WorldPoint(2520, 3518, 0)),
	PISCATORIS(FishingSpot.MONKFISH, new WorldPoint(2308, 3700, 0)),
	PORT_PISCARILIUS_EAST(FishingSpot.ANGLERFISH, new WorldPoint(1831, 3773, 0)),
	PORT_PISCARILIUS_WEST(new FishingSpot[]{FishingSpot.LOBSTER, FishingSpot.SHRIMP},
		new WorldPoint(1762, 3796, 0), new WorldPoint(1745, 3802, 0)),
	PRIFDDINAS_INSIDE_EAST(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER},
		new WorldPoint(3186, 6102, 0), new WorldPoint(3187, 6123, 0)),
	PRIFDDINAS_INSIDE_NORTH(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER},
		new WorldPoint(3250, 6182, 0), new WorldPoint(3258, 6180, 0),
		new WorldPoint(3258, 6197, 0)),
	PRIFDDINAS_OUTSIDE_EAST(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER},
		new WorldPoint(2162, 3350, 0), new WorldPoint(2163, 3371, 0)),
	PRIFDDINAS_OUTSIDE_NORTH(new FishingSpot[]{FishingSpot.SHARK, FishingSpot.LOBSTER},
		new WorldPoint(2226, 3430, 0), new WorldPoint(2234, 3428, 0),
		new WorldPoint(2234, 3445, 0)),
	RELLEKKA_CENTER(FishingSpot.LOBSTER, new WorldPoint(2641, 3696, 0)),
	RELLEKKA_NORTH_EAST(FishingSpot.SHARK, new WorldPoint(2649, 3708, 0)),
	RELLEKKA_WEST(FishingSpot.SHRIMP, new WorldPoint(2632, 3694, 0)),
	RIVER_ARDOUGNE(FishingSpot.SALMON,
		new WorldPoint(2560, 3374, 0), new WorldPoint(2565, 3370, 0),
		new WorldPoint(2526, 3412, 0), new WorldPoint(2536, 3405, 0),
		new WorldPoint(2507, 3420, 0)),
	RIVER_ORTUS(FishingSpot.SALMON, new WorldPoint(1545, 3186, 0)),
	SAND_CRAB_PENINSULA_NORTH(FishingSpot.SHARK, new WorldPoint(1675, 3490, 0)),
	SAND_CRAB_PENINSULA_SOUTH(FishingSpot.SHRIMP, new WorldPoint(1676, 3469, 0)),
	SAND_CRAB_PENINSULA_WEST(FishingSpot.LOBSTER, new WorldPoint(1668, 3479, 0)),
	SEERS_VILLAGE(FishingSpot.SALMON,
		new WorldPoint(2725, 3524, 0), new WorldPoint(2714, 3531, 0)),
	SHIPWRECK_COVE_NORTH(FishingSpot.SHRIMP, new WorldPoint(1565, 3326, 0)),
	SHIPWRECK_COVE_SOUTH(FishingSpot.SHARK, new WorldPoint(1586, 3299, 0)),
	SHILO_VILLAGE(FishingSpot.SALMON,
		new WorldPoint(2854, 2977, 0), new WorldPoint(2858, 2973, 0)),
	TAL_TEKLAN_WEST(FishingSpot.SHARK, new WorldPoint(1218, 3146, 0)),
	TAL_TEKLAN_EAST(FishingSpot.SALMON, new WorldPoint(1265, 3132, 0)),
	TAVERLEY_DUNGEON(FishingSpot.LAVA_EEL,
		new WorldPoint(2893, 9764, 0), new WorldPoint(2889, 9766, 0),
		new WorldPoint(2883, 9765, 0)),
	TEMPOROSS(FishingSpot.HARPOONFISH,
		new WorldPoint(3047, 3002, 0), new WorldPoint(3050, 2995, 0),
		new WorldPoint(3036, 2996, 0), new WorldPoint(3035, 2962, 0),
		new WorldPoint(3047, 2957, 0), new WorldPoint(3045, 2954, 0)),
	TOWER_OF_ASCENSION(FishingSpot.SALMON, new WorldPoint(1623, 3235, 0)),
	TREE_GNOME_STRONGHOLD(FishingSpot.SALMON,
		new WorldPoint(2389, 3422, 0), new WorldPoint(2382, 3415, 0)),
	TUTORIAL_ISLAND(FishingSpot.TUTORIAL_SHRIMP, new WorldPoint(3100, 3091, 0)),
	WATSON_HOUSE_SOUTH(FishingSpot.SALMON, new WorldPoint(1646, 3558, 0)),
	WILDERNESS_BANDIT_CAMP(FishingSpot.SHRIMP, new WorldPoint(3049, 3704, 0)),
	WILDERNESS_DARK_CRABS(FishingSpot.DARK_CRAB,
		new WorldPoint(3362, 3802, 0), new WorldPoint(3347, 3813, 0)),
	WILDERNESS_LAVA_MAZE(FishingSpot.LAVA_EEL, new WorldPoint(3071, 3840, 0)),
	WILDERNESS_RESOURCE_AREA(FishingSpot.DARK_CRAB, new WorldPoint(3186, 3925, 0)),
	ZUL_ANDRA(FishingSpot.SACRED_EEL,
		new WorldPoint(2183, 3068, 0), new WorldPoint(2195, 3067, 0)),
	;

	private final WorldPoint[] locations;
	private final String tooltip;

	FishingSpotLocation(FishingSpot fishingSpot, WorldPoint... locations)
	{
		this.tooltip = fishingSpot.getWorldMapTooltip();
		this.locations = locations;
	}

	FishingSpotLocation(FishingSpot[] fishingSpot, WorldPoint... locations)
	{
		this.tooltip = Arrays.stream(fishingSpot).map(FishingSpot::getWorldMapTooltip).collect(Collectors.joining(" / "));
		this.locations = locations;
	}
}
