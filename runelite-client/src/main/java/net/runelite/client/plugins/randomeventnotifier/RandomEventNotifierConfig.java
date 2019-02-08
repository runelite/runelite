/*
 * Copyright (c) 2016-2017, Dylan Vollrath
 * Copyright (c) 2017, dylanvoll <https://github.com/dylanvoll>
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

package net.runelite.client.plugins.randomeventnotifier;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("randomeventnotifier")
public interface RandomEventNotifierConfig extends Config {

    @ConfigItem(
            keyName = "drJekyllEnabled",
            name = "Dr Jekyll",
            description = "Configures if Dr Jekyll random event notifications are enabled",
            position = 1
    )
    default boolean drJekyllEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "beeKeeperEnabled",
            name = "Bee Keeper",
            description = "Configures if Bee Keeper random event notifications are enabled",
            position = 2
    )
    default boolean beeKeeperEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "captArnavEnabled",
            name = "Capt Arnav",
            description = "Configures if Capt Arnav random event notifications are enabled",
            position = 3
    )
    default boolean captArnavEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "sergeantDamienEnabled",
            name = "Sergeant Damien",
            description = "Configures if Sergeant Damien random event notifications are enabled",
            position = 4
    )
    default boolean sergeantDamienEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "drunkenDwarfEnabled",
            name = "Drunken Dwarf",
            description = "Configures if Drunken Dwarf random event notifications are enabled",
            position = 5
    )
    default boolean drunkenDwarfEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "freakyForesterEnabled",
            name = "Freaky Forester",
            description = "Configures if Freaky Forester random event notifications are enabled",
            position = 6
    )
    default boolean freakyForesterEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "frogPrincessEnabled",
            name = "Frog Princess",
            description = "Configures if Frog Princess random event notifications are enabled",
            position = 7
    )
    default boolean frogPrincessEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "genieEnabled",
            name = "Genie",
            description = "Configures if Genie random event notifications are enabled",
            position = 8
    )
    default boolean genieEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "evilBobEnabled",
            name = "Evil Bob",
            description = "Configures if Evil Bob random event notifications are enabled",
            position = 9
    )
    default boolean evilBobEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "postiePeteEnabled",
            name = "Postie Pete",
            description = "Configures if Postie Pete random event notifications are enabled",
            position = 10
    )
    default boolean postiePeteEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "leoEnabled",
            name = "Leo",
            description = "Configures if Leo random event notifications are enabled",
            position = 11
    )
    default boolean leoEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "mysteriousOldManEnabled",
            name = "Mysterious Old Man",
            description = "Configures if Mysterious Old Man random event notifications are enabled",
            position = 12
    )
    default boolean mysteriousOldManEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "pilloryGuardEnabled",
            name = "Pillory Guard",
            description = "Configures if Pillory Guard random event notifications are enabled",
            position = 13
    )
    default boolean pilloryGuardEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "flippaEnabled",
            name = "Flippa",
            description = "Configures if Flippa random event notifications are enabled",
            position = 14
    )
    default boolean flippaEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "quizMasterEnabled",
            name = "Quiz Master",
            description = "Configures if Quiz Master random event notifications are enabled",
            position = 15
    )
    default boolean quizMasterEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "rickTurpentineEnabled",
            name = "Rick Turpentine",
            description = "Configures if Rick Turpentine random event notifications are enabled",
            position = 16
    )
    default boolean rickTurpentineEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "sandwichLadyEnabled",
            name = "Sandwich Lady",
            description = "Configures if Sandwich Lady random event notifications are enabled",
            position = 17
    )
    default boolean sandwichLadyEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "dunceEnabled",
            name = "Dunce",
            description = "Configures if Dunce random event notifications are enabled",
            position = 18
    )
    default boolean dunceEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "strangePlantEnabled",
            name = "Strange Plant",
            description = "Configures if Strange Plant random event notifications are enabled",
            position = 19
    )
    default boolean strangePlantEnabled()
    {
        return true;
    }

    @ConfigItem(
            keyName = "nilesMilesGilesEnabled",
            name = "Niles Miles Giles",
            description = "Configures if Niles Miles Giles random event notifications are enabled",
            position = 20
    )
    default boolean nilesMilesGilesEnabled()
    {
        return true;
    }
}
