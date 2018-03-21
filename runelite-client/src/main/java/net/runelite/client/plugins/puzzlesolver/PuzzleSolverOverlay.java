/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleState;
import net.runelite.client.plugins.puzzlesolver.solver.heuristics.ManhattanDistance;
import net.runelite.client.plugins.puzzlesolver.solver.pathfinding.IDAStar;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.ui.overlay.components.TextComponent;

@Slf4j
public class PuzzleSolverOverlay extends Overlay
{
	private static final int INFO_BOX_WIDTH = 100;
	private static final int INFO_BOX_OFFSET_Y = 50;
	private static final int INFO_BOX_TOP_BORDER = 2;
	private static final int INFO_BOX_BOTTOM_BORDER = 2;

	private static final int PUZZLE_TILE_SIZE = 39;
	private static final int DOT_MARKER_SIZE = 16;

	private static final int BLANK_TILE_VALUE = -1;
	private static final int DIMENSION = 5;

	private final Client client;
	private final PuzzleSolverConfig config;
	private final ScheduledExecutorService executorService;
	private final ItemManager itemManager;

	private PuzzleSolver solver;
	private Future<?> solverFuture;
	private int[] cachedItems;

	private BufferedImage downArrow;
	private BufferedImage upArrow;
	private BufferedImage leftArrow;
	private BufferedImage rightArrow;

	private static final int[] runeList = new int[] { 6436, 6422, 6428, 6424, 6426, 6438, 6432, 6430, 6434 };
	private static final Map<Integer, Integer> runeDokuMap = new HashMap<>();
	private static BufferedImage[] runeSprites;

	static
	{
		for (int i = 0; i < runeList.length; ++i)
		{
			runeDokuMap.put(runeList[i], i + 1);
		}
	}

