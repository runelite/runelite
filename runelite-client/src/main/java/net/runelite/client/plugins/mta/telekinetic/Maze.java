/*
 * Copyright (c) 2018, Jasper Ketelaar <Jasper0781@gmail.com>
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
package net.runelite.client.plugins.mta.telekinetic;

import net.runelite.api.coords.LocalPoint;

public enum Maze
{
	MAZE_1(100, new LocalPoint(6848, 3904)),
	MAZE_2(124, new LocalPoint(4928, 6848)),
	MAZE_3(129, new LocalPoint(7104, 5312)),
	MAZE_4(53, new LocalPoint(6208, 4928)),
	MAZE_5(108, new LocalPoint(5056, 5184)),
	MAZE_6(121, new LocalPoint(3648, 5440)),
	MAZE_7(71, new LocalPoint(6080, 5696)),
	MAZE_8(98, new LocalPoint(5952, 7360)),
	MAZE_9(87, new LocalPoint(5184, 6208)),
	MAZE_10(91, new LocalPoint(5440, 9024));

	private final int walls;
	private final LocalPoint start;

	Maze(int walls, LocalPoint start)
	{
		this.walls = walls;
		this.start = start;
	}

	public static Maze fromWalls(int walls)
	{
		for (Maze maze : values())
		{
			if (maze.getWalls() == walls)
			{
				return maze;
			}
		}

		return null;
	}

	public int getWalls()
	{
		return walls;
	}

	public LocalPoint getStart()
	{
		return start;
	}
}