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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import javax.swing.text.StyleContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;

@Slf4j
public class FontManager
{
	@Getter
	private static final Font runescapeFont;
	@Getter
	private static final Font runescapeSmallFont;
	@Getter
	private static final Font runescapeBoldFont;
	@Getter
	private static final Font defaultFont;
	@Getter
	private static final Font defaultBoldFont;

	static
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		try (InputStream inRunescape = FontManager.class.getResourceAsStream("runescape.ttf");
			InputStream inRunescapeSmall = FontManager.class.getResourceAsStream("runescape_small.ttf");
			InputStream inRunescapeBold = FontManager.class.getResourceAsStream("runescape_bold.ttf"))
		{
			// runescape
			Font font = Font.createFont(Font.TRUETYPE_FONT, inRunescape);
			ge.registerFont(font);

			runescapeFont = StyleContext.getDefaultStyleContext()
				.getFont(font.getFamily(), Font.PLAIN, 16);

			// small
			Font smallFont = Font.createFont(Font.TRUETYPE_FONT, inRunescapeSmall);
			ge.registerFont(smallFont);

			runescapeSmallFont = StyleContext.getDefaultStyleContext()
				.getFont(smallFont.getFamily(), Font.PLAIN, 16);

			// bold
			Font boldFont = Font.createFont(Font.TRUETYPE_FONT, inRunescapeBold);
			ge.registerFont(boldFont);

			runescapeBoldFont = StyleContext.getDefaultStyleContext()
				.getFont(boldFont.getFamily(), Font.BOLD, 16);
		}
		catch (FontFormatException ex)
		{
			throw new RuntimeException("Font loaded, but format incorrect.", ex);
		}
		catch (IOException ex)
		{
			throw new RuntimeException("Font file not found.", ex);
		}

		// Load custom fonts
		Path customFontsPath = RuneLite.FONTS_DIR.toPath();
		if (Files.isDirectory(customFontsPath))
		{
			try (Stream<Path> paths = Files.list(customFontsPath))
			{
				paths.filter(Files::isRegularFile)
					.filter(path ->
						{
							String name = path.getFileName().toString().toLowerCase();
							return name.endsWith(".ttf") || name.endsWith(".otf");
						}
					)
					.forEach(path ->
						{
							try (InputStream inFont = Files.newInputStream(path))
							{
								Font font = Font.createFont(Font.TRUETYPE_FONT, inFont);
								ge.registerFont(font);

								log.info("Loaded custom font: {}", font.getFamily());
							}
							catch (IOException | FontFormatException ex)
							{
								log.error("Error loading custom font: {}", path, ex);
							}
						}
					);
			}
			catch (IOException ex)
			{
				log.error("Error loading fonts from: {}", customFontsPath, ex);
			}
		}

		defaultFont = new Font(Font.DIALOG, Font.PLAIN, 16);
		defaultBoldFont = new Font(Font.DIALOG, Font.BOLD, 16);
	}
}
