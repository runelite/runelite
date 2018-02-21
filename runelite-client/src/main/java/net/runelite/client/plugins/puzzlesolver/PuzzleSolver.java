/*
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

package net.runelite.client.plugins.puzzlesolver;

public class PuzzleSolver implements Runnable
{
	public static final int BLANK_TILE_VALUE = -1;
	public static final int DIMENSION = 5;
	public static final int SIZE = DIMENSION * DIMENSION;

	private static final int MAX_DEPTH = 64;

	private static final int RIGHT = 0;
	private static final int LEFT = 1;
	private static final int DOWN = 2;
	private static final int UP = 3;

	private int[] tiles;
	private int searchDepth;
	private int[] solution;

	private volatile boolean shouldStop;

	public PuzzleSolver(int[] tiles)
	{
		this.tiles = new int[tiles.length];
		System.arraycopy(tiles, 0, this.tiles, 0, tiles.length);
		shouldStop = false;
	}

	public void stop()
	{
		shouldStop = true;
	}

	public int[] getSolution()
	{
		return solution;
	}

	@Override
	public void run()
	{
		int manhattanDistance = 0;
		int emptyIndex = -1;
		//Calculate initial manhattanDistance
		for (int i = 0; i < SIZE; ++i)
		{
			if (tiles[i] == BLANK_TILE_VALUE)
			{
				emptyIndex = i;
				continue;
			}
			int destX = tiles[i] % DIMENSION;
			int destY = tiles[i] / DIMENSION;
			int srcX = i % DIMENSION;
			int srcY = i / DIMENSION;
			manhattanDistance += Math.abs(destX - srcX) + Math.abs(destY - srcY);
		}

		if (emptyIndex == -1)
		{
			return;
		}

		int[] solution = null;

		for (searchDepth = manhattanDistance; searchDepth <= MAX_DEPTH; ++searchDepth)
		{
			if (shouldStop) break;
			solution = findSolution(RIGHT, emptyIndex, 1, manhattanDistance);
			if (solution != null)
			{
				solution[0] = emptyIndex;
				break;
			}

			if (shouldStop) break;
			solution = findSolution(LEFT, emptyIndex, 1, manhattanDistance);
			if (solution != null)
			{
				solution[0] = emptyIndex;
				break;
			}

			if (shouldStop) break;
			solution = findSolution(DOWN, emptyIndex, 1, manhattanDistance);
			if (solution != null)
			{
				solution[0] = emptyIndex;
				break;
			}

			if (shouldStop) break;
			solution = findSolution(UP, emptyIndex, 1, manhattanDistance);
			if (solution != null)
			{
				solution[0] = emptyIndex;
				break;
			}
		}
		this.solution = solution;
	}

	private int[] findSolution(int direction, int emptyIndex, int depth, int manhattanDistance)
	{
		//Update manhattanDistance and prepare tile movement
		int newEmptyIndex;
		switch (direction)
		{
			case RIGHT:
			{
				int prevEmptyX = emptyIndex % DIMENSION;
				if (prevEmptyX == DIMENSION - 1) return null;

				newEmptyIndex = emptyIndex + 1;
				int movedTileDestX = tiles[newEmptyIndex] % DIMENSION;
				if (prevEmptyX < movedTileDestX) ++manhattanDistance;
				else --manhattanDistance;
				break;
			}
			case LEFT:
			{
				int prevEmptyX = emptyIndex % DIMENSION;
				if (prevEmptyX == 0) return null;

				newEmptyIndex = emptyIndex - 1;
				int movedTileDestX = tiles[newEmptyIndex] % DIMENSION;
				if (prevEmptyX > movedTileDestX) ++manhattanDistance;
				else --manhattanDistance;
				break;
			}
			case DOWN:
			{
				int prevEmptyY = emptyIndex / DIMENSION;
				if (prevEmptyY == DIMENSION - 1) return null;

				newEmptyIndex = emptyIndex + DIMENSION;
				int movedTileDestY = tiles[newEmptyIndex] / DIMENSION;
				if (prevEmptyY < movedTileDestY) ++manhattanDistance;
				else --manhattanDistance;
				break;
			}
			default: // UP
			{
				int prevEmptyY = emptyIndex / DIMENSION;
				if (prevEmptyY == 0) return null;

				newEmptyIndex = emptyIndex - DIMENSION;
				int movedTileDestY = tiles[newEmptyIndex] / DIMENSION;
				if (prevEmptyY > movedTileDestY) ++manhattanDistance;
				else --manhattanDistance;
			}
		}
		//Check if done or if it's impossible to finish within searchDepth
		if (manhattanDistance == 0)
		{
			int[] solution = new int[depth + 1];
			solution[depth] = newEmptyIndex;
			return solution;
		}
		else if (depth + manhattanDistance > searchDepth) return null;

		//Perform tile movement
		tiles[emptyIndex] = tiles[newEmptyIndex];

		//Continue searching in all directions except for the one that returns directly
		if (direction != RIGHT)
		{
			int[] solution = findSolution(LEFT, newEmptyIndex, depth + 1, manhattanDistance);
			if (solution != null)
			{
				solution[depth] = newEmptyIndex;
				return solution;
			}
		}
		if (direction != LEFT)
		{
			int[] solution = findSolution(RIGHT, newEmptyIndex, depth + 1, manhattanDistance);
			if (solution != null)
			{
				solution[depth] = newEmptyIndex;
				return solution;
			}
		}
		if (direction != DOWN)
		{
			int[] solution = findSolution(UP, newEmptyIndex, depth + 1, manhattanDistance);
			if (solution != null)
			{
				solution[depth] = newEmptyIndex;
				return solution;
			}
		}
		if (direction != UP)
		{
			int[] solution = findSolution(DOWN, newEmptyIndex, depth + 1, manhattanDistance);
			if (solution != null)
			{
				solution[depth] = newEmptyIndex;
				return solution;
			}
		}
		//Revert tile movement
		tiles[newEmptyIndex] = tiles[emptyIndex];
		return null;
	}
}