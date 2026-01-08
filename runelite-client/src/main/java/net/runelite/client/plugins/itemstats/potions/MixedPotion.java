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

import java.util.Comparator;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import static net.runelite.client.plugins.itemstats.Builders.food;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.Positivity;
import net.runelite.client.plugins.itemstats.StatChange;
import static net.runelite.client.plugins.itemstats.stats.Stats.HITPOINTS;
import net.runelite.client.plugins.itemstats.StatsChanges;
import org.apache.commons.lang3.ArrayUtils;

@RequiredArgsConstructor
public class MixedPotion implements Effect
{
	private final int heal;

	@Nonnull
	private final Effect potion;

	@Override
	public StatsChanges calculate(Client client)
	{
		final StatsChanges changes = new StatsChanges(0);
		final StatChange mixedPotionHpBoost = food(heal).effect(client);
		final StatsChanges potionChanges = potion.calculate(client);
		final int mixedPotionHitpointsHealing = mixedPotionHpBoost.getRelative();

		if (Stream.of(potionChanges.getStatChanges()).anyMatch(statChange -> statChange.getStat() == HITPOINTS))
		{
			changes.setStatChanges(Stream.of(potionChanges.getStatChanges())
				.map(change ->
				{
					/*
					 * Mixed potions do not exist ingame for all types of potions. In fact, at the time of writing, the
					 * Zamorak mix is the only mixed potion which includes base potion effects which affect a player's
					 * Hitpoints. Working from what we know of how these behave, this code assumes that mixed potions
					 * including Hitpoints changes will only include negative HP effects as the
					 * absolute/relative/theoretical end values cannot be determined otherwise. For this reason, potions
					 * with positive HP effects will not have their stat changes affected here.
					 */
					if (change.getStat() != HITPOINTS || mixedPotionHitpointsHealing == 0 || change.getTheoretical() >= 0)
					{
						return change;
					}

					/*
					 * Mixed potions apply two hitpoints changes, both based on the current hitpoints value. Because of
					 * this, the two effects are calculated independently of each other, both against the same starting
					 * hitpoints value and later combined. These effects are:
					 *   1. A food effect of `heal` amount
					 *   2. Deduct hitpoints equal to the potion's boost amount
					 */

					final int max = HITPOINTS.getMaximum(client);
					final int absolute = change.getAbsolute();
					final int relative = change.getRelative();

					if (absolute + mixedPotionHitpointsHealing > max)
					{
						change.setPositivity(Positivity.BETTER_CAPPED);
					}
					else if (relative + mixedPotionHitpointsHealing > 0)
					{
						change.setPositivity(Positivity.BETTER_UNCAPPED);
					}
					else if (relative + mixedPotionHitpointsHealing == 0)
					{
						change.setPositivity(Positivity.NO_CHANGE);
					}
					else
					{
						change.setPositivity(Positivity.WORSE);
					}

					change.setAbsolute(Math.min(max, absolute + mixedPotionHitpointsHealing));
					change.setRelative(change.getRelative() + mixedPotionHitpointsHealing);
					change.setTheoretical(change.getTheoretical() + mixedPotionHitpointsHealing);

					return change;
				})
				.toArray(StatChange[]::new));
		}
		else
		{
			changes.setStatChanges(ArrayUtils.addAll(new StatChange[] { mixedPotionHpBoost }, potionChanges.getStatChanges()));
		}

		changes.setPositivity(Stream.of(changes.getStatChanges())
			.map(StatChange::getPositivity)
			.max(Comparator.naturalOrder()).get());

		return changes;
	}
}
