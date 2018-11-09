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

class ColorUtils
{
	static final int MAX_RGB_VALUE = 255;
	static final int MIN_RGB_VALUE = 0;

	/**
	 * Limits an int to the rgb value range (0-255)
	 */
	static int limitRGB(int value)
	{
		if (value < MIN_RGB_VALUE)
		{
			return MIN_RGB_VALUE;
		}

		if (value > MAX_RGB_VALUE)
		{
			return MAX_RGB_VALUE;
		}

		return value;
	}

	/**
	 * Calculates the distance between two color objects' values.
	 */
	static double colorDistance(Color a, Color b)
	{
		int redDistance = a.getRed() - b.getRed();
		int greenDistance = a.getGreen() - b.getGreen();
		int blueDistance = a.getBlue() - b.getBlue();
		return Math.sqrt(redDistance * redDistance
			+ greenDistance * greenDistance
			+ blueDistance * blueDistance);
	}

	static String getRGB(Color c)
	{
		return c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + ", " + c.getAlpha();
	}

	static String getHex(Color c)
	{
		return String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
	}
}
