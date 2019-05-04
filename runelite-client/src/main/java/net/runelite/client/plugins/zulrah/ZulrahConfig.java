/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2018, https://github.com/runeliteplusplus
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

package net.runelite.client.plugins.zulrah;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("zulrah")
public interface ZulrahConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "zulrahenable",
		name = "Enable Zulrah Helper",
		description = "Configures whether or not to enable Zulrah Helper."
	)
	default boolean EnableZulrah()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "zulrahprayenable",
		name = "Show Prayer Helper",
		description = "Configures whether or not to show when to pray at Zulrah."
	)
	default boolean EnableZulrahPrayerHelper()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "jadphasehelper",
		name = "Jad Phase Helper",
		description = "Tells you what to pray against Zulrah jad phase"
	)
	default boolean ZulrahJadHelper()
	{
		return true;
	}
}
