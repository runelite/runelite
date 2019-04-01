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

public class MorytaniaDiaryRequirement extends GenericDiaryRequirement
{
	public MorytaniaDiaryRequirement()
	{
		// EASY
		add("Craft any Snelm from scratch in Morytania.",
			new SkillRequirement(Skill.CRAFTING, 15));
		add("Cook a thin Snail on the Port Phasmatys range.",
			new SkillRequirement(Skill.COOKING, 12));
		add("Get a slayer task from Mazchna.",
			new CombatLevelRequirement(20));
		add("Kill a Banshee in the Slayer Tower.",
			new SkillRequirement(Skill.SLAYER, 15));
		add("Place a Scarecrow in the Morytania flower patch.",
			new SkillRequirement(Skill.FARMING, 23));
		add("Kill a werewolf in its human form using the Wolfbane Dagger.",
			new QuestRequirement(Quest.PRIEST_IN_PERIL));
		add("Restore your prayer points at the nature altar.",
			new QuestRequirement(Quest.NATURE_SPIRIT));

		// MEDIUM
		add("Catch a swamp lizard.",
			new SkillRequirement(Skill.HUNTER, 29));
		add("Complete a lap of the Canifis agility course.",
			new SkillRequirement(Skill.AGILITY, 40));
		add("Obtain some Bark from a Hollow tree.",
			new SkillRequirement(Skill.WOODCUTTING, 45));
		add("Kill a Terror Dog.",
			new SkillRequirement(Skill.SLAYER, 40),
			new QuestRequirement(Quest.LAIR_OF_TARN_RAZORLOR));
		add("Complete a game of trouble brewing.",
			new SkillRequirement(Skill.COOKING, 40),
			new QuestRequirement(Quest.CABIN_FEVER));
		add("Make a batch of cannonballs at the Port Phasmatys furnace.",
			new SkillRequirement(Skill.SMITHING, 35),
			new QuestRequirement(Quest.DWARF_CANNON),
			new QuestRequirement(Quest.GHOSTS_AHOY, true));
		add("Kill a Fever Spider on Braindeath Island.",
			new SkillRequirement(Skill.SLAYER, 42),
			new QuestRequirement(Quest.RUM_DEAL));
		add("Use an ectophial to return to Port Phasmatys.",
			new QuestRequirement(Quest.GHOSTS_AHOY));
		add("Mix a Guthix Balance potion while in Morytania.",
			new SkillRequirement(Skill.HERBLORE, 22),
			new QuestRequirement(Quest.IN_AID_OF_THE_MYREQUE, true));

		// HARD
		add("Enter the Kharyrll portal in your POH.",
			new SkillRequirement(Skill.MAGIC, 66),
			new SkillRequirement(Skill.CONSTRUCTION, 50),
			new QuestRequirement(Quest.DESERT_TREASURE));
		add("Climb the advanced spike chain within Slayer Tower.",
			new SkillRequirement(Skill.AGILITY, 71));
		add("Harvest some Watermelon from the Allotment patch on Harmony Island.",
			new SkillRequirement(Skill.FARMING, 47),
			new QuestRequirement(Quest.THE_GREAT_BRAIN_ROBBERY, true));
		add("Chop and burn some mahogany logs on Mos Le'Harmless.",
			new SkillRequirement(Skill.WOODCUTTING, 50),
			new SkillRequirement(Skill.FIREMAKING, 50),
			new QuestRequirement(Quest.CABIN_FEVER));
		add("Complete a temple trek with a hard companion.",
			new QuestRequirement(Quest.IN_AID_OF_THE_MYREQUE));
		add("Kill a Cave Horror.",
			new SkillRequirement(Skill.SLAYER, 58),
			new QuestRequirement(Quest.CABIN_FEVER));
		add("Harvest some Bittercap Mushrooms from the patch in Canifis.",
			new SkillRequirement(Skill.FARMING, 53));
		add("Pray at the Altar of Nature with Piety activated.",
			new SkillRequirement(Skill.PRAYER, 70),
			new SkillRequirement(Skill.DEFENCE, 70),
			new QuestRequirement(Quest.NATURE_SPIRIT),
			new QuestRequirement(Quest.KINGS_RANSOM));
		add("Use the shortcut to get to the bridge over the Salve.",
			new SkillRequirement(Skill.AGILITY, 65));
		add("Mine some Mithril ore in the Abandoned Mine.",
			new SkillRequirement(Skill.MINING, 55),
			new QuestRequirement(Quest.HAUNTED_MINE));

		// ELITE
		add("Catch a shark in Burgh de Rott with your bare hands.",
			new SkillRequirement(Skill.FISHING, 96),
			new SkillRequirement(Skill.STRENGTH, 76),
			new QuestRequirement(Quest.IN_AID_OF_THE_MYREQUE));
		add("Cremate any Shade remains on a Magic or Redwood pyre.",
			new SkillRequirement(Skill.FIREMAKING, 80),
			new QuestRequirement(Quest.SHADES_OF_MORTTON));
		add("Fertilize the Morytania herb patch using Lunar Magic.",
			new SkillRequirement(Skill.MAGIC, 83),
			new QuestRequirement(Quest.LUNAR_DIPLOMACY));
		add("Craft a Black dragonhide body in Canifis bank.",
			new SkillRequirement(Skill.CRAFTING, 84));
		add("Kill an Abyssal demon in the Slayer Tower.",
			new SkillRequirement(Skill.SLAYER, 85));
		add("Loot the Barrows chest while wearing any complete barrows set.",
			new SkillRequirement(Skill.DEFENCE, 70),
			new OrRequirement(
				new SkillRequirement(Skill.ATTACK, 70),
				new SkillRequirement(Skill.STRENGTH, 70),
				new SkillRequirement(Skill.RANGED, 70),
				new SkillRequirement(Skill.MAGIC, 70)
			)
		);
	}
}
