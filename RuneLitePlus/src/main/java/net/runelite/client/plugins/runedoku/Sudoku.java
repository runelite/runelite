package net.runelite.client.plugins.runedoku;

/**
 * Credits to whoever wrote this sudoku class.
 *
 * @author ?
 */
public class Sudoku
{

	private int[][] board;
	public static final int EMPTY = 0;
	public static final int SIZE = 9;

	Sudoku(int[][] board)
	{
		this.board = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				this.board[i][j] = board[i][j];
			}
		}
	}

	private boolean isInRow(int row, int number)
	{
		for (int i = 0; i < SIZE; i++)
		{
			if (board[row][i] == number)
			{
				return true;
			}
		}

		return false;
	}

	private boolean isInCol(int col, int number)
	{
		for (int i = 0; i < SIZE; i++)
		{
			if (board[i][col] == number)
			{
				return true;
			}
		}

		return false;
	}

	private boolean isInBox(int row, int col, int number)
	{
		int r = row - row % 3;
		int c = col - col % 3;

		for (int i = r; i < r + 3; i++)
		{
			for (int j = c; j < c + 3; j++)
			{
				if (board[i][j] == number)
				{
					return true;
				}
			}
		}

		return false;
	}

	private boolean isOk(int row, int col, int number)
	{
		return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
	}

	public boolean solve()
	{
		for (int row = 0; row < SIZE; row++)
		{
			for (int col = 0; col < SIZE; col++)
			{
				if (board[row][col] == EMPTY)
				{
					for (int number = 1; number <= SIZE; number++)
					{
						if (isOk(row, col, number))
						{
							board[row][col] = number;
							if (solve())
							{
								return true;
							}
							else
							{
								board[row][col] = EMPTY;
							}
						}
					}
					return false;
				}
			}
		}

		return true;
	}

	public void display()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				System.out.print(" " + board[i][j]);
			}
		}
	}

	public int[][] getBoard()
	{
		return board;
	}

}
