/*
 * Copyright (c) 2025 Macweese
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

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import static net.runelite.client.plugins.itemstats.Builders.boost;
import static net.runelite.client.plugins.itemstats.Builders.combo;
import static net.runelite.client.plugins.itemstats.Builders.heal;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.ItemStatChanges;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import static net.runelite.client.plugins.itemstats.stats.Stats.MAGIC;
import static net.runelite.client.plugins.itemstats.stats.Stats.RANGED;
import static net.runelite.client.plugins.itemstats.stats.Stats.RUN_ENERGY;

@RequiredArgsConstructor
public class CastleWarsBrew implements Effect
{
	@Override
	public StatsChanges calculate(Client client)
	{
		final Effect superRestore = ItemStatChanges.SUPER_RESTORE_POT;
		final Effect boosts = combo(
			ItemStatChanges.SUPER_ATTACK_POT,
			ItemStatChanges.SUPER_STRENGTH_POT,
			ItemStatChanges.SUPER_DEFENCE_POT,
			boost(MAGIC, perc(.10, 1)),
			boost(RANGED, perc(.10, 4)),
			heal(RUN_ENERGY, 20)
		);

		StatsChanges changes = new StatsChanges(0);
		changes.setStatChanges(Stream.concat(
				Arrays.stream(superRestore.calculate(client).getStatChanges()),
				Arrays.stream(boosts.calculate(client).getStatChanges()))
			.toArray(StatChange[]::new));
		changes.setPositivity(Stream.of(changes.getStatChanges())
			.map(StatChange::getPositivity)
			.max(Comparator.naturalOrder())
			.orElseThrow());
		return changes;
	}
}
