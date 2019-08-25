/*
 * Copyright (c) 2018 kulers
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
package net.runelite.client.plugins.inventorytags;

import java.awt.Color;
import lombok.RequiredArgsConstructor;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("inventorytags")
public interface InventoryTagsConfig extends Config
{
	String GROUP = "inventorytags";

	@RequiredArgsConstructor
	enum amount
	{
		ONE("1"),
		TWO("2"),
		THREE("3"),
		FOUR("4"),
		FIVE("5"),
		SIX("6"),
		SEVEN("7"),
		EIGHT("8");

		private final String name;

		@Override
		public String toString()
		{
			return name;
		}

		public int toInt()
		{
			return Integer.parseInt(name);
		}
	}

	@ConfigItem(
		position = 0,
		keyName = "amount",
		name = "Amount of groups",
		description = "The amount of inventory groups"
	)
	default amount getAmount()
	{
		return amount.FOUR;
	}

	@ConfigItem(
		position = 1,
		keyName = "groupColor1",
		name = "Group 1 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "1 || 2 || 3 || 4 || 5 || 6 || 7 || 8"
	)
	default Color getGroup1Color()
	{
		return new Color(255, 0, 0);
	}

	@ConfigItem(
		position = 2,
		keyName = "groupColor2",
		name = "Group 2 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "2 || 3 || 4 || 5 || 6 || 7 || 8"
	)
	default Color getGroup2Color()
	{
		return new Color(0, 255, 0);
	}

	@ConfigItem(
		position = 3,
		keyName = "groupColor3",
		name = "Group 3 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "3 || 4 || 5 || 6 || 7 || 8"
	)
	default Color getGroup3Color()
	{
		return new Color(0, 0, 255);
	}

	@ConfigItem(
		position = 4,
		keyName = "groupColor4",
		name = "Group 4 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "4 || 5 || 6 || 7 || 8"
	)
	default Color getGroup4Color()
	{
		return new Color(255, 0, 255);
	}

	@ConfigItem(
		position = 5,
		keyName = "groupColor5",
		name = "Group 5 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "5 || 6 || 7 || 8"
	)
	default Color getGroup5Color()
	{
		return new Color(0, 255, 246);
	}

	@ConfigItem(
		position = 6,
		keyName = "groupColor6",
		name = "Group 6 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "6 || 7 || 8"
	)
	default Color getGroup6Color()
	{
		return new Color(248, 255, 244);
	}

	@ConfigItem(
		position = 7,
		keyName = "groupColor7",
		name = "Group 7 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "7 || 8"
	)
	default Color getGroup7Color()
	{
		return new Color(0, 0, 0);
	}

	@ConfigItem(
		position = 8,
		keyName = "groupColor8",
		name = "Group 8 Color",
		description = "Color of the Tag",
		hidden = true,
		unhide = "amount",
		unhideValue = "8"
	)
	default Color getGroup8Color()
	{
		return new Color(104, 105, 255);
	}
}
