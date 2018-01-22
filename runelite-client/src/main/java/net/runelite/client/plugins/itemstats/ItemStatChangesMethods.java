/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.itemstats;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;

public class ItemStatChangesMethods
{
	final Stats stats;

	final Client client;

	final Map<Integer, StatChangeCalculator> itemToCalcs = new HashMap<>();

	ItemStatChangesMethods(Client client, Stats stats)
	{
		this.client = client;
		this.stats = stats;
	}

	/**
	 * Returns an <code>ItemStatChange</code> for the item passed for the current player's stats
	 *
	 * @param  item ID of the item to lookup
	 * @return      Stat changes for the item, or null
	 * @see         ItemStatChange
	 */
	public ItemStatChange getChanges(int item)
	{
		StatChangeCalculator calcs = itemToCalcs.get(item);
		if (calcs == null)
		{
			return null;
		}
		return calcs.calculate();
	}

	/**
	 * Sets <code>calculator</code> as the <code>StatChangeCalculator</code> for <code>items</code>
	 * Adding multiple StatChangeCalculators to a single item is illegal
	 */
	void add(StatChangeCalculator calculator, int... items)
	{
		assert items.length > 0;
		for (int item : items)
		{
			StatChangeCalculator prev = itemToCalcs.put(item, calculator);
			assert prev == null : "Item already added";
		}
	}

	/**
	 * StatChangeCalculator calculates a {@link ItemStatChange} for the item it is assigned to.
	 * This is responsible for calculating or delegating individual {@link ItemStatChange.StatChange}s
	 * and for calculating the overall positivity of the change.
	 *
	 * @see Combo
	 * @see SuperRestore
	 */
	@FunctionalInterface
	interface StatChangeCalculator
	{
		ItemStatChange calculate();
	}

	/**
	 * Combo takes an list of {@link SingleStatChangeCalculator}s and combines them into
	 * a single StatChangeCalculator.
	 *
	 * <code>numPrimaries</code> may be passed as the first parameter to limit the number
	 * of "Primary" stats to be used for calculating the {@link ItemStatChange}'s overall
	 * positivity
	 */
	static class Combo implements StatChangeCalculator
	{
		private final SingleStatChangeCalculator[] calcs;
		private final int numPrimaries;

		Combo(SingleStatChangeCalculator... calcs)
		{
			this(1, calcs);
		}

		Combo(int numPrimaries, SingleStatChangeCalculator... calcs)
		{
			assert numPrimaries <= calcs.length;
			this.numPrimaries = numPrimaries;
			this.calcs = calcs;
		}

		public ItemStatChange calculate()
		{
			ItemStatChange out = new ItemStatChange(calcs.length);
			for (int i = 0; i < calcs.length; i++)
			{
				out.statChanges[i] = calcs[i].calculate();
			}
			int positivity = Positivity.NO_CHANGE;
			for (int i = 0; i < numPrimaries; i++)
			{
				if (positivity < out.statChanges[i].positivity)
				{
					positivity = out.statChanges[i].positivity;
				}
			}
			out.positivity = positivity;
			return out;
		}
	}

	/**
	 * SingleStatChangeCalculator is responsible for calculating a single stat change
	 */
	@FunctionalInterface
	interface SingleStatChangeCalculator
	{
		ItemStatChange.StatChange calculate();
	}

	/**
	 * DeltaCalculator calculates the change for a stat given it's maximum.
	 * It is a convenience interface for {@link SimpleStatCalc}. It should not
	 * attempt to limit itself based on the <code>max</code> passed to it
	 */
	@FunctionalInterface
	interface DeltaCalculator
	{
		int calculateDelta(int max);
	}

	/**
	 * BOOST is set if the stat's cap should be increased by the calculated delta.
	 * This behaves like most of RuneScape's "Temporary skill boosts"
	 *
	 * @see SimpleStatCalc
	 */
	static final int BOOST = 1;

	/**
	 * A {@link SingleStatChangeCalculator} for simple stat changes.
	 *
	 * @See add
	 * @See perc
	 */
	SingleStatChangeCalculator simple(Stat stat, DeltaCalculator calc, int flags)
	{
		return new SimpleStatCalc(stat, calc, flags);
	}

	SingleStatChangeCalculator simple(Stat stat, DeltaCalculator calc)
	{
		return new SimpleStatCalc(stat, calc, 0);
	}

	@AllArgsConstructor
	private static class SimpleStatCalc implements SingleStatChangeCalculator
	{
		protected Stat stat;
		protected final DeltaCalculator delta;
		protected final int flags;

