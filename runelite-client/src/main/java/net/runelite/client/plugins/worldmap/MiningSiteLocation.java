/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
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

import com.google.common.base.Joiner;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

@Getter
enum MiningSiteLocation
{
	AGILITY_PYRAMID(new WorldPoint(3322, 2875, 0), new Rock(5, Ore.GOLD)),
	// ABANDONED_MINE -- NOT AVAILABLE ON WORLDMAP
	AL_KHARID_MINE_NORTH(new WorldPoint(3298, 3312, 0),
		new Rock(3, Ore.COPPER), new Rock(1, Ore.TIN), new Rock(7, Ore.IRON), new Rock(5, Ore.SILVER),
		new Rock(3, Ore.COAL), new Rock(3, Ore.MITHRIL), new Rock(2, Ore.ADAMANTITE)),
	AL_KHARID_MINE_SOUTH(new WorldPoint(3298, 3282, 0), new Rock(2, Ore.IRON), new Rock(2, Ore.GOLD)),
	ANCIENT_CAVERN_NORTH(new WorldPoint(1847, 5414, 0), new Rock(4, Ore.MITHRIL)),
	ANCIENT_CAVERN_SOUTH(new WorldPoint(1826, 5392, 0), new Rock(2, Ore.MITHRIL)),
	ANCIENT_CAVERN_MIDDLE(new WorldPoint(1840, 5397, 0), new Rock(8, Ore.MITHRIL)),
	ARANDAR(new WorldPoint(2322, 3269, 0), new Rock(8, Ore.LIMESTONE)),
	ARANDAR_PRIFDDINAS_MAP(new WorldPoint(3346, 6021, 0), new Rock(8, Ore.LIMESTONE)),
	ARCEUUS_NORTH(new WorldPoint(1763, 3860, 0), new Rock(1, Ore.DENSE_ESSENCE)),
	ARCEUUS_SOUTH(new WorldPoint(1763, 3844, 0), new Rock(1, Ore.DENSE_ESSENCE)),
	ARDOUGNE_SEWERS(new WorldPoint(2670, 9680, 0), new Rock(5, Ore.IRON), new Rock(5, Ore.COAL)),
	ARDOUGNE_SOUTH_EAST(new WorldPoint(2599, 3232, 0), new Rock(6, Ore.IRON), new Rock(4, Ore.COAL)),
	// ARZINIAN_MINE -- NOT AVAILABLE ON WORLD MAP
	ASGARNIA_ICE_DUNGEON_EAST(new WorldPoint(3063, 9582, 0), new Rock(2, Ore.BLURITE)),
	ASGARNIA_ICE_DUNGEON_WEST(new WorldPoint(3049, 9568, 0), new Rock(2, Ore.BLURITE)),
	BANDIT_CAMP_MINE(new WorldPoint(3086, 3763, 0), new Rock(16, Ore.IRON), new Rock(20, Ore.COAL), new Rock(22, Ore.MITHRIL), new Rock(8, Ore.ADAMANTITE)),
	BANDIT_CAMP_QUARRY(new WorldPoint(3171, 2912, 0), new Rock(4, Ore.CLAY), new Rock(2, Ore.COAL), new Rock(32, Ore.SANDSTONE), new Rock(28, Ore.GRANITE)),
	BARBARIAN_VILLAGE(new WorldPoint(3078, 3421, 0), new Rock(5, Ore.TIN), new Rock(4, Ore.COAL)),
	BATTLEFIELD(new WorldPoint(2471, 3255, 0), new Rock(3, Ore.COPPER), new Rock(1, Ore.TIN)),
	BLAST_MINE_EAST(new WorldPoint(1502, 3869, 0), new Rock(20, Ore.HARD_ROCK)),
	BLAST_MINE_NORTH(new WorldPoint(1485, 3882, 0), new Rock(17, Ore.HARD_ROCK)),
	BLAST_MINE_WEST(new WorldPoint(1471, 3865, 0), new Rock(22, Ore.HARD_ROCK)),
	BRIMHAVEN_NORTH(new WorldPoint(2732, 3225, 0), new Rock(10, Ore.GOLD)),
	BRIMHAVEN_SOUTH_(new WorldPoint(2743, 3150, 0), new Rock(6, Ore.GOLD)),
	CENTRAL_FREMENIK_ISLES(new WorldPoint(2374, 3850, 0), new Rock(7, Ore.COAL), new Rock(1, Ore.RUNITE)),
	CITHAREDE_ABBEY(new WorldPoint(3400, 3170, 0), new Rock(3, Ore.IRON), new Rock (3, Ore.COAL)),
	COAL_TRUCKS(new WorldPoint(2580, 3484, 0), new Rock(18, Ore.COAL)),
	CRAFTING_GUILD(new WorldPoint(2939, 3283, 0), new Rock(6, Ore.CLAY), new Rock(6, Ore.SILVER), new Rock(7, Ore.GOLD)),
	CRANDOR_NORTH_EAST(new WorldPoint(2860, 3287, 0), new Rock(3, Ore.GOLD)),
	CRANDOR_NORTH_WEST(new WorldPoint(2831, 3296, 0), new Rock(7, Ore.COAL), new Rock(1, Ore.MITHRIL)),
	CRANDOR_SOUTH_EAST(new WorldPoint(2835, 3245, 0), new Rock(3, Ore.COAL), new Rock(3, Ore.ADAMANTITE)),
	CRANDOR_SOUTH_WEST(new WorldPoint(2819, 3247, 0), new Rock(7, Ore.MITHRIL)),
	DAEYALT_ESSENCE_MINE(new WorldPoint(3631, 3340, 0), new Rock(3, Ore.DAEYALT_ESSENCE)),
	DESERT_MINING_CAMP_SURFACE(new WorldPoint(3299, 3021, 0), true, new Rock(4, Ore.COPPER), new Rock(4, Ore.TIN), new Rock(3, Ore.IRON), new Rock(4, Ore.COAL)),
	// DESERT_MINING_CAMP_UNDERGROUND -- NOT AVAILABLE ON WORLDMAP
	DORGESH_KAAN_NORTH(new WorldPoint(3309, 9645, 0), new Rock(1, Ore.IRON), new Rock(9, Ore.SILVER)),
	DORGESH_KAAN_SOUTH_EAST(new WorldPoint(3322, 9616, 0), new Rock(3, Ore.IRON)),
	DORGESH_KAAN_SOUTH_WEST(new WorldPoint(3312, 9621, 0), new Rock(3, Ore.IRON)),
	DORGESH_KAAN_WEST(new WorldPoint(3311, 9628, 0), new Rock(3, Ore.IRON), new Rock(2, Ore.SILVER)),
	DWARVEN_EAST_BOTTOM(new WorldPoint(3039, 9763, 0),
		new Rock(5, Ore.TIN), new Rock(2, Ore.IRON), new Rock(8, Ore.COAL), new Rock(2, Ore.GOLD), new Rock(1, Ore.ADAMANTITE)),
	DWARVEN_EAST_MIDDLE(new WorldPoint(3037, 9775, 0),
		new Rock(4, Ore.COPPER), new Rock(3, Ore.IRON), new Rock(3, Ore.COAL), new Rock(2, Ore.MITHRIL), new Rock(2, Ore.ADAMANTITE)),
	DWARVEN_EAST_TOP(new WorldPoint(3051, 9820, 0), new Rock(2, Ore.CLAY), new Rock(3, Ore.TIN), new Rock(2, Ore.IRON)),
	DWARVEN_WEST_BOTTOM(new WorldPoint(3028, 9809, 0), new Rock(3, Ore.CLAY), new Rock(4, Ore.COPPER)),
	DWARVEN_WEST_TOP(new WorldPoint(3031, 9828, 0), new Rock(3, Ore.COPPER), new Rock(2, Ore.TIN), new Rock(2, Ore.IRON)),
	FREMENIK_ISLES_EAST(new WorldPoint(2405, 3867, 0), new Rock(3, Ore.COPPER), new Rock(3, Ore.TIN), new Rock(4, Ore.COAL)),
	EAGLES_OUTPOST(new WorldPoint(3424, 3164, 0), new Rock(7, Ore.CLAY)),
	EDGEVILLE_DUNGEON(new WorldPoint(3138, 9874, 0),
		new Rock(2, Ore.COPPER), new Rock(2, Ore.TIN), new Rock(3, Ore.IRON), new Rock(3, Ore.SILVER),
		new Rock(6, Ore.COAL), new Rock(1, Ore.MITHRIL), new Rock(2, Ore.ADAMANTITE)),
	// EVIL_CHICKEN_LAIR  -- NOT AVAILABLE ON WORLD MAP
	FALADOR_WEST(new WorldPoint(2907, 3362, 0),
		new Rock(2, Ore.COPPER), new Rock(6, Ore.TIN), new Rock(3, Ore.IRON), new Rock(2, Ore.COAL)),
	FELDIP_HILLS_EAST(new WorldPoint(2638, 2996, 0), new Rock(3, Ore.ROCK)),
	FELDIP_HILLS_MIDDLE(new WorldPoint(2579, 2998, 0), new Rock(4, Ore.ROCK)),
	FELDIP_HILLS_WEST(new WorldPoint(2567, 2961, 0), new Rock(3, Ore.ROCK)),
	FIGHT_ARENA(new WorldPoint(2630, 3142, 0),
		new Rock(4, Ore.CLAY), new Rock(2, Ore.COPPER), new Rock(7, Ore.TIN), new Rock(9, Ore.IRON),
		new Rock(1, Ore.COAL), new Rock(2, Ore.MITHRIL)),
	FOSSIL_ISLAND(new WorldPoint(3770, 3815, 0),
		new Rock(7, Ore.IRON), new Rock(20, Ore.COAL), new Rock(3, Ore.MITHRIL), new Rock(5, Ore.ADAMANTITE),
		new Rock(2, Ore.RUNITE)),
	FREMENNIK_ISLES_WEST(new WorldPoint(2310, 3853, 0), new Rock(3, Ore.COPPER)),
	FROZEN_WASTE_PLATEU_CENTER(new WorldPoint(2963, 3933, 0), new Rock(1, Ore.RUNITE)),
	FROZEN_WASTE_PLATEU_NORTH(new WorldPoint(2975, 3937, 0), new Rock(1, Ore.RUNITE)),
	FROZEN_WASTE_PLATEU_SOUTH(new WorldPoint(2947, 3914, 0), new Rock(1, Ore.RUNITE)),
	GRAND_TREE(new WorldPoint(2489, 9916, 0),
		new Rock(9, Ore.CLAY), new Rock(8, Ore.IRON), new Rock(4, Ore.SILVER), new Rock(11, Ore.COAL),
		new Rock(4, Ore.GOLD), new Rock(4, Ore.MITHRIL), new Rock(3, Ore.ADAMANTITE)),
	GWENITH(new WorldPoint(2163, 3415, 0), new Rock(10, Ore.GOLD)),
	GWENITH_PRIFDDINAS_MAP(new WorldPoint(3187, 6167, 0), new Rock(10, Ore.GOLD)),
	HEROES_GUILD_EAST_BOTTOM(new WorldPoint(2939, 9898, 0), new Rock(3, Ore.COAL), new Rock(2, Ore.RUNITE)),
	HEROES_GUILD_EAST_TOP(new WorldPoint(2940, 9884, 0), new Rock(5, Ore.COAL)),
	HEROES_GUILD_WEST_BOTTOM(new WorldPoint(2921, 9904, 0), new Rock(3, Ore.COAL)),
	HEROES_GUILD_WEST_TOP(new WorldPoint(2914, 9916, 0), new Rock(2, Ore.MITHRIL), new Rock(2, Ore.ADAMANTITE)),
	HOSIDIUS_MINE(new WorldPoint(1777, 3489, 0),
		new Rock(10, Ore.CLAY), new Rock(11, Ore.COPPER), new Rock(4, Ore.TIN), new Rock(9, Ore.IRON),
		new Rock(2, Ore.SILVER)),
	ISAFDAR(new WorldPoint(2277, 3159, 0), new Rock(4, Ore.ADAMANTITE), new Rock(2, Ore.RUNITE)),
	ISLE_OF_SOULS_DUNGEON_EAST(new WorldPoint(1831, 9109, 0), new Rock(1, Ore.RUNITE)),
	ISLE_OF_SOULS_DUNGEON_WEST(new WorldPoint(1814, 9116, 0), new Rock(2, Ore.ADAMANTITE)),
	ISLE_OF_SOULS_SOUTH(new WorldPoint(2195, 2793, 0),
		new Rock(3, Ore.CLAY), new Rock(3, Ore.TIN), new Rock(3, Ore.COPPER), new Rock(10, Ore.IRON),
		new Rock(3, Ore.SILVER), new Rock(6, Ore.COAL), new Rock(4, Ore.GOLD), new Rock(2, Ore.MITHRIL)),
	JATIZSO(new WorldPoint(2396, 3812, 0),
		new Rock(11, Ore.TIN), new Rock(7, Ore.IRON), new Rock(8, Ore.COAL), new Rock(15, Ore.MITHRIL),
		new Rock(11, Ore.ADAMANTITE)),
	KARAMJA_JUNGLE(new WorldPoint(2848, 3033, 0),
		new Rock(1, Ore.IRON), new Rock(1, Ore.SILVER), new Rock(1, Ore.COAL), new Rock(2, Ore.MITHRIL),
		new Rock(2, Ore.ADAMANTITE)),
	KARAMJA_VOLCANO(new WorldPoint(2856, 9579, 0), new Rock(4, Ore.GOLD)),
	KEBOS_LOWLANDS(new WorldPoint(1211, 3657, 0), new Rock(4, Ore.ADAMANTITE), new Rock(5, Ore.MITHRIL)),
	KELDAGRIM_ENTRANCE(new WorldPoint(2724, 3693, 0), new Rock(9, Ore.IRON), new Rock(2, Ore.MITHRIL)),
	KELDAGRIM_NORTH_EAST(new WorldPoint(2937, 10232, 0), new Rock(9, Ore.COAL)),
	KELDAGRIM_SOUTH_WEST_BOTTOM(new WorldPoint(2872, 10119, 0), new Rock(2, Ore.COPPER), new Rock(5, Ore.COAL)),
	KELDAGRIM_SOUTH_WEST_MIDDLE(new WorldPoint(2818, 10156, 0), new Rock(4, Ore.IRON), new Rock(1, Ore.GOLD)),
	KELDAGRIM_SOUTH_WEST_TOP(new WorldPoint(2864, 10170, 0), new Rock(5, Ore.TIN)),
	LAVA_MAZE_DUNGEON(new WorldPoint(3045, 10263, 0), true, new Rock(1, Ore.RUNITE)),
	LAVA_MAZE_NORTH(new WorldPoint(3059, 3884, 0), new Rock(2, Ore.RUNITE)),
	LEGENDS_GUILD_EAST(new WorldPoint(2709, 3331, 0), new Rock(6, Ore.IRON), new Rock(8, Ore.COAL)),
	LEGENDS_GUILD_WEST(new WorldPoint(2694, 3332, 0), new Rock(5, Ore.IRON), new Rock(5, Ore.COAL)),
	LOVAKENGJ_SOUTH(new WorldPoint(1476, 3779, 0), new Rock(4, Ore.IRON), new Rock(6, Ore.COAL), new Rock(1, Ore.MITHRIL)),
	LOVAKENGJ_SULPHUR_EAST(new WorldPoint(1445, 3870, 0), new Rock(3, Ore.VOLCANIC_SULPHUR)),
	LOVAKENGJ_SULPHUR_WEST(new WorldPoint(1427, 3870, 0), new Rock(2, Ore.VOLCANIC_SULPHUR)),
	LOVAKENGJ_WEST(new WorldPoint(1432, 3845, 0), true, new Rock(45, Ore.COAL), new Rock(80, Ore.LOVAKITE)),
	LUMBRIDGE_SWAMP_EAST(new WorldPoint(3226, 3146, 0), new Rock(5, Ore.COPPER), new Rock(5, Ore.TIN)),
	LUMBRIDGE_SWAMP_WEST(new WorldPoint(3148, 3149, 0),
		new Rock(7, Ore.COAL), new Rock(5, Ore.MITHRIL), new Rock(2, Ore.ADAMANTITE)),
	// Lunar Isle Dungeon: Starting north-east and going clockwise
	LUNAR_ISLE_1(new WorldPoint(2163, 10347, 0),
		new Rock(2, Ore.SILVER), new Rock(1, Ore.GOLD), new Rock(1, Ore.GEM_ROCK), new Rock(6, Ore.LUNAR)),
	LUNAR_ISLE_2(new WorldPoint(2165, 10325, 0), new Rock(3, Ore.GEM_ROCK), new Rock(4, Ore.LUNAR)),
	LUNAR_ISLE_3(new WorldPoint(2140, 10318, 0), new Rock(3, Ore.SILVER), new Rock(3, Ore.LUNAR)),
	LUNAR_ISLE_4(new WorldPoint(2125, 10327, 0), new Rock(4, Ore.GOLD), new Rock(1, Ore.LUNAR)),
	LUNAR_ISLE_5(new WorldPoint(2124, 10342, 0), new Rock(2, Ore.GOLD), new Rock(5, Ore.LUNAR)),
	MINING_GUILD_AMETHYST(new WorldPoint(3022, 9704, 0), new Rock(26, Ore.AMETHYST)),
	MINING_GUILD_NORTH(new WorldPoint(3040, 9740, 0),
		new Rock(4, Ore.IRON), new Rock(37, Ore.COAL), new Rock(5, Ore.MITHRIL), new Rock(2, Ore.ADAMANTITE)),
	MINING_GUILD_SOUTH(new WorldPoint(3032, 9720, 0),
		new Rock(8, Ore.IRON), new Rock(20, Ore.COAL), new Rock(10, Ore.MITHRIL), new Rock(8, Ore.ADAMANTITE),
		new Rock(2, Ore.RUNITE)),
	MISCELLANIA(new WorldPoint(2526, 3891, 0), new Rock(9, Ore.COAL)),
	MISCELLANIA_DUNGEON(new WorldPoint(2504, 10287, 0), new Rock(4, Ore.COAL)),
	MOR_UL_REK_NORTH(new WorldPoint(2458, 5167, 0), new Rock(3, Ore.SILVER), new Rock(3, Ore.GOLD)),
	MOR_UL_REK_SOUTH_EAST(new WorldPoint(2513, 5074, 0), new Rock(6, Ore.SILVER), new Rock(7, Ore.GOLD)),
	MOR_UL_REK_SOUTH_WEST(new WorldPoint(2499, 5062, 0),
		new Rock(3, Ore.IRON), new Rock(4, Ore.COAL), new Rock(2, Ore.ADAMANTITE), new Rock(3, Ore.RUNITE)),
	MOUNT_KARUULM(new WorldPoint(1278, 3814, 0), new Rock(6, Ore.IRON), new Rock(5, Ore.COAL)),
	// MOURNER_TUNNELS -- NOT AVAILABLE ON WORLD MAP
	MYTHS_GUILD(new WorldPoint(1936, 9020, 0), new Rock(4, Ore.ADAMANTITE), new Rock(2, Ore.RUNITE)),
	OGRESS_SETTLEMENT(new WorldPoint(1977, 9041, 0),
		new Rock(5, Ore.COAL), new Rock(2, Ore.MITHRIL), new Rock(1, Ore.ADAMANTITE)),
	PIRATES_HIDEOUT(new WorldPoint(3056, 3945, 0),
		new Rock(1, Ore.IRON), new Rock(4, Ore.COAL), new Rock(4, Ore.MITHRIL), new Rock(1, Ore.ADAMANTITE)),
	PISCARILLIUS(new WorldPoint(1759, 3718, 0),
		new Rock(5, Ore.COPPER), new Rock(6, Ore.TIN), new Rock(5, Ore.IRON), new Rock(2, Ore.SILVER),
		new Rock(1, Ore.MITHRIL)),
	PISCATORIS(new WorldPoint(2337, 3640, 0),
		new Rock(2, Ore.CLAY), new Rock(2, Ore.COPPER), new Rock(2, Ore.TIN), new Rock(3, Ore.IRON)),
	PORT_KHAZARD(new WorldPoint(2651, 3172, 0),
		new Rock(2, Ore.COPPER), new Rock(2, Ore.TIN), new Rock(2, Ore.MITHRIL)),
	RELLEKKA(new WorldPoint(2682, 3704, 0), new Rock(4, Ore.CLAY), new Rock(3, Ore.SILVER), new Rock(7, Ore.COAL)),
	RIMMINGTON(new WorldPoint(2977, 3240, 0),
		new Rock(2, Ore.CLAY), new Rock(5, Ore.COPPER), new Rock(2, Ore.TIN), new Rock(6, Ore.IRON),
		new Rock(2, Ore.GOLD)),
	RUINS_OF_UNKAH(new WorldPoint(3172, 2871, 0),
		new Rock(1, Ore.COPPER), new Rock(1, Ore.TIN), new Rock(5, Ore.IRON), new Rock(2, Ore.SILVER), new Rock(1, Ore.COAL)),
	SALT_MINE(new WorldPoint(2835, 10334, 0),
		new Rock(7, Ore.BASALT), new Rock(15, Ore.TE_SALT), new Rock(12, Ore.EFH_SALT), new Rock(12, Ore.URT_SALT)),
	SHAYZIEN_EAST(new WorldPoint(1597, 3653, 0), new Rock(3, Ore.CLAY), new Rock(1, Ore.MITHRIL), new Rock(1, Ore.ADAMANTITE)),
	SHAYZIEN_WEST(new WorldPoint(1586, 3650, 0),
		new Rock(4, Ore.IRON), new Rock(4, Ore.COAL), new Rock(1, Ore.MITHRIL), new Rock(1, Ore.ADAMANTITE)),
	SHILO_VILLAGE_SURFACE(new WorldPoint(2822, 3001, 0), new Rock(7, Ore.GEM_ROCK)),
	SILVAREA(new WorldPoint(3371, 3498, 0), new Rock(7, Ore.LIMESTONE)),
	SLEPE_UNDERGROUND(new WorldPoint(3888, 9749, 0), new Rock(6, Ore.IRON), new Rock(14, Ore.COAL)),
	TRAHEARN(new WorldPoint(3295, 12387, 0),
		new Rock(26, Ore.IRON), new Rock(8, Ore.SILVER), new Rock(19, Ore.COAL), new Rock(14, Ore.GOLD),
		new Rock(7, Ore.MITHRIL), new Rock(10, Ore.SOFT_CLAY), new Rock(7, Ore.ADAMANTITE), new Rock(4, Ore.RUNITE)),
	// TUTORIAL ISLAND -- NOT AVAILABLE ON WORLD MAP
	UZER(new WorldPoint(3415, 3160, 0), new Rock(10, Ore.CLAY)),
	VARROCK_SOUTH_EAST(new WorldPoint(3286, 3365, 0),
		new Rock(9, Ore.COPPER), new Rock(6, Ore.TIN), new Rock(4, Ore.IRON)),
	VARROCK_SOUTH_WEST(new WorldPoint(3176, 3370, 0),
		new Rock(3, Ore.CLAY), new Rock(8, Ore.TIN), new Rock(3, Ore.IRON), new Rock(3, Ore.SILVER)),
	VERDANT_VALLEY(new WorldPoint(3766, 3757, 0), true, new Rock(3, Ore.IRON)),
	WILDERNESS_RESOURCE_AREA(new WorldPoint(3192, 3930, 0),
		new Rock(6, Ore.IRON), new Rock(11, Ore.COAL), new Rock(4, Ore.GOLD), new Rock(1, Ore.MITHRIL), new Rock(6, Ore.ADAMANTITE)),
	WILDERNESS_SOUTH(new WorldPoint(3104, 3569, 0), new Rock(2, Ore.IRON), new Rock(3, Ore.COAL)),
	WILDERNESS_SOUTH_WEST(new WorldPoint(3013, 3589, 0), new Rock(34, Ore.COAL)),
	;

