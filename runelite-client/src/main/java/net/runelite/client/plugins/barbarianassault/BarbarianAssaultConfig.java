/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
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
package net.runelite.client.plugins.barbarianassault;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("barbarianAssault")
public interface BarbarianAssaultConfig extends Config
{
	@ConfigItem(
		keyName = "showTimer",
		name = "Show call change timer",
		description = "Show time to next call change",
		position = 1
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "callChangeAudioCue",
		name = "Call Change Audio Cue",
		description = "Play an audio cue when the call changes",
		position = 2
	)
	default boolean callChangeAudioCue()
	{
		return false;
	}

	@Range(
		min = 0,
		max = 29
	)
	@ConfigItem(
		keyName = "callChangeAudioCueDelay",
		name = "Audio Cue Delay",
		description = "Sets the delay in seconds after a call change that the audio cue should occur",
		position = 3
	)
	default int callChangeAudioCueDelay()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "showHealerBars",
		name = "Show health bars for teammates when healer",
		description = "Displays team health for healer",
		position = 4
	)
	default boolean showHealerBars()
	{
		return true;
	}

	@ConfigItem(
		keyName = "waveTimes",
		name = "Show wave and game duration",
		description = "Displays wave and game duration",
		position = 5
	)
	default boolean waveTimes()
	{
		return true;
	}
}
