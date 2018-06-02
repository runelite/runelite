/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import net.runelite.cache.fs.Store;
import net.runelite.cache.region.Region;
import net.runelite.cache.region.RegionLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeightMapDumper
{
	private static final Logger logger = LoggerFactory.getLogger(HeightMapDumper.class);

	private static final int MAP_SCALE = 1;
	private static final float MAX_HEIGHT = 2048f;

	private final Store store;
	private RegionLoader regionLoader;

	public HeightMapDumper(Store store)
	{
		this.store = store;
	}

	public void load() throws IOException
	{
		regionLoader = new RegionLoader(store);
		regionLoader.loadRegions();
		regionLoader.calculateBounds();
	}

	public BufferedImage drawHeightMap(int z)
	{
		int minX = regionLoader.getLowestX().getBaseX();
		int minY = regionLoader.getLowestY().getBaseY();

		int maxX = regionLoader.getHighestX().getBaseX() + Region.X;
		int maxY = regionLoader.getHighestY().getBaseY() + Region.Y;

		int dimX = maxX - minX;
		int dimY = maxY - minY;

		dimX *= MAP_SCALE;
		dimY *= MAP_SCALE;

		logger.info("Map image dimensions: {}px x {}px, {}px per map square ({} MB)", dimX, dimY, MAP_SCALE, (dimX * dimY / 1024 / 1024));

		BufferedImage image = new BufferedImage(dimX, dimY, BufferedImage.TYPE_INT_RGB);
		draw(image, z);
		return image;
	}

	private void draw(BufferedImage image, int z)
	{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (Region region : regionLoader.getRegions())
		{
			int baseX = region.getBaseX();
			int baseY = region.getBaseY();

			// to pixel X
			int drawBaseX = baseX - regionLoader.getLowestX().getBaseX();

			// to pixel Y. top most y is 0, but the top most
			// region has the greatest y, so invert
			int drawBaseY = regionLoader.getHighestY().getBaseY() - baseY;

			for (int x = 0; x < Region.X; ++x)
			{
				int drawX = drawBaseX + x;

				for (int y = 0; y < Region.Y; ++y)
				{
					int drawY = drawBaseY + (Region.Y - 1 - y);

					int height = region.getTileHeight(z, x, y);
					if (height > max)
					{
						max = height;
					}
					if (height < min)
					{
						min = height;
					}

					int rgb = toColor(height);

					drawMapSquare(image, drawX, drawY, rgb);
				}
			}
		}
		System.out.println("max " + max);
		System.out.println("min " + min);
	}

	private int toColor(int height)
	{
		// height seems to be between -2040 and 0, inclusive
		height = -height;
		// Convert to between 0 and 1
		float color = (float) height / MAX_HEIGHT;

		assert color >= 0.0f && color <= 1.0f;

		return new Color(color, color, color).getRGB();
	}

	private void drawMapSquare(BufferedImage image, int x, int y, int rgb)
	{
		x *= MAP_SCALE;
		y *= MAP_SCALE;

		for (int i = 0; i < MAP_SCALE; ++i)
		{
			for (int j = 0; j < MAP_SCALE; ++j)
			{
				image.setRGB(x + i, y + j, rgb);
			}
		}
	}
}
