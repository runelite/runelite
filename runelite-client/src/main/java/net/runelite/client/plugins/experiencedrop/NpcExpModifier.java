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
package net.runelite.client.plugins.experiencedrop;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.NpcID;

/**
 * The Experience received from damaging an NPC is actually based on the NPCs stats.
 * For stronger NPCs this can cause you to gain more XP for the same damage dealt.
 */
@Getter
enum NpcExpModifier
{
	// TODO: Confirm all NPC ids, some are probably incorrect or just useless
	// Common
	DAGANNOTH_REX(255, 255, 255, 255, 255, 255, 255, 0, 0, NpcID.DAGANNOTH_REX),
	DAGANNOTH_PRIME(255, 255, 255, 255, 255, 255, 255, 0, 0, NpcID.DAGANNOTH_PRIME),
	DAGANNOTH_SUPREME(225, 255, 128, 255, 10, 10, 10, 0, 0, NpcID.DAGANNOTH_SUPREME),
	GIANT_MOLE(200, 200, 200, 200, 60, 80, 100, 0, 0, NpcID.GIANT_MOLE),
	KQ(300, 300, 300, 255, 50, 50, 10, 0, 0, NpcID.KALPHITE_QUEEN, NpcID.KALPHITE_QUEEN_963, NpcID.KALPHITE_QUEEN_965),
	KQ_2(300, 300, 300, 255, 100, 100, 100, 0, 0, NpcID.KALPHITE_QUEEN_4303, NpcID.KALPHITE_QUEEN_4304),
	// Other
	VORKATH(560, 308, 214, 750, 26, 108, 108, 16, 0, NpcID.VORKATH, NpcID.VORKATH_8058, NpcID.VORKATH_8059, NpcID.VORKATH_8060, NpcID.VORKATH_8061),
	// All Zulrah phase stats are the same for the values we care about
	ZULRAH(1, 1, 300, 500, 0, 0, 0, 0, 0, NpcID.ZULRAH, NpcID.ZULRAH_2043, NpcID.ZULRAH_2044),
	// Sporadic
	OBOR(90, 100, 60, 120, 35, 40, 45, 100, 68, NpcID.OBOR),
	BRYOPHYTA(130, 100, 100, 115, 0, 0, 0, 33, 31, NpcID.BRYOPHYTA),
	SKOTIZO(240, 250, 200, 450, 80, 80, 80, 160, 31, NpcID.SKOTIZO),
	// GWD
	KREEARRA(300, 200, 260, 255, 180, 180, 180, 136, 12, NpcID.KREEARRA),
	GENERAL_GRAARDOR(280, 350, 250, 255, 90, 90, 90, 120, 43, NpcID.GENERAL_GRAARDOR),
	COMMANDER_ZILYANA(280, 196, 300, 255, 100, 100, 100, 195, 20, NpcID.COMMANDER_ZILYANA),
	KRIL_TSUTSAROTH(340, 300, 270, 255, 80, 80, 80, 160, 31, NpcID.KRIL_TSUTSAROTH),
	// Slayer
	DUSK(200, 1400, 100, 450, 0, 0, 0, 0, 0, NpcID.DUSK, NpcID.DUSK_7851, NpcID.DUSK_7854, NpcID.DUSK_7855,
		NpcID.DUSK_7882, NpcID.DUSK_7883, NpcID.DUSK_7886, NpcID.DUSK_7887, NpcID.DUSK_7888, NpcID.DUSK_7889),
	DAWN(140, 140, 100, 450, 0, 0, 0, 0, 0, NpcID.DAWN, NpcID.DAWN_7852, NpcID.DAWN_7853, NpcID.DAWN_7884, NpcID.DAWN_7885),
	ABYSSAL_SIRE(180, 136, 250, 350, 40, 60, 50, 65, 0, NpcID.ABYSSAL_SIRE, NpcID.ABYSSAL_SIRE_5908,
		NpcID.ABYSSAL_SIRE_5887, NpcID.ABYSSAL_SIRE_5888, NpcID.ABYSSAL_SIRE_5889, NpcID.ABYSSAL_SIRE_5890, NpcID.ABYSSAL_SIRE_5891),
	KRAKEN(1, 1, 1, 255, 0, 0, 0, 0, 0, NpcID.KRAKEN, NpcID.KRAKEN_6640, NpcID.KRAKEN_6656),
	CERBERUS(220, 220, 100, 600, 50, 100, 25, 50, 0, NpcID.CERBERUS, NpcID.CERBERUS_5863, NpcID.CERBERUS_5866),
	SMOKE_DEVIL(240, 220, 360, 240, 11, 4, 9, 0, 0, NpcID.THERMONUCLEAR_SMOKE_DEVIL),
	// Theatre of Blood
	MAIDEN(350, 350, 200, 3500, 0, 0, 0, 0, 0,
		NpcID.THE_MAIDEN_OF_SUGADINTI, NpcID.THE_MAIDEN_OF_SUGADINTI_8361, NpcID.THE_MAIDEN_OF_SUGADINTI_8362,
		NpcID.THE_MAIDEN_OF_SUGADINTI_8363, NpcID.THE_MAIDEN_OF_SUGADINTI_8364, NpcID.THE_MAIDEN_OF_SUGADINTI_8365),
	BLOAT(250, 340, 100, 2000, 40, 20, 40, 82, 150, NpcID.PESTILENT_BLOAT),
	NYLOCAS(400, 350, 50, 2500, 0, 0, 0, 60, 0,
		NpcID.NYLOCAS_VASILIAS, NpcID.NYLOCAS_VASILIAS_8355, NpcID.NYLOCAS_VASILIAS_8356, NpcID.NYLOCAS_VASILIAS_8357),
	SOTETSEG(250, 250, 200, 4000, 70, 70, 70, 49, 0, NpcID.SOTETSEG, NpcID.SOTETSEG_8388),
	XARPUS(1, 1, 250, 5080, 0, 0, 0, 0, 0, NpcID.XARPUS, NpcID.XARPUS_8339, NpcID.XARPUS_8340, NpcID.XARPUS_8341),
	VERZIK(400, 400, 20, 2000, 20, 20, 20, 0, 0, NpcID.VERZIK_VITUR_8370),
	VERZIK_2(400, 400, 200, 3250, 100, 60, 100, 0, 0, NpcID.VERZIK_VITUR_8372),
	VERZIK_3(400, 400, 150, 3250, 70, 30, 70, 30, 80, NpcID.VERZIK_VITUR_8374);

