/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;
import net.runelite.client.util.ImageUploadStyle;

@ConfigGroup("raids")
public interface RaidsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "raidsTimer",
		name = "Display elapsed raid time",
		description = "Display elapsed raid time"
	)
	default boolean raidsTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "pointsMessage",
		name = "Display points in chatbox after raid",
		description = "Display a message with total points, individual points and percentage at the end of a raid"
	)
	default boolean pointsMessage()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "scoutOverlay",
		name = "Show scout overlay",
		description = "Display an overlay that shows the current raid layout (when entering lobby)"
	)
	default boolean scoutOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "scoutOverlayAtBank",
		name = "Show scout overlay outside lobby",
		description = "Keep the overlay active while at the raids area"
	)
	default boolean scoutOverlayAtBank()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "scoutOverlayInRaid",
		name = "Show scout overlay inside raid",
		description = "Keep the overlay active while inside raid"
	)
	default boolean scoutOverlayInRaid()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "ccDisplay",
		name = "FC and World in scout overlay",
		description = "Display current Friends Chat and World in scouting overlay"
	)
	default boolean fcDisplay()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "whitelistedRooms",
		name = "Whitelisted rooms",
		description = "Display whitelisted rooms in green on the overlay. Separate with comma (full name)"
	)
	default String whitelistedRooms()
	{
		return "";
	}

	@ConfigItem(
		position = 7,
		keyName = "blacklistedRooms",
		name = "Blacklisted rooms",
		description = "Display blacklisted rooms in red on the overlay. Separate with comma (full name)"
	)
	default String blacklistedRooms()
	{
		return "";
	}

	@ConfigItem(
		position = 8,
		keyName = "enableRotationWhitelist",
		name = "Enable rotation whitelist",
		description = "Enable the rotation whitelist"
	)
	default boolean enableRotationWhitelist()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "whitelistedRotations",
		name = "Whitelisted rotations",
		description = "Warn when boss rotation doesn't match a whitelisted one. Add rotations like: tekton, muttadiles, guardians - each rotation on its own line"
	)
	default String whitelistedRotations()
	{
		return "";
	}

	@ConfigItem(
		position = 10,
		keyName = "enableLayoutWhitelist",
		name = "Enable layout whitelist",
		description = "Enable the layout whitelist"
	)
	default boolean enableLayoutWhitelist()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "whitelistedLayouts",
		name = "Whitelisted layouts",
		description = "Warn when layout doesn't match a whitelisted one. Add layouts like CFSCPPCSCF separated with comma"
	)
	default String whitelistedLayouts()
	{
		return "";
	}

	@ConfigItem(
		position = 12,
		keyName = "layoutMessage",
		name = "Send raid layout message when entering raid",
		description = "Sends game message with raid layout on entering new raid"
	)
	default boolean layoutMessage()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "showLootValue",
		name = "Show Loot Value",
		description = "Shows the value of your loot at the end of a raid"
	)
	default boolean showLootValue()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "screenshotHotkey",
		name = "Scouter screenshot hotkey",
		description = "Hotkey used to screenshot the scouting overlay"
	)
	default Keybind screenshotHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		position = 15,
		keyName = "uploadScreenshot",
		name = "Upload scouting screenshot",
		description = "Uploads the scouting screenshot to Imgur or the clipboard"
	)
	default ImageUploadStyle uploadScreenshot()
	{
		return ImageUploadStyle.CLIPBOARD;
	}
}
