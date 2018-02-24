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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PuzzleSolverTest
{
	private static final int[] TEST_STATE = new int[]{5, 10, 3, 6, 4, 0, 2, 12, 7, 9, 16, -1, 22, 1, 14, 11, 8, 21, 13, 18, 15, 20, 23, 17, 19};//{0, 11, 1, 3, 4, 5, 12, 2, 7, 9, 6, 20, 18, 16, 8, 15, 22, 10, 14, 13, 21, -1, 17, 23, 19};
	private static final int[] FINISHED_STATE = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, -1};

	@Test
	public void testSolver()
	{
		int[] tiles = new int[TEST_STATE.length];
		System.arraycopy(TEST_STATE, 0, tiles, 0, TEST_STATE.length);
		PuzzleSolver solver = new PuzzleSolver(TEST_STATE);
		long start = System.nanoTime();
		solver.run();
		long end = System.nanoTime();
		System.out.println(end - start);
		int[] solution = solver.getSolution();

		assertEquals(solution != null, true);

		if (solution != null) {

			performSolution(solution, tiles);

			for (int i = 0; i < FINISHED_STATE.length; i++) {
				assertEquals(tiles[i], FINISHED_STATE[i]);
			}
		}
	}

	private void performSolution(int[] solution, int[] tiles)
	{
		for (int i = 0; i < solution.length - 1; ++i)
		{
			int newEmptyIndex = solution[i + 1];
			tiles[solution[i]] = tiles[newEmptyIndex];
			tiles[newEmptyIndex] = -1;
		}
	}
}
