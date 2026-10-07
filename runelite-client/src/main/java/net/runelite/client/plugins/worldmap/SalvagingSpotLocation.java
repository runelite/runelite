/*
 * Copyright (c) 2026, Sam Szotkowski <https://github.com/samszotkowski>
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
enum SalvagingSpotLocation
{
	SMALL_SHIPWRECK("Small salvage", 15,
		// Kharidian Sea
		new WorldPoint(3110, 2948, 0),

		// Shipwreck Cove
		new WorldPoint(1589, 3323, 0)
	),

	FISHERMANS_SHIPWRECK("Fishy salvage", 26,
		// Catherby Bay
		new WorldPoint(2782, 3319, 0),

		// Gu'tanoth Bay
		new WorldPoint(2698, 3047, 0),

		//Gulf of Kourend
		new WorldPoint(1903, 3835, 0)
	),

	BARRACUDA_SHIPWRECK("Barracuda salvage", 35,
		// The Storm Tempor
		new WorldPoint(2996, 2917, 0),

		// Sea Spirit Dock
		new WorldPoint(3123, 2808, 0),

		// Backwater
		new WorldPoint(2447, 3021, 0),

		// Myths' Guild
		new WorldPoint(2478, 2823, 0),

		// Tirannwn Bight
		new WorldPoint(2142, 3350, 0),

		// Ynysdail
		new WorldPoint(2222, 3444, 0)

		// There is one more by Anglers' Retreat, but it doesn't have an icon
	),

	LARGE_SHIPWRECK("Large salvage", 53,
		// South of Shimmering Atoll
		new WorldPoint(1563, 2679, 0),

		// North of Isle of Serpents
		new WorldPoint(1886, 2508, 0),

		// South-west of Wyrmscraig
		new WorldPoint(2459, 2144, 0),

		// South-west of Grimstone
		new WorldPoint(2845, 4030, 0),

		// South of The Little Pearl
		new WorldPoint(3394, 2138, 0)
	),

	PIRATE_SHIPWRECK("Plundered salvage", 64,
		// South of Pest Control
		new WorldPoint(2663, 2544, 0),

		// Aureum Coast
		new WorldPoint(1826, 2842, 0),

		// South-east of Buccaneers' Haven
		new WorldPoint(2116, 3655, 0),

		// Pirates' Cove
		new WorldPoint(2193, 3843, 0)
	),

	MERCENARY_SHIPWRECK("Martial salvage", 73,
		// West of the Isle of Serpents
		new WorldPoint(1688, 2399, 0),

		// South-western Southern Expanse
		new WorldPoint(1747, 2209, 0),

		// South-west of Sunbleak Island
		new WorldPoint(2140, 2212, 0)
	),

	FREMENNIK_SHIPWRECK("Fremennik salvage", 80,
		// Everwinter Sea
		new WorldPoint(1769, 4124, 0),

		// North of Ungael
		new WorldPoint(2272, 4129, 0),

		// Stoneheart Sea
		new WorldPoint(2591, 4128, 0)
	),

	MERCHANT_SHIPWRECK("Opulent salvage", 87,
		// Dusk's Maw
		new WorldPoint(1069, 2962, 0),

		// Winter's Edge
		new WorldPoint(1820, 3989, 0),

		// Southern Expanse
		new WorldPoint(1888, 2150, 0)
	);

	private final String tooltip;
	private final WorldPoint[] locations;
	private final int levelReq;

	SalvagingSpotLocation(String description, int level, WorldPoint... locations)
	{
		this.tooltip = description + " - Level " + level;
		this.locations = locations;
		this.levelReq = level;
	}
}