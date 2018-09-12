/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Bryan Keller <b@bk.gg>
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

package net.runelite.client.plugins.rightclick;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.rightclick.config.MenuHighlightMode;

@ConfigGroup("rightclick")
public interface RightclickOptionsConfig extends Config
{
	@ConfigItem(
		keyName = "highlightedRightclickItems",
		name = "Highlighted Menu Items",
		description = "List of right-click menu entries to highlight, separated by commas.",
		position = 0
	)
	default String getHighlightedRightclickItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "dimmedItems",
		name = "Dimmed Items",
		description = "List of right-click menu entries to dim, separated by commas",
		position = 1
	)
	default String getDimmedItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "menuHighlightMode",
		name = "Menu Highlight Mode",
		description = "Configures what to highlight in right-click menu",
		position = 2
	)
	default MenuHighlightMode menuHighlightMode()
	{
		return MenuHighlightMode.NAME;
	}

	@ConfigItem(
		keyName = "highlightedColor",
		name = "Highlighted items color",
		description = "Configures the color for highlighted entries",
		position = 3
	)
	default Color highlightedColor()
	{
		return Color.decode("#FF66AA");
	}

	@ConfigItem(
		keyName = "dimmedColor",
		name = "Dimmed items color",
		description = "Configures the color for dimmed entries",
		position = 4
	)
	default Color dimmedColor()
	{
		return Color.decode("#808080");
	}

	@ConfigItem(
		keyName = "hideExamine",
		name = "Hide \"Examine\"",
		description = "Hides Examine from all right-click menus",
		position = 5
	)
	default boolean hideExamine()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideTradeWith",
		name = "Hide \"Trade with\"",
		description = "Hides Trade from all right-click menus",
		position = 6
	)
	default boolean hideTradeWith()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideFollow",
		name = "Hide \"Follow\"",
		description = "Hides Follow from all right-click menus",
		position = 7
	)
	default boolean hideFollow()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideWithdraw5",
		name = "Hide \"Withdraw-5\"",
		description = "Hides Withdraw-5 from all right-click menus",
		position = 8
	)
	default boolean hideWithdraw5()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideWithdraw10",
		name = "Hide \"Withdraw-10\"",
		description = "Hides Withdraw-10 from all right-click menus",
		position = 9
	)
	default boolean hideWithdraw10()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideWithdrawAllButOne",
		name = "Hide \"Withdraw-All-But-One\"",
		description = "Hides WithdrawAllButOne from all right-click menus",
		position = 10
	)
	default boolean hideWithdrawAllButOne()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDepositWornItems",
		name = "Hide \"Deposit worn items\"",
		description = "Prevents you from depositing your worn items by accident",
		position = 11
	)
	default boolean hideDepositWornItems()
	{
		return false;
	}
}
