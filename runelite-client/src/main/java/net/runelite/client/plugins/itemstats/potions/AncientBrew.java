/*
 * Copyright (c) 2022 Hydrox6 <ikada@protonmail.ch>
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
import net.runelite.client.plugins.itemstats.BoostedStatBoost;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import net.runelite.client.plugins.itemstats.CappedStatBoost;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.SimpleStatBoost;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.itemstats.stats.Stat;
import static net.runelite.client.plugins.itemstats.stats.Stats.ATTACK;
import static net.runelite.client.plugins.itemstats.stats.Stats.DEFENCE;
import static net.runelite.client.plugins.itemstats.stats.Stats.MAGIC;
import static net.runelite.client.plugins.itemstats.stats.Stats.PRAYER;
import static net.runelite.client.plugins.itemstats.stats.Stats.STRENGTH;
import java.util.Comparator;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class AncientBrew implements Effect
{
	private static final Stat[] LOWERED_STATS = {
		ATTACK, STRENGTH, DEFENCE
	};
	private static final CappedStatBoost PRAYER_BOOST = new CappedStatBoost(PRAYER, perc(.1, 2), perc(.05, 0));
	private static final BoostedStatBoost MELEE_DRAIN = new BoostedStatBoost(null, false, perc(.1, -2));

	private final double magicBoostPercent;
	private final int magicBoostAmount;

	@Override
	public StatsChanges calculate(Client client)
	{
		final SimpleStatBoost magic = new SimpleStatBoost(MAGIC, true, perc(magicBoostPercent, magicBoostAmount));

		StatsChanges changes = new StatsChanges(0);
		changes.setStatChanges(Stream.of(
			Stream.of(PRAYER_BOOST.effect(client)),
			Stream.of(magic.effect(client)),
			Stream.of(LOWERED_STATS)
				.filter(stat -> 0 < stat.getValue(client))
				.map(stat ->
				{
					MELEE_DRAIN.setStat(stat);
					return MELEE_DRAIN.effect(client);
				}))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.toArray(StatChange[]::new));
		changes.setPositivity(Stream.of(changes.getStatChanges())
			.map(StatChange::getPositivity)
			.max(Comparator.naturalOrder()).get());
		return changes;
	}
}
