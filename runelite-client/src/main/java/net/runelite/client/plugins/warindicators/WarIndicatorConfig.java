/*
 * Copyright (c) 2018, Andrew EP | ElPinche256 <https://github.com/ElPinche256>
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
package net.runelite.client.plugins.warindicators;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("warIndicators")

public interface WarIndicatorConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "highLightCallers",
		name = "Highlight Callers",
		description = "Highlight listed caller(s)"
	)
	default boolean highLightCallers()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "callerColor",
		name = "Caller(s) Color",
		description = "Color to highlight caller's name"
	)
	default Color getCallerColor()
	{
		return new Color(36, 255, 237);
	}

	@ConfigItem(
		position = 2,
		keyName = "callerMinimap",
		name = "Callers on Minimap",
		description = "Show your caller(s) on the minimap"
	)
	default boolean callerMinimap()
	{
		return false;
	}


	@ConfigItem(
		position = 3,
		keyName = "callerTile",
		name = "Show Caller's Tile",
		description = "Show the tile your target is standing on"
	)
	default boolean callerTile()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "activeCallers",
		name = "Callers",
		description = "Adds a user to your caller list. Format: (caller), (caller)"
	)
	default String getActiveCallers()
	{
		return "";
	}

	@ConfigItem(
		position = 5,
		keyName = "activeCallers",
		name = "",
		description = ""
	)
	void setActiveCallers(String key);

	@ConfigItem(
		position = 6,
		keyName = "highlightSnipes",
		name = "Highlight Targets",
		description = "Highlight listed target(s)"
	)
	default boolean highlightSnipes()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "snipeColor",
		name = "Target(s) Color",
		description = "Color to highlight target name"
	)
	default Color getSnipeColor()
	{
		return new Color(255, 0, 0);
	}

	@ConfigItem(
		position = 8,
		keyName = "snipeMinimap",
		name = "Targets on Minimap",
		description = "Show your target on the minimap"
	)
	default boolean snipeMinimap()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "snipeTile",
		name = "Show Target's Tile",
		description = "Show the tile your target is standing on"
	)
	default boolean snipeTile()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "targetedSnipes",
		name = "Targets",
		description = "Adds a user to your snipe list. Format: (target), (target)"
	)
	default String getTargetedSnipes()
	{
		return "";
	}

	@ConfigItem(
		position = 11,
		keyName = "targetedSnipes",
		name = "",
		description = ""
	)
	void setTargetedSnipe(String key);
}