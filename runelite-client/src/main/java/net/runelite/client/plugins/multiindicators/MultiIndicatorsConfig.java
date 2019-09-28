/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
 * Copyright (c) 2019, Enza-Denino <https://github.com/Enza-Denino>
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
package net.runelite.client.plugins.multiindicators;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("multiindicators")
public interface MultiIndicatorsConfig extends Config
{
	@ConfigItem(
		keyName = "multicombatZoneVisibility",
		name = "Multicombat zones",
		description = "Determine where multicombat zones should be shown",
		position = 1
	)
	default ZoneVisibility multicombatZoneVisibility()
	{
		return ZoneVisibility.SHOW_IN_PVP;
	}

	@ConfigItem(
		keyName = "pvpSafeZones",
		name = "PvP safe zones",
		description = "Show safe zones in PvP worlds",
		position = 2
	)
	default boolean showPvpSafeZones()
	{
		return true;
	}

	@ConfigItem(
		keyName = "deadmanSafeZones",
		name = "Deadman safe zones",
		description = "Show safe zones in Deadman worlds",
		position = 3
	)
	default boolean showDeadmanSafeZones()
	{
		return true;
	}

	@ConfigItem(
		keyName = "wildernessLevelLines",
		name = "Wilderness level lines",
		description = "Show wilderness level lines",
		position = 4
	)
	default boolean showWildernessLevelLines()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showMinimapLines",
		name = "Show on minimap",
		description = "Show multicombat and safe zones on the minimap",
		position = 5
	)
	default boolean showMinimapLines()
	{
		return true;
	}

	@ConfigItem(
		keyName = "multicombatColor",
		name = "Multicombat zone color",
		description = "Choose color to use for marking multicombat zones",
		position = 6
	)
	default Color multicombatColor()
	{
		return Color.MAGENTA;
	}

	@ConfigItem(
		keyName = "safeZoneColor",
		name = "Safe zone color",
		description = "Choose color to use for marking safe zones in PvP/Deadman",
		position = 7
	)
	default Color safeZoneColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "wildernessLevelLinesColor",
		name = "Wilderness level lines color",
		description = "Choose color to use for marking wilderness level lines",
		position = 8
	)
	default Color wildernessLevelLinesColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "thinnerLines",
		name = "Thin lines",
		description = "Render multi lines, safe zone lines, and wildy level lines as 1 pixel wide instead of 2",
		position = 9
	)
	default boolean thinnerLines()
	{
		return false;
	}

}