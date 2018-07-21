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
package net.runelite.client.game.loot;

import lombok.Getter;
import net.runelite.api.NpcID;
import java.util.HashMap;
import java.util.Map;

public enum NpcHpDeath
{
	// Slayer Creatures
	ROCK_SLUGS(4, 40, NpcID.ROCKSLUG, NpcID.ROCKSLUG_422),
	// Desert Lizards have diff health based on Combat Level (also have different names)
	DESERT_LIZARDS_12(4, 15, NpcID.SMALL_LIZARD, NpcID.SMALL_LIZARD_463),
	DESERT_LIZARDS_24(4, 25, NpcID.DESERT_LIZARD, NpcID.DESERT_LIZARD_460, NpcID.DESERT_LIZARD_461),
	DESERT_LIZARDS_42(4, 40, NpcID.LIZARD),
	ZYGOMITES(7, 65, NpcID.ZYGOMITE, NpcID.ZYGOMITE_474),
	ANCIENT_ZYOGMITES(7, 150, NpcID.ANCIENT_ZYGOMITE),
	GARGOYLES(9, 150, NpcID.GARGOYLE, NpcID.GARGOYLE_413, NpcID.GARGOYLE_1543),

	// Superior Creatures (Not 100% sure on these death hp values)
	GIANT_ROCKSLUG(4, 77, NpcID.GIANT_ROCKSLUG),
	MARBLE_GARGOYLE(9, 270, NpcID.MARBLE_GARGOYLE, NpcID.MARBLE_GARGOYLE_7408);

	@Getter
	private final double deathHp;
	@Getter
	private final double startHp;
	@Getter
	private final int[] ids;

	NpcHpDeath(int deathHp, int startHp, int... ids)
	{
		this.deathHp = deathHp;
		this.startHp = startHp;
		this.ids = ids;
	}

	public static double npcDeathHealthPercent(int id)
	{
		Double r = npcMap.get(id);
		if (r == null)
		{
			r = 0.00;
		}
		return r;
	}

	private static Map<Integer, Double> npcMap = createNpcMap();

	private static Map<Integer, Double> createNpcMap()
	{
		Map<Integer, Double> m = new HashMap<>();
		for (NpcHpDeath n : values())
		{
			double hpPercent = n.getDeathHp() / n.getStartHp();
			for (Integer i : n.getIds())
			{
				m.put(i, hpPercent);
			}
		}
		return m;
	}
}