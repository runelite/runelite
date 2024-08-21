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

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

enum Courses
{
	GNOME(110.5, 9781, new WorldPoint(2484, 3437, 0), new WorldPoint(2487, 3437, 0)),
	SHAYZIEN_BASIC(153.5, 6200, new WorldPoint(1554, 3640, 0)),
	DRAYNOR(120.0, 12338, new WorldPoint(3103, 3261, 0)),
	AL_KHARID(216.0, 13105, new WorldPoint(3299, 3194, 0)),
	PYRAMID(722.0, 13356, new WorldPoint(3364, 2830, 0)),
	VARROCK(270.0, 12853, new WorldPoint(3236, 3417, 0)),
	PENGUIN(540.0, 10559, new WorldPoint(2652, 4039, 1)),
	BARBARIAN(153.2, 10039, new WorldPoint(2543, 3553, 0)),
	CANIFIS(240.0, 13878, new WorldPoint(3510, 3485, 0)),
	APE_ATOLL(580.0, 11050, new WorldPoint(2770, 2747, 0)),
	SHAYZIEN_ADVANCED(507.5, 5944, new WorldPoint(1522, 3625, 0)),
	FALADOR(586, 12084, new WorldPoint(3029, 3332, 0), new WorldPoint(3029, 3333, 0), new WorldPoint(3029, 3334, 0), new WorldPoint(3029, 3335, 0)),
	WILDERNESS(571.4, 11837, new WorldPoint(2994, 3933, 0)),
	WEREWOLF(730.0, 14234, new WorldPoint(3528, 9873, 0)),
	SEERS(570.0, 10806, new WorldPoint(2704, 3464, 0)),
	POLLNIVNEACH(1016.0, 13358, new WorldPoint(3363, 2998, 0)),
	RELLEKA(920.0, 10553, new WorldPoint(2653, 3676, 0)),
	PRIFDDINAS(1337.0, 12895, new WorldPoint(3240, 6109, 0)),
	ARDOUGNE(889.0, 10547, new WorldPoint(2668, 3297, 0));

	private final static Map<Integer, Courses> coursesByRegion;

	@Getter
	private final double totalXp;

	@Getter
	private final int regionId;

	@Getter
	private final WorldPoint[] courseEndWorldPoints;

	static
	{
		ImmutableMap.Builder<Integer, Courses> builder = new ImmutableMap.Builder<>();

		for (Courses course : values())
		{
			builder.put(course.regionId, course);
		}

		coursesByRegion = builder.build();
	}

	Courses(double totalXp, int regionId, WorldPoint... courseEndWorldPoints)
	{
		this.totalXp = totalXp;
		this.regionId = regionId;
		this.courseEndWorldPoints = courseEndWorldPoints;
	}

	static Courses getCourse(int regionId)
	{
		return coursesByRegion.get(regionId);
	}
}
