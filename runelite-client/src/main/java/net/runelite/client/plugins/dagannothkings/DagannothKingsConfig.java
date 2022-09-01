/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.dagannothkings;

import java.awt.Font;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("dagannothkings")
public interface DagannothKingsConfig extends Config
{
	// Sections

	@ConfigSection(
		position = 0,
		name = "Settings",
		description = ""
	)
	String settings = "Settings";

	@ConfigSection(
		position = 1,
		name = "Font",
		description = ""
	)
	String font = "Font";

	// Settings

	@ConfigItem(
		position = 0,
		keyName = "showPrayerInfoboxOverlay",
		name = "Prayer infobox overlay",
		description = "Infobox overlay with prayer to activate.",
		section = settings
	)
	default boolean showPrayerInfoboxOverlay()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "showPrayerWidgetOverlay",
		name = "Prayer widget overlay",
		description = "Overlay prayer widget with tick timer.",
		section = settings
	)
	default boolean showPrayerWidgetOverlay()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "showGuitarHeroOverlay",
		name = "Guitar hero overlay",
		description = "Render \"Guitar Hero\" style prayer overlay.",
		section = settings
	)
	default boolean showGuitarHeroOverlay()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "showNpcTickCounter",
		name = "Show NPC tick counter",
		description = "Show tick counters on NPCs.",
		section = settings
	)
	default boolean showNpcTickCounter()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "ignoringNonAttacking",
		name = "Ignore non-attacking NPCs",
		description = "Ignore NPCs that are not attacking you.",
		section = settings
	)
	default boolean ignoringNonAttacking()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "showNpcTileOutline",
		name = "Show NPC tile outlines",
		description = "Show tile outlines for NPCs.",
		section = settings
	)
	default boolean showNpcTileOutline()
	{
		return false;
	}

	// Font

	@ConfigItem(
		position = 0,
		keyName = "fontStyle",
		name = "Font style",
		description = "Plain | Bold | Italics",
		section = font
	)
	default FontStyle fontStyle()
	{
		return FontStyle.BOLD;
	}

	@Range(
		min = 14,
		max = 40
	)
	@ConfigItem(
		position = 1,
		keyName = "fontSize",
		name = "Font size",
		description = "Font size for timers.",
		section = font
	)
	default int fontSize()
	{
		return 20;
	}

	@ConfigItem(
		position = 2,
		keyName = "fontShadow",
		name = "Font shadow",
		description = "Add shadow to font.",
		section = font
	)
	default boolean fontShadow()
	{
		return false;
	}

	@Getter
	@AllArgsConstructor
	enum FontStyle
	{
		BOLD("Bold", Font.BOLD),
		ITALIC("Italic", Font.ITALIC),
		PLAIN("Plain", Font.PLAIN);

		private final String name;
		private final int font;

		@Override
		public String toString()
		{
			return name;
		}
	}
}
