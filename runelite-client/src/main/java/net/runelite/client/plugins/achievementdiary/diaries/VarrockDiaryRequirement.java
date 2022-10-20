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
import net.runelite.client.plugins.achievementdiary.QuestPointRequirement;
import net.runelite.client.plugins.achievementdiary.QuestRequirement;
import net.runelite.client.plugins.achievementdiary.SkillRequirement;

public class VarrockDiaryRequirement extends GenericDiaryRequirement
{
	public VarrockDiaryRequirement()
	{
		// EASY
		add("Have Aubury teleport you to the Essence mine.",
			new QuestRequirement(Quest.RUNE_MYSTERIES));
		add("Mine some Iron in the south east mining patch near Varrock.",
			new SkillRequirement(Skill.MINING, 15));
		add("Jump over the fence south of Varrock.",
			new SkillRequirement(Skill.AGILITY, 13));
		add("Spin a bowl on the pottery wheel and fire it in the oven in Barb Village.",
			new SkillRequirement(Skill.CRAFTING, 8));
		add("Craft some Earth runes from Essence.",
			new SkillRequirement(Skill.RUNECRAFT, 9));
		add("Catch some trout in the River Lum at Barbarian Village.",
			new SkillRequirement(Skill.FISHING, 20));
		add("Steal from the Tea stall in Varrock.",
			new SkillRequirement(Skill.THIEVING, 5));

		// MEDIUM
		add("Enter the Champions' Guild.",
			new QuestPointRequirement(32));
		add("Select a colour for your kitten.",
			new QuestRequirement(Quest.GARDEN_OF_TRANQUILLITY, true),
			new QuestRequirement(Quest.GERTRUDES_CAT));
		add("Use the spirit tree north of Varrock.",
			new QuestRequirement(Quest.TREE_GNOME_VILLAGE));
		add("Enter the Tolna dungeon after completing A Soul's Bane.",
			new QuestRequirement(Quest.A_SOULS_BANE));
		add("Teleport to the digsite using a Digsite pendant.",
			new QuestRequirement(Quest.THE_DIG_SITE));
		add("Cast the teleport to Varrock spell.",
			new SkillRequirement(Skill.MAGIC, 25));
		add("Get a Slayer task from Vannaka.",
			new CombatLevelRequirement(40));
		add("Pick a White tree fruit.",
			new SkillRequirement(Skill.FARMING, 25),
			new QuestRequirement(Quest.GARDEN_OF_TRANQUILLITY));
		add("Use the balloon to travel from Varrock.",
			new SkillRequirement(Skill.FIREMAKING, 40),
			new QuestRequirement(Quest.ENLIGHTENED_JOURNEY));
		add("Complete a lap of the Varrock Agility course.",
			new SkillRequirement(Skill.AGILITY, 30));

		// HARD
		add("Trade furs with the Fancy Dress Seller for a spottier cape and equip it.",
			new SkillRequirement(Skill.HUNTER, 66));
		add("Make a Waka Canoe near Edgeville.",
			new SkillRequirement(Skill.WOODCUTTING, 57));
		add("Teleport to Paddewwa.",
			new SkillRequirement(Skill.MAGIC, 54),
			new QuestRequirement(Quest.DESERT_TREASURE));
		add("Chop some yew logs in Varrock and burn them at the top of the Varrock church.",
			new SkillRequirement(Skill.WOODCUTTING, 60),
			new SkillRequirement(Skill.FIREMAKING, 60));
		add("Have the Varrock estate agent decorate your house with Fancy Stone.",
			new SkillRequirement(Skill.CONSTRUCTION, 50));
		add("Collect at least 2 yew roots from the Tree patch in Varrock Palace.",
			new SkillRequirement(Skill.WOODCUTTING, 60),
			new SkillRequirement(Skill.FARMING, 68));
		add("Pray at the altar in Varrock palace with Smite active.",
			new SkillRequirement(Skill.PRAYER, 52));
		add("Squeeze through the obstacle pipe in Edgeville dungeon.",
			new SkillRequirement(Skill.AGILITY, 51));

		// ELITE
		add("Create a super combat potion in Varrock west bank.",
			new SkillRequirement(Skill.HERBLORE, 90),
			new QuestRequirement(Quest.DRUIDIC_RITUAL));
		add("Use Lunar magic to make 20 mahogany planks at the Lumberyard.",
			new SkillRequirement(Skill.MAGIC, 86),
			new QuestRequirement(Quest.DREAM_MENTOR));
		add("Bake a summer pie in the Cooking Guild.",
			new SkillRequirement(Skill.COOKING, 95));
		add("Smith and fletch ten rune darts within Varrock.",
			new SkillRequirement(Skill.SMITHING, 89),
			new SkillRequirement(Skill.FLETCHING, 81),
			new QuestRequirement(Quest.THE_TOURIST_TRAP));
		add("Craft 100 or more earth runes simultaneously from Essence.",
			new SkillRequirement(Skill.RUNECRAFT, 78),
			new QuestRequirement(Quest.RUNE_MYSTERIES));
	}
}
