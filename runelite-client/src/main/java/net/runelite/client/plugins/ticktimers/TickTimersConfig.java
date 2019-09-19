/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.ticktimers;

import java.awt.Font;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@ConfigGroup("TickTimers")
public interface TickTimersConfig extends Config
{
	@ConfigTitleSection(
		keyName = "mainConfig",
		position = 0,
		name = "Main Config",
		description = ""
	)
	default Title mainConfig()
	{
		return new Title();
	}

	@ConfigItem(
		position = 1,
		keyName = "prayerWidgetHelper",
		name = "Prayer Widget Helper",
		description = "Shows you which prayer to click and the time until click.",
		titleSection = "mainConfig"
	)
	default boolean showPrayerWidgetHelper()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "showHitSquares",
		name = "Show Hit Squares",
		description = "Shows you where the melee bosses can hit you from.",
		titleSection = "mainConfig"
	)
	default boolean showHitSquares()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "changeTickColor",
		name = "Change Tick Color",
		description = "If this is enabled, it will change the tick color to white" +
			"<br> at 1 tick remaining, signaling you to swap.",
		titleSection = "mainConfig"
	)
	default boolean changeTickColor()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "bosses",
		position = 4,
		name = "Bosses",
		description = ""
	)
	default Title bosses()
	{
		return new Title();
	}

	@ConfigItem(
		position = 5,
		keyName = "gwd",
		name = "God Wars Dungeon",
		description = "Show tick timers for GWD Bosses. This must be enabled before you zone in.",
		titleSection = "bosses"
	)
	default boolean gwd()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "dks",
		name = "Dagannoth Kings",
		description = "Show tick timers for Dagannoth Kings. This must be enabled before you zone in.",
		titleSection = "bosses"
	)
	default boolean dks()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "text",
		position = 7,
		name = "Text",
		description = ""
	)
	default Title text()
	{
		return new Title();
	}

	@ConfigItem(
		position = 8,
		keyName = "fontStyle",
		name = "Font Style",
		description = "Plain | Bold | Italics",
		titleSection = "text"
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
		position = 9,
		keyName = "textSize",
		name = "Text Size",
		description = "Text Size for Timers.",
		titleSection = "text"
	)
	default int textSize()
	{
		return 32;
	}

	@ConfigItem(
		position = 10,
		keyName = "shadows",
		name = "Shadows",
		description = "Adds Shadows to text.",
		titleSection = "text"
	)
	default boolean shadows()
	{
		return false;
	}

	@Getter(AccessLevel.PACKAGE)
	@AllArgsConstructor
	enum FontStyle
	{
		BOLD("Bold", Font.BOLD),
		ITALIC("Italic", Font.ITALIC),
		PLAIN("Plain", Font.PLAIN);

		private String name;
		private int font;

		@Override
		public String toString()
		{
			return getName();
		}
	}
}
