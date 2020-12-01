/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * Copyright (c) 2018, oplosthee <https://github.com/oplosthee>
 * Copyright (c) 2020, Adam Davies <https://github.com/acdvs>
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
package net.runelite.client.plugins.metronome;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;
import net.runelite.api.SoundEffectVolume;
import net.runelite.client.config.Units;

@ConfigGroup("metronome")
public interface MetronomePluginConfiguration extends Config
{
	int VOLUME_MAX = SoundEffectVolume.HIGH;
	Color CUSTOM_GREEN = new Color(30, 210, 30);
	Color CUSTOM_GRAY = new Color(225, 225, 225);
	Color CUSTOM_DARKER_GRAY = new Color(210, 210, 210);

	@ConfigSection(
		name = "Visual Metronome",
		description = "Settings relating to the visual metronome",
		position = 4
	)
	String visualSettings = "visualSettings";

	@ConfigItem(
		position = 1,
		keyName = "tickInterval",
		name = "Tick interval",
		description = "The game tick interval after which a sound will be played."
	)
	default int tickInterval()
	{
		return 1;
	}

	@Range(
		max = VOLUME_MAX
	)
	@ConfigItem(
		position = 2,
		keyName = "tickVolume",
		name = "Tick volume",
		description = "The volume of the <em>tick</em> sound. A value of 0 will disable <em>tick</em> sounds."
	)
	default int tickVolume()
	{
		return SoundEffectVolume.MEDIUM_HIGH;
	}

	@Range(
		max = VOLUME_MAX
	)
	@ConfigItem(
		position = 3,
		keyName = "tockVolume",
		name = "Tock volume",
		description = "The volume of the <em>tock</em> sound. A value of 0 will disable <em>tock</em> sounds."
	)
	default int tockVolume()
	{
		return SoundEffectVolume.MUTED;
	}

	@ConfigItem(
		position = 5,
		keyName = "showVisual",
		name = "Visual metronome",
		description = "Show or hide the visual metronome",
		section = visualSettings
	)
	default boolean showVisual()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "tickColor",
		name = "Tick color",
		description = "Color of the visual metronome on each <em>tick</em> sound.",
		section = visualSettings
	)
	default Color tickColor()
	{
		return CUSTOM_GREEN;
	}

	@ConfigItem(
		position = 7,
		keyName = "tockColor",
		name = "Tock color",
		description = "Color of the visual metronome on each <em>tock</em> sound.",
		section = visualSettings
	)
	default Color tockColor()
	{
		return CUSTOM_DARKER_GRAY;
	}

	@ConfigItem(
		position = 8,
		keyName = "baseColor",
		name = "Base color",
		description = "Color of the visual metronome base.",
		section = visualSettings
	)
	default Color baseColor()
	{
		return CUSTOM_GRAY;
	}

	@ConfigItem(
		position = 9,
		keyName = "size",
		name = "Size",
		description = "Diameter of the visual metronome",
		section = visualSettings
	)
	@Units(Units.PIXELS)
	default int size() { return 50; }
}
