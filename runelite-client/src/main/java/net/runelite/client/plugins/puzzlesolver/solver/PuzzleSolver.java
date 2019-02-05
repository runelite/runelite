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
package net.runelite.client.plugins.puzzlesolver.solver;

import com.google.common.base.Stopwatch;
import java.time.Duration;
import java.util.List;
import net.runelite.client.plugins.puzzlesolver.solver.pathfinding.Pathfinder;

public class PuzzleSolver implements Runnable
{
	public static final int DIMENSION = 5;
	public static final int BLANK_TILE_VALUE = -1;

	private static final Duration MAX_WAIT_DURATION = Duration.ofMillis(1500);

	private Pathfinder pathfinder;
	private PuzzleState startState;

	private List<PuzzleState> solution;
	private int position;
	private Stopwatch stopwatch;
	private boolean failed = false;

	public PuzzleSolver(Pathfinder pathfinder, PuzzleState startState)
	{
		this.pathfinder = pathfinder;
		this.startState = startState;
	}

	public PuzzleState getStep(int stepIdx)
	{
		return solution.get(stepIdx);
	}

	public int getStepCount()
	{
		return solution.size();
	}

	public boolean hasSolution()
	{
		return solution != null;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public boolean hasExceededWaitDuration()
	{
		return stopwatch.elapsed().compareTo(MAX_WAIT_DURATION) > 0;
	}

	public boolean hasFailed()
	{
		return failed;
	}

	@Override
	public void run()
	{
		stopwatch = Stopwatch.createStarted();
		solution = pathfinder.computePath(startState);
		failed = solution == null;
	}
}
