/*******************************************************************************
 * Copyright (c) 2019 openosrs
 * Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 * If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 * ST0NEWALL#9112
 * openosrs Discord: https://discord.gg/Q7wFtCe
 * openosrs website: https://openosrs.com
 ******************************************************************************/

package net.runelite.client.game;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Getter;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.util.PvPUtil;

public enum WorldLocation
{
	// Non-Wilderness Locations
	AGILITY_PYRAMID("Agility Pyramid", new Location(3334, 2864, 3386, 2819), 0),
	AL_KHARID_BANK("Al Kharid Bank", new Location(3265, 3173, 3272, 3161), 0),
	AL_KHARID_GLIDER("Al Kharid_Glider", new Location(3276, 3214, 3283, 3209), 0),
	AL_KHARID_PALACE("Al Kharid Palace", new Location(3281, 3177, 3304, 3158), 0),
	ZUL_ANDRA("Zul-Andra", new Location(2182, 3070, 2214, 3042), 0),
	APE_ATOLL_TEMPLE("Ape Atoll Temple", new Location(2784, 2802, 2810, 2770), 0),
	ARDY_CASTLE("Ardy Castle", new Location(2567, 3311, 2591, 3283), 0),
	ARDY_DOCKS("Ardy Docks", new Location(2660, 3284, 2689, 3264), 0),
	ARDY_NORTH_BANK("Ardy North Bank", new Location(2611, 3336, 2622, 3329), 0),
	ARDY_SOUTH_BANK("Ardy South Bank", new Location(2645, 3288, 2659, 3279), 0),
	ARDY_STALLS("Ardy Stalls", new Location(2651, 3318, 2673, 3293), 0),
	ARDY_ZOO("Ardy Zoo", new Location(2598, 3288, 2640, 3261), 0),
	BARB_VILLAGE("Barb Village", new Location(3071, 3448, 3092, 3405), 0),
	BARROWS("Barrows", new Location(3546, 3314, 3583, 3268), 0),
	BEDABIN_CAMP("Bedabin Camp", new Location(3157, 3052, 3188, 3019), 0),
	CAMELOT_CASTLE("Camelot Castle", new Location(2743, 3481, 2775, 3468), 0),
	CASTLE_WARS("Castle Wars", new Location(2435, 3127, 2474, 3074), 0),
	CATHERBY("Catherby", new Location(2791, 3457, 2833, 3436), 0),
	CATHERBY_DOCKS("Catherby Docks", new Location(2790, 3432, 2808, 3409), 0),
	CATHERBY_EAST("Catherby East", new Location(2834, 3441, 2862, 3425), 0),
	CATHERBY_NORTH("Catherby North", new Location(2791, 3472, 2833, 3458), 0),
	CLAN_WARS("Clan Wars", new Location(3344, 3176, 3391, 3142), 0),
	COOKS_GUILD("Cooks Guild", new Location(3135, 3455, 3155, 3427), 0),
	COX("CoX", new Location(1226, 3574, 1270, 3559), 0),
	CRAB_CLAW_ISLE("Crab Claw Isle", new Location(1745, 3449, 1795, 3399), 0),
	DESERT_BANDIT_CAMP("Desert Bandit Camp", new Location(3154, 2993, 3189, 2963), 0),
	DIGSITE_NORTHWEST("Digsite NorthWest", new Location(3325, 3445, 3353, 3420), 0),
	DIGSITE_NORTHEAST("Digsite NorthEast", new Location(3354, 3445, 3382, 3420), 0),
	DIGSITE_SOUTHEAST("Digsite SouthEast", new Location(3354, 3419, 3382, 3393), 0),
	DIGSITE_SOUTHWEST("Digsite SouthWest", new Location(3325, 3419, 3353, 3393), 0),
	DRYANOR_VILLAGE("Dryanor Village", new Location(3074, 3283, 3112, 3241), 0),
	DUEL_ARENA_ENTRANCE("Duel Arena Entrance", new Location(3311, 3247, 3328, 3223), 0),
	DUEL_ARENA_NORTH("Duel Arena North", new Location(3329, 3266, 3388, 3264), 0),
	DUEL_ARENA_NORTH_WEST("Duel Arena North West", new Location(3322, 3266, 3328, 3248), 0),
	EDGE_BANK("Edge Bank", new Location(3090, 3499, 3099, 3487), 0),
	FALADOR_PARTYROOM("Falador Partyroom", new Location(3035, 3386, 3056, 3370), 0),
	FALLY_BANK("Fally Bank", new Location(2943, 3372, 2949, 3358), 0),
	FALLY_CENTER("Fally Center", new Location(2959, 3385, 2972, 3374), 0),
	FALLY_EAST_BANK("Fally East Bank", new Location(3008, 3358, 3021, 3353), 0),
	FALLY_PARK("Fally Park", new Location(2982, 3390, 3025, 3368), 0),
	FALLY_RESPAWN("Fally Respawn", new Location(2957, 3355, 2998, 3325), 0),
	GNOME_AGILITY("Gnome Agility", new Location(2469, 3441, 2489, 3412), 0),
	GNOME_BALL("Gnome Ball", new Location(2384, 3495, 2408, 3479), 0),
	GRAND_EXCHANGE_NORTHEAST("Grand Exchange NorthEast", new Location(3165, 3516, 3197, 3490), 0),
	GRAND_EXCHANGE_NORTHWEST("Grand Exchange NorthWest", new Location(3139, 3516, 3164, 3490), 0),
	GRAND_EXCHANGE_SOUTHEAST("Grand Exchange SouthEast", new Location(3165, 3489, 3189, 3468), 0),
	GRAND_EXCHANGE_SOUTHWEST("Grand Exchange SouthWest", new Location(3139, 3489, 3164, 3467), 0),
	GRAND_TREE("Grand Tree", new Location(2442, 3515, 2490, 3478), 0),
	ICE_MOUNTAIN("Ice Mountain", new Location(3001, 3508, 3024, 3463), 0),
	TRAINING_GROUND("Training Ground", new Location(2501, 3387, 2534, 3358), 0),
	LUMBRIDGE_CASTLE("Lumbridge Castle", new Location(3201, 3235, 3225, 3201), 0),
	LUMBY_SWAMP("Lumby Swamp", new Location(3135, 3203, 3245, 3140), 0),
	LUNAR_ISLE_CENTRAL("Lunar Isle Central", new Location(2055, 3933, 2112, 3888), 0),
	LUNAR_ISLE_EAST("Lunar Isle East", new Location(2113, 3921, 2185, 3888), 0),
	LUNAR_ISLE_NORTH("Lunar Isle North", new Location(2063, 3958, 2112, 3934), 0),
	LUNAR_ISLE_NORTH_EAST("Lunar Isle North East", new Location(2113, 3958, 2185, 3922), 0),
	LUNAR_ISLE_SOUTH("Lunar Isle South", new Location(2057, 3887, 2112, 3843), 0),
	LUNAR_ISLE_SOUTHEAST("Lunar Isle SouthEast", new Location(2113, 3887, 2185, 3843), 0),
	MONASTERY("Monastery", new Location(3044, 3507, 3060, 3471), 0),
	NARDAH_NORTH("Nardah North", new Location(3397, 2942, 3453, 2915), 0),
	NARDAH_SOUTH("Nardah South", new Location(3397, 2914, 3453, 2882), 0),
	NIEVE("Nieve", new Location(2430, 3425, 2435, 3419), 0),
	NIGHTMARE_ZONE("Nightmare Zone", new Location(2599, 3119, 2614, 3111), 0),
	NORTH_MARIM("North Marim", new Location(2731, 2804, 2783, 2786), 0),
	PEST_CONTROL("Pest Control", new Location(2630, 2679, 2682, 2627), 0),
	POLLNIVNEACH_NORTH("Pollnivneach North", new Location(3331, 3004, 3379, 2974), 0),
	POLLNIVNEACH_SOUTH("Pollnivneach South", new Location(3331, 2973, 3379, 2941), 0),
	PORT_KHAZARD("Port Khazard", new Location(2624, 3182, 2680, 3143), 0),
	PORT_SARIM("Port Sarim", new Location(3009, 3261, 3060, 3194), 0),
	RELLEKA_SOUTH_WEST("Relleka South West", new Location(2609, 3678, 2649, 3644), 0),
	RELLEKKA_NORTH_EAST("Rellekka North East", new Location(2650, 3712, 2690, 3679), 0),
	RELLEKKA_NORTH_WEST("Rellekka North West", new Location(2609, 3712, 2649, 3679), 0),
	RELLEKKA_SOUTH_EAST("Rellekka South East", new Location(2650, 3678, 2690, 3644), 0),
	RIMMINGTON_PORTAL("Rimmington Portal", new Location(2946, 3228, 2960, 3218), 0),
	ROCK_CRABS_EAST("Rock Crabs East", new Location(2691, 3738, 2730, 3713), 0),
	ROCK_CRABS_WEST("Rock Crabs West", new Location(2650, 3738, 2690, 3713), 0),
	SANDCRABS_CENTRAL("SandCrabs Central", new Location(1850, 3529, 1884, 3465), 0),
	SANDCRABS_NORTH("SandCrabs North", new Location(1848, 3572, 1884, 3532), 0),
	SANDCRABS_SOUTH("SandCrabs South", new Location(1796, 3468, 1849, 3436), 0),
	SEERS_VILLAGE("Seers Village", new Location(2688, 3498, 2742, 3468), 0),
	SHANTAY_PASS("Shantay Pass", new Location(3293, 3137, 3312, 3116), 0),
	SHILO_VILLAGE_NORTH("Shilo Village North", new Location(2817, 3006, 2878, 2973), 0),
	SHILO_VILLAGE_SOUTH("Shilo Village South", new Location(2816, 2972, 2879, 2944), 0),
	SOUTH_MARIM("South Marim", new Location(2731, 2785, 2783, 2762), 0),
	SOUTH_OF_GRAND_EXCHANGE("South of Grand Exchange", new Location(3156, 3466, 3190, 3448), 0),
	TREEGOME_VILLAGE("TreeGome Village", new Location(2514, 3175, 2547, 3158), 0),
	VARROCK_CENTRE("Varrock Centre", new Location(3201, 3444, 3229, 3412), 0),
	VARROCK_EAST("Varrock East", new Location(3228, 3450, 3241, 3438), 0),
	VARROCK_WEST("Varrock West", new Location(3172, 3447, 3200, 3427), 0),
	WATERBIRTH_ISLAND("Waterbirth Island", new Location(2494, 3774, 2562, 3710), 0),
	WEST_ARDY("West Ardy", new Location(2452, 3336, 2557, 3265), 0),
	WINDERTODT_SOUTH_EAST("Windertodt South East", new Location(1630, 4007, 1651, 3987), 0),
	WINTERTODT_CAMP("Wintertodt Camp", new Location(1616, 3963, 1645, 3932), 0),
	WINTERTODT_ENTRANCE("Wintertodt Entrance", new Location(1617, 3986, 1641, 3964), 0),
	WINTERTODT_NORTHEAST("Wintertodt NorthEast", new Location(1630, 4027, 1651, 4008), 0),
	WINTERTODT_NORTHWEST("Wintertodt NorthWest", new Location(1608, 4028, 1629, 4008), 0),
	WINTERTODT_SOUTHWEST("Wintertodt SouthWest", new Location(1608, 4007, 1629, 3987), 0),
	WIZARDS_GUILD("Wizards Guild", new Location(2585, 3092, 2596, 3082), 0),
	WIZARDS_TOWER("Wizards Tower", new Location(3093, 3171, 3121, 3146), 0),
	YANILE_BANK("Yanile Bank", new Location(2608, 3097, 2616, 3087), 0),
	YANILLE_EAST("Yanille East", new Location(2576, 3110, 2621, 3071), 0),
	YANILLE_PORTAL("Yanille Portal", new Location(2537, 3108, 2551, 3091), 0),
	YANILLE_WEST("Yanille West", new Location(2532, 3110, 2575, 3071), 0),
	AXE_HUT("Axe Hut", new Location(3187, 3962, 3194, 3957), 0),
	BANDIT_CAMP("Bandit Camp", new Location(3017, 3712, 3059, 3681), 0),
	CALLISTO("Callisto", new Location(3266, 3863, 3315, 3827), 0),
	CEMETERY("Cemetery", new Location(2956, 3767, 2996, 3736), 0),
	CHAOS_FANATIC("Chaos Fanatic", new Location(2971, 3854, 2992, 3834), 0),
	CHAOS_TEMPLE("Chaos Temple", new Location(3220, 3632, 3255, 3593), 0),
	CHINS("Chins", new Location(3128, 3792, 3160, 3754), 0),
	CORP_CAVE("Corp Cave", new Location(3201, 3684, 3219, 3672), 0),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist", new Location(2952, 3709, 2985, 3678), 0),
	DARK_WARRIORS("Dark Warriors", new Location(3014, 3648, 3046, 3616), 0),
	DWARVES("Dwarves", new Location(3230, 3805, 3264, 3779), 0),
	EAST_DRAGS("East Drags", new Location(3326, 3704, 3365, 3671), 0),
	ENTS("Ents", new Location(3300, 3627, 3320, 3584), 0),
	FIFTY_PORTS("50 ports", new Location(3301, 3923, 3315, 3909), 0),
	FIRE_GIANT_ENTRANCE("Fire Giant Entrance", new Location(3042, 3929, 3051, 3920), 0),
	GAP("Gap", new Location(3238, 3855, 3258, 3841), 0),
	GDZ("Gdz", new Location(3279, 3895, 3296, 3875), 0),
	GHORROCK("44s", new Location(2973, 3870, 2987, 3859), 0),
	GLORY_HILL("Glory Hill", new Location(3331, 3890, 3348, 3866), 0),
	GLORY_HOLE("Glory Hole", new Location(3352, 3897, 3386, 3869), 0),
	GRAVES("Graves", new Location(3128, 3686, 3181, 3658), 0),
	GRAVEYARD_DRAGS("Graveyard Drags", new Location(3129, 3717, 3172, 3691), 0),
	GOD_WARS_DUNGEON("God Wars Dungeon", new Location(3010, 3745, 3027, 3727), 0),
	HIGH_ALTAR("High Altar", new Location(2945, 3826, 2970, 3813), 0),
	HILL_GIANTS("Hill Giants", new Location(3282, 3687, 3300, 3674), 0),
	HOB_OBELISK("35 Obelisk", new Location(3097, 3804, 3115, 3785), 0),
	HOBGOBLINS("Hobgoblins", new Location(3073, 3775, 3104, 3745), 0),
	ICE_GATE("Ice Gate", new Location(2945, 3913, 2978, 3878), 0),
	ICE_ROCK("Ice Rock", new Location(2957, 3942, 2984, 3929), 0),
	KBD_CAGE("KBD CAGE", new Location(3007, 3855, 3021, 3839), 0),
	LAVA_DRAGS("Lava Drags", new Location(3175, 3857, 3221, 3805), 0),
	LAVA_MAZE_TELE("Lava Maze Tele", new Location(3019, 3842, 3044, 3812), 0),
	LEVER("Lever", new Location(3149, 3933, 3162, 3917), 0),
	MAGE_ARENA("Mage Arena", new Location(3088, 3949, 3123, 3919), 0),
	MAGE_BANK("Mage Bank", new Location(3082, 3960, 3103, 3952), 0),
	NEW_GATE("New Gate", new Location(3345, 3957, 3390, 3916), 0),
	PORTS_19("19s", new Location(3220, 3672, 3234, 3660), 0),
	OLD_GATE("Old Gate", new Location(3211, 3906, 3238, 3882), 0),
	PIRATE_HUT("Pirate Hut", new Location(3037, 3959, 3045, 3948), 0),
	RESOURCE_ARENA("Resource Arena", new Location(3174, 3946, 3195, 3923), 0),
	REV_BLACK_DRAGS("Rev Black Drags", new Location(3223, 10216, 3254, 10190), 0),
	REV_CAVE("Rev Cave", new Location(3128, 10232, 3225, 10059), 0),
	REV_DARK_BEAST("Rev Dark Beast", new Location(3243, 10154, 3264, 10136), 0),
	REV_ENTRANCE("Rev Entrance", new Location(3118, 3837, 3142, 3818), 0),
	INSIDE_REV_ENT("Inside Rev Ent.", new Location(3238, 10236, 3243, 10231), 0),
	MAIN_REV_CHAMBER("Main Rev Chamber", new Location(3227, 10187, 3261, 10157), 0),
	ROGUE_CASTLE("Rogue Castle", new Location(3275, 3947, 3299, 3920), 0),
	RUNE_ROCKS("Rune Rocks", new Location(3055, 3890, 3072, 3876), 0),
	SCORPIA("Scorpia", new Location(3216, 3949, 3248, 3935), 0),
	SINGLE_STRIP("Single Strip", new Location(3333, 3842, 3348, 3774), 0),
	LVL_18_REV_ENT("Lvl 18 Rev Ent", new Location(3071, 3660, 3092, 3645), 0),
	SPIDER_HILL("Spider Hill", new Location(3156, 3896, 3182, 3871), 0),
	PORTAL_13S("13s", new Location(3145, 3628, 3168, 3609), 0),
	VENENATIS("Venenatis", new Location(3298, 3759, 3353, 3722), 0),
	VETTION("Vet'tion", new Location(3183, 3796, 3227, 3765), 0),
	VOLCANO("Volcano", new Location(3345, 3957, 3390, 3916), 0),
	WEB("Web", new Location(3153, 3961, 3163, 3948), 0),
	WEST_DRAGS("West Drags", new Location(2960, 3627, 2992, 3598), 0),
	WILDY_AGILITY_COURSE("Wildy Agility Course", new Location(2988, 3967, 3008, 3906), 0);


