/*
 * Copyright (c) 2018, Danny <DannysPVM@gmail.com>
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
package net.runelite.client.plugins.deathindicator;

import java.time.Instant;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("deathIndicator")
public interface DeathIndicatorConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "deathTileHighlight",
		name = "Highlight Death Tile",
		description = "Configures whether or not to highlight the death location"
	)
	default boolean showDeathTileHighlight()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "deathInfoBox",
		name = "Show Death InfoBox",
		description = "Configures whether or not to show item reclaim timer and death world infobox"
	)
	default boolean showDeathInfoBox()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "deathOnWorldMap",
		name = "Mark on World Map",
		description = "Configures whether or not to show death location on the world map"
	)
	default boolean showDeathOnWorldMap()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "deathChatMessage",
		name = "Show Chat Message",
		description = "Configures whether or not to show a chatbox message on login (Beware: includes login name if on a different account)"
	)
	default boolean showDeathChatMessage()
	{
		return false;
	}

	// Stored Data
	@ConfigItem(
		keyName = "deathWorld",
		name = "",
		description = "",
		hidden = true
	)
	int deathWorld();

	@ConfigItem(
		keyName = "deathWorld",
		name = "",
		description = ""
	)
	void deathWorld(int deathWorld);

	@ConfigItem(
		keyName = "deathLocationX",
		name = "",
		description = "",
		hidden = true
	)
	int deathLocationX();

	@ConfigItem(
		keyName = "deathLocationX",
		name = "",
		description = ""
	)
	void deathLocationX(int deathLocationX);

	@ConfigItem(
		keyName = "deathLocationY",
		name = "",
		description = "",
		hidden = true
	)
	int deathLocationY();

	@ConfigItem(
		keyName = "deathLocationY",
		name = "",
		description = ""
	)
	void deathLocationY(int deathLocationY);

	@ConfigItem(
		keyName = "deathLocationPlane",
		name = "",
		description = "",
		hidden = true
	)
	int deathLocationPlane();

	@ConfigItem(
		keyName = "deathLocationPlane",
		name = "",
		description = ""
	)
	void deathLocationPlane(int deathLocationPlane);

	@ConfigItem(
		keyName = "timeOfDeath",
		name = "",
		description = "",
		hidden = true
	)
	Instant timeOfDeath();

	@ConfigItem(
		keyName = "timeOfDeath",
		name = "",
		description = ""
	)
	void timeOfDeath(Instant timeOfDeath);

	@ConfigItem(
		keyName = "deadPlayerName",
		name = "",
		description = "",
		hidden = true
	)
	String deadPlayerName();

	@ConfigItem(
		keyName = "deadPlayerName",
		name = "",
		description = ""
	)
	void deadPlayerName(String deadPlayerName);
}
