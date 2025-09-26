/*
 * Copyright (c) 2025, Hamish <https://github.com/DustyRealm>
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
package net.runelite.client.config;

import com.google.gson.Gson;
import com.google.inject.Inject;
import java.awt.Font;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;
import net.runelite.client.ui.FontManager;

@ConfigSerializer(RuneLiteFontSerializer.class)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@With
public class RuneLiteFont
{
	public static final RuneLiteFont REGULAR = new RuneLiteFont().withFamily(FontManager.getRunescapeFont().getFamily()).withSize(16);
	public static final RuneLiteFont BOLD = new RuneLiteFont().withFamily(FontManager.getRunescapeBoldFont().getFamily()).withSize(16).withBold(true);
	public static final RuneLiteFont SMALL = new RuneLiteFont().withFamily(FontManager.getRunescapeSmallFont().getFamily()).withSize(16);

	String family;
	int size;

	boolean bold = false;
	boolean italic = false;

	private int getStyle()
	{
		return (bold ? Font.BOLD : Font.PLAIN) | (italic ? Font.ITALIC : Font.PLAIN);
	}

	public Font getFont()
	{

		return FontManager.getFont(family, getStyle(), size);
	}
}

class RuneLiteFontSerializer implements Serializer<RuneLiteFont>
{
	private static final Map<String, RuneLiteFont> FONT_TYPE_MAP = Map.of(
		FontType.REGULAR.name(), RuneLiteFont.REGULAR,
		FontType.BOLD.name(), RuneLiteFont.BOLD,
		FontType.SMALL.name(), RuneLiteFont.SMALL
	);

	private final Gson gson;

	@Inject
	private RuneLiteFontSerializer(Gson gson)
	{
		this.gson = gson;
	}

	@Override
	public String serialize(RuneLiteFont value)
	{
		return gson.toJson(value);
	}

	@Override
	public RuneLiteFont deserialize(String s)
	{
		// Handle legacy config values
		if (FONT_TYPE_MAP.containsKey(s))
		{
			return FONT_TYPE_MAP.get(s);
		}

		return gson.fromJson(s, RuneLiteFont.class);
	}
}