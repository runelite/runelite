/*
 * Copyright (c) 2021, Hexagon <hexagon@fking.work>
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
package net.runelite.client.plugins.shootingstars;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum StarRegion
{
	ASGARNIA("Asgarnia",
		StarCrashSite.of("Dwarven Mine", new WorldPoint(3018, 3443, 0)),
		StarCrashSite.of("Mining Guild", new WorldPoint(3030, 3348, 0)),
		StarCrashSite.of("West Falador", new WorldPoint(2906, 3355, 0)),
		StarCrashSite.of("Taverley", new WorldPoint(2882, 3474, 0)),
		StarCrashSite.of("Crafting Guild", new WorldPoint(2940, 3280, 0)),
		StarCrashSite.of("Rimmington Mine", new WorldPoint(2974, 3241, 0))
	),
	CRANDOR_KARAMJA("Crandor or Karamja", "Karamja",
		StarCrashSite.of("South crandor", new WorldPoint(2822, 3238, 0)),
		StarCrashSite.of("North crandor", new WorldPoint(2835, 3296, 0)),
		StarCrashSite.of("North brimhaven", new WorldPoint(2736, 3221, 0)),
		StarCrashSite.of("South brimhaven", new WorldPoint(2742, 3143, 0)),
		StarCrashSite.of("Karamja Jungle", new WorldPoint(2845, 3037, 0)),
		StarCrashSite.of("Shilo Village", new WorldPoint(2827, 2999, 0))
	),
	FELDIP_HILLS("Feldip Hills or on the Isle of Souls", "Feldip Hills",
		StarCrashSite.of("Feldip Hunter Area", new WorldPoint(2571, 2964, 0)),
		StarCrashSite.of("Rant'z Cave", new WorldPoint(2630, 2993, 0)),
		StarCrashSite.of("Corsair Cove", new WorldPoint(2567, 2858, 0)),
		StarCrashSite.of("Corsair Cove Resource Area", new WorldPoint(2483, 2886, 0)),
		StarCrashSite.of("Myth's Guild", new WorldPoint(2468, 2842, 0)),
		StarCrashSite.of("Isle of Souls Mine", new WorldPoint(2200, 2792, 0))
	),
	FOSSIL_ISLAND("Fossil Island or on Mos Le'Harmless", "Fossil Island",
		StarCrashSite.of("Fossil Island Mine", new WorldPoint(3774, 3814, 0)),
		StarCrashSite.of("Volcanic Mine", new WorldPoint(3818, 3801, 0)),
		StarCrashSite.of("Mos Le'Harmless", new WorldPoint(3686, 2969, 0))
	),
	FREMENNIK_LANDS("Fremennik Lands or on Lunar Isle", "Fremennik Lands",
		StarCrashSite.of("Rellekka Mine", new WorldPoint(2683, 3699, 0)),
		StarCrashSite.of("Keldagrim Entrance", new WorldPoint(2727, 3683, 0)),
		StarCrashSite.of("Miscellania", new WorldPoint(2528, 3887, 0)),
		StarCrashSite.of("Jaitzso", new WorldPoint(2393, 3814, 0)),
		StarCrashSite.of("Neitznot", new WorldPoint(2375, 3832, 0)),
		StarCrashSite.of("Lunar Isle", new WorldPoint(2139, 3938, 0))
	),
	GREAT_KOUREND("Great Kourend",
		StarCrashSite.of("Hosidius Mine", new WorldPoint(1778, 3493, 0)),
		StarCrashSite.of("Shayzien Mine", new WorldPoint(1591, 3658, 0)),
		StarCrashSite.of("Piscarillius Mine", new WorldPoint(1769, 3709, 0)),
		StarCrashSite.of("Arceuus Essence Mine", new WorldPoint(1760, 3853, 0)),
		StarCrashSite.of("Lovakite Mine", new WorldPoint(1760, 3853, 0)),
		StarCrashSite.of("Lovakengj", new WorldPoint(1534, 3747, 0))
	),
	KANDARIN("Kandarin",
		StarCrashSite.of("Catherby ", new WorldPoint(2804, 3434, 0)),
		StarCrashSite.of("Yanille", new WorldPoint(2602, 3086, 0)),
		StarCrashSite.of("Port Khazard", new WorldPoint(2624, 3141, 0)),
		StarCrashSite.of("Legend's Guild", new WorldPoint(2705, 3333, 0)),
		StarCrashSite.of("Coal Trucks", new WorldPoint(2589, 3478, 0)),
		StarCrashSite.of("SE Ardougne", new WorldPoint(2608, 3233, 0))
	),
	KEBOS_LOWLANDS("Kebos Lowlands",
		StarCrashSite.of("Kebos Lowlands Mine", new WorldPoint(1210, 3651, 0)),
		StarCrashSite.of("Mount Kaluum Mine", new WorldPoint(1279, 3817, 0)),
		StarCrashSite.of("Mount Quidamortem", new WorldPoint(1258, 3564, 0))
	),
	KHARIDIAN_DESERT("Kharidian Desert",
		StarCrashSite.of("Al Kharid Mine", new WorldPoint(3296, 3298, 0)),
		StarCrashSite.of("Al Kharid", new WorldPoint(3276, 3164, 0)),
		StarCrashSite.of("Uzer", new WorldPoint(3424, 3160, 0)),
		StarCrashSite.of("Desert Quarry", new WorldPoint(3171, 2910, 0)),
		StarCrashSite.of("Agility Pyramid", new WorldPoint(3316, 2867, 0)),
		StarCrashSite.of("Nardah", new WorldPoint(3434, 2889, 0)),
		StarCrashSite.of("Duel Arena", new WorldPoint(3341, 3267, 0))
	),
	MISTHALIN("Misthalin",
		StarCrashSite.of("Lumbridge Swamp", new WorldPoint(3230, 3155, 0)),
		StarCrashSite.of("Lumbridge East", new WorldPoint(3153, 3150, 0)),
		StarCrashSite.of("Draynor Village", new WorldPoint(3094, 3235, 0)),
		StarCrashSite.of("Varrock East", new WorldPoint(3258, 3408, 0)),
		StarCrashSite.of("SE Varrock", new WorldPoint(3290, 3353, 0)),
		StarCrashSite.of("Champions Guild", new WorldPoint(3175, 3362, 0))
	),
	MORYTANIA("Morytania",
		StarCrashSite.of("Canifis", new WorldPoint(3505, 3485, 0)),
		StarCrashSite.of("Burgh de Rott", new WorldPoint(3500, 3219, 0)),
		StarCrashSite.of("Abandoned Mine", new WorldPoint(3451, 3233, 0)),
		StarCrashSite.of("Ver Sinhaza", new WorldPoint(3650, 3214, 0)),
		StarCrashSite.of("Daeyalt Mine", new WorldPoint(3635, 3340, 0))
	),
	PISCATORIS_GNOME_STRONGHOLD("Piscatoris or the Gnome Stronghold",
		StarCrashSite.of("Piscatoris Mine", new WorldPoint(2341, 3635, 0)),
		StarCrashSite.of("Grand Tree", new WorldPoint(2444, 3490, 0)),
		StarCrashSite.of("Tree Gnome Stronghold Bank", new WorldPoint(2448, 3436, 0))
	),
	TIRANNWN("Tirannwn",
		StarCrashSite.of("Isafdar Mine", new WorldPoint(2269, 3158, 0)),
		StarCrashSite.of("Arandar Mine", new WorldPoint(2318, 3269, 0)),
		StarCrashSite.of("Lletya", new WorldPoint(2329, 3163, 0)),
		StarCrashSite.of("Trahaearn Mine", new WorldPoint(3274, 6055, 0)),
		StarCrashSite.of("Mynydd Mine", new WorldPoint(2173, 3409, 0))
	),
	WILDERNESS("Wilderness",
		StarCrashSite.of("South Mine", new WorldPoint(3108, 3569, 0)),
		StarCrashSite.of("South-West Mine", new WorldPoint(3018, 3593, 0)),
		StarCrashSite.of("Bandit Camp Mine", new WorldPoint(3093, 3756, 0)),
		StarCrashSite.of("Lava Maze Runite", new WorldPoint(3057, 3887, 0)),
		StarCrashSite.of("Resource Area", new WorldPoint(3188, 3932, 0)),
		StarCrashSite.of("Mage Arena", new WorldPoint(3091, 3962, 0)),
		StarCrashSite.of("Pirate's Cove Hideout", new WorldPoint(3049, 3940, 0))
	);

	private final String name;
	private final String shortName;
	private final List<StarCrashSite> crashSites;

	StarRegion(String name, StarCrashSite... crashSites)
	{
		this(name, name, crashSites);
	}

	StarRegion(String name, String shortName, StarCrashSite... crashSites)
	{
		this.name = name;
		this.shortName = shortName;
		this.crashSites = Arrays.asList(crashSites);
	}
}
