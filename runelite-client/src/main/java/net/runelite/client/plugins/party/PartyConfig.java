/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
 * Copyright (c) 2022, kamielvf <code@kamiel.dev>
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
package net.runelite.client.plugins.party;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;

@ConfigGroup(PartyConfig.GROUP)
public interface PartyConfig extends Config
{
	String GROUP = "party";

	@ConfigItem(
		keyName = "recolorNames",
		name = "Recolor names",
		description = "Recolor party members names based on unique color hash",
		position = 1
	)
	default boolean recolorNames()
	{
		return true;
	}

	@ConfigItem(
		keyName = "pings",
		name = "Enable pings",
		description = "Enables party pings",
		position = 2
	)
	default boolean pings()
	{
		return true;
	}

	@ConfigItem(
		keyName = "advancedPingMenu",
		name = "Enable advanced ping menu",
		description = "Enables opening advanced ping menu by dragging the mouse after selecting a target",
		position = 3
	)
	default boolean advancedPingMenu()
	{
		return true;
	}

	@ConfigItem(
		keyName = "pingHotkey",
		name = "Ping hotkey",
		description = "Key to hold to send a ping",
		position = 4
	)
	default Keybind pingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigSection(
		name = "Target ping (default)",
		description = "Configure default target ping.",
		position = 5
	)
	String SECTION_TARGET_PING = "targetPing";

	@ConfigItem(
		section = SECTION_TARGET_PING,
		keyName = "targetPingSound",
		name = "Enable sound",
		description = "Enables sound notification on target ping",
		position = 6
	)
	default boolean targetPingSound()
	{
		return true;
	}

	@ConfigItem(
		section = SECTION_TARGET_PING,
		keyName = "targetPingColor",
		name = "Target ping color",
		description = "Color of incoming target pings",
		position = 7
	)
	default Color targetPingColor()
	{
		return null;
	}

	@ConfigSection(
		name = "Danger ping",
		description = "Configure danger ping.",
		position = 8
	)
	String SECTION_DANGER_PING = "dangerPing";

	@ConfigItem(
		section = SECTION_DANGER_PING,
		keyName = "dangerPingSound",
		name = "Enable sound",
		description = "Enables sound notification on danger ping",
		position = 9
	)
	default boolean dangerPingSound()
	{
		return true;
	}

