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

public class FaladorDiaryRequirement extends GenericDiaryRequirement
{
	public FaladorDiaryRequirement()
	{
		// EASY
		add("Find out what your family crest is from Sir Renitee.",
			new SkillRequirement(Skill.CONSTRUCTION, 16));
		add("Climb over the western Falador wall.",
			new SkillRequirement(Skill.AGILITY, 5));
		add("Make a mind tiara.",
			new QuestRequirement(Quest.RUNE_MYSTERIES));
		add("Smith some Blurite Limbs on Doric's Anvil.",
			new SkillRequirement(Skill.MINING, 10),
			new SkillRequirement(Skill.SMITHING, 13),
			new QuestRequirement(Quest.THE_KNIGHTS_SWORD),
			new QuestRequirement(Quest.DORICS_QUEST));

		// MEDIUM
		add("Light a Bullseye lantern at the Chemist's in Rimmington.",
			new SkillRequirement(Skill.FIREMAKING, 49));
		add("Telegrab some Wine of Zamorak at the Chaos Temple by the Wilderness.",
			new SkillRequirement(Skill.MAGIC, 33));
		add("Place a Scarecrow in the Falador farming patch.",
			new SkillRequirement(Skill.FARMING, 23));
		add("Kill a Mogre at Mudskipper Point.",
			new SkillRequirement(Skill.SLAYER, 32),
			new QuestRequirement(Quest.SKIPPY_AND_THE_MOGRES));
		add("Visit the Port Sarim Rat Pits.",
			new QuestRequirement(Quest.RATCATCHERS, true));
		add("Grapple up and then jump off the north Falador wall.",
			new SkillRequirement(Skill.AGILITY, 11),
			new SkillRequirement(Skill.STRENGTH, 37),
			new SkillRequirement(Skill.RANGED, 19));
		add("Pickpocket a Falador guard.",
			new SkillRequirement(Skill.THIEVING, 40));
		add("Pray at the Altar of Guthix in Taverley whilst wearing full Initiate.",
			new SkillRequirement(Skill.PRAYER, 10),
			new SkillRequirement(Skill.DEFENCE, 20),
			new QuestRequirement(Quest.RECRUITMENT_DRIVE));
		add("Mine some Gold ore at the Crafting Guild.",
			new SkillRequirement(Skill.CRAFTING, 40),
			new SkillRequirement(Skill.MINING, 40));
		add("Squeeze through the crevice in the Dwarven mines.",
			new SkillRequirement(Skill.AGILITY, 42));
		add("Chop and burn some Willow logs in Taverley",
			new SkillRequirement(Skill.WOODCUTTING, 30),
			new SkillRequirement(Skill.FIREMAKING, 30));
		add("Craft a fruit basket on the Falador Farm loom.",
			new SkillRequirement(Skill.CRAFTING, 36));
		add("Teleport to Falador.",
			new SkillRequirement(Skill.MAGIC, 37));

		// HARD
		add("Craft 140 Mind runes simultaneously.",
			new SkillRequirement(Skill.RUNECRAFT, 56));
		add("Change your family crest to the Saradomin symbol.",
			new SkillRequirement(Skill.PRAYER, 70));
		add("Kill a Skeletal Wyvern in the Asgarnia Ice Dungeon.",
			new SkillRequirement(Skill.SLAYER, 72));
		add("Complete a lap of the Falador rooftop agility course.",
			new SkillRequirement(Skill.AGILITY, 50));
		add("Enter the mining guild wearing full prospector.",
			new SkillRequirement(Skill.MINING, 60));
		add("Kill the Blue Dragon under the Heroes' Guild.",
			new QuestRequirement(Quest.HEROES_QUEST));
		add("Crack a wall safe within Rogues Den.",
			new SkillRequirement(Skill.THIEVING, 50));
		add("Recharge your prayer in the Port Sarim church while wearing full Proselyte.",
			new SkillRequirement(Skill.DEFENCE, 30),
			new QuestRequirement(Quest.THE_SLUG_MENACE));
		add("Equip a dwarven helmet within the dwarven mines.",
			new SkillRequirement(Skill.DEFENCE, 50),
			new QuestRequirement(Quest.GRIM_TALES));

		// ELITE
		add("Craft 252 Air Runes simultaneously.",
			new SkillRequirement(Skill.RUNECRAFT, 88));
		add("Purchase a White 2h Sword from Sir Vyvin.",
			new QuestRequirement(Quest.WANTED));
		add("Find at least 3 magic roots at once when digging up your magic tree in Falador.",
			new SkillRequirement(Skill.FARMING, 91),
			new SkillRequirement(Skill.WOODCUTTING, 75));
		add("Jump over the strange floor in Taverley dungeon.",
			new SkillRequirement(Skill.AGILITY, 80));
		add("Mix a Saradomin brew in Falador east bank.",
			new SkillRequirement(Skill.HERBLORE, 81));
	}
}
