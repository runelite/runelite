/*
 * Copyright (c) 2019 Ahmad Issa
 * Copyright (c) 2019 Owain		<https://github.com/sdburns1998>
 * Copyright (c) 2019 Kyle 		<https://github.com/Kyleeld>
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

package net.runelite.client.plugins.highalchemy;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("highalchemy")
public interface HighAlchemyConfig extends Config
{
	int lowerLimit = Integer.MIN_VALUE;

	@ConfigItem(
		keyName = "showBank",
		name = "Highlight Bank Items",
		description = "Show highlight on bank items.",
		position = 0
	)
	default boolean showBank()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showInventory",
		name = "Highlight Inventory Items",
		description = "Show highlight on inventory items.",
		position = 1
	)
	default boolean showInventory()
	{
		return false;
	}

	@ConfigItem(
		keyName = "getHighlightColor",
		name = "Highlight Color",
		description = "Choose the color of the highlight.",
		position = 2
	)
	default Color getHighlightColor()
	{
		return Color.WHITE;
	}

	@Range(
		min = lowerLimit
	)
	@ConfigItem(
		keyName = "minProfit",
		name = "Profit Target",
		description = "Minimal desired profit from casting High Alchemy",
		position = 3
	)
	default int minProfit()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "usingFireRunes",
		name = "Using Fire Runes",
		description = "Change the equation to include the price of fire runes.",
		position = 4
	)
	default boolean usingFireRunes()
	{
		return false;
	}

}