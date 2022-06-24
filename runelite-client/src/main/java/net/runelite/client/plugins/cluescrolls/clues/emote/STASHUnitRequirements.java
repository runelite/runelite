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
package net.runelite.client.plugins.cluescrolls.clues.emote;

import lombok.Getter;
import static net.runelite.api.ItemID.*;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.any;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.item;
import net.runelite.client.plugins.cluescrolls.clues.item.MultipleOfItemRequirement;


@Getter
public enum STASHUnitRequirements
{
	BEGINNER_STASH(new MultipleOfItemRequirement(PLANK, 2), 12),
	EASY_STASH(new MultipleOfItemRequirement(PLANK, 2), 27),
	MEDIUM_STASH(new MultipleOfItemRequirement(OAK_PLANK, 2), 42),
	HARD_STASH(new MultipleOfItemRequirement(TEAK_PLANK, 2), 55),
	ELITE_STASH(new MultipleOfItemRequirement(MAHOGANY_PLANK, 2), 77),
	MASTERS_STASH(new MultipleOfItemRequirement(MAHOGANY_PLANK, 2), 88, new MultipleOfItemRequirement(GOLD_LEAF, 1)),
	;

	private final int requiredConLevel;
	private final AnyRequirementCollection saw = any("Saw", item(SAW), item(CRYSTAL_SAW));
	private final ItemRequirement hammer = item(HAMMER);
	private final MultipleOfItemRequirement planks;
	private final MultipleOfItemRequirement goldLeaf;
	private final AnyRequirementCollection nails = any("Nails x10",
		new MultipleOfItemRequirement(BRONZE_NAILS, 10),
		new MultipleOfItemRequirement(IRON_NAILS, 10),
		new MultipleOfItemRequirement(STEEL_NAILS, 10),
		new MultipleOfItemRequirement(BLACK_NAILS, 10),
		new MultipleOfItemRequirement(ADAMANTITE_NAILS, 10),
		new MultipleOfItemRequirement(RUNE_NAILS, 10));

	STASHUnitRequirements(MultipleOfItemRequirement planks, int requiredConLevel)
	{
		this.planks = planks;
		this.goldLeaf = null;
		this.requiredConLevel = requiredConLevel;
	}

	STASHUnitRequirements(MultipleOfItemRequirement planks, int requiredConLevel, MultipleOfItemRequirement goldLeaf)
	{
		this.planks = planks;
		this.requiredConLevel = requiredConLevel;
		this.goldLeaf = goldLeaf;
	}
}

