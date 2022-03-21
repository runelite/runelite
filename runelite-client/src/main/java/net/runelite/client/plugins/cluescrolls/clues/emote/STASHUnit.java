/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.cluescrolls.clues.emote;

import lombok.Getter;
import net.runelite.api.NullObjectID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.clues.item.*;

import java.util.ArrayList;
import java.util.List;

import static net.runelite.api.ItemID.*;

@Getter
public enum STASHUnit
{
	NEAR_A_SHED_IN_LUMBRIDGE_SWAMP(NullObjectID.NULL_28958, STASHUnitTier.EASY, new WorldPoint(3201, 3171, 0)),
	ON_THE_BRIDGE_TO_THE_MISTHALIN_WIZARDS_TOWER(NullObjectID.NULL_28959, STASHUnitTier.EASY, new WorldPoint(3115, 3194, 0)),
	DRAYNOR_VILLAGE_MARKET(NullObjectID.NULL_28960, STASHUnitTier.EASY, new WorldPoint(3083, 3254, 0)),
	LIMESTONE_MINE(NullObjectID.NULL_28961, STASHUnitTier.EASY, new WorldPoint(3373, 3498, 0)),
	OUTSIDE_THE_LEGENDS_GUILD_GATES(NullObjectID.NULL_28962, STASHUnitTier.EASY, new WorldPoint(2735, 3350, 0)),
	MUDSKIPPER_POINT(NullObjectID.NULL_28963, STASHUnitTier.EASY, new WorldPoint(2988, 3111, 0)),
	NEAR_THE_ENTRANA_FERRY_IN_PORT_SARIM(NullObjectID.NULL_28964, STASHUnitTier.EASY, new WorldPoint(3050, 3237, 0)),
	AL_KHARID_SCORPION_MINE(NullObjectID.NULL_28965, STASHUnitTier.EASY, new WorldPoint(3303, 3289, 0)),
	DRAYNOR_MANOR_BY_THE_FOUNTAIN(NullObjectID.NULL_28966, STASHUnitTier.EASY, new WorldPoint(3089, 3331, 0)),
	WHEAT_FIELD_NEAR_THE_LUMBRIDGE_WINDMILL(NullObjectID.NULL_28967, STASHUnitTier.EASY, new WorldPoint(3163, 3297, 0)),
	CROSSROADS_NORTH_OF_DRAYNOR_VILLAGE(NullObjectID.NULL_28968, STASHUnitTier.EASY, new WorldPoint(3111, 3289, 0)),
	RIMMINGTON_MINE(NullObjectID.NULL_28969, STASHUnitTier.EASY, new WorldPoint(2976, 3239, 0)),
	VARROCK_PALACE_LIBRARY(NullObjectID.NULL_28970, STASHUnitTier.EASY, new WorldPoint(3214, 3490, 0)),
	UPSTAIRS_IN_THE_ARDOUGNE_WINDMILL(NullObjectID.NULL_28971, STASHUnitTier.EASY, new WorldPoint(2635, 3386, 2)),
	OUTSIDE_THE_FALADOR_PARTY_ROOM(NullObjectID.NULL_28972, STASHUnitTier.EASY, new WorldPoint(3043, 3371, 0)),
	TAVERLEY_STONE_CIRCLE(NullObjectID.NULL_28973, STASHUnitTier.EASY, new WorldPoint(2924, 3477, 0)),
	CATHERBY_BEEHIVE_FIELD(NullObjectID.NULL_28974, STASHUnitTier.EASY, new WorldPoint(2764, 3438, 0)),
	NEAR_THE_PARROTS_IN_ARDOUGNE_ZOO(NullObjectID.NULL_28975, STASHUnitTier.EASY, new WorldPoint(2608, 3284, 0)),
	ROAD_JUNCTION_NORTH_OF_RIMMINGTON(NullObjectID.NULL_28976, STASHUnitTier.EASY, new WorldPoint(2981, 3278, 0)),
	OUTSIDE_THE_FISHING_GUILD(NullObjectID.NULL_28977, STASHUnitTier.EASY, new WorldPoint(2608, 3393, 0)),
	OUTSIDE_KEEP_LE_FAYE(NullObjectID.NULL_28978, STASHUnitTier.EASY, new WorldPoint(2756, 3399, 0)),
	ROAD_JUNCTION_SOUTH_OF_SINCLAIR_MANSION(NullObjectID.NULL_28979, STASHUnitTier.EASY, new WorldPoint(2735, 3534, 0)),
	OUTSIDE_THE_DIGSITE_EXAM_CENTRE(NullObjectID.NULL_28980, STASHUnitTier.EASY, new WorldPoint(3353, 3343, 0)),
	NEAR_THE_SAWMILL_OPERATORS_BOOTH(NullObjectID.NULL_28981, STASHUnitTier.EASY, new WorldPoint(3298, 3490, 0)),
	MUBARIZS_ROOM_AT_THE_DUEL_ARENA(NullObjectID.NULL_28982, STASHUnitTier.EASY, new WorldPoint(3316, 3242, 0)),
	OUTSIDE_VARROCK_PALACE_COURTYARD(NullObjectID.NULL_28983, STASHUnitTier.EASY, new WorldPoint(3211, 3456, 0)),
	NEAR_HERQUINS_SHOP_IN_FALADOR(NullObjectID.NULL_28984, STASHUnitTier.EASY, new WorldPoint(2941, 3339, 0)),
	SOUTH_OF_THE_GRAND_EXCHANGE(NullObjectID.NULL_28985, STASHUnitTier.EASY, new WorldPoint(3159, 3464, 0)),
	AUBURYS_SHOP_IN_VARROCK(NullObjectID.NULL_28986, STASHUnitTier.EASY, new WorldPoint(3252, 3404, 0)),
	CENTRE_OF_CANIFIS(NullObjectID.NULL_28987, STASHUnitTier.MEDIUM, new WorldPoint(3491, 3489, 0)),
	MAUSOLEUM_OFF_THE_MORYTANIA_COAST(NullObjectID.NULL_28988, STASHUnitTier.MEDIUM, new WorldPoint(3500, 3575, 0)),
	EAST_OF_THE_BARBARIAN_VILLAGE_BRIDGE(NullObjectID.NULL_28989, STASHUnitTier.MEDIUM, new WorldPoint(3110, 3422, 0)),
	SOUTH_OF_THE_SHRINE_IN_TAI_BWO_WANNAI_VILLAGE(NullObjectID.NULL_28990, STASHUnitTier.MEDIUM, new WorldPoint(2802, 3081, 0)),
	CASTLE_WARS_BANK(NullObjectID.NULL_28991, STASHUnitTier.MEDIUM, new WorldPoint(2444, 3093, 0)),
	BARBARIAN_OUTPOST_OBSTACLE_COURSE(NullObjectID.NULL_28992, STASHUnitTier.MEDIUM, new WorldPoint(2541, 3550, 0)),
	GNOME_STRONGHOLD_BALANCING_ROPE(NullObjectID.NULL_28993, STASHUnitTier.MEDIUM, new WorldPoint(2473, 3418, 2)),
	OUTSIDE_YANILLE_BANK(NullObjectID.NULL_28994, STASHUnitTier.MEDIUM, new WorldPoint(2603, 3091, 0)),
	OBSERVATORY(NullObjectID.NULL_28995, STASHUnitTier.MEDIUM, new WorldPoint(2439, 3166, 0)),
	OGRE_CAGE_IN_KING_LATHAS_TRAINING_CAMP(NullObjectID.NULL_28996, STASHUnitTier.MEDIUM, new WorldPoint(2533, 3377, 0)),
	DIGSITE(NullObjectID.NULL_28997, STASHUnitTier.MEDIUM, new WorldPoint(3370, 3420, 0)),
	HICKTONS_ARCHERY_EMPORIUM(NullObjectID.NULL_28998, STASHUnitTier.MEDIUM, new WorldPoint(2825, 3441, 0)),
	SHANTAY_PASS(NullObjectID.NULL_28999, STASHUnitTier.MEDIUM, new WorldPoint(3308, 3125, 0)),
	LUMBRIDGE_SWAMP_CAVES(NullObjectID.NULL_29000, STASHUnitTier.MEDIUM, new WorldPoint(3222, 9584, 0), new WorldPoint(3167, 9570, 0)),
	OUTSIDE_CATHERBY_BANK(NullObjectID.NULL_29001, STASHUnitTier.MEDIUM, new WorldPoint(2807, 3437, 0)),
	OUTSIDE_THE_SEERS_VILLAGE_COURTHOUSE(NullObjectID.NULL_29002, STASHUnitTier.MEDIUM, new WorldPoint(2731, 3475, 0)),
	OUTSIDE_HARRYS_FISHING_SHOP_IN_CATHERBY(NullObjectID.NULL_29003, STASHUnitTier.MEDIUM, new WorldPoint(2837, 3436, 0)),
	TZHAAR_WEAPONS_STORE(NullObjectID.NULL_29004, STASHUnitTier.MEDIUM, new WorldPoint(2479, 5146, 0)),
	NORTH_OF_EVIL_DAVES_HOUSE_IN_EDGEVILLE(NullObjectID.NULL_29005, STASHUnitTier.MEDIUM, new WorldPoint(3077, 3503, 0)),
	WEST_OF_THE_SHAYZIEN_COMBAT_RING(NullObjectID.NULL_29006, STASHUnitTier.MEDIUM, new WorldPoint(1541, 3631, 0)),
	ENTRANCE_OF_THE_ARCEUUS_LIBRARY(NullObjectID.NULL_29007, STASHUnitTier.MEDIUM, new WorldPoint(1642, 3809, 0)),
	OUTSIDE_DRAYNOR_VILLAGE_JAIL(NullObjectID.NULL_29008, STASHUnitTier.MEDIUM, new WorldPoint(3130, 3250, 0)),
	CHAOS_TEMPLE_IN_THE_SOUTHEASTERN_WILDERNESS(NullObjectID.NULL_29009, STASHUnitTier.HARD, new WorldPoint(3245, 3609, 0)),
	FISHING_GUILD_BANK(NullObjectID.NULL_29010, STASHUnitTier.HARD, new WorldPoint(2593, 3409, 0)),
	TOP_FLOOR_OF_THE_LIGHTHOUSE(NullObjectID.NULL_29011, STASHUnitTier.HARD, new WorldPoint(2512, 3640, 2)),
	OUTSIDE_THE_GREAT_PYRAMID_OF_SOPHANEM(NullObjectID.NULL_29012, STASHUnitTier.HARD, new WorldPoint(3291, 2780, 0)),
	NOTERAZZOS_SHOP_IN_THE_WILDERNESS(NullObjectID.NULL_29013, STASHUnitTier.HARD, new WorldPoint(3027, 3699, 0)),
	WEST_SIDE_OF_THE_KARAMJA_BANANA_PLANTATION(NullObjectID.NULL_29014, STASHUnitTier.HARD, new WorldPoint(2909, 3169, 0)),
	MOUNTAIN_CAMP_GOAT_ENCLOSURE(NullObjectID.NULL_29015, STASHUnitTier.HARD, new WorldPoint(2810, 3677, 0)),
	GNOME_GLIDER_ON_WHITE_WOLF_MOUNTAIN(NullObjectID.NULL_29016, STASHUnitTier.HARD, new WorldPoint(2849, 3496, 0)),
	SHILO_VILLAGE_BANK(NullObjectID.NULL_29017, STASHUnitTier.HARD, new WorldPoint(2853, 2952, 0)),
	INSIDE_THE_DIGSITE_EXAM_CENTRE(NullObjectID.NULL_29018, STASHUnitTier.HARD, new WorldPoint(3356, 3333, 0)),
	NORTHEAST_CORNER_OF_THE_KHARAZI_JUNGLE(NullObjectID.NULL_29019, STASHUnitTier.HARD, new WorldPoint(2952, 2932, 0)),
	VOLCANO_IN_THE_NORTHEASTERN_WILDERNESS(NullObjectID.NULL_29020, STASHUnitTier.HARD, new WorldPoint(3368, 3930, 0)),
	IN_THE_MIDDLE_OF_JIGGIG(NullObjectID.NULL_29021, STASHUnitTier.HARD, new WorldPoint(2478, 3048, 0)),
	AGILITY_PYRAMID(NullObjectID.NULL_29022, STASHUnitTier.HARD, new WorldPoint(3357, 2830, 0)),
	HOSIDIUS_MESS(NullObjectID.NULL_29023, STASHUnitTier.HARD, new WorldPoint(1646, 3632, 0)),
	CHAPEL_IN_WEST_ARDOUGNE(NullObjectID.NULL_29024, STASHUnitTier.ELITE, new WorldPoint(2527, 3294, 0)),
	NEAR_A_RUNITE_ROCK_IN_THE_FREMENNIK_ISLES(NullObjectID.NULL_29025, STASHUnitTier.ELITE, new WorldPoint(2374, 3847, 0)),
	NEAR_A_LADDER_IN_THE_WILDERNESS_LAVA_MAZE(NullObjectID.NULL_29026, STASHUnitTier.ELITE, new WorldPoint(3069, 3862, 0)),
	ENTRANCE_OF_THE_CAVE_OF_DAMIS(NullObjectID.NULL_29027, STASHUnitTier.ELITE, new WorldPoint(2629, 5070, 0)),
	WARRIORS_GUILD_BANK(NullObjectID.NULL_29028, STASHUnitTier.ELITE, new WorldPoint(2844, 3537, 0)),
	SOUTHEAST_CORNER_OF_THE_MONASTERY(NullObjectID.NULL_29029, STASHUnitTier.ELITE, new WorldPoint(3056, 3482, 0)),
	SOUTHEAST_CORNER_OF_THE_FISHING_PLATFORM(NullObjectID.NULL_29030, STASHUnitTier.ELITE, new WorldPoint(2787, 3277, 0)),
	OUTSIDE_THE_SLAYER_TOWER_GARGOYLE_ROOM(NullObjectID.NULL_29031, STASHUnitTier.ELITE, new WorldPoint(3423, 3534, 2)),
	ON_TOP_OF_TROLLHEIM_MOUNTAIN(NullObjectID.NULL_29032, STASHUnitTier.ELITE, new WorldPoint(2886, 3676, 0)),
	FOUNTAIN_OF_HEROES(NullObjectID.NULL_29033, STASHUnitTier.ELITE, new WorldPoint(2916, 9891, 0)),
	ENTRANCE_OF_THE_CAVERN_UNDER_THE_WHIRLPOOL(NullObjectID.NULL_29034, STASHUnitTier.ELITE, new WorldPoint(1764, 5367, 1), new WorldPoint(1636, 5367, 1)),
	HALFWAY_DOWN_TROLLWEISS_MOUNTAIN(NullObjectID.NULL_29035, STASHUnitTier.ELITE, new WorldPoint(2782, 3787, 0)),
	SHAYZIEN_WAR_TENT(NullObjectID.NULL_29036, STASHUnitTier.ELITE,  new WorldPoint(1488, 3637, 0)),
	OUTSIDE_THE_LEGENDS_GUILD_DOOR(NullObjectID.NULL_29037, STASHUnitTier.ELITE,  new WorldPoint(2727, 3371, 0)),
	NEAR_THE_GEM_STALL_IN_ARDOUGNE_MARKET(NullObjectID.NULL_29038, STASHUnitTier.ELITE, new WorldPoint(2672, 3302, 0)),
	OUTSIDE_THE_BAR_BY_THE_FIGHT_ARENA(NullObjectID.NULL_29039, STASHUnitTier.ELITE, new WorldPoint(2571, 3150, 0)),
	SOUTHEAST_CORNER_OF_LAVA_DRAGON_ISLE(NullObjectID.NULL_29040, STASHUnitTier.MASTER, new WorldPoint(3228, 3830, 0)),
	NEAR_THE_PIER_IN_ZULANDRA(NullObjectID.NULL_29041, STASHUnitTier.MASTER, new WorldPoint(2203, 3059, 0)),
	BARROWS_CHEST(NullObjectID.NULL_29042, STASHUnitTier.MASTER, new WorldPoint(3547, 9690, 0)),
	WELL_OF_VOYAGE(NullObjectID.NULL_29043, STASHUnitTier.MASTER, new WorldPoint(2006, 4709, 1)),
	NORTHERN_WALL_OF_CASTLE_DRAKAN(NullObjectID.NULL_29044, STASHUnitTier.MASTER, new WorldPoint(3563, 3379, 0)),
	_7TH_CHAMBER_OF_JALSAVRAH(NullObjectID.NULL_29045, STASHUnitTier.MASTER, new WorldPoint(1951, 4431, 0)),
	SOUL_ALTAR(NullObjectID.NULL_29046, STASHUnitTier.MASTER, new WorldPoint(1810, 3855, 0)),
	WARRIORS_GUILD_BANK_29047(NullObjectID.NULL_29047, STASHUnitTier.MASTER, new WorldPoint(2845, 3545, 0)),
	ENTRANA_CHAPEL(NullObjectID.NULL_29048, STASHUnitTier.MASTER, new WorldPoint(2851, 3355, 0)),
	TZHAAR_GEM_STORE(NullObjectID.NULL_29049, STASHUnitTier.MASTER, new WorldPoint(2466, 5150, 0)),
	TENT_IN_LORD_IORWERTHS_ENCAMPMENT(NullObjectID.NULL_29050, STASHUnitTier.MASTER, new WorldPoint(2198, 3257, 0)),
	OUTSIDE_MUDKNUCKLES_HUT(NullObjectID.NULL_29051, STASHUnitTier.MASTER, new WorldPoint(2959, 3502, 0)),
	CENTRE_OF_THE_CATACOMBS_OF_KOUREND(NullObjectID.NULL_29052, STASHUnitTier.MASTER, new WorldPoint(1661, 10045, 0)),
	KING_BLACK_DRAGONS_LAIR(NullObjectID.NULL_29053, STASHUnitTier.MASTER, new WorldPoint(2286, 4680, 0)),
	OUTSIDE_KRIL_TSUTSAROTHS_ROOM(NullObjectID.NULL_29054, STASHUnitTier.MASTER, new WorldPoint(2931, 5337, 2)),
	BY_THE_BEAR_CAGE_IN_VARROCK_PALACE_GARDENS(NullObjectID.NULL_29055, STASHUnitTier.MASTER, new WorldPoint(3232, 3494, 0)),
	OUTSIDE_THE_WILDERNESS_AXE_HUT(NullObjectID.NULL_29056, STASHUnitTier.MASTER, new WorldPoint(3186, 3958, 0)),
	TOP_FLOOR_OF_THE_YANILLE_WATCHTOWER(NullObjectID.NULL_29057, STASHUnitTier.MASTER, new WorldPoint(2930, 4718, 2)),
	DEATH_ALTAR(NullObjectID.NULL_29058, STASHUnitTier.MASTER, new WorldPoint(2210, 4842, 0)),
	BEHIND_MISS_SCHISM_IN_DRAYNOR_VILLAGE(NullObjectID.NULL_29059, STASHUnitTier.MASTER, new WorldPoint(3095, 3254, 0)),
	NORTHWESTERN_CORNER_OF_THE_ENCHANTED_VALLEY(NullObjectID.NULL_29060, STASHUnitTier.MASTER, new WorldPoint(3022, 4517, 0)),
	NORTH_OF_MOUNT_KARUULM(NullObjectID.NULL_34647, STASHUnitTier.MEDIUM, new WorldPoint(1308, 3840, 0)),
	GYPSY_TENT_ENTRANCE(NullObjectID.NULL_34736, STASHUnitTier.BEGINNER, new WorldPoint(3206, 3422, 0)),
	FINE_CLOTHES_ENTRANCE(NullObjectID.NULL_34737, STASHUnitTier.BEGINNER, new WorldPoint(3209, 3416, 0)),
	BOB_AXES_ENTRANCE(NullObjectID.NULL_34738, STASHUnitTier.BEGINNER, new WorldPoint(3233, 3200, 0)),
	CRYSTALLINE_MAPLE_TREES(NullObjectID.NULL_34953, STASHUnitTier.MASTER, new WorldPoint(2213, 3427, 0)),
	CHARCOAL_BURNERS(NullObjectID.NULL_41758, STASHUnitTier.ELITE, new WorldPoint(1712, 3470, 0)),
	;

