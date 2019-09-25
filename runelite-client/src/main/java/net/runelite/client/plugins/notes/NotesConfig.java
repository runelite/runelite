/*
 * Copyright (c) 2018 Charlie Waters
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
package net.runelite.client.plugins.notes;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("notes")
public interface NotesConfig extends Config
{
	enum FontType
	{
		PLAIN,
		BOLD,
		ITALIC
	}

	@ConfigItem(
		keyName = "notesData",
		name = "",
		description = "",
		hidden = true
	)
	default String notesData()
	{
		return "";
	}

	@ConfigItem(
		keyName = "notesData",
		name = "",
		description = ""
	)
	void notesData(String str);

	@ConfigItem(
		position = 0,
		keyName = "font",
		name = "Font",
		description = "The name of the font"
	)
	default FontNotes font()
	{
		return FontNotes.RUNESCAPE_STANDARD;
	}

	@ConfigItem(
		position = 1,
		keyName = "fontStyle",
		name = "Font style",
		description = "The style of the font"
	)
	default FontType fontStyle()
	{
		return FontType.PLAIN;
	}

	@Range(
		min = 6,
		max = 30
	)
	@ConfigItem(
		position = 2,
		keyName = "fontSize",
		name = "Font size",
		description = "The size of the font"
	)
	default int fontSize()
	{
		return 16;
	}

	@ConfigItem(
		position = 3,
		keyName = "fontColour",
		name = "Font colour",
		description = "The colour of the font"
	)
	default Color fontColour()
	{
		return new Color(198, 198, 198);
	}
}
