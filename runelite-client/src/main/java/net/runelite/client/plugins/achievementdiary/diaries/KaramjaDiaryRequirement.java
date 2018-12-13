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

public class KaramjaDiaryRequirement extends GenericDiaryRequirement
{
	public KaramjaDiaryRequirement()
	{
		// EASY
		add("Use the rope swing to travel to the small island north-west of Karamja, where the " +
				"moss giants are.",
			new Requirement(Skill.AGILITY, 10));
		add("Mine some gold from the rocks on the north-west peninsula of Karamja.",
			new Requirement(Skill.MINING, 40));
		add("Explore Cairn Island to the west of Karamja.",
			new Requirement(Skill.AGILITY, 15));

		// MEDIUM
		add("Claim a ticket from the Agility Arena in Brimhaven.",
			new Requirement(Skill.AGILITY, 30));
		add("Earn 100% favour in the village of Tai Bwo Wannai.",
			new Requirement(Skill.WOODCUTTING, 10));
		add("Cook a spider on a stick.",
			new Requirement(Skill.COOKING, 16));
		add("Cut a log from a teak tree.",
			new Requirement(Skill.WOODCUTTING, 35));
		add("Cut a log from a mahogany tree.",
			new Requirement(Skill.WOODCUTTING, 50));
		add("Catch a karambwan.",
			new Requirement(Skill.FISHING, 65));
		add("Grow a healthy fruit tree in the patch near Brimhaven.",
			new Requirement(Skill.FARMING, 27));
		add("Trap a horned graahk.",
			new Requirement(Skill.HUNTER, 41));
		add("Chop the vines to gain deeper access to Brimhaven Dungeon.",
			new Requirement(Skill.WOODCUTTING, 10));
		add("Cross the lava using the stepping stones within Brimhaven Dungeon.",
			new Requirement(Skill.AGILITY, 12));
		add("Climb the stairs within Brimhaven Dungeon.",
			new Requirement(Skill.WOODCUTTING, 10));
		add("Mine a red topaz from a gem rock.",
			new Requirement(Skill.MINING, 40));

		// HARD
		add("Craft some nature runes.",
			new Requirement(Skill.RUNECRAFT, 44));
		add("Cook a karambwan thoroughly.",
			new Requirement(Skill.COOKING, 30));
		add("Kill a deathwing in the dungeon under the Kharazi Jungle.",
			new Requirement(Skill.WOODCUTTING, 15),
			new Requirement(Skill.STRENGTH, 50),
			new Requirement(Skill.AGILITY, 50),
			new Requirement(Skill.THIEVING, 50),
			new Requirement(Skill.MINING, 52));
		add("Use the crossbow short cut south of the volcano.",
			new Requirement(Skill.AGILITY, 53),
			new Requirement(Skill.RANGED, 42),
			new Requirement(Skill.STRENGTH, 21));
		add("Collect 5 palm leaves.",
			new Requirement(Skill.WOODCUTTING, 15));
		add("Be assigned a Slayer task by Duradel north of Shilo Village.",
			new Requirement("Combat", 100),
			new Requirement(Skill.SLAYER, 50));
		add("Kill a metal dragon in Brimhaven Dungeon.",
			new Requirement(Skill.AGILITY, 12),
			new Requirement(Skill.WOODCUTTING, 34));

		// ELITE
		add("Craft 56 Nature runes at once.",
			new Requirement(Skill.RUNECRAFT, 91));
		add("Check the health of a palm tree in Brimhaven.",
			new Requirement(Skill.FARMING, 68));
		add("Create an antivenom potion whilst standing in the horse shoe mine.",
			new Requirement(Skill.HERBLORE, 87));
		add("Check the health of your Calquat tree patch.",
			new Requirement(Skill.FARMING, 72));
	}
}
