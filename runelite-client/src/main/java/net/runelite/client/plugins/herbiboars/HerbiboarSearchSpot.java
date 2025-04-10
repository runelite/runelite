/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
 * Copyright (c) 2020, Jordan <nightfirecat@protonmail.com>
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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.VarbitID;

@Getter
enum HerbiboarSearchSpot
{
	// Wiki A location
	A_MUSHROOM(Group.A, new WorldPoint(3670, 3889, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_5, 1, ObjectID.HUNTING_TRAIL9_5),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_6, 1, ObjectID.HUNTING_TRAIL9_6)),
	A_PATCH(Group.A, new WorldPoint(3672, 3890, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_1, 2, ObjectID.HUNTING_TRAIL9_1)),

	// Wiki B location
	B_SEAWEED(Group.B, new WorldPoint(3728, 3893, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_4, 2, ObjectID.HUNTING_TRAIL9_4),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_5, 2, ObjectID.HUNTING_TRAIL9_5),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_1, 1, ObjectID.HUNTING_TRAIL10_1),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_2, 1, ObjectID.HUNTING_TRAIL10_2)),

	// Wiki C location
	C_MUSHROOM(Group.C, new WorldPoint(3697, 3875, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_0, 2, ObjectID.HUNTING_TRAIL9_0)),
	C_PATCH(Group.C, new WorldPoint(3699, 3875, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_3, 1, ObjectID.HUNTING_TRAIL9_3),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_4, 1, ObjectID.HUNTING_TRAIL9_4)),

	// Wiki D location
	D_PATCH(Group.D, new WorldPoint(3708, 3876, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_9, 1, ObjectID.HUNTING_TRAIL9_9),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_0, 1, ObjectID.HUNTING_TRAIL10_0)),
	D_SEAWEED(Group.D, new WorldPoint(3710, 3877, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_3, 2, ObjectID.HUNTING_TRAIL9_3),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_2, 2, ObjectID.HUNTING_TRAIL10_2)),

	// Wiki E location
	E_MUSHROOM(Group.E, new WorldPoint(3668, 3865, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_3, 1, ObjectID.HUNTING_TRAIL10_3),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_4, 1, ObjectID.HUNTING_TRAIL10_4)),
	E_PATCH(Group.E, new WorldPoint(3667, 3862, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_6, 2, ObjectID.HUNTING_TRAIL9_6)),

	// Wiki F location
	F_MUSHROOM(Group.F, new WorldPoint(3681, 3860, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_7, 1, ObjectID.HUNTING_TRAIL9_7),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_8, 1, ObjectID.HUNTING_TRAIL9_8),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_3, 2, ObjectID.HUNTING_TRAIL10_3)),
	F_PATCH(Group.F, new WorldPoint(3681, 3859, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_2, 2, ObjectID.HUNTING_TRAIL9_2)),

	// Wiki G location
	G_MUSHROOM(Group.G, new WorldPoint(3694, 3847, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_0, 2, ObjectID.HUNTING_TRAIL10_0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_7, 1, ObjectID.HUNTING_TRAIL10_7)),
	G_PATCH(Group.G, new WorldPoint(3698, 3847, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_8, 2, ObjectID.HUNTING_TRAIL9_8)),

	// Wiki H location
	H_SEAWEED_EAST(Group.H, new WorldPoint(3715, 3851, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_8, 1, ObjectID.HUNTING_TRAIL10_8),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_9, 1, ObjectID.HUNTING_TRAIL10_9)),
	H_SEAWEED_WEST(Group.H, new WorldPoint(3713, 3850, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_9, 2, ObjectID.HUNTING_TRAIL9_9),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE11_0, 1, ObjectID.HUNTING_TRAIL11_0)),

	// Wiki I location
	I_MUSHROOM(Group.I, new WorldPoint(3680, 3838, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_5, 1, ObjectID.HUNTING_TRAIL10_5),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_6, 1, ObjectID.HUNTING_TRAIL10_6)),
	I_PATCH(Group.I, new WorldPoint(3680, 3836, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE9_7, 2, ObjectID.HUNTING_TRAIL9_7),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_4, 2, ObjectID.HUNTING_TRAIL10_4)),

	// Wiki J location
	J_PATCH(Group.J, new WorldPoint(3713, 3840, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_8, 2, ObjectID.HUNTING_TRAIL10_8),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE11_3, 1, ObjectID.HUNTING_TRAIL11_3)),

	// Wiki K location
	K_PATCH(Group.K, new WorldPoint(3706, 3811, 0),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE10_5, 2, ObjectID.HUNTING_TRAIL10_5),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE11_1, 1, ObjectID.HUNTING_TRAIL11_1),
		new TrailToSpot(VarbitID.HUNTING_TRAIL_STATE11_2, 1, ObjectID.HUNTING_TRAIL11_2)),
	;

	private static final ImmutableMultimap<Group, HerbiboarSearchSpot> GROUPS;
	private static final Set<WorldPoint> SPOTS;
	private static final Set<Integer> TRAILS;

	static
	{
		ImmutableMultimap.Builder<Group, HerbiboarSearchSpot> groupBuilder = new ImmutableMultimap.Builder<>();
		ImmutableSet.Builder<WorldPoint> spotBuilder = new ImmutableSet.Builder<>();
		ImmutableSet.Builder<Integer> trailBuilder = new ImmutableSet.Builder<>();

		for (HerbiboarSearchSpot spot : values())
		{
			groupBuilder.put(spot.getGroup(), spot);
			spotBuilder.add(spot.getLocation());

			for (TrailToSpot trail : spot.getTrails())
			{
				trailBuilder.addAll(trail.getFootprintIds());
			}
		}

		GROUPS = groupBuilder.build();
		SPOTS = spotBuilder.build();
		TRAILS = trailBuilder.build();
	}

	private final Group group;
	private final WorldPoint location;
	private final List<TrailToSpot> trails;

	HerbiboarSearchSpot(Group group, WorldPoint location, TrailToSpot... trails)
	{
		this.group = group;
		this.location = location;
		this.trails = ImmutableList.copyOf(trails);
	}

	/**
	 * Spots are placed in groups of two
	 */
	enum Group
	{
		A, B, C, D, E, F, G, H, I, J, K
	}

	static boolean isTrail(int id)
	{
		return TRAILS.contains(id);
	}

	static boolean isSearchSpot(WorldPoint location)
	{
		return SPOTS.contains(location);
	}

	static List<WorldPoint> getGroupLocations(Group group)
	{
		return GROUPS.get(group).stream().map(HerbiboarSearchSpot::getLocation).collect(Collectors.toList());
	}
}
