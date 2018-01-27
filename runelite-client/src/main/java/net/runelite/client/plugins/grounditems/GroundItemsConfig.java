/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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

package net.runelite.client.plugins.grounditems;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup(
	keyName = "grounditems",
	name = "Ground Items",
	description = "Configuration for the ground items plugin"
)
public interface GroundItemsConfig extends Config
{
	@ConfigItem(
		keyName = "enabled",
		name = "Enabled",
		description = "Configures whether or not item names/quantities are displayed"
	)
	default boolean enabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGEPrice",
		name = "Show Grand Exchange Prices",
		description = "Configures whether or not to draw GE prices alongside ground items"
	)
	default boolean showGEPrice()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHAValue",
		name = "Show High Alchemy Values",
		description = "Configures whether or not to draw High Alchemy values alongside ground items"
	)
	default boolean showHAValue()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hiddenItems",
		name = "Hidden Items",
		description = "Configures hidden ground items. Format: (item), (item)"
	)
	default String getHiddenItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "highlightedItems",
		name = "Highlighted Items",
		description = "Configures specifically highlighted ground items. Format: (item), (item)"
	)
	default String getHighlightItems()
	{
		return "";
	}

	@ConfigItem(
		keyName = "hideUnderGeValue",
		name = "Hide < GE Value",
		description = "Configures hidden ground items under GE value"
	)
	default int getHideUnderGeValue()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "hideUnderHaValue",
		name = "Hide < HA Value",
		description = "Configures hidden ground items under High Alch value"
	)
	default int getHideUnderHAValue()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "highlightedColor",
		name = "Highlighted items color",
		description = "Configures the color for highlighted items"
	)
	default Color highlightedColor()
	{
		return Color.decode("#AA00FF");
	}

	@ConfigItem(
		keyName = "lowValueColor",
		name = "Low value items color",
		description = "Configures the color for low value items"
	)
	default Color lowValueColor()
	{
		return Color.decode("#66B2FF");
	}

	@ConfigItem(
		keyName = "mediumValueColor",
		name = "Medium value items color",
		description = "Configures the color for medium value items"
	)
	default Color mediumValueColor()
	{
		return Color.decode("#99FF99");
	}

	@ConfigItem(
		keyName = "highValueColor",
		name = "High value items color",
		description = "Configures the color for high value items"
	)
	default Color highValueColor()
	{
		return Color.decode("#FF9600");
	}

	@ConfigItem(
		keyName = "insaneValueColor",
		name = "Insane value items color",
		description = "Configures the color for insane value items"
	)
	default Color insaneValueColor()
	{
		return Color.decode("#FF66B2");
	}
}
