/*
 * Copyright (c) 2018, Marshall <https://github.com/marshdevs>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.achievementdiary.diaries;

import net.runelite.api.Skill;
import net.runelite.client.plugins.achievementdiary.GenericDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.Requirement;

public class WesternDiaryRequirement extends GenericDiaryRequirement
{
	public WesternDiaryRequirement()
	{
		// EASY
		add("Catch a Copper Longtail.",
			new Requirement(Skill.HUNTER, 9));
		add("Complete a novice game of Pest Control.",
			new Requirement("Combat", 40));
		add("Mine some Iron Ore near Piscatoris.",
			new Requirement(Skill.MINING, 15));
		add("Fletch an Oak shortbow from the Gnome Stronghold.",
			new Requirement(Skill.FLETCHING, 20));

		// MEDIUM
		add("Take the agility shortcut from the Grand Tree to Otto's Grotto.",
			new Requirement(Skill.AGILITY, 37));
		add("Trap a Spined Larupia.",
			new Requirement(Skill.HUNTER, 31));
		add("Fish some Bass on Ape Atoll.",
			new Requirement(Skill.FISHING, 46));
		add("Chop and burn some teak logs on Ape Atoll.",
			new Requirement(Skill.WOODCUTTING, 35),
			new Requirement(Skill.FIREMAKING, 35));
		add("Complete an intermediate game of Pest Control.",
			new Requirement("Combat", 70));
		add("Make a Chocolate Bomb at the Grand Tree.",
			new Requirement(Skill.COOKING, 42));
		add("Complete a delivery for the Gnome Restaurant.",
			new Requirement(Skill.COOKING, 42));
		add("Mine some Gold ore underneath the Grand Tree.",
			new Requirement(Skill.MINING, 40));

		// HARD
		add("Kill an Elf with a Crystal bow.",
			new Requirement(Skill.RANGED, 70),
			new Requirement(Skill.AGILITY, 50));
		add("Catch and cook a Monkfish in Piscatoris.",
			new Requirement(Skill.FISHING, 62),
			new Requirement(Skill.COOKING, 62));
		add("Complete a Veteran game of Pest Control.",
			new Requirement("Combat", 100));
		add("Catch a Dashing Kebbit.",
			new Requirement(Skill.HUNTER, 69));
		add("Complete a lap of the Ape Atoll agility course.",
			new Requirement(Skill.AGILITY, 48));
		add("Chop and burn some Mahogany logs on Ape Atoll.",
			new Requirement(Skill.WOODCUTTING, 50),
			new Requirement(Skill.FIREMAKING, 50));
		add("Mine some Adamantite ore in Tirannwn.",
			new Requirement(Skill.MINING, 70));
		add("Check the health of your Palm tree in Lletya.",
			new Requirement(Skill.FARMING, 68));
		add("Build an Isafdar painting in your POH Quest hall.",
			new Requirement(Skill.CONSTRUCTION, 65));
		add("Teleport to Ape Atoll.",
			new Requirement(Skill.MAGIC, 64));
		add("Pickpocket a Gnome.",
			new Requirement(Skill.THIEVING, 75));

		// ELITE
		add("Fletch a Magic Longbow in the Elven lands.",
			new Requirement(Skill.FLETCHING, 85));
		add("Kill the Thermonuclear Smoke devil (Does not require task).",
			new Requirement(Skill.SLAYER, 93));
		add("Have Prissy Scilla protect your Magic tree.",
			new Requirement(Skill.FARMING, 75));
		add("Use the Elven overpass advanced cliffside shortcut.",
			new Requirement(Skill.AGILITY, 85));
		add("Pickpocket an Elf.",
			new Requirement(Skill.THIEVING, 85));
	}
}
