/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Credit is due  to SomeoneWithAnInternetConnection and oplosthee
 * for writing the original Runelite Metronome, which inspired this plugin.
 */

package net.runelite.client.plugins.ztickindicator;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.api.SoundEffectID;

@ConfigGroup("Metronome2")

public interface TickIndicatorConfig extends Config
{
    @ConfigItem(
            keyName = "tickInterval",
            name = "Tick interval",
            description = "",
            position = 0
    )
    default int tickCount()
    {
        return 0;
    }


    @ConfigItem(
            keyName = "SoundEffect1",
            name = "Sound effect 1",
            description = "",
            position = 1
    )
    default int SoundEffect1()
    {
        return SoundEffectID.GE_INCREMENT_PLOP;
    }

    @ConfigItem(
            keyName = "Volume1",
            name = "Volume 1",
            description = "loudness",
            position = 2
    )
    default int Volume1()
    {
        return 3;
    }

    @ConfigItem(
            keyName = "SoundEffect2",
            name = "Sound effect 2",
            description = "",
            position = 3
    )
    default int SoundEffect2()
    {
        return SoundEffectID.GE_DECREMENT_PLOP;
    }

    @ConfigItem(
            keyName = "Volume2",
            name = "Volume 2",
            description = "",
            position = 4
    )
    default int Volume2()
    {
        return 3;
    }
}
