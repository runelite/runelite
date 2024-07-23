/*
 * Copyright (c) 2022, Jordan Atwood <nightfirecat@nightfirec.at>
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

import static java.util.Comparator.naturalOrder;
import static net.runelite.client.plugins.itemstats.Builders.boost;
import static net.runelite.client.plugins.itemstats.Builders.perc;

import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;

import java.util.Comparator;
import java.util.stream.Stream;

import static net.runelite.client.plugins.itemstats.stats.Stats.ATTACK;
import static net.runelite.client.plugins.itemstats.stats.Stats.STRENGTH;
import static net.runelite.client.plugins.itemstats.stats.Stats.DEFENCE;

public class MoonlightPotion implements Effect
{
    @Override
    public StatsChanges calculate(Client client)
    {
        // Player Stats
        final int playerHerblore = client.getRealSkillLevel(Skill.HERBLORE);
        final int playerPrayer = client.getRealSkillLevel(Skill.PRAYER);
        PrayerPotion prayerChange;
        StatChange attackChange;
        StatChange strengthChange;
        StatChange defenceChange;

        // Prayer boost:
        if(playerPrayer*0.25 > playerHerblore*0.3)
        {
            prayerChange = new PrayerPotion(7, 0.25);
        }else
        {
            prayerChange = new PrayerPotion((int) (playerHerblore*0.3+7), 0.0);
        }

        // Attack boost:
        if(playerHerblore>= 45)
        {
            attackChange = boost(ATTACK, perc(0.15,5)).effect(client);
        }else
        {
            attackChange = boost(ATTACK, perc(0.1,3)).effect(client);
        }

        // Strength boost:
        if(playerHerblore>=55)
        {
            strengthChange = boost(STRENGTH, perc(0.15,5)).effect(client);
        }else
        {
            strengthChange = boost(STRENGTH, perc(0.1,3)).effect(client);
        }

        //Defence boost:
        if(playerHerblore>=0 && playerHerblore<=65)
        {
            defenceChange = boost(DEFENCE, perc(0.1,3)).effect(client);
        }else if(playerHerblore>=66 && playerHerblore<=69)
        {
            defenceChange = boost(DEFENCE, perc(0.15,5)).effect(client);
        } else
        {
            defenceChange = boost(DEFENCE, perc(0.2,7)).effect(client);
        }

        final StatsChanges changes = new StatsChanges(4);

        changes.setStatChanges(new StatChange[]{ prayerChange.effect(client), attackChange, strengthChange, defenceChange });

        changes.setPositivity(Stream.of(changes.getStatChanges())
                .map(StatChange::getPositivity)
                .max(naturalOrder()).get());

        return changes;
    }
}
