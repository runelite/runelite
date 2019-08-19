/*
 * Copyright (c) 2019, Jacky <liangj97@gmail.com>
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
package net.runelite.client.plugins.inferno;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("inferno")
public interface InfernoConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "prayer",
		name = "Prayer",
		description = ""
	)
	default Stub prayer()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 1,
		keyName = "Prayer Helper",
		name = "Prayer Helper",
		description = "Indicates the correct prayer"
	)
	default boolean showPrayerHelp()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "prayerHelperMode",
		name = "Prayer Helper Mode",
		description = "Display prayer indicator in the prayer tab or in the bottom right corner of the screen"
	)
	default InfernoPrayerOverlayMode prayerOverlayMode()
	{
		return InfernoPrayerOverlayMode.PRAYER_TAB;
	}

	@ConfigItem(
		position = 3,
		keyName = "descendingBoxes",
		name = "Descending Boxes",
		description = "Draws timing boxes above the prayer icons, as if you were playing Piano Tiles"
	)
	default boolean descendingBoxes()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "indicateWhenPrayingCorrectly",
		name = "Indicate When Praying Correctly",
		description = "Indicate the correct prayer, even if you are already praying that prayer"
	)
	default boolean indicateWhenPrayingCorrectly()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "monsters",
		name = "Monsters",
		description = ""
	)
	default Stub monsters()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 6,
		keyName = "Nibbler Overlay",
		name = "Nibbler Overlay",
		description = "Shows if there are any Nibblers left"
	)
	default boolean displayNibblerOverlay()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "indicateActiveHealers",
		name = "Indicate Active Healers",
		description = "Indicate healers that are still healing Jad"
	)
	default boolean indicateActiveHealers()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "waves",
		name = "Waves",
		description = ""
	)
	default Stub waves()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 9,
		keyName = "waveDisplay",
		name = "Wave display",
		description = "Shows monsters that will spawn on the selected wave(s)."
	)
	default InfernoWaveDisplayMode waveDisplay()
	{
		return InfernoWaveDisplayMode.BOTH;
	}

	@ConfigItem(
		position = 10,
		keyName = "getWaveOverlayHeaderColor",
		name = "Wave Header",
		description = "Color for Wave Header"
	)
	default Color getWaveOverlayHeaderColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		position = 11,
		keyName = "getWaveTextColor",
		name = "Wave Text Color",
		description = "Color for Wave Texts"
	)
	default Color getWaveTextColor()
	{
		return Color.WHITE;
	}
}