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

public class FremennikDiaryRequirement extends GenericDiaryRequirement
{
	public FremennikDiaryRequirement()
	{
		// EASY
		add("Catch a Cerulean twitch.",
			new SkillRequirement(Skill.HUNTER, 11));
		add("Change your boots at Yrsa's Shoe Store.",
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED));
		add("Craft a tiara from scratch in Rellekka.",
			new SkillRequirement(Skill.CRAFTING, 23),
			new SkillRequirement(Skill.MINING, 20),
			new SkillRequirement(Skill.SMITHING, 20),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED));
		add("Browse the Stonemasons shop.",
			new QuestStatusRequirement(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS));
		add("Steal from the Keldagrim crafting or baker's stall.",
			new SkillRequirement(Skill.THIEVING, 5),
			new QuestStatusRequirement(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS));
		add("Enter the Troll Stronghold.",
			new QuestStatusRequirement(Quest.DEATH_PLATEAU, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD, QuestState.IN_PROGRESS));
		add("Chop and burn some oak logs in the Fremennik Province.",
			new SkillRequirement(Skill.WOODCUTTING, 15),
			new SkillRequirement(Skill.FIREMAKING, 15));

		// MEDIUM
		add("Slay a Brine rat.",
			new SkillRequirement(Skill.SLAYER, 47),
			new QuestStatusRequirement(Quest.OLAFS_QUEST, QuestState.IN_PROGRESS));
		add("Travel to the Snowy Hunter Area via Eagle.",
			new QuestStatusRequirement(Quest.EAGLES_PEAK, QuestState.FINISHED));
		add("Mine some coal in Rellekka.",
			new SkillRequirement(Skill.MINING, 30),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED));
		add("Steal from the Rellekka Fish stalls.",
			new SkillRequirement(Skill.THIEVING, 42),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED));
		add("Travel to Miscellania by Fairy ring.",
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS));
		add("Catch a Snowy knight.",
			new SkillRequirement(Skill.HUNTER, 35));
		add("Pick up your Pet Rock from your POH Menagerie.",
			new SkillRequirement(Skill.CONSTRUCTION, 37),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED));
		add("Visit the Lighthouse from Waterbirth island.",
			new QuestStatusRequirement(Quest.HORROR_FROM_THE_DEEP, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.IN_PROGRESS));
		add("Mine some gold at the Arzinian mine.",
			new SkillRequirement(Skill.MINING, 40),
			new QuestStatusRequirement(Quest.BETWEEN_A_ROCK, QuestState.IN_PROGRESS));

		// HARD
		add("Teleport to Trollheim.",
			new SkillRequirement(Skill.MAGIC, 61),
			new QuestStatusRequirement(Quest.EADGARS_RUSE, QuestState.FINISHED));
		add("Catch a Sabre-toothed Kyatt.",
			new SkillRequirement(Skill.HUNTER, 55));
		add("Mix a super defence potion in the Fremennik province.",
			new SkillRequirement(Skill.HERBLORE, 66));
		add("Steal from the Keldagrim Gem Stall.",
			new SkillRequirement(Skill.THIEVING, 75),
			new QuestStatusRequirement(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS));
		add("Craft a Fremennik shield on Neitiznot.",
			new SkillRequirement(Skill.WOODCUTTING, 56),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_ISLES, QuestState.FINISHED));
		add("Mine 5 Adamantite ores on Jatizso.",
			new SkillRequirement(Skill.MINING, 70),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_ISLES, QuestState.FINISHED));
		add("Obtain 100% support from your kingdom subjects.",
			new QuestStatusRequirement(Quest.THRONE_OF_MISCELLANIA, QuestState.FINISHED));
		add("Teleport to Waterbirth Island.",
			new SkillRequirement(Skill.MAGIC, 72),
			new QuestStatusRequirement(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED));
		add("Obtain the Blast Furnace Foreman's permission to use the Blast Furnace for free.",
			new SkillRequirement(Skill.SMITHING, 60),
			new QuestStatusRequirement(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS));

		// ELITE
		add("Craft 56 astral runes at once.",
			new SkillRequirement(Skill.RUNECRAFT, 82),
			new QuestStatusRequirement(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED));
		add("Create a dragonstone amulet in the Neitiznot furnace.",
			new SkillRequirement(Skill.CRAFTING, 80),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_ISLES, QuestState.IN_PROGRESS));
		add("Complete a lap of the Rellekka agility course.",
			new SkillRequirement(Skill.AGILITY, 80));
		add("Kill each of the Godwars generals.",
			new SkillRequirement(Skill.AGILITY, 70),
			new SkillRequirement(Skill.STRENGTH, 70),
			new SkillRequirement(Skill.HITPOINTS, 70),
			new SkillRequirement(Skill.RANGED, 70),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD, QuestState.FINISHED));
		add("Slay a Spiritual mage within the Godwars Dungeon.",
			new SkillRequirement(Skill.SLAYER, 83),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD, QuestState.FINISHED));
	}
}
