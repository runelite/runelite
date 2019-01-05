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

public class ArdougneDiaryRequirement extends GenericDiaryRequirement
{
	public ArdougneDiaryRequirement()
	{
		// EASY
		add("Have Wizard Cromperty teleport you to the Rune Essence mine.",
			new Requirement(Quest.RUNE_MYSTERIES));
		add("Steal a cake from the Ardougne market stalls.",
			new Requirement(Skill.THIEVING, 5));
		add("Enter the Combat Training Camp north of W. Ardougne",
			new Requirement(Quest.BIOHAZARD));

		// MEDIUM
		add("Enter the Unicorn pen in Ardougne zoo using Fairy rings.",
			new Requirement(Quest.FAIRYTALE_II, true));
		add("Grapple over Yanille's south wall.",
			new Requirement(Skill.AGILITY, 39),
			new Requirement(Skill.STRENGTH, 38),
			new Requirement(Skill.RANGED, 21));
		add("Harvest some strawberries from the Ardougne farming patch.",
			new Requirement(Skill.FARMING, 31));
		add("Cast the Ardougne Teleport spell.",
			new Requirement(Skill.MAGIC, 51),
			new Requirement(Quest.PLAGUE_CITY));
		add("Travel to Castlewars by Hot Air Balloon.",
			new Requirement(Skill.FIREMAKING, 50),
			new Requirement(Quest.ENLIGHTENED_JOURNEY));
		add("Claim buckets of sand from Bert in Yanille.",
			new Requirement(Skill.CRAFTING, 49),
			new Requirement(Quest.THE_HAND_IN_THE_SAND));
		add("Catch any fish on the Fishing Platform.",
			new Requirement(Quest.SEA_SLUG, true));
		add("Pickpocket the master farmer north of Ardougne.",
			new Requirement(Skill.THIEVING, 38));
		add("Collect some Nightshade from the Skavid Caves.",
			new Requirement(Quest.WATCHTOWER, true));
		add("Kill a swordchick in the Tower of Life.",
			new Requirement(Quest.TOWER_OF_LIFE));
		add("Equip Iban's upgraded staff or upgrade an Iban staff.",
			new Requirement(Skill.MAGIC, 50),
			new Requirement(Skill.ATTACK, 50),
			new Requirement(Quest.UNDERGROUND_PASS));
		add("Visit the Island East of the Necromancer's tower.",
			new Requirement(Quest.FAIRYTALE_II, true));

		// HARD
		add("Recharge some Jewellery at Totem in the Legends Guild.",
			new Requirement(Quest.LEGENDS_QUEST));
		add("Enter the Magic Guild.",
			new Requirement(Skill.MAGIC, 66));
		add("Attempt to steal from King Lathas' chest.",
			new Requirement(Skill.THIEVING, 72));
		add("Have a zookeeper put you in Ardougne Zoo's monkey cage.",
			new Requirement(Quest.MONKEY_MADNESS_I, true));
		add("Teleport to the Watchtower.",
			new Requirement(Skill.MAGIC, 58),
			new Requirement(Quest.WATCHTOWER));
		add("Catch a Red Salamander.",
			new Requirement(Skill.HUNTER, 59));
		add("Check the health of a Palm tree near tree gnome village.",
			new Requirement(Skill.FARMING, 68));
		add("Pick some Poison Ivy berries from the patch south of Ardougne.",
			new Requirement(Skill.FARMING, 70));
		add("Smith a Mithril platebody near Ardougne.",
			new Requirement(Skill.SMITHING, 68));
		add("Enter your POH from Yanille.",
			new Requirement(Skill.CONSTRUCTION, 50));
		add("Smith a Dragon sq shield in West Ardougne.",
			new Requirement(Skill.SMITHING, 60),
			new Requirement(Quest.LEGENDS_QUEST));
		add("Craft some Death runes.",
			new Requirement(Skill.RUNECRAFT, 65),
			new Requirement(Quest.MOURNINGS_ENDS_PART_II));

		// ELITE
		add("Catch a Manta ray in the Fishing Trawler and cook it in Port Khazard.",

			new Requirement(Skill.FISHING, 81),
			new Requirement(Skill.COOKING, 91)
		);
		add("Attempt to picklock the door to the basement of Yanille Agility Dungeon.",
			new Requirement(Skill.THIEVING, 82));
		add("Pickpocket a Hero.",
			new Requirement(Skill.THIEVING, 80));
		add("Make a rune crossbow yourself from scratch within Witchaven or Yanille.",
			new Requirement(Skill.CRAFTING, 10),
			new Requirement(Skill.SMITHING, 91),
			new Requirement(Skill.FLETCHING, 69));
		add("Imbue a salve amulet at Nightmare Zone or equip an imbued salve amulet.",
			new Requirement(Quest.HAUNTED_MINE));
		add("Pick some Torstol from the patch north of Ardougne.",
			new Requirement(Skill.FARMING, 85));
		add("Complete a lap of Ardougne's rooftop agility course.",
			new Requirement(Skill.AGILITY, 90));
		add("Cast Ice Barrage on another player within Castlewars.",
			new Requirement(Skill.MAGIC, 94),
			new Requirement(Quest.DESERT_TREASURE));
	}
}
