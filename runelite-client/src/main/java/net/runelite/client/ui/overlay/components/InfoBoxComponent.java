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
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Setter
public class InfoBoxComponent implements LayoutableRenderableEntity
{
	private static final int BOX_SIZE = 35;
	private static final int SEPARATOR = 2;

	@Getter
	private String tooltip;

	@Getter
	private Point preferredPosition = new Point();

	private String text;
	private Color color = Color.WHITE;
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;
	private BufferedImage image;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		graphics.translate(preferredPosition.x, preferredPosition.y);
		final FontMetrics metrics = graphics.getFontMetrics();
		final int w = BOX_SIZE;
		final int h = BOX_SIZE;
		final Rectangle bounds = new Rectangle(w, h);
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(bounds);
		backgroundComponent.render(graphics);

		if (Objects.nonNull(image))
		{
			graphics.drawImage(
				image,
				(w - image.getWidth()) / 2,
				(h - image.getHeight()) / 2,
				null);
		}

		final TextComponent textComponent = new TextComponent();
		textComponent.setColor(color);
		textComponent.setText(text);
		textComponent.setPosition(new Point(((w - metrics.stringWidth(text)) / 2), h - SEPARATOR));
		textComponent.render(graphics);
		graphics.translate(-preferredPosition.x, -preferredPosition.y);
		return bounds.getSize();
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(BOX_SIZE, BOX_SIZE);
	}

	@Override
	public void setPreferredSize(Dimension dimension)
	{
		// Just use infobox dimensions for now
	}
}
