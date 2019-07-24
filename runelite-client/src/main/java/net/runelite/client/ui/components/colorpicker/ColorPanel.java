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
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;
import javax.swing.JPanel;
import lombok.Setter;
import net.runelite.client.util.MiscUtils;

public class ColorPanel extends JPanel
{
	private static final int SELECTOR_RADIUS = 7;

	private final int size;

	private final BufferedImage image;
	private Point targetPosition;
	private int selectedY;
	private boolean forceRedraw;

	@Setter
	private Consumer<Color> onColorChange;

	ColorPanel(int size)
	{
		this.size = size;
		this.image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		this.targetPosition = new Point(size, 0);
		setPreferredSize(new Dimension(size, size));

		addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent me)
			{
				moveTarget(me.getX(), me.getY(), true);
			}
		});

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent me)
			{
				moveTarget(me.getX(), me.getY(), true);
			}

			@Override
			public void mousePressed(MouseEvent me)
			{
				moveTarget(me.getX(), me.getY(), true);
			}
		});
	}

	/*
	 * Sets the gradient's base hue index.
	 */
	void setBaseColor(int selectedY)
	{
		if (this.selectedY == selectedY)
		{
			return;
		}

		this.selectedY = selectedY;
		redrawGradient();

		if (onColorChange != null)
		{
			onColorChange.accept(colorAt(targetPosition.x, targetPosition.y));
		}

		paintImmediately(0, 0, size, size);
	}

	/*
	 * Move the indicator to the closest color without firing change event.
	 */
	void moveToClosestColor(int y, Color color)
	{
		Point closest = closestPointToColor(color);
		if (this.selectedY == y && closest.x == targetPosition.x && closest.y == targetPosition.y)
		{
			return;
		}

		this.selectedY = y;
		redrawGradient();
		moveTarget(closest.x, closest.y, false);
	}

	/*
	 * Calculates the closest point to a given color.
	 */
	private Point closestPointToColor(Color target)
	{
		float[] hsb = Color.RGBtoHSB(target.getRed(), target.getGreen(), target.getBlue(), null);
		int offSize = size - 1;

		return new Point((int) (hsb[1] * offSize), offSize - (int) (hsb[2] * offSize));
	}

	/**
	 * Moves the target (selector) to a specified x,y coordinates.
	 */
	private void moveTarget(int x, int y, boolean shouldUpdate)
	{
		if (targetPosition.x == x && targetPosition.y == y && !forceRedraw)
		{
			return;
		}

		x = MiscUtils.clamp(x, 0, size - 1);
		y = MiscUtils.clamp(y, 0, size - 1);

		targetPosition = new Point(x, y);
		paintImmediately(0, 0, size, size);

		if (onColorChange != null && shouldUpdate)
		{
			onColorChange.accept(colorAt(x, y));
		}
		forceRedraw = false;
	}

	@Override
	public void paint(Graphics g)
	{
		// Paint the gradient
		g.drawImage(this.image, 0, 0, null);

		int targetX = targetPosition.x - (SELECTOR_RADIUS / 2);
		int targetY = targetPosition.y - (SELECTOR_RADIUS / 2);

		// Paint the target (selector)
		g.setColor(Color.WHITE);
		g.fillOval(targetX, targetY, SELECTOR_RADIUS, SELECTOR_RADIUS);
		g.setColor(Color.BLACK);
		g.drawOval(targetX, targetY, SELECTOR_RADIUS, SELECTOR_RADIUS);
	}

	/*
	 * Draws a 3-color gradient based on white, black, and current hue index.
	 */
	private void redrawGradient()
	{
		Color primaryRight = Color.getHSBColor(1f - this.selectedY / (float) (size - 1), 1, 1);
		Graphics2D g = image.createGraphics();
		GradientPaint primary = new GradientPaint(
			0f, 0f, Color.WHITE,
			size - 1, 0f, primaryRight);
		GradientPaint shade = new GradientPaint(
			0f, 0f, new Color(0, 0, 0, 0),
			0f, size - 1, Color.BLACK);
		g.setPaint(primary);
		g.fillRect(0, 0, size, size);
		g.setPaint(shade);
		g.fillRect(0, 0, size, size);

		g.dispose();
		forceRedraw = true;
	}

	/*
	 * Determines which color is displayed on the gradient at x,y.
	 */
	private Color colorAt(int x, int y)
	{
		x = MiscUtils.clamp(x, 0, size - 1);
		y = MiscUtils.clamp(y, 0, size - 1);
		return new Color(image.getRGB(x, y));
	}
}
