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
import net.runelite.api.Skill;
import net.runelite.client.plugins.achievementdiary.CombatLevelRequirement;
import net.runelite.client.plugins.achievementdiary.GenericDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.OrRequirement;
import net.runelite.client.plugins.achievementdiary.QuestRequirement;
import net.runelite.client.plugins.achievementdiary.SkillRequirement;

public class KaramjaDiaryRequirement extends GenericDiaryRequirement
{
	public KaramjaDiaryRequirement()
	{
		// EASY
		add("Use the rope swing to travel to the small island north-west of Karamja, where the " +
				"moss giants are.",
			new SkillRequirement(Skill.AGILITY, 10));
		add("Mine some gold from the rocks on the north-west peninsula of Karamja.",
			new SkillRequirement(Skill.MINING, 40));
		add("Explore Cairn Island to the west of Karamja.",
			new SkillRequirement(Skill.AGILITY, 15));

		// MEDIUM
		add("Claim a ticket from the Agility Arena in Brimhaven.",
			new SkillRequirement(Skill.AGILITY, 30));
		add("Discover hidden wall in the dungeon below the volcano.",
			new QuestRequirement(Quest.DRAGON_SLAYER, true));
		add("Visit the Isle of Crandor via the dungeon below the volcano.",
			new QuestRequirement(Quest.DRAGON_SLAYER, true));
		add("Use Vigroy and Hajedy's cart service.",
			new QuestRequirement(Quest.SHILO_VILLAGE));
		add("Earn 100% favour in the village of Tai Bwo Wannai.",
			new SkillRequirement(Skill.WOODCUTTING, 10),
			new QuestRequirement(Quest.JUNGLE_POTION));
		add("Cook a spider on a stick.",
			new SkillRequirement(Skill.COOKING, 16));
		add("Charter the Lady of the Waves from Cairn Isle to Port Khazard.",
			new QuestRequirement(Quest.SHILO_VILLAGE));
		add("Cut a log from a teak tree.",
			new SkillRequirement(Skill.WOODCUTTING, 35),
			new QuestRequirement(Quest.JUNGLE_POTION));
		add("Cut a log from a mahogany tree.",
			new SkillRequirement(Skill.WOODCUTTING, 50),
			new QuestRequirement(Quest.JUNGLE_POTION));
		add("Catch a karambwan.",
			new SkillRequirement(Skill.FISHING, 65),
			new QuestRequirement(Quest.TAI_BWO_WANNAI_TRIO, true));
		add("Exchange gems for a machete.",
			new QuestRequirement(Quest.JUNGLE_POTION));
		add("Use the gnome glider to travel to Karamja.",
			new QuestRequirement(Quest.THE_GRAND_TREE));
		add("Grow a healthy fruit tree in the patch near Brimhaven.",
			new SkillRequirement(Skill.FARMING, 27));
		add("Trap a horned graahk.",
			new SkillRequirement(Skill.HUNTER, 41));
		add("Chop the vines to gain deeper access to Brimhaven Dungeon.",
			new SkillRequirement(Skill.WOODCUTTING, 10));
		add("Cross the lava using the stepping stones within Brimhaven Dungeon.",
			new SkillRequirement(Skill.AGILITY, 12));
		add("Climb the stairs within Brimhaven Dungeon.",
			new SkillRequirement(Skill.WOODCUTTING, 10));
		add("Charter a ship from the shipyard in the far east of Karamja.",
			new QuestRequirement(Quest.THE_GRAND_TREE));
		add("Mine a red topaz from a gem rock.",
			new SkillRequirement(Skill.MINING, 40),
			new OrRequirement(
				new QuestRequirement(Quest.SHILO_VILLAGE),
				new QuestRequirement(Quest.JUNGLE_POTION)
			)
		);

		// HARD
		add("Craft some nature runes.",
			new SkillRequirement(Skill.RUNECRAFT, 44),
			new QuestRequirement(Quest.RUNE_MYSTERIES));
		add("Cook a karambwan thoroughly.",
			new SkillRequirement(Skill.COOKING, 30),
			new QuestRequirement(Quest.TAI_BWO_WANNAI_TRIO));
		add("Kill a deathwing in the dungeon under the Kharazi Jungle.",
			new SkillRequirement(Skill.WOODCUTTING, 15),
			new SkillRequirement(Skill.STRENGTH, 50),
			new SkillRequirement(Skill.AGILITY, 50),
			new SkillRequirement(Skill.THIEVING, 50),
			new SkillRequirement(Skill.MINING, 52),
			new QuestRequirement(Quest.LEGENDS_QUEST));
		add("Use the crossbow short cut south of the volcano.",
			new SkillRequirement(Skill.AGILITY, 53),
			new SkillRequirement(Skill.RANGED, 42),
			new SkillRequirement(Skill.STRENGTH, 21));
		add("Collect 5 palm leaves.",
			new SkillRequirement(Skill.WOODCUTTING, 15),
			new QuestRequirement(Quest.LEGENDS_QUEST));
		add("Be assigned a Slayer task by Duradel north of Shilo Village.",
			new CombatLevelRequirement(100),
			new SkillRequirement(Skill.SLAYER, 50),
			new QuestRequirement(Quest.SHILO_VILLAGE));
		add("Kill a metal dragon in Brimhaven Dungeon.",
			new SkillRequirement(Skill.AGILITY, 12),
			new SkillRequirement(Skill.WOODCUTTING, 34));

		// ELITE
		add("Craft 56 Nature runes at once.",
			new SkillRequirement(Skill.RUNECRAFT, 91));
		add("Check the health of a palm tree in Brimhaven.",
			new SkillRequirement(Skill.FARMING, 68));
		add("Create an antivenom potion whilst standing in the horse shoe mine.",
			new SkillRequirement(Skill.HERBLORE, 87));
		add("Check the health of your Calquat tree patch.",
			new SkillRequirement(Skill.FARMING, 72));
	}
}
