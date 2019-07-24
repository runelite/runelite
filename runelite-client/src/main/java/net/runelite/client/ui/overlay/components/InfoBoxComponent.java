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

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.FontManager;

@Setter
public class InfoBoxComponent implements LayoutableRenderableEntity
{
	private static final int SEPARATOR = 2;
	private static final int DEFAULT_SIZE = 32;

	@Getter
	private String tooltip;

	@Getter
	private final Rectangle bounds = new Rectangle();

	private Point preferredLocation = new Point();
	private Dimension preferredSize = new Dimension(DEFAULT_SIZE, DEFAULT_SIZE);
	private String text;
	private Color color = Color.WHITE;
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;
	private BufferedImage image;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (image == null)
		{
			return new Dimension();
		}

		if (graphics.getFont().equals(FontManager.getRunescapeFont()) && getSize() > DEFAULT_SIZE)
		{
			graphics.setFont(FontManager.getRunescapeFont());
		}
		else
		{
			graphics.setFont(FontManager.getSmallFont(graphics.getFont()));
		}

		final int baseX = preferredLocation.x;
		final int baseY = preferredLocation.y;

		// Calculate dimensions
		final FontMetrics metrics = graphics.getFontMetrics();
		final int size = getSize();
		final Rectangle bounds = new Rectangle(baseX, baseY, size, size);

		// Render background
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(bounds);
		backgroundComponent.render(graphics);

		// Render image
		graphics.drawImage(
			image,
			baseX + (size - image.getWidth(null)) / 2,
			baseY + (size - image.getHeight(null)) / 2,
			null);

		// Render caption
		if (!Strings.isNullOrEmpty(text))
		{
			final TextComponent textComponent = new TextComponent();
			textComponent.setColor(color);
			textComponent.setText(text);
			textComponent.setPosition(new Point(baseX + ((size - metrics.stringWidth(text)) / 2), baseY + size - metrics.getMaxDescent() - SEPARATOR));
			textComponent.render(graphics);
		}

		this.bounds.setBounds(bounds);
		return bounds.getSize();
	}

	private int getSize()
	{
		return Math.max(preferredSize.width, preferredSize.height);
	}
}
