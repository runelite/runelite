/*
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.plugins.banktags;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("banktags")
public interface BankTagsConfig extends Config
{
	@ConfigItem(
		keyName = "useTabs",
		name = "Use Tag Tabs",
		description = "Enable the ability to add tabs to your bank which allow fast access to tags.",
		position = 1
	)
	default boolean tabs()
	{
		return true;
	}

	@ConfigItem(
		keyName = "rememberTab",
		name = "Remember last Tag Tab",
		description = "Enable the ability to remember last Tag Tab when closing/opening the bank.",
		position = 2
	)
	default boolean rememberTab()
	{
		return true;
	}

	@ConfigItem(
		keyName = "useQuantityFeature",
		name = "Display Quantities",
		description = "Display an overlay of the quantity of items for the tag.",
		position = 3
	)
	default boolean useQuantityFeature()
	{
		return true;
	}

	@ConfigItem(
		keyName = "autoSetQuantity",
		name = "Auto set Quantity",
		description = "Automatically set quantities when tagging your inventory.",
		position = 4
	)
	default boolean autoSetQuantity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "quantityOverlayColor",
		name = "Quantity Color",
		description = "Color of the item quantity overlay.",
		position = 5
	)
	@Alpha
	default Color quantityOverlayColor()
	{
		return Color.yellow;
	}

	@ConfigItem(
		keyName = "position",
		name = "",
		description = "",
		hidden = true
	)
	default int position()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "position",
		name = "",
		description = ""
	)
	void position(int idx);

	@ConfigItem(
		keyName = "tab",
		name = "",
		description = "",
		hidden = true
	)
	default String tab()
	{
		return "";
	}

	@ConfigItem(
		keyName = "tab",
		name = "",
		description = ""
	)
	void tab(String tab);
}