	private final WorldPoint location;
	private final String tooltip;
	private final boolean iconRequired;

	MiningSiteLocation(WorldPoint location, Rock... rocks)
	{
		this(location, false, rocks);
	}

	MiningSiteLocation(WorldPoint location, boolean iconRequired, Rock... rocks)
	{
		this.location = location;
		this.iconRequired = iconRequired;
		this.tooltip = createTooltip(rocks);
	}

	private String createTooltip(Rock[] rocks)
	{
		return Joiner.on("<br>").join(rocks);
	}

	@RequiredArgsConstructor
	private enum Ore
	{
		ROCK("Rock"),
		CLAY("Clay"),
		COPPER("Copper"),
		TIN("Tin"),
		LIMESTONE("Limestone"),
		BLURITE("Blurite"),
		IRON("Iron"),
		ELEMENTAL("Elemental"),
		SILVER("Silver"),
		COAL("Coal"),
		SANDSTONE("Sandstone"),
		DENSE_ESSENCE("Dense essence"),
		DAEYALT_ESSENCE("Daeyalt essence"),
		GOLD("Gold"),
		GEM_ROCK("Gem rock"),
		HARD_ROCK("Hard rock"),
		VOLCANIC_SULPHUR("Volcanic sulphur"),
		GRANITE("Granite"),
		MITHRIL("Mithril"),
		LUNAR("Lunar"),
		LOVAKITE("Lovakite"),
		ADAMANTITE("Adamantite"),
		SOFT_CLAY("Soft clay"),
		BASALT("Basalt"),
		TE_SALT("Te salt"),
		EFH_SALT("Efh salt"),
		URT_SALT("Urt salt"),
		RUNITE("Runite"),
		AMETHYST("Amethyst"),
		;

		private final String name;

		@Override
		public String toString()
		{
			return name;
		}
	}

	@Value
	private static class Rock
	{
		private final int count;
		private final Ore ore;

		@Override
		public String toString()
		{
			return count + " " + ore;
		}
	}
}
