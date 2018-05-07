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

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
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

	private static final int TOP_BORDER = 4;
	private static final int LEFT_BORDER = 4;
	private static final int RIGHT_BORDER = 4;
	private static final int BOTTOM_BORDER = 4;
	private static final int SEPARATOR = 1;

	@Setter
	private int wrapping = -1;

	@Setter
	private String title;

	@Setter
	private Color titleColor = Color.WHITE;

	@Setter
	private Color backgroundColor = BackgroundComponent.DEFAULT_BACKGROUND_COLOR;

	@Setter
	private Point position = new Point();

	@Setter
	private Dimension preferredSize = new Dimension(129, 0);

	@Getter
	private List<LayoutableRenderableEntity> children = new ArrayList<>();

	@Setter
	private Orientation orientation = Orientation.VERTICAL;

	private final Dimension savedChildrenSize = new Dimension();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (Strings.isNullOrEmpty(title) && children.isEmpty())
		{
			return null;
		}

		final FontMetrics metrics = graphics.getFontMetrics();

		// Calculate panel dimensions
		int width = preferredSize.width;
		int height = preferredSize.height;
		int x = LEFT_BORDER;
		int y = TOP_BORDER + metrics.getHeight();

		// Set graphics offset at correct position
		graphics.translate(position.x, position.y);

		// Render background
		final Dimension dimension = new Dimension(
			savedChildrenSize.width + RIGHT_BORDER,
			savedChildrenSize.height + BOTTOM_BORDER);

		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setRectangle(new Rectangle(dimension));
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.render(graphics);

		if (!Strings.isNullOrEmpty(title))
		{
			// Render title
			final TextComponent titleComponent = new TextComponent();
			titleComponent.setText(title);
			titleComponent.setColor(titleColor);
			titleComponent.setPosition(new Point((dimension.width - metrics.stringWidth(title)) / 2, y));
			titleComponent.render(graphics);

			// Move children a bit
			height = y += metrics.getHeight() + SEPARATOR;
		}

		// Render all children
		final Dimension childPreferredSize = new Dimension(
			preferredSize.width - RIGHT_BORDER,
			preferredSize.height - BOTTOM_BORDER);

		boolean wrapped = false;

		for (int i = 0; i < children.size(); i ++)
		{
			final LayoutableRenderableEntity child = children.get(i);

			child.setPreferredSize(childPreferredSize);
			graphics.translate(x, y);
			final Dimension childDimension = child.render(graphics);
			graphics.translate(-x, -y);

			switch (orientation)
			{
				case VERTICAL:
					y += childDimension.height + SEPARATOR;
					height = wrapped ? height : y;
					width = Math.max(width, x + childDimension.width);
					break;
				case HORIZONTAL:
					x += childDimension.width + SEPARATOR;
					width = wrapped ? width : x;
					height = Math.max(height, y + childDimension.height);
					break;
			}

			if (wrapping > 0 && (i + 1) % wrapping == 0)
			{
				wrapped = true;

				switch (orientation)
				{
					case VERTICAL:
						y = TOP_BORDER + metrics.getHeight();
						width = x += childDimension.width + SEPARATOR;
						break;
					case HORIZONTAL:
						x = LEFT_BORDER;
						height = y += childDimension.height + SEPARATOR;
						break;
				}
			}
		}

		// Reset the padding
		height -= metrics.getHeight();

		// Save children size
		savedChildrenSize.setSize(width, height);

		// Reset graphics position
		graphics.translate(-position.x, -position.y);
		return dimension;
	}
}
