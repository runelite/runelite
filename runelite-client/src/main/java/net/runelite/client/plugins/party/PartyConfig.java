/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
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
		keyName = "pings",
		name = "Pings",
		description = "Enables party pings",
		position = 1
	)
	default boolean pings()
	{
		return true;
	}

	@ConfigItem(
		keyName = "sounds",
		name = "Sound on ping",
		description = "Enables sound notification on party ping",
		position = 2
	)
	default boolean sounds()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recolorNames",
		name = "Recolor names",
		description = "Recolor party members names based on unique color hash",
		position = 3
	)
	default boolean recolorNames()
	{
		return true;
	}

	@ConfigItem(
		keyName = "pingHotkey",
		name = "Ping hotkey",
		description = "Key to hold to send a tile ping",
		position = 4
	)
	default Keybind pingHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		keyName = "memberColor",
		name = "Self-Color",
		description = "Which color you will appear as in the party panel and tile pings.",
		position = 5
	)
	Color memberColor();

	@ConfigItem(
		keyName = "memberColor",
		name = "",
		description = "",
		position = 5
	)
	void setMemberColor(Color newMemberColor);

	@ConfigSection(
		name = "Player Status Overlay",
		description = "Player status such as health, prayer, and special attack energy drawn on player models.",
		position = 100
	)
	String SECTION_STATUS_OVERLAY = "statusOverlay";

	@ConfigItem(
		section = SECTION_STATUS_OVERLAY,
		keyName = "statusOverlayHealth",
		name = "Show Health",
		description = "Show health of party members on the player model.",
		position = 101
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
		position = 102
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
		position = 103
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
		position = 104
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
		position = 105
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
		position = 106
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
