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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Setter;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.RenderableEntity;

public class TooltipComponent implements RenderableEntity
{
	private static final Pattern COLOR_SPLIT = Pattern.compile("<\\/?col=?([^>]+)?>");
	private static final Pattern BR = Pattern.compile("</br>");
	private static final int OFFSET = 4;

	@Setter
	private String text;

	@Setter
	private Color backgroundColor = BackgroundComponent.DEFAULT_BACKGROUND_COLOR;

	@Setter
	private Point position = new Point();

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		graphics.setFont(FontManager.getRunescapeSmallFont());

		// Tooltip size
		final FontMetrics metrics = graphics.getFontMetrics();
		final int textDescent = metrics.getDescent();
		final int textHeight = graphics.getFontMetrics().getHeight();
		int tooltipWidth = 0;
		int tooltipHeight = 0;
		String[] lines = BR.split(text);

		for (String line : lines)
		{
			String lineClean = COLOR_SPLIT.matcher(line).replaceAll("");
			int textWidth = graphics.getFontMetrics().stringWidth(lineClean);
			if (textWidth > tooltipWidth)
			{
				tooltipWidth = textWidth;
			}

			tooltipHeight += textHeight;
		}

		// Tooltip position
		int x = position.x;
		int y = position.y;
		x = x - tooltipWidth - OFFSET * 2;
		if (x < 0)
		{
			x = 0;
		}

		y = y - tooltipHeight - OFFSET * 2;
		if (y < 0)
		{
			y = 0;
		}

		// Render tooltip - background
		final Rectangle tooltipBackground = new Rectangle(x, y,
			tooltipWidth + OFFSET * 2, tooltipHeight + OFFSET * 2);
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(tooltipBackground);
		backgroundComponent.render(graphics, parent);
		graphics.setColor(Color.WHITE);

		// Render tooltip - text - line by line
		int textX = x + OFFSET;
		int textY = y + OFFSET;
		int lineX;
		Color nextColor = Color.WHITE;
		for (int i = 0; i < lines.length; i++)
		{
			lineX = textX;
			final String line = lines[i];
			final Matcher m = COLOR_SPLIT.matcher(line);

			int begin = 0;
			while (m.find())
			{
				// Draw text prior to color tag
				String preText = line.substring(begin, m.start());
				final TextComponent textComponent = new TextComponent();
				textComponent.setText(preText);
				textComponent.setPosition(new Point(lineX, textY + (i + 1) * textHeight - textDescent));
				textComponent.setColor(nextColor);
				textComponent.render(graphics, parent);

				// Set color for next text part
				if (m.group(1) == null)
				{
					// no color tag
					nextColor = Color.WHITE;
				}
				else
				{
					// color tag
					nextColor = Color.decode("#" + m.group(1));
				}
				begin = m.end();
				lineX += metrics.stringWidth(preText);
			}

			// Draw trailing text (after last tag)
			final TextComponent textComponent = new TextComponent();
			textComponent.setText(line.substring(begin, line.length()));
			textComponent.setPosition(new Point(lineX, textY + (i + 1) * textHeight - textDescent));
			textComponent.setColor(nextColor);
			textComponent.render(graphics, parent);
		}


		return new Dimension(tooltipWidth + OFFSET * 2, tooltipHeight + OFFSET * 2);
	}
}
