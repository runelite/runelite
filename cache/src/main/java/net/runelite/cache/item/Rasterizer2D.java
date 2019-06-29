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

class Rasterizer2D
{
	public int[] graphicsPixels;
	public int graphicsPixelsWidth;
	public int graphicsPixelsHeight;
	public int drawingAreaTop;
	public int drawingAreaBottom;
	public int draw_region_x;
	protected int drawingAreaRight;

	public void setRasterBuffer(int[] var0, int var1, int var2)
	{
		graphicsPixels = var0;
		graphicsPixelsWidth = var1;
		graphicsPixelsHeight = var2;
		setDrawRegion(0, 0, var1, var2);
	}

	public void setDrawRegion(int var0, int var1, int var2, int var3)
	{
		if (var0 < 0)
		{
			var0 = 0;
		}

		if (var1 < 0)
		{
			var1 = 0;
		}

		if (var2 > graphicsPixelsWidth)
		{
			var2 = graphicsPixelsWidth;
		}

		if (var3 > graphicsPixelsHeight)
		{
			var3 = graphicsPixelsHeight;
		}

		draw_region_x = var0;
		drawingAreaTop = var1;
		drawingAreaRight = var2;
		drawingAreaBottom = var3;
	}

	public void reset()
	{
		int var0 = 0;

		int var1;
		for (var1 = graphicsPixelsWidth * graphicsPixelsHeight - 7; var0 < var1; graphicsPixels[var0++] = 0)
		{
			graphicsPixels[var0++] = 0;
			graphicsPixels[var0++] = 0;
			graphicsPixels[var0++] = 0;
			graphicsPixels[var0++] = 0;
			graphicsPixels[var0++] = 0;
			graphicsPixels[var0++] = 0;
			graphicsPixels[var0++] = 0;
		}

		for (var1 += 7; var0 < var1; graphicsPixels[var0++] = 0)
		{
			;
		}

	}

}