		public ItemStatChange.StatChange calculate()
		{
			int value = stat.getValue();
			int max = stat.getMaximum();

			boolean hitCap = false;

			int calcedDelta = delta.calculateDelta(max);
			if ((flags & BOOST) != 0 && calcedDelta > 0)
			{
				max += calcedDelta;
			}
			if (value > max)
			{
				max = value;
			}
			int newValue = value + calcedDelta;
			if (newValue > max)
			{
				newValue = max;
				hitCap = true;
			}
			if (newValue < 0)
			{
				newValue = 0;
			}
			int delta = newValue - value;
			ItemStatChange.StatChange out = new ItemStatChange.StatChange();
			out.stat = stat;
			if (delta > 0)
			{
				out.positivity = hitCap ? Positivity.BETTER_CAPPED : Positivity.BETTER_UNCAPPED;
			}
			else if (delta == 0)
			{
				out.positivity = Positivity.NO_CHANGE;
			}
			else
			{
				out.positivity = Positivity.WORSE;
			}
			out.absolute = Integer.toString(newValue);
			out.relative = String.format("%+d", delta);
			return out;
		}
	}

	/**
	 * Add is a <code>DeltaCalculator</code> that adds value to stat.
	 */
	DeltaCalculator add(int value)
	{
		return new DeltaAdd(value);
	}

	@RequiredArgsConstructor
	private static class DeltaAdd implements DeltaCalculator
	{
		protected final int add;

		public int calculateDelta(int max)
		{
			return add;
		}
	}

	/**
	 * <code>perc</code> is a <code>DeltaCalculator</code> that computes <code> (max * perc) + delta </code>
	 * <code>perc</code> always rounds to zero.
	 *
	 * @param perc  The percentage of <code>getMaximum</code> to boost by
	 * @param delta The static change to boost by. If this is negative it also makes perc negative
	 */
	DeltaCalculator perc(double perc, int delta)
	{
		return new DeltaPercentage(perc, delta);
	}

	@RequiredArgsConstructor
	private static class DeltaPercentage implements DeltaCalculator
	{
		protected final double perc;
		protected final int delta;

		public int calculateDelta(int max)
		{
			return (((int) (max * perc)) * (delta >= 0 ? 1 : -1)) + delta;
		}
	}

	/**
	 * Calculates prayer bonus based on if the user has a holy wrench or similar
	 * in their inventory.
	 */
	@RequiredArgsConstructor
	class PrayerCalc implements DeltaCalculator
	{
		protected final int delta;

		public int calculateDelta(int max)
		{
			boolean wrenchEffect = false;// TODO:

			double perc = wrenchEffect ? 27 : .25;
			return (((int) (max * perc)) * (delta >= 0 ? 1 : -1)) + delta;
		}
	}

	/**
	 * Food represents a static change in hitpoints, non boosting
	 */
	StatChangeCalculator Food(int healing)
	{
		return new Combo(simple(stats.HITPOINTS, add(healing)));
	}

	@RequiredArgsConstructor
	class SuperRestore implements StatChangeCalculator
	{
		private final int delta;
		private final Stat[] superRestoreStats = new Stat[]{
			stats.ATTACK, stats.DEFENCE, stats.STRENGTH, stats.RANGED, stats.MAGIC, stats.COOKING,
			stats.WOODCUTTING, stats.FLETCHING, stats.FISHING, stats.FIREMAKING, stats.CRAFTING, stats.SMITHING, stats.MINING,
			stats.HERBLORE, stats.AGILITY, stats.THIEVING, stats.SLAYER, stats.FARMING, stats.RUNECRAFT, stats.HUNTER,
			stats.CONSTRUCTION
		};

		public ItemStatChange calculate()
		{
			SimpleStatCalc calc = new SimpleStatCalc(null, perc(.25, delta), 0);
			SimpleStatCalc prayer = new SimpleStatCalc(stats.PRAYER, new PrayerCalc(delta), 0);
			ItemStatChange out = new ItemStatChange(0);
			out.statChanges =
				Stream.concat(
					Stream.of(prayer.calculate()),
					Stream.of(superRestoreStats)
						.filter(stat -> stat.getValue() < stat.getMaximum())
						.map(stat ->
						{
							calc.stat = stat;
							return calc.calculate();
						})
				).toArray(ItemStatChange.StatChange[]::new);
			out.positivity = Stream.of(out.statChanges).mapToInt(sc -> sc.positivity).max().getAsInt();
			return out;
		}
	}
}
