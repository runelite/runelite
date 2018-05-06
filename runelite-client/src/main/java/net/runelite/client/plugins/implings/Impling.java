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

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.NpcID;

@AllArgsConstructor
@Getter
enum Impling
{
	BABY(ImplingType.BABY, NpcID.BABY_IMPLING),
	BABY_2(ImplingType.BABY, NpcID.BABY_IMPLING_1645),

	YOUNG(ImplingType.YOUNG, NpcID.YOUNG_IMPLING),
	YOUNG_2(ImplingType.YOUNG, NpcID.YOUNG_IMPLING_1646),

	GOURMET(ImplingType.GOURMET, NpcID.GOURMET_IMPLING),
	GOURMET_2(ImplingType.GOURMET, NpcID.GOURMET_IMPLING_1647),

	EARTH(ImplingType.EARTH, NpcID.EARTH_IMPLING),
	EARTH_2(ImplingType.EARTH, NpcID.EARTH_IMPLING_1648),

	ESSENCE(ImplingType.ESSENCE, NpcID.ESSENCE_IMPLING),
	ESSENCE_2(ImplingType.ESSENCE, NpcID.ESSENCE_IMPLING_1649),

	ECLECTIC(ImplingType.ECLECTIC, NpcID.ECLECTIC_IMPLING),
	ECLECTIC_2(ImplingType.ECLECTIC, NpcID.ECLECTIC_IMPLING_1650),

	NATURE(ImplingType.NATURE, NpcID.NATURE_IMPLING),
	NATURE_2(ImplingType.NATURE, NpcID.NATURE_IMPLING_1651),

	MAGPIE(ImplingType.MAGPIE, NpcID.MAGPIE_IMPLING),
	MAGPIE_2(ImplingType.MAGPIE, NpcID.MAGPIE_IMPLING_1652),

	NINJA(ImplingType.NINJA, NpcID.NINJA_IMPLING),
	NINJA_2(ImplingType.NINJA, NpcID.NINJA_IMPLING_1653),

	DRAGON(ImplingType.DRAGON, NpcID.DRAGON_IMPLING),
	DRAGON_2(ImplingType.DRAGON, NpcID.DRAGON_IMPLING_1654),

	LUCKY(ImplingType.LUCKY, NpcID.LUCKY_IMPLING),
	LUCKY_2(ImplingType.LUCKY, NpcID.LUCKY_IMPLING_7302);

	private ImplingType implingType;
	private final int npcId;

	private static final Map<Integer, Impling> IMPLINGS = new HashMap<>();

	static
	{
		for (Impling impling : values())
		{
			IMPLINGS.put(impling.npcId, impling);
		}
	}

	static Impling findImpling(int npcId)
	{
		return IMPLINGS.get(npcId);
	}
}
