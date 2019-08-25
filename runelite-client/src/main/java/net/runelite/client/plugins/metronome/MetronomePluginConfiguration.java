/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * Copyright (c) 2018, oplosthee <https://github.com/oplosthee>
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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("metronome")
public interface MetronomePluginConfiguration extends Config
{
	@ConfigItem(
		keyName = "tickCount",
		name = "Tick count",
		description = "Configures the number of game ticks between metronome sounds"
	)
	default int tickCount()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "enableTock",
		name = "Enable tock (alternating) sound",
		description = "Toggles whether to play \"tock\" sounds"
	)
	default boolean enableTock()
	{
		return false;
	}

	@ConfigItem(
		keyName = "tockNumber",
		name = "Tock every nth \"tick\"",
		description = "Configures how many \"ticks\" between each \"tock\""
	)
	default int tockNumber()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "tickOffset",
		name = "Offset",
		description = "Amount of ticks to offset the metronome (only useful for \"tocks\")"
	)
	default int tickOffset()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "tickSoundFilePath",
		name = "Tick .wav file path",
		description = "The path to the file to be used for \"tick\" sounds (short .wav only)"
	)
	default String tickPath()
	{
		return "";
	}

	@ConfigItem(
		keyName = "tockSoundFilePath",
		name = "Tock .wav file path",
		description = "The path to the file to be used for \"tock\" sounds (short .wav only)"
	)
	default String tockPath()
	{
		return "";
	}

	@Range(
		min = 0,
		max = 100
	)
	@ConfigItem(
		keyName = "volume",
		name = "Volume modification",
		description = "Configures tick/tock volume; only effects custom sounds."
	)
	default int volume()
	{
		return 35;
	}
}
