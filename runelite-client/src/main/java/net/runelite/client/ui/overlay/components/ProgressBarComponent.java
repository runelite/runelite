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
import java.text.DecimalFormat;
import lombok.Getter;
import lombok.Setter;

public class ProgressBarComponent
{
	@Setter
	private String text;

	@Setter
	private double progress;

	@Setter
	private Point position = new Point();

	@Setter
	private Color foregroundColor = new Color(82, 161, 82);

	@Setter
	private Color backgroundColor = new Color(255, 255, 255, 127);

	@Setter
	private Color fontColor = Color.WHITE;

	@Getter
	@Setter
	private int width = 140;

	@Getter
	@Setter
	private int height = 16;

	public Dimension render(Graphics2D graphics)
	{
		FontMetrics metrics = graphics.getFontMetrics();

		int barX = position.x;
		int barY = position.y;
		String textToWrite;

		if (Strings.isNullOrEmpty(text))
		{
			DecimalFormat df = new DecimalFormat("#0");
			textToWrite = df.format(Math.floor(progress)) + "%";
		}
		else
		{
			textToWrite = text;
		}

		int progressTextX = barX + (width - metrics.stringWidth(textToWrite)) / 2;
		int progressTextY = barY + ((height - metrics.getHeight()) / 2) + metrics.getAscent();

		int progressFill = (int) ((width / 100F) * progress);

		//Draw bar
		graphics.setColor(backgroundColor);
		graphics.fillRect(barX, barY, width, height);
		graphics.setColor(foregroundColor);
		graphics.fillRect(barX, barY, progressFill, height);

		TextComponent textComponent = new TextComponent();
		textComponent.setPosition(new Point(progressTextX, progressTextY));
		textComponent.setColor(fontColor);
		textComponent.setText(textToWrite);
		textComponent.render(graphics);

		return new Dimension(width, height);
	}
}
