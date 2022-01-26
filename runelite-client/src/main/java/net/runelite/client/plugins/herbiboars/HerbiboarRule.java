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

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
enum HerbiboarRule
{
	A_SOUTH(HerbiboarSearchSpot.Group.A, HerbiboarStart.MIDDLE),
	C_WEST(HerbiboarSearchSpot.Group.C, HerbiboarStart.MIDDLE),
	D_WEST_1(HerbiboarSearchSpot.Group.D, HerbiboarStart.MIDDLE),
	D_WEST_2(HerbiboarSearchSpot.Group.D, HerbiboarSearchSpot.Group.C),
	E_NORTH(HerbiboarSearchSpot.Group.E, HerbiboarSearchSpot.Group.A),
	F_EAST(HerbiboarSearchSpot.Group.F, HerbiboarSearchSpot.Group.G),
	G_NORTH(HerbiboarSearchSpot.Group.G, HerbiboarSearchSpot.Group.F),
	H_NORTH(HerbiboarSearchSpot.Group.H, HerbiboarSearchSpot.Group.D),
	H_EAST(HerbiboarSearchSpot.Group.H, HerbiboarStart.DRIFTWOOD),
	I_EAST(HerbiboarSearchSpot.Group.I, HerbiboarStart.LEPRECHAUN),
	I_SOUTH_1(HerbiboarSearchSpot.Group.I, HerbiboarStart.GHOST_MUSHROOM),
	I_SOUTH_2(HerbiboarSearchSpot.Group.I, HerbiboarStart.CAMP_ENTRANCE),
	I_WEST(HerbiboarSearchSpot.Group.I, HerbiboarSearchSpot.Group.E),
	;

	private final HerbiboarSearchSpot.Group to;
	private final HerbiboarStart fromStart;
	private final HerbiboarSearchSpot.Group fromGroup;

	HerbiboarRule(HerbiboarSearchSpot.Group to, HerbiboarSearchSpot.Group from)
	{
		this(to, null, from);
	}

	HerbiboarRule(HerbiboarSearchSpot.Group to, HerbiboarStart fromStart)
	{
		this(to, fromStart, null);
	}

	/**
	 * Returns whether the next {@link HerbiboarSearchSpot} can be deterministically selected based on the starting
	 * location and the path taken so far, based on the rules defined on the OSRS wiki.
	 *
	 * {@see https://oldschool.runescape.wiki/w/Herbiboar#Guaranteed_tracks}
	 *
	 * @param start       Herbiboar's starting spot where the tracking path begins
	 * @param currentPath A list of {@link HerbiboarSearchSpot}s which have been searched thus far, and the next one to search
	 * @return {@code true} if a rule can be applied, {@code false} otherwise
	 */
	static boolean canApplyRule(HerbiboarStart start, List<HerbiboarSearchSpot> currentPath)
	{
		if (start == null || currentPath.isEmpty())
		{
			return false;
		}

		int lastIndex = currentPath.size() - 1;
		HerbiboarSearchSpot.Group goingTo = currentPath.get(lastIndex).getGroup();

		for (HerbiboarRule rule : values())
		{
			if (lastIndex > 0 && rule.matches(currentPath.get(lastIndex - 1).getGroup(), goingTo)
			|| lastIndex == 0 && rule.matches(start, goingTo))
			{
				return true;
			}
		}

		return false;
	}

	boolean matches(HerbiboarStart from, HerbiboarSearchSpot.Group to)
	{
		return this.matches(from, null, to);
	}

	boolean matches(HerbiboarSearchSpot.Group from, HerbiboarSearchSpot.Group to)
	{
		return this.matches(null, from, to);
	}

	boolean matches(HerbiboarStart fromStart, HerbiboarSearchSpot.Group fromGroup, HerbiboarSearchSpot.Group to)
	{
		return this.to == to
			&& (fromStart != null && this.fromStart == fromStart || fromGroup != null && this.fromGroup == fromGroup);
	}
}
