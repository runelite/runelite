/*
 * Copyright (c) 2018, Fluffeh <berserkfluff@gmail.com>
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
package net.runelite.client.plugins.flinching;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("flinching")
public interface FlinchingConfig extends Config
{
    @ConfigItem(

            position = 0,
            keyName = "hexColorFlinch",
            name = "Overlay Color",
            description = "Color of flinching timer overlay"
    )
    default Color getFlinchOverlayColor()
    {
        return Color.CYAN;
    }

    @ConfigItem(

            position = 1,
            keyName = "flinchOverlaySize",
            name = "Overlay Diameter",
            description = "Flinch overlay timer diameter"
    )
    default int getFlinchOverlaySize()
    {
        return 30;
    }

    @ConfigItem(

            position = 2,
            keyName = "flinchDelay",
            name = "Flinch Timer Delay",
            description = "Shows the appropriate time to attack while flinching milliseconds"
    )
    default int getFlinchDelay()
    {
        return 5400;
    }

    @ConfigItem(

            position = 3,
            keyName = "flinchOnHitReceivedDelay",
            name = "Flinch Hit Received Delay",
            description = "Slightly longer delay after being attacked milliseconds"
    )
    default int getFlinchAttackedDelay()
    {
        return 6600;
    }

    @ConfigItem(

            position = 4,
            keyName = "flinchResetOnHit",
            name = "Reset on Hit",
            description = "Timer resets after every attack from your character"
    )
    default boolean getFlinchResetOnHit()
    {
        return true;
    }

    @ConfigItem(

            position = 5,
            keyName = "flinchResetOnHitReceived",
            name = "Reset on Hit Received",
            description = "Timer resets when your character gets attacked"
    )
    default boolean getFlinchResetOnHitReceived()
    {
        return true;
    }
}
