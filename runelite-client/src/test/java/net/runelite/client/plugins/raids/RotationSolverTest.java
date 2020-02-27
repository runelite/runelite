/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.raids;

import static net.runelite.client.plugins.raids.RaidRoom.GUARDIANS;
import static net.runelite.client.plugins.raids.RaidRoom.MUTTADILES;
import static net.runelite.client.plugins.raids.RaidRoom.MYSTICS;
import static net.runelite.client.plugins.raids.RaidRoom.SHAMANS;
import static net.runelite.client.plugins.raids.RaidRoom.TEKTON;
import static net.runelite.client.plugins.raids.RaidRoom.UNKNOWN_COMBAT;
import static net.runelite.client.plugins.raids.RaidRoom.VANGUARDS;
import static net.runelite.client.plugins.raids.RaidRoom.VASA;
import static net.runelite.client.plugins.raids.RaidRoom.VESPULA;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class RotationSolverTest
{
	@Test
	public void testSolve1()
	{
		RaidRoom[] rooms = new RaidRoom[]{VESPULA, UNKNOWN_COMBAT, UNKNOWN_COMBAT, VANGUARDS};
		RotationSolver.solve(rooms);
		assertArrayEquals(new RaidRoom[]{VESPULA, SHAMANS, VASA, VANGUARDS}, rooms);
	}

	@Test
	public void testSolve2()
	{
		RaidRoom[] rooms = new RaidRoom[]{UNKNOWN_COMBAT, UNKNOWN_COMBAT, MUTTADILES, TEKTON};
		RotationSolver.solve(rooms);
		assertArrayEquals(new RaidRoom[]{VESPULA, GUARDIANS, MUTTADILES, TEKTON}, rooms);
	}

	@Test
	public void testSolve3()
	{
		RaidRoom[] rooms = new RaidRoom[]{TEKTON, UNKNOWN_COMBAT, GUARDIANS, MYSTICS};
		RotationSolver.solve(rooms);
		assertArrayEquals(new RaidRoom[]{TEKTON, VASA, GUARDIANS, MYSTICS}, rooms);
	}

	@Test
	public void testSolve4()
	{
		RaidRoom[] rooms = new RaidRoom[]{VASA, UNKNOWN_COMBAT, UNKNOWN_COMBAT, GUARDIANS};
		RotationSolver.solve(rooms);
		assertArrayEquals(new RaidRoom[]{VASA, SHAMANS, VESPULA, GUARDIANS}, rooms);
	}

	@Test
	public void testSolve5()
	{
		RaidRoom[] rooms = new RaidRoom[]{GUARDIANS, UNKNOWN_COMBAT, SHAMANS, VASA};
		RotationSolver.solve(rooms);
		assertArrayEquals(new RaidRoom[]{GUARDIANS, VESPULA, SHAMANS, VASA}, rooms);
	}

	@Test
	public void testSolve6()
	{
		RaidRoom[] rooms = new RaidRoom[]{UNKNOWN_COMBAT, UNKNOWN_COMBAT, TEKTON, MUTTADILES};
		RotationSolver.solve(rooms);
		assertArrayEquals(new RaidRoom[]{VANGUARDS, MYSTICS, TEKTON, MUTTADILES}, rooms);
	}
}