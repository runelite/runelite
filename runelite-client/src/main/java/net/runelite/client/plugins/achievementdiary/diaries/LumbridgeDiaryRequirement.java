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
import net.runelite.client.plugins.achievementdiary.QuestRequirement;
import net.runelite.client.plugins.achievementdiary.SkillRequirement;

public class LumbridgeDiaryRequirement extends GenericDiaryRequirement
{
	public LumbridgeDiaryRequirement()
	{
		// EASY
		add("Slay a Cave bug beneath Lumbridge Swamp.",
			new SkillRequirement(Skill.SLAYER, 7));
		add("Have Sedridor teleport you to the Essence Mine.",
			new QuestRequirement(Quest.RUNE_MYSTERIES));
		add("Craft some water runes from Essence.",
			new SkillRequirement(Skill.RUNECRAFT, 5));
		add("Chop and burn some oak logs in Lumbridge.",
			new SkillRequirement(Skill.WOODCUTTING, 15),
			new SkillRequirement(Skill.FIREMAKING, 15));
		add("Catch some Anchovies in Al Kharid.",
			new SkillRequirement(Skill.FISHING, 15));
		add("Bake some Bread on the Lumbridge kitchen range.",
			new QuestRequirement(Quest.COOKS_ASSISTANT));
		add("Mine some Iron ore at the Al Kharid mine.",
			new SkillRequirement(Skill.MINING, 15));

		// MEDIUM
		add("Complete a lap of the Al Kharid agility course.",
			new SkillRequirement(Skill.AGILITY, 20));
		add("Grapple across the River Lum.",
			new SkillRequirement(Skill.AGILITY, 8),
			new SkillRequirement(Skill.STRENGTH, 19),
			new SkillRequirement(Skill.RANGED, 37));
		add("Purchase an upgraded device from Ava.",
			new SkillRequirement(Skill.RANGED, 50),
			new QuestRequirement(Quest.ANIMAL_MAGNETISM));
		add("Travel to the Wizards' Tower by Fairy ring.",
			new QuestRequirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true));
		add("Cast the teleport to Lumbridge spell.",
			new SkillRequirement(Skill.MAGIC, 31));
		add("Catch some Salmon in Lumbridge.",
			new SkillRequirement(Skill.FISHING, 30));
		add("Craft a coif in the Lumbridge cow pen.",
			new SkillRequirement(Skill.CRAFTING, 38));
		add("Chop some willow logs in Draynor Village.",
			new SkillRequirement(Skill.WOODCUTTING, 30));
		add("Pickpocket Martin the Master Gardener.",
			new SkillRequirement(Skill.THIEVING, 38));
		add("Get a slayer task from Chaeldar.",
			new CombatLevelRequirement(70),
			new QuestRequirement(Quest.LOST_CITY));
		add("Catch an Essence or Eclectic impling in Puro-Puro.",
			new SkillRequirement(Skill.HUNTER, 42),
			new QuestRequirement(Quest.LOST_CITY));
		add("Craft some Lava runes at the fire altar in Al Kharid.",
			new SkillRequirement(Skill.RUNECRAFT, 23));

		// HARD
		add("Cast Bones to Peaches in Al Kharid palace.",
			new SkillRequirement(Skill.MAGIC, 60));
		add("Squeeze past the jutting wall on your way to the cosmic altar.",
			new SkillRequirement(Skill.AGILITY, 46),
			new QuestRequirement(Quest.LOST_CITY));
		add("Craft 56 Cosmic runes simultaneously from Essence without the use of Extracts.",
			new SkillRequirement(Skill.RUNECRAFT, 59),
			new QuestRequirement(Quest.LOST_CITY));
		add("Travel from Lumbridge to Edgeville on a Waka Canoe.",
			new SkillRequirement(Skill.WOODCUTTING, 57));
		add("Collect at least 100 Tears of Guthix in one visit.",
			new QuestRequirement(Quest.TEARS_OF_GUTHIX));
		add("Take the train from Dorgesh-Kaan to Keldagrim.",
			new QuestRequirement(Quest.ANOTHER_SLICE_OF_HAM));
		add("Purchase some Barrows gloves from the Lumbridge bank chest.",
			new QuestRequirement(Quest.RECIPE_FOR_DISASTER));
		add("Pick some Belladonna from the farming patch at Draynor Manor.",
			new SkillRequirement(Skill.FARMING, 63));
		add("Light your mining helmet in the Lumbridge castle basement.",
			new SkillRequirement(Skill.FIREMAKING, 65));
		add("Recharge your prayer at the Emir's Arena with Smite activated.",
			new SkillRequirement(Skill.PRAYER, 52));
		add("Craft, string and enchant an Amulet of Power in Lumbridge.",
			new SkillRequirement(Skill.CRAFTING, 70),
			new SkillRequirement(Skill.MAGIC, 57));

		// ELITE
		add("Steal from a Dorgesh-Kaan rich chest.",
			new SkillRequirement(Skill.THIEVING, 78),
			new QuestRequirement(Quest.DEATH_TO_THE_DORGESHUUN));
		add("Pickpocket Movario on the Dorgesh-Kaan Agility course.",
			new SkillRequirement(Skill.AGILITY, 70),
			new SkillRequirement(Skill.RANGED, 70),
			new SkillRequirement(Skill.STRENGTH, 70),
			new QuestRequirement(Quest.DEATH_TO_THE_DORGESHUUN));
		add("Chop some magic logs at the Mage Training Arena.",
			new SkillRequirement(Skill.WOODCUTTING, 75));
		add("Smith an Adamant platebody down Draynor sewer.",
			new SkillRequirement(Skill.SMITHING, 88));
		add("Craft 140 or more Water runes simultaneously from Essence without the use of Extracts.",
			new SkillRequirement(Skill.RUNECRAFT, 76));
	}
}
