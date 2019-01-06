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

public class LumbridgeDiaryRequirement extends GenericDiaryRequirement
{
	public LumbridgeDiaryRequirement()
	{
		// EASY
		add("Complete a lap of the Draynor Village agility course.",
			new Requirement(Skill.AGILITY, 10));
		add("Slay a Cave bug beneath Lumbridge Swamp.",
			new Requirement(Skill.SLAYER, 7));
		add("Have Sedridor teleport you to the Essence Mine.",
			new Requirement(Quest.RUNE_MYSTERIES));
		add("Craft some water runes.",
			new Requirement(Skill.RUNECRAFT, 5),
			new Requirement(Quest.RUNE_MYSTERIES));
		add("Chop and burn some oak logs in Lumbridge.",
			new Requirement(Skill.WOODCUTTING, 15),
			new Requirement(Skill.FIREMAKING, 15));
		add("Catch some Anchovies in Al Kharid.",
			new Requirement(Skill.FISHING, 15));
		add("Bake some Bread on the Lumbridge kitchen range.",
			new Requirement(Quest.COOKS_ASSISTANT));
		add("Mine some Iron ore at the Al Kharid mine.",
			new Requirement(Skill.MINING, 15));

		// MEDIUM
		add("Complete a lap of the Al Kharid agility course.",
			new Requirement(Skill.AGILITY, 20));
		add("Grapple across the River Lum.",
			new Requirement(Skill.AGILITY, 8),
			new Requirement(Skill.STRENGTH, 19),
			new Requirement(Skill.RANGED, 37));
		add("Purchase an upgraded device from Ava.",
			new Requirement(Skill.RANGED, 50),
			new Requirement(Quest.ANIMAL_MAGNETISM));
		add("Travel to the Wizards' Tower by Fairy ring.",
			new Requirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true));
		add("Cast the teleport to Lumbridge spell.",
			new Requirement(Skill.MAGIC, 31));
		add("Catch some Salmon in Lumbridge.",
			new Requirement(Skill.FISHING, 30));
		add("Craft a coif in the Lumbridge cow pen.",
			new Requirement(Skill.CRAFTING, 38));
		add("Chop some willow logs in Draynor Village.",
			new Requirement(Skill.WOODCUTTING, 30));
		add("Pickpocket Martin the Master Gardener.",
			new Requirement(Skill.THIEVING, 38));
		add("Get a slayer task from Chaeldar.",
			new Requirement("Combat", 70),
			new Requirement(Quest.LOST_CITY));
		add("Catch an Essence or Eclectic impling in Puro-Puro.",
			new Requirement(Skill.HUNTER, 42),
			new Requirement(Quest.LOST_CITY));
		add("Craft some Lava runes at the fire altar in Al Kharid.",
			new Requirement(Skill.RUNECRAFT, 23),
			new Requirement(Quest.RUNE_MYSTERIES));

		// HARD
		add("Cast Bones to Peaches in Al Kharid palace.",
			new Requirement(Skill.MAGIC, 60));
		add("Squeeze past the jutting wall on your way to the cosmic altar.",
			new Requirement(Skill.AGILITY, 46),
			new Requirement(Quest.LOST_CITY));
		add("Craft 56 Cosmic runes simultaneously.",
			new Requirement(Skill.RUNECRAFT, 59),
			new Requirement(Quest.LOST_CITY));
		add("Travel from Lumbridge to Edgeville on a Waka Canoe.",
			new Requirement(Skill.WOODCUTTING, 57));
		add("Collect at least 100 Tears of Guthix in one visit.",
			new Requirement(Quest.TEARS_OF_GUTHIX));
		add("Take the train from Dorgesh-Kaan to Keldagrim.",
			new Requirement(Quest.ANOTHER_SLICE_OF_HAM));
		add("Purchase some Barrows gloves from the Lumbridge bank chest.",
			new Requirement(Quest.RECIPE_FOR_DISASTER));
		add("Pick some Belladonna from the farming patch at Draynor Manor.",
			new Requirement(Skill.FARMING, 63));
		add("Light your mining helmet in the Lumbridge castle basement.",
			new Requirement(Skill.FIREMAKING, 65));
		add("Recharge your prayer at Clan Wars with Smite activated.",
			new Requirement(Skill.PRAYER, 52));
		add("Craft, string and enchant an Amulet of Power in Lumbridge.",
			new Requirement(Skill.CRAFTING, 70),
			new Requirement(Skill.MAGIC, 57));

		// ELITE
		add("Steal from a Dorgesh-Kaan rich chest.",
			new Requirement(Skill.THIEVING, 78),
			new Requirement(Quest.DEATH_TO_THE_DORGESHUUN));
		add("Pickpocket Movario on the Dorgesh-Kaan Agility course.",
			new Requirement(Skill.AGILITY, 70),
			new Requirement(Skill.RANGED, 70),
			new Requirement(Skill.STRENGTH, 70),
			new Requirement(Quest.DEATH_TO_THE_DORGESHUUN));
		add("Chop some magic logs at the Mage Training Arena.",
			new Requirement(Skill.WOODCUTTING, 75));
		add("Smith an Adamant platebody down Draynor sewer.",
			new Requirement(Skill.SMITHING, 88));
		add("Craft 140 or more Water runes at once.",
			new Requirement(Skill.RUNECRAFT, 76),
			new Requirement(Quest.RUNE_MYSTERIES));
	}
}
