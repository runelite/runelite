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

public class WildernessDiaryRequirement extends GenericDiaryRequirement
{
	public WildernessDiaryRequirement()
	{
		// EASY
		add("Cast Low Alchemy at the Fountain of Rune.",
			new Requirement(Skill.MAGIC, 21));
		add("Kill an Earth Warrior in the Wilderness beneath Edgeville.",
			new Requirement(Skill.AGILITY, 15));
		add("Mine some Iron ore in the Wilderness.",
			new Requirement(Skill.MINING, 15));

		// MEDIUM
		add("Mine some Mithril ore in the wilderness.",
			new Requirement(Skill.MINING, 55));
		add("Chop some yew logs from a fallen Ent.",
			new Requirement(Skill.WOODCUTTING, 61));
		add("Enter the Wilderness Godwars Dungeon.",
			new Requirement(Skill.AGILITY, 60,
				new Requirement(Skill.STRENGTH, 60))
		);
		add("Complete a lap of the Wilderness Agility course.",
			new Requirement(Skill.AGILITY, 52));
		add("Charge an Earth Orb.",
			new Requirement(Skill.MAGIC, 60));
		add("Kill a Bloodveld in the Wilderness Godwars Dungeon.",
			new Requirement(Skill.SLAYER, 50));
		add("Smith a Golden helmet in the Resource Area.",
			new Requirement(Skill.SMITHING, 50));

		// HARD
		add("Cast one of the 3 God spells against another player in the Wilderness.",
			new Requirement(Skill.MAGIC, 60));
		add("Charge an Air Orb.",
			new Requirement(Skill.MAGIC, 66));
		add("Catch a Black Salamander in the Wilderness.",
			new Requirement(Skill.HUNTER, 67));
		add("Smith an Adamant scimitar in the Resource Area.",
			new Requirement(Skill.SMITHING, 75));
		add("Take the agility shortcut from Trollheim into the Wilderness.",
			new Requirement(Skill.AGILITY, 64));
		add("Kill a Spiritual warrior in the Wilderness Godwars Dungeon.",
			new Requirement(Skill.SLAYER, 68));
		add("Fish some Raw Lava Eel in the Wilderness.",
			new Requirement(Skill.FISHING, 53));

		// ELITE
		add("Teleport to Ghorrock.",
			new Requirement(Skill.MAGIC, 96));
		add("Fish and Cook a Dark Crab in the Resource Area.",
			new Requirement(Skill.FISHING, 85),
			new Requirement(Skill.COOKING, 90));
		add("Smith a rune scimitar from scratch in the Resource Area.",
			new Requirement(Skill.MINING, 85),
			new Requirement(Skill.SMITHING, 90));
		add("Steal from the Rogues' chest.",
			new Requirement(Skill.THIEVING, 84));
		add("Slay a spiritual mage inside the wilderness Godwars Dungeon.",
			new Requirement(Skill.SLAYER, 83),
			new Requirement(Skill.AGILITY, 60,
				new Requirement(Skill.STRENGTH, 60))
		);
		add("Cut and burn some magic logs in the Resource Area.",
			new Requirement(Skill.WOODCUTTING, 75),
			new Requirement(Skill.FIREMAKING, 75));
	}
}
