/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2018, Henke <https://github.com/henke96>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.puzzlesolver.solver.heuristics;

import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.BLANK_TILE_VALUE;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.DIMENSION;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleState;

/**
 * An implementation of the manhattan distance heuristic function.
 * <p>
 * https://heuristicswiki.wikispaces.com/Manhattan+Distance
 */
public class ManhattanDistance implements Heuristic
{
	@Override
	public int computeValue(PuzzleState state)
	{
		int value = 0;

		PuzzleState parent = state.getParent();

		if (parent == null)
		{
			for (int x = 0; x < DIMENSION; x++)
			{
				for (int y = 0; y < DIMENSION; y++)
				{
					int piece = state.getPiece(x, y);

					if (piece == BLANK_TILE_VALUE)
					{
						continue;
					}

					int goalX = piece % DIMENSION;
					int goalY = piece / DIMENSION;

					value += Math.abs(x - goalX) + Math.abs(y - goalY);
				}
			}
		}
		else
		{
			/*
				If the Manhattan distance for the parent has already been
				calculated, we can take advantage of that and just
				add/subtract from their heuristic value.

				Doing this decreases the execution time of the heuristic by about 25%.
			 */
			value = parent.getHeuristicValue(this);

			int x = parent.getEmptyPiece() % DIMENSION;
			int y = parent.getEmptyPiece() / DIMENSION;

			int x2 = state.getEmptyPiece() % DIMENSION;
			int y2 = state.getEmptyPiece() / DIMENSION;

			int piece = state.getPiece(x, y);

			if (x2 > x)
			{
				int targetX = piece % DIMENSION;

				// right
				if (targetX > x)
				{
					value++;
				}
				else
				{
					value--;
				}
			}
			else if (x2 < x)
			{
				int targetX = piece % DIMENSION;

				// left
				if (targetX < x)
				{
					value++;
				}
				else
				{
					value--;
				}
			}
			else if (y2 > y)
			{
				int targetY = piece / DIMENSION;

				// down
				if (targetY > y)
				{
					value++;
				}
				else
				{
					value--;
				}
			}
			else
			{
				int targetY = piece / DIMENSION;

				// up
				if (targetY < y)
				{
					value++;
				}
				else
				{
					value--;
				}
			}
		}

		return value;
	}
}
