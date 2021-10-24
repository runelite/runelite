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
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum StarRegion
{
	ASGARNIA("Asgarnia",
		LandingSite.of("Dwarven Mine", new WorldPoint(3018, 3443, 0)),
		LandingSite.of("Mining Guild", new WorldPoint(3030, 3348, 0)),
		LandingSite.of("West Falador", new WorldPoint(2906, 3355, 0)),
		LandingSite.of("Taverley", new WorldPoint(2882, 3474, 0)),
		LandingSite.of("Crafting Guild", new WorldPoint(2940, 3280, 0)),
		LandingSite.of("Rimmington Mine", new WorldPoint(2974, 3241, 0))
	),
	CRANDOR_KARAMJA("Crandor or Karamja", "Karamja",
		LandingSite.of("South crandor", new WorldPoint(2822, 3238, 0)),
		LandingSite.of("North crandor", new WorldPoint(2835, 3296, 0)),
		LandingSite.of("North brimhaven", new WorldPoint(2736, 3221, 0)),
		LandingSite.of("South brimhaven", new WorldPoint(2742, 3143, 0)),
		LandingSite.of("Karamja Jungle", new WorldPoint(2845, 3037, 0)),
		LandingSite.of("Shilo Village", new WorldPoint(2827, 2999, 0))
	),
	FELDIP_HILLS("Feldip Hills or on the Isle of Souls", "Feldip Hills",
		LandingSite.of("Feldip Hunter Area", new WorldPoint(2571, 2964, 0)),
		LandingSite.of("Rant'z Cave", new WorldPoint(2630, 2993, 0)),
		LandingSite.of("Corsair Cove", new WorldPoint(2567, 2858, 0)),
		LandingSite.of("Corsair Cove Resource Area", new WorldPoint(2483, 2886, 0)),
		LandingSite.of("Myth's Guild", new WorldPoint(2468, 2842, 0)),
		LandingSite.of("Isle of Souls Mine", new WorldPoint(2200, 2792, 0))
	),
	FOSSIL_ISLAND("Fossil Island or on Mos Le'Harmless", "Fossil Island",
		LandingSite.of("Fossil Island Mine", new WorldPoint(3774, 3814, 0)),
		LandingSite.of("Volcanic Mine", new WorldPoint(3818, 3801, 0)),
		LandingSite.of("Mos Le'Harmless", new WorldPoint(3686, 2969, 0))
	),
	FREMENNIK_LANDS("Fremennik Lands or on Lunar Isle", "Fremennik Lands",
		LandingSite.of("Rellekka Mine", new WorldPoint(2683, 3699, 0)),
		LandingSite.of("Keldagrim Entrance", new WorldPoint(2727, 3683, 0)),
		LandingSite.of("Miscellania", new WorldPoint(2528, 3887, 0)),
		LandingSite.of("Jaitzso", new WorldPoint(2393, 3814, 0)),
		LandingSite.of("Neitznot", new WorldPoint(2375, 3832, 0)),
		LandingSite.of("Lunar Isle", new WorldPoint(2139, 3938, 0))
	),
	GREAT_KOUREND("Great Kourend",
		LandingSite.of("Hosidius Mine", new WorldPoint(1778, 3493, 0)),
		LandingSite.of("Shayzien Mine", new WorldPoint(1591, 3658, 0)),
		LandingSite.of("Piscarillius Mine", new WorldPoint(1769, 3709, 0)),
		LandingSite.of("Arceuus Essence Mine", new WorldPoint(1760, 3853, 0)),
		LandingSite.of("Lovakite Mine", new WorldPoint(1760, 3853, 0)),
		LandingSite.of("Lovakengj", new WorldPoint(1534, 3747, 0))
	),
	KANDARIN("Kandarin",
		LandingSite.of("Catherby ", new WorldPoint(2804, 3434, 0)),
		LandingSite.of("Yanille", new WorldPoint(2602, 3086, 0)),
		LandingSite.of("Port Khazard", new WorldPoint(2624, 3141, 0)),
		LandingSite.of("Legend's Guild", new WorldPoint(2705, 3333, 0)),
		LandingSite.of("Coal Trucks", new WorldPoint(2589, 3478, 0)),
		LandingSite.of("SE Ardougne", new WorldPoint(2608, 3233, 0))
	),
	KEBOS_LOWLANDS("Kebos Lowlands",
		LandingSite.of("Kebos Lowlands Mine", new WorldPoint(1210, 3651, 0)),
		LandingSite.of("Mount Kaluum Mine", new WorldPoint(1279, 3817, 0)),
		LandingSite.of("Mount Quidamortem", new WorldPoint(1258, 3564, 0))
	),
	KHARIDIAN_DESERT("Kharidian Desert",
		LandingSite.of("Al Kharid Mine", new WorldPoint(3296, 3298, 0)),
		LandingSite.of("Al Kharid", new WorldPoint(3276, 3164, 0)),
		LandingSite.of("Uzer", new WorldPoint(3424, 3160, 0)),
		LandingSite.of("Desert Quarry", new WorldPoint(3171, 2910, 0)),
		LandingSite.of("Agility Pyramid", new WorldPoint(3316, 2867, 0)),
		LandingSite.of("Nardah", new WorldPoint(3434, 2889, 0)),
		LandingSite.of("Duel Arena", new WorldPoint(3341, 3267, 0))
	),
	MISTHALIN("Misthalin",
		LandingSite.of("Lumbridge Swamp", new WorldPoint(3230, 3155, 0)),
		LandingSite.of("Lumbridge East", new WorldPoint(3153, 3150, 0)),
		LandingSite.of("Draynor Village", new WorldPoint(3094, 3235, 0)),
		LandingSite.of("Varrock East", new WorldPoint(3258, 3408, 0)),
		LandingSite.of("SE Varrock", new WorldPoint(3290, 3353, 0)),
		LandingSite.of("Champions Guild", new WorldPoint(3175, 3362, 0))
	),
	MORYTANIA("Morytania",
		LandingSite.of("Canifis", new WorldPoint(3505, 3485, 0)),
		LandingSite.of("Burgh de Rott", new WorldPoint(3500, 3219, 0)),
		LandingSite.of("Abandoned Mine", new WorldPoint(3451, 3233, 0)),
		LandingSite.of("Ver Sinhaza", new WorldPoint(3650, 3214, 0)),
		LandingSite.of("Daeyalt Mine", new WorldPoint(3635, 3340, 0))
	),
	PISCATORIS_GNOME_STRONGHOLD("Piscatoris or the Gnome Stronghold",
		LandingSite.of("Piscatoris Mine", new WorldPoint(2341, 3635, 0)),
		LandingSite.of("Grand Tree", new WorldPoint(2444, 3490, 0)),
		LandingSite.of("Tree Gnome Stronghold Bank", new WorldPoint(2448, 3436, 0))
	),
	TIRANNWN("Tirannwn",
		LandingSite.of("Isafdar Mine", new WorldPoint(2269, 3158, 0)),
		LandingSite.of("Arandar Mine", new WorldPoint(2318, 3269, 0)),
		LandingSite.of("Lletya", new WorldPoint(2329, 3163, 0)),
		LandingSite.of("Trahaearn Mine", new WorldPoint(3274, 6055, 0)),
		LandingSite.of("Mynydd Mine", new WorldPoint(2173, 3409, 0))
	),
	WILDERNESS("Wilderness",
		LandingSite.of("South Mine", new WorldPoint(3108, 3569, 0)),
		LandingSite.of("South-West Mine", new WorldPoint(3018, 3593, 0)),
		LandingSite.of("Bandit Camp Mine", new WorldPoint(3093, 3756, 0)),
		LandingSite.of("Lava Maze Runite", new WorldPoint(3057, 3887, 0)),
		LandingSite.of("Resource Area", new WorldPoint(3188, 3932, 0)),
		LandingSite.of("Mage Arena", new WorldPoint(3091, 3962, 0)),
		LandingSite.of("Pirate's Cove Hideout", new WorldPoint(3049, 3940, 0))
	);

	private final String name;
	private final String shortName;
	private final List<LandingSite> crashSites;

	StarRegion(String name, LandingSite... crashSites)
	{
		this(name, name, crashSites);
	}

	StarRegion(String name, String shortName, LandingSite... crashSites)
	{
		this.name = name;
		this.shortName = shortName;
		this.crashSites = Arrays.asList(crashSites);
	}

	@Value(staticConstructor = "of")
	public static class LandingSite
	{
		String name;
		WorldPoint location;
	}
}
