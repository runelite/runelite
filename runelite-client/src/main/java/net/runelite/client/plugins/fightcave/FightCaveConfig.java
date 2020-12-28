/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.fightcave;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

import java.awt.*;

@ConfigGroup("fightcave")
public interface FightCaveConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "waveDisplay",
		name = "Wave display",
		description = "Shows monsters that will spawn on the selected wave(s)."
	)
	default WaveDisplayMode waveDisplay()
	{
		return WaveDisplayMode.BOTH;
	}

	@ConfigItem(
		position = 1,
		keyName = "tickTimersWidget",
		name = "Tick Timers in Prayer",
		description = "Adds an overlay to the Prayer Interface with the ticks until next attack for that prayer."
	)
	default boolean tickTimersWidget()
	{
		return false;
	}
	@ConfigItem(
		position = 1,
		keyName = "fontStyle",
		name = "Tick count font Style",
		description = "Plain | Bold | Italics"
	)
	default FontStyle fontStyle()
	{
		return FontStyle.BOLD;
	}

	@Range(
		min = 14,
		max = 40
	)
	@ConfigItem(
		position = 2,
		keyName = "textSize",
		name = "Tick count text Size",
		description = "Text Size for Timers."
	)
	default int textSize()
	{
		return 32;
	}

	@ConfigItem(
		position = 3,
		keyName = "shadows",
		name = "Tick count shadows",
		description = "Adds Shadows to text."
	)
	default boolean shadows()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "drawNames",
		name = "Draw names above NPC",
		description = "Configures whether or not NPC names should be drawn above the NPC"
	)
	default boolean drawNames()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not NPC names should be drawn on the minimap"
	)
	default boolean drawMinimapNames()
	{
		return true;
	}


	@ConfigItem(
		position = 6,
		keyName = "highlightDrainer",
		name = "HighlightDrainer",
		description = "Adds screen markers for drainer."
	)
	default boolean isHighlightDrainer()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "colorDrainer",
		name = "Drainer Color",
		description = "Color for drainer"
	)
	default Color getDrainerColor()
	{
		return Color.YELLOW;
	}
	@ConfigItem(
		position = 8,
		keyName = "highlightBlob",
		name = "HighlightBlob",
		description = "Adds screen markers for blob."
	)
	default boolean isHighlightBlob()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "colorBlob",
		name = "Blob Color",
		description = "Color for blob"
	)
	default Color getBlobColor()
	{
		return Color.PINK;
	}
	@ConfigItem(
		position = 10,
		keyName = "highlightRange",
		name = "HighlightRange",
		description = "Adds screen markers for range."
	)
	default boolean isHighlightRange()
	{
		return true;
	}

	@ConfigItem(
		position = 11,
		keyName = "colorRange",
		name = "Range Color",
		description = "Color for range"
	)
	default Color getRangeColor()
	{
		return Color.GREEN;
	}
	@ConfigItem(
		position = 12,
		keyName = "highlightMelee",
		name = "HighlightMelee",
		description = "Adds screen markers for melee."
	)
	default boolean isHighlightMelee()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "colorMelee",
		name = "Melee Color",
		description = "Color for melee"
	)
	default Color getMeleeColor()
	{
		return Color.RED;
	}
	@ConfigItem(
		position = 14,
		keyName = "highlightMage",
		name = "HighlightMage",
		description = "Adds screen markers for mage."
	)
	default boolean isHighlightMage()
	{
		return true;
	}

	@ConfigItem(
		position = 15,
		keyName = "colorMage",
		name = "Mage Color",
		description = "Color for mage"
	)
	default Color getMageColor()
	{
		return Color.CYAN;
	}
	@ConfigItem(
		position = 16,
		keyName = "highlightJad",
		name = "HighlightJad",
		description = "Adds screen markers for jad."
	)
	default boolean isHighlightJad()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "colorJad",
		name = "Jad Color",
		description = "Color for jad"
	)
	default Color getJadColor()
	{
		return Color.RED;
	}
	@ConfigItem(
		position = 18,
		keyName = "highlightHealer",
		name = "HighlightHealer",
		description = "Adds screen markers for healer."
	)
	default boolean isHighlightHealer()
	{
		return true;
	}

	@ConfigItem(
		position = 19,
		keyName = "colorHealer",
		name = "Healer Color",
		description = "Color for healer"
	)
	default Color getHealerColor()
	{
		return Color.GREEN;
	}

	@Getter
	@AllArgsConstructor
	enum FontStyle
	{
		BOLD("Bold", Font.BOLD),
		ITALIC("Italic", Font.ITALIC),
		PLAIN("Plain", Font.PLAIN);

		private String name;
		private int font;

		@Override
		public String toString()
		{
			return getName();
		}
	}
}
