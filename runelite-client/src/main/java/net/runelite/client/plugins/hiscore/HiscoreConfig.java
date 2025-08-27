/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.hiscore;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("hiscore")
public interface HiscoreConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "playerOption",
		name = "Player option",
		description = "Add Lookup option to players."
	)
	default boolean playerOption()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "menuOption",
		name = "Menu option",
		description = "Show Lookup option in menus."
	)
	default boolean menuOption()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "virtualLevels",
		name = "Display virtual levels",
		description = "Display levels over 99 in the hiscore panel."
	)
	default boolean virtualLevels()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "autocomplete",
		name = "Autocomplete",
		description = "Predict names when typing a name to lookup."
	)
	default boolean autocomplete()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "bountylookup",
		name = "Bounty lookup",
		description = "Automatically lookup the stats of your bounty hunter target."
	)
	default boolean bountylookup()
	{
		return false;
	}
}