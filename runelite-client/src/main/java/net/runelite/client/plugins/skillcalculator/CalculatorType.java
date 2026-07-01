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

import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.client.plugins.skillcalculator.skills.*;

@AllArgsConstructor
@Getter
enum CalculatorType
{
	MINING(Skill.MINING, MiningBonus.values(), MiningAction.values()),
	AGILITY(Skill.AGILITY, AgilityBonus.values(), AgilityAction.values()),
	SMITHING(Skill.SMITHING, SmithingBonus.values(), SmithingAction.values()),
	HERBLORE(Skill.HERBLORE, null, HerbloreAction.values()),
	FISHING(Skill.FISHING, FishingBonus.values(), FishingAction.values()),
	THIEVING(Skill.THIEVING, null, ThievingAction.values()),
	COOKING(Skill.COOKING, null, CookingAction.values()),
	PRAYER(Skill.PRAYER, PrayerBonus.values(), PrayerAction.values()),
	CRAFTING(Skill.CRAFTING, null, CraftingAction.values()),
	FIREMAKING(Skill.FIREMAKING, FiremakingBonus.values(), FiremakingAction.values()),
	MAGIC(Skill.MAGIC, null, MagicAction.values()),
	FLETCHING(Skill.FLETCHING, null, FletchingAction.values()),
	WOODCUTTING(Skill.WOODCUTTING, WoodcuttingBonus.values(), WoodcuttingAction.values()),
	RUNECRAFT(Skill.RUNECRAFT, RunecraftBonus.values(), RunecraftAction.values()),
	FARMING(Skill.FARMING, FarmingBonus.values(), FarmingAction.values()),
	CONSTRUCTION(Skill.CONSTRUCTION, ConstructionBonus.values(), ConstructionAction.values()),
	HUNTER(Skill.HUNTER, null, HunterAction.values());

	private final Skill skill;
	@Nullable
	private final SkillBonus[] skillBonuses;
	private final SkillAction[] skillActions;
}
