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
import static net.runelite.client.plugins.itemstats.Builders.boost;
import static net.runelite.client.plugins.itemstats.Builders.heal;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import static net.runelite.client.plugins.itemstats.stats.Stats.HITPOINTS;
import static net.runelite.client.plugins.itemstats.stats.Stats.PRAYER;
import static net.runelite.client.plugins.itemstats.stats.Stats.RUN_ENERGY;

public class Ambrosia implements Effect
{
	@Override
	public StatsChanges calculate(Client client)
	{
		final int currentHp = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int maxHp = client.getRealSkillLevel(Skill.HITPOINTS);
		final int hpToMax = Math.max(0, maxHp - currentHp);
		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final int maxPrayer = client.getRealSkillLevel(Skill.PRAYER);
		final int prayerToMax = Math.max(0, maxPrayer - currentPrayer);

		final StatChange hpChange = boost(HITPOINTS, perc(.25, 2 + hpToMax)).effect(client);
		final StatChange prayerChange = boost(PRAYER, perc(.2, 5 + prayerToMax)).effect(client);
		final StatChange runChange = heal(RUN_ENERGY, 100).effect(client);

		final StatsChanges changes = new StatsChanges(3);
		changes.setStatChanges(new StatChange[]{ hpChange, prayerChange, runChange });
		return changes;
	}
}