	@Inject
	public PuzzleSolverOverlay(Client client, PuzzleSolverConfig config, ScheduledExecutorService executorService, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
		this.executorService = executorService;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if ((!config.displaySolution() && !config.displayRemainingMoves())
				|| client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		// get rogue trader rune puzzle widget
		Widget runeDoku  = client.getWidget(WidgetInfo.ROGUE_TRADER_PUZZLE_GRID);
		if (runeDoku != null)
		{
			if (!runeDoku.isHidden())
			{
				solveRuneDoku(graphics, runeDoku);
				return null;
			}
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

		net.runelite.api.Point puzzleBoxLocation = puzzleBox.getCanvasLocation();

		String infoString = "Solving..";

		int[] itemIds = getItemIds(container);
		boolean shouldCache = false;

		if (solver != null)
		{
			if (solver.hasFailed())
			{
				infoString = "The puzzle could not be solved";
			}
			else
			{
				if (solver.hasSolution())
				{
					boolean foundPosition = false;

					// Find the current state by looking at the current step and then the next 5 steps
					for (int i = 0; i < 6; i++)
					{
						int j = solver.getPosition() + i;

						if (j == solver.getStepCount())
						{
							break;
						}

						PuzzleState currentState = solver.getStep(j);

						// If this is false, player has moved the empty tile
						if (currentState != null && currentState.hasPieces(itemIds))
						{
							foundPosition = true;
							solver.setPosition(j);
							if (i > 0)
							{
								shouldCache = true;
							}
							break;
						}
					}

					// If looking at the next steps didn't find the current state,
					// see if we can find the current state in the 5 previous steps
					if (!foundPosition)
					{
						for (int i = 1; i < 6; i++)
						{
							int j = solver.getPosition() - i;

							if (j < 0)
							{
								break;
							}

							PuzzleState currentState = solver.getStep(j);

							if (currentState != null && currentState.hasPieces(itemIds))
							{
								foundPosition = true;
								shouldCache = true;
								solver.setPosition(j);
								break;
							}
						}
					}

					if (foundPosition)
					{
						int stepsLeft = solver.getStepCount() - solver.getPosition() - 1;

						if (stepsLeft == 0)
						{
							infoString = "Solved!";
						}
						else if (config.displayRemainingMoves())
						{
							infoString = "Moves left: " + stepsLeft;
						}
						else
						{
							infoString = null;
						}

						if (config.displaySolution())
						{
							if (config.drawDots())
							{
								graphics.setColor(Color.YELLOW);

								// Display the next 4 steps
								for (int i = 1; i < 5; i++)
								{
									int j = solver.getPosition() + i;

									if (j >= solver.getStepCount())
									{
										break;
									}

									PuzzleState futureMove = solver.getStep(j);

									if (futureMove == null)
									{
										break;
									}

									int blankX = futureMove.getEmptyPiece() % DIMENSION;
									int blankY = futureMove.getEmptyPiece() / DIMENSION;

									int markerSize = DOT_MARKER_SIZE - i * 3;

									int x = puzzleBoxLocation.getX() + blankX * PUZZLE_TILE_SIZE
											+ PUZZLE_TILE_SIZE / 2 - markerSize / 2;

									int y = puzzleBoxLocation.getY() + blankY * PUZZLE_TILE_SIZE
											+ PUZZLE_TILE_SIZE / 2 - markerSize / 2;

									graphics.fillOval(x, y, markerSize, markerSize);
								}
							}
							else
							{
								// Find the current blank tile position
								PuzzleState currentMove = solver.getStep(solver.getPosition());

								int lastBlankX = currentMove.getEmptyPiece() % DIMENSION;
								int lastBlankY = currentMove.getEmptyPiece() / DIMENSION;

								// Display the next 3 steps
								for (int i = 1; i < 4; i++)
								{
									int j = solver.getPosition() + i;

									if (j >= solver.getStepCount())
									{
										break;
									}

									PuzzleState futureMove = solver.getStep(j);

									if (futureMove == null)
									{
										break;
									}

									int blankX = futureMove.getEmptyPiece() % DIMENSION;
									int blankY = futureMove.getEmptyPiece() / DIMENSION;

									int xDelta = blankX - lastBlankX;
									int yDelta = blankY - lastBlankY;

									BufferedImage arrow;
									if (xDelta > 0)
									{
										arrow = getRightArrow();
									}
									else if (xDelta < 0)
									{
										arrow = getLeftArrow();
									}
									else if (yDelta > 0)
									{
										arrow = getDownArrow();
									}
									else
									{
										arrow = getUpArrow();
									}

									int x = puzzleBoxLocation.getX() + blankX * PUZZLE_TILE_SIZE
											+ PUZZLE_TILE_SIZE / 2 - arrow.getWidth() / 2;

									int y = puzzleBoxLocation.getY() + blankY * PUZZLE_TILE_SIZE
											+ PUZZLE_TILE_SIZE / 2 - arrow.getHeight() / 2;

									OverlayUtil.renderImageLocation(graphics, new net.runelite.api.Point(x, y), arrow);

									lastBlankX = blankX;
									lastBlankY = blankY;
								}
							}
						}
					}
				}
			}
		}

		// Draw info box
		if (infoString != null)
		{
			int x = puzzleBoxLocation.getX() + puzzleBox.getWidth() / 2 - INFO_BOX_WIDTH / 2;
			int y = puzzleBoxLocation.getY() - INFO_BOX_OFFSET_Y;

			FontMetrics fm = graphics.getFontMetrics();
			int height = INFO_BOX_TOP_BORDER + fm.getHeight() + INFO_BOX_BOTTOM_BORDER;

			BackgroundComponent backgroundComponent = new BackgroundComponent();
			backgroundComponent.setRectangle(new Rectangle(x, y, INFO_BOX_WIDTH, height));
			backgroundComponent.render(graphics, parent);

			int textOffsetX = (INFO_BOX_WIDTH - fm.stringWidth(infoString)) / 2;
			int textOffsetY = fm.getHeight();

			TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(x + textOffsetX, y + textOffsetY));
			textComponent.setText(infoString);
			textComponent.render(graphics, parent);
		}

		// Solve the puzzle if we don't have an up to date solution
		if (solver == null || cachedItems == null || (!shouldCache && !Arrays.equals(cachedItems, itemIds)))
		{
			solve(itemIds);
			shouldCache = true;
		}

		if (shouldCache)
		{
			cacheItems(itemIds);
		}

		return null;
	}

	private void solveRuneDoku(Graphics2D graphics, Widget widget)
	{
		Collection<WidgetItem> items = widget.getWidgetItems();
		if (items == null)
		{
			return;
		}

		int[] puzzle = new int[81];

		for (WidgetItem item : items)
		{
			final int idx = item.getIndex();
			if (idx > 80)
			{
				log.warn("Invalid WidgetItem index");
				return;
			}
			final int id = item.getId();
			if (runeDokuMap.containsKey(id))
			{
				puzzle[idx] = runeDokuMap.get(id);
			}
		}

		int[] solvedPuzzle = puzzle.clone();
		if (!sudokuSolve(solvedPuzzle))
		{
			log.warn("Failed to solve RuneDoku");
			return;
		}

		if (runeSprites == null)
		{
			// Make all the sprites only the first time
			runeSprites = new BufferedImage[runeList.length];
			for (int i = 0; i < runeSprites.length; ++i)
			{
				BufferedImage sprite = itemManager.getImage(runeList[i]);
				if (sprite == null)
				{
					log.warn("Failed to load sprite");
					return;
				}
				BufferedImage scaledSprite = getScaledImage(sprite, 0.6);
				if (scaledSprite == null)
				{
					log.warn("Failed to load sprite");
					return;
				}

				runeSprites[i] = scaledSprite;
			}
		}

		for (int i = 0 ; i < puzzle.length; ++i)
		{
			if (puzzle[i] != 0)
			{
				// Don't draw sprites on fixed pieces
				continue;
			}

			if (solvedPuzzle[i] == 0)
			{
				// none of the solution should be empty
				log.warn("Bad solution");
				return;
			}

			// grid of widgets child ids are sequential
			Widget w = client.getWidget(WidgetID.ROGUE_TRADER_PUZZLE_GROUP_ID, WidgetID.RogueTrader.FIRST_TILE + i);
			// draw sprites over each tile widget
			OverlayUtil.renderImageLocation(graphics, w.getCanvasLocation(), runeSprites[solvedPuzzle[i] - 1]);
		}
	}

	private int[] getItemIds(ItemContainer container)
	{
		int[] itemIds = new int[DIMENSION * DIMENSION];

		Item[] items = container.getItems();

		for (int i = 0; i < items.length; i++)
		{
			itemIds[i] = items[i].getId();
		}

		// If blank is in the last position, items doesn't contain it, so let's add it manually
		if (itemIds.length > items.length)
		{
			itemIds[items.length] = BLANK_TILE_VALUE;
		}

		return convertToSolverFormat(itemIds);
	}

	/**
	 * This depends on there being no gaps in between item ids in puzzles.
	 */
	private int[] convertToSolverFormat(int[] items)
	{
		int lowestId = Integer.MAX_VALUE;

		int[] convertedItems = new int[items.length];

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

		return convertedItems;
	}

	private void cacheItems(int[] items)
	{
		cachedItems = new int[items.length];
		System.arraycopy(items, 0, cachedItems, 0, cachedItems.length);
	}

	private void solve(int[] items)
	{
		if (solverFuture != null)
		{
			solverFuture.cancel(true);
		}

		PuzzleState puzzleState = new PuzzleState(items);

		solver = new PuzzleSolver(new IDAStar(new ManhattanDistance()), puzzleState);
		solverFuture = executorService.submit(solver);
	}

	private BufferedImage getDownArrow()
	{
		if (downArrow == null)
		{
			try
			{
				synchronized (ImageIO.class)
				{
					downArrow = ImageIO.read(PuzzleSolverOverlay.class.getResourceAsStream("arrow.png"));
				}
			}
			catch (IOException e)
			{
				log.warn("Error loading image", e);
			}
		}
		return downArrow;
	}

	private BufferedImage getUpArrow()
	{
		if (upArrow == null)
		{
			upArrow = getRotatedImage(getDownArrow(), Math.PI);
		}
		return upArrow;
	}

	private BufferedImage getLeftArrow()
	{
		if (leftArrow == null)
		{
			leftArrow = getRotatedImage(getDownArrow(), Math.PI / 2);
		}
		return leftArrow;
	}

	private BufferedImage getRightArrow()
	{
		if (rightArrow == null)
		{
			rightArrow = getRotatedImage(getDownArrow(), 3 * Math.PI / 2);
		}
		return rightArrow;
	}

	private BufferedImage getRotatedImage(BufferedImage image, double theta)
	{
		AffineTransform transform = new AffineTransform();
		transform.rotate(theta, image.getWidth() / 2, image.getHeight() / 2);
		AffineTransformOp transformOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		return transformOp.filter(image, null);
	}

	private BufferedImage getScaledImage(BufferedImage image, double scale)
	{
		AffineTransform transform = new AffineTransform();
		transform.scale(scale, scale);
		AffineTransformOp transformOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		return transformOp.filter(image, null);
	}

	// Ripped from https://gist.github.com/vaskoz/8211276
	public static boolean sudokuSolve(int[] puzzle)
	{
		int N = (int) Math.round(Math.pow(puzzle.length, 0.25d)); // length ^ 0.25
		int SIZE = N * N;
		int CELLS = SIZE * SIZE;
		boolean noEmptyCells = true;
		int myRow = 0, myCol = 0;
		for (int i = 0; i < CELLS; i++)
		{
			if (puzzle[i] == 0)
			{
				myRow = i / SIZE;
				myCol = i % SIZE;
				noEmptyCells = false;
				break;
			}
		}
		if (noEmptyCells)
		{
			return true;
		}

		for (int choice = 1; choice <= SIZE; choice++)
		{
			boolean isValid = true;
			int gridRow = myRow / N;
			int gridCol = myCol / N;
			// check grid for duplicates
			for (int row = N * gridRow; row < N * gridRow + N; row++)
			{
				for (int col = N * gridCol; col < N * gridCol + N; col++)
				{
					if (puzzle[row * SIZE + col] == choice)
					{
						isValid = false;
					}
				}
			}

			// row & column
			for (int j = 0; j < SIZE; j++)
			{
				if (puzzle[SIZE * j + myCol] == choice || puzzle[myRow * SIZE + j] == choice)
				{
					isValid = false;
					break;
				}
			}


			if (isValid)
			{
				puzzle[myRow * SIZE + myCol] = choice;
				boolean solved = sudokuSolve(puzzle);
				if (solved)
				{
					return true;
				}
				else
				{
					puzzle[myRow * SIZE + myCol] = 0;
				}
			}
		}
		return false;
	}
}
