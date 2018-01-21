/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.itemstats;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Skill;

@Singleton
class Stats
{
	@Inject
	Stats(Client client)
	{
		ATTACK = new StatSkill(client, Skill.ATTACK);
		DEFENCE = new StatSkill(client, Skill.DEFENCE);
		STRENGTH = new StatSkill(client, Skill.STRENGTH);
		HITPOINTS = new StatSkill(client, Skill.HITPOINTS);
		RANGED = new StatSkill(client, Skill.RANGED);
		PRAYER = new StatSkill(client, Skill.PRAYER);
		MAGIC = new StatSkill(client, Skill.MAGIC);
		COOKING = new StatSkill(client, Skill.COOKING);
		WOODCUTTING = new StatSkill(client, Skill.WOODCUTTING);
		FLETCHING = new StatSkill(client, Skill.FLETCHING);
		FISHING = new StatSkill(client, Skill.FISHING);
		FIREMAKING = new StatSkill(client, Skill.FIREMAKING);
		CRAFTING = new StatSkill(client, Skill.CRAFTING);
		SMITHING = new StatSkill(client, Skill.SMITHING);
		MINING = new StatSkill(client, Skill.MINING);
		HERBLORE = new StatSkill(client, Skill.HERBLORE);
		AGILITY = new StatSkill(client, Skill.AGILITY);
		THIEVING = new StatSkill(client, Skill.THIEVING);
		SLAYER = new StatSkill(client, Skill.SLAYER);
		FARMING = new StatSkill(client, Skill.FARMING);
		RUNECRAFT = new StatSkill(client, Skill.RUNECRAFT);
		HUNTER = new StatSkill(client, Skill.HUNTER);
		CONSTRUCTION = new StatSkill(client, Skill.CONSTRUCTION);
		RUN_ENERGY = new Stat(client, "Run Energy")
		{
			public int getValue()
			{
				return client.getEnergy();
			}

			public int getMaximum()
			{
				return 100;
			}
		};

		values = new Stat[]{
			ATTACK, DEFENCE, STRENGTH, HITPOINTS, RANGED, PRAYER, MAGIC, COOKING, WOODCUTTING, FLETCHING,
			FISHING, FIREMAKING, CRAFTING, SMITHING, MINING, HERBLORE, AGILITY, THIEVING, SLAYER, FARMING,
			RUNECRAFT, HUNTER, CONSTRUCTION, RUN_ENERGY,
		};
	}

	public final Stat ATTACK, DEFENCE, STRENGTH, HITPOINTS, RANGED, PRAYER, MAGIC, COOKING, WOODCUTTING, FLETCHING;
	public final Stat FISHING, FIREMAKING, CRAFTING, SMITHING, MINING, HERBLORE, AGILITY, THIEVING, SLAYER, FARMING;
	public final Stat RUNECRAFT, HUNTER, CONSTRUCTION, RUN_ENERGY;

	public Stat[] values;

	private static class StatSkill extends Stat
	{
		private final Skill skill;

		StatSkill(Client client, Skill skill)
		{
			super(client, skill.getName());
			this.skill = skill;
		}

		public int getValue()
		{
			return client.getBoostedSkillLevel(this.skill);
		}

		public int getMaximum()
		{
			return client.getRealSkillLevel(this.skill);
		}
	}
}
