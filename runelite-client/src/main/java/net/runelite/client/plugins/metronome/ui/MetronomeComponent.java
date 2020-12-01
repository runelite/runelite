/*
 * Copyright (c) 2020, Adam Davies <https://github.com/acdvs>
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
package net.runelite.client.plugins.metronome.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import lombok.Setter;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class MetronomeComponent extends PanelComponent
{
	private static final int BORDER_OFFSET = 2;
	private static final float COLOR_OFFSET = 0.2f;
	private static final float OUTER_COLOR_OFFSET = 1 - COLOR_OFFSET;
	private static final float INNER_COLOR_OFFSET = 1 + COLOR_OFFSET;
	private static final float ALPHA_COLOR_OFFSET = 1 + 2 * COLOR_OFFSET;

	private static final int BASE_X = 0;
	private static final int BASE_Y = 0;

	@Setter
	private int diameter = 50;

	@Setter
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Color outsideStrokeColor = new Color(
			(int) (backgroundColor.getRed() * OUTER_COLOR_OFFSET),
			(int) (backgroundColor.getGreen() * OUTER_COLOR_OFFSET),
			(int) (backgroundColor.getBlue() * OUTER_COLOR_OFFSET),
			Math.min(255, (int) (backgroundColor.getAlpha() * ALPHA_COLOR_OFFSET))
		);

		Color insideStrokeColor = new Color(
			Math.min(255, (int) (backgroundColor.getRed() * INNER_COLOR_OFFSET)),
			Math.min(255, (int) (backgroundColor.getGreen() * INNER_COLOR_OFFSET)),
			Math.min(255, (int) (backgroundColor.getBlue() * INNER_COLOR_OFFSET)),
			Math.min(255, (int) (backgroundColor.getAlpha() * ALPHA_COLOR_OFFSET))
		);

		// Render background
		graphics.setColor(backgroundColor);
		graphics.fillOval(BASE_X, BASE_Y, diameter, diameter);

		// Render outside stroke
		graphics.setColor(outsideStrokeColor);
		graphics.drawOval(BASE_X, BASE_Y, diameter - BORDER_OFFSET / 2, diameter - BORDER_OFFSET / 2);

		// Render inside stroke
		graphics.setColor(insideStrokeColor);
		graphics.drawOval(BASE_X + BORDER_OFFSET / 2, BASE_Y + BORDER_OFFSET / 2,
			diameter - BORDER_OFFSET - BORDER_OFFSET / 2,
			diameter - BORDER_OFFSET - BORDER_OFFSET / 2);

		return new Dimension(diameter, diameter);
	}
}
