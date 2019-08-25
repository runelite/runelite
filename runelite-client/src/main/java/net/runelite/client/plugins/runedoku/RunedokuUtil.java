/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.runedoku;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;

class RunedokuUtil
{

	private final RunedokuPlugin plugin;

	@Inject
	RunedokuUtil(final RunedokuPlugin plugin)
	{
		this.plugin = plugin;
	}

	Color sudokuPieceToColor(int i)
	{
		switch (i)
		{
			case 1:
				return plugin.getMindRuneColor();
			case 2:
				return plugin.getFireRuneColor();
			case 3:
				return plugin.getBodyRuneColor();
			case 4:
				return plugin.getAirRuneColor();
			case 5:
				return plugin.getDeathRuneColor();
			case 6:
				return plugin.getWaterRuneColor();
			case 7:
				return plugin.getChaosRuneColor();
			case 8:
				return plugin.getEarthRuneColor();
			case 9:
				return plugin.getLawRuneColor();
			default:
				return Color.RED;
		}
	}

	Color referenceColors(int i)
	{
		switch (i)
		{
			case 121: //earth
				return plugin.getEarthRuneColor();
			case 122: //water
				return plugin.getWaterRuneColor();
			case 123: //air
				return plugin.getAirRuneColor();
			case 124: //mind
				return plugin.getMindRuneColor();
			case 125: //fire
				return plugin.getFireRuneColor();
			case 126: //body
				return plugin.getBodyRuneColor();
			case 127: //death
				return plugin.getDeathRuneColor();
			case 128: //chaos
				return plugin.getChaosRuneColor();
			case 129: //plugin
				return plugin.getLawRuneColor();
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
	List<Integer> makeSimple(int[][] board)
	{
		List<Integer> list = new ArrayList<>();
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
	static Polygon rectangleToPolygon(Rectangle rect)
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
					if (item.getId() != -1)
					{
						myArr[i][ii] = Objects.requireNonNull(RunedokuPiece.getById(item.getId())).getPieceForSudoku();
					}
					else
					{
						myArr[i][ii] = 0;
					}
				}
				else
				{
					myArr[i][ii] = 0;
				}
			}
		}
		return myArr;
	}

	/**
	 * @param client
	 * @return
	 */
	int getSelectedPiece(Client client)
	{
		for (int i = 91; i < 100; i++)
		{
			Widget selectedPieceWidget = client.getWidget(288, i);
			if (!selectedPieceWidget.isHidden())
			{
				switch (i)
				{
					case 91:
						return 8;
					case 92:
						return 6;
					case 93:
						return 4;
					case 94:
						return 2;
					case 95:
						return 1;
					case 96:
						return 3;
					case 97:
						return 5;
					case 98:
						return 7;
					case 99:
						return 9;
				}
			}
		}
		return -1;
	}

}
