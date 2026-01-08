/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.npcunaggroarea;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Notification;

@ConfigGroup("npcUnaggroArea")
public interface NpcAggroAreaConfig extends Config
{
	String CONFIG_GROUP = "npcUnaggroArea";
	String CONFIG_CENTER1 = "center1";
	String CONFIG_CENTER2 = "center2";
	String CONFIG_LOCATION = "location";
	String CONFIG_DURATION = "duration";

	@ConfigItem(
		keyName = "npcUnaggroAlwaysActive",
		name = "Always active",
		description = "Always show this plugin's overlays.<br>Otherwise, they will only be shown when any NPC name matches the list.",
		position = 1
	)
	default boolean alwaysActive()
	{
		return false;
	}

	@ConfigItem(
		keyName = "npcUnaggroNames",
		name = "NPC names",
		description = "Enter names of NPCs where you wish to use this plugin.",
		position = 2
	)
	default String npcNamePatterns()
	{
		return "";
	}

	@ConfigItem(
		keyName = "npcUnaggroShowTimer",
		name = "Show timer",
		description = "Display a timer until NPCs become unaggressive.",
		position = 3
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "npcUnaggroShowAreaLines",
		name = "Show area lines",
		description = "Display lines, when walked past, the unaggressive timer resets.",
		position = 4
	)
	default boolean showAreaLines()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "npcAggroAreaColor",
		name = "Aggressive color",
		description = "Choose color to use for marking NPC unaggressive area when NPCs are aggressive.",
		position = 5
	)
	default Color aggroAreaColor()
	{
		return new Color(0x64FFFF00, true);
	}

	@Alpha
	@ConfigItem(
		keyName = "npcUnaggroAreaColor",
		name = "Unaggressive color",
		description = "Choose color to use for marking NPC unaggressive area after NPCs have lost aggression.",
		position = 6
	)
	default Color unaggroAreaColor()
	{
		return new Color(0xFFFF00);
	}

	@ConfigItem(
		keyName = "notifyExpire",
		name = "Notify expiration",
		description = "Send a notification when the unaggressive timer expires.",
		position = 7
	)
	default Notification notifyExpire()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "hideIfOutOfCombat",
		name = "Hide when out of combat",
		description = "Hides unaggressive area lines when out of combat.",
		position = 8
	)
	default boolean hideIfOutOfCombat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOnSlayerTask",
		name = "Show on slayer task",
		description = "Enable for current slayer task NPCs.",
		position = 9
	)
	default boolean showOnSlayerTask()
	{
		return false;
	}
}
