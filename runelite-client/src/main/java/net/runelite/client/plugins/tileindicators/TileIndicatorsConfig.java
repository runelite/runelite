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
package net.runelite.client.plugins.tileindicators;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tileindicators")
public interface TileIndicatorsConfig extends Config
{
	@Alpha
	@ConfigItem(
		keyName = "highlightDestinationColor",
		name = "Color of current destination highlighting",
		description = "Configures the highlight color of current destination",
		position = 0
	)
	default Color highlightDestinationColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "highlightDestinationTile",
		name = "Highlight destination tile",
		description = "Highlights tile player is walking to",
		position = 1
	)
	default boolean highlightDestinationTile()
	{
		return true;
	}

	@ConfigItem(
		keyName = "thinDestinationTile",
		name = "Thin destination tile",
		description = "Renders the tile border as 1 pixel wide instead of 2",
		position = 2
	)
	default boolean thinDestinationTile()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightCurrentColor",
		name = "Color of current tile highlighting",
		description = "Configures the highlight color of current tile position",
		position = 3
	)
	default Color highlightCurrentColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "highlightCurrentTile",
		name = "Highlight current tile",
		description = "Highlights tile player is on",
		position = 4
	)
	default boolean highlightCurrentTile()
	{
		return false;
	}

	@ConfigItem(
		keyName = "thinCurrentTile",
		name = "Thin current tile",
		description = "Renders the tile border as 1 pixel wide instead of 2",
		position = 5
	)
	default boolean thinCurrentTile()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightHoveredColor",
		name = "Color of current hovered highlighting",
		description = "Configures the highlight color of hovered tile",
		position = 6
	)
	default Color highlightHoveredColor()
	{
		return new Color(0, 0, 0, 0);
	}

	@ConfigItem(
		keyName = "highlightHoveredTile",
		name = "Highlight hovered tile",
		description = "Highlights tile player is hovering with mouse",
		position = 7
	)
	default boolean highlightHoveredTile()
	{
		return false;
	}

	@ConfigItem(
		keyName = "thinHoveredTile",
		name = "Thin hovered tile",
		description = "Renders the tile border as 1 pixel wide instead of 2",
		position = 8
	)
	default boolean thinHoveredTile()
	{
		return false;
	}
}
