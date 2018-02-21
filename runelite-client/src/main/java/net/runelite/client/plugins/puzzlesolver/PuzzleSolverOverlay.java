/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>, Henke <https://github.com/henke96>
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

import java.awt.*;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.client.plugins.puzzlesolver.PuzzleSolver.BLANK_TILE_VALUE;

import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.ui.overlay.components.TextComponent;

@Slf4j
public class PuzzleSolverOverlay extends Overlay
{
	private static final int MOVES_LEFT_WIDTH = 100;
	private static final int MOVES_LEFT_OFFSET_Y = 50;
	private static final int MOVES_LEFT_TOP_BORDER = 2;
	private static final int MOVES_LEFT_BOTTOM_BORDER = 2;

	private static final int PUZZLE_TILE_SIZE = 39;

	private final Client client;
	private final PuzzleSolverConfig config;

	private PuzzleSolver solver;

	private int[] prevTiles;

	private int[] solution;
	private int solutionIndex;

	@Inject
	public PuzzleSolverOverlay(Client client, PuzzleSolverConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if ((!config.displaySolution() && !config.displayRemainingMoves())
				|| client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		ItemContainer container = client.getItemContainer(InventoryID.PUZZLE_BOX);

		if (container == null)
		{
			return null;
		}

		Widget puzzleBox = client.getWidget(WidgetInfo.PUZZLE_BOX);

		if (puzzleBox == null)
		{
			return null;
		}

		int[] itemIds = getItemIds(container);
		int[] tiles = convertToSolverFormat(itemIds);

		if (solution == null)
		{
			if (solver == null)
			{
				startSolver(tiles);
			}
			else if (!Arrays.equals(prevTiles, tiles))
			{
				//Puzzle has changed since we started solving, restart
				solver.stop();
				startSolver(tiles);
			}
			else
			{
				solution = solver.getSolution();
				if (solution != null)
				{
					solutionIndex = 0;
					solver = null;
				}
			}
		}
		else
		{
			if (!Arrays.equals(prevTiles, tiles))
			{
				//Puzzle has changed, try to find new position in solution
				updateSolutionPosition(tiles);
			}

			if (solution != null)
			{
				net.runelite.api.Point puzzleBoxLocation = puzzleBox.getCanvasLocation();

				if (config.displayRemainingMoves())
				{
					int x = puzzleBoxLocation.getX() + puzzleBox.getWidth() / 2 - MOVES_LEFT_WIDTH / 2;
					int y = puzzleBoxLocation.getY() - MOVES_LEFT_OFFSET_Y;

					String movesLeftString = "Moves left: " + (solution.length - 1 - solutionIndex);

					FontMetrics fm = graphics.getFontMetrics();
					int height = MOVES_LEFT_TOP_BORDER + fm.getHeight() + MOVES_LEFT_BOTTOM_BORDER;

					BackgroundComponent backgroundComponent = new BackgroundComponent();
					backgroundComponent.setRectangle(new Rectangle(x, y, MOVES_LEFT_WIDTH, height));
					backgroundComponent.render(graphics, parent);

					int textOffsetX = (MOVES_LEFT_WIDTH - fm.stringWidth(movesLeftString)) / 2;
					int textOffsetY = fm.getHeight();

					TextComponent textComponent = new TextComponent();
					textComponent.setPosition(new Point(x + textOffsetX, y + textOffsetY));
					textComponent.setText(movesLeftString);
					textComponent.render(graphics, parent);
				}

				if (config.displaySolution())
				{
					int markerSize = 16;

					int endIndex = Math.min(solutionIndex + 5, solution.length);
					for (int i = solutionIndex + 1; i < endIndex; ++i)
					{
						int blankX = solution[i] % PuzzleSolver.DIMENSION;
						int blankY = solution[i] / PuzzleSolver.DIMENSION;

						int x = puzzleBoxLocation.getX() + blankX * PUZZLE_TILE_SIZE
								+ PUZZLE_TILE_SIZE / 2 - markerSize / 2;

						int y = puzzleBoxLocation.getY() + blankY * PUZZLE_TILE_SIZE
								+ PUZZLE_TILE_SIZE / 2 - markerSize / 2;
						graphics.setColor(Color.YELLOW);
						graphics.fillOval(x, y, markerSize, markerSize);
						markerSize -= 3;
					}
				}
			}
		}
		return null;
	}

	private void startSolver(int[] tiles)
	{
		solver = new PuzzleSolver(tiles);
		new Thread(solver).start();
		prevTiles = tiles;
	}

	private void updateSolutionPosition(int[] currentTiles)
	{
		int[] prevTilesCopy = new int[prevTiles.length];
		System.arraycopy(prevTiles, 0, prevTilesCopy, 0, prevTiles.length);
		//Search forward 5 steps
		for (int i = solutionIndex + 1; i < Math.min(solutionIndex + 6, solution.length); ++i)
		{
			int newEmptyIndex = solution[i];
			prevTilesCopy[solution[i - 1]] = prevTilesCopy[newEmptyIndex];
			prevTilesCopy[newEmptyIndex] = BLANK_TILE_VALUE;
			if (Arrays.equals(prevTilesCopy, currentTiles))
			{
				solutionIndex = i;
				prevTiles = currentTiles;
				return;
			}
		}
		//Search backwards 5 steps
		for (int i = solutionIndex - 1;  i >= Math.max(solutionIndex - 5, 0); --i)
		{
			int newEmptyIndex = solution[i];
			prevTiles[solution[i + 1]] = prevTiles[newEmptyIndex];
			prevTiles[newEmptyIndex] = BLANK_TILE_VALUE;
			if (Arrays.equals(prevTiles, currentTiles))
			{
				solutionIndex = i;
				prevTiles = currentTiles;
				return;
			}
		}
		solution = null;
	}

	private int[] getItemIds(ItemContainer container)
	{
		return Arrays
				.stream(container.getItems())
				.mapToInt(Item::getId)
				.toArray();
	}

	/**
	 * This depends on there being no gaps in between item ids in puzzles.
	 */
	private int[] convertToSolverFormat(int[] items)
	{
		int lowestId = Integer.MAX_VALUE;

		int[] convertedItems = new int[PuzzleSolver.SIZE];

		for (int id : items)
		{
			if (id == BLANK_TILE_VALUE)
			{
				continue;
			}

			if (lowestId > id)
			{
				lowestId = id;
			}
		}

		for (int i = 0; i < items.length; i++)
		{
			if (items[i] != BLANK_TILE_VALUE)
			{
				convertedItems[i] = items[i] - lowestId;
			}
			else
			{
				convertedItems[i] = BLANK_TILE_VALUE;
			}
		}

		//If blank is in last position, items doesn't contain it. So we add it manually.
		if (items.length == PuzzleSolver.SIZE - 1)
		{
			convertedItems[items.length] = BLANK_TILE_VALUE;
		}

		return convertedItems;
	}
}
