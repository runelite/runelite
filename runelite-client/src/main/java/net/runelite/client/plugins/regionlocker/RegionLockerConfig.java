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
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup(RegionLockerPlugin.CONFIG_KEY)
public interface RegionLockerConfig extends Config
{
	@ConfigItem(
			keyName = "Karamja",
			name = "Show Karamja",
			description = "Unlock all Karamja regions",
			position = -1
	)
	default boolean showKaramja()
	{
		return true;
	}

	@ConfigItem(
			keyName = "renderLockedRegions",
			name = "Enable gray chunks",
			description = "Adds graphical change to all chunk that are locked",
			position = 0
	)
	default boolean renderLockedRegions()
	{
		return true;
	}

	@ConfigItem(
			keyName = "renderRegionBorders",
			name = "Render chunk borders",
			description = "Draws the chunk borders in the environment",
			position = 1
	)
	default boolean renderRegionBorders()
	{
		return false;
	}

	@ConfigItem(
			keyName = "chunkCommand",
			name = "Chunks command",
			description = "Configures whether the chunk command is enabled<br> This command shows your total unlocked chunks<br> !chunks",
			position = 2
	)
	default boolean chunkCommand()
	{
		return true;
	}

	@ConfigItem(
			keyName = "unlockUnderground",
			name = "Unlock underground",
			description = "Unlock all underground chunks",
			position = 4
	)
	default boolean unlockUnderground()
	{
		return true;
	}

	@ConfigItem(
			keyName = "unlockRealms",
			name = "Unlock realms",
			description = "Unlock all realm chunks like Zanaris and the TzHaar area",
			position = 5
	)
	default boolean unlockRealms()
	{
		return true;
	}

	@ConfigItem(
			keyName = "drawMapOverlay",
			name = "Draw chunks on map",
			description = "Draw a color overlay for each locked/unlocked chunk",
			position = 6
	)
	default boolean drawMapOverlay()
	{
		return true;
	}

	@ConfigItem(
			keyName = "invertMapOverlay",
			name = "Invert map overlay",
			description = "Switches which chunks the map will draw the color overlay for (true = locked, false = unlocked)",
			position = 7
	)
	default boolean invertMapOverlay()
	{
		return true;
	}

	@ConfigItem(
			keyName = "hardBorder",
			name = "Hard chunk border cutoff",
			description = "Switches which chunks the map will draw the color overlay for (true = locked, false = unlocked)",
			position = 8
	)
	default boolean hardBorder()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
			keyName = "shaderGrayColor",
			name = "Chunk shader color",
			description = "The color of the locked chunks in the shader",
			position = 9
	)
	default Color shaderGrayColor()
	{
		return new Color(0, 31, 77, 204);
	}

	@Alpha
	@ConfigItem(
			keyName = "shaderGrayAmount",
			name = "Chunk gray opacity",
			description = "The amount of gray scale that is applied to a locked chunk in the shader (alpha only)",
			position = 10
	)
	default Color shaderGrayAmount()
	{
		return new Color(0, 0, 0, 204);
	}

	@Alpha
	@ConfigItem(
			keyName = "mapOverlayColor",
			name = "Map overlay color",
			description = "The color the map overlay will draw the chunks in",
			position = 11
	)
	default Color mapOverlayColor()
	{
		return new Color(200, 16, 0, 100);
	}

	@Alpha
	@ConfigItem(
			keyName = "unlockableOverlayColor",
			name = "Unlockable overlay color",
			description = "The color the map overlay will draw the unlockable chunks in",
			position = 12
	)
	default Color unlockableOverlayColor()
	{
		return new Color(60, 200, 160, 100);
	}

	@Alpha
	@ConfigItem(
			keyName = "blacklistedOverlayColor",
			name = "Blacklisted overlay color",
			description = "The color the map overlay will draw the blacklisted chunks in",
			position = 13
	)
	default Color blacklistedOverlayColor()
	{
		return new Color(0, 0, 0, 200);
	}

	@Alpha
	@ConfigItem(
			keyName = "regionBorderColor",
			name = "Chunk border color",
			description = "The color of the chunk borders",
			position = 14
	)
	default Color regionBorderColor()
	{
		return new Color(0, 200, 83, 200);
	}

	@ConfigItem(
			keyName = "regionBorderWidth",
			name = "Chunk border width",
			description = "How wide the region border will be",
			position = 15
	)
	default int regionBorderWidth()
	{
		return 1;
	}

	@ConfigItem(
			keyName = "drawMapGrid",
			name = "Draw map grid",
			description = "Draw the grid of chunks on the map",
			position = 16
	)
	default boolean drawMapGrid()
	{
		return true;
	}

	@ConfigItem(
			keyName = "drawRegionId",
			name = "Draw region IDs",
			description = "Draw the chunk ID for each chunk on the map",
			position = 17
	)
	default boolean drawRegionId()
	{
		return true;
	}

	@ConfigItem(
			keyName = "chunkPickerButton",
			name = "Enable Chunk Picker button",
			description = "Adds a button in the navigation bar to go to the Chunk Picker website",
			position = 18
	)
	default boolean chunkPickerButton()
	{
		return true;
	}

	@ConfigItem(
			keyName = "unlockKey",
			name = "Unlock hotkey",
			description = "When you hold this key you can click on the map to unlock a chunk",
			position = 19
	)
	default Keybind unlockKey()
	{
		return Keybind.SHIFT;
	}

	@ConfigItem(
			keyName = "blacklistKey",
			name = "Blacklist hotkey",
			description = "When you hold this key you can click on the map to blacklist a chunk",
			position = 20
	)
	default Keybind blacklistKey()
	{
		return Keybind.CTRL;
	}

	@ConfigItem(
			keyName = "unlockedRegions",
			name = "Unlocked chunks",
			description = "List of unlocked regions seperated by a ',' symbol",
			position = 21
	)
	default String unlockedRegions()
	{
		return "";
	}

	@ConfigItem(
			keyName = "unlockableRegions",
			name = "Unlockable chunks",
			description = "List of unlockable regions seperated by a ',' symbol",
			position = 22
	)
	default String unlockableRegions()
	{
		return "";
	}

	@ConfigItem(
			keyName = "blacklistedRegions",
			name = "Blacklisted chunks",
			description = "List of blacklisted regions seperated by a ',' symbol",
			position = 23
	)
	default String blacklistedRegions()
	{
		return "";
	}
}
