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
import net.runelite.client.plugins.achievementdiary.SkillRequirement;

public class ArdougneDiaryRequirement extends GenericDiaryRequirement
{
	public ArdougneDiaryRequirement()
	{
		// EASY
		add("Steal a cake from the Ardougne market stalls.",
			new SkillRequirement(Skill.THIEVING, 5));

		// MEDIUM
		add("Grapple over Yanille's south wall.",
			new SkillRequirement(Skill.AGILITY, 39),
			new SkillRequirement(Skill.STRENGTH, 38),
			new SkillRequirement(Skill.RANGED, 21));
		add("Harvest some strawberries from the Ardougne farming patch.",
			new SkillRequirement(Skill.FARMING, 31));
		add("Cast the Ardougne Teleport spell.",
			new SkillRequirement(Skill.MAGIC, 51));
		add("Travel to Castlewars by Hot Air Balloon.",
			new SkillRequirement(Skill.FIREMAKING, 50));
		add("Claim buckets of sand from Bert in Yanille.",
			new SkillRequirement(Skill.CRAFTING, 49));
		add("Pickpocket the master farmer north of Ardougne.",
			new SkillRequirement(Skill.THIEVING, 38));
		add("Equip Iban's upgraded staff or upgrade an Iban staff.",
			new SkillRequirement(Skill.MAGIC, 50),
			new SkillRequirement(Skill.ATTACK, 50));

		// HARD
		add("Enter the Magic Guild.",
			new SkillRequirement(Skill.MAGIC, 66));
		add("Attempt to steal from King Lathas' chest.",
			new SkillRequirement(Skill.THIEVING, 72));
		add("Teleport to the Watchtower.",
			new SkillRequirement(Skill.MAGIC, 58));
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
			new SkillRequirement(Skill.SMITHING, 60));
		add("Craft some Death runes.",
			new SkillRequirement(Skill.RUNECRAFT, 65));

		// ELITE
		add("Catch a Manta ray in the Fishing Trawler and cook it in Port Khazard.",

			new SkillRequirement(Skill.FISHING, 81),
			new SkillRequirement(Skill.COOKING, 91)
		);
		add("Attempt to picklock the door to the basement of Yanille Agility Dungeon.",
			new SkillRequirement(Skill.THIEVING, 82));
		add("Pickpocket a Hero.",
			new SkillRequirement(Skill.THIEVING, 80));
		add("Make a rune crossbow yourself from scratch within Witchaven or Yanille.",
			new SkillRequirement(Skill.CRAFTING, 10),
			new SkillRequirement(Skill.SMITHING, 91),
			new SkillRequirement(Skill.FLETCHING, 69));
		add("Pick some Torstol from the patch north of Ardougne.",
			new SkillRequirement(Skill.FARMING, 85));
		add("Complete a lap of Ardougne's rooftop agility course.",
			new SkillRequirement(Skill.AGILITY, 90));
		add("Cast Ice Barrage on another player within Castlewars.",
			new SkillRequirement(Skill.MAGIC, 94));
	}
}
