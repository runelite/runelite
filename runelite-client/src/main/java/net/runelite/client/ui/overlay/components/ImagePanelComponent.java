/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.overlay.RenderableEntity;

public class ImagePanelComponent implements RenderableEntity
{
	private static final int TOP_BORDER = 4;
	private static final int SIDE_BORDER = 4;
	private static final int BOTTOM_BORDER = 4;
	private static final int SEPARATOR = 1;

	@Setter
	@Nullable
	private String title;

	@Setter
	private Color titleColor = Color.WHITE;

	@Setter
	private Color backgroundColor = BackgroundComponent.DEFAULT_BACKGROUND_COLOR;

	@Getter
	private final List<BufferedImage> images = new ArrayList<>();

	@Setter
	private Point position = new Point();

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		final Dimension dimension = new Dimension();
		final FontMetrics metrics = graphics.getFontMetrics();

		//Determine max height and width of images
		int maxImageHeight = 0;
		int imageWidth = 0;
		for (final BufferedImage image : images)
		{
			if (image.getHeight() > maxImageHeight)
			{
				maxImageHeight = image.getHeight();
			}
			imageWidth += image.getWidth() + SEPARATOR;
		}

		int height = TOP_BORDER + (Strings.isNullOrEmpty(title) ? 0 : metrics.getHeight() + SEPARATOR)
			+ maxImageHeight + BOTTOM_BORDER;
		int width = Math.max(Strings.isNullOrEmpty(title) ? 0 : metrics.stringWidth(title), imageWidth) + SIDE_BORDER * 2;
		dimension.setSize(width, height);

		if (dimension.height == TOP_BORDER + BOTTOM_BORDER)
		{
			return null;
		}

		int y = position.y + TOP_BORDER;
		if (!Strings.isNullOrEmpty(title))
		{
			// Calculate panel dimensions
			y += metrics.getHeight();
		}

		// Render background
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(new Rectangle(position.x, position.y, dimension.width, dimension.height));
		backgroundComponent.render(graphics, parent);

		// Render title
		if (!Strings.isNullOrEmpty(title))
		{
			final TextComponent titleComponent = new TextComponent();
			titleComponent.setText(title);
			titleComponent.setColor(titleColor);
			titleComponent.setPosition(new Point(position.x + (width - metrics.stringWidth(title)) / 2, y));
			titleComponent.render(graphics, parent);
			y += SEPARATOR;
		}

		// Render all images
		int imageOffsetX = ((width - imageWidth) / 2) - (SEPARATOR / 2);
		for (final BufferedImage image : images)
		{
			graphics.drawImage(image, imageOffsetX + ((imageWidth / images.size()) - image.getWidth()) / 2, y, null);
			imageOffsetX += image.getWidth() + SEPARATOR;
		}

		return dimension;
	}
}
