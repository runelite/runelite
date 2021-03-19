/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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

import java.util.Comparator;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.SimpleStatBoost;
import net.runelite.client.plugins.itemstats.BoostedStatBoost;
import net.runelite.client.plugins.itemstats.stats.Stat;
import net.runelite.client.plugins.itemstats.StatChange;
import static net.runelite.client.plugins.itemstats.stats.Stats.*;
import net.runelite.client.plugins.itemstats.StatsChanges;

@RequiredArgsConstructor
public class SaradominBrew implements Effect
{
	private static final Stat[] saradominBrewStats = {
		ATTACK, STRENGTH, RANGED, MAGIC
	};

	private final double percH; //percentage heal
	private final double percD; //percentage defence boost
	private final double percSD; //percentage stat drain
	private final int deltaB; //delta boosted
	private final int deltaR; //delta reduced

	@Override
	public StatsChanges calculate(Client client)
	{
		StatsChanges changes = new StatsChanges(0);
		SimpleStatBoost hitpoints = new SimpleStatBoost(HITPOINTS, true, perc(percH, deltaB));
		SimpleStatBoost defence = new SimpleStatBoost(DEFENCE, true, perc(percD, deltaB));
		BoostedStatBoost calc = new BoostedStatBoost(null, false, perc(percSD, -deltaR));
		changes.setStatChanges(Stream.concat(
			Stream.of(hitpoints.effect(client)),
			Stream.concat(
			Stream.of(defence.effect(client)),
			Stream.of(saradominBrewStats)
				.filter(stat -> 1 < stat.getValue(client))
				.map(stat ->
				{
					calc.setStat(stat);
					return calc.effect(client);
				})
			)
		).toArray(StatChange[]::new));
		changes.setPositivity(Stream.of(changes.getStatChanges())
			.map(sc -> sc.getPositivity())
			.max(Comparator.comparing(Enum::ordinal)).get());
		return changes;
	}
}