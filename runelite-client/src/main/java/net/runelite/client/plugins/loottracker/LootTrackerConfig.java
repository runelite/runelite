/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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

package net.runelite.client.plugins.loottracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("loottracker")
public interface LootTrackerConfig extends Config
{
	@ConfigItem(
		keyName = "ignoredItems",
		name = "Ignored items",
		description = "Configures which items should be ignored when calculating loot prices."
	)
	default String getIgnoredItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "ignoredItems",
		name = "",
		description = ""
	)
	void setIgnoredItems(String key);

	@ConfigItem(
		keyName = "saveLoot",
		name = "Submit loot tracker data",
		description = "Submit loot tracker data (requires being logged in)"
	)
	default boolean saveLoot()
	{
		return true;
	}

	@ConfigItem(
		keyName = "syncPanel",
		name = "Synchronize panel contents",
		description = "Synchronize you local loot tracker with your online (requires being logged in). This means" +
			" that panel is filled with portion of your remote data on startup and deleting data in panel deletes them" +
			" also on server."
	)
	default boolean syncPanel()
	{
		return true;
	}
}