/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

package net.runelite.client.plugins.groundmarkers;

import java.awt.Color;
import lombok.RequiredArgsConstructor;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("groundMarker")
public interface GroundMarkerConfig extends Config
{
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
		EIGHT("8"),
		NINE("9"),
		TEN("10"),
		ELEVEN("11"),
		TWELVE("12");

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

	@Alpha
	@ConfigItem(
		position = 1,
		keyName = "markerColor",
		name = "Default tile Color",
		description = "Configures the default color of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "1 || 2 || 3 || 4 || 5 || 6 || 7 || 8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor()
	{
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
		position = 3,
		keyName = "markerColor2",
		name = "Group 2 tile color",
		description = "Configures the color of the 2nd group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "2 || 3 || 4 || 5 || 6 || 7 || 8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor2()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "markerColor3",
		name = "Group 3 tile color",
		description = "Configures the color of the 3rd group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "3 || 4 || 5 || 6 || 7 || 8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor3()
	{
		return Color.BLUE;
	}

	@Alpha
	@ConfigItem(
		position = 5,
		keyName = "markerColor4",
		name = "Group 4 tile color",
		description = "Configures the color of the 4th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "4 || 5 || 6 || 7 || 8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor4()
	{
		return Color.GREEN;
	}

	@Alpha
	@ConfigItem(
		position = 6,
		keyName = "markerColor5",
		name = "Group 5 tile color",
		description = "Configures the color of the 5th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "5 || 6 || 7 || 8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor5()
	{
		return Color.BLACK;
	}

	@Alpha
	@ConfigItem(
		position = 7,
		keyName = "markerColor6",
		name = "Group 6 tile color",
		description = "Configures the color of the 6th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "6 || 7 || 8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor6()
	{
		return Color.GRAY;
	}

	@Alpha
	@ConfigItem(
		position = 8,
		keyName = "markerColor7",
		name = "Group 7 tile color",
		description = "Configures the color of the 7th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "7 || 8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor7()
	{
		return Color.WHITE;
	}

	@Alpha
	@ConfigItem(
		position = 9,
		keyName = "markerColor8",
		name = "Group 8 tile color",
		description = "Configures the color of the 8th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "8 || 9 || 10 || 11 || 12"
	)
	default Color markerColor8()
	{
		return Color.MAGENTA;
	}

	@Alpha
	@ConfigItem(
		position = 10,
		keyName = "markerColor9",
		name = "Group 9 tile color",
		description = "Configures the color of the 9th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "9 || 10 || 11 || 12"
	)
	default Color markerColor9()
	{
		return Color.CYAN;
	}

	@Alpha
	@ConfigItem(
		position = 11,
		keyName = "markerColor10",
		name = "Group 10 tile color",
		description = "Configures the color of the 10th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "10 || 11 || 12"
	)
	default Color markerColor10()
	{
		return Color.ORANGE;
	}

	@Alpha
	@ConfigItem(
		position = 12,
		keyName = "markerColor11",
		name = "Group 11 tile color",
		description = "Configures the color of the 11th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "11 || 12"
	)
	default Color markerColor11()
	{
		return Color.PINK;
	}

	@Alpha
	@ConfigItem(
		position = 13,
		keyName = "markerColor12",
		name = "Group 12 tile color",
		description = "Configures the color of the 12th group of marked tiles",
		hidden = true,
		unhide = "amount",
		unhideValue = "12"
	)
	default Color markerColor12()
	{
		return Color.LIGHT_GRAY;
	}

	@ConfigItem(
		position = 14,
		keyName = "showMinimap",
		name = "Show on minimap",
		description = "Shows marked tiles on the minimap"
	)
	default boolean showMinimap()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 100
	)
	@ConfigItem(
		position = 15,
		keyName = "minimapOpacity",
		name = "Minimap opacity",
		description = "The opacity of the minimap markers"
	)
	default int minimapOverlayOpacity()
	{
		return 100;
	}

	@ConfigItem(
		position = 16,
		keyName = "thinMarkers",
		name = "Thin markers",
		description = "Render marked tile borders as 1 pixel wide instead of 2"
	)
	default boolean thinMarkers()
	{
		return false;
	}
}
