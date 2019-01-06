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
import net.runelite.client.plugins.achievementdiary.GenericDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.Requirement;

public class FremennikDiaryRequirement extends GenericDiaryRequirement
{
	public FremennikDiaryRequirement()
	{
		// EASY
		add("Catch a Cerulean twitch.",
			new Requirement(Skill.HUNTER, 11));
		add("Change your boots at Yrsa's Shoe Store.",
			new Requirement(Quest.THE_FREMENNIK_TRIALS));
		add("Craft a tiara from scratch in Rellekka.",
			new Requirement(Skill.CRAFTING, 23),
			new Requirement(Skill.MINING, 20),
			new Requirement(Skill.SMITHING, 20),
			new Requirement(Quest.THE_FREMENNIK_TRIALS));
		add("Browse the Stonemasons shop.",
			new Requirement(Quest.THE_GIANT_DWARF, true));
		add("Steal from the Keldagrim crafting or baker's stall.",
			new Requirement(Skill.THIEVING, 5),
			new Requirement(Quest.THE_GIANT_DWARF, true));
		add("Enter the Troll Stronghold",
			new Requirement(Quest.DEATH_PLATEAU),
			new Requirement(Quest.TROLL_STRONGHOLD));
		add("Chop and burn some oak logs in the Fremennik Province.",
			new Requirement(Skill.WOODCUTTING, 15),
			new Requirement(Skill.FIREMAKING, 15));

		// MEDIUM
		add("Slay a Brine rat.",
			new Requirement(Skill.SLAYER, 47),
			new Requirement(Quest.OLAFS_QUEST, true));
		add("Travel to the Snowy Hunter Area via Eagle.",
			new Requirement(Quest.EAGLES_PEAK));
		add("Mine some coal in Rellekka.",
			new Requirement(Skill.MINING, 30),
			new Requirement(Quest.THE_FREMENNIK_TRIALS));
		add("Steal from the Rellekka Fish stalls.",
			new Requirement(Skill.THIEVING, 42),
			new Requirement(Quest.THE_FREMENNIK_TRIALS));
		add("Travel to Miscellania by Fairy ring.",
			new Requirement(Quest.THE_FREMENNIK_TRIALS),
			new Requirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true));
		add("Catch a Snowy knight.",
			new Requirement(Skill.HUNTER, 35));
		add("Pick up your Pet Rock from your POH Menagerie.",
			new Requirement(Skill.CONSTRUCTION, 37),
			new Requirement(Quest.THE_FREMENNIK_TRIALS));
		add("Visit the Lighthouse from Waterbirth island.",
			new Requirement(Quest.HORROR_FROM_THE_DEEP),
			new Requirement(Quest.THE_FREMENNIK_TRIALS, true));
		add("Mine some gold at the Arzinian mine.",
			new Requirement(Skill.MINING, 40),
			new Requirement(Quest.BETWEEN_A_ROCK, true));

		// HARD
		add("Teleport to Trollheim.",
			new Requirement(Skill.MAGIC, 61),
			new Requirement(Quest.EADGARS_RUSE));
		add("Catch a Sabre-toothed Kyatt.",
			new Requirement(Skill.HUNTER, 55));
		add("Mix a super defence potion in the Fremennik province.",
			new Requirement(Skill.HERBLORE, 66));
		add("Steal from the Keldagrim Gem Stall.",
			new Requirement(Skill.THIEVING, 75),
			new Requirement(Quest.THE_GIANT_DWARF, true));
		add("Craft a Fremennik shield on Neitiznot.",
			new Requirement(Skill.WOODCUTTING, 56),
			new Requirement(Quest.THE_FREMENNIK_ISLES));
		add("Mine 5 Adamantite ores on Jatizso.",
			new Requirement(Skill.MINING, 70),
			new Requirement(Quest.THE_FREMENNIK_ISLES));
		add("Obtain 100% support from your kingdom subjects.",
			new Requirement(Quest.THRONE_OF_MISCELLANIA));
		add("Teleport to Waterbirth Island.",
			new Requirement(Skill.MAGIC, 72),
			new Requirement(Quest.LUNAR_DIPLOMACY));
		add("Obtain the Blast Furnace Foreman's permission to use the Blast Furnace for free.",
			new Requirement(Skill.SMITHING, 60),
			new Requirement(Quest.THE_GIANT_DWARF, true));

		// ELITE
		add("Craft 56 astral runes at once.",
			new Requirement(Skill.RUNECRAFT, 82),
			new Requirement(Quest.LUNAR_DIPLOMACY));
		add("Create a dragonstone amulet in the Neitiznot furnace.",
			new Requirement(Skill.CRAFTING, 80),
			new Requirement(Quest.THE_FREMENNIK_ISLES, true));
		add("Complete a lap of the Rellekka agility course.",
			new Requirement(Skill.AGILITY, 80));
		add("Kill each of the Godwars generals.",
			new Requirement(Skill.AGILITY, 70),
			new Requirement(Skill.STRENGTH, 70),
			new Requirement(Skill.HITPOINTS, 70),
			new Requirement(Skill.RANGED, 70),
			new Requirement(Quest.TROLL_STRONGHOLD));
		add("Slay a Spiritual mage within the Godwars Dungeon.",
			new Requirement(Skill.SLAYER, 83),
			new Requirement(Quest.TROLL_STRONGHOLD));
	}
}
