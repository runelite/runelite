/*
 * Copyright (c) 2025, coopermor <https://github.com/coopermor>
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

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum MooringLocation
{
	PORT_SARIM("Port Sarim", 1, new WorldPoint(3050, 3192, 0)),
	THE_PANDEMONIUM("The Pandemonium", 1, new WorldPoint(3069, 2986, 0)),
	LANDS_END("Land's End", 5, new WorldPoint(1506, 3402, 0)),
	HOSIDIUS("Hosidius", 5, new WorldPoint(1726, 3452, 0)),
	MUSA_POINT("Musa Point", 10, new WorldPoint(2960, 3147, 0)),
	PORT_PISCARILLIUS("Port Piscarillius", 15, new WorldPoint(1845, 3687, 0)),
	RIMMINGTON("Rimmington", 18, new WorldPoint(2905, 3226, 0)),
	CATHERBY("Catherby", 20, new WorldPoint(2796, 3412, 0)),
	BRIMHAVEN("Brimhaven", 25, new WorldPoint(2757, 3229, 0)),
	ARDOUGNE("Ardougne", 28, new WorldPoint(2671, 3265, 0)),
	PORT_KHAZARD("Port Khazard", 30, new WorldPoint(2685, 3161, 0)),
	WITCHAVEN("Witchaven", 34, new WorldPoint(2746, 3304, 0)),
	ENTRANA("Entrana", 36, new WorldPoint(2878, 3335, 0)),
	CIVITAS_ILLA_FORTIS("Civitas illa Fortis", 38, new WorldPoint(1774, 3141, 0)),
	CORSAIR_COVE("Corsair Cove", 40, new WorldPoint(2579, 2843, 0)),
	DOGNOSE_ISLAND("Dognose Island", 40, new WorldPoint(3061, 2639, 0)),
	CAIRN_ISLE("Cairn Isle", 42, new WorldPoint(2749, 2951, 0)),
	CHINCHOMPA_ISLAND("Chinchompa Island", 42, new WorldPoint(1892, 3429, 0)),
	SUNSET_COAST("Sunset Coast", 44, new WorldPoint(1511, 2975, 0)),
	REMOTE_ISLAND("Remote Island", 45, new WorldPoint(2971, 2603, 0)),
	THE_SUMMER_SHORE("The Summer Shore", 45, new WorldPoint(3174, 2367, 0)),
	THE_LITTLE_PEARL("The Little Pearl", 45, new WorldPoint(3354, 2216, 0)),
	ALDARIN("Aldarin", 46, new WorldPoint(1452, 2970, 0)),
	VATRACHOS_ISLAND("Vatrachos Island", 46, new WorldPoint(1872, 2985, 0)),
	THE_ONYX_CREST("The Onyx Crest", 47, new WorldPoint(2997, 2288, 0)),
	RUINS_OF_UNKAH("Ruins of Unkah", 48, new WorldPoint(3143, 2824, 0)),
	SHIMMERING_ATOLL("Shimmering Atoll", 49, new WorldPoint(1557, 2771, 0)),
	VOID_KNIGHTS_OUTPOST("Void Knights' Outpost", 50, new WorldPoint(2651, 2678, 0)),
	PORT_ROBERTS("Port Roberts", 50, new WorldPoint(1860, 3306, 0)),
	ANGLERS_RETREAT("Anglers' Retreat", 51, new WorldPoint(2467, 2721, 0)),
	MINOTAURS_REST("Minotaurs' Rest", 54, new WorldPoint(1958, 3117, 0)),
	ISLE_OF_SOULS("Isle of Souls", 55, new WorldPoint(2282, 2823, 0)),
	ISLE_OF_BONES("Isle of Bones", 56, new WorldPoint(2532, 2531, 0)),
	LAGUNA_AURORAE("Laguna Aurorae", 58, new WorldPoint(1202, 2733, 0)),
	CHARRED_ISLAND("Charred Island", 60, new WorldPoint(2660, 2395, 0)),
	TEAR_OF_THE_SOUL("Tear of the Soul", 61, new WorldPoint(2318, 2774, 0)),
	RELLEKKA("Rellekka", 62, new WorldPoint(2630, 3705, 0)),
	WINTUMBER_ISLAND("Wintumber Island", 63, new WorldPoint(2058, 2606, 0)),
	THE_CROWN_JEWEL("The Crown Jewel", 64, new WorldPoint(1765, 2659, 0)),
	ETCETERIA("Etceteria", 65, new WorldPoint(2611, 3840, 0)),
	PORT_TYRAS("Port Tyras", 66, new WorldPoint(2144, 3120, 0)),
	LLEDRITH_ISLAND("Lledrith Island", 66, new WorldPoint(2097, 3188, 0)),
	DEEPFIN_POINT("Deepfin Point", 67, new WorldPoint(1923, 2758, 0)),
	JATIZSO("Jatizso", 68, new WorldPoint(2412, 3780, 0)),
	NEITIZNOT("Neitiznot", 68, new WorldPoint(2308, 3783, 0)),
	RAINBOWS_END("Rainbow's End", 69, new WorldPoint(2344, 2270, 0)),
	PRIFDDINAS("Prifddinas", 70, new WorldPoint(2158, 3324, 0)),
	SUNBLEAK_ISLAND("Sunbleak Island", 72, new WorldPoint(2189, 2327, 0)),
	YNYSDAIL("Ynysdail", 73, new WorldPoint(2222, 3466, 0)),
	WATERBIRTH_ISLAND("Waterbirth Island", 74, new WorldPoint(2543, 3765, 0)),
	PISCATORIS("Piscatoris", 75, new WorldPoint(2303, 3690, 0)),
	LUNAR_ISLE("Lunar Isle", 76, new WorldPoint(2151, 3880, 0)),
	BUCCANEERS_HAVEN("Buccaneers' Haven", 76, new WorldPoint(2080, 3690, 0)),
	DRUMSTICK_ISLE("Drumstick Isle", 79, new WorldPoint(2150, 3530, 0)),
	WEISS("Weiss", 80, new WorldPoint(2860, 3972, 0)),
	BRITTLE_ISLE("Brittle Isle", 81, new WorldPoint(1954, 4056, 0)),
	GRIMSTONE("Grimstone", 87, new WorldPoint(2927, 4056, 0)),
	;

	private final String tooltip;
	private final int levelReq;
	private final WorldPoint location;

	MooringLocation(String description, int level, WorldPoint location)
	{
		this.tooltip = description + " - Level " + level;
		this.location = location;
		this.levelReq = level;
	}
}
