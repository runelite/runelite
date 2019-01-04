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

public class DesertDiaryRequirement extends GenericDiaryRequirement
{
	public DesertDiaryRequirement()
	{
		// EASY
		add("Catch a Golden Warbler.",
			new Requirement(Skill.HUNTER, 5));
		add("Mine 5 clay in the north-eastern desert.",
			new Requirement(Skill.MINING, 5));
		add("Open the Sarcophagus in the first room of Pyramid Plunder.",
			new Requirement(Skill.THIEVING, 21),
			new Requirement(Quest.ICTHLARINS_LITTLE_HELPER, true));

		// MEDIUM
		add("Climb to the summit of the Agility Pyramid.",
			new Requirement(Skill.AGILITY, 30));
		add("Slay a desert lizard.",
			new Requirement(Skill.SLAYER, 22));
		add("Catch an Orange Salamander.",
			new Requirement(Skill.HUNTER, 47));
		add("Steal a feather from the Desert Phoenix.",
			new Requirement(Skill.THIEVING, 25));
		add("Travel to Uzer via Magic Carpet.",
			new Requirement(Quest.THE_GOLEM));
		add("Travel to the Desert via Eagle.",
			new Requirement(Quest.EAGLES_PEAK));
		add("Pray at the Elidinis statuette in Nardah.",
			new Requirement(Quest.SPIRITS_OF_THE_ELID));
		add("Create a combat potion in the desert.",
			new Requirement(Skill.HERBLORE, 36));
		add("Teleport to Enakhra's Temple with the Camulet.",
			new Requirement(Quest.ENAKHRAS_LAMENT));
		add("Visit the Genie.",
			new Requirement(Quest.SPIRITS_OF_THE_ELID));
		add("Teleport to Pollnivneach with a redirected teleport to house tablet.",
			new Requirement(Skill.CONSTRUCTION, 20));
		add("Chop some Teak logs near Uzer.",
			new Requirement(Skill.WOODCUTTING, 35));

		// HARD
		add("Knock out and pickpocket a Menaphite Thug.",
			new Requirement(Skill.THIEVING, 65),
			new Requirement(Quest.THE_FEUD));
		add("Mine some Granite.",
			new Requirement(Skill.MINING, 45));
		add("Refill your waterskins in the Desert using Lunar magic.",
			new Requirement(Skill.MAGIC, 68),
			new Requirement(Quest.DREAM_MENTOR));
		add("Complete a lap of the Pollnivneach agility course.",
			new Requirement(Skill.AGILITY, 70));
		add("Slay a Dust Devil with a Slayer helmet equipped.",
			new Requirement(Skill.SLAYER, 65),
			new Requirement(Skill.DEFENCE, 10),
			new Requirement(Skill.CRAFTING, 55),
			new Requirement(Quest.DESERT_TREASURE, true));
		add("Activate Ancient Magicks at the altar in the Jaldraocht Pyramid.",
			new Requirement(Quest.DESERT_TREASURE));
		add("Defeat a Locust Rider with Keris.",
			new Requirement(Skill.ATTACK, 50),
			new Requirement(Quest.CONTACT));
		add("Burn some yew logs on the Nardah Mayor's balcony.",
			new Requirement(Skill.FIREMAKING, 60));
		add("Create a Mithril Platebody in Nardah.",
			new Requirement(Skill.SMITHING, 68));

		// ELITE
		add("Bake a wild pie at the Nardah Clay Oven.",
			new Requirement(Skill.COOKING, 85));
		add("Cast Ice Barrage against a foe in the Desert.",
			new Requirement(Skill.MAGIC, 94),
			new Requirement(Quest.DESERT_TREASURE));
		add("Fletch some Dragon darts at the Bedabin Camp.",
			new Requirement(Skill.FLETCHING, 95),
			new Requirement(Quest.THE_TOURIST_TRAP));
		add("Speak to the KQ head in your POH.",
			new Requirement(Skill.CONSTRUCTION, 78),
			new Requirement(Quest.PRIEST_IN_PERIL));
		add("Steal from the Grand Gold Chest in the final room of Pyramid Plunder.",
			new Requirement(Skill.THIEVING, 91),
			new Requirement(Quest.ICTHLARINS_LITTLE_HELPER, true));
		add("Restore at least 85 Prayer points when praying at the Altar in Sophanem.",
			new Requirement(Skill.PRAYER, 85),
			new Requirement(Quest.ICTHLARINS_LITTLE_HELPER, true));
	}
}
