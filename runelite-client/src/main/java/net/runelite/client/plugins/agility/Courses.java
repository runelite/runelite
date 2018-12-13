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
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

enum Courses
{
	GNOME(86.5, 46, 9781),
	DRAYNOR(120.0, 79, 12338),
	AL_KHARID(180.0, 30, 13105, new WorldPoint(3299, 3194, 0)),
	PYRAMID(722.0, 300, 13356, new WorldPoint(3364, 2830, 0)),
	VARROCK(238.0, 125, 12853),
	PENGUIN(540.0, 65, 10559),
	BARBARIAN(139.5, 60, 10039),
	CANIFIS(240.0, 175, 13878),
	APE_ATOLL(580.0, 300, 11050),
	FALADOR(440, 180, 12084),
	WILDERNESS(571.0, 499, 11837),
	WEREWOLF(730.0, 380, 14234),
	SEERS(570.0, 435, 10806),
	POLLNIVNEACH(890.0, 540, 13358),
	RELLEKA(780.0, 475, 10553),
	ARDOUGNE(793.0, 529, 10547);

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

	Courses(double totalXp, int lastObstacleXp, int regionId, WorldPoint... courseEndWorldPoints)
	{
		this.totalXp = totalXp;
		this.lastObstacleXp = lastObstacleXp;
		this.regionId = regionId;
		this.courseEndWorldPoints = courseEndWorldPoints;
	}

	static Courses getCourse(int regionId)
	{
		return coursesByRegion.get(regionId);
	}
}
