/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
enum CalculatorType
{
	MINING(Skill.MINING, "skill_mining.json"),
	AGILITY(Skill.AGILITY, "skill_agility.json"),
	SMITHING(Skill.SMITHING, "skill_smithing.json"),
	HERBLORE(Skill.HERBLORE, "skill_herblore.json"),
	FISHING(Skill.FISHING, "skill_fishing.json"),
	THIEVING(Skill.THIEVING, "skill_thieving.json"),
	COOKING(Skill.COOKING, "skill_cooking.json"),
	PRAYER(Skill.PRAYER, "skill_prayer.json"),
	CRAFTING(Skill.CRAFTING, "skill_crafting.json"),
	FIREMAKING(Skill.FIREMAKING, "skill_firemaking.json"),
	MAGIC(Skill.MAGIC, "skill_magic.json"),
	FLETCHING(Skill.FLETCHING, "skill_fletching.json"),
	WOODCUTTING(Skill.WOODCUTTING, "skill_woodcutting.json"),
	RUNECRAFT(Skill.RUNECRAFT, "skill_runecraft.json"),
	FARMING(Skill.FARMING, "skill_farming.json"),
	CONSTRUCTION(Skill.CONSTRUCTION, "skill_construction.json"),
	HUNTER(Skill.HUNTER, "skill_hunter.json");

	private final Skill skill;
	private final String dataFile;
}