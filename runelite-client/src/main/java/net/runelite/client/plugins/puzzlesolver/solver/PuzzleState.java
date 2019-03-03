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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.client.plugins.puzzlesolver.solver.heuristics.Heuristic;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.DIMENSION;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.BLANK_TILE_VALUE;

public class PuzzleState
{
	private PuzzleState parent;

	private int[] pieces;
	private int emptyPiece = -1;

	private int h = -1;

	public PuzzleState(int[] pieces)
	{
		if (pieces == null)
		{
			throw new IllegalStateException("Pieces cannot be null");
		}

		if (DIMENSION * DIMENSION != pieces.length)
		{
			throw new IllegalStateException("Piece array does not have the right dimensions");
		}

		this.pieces = pieces;
		findEmptyPiece();
	}

	private PuzzleState(PuzzleState state)
	{
		this.pieces = Arrays.copyOf(state.pieces, state.pieces.length);
		this.emptyPiece = state.emptyPiece;
	}

	private void findEmptyPiece()
	{
		for (int i = 0; i < pieces.length; i++)
		{
			if (pieces[i] == BLANK_TILE_VALUE)
			{
				this.emptyPiece = i;
				return;
			}
		}
		throw new IllegalStateException("Incorrect empty piece passed in!");
	}

	public List<PuzzleState> computeMoves()
	{
		List<PuzzleState> moves = new ArrayList<>();

		int emptyPieceX = emptyPiece % DIMENSION;
		int emptyPieceY = emptyPiece / DIMENSION;

		// Move left if there is space to the left
		if (emptyPieceX > 0)
		{
			if (parent == null || parent.emptyPiece != emptyPiece - 1)
			{
				PuzzleState state = new PuzzleState(this);
				state.parent = this;

				state.pieces[emptyPiece - 1] = BLANK_TILE_VALUE;
				state.pieces[emptyPiece] = pieces[emptyPiece - 1];
				state.emptyPiece--;

				moves.add(state);
			}
		}

		// Move right if there is space to the right
		if (emptyPieceX < DIMENSION - 1)
		{
			if (parent == null || parent.emptyPiece != emptyPiece + 1)
			{
				PuzzleState state = new PuzzleState(this);
				state.parent = this;

				state.pieces[emptyPiece + 1] = BLANK_TILE_VALUE;
				state.pieces[emptyPiece] = pieces[emptyPiece + 1];
				state.emptyPiece++;

				moves.add(state);
			}
		}

		// Move up if there is space upwards
		if (emptyPieceY > 0)
		{
			if (parent == null || parent.emptyPiece != emptyPiece - DIMENSION)
			{
				PuzzleState state = new PuzzleState(this);
				state.parent = this;

				state.pieces[emptyPiece - DIMENSION] = BLANK_TILE_VALUE;
				state.pieces[emptyPiece] = pieces[emptyPiece - DIMENSION];
				state.emptyPiece -= DIMENSION;

				moves.add(state);
			}
		}

		// Move down if there is space downwards
		if (emptyPieceY < DIMENSION - 1)
		{
			if (parent == null || parent.emptyPiece != emptyPiece + DIMENSION)
			{
				PuzzleState state = new PuzzleState(this);
				state.parent = this;

				state.pieces[emptyPiece + DIMENSION] = BLANK_TILE_VALUE;
				state.pieces[emptyPiece] = pieces[emptyPiece + DIMENSION];
				state.emptyPiece += DIMENSION;

				moves.add(state);
			}
		}

		return moves;
	}

	public PuzzleState getParent()
	{
		return parent;
	}

	public boolean hasPieces(int[] pieces)
	{
		return Arrays.equals(pieces, this.pieces);
	}

	public int getPiece(int x, int y)
	{
		return pieces[y * DIMENSION + x];
	}

	public int getEmptyPiece()
	{
		return emptyPiece;
	}

	public int getHeuristicValue(Heuristic heuristic)
	{
		if (h == -1)
		{
			// cache the value
			h = heuristic.computeValue(this);
		}

		return h;
	}

	public PuzzleState swap(int x1, int y1, int x2, int y2)
	{
		int val1 = getPiece(x1, y1);
		int val2 = getPiece(x2, y2);

		if (!isValidSwap(x1, y1, x2, y2))
		{
			throw new IllegalStateException(String.format("Invalid swap: (%1$d, %2$d), (%3$d, %4$d)", x1, y1, x2, y2));
		}

		PuzzleState newState = new PuzzleState(this);

		newState.pieces[y1 * DIMENSION + x1] = val2;
		newState.pieces[y2 * DIMENSION + x2] = val1;
		newState.findEmptyPiece();

		return newState;
	}

	private boolean isValidSwap(int x1, int y1, int x2, int y2)
	{
		int absX = Math.abs(x1 - x2);
		int absY = Math.abs(y1 - y2);

		if (getPiece(x1, y1) != BLANK_TILE_VALUE && getPiece(x2, y2) != BLANK_TILE_VALUE)
		{
			return false;
		}

		if (x1 == x2 && absY == 1)
		{
			return true;
		}

		if (y1 == y2 && absX == 1)
		{
			return true;
		}

		return false;
	}
}
