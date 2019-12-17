/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.itemstats.*;
import net.runelite.client.plugins.itemstats.stats.Stat;
import net.runelite.client.plugins.itemstats.stats.Stats;

public class SpicyStew implements Effect
{

	@Override
	public StatsChanges calculate(Client client)
	{
		/*
		 * Spice boosts listed in the colour order of [Spicy stew -> Smell]
		 */
		int redBoost = spiceBoostOf(client.getVar(Varbits.SPICY_STEW_RED_SPICES));
		int yellowBoost = spiceBoostOf(client.getVar(Varbits.SPICY_STEW_YELLOW_SPICES));
		int orangeBoost = spiceBoostOf(client.getVar(Varbits.SPICY_STEW_ORANGE_SPICES));
		int brownBoost = spiceBoostOf(client.getVar(Varbits.SPICY_STEW_BROWN_SPICES));

		List<StatChange> changes = new ArrayList<>();

		/*
		 * Red spices: Attack, Strength, Defence, Ranged, Magic
		 */
		if (redBoost > 0)
		{
			changes.add(statChangeOf(Stats.ATTACK, redBoost, client));
			changes.add(statChangeOf(Stats.STRENGTH, redBoost, client));
			changes.add(statChangeOf(Stats.DEFENCE, redBoost, client));
			changes.add(statChangeOf(Stats.RANGED, redBoost, client));
			changes.add(statChangeOf(Stats.MAGIC, redBoost, client));
		}

		/*
		 * Yellow spices: Prayer, Agility, Thieving, Slayer, Hunter
		 */
		if (yellowBoost > 0)
		{
			changes.add(statChangeOf(Stats.PRAYER, yellowBoost, client));
			changes.add(statChangeOf(Stats.AGILITY, yellowBoost, client));
			changes.add(statChangeOf(Stats.THIEVING, yellowBoost, client));
			changes.add(statChangeOf(Stats.SLAYER, yellowBoost, client));
			changes.add(statChangeOf(Stats.HUNTER, yellowBoost, client));
		}

		/*
		 * Orange spices: Smithing, Cooking, Crafting, Firemaking, Fletching, Runecraft, Construction
		 */
		if (orangeBoost > 0)
		{
			changes.add(statChangeOf(Stats.SMITHING, orangeBoost, client));
			changes.add(statChangeOf(Stats.COOKING, orangeBoost, client));
			changes.add(statChangeOf(Stats.CRAFTING, orangeBoost, client));
			changes.add(statChangeOf(Stats.FIREMAKING, orangeBoost, client));
			changes.add(statChangeOf(Stats.FLETCHING, orangeBoost, client));
			changes.add(statChangeOf(Stats.RUNECRAFT, orangeBoost, client));
			changes.add(statChangeOf(Stats.CONSTRUCTION, orangeBoost, client));
		}

		/*
		 * Brown spices: Mining, Herblore, Fishing, Woodcutting, Farming
		 */
		if (brownBoost > 0)
		{
			changes.add(statChangeOf(Stats.MINING, brownBoost, client));
			changes.add(statChangeOf(Stats.HERBLORE, brownBoost, client));
			changes.add(statChangeOf(Stats.FISHING, brownBoost, client));
			changes.add(statChangeOf(Stats.WOODCUTTING, brownBoost, client));
			changes.add(statChangeOf(Stats.FARMING, brownBoost, client));
		}

		StatsChanges changesReturn = new StatsChanges(4);
		changesReturn.setStatChanges(changes.toArray(new StatChange[changes.size()]));

		return changesReturn;
	}

	/**
	 * Calculate the potential boost that a spice currently offers,
	 * based on its number of doses in the stew.
	 *
	 * @param spiceDoses Number of doses between 0 and 3.
	 * @return Either 0, +1, +3, or +5.
	 */
	private static int spiceBoostOf(int spiceDoses)
	{
		return Math.max(0, (spiceDoses * 2) - 1);
	}

	/**
	 * Calculate the fields of a stat change tooltip row.
	 *
	 * @param stat Stat that the spice boost affects.
	 * @param spiceBoost Potential spice boost before capping.
	 * @param client Client API, needed to check current stat values.
	 * @return StatChange object with all required values.
	 */
	private static StatChange statChangeOf(Stat stat, int spiceBoost, Client client)
	{
		int currentValue = stat.getValue(client);
		int currentBase = stat.getMaximum(client);

		int currentBoost = currentValue - currentBase; // Can be negative
		int spiceBoostCapped = (currentBoost <= 0) ? spiceBoost : Math.max(0, spiceBoost - currentBoost);

		final RangeStatChange change = new RangeStatChange();
		change.setStat(stat);
		change.setMinRelative(-spiceBoost);
		change.setRelative(spiceBoostCapped);
		change.setMinTheoretical(-spiceBoost);
		change.setTheoretical(spiceBoost);
		change.setMinAbsolute(Math.max(-spiceBoost, -currentValue));
		change.setAbsolute(stat.getValue(client) + spiceBoostCapped);

		Positivity positivity;
		if (spiceBoostCapped == 0)
		{
			positivity = Positivity.NO_CHANGE;
		}
		else if (spiceBoost > spiceBoostCapped)
		{
			positivity = Positivity.BETTER_CAPPED;
		}
		else
		{
			positivity = Positivity.BETTER_UNCAPPED;
		}
		change.setPositivity(positivity);

		return change;
	}
}
