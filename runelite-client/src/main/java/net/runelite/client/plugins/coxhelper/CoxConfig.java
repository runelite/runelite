/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
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

package net.runelite.client.plugins.coxhelper;

import java.awt.Color;
import java.awt.Font;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@ConfigGroup("Cox")

public interface CoxConfig extends Config
{
	@Getter
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

	@ConfigTitleSection(
		keyName = "muttadileTitle",
		position = 1,
		name = "Muttadile",
		description = ""
	)
	default Title muttadileTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 2,
		keyName = "muttadile",
		name = "Muttadile Marker",
		description = "Places an overlay around muttadiles showing their melee range.",
		titleSection = "muttadileTitle"
	)
	default boolean muttadile()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "tektonTitle",
		position = 3,
		name = "Tekton",
		description = ""
	)
	default Title tektonTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 4,
		keyName = "tekton",
		name = "Tekton Marker",
		description = "Places an overlay around Tekton showing his melee range.",
		titleSection = "tektonTitle"
	)
	default boolean tekton()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "tektonTickCounter",
		name = "Tekton Tick Counters",
		description = "Counts down current phase timer, and attack ticks.",
		titleSection = "tektonTitle"
	)
	default boolean tektonTickCounter()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "guardiansTitle",
		position = 5,
		name = "Guardians",
		description = ""
	)
	default Title guardiansTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 6,
		keyName = "guardians",
		name = "Guardians Overlay",
		description = "Places an overlay near Guardians showing safespot.",
		titleSection = "guardiansTitle"
	)
	default boolean guardians()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "guardinTickCounter",
		name = "Guardians Tick Timing",
		description = "Places an overlay on Guardians showing attack tick timers.",
		titleSection = "guardiansTitle"
	)
	default boolean guardinTickCounter()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "vanguardsTitle",
		position = 7,
		name = "Vanguards",
		description = ""
	)
	default Title vanguardsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 8,
		keyName = "vangHighlight",
		name = "Highlight Vanguards",
		description = "Color is based on their attack style.",
		titleSection = "vanguardsTitle"
	)
	default boolean vangHighlight()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "vangHealth",
		name = "Show Vanguards Current HP",
		description = "This will create an infobox with vanguards current hp.",
		titleSection = "vanguardsTitle"
	)
	default boolean vangHealth()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "olmTitle",
		position = 10,
		name = "Olm",
		description = ""
	)
	default Title olmTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 11,
		keyName = "prayAgainstOlm",
		name = "Olm Show Prayer",
		description = "Shows what prayer to use during olm.",
		titleSection = "olmTitle"
	)
	default boolean prayAgainstOlm()
	{
		return true;
	}

	@Range(
		min = 40,
		max = 100
	)
	@ConfigItem(
		position = 11,
		keyName = "prayAgainstOlmSize",
		name = "Olm Prayer Size",
		description = "Change the Size of the Olm Infobox.",
		titleSection = "olmTitle"
	)
	default int prayAgainstOlmSize()
	{
		return 40;
	}

	@ConfigItem(
		position = 12,
		keyName = "timers",
		name = "Olm Show Burn/Acid Timers",
		description = "Shows tick timers for burns/acids.",
		titleSection = "olmTitle"
	)
	default boolean timers()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "tpOverlay",
		name = "Olm Show Teleport Overlays",
		description = "Shows Overlays for targeted teleports.",
		titleSection = "olmTitle"
	)
	default boolean tpOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "olmTick",
		name = "Olm Tick Counter",
		description = "Show Tick Counter on Olm",
		titleSection = "olmTitle"
	)
	default boolean olmTick()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "colors",
		position = 15,
		name = "Colors",
		description = ""
	)
	default Title colors()
	{
		return new Title();
	}

	@ConfigItem(
		position = 16,
		keyName = "muttaColor",
		name = "Muttadile Tile Color",
		description = "Change hit area tile color for muttadiles",
		titleSection = "colors",
		hidden = true,
		unhide = "Muttadile"
	)
	default Color muttaColor()
	{
		return new Color(0, 255, 99);
	}

	@ConfigItem(
		position = 17,
		keyName = "guardColor",
		name = "Guardians Tile Color",
		description = "Change safespot area tile color for Guardians",
		titleSection = "colors",
		hidden = true,
		unhide = "Guardians"
	)
	default Color guardColor()
	{
		return new Color(0, 255, 99);
	}

	@ConfigItem(
		position = 18,
		keyName = "tektonColor",
		name = "Tekton Tile Color",
		description = "Change hit area tile color for Tekton",
		titleSection = "colors",
		hidden = true,
		unhide = "Tekton"
	)
	default Color tektonColor()
	{
		return new Color(193, 255, 245);
	}

	@ConfigItem(
		position = 19,
		keyName = "burnColor",
		name = "Burn Victim Color",
		description = "Changes tile color for burn victim.",
		titleSection = "colors",
		hidden = true,
		unhide = "timers"
	)
	default Color burnColor()
	{
		return new Color(255, 100, 0);
	}

	@ConfigItem(
		position = 20,
		keyName = "acidColor",
		name = "Acid Victim Color",
		description = "Changes tile color for acid victim.",
		titleSection = "colors",
		hidden = true,
		unhide = "timers"
	)
	default Color acidColor()
	{
		return new Color(69, 241, 44);
	}

	@ConfigItem(
		position = 21,
		keyName = "tpColor",
		name = "Teleport Target Color",
		description = "Changes tile color for teleport target.",
		titleSection = "colors",
		hidden = true,
		unhide = "tpOverlay"
	)
	default Color tpColor()
	{
		return new Color(193, 255, 245);
	}

	@ConfigTitleSection(
		keyName = "text",
		position = 22,
		name = "Text",
		description = ""
	)
	default Title text()
	{
		return new Title();
	}

	@ConfigItem(
		position = 23,
		keyName = "fontStyle",
		name = "Font Style",
		description = "Bold/Italics/Plain",
		titleSection = "text"
	)
	default FontStyle fontStyle()
	{
		return FontStyle.BOLD;
	}

	@Range(
		min = 9,
		max = 20
	)
	@ConfigItem(
		position = 24,
		keyName = "textSize",
		name = "Text Size",
		description = "Text Size for Timers.",
		titleSection = "text"
	)
	default int textSize()
	{
		return 14;
	}

	@ConfigItem(
		position = 25,
		keyName = "shadows",
		name = "Shadows",
		description = "Adds Shadows to text.",
		titleSection = "text"
	)
	default boolean shadows()
	{
		return true;
	}
}
