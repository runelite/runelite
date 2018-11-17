/*
 * Copyright (c) 2018, Steffen Hauge <steffen.oerum.hauge@hotmail.com>
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
package net.runelite.client.plugins.puzzlesolver.solver.monkeymadness;

import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Point;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleState;
import net.runelite.client.plugins.puzzlesolver.solver.pathfinding.Pathfinder;

public class PuzzleSolverMM extends PuzzleSolver implements Runnable
{
	private Pathfinder pathfinder;
	private PuzzleStateMM startState;

	private List<PuzzleState> solution = new ArrayList<>();
	private int position;
	private boolean failed = false;

	public PuzzleSolverMM(Pathfinder pathfinder, PuzzleStateMM startState)
	{
		super(pathfinder, startState);

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

	public boolean hasFailed()
	{
		return failed;
	}

	@Override
	public void run()
	{
		solution = computePath(startState);
		failed = solution == null;
	}

	private List<PuzzleState> computePath(PuzzleStateMM root)
	{
		//Reduce to 4x5
		root.solveRow(0);

		//Reduce to 4x4
		root.solveColumn(0);

		//Get state
		PuzzleState preSolved = new PuzzleState(root);

		//Pathfinder for 4x4
		PuzzleState pathfinderSolved = root.solvePathfinder(preSolved, pathfinder);

		if (pathfinderSolved == null)
		{
			//Pathfinder failed
			return null;
		}

		List<PuzzleState> path = new ArrayList<>();

		PuzzleState parent = pathfinderSolved;
		while (parent != null)
		{
			path.add(0, parent);
			parent = parent.getParent();
		}

		//Get the swaps needed
		List<Point> swaps = root.getSwaps();

		for (int i = swaps.size() - 1; i > 0; i -= 2)
		{
			Point swap1 = swaps.get(i);
			Point swap2 = swaps.get(i - 1);

			PuzzleState prevStep = root.stateFromSwap(swap1, swap2);

			path.add(0, prevStep);
		}

		return path;
	}
}
