/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.music;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("music")
public interface MusicConfig extends Config
{
	@ConfigItem(
		keyName = "muteOwnAreaSounds",
		name = "Mute player area sounds",
		description = "Mute area sounds caused by yourself",
		position = 0
	)
	default boolean muteOwnAreaSounds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "muteOtherAreaSounds",
		name = "Mute other players' area sounds",
		description = "Mute area sounds caused by other players",
		position = 1
	)
	default boolean muteOtherAreaSounds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "muteOtherAreaNPCSounds",
		name = "Mute NPCs' area sounds",
		description = "Mute area sounds caused by NPCs",
		position = 2
	)
	default boolean muteNpcAreaSounds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "muteOtherAreaEnvironmentSounds",
		name = "Mute environment area sounds",
		description = "Mute area sounds caused by neither NPCs nor players",
		position = 3
	)
	default boolean muteEnvironmentAreaSounds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "musicVolume",
		name = "",
		description = "",
		hidden = true
	)
	default int getMusicVolume()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "musicVolume",
		name = "",
		description = "",
		hidden = true
	)
	void setMusicVolume(int vol);

	@ConfigItem(
		keyName = "soundEffectVolume",
		name = "",
		description = "",
		hidden = true
	)
	default int getSoundEffectVolume()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "soundEffectVolume",
		name = "",
		description = "",
		hidden = true
	)
	void setSoundEffectVolume(int val);

	@ConfigItem(
		keyName = "areaSoundEffectVolume",
		name = "",
		description = "",
		hidden = true
	)
	default int getAreaSoundEffectVolume()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "areaSoundEffectVolume",
		name = "",
		description = "",
		hidden = true
	)
	void setAreaSoundEffectVolume(int vol);
}