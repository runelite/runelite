/*
 * Copyright (c) 2018-2019, Ethan <https://github.com/Wea1thRS/>
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.inventorysetups;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("inventorysetups")
public interface InventorySetupConfig extends Config
{
	@ConfigItem(
		keyName = "highlightDifferences",
		name = "Highlight Differences",
		description = "Highlight slots that don't match the selected setup",
		position = 0
	)

	default boolean getHighlightDifferences()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightDifferenceColor",
		name = "Highlight Color",
		description = "The color used to highlight differences between setups",
		position = 1
	)

	default Color getHighlightColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "stackDifference",
		name = "Stack Difference",
		description = "Differences between setups will be highlighted if the stack size is different",
		position = 2
	)

	default boolean getStackDifference()
	{
		return false;
	}

	@ConfigItem(
		keyName = "variationDifference",
		name = "Variation Difference",
		description = "Variations of items (E.g., charged jewellery) will be counted as different",
		position = 2
	)

	default boolean getVariationDifference()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bankHighlight",
		name = "Bank Highlight",
		description = "Highlight setup items in bank",
		position = 4
	)

	default boolean getBankHighlight()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bankHighlightColor",
		name = "Bank Highlight Color",
		description = "The color used to highlight setup items in bank",
		position = 5
	)

	default Color getBankHighlightColor()
	{
		return Color.RED;
	}
}