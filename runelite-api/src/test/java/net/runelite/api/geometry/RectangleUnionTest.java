/*
 * Copyright (c) 2019 Abex
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
package net.runelite.api.geometry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.junit.Test;

public class RectangleUnionTest
{
	private static final int ITERATIONS = 100;
	private static final int WIDTH = 1000;
	private static final int MAX_RECTS = 50;

	@Test
	public void test() throws IOException
	{
		for (int count = 1; count < MAX_RECTS; count++)
		{
			for (int r = 0; r < ITERATIONS; r++)
			{
				Random rand = new Random(count << 16 | r);
				String id = count + "rects_iteration" + r;

				BufferedImage wanted = new BufferedImage(WIDTH, WIDTH, BufferedImage.TYPE_BYTE_BINARY);
				BufferedImage got = new BufferedImage(WIDTH, WIDTH, BufferedImage.TYPE_BYTE_BINARY);

				Graphics2D wg = wanted.createGraphics();
				wg.setColor(Color.WHITE);
				Graphics2D gg = got.createGraphics();
				gg.setColor(Color.WHITE);

				List<RectangleUnion.Rectangle> rects = new ArrayList<>(count);

				for (int i = 0; i < count; i++)
				{
					int x1, y1, x2, y2;

					do
					{
						x1 = rand.nextInt(WIDTH);
						x2 = rand.nextInt(WIDTH);
					}
					while (x1 >= x2);

					do
					{
						y1 = rand.nextInt(WIDTH);
						y2 = rand.nextInt(WIDTH);
					}
					while (y1 >= y2);

					RectangleUnion.Rectangle rect = new RectangleUnion.Rectangle(x1, y1, x2, y2);
					rects.add(rect);

					wg.fillRect(x1, y1, x2 - x1, y2 - y1);
				}

				Shape union = RectangleUnion.union(rects);

				gg.fill(union);

				loop:
				for (int x = 0; x < WIDTH; x++)
				{
					for (int y = 0; y < WIDTH; y++)
					{
						if (wanted.getRGB(x, y) != got.getRGB(x, y))
						{
							File tmp = new File(System.getProperty("java.io.tmpdir"));
							ImageIO.write(wanted, "png", new File(tmp, id + "_wanted.png"));
							ImageIO.write(got, "png", new File(tmp, id + "_got.png"));

							Assert.fail(id);
							break loop;
						}
					}
				}
			}
		}
	}
}