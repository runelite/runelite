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
package net.runelite.client.game.attackstyles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

public enum AttackStyle
{
	ACCURATE("Accurate",
			new SkillAmount(Skill.ATTACK, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	AGGRESSIVE("Aggressive",
			new SkillAmount(Skill.STRENGTH, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	DEFENSIVE("Defensive",
			new SkillAmount(Skill.DEFENCE, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	CONTROLLED("Controlled",
			new SkillAmount(Skill.ATTACK, 4.0 / 3.0),
			new SkillAmount(Skill.STRENGTH, 4.0 / 3.0),
			new SkillAmount(Skill.DEFENCE, 4.0 / 3.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	RANGING("Ranging",
			new SkillAmount(Skill.RANGED, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	LONGRANGE("Longrange",
			new SkillAmount(Skill.RANGED, 2.0),
			new SkillAmount(Skill.DEFENCE, 2.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	CASTING("Casting",
			new SkillAmount(Skill.MAGIC, 4.0), // note that this is estimate
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	DEFENSIVE_CASTING("Defensive Casting",
			new SkillAmount(Skill.MAGIC, 3.0), // also an estimate
			new SkillAmount(Skill.DEFENCE, 1.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	OTHER("Other");

	@Getter
	@AllArgsConstructor
	public static class SkillAmount
	{

		private final Skill skill;
		private final double amount;

	}

	private final String name;
	private final SkillAmount[] skillAmounts;

	AttackStyle(String name, SkillAmount... skillAmounts)
	{
		this.name = name;
		this.skillAmounts = skillAmounts;
	}

	public String getName()
	{
		return name;
	}

	public SkillAmount[] getSkillAmounts()
	{
		return skillAmounts;
	}
}
