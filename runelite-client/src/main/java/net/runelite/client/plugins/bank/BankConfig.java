/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.bank;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("bank")
public interface BankConfig extends Config
{
	@ConfigSection(
		name = "Show Values",
		description = "",
		position = 0,
		keyName = "ValueSection"
	)
	default boolean ValueSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Disable Left Click",
		description = "",
		position = 1,
		keyName = "DisableLClickSection"
	)
	default boolean DisableLClickSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Bank Pin",
		description = "",
		position = 2,
		keyName = "BankPinSection"
	)
	default boolean BankPinSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showGE",
		name = "Show Grand Exchange price",
		description = "Show grand exchange price total (GE)",
		position = 0,
		section = "ValueSection"
	)
	default boolean showGE()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHA",
		name = "Show high alchemy price",
		description = "Show high alchemy price total (HA)",
		position = 2,
		section = "ValueSection"
	)
	default boolean showHA()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showExact",
		name = "Show exact bank value",
		description = "Show exact bank value",
		position = 3,
		section = "ValueSection"
	)
	default boolean showExact()
	{
		return false;
	}

	@ConfigItem(
		keyName = "seedVaultValue",
		name = "Show seed vault value",
		description = "Adds the total value of all seeds inside the seed vault to the title",
		position = 4,
		section = "ValueSection"
	)
	default boolean seedVaultValue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "rightClickBankInventory",
		name = "Disable left click bank inventory",
		description = "Configures whether the bank inventory button will bank your inventory on left click",
		position = 0,
		section = "DisableLClickSection"
	)
	default boolean rightClickBankInventory()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickBankEquip",
		name = "Disable left click bank equipment",
		description = "Configures whether the bank equipment button will bank your equipment on left click",
		position = 1,
		section = "DisableLClickSection"
	)
	default boolean rightClickBankEquip()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickBankLoot",
		name = "Disable left click bank looting bag",
		description = "Configures whether the bank looting bag button will bank your looting bag contents on left click",
		position = 2,
		section = "DisableLClickSection"
	)
	default boolean rightClickBankLoot()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickSetPlaceholders",
		name = "Disable left click set placeholders",
		description = "Configures whether the set bank placeholder button will be on left click",
		position = 3,
		section = "DisableLClickSection"
	)
	default boolean rightClickSetPlaceholders()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickReleasePlaceholders",
		name = "Disable left click release placeholder",
		description = "Configures whether the release bank placeholder button will be on left click",
		position = 4,
		section = "DisableLClickSection"
	)
	default boolean rightClickReleasePlaceholders()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickFillBankFiller",
		name = "Disable left click fill bank fillers",
		description = "Configures whether the fill bank fillers button will be on left click",
		position = 5,
		section = "DisableLClickSection"
	)
	default boolean rightClickFillBankFiller()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickSearch",
		name = "Disable left click search",
		description = "Configures whether the search button will search on left click",
		position = 6,
		section = "DisableLClickSection"
	)
	default boolean rightClickSearch()
	{
		return false;
	}

	@ConfigItem(
		keyName = "largePinNumbers",
		name = "Large bank pin numbers",
		description = "Enlarges and centers the numbers inside the bank pin buttons",
		position = 0,
		section = "BankPinSection"
	)
	default boolean largePinNumbers()
	{
		return false;
	}
}
