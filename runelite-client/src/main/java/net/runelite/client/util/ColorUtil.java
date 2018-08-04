/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.util;

import java.awt.Color;

public class ColorUtil
{
	private static final String OPENING_COLOR_TAG_START = "<col=";
	private static final String OPENING_COLOR_TAG_END = ">";
	private static final String CLOSING_COLOR_TAG = "</col>";

	/**
	 * Creates a color tag from the given color.
	 *
	 * @param color The Color to create a tag from.
	 * @return      A string of the color tag for the given color.
	 */
	public static String colorTag(Color color)
	{
		return OPENING_COLOR_TAG_START + colorToHexCode(color) + OPENING_COLOR_TAG_END;
	}

	/**
	 * Prepends the given str with an opening color tag of the given color.
	 *
	 * @param str   The string to be colorized.
	 * @param color The color to be used in the color tag.
	 * @return      The passed str with a prepended color tag.
	 */
	public static String prependColorTag(final String str, final Color color)
	{
		return colorTag(color) + str;
	}

	/**
	 * Wraps the given str with a color tag of the given color.
	 *
	 * @param str   The string to be colorized.
	 * @param color The color to be used in the color tag.
	 * @return      The passed str wrapped with opening and closing color tags.
	 */
	public static String wrapWithColorTag(final String str, final Color color)
	{
		return prependColorTag(str, color) + CLOSING_COLOR_TAG;
	}

	/**
	 * Converts a given color to it's hexidecimal equivalent.
	 *
	 * @param color Color to get hexidecimal string from.
	 * @return      Hexidecimal string representing the given color, in the form "#abcdef".
	 */
	public static String toHexColor(final Color color)
	{
		return "#" + colorToHexCode(color);
	}

	/**
	 * Linearly interpolates between colors a and b by t.
	 *
	 * @param a first color
	 * @param b second color
	 * @param t factor
	 * @return  interpolated color
	 */
	public static Color colorLerp(final Color a, final Color b, final double t)
	{
		final double r1 = a.getRed();
		final double r2 = b.getRed();
		final double g1 = a.getGreen();
		final double g2 = b.getGreen();
		final double b1 = a.getBlue();
		final double b2 = b.getBlue();

		return new Color(
			(int) Math.round(r1 + (t * (r2 - r1))),
			(int) Math.round(g1 + (t * (g2 - g1))),
			(int) Math.round(b1 + (t * (b2 - b1)))
		);
	}

	/**
	 * Gets the RGB hex color code of the passed color.
	 *
	 * @param color The color to get a hex code from.
	 * @return      A lower-cased string of the RGB hex code of color.
	 */
	static String colorToHexCode(final Color color)
	{
		return String.format("%06x", color.getRGB() & 0xFFFFFF);
	}

	static boolean isFullyTransparent(final Color color)
	{
		return color.getAlpha() == 0;
	}

	static boolean isNotFullyTransparent(final Color color)
	{
		return !isFullyTransparent(color);
	}
}
