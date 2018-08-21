/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;
import lombok.Builder;
import lombok.Setter;
import lombok.Singular;
import net.runelite.api.VerticalAlign;

@Setter
@Builder
public class LineImageComponent implements LayoutableRenderableEntity
{
	@Singular("left")
	private List<Object> left;

	@Singular("right")
	private List<Object> right;

	@Builder.Default
	private Color leftColor = Color.WHITE;

	@Builder.Default
	private Color rightColor = Color.WHITE;

	@Builder.Default
	private Point preferredLocation = new Point();

	@Builder.Default
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Builder.Default
	private int spacing = 2;

	@Builder.Default
	private boolean autoExpand = true;

	@Builder.Default
	private VerticalAlign alignment = VerticalAlign.MIDDLE;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		graphics.translate(preferredLocation.x, preferredLocation.y);

		final FontMetrics metrics = graphics.getFontMetrics();
		int x = 0;
		int y = 0;
		int fontHeight = metrics.getHeight();

		final int leftFullWidth = getListWidth(left, metrics);
		final int rightFullWidth = getListWidth(right, metrics);

		final int leftMaxHeight = getListHeight(left, metrics);
		final int rightMaxHeight = getListHeight(right, metrics);

		final int maxHeight = (leftMaxHeight > rightMaxHeight ? leftMaxHeight : rightMaxHeight);

		if (leftFullWidth + rightFullWidth > preferredSize.width)
		{
			preferredSize.width = leftFullWidth + rightFullWidth + 5;
		}

		for (Object o : left)
		{
			if (o instanceof String)
			{
				String s = (String) o;
				TextComponent txt = new TextComponent();
				switch (alignment)
				{
					case MIDDLE:
						y = rightMaxHeight / 2 + fontHeight / 2;
						break;
					case TOP:
						y = fontHeight;
						break;
					case BOTTOM:
						y = leftMaxHeight;
						break;
				}

				txt.setPosition(new Point(x, y));
				txt.setText(s);
				txt.setColor(leftColor);
				txt.render(graphics);

				x += getLineWidth(s, metrics) + spacing;
			}
			else if (o instanceof BufferedImage)
			{
				BufferedImage bi = (BufferedImage) o;
				ImageComponent image = new ImageComponent(bi);
				image.setPreferredLocation(new Point(x, 0));
				image.render(graphics);

				x += bi.getWidth() + spacing;
			}
		}

		x = preferredSize.width;
		for (int i = right.size() - 1; i >= 0; i--)
		{
			Object o = right.get(i);

			if (o instanceof String)
			{
				String s = (String) o;
				x -= getLineWidth(s, metrics) + spacing;

				TextComponent txt = new TextComponent();

				switch (alignment)
				{
					case MIDDLE:
						y = rightMaxHeight / 2 + fontHeight / 2;
						break;
					case TOP:
						y = fontHeight;
						break;
					case BOTTOM:
						y = rightMaxHeight;
						break;
				}

				txt.setPosition(new Point(x, y));

				txt.setText(s);
				txt.setColor(rightColor);
				txt.render(graphics);
			}
			else if (o instanceof BufferedImage)
			{
				BufferedImage bi = (BufferedImage) o;
				x -= bi.getWidth() + spacing;

				ImageComponent image = new ImageComponent(bi);
				image.setPreferredLocation(new Point(x, 0));
				image.render(graphics);
			}
		}

		graphics.translate(-preferredLocation.x, -preferredLocation.y);
		return new Dimension(preferredSize.width, maxHeight );
	}

	private int getListWidth(List<Object> l, final FontMetrics metrics)
	{
		int result = 0;
		for (Object o : l)
		{
			if (o instanceof String)
			{
				String s = (String) o;
				result += getLineWidth(s, metrics) + spacing;
			}
			else if (o instanceof BufferedImage)
			{
				BufferedImage bi = (BufferedImage) o;
				result += bi.getWidth() + spacing;
			}
		}

		return result;
	}

	private int getListHeight(List<Object> l, final FontMetrics metrics)
	{
		int result = 0;
		for (Object o : l)
		{
			if (o instanceof String)
			{
				String s = (String) o;
				if (metrics.getHeight() > result)
				{
					result = metrics.getHeight();
				}
			}
			else if (o instanceof BufferedImage)
			{
				BufferedImage bi = (BufferedImage) o;

				if (bi.getHeight() > result)
				{
					result = bi.getHeight();
				}
			}
		}

		return result;
	}

	private static int getLineWidth(final String line, final FontMetrics metrics)
	{
		return metrics.stringWidth(TextComponent.textWithoutColTags(line));
	}

}

