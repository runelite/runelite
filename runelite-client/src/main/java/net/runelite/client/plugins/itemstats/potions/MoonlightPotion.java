/*
 * Copyright (c) 2024, Thource <me@thource.dev>
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

import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import static net.runelite.client.plugins.itemstats.Builders.boost;
import static net.runelite.client.plugins.itemstats.Builders.heal;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.ItemStatChanges;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import static net.runelite.client.plugins.itemstats.stats.Stats.DEFENCE;
import static net.runelite.client.plugins.itemstats.stats.Stats.HITPOINTS;
import static net.runelite.client.plugins.itemstats.stats.Stats.PRAYER;
import static net.runelite.client.plugins.itemstats.stats.Stats.RUN_ENERGY;

public class MoonlightPotion implements Effect
{
	private final Effect attack;
	private final Effect superAttack;
	private final Effect strength;
	private final Effect superStrength;
	private final Effect defence;
	private final Effect superDefence;

    public MoonlightPotion(Effect attack, Effect superAttack, Effect strength, Effect superStrength, Effect defence, Effect superDefence)
	{
        this.attack = attack;
        this.superAttack = superAttack;
        this.strength = strength;
        this.superStrength = superStrength;
        this.defence = defence;
        this.superDefence = superDefence;
    }

    @Override
	public StatsChanges calculate(Client client)
	{
		final int currentHerblore = client.getBoostedSkillLevel(Skill.HERBLORE);
		final int maxPrayer = client.getRealSkillLevel(Skill.PRAYER);
		final Effect attackEffect = currentHerblore < 45 ? attack : superAttack;
		final Effect strengthEffect = currentHerblore < 55 ? strength : superStrength;
		final Effect defenceEffect = currentHerblore < 66 ? defence :
				(currentHerblore < 70 ? superDefence : boost(DEFENCE, perc(.2, 7)));

		final List<StatChange> changeList = new ArrayList<>();

		// If the player's current Herblore level is less than 38 when the potion is drunk, it will not restore any prayer points.
		if (currentHerblore >= 38)
		{
			changeList.add(heal(PRAYER, (int) Math.max(maxPrayer * .25, currentHerblore * .3) + 7).effect(client));
		}

		changeList.addAll(List.of(attackEffect.calculate(client).getStatChanges()));
		changeList.addAll(List.of(strengthEffect.calculate(client).getStatChanges()));
		changeList.addAll(List.of(defenceEffect.calculate(client).getStatChanges()));

		final StatsChanges changes = new StatsChanges(changeList.size());
		changes.setStatChanges(changeList.toArray(new StatChange[0]));
		return changes;
	}
}