	private final int attack;
	private final int strength;
	private final int defence;
	private final int hp;
	private final int stab;
	private final int slash;
	private final int crush;
	private final int bonusStrength;
	private final int bonusAttack;
	private final int[] npcIDs;

	private final static Map<Integer, Double> XP_MODIFIER_MAP = new HashMap<>();

	static
	{
		for (net.runelite.client.plugins.experiencedrop.NpcExpModifier m : values())
		{
			final double bonus = m.calculateXpModifier();
			for (int id : m.getNpcIDs())
			{
				XP_MODIFIER_MAP.put(id, bonus);
			}
		}
	}

	NpcExpModifier(int attack, int strength, int defence, int hp, int stab, int slash, int crush, int bonusStrength, int bonusAttack, int... npcIDs)
	{
		this.attack = attack;
		this.strength = strength;
		this.defence = defence;
		this.hp = hp;
		this.stab = stab;
		this.slash = slash;
		this.crush = crush;
		this.bonusStrength = bonusStrength;
		this.bonusAttack = bonusAttack;
		this.npcIDs = npcIDs;
	}

	/**
	 * Based off the formula found here: http://services.runescape.com/m=forum/c=PLuJ4cy6gtA/forums.ws?317,318,712,65587452,209,337584542#209
	 * @return bonus XP modifier
	 */
	private double calculateXpModifier()
	{
		final double averageLevel = Math.floor((attack + strength + defence + hp) / 4);
		final double averageDefBonus = Math.floor((stab + slash + crush) / 3);

		return (1 + Math.floor(averageLevel * (averageDefBonus + bonusStrength + bonusAttack) / 5120) / 40);
	}

	public static double getByNpcId(final int npcID)
	{
		return XP_MODIFIER_MAP.getOrDefault(npcID, 1.0);
	}
}