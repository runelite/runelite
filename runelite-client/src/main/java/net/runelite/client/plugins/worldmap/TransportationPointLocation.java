/*
 * Copyright (c) 2019, Kyle Sergio <https://github.com/ksergio39>
 * Copyright (c) 2019, Bryce Altomare <https://github.com/Twinkiel0ver>
 * Copyright (c) 2019, Kyle Stead <http://github.com/kyle1elyk>
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import javax.annotation.Nullable;

@Getter
@AllArgsConstructor
enum TransportationPointLocation
{
	//Ships
	ARDOUGNE_TO_BRIMHAVEN("Ship to Brimhaven / Rimmington", new WorldPoint(2675, 3275, 0)),
	ARDOUGNE_TO_FISHINGPLAT("Ship to Fishing Platform", new WorldPoint(2722, 3304, 0), new WorldPoint(2779, 3271, 0)),
	BRIMHAVEN_TO_ARDOUGNE("Ship to Ardougne / Rimmington", new WorldPoint(2772, 3234, 0)),
	RIMMINGTON_TO_ARDOUGNE("Ship to Ardougne / Brimhaven", new WorldPoint(2915, 3224, 0)),
	CATHERBY_TO_KEEP_LE_FAYE("Ship to Keep Le Faye", new WorldPoint(2804, 3421, 0), new WorldPoint(2769, 3402, 0)),
	CORSAIR_TO_RIMMINGTON("Ship to Rimmington", new WorldPoint(2577, 2839, 0), new WorldPoint(2909, 3227, 0 )),
	DRAGONTOOTH_TO_PHASMATYS("Ship to Port Phasmatys", new WorldPoint(3791, 3561, 0), new WorldPoint(3703, 3487, 0)),
	DIGSITE_TO_FOSSIL("Ship to Fossil Island", new WorldPoint(3361, 3448, 0), new WorldPoint(3723, 3807, 0)),
	ENTRANA_TO_PORTSARIM("Ship to Port Sarim", new WorldPoint(2833, 3334, 0), new WorldPoint(3046, 3233, 0)),
	FISHINGPLAT_TO_ARDOUGNE("Ship to Ardougne", new WorldPoint(2779, 3271, 0), new WorldPoint(2722, 3304, 0)),
	HARMLESS_TO_PORT_PHASMATYS("Ship to Port Phasmatys", new WorldPoint(3682, 2951, 0), new WorldPoint(3709, 3497, 0)),
	ICEBERG_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2657, 3988, 0), new WorldPoint(2707, 3735, 0)),
	ISLAND_OF_STONE_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2470, 3994, 0), new WorldPoint(2621, 3692, 0)),
	ISLAND_TO_APE_ATOLL("Ship to Ape Atoll", new WorldPoint(2891, 2726, 0), new WorldPoint(2802, 2706, 0)),
	JATIZSO_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2420, 3780, 0), new WorldPoint(2639, 3710, 0)),
	KARAMJA_TO_PORT_SARIM("Ship to Port Sarim", new WorldPoint(2955, 3145, 0), new WorldPoint(3029, 3218, 0)),
	KARAMJA_TO_PORT_KHAZARD("Ship to Port Khazard", new WorldPoint(2763, 2957, 0), new WorldPoint(2653, 3166, 0)),
	LANDSEND_TO_PORTSARIM_PORTPISCARILIUS("Ship to Port Sarim/Port Piscarilius", new WorldPoint(1503, 3398, 0)),
	LUNAR_ISLE_TO_PIRATES_COVE("Ship to Pirates' Cove", new WorldPoint(2137, 3899, 0), new WorldPoint(2223, 3796, 0)),
	MISCELLANIA_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2579, 3846, 0), new WorldPoint(2627, 3692, 0)),
	NEITIZNOT_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2310, 3779, 0), new WorldPoint(2639, 3710, 0)),
	PESTCONTROL_TO_PORTSARIM("Ship to Port Sarim", new WorldPoint(2659, 2675, 0), new WorldPoint(3039, 3201, 0)),
	PIRATES_COVE_TO_LUNAR_ISLE("Ship to Lunar Isle", new WorldPoint(2223, 3796, 0), new WorldPoint(2137, 3899, 0)),
	PIRATES_COVE_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2212, 3794, 0), new WorldPoint(2620, 3695, 0)),
	PORT_PHASMATYS_TO_DRAGONTOOTH("Ship to Dragontooth Island", new WorldPoint(3703, 3487, 0), new WorldPoint(3791, 3561, 0)),
	PORT_PHASMATYS_TO_HARMLESS("Ship to Mos Le'Harmless", new WorldPoint(3709, 3497, 0), new WorldPoint(3682, 2951, 0)),
	PORT_PISCARILIUS_TO_PORTSARIM_LANDSEND("Ship to Port Sarim/Land's End", new WorldPoint(1823, 3692, 0)),
	PORTSARIM_TO_GREAT_KOUREND("Ship to Great Kourend", new WorldPoint(3054, 3244, 0), new WorldPoint(1823, 3692, 0)),
	PORTSARIM_TO_ENTRANA("Ship to Entrana", new WorldPoint(3046, 3233, 0), new WorldPoint(2833, 3334, 0)),
	PORTSARIM_TO_KARAMJA("Ship to Karamja", new WorldPoint(3029, 3218, 0), new WorldPoint(2955, 3144, 0)),
	PORTSARIM_TO_CRANDOR("Ship to Crandor", new WorldPoint(3045, 3205, 0), new WorldPoint(2839, 3261, 0)),
	PORTSARIM_TO_PEST_CONTROL("Ship to Pest Control", new WorldPoint(3039, 3201, 0), new WorldPoint(2659, 2675, 0)),
	RELLEKKA_TO_JATIZSO_NEITIZNOT("Ship to Jatizso/Neitiznot", new WorldPoint(2639, 3710, 0)),
	RELLEKKA_TO_MISCELLANIA("Ship to Miscellania", new WorldPoint(2627, 3692, 0), new WorldPoint(2579, 3846, 0)),
	RELLEKKA_TO_PIRATES_COVE("Ship to Pirates' Cove", new WorldPoint(2620, 3695, 0), new WorldPoint(2212, 3794, 0)),
	RELLEKKA_TO_WATERBIRTH("Ship to Waterbirth", new WorldPoint(2618, 3685, 0), new WorldPoint(2549, 3758, 0)),
	RELLEKKA_TO_WEISS_ICEBERG("Ship to Weiss/Iceberg", new WorldPoint(2707, 3735, 0)),
	RELLEKKA_TO_UNGAEL("Ship to Ungael", new WorldPoint(2638, 3698, 0), new WorldPoint(2276, 4034, 0)),
	RIMMINGTON_TO_CORSAIR_COVE("Ship to Corsair Cove", new WorldPoint(2909, 3227, 0 ), new WorldPoint(2577, 2839, 0)),
	WATERBIRTH_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2549, 3758, 0), new WorldPoint(2618, 3685, 0)),
	WEISS_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2847, 3967, 0), new WorldPoint(2707, 3735, 0)),
	UNGAEL_TO_RELLEKKA("Ship to Rellekka", new WorldPoint(2276, 4034, 0), new WorldPoint(2638, 3698, 0)),

	//Row Boats
	ROW_BOAT_BATTLEFRONT("Rowboat to Molch/Molch Island/Shayzien", new WorldPoint(1383, 3663, 0)),
	ROW_BOAT_BRAIN_DEATH("Rowboat to Port Phasmatys", new WorldPoint(2161, 5117, 0), new WorldPoint(3680, 3538, 0)),
	ROW_BOAT_BURGH_DE_ROTT("Rowboat to Meiyerditch", new WorldPoint(3522, 3168, 0), new WorldPoint(3589, 3172, 0)),
	ROW_BOAT_CRABCLAW("Rowboat to Hosidius", new WorldPoint(1780, 3417, 0), new WorldPoint(1779, 3457, 0)),
	ROW_BOAT_DIVING_ISLAND("Rowboat to Barge/Camp/North of Island", new WorldPoint(3764, 3901, 0)),
	ROW_BOAT_FISHING_GUILD("Rowboat to Hemenster", new WorldPoint(2598, 3426, 0), new WorldPoint(2613, 3439, 0)),
	ROW_BOAT_GNOME_STRONGHOLD("Rowboat to Fishing Colony", new WorldPoint(2368, 3487, 0), new WorldPoint(2356, 3641, 0)),
	ROW_BOAT_FISHING_COLONY("Rowboat to Gnome Stronghold", new WorldPoint(2356, 3641, 0), new WorldPoint(2368, 3487, 0)),
	ROW_BOAT_HEMENSTER("Rowboat to Fishing Guild", new WorldPoint(2613, 3439, 0), new WorldPoint(2598, 3426, 0)),
	ROW_BOAT_HOSIDIUS("Rowboat to Crabclaw Isle", new WorldPoint(1779, 3457, 0), new WorldPoint(1780, 3417, 0)),
	ROW_BOAT_LITHKREN("Rowboat to Mushroom Forest", new WorldPoint(3582, 3973, 0), new WorldPoint(3659, 3849, 0)),
	ROW_BOAT_LUMBRIDGE("Rowboat to Misthalin Mystery", new WorldPoint(3238, 3141, 0)),
	ROW_BOAT_MOLCH("Rowboat to Molch Island/Shayzien/Battlefront", new WorldPoint(1343, 3646, 0)),
	ROW_BOAT_MOLCH_ISLAND("Rowboat to Molch/Shayzien/Battlefront", new WorldPoint(1368, 3641, 0)),
	ROW_BOAT_MORT("Rowboat to Mort Myre", new WorldPoint(3518, 3284, 0), new WorldPoint(3498, 3380, 0)),
	ROW_BOAT_MORT_SWAMP("Rowboat to Mort'ton", new WorldPoint(3498, 3380, 0), new WorldPoint(3518, 3284, 0)),
	ROW_BOAT_MUSEUM_CAMP("Rowboat to Barge/Digsite/North of Island", new WorldPoint(3723, 3807, 0)),
	ROW_BOAT_MUSHROOM_FOREST_WEST("Rowboat to Lithkren", new WorldPoint(3659, 3849, 0), new WorldPoint(3582, 3973, 0)),
	ROW_BOAT_MUSHROOM_FOREST_NE("Rowboat to Barge/Camp/Sea", new WorldPoint(3733, 3894, 0)),
	ROW_BOAT_PORT_PHASMATYS_NORTH("Rowboat to Slepe", new WorldPoint(3670, 3545, 0), new WorldPoint(3661, 3279, 0)),
	ROW_BOAT_PORT_PHASMATYS_EAST("Rowboat to Braindeath Island", new WorldPoint(3680, 3538, 0), new WorldPoint(2161, 5117, 0)),
	ROW_BOAT_SHAYZIEN("Rowboat to Molch/Molch Island/Battlefront", new WorldPoint(1405, 3612, 0)),
	ROW_BOAT_SLEPE("Rowboat to Port Phasmatys", new WorldPoint(3661, 3279, 0), new WorldPoint(3670, 3545, 0)),
	ROW_BOAT_MOUNT_QUIDAMORTEM("Rowboat to The Stranglewood", new WorldPoint(1228, 3470, 0), new WorldPoint(1193, 3452, 0)),
	ROW_BOAT_STRANGLEWOOD("Rowboat to Mount Quidamortem", new WorldPoint(1193, 3452, 0), new WorldPoint(1228, 3470, 0)),
	OGRE_BOAT_FELDIP("Ogre Boat to Karamja", new WorldPoint(2653, 2964, 0), new WorldPoint(2757, 3085, 0)),
	OGRE_BOAT_KARAMJA("Ogre Boat to Feldip", new WorldPoint(2757, 3085, 0), new WorldPoint(2653, 2964, 0)),

	//Charter ships
	CHARTER_BRIMHAVEN("Charter Ship", new WorldPoint(2760, 3238, 0)),
	CHARTER_CATHERBY("Charter Ship", new WorldPoint(2791, 3415, 0)),
	CHARTER_CORSAIR_("Charter Ship", new WorldPoint(2589, 2851, 0)),
	CHARTER_KARAMJA_NORTH("Charter Ship", new WorldPoint(2954, 3158, 0)),
	CHARTER_KARAMJA_EAST("Charter Ship", new WorldPoint(2999, 3032, 0)),
	CHARTER_KHAZARD("Charter Ship", new WorldPoint(2673, 3143, 0)),
	CHARTER_MOSLE_HARMLESS("Charter Ship", new WorldPoint(3669, 2931, 0)),
	CHARTER_PORT_PHASMATYS("Charter Ship", new WorldPoint(3702, 3503, 0)),
	CHARTER_PORTSARIM("Charter Ship", new WorldPoint(3037, 3191, 0)),
	CHARTER_TYRAS("Charter Ship", new WorldPoint(2141, 3123, 0)),
	CHARTER_PRIFDDINAS("Charter Ship", new WorldPoint(2156, 3331, 0)),
	CHARTER_PRIFDDINAS_INSTANCE("Charter Ship", new WorldPoint(3180, 6083, 0)),

	//Ferries
	FERRY_AL_KHARID("Ferry to Ruins of Unkah", new WorldPoint(3269, 3142, 0), new WorldPoint(3145, 2843, 0)),
	FERRY_RUINS_OF_UNKAH("Ferry to Al Kharid", new WorldPoint(3145, 2843, 0), new WorldPoint(3269, 3142, 0)),

	//Minecarts/Carts
	MINE_CART_ARCEUUS("Lovakengj Minecart Network", new WorldPoint(1673, 3832, 0)),
	MINE_CART_GRANDEXCHANGE("Minecart to Keldagrim", new WorldPoint(3139, 3504, 0)),
	MINE_CART_HOSIDIUS("Lovakengj Minecart Network", new WorldPoint(1656, 3542, 0)),
	MINE_CART_ICE_MOUNTAIN("Minecart to Keldagrim", new WorldPoint(2995, 9836, 0)),
	MINE_CART_KELDAGRIM("Keldagrim Minecart System", new WorldPoint(2908, 10170, 0)),
	MINE_CART_LOVAKENGJ("Lovakengj Minecart Network", new WorldPoint(1524, 3721, 0)),
	MINE_CART_PORT_PISCARILIUS("Lovakengj Minecart Network", new WorldPoint(1760, 3708, 0)),
	MINE_CART_QUIDAMORTEM("Lovakengj Minecart Network", new WorldPoint(1253, 3550, 0)),
	MINE_CART_SHAYZIEN("Lovakengj Minecart Network", new WorldPoint(1586, 3622, 0)),
	MINE_CART_WHITE_WOLF_MOUNTAIN("Minecart to Keldagrim", new WorldPoint(2874, 9870, 0)),
	CART_TO_BRIMHAVEN("Cart to Brimhaven", new WorldPoint(2833, 2958, 0), new WorldPoint(2780, 3214, 0)),
	CART_TO_SHILO("Cart to Shilo Village", new WorldPoint(2780, 3214, 0), new WorldPoint(2833, 2958, 0)),

	//Canoes
	CANOE_BARBVILLAGE("Canoe", new WorldPoint(3111, 3409, 0)),
	CANOE_CHAMPIONSGUILD("Canoe", new WorldPoint(3202, 3344, 0)),
	CANOE_EDGEVILLE("Canoe", new WorldPoint(3130, 3509, 0)),
	CANOE_LUMBRIDGE("Canoe", new WorldPoint(3241, 3238, 0)),
	CANOE_FEROXENCLAVE("Canoe", new WorldPoint(3155, 3630, 0)),

	//Gnome Gliders
	GNOME_GLIDER_KHARID("Gnome Glider", new WorldPoint(3278, 3213, 0)),
	GNOME_GLIDER_APE_ATOLL("Gnome Glider", new WorldPoint(2712, 2804, 0)),
	GNOME_GLIDER_KARAMJA("Gnome Glider", new WorldPoint(2971, 2974, 0)),
	GNOME_GLIDER_FELDIP("Gnome Glider", new WorldPoint(2540, 2969, 0)),
	GNOME_GLIDER_GNOMESTRONGHOLD("Gnome Glider", new WorldPoint(2460, 3502, 0)),
	GNOME_GLIDER_WHITEWOLF("Gnome Glider", new WorldPoint(2845, 3501, 0)),

	//Balloons
	BALLOON_VARROCK("Hot Air Balloon", new WorldPoint(3298, 3480, 0)),
	BALLOON_YANILLE("Hot Air Balloon", new WorldPoint(2458, 3108, 0)),
	BALLOON_GNOMESTRONGHOLD("Hot Air Balloon", new WorldPoint(2478, 3459, 0)),
	BALLOON_TAVERLEY("Hot Air Balloon", new WorldPoint(2936, 3422, 0)),
	BALLOON_FALADOR("Hot Air Balloon", new WorldPoint(2921, 3301, 0)),

	//Spirit Tree
	SPIRITTREE_ARDOUGNE("Spirit Tree", new WorldPoint(2554, 3259, 0)),
	SPIRITTREE_CORSAIR("Spirit Tree", new WorldPoint(2485, 2850, 0)),
	SPIRITTREE_GNOMESTRONGHOLD("Spirit Tree", new WorldPoint(2459, 3446, 0)),
	SPIRITTREE_GNOMEVILLAGE("Spirit Tree", new WorldPoint(2538, 3166, 0)),
	SPIRITTREE_GRANDEXCHANGE("Spirit Tree", new WorldPoint(3184, 3510, 0)),
	SPIRITTREE_PRIFDDINAS("Spirit Tree", new WorldPoint(3274, 6124, 0)),

	//Carpets
	CARPET_KHARID("Carpet to Bedabin/Pollnivneach/Uzer", new WorldPoint(3311, 3107, 0)),
	CARPET_BEDABIN("Carpet to Shantay Pass", new WorldPoint(3183, 3042, 0), new WorldPoint(3311, 3107, 0)),
	CARPET_POLLNIVNEACH_NORTH("Carpet to Shantay Pass", new WorldPoint(3351, 3001, 0), new WorldPoint(3311, 3107, 0)),
	CARPET_POLLNIVNEACH_SOUTH("Carpet to Nardah/Sophanem/Menaphos", new WorldPoint(3345, 2943, 0)),
	CARPET_NARDAH("Carpet to Pollnivneach", new WorldPoint(3399, 2916, 0), new WorldPoint(3345, 2943, 0)),
	CARPET_SOPHANEM("Carpet to Pollnivneach", new WorldPoint(3288, 2814, 0), new WorldPoint(3345, 2943, 0)),
	CARPET_MENAPHOS("Carpet to Pollnivneach", new WorldPoint(3244, 2812, 0), new WorldPoint(3345, 2943, 0)),
	CARPET_UZER("Carpet to Shantay Pass", new WorldPoint(3468, 3111, 0), new WorldPoint(3311, 3107, 0)),

	//Teleports
	TELEPORT_ARCHIVE_FROM_ARCEUUS("Teleport to Library Archive", new WorldPoint(1623, 3808, 0)),
	TELEPORT_HARMLESS_FROM_HARMONY("Teleport to Mos Le'Harmless", new WorldPoint(3784, 2828, 0)),
	TELEPORT_RUNE_ARDOUGNE("Teleport to Rune Essence", new WorldPoint(2681, 3325, 0)),
	TELEPORT_RUNE_YANILLE("Teleport to Rune Essence", new WorldPoint(2592, 3089, 0)),
	TELEPORT_SORCERESS_GARDEN("Teleport to Sorceress's Garden", new WorldPoint(3320, 3141, 0)),
	TELEPORT_PRIFDDINAS_LIBRARY("Teleport to Prifddinas Library", new WorldPoint(3254, 6082, 2)),

	//Other
	ALTER_KOUREND_UNDERGROUND("Altar to Skotizo", new WorldPoint(1662, 10047, 0)),
	FAIRY_RING_ZANARIS_TO_KHARID("Fairy Ring to Al Kharid", new WorldPoint(2483, 4471, 0)),
	FAIRY_RING_ZANARIS_TO_SHACK("Fairy Ring to Shack", new WorldPoint(2451, 4471, 0)),
	MOUNTAIN_GUIDE_QUIDAMORTEM("Mountain Guide", new WorldPoint(1275, 3559, 0)),
	MOUNTAIN_GUIDE_QUIDAMORTEM_SOUTH("Mountain Guide", new WorldPoint(1270, 3477, 0)),
	MOUNTAIN_GUIDE_WALL("Mountain Guide", new WorldPoint(1400, 3538, 0)),
	MUSHTREE_MUSHROOM_FOREST("Mushtree", new WorldPoint(3674, 3871, 0)),
	MUSHTREE_TAR_SWAMP("Mushtree", new WorldPoint(3676, 3755, 0)),
	MUSHTREE_VERDANT_VALLEY("Mushtree", new WorldPoint(3757, 3756, 0)),
	MYTHS_GUILD_PORTAL("Portal to Guilds", new WorldPoint(2456, 2856, 0)),
	SOUL_WARS_PORTAL("Portal to Edgeville/Ferox Enclave", new WorldPoint(2204, 2858, 0)),
	TELEPORTER_THE_PALACE("Teleporter - The Palace", new WorldPoint(2592, 6424, 0)),
	TELEPORTER_THE_PLAZA("Teleporter - The Plaza", new WorldPoint(2616, 6417, 0)),
	TELEPORTER_THE_CATHEDRAL("Teleporter - The Cathedral", new WorldPoint(2651, 6405, 0)),
	TELEPORTER_WESTERN_RESIDENTIAL_DISTRICT("Teleporter - Western Residential District", new WorldPoint(2642, 6434, 0)),
	TELEPORTER_EASTERN_RESIDENTIAL_DISTRICT("Teleporter - Eastern Residential District", new WorldPoint(2690, 6415, 0)),
	TELEPORTER_NORTHERN_SCIENCE_DISTRICT("Teleporter - Northern Science District", new WorldPoint(2610, 6379, 0)),
	TELEPORTER_SOUTHERN_SCIENCE_DISTRICT("Teleporter - Southern Science District", new WorldPoint(2598, 6341, 0)),
	TRAIN_KELDAGRIM("Railway Station", new WorldPoint(2941, 10179, 0)),
	WILDERNESS_LEVER_ARDOUGNE("Wilderness Lever to Deserted Keep", new WorldPoint(2559, 3309, 0), new WorldPoint(3154, 3924, 0)),
	WILDERNESS_LEVER_EDGEVILLE("Wilderness Lever to Deserted Keep", new WorldPoint(3088, 3474, 0), new WorldPoint(3154, 3924, 0)),
	WILDERNESS_LEVER_WILDERNESS("Wilderness Lever to Ardougne/Edgeville", new WorldPoint(3154, 3924, 0));

	private final String tooltip;
	private final WorldPoint location;
	@Nullable
	private final WorldPoint target;

	TransportationPointLocation(String tooltip, WorldPoint worldPoint)
	{
		this(tooltip, worldPoint, null);
	}
}
