/*
 * Copyright (c) 2026, StaySleeping <https://github.com/StaySleeping>
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
package net.runelite.client.ui.overlay;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OverlayUtilTest
{
	private static final int IMAGE_SIZE = 48;
	private static final int ORIGIN = 8;
	private static final int DIAMETER = 26;
	private static final int THICKNESS = 2;

	private static final double CENTER = ORIGIN + DIAMETER / 2.0 - 0.5;
	private static final double RADIUS = DIAMETER / 2.0 - 0.5;

	@Test
	public void pixelRing_isAnnulusAroundOvalFrame()
	{
		BufferedImage image = drawRing();

		int painted = 0;
		for (int y = 0; y < IMAGE_SIZE; y++)
		{
			for (int x = 0; x < IMAGE_SIZE; x++)
			{
				if (image.getRGB(x, y) == 0)
				{
					continue;
				}
				painted++;
				double distance = Math.hypot(x - CENTER, y - CENTER);
				assertTrue("pixel " + x + "," + y + " outside ring band",
					distance > RADIUS - THICKNESS / 2.0 && distance <= RADIUS + THICKNESS / 2.0);
			}
		}
		assertTrue(painted > DIAMETER * 2);
	}

	@Test
	public void pixelRing_isSymmetric()
	{
		BufferedImage image = drawRing();

		for (int y = ORIGIN - THICKNESS; y < ORIGIN + DIAMETER + THICKNESS; y++)
		{
			for (int x = ORIGIN - THICKNESS; x < ORIGIN + DIAMETER + THICKNESS; x++)
			{
				int mirrorX = (int) (2 * CENTER) - x;
				int mirrorY = (int) (2 * CENTER) - y;
				assertEquals("mirror of " + x + "," + y, image.getRGB(x, y), image.getRGB(mirrorX, y));
				assertEquals("mirror of " + x + "," + y, image.getRGB(x, y), image.getRGB(x, mirrorY));
			}
		}
	}

	/**
	 * Arc2D angles: 90 degrees is 12 o'clock and a negative extent runs clockwise, so a
	 * -90 degree extent must only paint the top right quadrant.
	 */
	@Test
	public void pixelArc_clockwiseFromTopFillsTopRightQuadrant()
	{
		BufferedImage image = newImage();
		Graphics2D graphics = createGraphics(image);
		OverlayUtil.drawPixelArc(graphics, ORIGIN, ORIGIN, DIAMETER, THICKNESS, 90, -90);
		graphics.dispose();

		int painted = 0;
		for (int y = 0; y < IMAGE_SIZE; y++)
		{
			for (int x = 0; x < IMAGE_SIZE; x++)
			{
				if (image.getRGB(x, y) == 0)
				{
					continue;
				}
				painted++;
				assertTrue("pixel " + x + "," + y + " outside top right quadrant",
					x >= CENTER - 1 && y <= CENTER + 1);
			}
		}
		assertTrue(painted > DIAMETER / 2);
	}

	private static BufferedImage drawRing()
	{
		BufferedImage image = newImage();
		Graphics2D graphics = createGraphics(image);
		OverlayUtil.drawPixelRing(graphics, ORIGIN, ORIGIN, DIAMETER, THICKNESS);
		graphics.dispose();
		return image;
	}

	private static BufferedImage newImage()
	{
		return new BufferedImage(IMAGE_SIZE, IMAGE_SIZE, BufferedImage.TYPE_INT_ARGB);
	}

	private static Graphics2D createGraphics(BufferedImage image)
	{
		Graphics2D graphics = image.createGraphics();
		OverlayUtil.setGraphicProperties(graphics, false);
		graphics.setColor(Color.WHITE);
		return graphics;
	}
}
