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
package net.runelite.client.plugins.aaaflexo;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("flexo")
public interface FlexoConfig extends Config {

    @ConfigItem(
            position = 0,
            keyName = "minDelayAmount",
            name = "Min Delay",
            description = "Minimum delay that is applied to every action at the end (ms)"
    )
    default int minDelayAmt() {
        return 45;
    }


    @ConfigItem(
            position = 1,
            keyName = "reactionTime",
            name = "Reaction Time",
            description = "The base time between actions (ms)"
    )
    default int getReactionTimeVariation() {
        return 80;
    }

    @ConfigItem(
            position = 2,
            keyName = "mouseDragSpeed",
            name = "Mouse drag speed",
            description = "The speed at which steps are executed. Keep at 49? cuz jagex mouse recorder?"
    )
    default int getMouseDragSpeed() {
        return 49;
    }


    @ConfigItem(
            position = 3,
            keyName = "overshoots",
            name = "Overshoots",
            description = "Higher number = more overshoots"
    )
    default int getOvershoots() {
        return 4;
    }


}
