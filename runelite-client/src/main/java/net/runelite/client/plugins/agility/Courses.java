/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.agility;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@AllArgsConstructor
public enum Courses
{
	GNOME(86.5, 46, 9781, new WorldPoint[] { new WorldPoint(2484, 3437, 0), new WorldPoint(2487, 3437, 0) }),
	DRAYNOR(120.0, 79, 12338, new WorldPoint[] { new WorldPoint(3103, 3261, 0) }),
	AL_KARID(180.0, 30, 13105, new WorldPoint[] { new WorldPoint(3299, 3194, 0) }),
	PYRAMID(722.0, 300, 13356, new WorldPoint[] { new WorldPoint(3364, 2830, 0) }),
	VARROCK(238.0, 125, 12853, new WorldPoint[] { new WorldPoint(3236, 3417, 0), new WorldPoint(3237, 3417, 0), new WorldPoint(3238, 3417, 0), new WorldPoint(3239, 3417, 0), new WorldPoint(3240, 3417, 0) }),
	PENGUIN(540.0, 65, 10559, new WorldPoint[] { new WorldPoint(2651, 4039, 1), new WorldPoint(2652, 4039, 1) }),
	BARBARIAN(139.5, 60, 10039, new WorldPoint[] { new WorldPoint(2543, 3553, 0) }),
	CANIFIS(240.0, 175, 13878, new WorldPoint[] { new WorldPoint(3510, 3485, 0) }),
	APE_ATOLL(580.0, 300, 11050, new WorldPoint[] { new WorldPoint(2770, 2747, 0) }),
	FALADOR(440, 180, 12084, new WorldPoint[] { new WorldPoint(3029, 3333, 0) }),
	WILDERNESS(571.0, 499, 11837, new WorldPoint[] { new WorldPoint(2993, 3933, 0), new WorldPoint(2994, 3933, 0), new WorldPoint(2995, 3933, 0) }),
	SEERS(570.0, 435, 10806, new WorldPoint[] { new WorldPoint(2704, 3464, 0) }),
	POLLNIVEACH(890.0, 540, 13358, new WorldPoint[] { new WorldPoint(3363, 2998, 0) }),
	RELLEKA(780.0, 475, 10553, new WorldPoint[] { new WorldPoint(2653, 3676, 0) }),
	ARDOUGNE(793.0, 529, 10547, new WorldPoint[] { new WorldPoint(2668, 3297, 0) });

	private final static Map<Integer, Courses> coursesByRegion = new HashMap<>();

	@Getter
	private final double totalXp;

	@Getter
	private final int lastObstacleXp;

	@Getter
	private final int regionId;

	@Getter
	private final WorldPoint[] courseEndWorldPoints;

	static
	{
		for (Courses course : values())
		{
			coursesByRegion.put(course.regionId, course);
		}
	}

	public static Courses getCourse(int regionId)
	{
		return coursesByRegion.get(regionId);
	}
}
