/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.aaautoswitcherbeta;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("autoswitcher")
public interface AutoSwitcherConfig extends Config {

    @ConfigItem(
            position = 0,
            keyName = "menuEntriesEnabled",
            name = "Menu Entries",
            description = "Enables Menu Entries to be altared. (REQUIRED for setup)"
    )
    default boolean menuEntriesEnabled() {
        return true;
    }


    @ConfigItem(
            position = 1,
            keyName = "presetColor1",
            name = "Preset 1",
            description = "Color of the Tag"
    )
    default Color getPreset1Color() {
        return Color.red;
    }

    @ConfigItem(
            position = 2,
            keyName = "preset1",
            name = "",
            description = "The (Script) for preset 1"
    )
    default String preset1() {
        return "";
    }

    @ConfigItem(
            keyName = "preset1",
            name = "",
            description = ""
    )
    void setPreset1(String key);


    @ConfigItem(
            position = 3,
            keyName = "presetColor2",
            name = "Preset 2",
            description = "Color of the Tag"
    )
    default Color getPreset2Color() {
        return Color.green;
    }

    @ConfigItem(
            position = 4,
            keyName = "preset2",
            name = "",
            description = "The (Script) for preset 2"
    )
    default String preset2() {
        return "";
    }

    @ConfigItem(
            keyName = "preset2",
            name = "",
            description = ""
    )
    void setPreset2(String key);


    @ConfigItem(
            position = 5,
            keyName = "presetColor3",
            name = "Preset 3",
            description = "Color of the Tag"
    )
    default Color getPreset3Color() {
        return Color.blue;
    }

    @ConfigItem(
            position = 6,
            keyName = "preset3",
            name = "",
            description = "The (Script) for preset 3"
    )
    default String preset3() {
        return "";
    }

    @ConfigItem(
            keyName = "preset3",
            name = "",
            description = ""
    )
    void setPreset3(String key);

    @ConfigItem(
            position = 7,
            keyName = "presetColor4",
            name = "Preset 4",
            description = "Color of the Tag"
    )
    default Color getPreset4Color() {
        return Color.MAGENTA;
    }

    @ConfigItem(
            position = 8,
            keyName = "preset4",
            name = "",
            description = "The (Script) for preset 4"
    )
    default String preset4() {
        return "";
    }

    @ConfigItem(
            position = 9,
            keyName = "preset4",
            name = "",
            description = ""
    )
    void setPreset4(String key);
}
