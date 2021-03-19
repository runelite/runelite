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
package net.runelite.client.plugins.puzzlesolver.solver.pathfinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.Point;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.BLANK_TILE_VALUE;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.DIMENSION;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleState;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleSwapPattern;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSwapPattern.*;
import net.runelite.client.plugins.puzzlesolver.solver.heuristics.Heuristic;

public class IDAStarMM extends IDAStar
{
	private PuzzleState currentState;
	private final List<PuzzleState> stateList = new ArrayList<>();
	private final List<List<Integer>> validRowNumbers = new ArrayList<>();
	private final List<List<Integer>> validColumnNumbers = new ArrayList<>();

	public IDAStarMM(Heuristic heuristic)
	{
		super(heuristic);

		//Add valid numbers for rows and columns
		validRowNumbers.add(Arrays.asList(0, 1, 2, 3, 4));
		validRowNumbers.add(Arrays.asList(6, 7, 8, 9));
		validColumnNumbers.add(Arrays.asList(5, 10, 15, 20));
	}

	@Override
	public List<PuzzleState> computePath(PuzzleState root)
	{
		currentState = root;
		stateList.add(root);

		List<PuzzleState> path = new ArrayList<>();

		//Reduce to 4x5
		solveRow(0);

		//Reduce to 4x4
		solveColumn();

		//Reduce to 3x4
		solveRow(1);

		//Remove last state
		stateList.remove(stateList.size() - 1);

		//Pathfinder for 4x4
		path.addAll(super.computePath(currentState));

		path.addAll(0, stateList);

		return path;
	}

	private void solveRow(int row)
	{
		for (int i = row; i < DIMENSION; i++)
		{
			int valTarget = row * DIMENSION + i;

			int valCurrent = currentState.getPiece(i, row);

			if (valCurrent != valTarget)
			{
				moveTowardsVal(valTarget, i, row, true);
			}
		}
	}

	private void solveColumn()
	{
		int column = 0;

		for (int i = column + 1; i < DIMENSION; i++)
		{
			int valTarget = column + i * DIMENSION;

			int valCurrent = currentState.getPiece(column, i);

			if (valCurrent != valTarget)
			{
				moveTowardsVal(valTarget, column, i, false);
			}
		}
	}

	private void moveTowardsVal(int valTarget, int x, int y, boolean rowMode)
	{
		//Not in place
		boolean reached = false;

		while (currentState.getPiece(x, y) != valTarget)
		{
			//Find piece location
			Point locVal = findPiece(valTarget);
			Point locBlank = findPiece(BLANK_TILE_VALUE);

			if (reached)
			{
				//Swap towards locTarget
				if (rowMode)
				{
					alignTargetX(valTarget, x, y);
					swapUpRow(valTarget, x, y);
				}
				else
				{
					alignTargetY(valTarget, x, y);
					swapLeftColumn(valTarget, x, y);
				}
			}
			else
			{
				int distX = locVal.getX() - locBlank.getX();
				int distY = locVal.getY() - locBlank.getY();
				int distAbsX = Math.abs(distX);
				int distAbsY = Math.abs(distY);

				if (distX == 0)
				{
					//Same column
					if (distAbsY == 1)
					{
						//Next to
						reached = true;
					}
					else
					{
						//More than 2 away, move towards on Y-axis
						if (distY >= 2)
						{
							Point locSwap = new Point(locBlank.getX(), locBlank.getY() + 1);
							swap(locBlank, locSwap);
						}
						else if (distY <= -2)
						{
							Point locSwap = new Point(locBlank.getX(), locBlank.getY() - 1);
							swap(locBlank, locSwap);
						}
					}
				}
				else if (distY == 0)
				{
					//Same row
					if (distAbsX == 1)
					{
						//Next to
						reached = true;
					}
					else
					{
						//More than 2 away, move towards on X-axis
						if (distX >= 2)
						{
							Point locSwap = new Point(locBlank.getX() + 1, locBlank.getY());
							swap(locBlank, locSwap);
						}
						else if (distX <= -2)
						{
							Point locSwap = new Point(locBlank.getX() - 1, locBlank.getY());
							swap(locBlank, locSwap);
						}
					}
				}
				else
				{
					//Different row and column
					if (rowMode)
					{
						//Check if already correct above
						if (locBlank.getY() - 1 == y
							&& validRowNumbers.get(y).contains(currentState.getPiece(locBlank.getX(), locBlank.getY() - 1))
							&& currentState.getPiece(locBlank.getX(), locBlank.getY() - 1) < valTarget
							&& distY <= -1)
						{
							//Move forward
							Point locSwap = new Point(locBlank.getX() + 1, locBlank.getY());
							swap(locBlank, locSwap);
							continue;
						}

						//Move downwards or upwards
						if (distY >= 1)
						{
							Point locSwap = new Point(locBlank.getX(), locBlank.getY() + 1);
							swap(locBlank, locSwap);
						}
						else if (distY <= -1)
						{
							Point locSwap = new Point(locBlank.getX(), locBlank.getY() - 1);
							swap(locBlank, locSwap);
						}
					}
					else
					{
						//Check if already correct to the left
						if (locBlank.getX() - 1 == x
							&& validColumnNumbers.get(x).contains(currentState.getPiece(locBlank.getX() - 1, locBlank.getY()))
							&& currentState.getPiece(locBlank.getX() - 1, locBlank.getY()) < valTarget
							&& distX <= -1)
						{
							//Move down
							Point locSwap = new Point(locBlank.getX(), locBlank.getY() + 1);
							swap(locBlank, locSwap);
							continue;
						}

						//Move right or left
						if (distX >= 1)
						{
							Point locSwap = new Point(locBlank.getX() + 1, locBlank.getY());
							swap(locBlank, locSwap);
						}
						else if (distX <= -1)
						{
							Point locSwap = new Point(locBlank.getX() - 1, locBlank.getY());
							swap(locBlank, locSwap);
						}
					}
				}
			}
		}
	}

