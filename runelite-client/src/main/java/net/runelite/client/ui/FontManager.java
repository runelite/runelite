/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.ui;

import com.google.common.collect.ImmutableBiMap;
import java.awt.Canvas;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Map;
import lombok.Getter;
import net.runelite.client.config.FontType;

public class FontManager
{
	private static final Font runescapeFont;
	private static final Font runescapeSmallFont;
	private static final Font runescapeBoldFont;

	@Getter
	private static class CachedFont
	{
		private final Font reg;
		private final Font small;
		private final Font bold;

		private CachedFont(Font f)
		{
			reg = f.deriveFont(14.0f);
			small = getFontOffCorrectSize(f);
			bold = f.deriveFont(Font.BOLD, 14.0f);
		}
	}

	private static final ImmutableBiMap<String, Font> fontMap;
	private static final Map<Font, CachedFont> derivedFontMap = new HashMap<>();

	static
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		try
		{
			runescapeFont = Font.createFont(Font.TRUETYPE_FONT,
				FontManager.class.getResourceAsStream("runescape.ttf"))
				.deriveFont(Font.PLAIN, 16);

			runescapeSmallFont = Font.createFont(Font.TRUETYPE_FONT,
				FontManager.class.getResourceAsStream("runescape_small.ttf"))
				.deriveFont(Font.PLAIN, 16);

			runescapeBoldFont = Font.createFont(Font.TRUETYPE_FONT,
				FontManager.class.getResourceAsStream("runescape_bold.ttf"))
				.deriveFont(Font.PLAIN, 16);

			final LinkedHashMap<String, Font> _fontMap = new LinkedHashMap<>();
			_fontMap.put("Runescape", runescapeFont);

			// Get all available fonts on the system
			Font[] availableFonts = ge.getAllFonts();
			// build bidirectional map
			Arrays.stream(availableFonts).sorted(Comparator.comparing(Font::getFontName)).forEach(f ->
			{
				if (!_fontMap.containsKey(f.getFontName()))
				{
					_fontMap.put(f.getFontName(), f);
				}
			});
			fontMap = ImmutableBiMap.copyOf(_fontMap);

			ge.registerFont(runescapeFont);
			ge.registerFont(runescapeSmallFont);
			ge.registerFont(runescapeBoldFont);
		}
		catch (FontFormatException ex)
		{
			throw new RuntimeException("Font loaded, but format incorrect.", ex);
		}
		catch (IOException ex)
		{
			throw new RuntimeException("Font file not found.", ex);
		}
	}

	private static Font getFontOffCorrectSize(Font f)
	{
		// Size of the font is already set
		if (f.getSize2D() > 1)
		{
			return f;
		}

		// Dummy canvas for font metrics
		Canvas c = new Canvas();

		f = f.deriveFont(12f);
		if (c.getFontMetrics(f).getMaxAscent() > 11)
		{
			f = f.deriveFont(11f);
		}
		return f;
	}

	public static Font getRunescapeFont()
	{
		return runescapeFont;
	}

	public static Font getRunescapeSmallFont()
	{
		return runescapeSmallFont;
	}

	public static Font getRunescapeBoldFont()
	{
		return runescapeBoldFont;
	}

	private static boolean isRunescapeFont(Font f)
	{
		return f.equals(runescapeFont) || f.equals(runescapeSmallFont) || f.equals(runescapeBoldFont);
	}

	public static Font getSmallFont(Font f)
	{
		if (isRunescapeFont(f))
		{
			return runescapeSmallFont;
		}

		if (derivedFontMap.containsKey(f))
		{
			return derivedFontMap.get(f).getSmall();
		}

		// cache and return
		CachedFont cachedFont = new CachedFont(f);
		derivedFontMap.put(f, cachedFont);
		return cachedFont.getSmall();
	}

	public static Font getFontFromType(Font f, FontType type)
	{
		switch (type)
		{
			case SMALL:
				return getSmallFont(f);
			case BOLD:
				if (isRunescapeFont(f))
				{
					return runescapeBoldFont;
				}
				if (derivedFontMap.containsKey(f))
				{
					return derivedFontMap.get(f).getBold();
				}

				// cache and return
				CachedFont cachedBoldFont = new CachedFont(f);
				derivedFontMap.put(f, cachedBoldFont);
				return cachedBoldFont.getBold();
			default: //in this case regular
				if (isRunescapeFont(f))
				{
					return runescapeFont;
				}
				if (derivedFontMap.containsKey(f))
				{
					return derivedFontMap.get(f).getReg();
				}

				// cache and return
				CachedFont cachedFont = new CachedFont(f);
				derivedFontMap.put(f, cachedFont);
				return cachedFont.getReg();
		}
	}

	public static Font lookupFont(String fontName)
	{
		return fontMap.get(fontName);
	}

	public static String getFontName(Font font)
	{
		return fontMap.inverse().get(font);
	}

	public static String[] getAvailableFontNames()
	{
		return fontMap.keySet().toArray(new String[0]);
	}

	public static boolean isAvailable(Font font)
	{
		return fontMap.containsKey(font.getFontName());
	}

	public static Font getFontOrDefault(Font font)
	{
		if (font == null || !fontMap.containsKey(font.getFontName()))
		{
			return getRunescapeFont();
		}
		return getFontOffCorrectSize(font);
	}
}