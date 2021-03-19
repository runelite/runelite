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
package net.runelite.client.plugins.specialcounter;

import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Getter;
import lombok.ToString;
import net.runelite.api.NpcID;

@Getter
@ToString
enum Boss
{
	ABYSSAL_SIRE(NpcID.ABYSSAL_SIRE, NpcID.ABYSSAL_SIRE_5887, NpcID.ABYSSAL_SIRE_5888, NpcID.ABYSSAL_SIRE_5889, NpcID.ABYSSAL_SIRE_5890, NpcID.ABYSSAL_SIRE_5891, NpcID.ABYSSAL_SIRE_5908),
	CALLISTO(NpcID.CALLISTO, NpcID.CALLISTO_6609),
	CERBERUS(NpcID.CERBERUS, NpcID.CERBERUS_5863, NpcID.CERBERUS_5866),
	CHAOS_ELEMENTAL(NpcID.CHAOS_ELEMENTAL, NpcID.CHAOS_ELEMENTAL_6505),
	CORPOREAL_BEAST(NpcID.CORPOREAL_BEAST),
	GENERAL_GRAARDOR(NpcID.GENERAL_GRAARDOR, NpcID.GENERAL_GRAARDOR_6494),
	GIANT_MOLE(NpcID.GIANT_MOLE, NpcID.GIANT_MOLE_6499),
	KALPHITE_QUEEN(NpcID.KALPHITE_QUEEN, NpcID.KALPHITE_QUEEN_963, NpcID.KALPHITE_QUEEN_965, NpcID.KALPHITE_QUEEN_4303, NpcID.KALPHITE_QUEEN_4304, NpcID.KALPHITE_QUEEN_6500, NpcID.KALPHITE_QUEEN_6501),
	KING_BLACK_DRAGON(NpcID.KING_BLACK_DRAGON, NpcID.KING_BLACK_DRAGON_2642, NpcID.KING_BLACK_DRAGON_6502),
	KRIL_TSUROTH(NpcID.KRIL_TSUTSAROTH, NpcID.KRIL_TSUTSAROTH_6495),
	VENETENATIS(NpcID.VENENATIS, NpcID.VENENATIS_6610),
	VETION(NpcID.VETION, NpcID.VETION_REBORN);

	private final Set<Integer> ids;

	Boss(Integer... ids)
	{
		this.ids = Sets.newHashSet(ids);
	}

	static Boss getBoss(int id)
	{
		for (Boss boss : values())
		{
			if (boss.ids.contains(id))
			{
				return boss;
			}
		}

		return null;
	}

}