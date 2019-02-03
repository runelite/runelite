/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.performancetracker;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public enum PTRegion
{
	// PvM Bosses
	DKS(11588, 11589),
	GIANT_MOLE(6736, 6737, 6992, 6993),
	KQ(13972),
	VORKATH(9023),
	ZULRAH(9007),
	// Sporadic TODO: Add moss & hill giant boss region(s)
	SKOTIZO(6810),
	// GWD
	KREEARRA(11346),
	GENERAL_GRAARDOR(11347),
	COMMANDER_ZILYANA(11602),
	KRIL_TSUTSAROTH(11603),
	// Slayer
	GROTESQUE_GUARDIANS(6727),
	ABYSSAL_SIRE(11851, 11850, 12363, 12362),
	KRAKEN(9116),
	CERBERUS(4883, 5140, 5395),
	SMOKE_DEVIL(9363, 9619),
	// Theatre of Blood
	MAIDEN(12613, 12869),
	BLOAT(13125),
	NYLOCAS(13122),
	SOTETSEG(13123, 13379),
	XARPUS(12612),
	VERZIK(12611),
	TEST(12342, 12343);

	private final int[] regionIDs;

	public static final Map<Integer, PTRegion> map = new HashMap<>();
	static
	{
		for (PTRegion r : values())
		{
			for (int i : r.regionIDs)
			{
				map.put(i, r);
			}
		}
	}

	PTRegion(int... regionIDs)
	{
		this.regionIDs = regionIDs;
	}
}
