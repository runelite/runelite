package net.runelite.client.plugins.runedoku;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.inject.Inject;
import api.Client;
import api.widgets.Widget;
import api.widgets.WidgetItem;

class RunedokuUtil
{

	private final RunedokuConfig config;

	@Inject
	RunedokuUtil(final RunedokuConfig config)
	{
		this.config = config;
	}

	Color sudokuPieceToColor(int i)
	{
		switch (i)
		{
			case 1:
				return config.mindRuneColor();
			case 2:
				return config.fireRuneColor();
			case 3:
				return config.bodyRuneColor();
			case 4:
				return config.airRuneColor();
			case 5:
				return config.deathRuneColor();
			case 6:
				return config.waterRuneColor();
			case 7:
				return config.chaosRuneColor();
			case 8:
				return config.earthRuneColor();
			case 9:
				return config.lawRuneColor();
			default:
				return Color.RED;
		}
	}

	Color referenceColors(int i)
	{
		switch (i)
		{
			case 121: //earth
				return config.earthRuneColor();
			case 122: //water
				return config.waterRuneColor();
			case 123: //air
				return config.airRuneColor();
			case 124: //mind
				return config.mindRuneColor();
			case 125: //fire
				return config.fireRuneColor();
			case 126: //body
				return config.bodyRuneColor();
			case 127: //death
				return config.deathRuneColor();
			case 128: //chaos
				return config.chaosRuneColor();
			case 129: //law
				return config.lawRuneColor();
			default:
				return Color.RED;
		}
	}

	/**
	 * Make the 2d array into an arraylist
	 *
	 * @param board
	 * @return
	 */
	ArrayList<Integer> makeSimple(int[][] board)
	{
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 9; i++)
		{
			for (int ii = 0; ii < 9; ii++)
			{
				list.add(board[i][ii]);
			}
		}
		return list;
	}

	/**
	 * utility method
	 *
	 * @param rect
	 * @return
	 */
	public static Polygon rectangleToPolygon(Rectangle rect)
	{
		int[] xpoints = {rect.x, rect.x + rect.width, rect.x + rect.width, rect.x};
		int[] ypoints = {rect.y, rect.y, rect.y + rect.height, rect.y + rect.height};
		return new Polygon(xpoints, ypoints, 4);
	}

	/**
	 * Pulls data from what's on the Runedoku interface and creates a 2dimensional array for it
	 *
	 * @param client
	 * @return sudoku table that the client currently sees in a 2d array
	 * @author gazivodag
	 */
	int[][] createTable(Client client)
	{
		int[][] myArr = new int[9][9];
		Widget sudokuScreen = client.getWidget(288, 131);
		for (int i = 0; i < 9; i++)
		{
			for (int ii = 0; ii < 9; ii++)
			{
				WidgetItem item;
				int myIndex;
				if (i > 0)
				{
					myIndex = ((i * 10) + ii) - i;
				}
				else
				{
					myIndex = ii;
				}
				if (myIndex == 81)
				{
					break;
				}
				item = sudokuScreen.getWidgetItem(myIndex);
				if (item != null)
				{
					myArr[i][ii] = RunedokuPiece.getById(item.getId()).getPieceForSudoku();
				}
				else
				{
					myArr[i][ii] = 0;
				}
			}
		}
		return myArr;
	}

}
