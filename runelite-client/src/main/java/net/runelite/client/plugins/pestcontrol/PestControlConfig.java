/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
		position = 1
	)
	default boolean showHintArrow()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPortalWeakness",
		name = "Show portal weakness",
		description = "Show the combat style weakness of the portals. For melee the attack styles are shown: Stab/Crush/Slash",
		position = 2
	)
	default boolean showPortalWeakness()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightGangplanks",
		name = "Highlight gangplanks",
		description = "Highlight the boarding gangplanks and show the required combat level.",
		position = 3
	)
	default boolean highlightGangplanks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightPortals",
		name = "Highlight portals",
		description = "Highlight all, active or shielded portals.",
		position = 4
	)
	default HighlightPortalOption portalHighlight()
	{
		return HighlightPortalOption.ACTIVE;
	}

	@ConfigItem(
		keyName = "activePortalColor",
		name = "Active portal color",
		description = "Color of the portals that can be attacked.",
		position = 5
	)
	default Color activePortalColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "shieldedPortalColor",
		name = "Shielded portal color",
		description = "Color of the portals that are shielded.",
		position = 6
	)
	default Color shieldedPortalColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
		keyName = "highlightSpinners",
		name = "Highlight Spinners",
		description = "Highlights Spinners. Highlighting them is recommended as Spinners heal the portals.",
		position = 7
	)
	default NpcHighlightStyle highlightSpinners()
	{
		return NpcHighlightStyle.BOTH;
	}

	@ConfigItem(
		keyName = "spinnerColor",
		name = "Spinner color",
		description = "Color of highlighted Spinners.",
		position = 8
	)
	default Color spinnerColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "highlightBrawlers",
		name = "Highlight Brawlers",
		description = "Highlights Brawlers.",
		position = 9
	)
	default NpcHighlightStyle highlightBrawlers()
	{
		return NpcHighlightStyle.TILE;
	}

	@ConfigItem(
		keyName = "brawlerColor",
		name = "Brawler color",
		description = "Color of highlighted Brawlers.",
		position = 10
	)
	default Color brawlerColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "highlightRepairables",
		name = "Highlight repairables",
		description = "Highlight repairable barricades and gates.",
		position = 11
	)
	default boolean highlightRepairables()
	{
		return false;
	}

	@ConfigItem(
		keyName = "repairableColor",
		name = "Repairable color",
		description = "Color of highlighted repairables.",
		position = 12
	)
	/*default Color repairableColor()
	{
		return new Color(193, 141, 255);
	}*/
	default Color repairableColor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		keyName = "showPoints",
		name = "Show points indicator",
		description = "Always display your points when on the island or in the minigame.",
		position = 13
	)
	default boolean showPoints()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTimeTillNextPortal",
		name = "Show time till next portal",
		description = "Show a timer that counts down till the next portal is attackable.",
		position = 14
	)
	default boolean showTimeTillNextPortal()
	{
		return true;
	}
}
