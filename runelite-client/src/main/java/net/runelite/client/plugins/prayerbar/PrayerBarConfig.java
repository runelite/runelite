/*
 * Copyright (c) 2018 Chdata
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
package net.runelite.client.plugins.prayerbar;

import java.awt.Color;
import java.awt.Dimension;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "prayerbar",
	name = "Prayer Bar",
	description = "Configuration for the overhead prayer bar"
)
public interface PrayerBarConfig extends Config
{
    @ConfigItem(
            keyName = "prayerBarHideIfNotPraying",
            name = "Hide while prayer is inactive",
            description = "Prayer bar will be hidden while prayers are inactivate.",
            position = 1
    )
    default boolean hideIfNotPraying()
    {
        return true;
    }

    @ConfigItem(
            keyName = "prayerBarHideIfNonCombat",
            name = "Hide while out-of-combat",
            description = "Prayer bar will be hidden while out-of-combat.",
            position = 2
    )
    default boolean hideIfOutOfCombat()
    {
        return false;
    }

    @ConfigItem(
		keyName = "prayerBarFgColor",
		name = "Prayer Bar FG Color",
		description = "Color of the overhead prayer bar",
		position = 3
	)
	default Color getPrayerBarColor()
	{
		return Color.cyan; //new Color(0x67, 0xD4, 0xA9) // Prayer Potion color
	}

	@ConfigItem(
			keyName = "prayerBarBgColor",
			name = "Prayer Bar BG Color",
			description = "Color of the background of the overhead prayer bar",
			position = 4
	)
	default Color getPrayerBarBackgroundColor()
	{
		return Color.white;
	}

	@ConfigItem(
			keyName = "prayerBarBgAlpha",
			name = "Prayer Bar BG Alpha",
			description = "Translucency of the background of the overhead prayer bar",
			position = 5
	)
	default int getPrayerBarBackgroundAlpha()
	{
		return 255;
	}
}
