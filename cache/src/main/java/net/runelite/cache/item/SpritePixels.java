/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.cache.item;

import java.awt.image.BufferedImage;

class SpritePixels
{
	public int[] pixels;
	public int width;
	public int height;
	public int offsetX;
	int offsetY;

	public SpritePixels(int[] var1, int var2, int var3)
	{
		this.pixels = var1;
		this.width = var2;
		this.height = var3;
		this.offsetY = 0;
		this.offsetX = 0;
	}

	public SpritePixels(int var1, int var2)
	{
		this(new int[var2 * var1], var1, var2);
	}

	public void drawBorder(int color)
	{
		int[] newPixels = new int[this.width * this.height];
		int pixelIndex = 0;

		for (int y = 0; y < this.height; ++y)
		{
			for (int x = 0; x < this.width; ++x)
			{
				int pixel = this.pixels[pixelIndex];
				if (pixel == 0)
				{
					// W
					if (x > 0 && this.pixels[pixelIndex - 1] != 0)
					{
						pixel = color;
					}
					// N
					else if (y > 0 && this.pixels[pixelIndex - this.width] != 0)
					{
						pixel = color;
					}
					// E
					else if (x < this.width - 1 && this.pixels[pixelIndex + 1] != 0)
					{
						pixel = color;
					}
					// S
					else if (y < this.height - 1 && this.pixels[pixelIndex + this.width] != 0)
					{
						pixel = color;
					}
				}

				newPixels[pixelIndex++] = pixel;
			}
		}

		this.pixels = newPixels;
	}


	public void drawShadow(int color)
	{
		for (int y = this.height - 1; y > 0; --y)
		{
			int rowOffset = y * this.width;

			for (int x = this.width - 1; x > 0; --x)
			{
				// if *this* pixel is black/unset AND the pixel to the NW isn't black/unset
				if (this.pixels[x + rowOffset] == 0 && this.pixels[x + rowOffset - 1 - this.width] != 0)
				{
					this.pixels[x + rowOffset] = color;
				}
			}
		}

	}

	public void drawAtOn(Rasterizer2D graphics, int x, int y)
	{
		x += this.offsetX;
		y += this.offsetY;
		int pixelIndex = x + y * graphics.graphicsPixelsWidth;
		int deltaIndex = 0;
		int height = this.height;
		int width = this.width;
		int var7 = graphics.graphicsPixelsWidth - width;
		int var8 = 0;
		if (y < graphics.drawingAreaTop)
		{
			int deltaY = graphics.drawingAreaTop - y;
			height -= deltaY;
			y = graphics.drawingAreaTop;
			deltaIndex += deltaY * width;
			pixelIndex += deltaY * graphics.graphicsPixelsWidth;
		}

		if (height + y > graphics.drawingAreaBottom)
		{
			height -= height + y - graphics.drawingAreaBottom;
		}

		if (x < graphics.draw_region_x)
		{
			int deltaX = graphics.draw_region_x - x;
			width -= deltaX;
			x = graphics.draw_region_x;
			deltaIndex += deltaX;
			pixelIndex += deltaX;
			var8 += deltaX;
			var7 += deltaX;
		}

		if (width + x > graphics.drawingAreaRight)
		{
			int deltaX = width + x - graphics.drawingAreaRight;
			width -= deltaX;
			var8 += deltaX;
			var7 += deltaX;
		}

		if (width > 0 && height > 0)
		{
			method5843(graphics.graphicsPixels, this.pixels, 0, deltaIndex, pixelIndex, width, height, var7, var8);
		}
	}

	static void method5843(int[] rasterizerPixels, int[] spritePixels, int var2, int var3, int pixelIndex, int width, int height, int var7, int var8)
	{
		int var9 = -(width >> 2);
		width = -(width & 3);

		for (int var10 = -height; var10 < 0; ++var10)
		{
			for (int i = var9 * 4; i < 0; ++i)
			{
				var2 = spritePixels[var3++];
				if (var2 != 0)
				{
					rasterizerPixels[pixelIndex++] = var2;
				}
				else
				{
					++pixelIndex;
				}
			}

			for (int i = width; i < 0; ++i)
			{
				var2 = spritePixels[var3++];
				if (var2 != 0)
				{
					rasterizerPixels[pixelIndex++] = var2;
				}
				else
				{
					++pixelIndex;
				}
			}

			pixelIndex += var7;
			var3 += var8;
		}

	}

	public BufferedImage toBufferedImage()
	{
		int[] transPixels = new int[pixels.length];
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < pixels.length; i++)
		{
			if (pixels[i] != 0)
			{
				transPixels[i] = pixels[i] | 0xff000000;
			}
		}

		img.setRGB(0, 0, width, height, transPixels, 0, width);
		return img;
	}

}
