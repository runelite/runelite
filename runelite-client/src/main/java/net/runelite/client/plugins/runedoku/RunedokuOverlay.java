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
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

/**
 * @author gazivodag
 */
@Singleton
class RunedokuOverlay extends Overlay
{

	private final RunedokuPlugin plugin;
	private final Client client;
	private final RunedokuUtil util;


	@Inject
	private RunedokuOverlay(final RunedokuPlugin plugin, final Client client, final RunedokuUtil util)
	{
		super(plugin);
		this.plugin = plugin;
		this.client = client;
		this.util = util;

		setPosition(OverlayPosition.DETACHED);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		final Widget sudokuScreen = client.getWidget(288, 131);

		if (sudokuScreen != null && !sudokuScreen.isHidden())
		{
			Sudoku sudoku = new Sudoku(util.createTable(client));
			boolean solved = sudoku.solve();

			renderReferenceRunes(graphics, solved);
			renderSolvedPuzzle(graphics, sudoku, solved);
		}

		return null;
	}

	/**
	 * highlights the runes on the left handside so you know which runes to place on the board
	 *
	 * @param graphics
	 * @param solved
	 */
	private void renderReferenceRunes(Graphics2D graphics, boolean solved)
	{
		//reference runes on the left handside
		for (int i = 121; i < 130; i++)
		{
			Widget widget = client.getWidget(288, i);
			if (solved)
			{
				if (!util.makeSimple(util.createTable(client)).contains(0))
				{
					OverlayUtil.renderPolygon(graphics, RunedokuUtil.rectangleToPolygon(widget.getBounds()), Color.GREEN);
				}
				else
				{
					OverlayUtil.renderPolygon(graphics, RunedokuUtil.rectangleToPolygon(widget.getBounds()), util.referenceColors(i));
				}
			}
			else
			{
				OverlayUtil.renderPolygon(graphics, RunedokuUtil.rectangleToPolygon(widget.getBounds()), RED);
			}

		}
	}

	/**
	 * goes through each 9x9 cell and tells you which piece to place in there
	 *
	 * @param graphics
	 * @param sudoku
	 * @param solved
	 */
	private void renderSolvedPuzzle(Graphics2D graphics, Sudoku sudoku, boolean solved)
	{
		List<Integer> simpleArr = util.makeSimple(sudoku.getBoard());
		//highlight each cell to tell you which piece to place
		int iteration = 0;
		for (int i = 10; i < 91; i++)
		{
			Widget squareToHighlight = client.getWidget(288, i);
			if (solved)
			{
				if (!util.makeSimple(util.createTable(client)).contains(0))
				{
					OverlayUtil.renderPolygon(graphics, RunedokuUtil.rectangleToPolygon(squareToHighlight.getBounds()), Color.GREEN);
				}
				else
				{
					if (!plugin.isOnlyHighlightSelectedPiece() ^ (plugin.isOnlyHighlightSelectedPiece() && util.getSelectedPiece(client) == simpleArr.get(iteration)))
					{
						OverlayUtil.renderPolygon(graphics, RunedokuUtil.rectangleToPolygon(squareToHighlight.getBounds()), util.sudokuPieceToColor(simpleArr.get(iteration)));
					}
				}
				iteration++;
			}
			else
			{
				OverlayUtil.renderPolygon(graphics, RunedokuUtil.rectangleToPolygon(squareToHighlight.getBounds()), RED);
			}

		}
	}

}
