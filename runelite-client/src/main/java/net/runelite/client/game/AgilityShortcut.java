/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * Copyright (c) 2019, MrGroggle
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

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.NullObjectID;
import static net.runelite.api.NullObjectID.NULL_25337;
import static net.runelite.api.NullObjectID.NULL_26371;
import static net.runelite.api.NullObjectID.NULL_26375;
import static net.runelite.api.NullObjectID.NULL_26561;
import static net.runelite.api.NullObjectID.NULL_26562;
import static net.runelite.api.NullObjectID.NULL_26884;
import static net.runelite.api.NullObjectID.NULL_26886;
import static net.runelite.api.NullObjectID.NULL_29868;
import static net.runelite.api.NullObjectID.NULL_29869;
import static net.runelite.api.NullObjectID.NULL_29870;
import static net.runelite.api.NullObjectID.NULL_31823;
import static net.runelite.api.NullObjectID.NULL_31849;
import static net.runelite.api.NullObjectID.NULL_31852;
import static net.runelite.api.NullObjectID.NULL_33327;
import static net.runelite.api.NullObjectID.NULL_33328;
import static net.runelite.api.NullObjectID.NULL_39541;
import static net.runelite.api.NullObjectID.NULL_39542;
import static net.runelite.api.NullObjectID.NULL_40960;
import static net.runelite.api.NullObjectID.NULL_40962;
import static net.runelite.api.NullObjectID.NULL_43840;
import static net.runelite.api.NullObjectID.NULL_47325;
import static net.runelite.api.ObjectID.*;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum AgilityShortcut
{
	GENERIC_SHORTCUT(1, "Shortcut", null,
			// Trollheim
			ROCKS_3790, ROCKS_3791,
			// Fremennik Slayer Cave
			STEPS_29993,
			// Fossil Island
			LADDER_30938, LADDER_30939, LADDER_30940, LADDER_30941, RUBBER_CAP_MUSHROOM,
			// Brimhaven dungeon
			CREVICE_30198,
			// Lumbridge
			STILE_12982,
			// Gu'Tanoth Bridge
			GAP, GAP_2831,
			// Lumbridge Swamp Caves
			STEPPING_STONE_5948, STEPPING_STONE_5949, ROCKS_6673,
			// Morytania Pirate Ship
			ROCK_16115,
			// Lumber Yard
			BROKEN_FENCE_2618,
			// McGrubor's Wood
			LOOSE_RAILING,
			// Underwater Area Fossil Island
			TUNNEL_30959, HOLE_30966, OBSTACLE, OBSTACLE_30767, OBSTACLE_30964, OBSTACLE_30962, PLANT_DOOR, PLANT_DOOR_30961,
			// Tree Gnome Village
			LOOSE_RAILING_2186,
			// Burgh de Rott
			LOW_FENCE,
			// Taverley
			STILE,
			// Asgarnian Ice Dungeon
			STEPS,
			// Fossil Island Wyvern Cave
			STAIRS_31485,
			// Trollweiss Mountain Cave
			ROCKY_HANDHOLDS, ROCKY_HANDHOLDS_19847,
			// Witchaven Dungeon
			SHORTCUT,
			// Nature Grotto bridge
			BRIDGE_3522,
			// Rocky Ledges Viyeldi cave
			ROCKY_LEDGE, ROCKY_LEDGE_2960, ROCKY_LEDGE_2961, ROCKS_2962, ROCKS_2963, ROCKS_2964,
			// Villa Lucens backstage theatre
			LOOSE_ROCKS_54720, LOOSE_ROCKS_54721, LOOSE_ROCKS_54722),
	WEISS_BROKEN_FENCE(1, "Shortcut", null, /* base id */ NullObjectID.NULL_46815)
	{
		@Override
		public boolean matches(Client client, TileObject object)
		{
			assert object.getId() == NullObjectID.NULL_46815;
			int multilocId = client.getObjectDefinition(object.getId())
				.getImpostor()
				.getId();
			return multilocId == BROKEN_FENCE_46817;
		}
	},
	BRIMHAVEN_DUNGEON_MEDIUM_PIPE_RETURN(1, "Pipe Squeeze", null, new WorldPoint(2698, 9491, 0), PIPE_21727),
	BRIMHAVEN_DUNGEON_PIPE_RETURN(1, "Pipe Squeeze", null, new WorldPoint(2655, 9573, 0), PIPE_21728),
	BRIMHAVEN_DUNGEON_STEPPING_STONES_RETURN(1, "Pipe Squeeze", null, STEPPING_STONE_21739),
	BRIMHAVEN_DUNGEON_LOG_BALANCE_RETURN(1, "Log Balance", null, LOG_BALANCE_20884),
	AGILITY_PYRAMID_ROCKS_WEST(1, "Rocks", null, CLIMBING_ROCKS_11948),
	CAIRN_ISLE_CLIMBING_ROCKS(1, "Rocks", null, CLIMBING_ROCKS),
	KARAMJA_GLIDER_LOG(1, "Log Balance", new WorldPoint(2906, 3050, 0), A_WOODEN_LOG),
	FALADOR_CRUMBLING_WALL(5, "Crumbling Wall", new WorldPoint(2936, 3357, 0), CRUMBLING_WALL_24222),
	YANILLE_CLIMBING_ROCKS(5, "Climbing rocks", null, CLIMBING_ROCKS_23543),
	RIVER_LUM_GRAPPLE_WEST(8, "Grapple Broken Raft", new WorldPoint(3245, 3179, 0), BROKEN_RAFT),
	RIVER_LUM_GRAPPLE_EAST(8, "Grapple Broken Raft", new WorldPoint(3258, 3179, 0), BROKEN_RAFT),
	CORSAIR_COVE_ROCKS(10, "Rocks", new WorldPoint(2545, 2871, 0), ROCKS_31757),
	KARAMJA_MOSS_GIANT_SWING(10, "Rope", null, ROPESWING_23568, ROPESWING_23569),
	FALADOR_GRAPPLE_WALL(11, "Grapple Wall", new WorldPoint(3031, 3391, 0), WALL_17049, WALL_17050),
	BRIMHAVEN_DUNGEON_STEPPING_STONES(12, "Stepping Stones", null, STEPPING_STONE_21738),
	VARROCK_SOUTH_FENCE(13, "Fence", new WorldPoint(3239, 3334, 0), FENCE_16518),
	GOBLIN_VILLAGE_WALL(14, "Wall", new WorldPoint(2925, 3523, 0), TIGHTGAP),
	CORSAIR_COVE_DUNGEON_PILLAR(15, "Pillar Jump", new WorldPoint(1980, 8996, 0), PILLAR_31809),
	EDGEVILLE_DUNGEON_MONKEYBARS(15, "Monkey Bars", null, MONKEYBARS_23566),
	TROLLHEIM_ROCKS(15, "Rocks", null, new WorldPoint(2838, 3614, 0), ROCKS_3748), // No fixed world map location, but rocks near death plateau have a requirement of 15
	YANILLE_UNDERWALL_TUNNEL(16, "Underwall Tunnel", new WorldPoint(2574, 3109, 0), HOLE_16520, CASTLE_WALL),
	KOUREND_CATACOMBS_SOUTH_WEST_CRACK_NORTH(17, "Crack", new WorldPoint(1647, 10008, 0), CRACK_28892),
	KOUREND_CATACOMBS_SOUTH_WEST_CRACK_SOUTH(17, "Crack", new WorldPoint(1645, 10001, 0), CRACK_28892),
	CRABCLAW_CAVES_CREVICE(18, "Crevice", new WorldPoint(1710, 9822, 0), CREVICE_31695, CREVICE_31696),
	CRABCLAW_CAVES_ROCKS(18, "Rocks", new WorldPoint(1687, 9802, 0), ROCKS_31697),
	CRABCLAW_CAVES_STEPPING_STONES(18, "Stepping Stones", new WorldPoint(1704, 9800, 0), STEPPING_STONE_31699),
	YANILLE_WATCHTOWER_TRELLIS(18, "Trellis", null, TRELLIS_20056),
	COAL_TRUCKS_LOG_BALANCE(20, "Log Balance", new WorldPoint(2598, 3475, 0), LOG_BALANCE_23274),
	GRAND_EXCHANGE_UNDERWALL_TUNNEL(21, "Underwall Tunnel", new WorldPoint(3139, 3515, 0), UNDERWALL_TUNNEL_16529, UNDERWALL_TUNNEL_16530),
	BRIMHAVEN_DUNGEON_PIPE(22, "Pipe Squeeze", new WorldPoint(2654, 9569, 0), PIPE_21728),
	OBSERVATORY_SCALE_CLIFF(23, "Grapple Rocks", new WorldPoint(2447, 3155, 0), NULL_31849, NULL_31852),
	EAGLES_PEAK_ROCK_CLIMB(25, "Rock Climb", new WorldPoint(2320, 3499, 0), ROCKS_19849),
	FALADOR_UNDERWALL_TUNNEL(26, "Underwall Tunnel", new WorldPoint(2947, 3313, 0), UNDERWALL_TUNNEL, UNDERWALL_TUNNEL_16528),
	KOUREND_CATACOMBS_STONES_NORTH(28, "Stones", new WorldPoint(1613, 10071, 0), STONE_28893),
	KOUREND_CATACOMBS_STONES_SOUTH(28, "Stones", new WorldPoint(1609, 10060, 0), STONE_28893),
	MOUNT_KARUULM_LOWER(29, "Rocks", new WorldPoint(1324, 3782, 0), ROCKS_34397),
	CORSAIR_COVE_RESOURCE_ROCKS(30, "Rocks", new WorldPoint(2486, 2898, 0), ROCKS_31758, ROCKS_31759),
	SOUTHEAST_KARAJMA_STEPPING_STONES(30, "Stepping Stones", new WorldPoint(2924, 2946, 0), STEPPING_STONES, STEPPING_STONES_23646, STEPPING_STONES_23647),
	BRIMHAVEN_DUNGEON_LOG_BALANCE(30, "Log Balance", null, LOG_BALANCE_20882),
	AGILITY_PYRAMID_ROCKS_EAST(30, "Rocks", null, CLIMBING_ROCKS_11949),
	DRAYNOR_MANOR_STEPPING_STONES(31, "Stepping Stones", new WorldPoint(3150, 3362, 0), STEPPING_STONE_16533),
	CATHERBY_CLIFFSIDE_GRAPPLE(32, "Grapple Rock", new WorldPoint(2868, 3429, 0), ROCKS_17042),
	CAIRN_ISLE_ROCKS(32, "Rocks", null, ROCKS_2231),
	SHILO_VILLAGE_STEPPING_STONES( 32, "Stepping Stones", new WorldPoint(2863, 2974, 0), STEPPING_STONE_16466),
	ARDOUGNE_LOG_BALANCE(33, "Log Balance", new WorldPoint(2602, 3336, 0), LOG_BALANCE_16546, LOG_BALANCE_16547, LOG_BALANCE_16548),
	BRIMHAVEN_DUNGEON_MEDIUM_PIPE(34, "Pipe Squeeze", null, new WorldPoint(2698, 9501, 0), PIPE_21727),
	KOUREND_CATACOMBS_NORTH_EAST_CRACK_NORTH(34, "Crack", new WorldPoint(1715, 10057, 0), CRACK_28892),
	KOUREND_CATACOMBS_NORTH_EAST_CRACK_SOUTH(34, "Crack", new WorldPoint(1705, 10077, 0), CRACK_28892),
	CATHERBY_OBELISK_GRAPPLE(36, "Grapple Rock", null, CROSSBOW_TREE_17062),
	GNOME_STRONGHOLD_ROCKS(37, "Rocks", new WorldPoint(2485, 3515, 0), ROCKS_16534, ROCKS_16535),
	AL_KHARID_MINING_PITCLIFF_SCRAMBLE(38, "Rocks", new WorldPoint(3305, 3315, 0), ROCKS_16549, ROCKS_16550),
	YANILLE_WALL_GRAPPLE(39, "Grapple Wall", new WorldPoint(2552, 3072, 0), WALL_17047),
	NEITIZNOT_BRIDGE_REPAIR(0, "Bridge Repair - Quest", new WorldPoint(2315, 3828, 0), ROPE_BRIDGE_21306, ROPE_BRIDGE_21307),
	NEITIZNOT_BRIDGE_SOUTHEAST(0, "Rope Bridge", null, ROPE_BRIDGE_21308, ROPE_BRIDGE_21309),
	NEITIZNOT_BRIDGE_NORTHWEST(0, "Rope Bridge", null, ROPE_BRIDGE_21310, ROPE_BRIDGE_21311),
	NEITIZNOT_BRIDGE_NORTH(0, "Rope Bridge", null, ROPE_BRIDGE_21312, ROPE_BRIDGE_21313),
	NEITIZNOT_BRIDGE_NORTHEAST(40, "Broken Rope bridge", null, ROPE_BRIDGE_21314, ROPE_BRIDGE_21315),
	KOUREND_LAKE_JUMP_EAST(40, "Stepping Stones", new WorldPoint(1612, 3570, 0), STEPPING_STONE_29729, STEPPING_STONE_29730),
	KOUREND_LAKE_JUMP_WEST(40, "Stepping Stones", new WorldPoint(1604, 3572, 0), STEPPING_STONE_29729, STEPPING_STONE_29730),
	YANILLE_DUNGEON_BALANCE(40, "Balancing Ledge", null, BALANCING_LEDGE_23548),
	TROLLHEIM_EASY_CLIFF_SCRAMBLE(41, "Rocks", new WorldPoint(2869, 3670, 0), ROCKS_16521),
	DWARVEN_MINE_NARROW_CREVICE(42, "Narrow Crevice", new WorldPoint(3034, 9806, 0), CREVICE_16543),
	DRAYNOR_UNDERWALL_TUNNEL(42, "Underwall Tunnel", new WorldPoint(3068, 3261, 0), UNDERWALL_TUNNEL_19032, UNDERWALL_TUNNEL_19036),
	TROLLHEIM_MEDIUM_CLIFF_SCRAMBLE_NORTH(43, "Rocks", new WorldPoint(2886, 3684, 0), ROCKS_3803, ROCKS_3804, ROCKS_16522),
	TROLLHEIM_MEDIUM_CLIFF_SCRAMBLE_SOUTH(43, "Rocks", new WorldPoint(2876, 3666, 0), ROCKS_3803, ROCKS_3804, ROCKS_16522),
	SLAYER_DUNGEON_CHASM_JUMP(43, "Spiked Blades", new WorldPoint(2770, 10003, 0), STRANGE_FLOOR_16544),
	TROLLHEIM_ADVANCED_CLIFF_SCRAMBLE(44, "Rocks", new WorldPoint(2907, 3686, 0), ROCKS_16523, ROCKS_3748),
	KOUREND_RIVER_STEPPING_STONES(45, "Stepping Stones", new WorldPoint(1720, 3551, 0), STEPPING_STONE_29728),
	TIRANNWN_LOG_BALANCE(45, "Log Balance", null, LOG_BALANCE_3933, LOG_BALANCE_3931, LOG_BALANCE_3930, LOG_BALANCE_3929, LOG_BALANCE_3932),
	COSMIC_ALTAR_MEDIUM_WALKWAY(46, "Narrow Walkway", new WorldPoint(2399, 4403, 0), JUTTING_WALL_17002),
	DEEP_WILDERNESS_DUNGEON_CREVICE_NORTH(46, "Narrow Crevice", new WorldPoint(3047, 10335, 0), CREVICE_19043),
	DEEP_WILDERNESS_DUNGEON_CREVICE_SOUTH(46, "Narrow Crevice", new WorldPoint(3045, 10327, 0), CREVICE_19043),
	TROLLHEIM_HARD_CLIFF_SCRAMBLE(47, "Rocks", new WorldPoint(2902, 3680, 0), ROCKS_16524),
	RALOS_RISE_ROCK_CLIMB(47, "Rocks", new WorldPoint(1458, 3129, 0), ROCKS_51931),
	FREMENNIK_LOG_BALANCE(48, "Log Balance", new WorldPoint(2721, 3591, 0), LOG_BALANCE_16540, LOG_BALANCE_16541, LOG_BALANCE_16542),
	YANILLE_DUNGEON_PIPE_SQUEEZE(49, "Pipe Squeeze", null, OBSTACLE_PIPE_23140),
	ARCEUUS_ESSENCE_MINE_BOULDER(49, "Boulder", new WorldPoint(1774, 3888, 0), BOULDER_27990),
	MORYTANIA_STEPPING_STONE(50, "Stepping Stone", new WorldPoint(3418, 3326, 0), STEPPING_STONE_13504),
	SHAMAN_CAVES_JAGGED_WALL(50, "Jagged wall", null, JAGGED_WALL),
	VARROCK_SEWERS_PIPE_SQUEEZE(51, "Pipe Squeeze", new WorldPoint(3152, 9905, 0), OBSTACLE_PIPE_16511),
	ARCEUUS_ESSENCE_MINE_EAST_SCRAMBLE(52, "Rock Climb", new WorldPoint(1770, 3851, 0), ROCKS_27987, ROCKS_27988),
	KARAMJA_VOLCANO_GRAPPLE_NORTH(53, "Grapple Rock", new WorldPoint(2873, 3143, 0), STRONG_TREE_17074),
	KARAMJA_VOLCANO_GRAPPLE_SOUTH(53, "Grapple Rock", new WorldPoint(2874, 3128, 0), STRONG_TREE_17074),
	ALDARIN_ROCKS(54, "Rocks", new WorldPoint(1340, 2916, 0), ROCKS_54775, ROCKS_54776),
	MOTHERLODE_MINE_WALL_EAST(54, "Wall", new WorldPoint(3124, 9703, 0), DARK_TUNNEL_10047),
	MOTHERLODE_MINE_WALL_WEST(54, "Wall", new WorldPoint(3118, 9702, 0), DARK_TUNNEL_10047),
	MISCELLANIA_DOCK_STEPPING_STONE(55, "Stepping Stone", new WorldPoint(2572, 3862, 0), STEPPING_STONE_11768),
	TEMPLE_OF_EYE_RUBBLE(56, "Rubble", null, RUBBLE_43724, RUBBLE_43726),
	BRIMHAVEN_DUNGEON_EAST_STEPPING_STONES_NORTH(56, "Stepping Stones", new WorldPoint(2685, 9547, 0), STEPPING_STONE_19040),
	BRIMHAVEN_DUNGEON_EAST_STEPPING_STONES_SOUTH(56, "Stepping Stones", new WorldPoint(2693, 9529, 0), STEPPING_STONE_19040),
	ISAFDAR_FOREST_OBSTACLES(56, "Trap", null, DENSE_FOREST_3938, DENSE_FOREST_3939, DENSE_FOREST_3998, DENSE_FOREST_3999, DENSE_FOREST, LEAVES, LEAVES_3924, LEAVES_3925, STICKS, TRIPWIRE, TRIPWIRE_3921),
	RELEKKA_EAST_FENCE(57, "Fence", new WorldPoint(2688, 3697, 0), BROKEN_FENCE),
	YANILLE_DUNGEON_MONKEY_BARS(57, "Monkey Bars", null, MONKEYBARS_23567),
	PHASMATYS_ECTOPOOL_SHORTCUT(58, "Weathered Wall", null , WEATHERED_WALL, WEATHERED_WALL_16526),
	ELVEN_OVERPASS_CLIFF_SCRAMBLE(59, "Rocks", new WorldPoint(2345, 3300, 0), ROCKS_16514, ROCKS_16515),
	ELVEN_OVERPASS_CLIFF_SCRAMBLE_PRIFDDINAS(59, "Rocks", new WorldPoint(3369, 6052, 0), ROCKS_16514, ROCKS_16515),
	WILDERNESS_GWD_CLIMB_EAST(60, "Rocks", new WorldPoint(2943, 3770, 0), ROCKY_HANDHOLDS_26400, ROCKY_HANDHOLDS_26401, ROCKY_HANDHOLDS_26402, ROCKY_HANDHOLDS_26404, ROCKY_HANDHOLDS_26405, ROCKY_HANDHOLDS_26406),
	WILDERNESS_GWD_CLIMB_WEST(60, "Rocks", new WorldPoint(2928, 3760, 0), ROCKY_HANDHOLDS_26400, ROCKY_HANDHOLDS_26401, ROCKY_HANDHOLDS_26402, ROCKY_HANDHOLDS_26404, ROCKY_HANDHOLDS_26405, ROCKY_HANDHOLDS_26406),
	MOS_LEHARMLESS_STEPPING_STONE(60, "Stepping Stone", new WorldPoint(3710, 2970, 0), STEPPING_STONE_19042),
	WINTERTODT_GAP(60, "Gap", new WorldPoint(1629, 4023, 0), GAP_29326),
	UNGAEL_ICE(60, "Ice Chunks", new WorldPoint(2262, 4044, 0), NULL_25337, NULL_29868, NULL_29869, NULL_29870, ICE_CHUNKS_31822, NULL_31823, ICE_CHUNKS_31990, ICE_CHUNKS_47324, NULL_47325),
	GWD_LITTLE_CRACK(60, "Little Crack", new WorldPoint(2900, 3712, 0), LITTLE_CRACK),
	SLAYER_TOWER_MEDIUM_CHAIN_FIRST(61, "Spikey Chain (Floor 1)", new WorldPoint(3421, 3550, 0), SPIKEY_CHAIN),
	SLAYER_TOWER_MEDIUM_CHAIN_SECOND(61, "Spikey Chain (Floor 2)", new WorldPoint(3420, 3551, 0), SPIKEY_CHAIN_16538),
	SLAYER_DUNGEON_CREVICE(61, "Narrow Crevice", new WorldPoint(2729, 10008, 0), CREVICE_16539),
	MOUNT_KARUULM_UPPER(62, "Rocks", new WorldPoint(1322, 3791, 0), ROCKS_34396),
	NECROPOLIS_STEPPING_STONE_NORTH(62, "Stepping Stone", new WorldPoint(3293, 2706, 0), STEPPING_STONE_43990),
	NECROPOLIS_STEPPING_STONES_SOUTH(62, "Stepping Stones", new WorldPoint(3291, 2700, 0), STEPPING_STONE_43989),
	TAVERLEY_DUNGEON_RAILING(63, "Loose Railing", new WorldPoint(2935, 9811, 0), LOOSE_RAILING_28849),
	FORTHOS_DUNGEON_SPIKED_BLADES(63, "Spiked Blades", new WorldPoint(1819, 9946, 0), STRANGE_FLOOR_34834),
	DARKMEYER_WALL(63, "Wall (Long rope)", new WorldPoint(3669, 3375, 0), NULL_39541, NULL_39542),
	TROLLHEIM_WILDERNESS_ROCKS_EAST(64, "Rocks", new WorldPoint(2945, 3678, 0), ROCKS_16545),
	TROLLHEIM_WILDERNESS_ROCKS_WEST(64, "Rocks", new WorldPoint(2917, 3672, 0), ROCKS_16545),
	FOSSIL_ISLAND_VOLCANO(64, "Rope", new WorldPoint(3780, 3822, 0), ROPE_ANCHOR, ROPE_ANCHOR_30917),
	MORYTANIA_TEMPLE(65, "Loose Railing", new WorldPoint(3422, 3476, 0), ROCKS_16998, ROCKS_16999, ORNATE_RAILING, ORNATE_RAILING_17000),
	REVENANT_CAVES_GREEN_DRAGONS(65, "Jump", new WorldPoint(3220, 10086, 0), PILLAR_31561),
	COSMIC_ALTAR_ADVANCED_WALKWAY(66, "Narrow Walkway", new WorldPoint(2408, 4401, 0), JUTTING_WALL_17002),
	LUMBRIDGE_DESERT_STEPPING_STONE(66, "Stepping Stone", new WorldPoint(3210, 3135, 0), STEPPING_STONE_16513),
	TAVERLEY_WALL_CLIMBING_ROCKS(66, "Climbing rocks", new WorldPoint(2945, 3439, 0), CLIMBING_ROCKS_53255),
	HEROES_GUILD_TUNNEL_EAST(67, "Crevice", new WorldPoint(2898, 9901, 0), CREVICE_9739, CREVICE_9740),
	HEROES_GUILD_TUNNEL_WEST(67, "Crevice", new WorldPoint(2913, 9895, 0), CREVICE_9739, CREVICE_9740),
	YANILLE_DUNGEON_RUBBLE_CLIMB(67, "Pile of Rubble", null, PILE_OF_RUBBLE_23563, PILE_OF_RUBBLE_23564),
	ELVEN_OVERPASS_MEDIUM_CLIFF(68, "Rocks", new WorldPoint(2337, 3288, 0), ROCKS_16514, ROCKS_16515),
	ICE_MOUNTAIN_WESTERN_SCRAMBLE(68, "Rocks", new WorldPoint(2998, 3484, 0), ROCKS_47570, ROCKS_47571),
	ELVEN_OVERPASS_MEDIUM_CLIFF_PRIFDDINAS(68, "Rocks", new WorldPoint(3361, 6040, 0), ROCKS_16514, ROCKS_16515),
	WEISS_OBSTACLES(68, "Shortcut", null, ROCKSLIDE_33184, ROCKSLIDE_33185, NULL_33327, NULL_33328, LEDGE_33190, ROCKSLIDE_33191, FALLEN_TREE_33192),
	WEISS_FARMING_PATCH_BOULDER(0, "Shortcut", null, LITTLE_BOULDER),
	ARCEUUS_ESSENSE_NORTH(69, "Rock Climb", new WorldPoint(1759, 3873, 0), ROCKS_34741),
	TAVERLEY_DUNGEON_PIPE_BLUE_DRAGON(70, "Pipe Squeeze", new WorldPoint(2886, 9798, 0), OBSTACLE_PIPE_16509),
	TAVERLEY_DUNGEON_ROCKS_NORTH(70, "Rocks", new WorldPoint(2887, 9823, 0), ROCKS, ROCKS_14106),
	TAVERLEY_DUNGEON_ROCKS_SOUTH(70, "Rocks", new WorldPoint(2887, 9631, 0), ROCKS, ROCKS_14106),
	FOSSIL_ISLAND_HARDWOOD_NORTH(70, "Hole" , new WorldPoint(3712, 3828, 0), HOLE_31481, HOLE_31482),
	FOSSIL_ISLAND_HARDWOOD_SOUTH(70, "Hole" , new WorldPoint(3714, 3816, 0), HOLE_31481, HOLE_31482),
	AL_KHARID_WINDOW(70, "Window", new WorldPoint(3293, 3158, 0), BROKEN_WALL_33344, BIG_WINDOW)
	{
		@Override
		public boolean matches(Client client, TileObject object)
		{
			// there are two BIG_WINDOW objects right next to each other here, but only this one is valid
			return object.getId() != BIG_WINDOW || object.getWorldLocation().equals(new WorldPoint(3295, 3158, 0));
		}
	},
	GWD_SARADOMIN_ROPE_NORTH(70, "Rope Descent", new WorldPoint(2912, 5300, 0), NULL_26371, NULL_26561),
	GWD_SARADOMIN_ROPE_SOUTH(70, "Rope Descent", new WorldPoint(2951, 5267, 0), NULL_26375, NULL_26562),
	GU_TANOTH_CRUMBLING_WALL(71, "Rocks", new WorldPoint(2545, 3032, 0), CRUMBLING_WALL_40355, ROCKS_40356),
	POLLNIVNEACH_STEPPING_STONE(71, "Stepping stone", new WorldPoint(3371, 2958, 0), STEPPING_STONE_53241),
	SLAYER_TOWER_ADVANCED_CHAIN_FIRST(71, "Spikey Chain (Floor 2)", new WorldPoint(3447, 3578, 0), SPIKEY_CHAIN),
	SLAYER_TOWER_ADVANCED_CHAIN_SECOND(71, "Spikey Chain (Floor 3)", new WorldPoint(3446, 3576, 0), SPIKEY_CHAIN_16538),
	STRONGHOLD_SLAYER_CAVE_TUNNEL(72, "Tunnel", new WorldPoint(2431, 9806, 0), TUNNEL_30174, TUNNEL_30175),
	ASGARNIA_ICE_DUNGEON_BASIC_NORTH(72, "Tunnel", new WorldPoint(3025, 9570, 0), TUNNEL_42506),
	ASGARNIA_ICE_DUNGEON_BASIC_SOUTH(72, "Tunnel", new WorldPoint(3033, 9559, 0), TUNNEL_42507),
	CHAOS_TEMPLE_STEPPING_STONE(72, "Stepping stone", new WorldPoint(3267, 3628, 0), STEPPING_STONE_53237),
	BARROWS_WALL_JUMP(72, "Dry stone wall", new WorldPoint(3544, 3282, 0), DRY_STONE_WALL_53256),
	TROLL_STRONGHOLD_WALL_CLIMB(73, "Rocks", new WorldPoint(2841, 3694, 0), ROCKS_16464),
	ARCEUUS_ESSENSE_MINE_WEST(73, "Rock Climb", new WorldPoint(1742, 3853, 0), ROCKS_27984, ROCKS_27985),
	LAVA_DRAGON_ISLE_JUMP(74, "Stepping Stone", new WorldPoint(3200, 3807, 0), STEPPING_STONE_14918),
	MEIYERDITCH_LAB_TUNNELS_NORTH(74, "Cave", new WorldPoint(3623, 9747, 0), CAVE_43755, CAVE_43756),
	MEIYERDITCH_LAB_TUNNELS_SOUTH(74, "Cave", new WorldPoint(3618, 9722, 0), CAVE_43757, CAVE_43758),
	REVENANT_CAVES_DEMONS_JUMP(75, "Jump", new WorldPoint(3199, 10135, 0), PILLAR_31561),
	REVENANT_CAVES_ANKOU_EAST(75, "Jump", new WorldPoint(3201, 10195, 0), PILLAR_31561),
	REVENANT_CAVES_ANKOU_NORTH(75, "Jump", new WorldPoint(3180, 10209, 0), PILLAR_31561),
	ZUL_ANDRA_ISLAND_CROSSING(76, "Stepping Stone", new WorldPoint(2156, 3073, 0), STEPPING_STONE_10663),
	WILDERNESS_SLAYER_CAVE_CREVICE_NORTH_EAST(77, "Crevice", new WorldPoint(3433, 10093, 0), CREVICE_53259),
	WILDERNESS_SLAYER_CAVE_CREVICE_SOUTH_EAST(77, "Crevice", new WorldPoint(3434, 10115, 0), CREVICE_53259),
	WILDERNESS_SLAYER_CAVE_CREVICE_NORTH_WEST(77, "Crevice", new WorldPoint(3341, 10149, 0), CREVICE_53259),
	WILDERNESS_SLAYER_CAVE_CREVICE_SOUTH_WEST(77, "Crevice", new WorldPoint(3333, 10119, 0), CREVICE_53259),
	IORWERTHS_DUNGEON_NORTHERN_SHORTCUT_EAST(78, "Tight Gap", new WorldPoint(3221, 12441, 0), TIGHT_GAP),
	IORWERTHS_DUNGEON_NORTHERN_SHORTCUT_WEST(78, "Tight Gap", new WorldPoint(3215, 12441, 0), TIGHT_GAP_36693),
	SHILO_VILLAGE_ROCKS(79, "Rocks", new WorldPoint(2870, 3003, 0), ROCKS_53240, ROCKS_53238),
	KHARAZI_JUNGLE_VINE_CLIMB(79, "Vine", new WorldPoint(2897, 2939, 0), NULL_26884, NULL_26886),
	TAVERLEY_DUNGEON_SPIKED_BLADES(80, "Strange Floor", new WorldPoint(2877, 9813, 0), STRANGE_FLOOR),
	WATERBIRTH_DUNGEON_CREVICE(81, "Crevice", new WorldPoint(2604, 10070, 0), CREVICE_53258),
	LAVA_MAZE_NORTH_JUMP(82, "Stepping Stone", new WorldPoint(3092, 3880, 0), STEPPING_STONE_14917),
	ASGARNIA_ICE_DUNGEON_ADEPT_WEST(82, "Tunnel", new WorldPoint(3012, 9549, 0), TUNNEL_53250),
	ASGARNIA_ICE_DUNGEON_ADEPT_EAST(82, "Tunnel", new WorldPoint(3022, 9553, 0), TUNNEL_53251),
	IORWERTHS_DUNGEON_SOUTHERN_SHORTCUT_EAST(84, "Tight Gap", new WorldPoint(3241, 12420, 0), TIGHT_GAP_36694),
	IORWERTHS_DUNGEON_SOUTHERN_SHORTCUT_WEST(84, "Tight Gap", new WorldPoint(3231, 12420, 0), TIGHT_GAP_36695),
	CRANDOR_ROCK_CLIMB(84, "Rocks", new WorldPoint(2831, 3252, 0), ROCKS_53236, ROCKS_53234),
	ELVEN_ADVANCED_CLIFF_SCRAMBLE(85, "Rocks", new WorldPoint(2337, 3253, 0), ROCKS_16514, ROCKS_16515),
	ELVEN_ADVANCED_CLIFF_SCRAMBLE_PRIFDDINAS(85, "Rocks", new WorldPoint(3361, 6005, 0), ROCKS_16514, ROCKS_16515),
	WATERBIRTH_ISLAND_ROCKS(85, "Rocks", new WorldPoint(2546, 3750, 0), ROCKS_53252, ROCKS_53254),
	KALPHITE_WALL(86, "Crevice", new WorldPoint(3214, 9508, 0), CREVICE_16465),
	BRIMHAVEN_DUNGEON_VINE_EAST(87, "Vine", new WorldPoint(2672, 9582, 0), VINE_26880, VINE_26882),
	BRIMHAVEN_DUNGEON_VINE_WEST(87, "Vine", new WorldPoint(2606, 9584, 0), VINE_26880, VINE_26882),
	MOUNT_KARUULM_PIPE_SOUTH(88, "Pipe", new WorldPoint(1316, 10214, 0), MYSTERIOUS_PIPE),
	MOUNT_KARUULM_PIPE_NORTH(88, "Pipe", new WorldPoint(1345, 10230, 0), MYSTERIOUS_PIPE),
	REVENANT_CAVES_CHAMBER_JUMP(89, "Jump", new WorldPoint(3240, 10144, 0), PILLAR_31561),
	VIYELDI_ROCK_CLIMB(91, "Rocks", null, NULL_40960, NULL_40962),
	MEIYERDITCH_LAB_ADVANCED_TUNNELS_WEST(93, "Cave", new WorldPoint(3499, 9738, 0), CAVE_43759),
	MEIYERDITCH_LAB_ADVANCED_TUNNELS_MIDDLE(93, "Cave", new WorldPoint(3597, 9704, 0), NULL_43840),
	MEIYERDITCH_LAB_ADVANCED_TUNNELS_EAST(93, "Cave", new WorldPoint(3604, 9708, 0), CAVE_43762, CAVE_43763),
	VIYELDI_CAVES_CREVICE(96, "Crevice", null, CREVICE_53242);

	/**
	 * The agility level required to pass the shortcut
	 */
	@Getter
	private final int level;
	/**
	 * Brief description of the shortcut. (e.g. 'Rocks', 'Stepping Stones', 'Jump')
	 */
	@Getter
	private final String description;
	/**
	 * The location of the Shortcut icon on the world map (null if there is no icon)
	 */
	@Getter
	private final WorldPoint worldMapLocation;
	/**
	 * An optional location in case the location of the shortcut icon is either
	 * null or isn't close enough to the obstacle
	 */
	@Getter
	private final WorldPoint worldLocation;
	/**
	 * Array of obstacles, null objects, decorations etc. that this shortcut uses.
	 * Typically an ObjectID/NullObjectID
	 */
	@Getter
	private final int[] obstacleIds;

	AgilityShortcut(int level, String description, WorldPoint mapLocation, WorldPoint worldLocation, int... obstacleIds)
	{
		this.level = level;
		this.description = description;
		this.worldMapLocation = mapLocation;
		this.worldLocation = worldLocation;
		this.obstacleIds = obstacleIds;
	}

	AgilityShortcut(int level, String description, WorldPoint location, int... obstacleIds)
	{
		this(level, description, location, location, obstacleIds);
	}

	public String getTooltip()
	{
		return description + " - Level " + level;
	}

	public boolean matches(Client client, TileObject object)
	{
		return true;
	}
}
