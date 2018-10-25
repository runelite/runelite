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
package net.runelite.client.plugins.theatreofblood.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NpcHps
{
	// Other ToB NPCS
	BLOOD_SPAWN("Blood spawn", 120),				// Maiden
	NYLOCAS_MATOMENOS("Nylocas matomenos", 200),	// Healers
	NYLOCAS_HAGIOS("Nylocas hagios", 11),			// Mage (Big & Small)
	NYLOCAS_ISCHYROS("Nylocas ischyros", 11),		// Melee (Big & Small)
	NYLOCAS_TOXOBOLOS("Nylocas toxobolos", 11),		// Range (Big & Small)
	NYLOCAS_ATHANATOS("Nylocas Athanatos", 180),	// Purple
	// Bosses
	MAIDEN("Maiden of sugadiniti", 3500),
	BLOAT("Pestilent bloat", 2000),
	NYLOCAS("Nylocas Vasilias", 2500),
	SOTETSEG("Sotetseg", 4000),
	XARPUS("Xarpus", 5080),
	VERZIK("Verzik", 2000),
	VERZIK_2("Verzik 2", 3250),
	VERZIK_3("Verzik 3", 3250);

	private final String name;
	private final int maxHP;

	/**
	 * Returns the maximum hp for the NPC name if it exists inside ToB
	 * @param npcName npcName
	 * @return maximum hp
	 */
	public static int getMaxHpByNpcName(String npcName)
	{
		for (NpcHps n : values())
		{
			if (n.getName().toLowerCase().equals(npcName.toLowerCase()))
			{
				return n.getMaxHP();
			}
		}

		return -1;
	}
}
