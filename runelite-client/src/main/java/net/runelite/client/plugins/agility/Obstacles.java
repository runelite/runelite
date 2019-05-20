/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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
package net.runelite.client.plugins.agility;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Set;
import static net.runelite.api.NullObjectID.NULL_10872;
import static net.runelite.api.NullObjectID.NULL_10873;
import static net.runelite.api.NullObjectID.NULL_12945;
import static net.runelite.api.NullObjectID.NULL_18083;
import static net.runelite.api.NullObjectID.NULL_18116;
import static net.runelite.api.NullObjectID.NULL_18122;
import static net.runelite.api.NullObjectID.NULL_18124;
import static net.runelite.api.NullObjectID.NULL_18129;
import static net.runelite.api.NullObjectID.NULL_18130;
import static net.runelite.api.NullObjectID.NULL_18132;
import static net.runelite.api.NullObjectID.NULL_18133;
import static net.runelite.api.NullObjectID.NULL_18135;
import static net.runelite.api.NullObjectID.NULL_18136;
import static net.runelite.api.NullObjectID.NULL_3550;
import static net.runelite.api.ObjectID.BALANCING_LEDGE;
import static net.runelite.api.ObjectID.BALANCING_LEDGE_23547;
import static net.runelite.api.ObjectID.BALANCING_LEDGE_3561;
import static net.runelite.api.ObjectID.BALANCING_ROPE;
import static net.runelite.api.ObjectID.BALANCING_ROPE_23557;
import static net.runelite.api.ObjectID.BANNER_11382;
import static net.runelite.api.ObjectID.BASKET_11380;
import static net.runelite.api.ObjectID.BOAT_17961;
import static net.runelite.api.ObjectID.BOILER_22635;
import static net.runelite.api.ObjectID.CABLE;
import static net.runelite.api.ObjectID.CABLE_22569;
import static net.runelite.api.ObjectID.CABLE_22572;
import static net.runelite.api.ObjectID.CLIMBING_ROCKS_10851;
import static net.runelite.api.ObjectID.CLOTHES_LINE;
import static net.runelite.api.ObjectID.CONSOLE;
import static net.runelite.api.ObjectID.CRATE_10086;
import static net.runelite.api.ObjectID.CRUMBLING_WALL_1948;
import static net.runelite.api.ObjectID.DOORWAY_10855;
import static net.runelite.api.ObjectID.DOOR_18091;
import static net.runelite.api.ObjectID.DRYING_LINE;
import static net.runelite.api.ObjectID.EDGE;
import static net.runelite.api.ObjectID.EDGE_11371;
import static net.runelite.api.ObjectID.EDGE_11377;
import static net.runelite.api.ObjectID.FLOORBOARDS;
import static net.runelite.api.ObjectID.FLOORBOARDS_18071;
import static net.runelite.api.ObjectID.FLOORBOARDS_18072;
import static net.runelite.api.ObjectID.FLOORBOARDS_18073;
import static net.runelite.api.ObjectID.FLOORBOARDS_18089;
import static net.runelite.api.ObjectID.FLOORBOARDS_18090;
import static net.runelite.api.ObjectID.FLOORBOARDS_18093;
import static net.runelite.api.ObjectID.FLOORBOARDS_18094;
import static net.runelite.api.ObjectID.FLOORBOARDS_18097;
import static net.runelite.api.ObjectID.FLOORBOARDS_18098;
import static net.runelite.api.ObjectID.FLOORBOARDS_18109;
import static net.runelite.api.ObjectID.FLOORBOARDS_18110;
import static net.runelite.api.ObjectID.FLOORBOARDS_18111;
import static net.runelite.api.ObjectID.FLOORBOARDS_18112;
import static net.runelite.api.ObjectID.FLOORBOARDS_18113;
import static net.runelite.api.ObjectID.FLOORBOARDS_18114;
import static net.runelite.api.ObjectID.FLOORBOARDS_18117;
import static net.runelite.api.ObjectID.FLOORBOARDS_18118;
import static net.runelite.api.ObjectID.GAP_10085;
import static net.runelite.api.ObjectID.GAP_10352;
import static net.runelite.api.ObjectID.GAP_10642;
import static net.runelite.api.ObjectID.GAP_10778;
import static net.runelite.api.ObjectID.GAP_10779;
import static net.runelite.api.ObjectID.GAP_10780;
import static net.runelite.api.ObjectID.GAP_10820;
import static net.runelite.api.ObjectID.GAP_10821;
import static net.runelite.api.ObjectID.GAP_10822;
import static net.runelite.api.ObjectID.GAP_10823;
import static net.runelite.api.ObjectID.GAP_10828;
import static net.runelite.api.ObjectID.GAP_10832;
import static net.runelite.api.ObjectID.GAP_10859;
import static net.runelite.api.ObjectID.GAP_10861;
import static net.runelite.api.ObjectID.GAP_10882;
import static net.runelite.api.ObjectID.GAP_10884;
import static net.runelite.api.ObjectID.GAP_11161;
import static net.runelite.api.ObjectID.GAP_11360;
import static net.runelite.api.ObjectID.GAP_11365;
import static net.runelite.api.ObjectID.GAP_11374;
import static net.runelite.api.ObjectID.GAP_11375;
import static net.runelite.api.ObjectID.GAP_11376;
import static net.runelite.api.ObjectID.GAP_11383;
import static net.runelite.api.ObjectID.GAP_11392;
import static net.runelite.api.ObjectID.GAP_11395;
import static net.runelite.api.ObjectID.GAP_11396;
import static net.runelite.api.ObjectID.GAP_11406;
import static net.runelite.api.ObjectID.GAP_11429;
import static net.runelite.api.ObjectID.GAP_11430;
import static net.runelite.api.ObjectID.GAP_11630;
import static net.runelite.api.ObjectID.HAND_HOLDS_10836;
import static net.runelite.api.ObjectID.HAND_HOLDS_3583;
import static net.runelite.api.ObjectID.HURDLE;
import static net.runelite.api.ObjectID.HURDLE_11639;
import static net.runelite.api.ObjectID.HURDLE_11640;
import static net.runelite.api.ObjectID.ICE;
import static net.runelite.api.ObjectID.ICE_21149;
import static net.runelite.api.ObjectID.ICE_21150;
import static net.runelite.api.ObjectID.ICE_21151;
import static net.runelite.api.ObjectID.ICE_21152;
import static net.runelite.api.ObjectID.ICE_21153;
import static net.runelite.api.ObjectID.ICE_21154;
import static net.runelite.api.ObjectID.ICE_21155;
import static net.runelite.api.ObjectID.ICE_21156;
import static net.runelite.api.ObjectID.ICICLES;
import static net.runelite.api.ObjectID.JUTTING_WALL_22552;
import static net.runelite.api.ObjectID.LADDER_16682;
import static net.runelite.api.ObjectID.LADDER_22564;
import static net.runelite.api.ObjectID.LEDGE_10781;
import static net.runelite.api.ObjectID.LEDGE_10860;
import static net.runelite.api.ObjectID.LEDGE_10886;
import static net.runelite.api.ObjectID.LEDGE_10888;
import static net.runelite.api.ObjectID.LEDGE_11366;
import static net.runelite.api.ObjectID.LEDGE_11367;
import static net.runelite.api.ObjectID.LEDGE_11369;
import static net.runelite.api.ObjectID.LEDGE_11370;
import static net.runelite.api.ObjectID.LOG_BALANCE;
import static net.runelite.api.ObjectID.LOG_BALANCE_23144;
import static net.runelite.api.ObjectID.LOG_BALANCE_23145;
import static net.runelite.api.ObjectID.LOG_BALANCE_23542;
import static net.runelite.api.ObjectID.LOG_BALANCE_3557;
import static net.runelite.api.ObjectID.LOW_WALL;
import static net.runelite.api.ObjectID.LOW_WALL_10865;
import static net.runelite.api.ObjectID.MARKET_STALL_11381;
import static net.runelite.api.ObjectID.MONKEYBARS;
import static net.runelite.api.ObjectID.MONKEYBARS_15417;
import static net.runelite.api.ObjectID.MONKEY_BARS_3564;
import static net.runelite.api.ObjectID.NARROW_WALL;
import static net.runelite.api.ObjectID.OBSTACLE_NET_20211;
import static net.runelite.api.ObjectID.OBSTACLE_NET_23134;
import static net.runelite.api.ObjectID.OBSTACLE_NET_23135;
import static net.runelite.api.ObjectID.OBSTACLE_PIPE_23137;
import static net.runelite.api.ObjectID.OBSTACLE_PIPE_23138;
import static net.runelite.api.ObjectID.OBSTACLE_PIPE_23139;
import static net.runelite.api.ObjectID.PILE_OF_FISH;
import static net.runelite.api.ObjectID.PILLAR_3578;
import static net.runelite.api.ObjectID.PIPE_11657;
import static net.runelite.api.ObjectID.PLANK_10868;
import static net.runelite.api.ObjectID.PLANK_11631;
import static net.runelite.api.ObjectID.PLANK_3570;
import static net.runelite.api.ObjectID.PLANK_3571;
import static net.runelite.api.ObjectID.PLANK_3572;
import static net.runelite.api.ObjectID.POLEVAULT;
import static net.runelite.api.ObjectID.PYLON_22664;
import static net.runelite.api.ObjectID.ROCKS_23640;
import static net.runelite.api.ObjectID.ROCK_17958;
import static net.runelite.api.ObjectID.ROCK_17959;
import static net.runelite.api.ObjectID.ROCK_17960;
import static net.runelite.api.ObjectID.ROOF_TOP_BEAMS;
import static net.runelite.api.ObjectID.ROPESWING_23131;
import static net.runelite.api.ObjectID.ROPESWING_23132;
import static net.runelite.api.ObjectID.ROPE_15487;
import static net.runelite.api.ObjectID.ROPE_SWING;
import static net.runelite.api.ObjectID.ROUGH_WALL;
import static net.runelite.api.ObjectID.ROUGH_WALL_10093;
import static net.runelite.api.ObjectID.ROUGH_WALL_10586;
import static net.runelite.api.ObjectID.ROUGH_WALL_10833;
import static net.runelite.api.ObjectID.ROUGH_WALL_11385;
import static net.runelite.api.ObjectID.ROUGH_WALL_11391;
import static net.runelite.api.ObjectID.SHELF_18086;
import static net.runelite.api.ObjectID.SHELF_18087;
import static net.runelite.api.ObjectID.SHELF_18095;
import static net.runelite.api.ObjectID.SHELF_18096;
import static net.runelite.api.ObjectID.SHELF_18105;
import static net.runelite.api.ObjectID.SHELF_18106;
import static net.runelite.api.ObjectID.SHELF_18107;
import static net.runelite.api.ObjectID.SHELF_18108;
import static net.runelite.api.ObjectID.SKULL_SLOPE;
import static net.runelite.api.ObjectID.SKULL_SLOPE_15483;
import static net.runelite.api.ObjectID.STAIRS_10857;
import static net.runelite.api.ObjectID.STAIRS_22608;
import static net.runelite.api.ObjectID.STAIRS_22609;
import static net.runelite.api.ObjectID.STAIRS_22650;
import static net.runelite.api.ObjectID.STAIRS_22651;
import static net.runelite.api.ObjectID.STAIRS_DOWN;
import static net.runelite.api.ObjectID.STEEP_ROOF;
import static net.runelite.api.ObjectID.STEPPING_STONE_11643;
import static net.runelite.api.ObjectID.STEPPING_STONE_15412;
import static net.runelite.api.ObjectID.STEPPING_STONE_21120;
import static net.runelite.api.ObjectID.STEPPING_STONE_21126;
import static net.runelite.api.ObjectID.STEPPING_STONE_21128;
import static net.runelite.api.ObjectID.STEPPING_STONE_21129;
import static net.runelite.api.ObjectID.STEPPING_STONE_21130;
import static net.runelite.api.ObjectID.STEPPING_STONE_21131;
import static net.runelite.api.ObjectID.STEPPING_STONE_21132;
import static net.runelite.api.ObjectID.STEPPING_STONE_21133;
import static net.runelite.api.ObjectID.STEPPING_STONE_23556;
import static net.runelite.api.ObjectID.STILE_7527;
import static net.runelite.api.ObjectID.TALL_TREE_10819;
import static net.runelite.api.ObjectID.TIGHTROPE;
import static net.runelite.api.ObjectID.TIGHTROPE_10075;
import static net.runelite.api.ObjectID.TIGHTROPE_10284;
import static net.runelite.api.ObjectID.TIGHTROPE_10583;
import static net.runelite.api.ObjectID.TIGHTROPE_10834;
import static net.runelite.api.ObjectID.TIGHTROPE_11361;
import static net.runelite.api.ObjectID.TIGHTROPE_11364;
import static net.runelite.api.ObjectID.TIGHTROPE_11378;
import static net.runelite.api.ObjectID.TIGHTROPE_11393;
import static net.runelite.api.ObjectID.TIGHTROPE_11397;
import static net.runelite.api.ObjectID.TREE_11384;
import static net.runelite.api.ObjectID.TREE_11389;
import static net.runelite.api.ObjectID.TREE_BRANCH_23559;
import static net.runelite.api.ObjectID.TREE_BRANCH_23560;
import static net.runelite.api.ObjectID.TROPICAL_TREE_10357;
import static net.runelite.api.ObjectID.TROPICAL_TREE_15414;
import static net.runelite.api.ObjectID.TROPICAL_TREE_16062;
import static net.runelite.api.ObjectID.TUNNEL_18085;
import static net.runelite.api.ObjectID.TUNNEL_22557;
import static net.runelite.api.ObjectID.WALL_10084;
import static net.runelite.api.ObjectID.WALL_10777;
import static net.runelite.api.ObjectID.WALL_11373;
import static net.runelite.api.ObjectID.WALL_17980;
import static net.runelite.api.ObjectID.WALL_18078;
import static net.runelite.api.ObjectID.WALL_18088;
import static net.runelite.api.ObjectID.WALL_RUBBLE;
import static net.runelite.api.ObjectID.WALL_RUBBLE_18038;
import static net.runelite.api.ObjectID.WASHING_LINE_18099;
import static net.runelite.api.ObjectID.WASHING_LINE_18100;
import static net.runelite.api.ObjectID.WOODEN_BEAMS;
import static net.runelite.api.ObjectID.ZIP_LINE;
import static net.runelite.api.ObjectID.ZIP_LINE_11644;
import static net.runelite.api.ObjectID.ZIP_LINE_11645;
import static net.runelite.api.ObjectID.ZIP_LINE_11646;
import net.runelite.client.game.AgilityShortcut;

