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

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

public class FontManager
{
	private static final Font runescapeFont;
	private static final Font runescapeSmallFont;
	private static final Font runescapeBoldFont;

	// By using a 2way map we're not dependant on the toString() method so we have control over the font naming in the UI.
	private static final HashMap<String, Font> fontLookupMap;
	// By using a linkedHashMap we decide the order in which the fonts a re represented which allows more intuitive ordering, i couldn't get ordering to swork with guave bimaps
	private static final LinkedHashMap<Font, String> fontMap;

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

			fontMap = new LinkedHashMap<>();
			fontLookupMap = new HashMap<>();

			fontMap.put(runescapeSmallFont, "rs small");
			fontMap.put(runescapeFont, "rs default");
			fontMap.put(runescapeBoldFont, "rs bold");
			fontMap.forEach((k, v) -> fontLookupMap.put(v, k));

			// Get all available fonts on the system
			Font[] availableFonts = ge.getAllFonts();
			//build bidirectional map
			Arrays.stream(availableFonts).sorted(Comparator.comparing(Font::getFontName)).forEach(f ->
			{
				if (!fontLookupMap.containsKey(f.getFontName()) && !fontMap.containsKey(f))
				{
					// I believe font size 11 or 12 is for many fonts about the same size as font size 16 for the rs fonts
					f = f.deriveFont(11f);
					fontMap.put(f, f.getFontName());
					fontLookupMap.put(f.getFontName(), f);
				}
			});
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

	public static LinkedHashMap<Font, String> getFontMap()
	{
		return fontMap;
	}

	public static Font lookupFont(String fontName)
	{
		return fontLookupMap.get(fontName);
	}
}
