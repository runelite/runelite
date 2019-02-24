/*
 * Copyright (c) 2018, Cas <https://github.com/casvandongen>
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
package net.runelite.client.plugins.pestcontrol;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.pestcontrol.config.HighlightPortalOption;
import net.runelite.client.plugins.pestcontrol.config.NpcHighlightStyle;

@ConfigGroup("pestcontrol")
public interface PestControlConfig extends Config
{
	@ConfigItem(
		keyName = "showHintArrow",
		name = "Show hint arrows",
		description = "Show hint arrows to the portals that can be attacked.",
		position = 2
	)
	default boolean showHintArrow()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPortalWeakness",
		name = "Show portal weakness",
		description = "Show the combat style weakness of the portals.",
		position = 3
	)
	default boolean showCombatWeakness()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showCombatRequirements",
		name = "Show combat requirements",
		description = "Adds the minimum required combat level to the banner pole.",
		position = 4
	)
	default boolean showCombatRequirements()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightPortals",
		name = "Highlight portals",
		description = "Adds the minimum required combat level to the banner pole.",
		position = 5
	)
	default HighlightPortalOption highlightPortals()
	{
		return HighlightPortalOption.ALL;
	}

	@ConfigItem(
		keyName = "activePortalColor",
		name = "Active portal color",
		description = "Color of the portals that can be attacked.",
		position = 6
	)
	default Color activePortalColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "shieldedPortalColor",
		name = "Shielded portal color",
		description = "Color of the portals that can not be attacked yet.",
		position = 7
	)
	default Color shieldedPortalColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
		keyName = "spinnerHighlight",
		name = "Highlight Spinners",
		description = "Highlights Spinners. Highlighting them is recommended as Spinners heal the portals.",
		position = 8
	)
	default NpcHighlightStyle spinnerHighlight()
	{
		return NpcHighlightStyle.BOTH;
	}

	@ConfigItem(
		keyName = "spinnerColor",
		name = "Spinner color",
		description = "Color of highlighted Spinners.",
		position = 9
	)
	default Color spinnerColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "brawlerHighlight",
		name = "Highlight Brawlers",
		description = "Highlights Brawlers.",
		position = 10
	)
	default NpcHighlightStyle brawlerHighlight()
	{
		return NpcHighlightStyle.TILE;
	}

	@ConfigItem(
		keyName = "brawlerColor",
		name = "Brawler color",
		description = "Color of highlighted Brawlers.",
		position = 11
	)
	default Color brawlerColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "splatterHighlight",
		name = "Highlight Splatters",
		description = "Highlights Splatters.",
		position = 12
	)
	default NpcHighlightStyle splatterHighlight()
	{
		return NpcHighlightStyle.TILE;
	}

	@ConfigItem(
		keyName = "splatterColor",
		name = "Splatter color",
		description = "Color of highlighted Splatters.",
		position = 13
	)
	default Color splatterColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "shifterHighlight",
		name = "Highlight Shifters",
		description = "Highlights Brawlers.",
		position = 14
	)
	default NpcHighlightStyle shifterHighlight()
	{
		return NpcHighlightStyle.TILE;
	}

	@ConfigItem(
		keyName = "shifterColor",
		name = "Spinner color",
		description = "Color of highlighted Spinners.",
		position = 15
	)
	default Color shifterColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "defilerHighlight",
		name = "Highlight Defilers",
		description = "Highlights Defilers.",
		position = 16
	)
	default NpcHighlightStyle defilerHighlight()
	{
		return NpcHighlightStyle.TILE;
	}

	@ConfigItem(
		keyName = "defilerColor",
		name = "Defiler color",
		description = "Color of highlighted Defilers.",
		position = 17
	)
	default Color defilerColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "ravagerHighlight",
		name = "Highlight Ravagers",
		description = "Highlights Ravagers.",
		position = 18
	)
	default NpcHighlightStyle ravagerHighlight()
	{
		return NpcHighlightStyle.TILE;
	}

	@ConfigItem(
		keyName = "ravagerColor",
		name = "Ravager color",
		description = "Color of highlighted Ravagers.",
		position = 19
	)
	default Color ravagerColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "torcherHighlight",
		name = "Highlight Torchers",
		description = "Highlights Torchers.",
		position = 20
	)
	default NpcHighlightStyle torcherHighlight()
	{
		return NpcHighlightStyle.TILE;
	}

	@ConfigItem(
		keyName = "torcherColor",
		name = "Torcher color",
		description = "Color of highlighted Torchers.",
		position = 21
	)
	default Color torcherColor()
	{
		return Color.GRAY;
	}

}
