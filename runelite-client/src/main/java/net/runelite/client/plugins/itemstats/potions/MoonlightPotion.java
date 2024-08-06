/*
 * Copyright (c) 2024, burkeg
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
package net.runelite.client.plugins.itemstats.potions;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.skillcalculator.skills.HerbloreAction;

import static net.runelite.client.plugins.itemstats.Builders.*;
import static net.runelite.client.plugins.itemstats.stats.Stats.*;

public class MoonlightPotion implements Effect {

    @Override
    public StatsChanges calculate(Client client) {
        final int currentHerblore = client.getBoostedSkillLevel(Skill.HERBLORE);

        StatChange prayerChange = heal(PRAYER, 0).effect(client);
        // Only gives a boost if you have the herblore level to make prayer pots, then calculates restoration amount
        // based on your herblore and prayer level then takes the better of the two.
        if (currentHerblore >= HerbloreAction.PRAYER_POTION_3.getLevel()) {
            StatChange prayerChange_standard = heal(PRAYER, perc(.25, 7)).effect(client);
            StatChange herbloreChange = heal(HERBLORE, perc(.30, 7)).effect(client);
            StatChange prayerChange_herblore_based = heal(PRAYER, herbloreChange.getTheoretical()).effect(client);
            // TODO Boosting your herblore actually does improve prayer restoration, however the way it's being
            //  calculated here only takes into account your real skill level so it may be 1 more than shown.
            //  Need to find a way to calculate boost() of a boosted skill as if the current value was the real
            //  skill level.
            prayerChange = (prayerChange_herblore_based.getAbsolute() > prayerChange_standard.getAbsolute())
                    ? prayerChange_herblore_based : prayerChange_standard;
        }

        // Only gives a boost up to the herblore level you have to make the corresponding potion
        StatChange attChange = boost(ATTACK, 0).effect(client);
        if (currentHerblore >= HerbloreAction.SUPER_ATTACK_3.getLevel()) {
            attChange = boost(ATTACK, perc(.15, 5)).effect(client);
        } else if (currentHerblore >= HerbloreAction.ATTACK_POTION_3.getLevel()) {
            attChange = boost(ATTACK, perc(.10, 3)).effect(client);
        }

        // Only gives a boost up to the herblore level you have to make the corresponding potion
        StatChange strChange = boost(STRENGTH, 0).effect(client);
        if (currentHerblore >= HerbloreAction.SUPER_STRENGTH_3.getLevel()) {
            strChange = boost(STRENGTH, perc(.15, 5)).effect(client);
        } else if (currentHerblore >= HerbloreAction.STRENGTH_POTION_3.getLevel()) {
            strChange = boost(STRENGTH, perc(.10, 3)).effect(client);
        }

        // Only gives a boost up to the herblore level you have to make the corresponding potion, with extra
        // benefits at level 70
        StatChange defChange = boost(DEFENCE, 0).effect(client);
        if (currentHerblore >= 70) {
            defChange = boost(DEFENCE, perc(.20, 7)).effect(client);
        } else if (currentHerblore >= HerbloreAction.SUPER_DEFENCE_3.getLevel()) {
            defChange = boost(DEFENCE, perc(.15, 5)).effect(client);
        } else if (currentHerblore >= HerbloreAction.DEFENCE_POTION_3.getLevel()) {
            defChange = boost(DEFENCE, perc(.10, 3)).effect(client);
        }

        final StatsChanges changes = new StatsChanges(4);
        changes.setStatChanges(new StatChange[]{prayerChange, attChange, strChange, defChange});

        return changes;
    }
}
