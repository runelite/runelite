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
	@ConfigSection(name = "Target ping (default)", description = "Configure default target ping.", position = 6)
	String SECTION_TARGET_PING = "targetPing";
	@ConfigSection(name = "Danger ping", description = "Configure danger ping.", position = 9)
	String SECTION_DANGER_PING = "dangerPing";
	@ConfigSection(name = "Destination ping", description = "Configure destination ping.", position = 13)
	String SECTION_DESTINATION_PING = "destinationPing";
	@ConfigSection(name = "Request ping", description = "Configure request ping.", position = 18)
	String SECTION_REQUEST_PING = "requestPing";
	@ConfigSection(name = "Question ping", description = "Configure question ping.", position = 22)
	String SECTION_QUESTION_PING = "questionPing";
	@ConfigSection(name = "Player status overlay", description = "Player status such as health, prayer, and special attack energy drawn on player models.", position = 26)
	String SECTION_STATUS_OVERLAY = "statusOverlay";

	@ConfigItem(keyName = "pings", name = "Pings", description = "Enables party pings.<br>" + "To ping, hold the ping hotkey down and click on the tile you want to ping.", position = 1)
	default boolean recolorNames()
	{
		return true;
	}

	@ConfigItem(keyName = "sounds", name = "Sound on ping", description = "Enables sound notification on party ping.", position = 2)
	default boolean pings()
	{
		return true;
	}

	@ConfigItem(keyName = "advancedPingMenu", name = "Enable advanced ping menu", description = "Enables opening advanced ping menu by dragging the mouse after selecting a target", position = 3)
	default boolean advancedPingMenu()
	{
		return true;
	}

	@ConfigItem(keyName = "pingHotkey", name = "Ping hotkey", description = "Key to hold to send a tile ping.<br>" + "To ping, hold the ping hotkey down and click on the tile you want to ping.", position = 4)
	default Keybind pingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(keyName = "pingDuration", name = "Ping duration", description = "How long pings are visible for, in seconds", position = 5)
	default double pingDuration()
	{
		return 1.5;
	}

	@ConfigItem(section = SECTION_TARGET_PING, keyName = "targetPingSound", name = "Enable sound", description = "Enables sound notification on target ping", position = 7)
	default boolean targetPingSound()
	{
		return true;
	}

	@ConfigItem(section = SECTION_TARGET_PING, keyName = "targetPingColor", name = "Target ping color", description = "Color of incoming target pings", position = 8)
	default Color targetPingColor()
	{
		return null;
	}

	@ConfigItem(section = SECTION_DANGER_PING, keyName = "dangerPingSound", name = "Enable sound", description = "Enables sound notification on danger ping", position = 10)
	default boolean dangerPingSound()
	{
		return true;
	}

	@ConfigItem(section = SECTION_DANGER_PING, keyName = "dangerPingColor", name = "Danger ping color", description = "Color of incoming danger pings", position = 11)
	default Color dangerPingColor()
	{
		return Color.RED;
	}

	@ConfigItem(section = SECTION_DANGER_PING, keyName = "dangerPingHotkey", name = "Danger ping hotkey", description = "Key to hold to send a danger ping", position = 12)
	default Keybind dangerPingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(section = SECTION_DESTINATION_PING, keyName = "destinationLine", name = "Draw line", description = "Draw a line between source player and destination", position = 14)
	default boolean drawDestinationLine()
	{
		return true;
	}

	@ConfigItem(section = SECTION_DESTINATION_PING, keyName = "destinationPingSound", name = "Enable sound", description = "Enables sound notification on destination ping", position = 15)
	default boolean destinationPingSound()
	{
		return true;
	}

	@ConfigItem(section = SECTION_DESTINATION_PING, keyName = "destinationPingColor", name = "Destination ping color", description = "Color of incoming destination pings", position = 16)
	default Color destinationPingColor()
	{
		return null;
	}

	@ConfigItem(section = SECTION_DESTINATION_PING, keyName = "destinationPingHotkey", name = "Destination ping hotkey", description = "Key to hold to send a destination ping", position = 17)
	default Keybind destinationPingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(section = SECTION_REQUEST_PING, keyName = "requestPingSound", name = "Enable sound", description = "Enables sound notification on request ping", position = 19)
	default boolean requestPingSound()
	{
		return true;
	}

	@ConfigItem(section = SECTION_REQUEST_PING, keyName = "requestPingColor", name = "Request ping color", description = "Color of incoming request pings", position = 20)
	default Color requestPingColor()
	{
		return null;
	}

	@ConfigItem(section = SECTION_REQUEST_PING, keyName = "requestPingHotkey", name = "Request ping hotkey", description = "Key to hold to send a request ping", position = 21)
	default Keybind requestPingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(section = SECTION_QUESTION_PING, keyName = "questionPingSound", name = "Enable sound", description = "Enables sound notification on question ping", position = 23)
	default boolean questionPingSound()
	{
		return true;
	}

	@ConfigItem(section = SECTION_QUESTION_PING, keyName = "questionPingColor", name = "Question ping color", description = "Color of incoming question pings", position = 24)
	default Color questionPingColor()
	{
		return null;
	}

	@ConfigItem(section = SECTION_QUESTION_PING, keyName = "questionPingHotkey", name = "Question ping hotkey", description = "Key to hold to send an question ping", position = 25)
	default Keybind questionPingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(keyName = "memberColor", name = "Self-color", description = "Which color you will appear as in the party panel and tile pings.", position = 5)
	Color memberColor();

	@ConfigItem(keyName = "memberColor", name = "", description = "", position = 5)
	void setMemberColor(Color newMemberColor);

	@ConfigItem(section = SECTION_STATUS_OVERLAY, keyName = "statusOverlayHealth", name = "Show health", description = "Show health of party members on the player model.", position = 27)
	default boolean statusOverlayHealth()
	{
		return false;
	}

	@ConfigItem(section = SECTION_STATUS_OVERLAY, keyName = "statusOverlayPrayer", name = "Show prayer", description = "Show prayer of party members on the player model.", position = 28)
	default boolean statusOverlayPrayer()
	{
		return false;
	}

	@ConfigItem(section = SECTION_STATUS_OVERLAY, keyName = "statusOverlayStamina", name = "Show run energy", description = "Show run energy (stamina) of party members on the player model.", position = 29)
	default boolean statusOverlayStamina()
	{
		return false;
	}

	@ConfigItem(section = SECTION_STATUS_OVERLAY, keyName = "statusOverlaySpec", name = "Show spec energy", description = "Show special attack energy of party members on the player model.", position = 30)
	default boolean statusOverlaySpec()
	{
		return false;
	}

	@ConfigItem(section = SECTION_STATUS_OVERLAY, keyName = "statusOverlayVeng", name = "Show vengeance", description = "Show vengeance status (active/inactive) of party members on the player model.", position = 31)
	default boolean statusOverlayVeng()
	{
		return true;
	}

	@ConfigItem(section = SECTION_STATUS_OVERLAY, keyName = "statusOverlayRenderSelf", name = "Show on self", description = "Show above activated status overlays on your local player.", position = 32)
	default boolean statusOverlayRenderSelf()
	{
		return true;
	}

	@ConfigItem(keyName = "previousPartyId", name = "", description = "", hidden = true)
	default String previousPartyId()
	{
		return "";
	}

	@ConfigItem(keyName = "previousPartyId", name = "", description = "", hidden = true)
	void setPreviousPartyId(String id);
}
