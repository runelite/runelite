/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
import java.util.function.BiConsumer;
import javax.swing.JPanel;
import lombok.Setter;

public class ColorPanel extends JPanel
{
	private final static int PANEL_WIDTH = 15;

	private final int height;
	private final Color[] gradient;

	private int selectedY = 0;

	// The color which it was changed to, and wether this change was the
	// result of a forced update
	@Setter
	private BiConsumer<Color, Boolean> onColorChange;

	ColorPanel(int height)
	{
		this.height = height;
		this.gradient = new Color[]{
			Color.RED,
			Color.MAGENTA,
			Color.BLUE,
			Color.CYAN,
			Color.GREEN,
			Color.YELLOW,
			Color.RED};

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

	public void select(Color color)
	{
		this.selectedY = closestYToColor(color);

		if (this.onColorChange != null)
		{
			this.onColorChange.accept(colorAt(selectedY), true);
		}

		repaint();
	}

	/**
	 * Moves the selector to a specified y coordinate.
	 */
	private void moveSelector(int y)
	{
		if (y < 0)
		{
			y = 0;
		}

		if (y > height)
		{
			y = height;
		}

		this.selectedY = y;

		if (this.onColorChange != null)
		{
			this.onColorChange.accept(colorAt(selectedY), false);
		}

		repaint();
	}

	/**
	 * Calculates the closest y value to the base color of a given target color.
	 */
	private int closestYToColor(Color target)
	{
		// Check the current gradient for matches before searching
		// through all of the other gradients
		Color currentBase = colorAt(selectedY);

		for (int x = 0; x < height; x++)
		{
			for (int y = 0; y < height; y++)
			{
				Color c = TonePanel.colorAt(currentBase, x, y, height);

				if (c.equals(target))
				{
					return selectedY;
				}
			}
		}

		// Search through all the gradients for the best match
		double minDistance = Double.MAX_VALUE;
		int closestY = height;

		for (int i = 0; i < height; i++)
		{
			Color base = colorAt(i);

			for (int x = 0; x < height; x++)
			{
				for (int y = 0; y < height; y++)
				{
					Color c = TonePanel.colorAt(base, x, y, height);

					if (c.equals(target))
					{
						return i;
					}

					double dv = ColorUtils.colorDistance(c, target);

					if (dv < minDistance)
					{
						minDistance = dv;
						closestY = i;
					}
				}
			}
		}

		return closestY;
	}

	/**
	 * Determines which color is displayed on the gradient on a given y
	 * coordinate.
	 */
	private Color colorAt(int y)
	{
		// The height of each color divison (the different colors of the gradient)
		int divisionHeight = height / (gradient.length - 1);

		// Which section the color is at
		int colorSection = y / divisionHeight;

		// Where inside the section the color is at
		int sectionPosition = y % divisionHeight;

		// The current base color
		Color current = gradient[colorSection];

		// The next base color (the color we should be transitioning to)
		Color next = colorSection < gradient.length - 1 ? gradient[colorSection + 1] : current;

		// The distances (differences) between the current and the target color
		int redDiff = current.getRed() - next.getRed();
		int greenDiff = current.getGreen() - next.getGreen();
		int blueDiff = current.getBlue() - next.getBlue();

		// The differences in colors scaled to the section position
		float redFraction = sectionPosition * (redDiff / divisionHeight);
		float greenFraction = sectionPosition * (greenDiff / divisionHeight);
		float blueFraction = sectionPosition * (blueDiff / divisionHeight);

		int newRed = ColorUtils.limitRGB((int) (current.getRed() - redFraction));
		int newGreen = ColorUtils.limitRGB((int) (current.getGreen() - greenFraction));
		int newBlue = ColorUtils.limitRGB((int) (current.getBlue() - blueFraction));

		return new Color(newRed, newGreen, newBlue);
	}

	@Override
	public void paint(Graphics g)
	{
		// Paint the gradient
		for (int y = 0; y < height; y++)
		{
			g.setColor(colorAt(y));
			g.fillRect(0, y, 30, 1);
		}

		// Paint the selector
		g.setColor(Color.WHITE);
		g.fillRect(0, selectedY - 1, 50, 2);
		g.setColor(Color.BLACK);
		g.drawRect(0, selectedY - 2, 50, 3);
	}
}
