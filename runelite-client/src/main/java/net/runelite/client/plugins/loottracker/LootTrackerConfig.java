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
		name = "Ignored Entries",
		description = "The Ignore items and Ignore groups options",
		position = -2,
		closedByDefault = true
	)
	String ignored = "ignored";

	@ConfigItem(
		keyName = "ignoredItems",
		name = "Ignored items",
		description = "Configures which items should be ignored when calculating loot prices.",
		section = ignored
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

	@ConfigItem(
		keyName = "saveLoot",
		name = "Submit loot tracker data",
		description = "Submit loot tracker data"
	)
	default boolean saveLoot()
	{
		return true;
	}

	@ConfigItem(
		keyName = "syncPanel",
		name = "Synchronize panel contents",
		description = "Synchronize your local loot tracker with your server data (requires being logged in).<br/>" +
			" This means the panel is filled with portions of your remote data on startup<br/>" +
			" and deleting data in the panel also deletes it on the server."
	)
	default boolean syncPanel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "ignoredEvents",
		name = "Ignored Loot Sources",
		description = "Hide specific NPCs or sources of loot in the loot tracker (e.g., Goblin, Barrows Chest, H.A.M. Member).",
		section = ignored
	)
	default String getIgnoredEvents()
	{
		return "";
	}

	@ConfigItem(
		keyName = "ignoredEvents",
		name = "",
		description = ""
	)
	void setIgnoredEvents(String key);

	@ConfigItem(
		keyName = "npcKillChatMessage",
		name = "Show chat message for NPC kills",
		description = "Adds a chat message with monster name and kill value when receiving loot from an NPC kill."
	)
	default boolean npcKillChatMessage()
	{
		return false;
	}

	@ConfigItem(
		keyName = "pvpKillChatMessage",
		name = "Show chat message for PVP kills",
		description = "Adds a chat message with player name and kill value when receiving loot from a player kill."
	)
	default boolean pvpKillChatMessage()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showRaidsLootValue",
		name = "Show chat message for raids loot",
		description = "Adds a chat message that displays the value of your loot at the end of the raid."
	)
	default boolean showRaidsLootValue()
	{
		return true;
	}
}
