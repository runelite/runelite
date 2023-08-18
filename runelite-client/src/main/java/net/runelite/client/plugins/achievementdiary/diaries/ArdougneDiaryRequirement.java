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
import net.runelite.client.plugins.achievementdiary.QuestRequirement;
import net.runelite.client.plugins.achievementdiary.SkillRequirement;

public class ArdougneDiaryRequirement extends GenericDiaryRequirement
{
	public ArdougneDiaryRequirement()
	{
		// EASY
		add("Have Wizard Cromperty teleport you to the Rune Essence mine.",
			new QuestRequirement(Quest.RUNE_MYSTERIES));
		add("Steal a cake from the Ardougne market stalls.",
			new SkillRequirement(Skill.THIEVING, 5));
		add("Enter the Combat Training Camp north of W. Ardougne.",
			new QuestRequirement(Quest.BIOHAZARD));

		// MEDIUM
		add("Enter the Unicorn pen in Ardougne zoo using Fairy rings.",
			new QuestRequirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true));
		add("Grapple over Yanille's south wall.",
			new SkillRequirement(Skill.AGILITY, 39),
			new SkillRequirement(Skill.STRENGTH, 38),
			new SkillRequirement(Skill.RANGED, 21));
		add("Harvest some strawberries from the Ardougne farming patch.",
			new SkillRequirement(Skill.FARMING, 31));
		add("Cast the Ardougne Teleport spell.",
			new SkillRequirement(Skill.MAGIC, 51),
			new QuestRequirement(Quest.PLAGUE_CITY));
		add("Travel to Castlewars by Hot Air Balloon.",
			new SkillRequirement(Skill.FIREMAKING, 50),
			new QuestRequirement(Quest.ENLIGHTENED_JOURNEY));
		add("Claim buckets of sand from Bert in Yanille.",
			new SkillRequirement(Skill.CRAFTING, 49),
			new QuestRequirement(Quest.THE_HAND_IN_THE_SAND));
		add("Catch any fish on the Fishing Platform.",
			new QuestRequirement(Quest.SEA_SLUG, true));
		add("Pickpocket the master farmer north of Ardougne.",
			new SkillRequirement(Skill.THIEVING, 38));
		add("Collect some Nightshade from the Skavid Caves.",
			new QuestRequirement(Quest.WATCHTOWER, true));
		add("Kill a swordchick in the Tower of Life.",
			new QuestRequirement(Quest.TOWER_OF_LIFE));
		add("Equip Iban's upgraded staff or upgrade an Iban staff.",
			new SkillRequirement(Skill.MAGIC, 50),
			new SkillRequirement(Skill.ATTACK, 50),
			new QuestRequirement(Quest.UNDERGROUND_PASS));
		add("Visit the Island East of the Necromancer's tower.",
			new QuestRequirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true));

		// HARD
		// When the task is completed "the Totem" changes to "Totem" - so we add
		// both variations.
		add("Recharge some Jewellery at the Totem in the Legends Guild.",
			new QuestRequirement(Quest.LEGENDS_QUEST));
		add("Recharge some Jewellery at Totem in the Legends Guild.",
			new QuestRequirement(Quest.LEGENDS_QUEST));
		add("Enter the Magic Guild.",
			new SkillRequirement(Skill.MAGIC, 66));
		add("Steal from a chest in Ardougne Castle.",
			new SkillRequirement(Skill.THIEVING, 72));
		add("Have a zookeeper put you in Ardougne Zoo's monkey cage.",
			new QuestRequirement(Quest.MONKEY_MADNESS_I, true));
		add("Teleport to the Watchtower.",
			new SkillRequirement(Skill.MAGIC, 58),
			new QuestRequirement(Quest.WATCHTOWER));
		add("Catch a Red Salamander.",
			new SkillRequirement(Skill.HUNTER, 59));
		add("Check the health of a Palm tree near tree gnome village.",
			new SkillRequirement(Skill.FARMING, 68));
		add("Pick some Poison Ivy berries from the patch south of Ardougne.",
			new SkillRequirement(Skill.FARMING, 70));
		add("Smith a Mithril platebody near Ardougne.",
			new SkillRequirement(Skill.SMITHING, 68));
		add("Enter your POH from Yanille.",
			new SkillRequirement(Skill.CONSTRUCTION, 50));
		add("Smith a Dragon sq shield in West Ardougne.",
			new SkillRequirement(Skill.SMITHING, 60),
			new QuestRequirement(Quest.LEGENDS_QUEST));
		add("Craft some Death runes from Essence.",
			new SkillRequirement(Skill.RUNECRAFT, 65),
			new QuestRequirement(Quest.MOURNINGS_END_PART_II));

		// ELITE
		add("Catch a Manta ray in the Fishing Trawler and cook it in Port Khazard.",
			new SkillRequirement(Skill.FISHING, 81),
			new SkillRequirement(Skill.COOKING, 91)
		);
		add("Picklock the door to the basement of Yanille Agility Dungeon.",
			new SkillRequirement(Skill.THIEVING, 82));
		add("Pickpocket a Hero.",
			new SkillRequirement(Skill.THIEVING, 80));
		add("Make a rune crossbow yourself from scratch within Witchaven or Yanille.",
			new SkillRequirement(Skill.CRAFTING, 10),
			new SkillRequirement(Skill.SMITHING, 91),
			new SkillRequirement(Skill.FLETCHING, 69));
		add("Imbue a salve amulet at Nightmare Zone or equip an imbued salve amulet.",
			new QuestRequirement(Quest.HAUNTED_MINE));
		add("Pick some Torstol from the patch north of Ardougne.",
			new SkillRequirement(Skill.FARMING, 85));
		add("Complete a lap of Ardougne's rooftop agility course.",
			new SkillRequirement(Skill.AGILITY, 90));
		add("Cast Ice Barrage on another player within Castle Wars.",
			new SkillRequirement(Skill.MAGIC, 94),
			new QuestRequirement(Quest.DESERT_TREASURE_I));
	}
}
