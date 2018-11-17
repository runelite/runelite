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
import java.util.Arrays;
import java.util.List;
import net.runelite.api.Point;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.BLANK_TILE_VALUE;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.DIMENSION;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleState;
import net.runelite.client.plugins.puzzlesolver.solver.pathfinding.Pathfinder;

public class PuzzleStateMM extends PuzzleState
{
	private int[] pieces;
	private int emptyPiece = -1;

	private List<List<Integer>> validRowNumbers = new ArrayList<>();
	private List<List<Integer>> validColumnNumbers = new ArrayList<>();

	private List<Point> swaps = new ArrayList<>();

	public PuzzleStateMM(int[] pieces)
	{
		super(pieces);

		this.pieces = super.getPuzzle();
		this.emptyPiece = super.getEmptyPiece();

		//Add valid numbers for rows and columns
		validRowNumbers.add(Arrays.asList(0, 1, 2, 3, 4));
		validRowNumbers.add(Arrays.asList(6, 7, 8, 9));
		validRowNumbers.add(Arrays.asList(12, 13, 14));
		validRowNumbers.add(Arrays.asList(18, 19));
		validColumnNumbers.add(Arrays.asList(5, 10, 15, 20));
		validColumnNumbers.add(Arrays.asList(11, 16, 21));
		validColumnNumbers.add(Arrays.asList(17, 22));
		validColumnNumbers.add(Arrays.asList(23));
	}

	PuzzleState solvePathfinder(PuzzleState preSolved, Pathfinder pathfinder)
	{
		PuzzleSolver solver = new PuzzleSolver(pathfinder, new PuzzleState(preSolved));
		solver.run();

		if (solver.hasFailed())
		{
			return null;
		}

		return solver.getStep(solver.getStepCount() - 1);
	}

	void solveRow(int row)
	{
		validateInput(row);

		for (int i = row; i < DIMENSION; i++)
		{
			int valTarget = row * DIMENSION + i;

			int valCurrent = getPiece(i, row);

			if (valCurrent != valTarget)
			{
				Point locTarget = new Point(i, row);
				moveTowardsVal(valTarget, locTarget,  true);
			}
		}
	}

	void solveColumn(int column)
	{
		validateInput(column);

		for (int i = column + 1; i < DIMENSION; i++)
		{
			int valTarget = column + i * DIMENSION;

			int valCurrent = getPiece(column, i);

			if (valCurrent != valTarget)
			{
				Point locTarget = new Point(column, i);
				moveTowardsVal(valTarget, locTarget,  false);
			}
		}
	}

	private void validateInput(int val)
	{
		if (val < 0 || val > DIMENSION - 2)
		{
			throw new IllegalArgumentException(String.format("Input: %d outside of valid range", val));
		}
	}

	private void moveTowardsVal(int valTarget, Point locTarget, boolean rowMode)
	{
		//Not in place
		boolean reached = false;

		int row = locTarget.getY();
		int column = locTarget.getX();

		while (getPiece(locTarget) != valTarget)
		{
			//Find piece location
			Point locVal = findPiece(valTarget);
			Point locBlank = findPiece(BLANK_TILE_VALUE);

			if (!reached)
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
						if (locBlank.getY() - 1 == row &&
							validRowNumbers.get(row).contains(getPiece(locBlank.getX(), locBlank.getY() - 1)) &&
							getPiece(locBlank.getX(), locBlank.getY() - 1) < valTarget &&
							distY <= -1)
						{
							//Move forward
							Point locSwap = new Point(locBlank.getX() + 1, locBlank.getY());
							swap(locBlank, locSwap);
							continue;
						}

						//Move upwards or downwards
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
						if (locBlank.getX() - 1 == column &&
							validColumnNumbers.get(column).contains(getPiece(locBlank.getX() - 1, locBlank.getY())) &&
							getPiece(locBlank.getX() - 1, locBlank.getY()) < valTarget &&
							distX <= -1)
						{
							//Move down
							Point locSwap = new Point(locBlank.getX(), locBlank.getY() + 1);
							swap(locBlank, locSwap);
							continue;
						}

						//Move left or right
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
			else
			{
				//Swap towards locTarget
				if (rowMode)
				{
					alignTargetX(valTarget, locTarget);
					swapUpRow(valTarget, locTarget);
				}
				else
				{
					alignTargetY(valTarget, locTarget);
					swapLeftColumn(valTarget, locTarget);
				}
			}
		}
	}

