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

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.text.StyleContext;

public class FontManager
{
	private static final Font runescapeFont;
	private static final Font runescapeSmallFont;
	private static final Font runescapeBoldFont;

	static
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		try
		{
			Font font;

			try (InputStream runescapeIn = FontManager.class.getResourceAsStream("runescape.ttf"))
			{
				font = Font.createFont(Font.TRUETYPE_FONT,
					runescapeIn)
					.deriveFont(Font.PLAIN, 16);
				ge.registerFont(font);
			}

			runescapeFont = StyleContext.getDefaultStyleContext()
				.getFont(font.getName(), Font.PLAIN, 16);
			ge.registerFont(runescapeFont);

			try (InputStream smallIn = FontManager.class.getResourceAsStream("runescape_small.ttf"))
			{
				font = Font.createFont(Font.TRUETYPE_FONT,
					smallIn)
					.deriveFont(Font.PLAIN, 16);
				ge.registerFont(font);
			}

			runescapeSmallFont = StyleContext.getDefaultStyleContext()
				.getFont(font.getName(), Font.PLAIN, 16);
			ge.registerFont(runescapeSmallFont);

			try (InputStream boldIn = FontManager.class.getResourceAsStream("runescape_bold.ttf"))
			{
				font = Font.createFont(Font.TRUETYPE_FONT,
					boldIn)
					.deriveFont(Font.PLAIN, 16);
				ge.registerFont(font);
			}

			runescapeBoldFont = StyleContext.getDefaultStyleContext()
				.getFont(font.getName(), Font.PLAIN, 16);
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
}
