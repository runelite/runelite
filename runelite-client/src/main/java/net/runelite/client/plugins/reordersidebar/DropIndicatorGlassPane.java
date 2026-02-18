/*
 * Copyright (c) 2024, Smoke (Smoked today) <https://github.com/Varietyz>
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
package net.runelite.client.plugins.reordersidebar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * A glass pane that displays a drop indicator arrow for sidebar tab reordering.
 * The indicator consists of an arrow head pointing to the insertion point and a
 * line extending across the tab.
 */
class DropIndicatorGlassPane extends JPanel
{
	// Indicator color: golden/orange with transparency
	private static final Color DROP_INDICATOR_COLOR = new Color(255, 200, 0);

	// Arrow dimensions
	private static final int ARROW_HEAD_WIDTH = 4;
	private static final int ARROW_HEAD_HEIGHT = 5;
	private static final int LINE_THICKNESS = 1;
	private static final int LINE_PADDING = 0;

	private Rectangle tabBounds;
	private boolean showAbove;
	private int tabPlacement;

	DropIndicatorGlassPane()
	{
		setOpaque(false);
		setVisible(false);
	}

	void showIndicator(Rectangle bounds, boolean above, int placement)
	{
		this.tabBounds = bounds;
		this.showAbove = above;
		this.tabPlacement = placement;
		setVisible(true);
		repaint();
	}

	void hideIndicator()
	{
		this.tabBounds = null;
		setVisible(false);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (tabBounds == null)
		{
			return;
		}

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(DROP_INDICATOR_COLOR);

		boolean isHorizontal = tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM;

		if (isHorizontal)
		{
			drawVerticalIndicator(g2d);
		}
		else
		{
			drawHorizontalIndicator(g2d);
		}

		g2d.dispose();
	}

	/**
	 * Draws a vertical indicator (arrow pointing down with vertical line) for horizontal tab layouts.
	 * Used when tabs are at TOP or BOTTOM.
	 */
	private void drawVerticalIndicator(Graphics2D g2d)
	{
		int x = showAbove ? tabBounds.x : tabBounds.x + tabBounds.width;
		int y = tabBounds.y;
		int lineHeight = tabBounds.height - (LINE_PADDING * 2);

		// Draw arrow head (triangle pointing down)
		Polygon arrowHead = new Polygon();
		arrowHead.addPoint(x - ARROW_HEAD_WIDTH, y);                    // Top-left
		arrowHead.addPoint(x, y + ARROW_HEAD_HEIGHT);                   // Bottom-center (point)
		arrowHead.addPoint(x + ARROW_HEAD_WIDTH, y);                    // Top-right
		g2d.fillPolygon(arrowHead);

		// Draw vertical line below arrow
		int lineTop = y + LINE_PADDING;
		int lineBottom = y + LINE_PADDING + lineHeight;
		g2d.fillRect(x - LINE_THICKNESS, lineTop, LINE_THICKNESS * 2, lineBottom - lineTop);
	}

	/**
	 * Draws a horizontal indicator (arrow pointing right with horizontal line) for vertical tab layouts.
	 * Used when tabs are at LEFT or RIGHT.
	 */
	private void drawHorizontalIndicator(Graphics2D g2d)
	{
		int x = tabBounds.x;
		int y = showAbove ? tabBounds.y : tabBounds.y + tabBounds.height;
		int lineWidth = tabBounds.width - (LINE_PADDING * 2);

		// Draw arrow head (triangle pointing right)
		Polygon arrowHead = new Polygon();
		arrowHead.addPoint(x, y - ARROW_HEAD_WIDTH);                    // Top-left
		arrowHead.addPoint(x + ARROW_HEAD_HEIGHT, y);                   // Middle-right (point)
		arrowHead.addPoint(x, y + ARROW_HEAD_WIDTH);                    // Bottom-left
		g2d.fillPolygon(arrowHead);

		// Draw horizontal line to the right of arrow
		int lineLeft = x + LINE_PADDING;
		int lineRight = x + LINE_PADDING + lineWidth;
		g2d.fillRect(lineLeft, y - LINE_THICKNESS, lineRight - lineLeft, LINE_THICKNESS * 2);
	}
}

