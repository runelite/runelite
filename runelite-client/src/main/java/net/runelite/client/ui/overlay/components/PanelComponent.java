/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.ui.overlay.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class PanelComponent implements LayoutableRenderableEntity
{
	public enum Orientation
	{
		HORIZONTAL,
		VERTICAL;
	}

	private static final int TOP_BORDER = ComponentConstants.STANDARD_PADDING;
	private static final int LEFT_BORDER = ComponentConstants.STANDARD_PADDING;
	private static final int RIGHT_BORDER = ComponentConstants.STANDARD_PADDING;
	private static final int BOTTOM_BORDER = ComponentConstants.STANDARD_PADDING;

	@Setter
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;

	@Setter
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Getter
	private List<LayoutableRenderableEntity> children = new ArrayList<>();

	@Setter
	private Orientation orientation = Orientation.VERTICAL;

	private final Dimension childDimensions = new Dimension();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (children.isEmpty())
		{
			return null;
		}

		final FontMetrics metrics = graphics.getFontMetrics();

		// Render background
		final Dimension dimension = new Dimension(
			LEFT_BORDER + childDimensions.width + RIGHT_BORDER,
			TOP_BORDER + childDimensions.height + BOTTOM_BORDER);

		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setRectangle(new Rectangle(dimension));
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.render(graphics);

		// Offset children
		final int baseX = LEFT_BORDER;
		final int baseY = TOP_BORDER + metrics.getHeight();
		int width = 0;
		int height = 0;
		int x = baseX;
		int y = baseY;

		// Create child preferred size
		final Dimension childPreferredSize = new Dimension(
			preferredSize.width - LEFT_BORDER - RIGHT_BORDER,
			preferredSize.height - TOP_BORDER - BOTTOM_BORDER);

		// Render all children
		for (final LayoutableRenderableEntity child : children)
		{
			child.setPreferredSize(childPreferredSize);
			graphics.translate(x, y);
			final Dimension childDimension = child.render(graphics);
			graphics.translate(-x, -y);

			switch (orientation)
			{
				case VERTICAL:
					height += childDimension.height;
					y = baseY + height;
					width = Math.max(width, childDimension.width);
					break;
				case HORIZONTAL:
					width += childDimension.width;
					x = baseX + width;
					height = Math.max(height, childDimension.height);
					break;
			}
		}

		// Cache children bounds
		childDimensions.setSize(width, height);

		return dimension;
	}
}
