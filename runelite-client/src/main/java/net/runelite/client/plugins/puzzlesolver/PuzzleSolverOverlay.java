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
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import static net.runelite.api.SpriteID.MINIMAP_DESTINATION_FLAG;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.BLANK_TILE_VALUE;
import static net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver.DIMENSION;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleSolver;
import net.runelite.client.plugins.puzzlesolver.solver.PuzzleState;
import net.runelite.client.plugins.puzzlesolver.solver.heuristics.ManhattanDistance;
import net.runelite.client.plugins.puzzlesolver.solver.pathfinding.IDAStar;
import net.runelite.client.plugins.puzzlesolver.solver.pathfinding.IDAStarMM;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.ImageUtil;

public class PuzzleSolverOverlay extends Overlay
{
	private static final int INFO_BOX_WIDTH = 100;
	private static final int INFO_BOX_OFFSET_Y = 50;
	private static final int INFO_BOX_TOP_BORDER = 2;
	private static final int INFO_BOX_BOTTOM_BORDER = 2;

	private static final int PUZZLE_TILE_SIZE = 39;
	private static final int DOT_MARKER_SIZE = 16;

	private final Client client;
	private final PuzzleSolverConfig config;
	private final ScheduledExecutorService executorService;
	private final SpriteManager spriteManager;

	private PuzzleSolver solver;
	private Future<?> solverFuture;
	private int[] cachedItems;

	private BufferedImage upArrow;
	private BufferedImage leftArrow;
	private BufferedImage rightArrow;

	@Inject
	public PuzzleSolverOverlay(Client client, PuzzleSolverConfig config, ScheduledExecutorService executorService, SpriteManager spriteManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
		this.executorService = executorService;
		this.spriteManager = spriteManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if ((!config.displaySolution() && !config.displayRemainingMoves())
				|| client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		boolean useNormalSolver = true;
		ItemContainer container = client.getItemContainer(InventoryID.PUZZLE_BOX);

		if (container == null)
		{
			useNormalSolver = false;
			container = client.getItemContainer(InventoryID.MONKEY_MADNESS_PUZZLE_BOX);

			if (container == null)
			{
				return null;
			}
		}

		Widget puzzleBox = client.getWidget(WidgetInfo.PUZZLE_BOX);

		if (puzzleBox == null)
		{
			return null;
		}

		net.runelite.api.Point puzzleBoxLocation = puzzleBox.getCanvasLocation();

		String infoString = "Solving..";

		int[] itemIds = getItemIds(container, useNormalSolver);
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
			backgroundComponent.render(graphics);

			int textOffsetX = (INFO_BOX_WIDTH - fm.stringWidth(infoString)) / 2;
			int textOffsetY = fm.getHeight();

			TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(x + textOffsetX, y + textOffsetY));
			textComponent.setText(infoString);
			textComponent.render(graphics);
		}

		// Solve the puzzle if we don't have an up to date solution
		if (solver == null || cachedItems == null
			|| (!shouldCache && solver.hasExceededWaitDuration() && !Arrays.equals(cachedItems, itemIds)))
		{
			solve(itemIds, useNormalSolver);
			shouldCache = true;
		}

		if (shouldCache)
		{
			cacheItems(itemIds);
		}

		return null;
	}

	private int[] getItemIds(ItemContainer container, boolean useNormalSolver)
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

		return convertToSolverFormat(itemIds, useNormalSolver);
	}

	private int[] convertToSolverFormat(int[] items, boolean useNormalSolver)
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
				int value = items[i] - lowestId;

				// The MM puzzle has gaps
				if (!useNormalSolver)
				{
					value /= 2;
				}

				convertedItems[i] = value;
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

	private void solve(int[] items, boolean useNormalSolver)
	{
		if (solverFuture != null)
		{
			solverFuture.cancel(true);
		}

		PuzzleState puzzleState = new PuzzleState(items);

		if (useNormalSolver)
		{
			solver = new PuzzleSolver(new IDAStar(new ManhattanDistance()), puzzleState);
		}
		else
		{
			solver = new PuzzleSolver(new IDAStarMM(new ManhattanDistance()), puzzleState);
		}

		solverFuture = executorService.submit(solver);
	}

	private BufferedImage getDownArrow()
	{
		return spriteManager.getSprite(MINIMAP_DESTINATION_FLAG, 1);
	}

	private BufferedImage getUpArrow()
	{
		if (upArrow == null)
		{
			upArrow = ImageUtil.rotateImage(getDownArrow(), Math.PI);
		}
		return upArrow;
	}

	private BufferedImage getLeftArrow()
	{
		if (leftArrow == null)
		{
			leftArrow = ImageUtil.rotateImage(getDownArrow(), Math.PI / 2);
		}
		return leftArrow;
	}

	private BufferedImage getRightArrow()
	{
		if (rightArrow == null)
		{
			rightArrow = ImageUtil.rotateImage(getDownArrow(), 3 * Math.PI / 2);
		}
		return rightArrow;
	}
}
