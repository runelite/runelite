/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
public class LineComponent implements LayoutableRenderableEntity
{
	private String left;
	private String right;

	@Builder.Default
	private Color leftColor = Color.WHITE;

	@Builder.Default
	private Color rightColor = Color.WHITE;

	@Builder.Default
	private Point preferredLocation = new Point();

	@Builder.Default
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Builder.Default
	@Getter
	private final Rectangle bounds = new Rectangle();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Prevent NPEs
		final String left = MoreObjects.firstNonNull(this.left, "");
		final String right = MoreObjects.firstNonNull(this.right, "");

		final FontMetrics metrics = graphics.getFontMetrics();
		final int baseX = preferredLocation.x;
		final int baseY = preferredLocation.y + metrics.getHeight();
		int x = baseX;
		int y = baseY;
		final int leftFullWidth = getLineWidth(left, metrics);
		final int rightFullWidth = getLineWidth(right, metrics);

		if (preferredSize.width < leftFullWidth + rightFullWidth)
		{
			int leftSmallWidth = preferredSize.width;
			int rightSmallWidth = 0;

			if (!Strings.isNullOrEmpty(right))
			{
				rightSmallWidth = (preferredSize.width / 3);
				leftSmallWidth -= rightSmallWidth;
			}

			final String[] leftSplitLines = lineBreakText(left, leftSmallWidth, metrics);
			final String[] rightSplitLines = lineBreakText(right, rightSmallWidth, metrics);

			int lineCount = Math.max(leftSplitLines.length, rightSplitLines.length);

			for (int i = 0; i < lineCount; i++)
			{
				String leftText = "";
				String rightText = "";

				if (i < leftSplitLines.length)
				{
					leftText = leftSplitLines[i];
				}

				if (i < rightSplitLines.length)
				{
					rightText = rightSplitLines[i];
				}

				final TextComponent leftLineComponent = new TextComponent();
				leftLineComponent.setPosition(new Point(x, y));
				leftLineComponent.setText(leftText);
				leftLineComponent.setColor(leftColor);
				leftLineComponent.render(graphics);

				final TextComponent rightLineComponent = new TextComponent();
				rightLineComponent.setPosition(new Point(x + leftSmallWidth + rightSmallWidth - getLineWidth(rightText, metrics), y));
				rightLineComponent.setText(rightText);
				rightLineComponent.setColor(rightColor);
				rightLineComponent.render(graphics);
				y += metrics.getHeight();
			}

			final Dimension dimension = new Dimension(preferredSize.width, y - baseY);
			bounds.setLocation(preferredLocation);
			bounds.setSize(dimension);
			return dimension;
		}

		final TextComponent leftLineComponent = new TextComponent();
		leftLineComponent.setPosition(new Point(x, y));
		leftLineComponent.setText(left);
		leftLineComponent.setColor(leftColor);
		leftLineComponent.render(graphics);

		final TextComponent rightLineComponent = new TextComponent();
		rightLineComponent.setPosition(new Point(x + preferredSize.width - getLineWidth(right, metrics), y));
		rightLineComponent.setText(right);
		rightLineComponent.setColor(rightColor);
		rightLineComponent.render(graphics);
		y += metrics.getHeight();

		final Dimension dimension = new Dimension(preferredSize.width, y - baseY);
		bounds.setLocation(preferredLocation);
		bounds.setSize(dimension);
		return dimension;
	}

	private static int getLineWidth(final String line, final FontMetrics metrics)
	{
		return metrics.stringWidth(TextComponent.textWithoutColTags(line));
	}

	private static String[] lineBreakText(String text, int maxWidth, FontMetrics metrics)
	{
		final String[] words = text.split(" ");

		if (words.length == 0)
		{
			return new String[0];
		}

		final StringBuilder wrapped = new StringBuilder(words[0]);
		int spaceLeft = maxWidth - metrics.stringWidth(wrapped.toString());

		for (int i = 1; i < words.length; i++)
		{
			final String word = words[i];
			final int wordLen = metrics.stringWidth(word);
			final int spaceWidth = metrics.stringWidth(" ");

			if (wordLen + spaceWidth > spaceLeft)
			{
				wrapped.append("\n").append(word);
				spaceLeft = maxWidth - wordLen;
			}
			else
			{
				wrapped.append(" ").append(word);
				spaceLeft -= spaceWidth + wordLen;
			}
		}

		return wrapped.toString().split("\n");
	}
}

