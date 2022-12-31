/*
 * Copyright (c) 2022 Abex
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
package net.runelite.api;

/**
 * Jagex 2D and 3D drawing utilities.
 * Similar to AWT's {@link java.awt.Graphics2D}
 *
 * @see JagexColor
 */
public interface Rasterizer
{
	/**
	 * Gets the back buffer of the rasterizer
	 *
	 * ARGB or RGB depending on {@link Client#isGpu()}
	 */
	int[] getPixels();

	/**
	 * Width of {@link #getPixels()}
	 */
	int getWidth();

	/**
	 * Height of {@link #getPixels()}
	 */
	int getHeight();


	/**
	 * Draws a filled rectangle onto the rasterizer buffer at full opacity
	 */
	void fillRectangle(int x, int y, int w, int h, int rgb);

	/**
	 * Draws a filled triangle onto the rasterizer buffer at rasterizer opacity
	 */
	void rasterFlat(int y0, int y1, int y2, int x0, int x1, int x2, int rgb);


	/**
	 * Sets if {@link #rasterGouraud} uses a faster shading algorithm
	 */
	void setRasterGouraudLowRes(boolean lowRes);

	/**
	 * Draws a gouraud shaded filled triangle onto the rasterizer buffer at rasterizer opacity
	 */
	void rasterGouraud(int y0, int y1, int y2, int x0, int x1, int x2, int hsl0, int hsl1, int hsl2);
}
