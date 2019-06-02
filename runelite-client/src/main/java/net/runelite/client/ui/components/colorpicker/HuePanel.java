/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.ui.components.colorpicker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.function.Consumer;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.util.MiscUtils;

public class HuePanel extends JPanel
{
	private static final int PANEL_WIDTH = 15;
	private static final int KNOB_HEIGHT = 4;

	private final int height;

	@Getter
	private int selectedY;

	@Setter
	private Consumer<Integer> onColorChange;

	HuePanel(int height)
	{
		this.height = height;
		setPreferredSize(new Dimension(PANEL_WIDTH, height));

		addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent me)
			{
				moveSelector(me.getY());
			}
		});

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent me)
			{
				moveSelector(me.getY());
			}

			@Override
			public void mousePressed(MouseEvent me)
			{
				moveSelector(me.getY());
			}
		});
	}

	/**
	 * Repaint slider with closest guess for y value on slider.
	 */
	public void select(Color color)
	{
		this.selectedY = closestYToColor(color);
		paintImmediately(0, 0, PANEL_WIDTH, height);
	}

	/**
	 * Moves the selector to a specified y coordinate.
	 */
	private void moveSelector(int y)
	{
		y = MiscUtils.clamp(y, 0, height - 1);
		if (y == this.selectedY)
		{
			return;
		}

		this.selectedY = y;
		paintImmediately(0, 0, PANEL_WIDTH, height);
		if (this.onColorChange != null)
		{
			this.onColorChange.accept(y);
		}
	}

	/**
	 * Calculates a close y value for the given target color.
	 */
	private int closestYToColor(Color target)
	{
		float[] hsb = Color.RGBtoHSB(target.getRed(), target.getGreen(), target.getBlue(), null);
		float hue = hsb[0];

		int offHeight = height - 1;

		return Math.round(offHeight - hue * offHeight);
	}

	@Override
	public void paint(Graphics g)
	{
		// Paint the gradient
		for (int y = 0; y < height; y++)
		{
			g.setColor(colorAt(y));
			g.fillRect(0, y, PANEL_WIDTH, 1);
		}

		final int halfKnob = KNOB_HEIGHT / 2;

		// Paint the selector
		g.setColor(Color.WHITE);
		g.fillRect(0, selectedY - 1, PANEL_WIDTH, KNOB_HEIGHT);
		g.setColor(Color.BLACK);
		g.drawLine(0, selectedY - halfKnob, PANEL_WIDTH, selectedY - halfKnob);
		g.drawLine(0, selectedY + halfKnob, PANEL_WIDTH, selectedY + halfKnob);
	}

	/**
	 * Calculate hue color for current hue index.
	 */
	private Color colorAt(int y)
	{
		return Color.getHSBColor(1 - (float) y / (height - 1), 1, 1);
	}
}
