/*
 * Copyright (c) 2018, Mika Kuijpers <github.com/mkuijpers>
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
package net.runelite.client.plugins.farmingprofit;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("farmingProfit")
public interface FarmingProfitConfig extends Config
{
	@ConfigItem(
		keyName = "trackAllotments",
		name = "Track allotment patches",
		description = "Track profit made of allotment patches",
		position = 0
	)
	default boolean trackAllotments()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackHerbs",
		name = "Track herb patches",
		description = "Track profit made of herb patches",
		position = 0
	)
	default boolean trackHerbs()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackHops",
		name = "Track hops patches",
		description = "Track profit made of hops patches",
		position = 0
	)
	default boolean trackHops()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackBushes",
		name = "Track bush patches",
		description = "Track profit made of bush patches",
		position = 0
	)
	default boolean trackBushes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackSpecial",
		name = "Track special patches",
		description = "Track profit made of the special patches, cactus and seaweed",
		position = 0
	)
	default boolean trackSpecial()
	{
		return true;
	}
}
