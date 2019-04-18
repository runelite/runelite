/*
 * Copyright (c) 2019, Jordan Houghton <jordan.houghton@protonmail.com>
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
 *
 */


package net.runelite.client.plugins.musicreplacer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("osrsbeatz")
public interface MusicReplacerConfiguration extends Config {
    @ConfigItem(
            position = 0,
            keyName = "musicPack",
            name = "Music Pack",
            description = "Music Pack Choice"
    )
    default String musicPack()
    {
        return "";
    }
    @ConfigItem(
            position = 1,
            keyName = "Vol",
            name =  "Volume",
            description = "Volume"
    )
    default int Vol(){ return 25; }
	@ConfigItem(
			position = 2,
			keyName = "FadeIn",
			name =  "Fade In (Millis)",
			description = "Fade In in Milliseconds"
	)
	default int FadeIn(){ return 2500; }
	@ConfigItem(
			position = 3,
			keyName = "FadeOut",
			name =  "Fade Out (Millis)",
			description = "Fade Out in Milliseconds"
	)
	default int FadeOut(){ return 2500; }
}
