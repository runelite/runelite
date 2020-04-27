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
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("npcindicators")
public interface NpcIndicatorsConfig extends Config
{

	@ConfigItem(
		keyName = "npcToHighlight",
		name = "NPCs to Highlight",
		description = "List of NPC names to highlight"
	)
	default String getNpcToHighlight()
	{
		return "";
	}

	@ConfigItem(
		keyName = "npcColor",
		name = "Highlight Color",
		description = "Color of the NPC highlight"
	)
	default Color getHighlightColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "drawNames",
		name = "Draw names above NPC",
		description = "Configures whether or not NPC names should be drawn above the NPC"
	)
	default boolean drawNames()
	{
		return false;
	}

	@ConfigItem(
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not NPC names should be drawn on the minimap"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightMenuNames",
		name = "Highlight menu names",
		description = "Highlight NPC names in right click menu"
	)
	default boolean highlightMenuNames()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showRespawnTimer",
		name = "Show respawn timer",
		description = "Show respawn timer of tagged NPCs")
	default boolean showRespawnTimer()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightStyleTile",
		name = "Highlight Style Tile",
		description = "Highlight setting Tile"
	)
	default boolean renderStyleTile()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightStyleHull",
		name = "Highlight Style Hull",
		description = "Highlight setting Hull"
	)
	default boolean renderStyleHull()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightStyleSouthWestTile",
		name = "Highlight Style South West Tile",
		description = "Highlight setting South West Tile"
	)
	default boolean renderStyleSouthWestTile()
	{
		return false;
	}
}