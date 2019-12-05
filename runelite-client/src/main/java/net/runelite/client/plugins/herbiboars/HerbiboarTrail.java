/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.herbiboars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

//Location of GameObjects which show TRAIL_xxxxx when used
@AllArgsConstructor
public enum HerbiboarTrail
{
	TRAIL_31303(31303, Varbits.HB_TRAIL_31303, null, new WorldPoint(3697, 3875, 0), null, new WorldPoint(3699, 3875, 0)),
	TRAIL_31306(31306, Varbits.HB_TRAIL_31306, null, new WorldPoint(3672, 3890, 0), null, new WorldPoint(3670, 3889, 0)),
	TRAIL_31309(31309, Varbits.HB_TRAIL_31309, null, new WorldPoint(3681, 3859, 0), null, new WorldPoint(3681, 3860, 0)),
	TRAIL_31312(31312, Varbits.HB_TRAIL_31312, new WorldPoint(3699, 3875, 0), new WorldPoint(3710, 3877, 0), new WorldPoint(3697, 3875, 0), new WorldPoint(3708, 3876, 0)),
	TRAIL_31315(31315, Varbits.HB_TRAIL_31315, new WorldPoint(3699, 3875, 0), new WorldPoint(3728, 3893, 0), new WorldPoint(3697, 3875, 0), null),
	TRAIL_31318(31318, Varbits.HB_TRAIL_31318, new WorldPoint(3670, 3889, 0), new WorldPoint(3728, 3893, 0), new WorldPoint(3672, 3890, 0), null),
	TRAIL_31321(31321, Varbits.HB_TRAIL_31321, new WorldPoint(3670, 3889, 0), new WorldPoint(3667, 3862, 0), new WorldPoint(3672, 3890, 0), new WorldPoint(3668, 3865, 0)),
	TRAIL_31324(31324, Varbits.HB_TRAIL_31324, new WorldPoint(3681, 3860, 0), new WorldPoint(3680, 3836, 0), new WorldPoint(3681, 3859, 0), new WorldPoint(3680, 3838, 0)),
	TRAIL_31327(31327, Varbits.HB_TRAIL_31327, new WorldPoint(3681, 3860, 0), new WorldPoint(3698, 3847, 0), new WorldPoint(3681, 3859, 0), new WorldPoint(3694, 3847, 0)),
	TRAIL_31330(31330, Varbits.HB_TRAIL_31330, new WorldPoint(3708, 3876, 0), new WorldPoint(3713, 3850, 0), new WorldPoint(3710, 3877, 0), new WorldPoint(3715, 3851, 0)),
	TRAIL_31333(31333, Varbits.HB_TRAIL_31333, new WorldPoint(3708, 3876, 0), new WorldPoint(3694, 3847, 0), new WorldPoint(3710, 3877, 0), new WorldPoint(3698, 3847, 0)),
	TRAIL_31336(31336, Varbits.HB_TRAIL_31336, new WorldPoint(3728, 3893, 0), null, null, null),
	TRAIL_31339(31339, Varbits.HB_TRAIL_31339, new WorldPoint(3728, 3893, 0), new WorldPoint(3710, 3877, 0), null, new WorldPoint(3708, 3876, 0)),
	TRAIL_31342(31342, Varbits.HB_TRAIL_31342, new WorldPoint(3668, 3865, 0), new WorldPoint(3681, 3860, 0), new WorldPoint(3667, 3862, 0), new WorldPoint(3681, 3859, 0)),
	TRAIL_31345(31345, Varbits.HB_TRAIL_31345, new WorldPoint(3668, 3865, 0), new WorldPoint(3680, 3836, 0), new WorldPoint(3667, 3862, 0), new WorldPoint(3680, 3838, 0)),
	TRAIL_31348(31348, Varbits.HB_TRAIL_31348, new WorldPoint(3680, 3838, 0), new WorldPoint(3706, 3811, 0), new WorldPoint(3680, 3836, 0), null),
	TRAIL_31351(31351, Varbits.HB_TRAIL_31351, new WorldPoint(3680, 3838, 0), null, new WorldPoint(3680, 3836, 0), null),
	TRAIL_31354(31354, Varbits.HB_TRAIL_31354, new WorldPoint(3694, 3847, 0), null, new WorldPoint(3698, 3847, 0), null),
	TRAIL_31357(31357, Varbits.HB_TRAIL_31357, new WorldPoint(3715, 3851, 0), new WorldPoint(3713, 3840, 0), new WorldPoint(3713, 3850, 0), null),
	TRAIL_31360(31360, Varbits.HB_TRAIL_31360, new WorldPoint(3715, 3851, 0), null, new WorldPoint(3713, 3850, 0), null),
	TRAIL_31363(31363, Varbits.HB_TRAIL_31363, new WorldPoint(3713, 3850, 0), null, new WorldPoint(3715, 3851, 0), null),
	TRAIL_31366(31366, Varbits.HB_TRAIL_31366, null, null, null, null),
	TRAIL_31369(31369, Varbits.HB_TRAIL_31369, new WorldPoint(3706, 3811, 0), null, null, null),
	TRAIL_31372(31372, Varbits.HB_TRAIL_31372, new WorldPoint(3713, 3840, 0), null, null, null);

	@Getter(AccessLevel.PACKAGE)
	private final int trailId;
	@Getter(AccessLevel.PACKAGE)
	private final Varbits varbit;
	private final WorldPoint objectLoc1;
	private final WorldPoint objectLoc2;
	private final WorldPoint objectLoc3;
	private final WorldPoint objectLoc4;

	@Getter(AccessLevel.PACKAGE)
	private static Set<Integer> trailIds = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private static Set<WorldPoint> allObjectLocs = new HashSet<>();

	static
	{
		for (HerbiboarTrail trail : values())
		{
			trailIds.add(trail.trailId);
			trailIds.add(trail.trailId + 1);

			allObjectLocs.addAll(Arrays.asList(trail.getObjectLocs(1)));
			allObjectLocs.addAll(Arrays.asList(trail.getObjectLocs(2)));
		}
	}

	public WorldPoint[] getObjectLocs(int varbitValue)
	{
		switch (varbitValue)
		{
			case 1:
				return new WorldPoint[]{objectLoc1, objectLoc3};
			case 2:
				return new WorldPoint[]{objectLoc2, objectLoc4};
			case 0:
			default:
				return new WorldPoint[]{};
		}
	}

	@Override
	public String toString()
	{
		return String.format("trailId=%s obj1=%s obj2=%s obj3=%s obj4=%s", trailId, objectLoc1, objectLoc2, objectLoc3, objectLoc4);
	}
}
