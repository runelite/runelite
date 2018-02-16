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
package net.runelite.client.plugins.puzzlesolver;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import javax.imageio.ImageIO;
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
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
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
	private Deque<Integer> nextMoves;
	private int[] cachedItems;

	private BufferedImage downArrow;
	private BufferedImage upArrow;
	private BufferedImage leftArrow;
	private BufferedImage rightArrow;

	@Inject
	public PuzzleSolverOverlay(Client client, PuzzleSolverConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
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
		boolean shouldCache = false;

		if (nextMoves != null)
		{
			Integer nextMove = nextMoves.peek();

			// If this is true, nextMove is actually the current state (player has moved the empty tile),
			// so let's throw away this step and try to find the actual next move.
			while (nextMove != null && itemIds[nextMove] == BLANK_TILE_VALUE)
			{
				nextMoves.pop(); // pop the current move
				nextMove = nextMoves.peek();
				shouldCache = true;
			}

			// If nextMove is null, the puzzle is either finished
			// or the player has not followed the instructions.
			if (nextMove != null)
			{
				net.runelite.api.Point puzzleBoxLocation = puzzleBox.getCanvasLocation();

				if (config.displayRemainingMoves())
				{
					int x = puzzleBoxLocation.getX() + puzzleBox.getWidth() / 2 - MOVES_LEFT_WIDTH / 2;
					int y = puzzleBoxLocation.getY() - MOVES_LEFT_OFFSET_Y;

					String movesLeftString = "Moves left: " + nextMoves.size();

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
					int i = 0;
					int lastBlankX = 0;
					int lastBlankY = 0;

					// First find the current blank tile position
					for (int j = 0; j < itemIds.length; j++)
					{
						if (itemIds[j] == BLANK_TILE_VALUE)
						{
							lastBlankX = j % PuzzleSolver.DIMENSION;
							lastBlankY = j / PuzzleSolver.DIMENSION;
							break;
						}
					}

					for (Integer futureMove : nextMoves)
					{
						int blankX = futureMove % PuzzleSolver.DIMENSION;
						int blankY = futureMove / PuzzleSolver.DIMENSION;

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

						if (++i == 3)
						{
							break;
						}
					}
				}
			}
		}

		if (solver == null || cachedItems == null || (!shouldCache && !Arrays.equals(cachedItems, itemIds)))
		{
			nextMoves = solve(itemIds);
			shouldCache = true;
		}

		if (shouldCache)
		{
			cacheItems(itemIds);
		}

		return null;
	}

	private int[] getItemIds(ItemContainer container)
	{
		return Arrays
				.stream(container.getItems())
				.mapToInt(Item::getId)
				.toArray();
	}

	private void cacheItems(int[] items)
	{
		cachedItems = new int[items.length];
		System.arraycopy(items, 0, cachedItems, 0, cachedItems.length);
	}

	private Deque<Integer> solve(int[] items)
	{
		Deque<Integer> steps = new ArrayDeque<>();

		solver = new PuzzleSolver(convertToSolverFormat(items));

		while (solver.hasNext())
		{
			solver.next();
			steps.add(solver.getBlankX() + solver.getBlankY() * PuzzleSolver.DIMENSION);
		}

		return steps;
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

	private BufferedImage getDownArrow()
	{
		if (downArrow == null)
		{
			try
			{
				InputStream in = PuzzleSolverOverlay.class.getResourceAsStream("arrow.png");
				downArrow = ImageIO.read(in);
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
}
