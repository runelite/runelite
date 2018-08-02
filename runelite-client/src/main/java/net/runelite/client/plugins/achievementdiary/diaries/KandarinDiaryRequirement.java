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
import net.runelite.client.plugins.achievementdiary.Requirement;

public class KandarinDiaryRequirement extends GenericDiaryRequirement
{
	public KandarinDiaryRequirement()
	{
		// EASY
		add("Catch a Mackerel at Catherby.",
			new Requirement(Skill.FISHING, 16));
		add("Plant some Jute seeds in the patch north of McGrubor's Wood.",
			new Requirement(Skill.FARMING, 13));
		add("Cross the Coal truck log shortcut.",
			new Requirement(Skill.AGILITY, 20));

		// MEDIUM
		add("Complete a lap of the Barbarian agility course.",
			new Requirement(Skill.AGILITY, 35));
		add("Create a Super Antipoison potion from scratch in the Seers/Catherby Area.",
			new Requirement(Skill.HERBLORE, 48));
		add("Enter the Ranging guild.",
			new Requirement(Skill.RANGED, 40));
		add("Use the grapple shortcut to get from the water obelisk to Catherby shore.",
			new Requirement(Skill.AGILITY, 36),
			new Requirement(Skill.STRENGTH, 22),
			new Requirement(Skill.RANGED, 39));
		add("Catch and cook a Bass in Catherby.",
			new Requirement(Skill.FISHING, 46),
			new Requirement(Skill.COOKING, 43));
		add("Teleport to Camelot.",
			new Requirement(Skill.MAGIC, 45));
		add("String a Maple shortbow in Seers' Village bank.",
			new Requirement(Skill.FLETCHING, 50));
		add("Pick some Limpwurt root from the farming patch in Catherby.",
			new Requirement(Skill.FARMING, 26));
		add("Steal from the chest in Hemenster.",
			new Requirement(Skill.THIEVING, 47));
		add("Mine some coal near the coal trucks.",
			new Requirement(Skill.MINING, 30));

		// HARD
		add("Catch a Leaping Sturgeon.",
			new Requirement(Skill.FISHING, 70),
			new Requirement(Skill.AGILITY, 45),
			new Requirement(Skill.STRENGTH, 45));
		add("Complete a lap of the Seers' Village agility course.",
			new Requirement(Skill.AGILITY, 60));
		add("Create a Yew Longbow from scratch around Seers' Village.",
			new Requirement(Skill.WOODCUTTING, 60),
			new Requirement(Skill.FLETCHING, 70),
			new Requirement(Skill.CRAFTING, 10));
		add("Enter the Seers' Village courthouse with piety turned on.",
			new Requirement(Skill.PRAYER, 70),
			new Requirement(Skill.DEFENCE, 70));
		add("Charge a Water Orb.",
			new Requirement(Skill.MAGIC, 56));
		add("Burn some Maple logs with a bow in Seers' Village.",
			new Requirement(Skill.FIREMAKING, 65));
		add("Purchase and equip a granite body from Barbarian Assault.",
			new Requirement(Skill.STRENGTH, 50),
			new Requirement(Skill.DEFENCE, 50));
		add("Have the Seers' estate agent decorate your house with Fancy Stone.",
			new Requirement(Skill.CONSTRUCTION, 50));
		add("Smith an Adamant spear at Otto's Grotto.",
			new Requirement(Skill.SMITHING, 75));

		// ELITE
		add("Pick some Dwarf weed from the herb patch at Catherby.",
			new Requirement(Skill.FARMING, 79));
		add("Fish and Cook 5 Sharks in Catherby using the Cooking gauntlets.",
			new Requirement(Skill.FISHING, 76),
			new Requirement(Skill.COOKING, 80));
		add("Mix a Stamina Mix on top of the Seers' Village bank.",
			new Requirement(Skill.HERBLORE, 86),
			new Requirement(Skill.AGILITY, 60));
		add("Smith a Rune Hasta at Otto's Grotto.",
			new Requirement(Skill.SMITHING, 90));
		add("Construct a Pyre ship from Magic Logs.(Requires Chewed Bones.)",
			new Requirement(Skill.FIREMAKING, 85),
			new Requirement(Skill.CRAFTING, 85));
		add("Teleport to Catherby.",
			new Requirement(Skill.MAGIC, 87));
	}
}
