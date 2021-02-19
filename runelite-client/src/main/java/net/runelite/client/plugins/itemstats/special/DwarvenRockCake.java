/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.itemstats.special;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import static net.runelite.client.plugins.itemstats.Builders.heal;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import static net.runelite.client.plugins.itemstats.stats.Stats.HITPOINTS;

public class DwarvenRockCake implements Effect
{
	@Override
	public StatsChanges calculate(Client client)
	{
		final int current = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int eat = current <= 1 ? 0 : -1;
		// -10% of current health, rounded down, plus one
		final int guzzle = current <= 1 ? 0 : -1 * (current / 10 + 1);
		final StatChange eatChange = heal(HITPOINTS, eat).effect(client);
		final StatChange guzzleChange = heal(HITPOINTS, guzzle).effect(client);

		final StatsChanges changes = new StatsChanges(2);
		changes.setStatChanges(new StatChange[]{ eatChange, guzzleChange });
		return changes;
	}
}
