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

public class MorytaniaDiaryRequirement extends GenericDiaryRequirement
{
	public MorytaniaDiaryRequirement()
	{
		// EASY
		add("Craft any Snelm from scratch in Morytania.",
			new Requirement(Skill.CRAFTING, 15));
		add("Cook a thin Snail on the Port Phasmatys range.",
			new Requirement(Skill.COOKING, 12));
		add("Get a slayer task from Mazchna.",
			new Requirement("Combat", 20));
		add("Kill a Banshee in the Slayer Tower.",
			new Requirement(Skill.SLAYER, 15));
		add("Place a Scarecrow in the Morytania flower patch.",
			new Requirement(Skill.FARMING, 23));

		// MEDIUM
		add("Catch a swamp lizard.",
			new Requirement(Skill.HUNTER, 29));
		add("Complete a lap of the Canifis agility course.",
			new Requirement(Skill.AGILITY, 40));
		add("Obtain some Bark from a Hollow tree.",
			new Requirement(Skill.WOODCUTTING, 45));
		add("Kill a Terror Dog.",
			new Requirement(Skill.SLAYER, 40));
		add("Complete a game of trouble brewing.",
			new Requirement(Skill.COOKING, 40));
		add("Make a batch of cannonballs at the Port Phasmatys furnace.",
			new Requirement(Skill.SMITHING, 35));
		add("Kill a Fever Spider on Braindeath Island.",
			new Requirement(Skill.SLAYER, 42));
		add("Mix a Guthix Balance potion while in Morytania.",
			new Requirement(Skill.HERBLORE, 36));

		// HARD
		add("Enter the Kharyrll portal in your POH.",
			new Requirement(Skill.MAGIC, 66),
			new Requirement(Skill.CONSTRUCTION, 50));
		add("Climb the advanced spike chain within Slayer Tower.",
			new Requirement(Skill.AGILITY, 71));
		add("Harvest some Watermelon from the Allotment patch on Harmony Island.",
			new Requirement(Skill.FARMING, 47));
		add("Chop and burn some mahogany logs on Mos Le'Harmless.",
			new Requirement(Skill.WOODCUTTING, 50),
			new Requirement(Skill.FIREMAKING, 50));
		add("Kill a Cave Horror.",
			new Requirement(Skill.SLAYER, 58));
		add("Harvest some Bittercap Mushrooms from the patch in Canifis.",
			new Requirement(Skill.FARMING, 53));
		add("Pray at the Altar of Nature with Piety activated.",
			new Requirement(Skill.PRAYER, 70),
			new Requirement(Skill.DEFENCE, 70));
		add("Use the shortcut to get to the bridge over the Salve.",
			new Requirement(Skill.AGILITY, 65));
		add("Mine some Mithril ore in the Abandoned Mine.",
			new Requirement(Skill.MINING, 55));

		// ELITE
		add("Catch a shark in Burgh de Rott with your bare hands.",
			new Requirement(Skill.FISHING, 96),
			new Requirement(Skill.STRENGTH, 76));
		add("Cremate any Shade remains on a Magic or Redwood pyre.",
			new Requirement(Skill.FIREMAKING, 80));
		add("Fertilize the Morytania herb patch using Lunar Magic.",
			new Requirement(Skill.MAGIC, 83));
		add("Craft a Black dragonhide body in Canifis bank.",
			new Requirement(Skill.CRAFTING, 84));
		add("Kill an Abyssal demon in the Slayer Tower.",
			new Requirement(Skill.SLAYER, 85));
		add("Loot the Barrows chest while wearing any complete barrows set.",
			new Requirement(Skill.DEFENCE, 70),
			new Requirement(Skill.ATTACK, 70,
				new Requirement(Skill.STRENGTH, 70),
				new Requirement(Skill.RANGED, 70),
				new Requirement(Skill.MAGIC, 70))
		);
	}
}
