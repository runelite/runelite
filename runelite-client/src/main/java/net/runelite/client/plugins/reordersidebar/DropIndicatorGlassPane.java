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

import java.awt.geom.Area;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import net.runelite.client.ui.ColorScheme;

/**
 * A glass pane that displays a drop indicator arrow for sidebar tab reordering.
 * The indicator consists of an arrow head pointing to the insertion point and a
 * line extending across the tab.
 */
class DropIndicatorGlassPane extends JPanel
{
	private static final int ARROW_HEAD_WIDTH = 4;
	private static final int ARROW_HEAD_HEIGHT = 5;
	private static final int LINE_THICKNESS = 1;
	private static final int LINE_PADDING = 0;

	private Rectangle tabBounds;
	private boolean showAbove;

	DropIndicatorGlassPane()
	{
		setOpaque(false);
		setVisible(false);
	}

	void showIndicator(Rectangle bounds, boolean above)
	{
		this.tabBounds = bounds;
		this.showAbove = above;
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
		g2d.setColor(ColorScheme.BRAND_ORANGE_TRANSPARENT);

		drawHorizontalIndicator(g2d);
		g2d.dispose();
	}

	private void drawHorizontalIndicator(Graphics2D g2d)
	{
		int x = tabBounds.x;
		int y = showAbove ? tabBounds.y : tabBounds.y + tabBounds.height;
		int lineWidth = tabBounds.width - (LINE_PADDING * 2);

		// triangle, pointing right
		Polygon arrowHead = new Polygon();
		arrowHead.addPoint(x, y - ARROW_HEAD_WIDTH);   // top-left
		arrowHead.addPoint(x + ARROW_HEAD_HEIGHT, y);  // point
		arrowHead.addPoint(x, y + ARROW_HEAD_WIDTH);   // bottom-left

		// horizontal line to the right of arrow
		Rectangle rect = new Rectangle(x + LINE_PADDING, y - LINE_THICKNESS, lineWidth, LINE_THICKNESS * 2);

		Area arrowArea = new Area(arrowHead);
		Area rectArea = new Area(rect);
		arrowArea.add(rectArea);
		g2d.fill(arrowArea);
	}
}

