/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.puzzlesolver;

import net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleState;
import net.runelite.client.plugins.puzzlesolver.solver.heuristics.ManhattanDistance;
import net.runelite.client.plugins.puzzlesolver.solver.pathfinding.IDAStar;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PuzzleSolverTest
{
	private static final PuzzleState[] START_STATES =
	{
		new PuzzleState(new int[]{0, 11, 1, 3, 4, 5, 12, 2, 7, 9, 6, 20, 18, 16, 8, 15, 22, 10, 14, 13, 21, -1, 17, 23, 19}),
		new PuzzleState(new int[]{0, 2, 7, 3, 4, 10, 5, 12, 1, 9, 6, 17, 8, 14, 19, -1, 16, 21, 11, 13, 15, 20, 22, 18, 23}),
		new PuzzleState(new int[]{0, 1, 11, 3, 4, 12, 2, 7, 13, 9, 5, 21, 15, 17, 14, -1, 10, 6, 8, 19, 16, 20, 22, 18, 23}),
		new PuzzleState(new int[]{0, 1, 2, 3, 4, 10, 5, 6, 9, 14, 15, -1, 7, 13, 17, 21, 11, 20, 23, 8, 16, 22, 12, 19, 18}),
		new PuzzleState(new int[]{0, 1, 2, 3, 4, 5, 6, 8, 22, 18, 10, -1, 7, 17, 9, 20, 11, 12, 21, 14, 16, 15, 23, 13, 19}),
		new PuzzleState(new int[]{0, 1, 2, 3, 4, 5, 6, 8, 12, 9, 16, 11, 17, 7, 14, 10, 20, -1, 22, 13, 15, 18, 21, 23, 19}),
		new PuzzleState(new int[]{1, 6, 16, 8, 4, 0, 7, 11, 2, 9, 5, 21, 18, 3, 14, 10, 20, -1, 13, 22, 15, 23, 12, 17, 19}),
		new PuzzleState(new int[]{0, 1, 2, 4, 8, 6, 16, 11, 7, 3, 5, -1, 12, 14, 9, 15, 10, 17, 13, 18, 20, 21, 22, 23, 19}),
		new PuzzleState(new int[]{0, 2, 9, 14, 6, 5, 7, 11, 3, 4, 15, 10, 1, 12, 18, 16, 17, -1, 8, 13, 20, 21, 22, 23, 19}),
		new PuzzleState(new int[]{0, 1, 2, 3, 4, 11, 5, 12, 7, 8, 10, 6, 15, 13, 9, 16, 21, -1, 17, 14, 20, 22, 23, 18, 19}),
		new PuzzleState(new int[]{5, 0, 1, 2, 4, 10, 6, 3, 8, 9, 12, 13, 7, 14, 19, 15, 11, 16, 17, -1, 20, 21, 22, 18, 23}),
		new PuzzleState(new int[]{0, 6, 1, 3, 4, 5, 8, -1, 2, 9, 16, 11, 12, 7, 14, 10, 15, 17, 13, 19, 20, 21, 22, 18, 23}),
		new PuzzleState(new int[]{0, 6, 1, 2, 4, 11, 15, 8, 3, 14, 5, 7, 9, 12, 18, 16, 10, 17, 23, 13, 20, 21, 22, -1, 19}),
		new PuzzleState(new int[]{0, 1, 7, 2, 4, 5, 3, 12, 8, 9, 15, 6, 18, -1, 13, 11, 10, 22, 17, 23, 16, 21, 20, 19, 14}),
		new PuzzleState(new int[]{0, 1, 2, 7, 3, 5, 11, 6, 14, 4, 10, -1, 16, 12, 9, 15, 17, 18, 8, 19, 20, 21, 13, 22, 23}),
		new PuzzleState(new int[]{2, 10, 5, 3, 4, -1, 0, 1, 8, 9, 15, 11, 7, 13, 23, 17, 6, 20, 14, 19, 16, 12, 18, 21, 22}),
		new PuzzleState(new int[]{0, 1, 2, 8, 9, 5, 6, 7, 3, 4, 10, -1, 14, 23, 18, 21, 11, 16, 12, 19, 15, 20, 17, 13, 22}),
		new PuzzleState(new int[]{0, 6, 1, 3, 4, 11, 2, 13, 9, 12, 5, 16, 7, 18, 8, 20, 15, -1, 14, 19, 21, 10, 22, 23, 17}),
		new PuzzleState(new int[]{12, 1, 2, 3, 4, 0, 7, 6, 8, 9, 5, 10, 22, 13, 19, 15, 11, 21, 14, 17, 20, 16, 18, -1, 23}),
		new PuzzleState(new int[]{0, 2, 11, 3, 4, 5, 1, 6, 8, 9, 15, 10, 13, 14, 19, 7, 12, -1, 17, 18, 20, 21, 16, 22, 23}),
		new PuzzleState(new int[]{5, 0, 4, 2, 9, 10, 7, 3, 19, 8, 6, 1, 18, -1, 14, 15, 11, 16, 12, 13, 20, 21, 17, 22, 23}),
		new PuzzleState(new int[]{0, 3, 2, 7, 4, 6, 10, 1, 8, 9, 15, 5, 12, 18, 13, -1, 20, 11, 22, 14, 16, 21, 23, 17, 19}),
		new PuzzleState(new int[]{1, 2, 4, -1, 9, 0, 5, 7, 3, 14, 10, 6, 8, 13, 19, 15, 11, 18, 12, 22, 20, 16, 21, 23, 17}),
		new PuzzleState(new int[]{0, 1, 2, 4, 9, 5, 11, -1, 7, 14, 10, 17, 6, 13, 8, 15, 16, 20, 3, 18, 22, 21, 12, 23, 19}),
		new PuzzleState(new int[]{0, 1, 8, 2, 4, 5, 11, 17, 3, 9, 6, 16, 7, 12, 18, 15, 21, -1, 14, 13, 20, 22, 10, 23, 19}),
		new PuzzleState(new int[]{5, 0, 2, 3, 4, 1, 8, 6, 7, 9, 11, 12, 16, 13, 14, -1, 22, 20, 17, 19, 21, 10, 15, 18, 23}),
		new PuzzleState(new int[]{0, -1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 16, 11, 13, 14, 10, 15, 19, 22, 23, 20, 21, 17, 12, 18}),
		new PuzzleState(new int[]{0, 2, 7, -1, 4, 6, 1, 9, 3, 14, 5, 12, 8, 13, 19, 15, 16, 10, 22, 23, 20, 11, 18, 21, 17}),
		new PuzzleState(new int[]{7, 5, 13, 1, 12, 0, 2, 4, 3, 9, 10, 6, 8, 17, 14, 15, 11, 16, 18, -1, 20, 21, 22, 23, 19}),
		new PuzzleState(new int[]{5, 0, 3, 8, 4, 10, 6, -1, 7, 9, 11, 1, 12, 2, 19, 15, 16, 17, 14, 13, 20, 21, 22, 18, 23}),
		new PuzzleState(new int[]{5, 2, 3, 7, 4, 0, 6, 14, 9, 19, 1, 11, 22, 17, 12, 10, 15, -1, 13, 8, 20, 16, 21, 18, 23}),
		new PuzzleState(new int[]{0, 1, 3, 4, 9, 5, 6, 2, 7, 14, 10, 13, 17, -1, 8, 15, 11, 16, 12, 18, 20, 21, 22, 23, 19}),
		new PuzzleState(new int[]{0, 3, 11, 7, 4, 5, 2, 6, 12, 8, 10, 1, 17, -1, 9, 15, 16, 23, 13, 14, 20, 21, 18, 22, 19}),
		new PuzzleState(new int[]{1, 5, 8, 2, 4, -1, 0, 7, 3, 9, 11, 22, 15, 12, 14, 6, 10, 18, 16, 19, 20, 21, 17, 13, 23}),
		new PuzzleState(new int[]{7, 12, 11, 4, 9, -1, 0, 8, 10, 2, 6, 1, 16, 3, 14, 5, 15, 17, 13, 19, 20, 21, 22, 18, 23}),
		new PuzzleState(new int[]{11, 3, 2, 12, 4, 6, 0, 7, 13, 8, 1, 5, 17, 16, 9, -1, 10, 15, 18, 14, 20, 21, 22, 23, 19}),
		new PuzzleState(new int[]{0, 6, 1, 3, 4, 5, 11, 2, 10, 9, 15, 12, 8, 14, 19, 16, 21, -1, 7, 13, 20, 22, 17, 18, 23}),
		new PuzzleState(new int[]{0, 1, 2, 3, 4, 6, 10, 7, 8, 9, 5, 16, 11, 14, 17, 20, 13, 18, 12, 22, 21, 15, 23, -1, 19}),
		new PuzzleState(new int[]{0, 1, 2, 4, 8, 5, 6, 7, 3, -1, 10, 16, 18, 17, 9, 15, 12, 11, 14, 13, 20, 21, 22, 23, 19}),
		new PuzzleState(new int[]{0, 11, 6, 1, 4, 5, 21, 8, 2, 9, 10, 3, 16, -1, 14, 15, 12, 17, 13, 19, 20, 22, 7, 18, 23}),
		new PuzzleState(new int[]{0, 6, 1, 2, 4, 11, 10, 3, 13, 9, 5, 7, 8, -1, 23, 15, 16, 22, 18, 14, 20, 21, 12, 17, 19}),
		new PuzzleState(new int[]{0, 6, 1, 2, 3, 10, 11, 12, 5, 18, 15, 7, 4, -1, 14, 21, 17, 13, 8, 9, 16, 20, 22, 23, 19}),
		new PuzzleState(new int[]{0, 1, 3, 11, 4, 6, 10, 14, 2, 8, 5, -1, 12, 7, 9, 15, 16, 18, 13, 19, 20, 21, 22, 17, 23}),
		new PuzzleState(new int[]{1, 5, 2, 3, 4, -1, 0, 7, 14, 8, 11, 6, 13, 9, 23, 10, 12, 15, 19, 17, 20, 21, 16, 22, 18}),
	};

	private static final int[] FINISHED_STATE = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, -1};

	@Test
	public void testSolver()
	{
		for (PuzzleState state : START_STATES)
		{
			PuzzleSolver solver = new PuzzleSolver(new IDAStar(new ManhattanDistance()), state);
			solver.run();

			assertTrue(solver.hasSolution());
			assertFalse(solver.hasFailed());
			assertTrue(solver.getStep(solver.getStepCount() - 1).hasPieces(FINISHED_STATE));
		}
	}
}
