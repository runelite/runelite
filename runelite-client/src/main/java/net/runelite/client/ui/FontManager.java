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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;

public class FontManager
{
	private static final Logger logger = LoggerFactory.getLogger(ClientPanel.class);

	private static final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static Font runescapeFont;
	private static Font runescapeSmallFont;

	static
	{
		try
		{
			runescapeFont = Font.createFont(Font.TRUETYPE_FONT, FontManager.class.getResourceAsStream("/runescape.ttf"));
			runescapeFont = runescapeFont.deriveFont(Font.PLAIN, 16);
			ge.registerFont(runescapeFont);

			runescapeSmallFont = Font.createFont(Font.TRUETYPE_FONT, FontManager.class.getResourceAsStream("/runescape_small.ttf"));
			runescapeSmallFont = runescapeSmallFont.deriveFont(Font.PLAIN, 16);
			ge.registerFont(runescapeSmallFont);
		}
		catch (Exception ex)
		{
			if (ex instanceof FontFormatException)
			{
				logger.error("Font loaded, but format incorrect: " + ex);
			}
			if (ex instanceof IOException)
			{
				logger.error("Font file not found: " + ex);
			}
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
}
