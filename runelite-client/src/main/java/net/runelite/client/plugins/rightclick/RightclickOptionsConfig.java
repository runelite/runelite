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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.rightclick.config.MenuHighlightMode;

import java.awt.*;

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
		keyName = "hiddenItems",
		name = "Hidden Items",
		description = "List of right-click menu entries to prevent from appearing, separated by commas.",
		position = 1
	)
	default String getHiddenItems()
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
		return Color.decode("#AA00FF");
	}

}
