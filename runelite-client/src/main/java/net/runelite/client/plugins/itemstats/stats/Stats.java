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

import net.runelite.api.Skill;

public class Stats
{
	public static final Stat ATTACK = new SkillStat(Skill.ATTACK);
	public static final Stat DEFENCE = new SkillStat(Skill.DEFENCE);
	public static final Stat STRENGTH = new SkillStat(Skill.STRENGTH);
	public static final Stat HITPOINTS = new SkillStat(Skill.HITPOINTS);
	public static final Stat RANGED = new SkillStat(Skill.RANGED);
	public static final Stat PRAYER = new SkillStat(Skill.PRAYER);
	public static final Stat MAGIC = new SkillStat(Skill.MAGIC);
	public static final Stat COOKING = new SkillStat(Skill.COOKING);
	public static final Stat WOODCUTTING = new SkillStat(Skill.WOODCUTTING);
	public static final Stat FLETCHING = new SkillStat(Skill.FLETCHING);
	public static final Stat FISHING = new SkillStat(Skill.FISHING);
	public static final Stat FIREMAKING = new SkillStat(Skill.FIREMAKING);
	public static final Stat CRAFTING = new SkillStat(Skill.CRAFTING);
	public static final Stat SMITHING = new SkillStat(Skill.SMITHING);
	public static final Stat MINING = new SkillStat(Skill.MINING);
	public static final Stat HERBLORE = new SkillStat(Skill.HERBLORE);
	public static final Stat AGILITY = new SkillStat(Skill.AGILITY);
	public static final Stat THIEVING = new SkillStat(Skill.THIEVING);
	public static final Stat SLAYER = new SkillStat(Skill.SLAYER);
	public static final Stat FARMING = new SkillStat(Skill.FARMING);
	public static final Stat RUNECRAFT = new SkillStat(Skill.RUNECRAFT);
	public static final Stat HUNTER = new SkillStat(Skill.HUNTER);
	public static final Stat CONSTRUCTION = new SkillStat(Skill.CONSTRUCTION);
	public static final Stat RUN_ENERGY = new EnergyStat();
}
