/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.lootrecorder;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "loot-recorder",
	name = "Loot Recorder",
	description = "Configuration for the Loot Recorder plugin"
)

public interface LootRecorderConfig extends Config
{
	@ConfigItem(
		keyName = "recordBarrowsChest",
		name = "Record Barrows Chest Loot",
		description = "Configures whether or not loot from Barrows Chests is recorded",
		position = 0
	)
	default boolean recordBarrowsChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordRaidsChest",
		name = "Record Chest Loot from Raids",
		description = "Configures whether or not loot from Raids is recorded",
		position = 1
	)
	default boolean recordRaidsChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLootTotals",
		name = "Show Recorded Loots Panel",
		description = "Configures whether or not the Recorded Loots Panel is shown",
		position = 2
	)
	default boolean showLootTotals()
	{
		return false;
	}

	@ConfigItem(
		keyName = "activeTab",
		name = "",
		description = "",
		hidden = true
	)
	default Tab activeTab()
	{
		return Tab.BARROWS;
	}

	void setActiveTab(Tab activeTab);
}
