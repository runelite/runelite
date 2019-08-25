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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.util.regex.Pattern;
import lombok.Setter;
import net.runelite.client.ui.overlay.RenderableEntity;

@Setter
public class TextComponent implements RenderableEntity
{
	private static final String COL_TAG_REGEX = "(<col=([0-9a-fA-F]){2,6}>)";
	private static final Pattern COL_TAG_PATTERN_W_LOOKAHEAD = Pattern.compile("(?=" + COL_TAG_REGEX + ")");
	private static final Pattern COL_TAG_PATTERN = Pattern.compile(COL_TAG_REGEX);

	private String text;
	private Point position = new Point();
	private Color color = Color.WHITE;
	private Color borderColor = Color.BLACK;

	public static String textWithoutColTags(String text)
	{
		return COL_TAG_PATTERN.matcher(text).replaceAll("");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final FontMetrics fontMetrics = graphics.getFontMetrics();

		if (COL_TAG_PATTERN.matcher(text).find())
		{
			final String[] parts = COL_TAG_PATTERN_W_LOOKAHEAD.split(text);
			int x = position.x;

			for (String textSplitOnCol : parts)
			{
				final String textWithoutCol = textWithoutColTags(textSplitOnCol);
				final String colColor = textSplitOnCol.substring(textSplitOnCol.indexOf('=') + 1, textSplitOnCol.indexOf('>'));

				renderText(graphics, x, position.y, textWithoutCol, Color.decode("#" + colColor), borderColor);

				x += fontMetrics.stringWidth(textWithoutCol);
			}
		}
		else
		{
			renderText(graphics, position.x, position.y, text, color, borderColor);
		}
		return new Dimension(fontMetrics.stringWidth(text), fontMetrics.getHeight());
	}

	private void renderText(Graphics2D graphics, int x, int y, String text, Color color, Color border)
	{
		// remember previous composite
		Composite originalComposite = graphics.getComposite();

		// create a vector of the text
		GlyphVector vector = graphics.getFont().createGlyphVector(graphics.getFontRenderContext(), text);

		// compute the text shape
		Shape stroke = vector.getOutline(x + 1, y + 1);
		Shape shape = vector.getOutline(x, y);

		// draw text border
		graphics.setColor(border);
		graphics.fill(stroke);

		// replace the pixels instead of overlaying
		graphics.setComposite(AlphaComposite.Src);

		// draw actual text
		graphics.setColor(color);
		graphics.fill(shape);

		// reset composite to original
		graphics.setComposite(originalComposite);
	}

}
