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

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

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
		keyName = "whitelistedRooms",
		name = "Whitelisted rooms",
		description = "Display whitelisted rooms in green on the overlay. Separate with comma (full name)"
	)
	default String whitelistedRooms()
	{
		return "";
	}

	@ConfigItem(
		position = 6,
		keyName = "blacklistedRooms",
		name = "Blacklisted rooms",
		description = "Display blacklisted rooms in red on the overlay. Separate with comma (full name)"
	)
	default String blacklistedRooms()
	{
		return "";
	}

	@ConfigItem(
		position = 7,
		keyName = "enableRotationWhitelist",
		name = "Enable rotation whitelist",
		description = "Enable the rotation whitelist"
	)
	default boolean enableRotationWhitelist()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "whitelistedRotations",
		name = "Whitelisted rotations",
		description = "Warn when boss rotation doesn't match a whitelisted one. Add rotations like [tekton, muttadile, guardians]"
	)
	default String whitelistedRotations()
	{
		return "";
	}

	@ConfigItem(
		position = 9,
		keyName = "enableLayoutWhitelist",
		name = "Enable layout whitelist",
		description = "Enable the layout whitelist"
	)
	default boolean enableLayoutWhitelist()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "whitelistedLayouts",
		name = "Whitelisted layouts",
		description = "Warn when layout doesn't match a whitelisted one. Add layouts like CFSCPPCSCF separated with comma"
	)
	default String whitelistedLayouts()
	{
		return "";
	}

	@ConfigItem(
		position = 11,
		keyName = "showScavsFarms",
		name = "Show scavengers and farming",
		description = "Adds scavengers and farming to the room breakdown"
	)
	default boolean showScavsFarms()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "enhanceScouterTitle",
		name = "Enhance scouter title",
		description = "Adds #combat and good puzzles to scouter title"
	)
	default boolean enhanceScouterTitle()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "enableSharableImage",
		name = "Enable sharable image",
		description = "Use the specified hotkey to capture the raid scouter"
	)
	default boolean enableSharableImage()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "hotkey",
		name = "Capture hotkey",
		description = "Hotkey used to capture the scouter"
	)
	default Keybind hotkey()
	{
		return new Keybind(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		position = 15,
		keyName = "enableTrayNotification",
		name = "Enable tray notification",
		description = "Adds a system tray notification on successful screen capture"
	)
	default boolean enableTrayNotification()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "showRecommendedItems",
		name = "Show recommended items",
		description = "Adds overlay with recommended items to scouter"
	)
	default boolean showRecommendedItems()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "recommendedItems",
		name = "Recommended items",
		description = "User-set recommended items in the form: [muttadiles,ice barrage,zamorak godsword],[tekton,elder maul], ..."
	)
	default String recommendedItems()
	{
		return "";
	}

	@ConfigItem(
		position = 18,
		keyName = "scavsBeforeIce",
		name = "Show last scavs for Ice Demon",
		description = "Highlights final scavengers before Ice Demon"
	)
	default boolean scavsBeforeIce()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "scavsBeforeOlm",
		name = "Show last scavs for Olm",
		description = "Highlights final scavengers before Olm"
	)
	default boolean scavsBeforeOlm()
	{
		return false;
	}

	@ConfigItem(
		position = 20,
		keyName = "scavPrepColor",
		name = "Last scavs color",
		description = "The color of the final scavs before Ice Demon/Olm"
	)
	default Color scavPrepColor()
	{
		return new Color(130, 222, 255); //light blue
	}

	@ConfigItem(
		position = 21,
		keyName = "alwaysShowWorldAndCC",
		name = "Always show CC and World",
		description = "The CC and World are not removed from being in the in-game scouter"
	)
	default boolean alwaysShowWorldAndCC()
	{
		return false;
	}

	@ConfigItem(
		position = 22,
		keyName = "colorTightrope",
		name = "Color tightrope",
		description = "Colors tightrope a separate color"
	)
	default boolean colorTightrope()
	{
		return false;
	}

	@ConfigItem(
		position = 23,
		keyName = "tightropeColor",
		name = "Tightrope color",
		description = "The color of tightropes"
	)
	default Color tightropeColor()
	{
		return Color.MAGENTA;
	}

	@ConfigItem(
		position = 24,
		keyName = "hideRopeless",
		name = "Hide no Tightrope raids",
		description = "Completely hides raids with no tightrope"
	)
	default boolean hideRopeless()
	{
		return false;
	}
}
