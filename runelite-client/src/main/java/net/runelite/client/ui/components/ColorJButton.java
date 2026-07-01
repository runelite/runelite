/*
 * Copyright (c) 2020, Martin H <pilino@posteo.de>
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
package net.runelite.client.ui.components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import lombok.Getter;

public class ColorJButton extends JButton
{
	private static final int ALPHA_TEXT_CUTOFF = 120;
	private static final int CHECKER_SIZE = 10;

	@Getter
	private Color color;

	public ColorJButton(String text, Color color)
	{
		super(text);

		// Tell ButtonUI to not paint the background, we do it ourselves.
		this.setContentAreaFilled(false);

		setColor(color);
	}

	public void setColor(Color color)
	{
		this.color = color;

		// Use perceptive luminance to choose a readable font color
		// Based on https://stackoverflow.com/a/1855903
		double lum = (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue()) / 255;

		final Color textColor;

		if (lum > 0.5 || color.getAlpha() < ALPHA_TEXT_CUTOFF)
		{
			textColor = Color.BLACK;
		}
		else
		{
			textColor = Color.WHITE;
		}

		this.setForeground(textColor);
	}

	@Override
	public void paint(Graphics g)
	{
		if (this.color.getAlpha() != 255)
		{
			for (int x = 0; x < this.getWidth(); x += CHECKER_SIZE)
			{
				for (int y = 0; y < this.getHeight(); y += CHECKER_SIZE)
				{
					int val = (x / CHECKER_SIZE + y / CHECKER_SIZE) % 2;
					g.setColor(val == 0 ? Color.LIGHT_GRAY : Color.WHITE);
					g.fillRect(x, y, CHECKER_SIZE, CHECKER_SIZE);
				}
			}
		}

		g.setColor(this.color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		super.paint(g);
	}
}
