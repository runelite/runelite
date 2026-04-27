/*
 * Copyright (c) 2018, Torkel Velure <https://github.com/TorkelV>
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
enum FarmingPatchLocation
{
	ALLOTMENT("Allotment",
		new WorldPoint(3793, 2836, 0),
		new WorldPoint(1269, 3730, 0)
	),
	ALLOTMENT_FLOWER("Allotment/Flower", new WorldPoint(3289, 6100, 0)),
	ALLOTMENT_HERB_FLOWER("Allotment/Herb/Flower",
		new WorldPoint(1729, 3558, 0),
		new WorldPoint(3598, 3524, 0),
		new WorldPoint(3052, 3309, 0),
		new WorldPoint(2810, 3462, 0),
		new WorldPoint(2663, 3375, 0),
		new WorldPoint(1587, 3101, 0)
	),
	ANIMA_HERB("Anima/Herb", new WorldPoint(1235, 3724, 0)),
	BELLADONNA("Belladonna",
		new WorldPoint(3084, 3356, 0),
		new WorldPoint(1449, 3354, 0)
	),
	BUSH("Bush",
		new WorldPoint(2938, 3223, 0),
		new WorldPoint(2589, 3862, 0),
		new WorldPoint(3182, 3356, 0),
		new WorldPoint(2615, 3224, 0)
	),
	BUSH_FLOWER("Bush/Flower", new WorldPoint(1259, 3729, 0)),
	CACTUS("Cactus",
		new WorldPoint(3313, 3201, 0),
		new WorldPoint(1264, 3745, 0)
	),
	CALQUAT("Calquat",
		new WorldPoint(2793, 3099, 0),
		new WorldPoint(1365, 3035, 0),
		new WorldPoint(3125, 2403, 0)
	),
	CELASTRUS_FRUIT_TREE("Celastrus/Fruit Tree",
		new WorldPoint(1242, 3755, 0)
	),
	CORAL("Coral",
		new WorldPoint(3296, 8861, 0)
	),
	CRYSTAL_TREE("Crystal Tree",
		new WorldPoint(3292, 6120, 0)
	),
	FLOWER("Flower", new WorldPoint(1352, 3025, 0)),
	FRUIT_TREE("Fruit Tree",
		new WorldPoint(2487, 3181, 0),
		new WorldPoint(2343, 3160, 0),
		new WorldPoint(2472, 3445, 0),
		new WorldPoint(2858, 3432, 0),
		new WorldPoint(2765, 3211, 0),
		new WorldPoint(1347, 3058, 0)
	),
	GRAPES("Grapes", new WorldPoint(1807, 3555, 0)),
	HARDWOOD("Hardwood",
		new WorldPoint(3707, 3838, 0),
		new WorldPoint(1683, 2971, 0),
		new WorldPoint(2472, 2705, 0)
	),
	HERB("Herb",
		new WorldPoint(3789, 2840, 0),
		new WorldPoint(2847, 3933, 0),
		new WorldPoint(2828, 3696, 0)
	),
	HESPORI("Hespori", new WorldPoint(1182, 10068, 0)),
	HOPS("Hops",
		new WorldPoint(2572, 3102, 0),
		new WorldPoint(2661, 3523, 0),
		new WorldPoint(3224, 3313, 0),
		new WorldPoint(2812, 3334, 0),
		new WorldPoint(1367, 2938, 0)
	),
	MUSHROOM("Mushroom", new WorldPoint(3449, 3471, 0)),
	REDWOOD("Redwood", new WorldPoint(1233, 3754, 0)),
	SEAWEED("Seaweed", new WorldPoint(3730, 10271, 0)),
	SPIRIT_TREE("Spirit Tree",
		new WorldPoint(3056, 3259, 0),
		new WorldPoint(1690, 3540, 0),
		new WorldPoint(3614, 3856, 0),
		new WorldPoint(2799, 3205, 0),
		new WorldPoint(1254, 3753, 0)
	),
	TREE("Tree",
		new WorldPoint(3226, 3457, 0),
		new WorldPoint(2933, 3436, 0),
		new WorldPoint(3189, 3233, 0),
		new WorldPoint(2434, 3418, 0),
		new WorldPoint(3005, 3375, 0),
		new WorldPoint(1234, 3736, 0),
		new WorldPoint(1366, 3318, 0)
	);

	private final String tooltip;
	private final WorldPoint[] locations;

	FarmingPatchLocation(String description, WorldPoint... locations)
	{
		this.tooltip = "Farming patch - " + description;
		this.locations = locations;
	}
}
