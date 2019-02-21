/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package net.runelite.client.plugins.maxhit.attackstyle;

import net.runelite.api.Skill;

public enum AttackStyle
{
	ACCURATE("Accurate", new Skill[]{Skill.ATTACK}, 0),
	AGGRESSIVE("Aggressive", new Skill[]{Skill.STRENGTH}, 3),
	DEFENSIVE("Defensive", new Skill[]{Skill.DEFENCE}, 0),
	CONTROLLED("Controlled", new Skill[]{Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE}, 1),
	RANGING("Ranging", new Skill[]{Skill.RANGED}, 3),
	LONGRANGE("Longrange", new Skill[]{Skill.RANGED, Skill.DEFENCE}, 0),
	CASTING("Casting", new Skill[]{Skill.MAGIC}, 0),
	DEFENSIVE_CASTING("Defensive Casting", new Skill[]{Skill.MAGIC, Skill.DEFENCE}, 0),
	OTHER("Other", new Skill[]{}, 0);

	private final String name;
	private final Skill[] skills;
	private int maxHitBonus;

	AttackStyle(String name, Skill[] skills, int maxHitBonus)
	{
		this.name = name;
		this.skills = skills;
		this.maxHitBonus = maxHitBonus;
	}

	public String getName()
	{
		return this.name;
	}

	public Skill[] getSkills()
	{
		return this.skills;
	}

	public double getMaxHitBonus() {
		return this.maxHitBonus;
	}
}
