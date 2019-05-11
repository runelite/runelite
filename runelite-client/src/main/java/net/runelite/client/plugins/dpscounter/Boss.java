/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.dpscounter;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;
import net.runelite.api.NpcID;

@Getter
@ToString
enum Boss
{
	ABYSSAL_SIRE(1.25f, NpcID.ABYSSAL_SIRE, NpcID.ABYSSAL_SIRE_5887, NpcID.ABYSSAL_SIRE_5888, NpcID.ABYSSAL_SIRE_5889, NpcID.ABYSSAL_SIRE_5890, NpcID.ABYSSAL_SIRE_5891, NpcID.ABYSSAL_SIRE_5908),
	CALLISTO(1.225f, NpcID.CALLISTO, NpcID.CALLISTO_6609),
	CERBERUS(1.15f, NpcID.CERBERUS, NpcID.CERBERUS_5863, NpcID.CERBERUS_5866),
	CHAOS_ELEMENTAL(1.075f, NpcID.CHAOS_ELEMENTAL, NpcID.CHAOS_ELEMENTAL_6505),
	CORPOREAL_BEAST(1.55f, NpcID.CORPOREAL_BEAST),
	GENERAL_GRAARDOR(1.325f, NpcID.GENERAL_GRAARDOR, NpcID.GENERAL_GRAARDOR_6494),
	GIANT_MOLE(1.075f, NpcID.GIANT_MOLE, NpcID.GIANT_MOLE_6499),
	KALPHITE_QUEEN(1.05f, NpcID.KALPHITE_QUEEN, NpcID.KALPHITE_QUEEN_963, NpcID.KALPHITE_QUEEN_965, NpcID.KALPHITE_QUEEN_4303, NpcID.KALPHITE_QUEEN_4304, NpcID.KALPHITE_QUEEN_6500, NpcID.KALPHITE_QUEEN_6501),
	KING_BLACK_DRAGON(1.075f, NpcID.KING_BLACK_DRAGON, NpcID.KING_BLACK_DRAGON_2642, NpcID.KING_BLACK_DRAGON_6502),
	KRIL_TSUROTH(1.375f, NpcID.KRIL_TSUTSAROTH, NpcID.KRIL_TSUTSAROTH_6495),
	VENETENATIS(1.4f, NpcID.VENENATIS, NpcID.VENENATIS_6610),
	VETION(1.225f, NpcID.VETION, NpcID.VETION_REBORN);

	private final int[] ids;
	private final float modifier; // Some NPCs have a modifier to the experience a player receives.

	Boss(float modifier, int... ids)
	{
		this.modifier = modifier;
		this.ids = ids;
	}

	private static final Map<Integer, Boss> BOSS_MAP;

	static Boss findBoss(int id)
	{
		return BOSS_MAP.get(id);
	}

	static
	{
		ImmutableMap.Builder<Integer, Boss> builder = ImmutableMap.builder();
		for (Boss boss : values())
		{
			for (int id : boss.ids)
			{
				builder.put(id, boss);
			}
		}
		BOSS_MAP = builder.build();
	}
}