/*
 * Copyright (c) 2024 Macweese
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

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.SimpleStatBoost;
import net.runelite.client.plugins.itemstats.StatBoost;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.itemstats.delta.DeltaCalculator;
import net.runelite.client.plugins.itemstats.stats.Stat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import static net.runelite.client.plugins.itemstats.stats.Stats.ATTACK;
import static net.runelite.client.plugins.itemstats.stats.Stats.DEFENCE;
import static net.runelite.client.plugins.itemstats.stats.Stats.HERBLORE;
import static net.runelite.client.plugins.itemstats.stats.Stats.PRAYER;
import static net.runelite.client.plugins.itemstats.stats.Stats.STRENGTH;

@RequiredArgsConstructor
public class MoonlightPotion implements Effect
{
	private static final Stat[] OFFENSIVE_MELEE_STATS = {
			ATTACK, STRENGTH
	};

	final StatBoost prayerRestore = new StatBoost(PRAYER, false)
	{
		@Override
		public int heals(Client client)
		{
			int pray = PRAYER.getMaximum(client);
			int herb = HERBLORE.getValue(client);
			return herb < 38 ? 0 : (int) Math.max(pray * 0.25, herb * 0.3) + 7;
		}
	};

	@Override
	public StatsChanges calculate(Client client)
	{
		StatsChanges changes = new StatsChanges(0);
		StatChange restoreChange = prayerRestore.effect(client);

		SimpleStatBoost attackBoost = new SimpleStatBoost(ATTACK, true, getMeleeEffect(client, ATTACK));
		SimpleStatBoost defenceBoost = new SimpleStatBoost(DEFENCE, true, getMeleeEffect(client, DEFENCE));
		SimpleStatBoost strengthBoost = new SimpleStatBoost(STRENGTH, true, getMeleeEffect(client, STRENGTH));

		changes.setStatChanges(Stream.of(
			Stream.of(restoreChange),
			Stream.of(defenceBoost.effect(client)),
			Stream.of(OFFENSIVE_MELEE_STATS)
				.map(stat ->
				{
					if (stat == ATTACK)
					{
						attackBoost.setStat(stat);
						return attackBoost.effect(client);
					}
					if (stat == STRENGTH)
					{
						strengthBoost.setStat(stat);
						return strengthBoost.effect(client);
					}
					return null;
				}))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.toArray(StatChange[]::new));

		changes.setPositivity(Stream.of(changes.getStatChanges())
			.map(StatChange::getPositivity)
			.max(Comparator.naturalOrder()).orElseThrow());
		return changes;
	}

	private DeltaCalculator getMeleeEffect(Client client, Stat stat)
	{
		return Arrays.stream(MeleeEffect.values())
			.filter(t -> t.getStat() == stat && client.getBoostedSkillLevel(Skill.HERBLORE) >= t.getLevelRequirement())
			.max(Comparator.comparingInt(MeleeEffect::getLevelRequirement))
			.orElseGet(() -> MeleeEffect.NONE).getDeltaCalculator();
	}
}

@Getter
enum MeleeEffect
{
	ATTACK_POTION(ATTACK, 3, perc(.10, 3)),
	DEFENCE_POTION(DEFENCE, 30, perc(.10, 3)),
	// Misnomer: Moonlight potion gives the effect of smelling salts on defence but requires the level for,
	// and activates the var/effect timer for—albeit without the drain prevention from—Divine Super Defence potion
	DIVINE_SUPER_DEFENCE_POTION(DEFENCE, 70, perc(.16, 11)),
	STRENGTH_POTION(STRENGTH, 12, perc(.10, 3)),
	SUPER_ATTACK_POTION(ATTACK, 45, perc(.15, 5)),
	SUPER_DEFENCE_POTION(DEFENCE, 66, perc(.15, 5)),
	SUPER_STRENGTH_POTION(STRENGTH, 55, perc(.15, 5)),
	NONE(null, 0, max -> 0),
	;

	private final Stat stat;
	private final int levelRequirement;
	private final DeltaCalculator deltaCalculator;

	MeleeEffect(Stat stat, int levelRequirement, DeltaCalculator deltaCalculator)
	{
		this.stat = stat;
		this.levelRequirement = levelRequirement;
		this.deltaCalculator = deltaCalculator;
	}
}
