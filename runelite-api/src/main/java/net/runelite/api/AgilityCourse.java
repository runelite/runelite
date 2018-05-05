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
package net.runelite.api;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AgilityCourse
{
	GNOME(86.5, 9781, 46),
	DRAYNOR(120.0, 12338, 79),
	AL_KHARID(180.0, 13105, 30),
	PYRAMID(722.0, 13356, 300),
	VARROCK(238.0, 12853, 125),
	PENGUIN(540.0, 10559, 65),
	BARBARIAN(139.5, 10039, 60),
	CANIFIS(240.0, 13878, 175),
	APE_ATOLL(580.0, 11050, 300),
	FALADOR(440, 12084, 180),
	WILDERNESS(571.0, 11837, 499),
	SEERS(570.0, 10806, 435),
	POLLNIVEACH(890.0, 13358, 540),
	RELLEKA(780.0, 10553, 475),
	ARDOUGNE(793.0, 10547, 529);

	private final static Map<Integer, AgilityCourse> courseXps = new HashMap<>();

	static
	{
		for (AgilityCourse course : values())
		{
			courseXps.put(course.lastObstacleXp, course);
		}
	}

	@Getter
	private final double totalXp;
	@Getter
	private final int regionId;
	private final int lastObstacleXp;

	public static AgilityCourse getCourse(int exp)
	{
		return courseXps.get(exp);
	}
}
