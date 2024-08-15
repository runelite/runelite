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

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("bank")
public interface BankConfig extends Config
{
	@ConfigItem(
		keyName = "showGE",
		name = "Show Grand Exchange price",
		description = "Show Grand Exchange price total (GE)",
		position = 1
	)
	default boolean showGE()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGEPerItem",
		name = "Show Grand Exchange price on Item",
		description = "Show Grand Exchange price total (GE) on the item. When GE and HA are both enabled, greater of the two is shown.",
		position = 2
	)
	default boolean showGEPerItem()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "gePerItemColor",
		name = "Color for Grand Exchange price on Item",
		description = "Configures the color for Grand Exchange value shown on the item",
		position = 3
	)
	default Color gePerItemColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "showHA",
		name = "Show high alchemy price",
		description = "Show high alchemy price total (HA)",
		position = 4
	)
	default boolean showHA()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showHAPerItem",
		name = "Show high alchemy price on Item",
		description = "Show high alchemy price total (HA) on the item. When GE and HA are both enabled, greater of the two is shown.",
		position = 5
	)
	default boolean showHAPerItem()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "haPerItemColor",
		name = "Color for High alchemy price on Item",
		description = "Configures the color for high alchemy value shown on the item",
		position = 6
	)
	default Color haPerItemColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "showPriceOnItemKeybind",
		name = "Price on Item shortcut",
		description = "Keyboard shortcut for showing GE/HA value on item",
		position = 7
	)
	default Keybind showItemPriceKeybind()
	{
		return new Keybind(KeyEvent.VK_UNDEFINED, InputEvent.ALT_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "showExact",
		name = "Show exact bank value",
		description = "Show exact bank value",
		position = 8
	)
	default boolean showExact()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickBankInventory",
		name = "Disable left click bank inventory",
		description = "Configures whether the bank inventory button will bank your inventory on left click",
		position = 9
	)
	default boolean rightClickBankInventory()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickBankEquip",
		name = "Disable left click bank equipment",
		description = "Configures whether the bank equipment button will bank your equipment on left click",
		position = 10
	)
	default boolean rightClickBankEquip()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickBankLoot",
		name = "Disable left click bank looting bag",
		description = "Configures whether the bank looting bag button will bank your looting bag contents on left click",
		position = 11
	)
	default boolean rightClickBankLoot()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rightClickPlaceholders",
		name = "Disable left click placeholders button",
		description = "Configures whether the placeholders button will be toggled on left click",
		position = 12
	)
	default boolean rightClickPlaceholders()
	{
		return false;
	}

	@ConfigItem(
		keyName = "seedVaultValue",
		name = "Show seed vault value",
		description = "Adds the total value of all seeds inside the seed vault to the title",
		position = 13
	)
	default boolean seedVaultValue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bankPinKeyboard",
		name = "Keyboard Bankpin",
		description = "Allows using the keyboard keys for bank pin input",
		position = 14
	)
	default boolean bankPinKeyboard()
	{
		return false;
	}

	@ConfigItem(
		keyName = "searchKeybind",
		name = "Search Shortcut",
		description = "Keyboard shortcut for initiating a bank or seed vault search",
		position = 15
	)
	default Keybind searchKeybind()
	{
		return new Keybind(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "blockJagexAccountAd",
		name = "Block Jagex Account popup",
		description = "Blocks the weekly reminder to migrate to a Jagex account",
		position = 16
	)
	default boolean blockJagexAccountAd()
	{
		return false;
	}
}
