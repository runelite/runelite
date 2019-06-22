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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import java.awt.Color;

@ConfigGroup("inferno")
public interface InfernoConfig extends Config
	{
	@ConfigItem(
			position = 0,
			keyName = "Nibbler Overlay",
			name = "Nibbler Overlay",
			description = "Shows if there are any Nibblers left"
	)
	default boolean displayNibblerOverlay()
		{
			return false;
		}

	@ConfigItem(
			position = 1,
			keyName = "Prayer Helper",
			name = "Prayer Helper",
			description = "Tells you what to flick in how many ticks"
	)
	default boolean showPrayerHelp()
		{
			return false;
		}

	@ConfigItem(
			position = 2,
			keyName = "Wave Display",
			name = "Wave display",
			description = "Shows monsters that will spawn on the selected wave(s)."
	)
	default InfernoWaveDisplayMode waveDisplay()
		{
			return InfernoWaveDisplayMode.BOTH;
		}

	@ConfigItem(
			position = 3,
			keyName = "getWaveOverlayHeaderColor",
			name = "Wave Header",
			description = "Color for Wave Header"
	)
	default Color getWaveOverlayHeaderColor()
		{
			return Color.ORANGE;
		}

	@ConfigItem(
			position = 4,
			keyName = "getWaveTextColor",
			name = "Wave Text Color",
			description = "Color for Wave Texts"
	)
	default Color getWaveTextColor()
		{
			return Color.WHITE;
		}
	}