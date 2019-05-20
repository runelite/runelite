package net.runelite.client.util;

import lombok.Getter;
import net.runelite.api.coords.WorldArea;

public enum WildernessLocation
{

	REV_CAVE_OTHER("Rev Cave", new Location(3128, 10232, 3225, 10059), 0),
	REV_BLACK_DRAGS("Rev Black Drags", new Location(3223, 10216, 3254, 10190), 0),
	REV_DARK_BEAST("Rev Dark Beast", new Location(3243, 10154, 3264, 10136), 0),
	REV_MAIN_CHAMBER("Main Rev Chamber", new Location(3227, 10187, 3261, 10157), 0),
	REV_ENTRANCE_INSIDE("Inside Rev Ent.", new Location(3238, 10236, 3243, 10231), 0),
	ICE_ROCK("Ice Rock", new Location(2957, 3942, 2984, 3929), 0),
	WILDY_AGILITY_COURSE("Wildy Agility Course", new Location(2988, 3967, 3008, 3906), 0),
	FIRE_GIANT_ENTRANCE("Fire Giant Entrance", new Location(3042, 3929, 3051, 3920), 0),
	PIRATE_HUT("Pirate Hut", new Location(3037, 3959, 3045, 3948), 0),
	MAGE_BANK("Mage Bank", new Location(3082, 3960, 3103, 3952), 0),
	MAGE_ARENA("Mage Arena", new Location(3088, 3949, 3123, 3919), 0),
	LEVER("Lever", new Location(3149, 3933, 3162, 3917), 0),
	WEB("Web", new Location(3153, 3961, 3163, 3948), 0),
	RESOURCE_ARENA("Resource Arena", new Location(3174, 3946, 3195, 3923), 0),
	AXE_HUT("Axe Hut", new Location(3187, 3962, 3194, 3957), 0),
	SCORPIA("Scorpia", new Location(3216, 3949, 3248, 3935), 0),
	ROGUE_CASTLE("Rogue Castle", new Location(3275, 3947, 3299, 3920), 0),
	FIFTY_PORTS("50 ports", new Location(3301, 3923, 3315, 3909), 0),
	VOLCANO("Volcano", new Location(3345, 3957, 3390, 3916), 0),
	NEW_GATE("New Gate", new Location(3345, 3957, 3390, 3916), 0),
	GLORY_HOLE("Glory Hole", new Location(3352, 3897, 3386, 3869), 0),
	GLORY_HILL("Glory Hill", new Location(3331, 3890, 3348, 3866), 0),
	GDZ("Gdz", new Location(3279, 3895, 3296, 3875), 0),
	GAP("Gap", new Location(3238, 3855, 3258, 3841), 0),
	OLD_GATE("Old Gate", new Location(3211, 3906, 3238, 3882), 0),
	LAVA_DRAGS("Lava Drags", new Location(3175, 3857, 3221, 3805), 0),
	SPIDER_HILL("Spider Hill", new Location(3156, 3896, 3182, 3871), 0),
	RUNE_ROCKS("Rune Rocks", new Location(3055, 3890, 3072, 3876), 0),
	ICE_GATE("Ice Gate", new Location(2945, 3913, 2978, 3878), 0),
	VENENATIS("Venenatis", new Location(3298, 3759, 3353, 3722), 0),
	SINGLE_STRIP("Single Strip", new Location(3333, 3842, 3348, 3774), 0),
	CALLISTO("Callisto", new Location(3266, 3863, 3315, 3827), 0),
	DWARVES("Dwarves", new Location(3230, 3805, 3264, 3779), 0),
	VETTION("Vet'tion", new Location(3183, 3796, 3227, 3765), 0),
	EAST_DRAGONS("East Drags", new Location(3326, 3704, 3365, 3671), 0),
	HILL_GIANTS("Hill Giants", new Location(3282, 3687, 3300, 3674), 0),
	ENTS("Ents", new Location(3300, 3627, 3320, 3584), 0),
	CHAOS_TEMPLE("Chaos Temple", new Location(3220, 3632, 3255, 3593), 0),
	NINETEEN_OBELISK("19s", new Location(3220, 3672, 3234, 3660), 0),
	CORP_CAVE("Corp Cave", new Location(3201, 3684, 3219, 3672), 0),
	THIRTEEN_OBELISK("13s", new Location(3145, 3628, 3168, 3609), 0),
	SOUTH_REV_ENTRANCE("Lvl 18 Rev Ent", new Location(3071, 3660, 3092, 3645), 0),
	GRAVES("Graves", new Location(3128, 3686, 3181, 3658), 0),
	GRAVEYARD_DRAGS("Graveyard Drags", new Location(3129, 3717, 3172, 3691), 0),
	CHINS("Chins", new Location(3128, 3792, 3160, 3754), 0),
	REV_ENTRANCE("Rev Entrance", new Location(3118, 3837, 3142, 3818), 0),
	HOB_OBELISK("35 Obelisk", new Location(3097, 3804, 3115, 3785), 0),
	HOBGOBLINS("Hobgoblins", new Location(3073, 3775, 3104, 3745), 0),
	GWD("God Wars Dungeon", new Location(3010, 3745, 3027, 3727), 0),
	LAVA_MAZE_TELE("Lava Maze Tele", new Location(3019, 3842, 3044, 3812), 0),
	KBD_CAGE("KBD CAGE", new Location(3007, 3855, 3021, 3839), 0),
	GHORROCK("44s", new Location(2973, 3870, 2987, 3859), 0),
	CHAOS_FANATIC("Chaos Fanatic", new Location(2971, 3854, 2992, 3834), 0),
	HIGH_ALTAR("High Altar", new Location(2945, 3826, 2970, 3813), 0),
	CEMETERY("Cemetery", new Location(2956, 3767, 2996, 3736), 0),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist", new Location(2952, 3709, 2985, 3678), 0),
	DARK_WARRIOR_FORTRESS("Dark Warriors", new Location(3014, 3648, 3046, 3616), 0),
	WEST_DRAGONS("West Drags", new Location(2960, 3627, 2992, 3598), 0),
	BANDIT_CAMP("Bandit Camp", new Location(3017, 3712, 3059, 3681), 0);

	@Getter
	private final String name;
	@Getter
	private final WorldArea worldArea;

	WildernessLocation(String name, Location location, int plane)
	{
		this.name = name;
		this.worldArea = new WorldArea(location.x, location.y, location.width, location.height, plane);
	}

	public static class Location
	{
		public int x;
		public int y;
		public int width;
		public int height;

		Location(int x, int y, int x1, int y1)
		{
			this.x = x;
			this.y = y1;
			this.width = x1 - x;
			this.height = y - y1;
		}
	}
}
