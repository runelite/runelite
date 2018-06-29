/*
 * Copyright (c) 2016-2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.itemstats.food;

import net.runelite.api.Client;
import net.runelite.client.plugins.itemstats.FoodBase;
import net.runelite.client.plugins.itemstats.StatChange;

public class VariableHealingFood extends FoodBase
{
	private final int minHeal;
	private final int maxHeal;

	public VariableHealingFood(final int minHeal, final int maxHeal)
	{
		super();
		this.minHeal = minHeal;
		this.maxHeal = maxHeal;
	}

	@Override
	public StatChange effect(Client client)
	{
		StatChange minEffect = super.effect(client);

		int value = getStat().getValue(client);
		int max = getStat().getMaximum(client);
		if (value > max)
		{
			max = value;
		}

		int calcedDelta = maxHeal;
		int newValue = value + calcedDelta;
		if (newValue > max)
		{
			newValue = max;
		}
		if (newValue < 0)
		{
			newValue = 0;
		}

		if (Integer.parseInt(minEffect.getAbsolute()) == newValue)
		{
			return minEffect;
		}

		int delta = newValue - value;
		StatChange out = new StatChange();
		out.setStat(getStat());
		out.setPositivity(minEffect.getPositivity());
		out.setAbsolute(minEffect.getAbsolute() + "~" + Integer.toString(newValue));
		out.setRelative(minEffect.getRelative() + "~" +  String.format("%+d", delta));
		out.setTheoretical(minEffect.getTheoretical() + "~" + String.format("%+d", calcedDelta));
		return out;
	}

	@Override
	public int heals(Client client)
	{
		return minHeal;
	}
}
