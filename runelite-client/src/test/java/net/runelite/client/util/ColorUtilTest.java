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

import com.google.common.collect.ImmutableMap;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ColorUtilTest
{
	private static final Map<Color, String> COLOR_HEXSTRING_MAP = new ImmutableMap.Builder<Color, String>().
		put(Color.BLACK, "000000").
		put(new Color(0x1), "000001").
		put(new Color(0x100000), "100000").
		put(Color.RED, "ff0000").
		put(Color.GREEN, "00ff00").
		put(Color.BLUE, "0000ff").
		put(new Color(0xA1B2C3), "a1b2c3").
		put(Color.WHITE, "ffffff").build();

	private static final Map<Color, String> COLOR_ALPHA_HEXSTRING_MAP = ImmutableMap.of(
		new Color(0x00000000, true), "00000000",
		new Color(0xA1B2C3D4, true), "a1b2c3d4"
	);

	private static final List<String> INVALID_COLOR_HEXSTRING_LIST = List.of(
		"#ffffffffffffffff",
		"##abcdef",
		"fffffg",
		"0xabcdefg",
		"0x",
		"#",
		"#######",
		"#########",
		""
	);

	@Test
	public void colorTag()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("<col=" + hex + ">", ColorUtil.colorTag(color));
		});
	}

	@Test
	public void prependColorTag()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("<col=" + hex + ">test", ColorUtil.prependColorTag("test", color));
			assertEquals("<col=" + hex + ">", ColorUtil.prependColorTag("", color));
		});

		assertEquals("<col=ff0000>94<col=ffffff>/99", ColorUtil.prependColorTag("94" + ColorUtil.prependColorTag("/99", Color.WHITE), Color.RED));
	}

	@Test
	public void wrapWithColorTag()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("<col=" + hex + ">test</col>", ColorUtil.wrapWithColorTag("test", color));
			assertEquals("<col=" + hex + "></col>", ColorUtil.wrapWithColorTag("", color));
		});
	}

	@Test
	public void toHexColor()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("#" + hex, ColorUtil.toHexColor(color));
		});
	}

	@Test
	public void colorWithAlpha()
	{
		int[] alpha = {73};

		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha[0]),
				ColorUtil.colorWithAlpha(color, alpha[0]));
			alpha[0] += 73;
			alpha[0] %= 255;
		});

		COLOR_ALPHA_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha[0]),
				ColorUtil.colorWithAlpha(color, alpha[0]));
			alpha[0] += 73;
			alpha[0] %= 255;
		});

		COLOR_HEXSTRING_MAP.keySet().forEach((color) ->
		{
			assertEquals(color, ColorUtil.colorWithAlpha(color, 255));
		});
	}

	@Test
	public void colorLerp()
	{
		assertEquals(Color.WHITE, ColorUtil.colorLerp(Color.WHITE, Color.WHITE, 0.9));
		assertEquals(new Color(128, 128, 128), ColorUtil.colorLerp(Color.BLACK, Color.WHITE, 0.5));
		assertEquals(Color.BLACK, ColorUtil.colorLerp(Color.BLACK, Color.CYAN, 0));
		assertEquals(Color.CYAN, ColorUtil.colorLerp(Color.BLACK, Color.CYAN, 1));
		assertEquals(new Color(0x80800080, true), ColorUtil.colorLerp(new Color(0xff0000ff, true), new Color(0x00ff0000, true), 0.5));
	}

	@Test
	public void colorToHexCode()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals(hex, ColorUtil.colorToHexCode(color));
		});
	}

	@Test
	public void colorToAlphaHexCode()
	{
		COLOR_ALPHA_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals(hex, ColorUtil.colorToAlphaHexCode(color));
		});
	}

	@Test
	public void isHex()
	{
		COLOR_HEXSTRING_MAP.values().forEach((hex) ->
		{
			assertTrue(ColorUtil.isHex(hex));
		});

		COLOR_ALPHA_HEXSTRING_MAP.values().forEach((hex) ->
		{
			assertTrue(ColorUtil.isHex(hex));
		});

		INVALID_COLOR_HEXSTRING_LIST.forEach((string) ->
		{
			assertFalse(ColorUtil.isHex(string));
		});
	}

	@Test
	public void isAlphaHex()
	{
		COLOR_ALPHA_HEXSTRING_MAP.values().forEach((hex) ->
		{
			assertTrue(ColorUtil.isAlphaHex(hex));
		});

		COLOR_HEXSTRING_MAP.values().forEach((hex) ->
		{
			assertFalse(ColorUtil.isAlphaHex(hex));
		});

		INVALID_COLOR_HEXSTRING_LIST.forEach((string) ->
		{
			assertFalse(ColorUtil.isAlphaHex(string));
		});
	}

	@Test
	public void fromString()
	{
		String WHITE_MAX_ALPHA = "-1";
		String WHITE_ZERO_ALPHA = "0xffffff";
		String TOO_LARGE = "0xffffffff";
		String INVALID_FORMAT = "ffffff";

		assertEquals(Color.WHITE, ColorUtil.fromString(WHITE_MAX_ALPHA));
		assertEquals(ColorUtil.colorWithAlpha(Color.WHITE, 0), ColorUtil.fromString(WHITE_ZERO_ALPHA));
		assertNotEquals(Color.WHITE, ColorUtil.fromString(WHITE_ZERO_ALPHA));

		assertNull(ColorUtil.fromString(TOO_LARGE));
		assertNull(ColorUtil.fromString(INVALID_FORMAT));
	}

	@Test
	public void fromHex()
	{
		assertEquals(Color.BLACK, ColorUtil.fromHex("0x000000"));
		assertEquals(Color.BLACK, ColorUtil.fromHex("#000000"));
		assertEquals(Color.BLACK, ColorUtil.fromHex("000000"));

		assertEquals(Color.BLACK, ColorUtil.fromHex("0x0"));
		assertEquals(Color.BLACK, ColorUtil.fromHex("#0"));

		assertEquals(ColorUtil.colorWithAlpha(Color.BLACK, 0), ColorUtil.fromHex("0x00000000"));
		assertEquals(Color.WHITE, ColorUtil.fromHex("0xFFFFFFFF"));

		INVALID_COLOR_HEXSTRING_LIST.forEach((string) ->
		{
			assertNull(ColorUtil.fromHex(string));
		});
	}

	@Test
	public void fromObject()
	{
		List<Object> ASSORTED_OBJECTS = List.of("Wise Old Man", 7, true, 1.337, COLOR_ALPHA_HEXSTRING_MAP);
		ASSORTED_OBJECTS.forEach((object) ->
		{
			assertNotNull(ColorUtil.fromObject(object));
		});
	}
}
