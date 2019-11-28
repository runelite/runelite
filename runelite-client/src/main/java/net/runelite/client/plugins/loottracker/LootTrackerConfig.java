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
import net.runelite.client.config.ConfigSection;

@ConfigGroup("loottracker")
public interface LootTrackerConfig extends Config
{
	@ConfigSection(
		position = 1,
		keyName = "filterSection",
		name = "Filter",
		description = ""
	)
	default boolean filterSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "ignoredItems",
		name = "Ignored items",
		description = "Configures which items should be ignored when calculating loot prices.",
		position = 0,
		section = "filterSection"
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
		keyName = "ignoredNPCs",
		name = "Ignored NPCs",
		description = "Configures which NPCs should be ignored ",
		position = 1,
		section = "filterSection"
	)
	default String getIgnoredNPCs()
	{
		return "";
	}

	@ConfigItem(
		keyName = "ignoredNPCs",
		name = "",
		description = ""
	)
	void setIgnoredNPCs(String key);

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
		keyName = "chestLootChat",
		name = "Show chest loot value in chat",
		description = "Show the value of items from CoX/ToB/Barrows chests in chat"
	)
	default boolean chestLootChat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "syncPanel",
		name = "Synchronize panel contents",
		description = "Synchronize your local loot tracker with your online (requires being logged in). This means" +
			" that panel is filled with portion of your remote data on startup and deleting data in panel deletes them" +
			" also on server."
	)
	default boolean syncPanel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "localPersistence",
		name = "Local Record Persistence",
		description = "Stores/syncs loot records locally in the JSON format. Note: records will not be saved locally" +
			" if they are successfully saved online. "
	)
	default boolean localPersistence()
	{
		return true;
	}

	@ConfigItem(
		keyName = "sortType",
		name = "Sorting",
		description = "The method for sorting Loot Tracker entries"
	)
	default LootRecordSortType sortType()
	{
		return LootRecordSortType.TIMESTAMP;
	}

	@ConfigItem(
		keyName = "whitelistEnabled",
		name = "NPC Whitelist",
		description = "Only track drops from specific NPCs",
		position = 1,
		section = "filterSection",
		disabledBy = "blacklistEnabled"
	)
	default boolean whitelistEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "getWhitelist",
		name = "Whitelist",
		description = "Comma-separated list of NPCs to track drops from",
		position = 2,
		section = "filterSection",
		hidden = true,
		unhide = "whitelistEnabled"
	)
	default String getWhitelist()
	{
		return "";
	}

	@ConfigItem(
		keyName = "blacklistEnabled",
		name = "NPC Blacklist",
		description = "Track drops from all NPCs except for specified ones",
		position = 3,
		section = "filterSection",
		disabledBy = "whitelistEnabled"
	)
	default boolean blacklistEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "getBlacklist",
		name = "Blacklist",
		description = "Comma-separated list of NPCs to not track drops from",
		position = 4,
		section = "filterSection",
		hidden = true,
		unhide = "blacklistEnabled"
	)
	default String getBlacklist()
	{
		return "";
	}

	@ConfigItem(
		keyName = "lootValueMessage",
		name = "Loot Value Messages",
		description = "Sends a game message with the total value you of your loot when you get a kill",
		position = 5
	)
	default boolean sendLootValueMessages()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDeaths",
		name = "Show PvP Deaths",
		description = "Shows your deaths to help you calculate PvP profit"
	)
	default boolean showDeaths()
	{
		return true;
	}

	@ConfigItem(
		keyName = "displayDate",
		name = "Display Date",
		description = "Displays the date the loot was received"
	)
	default boolean displayDate()
	{
		return true;
	}

	@ConfigItem(
		keyName = "priceType",
		name = "Price Type",
		description = "What type of price to use for calculating value."
	)
	default LootTrackerPriceType priceType()
	{
		return LootTrackerPriceType.GRAND_EXCHANGE;
	}

	@ConfigItem(
		keyName = "showPriceType",
		name = "Show Price Type",
		description = "Whether to show a GE: or HA: next to the total values in the tracker"
	)
	default boolean showPriceType()
	{
		return false;
	}
}
