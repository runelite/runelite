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
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import lombok.Setter;
import net.runelite.client.ui.overlay.RenderableEntity;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@Setter
public class TextComponent implements RenderableEntity
{
	private static final String COL_TAG_REGEX = "(<col=([0-9a-fA-F]){2,6}>)";
	private static final Pattern COL_TAG_PATTERN_W_LOOKAHEAD = Pattern.compile("(?=" + COL_TAG_REGEX + ")");

	private String text;
	private Point position = new Point();
	private Color color = Color.WHITE;
	private boolean outline;
	/**
	 * The text font.
	 */
	@Nullable
	private Font font;

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

		if (COL_TAG_PATTERN_W_LOOKAHEAD.matcher(text).find())
		{
			final String[] parts = COL_TAG_PATTERN_W_LOOKAHEAD.split(text);
			int x = position.x;

			for (String textSplitOnCol : parts)
			{
				final String textWithoutCol = Text.removeTags(textSplitOnCol);
				final String colColor = textSplitOnCol.substring(textSplitOnCol.indexOf("=") + 1, textSplitOnCol.indexOf(">"));

				graphics.setColor(Color.BLACK);

				if (outline)
				{
					graphics.drawString(textWithoutCol, x, position.y + 1);
					graphics.drawString(textWithoutCol, x, position.y - 1);
					graphics.drawString(textWithoutCol, x + 1, position.y);
					graphics.drawString(textWithoutCol, x - 1, position.y);
				}
				else
				{
					// shadow
					graphics.drawString(textWithoutCol, x + 1, position.y + 1);
				}

				// actual text
				graphics.setColor(Color.decode("#" + colColor));
				graphics.drawString(textWithoutCol, x, position.y);

				x += fontMetrics.stringWidth(textWithoutCol);
			}
		}
		else
		{
			graphics.setColor(Color.BLACK);

			if (outline)
			{
				graphics.drawString(text, position.x, position.y + 1);
				graphics.drawString(text, position.x, position.y - 1);
				graphics.drawString(text, position.x + 1, position.y);
				graphics.drawString(text, position.x - 1, position.y);
			}
			else
			{
				// shadow
				graphics.drawString(text, position.x + 1, position.y + 1);
			}

			// actual text
			graphics.setColor(ColorUtil.colorWithAlpha(color, 0xFF));
			graphics.drawString(text, position.x, position.y);
		}

		int width = fontMetrics.stringWidth(text);
		int height = fontMetrics.getHeight();

		if (originalFont != null)
		{
			graphics.setFont(originalFont);
		}

		return new Dimension(width, height);
	}
}
