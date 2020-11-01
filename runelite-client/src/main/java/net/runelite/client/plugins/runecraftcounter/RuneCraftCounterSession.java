/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.runecraftcounter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemID;
import javax.inject.Singleton;

@SuppressWarnings("ALL")
@Slf4j
@Singleton
public class RuneCraftCounterSession
{

    public RuneCraftCounterSession()
    {
        totalCrafted = 0;
        fireRuneCrafted = 0;
        waterRuneCrafted = 0;
        airRuneCrafted = 0;
        earthRuneCrafted = 0;
        mindRuneCrafted = 0;
        bodyRuneCrafted = 0;
        deathRuneCrafted = 0;
        natureRuneCrafted = 0;
        chaosRuneCrafted = 0;
        lawRuneCrafted = 0;
        cosmicRuneCrafted = 0;
        bloodRuneCrafted = 0;
        soulRuneCrafted = 0;
        astralRuneCrafted = 0;
        wrathRuneCrafted = 0;
    }

    @Getter(AccessLevel.PACKAGE)
    private int totalCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int fireRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int waterRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int airRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int earthRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int mindRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int bodyRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int deathRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int natureRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int chaosRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int lawRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int cosmicRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int bloodRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int soulRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int astralRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int wrathRuneCrafted;

    void incrementRunesCrafted(int runeId, int quantity)
    {
        switch(runeId)
        {
            case ItemID.FIRE_RUNE:
                fireRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.WATER_RUNE:
                waterRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.AIR_RUNE:
                airRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.EARTH_RUNE:
                earthRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.MIND_RUNE:
                mindRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.BODY_RUNE:
                bodyRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.DEATH_RUNE:
                deathRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.NATURE_RUNE:
                natureRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.CHAOS_RUNE:
                chaosRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.LAW_RUNE:
                lawRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.COSMIC_RUNE:
                cosmicRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.BLOOD_RUNE:
                bloodRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.SOUL_RUNE:
                soulRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.ASTRAL_RUNE:
                astralRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.WRATH_RUNE:
                wrathRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            default:
                log.debug("Invalid rune type specified. The rune count will not be incremented.");
        }
    }
}
