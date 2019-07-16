/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.vorkath;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("vorkath")
public interface VorkathConfig extends Config
{
	@ConfigItem(
		keyName = "indicateAcidPools",
		name = "Acid Pools",
		description = "Indicate the acid pools",
		position = 0
	)
	default boolean indicateAcidPools()
	{
		return false;
	}

	@ConfigItem(
		keyName = "indicateAcidFreePath",
		name = "Acid Free Path",
		description = "Indicate the most efficient acid free path",
		position = 1
	)
	default boolean indicateAcidFreePath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "acidFreePathMinLength",
		name = "Minimum Length Acid Free Path",
		description = "The minimum length of an acid free path",
		position = 2,
		hidden = true,
		unhide = "indicateAcidFreePath"
	)
	default int acidFreePathLength()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "indicateWooxWalkPath",
		name = "WooxWalk Path",
		description = "Indicate the closest WooxWalk path",
		position = 3
	)
	default boolean indicateWooxWalkPath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "indicateWooxWalkTick",
		name = "WooxWalk Tick",
		description = "Indicate on which tile to click during each game tick",
		position = 4
	)
	default boolean indicateWooxWalkTick()
	{
		return true;
	}
}
