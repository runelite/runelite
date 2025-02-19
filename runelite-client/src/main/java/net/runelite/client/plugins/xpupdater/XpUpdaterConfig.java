/*
 * Copyright (c) 2020, Alexsuperfly <alexsuperfly@users.noreply.github.com>
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
package net.runelite.client.plugins.xpupdater;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("xpupdater")
public interface XpUpdaterConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "cml",
		name = "Crystal Math Labs",
		description = "Automatically updates your stats on crystalmathlabs.com when you log out."
	)
	default boolean cml()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "runetracker",
		name = "RuneTracker",
		description = "Automatically updates your stats on runetracker.org when you log out."
	)
	default boolean runetracker()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "templeosrs",
		name = "TempleOSRS",
		description = "Automatically updates your stats on templeosrs.com when you log out."
	)
	default boolean templeosrs()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "wiseoldman",
		name = "Wise Old Man",
		description = "Automatically updates your stats on wiseoldman.net when you log out."
	)
	default boolean wiseoldman()
	{
		return false;
	}
}
