/*
 * This code file is a derivative of code by Jaap Scherphuis <https://www.jaapsch.net/puzzles/fifteen.htm>.
 * The original code can be found in the page source of https://www.jaapsch.net/puzzles/javascript/fifteenj.htm.
 *
 * Quote copied verbatim from the creator's grant to use this code in RuneLite:
 *
 * "You have my permission to incorporate, adapt, and distribute any part
 * of my 15-puzzle javascript code as part of your free, open source project"
 *
 *
 * The adaptions made to Jaap Scherphuis' code is copyrighted and licensed according to:
 *
 *
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

import java.util.ArrayList;
import java.util.List;

/**
 * This 5x5 sliding puzzle solver algorithm is based on https://www.jaapsch.net/puzzles/fifteen.htm.
 */
public class PuzzleSolver
{
	public static final int BLANK_TILE_VALUE = -1;
	public static final int DIMENSION = 5;
	private static final int SIZE = DIMENSION * DIMENSION - 1;

	private int[] tiles = new int[SIZE + DIMENSION];
	private List<Integer> seq = new ArrayList<>();

	private int blankX;
	private int blankY;

	private int mode;

	public PuzzleSolver(int[] arr)
	{
		System.arraycopy(arr, 0, tiles, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == BLANK_TILE_VALUE)
			{
				blankX = i % DIMENSION;
				blankY = i / DIMENSION;
				break;
			}
		}
	}

	public boolean hasNext()
	{
		for (int i = SIZE; i >= 0; i--)
		{
			if (tiles[i] != i)
			{
				return true;
			}
		}
		return false;
	}

	public void next()
	{
		if (mode == 0)
		{
			mode = 3;
			seq.clear();

			int[] oldTiles = new int[tiles.length];
			System.arraycopy(tiles, 0, oldTiles, 0, tiles.length);
			int oldBlankX = blankX;
			int oldBlankY = blankY;

			//restore top rows
			int rr = 0;
			for (int r = 0; r < DIMENSION - 2; r++)
			{
				for (int c = 0; c < DIMENSION; c++)
				{
					movePiece(rr + c, r, c);
				}
				rr += DIMENSION;
			}

			//restore left columns
			for (int c = 0; c < DIMENSION - 2; c++)
			{
				//restore top tile of column.
				movePiece(rr, DIMENSION - 2, c);
				//restore bottom tile of column
				if (blankX == c) push(3);  //fill destination spot
				if (tiles[rr + DIMENSION] != rr + DIMENSION)
				{
					movePiece(rr + DIMENSION, DIMENSION - 1, c + 1);
					if (blankY != DIMENSION - 1)
					{    //0=right, 1=down, 2=up, 3=left
						//A.X or AX.
						//XBX    XBX
						if (blankX == c + 1) push(3);
						push(2);
					}
					//AXX
					//XB.
					while (blankX > c + 2)
					{
						push(0);
					}
					push(0, 0, 1, 3, 2, 3, 1, 0, 0, 2, 3);
				}
				rr++;
			}

			//last 2x2 square
			if (blankX < DIMENSION - 1) push(3);
			if (blankY < DIMENSION - 1) push(2);
			rr = SIZE - DIMENSION - 1;
			if (tiles[rr] == rr + 1) push(1, 0, 2, 3);
			if (tiles[rr] == rr + DIMENSION) push(0, 1, 3, 2);

			//restore pieces;
			System.arraycopy(oldTiles, 0, tiles, 0, tiles.length);
			blankX = oldBlankX;
			blankY = oldBlankY;
		}

		if (mode >= 3)
		{
			if (!seq.isEmpty())
			{
				Integer c = seq.get(0);
				for (int i = 1; i < seq.size(); i++)
				{
					seq.set(i - 1, seq.get(i));
				}
				seq.remove(seq.size() - 1);
				doMove(c);
			}

			if (seq.isEmpty())
			{
				mode = 0;
			}
		}
	}

	private void movePiece(int p, int y, int x)
	{
		//moves piece p to position y,x without disturbing previously placed pieces.
		int c = -1;
		int i = 0;
		int j = 0;
		for (; i < DIMENSION; i++)
		{
			for (j = 0; j < DIMENSION; j++)
			{
				c++;
				if (tiles[c] == p) break;
			}
			if (tiles[c] == p) break;
		}

		//Move piece to same column         //0=right, 1=down, 2=up, 3=left
		if (j < x && blankY == y) push(2);    // move blank down if it might disturb solved pieces.
		while (j > x)
		{
			//move piece to left
			//First move blank to left hand side of it
			if (blankY == i && blankX > j)
			{    //if blank on wrong side of piece
				if (i == DIMENSION - 1) push(1);
				else push(2); //then move it to other row
			}
			while (blankX >= j) push(0);    // move blank to column left of piece
			while (blankX < j - 1) push(3);
			while (blankY < i) push(2);     // move blank to same row as piece
			while (blankY > i) push(1);
			push(3);                    // move piece to left.
			j--;
		}
		while (j < x)
		{
			//move piece to right
			//First move blank to right hand side of it
			if (blankY == i && blankX < j)
			{
				if (i == DIMENSION - 1) push(1);
				else push(2);
			}
			while (blankX <= j) push(3);
			while (blankX > j + 1) push(0);
			while (blankY < i) push(2);
			while (blankY > i) push(1);
			push(0);
			j++;
		}

		//Move piece up to same row         //0=right, 1=down, 2=up, 3=left
		while (i > y)
		{
			if (y < i - 1)
			{
				while (blankY < i - 1) push(2);
				if (blankX == j) push(j == DIMENSION - 1 ? 0 : 3);
				while (blankY > i - 1) push(1);
				while (blankX < j) push(3);
				while (blankX > j) push(0);
				push(2);
			}
			else
			{
				if (j != DIMENSION - 1)
				{
					if (blankY == i) push(2);
					while (blankX < j + 1) push(3);
					while (blankX > j + 1) push(0);
					while (blankY > i - 1) push(1);
					while (blankY < i - 1) push(2);
					push(0, 2);
				}
				else
				{
					if (blankY < i && blankX == j)
					{
						while (blankY < i) push(2);
					}
					else
					{
						while (blankY > i + 1) push(1);
						while (blankY < i + 1) push(2);
						while (blankX < j) push(3);
						while (blankX > j) push(0);
						push(1, 1, 0, 2, 3, 2, 0, 1, 1, 3, 2);
					}
				}
			}
			i--;
		}
		while (i < y)
		{
			//move piece downwards
			//First move blank below tile
			if (blankX == j && blankY < i)
			{
				if (j == DIMENSION - 1) push(0);
				else push(3);
			}
			while (blankY > i + 1) push(1);
			while (blankY < i + 1) push(2);
			while (blankX < j) push(3);
			while (blankX > j) push(0);
			push(1);
			i++;
		}
	}

	private void push(int... moves)
	{
		for (int c : moves)
		{
			if (!seq.isEmpty() && seq.get(seq.size() - 1) + c == 3)
			{
				seq.remove(seq.size() - 1);
			}
			else
			{
				seq.add(c);
			}

			doMove(c);
		}
	}

	private void doMove(int m)
	{
		int d = blankX + blankY * DIMENSION;

		if (m == 0)
		{
			// RIGHT
			tiles[d] = tiles[d - 1];
			tiles[d - 1] = SIZE;
			blankX--;
		}
		else if (m == 1)
		{
			// DOWN
			tiles[d] = tiles[d - DIMENSION];
			tiles[d - DIMENSION] = SIZE;
			blankY--;
		}
		else if (m == 2)
		{
			// UP
			tiles[d] = tiles[d + DIMENSION];
			tiles[d + DIMENSION] = SIZE;
			blankY++;
		}
		else if (m == 3)
		{
			// LEFT
			tiles[d] = tiles[d + 1];
			tiles[d + 1] = SIZE;
			blankX++;
		}
	}

	public int[] getTiles()
	{
		return tiles;
	}

	public int getBlankX()
	{
		return blankX;
	}

	public int getBlankY()
	{
		return blankY;
	}
}
