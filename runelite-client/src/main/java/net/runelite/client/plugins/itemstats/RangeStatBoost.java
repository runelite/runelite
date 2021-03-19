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

import net.runelite.api.Client;

public class RangeStatBoost extends SingleEffect
{
	private final StatBoost a;
	private final StatBoost b;

	RangeStatBoost(StatBoost a, StatBoost b)
	{
		assert a.getStat() == b.getStat();

		this.a = a;
		this.b = b;
	}

	@Override
	public StatChange effect(Client client)
	{
		final StatChange changeA = this.a.effect(client);
		final StatChange changeB = this.b.effect(client);

		final RangeStatChange r = new RangeStatChange();
		r.setMinAbsolute(Math.min(changeA.getAbsolute(), changeB.getAbsolute()));
		r.setAbsolute(Math.max(changeA.getAbsolute(), changeB.getAbsolute()));
		r.setMinRelative(Math.min(changeA.getRelative(), changeB.getRelative()));
		r.setRelative(Math.max(changeA.getRelative(), changeB.getRelative()));
		r.setMinTheoretical(Math.min(changeA.getTheoretical(), changeB.getTheoretical()));
		r.setTheoretical(Math.max(changeA.getTheoretical(), changeB.getTheoretical()));
		r.setStat(changeA.getStat());

		final int avg = (changeA.getPositivity().ordinal() + changeB.getPositivity().ordinal()) / 2;
		r.setPositivity(Positivity.values()[avg]);

		return r;
	}
}
