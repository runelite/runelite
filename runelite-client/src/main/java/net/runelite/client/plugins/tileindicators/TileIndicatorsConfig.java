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
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tileindicators")
public interface TileIndicatorsConfig extends Config
{
	@ConfigItem(
		keyName = "highlightCurrentLocation",
		name = "Highlight current tile",
		description = "Enable/disable current location highlighting",
		position = 1
	)
	default boolean highlightCurrentLocation()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightCurrentLocationColor",
		name = "Color of current tile highlighting",
		description = "Configures the highlight color of current location",
		position = 2
	)
	default Color highlightCurrentLocationColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "highlightDestination",
		name = "Highlight destination tile",
		description = "Enable/disable destination highlighting",
		position = 3
	)
	default boolean highlightDestination()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightDestinationColor",
		name = "Color of current destination highlighting",
		description = "Configures the highlight color of current destination",
		position = 4
	)
	default Color highlightDestinationColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "highlightMousePosition",
		name = "Highlight tile under mouse cursor",
		description = "Enable/disable highlighting destination highlighting",
		position = 5
	)
	default boolean highlightMousePosition()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightMousePositionColor",
		name = "Color of mouse cursor tile highlighting",
		description = "Configures the highlight color of tile under mouse cursor",
		position = 6
	)
	default Color highlightMousePositionColor()
	{
		return Color.GRAY;
	}
}
