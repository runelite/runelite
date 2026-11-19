/*
 * Copyright (c) 2022 Abex
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
package net.runelite.client.ui.laf;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatSystemProperties;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.UIDefaults;
import lombok.SneakyThrows;
import net.runelite.client.config.FontType;
import net.runelite.client.ui.AppFontManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;

public class RuneLiteLAF extends FlatDarkLaf
{
	private final Font appFont;

	public static boolean setup()
	{
		return setup(FontType.REGULAR.getFont());
	}

	public static boolean setup(Font appFont)
	{
		// flatlaf always gets this wrong
		System.setProperty(FlatSystemProperties.UI_SCALE_ENABLED, "false");

		return setup(new RuneLiteLAF(appFont));
	}

	public RuneLiteLAF()
	{
		this(FontType.REGULAR.getFont());
	}

	@SneakyThrows
	public RuneLiteLAF(Font appFont)
	{
		this.appFont = appFont;
		Map<String, String> extras = new HashMap<>();

		// load the properties ourselves to avoid platform specific styles
		Properties p = new Properties();
		for (Class<?> clazz : new Class[]{
			FlatLaf.class,
			FlatDarkLaf.class,
			RuneLiteLAF.class,
		})
		{
			try (InputStream is = clazz.getResourceAsStream("/" + clazz.getName().replace('.', '/') + ".properties"))
			{
				if (is != null)
				{
					p.load(new InputStreamReader(is, StandardCharsets.UTF_8));
				}
			}
		}
		for (Map.Entry<Object, Object> ent : p.entrySet())
		{
			String k = (String) ent.getKey();
			String v = (String) ent.getValue();
			if (k.charAt(0) == '[' && !k.startsWith("[style]"))
			{
				// platform rule
				continue;
			}
			extras.put(k, v);
		}

		// add all of ColorScheme as variables for the properties
		for (Field f : ColorScheme.class.getDeclaredFields())
		{
			if (Modifier.isStatic(f.getModifiers()) && Color.class == f.getType())
			{
				String name = f.getName();
				if (name.endsWith("_COLOR"))
				{
					name = name.substring(0, name.length() - 6);
				}

				Color color = (Color) f.get(null);
				extras.put("@" + name, String.format("#%06x%02x", color.getRGB() & 0xFFFFFF, color.getRGB() >>> 24));
			}
		}

		setExtraDefaults(extras);
	}

	@Override
	protected List<Class<?>> getLafClassesForDefaultsLoading()
	{
		return Collections.emptyList();
	}

	@Override
	public String getName()
	{
		return "RuneLite";
	}

	@Override
	public String getDescription()
	{
		return "RuneLite";
	}

	@Override
	public UIDefaults getDefaults()
	{
		UIDefaults d = super.getDefaults();

		boolean custom = !appFont.equals(FontType.REGULAR.getFont());
		Font font = custom ? appFont : FontManager.getRunescapeFont();
		// Tag app-owned fonts independently of equal fonts explicitly chosen by plugins.
		d.put("defaultFont", new AppFontManager.ThemeFont(font));
		d.put("RuneLite.customAppFont", custom);
		d.put("RuneLite.uiBoldFont", custom ? font.deriveFont(font.getStyle() | Font.BOLD) : FontManager.getRunescapeBoldFont());
		d.put("RuneLite.uiSmallFont", custom ? font.deriveFont((float) Math.max(1, font.getSize() - 2)) : FontManager.getRunescapeSmallFont());
		d.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

		return d;
	}
}
