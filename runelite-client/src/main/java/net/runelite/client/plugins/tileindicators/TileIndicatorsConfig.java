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
import net.runelite.client.config.ConfigSection;

@ConfigGroup("tileindicators")
public interface TileIndicatorsConfig extends Config
{
	@ConfigSection(
		name = "Destination tile",
		description = "Destination tile configuration.",
		position = 0
	)
	String destinationTile = "destinationTile";

	@ConfigSection(
		name = "Hovered tile",
		description = "Hovered tile configuration.",
		position = 1
	)
	String hoveredTile = "hoveredTile";

	@ConfigSection(
		name = "Current tile",
		description = "Current tile configuration.",
		position = 2
	)
	String currentTile = "currentTile";

	@ConfigItem(
		keyName = "highlightDestinationTile",
		name = "Highlight destination tile",
		description = "Highlights tile player is walking to.",
		position = 1,
		section = destinationTile
	)
	default boolean highlightDestinationTile()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightDestinationColor",
		name = "Highlight color",
		description = "Configures the highlight color of current destination.",
		position = 2,
		section = destinationTile
	)
	default Color highlightDestinationColor()
	{
		return Color.GRAY;
	}

	@Alpha
	@ConfigItem(
		keyName = "destinationTileFillColor",
		name = "Fill color",
		description = "Configures the fill color of destination tile.",
		position = 3,
		section = destinationTile
	)
	default Color destinationTileFillColor()
	{
		return new Color(0, 0, 0, 50);
	}

	@ConfigItem(
		keyName = "destinationTileBorderWidth",
		name = "Border width",
		description = "Width of the destination tile marker border.",
		position = 4,
		section = destinationTile
	)
	default double destinationTileBorderWidth()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "highlightHoveredTile",
		name = "Highlight hovered tile",
		description = "Highlights tile player is hovering with mouse.",
		position = 1,
		section = hoveredTile
	)
	default boolean highlightHoveredTile()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightHoveredColor",
		name = "Highlight color",
		description = "Configures the highlight color of hovered tile.",
		position = 2,
		section = hoveredTile
	)
	default Color highlightHoveredColor()
	{
		return new Color(0, 0, 0, 0);
	}

	@Alpha
	@ConfigItem(
		keyName = "hoveredTileFillColor",
		name = "Fill color",
		description = "Configures the fill color of hovered tile.",
		position = 3,
		section = hoveredTile
	)
	default Color hoveredTileFillColor()
	{
		return new Color(0, 0, 0, 50);
	}

	@ConfigItem(
		keyName = "hoveredTileBorderWidth",
		name = "Border width",
		description = "Width of the hovered tile marker border.",
		position = 4,
		section = hoveredTile
	)
	default double hoveredTileBorderWidth()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "highlightCurrentTile",
		name = "Highlight true tile",
		description = "Highlights true tile player is on as seen by server.",
		position = 1,
		section = currentTile
	)
	default boolean highlightCurrentTile()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightCurrentColor",
		name = "Highlight color",
		description = "Configures the highlight color of current true tile.",
		position = 2,
		section = currentTile
	)
	default Color highlightCurrentColor()
	{
		return Color.CYAN;
	}

	@Alpha
	@ConfigItem(
		keyName = "currentTileFillColor",
		name = "Fill color",
		description = "Configures the fill color of current true tile.",
		position = 3,
		section = currentTile
	)
	default Color currentTileFillColor()
	{
		return new Color(0, 0, 0, 50);
	}

	@ConfigItem(
		keyName = "currentTileBorderWidth",
		name = "Border width",
		description = "Width of the true tile marker border.",
		position = 4,
		section = currentTile
	)
	default double currentTileBorderWidth()
	{
		return 2;
	}
}