	@Getter
	private final String name;
	@Getter
	private final WorldArea worldArea;
	@Getter
	private final Location location;

	/**
	 * Creates a location used to get the name of a location by a WorldPoint
	 *
	 * @param name     - The name that is used to represent the area in overlays etc
	 * @param location - A Location made out of 4 points on the world map
	 * @param plane    - The plane of the World Area
	 */
	WorldLocation(String name, Location location, int plane)
	{
		this.name = name;
		this.location = location;
		this.worldArea = new WorldArea(location.x, location.y, location.width, location.height, plane);
	}

	/**
	 * Returns all locations that aren't in the wild
	 * @return - A Collection of non-wilderness WorldLocations
	 */
	public static Collection<WorldLocation> getNonWildernessLocations()
	{
		return Arrays.stream(WorldLocation.values()).filter(loc ->
			PvPUtil.getWildernessLevelFrom(loc.worldArea.toWorldPoint()) < 0).collect(Collectors.toList());
	}

	/**
	 * Returns only the WorldLocations that are in the wilderness
	 * @return - A Collection of WorldLocations in the wilderness
	 */
	public static Collection<WorldLocation> getWildernessLocations()
	{
		return Arrays.stream(WorldLocation.values()).filter(loc ->
			PvPUtil.getWildernessLevelFrom(loc.worldArea.toWorldPoint()) > 0).collect(Collectors.toList());
	}

