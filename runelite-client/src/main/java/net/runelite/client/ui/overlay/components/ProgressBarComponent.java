/*
 * Copyright (c) 2018, Cameron <moberg@tuta.io>
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
import java.text.DecimalFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
public class ProgressBarComponent implements LayoutableRenderableEntity
{
	public enum LabelDisplayMode
	{
		PERCENTAGE,
		FULL,
		TEXT_ONLY,
		BOTH
	}

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0");
	private static final DecimalFormat DECIMAL_FORMAT_ABS = new DecimalFormat("#0");

	private static final int SIDE_LABEL_OFFSET = 4;

	private long minimum;
	private long maximum = 100;
	private double value;
	private LabelDisplayMode labelDisplayMode = LabelDisplayMode.PERCENTAGE;
	private String centerLabel;
	private String leftLabel;
	private String rightLabel;
	private Color foregroundColor = new Color(82, 161, 82);
	private Color backgroundColor = new Color(255, 255, 255, 127);
	private Color fontColor = Color.WHITE;
	private Point preferredLocation = new Point();
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 16);

	@Getter
	private final Rectangle bounds = new Rectangle();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final FontMetrics metrics = graphics.getFontMetrics();

		final int barX = preferredLocation.x;
		final int barY = preferredLocation.y;

		final long span = maximum - minimum;
		final double currentValue = value - minimum;
		final double pc = currentValue / span;
		String textToWrite;

		switch (labelDisplayMode)
		{
			case TEXT_ONLY:
				textToWrite = "";
				break;
			case PERCENTAGE:
				textToWrite = formatPercentageProgress(pc);
				break;
			case BOTH:
				textToWrite = formatFullProgress(currentValue, maximum) + " (" + formatPercentageProgress(pc) + ")";
				break;
			case FULL:
			default:
				textToWrite = formatFullProgress(currentValue, maximum);
		}

		if (!Strings.isNullOrEmpty(centerLabel))
		{
			if (!textToWrite.isEmpty())
			{
				textToWrite += " ";
			}

			textToWrite += centerLabel;
		}

		final int width = preferredSize.width;
		final int height = Math.max(preferredSize.height, 16);
		final int progressTextX = barX + (width - metrics.stringWidth(textToWrite)) / 2;
		final int progressTextY = barY + ((height - metrics.getHeight()) / 2) + metrics.getHeight();
		final int progressFill = (int) (width * Math.min(1, pc));

		// Draw bar
		graphics.setColor(backgroundColor);
		graphics.fillRect(barX, barY, width, height);
		graphics.setColor(foregroundColor);
		graphics.fillRect(barX, barY, progressFill, height);

		final TextComponent textComponent = new TextComponent();
		textComponent.setPosition(new Point(progressTextX, progressTextY));
		textComponent.setColor(fontColor);
		textComponent.setText(textToWrite);
		textComponent.render(graphics);

		if (leftLabel != null)
		{
			final TextComponent leftTextComponent = new TextComponent();
			leftTextComponent.setPosition(new Point(barX + SIDE_LABEL_OFFSET, progressTextY));
			leftTextComponent.setColor(fontColor);
			leftTextComponent.setText(leftLabel);
			leftTextComponent.render(graphics);
		}

		if (rightLabel != null)
		{
			final TextComponent leftTextComponent = new TextComponent();
			leftTextComponent.setPosition(new Point(barX + width - metrics.stringWidth(rightLabel) - SIDE_LABEL_OFFSET, progressTextY));
			leftTextComponent.setColor(fontColor);
			leftTextComponent.setText(rightLabel);
			leftTextComponent.render(graphics);
		}

		final Dimension dimension = new Dimension(width, height);
		bounds.setLocation(preferredLocation);
		bounds.setSize(dimension);
		return dimension;
	}

	private static String formatFullProgress(double current, long maximum)
	{
		return DECIMAL_FORMAT_ABS.format(Math.floor(current)) + "/" + maximum;
	}

	private static String formatPercentageProgress(double ratio)
	{
		return DECIMAL_FORMAT.format(ratio * 100d) + "%";
	}
}