	@ConfigItem(
		section = SECTION_DANGER_PING,
		keyName = "dangerPingColor",
		name = "Danger ping color",
		description = "Color of incoming danger pings",
		position = 10
	)
	default Color dangerPingColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		section = SECTION_DANGER_PING,
		keyName = "dangerPingHotkey",
		name = "Danger ping hotkey",
		description = "Key to hold to send a danger ping",
		position = 11
	)
	default Keybind dangerPingHotkey()
	{
		return Keybind.NOT_SET;
	}
	@ConfigSection(
		name = "Destination ping",
		description = "Configure destination ping.",
		position = 12
	)
	String SECTION_DESTINATION_PING = "destinationPing";

	@ConfigItem(
		section = SECTION_DESTINATION_PING,
		keyName = "destinationLine",
		name = "Draw line",
		description = "Draw a line between source player and destination",
		position = 13
	)
	default boolean drawDestinationLine()
	{
		return true;
	}

	@ConfigItem(
		section = SECTION_DESTINATION_PING,
		keyName = "destinationPingSound",
		name = "Enable sound",
		description = "Enables sound notification on destination ping",
		position = 14
	)
	default boolean destinationPingSound()
	{
		return true;
	}

	@ConfigItem(
		section = SECTION_DESTINATION_PING,
		keyName = "destinationPingColor",
		name = "Destination ping color",
		description = "Color of incoming destination pings",
		position = 15
	)
	default Color destinationPingColor()
	{
		return null;
	}

	@ConfigItem(
		section = SECTION_DESTINATION_PING,
		keyName = "destinationPingHotkey",
		name = "Destination ping hotkey",
		description = "Key to hold to send a destination ping",
		position = 16
	)
	default Keybind destinationPingHotkey()
	{
		return Keybind.NOT_SET;
	}
	@ConfigSection(
		name = "Request ping",
		description = "Configure request ping.",
		position = 17
	)
	String SECTION_REQUEST_PING = "requestPing";

	@ConfigItem(
		section = SECTION_REQUEST_PING,
		keyName = "requestPingSound",
		name = "Enable sound",
		description = "Enables sound notification on request ping",
		position = 18
	)
	default boolean requestPingSound()
	{
		return true;
	}

	@ConfigItem(
		section = SECTION_REQUEST_PING,
		keyName = "requestPingColor",
		name = "Request ping color",
		description = "Color of incoming request pings",
		position = 19
	)
	default Color requestPingColor()
	{
		return null;
	}

	@ConfigItem(
		section = SECTION_REQUEST_PING,
		keyName = "requestPingHotkey",
		name = "Request ping hotkey",
		description = "Key to hold to send a request ping",
		position = 20
	)
	default Keybind requestPingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigSection(
		name = "Question ping",
		description = "Configure question ping.",
		position = 21
	)
	String SECTION_QUESTION_PING = "questionPing";

	@ConfigItem(
		section = SECTION_QUESTION_PING,
		keyName = "questionPingSound",
		name = "Enable sound",
		description = "Enables sound notification on question ping",
		position = 22
	)
	default boolean questionPingSound()
	{
		return true;
	}

	@ConfigItem(
		section = SECTION_QUESTION_PING,
		keyName = "questionPingColor",
		name = "Question ping color",
		description = "Color of incoming question pings",
		position = 23
	)
	default Color questionPingColor()
	{
		return null;
	}

	@ConfigItem(
		section = SECTION_QUESTION_PING,
		keyName = "questionPingHotkey",
		name = "Question ping hotkey",
		description = "Key to hold to send an question ping",
		position = 24
	)
	default Keybind questionPingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigSection(
		name = "Player Status Overlay",
		description = "Player status such as health, prayer, and special attack energy drawn on player models.",
		position = 25
	)
	String SECTION_STATUS_OVERLAY = "statusOverlay";

	@ConfigItem(
		section = SECTION_STATUS_OVERLAY,
		keyName = "statusOverlayHealth",
		name = "Show Health",
		description = "Show health of party members on the player model.",
		position = 26
	)
	default boolean statusOverlayHealth()
	{
		return false;
	}

	@ConfigItem(
		section = SECTION_STATUS_OVERLAY,
		keyName = "statusOverlayPrayer",
		name = "Show Prayer",
		description = "Show prayer of party members on the player model.",
		position = 27
	)
	default boolean statusOverlayPrayer()
	{
		return false;
	}

	@ConfigItem(
		section = SECTION_STATUS_OVERLAY,
		keyName = "statusOverlayStamina",
		name = "Show Run Energy",
		description = "Show run energy (stamina) of party members on the player model.",
		position = 28
	)
	default boolean statusOverlayStamina()
	{
		return false;
	}

	@ConfigItem(
		section = SECTION_STATUS_OVERLAY,
		keyName = "statusOverlaySpec",
		name = "Show Spec Energy",
		description = "Show special attack energy of party members on the player model.",
		position = 29
	)
	default boolean statusOverlaySpec()
	{
		return false;
	}

	@ConfigItem(
		section = SECTION_STATUS_OVERLAY,
		keyName = "statusOverlayVeng",
		name = "Show Vengeance",
		description = "Show vengeance status (active/inactive) of party members on the player model.",
		position = 30
	)
	default boolean statusOverlayVeng()
	{
		return true;
	}

	@ConfigItem(
		section = SECTION_STATUS_OVERLAY,
		keyName = "statusOverlayRenderSelf",
		name = "Show On Self",
		description = "Show above activated status overlays on your local player.",
		position = 31
	)
	default boolean statusOverlayRenderSelf()
	{
		return true;
	}

	@ConfigItem(
		keyName = "previousPartyId",
		name = "",
		description = "",
		hidden = true
	)
	default String previousPartyId()
	{
		return "";
	}

	@ConfigItem(
		keyName = "previousPartyId",
		name = "",
		description = "",
		hidden = true
	)
	void setPreviousPartyId(String id);
}
