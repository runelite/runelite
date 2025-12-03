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

import com.google.common.annotations.VisibleForTesting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.regex.Pattern;
import lombok.Setter;
import net.runelite.api.IndexedSprite;

@Setter
public class TooltipComponent implements LayoutableRenderableEntity
{
	private static final Pattern BR = Pattern.compile("</?br>");
	private static final int OFFSET = 4;
	private static final int MOD_ICON_WIDTH = 13; // they are generally 13px wide

	private String text;
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;
	private Point position = new Point();
	private IndexedSprite[] modIcons;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Tooltip size
		final FontMetrics metrics = graphics.getFontMetrics();
		final int textDescent = metrics.getDescent();
		final int textHeight = metrics.getHeight();
		int tooltipWidth = 0;
		int tooltipHeight = 0;
		String[] lines = BR.split(text);

		// Calculate tooltip size
		for (String line : lines)
		{
			int textWidth = calculateTextWidth(metrics, line);

			if (textWidth > tooltipWidth)
			{
				tooltipWidth = textWidth;
			}

			tooltipHeight += textHeight;
		}

		// Tooltip position
		int x = position.x;
		int y = position.y;

		// Render tooltip - background
		final Rectangle tooltipBackground = new Rectangle(x, y,
			tooltipWidth + OFFSET * 2, tooltipHeight + OFFSET * 2);
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(tooltipBackground);
		backgroundComponent.render(graphics);
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
			char[] chars = line.toCharArray();

			int begin = 0;
			boolean inTag = false;
			for (int j = 0; j < chars.length; j++)
			{
				if (chars[j] == '<')
				{
					TextComponent textComponent = new TextComponent();
					textComponent.setColor(nextColor);
					String text = line.substring(begin, j);
					textComponent.setText(text);
					textComponent.setPosition(lineX, textY + (i + 1) * textHeight - textDescent);
					textComponent.render(graphics);

					lineX += metrics.stringWidth(text);

					begin = j;
					inTag = true;
				}
				else if (chars[j] == '>' && inTag)
				{
					String subLine = line.substring(begin + 1, j);

					if (subLine.startsWith("col="))
					{
						String argument = subLine.substring(4);
						nextColor = Color.decode("#" + argument);
					}
					else if (subLine.equals("/col"))
					{
						nextColor = Color.WHITE;
					}
					else if (subLine.startsWith("img="))
					{
						if (modIcons != null)
						{
							String argument = subLine.substring(4);
							int iconId = Integer.parseInt(argument);
							IndexedSprite modIcon = modIcons[iconId];
							renderModIcon(graphics, lineX, textY + i * textHeight - textDescent, modIcon);
							lineX += modIcon.getWidth();
						}
					}
					else
					{
						TextComponent textComponent = new TextComponent();
						textComponent.setColor(nextColor);
						String text = line.substring(begin, j + 1);
						textComponent.setText(text);
						textComponent.setPosition(lineX, textY + (i + 1) * textHeight - textDescent);
						textComponent.render(graphics);

						lineX += metrics.stringWidth(text);
					}

					begin = j + 1;
					inTag = false;
				}
			}

			// Draw trailing text (after last tag)
			final TextComponent textComponent = new TextComponent();
			textComponent.setColor(nextColor);
			textComponent.setText(line.substring(begin));
			textComponent.setPosition(lineX, textY + (i + 1) * textHeight - textDescent);
			textComponent.render(graphics);
		}

		return new Dimension(tooltipWidth + OFFSET * 2, tooltipHeight + OFFSET * 2);
	}

	@VisibleForTesting
	static int calculateTextWidth(FontMetrics metrics, String line)
	{
		char[] chars = line.toCharArray();
		int textWidth = 0;

		int begin = 0;
		boolean inTag = false;
		for (int j = 0; j < chars.length; j++)
		{
			if (chars[j] == '<')
			{
				textWidth += metrics.stringWidth(line.substring(begin, j));

				begin = j;
				inTag = true;
			}
			else if (chars[j] == '>' && inTag)
			{
				String subLine = line.substring(begin + 1, j);

				if (subLine.startsWith("img="))
				{
					textWidth += MOD_ICON_WIDTH;
				}
				else if (!subLine.startsWith("col=") && !subLine.startsWith("/col"))
				{
					textWidth += metrics.stringWidth(line.substring(begin, j + 1));
				}

				begin = j + 1;
				inTag = false;
			}
		}

		// Include trailing text (after last tag)
		textWidth += metrics.stringWidth(line.substring(begin));

		return textWidth;
	}

	private void renderModIcon(Graphics2D graphics, int x, int y, IndexedSprite modIcon)
	{
		int sourceOffset = 0;

		for (int y2 = 0; y2 < modIcon.getHeight(); y2++)
		{
			for (int x2 = 0; x2 < modIcon.getWidth(); x2++)
			{
				int index = modIcon.getPixels()[sourceOffset++] & 0xff;

				if (index != 0)
				{
					graphics.setColor(new Color(modIcon.getPalette()[index]));
					graphics.drawLine(x + x2, y + y2, x + x2, y + y2);
				}
			}
		}
	}

	@Override
	public Rectangle getBounds()
	{
		return null;
	}

	@Override
	public void setPreferredLocation(Point position)
	{
		this.position = position;
	}

	@Override
	public void setPreferredSize(Dimension dimension)
	{
	}
}
