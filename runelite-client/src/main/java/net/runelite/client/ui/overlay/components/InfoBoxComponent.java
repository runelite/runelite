/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Setter;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.RenderableEntity;

public class InfoBoxComponent implements RenderableEntity
{
	private final int boxSize;
	private final int separator;

	public InfoBoxComponent(int boxSize, int separator)
	{
		this.boxSize = boxSize;
		this.separator = separator;
	}

	@Setter
	private String text;

	@Setter
	private Color color = Color.WHITE;

	@Setter
	private Color backgroundColor = BackgroundComponent.DEFAULT_BACKGROUND_COLOR;

	@Setter
	private Point position = new Point();

	@Setter
	@Nullable
	private BufferedImage image;

	@Setter
	private Font font = FontManager.getRunescapeFont();

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		graphics.setFont(font);
		final FontMetrics metrics = graphics.getFontMetrics();
		final Rectangle bounds = new Rectangle(position.x, position.y, boxSize, boxSize);
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(bounds);
		backgroundComponent.render(graphics, parent);

		if (Objects.nonNull(image))
		{
			if (image.getWidth() > boxSize || image.getHeight() > boxSize)
			{
				float scale = image.getWidth() > image.getHeight() ? boxSize / (float)image.getWidth() : boxSize / (float)image.getHeight();
				graphics.drawImage(image, position.x + (boxSize - (int)(image.getWidth() * scale)) / 2, (boxSize - (int)(image.getHeight() * scale)) / 2, (int)(image.getWidth() * scale), (int)(image.getHeight() * scale), null);
			}
			else
			{
				graphics.drawImage(image, position.x + (boxSize - image.getWidth()) / 2, (boxSize - image.getHeight()) / 2, null);
			}
		}

		final TextComponent textComponent = new TextComponent();
		textComponent.setColor(color);
		textComponent.setText(text);
		textComponent.setPosition(new Point(
			position.x + (boxSize - metrics.stringWidth(text) - separator),
			boxSize - separator
		));
		textComponent.render(graphics, parent);
		return new Dimension(boxSize, boxSize);
	}
}
