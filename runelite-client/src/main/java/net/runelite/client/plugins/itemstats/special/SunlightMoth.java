/*
 * Copyright (c) 2024, Macweese
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
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.SimpleStatBoost;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.itemstats.stats.Stat;
import java.util.Comparator;
import java.util.stream.Stream;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import static net.runelite.client.plugins.itemstats.stats.Stats.*;

public class SunlightMoth implements Effect
{
	private static final Stat[] RESTORED_STATS = {
		ATTACK, DEFENCE, STRENGTH, RANGED, MAGIC, COOKING,
		WOODCUTTING, FLETCHING, FISHING, FIREMAKING, CRAFTING, SMITHING, MINING,
		HERBLORE, AGILITY, THIEVING, SLAYER, FARMING, RUNECRAFT, HUNTER,
		CONSTRUCTION
	};

	public final double percentRestored;
	private final int delta;

	public SunlightMoth(double percentRestored, int delta)
	{
		this.percentRestored = percentRestored;
		this.delta = delta;
	}

	@Override
	public StatsChanges calculate(Client client)
	{
		StatsChanges changes = new StatsChanges(0);

		SimpleStatBoost calcRestore = new SimpleStatBoost(null, false, perc(percentRestored, delta));
		SimpleStatBoost calcHeal = new SimpleStatBoost(HITPOINTS, false, perc(0, 8));

		changes.setStatChanges(Stream.concat(
			Stream.of(new Stat[]{HITPOINTS})
				.map(stat -> calcHeal.effect(client)),
			Stream.of(RESTORED_STATS)
				.filter(stat -> stat.getValue(client) < stat.getMaximum(client))
				.map(stat ->
				{
					calcRestore.setStat(stat);
					return calcRestore.effect(client);
				})
		).toArray(StatChange[]::new));
		changes.setPositivity(Stream.of(changes.getStatChanges())
				.map(StatChange::getPositivity)
				.max(Comparator.naturalOrder()).orElse(null));
		return changes;
	}
}
