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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import net.runelite.client.plugins.raids.RaidRoom;
import net.runelite.client.plugins.raids.RaidRoom.Boss;

public class RotationSolver
{
	private static final Rotation[] ROTATIONS =
		{
			new Rotation<>(Arrays.asList(Boss.TEKTON, Boss.VASA, Boss.GUARDIANS, Boss.MYSTICS, Boss.SHAMANS, Boss.MUTTADILES, Boss.VANGUARDS, Boss.VESPULA)),
			new Rotation<>(Arrays.asList(Boss.TEKTON, Boss.MUTTADILES, Boss.GUARDIANS, Boss.VESPULA, Boss.SHAMANS, Boss.VASA, Boss.VANGUARDS, Boss.MYSTICS)),
			new Rotation<>(Arrays.asList(Boss.VESPULA, Boss.VANGUARDS, Boss.MUTTADILES, Boss.SHAMANS, Boss.MYSTICS, Boss.GUARDIANS, Boss.VASA, Boss.TEKTON)),
			new Rotation<>(Arrays.asList(Boss.MYSTICS, Boss.VANGUARDS, Boss.VASA, Boss.SHAMANS, Boss.VESPULA, Boss.GUARDIANS, Boss.MUTTADILES, Boss.TEKTON))
		};

	public static void solve(RaidRoom[] rooms)
	{
		if (rooms == null)
		{
			return;
		}

		Rotation match = null;
		Integer start = null;
		Integer index = null;
		int known = 0;

		for (int i = 0; i < rooms.length; i++)
		{
			if (rooms[i] == null || rooms[i].getBoss() == null || rooms[i].getBoss() == Boss.UNKNOWN)
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
			return;
		}

		if (known == rooms.length)
		{
			return;
		}

		for (Rotation rotation : ROTATIONS)
		{
			COMPARE:
			for (int i = 0; i < rotation.size(); i++)
			{
				if (rooms[start].getBoss() == rotation.get(i))
				{
					for (int j = start + 1; j < rooms.length; j++)
					{
						if (rooms[j].getBoss() == null || rooms[j].getBoss() == Boss.UNKNOWN)
						{
							continue;
						}

						if (rooms[j].getBoss() != rotation.get(i + j - start))
						{
							break COMPARE;
						}
					}

					if (match != null && match.equals(rotation))
					{
						return;
					}

					index = i - start;
					match = rotation;
				}
			}
		}

		if (match == null)
		{
			return;
		}

		for (int i = 0; i < rooms.length; i++)
		{
			if (rooms[i] == null)
			{
				continue;
			}

			if (rooms[i].getBoss() == null || rooms[i].getBoss() == Boss.UNKNOWN)
			{
				rooms[i].setBoss((Boss) match.get(index + i));
			}
		}

	}

	private static class Rotation<E> extends ArrayList<E>
	{
		Rotation(final Collection<? extends E> bosses)
		{
			super(bosses);
		}

		@Override
		public E get(int index)
		{
			if (index < 0)
			{
				index = index + size();
			}

			return super.get(index % size());
		}
	}
}
