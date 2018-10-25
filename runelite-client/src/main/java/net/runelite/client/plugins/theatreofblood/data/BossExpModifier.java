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
import net.runelite.api.NpcID;

@AllArgsConstructor
@Getter
public enum BossExpModifier
{
	MAIDEN("The Maiden of Sugadinti", 350, 350, 200, 3500, 0, 0, 0, 0, 0),
	BLOAT("Pestilent bloat", 250, 340, 100, 2000, 40, 20, 40, 82, 150),
	NYLOCAS("Nylocas Vasilias", 400, 350, 50, 2500, 0, 0, 0, 60, 0),
	SOTETSEG("Sotetseg", 250, 250, 200, 4000, 70, 70, 70, 49, 0),
	XARPUS("Xarpus", 1, 1, 250, 5080, 0, 0, 0, 0, 0),
	VERZIK("Verzik", 400, 400, 20, 2000, 20, 20, 20, 0, 0),
	VERZIK_2("Verzik 2", 400, 400, 200, 3250, 100, 60, 100, 0, 0),
	VERZIK_3("Verzik 3", 400, 400, 150, 3250, 70, 30, 70, 30, 80);

	private String name;
	private int attack;
	private int strength;
	private int defence;
	private int hp;
	private int stab;
	private int slash;
	private int crush;
	private int bonusStrength;
	private int bonusAttack;


	public static double calculateBonus(BossExpModifier m)
	{
		double averageLevel = Math.floor((m.attack + m.strength + m.defence + m.hp) / 4);
		double averageDefBonus = Math.floor((m.stab + m.slash + m.crush) / 3);

		return (1 + Math.floor(averageLevel * (averageDefBonus + m.bonusStrength + m.bonusAttack) / 5120) / 40);
	}

	public static BossExpModifier getByName(String name)
	{
		for (BossExpModifier m : values())
		{
			if (m.name().toLowerCase().equals(name.toLowerCase()))
			{
				return m;
			}
		}

		return null;
	}

	public static String getBossNameByNpcId(int id)
	{
		switch (id)
		{
			case NpcID.VERZIK_VITUR:      // Unknown, maybe quest NPC?
			case NpcID.VERZIK_VITUR_8369: // Unknown, maybe quest NPC?
			case NpcID.VERZIK_VITUR_8371: // Flying to middle (Transition)
			case NpcID.VERZIK_VITUR_8373: // Turning into Spider form (Transition)
			case NpcID.VERZIK_VITUR_8375: // Dying Verzik
				break;
			case NpcID.VERZIK_VITUR_8370: // Throne Verzik (Phase 1)
				return "Verzik";
			case NpcID.VERZIK_VITUR_8372: // Flying Verzik (Phase 2)
				return "Verzik 2";
			case NpcID.VERZIK_VITUR_8374: // Spider Verzik (Phase 3)
				return "Verzik 3";
		}

		return null;
	}
}