	private final int objectId;
	private final int tier;
	private final WorldPoint[] worldPoints;

	STASHUnit(int objectId, int tier, WorldPoint... worldPoints)
	{
		this.objectId = objectId;
		this.tier = tier;
		this.worldPoints = worldPoints;
	}

	public int getBuildLevelRequirement()
	{

		int req = 0;

		switch (this.tier)
		{
			case STASHUnitTier.BEGINNER:
				req = 12;
				break;
			case STASHUnitTier.EASY:
				req = 27;
				break;
			case STASHUnitTier.MEDIUM:
				req = 42;
				break;
			case STASHUnitTier.HARD:
				req = 55;
				break;
			case STASHUnitTier.ELITE:
				req = 77;
				break;
			case STASHUnitTier.MASTER:
				req = 88;
				break;
		}

		return req;
	}

	public ItemRequirement[] getBuildRequirements()
	{

		List<ItemRequirement> buildRequirements = new ArrayList<>();

		switch (this.tier)
		{
			case STASHUnitTier.BEGINNER:
				buildRequirements.add(new MultipleOfItemRequirement(PLANK, 2));
				break;
			case STASHUnitTier.EASY:
				buildRequirements.add(new MultipleOfItemRequirement(PLANK, 2));
				break;
			case STASHUnitTier.MEDIUM:
				buildRequirements.add(new MultipleOfItemRequirement(OAK_PLANK, 2));
				break;
			case STASHUnitTier.HARD:
				buildRequirements.add(new MultipleOfItemRequirement(TEAK_PLANK, 2));
				break;
			case STASHUnitTier.ELITE:
				buildRequirements.add(new MultipleOfItemRequirement(MAHOGANY_PLANK, 2));
				break;
			case STASHUnitTier.MASTER:
				buildRequirements.add(new MultipleOfItemRequirement(MAHOGANY_PLANK, 2));
				buildRequirements.add(new SingleItemRequirement(GOLD_LEAF));
				break;
		}

		buildRequirements.add(new MultipleOfAnyItemRequirement("Nails (10)",
				10,
				BRONZE_NAILS,
				IRON_NAILS,
				STEEL_NAILS,
				MITHRIL_NAILS,
				ADAMANTITE_NAILS,
				RUNE_NAILS));
		buildRequirements.add(new SingleItemRequirement(SAW));
		buildRequirements.add(new SingleItemRequirement(HAMMER));


		ItemRequirement[] reqs = new ItemRequirement[buildRequirements.size()];
		buildRequirements.toArray(reqs);

		return reqs;
	}
}
