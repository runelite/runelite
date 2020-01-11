/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids.solver;

import com.google.common.collect.ImmutableList;
import net.runelite.client.plugins.raids.RaidRoom;
import net.runelite.client.plugins.raids.RoomType;
import java.util.List;
import static net.runelite.client.plugins.raids.RaidRoom.GUARDIANS;
import static net.runelite.client.plugins.raids.RaidRoom.MUTTADILES;
import static net.runelite.client.plugins.raids.RaidRoom.MYSTICS;
import static net.runelite.client.plugins.raids.RaidRoom.SHAMANS;
import static net.runelite.client.plugins.raids.RaidRoom.TEKTON;
import static net.runelite.client.plugins.raids.RaidRoom.UNKNOWN_COMBAT;
import static net.runelite.client.plugins.raids.RaidRoom.VANGUARDS;
import static net.runelite.client.plugins.raids.RaidRoom.VASA;
import static net.runelite.client.plugins.raids.RaidRoom.VESPULA;

public class RotationSolver
{
	private static final ImmutableList<ImmutableList<RaidRoom>> ROTATIONS = ImmutableList.of
	(
			ImmutableList.of(TEKTON, VASA, GUARDIANS, MYSTICS, SHAMANS, MUTTADILES, VANGUARDS, VESPULA),
			ImmutableList.of(TEKTON, MUTTADILES, GUARDIANS, VESPULA, SHAMANS, VASA, VANGUARDS, MYSTICS),
			ImmutableList.of(VESPULA, VANGUARDS, MUTTADILES, SHAMANS, MYSTICS, GUARDIANS, VASA, TEKTON),
			ImmutableList.of(MYSTICS, VANGUARDS, VASA, SHAMANS, VESPULA, GUARDIANS, MUTTADILES, TEKTON)
	);

	public static boolean solve(RaidRoom[] rooms)
	{
		if (rooms == null)
		{
			return false;
		}

		List<RaidRoom> match = null;
		Integer start = null;
		Integer index = null;
		int known = 0;

		for (int i = 0; i < rooms.length; i++)
		{
			if (rooms[i] == null || rooms[i].getType() != RoomType.COMBAT || rooms[i] == UNKNOWN_COMBAT)
			{
				continue;
			}

			if (start == null)
			{
				start = i;
			}

			known++;
		}

		if (known < 2)
		{
			return false;
		}

		if (known == rooms.length)
		{
			return true;
		}

		for (List rotation : ROTATIONS)
		{
			COMPARE:
			for (int i = 0; i < rotation.size(); i++)
			{
				if (rooms[start] == rotation.get(i))
				{
					for (int j = start + 1; j < rooms.length; j++)
					{
						if (rooms[j].getType() != RoomType.COMBAT || rooms[j] == UNKNOWN_COMBAT)
						{
							continue;
						}

						if (rooms[j] != rotation.get((i + j - start) % rotation.size()))
						{
							break COMPARE;
						}
					}

					if (match != null && match.equals(rotation))
					{
						return false;
					}

					index = i - start;
					match = rotation;
				}
			}
		}

		if (match == null)
		{
			return false;
		}

		for (int i = 0; i < rooms.length; i++)
		{
			if (rooms[i] == null)
			{
				continue;
			}

			if ((rooms[i].getType() != RoomType.COMBAT || rooms[i] == UNKNOWN_COMBAT))
			{
				rooms[i] = match.get((index + i + match.size()) % match.size());
			}
		}
		return true;
	}
}