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

import java.util.ArrayList;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.ItemStatChanges;
import net.runelite.client.plugins.itemstats.SimpleStatBoost;
import net.runelite.client.plugins.itemstats.SingleEffect;
import net.runelite.client.plugins.itemstats.StatBoost;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.itemstats.delta.DeltaPercentage;
import net.runelite.client.plugins.itemstats.stats.Stat;
import java.util.Arrays;
import java.util.Comparator;
import static net.runelite.client.plugins.itemstats.stats.Stats.ATTACK;
import static net.runelite.client.plugins.itemstats.stats.Stats.DEFENCE;
import static net.runelite.client.plugins.itemstats.stats.Stats.HERBLORE;
import static net.runelite.client.plugins.itemstats.stats.Stats.PRAYER;
import static net.runelite.client.plugins.itemstats.stats.Stats.STRENGTH;

@RequiredArgsConstructor
public class MoonlightPotion implements Effect
{
	@Override
	public StatsChanges calculate(Client client)
	{
		StatsChanges changes = new StatsChanges(4);
		ArrayList<StatChange> statChanges = new ArrayList<>();

		getStatChange(client, ATTACK).ifPresent(e -> statChanges.add(e.getEffect().effect(client)));
		getStatChange(client, DEFENCE).ifPresent(e -> statChanges.add(e.getEffect().effect(client)));
		getStatChange(client, STRENGTH).ifPresent(e -> statChanges.add(e.getEffect().effect(client)));
		getStatChange(client, PRAYER).ifPresent(e -> statChanges.add(e.getEffect().effect(client)));

		changes.setStatChanges(statChanges.toArray(StatChange[]::new));
		return changes;
	}

	private Optional<StatEffect> getStatChange(Client client, Stat stat)
	{
		return Arrays.stream(StatEffect.values())
			.filter(t -> t.getStat() == stat && client.getBoostedSkillLevel(Skill.HERBLORE) >= t.getLevelRequirement())
			.max(Comparator.comparingInt(StatEffect::getLevelRequirement));
	}
}

@Getter
enum StatEffect
{
	ATTACK_POTION(ATTACK, 3, ItemStatChanges.ATTACK_POT),
	DEFENCE_POTION(DEFENCE, 30, ItemStatChanges.DEFENCE_POT),
	// Misnomer: Moonlight potion gives a stronger effect than Super Defence on defence but requires the level for,
	// and activates the var/effect timer for—albeit without the drain prevention from—Divine Super Defence potion
	DIVINE_SUPER_DEFENCE_POTION(DEFENCE, 70, new SimpleStatBoost(DEFENCE, true, new DeltaPercentage(.2, 7))),
	STRENGTH_POTION(STRENGTH, 12, ItemStatChanges.STRENGTH_POT),
	SUPER_ATTACK_POTION(ATTACK, 45, ItemStatChanges.SUPER_ATTACK_POT),
	SUPER_DEFENCE_POTION(DEFENCE, 66, ItemStatChanges.SUPER_DEFENCE_POT),
	SUPER_STRENGTH_POTION(STRENGTH, 55, ItemStatChanges.SUPER_STRENGTH_POT),
	PRAYER_POTION(PRAYER, 38, new StatBoost(PRAYER, false)
	{
		@Override
		public int heals(Client client)
		{
			int pray = PRAYER.getMaximum(client);
			int herb = HERBLORE.getValue(client);
			return herb < 38 ? 0 : (int) Math.max(pray * 0.25, herb * 0.3) + 7;
		}
	}),
	;

	private final Stat stat;
	private final int levelRequirement;
	private final SingleEffect effect;

	StatEffect(Stat stat, int levelRequirement, SingleEffect effect)
	{
		this.stat = stat;
		this.levelRequirement = levelRequirement;
		this.effect = effect;
	}
}
