/*
 * Copyright (c) 2019, Slay to Stay <https://github.com/slaytostay>
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
package net.runelite.client.plugins.regionlocker;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup(RegionLockerPlugin.CONFIG_KEY)
public interface RegionLockerConfig extends Config
{
	@ConfigItem(
			keyName = "renderLockedRegions",
			name = "Render locked regions",
			description = "Adds graphical change to all regions that are not in the unlocked region list",
			position = 0
	)
	default boolean renderLockedRegions()
	{
		return true;
	}

	@ConfigItem(
			keyName = "renderRegionBorders",
			name = "Render region borders",
			description = "Draws the region borders in the environment",
			position = 1
	)
	default boolean renderRegionBorders()
	{
		return false;
	}

	@ConfigItem(
			keyName = "chunkCommand",
			name = "Chunk command",
			description = "Configures whether the chunk command is enabled<br> This command shows your total unlocked chunks<br> !chunk",
			position = 2
	)
	default boolean chunkCommand()
	{
		return true;
	}

	@ConfigItem(
			keyName = "unlockUnderground",
			name = "Unlock underground",
			description = "Unlock all underground areas",
			position = 4
	)
	default boolean unlockUnderground()
	{
		return true;
	}

	@ConfigItem(
			keyName = "unlockRealms",
			name = "Unlock realms",
			description = "Unlock all realms like Zanaris and the TzHaar area",
			position = 5
	)
	default boolean unlockRealms()
	{
		return true;
	}

	@ConfigItem(
			keyName = "drawMapOverlay",
			name = "Draw regions on map",
			description = "Draw a color overlay for each locked/unlocked region",
			position = 6
	)
	default boolean drawMapOverlay()
	{
		return true;
	}

	@ConfigItem(
			keyName = "invertMapOverlay",
			name = "Invert map overlay",
			description = "Switches which regions the map will draw the color overlay for (true = locked, false = unlocked)",
			position = 7
	)
	default boolean invertMapOverlay()
	{
		return true;
	}

	@ConfigItem(
			keyName = "mapOverlayColor",
			name = "Map overlay color",
			description = "The color the map overlay will draw the regions in",
			position = 8
	)
	default Color mapOverlayColor()
	{
		return new Color(200, 16, 0, 100);
	}

	@ConfigItem(
			keyName = "mapOverlayAlpha",
			name = "Map overlay alpha",
			description = "How transparent the map overlay will be (0-255)",
			position = 9
	)
	default int mapOverlayAlpha()
	{
		return 100;
	}

	@ConfigItem(
			keyName = "unlockableOverlayColor",
			name = "Unlockable overlay color",
			description = "The color the map overlay will draw the unlockable regions in",
			position = 10
	)
	default Color unlockableOverlayColor()
	{
		return new Color(60, 200, 160, 100);
	}

	@ConfigItem(
			keyName = "unlockableOverlayAlpha",
			name = "Map overlay alpha",
			description = "How transparent the map overlay for unlockable regions will be (0-255)",
			position = 11
	)
	default int unlockableOverlayAlpha()
	{
		return 100;
	}

	@ConfigItem(
			keyName = "blacklistedOverlayColor",
			name = "Blacklisted overlay color",
			description = "The color the map overlay will draw the blacklisted regions in",
			position = 12
	)
	default Color blacklistedOverlayColor()
	{
		return new Color(0, 0, 0, 200);
	}

	@ConfigItem(
			keyName = "blacklistedOverlayAlpha",
			name = "Blacklisted overlay alpha",
			description = "How transparent the map overlay for blacklisted regions will be (0-255)",
			position = 13
	)
	default int blacklistedOverlayAlpha()
	{
		return 200;
	}

	@ConfigItem(
			keyName = "regionBorderColor",
			name = "Region border color",
			description = "The color of the region borders",
			position = 14
	)
	default Color regionBorderColor()
	{
		return new Color(0, 200, 83, 200);
	}

	@ConfigItem(
			keyName = "regionBorderAlpha",
			name = "Region border alpha",
			description = "How transparent the region borders will be (0-255)",
			position = 15
	)
	default int regionBorderAlpha()
	{
		return 200;
	}

	@ConfigItem(
			keyName = "regionBorderWidth",
			name = "Region border width",
			description = "How wide the region border will be",
			position = 16
	)
	default int regionBorderWidth()
	{
		return 4;
	}

	@ConfigItem(
			keyName = "drawMapGrid",
			name = "Draw map grid",
			description = "Draw the grid of regions on the map",
			position = 17
	)
	default boolean drawMapGrid()
	{
		return true;
	}

	@ConfigItem(
			keyName = "drawRegionId",
			name = "Draw region IDs",
			description = "Draw the region ID for each region on the map",
			position = 18
	)
	default boolean drawRegionId()
	{
		return true;
	}

	@ConfigItem(
			keyName = "unlockKey",
			name = "Unlock hotkey",
			description = "When you hold this key you can click on the map to unlock a region",
			position = 19
	)
	default Keybind unlockKey()
	{
		return Keybind.SHIFT;
	}

	@ConfigItem(
			keyName = "blacklistKey",
			name = "Blacklist hotkey",
			description = "When you hold this key you can click on the map to blacklist a region",
			position = 20
	)
	default Keybind blacklistKey()
	{
		return Keybind.CTRL;
	}

	@ConfigItem(
			keyName = "unlockedRegions",
			name = "Unlocked regions",
			description = "List of unlocked regions seperated by a ',' symbol",
			position = 21
	)
	default String unlockedRegions()
	{
		return "";
	}

	@ConfigItem(
			keyName = "unlockableRegions",
			name = "Unlockable regions",
			description = "List of unlockable regions seperated by a ',' symbol",
			position = 22
	)
	default String unlockableRegions()
	{
		return "";
	}

	@ConfigItem(
			keyName = "blacklistedRegions",
			name = "Blacklisted regions",
			description = "List of blacklisted regions seperated by a ',' symbol",
			position = 23
	)
	default String blacklistedRegions()
	{
		return "";
	}
}