	private void alignTargetX(int valTarget, Point locTarget)
	{
		Point locVal = findPiece(valTarget);
		Point locBlank;

		//Check if same column
		if (locVal.getX() == locTarget.getX())
		{
			return;
		}

		//1 = right, -1 = left
		int direction = Integer.signum(locTarget.getX() - locVal.getX());

		while (locVal.getX() != locTarget.getX())
		{
			locVal = findPiece(valTarget);
			locBlank = findPiece(BLANK_TILE_VALUE);

			//Check if aligned
			if (locTarget.getX() - locVal.getX() == 0)
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
							Point loc1 = new Point(locVal.getX() + 1, locVal.getY() - 1);
							Point loc2 = new Point(locVal.getX(), locVal.getY() - 1);
							Point loc3 = new Point(locVal.getX() - 1, locVal.getY() - 1);
							Point loc4 = new Point(locVal.getX() - 1, locVal.getY());

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
						}
						else
						{
							//Space below, use lower rotate
							Point loc1 = new Point(locVal.getX() + 1, locVal.getY() + 1);
							Point loc2 = new Point(locVal.getX(), locVal.getY() + 1);
							Point loc3 = new Point(locVal.getX() - 1, locVal.getY() + 1);
							Point loc4 = new Point(locVal.getX() - 1, locVal.getY());

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
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
							Point loc1 = new Point(locVal.getX() - 1, locVal.getY() - 1);
							Point loc2 = new Point(locVal.getX(), locVal.getY() - 1);
							Point loc3 = new Point(locVal.getX() + 1, locVal.getY() - 1);
							Point loc4 = new Point(locVal.getX() + 1, locVal.getY());

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
						}
						else
						{
							//Space below, use lower rotate
							Point loc1 = new Point(locVal.getX() - 1, locVal.getY() + 1);
							Point loc2 = new Point(locVal.getX(), locVal.getY() + 1);
							Point loc3 = new Point(locVal.getX() + 1, locVal.getY() + 1);
							Point loc4 = new Point(locVal.getX() + 1, locVal.getY());

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
						}
					}
				}
			}
		}
	}

	//Swaps up until inserted into the correct place
	private void swapUpRow(int valTarget, Point locTarget)
	{
		Point locVal = findPiece(valTarget);
		Point locBlank = findPiece(BLANK_TILE_VALUE);

		//Check if already placed correct
		if (locVal.equals(locTarget))
		{
			return;
		}

		//Check if simple swap is enough
		if (locBlank.equals(locTarget) && locVal.getY() - 1 == locTarget.getY())
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
			if (locVal.equals(locTarget))
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
					if (locTarget.getX() == DIMENSION - 1)
					{
						Point loc1 = new Point(locVal.getX() - 1, locVal.getY() - 1);
						Point loc2 = new Point(locVal.getX(), locVal.getY() - 1);
						Point loc3 = new Point(locVal.getX() - 1, locVal.getY());
						Point loc4 = new Point(locVal.getX() - 1, locVal.getY() + 1);

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

						return;
					}

					Point loc1 = new Point(locVal.getX() + 1, locVal.getY() + 1);
					Point loc2 = new Point(locVal.getX() + 1, locVal.getY());
					Point loc3 = new Point(locVal.getX() + 1, locVal.getY() - 1);
					Point loc4 = new Point(locVal.getX(), locVal.getY() - 1);

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, loc3);
					swap(loc3, loc4);
					swap(loc4, locVal);
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
					Point loc1 = new Point(locBlank.getX(), locBlank.getY() - 1);
					Point loc2 = new Point(loc1.getX() - 1, loc1.getY());

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, locVal);
				}
				else if (diff == -1)
				{
					//Left

					//Don't remove correct pieces from row
					if (locVal.getY() - 1 == locTarget.getY())
					{
						//Swap blank to below and continue
						Point loc1 = new Point(locBlank.getX(), locBlank.getY() + 1);
						Point loc2 = new Point(loc1.getX() + 1, loc1.getY());

						swap(locBlank, loc1);
						swap(loc1, loc2);

						continue;
					}

					Point loc1 = new Point(locBlank.getX(), locBlank.getY() - 1);
					Point loc2 = new Point(loc1.getX() + 1, loc1.getY());

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, locVal);
				}
			}
		}
	}


	private void alignTargetY(int valTarget, Point locTarget)
	{
		Point locVal = findPiece(valTarget);
		Point locBlank;

		//Check if same row
		if (locVal.getY() == locTarget.getY())
		{
			return;
		}

		//1 = down, -1 = up
		int direction = Integer.signum(locTarget.getY() - locVal.getY());

		while (locVal.getY() != locTarget.getY())
		{
			locVal = findPiece(valTarget);
			locBlank = findPiece(BLANK_TILE_VALUE);

			//Check if aligned
			if (locTarget.getY() - locVal.getY() == 0)
			{
				break;
			}

			if (locVal.getX() == locBlank.getX())
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
							Point loc1 = new Point(locVal.getX() - 1, locVal.getY() + 1);
							Point loc2 = new Point(locVal.getX() - 1, locVal.getY());
							Point loc3 = new Point(locVal.getX() - 1, locVal.getY() - 1);
							Point loc4 = new Point(locVal.getX(), locVal.getY() - 1);

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
						}
						else
						{
							//Space to the right, use right rotate
							Point loc1 = new Point(locVal.getX() + 1, locVal.getY() + 1);
							Point loc2 = new Point(locVal.getX() + 1, locVal.getY());
							Point loc3 = new Point(locVal.getX() + 1, locVal.getY() - 1);
							Point loc4 = new Point(locVal.getX(), locVal.getY() - 1);

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
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
							Point loc1 = new Point(locVal.getX() - 1, locVal.getY() - 1);
							Point loc2 = new Point(locVal.getX() - 1, locVal.getY());
							Point loc3 = new Point(locVal.getX() - 1, locVal.getY() + 1);
							Point loc4 = new Point(locVal.getX(), locVal.getY() + 1);

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
						}
						else
						{
							//Space to the right, use right rotate
							Point loc1 = new Point(locVal.getX() + 1, locVal.getY() - 1);
							Point loc2 = new Point(locVal.getX() + 1, locVal.getY());
							Point loc3 = new Point(locVal.getX() + 1, locVal.getY() + 1);
							Point loc4 = new Point(locVal.getX(), locVal.getY() + 1);

							swap(locBlank, loc1);
							swap(loc1, loc2);
							swap(loc2, loc3);
							swap(loc3, loc4);
							swap(loc4, locVal);
						}
					}
				}
			}
			else if (locVal.getY() == locBlank.getY())
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
		}
	}

	//Swaps left until inserted into the correct place
	private void swapLeftColumn(int valTarget, Point locTarget)
	{
		Point locVal = findPiece(valTarget);
		Point locBlank = findPiece(BLANK_TILE_VALUE);

		//Check if already placed correct
		if (locVal.equals(locTarget))
		{
			return;
		}

		//Check if simple swap is enough
		if (locBlank.equals(locTarget) && locVal.getX() - 1 == locTarget.getX())
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
			if (locVal.equals(locTarget))
			{
				return;
			}

			if (locVal.getX() == locBlank.getX())
			{
				int diff = locBlank.getY() - locVal.getY();
				if (diff == 1)
				{
					//Below
					Point loc1 = new Point(locBlank.getX() - 1, locBlank.getY());
					Point loc2 = new Point(loc1.getX(), loc1.getY() - 1);

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, locVal);
				}
				else if (diff == -1)
				{
					//Above

					//Don't remove correct pices from row
					if (locVal.getX() - 1 == locTarget.getX())
					{
						//Swap blank to right and continue
						Point loc1 = new Point(locBlank.getX() + 1, locBlank.getY());
						Point loc2 = new Point(loc1.getX(), loc1.getY() + 1);

						swap(locBlank, loc1);
						swap(loc1, loc2);

						continue;
					}

					Point loc1 = new Point(locBlank.getX() - 1, locBlank.getY());
					Point loc2 = new Point(loc1.getX(), loc1.getY() + 1);

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, locVal);
				}
			}
			else if (locVal.getY() == locBlank.getY())
			{
				int diff = locBlank.getX() - locVal.getX();
				if (diff == 1)
				{
					//Right

					//Last piece
					if (locTarget.getY() == DIMENSION - 1)
					{
						Point loc1 = new Point(locVal.getX() - 1, locVal.getY() - 1);
						Point loc2 = new Point(locVal.getX() - 1, locVal.getY());
						Point loc3 = new Point(locVal.getX(), locVal.getY() - 1);
						Point loc4 = new Point(locVal.getX() + 1, locVal.getY() - 1);

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

						return;
					}

					Point loc1 = new Point(locVal.getX() + 1, locVal.getY() + 1);
					Point loc2 = new Point(locVal.getX(), locVal.getY() + 1);
					Point loc3 = new Point(locVal.getX() - 1, locVal.getY() + 1);
					Point loc4 = new Point(locVal.getX() - 1, locVal.getY());

					swap(locBlank, loc1);
					swap(loc1, loc2);
					swap(loc2, loc3);
					swap(loc3, loc4);
					swap(loc4, locVal);
				}
				else if (diff == -1)
				{
					//Left
					swap(locBlank, locVal);
				}
			}
		}
	}

	private boolean checkSwap(Point loc1, Point loc2)
	{
		int absX = Math.abs(loc1.getX() - loc2.getX());
		int absY = Math.abs(loc1.getY() - loc2.getY());

		if (getPiece(loc1) != BLANK_TILE_VALUE && getPiece(loc2) != BLANK_TILE_VALUE)
		{
			return false;
		}

		if (loc1.getX() == loc2.getX() && absY == 1)
		{
			return true;
		}

		if (loc1.getY() == loc2.getY() && absX == 1)
		{
			return true;
		}

		return false;
	}

	private void swap(Point loc1, Point loc2)
	{
		int val1 = getPiece(loc1);
		int val2 = getPiece(loc2);

		if (!checkSwap(loc1, loc2))
		{
			throw new IllegalStateException(String.format("Invalid swap: %1$s, %2$s", loc1.toString(), loc2.toString()));
		}

		this.emptyPiece = val1 != BLANK_TILE_VALUE ? loc1.getY() * DIMENSION + loc1.getX() : loc2.getY() * DIMENSION + loc2.getX();

		swaps.add(loc1);
		swaps.add(loc2);

		this.pieces[loc1.getY() * DIMENSION + loc1.getX()] = val2;
		this.pieces[loc2.getY() * DIMENSION + loc2.getX()] = val1;
	}

	PuzzleState stateFromSwap(Point swap1, Point swap2)
	{
			swap(swap1, swap2);

			return new PuzzleState(this);
	}

	List<Point> getSwaps()
	{
		return new ArrayList<>(swaps);
	}

	private Point findPiece(int val)
	{
		Point loc = null;

		for (int x = 0; x < DIMENSION; x++)
		{
			for (int y = 0; y < DIMENSION; y++)
			{
				if (getPiece(x, y) == val)
				{
					return new Point(x, y);
				}
			}
		}

		return loc;
	}

	public int getEmptyPiece()
	{
		return emptyPiece;
	}

	private int getPiece(Point p)
	{
		return pieces[p.getY() * DIMENSION + p.getX()];
	}
}
