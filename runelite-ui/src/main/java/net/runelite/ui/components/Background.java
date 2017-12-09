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
package net.runelite.ui.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Background extends Component
{
	private static final int BORDER_OFFSET = 2;
	private static final Color BACKGROUND_COLOR = new Color(70, 61, 50, 156);
	private static final Color OUTSIDE_STROKE_COLOR = new Color(56, 48, 35, 255);
	private static final Color INSIDE_STROKE_COLOR = new Color(90, 82, 69, 255);

	@Override
	public void draw(Graphics2D graphics)
	{
		super.draw(graphics);

		// Calculate bounds
		final Rectangle bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());

		// Render background
		graphics.setColor(BACKGROUND_COLOR);
		graphics.fill(bounds);

		// Render outside stroke
		final Rectangle outsideStroke = new Rectangle(bounds);
		outsideStroke.grow(-BORDER_OFFSET / 2,- BORDER_OFFSET / 2);
		graphics.setColor(OUTSIDE_STROKE_COLOR);
		graphics.draw(outsideStroke);

		// Render inside stroke
		final Rectangle insideStroke = new Rectangle(bounds);
		insideStroke.grow(-BORDER_OFFSET, -BORDER_OFFSET);
		graphics.setColor(INSIDE_STROKE_COLOR);
		graphics.draw(insideStroke);
	}
}
