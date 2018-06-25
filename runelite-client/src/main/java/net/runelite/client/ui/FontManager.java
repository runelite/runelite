/*
 * Copyright (c) 2018 Abex
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
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.text.StyleContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.util.OSType;

@Slf4j
public class FontManager
{
	static
	{
		doOSXCompositeFontHack();
	}

	@Getter
	private static final Font runescapeFont = loadFont("runescape");

	@Getter
	private static final Font runescapeSmallFont = loadFont("runescape_small");

	@Getter
	private static final Font runescapeBoldFont = loadFont("runescape_bold");

	private static Font loadFont(String name)
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		try
		{
			Font base = Font.createFont(Font.TRUETYPE_FONT, FontManager.class.getResourceAsStream(name + ".ttf"))
				.deriveFont(Font.PLAIN, 16);
			ge.registerFont(base);
			// AWT automatically makes fonts composite, aslong as `dialog` is also composite
			Font composite = StyleContext.getDefaultStyleContext()
				.getFont(base.getName(), Font.PLAIN, 16);
			ge.registerFont(composite);
			return composite;
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

	private static void doOSXCompositeFontHack()
	{
		if (OSType.getOSType() != OSType.MacOS || RuneLite.getOptions().has("no-font-hack"))
		{
			return;
		}

		// OSX has a different font renderer that supports composite types natively,
		// where other platforms (X11 and Win32) get composite font support implemented
		// in java (via CompositeFont and FontUtilities.getCompositeFontUIResource).
		// However on OSX, non CFont fonts don't get fallback to CFont fonts because
		// the fallback font is not a CompositeFont.
		//
		// Solution is to make a composite font manually on this platform, but it breaks
		// japanese IME support in some ways apparently, but I don't think we care too much.
		// See https://youtrack.jetbrains.com/issue/JRE-674 and https://youtrack.jetbrains.com/issue/JRE-599

		try
		{
			// If this patch is not applied it crashes
			// http://hg.openjdk.java.net/jdk8u/jdk8u/jdk/rev/dd6b8cddccc9
			if (!Class.forName("sun.font.PhysicalStrike").isAssignableFrom(Class.forName("sun.font.CStrike")))
			{
				log.warn("Java version is not fully compatible, some fonts will render incorrectly");
				return;
			}


			Object fontManager = Class.forName("sun.font.FontManagerFactory")
				.getMethod("getInstance")
				.invoke(null);

			String[] fonts = new String[]
				{
					"dialog.plain",
					"dialog.bold",
					"dialog.italic",
					"dialog.bolditalic",
				};

			for (String name : fonts)
			{
				Object f2d = Class.forName("sun.font.CompositeFont")
					.getConstructor(String.class, String[].class, String[].class, int.class, int[].class, int[].class, boolean.class, Class.forName("sun.font.SunFontManager"))
					.newInstance(name, null, new String[]{"dialog"}, 1, null, null, false, fontManager);

				Class.forName("sun.font.CompositeFont")
					.getMethod("getSlotFont", int.class)
					.invoke(f2d, 0); // force it to init before we set it, so it doesn't recurse

				// Enter it into the cache over the old value
				Field fFontNameCache = Class.forName("sun.font.SunFontManager").getDeclaredField("fontNameCache");
				fFontNameCache.setAccessible(true);
				ConcurrentHashMap fontNameCache = (ConcurrentHashMap) fFontNameCache.get(fontManager);
				fontNameCache.put(name, f2d);
			}
		}
		catch (ThreadDeath d)
		{
			throw d;
		}
		catch (Throwable e) // This is an internal API, try to fail gracefully if it changes
		{
			log.warn("Unable to make fallback font {}", e);
		}
	}
}
