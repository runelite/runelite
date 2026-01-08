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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import lombok.Setter;
import net.runelite.client.ui.overlay.RenderableEntity;

public class TextComponent implements RenderableEntity
{
	private static final Pattern COL_TAG_PATTERN = Pattern.compile("<col=([0-9a-fA-F]{2,6})>");

	@Setter
	private String text;
	private int positionX;
	private int positionY;
	@Setter
	private Color color = Color.WHITE;
	@Setter
	private boolean outline;
	/**
	 * The text font.
	 */
	@Setter
	@Nullable
	private Font font;

	public void setPosition(Point position)
	{
		setPosition(position.x, position.y);
	}

	public void setPosition(int x, int y)
	{
		this.positionX = x;
		this.positionY = y;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Font originalFont = null;
		if (font != null)
		{
			originalFont = graphics.getFont();
			graphics.setFont(font);
		}

		final FontMetrics fontMetrics = graphics.getFontMetrics();

		Matcher matcher = COL_TAG_PATTERN.matcher(text);
		Color textColor = color;
		int idx = 0;
		int width = 0;
		while (matcher.find())
		{
			String color = matcher.group(1);
			String s = text.substring(idx, matcher.start());
			idx = matcher.end();

			renderText(graphics, textColor, positionX + width, positionY, s);
			width += fontMetrics.stringWidth(s);

			textColor = Color.decode("#" + color);
		}

		{
			String s = text.substring(idx);
			renderText(graphics, textColor, positionX + width, positionY, s);
			width += fontMetrics.stringWidth(s);
		}

		int height = fontMetrics.getHeight();

		if (originalFont != null)
		{
			graphics.setFont(originalFont);
		}

		return new Dimension(width, height);
	}

	private void renderText(Graphics2D graphics, Color color, int x, int y, String text)
	{
		if (text.isEmpty())
		{
			return;
		}

		graphics.setColor(Color.BLACK);

		if (outline)
		{
			graphics.drawString(text, x, y + 1);
			graphics.drawString(text, x, y - 1);
			graphics.drawString(text, x + 1, y);
			graphics.drawString(text, x - 1, y);
		}
		else
		{
			// shadow
			graphics.drawString(text, x + 1, y + 1);
		}

		// actual text
		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}
}
