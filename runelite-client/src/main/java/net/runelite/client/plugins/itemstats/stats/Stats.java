/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemstats.stats;

import net.runelite.api.Client;
import net.runelite.api.Skill;

public class Stats
{
	public static final Stat ATTACK, DEFENCE, STRENGTH, HITPOINTS, RANGED, PRAYER, MAGIC, COOKING, WOODCUTTING, FLETCHING;
	public static final Stat FISHING, FIREMAKING, CRAFTING, SMITHING, MINING, HERBLORE, AGILITY, THIEVING, SLAYER, FARMING;
	public static final Stat RUNECRAFT, HUNTER, CONSTRUCTION, RUN_ENERGY;

	static
	{
		ATTACK = new SkillStat(Skill.ATTACK);
		DEFENCE = new SkillStat(Skill.DEFENCE);
		STRENGTH = new SkillStat(Skill.STRENGTH);
		HITPOINTS = new SkillStat(Skill.HITPOINTS);
		RANGED = new SkillStat(Skill.RANGED);
		PRAYER = new SkillStat(Skill.PRAYER);
		MAGIC = new SkillStat(Skill.MAGIC);
		COOKING = new SkillStat(Skill.COOKING);
		WOODCUTTING = new SkillStat(Skill.WOODCUTTING);
		FLETCHING = new SkillStat(Skill.FLETCHING);
		FISHING = new SkillStat(Skill.FISHING);
		FIREMAKING = new SkillStat(Skill.FIREMAKING);
		CRAFTING = new SkillStat(Skill.CRAFTING);
		SMITHING = new SkillStat(Skill.SMITHING);
		MINING = new SkillStat(Skill.MINING);
		HERBLORE = new SkillStat(Skill.HERBLORE);
		AGILITY = new SkillStat(Skill.AGILITY);
		THIEVING = new SkillStat(Skill.THIEVING);
		SLAYER = new SkillStat(Skill.SLAYER);
		FARMING = new SkillStat(Skill.FARMING);
		RUNECRAFT = new SkillStat(Skill.RUNECRAFT);
		HUNTER = new SkillStat(Skill.HUNTER);
		CONSTRUCTION = new SkillStat(Skill.CONSTRUCTION);
		RUN_ENERGY = new Stat("Run Energy")
		{
			@Override
			public int getValue(Client client)
			{
				return client.getEnergy();
			}

			@Override
			public int getMaximum(Client client)
			{
				return 100;
			}
		};
	}
}
