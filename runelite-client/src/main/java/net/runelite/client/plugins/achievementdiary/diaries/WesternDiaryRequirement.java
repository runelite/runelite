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

import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.client.plugins.achievementdiary.GenericDiaryRequirement;
import net.runelite.client.util.requirements.QuestStatusRequirement;
import net.runelite.client.util.requirements.SkillRequirement;
import net.runelite.client.util.requirements.CombatLevelRequirement;

public class WesternDiaryRequirement extends GenericDiaryRequirement
{
	public WesternDiaryRequirement()
	{
		// EASY
		add("Catch a Copper Longtail.",
			new SkillRequirement(Skill.HUNTER, 9));
		add("Complete a novice game of Pest Control.",
			new CombatLevelRequirement(40));
		add("Mine some Iron Ore near Piscatoris.",
			new SkillRequirement(Skill.MINING, 15));
		add("Claim any Chompy bird hat from Rantz.",
			new QuestStatusRequirement(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED));
		add("Have Brimstail teleport you to the Essence mine.",
			new QuestStatusRequirement(Quest.RUNE_MYSTERIES, QuestState.FINISHED));
		add("Fletch an Oak shortbow from the Gnome Stronghold.",
			new SkillRequirement(Skill.FLETCHING, 20));

		// MEDIUM
		add("Take the agility shortcut from the Grand Tree to Otto's Grotto.",
			new SkillRequirement(Skill.AGILITY, 37),
			new QuestStatusRequirement(Quest.TREE_GNOME_VILLAGE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_GRAND_TREE, QuestState.FINISHED));
		add("Travel to the Gnome Stronghold by Spirit Tree.",
			new QuestStatusRequirement(Quest.TREE_GNOME_VILLAGE, QuestState.FINISHED));
		add("Trap a Spined Larupia.",
			new SkillRequirement(Skill.HUNTER, 31));
		add("Fish some Bass on Ape Atoll.",
			new SkillRequirement(Skill.FISHING, 46),
			new QuestStatusRequirement(Quest.MONKEY_MADNESS_I, QuestState.IN_PROGRESS));
		add("Chop and burn some teak logs on Ape Atoll.",
			new SkillRequirement(Skill.WOODCUTTING, 35),
			new SkillRequirement(Skill.FIREMAKING, 35),
			new QuestStatusRequirement(Quest.MONKEY_MADNESS_I, QuestState.IN_PROGRESS));
		add("Complete an intermediate game of Pest Control.",
			new CombatLevelRequirement(70));
		add("Travel to the Feldip Hills by Gnome Glider.",
			new QuestStatusRequirement(Quest.ONE_SMALL_FAVOUR, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_GRAND_TREE, QuestState.FINISHED));
		add("Claim a Chompy bird hat from Rantz after registering at least 125 kills.",
			new QuestStatusRequirement(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED));
		add("Travel from Eagles' Peak to the Feldip Hills by Eagle.",
			new QuestStatusRequirement(Quest.EAGLES_PEAK, QuestState.FINISHED));
		add("Make a Chocolate Bomb at the Grand Tree.",
			new SkillRequirement(Skill.COOKING, 42));
		add("Complete a delivery for the Gnome Restaurant.",
			new SkillRequirement(Skill.COOKING, 29));
		add("Turn your small crystal seed into a Crystal saw.",
			new QuestStatusRequirement(Quest.THE_EYES_OF_GLOUPHRIE, QuestState.FINISHED));
		add("Mine some Gold ore underneath the Grand Tree.",
			new SkillRequirement(Skill.MINING, 40),
			new QuestStatusRequirement(Quest.THE_GRAND_TREE, QuestState.FINISHED));

		// HARD
		add("Kill an Elf with a Crystal bow.",
			new SkillRequirement(Skill.RANGED, 70),
			new SkillRequirement(Skill.AGILITY, 56),
			new QuestStatusRequirement(Quest.ROVING_ELVES, QuestState.FINISHED));
		add("Catch and cook a Monkfish in Piscatoris.",
			new SkillRequirement(Skill.FISHING, 62),
			new SkillRequirement(Skill.COOKING, 62),
			new QuestStatusRequirement(Quest.SWAN_SONG, QuestState.FINISHED));
		add("Complete a Veteran game of Pest Control.",
			new CombatLevelRequirement(100));
		add("Catch a Dashing Kebbit.",
			new SkillRequirement(Skill.HUNTER, 69));
		add("Complete a lap of the Ape Atoll agility course.",
			new SkillRequirement(Skill.AGILITY, 48),
			new QuestStatusRequirement(Quest.MONKEY_MADNESS_I, QuestState.FINISHED));
		add("Chop and burn some Mahogany logs on Ape Atoll.",
			new SkillRequirement(Skill.WOODCUTTING, 50),
			new SkillRequirement(Skill.FIREMAKING, 50),
			new QuestStatusRequirement(Quest.MONKEY_MADNESS_I, QuestState.FINISHED));
		add("Mine some Adamantite ore in Tirannwn.",
			new SkillRequirement(Skill.MINING, 70),
			new QuestStatusRequirement(Quest.REGICIDE, QuestState.FINISHED));
		add("Check the health of your Palm tree in Lletya.",
			new SkillRequirement(Skill.FARMING, 68),
			new QuestStatusRequirement(Quest.MOURNINGS_END_PART_I, QuestState.IN_PROGRESS));
		add("Claim a Chompy bird hat from Rantz after registering at least 300 kills.",
			new QuestStatusRequirement(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED));
		add("Build an Isafdar painting in your POH Quest hall.",
			new SkillRequirement(Skill.CONSTRUCTION, 65),
			new QuestStatusRequirement(Quest.ROVING_ELVES, QuestState.FINISHED));
		add("Kill Zulrah.",
			new QuestStatusRequirement(Quest.REGICIDE, QuestState.IN_PROGRESS));
		add("Teleport to Ape Atoll.",
			new SkillRequirement(Skill.MAGIC, 64),
			new QuestStatusRequirement(Quest.RECIPE_FOR_DISASTER, QuestState.IN_PROGRESS));
		add("Pickpocket a Gnome.",
			new SkillRequirement(Skill.THIEVING, 75),
			new QuestStatusRequirement(Quest.TREE_GNOME_VILLAGE, QuestState.FINISHED));

		// ELITE
		add("Fletch a Magic Longbow in Tirannwn.",
			new SkillRequirement(Skill.FLETCHING, 85),
			new QuestStatusRequirement(Quest.MOURNINGS_END_PART_I, QuestState.FINISHED));
		add("Kill the Thermonuclear Smoke devil (Does not require task).",
			new SkillRequirement(Skill.SLAYER, 93));
		add("Have Prissy Scilla protect your Magic tree.",
			new SkillRequirement(Skill.FARMING, 75));
		add("Use the Elven overpass advanced cliffside shortcut.",
			new SkillRequirement(Skill.AGILITY, 85),
			new QuestStatusRequirement(Quest.UNDERGROUND_PASS, QuestState.FINISHED));
		add("Claim a Chompy bird hat from Rantz after registering at least 1000 kills.",
			new QuestStatusRequirement(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED));
		add("Pickpocket an Elf.",
			new SkillRequirement(Skill.THIEVING, 85),
			new QuestStatusRequirement(Quest.MOURNINGS_END_PART_I, QuestState.IN_PROGRESS));
	}
}
