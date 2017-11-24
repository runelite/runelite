/*
 * Copyright (c) 2017. l2-
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.volcanicmine;

import com.google.common.collect.ImmutableSet;
import net.runelite.api.Point;
import java.util.Set;

class OptimalPaths
{
	private static final int INSTANCE_SIZE = 192;

	private static final Set<Point> OPTIMAL_PATH_POINTS = ImmutableSet.of(
		new Point(161, 145),
		new Point(161, 144),
		new Point(161, 143),
		new Point(161, 142),
		new Point(169, 151),
		new Point(169, 148),
		new Point(169, 147),
		new Point(169, 133),
		new Point(175, 146),
		new Point(176, 146),
		new Point(179, 116),
		new Point(179, 117),
		new Point(179, 118),
		new Point(167, 101),
		new Point(167, 100),
		new Point(167, 104),
		new Point(167, 105),
		new Point(166, 76),
		new Point(166, 77),
		new Point(166, 78),
		new Point(166, 79),
		new Point(146, 107),
		new Point(145, 107),
		new Point(144, 107),
		new Point(143, 107),
		new Point(142, 107),
		new Point(141, 107),
		new Point(139, 104),
		new Point(139, 103),
		new Point(139, 102),
		new Point(139, 101),
		new Point(152, 101),
		new Point(152, 100),
		new Point(149, 76)
	);

	public final static Set<Point> BOULDER_RANGE_POINTS = ImmutableSet.of(
		new Point(162, 123),
		new Point(161, 152),
		new Point(160, 151),
		new Point(163, 105),
		new Point(163, 104),
		new Point(163, 103),
		new Point(163, 102),
		new Point(163, 101),
		new Point(164, 92),
		new Point(164, 91),
		new Point(164, 90),
		new Point(164, 83),
		new Point(165, 80),
		new Point(164, 80),
		new Point(155, 80),
		new Point(155, 81),
		new Point(155, 82),
		new Point(155, 83),
		new Point(155, 89),
		new Point(155, 90),
		new Point(155, 91),
		new Point(155, 92),
		new Point(156, 103),
		new Point(156, 104),
		new Point(156, 105),
		new Point(162, 126),
		new Point(162, 125),
		new Point(162, 124)
	);

	//only use global location
	public static boolean isOptimalPathTile(Point point)
	{
		Point instanceLocation = new Point(point.getX() % INSTANCE_SIZE, point.getY() % INSTANCE_SIZE);
		return OPTIMAL_PATH_POINTS.contains(instanceLocation);
	}

	//only use global location
	public static boolean isBoulderRangeTile(Point point)
	{
		Point instanceLocation = new Point(point.getX() % INSTANCE_SIZE, point.getY() % INSTANCE_SIZE);
		return BOULDER_RANGE_POINTS.contains(instanceLocation);
	}
}
