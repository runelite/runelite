/*
 * Copyright (c) 2025, Patrick Watts <https://github.com/pwatts6060>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.puzzlesolver;

import java.awt.Color;

public class HSBGradient
{

	/**
	 * Returns the rgb Color linearly interpolated between the start and end colours provided as a scale
	 * from 0 inclusive to steps exclusive. An index of 0 would be the start colour and
	 * an index of steps-1 would be the end colour. The interpolation converts to HSB colors for
	 * more realistic color interpolation.
	 * @param start The starting color at index 0
	 * @param end The ending color at steps - 1
	 * @param index The index along the interpolation for blending the start and end colours
	 * @param steps The number of steps between the start and end colour
	 * @return The interpolated Color object for the given index
	 */
	public static Color getHSBStep(Color start, Color end, int index, int steps)
	{
		float[] hsbStart = Color.RGBtoHSB(start.getRed(), start.getGreen(), start.getBlue(), null);
		float[] hsbEnd = Color.RGBtoHSB(end.getRed(), end.getGreen(), end.getBlue(), null);

		float ratio = (float) index / (steps - 1);

		// Interpolate each HSB component
		float h = interpolateHue(hsbStart[0], hsbEnd[0], ratio);
		float s = hsbStart[1] + ratio * (hsbEnd[1] - hsbStart[1]);
		float v = hsbStart[2] + ratio * (hsbEnd[2] - hsbStart[2]);

		int rgb = Color.HSBtoRGB(h, s, v);
		return new Color(rgb);
	}

	// Handles hue wrapping (e.g. 0.95 to 0.05 goes the short way around the color wheel)
	private static float interpolateHue(float h1, float h2, float ratio)
	{
		float delta = h2 - h1;

		if (Math.abs(delta) > 0.5f)
		{
			if (delta > 0)
			{
				h1 += 1.0f;
			}
			else
			{
				h2 += 1.0f;
			}
		}

		float h = (h1 + ratio * (h2 - h1)) % 1.0f;
		return h < 0 ? h + 1.0f : h;
	}
}