class Obstacles
{
	static final Set<Integer> COURSE_OBSTACLE_IDS = ImmutableSet.of(
		// Gnome
		OBSTACLE_NET_23134, TREE_BRANCH_23559, TREE_BRANCH_23560, OBSTACLE_NET_23135, OBSTACLE_PIPE_23138,
		OBSTACLE_PIPE_23139, LOG_BALANCE_23145, BALANCING_ROPE_23557,
		// Brimhaven
		PLANK_3572, PLANK_3571, PLANK_3570, ROPE_SWING, PILLAR_3578, LOW_WALL, LOG_BALANCE, LOG_BALANCE_3557,
		BALANCING_LEDGE_3561, BALANCING_LEDGE, MONKEY_BARS_3564, BALANCING_ROPE, HAND_HOLDS_3583,
		// Draynor
		ROUGH_WALL, TIGHTROPE, TIGHTROPE_10075, NARROW_WALL, WALL_10084, GAP_10085, CRATE_10086, STILE_7527,
		// Al-Kharid
		ROUGH_WALL_10093, TIGHTROPE_10284, CABLE, ZIP_LINE, TROPICAL_TREE_10357, ROOF_TOP_BEAMS,
		TIGHTROPE_10583, GAP_10352,
		// Pyramid
		STAIRS_10857, LOW_WALL_10865, LEDGE_10860, PLANK_10868, GAP_10882, LEDGE_10886, STAIRS_10857, GAP_10884,
		GAP_10859, GAP_10861, LOW_WALL_10865, GAP_10859, LEDGE_10888, PLANK_10868, CLIMBING_ROCKS_10851, DOORWAY_10855,
		// Varrock
		ROUGH_WALL_10586, CLOTHES_LINE, GAP_10642, WALL_10777, GAP_10778, GAP_10779, GAP_10780, LEDGE_10781, EDGE,
		// Penguin
		STEPPING_STONE_21120, STEPPING_STONE_21126, STEPPING_STONE_21128, STEPPING_STONE_21129,
		STEPPING_STONE_21130, STEPPING_STONE_21131, STEPPING_STONE_21132, STEPPING_STONE_21133,
		ICICLES, ICE, ICE_21149, ICE_21150, ICE_21151, ICE_21152, ICE_21153, ICE_21154, ICE_21155, ICE_21156,
		// Barbarian
		ROPESWING_23131, LOG_BALANCE_23144, OBSTACLE_NET_20211, BALANCING_LEDGE_23547, LADDER_16682, CRUMBLING_WALL_1948,
		// Canifis
		TALL_TREE_10819, GAP_10820, GAP_10821, GAP_10828, GAP_10822, POLEVAULT, GAP_10823, GAP_10832,
		// Ape atoll
		STEPPING_STONE_15412, TROPICAL_TREE_15414, MONKEYBARS_15417, SKULL_SLOPE_15483, ROPE_15487, TROPICAL_TREE_16062,
		// Falador
		ROUGH_WALL_10833, TIGHTROPE_10834, HAND_HOLDS_10836, GAP_11161, GAP_11360, TIGHTROPE_11361,
		TIGHTROPE_11364, GAP_11365, LEDGE_11366, LEDGE_11367, LEDGE_11369, LEDGE_11370, EDGE_11371,
		// Wilderness
		OBSTACLE_PIPE_23137, ROPESWING_23132, STEPPING_STONE_23556, LOG_BALANCE_23542, ROCKS_23640,
		// Seers
		WALL_11373, GAP_11374, TIGHTROPE_11378, GAP_11375, GAP_11376, EDGE_11377,
		// Dorgesh-Kaan
		CABLE_22569, CABLE_22572, LADDER_22564, JUTTING_WALL_22552, TUNNEL_22557, PYLON_22664,
		CONSOLE, BOILER_22635, STAIRS_22650, STAIRS_22651, STAIRS_22609, STAIRS_22608,
		// Pollniveach
		BASKET_11380, MARKET_STALL_11381, BANNER_11382, GAP_11383, TREE_11384, ROUGH_WALL_11385,
		MONKEYBARS, TREE_11389, DRYING_LINE,
		// Rellaka
		ROUGH_WALL_11391, GAP_11392, TIGHTROPE_11393, GAP_11395, GAP_11396, TIGHTROPE_11397, PILE_OF_FISH,
		// Ardougne
		GAP_11406, GAP_11429, GAP_11430, STEEP_ROOF, GAP_11630, PLANK_11631, WOODEN_BEAMS,
		// Meiyerditch
		NULL_12945, ROCK_17958, ROCK_17959, ROCK_17960, BOAT_17961, NULL_18122, NULL_18124, WALL_RUBBLE,
		WALL_RUBBLE_18038, FLOORBOARDS, FLOORBOARDS_18071, FLOORBOARDS_18072, FLOORBOARDS_18073, NULL_18129, NULL_18130,
		WALL_18078, NULL_18132, NULL_18133, NULL_18083, TUNNEL_18085, SHELF_18086, SHELF_18087, WALL_18088,
		FLOORBOARDS_18089, FLOORBOARDS_18090, DOOR_18091, FLOORBOARDS_18093, FLOORBOARDS_18094, SHELF_18095,
		SHELF_18096, FLOORBOARDS_18097, FLOORBOARDS_18098, WASHING_LINE_18099, WASHING_LINE_18100,
		NULL_18135, NULL_18136, SHELF_18105, SHELF_18106, SHELF_18107, SHELF_18108, FLOORBOARDS_18109,
		FLOORBOARDS_18110, FLOORBOARDS_18112, FLOORBOARDS_18111, FLOORBOARDS_18114, FLOORBOARDS_18113,
		NULL_18116, FLOORBOARDS_18117, FLOORBOARDS_18118, STAIRS_DOWN, WALL_17980,
		// Werewolf
		STEPPING_STONE_11643, HURDLE, HURDLE_11639, HURDLE_11640, PIPE_11657, SKULL_SLOPE, ZIP_LINE_11644,
		ZIP_LINE_11645, ZIP_LINE_11646
	);

	static final Multimap<Integer, AgilityShortcut> SHORTCUT_OBSTACLE_IDS;

	static final Set<Integer> TRAP_OBSTACLE_IDS = ImmutableSet.of(
		// Agility pyramid
		NULL_3550, NULL_10872, NULL_10873
	);

	static final List<Integer> TRAP_OBSTACLE_REGIONS = ImmutableList.of(12105, 13356);

	static
	{
		final ImmutableMultimap.Builder<Integer, AgilityShortcut> builder = ImmutableMultimap.builder();
		for (final AgilityShortcut item : AgilityShortcut.values())
		{
			for (int obstacle : item.getObstacleIds())
			{
				builder.put(obstacle, item);
			}
		}
		SHORTCUT_OBSTACLE_IDS = builder.build();
	}
}