	public static Map<WorldArea, String> getLocationMap()
	{
		Map<WorldArea, String> hashMap = new HashMap<>();
		Arrays.stream(values()).forEach(worldLocation ->
			hashMap.put(worldLocation.getWorldArea(), worldLocation.getName()));
		return hashMap;
	}

	/**
	 * Returns the WorldLocation that a WorldPoint is in, or the closest WorldLocation to the point
	 * @param worldPoint - the WorldPoint to find the WorldLocation of
	 * @return - Containing location or closest location if it isn't in any
	 */
	public static String location(WorldPoint worldPoint)
	{
		final Map<WorldArea, String> locationMap = getLocationMap();
		int dist = 10000;
		String s = "";
		WorldArea closestArea = null;
		for (Map.Entry<WorldArea, String> entry : locationMap.entrySet())
		{
			WorldArea worldArea = entry.getKey();

			if (worldArea.toWorldPointList().contains(worldPoint))
			{
				s = entry.getValue();
				return s;
			}
			int distTo = worldArea.distanceTo(worldPoint);
			if (distTo < dist)
			{
				dist = distTo;
				closestArea = worldArea;
			}
		}
		if (worldPoint.getY() > (Objects.requireNonNull(closestArea).toWorldPoint().getY() + closestArea.getHeight()))
		{
			s = s + "N";
		}
		if (worldPoint.getY() < closestArea.toWorldPoint().getY())
		{
			s = s + "S";
		}
		if (worldPoint.getX() < closestArea.toWorldPoint().getX())
		{
			s = s + "W";
		}
		if (worldPoint.getX() > (closestArea.toWorldPoint().getX() + closestArea.getWidth()))
		{
			s = s + "E";
		}
		s = s + " of ";
		s = s + locationMap.get(closestArea);
		if (s.startsWith(" of "))
		{
			s = s.substring(3);
		}
		return s;
	}


	public static class Location
	{
		@Getter
		private final int x;
		@Getter
		private final int y;
		@Getter
		private final int x1;
		@Getter
		private final int y1;
		final int width;
		final int height;

		Location(int x, int y, int x1, int y1)
		{
			this.x = x;
			this.y = y;
			this.x1 = x1;
			this.y1 = y1;
			this.width = x1 - x;
			this.height = y - y1;
		}

		@Override
		public String toString()
		{
			return "Location{" +
				"x=" + x +
				", y=" + y +
				", width=" + width +
				", height=" + height +
				'}';
		}
	}

	@Override
	public String toString()
	{
		return "WorldLocation{" +
			"name='" + name + '\'' +
			", worldArea=" + worldArea +
			'}';
	}
}
