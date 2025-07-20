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
package net.runelite.client.plugins.implings;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.gameval.NpcID;

@AllArgsConstructor
@Getter
enum Impling
{
	BABY(ImplingType.BABY, NpcID.II_IMPLING_TYPE_1),
	BABY_2(ImplingType.BABY, NpcID.II_IMPLING_TYPE_1_MAZE),

	YOUNG(ImplingType.YOUNG, NpcID.II_IMPLING_TYPE_2),
	YOUNG_2(ImplingType.YOUNG, NpcID.II_IMPLING_TYPE_2_MAZE),

	GOURMET(ImplingType.GOURMET, NpcID.II_IMPLING_TYPE_3),
	GOURMET_2(ImplingType.GOURMET, NpcID.II_IMPLING_TYPE_3_MAZE),

	EARTH(ImplingType.EARTH, NpcID.II_IMPLING_TYPE_4),
	EARTH_2(ImplingType.EARTH, NpcID.II_IMPLING_TYPE_4_MAZE),

	ESSENCE(ImplingType.ESSENCE, NpcID.II_IMPLING_TYPE_5),
	ESSENCE_2(ImplingType.ESSENCE, NpcID.II_IMPLING_TYPE_5_MAZE),

	ECLECTIC(ImplingType.ECLECTIC, NpcID.II_IMPLING_TYPE_6),
	ECLECTIC_2(ImplingType.ECLECTIC, NpcID.II_IMPLING_TYPE_6_MAZE),

	NATURE(ImplingType.NATURE, NpcID.II_IMPLING_TYPE_7),
	NATURE_2(ImplingType.NATURE, NpcID.II_IMPLING_TYPE_7_MAZE),

	MAGPIE(ImplingType.MAGPIE, NpcID.II_IMPLING_TYPE_8),
	MAGPIE_2(ImplingType.MAGPIE, NpcID.II_IMPLING_TYPE_8_MAZE),

	NINJA(ImplingType.NINJA, NpcID.II_IMPLING_TYPE_9),
	NINJA_2(ImplingType.NINJA, NpcID.II_IMPLING_TYPE_9_MAZE),

	CRYSTAL(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_JOHNNY),
	CRYSTAL_2(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_JUNIOR),
	CRYSTAL_3(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_ANDY),
	CRYSTAL_4(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_JOEY),
	CRYSTAL_5(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_TROUBLE),
	CRYSTAL_6(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_HINGY),
	CRYSTAL_7(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_ZOLTY),
	CRYSTAL_8(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_NEIL),
	CRYSTAL_9(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_YANNY),
	CRYSTAL_10(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_MATTY),
	CRYSTAL_11(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_STACE),
	CRYSTAL_12(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_IAN),
	CRYSTAL_13(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_JAMIE),
	CRYSTAL_14(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_DAMO),
	CRYSTAL_15(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_XANDER),
	CRYSTAL_16(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_STEVEO),
	CRYSTAL_17(ImplingType.CRYSTAL, NpcID.II_IMPLING_TYPE_12_STEWIE),

	DRAGON(ImplingType.DRAGON, NpcID.II_IMPLING_TYPE_10),
	DRAGON_2(ImplingType.DRAGON, NpcID.II_IMPLING_TYPE_10_MAZE),

	LUCKY(ImplingType.LUCKY, NpcID.II_IMPLING_TYPE_11),
	LUCKY_2(ImplingType.LUCKY, NpcID.II_IMPLING_TYPE_11_MAZE);

	private ImplingType implingType;
	private final int npcId;

	private static final Map<Integer, Impling> IMPLINGS;

	static
	{
		ImmutableMap.Builder<Integer, Impling> builder = new ImmutableMap.Builder<>();

		for (Impling impling : values())
		{
			builder.put(impling.npcId, impling);
		}

		IMPLINGS = builder.build();
	}

	static Impling findImpling(int npcId)
	{
		return IMPLINGS.get(npcId);
	}
}
