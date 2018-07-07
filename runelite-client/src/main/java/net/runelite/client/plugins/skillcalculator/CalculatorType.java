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

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

@AllArgsConstructor
@Getter
enum CalculatorType
{
	MINING(Skill.MINING, "It's coming home"),
	AGILITY(Skill.AGILITY, "It's coming home"),
	SMITHING(Skill.SMITHING, "It's coming home"),
	HERBLORE(Skill.HERBLORE, "It's coming home"),
	FISHING(Skill.FISHING, "It's coming home"),
	THIEVING(Skill.THIEVING, "It's coming home"),
	COOKING(Skill.COOKING, "It's coming home"),
	PRAYER(Skill.PRAYER, "It's coming home"),
	CRAFTING(Skill.CRAFTING, "It's coming home"),
	FIREMAKING(Skill.FIREMAKING, "It's coming home"),
	MAGIC(Skill.MAGIC, "It's coming home"),
	FLETCHING(Skill.FLETCHING, "It's coming home"),
	WOODCUTTING(Skill.WOODCUTTING, "It's coming home"),
	RUNECRAFT(Skill.RUNECRAFT, "It's coming home"),
	FARMING(Skill.FARMING, "It's coming home"),
	CONSTRUCTION(Skill.CONSTRUCTION, "It's coming home"),
	HUNTER(Skill.HUNTER, "It's coming home");

	private final Skill skill;
	private final String dataFile;
}