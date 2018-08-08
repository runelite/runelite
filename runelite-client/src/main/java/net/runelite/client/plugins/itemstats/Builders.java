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
package net.runelite.client.plugins.itemstats;

import net.runelite.client.plugins.itemstats.delta.DeltaCalculator;
import net.runelite.client.plugins.itemstats.delta.DeltaPercentage;
import net.runelite.client.plugins.itemstats.stats.Stat;

public class Builders
{
	public static Food food(int diff)
	{
		return food((max) -> diff);
	}

	public static Food food(DeltaCalculator p)
	{
		return new Food(p);
	}

	public static Effect combo(int primaries, SingleEffect... effect)
	{
		return new Combo(primaries, effect);
	}

	public static Effect combo(SingleEffect... effect)
	{
		return new Combo(effect);
	}

	public static SimpleStatBoost boost(Stat stat, int boost)
	{
		return boost(stat, (max) -> boost);
	}

	public static SimpleStatBoost boost(Stat stat, DeltaCalculator p)
	{
		return new SimpleStatBoost(stat, true, p);
	}

	public static SimpleStatBoost heal(Stat stat, int boost)
	{
		return heal(stat, (max) -> boost);
	}

	public static SimpleStatBoost heal(Stat stat, DeltaCalculator p)
	{
		return new SimpleStatBoost(stat, false, p);
	}

	public static SimpleStatBoost dec(Stat stat, int boost)
	{
		return heal(stat, -boost);
	}

	public static DeltaPercentage perc(double perc, int delta)
	{
		return new DeltaPercentage(perc, delta);
	}

	public static RangeStatBoost range(StatBoost a, StatBoost b)
	{
		return new RangeStatBoost(a, b);
	}
}
