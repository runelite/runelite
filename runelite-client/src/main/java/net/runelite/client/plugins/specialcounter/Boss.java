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
import java.util.HashSet;
import lombok.Getter;
import lombok.ToString;
import net.runelite.api.NpcID;

@Getter
@ToString
enum Boss
{
	ABYSSAL_SIRE("Abyssal sire", 1.25d, null, NpcID.RESPIRATORY_SYSTEM),
	CALLISTO("Callisto", 1.225d),
	CERBERUS("Cerberus", 1.15d),
	CHAOS_ELEMENTAL("Chaos elemental", 1.075d),
	CORPOREAL_BEAST("Corporeal Beast", 1.55d, null, NpcID.DARK_ENERGY_CORE),
	GENERAL_GRAARDOR("General Graardor", 1.325d, null, NpcID.SERGEANT_STRONGSTACK, NpcID.SERGEANT_STEELWILL, NpcID.SERGEANT_GRIMSPIKE),
	GIANT_MOLE("Giant Mole", 1.075d),
	KALPHITE_QUEEN("Kalphite Queen", 1.05d),
	KING_BLACK_DRAGON("King Black Dragon", 1.075d),
	KRIL_TSUROTH("K'ril Tsutsaroth", 1.375d, null, NpcID.BALFRUG_KREEYATH, NpcID.TSTANON_KARLAK, NpcID.ZAKLN_GRITCH),
	VENETENATIS("Venenatis", 1.4d),
	VETION("Vet'ion", 1.225d, NpcID.VETION, NpcID.SKELETON_HELLHOUND_6613, NpcID.GREATER_SKELETON_HELLHOUND);

	private final String name;
	private final double modifier; // Some NPCs have a modifier to the experience a player receives.
	private final Integer npcId; // id of the NPC, if multiple forms
	private final HashSet<Integer> minions;

	Boss(String name, double modifier, Integer npcId, Integer... minions)
	{
		this.name = name;
		this.modifier = modifier;
		this.npcId = npcId;
		this.minions = minions != null ? Sets.newHashSet(minions) : Sets.newHashSet();
	}

	Boss(String name, double modifier, Integer npcId)
	{
		this(name, modifier, npcId, null);
	}

	Boss(String name, double modifier)
	{
		this(name, modifier, null, null);
	}

	public static Boss getBoss(String name)
	{
		for (Boss boss : values())
		{
			if (boss.getName().equals(name))
			{
				return boss;
			}
		}
		return null;
	}

	public static boolean isMinion(Integer npcId)
	{
		for (Boss boss : values())
		{
			if (!boss.getMinions().isEmpty() && boss.getMinions().contains(npcId))
			{
				return true;
			}
		}
		return false;
	}

}