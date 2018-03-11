/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.clancaller;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "clancaller",
	name = "Clan Caller",
	description = "Configuration for the clan caller plugin"
)
public interface ClanCallerConfig extends Config
{
	@ConfigItem(
		keyName = "getCallers",
		name = "Callers RSN",
		description = "Configures the RSN of the callers (Eg. zezima,lynx titan",
		position = 1
	)
	default String getCallers()
	{
		return "";
	}

	@ConfigItem(
		keyName = "getSnipers",
		name = "Snipers RSN",
		description = "Configures the RSN of the snipers (Eg. zezima,lynx titan",
		position = 2
	)
	default String getSnipers()
	{
		return "";
	}

	@ConfigItem(
		keyName = "recolorMenu",
		name = "Re-color menu option",
		description = "Configures whether to re-color the menu option",
		position = 3
	)
	default boolean recolorMenu()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTargetOverlay",
		name = "Show Target overlay",
		description = "Configures whether to display the targets name",
		position = 4
	)
	default boolean showTargetOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "targetColor",
		name = "Target color",
		description = "Configures the target color for the menu and overlay",
		position = 5
	)
	default Color targetColor()
	{
		return new Color(0, 255, 255);
	}

	@ConfigItem(
		keyName = "showCallerOverlay",
		name = "Show Caller overlay",
		description = "Configures whether to display the caller name",
		position = 6
	)
	default boolean showCallerOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "callerColor",
		name = "Caller color",
		description = "Configures the caller color for the overlay",
		position = 7
	)
	default Color callerColor()
	{
		return new Color(255, 200, 0);
	}

	@ConfigItem(
		keyName = "showSniperOverlay",
		name = "Show Sniper overlay",
		description = "Configures whether to display the Snipers name",
		position = 8
	)
	default boolean showSniperOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "sniperColor",
		name = "Sniper color",
		description = "Configures the sniper color for the menu and overlay",
		position = 9
	)
	default Color sniperColor()
	{
		return new Color(255, 0, 0);
	}
}
