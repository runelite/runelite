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

public class FaladorDiaryRequirement extends GenericDiaryRequirement
{
	public FaladorDiaryRequirement()
	{
		// EASY
		add("Find out what your family crest is from Sir Renitee.",
			new Requirement(Skill.CONSTRUCTION, 16));
		add("Climb over the western Falador wall.",
			new Requirement(Skill.AGILITY, 5));
		add("Smith some Blurite Limbs on Doric's Anvil.",
			new Requirement(Skill.MINING, 10),
			new Requirement(Skill.SMITHING, 13));

		// MEDIUM
		add("Light a Bullseye lantern at the Chemist's in Rimmington.",
			new Requirement(Skill.FIREMAKING, 49));
		add("Telegrab some Wine of Zamorak at the Chaos Temple by the Wilderness.",
			new Requirement(Skill.MAGIC, 33));
		add("Place a Scarecrow in the Falador farming patch.",
			new Requirement(Skill.FARMING, 23));
		add("Kill a Mogre at Mudskipper Point.",
			new Requirement(Skill.SLAYER, 32));
		add("Grapple up and then jump off the north Falador wall.",
			new Requirement(Skill.AGILITY, 11),
			new Requirement(Skill.STRENGTH, 37),
			new Requirement(Skill.RANGED, 19));
		add("Pickpocket a Falador guard.",
			new Requirement(Skill.THIEVING, 40));
		add("Pray at the Altar of Guthix in Taverley whilst wearing full Initiate.",
			new Requirement(Skill.PRAYER, 10),
			new Requirement(Skill.DEFENCE, 20));
		add("Mine some Gold ore at the Crafting Guild.",
			new Requirement(Skill.CRAFTING, 40),
			new Requirement(Skill.MINING, 40));
		add("Squeeze through the crevice in the Dwarven mines.",
			new Requirement(Skill.AGILITY, 42));
		add("Chop and burn some Willow logs in Taverley",
			new Requirement(Skill.WOODCUTTING, 30),
			new Requirement(Skill.FIREMAKING, 30));
		add("Craft a fruit basket on the Falador Farm loom.",
			new Requirement(Skill.CRAFTING, 36));
		add("Teleport to Falador.",
			new Requirement(Skill.MAGIC, 37));

		// HARD
		add("Craft 140 Mind runes simultaneously.",
			new Requirement(Skill.RUNECRAFT, 56));
		add("Change your family crest to the Saradomin symbol.",
			new Requirement(Skill.PRAYER, 70));
		add("Kill a Skeletal Wyvern in the Asgarnia Ice Dungeon.",
			new Requirement(Skill.SLAYER, 72));
		add("Complete a lap of the Falador rooftop agility course.",
			new Requirement(Skill.AGILITY, 50));
		add("Enter the mining guild wearing full prospector.",
			new Requirement(Skill.MINING, 60));
		add("Crack a wall safe within Rogues Den.",
			new Requirement(Skill.THIEVING, 50));
		add("Recharge your prayer in the Port Sarim church while wearing full Proselyte.",
			new Requirement(Skill.DEFENCE, 30));
		add("Equip a dwarven helmet within the dwarven mines.",
			new Requirement(Skill.DEFENCE, 50));

		// ELITE
		add("Craft 252 Air Runes simultaneously.",
			new Requirement(Skill.RUNECRAFT, 88));
		add("Find at least 3 magic roots at once when digging up your magic tree in Falador.",
			new Requirement(Skill.FARMING, 91),
			new Requirement(Skill.WOODCUTTING, 75));
		add("Jump over the strange floor in Taverley dungeon.",
			new Requirement(Skill.AGILITY, 80));
		add("Mix a Saradomin brew in Falador east bank.",
			new Requirement(Skill.HERBLORE, 81));
	}
}
