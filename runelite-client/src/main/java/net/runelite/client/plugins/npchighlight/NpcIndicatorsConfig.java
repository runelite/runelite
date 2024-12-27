/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.npchighlight;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup(NpcIndicatorsConfig.GROUP)
public interface NpcIndicatorsConfig extends Config
{
	String GROUP = "npcindicators";

	@ConfigSection(
		name = "Render style",
		description = "The render style of NPC highlighting.",
		position = 0
	)
	String renderStyleSection = "renderStyleSection";

	@ConfigItem(
		position = 0,
		keyName = "highlightHull",
		name = "Highlight hull",
		description = "Configures whether or not NPC should be highlighted by hull.",
		section = renderStyleSection
	)
	default boolean highlightHull()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "highlightTile",
		name = "Highlight tile",
		description = "Configures whether or not NPC should be highlighted by tile.",
		section = renderStyleSection
	)
	default boolean highlightTile()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightTrueTile",
		name = "Highlight true tile",
		description = "Configures whether or not NPC should be highlighted by true tile.",
		section = renderStyleSection
	)
	default boolean highlightTrueTile()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "highlightSouthWestTile",
		name = "Highlight south west tile",
		description = "Configures whether or not NPC should be highlighted by south western tile.",
		section = renderStyleSection
	)
	default boolean highlightSouthWestTile()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "highlightSouthWestTrueTile",
		name = "Highlight south west true tile",
		description = "Configures whether or not NPC should be highlighted by south western true tile.",
		section = renderStyleSection
	)
	default boolean highlightSouthWestTrueTile()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "highlightOutline",
		name = "Highlight outline",
		description = "Configures whether or not the model of the NPC should be highlighted by outline.",
		section = renderStyleSection
	)
	default boolean highlightOutline()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 10,
		keyName = "npcColor",
		name = "Highlight color",
		description = "Color of the NPC highlight border, menu, and text.",
		section = renderStyleSection
	)
	default Color highlightColor()
	{
		return Color.CYAN;
	}

	@Alpha
	@ConfigItem(
		position = 11,
		keyName = "fillColor",
		name = "Fill color",
		description = "Color of the NPC highlight fill.",
		section = renderStyleSection
	)
	default Color fillColor()
	{
		return new Color(0, 255, 255, 20);
	}

	@ConfigItem(
		position = 12,
		keyName = "borderWidth",
		name = "Border width",
		description = "Width of the highlighted NPC border.",
		section = renderStyleSection
	)
	default double borderWidth()
	{
		return 2;
	}

	@ConfigItem(
		position = 13,
		keyName = "outlineFeather",
		name = "Outline feather",
		description = "Specify between 0-4 how much of the model outline should be faded.",
		section = renderStyleSection
	)
	@Range(
		min = 0,
		max = 4
	)
	default int outlineFeather()
	{
		return 0;
	}

	@ConfigItem(
		position = 7,
		keyName = "npcToHighlight",
		name = "NPCs to highlight",
		description = "List of NPC names to highlight. Format: npc1, npc2, npc3"
	)
	default String getNpcToHighlight()
	{
		return "";
	}

	@ConfigItem(
		keyName = "npcToHighlight",
		name = "",
		description = ""
	)
	void setNpcToHighlight(String npcsToHighlight);

	@ConfigItem(
		position = 8,
		keyName = "drawNames",
		name = "Draw names above NPC",
		description = "Configures whether or not NPC names should be drawn above the NPC."
	)
	default boolean drawNames()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not NPC names should be drawn on the minimap."
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	enum MenuHighlightStyle
	{
		NONE,
		LEVEL,
		NAME,
		BOTH
	}

	@ConfigItem(
		position = 10,
		keyName = "highlightMenuStyle",
		name = "Highlight menu style",
		description = "Highlight style in the right-click menu."
	)
	default MenuHighlightStyle highlightMenuStyle()
	{
		return MenuHighlightStyle.NONE;
	}

	@ConfigItem(
		position = 11,
		keyName = "ignoreDeadNpcs",
		name = "Ignore dead NPCs",
		description = "Prevents highlighting NPCs after they are dead."
	)
	default boolean ignoreDeadNpcs()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "deadNpcMenuColor",
		name = "Dead NPC menu color",
		description = "Color of the NPC menus for dead NPCs."
	)
	Color deadNpcMenuColor();

	@ConfigItem(
		position = 13,
		keyName = "showRespawnTimer",
		name = "Show respawn timer",
		description = "Show respawn timer of tagged NPCs."
	)
	default boolean showRespawnTimer()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "ignorePets",
		name = "Ignore pets",
		description = "Excludes pets from being highlighted."
	)
	default boolean ignorePets()
	{
		return true;
	}
}