	private void alignTargetX(int valTarget, int x, int y)
	{
		Point locVal = findPiece(valTarget);

		//Check if same column
		if (locVal.getX() == x)
		{
			return;
		}

		//1 = right, -1 = left
		int direction = Integer.signum(x - locVal.getX());

		while (locVal.getX() != x)
		{
			locVal = findPiece(valTarget);
			Point locBlank = findPiece(BLANK_TILE_VALUE);

			//Check if aligned
			if (x - locVal.getX() == 0)
			{
				break;
			}

			if (locVal.getX() == locBlank.getX())
			{
				int diff = locBlank.getY() - locVal.getY();
				if (diff == 1)
				{
					//Below
					Point loc1 = new Point(locBlank.getX() + direction, locBlank.getY());
					Point loc2 = new Point(loc1.getX(), loc1.getY() - 1);

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, locVal);
				}
				else if (diff == -1)
				{
					//Above
					swap(locBlank, locVal);
				}
			}
			else if (locVal.getY() == locBlank.getY())
			{
				int diff = locBlank.getX() - locVal.getX();
				if (diff == 1)
				{
					//Right
					if (direction == 1)
					{
						swap(locVal, locBlank);
					}
					else if (direction == -1)
					{
						//Check space
						if (locVal.getY() == DIMENSION - 1)
						{
							//No space below, use upper rotate
							performSwapPattern(locBlank, locVal, ROTATE_LEFT_UP);
						}
						else
						{
							//Space below, use lower rotate
							performSwapPattern(locBlank, locVal, ROTATE_LEFT_DOWN);
						}
					}
				}
				else if (diff == -1)
				{
					//Left
					if (direction == -1)
					{
						swap(locVal, locBlank);
					}
					else if (direction == 1)
					{
						//Check space
						if (locVal.getY() == DIMENSION - 1)
						{
							//No space below, use upper rotate
							performSwapPattern(locBlank, locVal, ROTATE_RIGHT_UP);
						}
						else
						{
							//Space below, use lower rotate
							performSwapPattern(locBlank, locVal, ROTATE_RIGHT_DOWN);
						}
					}
				}
			}
		}
	}

	//Swaps up until inserted into the correct place
	private void swapUpRow(int valTarget, int x, int y)
	{
		Point locVal = findPiece(valTarget);
		Point locBlank = findPiece(BLANK_TILE_VALUE);

		//Check if already placed correct
		if (locVal.getX() == x && locVal.getY() == y)
		{
			return;
		}

		//Check if simple swap is enough
		if (locBlank.getX() == x && locBlank.getY() == y && locVal.getY() - 1 == y)
		{
			swap(locBlank, locVal);
			return;
		}

		//Move up
		while (true)
		{
			locVal = findPiece(valTarget);
			locBlank = findPiece(BLANK_TILE_VALUE);

			//Check if already placed correct
			if (locVal.getX() == x && locVal.getY() == y)
			{
				return;
			}

			if (locVal.getX() == locBlank.getX())
			{
				int diff = locBlank.getY() - locVal.getY();
				if (diff == 1)
				{
					//Below

					//Last piece
					if (x == DIMENSION - 1)
					{
						performSwapPattern(locBlank, locVal, LAST_PIECE_ROW);
						return;
					}

					performSwapPattern(locBlank, locVal, ROTATE_UP_RIGHT);
				}
				else if (diff == -1)
				{
					//Above
					swap(locBlank, locVal);
				}
			}
			else if (locVal.getY() == locBlank.getY())
			{
				int diff = locBlank.getX() - locVal.getX();
				if (diff == 1)
				{
					//Right
					performSwapPattern(locBlank, locVal, SHUFFLE_UP_RIGHT);
				}
				else if (diff == -1)
				{
					//Left

					//Don't remove correct pieces from row
					if (locVal.getY() - 1 == y)
					{
						//Swap blank to below and continue
						Point loc1 = new Point(locBlank.getX(), locBlank.getY() + 1);
						Point loc2 = new Point(loc1.getX() + 1, loc1.getY());

						swap(locBlank, loc1);
						swap(loc1, loc2);

						continue;
					}

					performSwapPattern(locBlank, locVal, SHUFFLE_UP_LEFT);
				}
			}
		}
	}

	private void alignTargetY(int valTarget, int x, int y)
	{
		Point locVal = findPiece(valTarget);

		//Check if same row
		if (locVal.getY() == y)
		{
			return;
		}

		//1 = down, -1 = up
		int direction = Integer.signum(y - locVal.getY());

		while (locVal.getY() != y)
		{
			locVal = findPiece(valTarget);
			Point locBlank = findPiece(BLANK_TILE_VALUE);

			//Check if aligned
			if (y - locVal.getY() == 0)
			{
				break;
			}

			if (locVal.getY() == locBlank.getY())
			{
				int diff = locBlank.getX() - locVal.getX();
				if (diff == 1)
				{
					//Right
					Point loc1 = new Point(locBlank.getX(), locBlank.getY() + direction);
					Point loc2 = new Point(loc1.getX() - 1, loc1.getY());

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, locVal);
				}
				else if (diff == -1)
				{
					//Left
					swap(locBlank, locVal);
				}
			}
			else if (locVal.getX() == locBlank.getX())
			{
				int diff = locBlank.getY() - locVal.getY();
				if (diff == 1)
				{
					//Below
					if (direction == 1)
					{
						swap(locVal, locBlank);
					}
					else if (direction == -1)
					{
						//Check space
						if (locVal.getX() == DIMENSION - 1)
						{
							//No space to the right, use left rotate
							performSwapPattern(locBlank, locVal, ROTATE_UP_LEFT);
						}
						else
						{
							//Space to the right, use right rotate
							performSwapPattern(locBlank, locVal, ROTATE_UP_RIGHT);
						}
					}
				}
				else if (diff == -1)
				{
					//Above
					if (direction == -1)
					{
						swap(locVal, locBlank);
					}
					else if (direction == 1)
					{
						//Check space
						if (locVal.getX() == DIMENSION - 1)
						{
							//No space to the right, use left rotate
							performSwapPattern(locBlank, locVal, ROTATE_DOWN_LEFT);
						}
						else
						{
							//Space to the right, use right rotate
							performSwapPattern(locBlank, locVal, ROTATE_DOWN_RIGHT);
						}
					}
				}
			}
		}
	}

	//Swaps left until inserted into the correct place
	private void swapLeftColumn(int valTarget, int x, int y)
	{
		Point locVal = findPiece(valTarget);
		Point locBlank = findPiece(BLANK_TILE_VALUE);

		//Check if already placed correct
		if (locVal.getX() == x && locVal.getY() == y)
		{
			return;
		}

		//Check if simple swap is enough
		if (locBlank.getX() == x && locBlank.getY() == y && locVal.getX() - 1 == x)
		{
			swap(locBlank, locVal);
			return;
		}

		//Move left
		while (true)
		{
			locVal = findPiece(valTarget);
			locBlank = findPiece(BLANK_TILE_VALUE);

			//Check if already placed correct
			if (locVal.getX() == x && locVal.getY() == y)
			{
				return;
			}

			if (locVal.getX() == locBlank.getX())
			{
				int diff = locBlank.getY() - locVal.getY();
				if (diff == 1)
				{
					//Below
					performSwapPattern(locBlank, locVal, SHUFFLE_UP_BELOW);
				}
				else if (diff == -1)
				{
					//Above

					//Don't remove correct pices from row
					if (locVal.getX() - 1 == x)
					{
						//Swap blank to right and continue
						Point loc1 = new Point(locBlank.getX() + 1, locBlank.getY());
						Point loc2 = new Point(loc1.getX(), loc1.getY() + 1);

						swap(locBlank, loc1);
						swap(loc1, loc2);

						continue;
					}

					performSwapPattern(locBlank, locVal, SHUFFLE_UP_ABOVE);
				}
			}
			else if (locVal.getY() == locBlank.getY())
			{
				int diff = locBlank.getX() - locVal.getX();
				if (diff == 1)
				{
					//Right

					//Last piece
					if (y == DIMENSION - 1)
					{
						performSwapPattern(locBlank, locVal, LAST_PIECE_COLUMN);
						return;
					}

					performSwapPattern(locBlank, locVal, ROTATE_LEFT_DOWN);
				}
				else if (diff == -1)
				{
					//Left
					swap(locBlank, locVal);
				}
			}
		}
	}

	private void swap(Point p1, Point p2)
	{
		PuzzleState newState = currentState.swap(p1.getX(), p1.getY(), p2.getX(), p2.getY());

		currentState = newState;
		stateList.add(newState);
	}

	private Point findPiece(int val)
	{
		for (int x = 0; x < DIMENSION; x++)
		{
			for (int y = 0; y < DIMENSION; y++)
			{
				if (currentState.getPiece(x, y) == val)
				{
					return new Point(x, y);
				}
			}
		}
		// This should never happen
		throw new IllegalStateException("Piece wasn't found!");
	}

	/**
	 * Assumes locBlank is first point for swap and locVal is last point for swap
	 *
	 * swap(locBlank, loc1);
	 * swap(loc1, loc2);
	 * swap(loc2, locVal);
	 */
	private void performSwapPattern(Point locBlank, Point locVal, PuzzleSwapPattern pattern)
	{
		int[] offsets;
		switch (pattern)
		{
			case ROTATE_LEFT_UP:
			case ROTATE_RIGHT_UP:
			case ROTATE_RIGHT_DOWN:
			case ROTATE_LEFT_DOWN:
				offsets = ROTATE_LEFT_UP.getPoints();
				break;
			case ROTATE_UP_LEFT:
			case ROTATE_UP_RIGHT:
			case ROTATE_DOWN_LEFT:
			case ROTATE_DOWN_RIGHT:
				offsets = ROTATE_UP_LEFT.getPoints();
				break;
			default:
				offsets = pattern.getPoints();
		}

		if (offsets == null || offsets.length % 2 == 1)
		{
			// This should never happen
			throw new IllegalStateException("Unexpected points given in pattern!");
		}

		int modX = pattern.getModX();
		int modY = pattern.getModY();

		ArrayList<Point> points = new ArrayList<>();

		for (int i = 0; i < offsets.length; i += 2)
		{
			int x = locVal.getX() + modX * offsets[i];
			int y = locVal.getY() + modY * offsets[i + 1];

			points.add(new Point(x, y));
		}

		// Add locVal as last point
		points.add(locVal);

		if (pattern != LAST_PIECE_ROW && pattern != LAST_PIECE_COLUMN)
		{
			Point start = locBlank;
			for (Point p : points)
			{
				swap(start, p);
				start = p;
			}
		}
		else
		{
			Point loc1 = points.get(0);
			Point loc2 = points.get(1);
			Point loc3 = points.get(2);
			Point loc4 = points.get(3);

			swap(locBlank, locVal);
			swap(locVal, loc3);
			swap(loc3, loc1);
			swap(loc1, loc2);
			swap(loc2, locVal);
			swap(locVal, loc3);
			swap(loc3, loc1);
			swap(loc1, loc2);
			swap(loc2, locVal);
			swap(locVal, locBlank);
			swap(locBlank, loc4);
			swap(loc4, loc3);
			swap(loc3, loc1);
			swap(loc1, loc2);
			swap(loc2, locVal);
		}
	}
}
