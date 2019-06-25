/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.runedoku;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("runedoku")
public interface RunedokuConfig extends Config
{

	@ConfigItem(
			position = 0,
			keyName = "colorStub",
			name = "Colors",
			description = "" //stubs don't show descriptions when hovered over
	)
	default Stub colorStub()
	{
		return new Stub();
	}

	@ConfigItem(
			position = 1,
			keyName = "mindRuneColor",
			name = "Mind Rune Color",
			description = "Color used to highlight Mind runes.",
			parent = "colorStub"
	)
	default Color mindRuneColor()
	{
		return Color.PINK;
	}

	@ConfigItem(
			position = 2,
			keyName = "fireRuneColor",
			name = "Fire Rune Color",
			description = "Color used to highlight Fire runes.",
			parent = "colorStub"
	)
	default Color fireRuneColor()
	{
		return Color.RED;
	}

	@ConfigItem(
			position = 3,
			keyName = "bodyRuneColor",
			name = "Body Rune Color",
			description = "Color used to highlight Body runes.",
			parent = "colorStub"
	)
	default Color bodyRuneColor()
	{
		return Color.MAGENTA;
	}

	@ConfigItem(
			position = 4,
			keyName = "airRuneColor",
			name = "Air Rune Color",
			description = "Color used to highlight Air runes.",
			parent = "colorStub"
	)
	default Color airRuneColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
			position = 5,
			keyName = "deathRuneColor",
			name = "Death Rune Color",
			description = "Color used to highlight Death runes.",
			parent = "colorStub"
	)
	default Color deathRuneColor()
	{
		return Color.BLACK;
	}

	@ConfigItem(
			position = 6,
			keyName = "waterRuneColor",
			name = "Water Rune Color",
			description = "Color used to highlight Water runes.",
			parent = "colorStub"
	)
	default Color waterRuneColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
			position = 7,
			keyName = "chaosRuneColor",
			name = "Chaos Rune Color",
			description = "Color used to highlight Chaos runes.",
			parent = "colorStub"
	)
	default Color chaosRuneColor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
			position = 8,
			keyName = "earthRuneColor",
			name = "Earth Rune Color",
			description = "Color used to highlight Earth runes.",
			parent = "colorStub"
	)
	default Color earthRuneColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
			position = 9,
			keyName = "lawRuneColor",
			name = "Law Rune Color",
			description = "Color used to highlight Law runes.",
			parent = "colorStub"
	)
	default Color lawRuneColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
			position = 10,
			keyName = "miscFeature",
			name = "Miscellaneous Features",
			description = ""
	)
	default Stub miscFeature()
	{
		return new Stub();
	}

	@ConfigItem(
			position = 11,
			keyName = "onlyHighlightSelectedPiece",
			name = "Only Highlight Selected Piece",
			description = "Instead of showing all, this option only show what rune you have selected."
	)
	default boolean onlyHighlightSelectedPiece()
	{
		return false;
	}

}
