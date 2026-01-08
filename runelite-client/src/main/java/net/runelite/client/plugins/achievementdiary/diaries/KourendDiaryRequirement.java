/*
 * Copyright (c) 2019 William <https://github.com/monsterxsync>
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
import net.runelite.api.Skill;
import net.runelite.client.plugins.achievementdiary.GenericDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.QuestRequirement;
import net.runelite.client.plugins.achievementdiary.SkillRequirement;

public class KourendDiaryRequirement extends GenericDiaryRequirement
{
	public KourendDiaryRequirement()
	{
		//EASY
		add("Mine some Iron at the Mount Karuulm mine.",
			new SkillRequirement(Skill.MINING, 15));
		add("Steal from a Hosidius Food Stall.",
			new SkillRequirement(Skill.THIEVING, 25));
		add("Enter your Player Owned House from Hosidius.",
			new SkillRequirement(Skill.CONSTRUCTION, 25));
		add("Create a Strength potion in the Lovakengj Pub.",
			new SkillRequirement(Skill.HERBLORE, 12));
		add("Fish a Trout from the River Molch.",
			new SkillRequirement(Skill.FISHING, 20));

		//MEDIUM
		add("Travel to the Fairy Ring south of Mount Karuulm.",
			new QuestRequirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true));
		add("Use Kharedst's memoirs to teleport to all five cities in Great Kourend.",
			new QuestRequirement(Quest.THE_DEPTHS_OF_DESPAIR),
			new QuestRequirement(Quest.THE_QUEEN_OF_THIEVES),
			new QuestRequirement(Quest.TALE_OF_THE_RIGHTEOUS),
			new QuestRequirement(Quest.THE_FORSAKEN_TOWER),
			new QuestRequirement(Quest.THE_ASCENT_OF_ARCEUUS));
		add("Mine some Volcanic sulphur.",
			new SkillRequirement(Skill.MINING, 42));
		add("Enter the Farming Guild.",
			new SkillRequirement(Skill.FARMING, 45));
		add("Repair a Piscarilius crane.",
			new SkillRequirement(Skill.CRAFTING, 30),
			new SkillRequirement(Skill.CONSTRUCTION, 30));
		add("Catch a Bluegill on Molch Island.",
			new SkillRequirement(Skill.FISHING, 43),
			new SkillRequirement(Skill.HUNTER, 35));
		add("Use the boulder leap in the Arceuus essence mine.",
			new SkillRequirement(Skill.AGILITY, 49));
		add("Subdue the Wintertodt.",
			new SkillRequirement(Skill.FIREMAKING, 50));
		add("Catch a Chinchompa in the Kourend Woodland.",
			new SkillRequirement(Skill.HUNTER, 53),
			new QuestRequirement(Quest.EAGLES_PEAK));
		add("Chop some Mahogany logs north of the Farming Guild.",
			new SkillRequirement(Skill.WOODCUTTING, 50));

		//HARD
		add("Enter the Woodcutting Guild.",
			new SkillRequirement(Skill.WOODCUTTING, 60));
		add("Smelt an Adamantite bar in The Forsaken Tower.",
			new SkillRequirement(Skill.SMITHING, 70),
			new QuestRequirement(Quest.THE_FORSAKEN_TOWER, true));
		add("Mine some Lovakite.",
			new SkillRequirement(Skill.MINING, 65));
		add("Plant some Logavano seeds at the Tithe Farm.",
			new SkillRequirement(Skill.FARMING, 74));
		add("Deliver an artefact to Captain Khaled.",
			new SkillRequirement(Skill.THIEVING, 49));
		add("Kill a Wyrm in the Karuulm Slayer Dungeon.",
			new SkillRequirement(Skill.SLAYER, 62));
		add("Cast Monster Examine on a Troll south of Mount Quidamortem.",
			new SkillRequirement(Skill.MAGIC, 66),
			new QuestRequirement(Quest.DREAM_MENTOR));

		//ELITE
		add("Craft one or more Blood runes from Dark essence fragments.",
			new SkillRequirement(Skill.RUNECRAFT, 77),
			new SkillRequirement(Skill.MINING, 38),
			new SkillRequirement(Skill.CRAFTING, 38));
		add("Chop some Redwood logs.",
			new SkillRequirement(Skill.WOODCUTTING, 90));
		add("Catch an Anglerfish and cook it whilst in Great Kourend.",
			new SkillRequirement(Skill.FISHING, 82),
			new SkillRequirement(Skill.COOKING, 84));
		add("Kill a Hydra in the Karuulm Slayer Dungeon.",
			new SkillRequirement(Skill.SLAYER, 95));
		add("Create an Ape Atoll teleport tablet.",
			new SkillRequirement(Skill.MAGIC, 90),
			new SkillRequirement(Skill.MINING, 38),
			new SkillRequirement(Skill.CRAFTING, 38));
		add("Create your own Battlestaff from scratch within the Farming Guild.",
			new SkillRequirement(Skill.FARMING, 85),
			new SkillRequirement(Skill.FLETCHING, 40));
	}
}
