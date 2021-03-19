/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import static net.runelite.client.plugins.itemstats.Builders.heal;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.itemstats.stats.Stats;

/**
 * Acts like a prayer potion and stamina dose combined but restores 40 energy instead of 20
 */
@RequiredArgsConstructor
public class GauntletPotion implements Effect
{
	private static final int PRAYER_RESTORE_DELTA = 7;
	private static final double PRAYER_RESTORE_PERCENT = .25;

	@Override
	public StatsChanges calculate(Client client)
	{
		// Restores prayer similar to PrayerPotion but there aren't any possible boost so simplify the calculation
		final int restorePerc = (int) (client.getRealSkillLevel(Skill.PRAYER) * PRAYER_RESTORE_PERCENT);
		final StatChange prayer =  heal(Stats.PRAYER, restorePerc + PRAYER_RESTORE_DELTA).effect(client);

		final StatChange runEnergy = heal(Stats.RUN_ENERGY, 40).effect(client);

		final StatsChanges changes = new StatsChanges(2);
		changes.setStatChanges(new StatChange[]{runEnergy, prayer});
		return changes;
	}
}
