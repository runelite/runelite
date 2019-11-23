/*
 * Copyright (c) 2018, Spedwards <https://github.com/Spedwards>
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

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter(AccessLevel.PACKAGE)
enum RareTreeLocation
{
	WILLOW("Willow tree", 30,
		// Kandarin
		new WorldPoint(2710, 3510, 0)),

	TEAK("Teak tree", 35,
		// Ape Atoll
		new WorldPoint(2774, 2697, 0),

		// Desert
		new WorldPoint(3510, 3073, 0),

		// Mos Le'Harmless
		new WorldPoint(3832, 3067, 0),

		// Karamja
		new WorldPoint(2837, 2907, 0),
		new WorldPoint(2899, 2897, 0),

		// Feldip Hills
		new WorldPoint(2333, 3049, 0),

		// Prifddinas
		new WorldPoint(3309, 6123, 0)),

	SWAYING("Swaying tree", 40,
		// The Fremennik Trials
		new WorldPoint(2738, 3639, 0)),

	MATURE_JUNIPER("Mature juniper tree", 42,
		// Zeah
		new WorldPoint(1690, 3524, 0)),

	MAPLE("Maple tree", 45,
		// Zeah
		new WorldPoint(1231, 3704, 0),
		new WorldPoint(1293, 3756, 0),
		new WorldPoint(1640, 3496, 0),
		new WorldPoint(1613, 3494, 0),
		new WorldPoint(1560, 3636, 0),
		new WorldPoint(1646, 3590, 0),

		// Miscellania
		new WorldPoint(2550, 3869, 0),

		// Kandarin
		new WorldPoint(2712, 3382, 0),
		new WorldPoint(2720, 3465, 0),
		new WorldPoint(2726, 3501, 0),
		new WorldPoint(2728, 3481, 0),
		new WorldPoint(2748, 3466, 0),
		new WorldPoint(2710, 3570, 0),

		// Prifddinas
		new WorldPoint(2209, 3427, 0),
		new WorldPoint(3233, 6179, 0)),

	MAHOGANY("Mahogany tree", 50,
		// Zeah
		new WorldPoint(1237, 3770, 0),

		// Ape Atoll
		new WorldPoint(2716, 2710, 0),
		new WorldPoint(2725, 2735, 0),

		// Mos Le'Harmless
		new WorldPoint(3824, 3053, 0),

		// Karamja
		new WorldPoint(2946, 2908, 0),

		// Prifddinas
		new WorldPoint(3301, 6129, 0)),

	TEAK_MAHOGANY("Teak/Mahogany trees", 50,
		// Miscellania
		new WorldPoint(2602, 3895, 0),

		// Mos Le'Harmless
		new WorldPoint(3810, 3058, 0),

		// Karamja
		new WorldPoint(2821, 3084, 0)),

	YEW("Yew tree", 60,
		// Zeah
		new WorldPoint(1217, 3688, 0),
		new WorldPoint(1353, 3731, 0),
		new WorldPoint(1529, 3452, 0),
		new WorldPoint(1591, 3421, 0),
		new WorldPoint(1647, 3508, 0),
		new WorldPoint(1621, 3512, 0),
		new WorldPoint(1593, 3491, 0),
		new WorldPoint(1583, 3499, 0),
		new WorldPoint(1696, 3554, 0),
		new WorldPoint(1625, 3677, 0),
		new WorldPoint(1625, 3669, 0),
		new WorldPoint(1642, 3683, 0),
		new WorldPoint(1642, 3663, 0),
		new WorldPoint(1642, 3533, 0),
		new WorldPoint(1671, 3657, 0),
		new WorldPoint(1680, 3657, 0),

		// Tirannwn
		new WorldPoint(2217, 3141, 0),

		// Prifddinas
		new WorldPoint(3288, 6066, 0),
		new WorldPoint(3305, 6032, 0),

		// Kandarin
		new WorldPoint(2315, 3610, 0),
		new WorldPoint(2331, 3514, 0),
		new WorldPoint(2358, 3510, 0),
		new WorldPoint(2360, 3471, 0),
		new WorldPoint(2434, 3432, 0),
		new WorldPoint(2493, 3396, 0),
		new WorldPoint(2494, 3490, 0),
		new WorldPoint(2733, 3334, 0),
		new WorldPoint(2757, 3431, 0),
		new WorldPoint(2714, 3460, 0),

		// Asgarnia
		new WorldPoint(2995, 3312, 0),
		new WorldPoint(3018, 3316, 0),
		new WorldPoint(3041, 3320, 0),
		new WorldPoint(3052, 3272, 0),
		new WorldPoint(2931, 3231, 0),

		// Misthalin
		new WorldPoint(3085, 3481, 0),
		new WorldPoint(3085, 3469, 0),
		new WorldPoint(3146, 3255, 0),
		new WorldPoint(3151, 3231, 0),
		new WorldPoint(3165, 3220, 0),
		new WorldPoint(3184, 3227, 0),
		new WorldPoint(3251, 3364, 0),
		new WorldPoint(3204, 3504, 0),
		new WorldPoint(3208, 3500, 0),
		new WorldPoint(3221, 3503, 0),
		new WorldPoint(3248, 3473, 0),
		new WorldPoint(3266, 3494, 0),
		new WorldPoint(3270, 3471, 0),
		new WorldPoint(3304, 3470, 0),
		new WorldPoint(3249, 3202, 0),

		// Morytania
		new WorldPoint(3674, 3447, 0),
		new WorldPoint(3684, 3385, 0),

		// Zanaris
		new WorldPoint(2412, 4464, 0),
		new WorldPoint(2465, 4427, 0),
		new WorldPoint(2491, 4426, 0)),

	MAPLE_YEW("Maple/Yew trees", 60,
		// Feldip Hills
		new WorldPoint(2476, 2893, 0)),

	SULLIUSCEP("Sulliuscep", 65,
		// Fossil Island
		new WorldPoint(3662, 3802, 0),
		new WorldPoint(3662, 3781, 0),
		new WorldPoint(3677, 3806, 0),
		new WorldPoint(3677, 3733, 0),
		new WorldPoint(3682, 3775, 0),
		new WorldPoint(3682, 3758, 0)),

	MAGIC("Magic tree", 75,
		// Zeah
		new WorldPoint(1373, 3821, 0),
		new WorldPoint(1389, 3821, 0),
		new WorldPoint(1610, 3443, 0),
		new WorldPoint(1578, 3488, 0),
		new WorldPoint(1685, 3740, 0),
		new WorldPoint(1681, 3689, 0),
		new WorldPoint(1751, 3564, 0),
		new WorldPoint(1796, 3600, 0),

		// Misthalin
		new WorldPoint(3355, 3312, 0),
		new WorldPoint(3368, 3312, 0),

		// Tirannwn
		new WorldPoint(2284, 3141, 0),

		// Prifddinas
		new WorldPoint(3229, 6101, 0),

		// Kandarin
		new WorldPoint(2371, 3427, 0),
		new WorldPoint(2432, 3411, 0),
		new WorldPoint(2490, 3414, 0),
		new WorldPoint(2704, 3397, 0),
		new WorldPoint(2695, 3423, 0),

		// Feldip Hills
		new WorldPoint(2443, 2845, 0),

		// Wilderness
		new WorldPoint(3175, 3931, 0)),

	REDWOOD("Redwood tree", 90,
		// Zeah
		new WorldPoint(1569, 3493, 0),
		new WorldPoint(1569, 3483, 0));

	private final String tooltip;
	private final WorldPoint[] locations;
	private final int levelReq;

	RareTreeLocation(String description, int level, WorldPoint... locations)
	{
		this.tooltip = description + " - Level " + level;
		this.locations = locations;
		this.levelReq = level;
	}
}
