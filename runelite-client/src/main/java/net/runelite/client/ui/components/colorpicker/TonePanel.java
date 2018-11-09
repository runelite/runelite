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
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.function.Consumer;
import javax.swing.JPanel;
import lombok.Setter;

public class TonePanel extends JPanel
{
	// The radius of the selector target
	private static final int SELECTOR_SIZE = 7;

	private final int size;

	private Point targetPosition;
	private Color baseColor;
	@Setter
	private Consumer<Color> onColorChange;

	TonePanel(int size)
	{
		this.size = size;
		this.targetPosition = new Point(size, 0);
		setPreferredSize(new Dimension(size, size));

		addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent me)
			{
				moveTarget(me.getX(), me.getY());
			}
		});

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent me)
			{
				moveTarget(me.getX(), me.getY());
			}

			@Override
			public void mousePressed(MouseEvent me)
			{
				moveTarget(me.getX(), me.getY());
			}
		});
	}

	/*
	 * Sets the gradient's base color (top-right) to a specified color.
	 *
	 * If this method isn't called as a result of a forced update, then it will
	 * call the onColorChange event.
	 */
	void setBaseColor(Color baseColor, boolean forceUpdate)
	{
		this.baseColor = baseColor;

		if (!forceUpdate && onColorChange != null)
		{
			onColorChange.accept(colorAt(baseColor, targetPosition.x, targetPosition.y, size));
		}

		repaint();
	}

	public void select(Color color)
	{
		Point closest = closestPointToColor(color);
		moveTarget(closest.x, closest.y);
	}

	/*
	 * Calculates the closest point to a given color.
	 *
	 * It iterates through all the colors in the gradient and finds the nearest
	 * match to the target color.
	 */
	private Point closestPointToColor(Color target)
	{
		double minDistance = Double.MAX_VALUE;
		Point closest = new Point(0, 0);

		for (int x = 0; x < size + 1; x++)
		{
			for (int y = 0; y < size + 1; y++)
			{
				Color c = colorAt(baseColor, x, y, size);

				if (c.equals(target))
				{
					return new Point(x, y);
				}

				double dv = ColorUtils.colorDistance(c, target);

				if (dv < minDistance)
				{
					minDistance = dv;
					closest = new Point(x, y);
				}
			}
		}

		return closest;
	}

	/**
	 * Moves the target (selector) to a specified x,y coordinates.
	 */
	private void moveTarget(int x, int y)
	{
		if (x > size)
		{
			x = size;
		}

		if (x < 0)
		{
			x = 0;
		}

		if (y > size)
		{
			y = size;
		}

		if (y < 0)
		{
			y = 0;
		}

		targetPosition = new Point(x, y);

		if (onColorChange != null)
		{
			onColorChange.accept(colorAt(baseColor, x, y, size));
		}

		repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		// Paint the gradient
		for (int x = 0; x < size; x++)
		{
			for (int y = 0; y < size; y++)
			{
				g.setColor(colorAt(baseColor, x, y, size));
				g.fillRect(x, y, 1, 1);
			}
		}

		int targetX = targetPosition.x - (SELECTOR_SIZE / 2);
		int targetY = targetPosition.y - (SELECTOR_SIZE / 2);

		// Paint the target (selector)
		g.setColor(Color.WHITE);
		g.fillOval(targetX, targetY, SELECTOR_SIZE, SELECTOR_SIZE);
		g.setColor(Color.BLACK);
		g.drawOval(targetX, targetY, SELECTOR_SIZE, SELECTOR_SIZE);
	}

	/*
	 * Determines which color is displayed on the gradient on given coordinates.
	 */
	static Color colorAt(Color baseColor, int x, int y, int size)
	{
		int red = baseColor.getRed();
		int green = baseColor.getGreen();
		int blue = baseColor.getBlue();

		// Force the brightest color to be white
		if (x == 0 && y == 0)
		{
			return Color.WHITE;
		}

		// Force the darkest color to be white
		if (y > size - 1)
		{
			return Color.BLACK;
		}

		// The scaling factor (if == 1, then 1 px for every color value difference)
		float yScale = ((float) 255 / size);

		// The brightness difference, the higher the Y, the darker the color
		// should be. This value will be deducted from the r g b values to make
		// the gradient fade into dark
		float yDiff = y * yScale;

		// The distances (differences) between the maximum and the target values
		float redDiff = 255 - red;
		float greenDiff = 255 - green;
		float blueDiff = 255 - blue;

		// The differences in color values, adjusted for the x position in the gradient
		float gRed = 255 - (x * (redDiff / size));
		float gGreen = 255 - (x * (greenDiff / size));
		float gBlue = 255 - (x * (blueDiff / size));

		// The final rgb values adjusted for the x and y positions
		int newRed = ColorUtils.limitRGB((int) (gRed - (yDiff)));
		int newGreen = ColorUtils.limitRGB((int) (gGreen - (yDiff)));
		int newBlue = ColorUtils.limitRGB((int) (gBlue - (yDiff)));

		return new Color(newRed, newGreen, newBlue);
	}
}
