/*
 * Copyright (c) 2020, Macweese <macweese@pm.me>
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

package net.runelite.client.plugins.environmenteffects;

import net.runelite.client.config.*;

@ConfigGroup("environmenteffects")
public interface EnvironmentConfig extends Config {

    @ConfigItem(
            position = 0,
            keyName = "dungeonLight",
            name = "Night-vision",
            description = "Removes the on-screen darkening effect in caves and dungeons",
            warning = "This feature will remove the darkening effect in certain areas\nbut will NOT stop the player from taking damage!"

    )
    default boolean nightVision() {
        return false;
    }

    @ConfigItem(
            position = 1,
            keyName = "smokeDungeon",
            name = "Remove smoke",
            description = "Removes the on-screen smoke effect in the Pollnivneach Smoke Dungeon & Thermonuclear Smoke Dungeon"
    )
    default boolean smokeEffect() {
        return false;
    }

    @ConfigItem(
            position = 2,
            keyName = "snowTrollheim",
            name = "Remove snow",
            description = "Removes the on-screen snow effect north of Trollheim & God Wars entrance"
    )
    default boolean snowEffect() {
        return false;
    }

    @ConfigItem(
            position = 3,
            keyName = "zamorakDarkness",
            name = "Remove darkness",
            description = "Removes the on-screen darkening effect in the Zamorak chamber of GWD"
    )
    default boolean zamorakEffect() {
        return false;
    }
/*
       @ConfigItem(
               position = 4,
               keyName = "fishingTrawler",
               name = "Fishing Trawler",
               description = "Disable the camera bobbing effect in the Fishing Trawler minigame"
       )
       default boolean fishingTrawler() {
           return false;
       }


       @ConfigItem(
               position = 5,
               keyName = "olmShake",
               name = "CoX earthquake",
               description = "Disable the camera shake effect during the fight against Olm in Chambers of Xeric"

       )
       default boolean olmShake() {
           return false;
       }
*/
}
