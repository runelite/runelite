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
package net.runelite.api;

import java.awt.Color;

public final class JagexColor
{
	public static final int HUE_MAX = 63;
	public static final int SATURATION_MAX = 7;
	public static final int LUMINANCE_MAX = 127;

	public static short packHSL(int hue, int saturation, int luminance)
	{
		return (short) ((short) (hue & HUE_MAX) << 10
				| (short) (saturation & SATURATION_MAX) << 7
				| (short) (luminance & LUMINANCE_MAX));
	}

	public static int unpackHue(short hsl)
	{
		return hsl >> 10 & HUE_MAX;
	}

	public static int unpackSaturation(short hsl)
	{
		return hsl >> 7 & SATURATION_MAX;
	}

	public static int unpackLuminance(short hsl)
	{
		return hsl & LUMINANCE_MAX;
	}

	public static String formatHSL(short hsl)
	{
		return String.format("%02Xh%Xs%02Xl", unpackHue(hsl), unpackSaturation(hsl), unpackLuminance(hsl));
	}

	public static short rgbToHSL(int rgb, double brightness)
	{
		if (rgb == 1)
		{
			return 0;
		}

		brightness = 1.D / brightness;

		double r = (double) (rgb >> 16 & 255) / 256.0D;
		double g = (double) (rgb >> 8 & 255) / 256.0D;
		double b = (double) (rgb & 255) / 256.0D;

		r = Math.pow(r, brightness);
		g = Math.pow(g, brightness);
		b = Math.pow(b, brightness);

		float[] hsv = Color.RGBtoHSB((int) (r * 256.D), (int) (g * 256.D), (int) (b * 256.D), null);
		double hue = hsv[0];
		double luminance = hsv[2] - ((hsv[2] * hsv[1]) / 2.F);
		double saturation = (hsv[2] - luminance) / Math.min(luminance, 1 - luminance);

		return packHSL((int) (Math.ceil(hue * 64.D) % 63.D),
				(int) Math.ceil(saturation * 7.D),
				(int) Math.ceil(luminance * 127.D));
	}
}
