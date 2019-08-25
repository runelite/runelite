/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

package net.runelite.client.plugins.zulrah;

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.client.ui.overlay.RenderableEntity;
import net.runelite.client.ui.overlay.components.BackgroundComponent;

@Singleton
public class ImagePanelComponent implements RenderableEntity
{
	private static final int TOP_BORDER = 3;
	private static final int SIDE_BORDER = 6;
	private static final int BOTTOM_BORDER = 6;
	private static final int SEPARATOR = 4;

	@Setter(AccessLevel.PUBLIC)
	@Nullable
	private String title;

	@Setter(AccessLevel.PACKAGE)
	private Color titleColor = Color.WHITE;

	@Setter(AccessLevel.PUBLIC)
	private Color backgroundColor = new Color(70, 61, 50, 156);

	@Setter(AccessLevel.PUBLIC)
	private BufferedImage image;

	@Setter(AccessLevel.PACKAGE)
	private Point position = new Point();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Dimension dimension = new Dimension();
		final FontMetrics metrics = graphics.getFontMetrics();
		int height = TOP_BORDER + (Strings.isNullOrEmpty(title) ? 0 : metrics.getHeight())
			+ SEPARATOR + image.getHeight() + BOTTOM_BORDER;
		int width = Math.max(Strings.isNullOrEmpty(title) ? 0 : metrics.stringWidth(title), image.getWidth()) + SIDE_BORDER * 2;
		dimension.setSize(width, height);

		if (dimension.height == 0)
		{
			return null;
		}

		// Calculate panel dimensions
		int y = position.y + TOP_BORDER + metrics.getHeight();

		// Render background
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(new Rectangle(position.x, position.y, dimension.width, dimension.height));
		backgroundComponent.render(graphics);

		// Render title
		if (!Strings.isNullOrEmpty(title))
		{
			final TextComponent titleComponent = new TextComponent();
			titleComponent.setText(title);
			titleComponent.setColor(titleColor);
			titleComponent.setPosition(new Point(position.x + (width - metrics.stringWidth(title)) / 2, y));
			titleComponent.render(graphics);
			y += SEPARATOR;
		}

		// Render image
		graphics.drawImage(image, position.x + (width - image.getWidth()) / 2, y, null);

		return dimension;
	}
}