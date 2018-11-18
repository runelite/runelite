/*
 * Copyright (c) 2018, trimbe <https://github.com/trimbe>
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

package net.runelite.client.plugins.worldswitcherfilter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("worldSwitcherFilter")
public interface WorldSwitcherFilterConfig extends Config
{
	@ConfigItem(
		keyName = "hidePvp",
		name = "Hide PvP worlds",
		description = "Hides PvP worlds",
		position = 0
	)
	default boolean hidePvp()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDeadman",
		name = "Hide Deadman worlds",
		description = "Hides Deadman worlds",
		position = 1
	)
	default boolean hideDeadman()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDeadmanSeasonal",
		name = "Hide Deadman seasonal worlds",
		description = "Hides Deadman seasonal worlds",
		position = 2
	)
	default boolean hideDeadmanSeasonal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideF2p",
		name = "Hide F2P worlds",
		description = "Hides F2P worlds",
		position = 3
	)
	default boolean hideF2p()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideMembers",
		name = "Hide Member worlds",
		description = "Hides Member worlds",
		position = 4
	)
	default boolean hideMember()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideIneligibleTotal",
		name = "Hide ineligible total worlds",
		description = "Hides total level worlds you're not eligible for",
		position = 5
	)
	default boolean hideIneligibleTotal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideUk",
		name = "Hide UK worlds",
		description = "Hides UK worlds",
		position = 6
	)
	default boolean hideUk()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideUsa",
		name = "Hide USA worlds",
		description = "Hides USA worlds",
		position = 7
	)
	default boolean hideUsa()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideAus",
		name = "Hide Australia worlds",
		description = "Hides Australia worlds",
		position = 8
	)
	default boolean hideAus()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideGermany",
		name = "Hide Germany worlds",
		description = "Hides Germany worlds",
		position = 9
	)
	default boolean hideGermany()
	{
		return false;
	}

	@ConfigItem(
		keyName = "replaceRegionFlags",
		name = "Replace region flags with ping",
		description = "Replaces region flags with ping and allows sorting by ping",
		position = 10
	)
	default boolean replaceRegionFlags()
	{
		return false;
	}

	@ConfigItem(
		keyName = "whitelistedWorlds",
		name = "Worlds to whitelist",
		description = "List of worlds to whitelist regardless of filter settings, separated by commas",
		position = 11
	)
	default String whitelistedWorlds()
	{
		return "";
	}

	@ConfigItem(
		keyName = "blacklistedWorlds",
		name = "Worlds to blacklist",
		description = "List of worlds to blacklist regardless of filter settings, separated by commas",
		position = 12
	)
	default String blacklistedWorlds()
	{
		return "";
	}
}

