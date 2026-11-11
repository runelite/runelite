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
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class RectangleUnionTest
{
	private static final int ITERATIONS = 100;
	private static final int WIDTH = 1000;
	private static final int MAX_RECTS = 50;

	@Test
	public void empty()
	{
		Assert.assertNull(RectangleUnion.union(new ArrayList<>()));
	}

	@Test
	public void sharedEdgesAndNestedRectangles()
	{
		assertUnion(Arrays.asList(
			new RectangleUnion.Rectangle(-20, -20, 0, 0),
			new RectangleUnion.Rectangle(0, -20, 20, 0),
			new RectangleUnion.Rectangle(-20, 0, 20, 20),
			new RectangleUnion.Rectangle(-10, -10, 10, 10),
			new RectangleUnion.Rectangle(-20, -20, 0, 0)));
	}

	@Test
	public void disjointRectangles()
	{
		List<RectangleUnion.Rectangle> rects = new ArrayList<>();
		for (int i = 0; i < 256; i++)
		{
			rects.add(new RectangleUnion.Rectangle(i * 3, i * 4 - 512, i * 3 + 2, i * 4 - 510));
		}
		Collections.shuffle(rects, new Random(123));
		assertUnion(rects);
	}

	@Test
	public void hole()
	{
		assertUnion(Arrays.asList(
			new RectangleUnion.Rectangle(0, 0, 30, 10),
			new RectangleUnion.Rectangle(0, 20, 30, 30),
			new RectangleUnion.Rectangle(0, 10, 10, 20),
			new RectangleUnion.Rectangle(20, 10, 30, 20)));
	}

	@Test
	public void zeroWidthAndHeight()
	{
		assertUnion(Arrays.asList(new RectangleUnion.Rectangle(0, 0, 1, 0)));
		assertUnion(Arrays.asList(new RectangleUnion.Rectangle(0, 0, 0, 1)));
		List<RectangleUnion.Rectangle> rects = new ArrayList<>();
		for (int i = 0; i < 200; i++)
		{
			rects.add(new RectangleUnion.Rectangle(i * 2, i * 4, i * 2 + 1, i * 4 + 2));
		}
		rects.add(new RectangleUnion.Rectangle(500, 123, 501, 123));
		rects.add(new RectangleUnion.Rectangle(500, 122, 500, 125));
		rects.add(new RectangleUnion.Rectangle(500, 120, 505, 126));
		assertUnion(rects);
	}

	@Test
	public void randomizedUnions()
	{
		Random random = new Random(0x5eed);
		for (int iteration = 0; iteration < 200; iteration++)
		{
			List<RectangleUnion.Rectangle> rects = new ArrayList<>();
			int count = 1 + random.nextInt(50);
			for (int i = 0; i < count; i++)
			{
				int x = random.nextInt(100) - 50;
				int y = random.nextInt(100) - 50;
				rects.add(new RectangleUnion.Rectangle(x, y, x + 1 + random.nextInt(30), y + 1 + random.nextInt(30)));
			}
			assertUnion(rects);
		}
	}

	private static void assertUnion(List<RectangleUnion.Rectangle> rects)
	{
		Area expected = new Area();
		for (RectangleUnion.Rectangle rect : rects)
		{
			expected.add(new Area(new java.awt.Rectangle(rect.getX1(), rect.getY1(),
				rect.getX2() - rect.getX1(), rect.getY2() - rect.getY1())));
		}
		Area actual = new Area(RectangleUnion.union(new ArrayList<>(rects)));
		expected.exclusiveOr(actual);
		Assert.assertTrue("Rectangle union differs from java.awt.geom.Area", expected.isEmpty());
	}

	// @Test
	public void test() throws IOException
	{
		for (int count = 1; count < MAX_RECTS; count++)
		{
			for (int r = 0; r < ITERATIONS; r++)
			{
				Random rand = new Random(count << 16 | r);
				String id = count + "rects_iteration" + r;
				log.info(id);
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
					log.trace("{}", rect);
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