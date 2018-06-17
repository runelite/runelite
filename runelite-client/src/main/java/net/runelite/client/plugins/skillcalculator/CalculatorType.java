/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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
package net.runelite.client.plugins.skillcalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
enum CalculatorType
{
	AGILITY(Skill.AGILITY, "skill_agility.json", false),
	CONSTRUCTION(Skill.CONSTRUCTION, "skill_construction.json", true),
	COOKING(Skill.COOKING, "skill_cooking.json", true),
	CRAFTING(Skill.CRAFTING, "skill_crafting.json", true),
	FARMING(Skill.FARMING, "skill_farming.json", false),
	FIREMAKING(Skill.FIREMAKING, "skill_firemaking.json", false),
	FLETCHING(Skill.FLETCHING, "skill_fletching.json", false),
	FISHING(Skill.FISHING, "skill_fishing.json", false),
	HERBLORE(Skill.HERBLORE, "skill_herblore.json", true),
	HUNTER(Skill.HUNTER, "skill_hunter.json", false),
	MAGIC(Skill.MAGIC, "skill_magic.json", false),
	MINING(Skill.MINING, "skill_mining.json", false),
	PRAYER(Skill.PRAYER, "skill_prayer.json", true),
	RUNECRAFT(Skill.RUNECRAFT, "skill_runecraft.json", false),
	SMITHING(Skill.SMITHING, "skill_smithing.json", true),
	THIEVING(Skill.THIEVING, "skill_thieving.json", false),
	WOODCUTTING(Skill.WOODCUTTING, "skill_woodcutting.json", false);

	private final Skill skill;
	private final String dataFile;
	private final boolean bankedXpFlag;

	public static CalculatorType getBySkill(Skill skill)
	{
		return bySkill.get(skill);
	}

	private final static Map<Skill, CalculatorType> bySkill = buildSkillMap();
	private static Map<Skill, CalculatorType> buildSkillMap()
	{
		Map<Skill, CalculatorType> map = new HashMap<>();
		for (CalculatorType c : values())
			map.put(c.getSkill(), c);

		return map;
	}
}