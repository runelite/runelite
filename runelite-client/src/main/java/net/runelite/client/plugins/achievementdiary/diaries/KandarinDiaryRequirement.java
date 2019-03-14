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

public class KandarinDiaryRequirement extends GenericDiaryRequirement
{
	public KandarinDiaryRequirement()
	{
		// EASY
		add("Catch a Mackerel at Catherby.",
			new SkillRequirement(Skill.FISHING, 16));
		add("Plant some Jute seeds in the patch north of McGrubor's Wood.",
			new SkillRequirement(Skill.FARMING, 13));
		add("Defeat one of each elemental in the workshop.",
			new QuestRequirement(Quest.ELEMENTAL_WORKSHOP_I, true));
		add("Cross the Coal truck log shortcut.",
			new SkillRequirement(Skill.AGILITY, 20));

		// MEDIUM
		add("Complete a lap of the Barbarian agility course.",
			new SkillRequirement(Skill.AGILITY, 35),
			new QuestRequirement(Quest.ALFRED_GRIMHANDS_BARCRAWL));
		add("Create a Super Antipoison potion from scratch in the Seers/Catherby Area.",
			new SkillRequirement(Skill.HERBLORE, 48));
		add("Enter the Ranging guild.",
			new SkillRequirement(Skill.RANGED, 40));
		add("Use the grapple shortcut to get from the water obelisk to Catherby shore.",
			new SkillRequirement(Skill.AGILITY, 36),
			new SkillRequirement(Skill.STRENGTH, 22),
			new SkillRequirement(Skill.RANGED, 39));
		add("Catch and cook a Bass in Catherby.",
			new SkillRequirement(Skill.FISHING, 46),
			new SkillRequirement(Skill.COOKING, 43));
		add("Teleport to Camelot.",
			new SkillRequirement(Skill.MAGIC, 45));
		add("String a Maple shortbow in Seers' Village bank.",
			new SkillRequirement(Skill.FLETCHING, 50));
		add("Pick some Limpwurt root from the farming patch in Catherby.",
			new SkillRequirement(Skill.FARMING, 26));
		add("Create a Mind helmet.",
			new QuestRequirement(Quest.ELEMENTAL_WORKSHOP_II));
		add("Kill a Fire Giant inside Baxtorian Waterfall.",
			new QuestRequirement(Quest.WATERFALL_QUEST, true));
		add("Steal from the chest in Hemenster.",
			new SkillRequirement(Skill.THIEVING, 47));
		add("Travel to McGrubor's Wood by Fairy Ring.",
			new QuestRequirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true));
		add("Mine some coal near the coal trucks.",
			new SkillRequirement(Skill.MINING, 30));

		// HARD
		add("Catch a Leaping Sturgeon.",
			new SkillRequirement(Skill.FISHING, 70),
			new SkillRequirement(Skill.AGILITY, 45),
			new SkillRequirement(Skill.STRENGTH, 45));
		add("Complete a lap of the Seers' Village agility course.",
			new SkillRequirement(Skill.AGILITY, 60));
		add("Create a Yew Longbow from scratch around Seers' Village.",
			new SkillRequirement(Skill.WOODCUTTING, 60),
			new SkillRequirement(Skill.FLETCHING, 70),
			new SkillRequirement(Skill.CRAFTING, 10));
		add("Enter the Seers' Village courthouse with piety turned on.",
			new SkillRequirement(Skill.PRAYER, 70),
			new SkillRequirement(Skill.DEFENCE, 70),
			new QuestRequirement(Quest.KINGS_RANSOM));
		add("Charge a Water Orb.",
			new SkillRequirement(Skill.MAGIC, 56));
		add("Burn some Maple logs with a bow in Seers' Village.",
			new SkillRequirement(Skill.FIREMAKING, 65));
		add("Kill a Shadow Hound in the Shadow dungeon.",
			new SkillRequirement(Skill.THIEVING, 53),
			new QuestRequirement(Quest.DESERT_TREASURE, true));
		add("Purchase and equip a granite body from Barbarian Assault.",
			new SkillRequirement(Skill.STRENGTH, 50),
			new SkillRequirement(Skill.DEFENCE, 50));
		add("Have the Seers' estate agent decorate your house with Fancy Stone.",
			new SkillRequirement(Skill.CONSTRUCTION, 50));
		add("Smith an Adamant spear at Otto's Grotto.",
			new SkillRequirement(Skill.SMITHING, 75),
			new QuestRequirement(Quest.TAI_BWO_WANNAI_TRIO));

		// ELITE
		add("Pick some Dwarf weed from the herb patch at Catherby.",
			new SkillRequirement(Skill.FARMING, 79));
		add("Fish and Cook 5 Sharks in Catherby using the Cooking gauntlets.",
			new SkillRequirement(Skill.FISHING, 76),
			new SkillRequirement(Skill.COOKING, 80),
			new QuestRequirement(Quest.FAMILY_CREST));
		add("Mix a Stamina Mix on top of the Seers' Village bank.",
			new SkillRequirement(Skill.HERBLORE, 86),
			new SkillRequirement(Skill.AGILITY, 60));
		add("Smith a Rune Hasta at Otto's Grotto.",
			new SkillRequirement(Skill.SMITHING, 90));
		add("Construct a Pyre ship from Magic Logs.(Requires Chewed Bones.)",
			new SkillRequirement(Skill.FIREMAKING, 85),
			new SkillRequirement(Skill.CRAFTING, 85));
		add("Teleport to Catherby.",
			new SkillRequirement(Skill.MAGIC, 87),
			new QuestRequirement(Quest.LUNAR_DIPLOMACY));
	}
}
