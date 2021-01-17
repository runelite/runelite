/*
 * Copyright (c) 2020, Jordan Zomerlei <<https://github.com/JZomerlei>
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

package net.runelite.client.plugins.questlist.quests;

import net.runelite.api.Favour;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.client.plugins.questlist.GenericQuestRequirement;
import net.runelite.client.util.requirements.CombatLevelRequirement;
import net.runelite.client.util.requirements.FavourRequirement;
import net.runelite.client.util.requirements.KudosRequirement;
import net.runelite.client.util.requirements.OrRequirement;
import net.runelite.client.util.requirements.QuestPointRequirement;
import net.runelite.client.util.requirements.QuestStatusRequirement;
import net.runelite.client.util.requirements.SkillRequirement;

public class QuestRequirement extends GenericQuestRequirement
{
	public QuestRequirement()
	{
		// quests
		add(Quest.DORICS_QUEST,
			new SkillRequirement(Skill.MINING, 15));

		add(Quest.BLACK_KNIGHTS_FORTRESS,
			new QuestPointRequirement(12));

		add(Quest.THE_KNIGHTS_SWORD,
			new SkillRequirement(Skill.MINING, 10));

		add(Quest.DRAGON_SLAYER_I,
			new QuestPointRequirement(32),
			new SkillRequirement(Skill.CRAFTING, 8));

		add(Quest.LOST_CITY,
			new SkillRequirement(Skill.CRAFTING, 31),
			new SkillRequirement(Skill.WOODCUTTING, 36));

		add(Quest.HEROES_QUEST,
			new QuestStatusRequirement(Quest.SHIELD_OF_ARRAV, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.LOST_CITY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.MERLINS_CRYSTAL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.DRAGON_SLAYER_I, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.DRUIDIC_RITUAL, QuestState.FINISHED),
			new SkillRequirement(Skill.WOODCUTTING, 36));

		add(Quest.SCORPION_CATCHER,
			new QuestStatusRequirement(Quest.ALFRED_GRIMHANDS_BARCRAWL),
			new SkillRequirement(Skill.PRAYER, 31));

		add(Quest.FAMILY_CREST,
			new SkillRequirement(Skill.MINING, 40),
			new SkillRequirement(Skill.SMITHING, 40),
			new SkillRequirement(Skill.MAGIC, 59),
			new SkillRequirement(Skill.CRAFTING, 40));

		add(Quest.TRIBAL_TOTEM,
			new SkillRequirement(Skill.THIEVING, 21));

		add(Quest.FISHING_CONTEST,
			new SkillRequirement(Skill.FISHING, 10));

		add(Quest.TEMPLE_OF_IKOV,
			new SkillRequirement(Skill.THIEVING, 42),
			new SkillRequirement(Skill.RANGED, 40));

		add(Quest.HOLY_GRAIL,
			new QuestStatusRequirement(Quest.MERLINS_CRYSTAL),
			new SkillRequirement(Skill.ATTACK, 20));

		add(Quest.SEA_SLUG,
			new SkillRequirement(Skill.FIREMAKING, 30));

		add(Quest.BIOHAZARD,
			new QuestStatusRequirement(Quest.PLAGUE_CITY, QuestState.FINISHED));

		add(Quest.JUNGLE_POTION,
			new QuestStatusRequirement(Quest.DRUIDIC_RITUAL, QuestState.FINISHED));

		add(Quest.THE_GRAND_TREE,
			new SkillRequirement(Skill.AGILITY, 25));

		add(Quest.SHILO_VILLAGE,
			new QuestStatusRequirement(Quest.JUNGLE_POTION, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 20),
			new SkillRequirement(Skill.AGILITY, 32),
			new SkillRequirement(Skill.SMITHING, 4));

		add(Quest.UNDERGROUND_PASS,
			new QuestStatusRequirement(Quest.BIOHAZARD),
			new SkillRequirement(Skill.RANGED, 32));
		add(Quest.THE_TOURIST_TRAP,
			new SkillRequirement(Skill.FLETCHING, 10),
			new SkillRequirement(Skill.SMITHING, 20));

		add(Quest.WATCHTOWER,
			new SkillRequirement(Skill.MAGIC, 15),
			new SkillRequirement(Skill.THIEVING, 15),
			new SkillRequirement(Skill.AGILITY, 25),
			new SkillRequirement(Skill.HERBLORE, 14),
			new SkillRequirement(Skill.MINING, 40));

		add(Quest.THE_DIG_SITE,
			new QuestStatusRequirement(Quest.DRUIDIC_RITUAL),
			new SkillRequirement(Skill.AGILITY, 10),
			new SkillRequirement(Skill.HERBLORE, 10),
			new SkillRequirement(Skill.THIEVING, 25));

		add(Quest.LEGENDS_QUEST,
			new QuestStatusRequirement(Quest.FAMILY_CREST),
			new QuestStatusRequirement(Quest.HEROES_QUEST),
			new QuestStatusRequirement(Quest.SHILO_VILLAGE),
			new QuestStatusRequirement(Quest.UNDERGROUND_PASS),
			new QuestStatusRequirement(Quest.WATERFALL_QUEST),
			new QuestPointRequirement(107),
			new SkillRequirement(Skill.AGILITY, 50),
			new SkillRequirement(Skill.CRAFTING, 50),
			new SkillRequirement(Skill.HERBLORE, 45),
			new SkillRequirement(Skill.MAGIC, 56),
			new SkillRequirement(Skill.MINING, 52),
			new SkillRequirement(Skill.PRAYER, 42),
			new SkillRequirement(Skill.SMITHING, 50),
			new SkillRequirement(Skill.STRENGTH, 50),
			new SkillRequirement(Skill.THIEVING, 50),
			new SkillRequirement(Skill.WOODCUTTING, 50));

		add(Quest.BIG_CHOMPY_BIRD_HUNTING,
			new SkillRequirement(Skill.FLETCHING, 5),
			new SkillRequirement(Skill.COOKING, 30),
			new SkillRequirement(Skill.RANGED, 30));

		add(Quest.ELEMENTAL_WORKSHOP_I,
			new SkillRequirement(Skill.MINING, 20),
			new SkillRequirement(Skill.SMITHING, 20),
			new SkillRequirement(Skill.CRAFTING, 20));

		add(Quest.NATURE_SPIRIT,
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL),
			new QuestStatusRequirement(Quest.THE_RESTLESS_GHOST),
			new SkillRequirement(Skill.CRAFTING, 18));


		add(Quest.TROLL_STRONGHOLD,
			new QuestStatusRequirement(Quest.JUNGLE_POTION),
			new SkillRequirement(Skill.FISHING, 5),
			new SkillRequirement(Skill.COOKING, 30),
			new SkillRequirement(Skill.AGILITY, 15));

		add(Quest.TAI_BWO_WANNAI_TRIO,
			new QuestStatusRequirement(Quest.UNDERGROUND_PASS),
			new SkillRequirement(Skill.AGILITY, 56),
			new SkillRequirement(Skill.CRAFTING, 10));

		add(Quest.REGICIDE,
			new QuestStatusRequirement(Quest.DEATH_PLATEAU),
			new SkillRequirement(Skill.AGILITY, 15));

		add(Quest.EADGARS_RUSE,
			new QuestStatusRequirement(Quest.DRUIDIC_RITUAL),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD),
			new SkillRequirement(Skill.HERBLORE, 31));

		add(Quest.SHADES_OF_MORTTON,
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL),
			new SkillRequirement(Skill.FLETCHING, 25),
			new SkillRequirement(Skill.WOODCUTTING, 40),
			new SkillRequirement(Skill.CRAFTING, 40));

		add(Quest.THE_FREMENNIK_TRIALS,
			new SkillRequirement(Skill.CRAFTING, 20),
			new SkillRequirement(Skill.HERBLORE, 15),
			new SkillRequirement(Skill.FIREMAKING, 5));

		add(Quest.THE_FREMENNIK_TRIALS,
			new QuestStatusRequirement(Quest.ALFRED_GRIMHANDS_BARCRAWL, QuestState.FINISHED),
			new SkillRequirement(Skill.AGILITY, 35));

		add(Quest.THRONE_OF_MISCELLANIA,
			new QuestStatusRequirement(Quest.HEROES_QUEST, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED),
			new OrRequirement(new SkillRequirement(Skill.WOODCUTTING, 45),
				new SkillRequirement(Skill.FARMING, 10),
				new SkillRequirement(Skill.MINING, 30),
				new SkillRequirement(Skill.FISHING, 35)));

		add(Quest.THE_FREMENNIK_TRIALS,
			new QuestStatusRequirement(Quest.THE_GRAND_TREE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.TREE_GNOME_VILLAGE, QuestState.FINISHED));

		add(Quest.HAUNTED_MINE,
			new SkillRequirement(Skill.AGILITY, 15),
			new SkillRequirement(Skill.CRAFTING, 35),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED));

		add(Quest.TROLL_ROMANCE,
			new SkillRequirement(Skill.AGILITY, 28),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD, QuestState.FINISHED));

		add(Quest.IN_SEARCH_OF_THE_MYREQUE,
			new SkillRequirement(Skill.AGILITY, 25),
			new QuestStatusRequirement(Quest.NATURE_SPIRIT, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_RESTLESS_GHOST, QuestState.FINISHED));

		add(Quest.CREATURE_OF_FENKENSTRAIN,
			new SkillRequirement(Skill.CRAFTING, 20),
			new SkillRequirement(Skill.THIEVING, 25),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_RESTLESS_GHOST, QuestState.FINISHED));

		add(Quest.ROVING_ELVES,
			new SkillRequirement(Skill.AGILITY, 56),
			new QuestStatusRequirement(Quest.REGICIDE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.WATERFALL_QUEST, QuestState.FINISHED));

		add(Quest.GHOSTS_AHOY,
			new SkillRequirement(Skill.AGILITY, 25),
			new SkillRequirement(Skill.COOKING, 20),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_RESTLESS_GHOST, QuestState.FINISHED));

		add(Quest.ONE_SMALL_FAVOUR,
			new SkillRequirement(Skill.AGILITY, 36),
			new SkillRequirement(Skill.CRAFTING, 25),
			new SkillRequirement(Skill.HERBLORE, 18),
			new SkillRequirement(Skill.SMITHING, 30),
			new QuestStatusRequirement(Quest.RUNE_MYSTERIES, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.SHILO_VILLAGE, QuestState.FINISHED));

		add(Quest.MOUNTAIN_DAUGHTER,
			new SkillRequirement(Skill.AGILITY, 20));

		add(Quest.BETWEEN_A_ROCK,
			new SkillRequirement(Skill.DEFENCE, 30),
			new SkillRequirement(Skill.FARMING, 40),
			new SkillRequirement(Skill.SMITHING, 50),
			new QuestStatusRequirement(Quest.DWARF_CANNON, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.FISHING_CONTEST, QuestState.FINISHED));

		add(Quest.THE_FEUD,
			new SkillRequirement(Skill.THIEVING, 30));

		add(Quest.THE_GOLEM,
			new SkillRequirement(Skill.CRAFTING, 20),
			new SkillRequirement(Skill.THIEVING, 25));

		add(Quest.DESERT_TREASURE,
			new SkillRequirement(Skill.THIEVING, 30),
			new SkillRequirement(Skill.FIREMAKING, 40),
			new OrRequirement(new SkillRequirement(Skill.SLAYER, 10), new QuestStatusRequirement(Quest.PLAGUE_CITY, QuestState.FINISHED)),
			new SkillRequirement(Skill.MAGIC, 50),
			new QuestStatusRequirement(Quest.THE_DIG_SITE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_TOURIST_TRAP, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.WATERFALL_QUEST, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.TEMPLE_OF_IKOV, QuestState.FINISHED));

		add(Quest.ICTHLARINS_LITTLE_HELPER,
			new QuestStatusRequirement(Quest.GERTRUDES_CAT, QuestState.FINISHED));

		add(Quest.TEARS_OF_GUTHIX,
			new QuestPointRequirement(43),
			new SkillRequirement(Skill.FIREMAKING, 49),
			new SkillRequirement(Skill.CRAFTING, 20),
			new SkillRequirement(Skill.MINING, 20));


		add(Quest.ZOGRE_FLESH_EATERS,
			new SkillRequirement(Skill.SMITHING, 4),
			new SkillRequirement(Skill.HERBLORE, 8),
			new SkillRequirement(Skill.RANGED, 30),
			new SkillRequirement(Skill.FLETCHING, 30),
			new QuestStatusRequirement(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.JUNGLE_POTION, QuestState.FINISHED));

		add(Quest.THE_LOST_TRIBE,
			new SkillRequirement(Skill.AGILITY, 13),
			new SkillRequirement(Skill.THIEVING, 13),
			new SkillRequirement(Skill.MINING, 17),
			new QuestStatusRequirement(Quest.GOBLIN_DIPLOMACY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.RUNE_MYSTERIES, QuestState.FINISHED));


		add(Quest.THE_GIANT_DWARF,
			new SkillRequirement(Skill.CRAFTING, 12),
			new SkillRequirement(Skill.FIREMAKING, 16),
			new SkillRequirement(Skill.MAGIC, 33),
			new SkillRequirement(Skill.THIEVING, 14));

		add(Quest.RECRUITMENT_DRIVE,
			new QuestStatusRequirement(Quest.BLACK_KNIGHTS_FORTRESS, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.DRUIDIC_RITUAL, QuestState.FINISHED),
			new QuestPointRequirement(12));

		add(Quest.MOURNINGS_END_PART_I,
			new SkillRequirement(Skill.RANGED, 60),
			new SkillRequirement(Skill.THIEVING, 50),
			new QuestStatusRequirement(Quest.ROVING_ELVES, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.SHEEP_HERDER, QuestState.FINISHED));

		add(Quest.FORGETTABLE_TALE,
			new SkillRequirement(Skill.COOKING, 22),
			new SkillRequirement(Skill.FARMING, 17),
			new QuestStatusRequirement(Quest.THE_GIANT_DWARF, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.FISHING_CONTEST, QuestState.FINISHED));

		add(Quest.GARDEN_OF_TRANQUILLITY,
			new SkillRequirement(Skill.FARMING, 25),
			new QuestStatusRequirement(Quest.CREATURE_OF_FENKENSTRAIN, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_RESTLESS_GHOST, QuestState.FINISHED));

		add(Quest.A_TAIL_OF_TWO_CATS,
			new QuestStatusRequirement(Quest.ICTHLARINS_LITTLE_HELPER, QuestState.FINISHED));

		add(Quest.WANTED,
			new QuestStatusRequirement(Quest.RECRUITMENT_DRIVE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_LOST_TRIBE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.ENTER_THE_ABYSS, QuestState.FINISHED),
			new QuestPointRequirement(32));

		add(Quest.MOURNINGS_END_PART_II,
			new QuestStatusRequirement(Quest.MOURNINGS_END_PART_I, QuestState.FINISHED));

		add(Quest.RUM_DEAL,
			new QuestStatusRequirement(Quest.ZOGRE_FLESH_EATERS, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 42),
			new SkillRequirement(Skill.FISHING, 50),
			new SkillRequirement(Skill.FARMING, 40),
			new SkillRequirement(Skill.PRAYER, 47),
			new SkillRequirement(Skill.SLAYER, 42));

		add(Quest.SHADOW_OF_THE_STORM,
			new QuestStatusRequirement(Quest.THE_GOLEM, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.DEMON_SLAYER, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 30));

		add(Quest.MAKING_HISTORY,
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_RESTLESS_GHOST, QuestState.FINISHED));

		add(Quest.RATCATCHERS,
			new QuestStatusRequirement(Quest.ICTHLARINS_LITTLE_HELPER, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.GERTRUDES_CAT, QuestState.FINISHED));

		add(Quest.SPIRITS_OF_THE_ELID,
			new SkillRequirement(Skill.MAGIC, 33),
			new SkillRequirement(Skill.RANGED, 37),
			new SkillRequirement(Skill.MINING, 37),
			new SkillRequirement(Skill.THIEVING, 37));

		add(Quest.DEVIOUS_MINDS,
			new SkillRequirement(Skill.SMITHING, 65),
			new SkillRequirement(Skill.RUNECRAFT, 50),
			new SkillRequirement(Skill.FLETCHING, 12),
			new QuestStatusRequirement(Quest.DORICS_QUEST, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.WANTED, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.RECRUITMENT_DRIVE, QuestState.FINISHED));

		add(Quest.THE_HAND_IN_THE_SAND,
			new SkillRequirement(Skill.THIEVING, 17),
			new SkillRequirement(Skill.CRAFTING, 49));

		add(Quest.ENAKHRAS_LAMENT,
			new SkillRequirement(Skill.CRAFTING, 50),
			new SkillRequirement(Skill.PRAYER, 45),
			new SkillRequirement(Skill.MAGIC, 43),
			new SkillRequirement(Skill.MINING, 39));

		add(Quest.CABIN_FEVER,
			new QuestStatusRequirement(Quest.PIRATES_TREASURE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.RUM_DEAL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new SkillRequirement(Skill.AGILITY, 42),
			new SkillRequirement(Skill.CRAFTING, 45),
			new SkillRequirement(Skill.SMITHING, 50),
			new SkillRequirement(Skill.RANGED, 40));

		add(Quest.FAIRYTALE_I__GROWING_PAINS,
			new QuestStatusRequirement(Quest.LOST_CITY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.NATURE_SPIRIT, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.JUNGLE_POTION, QuestState.FINISHED));

		// Yes needs a lot of requirements but only these to start it.
		add(Quest.RECIPE_FOR_DISASTER,
			new QuestStatusRequirement(Quest.COOKS_ASSISTANT, QuestState.FINISHED),
			new SkillRequirement(Skill.COOKING, 10));

		add(Quest.IN_AID_OF_THE_MYREQUE,
			new QuestStatusRequirement(Quest.IN_SEARCH_OF_THE_MYREQUE, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 25),
			new SkillRequirement(Skill.MINING, 15),
			new SkillRequirement(Skill.MAGIC, 7));

		add(Quest.RAG_AND_BONE_MAN_II,
			new QuestStatusRequirement(Quest.ZOGRE_FLESH_EATERS, QuestState.IN_PROGRESS),
			new QuestStatusRequirement(Quest.CREATURE_OF_FENKENSTRAIN, QuestState.IN_PROGRESS),
			new QuestStatusRequirement(Quest.RAG_AND_BONE_MAN_I, QuestState.FINISHED),
			new OrRequirement(new QuestStatusRequirement(Quest.IN_SEARCH_OF_THE_MYREQUE, QuestState.FINISHED), new QuestStatusRequirement(Quest.HORROR_FROM_THE_DEEP, QuestState.FINISHED)),
			new SkillRequirement(Skill.SLAYER, 40),
			new SkillRequirement(Skill.DEFENCE, 15),
			new SkillRequirement(Skill.MAGIC, 7));

		add(Quest.SWAN_SONG,
			new QuestStatusRequirement(Quest.ONE_SMALL_FAVOUR, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.GARDEN_OF_TRANQUILLITY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.CREATURE_OF_FENKENSTRAIN, QuestState.FINISHED),
			new QuestPointRequirement(100),
			new SkillRequirement(Skill.MAGIC, 66),
			new SkillRequirement(Skill.COOKING, 62),
			new SkillRequirement(Skill.FISHING, 62),
			new SkillRequirement(Skill.SMITHING, 45),
			new SkillRequirement(Skill.FIREMAKING, 42),
			new SkillRequirement(Skill.CRAFTING, 40));

		add(Quest.ROYAL_TROUBLE,
			new QuestStatusRequirement(Quest.THRONE_OF_MISCELLANIA, QuestState.FINISHED),
			new SkillRequirement(Skill.AGILITY, 40),
			new SkillRequirement(Skill.SLAYER, 40));

		add(Quest.DEATH_TO_THE_DORGESHUUN,
			new QuestStatusRequirement(Quest.THE_LOST_TRIBE, QuestState.FINISHED),
			new SkillRequirement(Skill.AGILITY, 23),
			new SkillRequirement(Skill.THIEVING, 23));

		add(Quest.FAIRYTALE_II__CURE_A_QUEEN,
			new QuestStatusRequirement(Quest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
			new SkillRequirement(Skill.THIEVING, 40),
			new SkillRequirement(Skill.FARMING, 49),
			new SkillRequirement(Skill.HERBLORE, 57));

		add(Quest.LUNAR_DIPLOMACY,
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.LOST_CITY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.RUNE_MYSTERIES, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.SHILO_VILLAGE, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 61),
			new SkillRequirement(Skill.DEFENCE, 40),
			new SkillRequirement(Skill.FIREMAKING, 49),
			new SkillRequirement(Skill.MAGIC, 65),
			new SkillRequirement(Skill.MINING, 60),
			new SkillRequirement(Skill.WOODCUTTING, 55));

		add(Quest.THE_EYES_OF_GLOUPHRIE,
			new QuestStatusRequirement(Quest.THE_GRAND_TREE, QuestState.FINISHED),
			new SkillRequirement(Skill.CONSTRUCTION, 5),
			new SkillRequirement(Skill.MAGIC, 46),
			new OrRequirement(new QuestStatusRequirement(Quest.THRONE_OF_MISCELLANIA, QuestState.FINISHED), new SkillRequirement(Skill.WOODCUTTING, 45), new SkillRequirement(Skill.FIREMAKING, 45)));

		add(Quest.DARKNESS_OF_HALLOWVALE,
			new QuestStatusRequirement(Quest.IN_AID_OF_THE_MYREQUE, QuestState.FINISHED),
			new SkillRequirement(Skill.CONSTRUCTION, 5),
			new SkillRequirement(Skill.MINING, 22),
			new SkillRequirement(Skill.THIEVING, 22),
			new SkillRequirement(Skill.AGILITY, 26),
			new SkillRequirement(Skill.CRAFTING, 32),
			new SkillRequirement(Skill.MAGIC, 33),
			new SkillRequirement(Skill.STRENGTH, 40));

		add(Quest.THE_SLUG_MENACE,
			new QuestStatusRequirement(Quest.WANTED, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.SEA_SLUG, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 30),
			new SkillRequirement(Skill.RUNECRAFT, 30),
			new SkillRequirement(Skill.SLAYER, 30),
			new SkillRequirement(Skill.THIEVING, 30));

		add(Quest.ELEMENTAL_WORKSHOP_II,
			new QuestStatusRequirement(Quest.ELEMENTAL_WORKSHOP_I, QuestState.FINISHED),
			new SkillRequirement(Skill.MAGIC, 20),
			new SkillRequirement(Skill.SMITHING, 30));

		add(Quest.MY_ARMS_BIG_ADVENTURE,
			new QuestStatusRequirement(Quest.EAGLES_PEAK, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_FEUD, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.JUNGLE_POTION, QuestState.FINISHED),
			new SkillRequirement(Skill.WOODCUTTING, 10),
			new SkillRequirement(Skill.FARMING, 29));

		add(Quest.ENLIGHTENED_JOURNEY,
			new QuestPointRequirement(20),
			new SkillRequirement(Skill.FIREMAKING, 20),
			new SkillRequirement(Skill.FARMING, 30),
			new SkillRequirement(Skill.CRAFTING, 36));

		add(Quest.EAGLES_PEAK,
			new SkillRequirement(Skill.HUNTER, 27));

		add(Quest.ANIMAL_MAGNETISM,
			new QuestStatusRequirement(Quest.THE_RESTLESS_GHOST, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.ERNEST_THE_CHICKEN, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new SkillRequirement(Skill.SLAYER, 18),
			new SkillRequirement(Skill.CRAFTING, 19),
			new SkillRequirement(Skill.RANGED, 30),
			new SkillRequirement(Skill.WOODCUTTING, 35));

		add(Quest.CONTACT,
			new QuestStatusRequirement(Quest.PRIEST_IN_PERIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.ICTHLARINS_LITTLE_HELPER, QuestState.FINISHED));

		add(Quest.COLD_WAR,
			new SkillRequirement(Skill.HUNTER, 10),
			new SkillRequirement(Skill.AGILITY, 30),
			new SkillRequirement(Skill.CRAFTING, 30),
			new SkillRequirement(Skill.CONSTRUCTION, 34),
			new SkillRequirement(Skill.THIEVING, 15));

		add(Quest.THE_FREMENNIK_ISLES,
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED),
			new SkillRequirement(Skill.CONSTRUCTION, 20),
			new SkillRequirement(Skill.AGILITY, 40),
			new SkillRequirement(Skill.WOODCUTTING, 56),
			new SkillRequirement(Skill.CRAFTING, 46));

		add(Quest.TOWER_OF_LIFE,
			new SkillRequirement(Skill.CONSTRUCTION, 10));

		add(Quest.THE_GREAT_BRAIN_ROBBERY,
			new QuestStatusRequirement(Quest.CABIN_FEVER, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.CREATURE_OF_FENKENSTRAIN, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.RECIPE_FOR_DISASTER, QuestState.IN_PROGRESS),
			new SkillRequirement(Skill.CONSTRUCTION, 30),
			new SkillRequirement(Skill.PRAYER, 50));

		add(Quest.WHAT_LIES_BELOW,
			new QuestStatusRequirement(Quest.RUNE_MYSTERIES, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 35),
			new SkillRequirement(Skill.MINING, 42));

		add(Quest.OLAFS_QUEST,
			new QuestStatusRequirement(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED),
			new SkillRequirement(Skill.WOODCUTTING, 50),
			new SkillRequirement(Skill.FIREMAKING, 40));

		add(Quest.ANOTHER_SLICE_OF_HAM,
			new QuestStatusRequirement(Quest.DEATH_TO_THE_DORGESHUUN, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_GIANT_DWARF, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_DIG_SITE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.DRUIDIC_RITUAL, QuestState.FINISHED),
			new SkillRequirement(Skill.ATTACK, 15),
			new SkillRequirement(Skill.PRAYER, 25));

		add(Quest.DREAM_MENTOR,
			new QuestStatusRequirement(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.EADGARS_RUSE, QuestState.FINISHED),
			new CombatLevelRequirement(85));

		add(Quest.GRIM_TALES,
			new QuestStatusRequirement(Quest.WITCHS_HOUSE, QuestState.FINISHED),
			new SkillRequirement(Skill.FARMING, 45),
			new SkillRequirement(Skill.HERBLORE, 52),
			new SkillRequirement(Skill.THIEVING, 58),
			new SkillRequirement(Skill.AGILITY, 59),
			new SkillRequirement(Skill.WOODCUTTING, 71));

		add(Quest.KINGS_RANSOM,
			new QuestStatusRequirement(Quest.BLACK_KNIGHTS_FORTRESS, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.HOLY_GRAIL, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.MURDER_MYSTERY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.ONE_SMALL_FAVOUR, QuestState.FINISHED),
			new SkillRequirement(Skill.MAGIC, 45),
			new SkillRequirement(Skill.DEFENCE, 65));

		add(Quest.MONKEY_MADNESS_II,
			new QuestStatusRequirement(Quest.ENLIGHTENED_JOURNEY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_EYES_OF_GLOUPHRIE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.RECIPE_FOR_DISASTER, QuestState.IN_PROGRESS),
			new QuestStatusRequirement(Quest.MONKEY_MADNESS_I, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.WATCHTOWER, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.TROLL_STRONGHOLD, QuestState.FINISHED),
			new SkillRequirement(Skill.SLAYER, 69),
			new SkillRequirement(Skill.CRAFTING, 70),
			new SkillRequirement(Skill.HUNTER, 60),
			new SkillRequirement(Skill.AGILITY, 55),
			new SkillRequirement(Skill.THIEVING, 55));

		add(Quest.BONE_VOYAGE,
			new KudosRequirement(100),
			new QuestStatusRequirement(Quest.THE_DIG_SITE, QuestState.FINISHED));

		add(Quest.THE_QUEEN_OF_THIEVES,
			new QuestStatusRequirement(Quest.CLIENT_OF_KOUREND, QuestState.FINISHED),
			new SkillRequirement(Skill.THIEVING, 20),
			new FavourRequirement(Favour.PISCARILIUS, 20));

		add(Quest.THE_DEPTHS_OF_DESPAIR,
			new QuestStatusRequirement(Quest.CLIENT_OF_KOUREND, QuestState.FINISHED),
			new SkillRequirement(Skill.AGILITY, 18),
			new FavourRequirement(Favour.HOSIDIUS, 20));

		add(Quest.DRAGON_SLAYER_II,
			new SkillRequirement(Skill.MAGIC, 75),
			new SkillRequirement(Skill.SMITHING, 70),
			new SkillRequirement(Skill.MINING, 68),
			new SkillRequirement(Skill.CRAFTING, 62),
			new SkillRequirement(Skill.AGILITY, 60),
			new SkillRequirement(Skill.THIEVING, 60),
			new SkillRequirement(Skill.CONSTRUCTION, 50),
			new SkillRequirement(Skill.HITPOINTS, 50),
			new QuestStatusRequirement(Quest.LEGENDS_QUEST, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.DRAGON_SLAYER_I, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.DREAM_MENTOR, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.A_TAIL_OF_TWO_CATS, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.LOST_CITY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.EADGARS_RUSE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.ANIMAL_MAGNETISM, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.GHOSTS_AHOY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.BONE_VOYAGE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.CLIENT_OF_KOUREND, QuestState.FINISHED),
			new QuestPointRequirement(200));

		add(Quest.TALE_OF_THE_RIGHTEOUS,
			new QuestStatusRequirement(Quest.CLIENT_OF_KOUREND, QuestState.FINISHED),
			new SkillRequirement(Skill.STRENGTH, 16),
			new SkillRequirement(Skill.MINING, 10),
			new FavourRequirement(Favour.SHAYZIEN, 20));

		add(Quest.A_TASTE_OF_HOPE,
			new QuestStatusRequirement(Quest.DARKNESS_OF_HALLOWVALE, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 48),
			new SkillRequirement(Skill.AGILITY, 45),
			new SkillRequirement(Skill.ATTACK, 40),
			new SkillRequirement(Skill.HERBLORE, 40),
			new SkillRequirement(Skill.SLAYER, 38));

		add(Quest.MAKING_FRIENDS_WITH_MY_ARM,
			new SkillRequirement(Skill.MINING, 72),
			new SkillRequirement(Skill.AGILITY, 68),
			new SkillRequirement(Skill.FIREMAKING, 66),
			new SkillRequirement(Skill.CONSTRUCTION, 35),
			new QuestStatusRequirement(Quest.MY_ARMS_BIG_ADVENTURE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.SWAN_SONG, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.ROMEO__JULIET, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.COLD_WAR, QuestState.FINISHED));

		add(Quest.FORGETTABLE_TALE,
			new QuestStatusRequirement(Quest.CLIENT_OF_KOUREND, QuestState.FINISHED),
			new FavourRequirement(Favour.LOVAKENGJ, 20));

		add(Quest.THE_ASCENT_OF_ARCEUUS,
			new SkillRequirement(Skill.HUNTER, 12),
			new FavourRequirement(Favour.ARCEUUS, 20));

		add(Quest.SONG_OF_THE_ELVES,
			new QuestStatusRequirement(Quest.MOURNINGS_END_PART_II, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.MAKING_HISTORY, QuestState.FINISHED),
			new SkillRequirement(Skill.AGILITY, 70),
			new SkillRequirement(Skill.CONSTRUCTION, 70),
			new SkillRequirement(Skill.FARMING, 70),
			new SkillRequirement(Skill.HERBLORE, 70),
			new SkillRequirement(Skill.HUNTER, 70),
			new SkillRequirement(Skill.MINING, 70),
			new SkillRequirement(Skill.SMITHING, 70),
			new SkillRequirement(Skill.WOODCUTTING, 70),
			new QuestStatusRequirement(Quest.MY_ARMS_BIG_ADVENTURE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.SWAN_SONG, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.ROMEO__JULIET, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.COLD_WAR, QuestState.FINISHED));

		add(Quest.THE_FREMENNIK_EXILES,
			new QuestStatusRequirement(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.THE_FREMENNIK_ISLES, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.MOUNTAIN_DAUGHTER, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.HEROES_QUEST, QuestState.FINISHED),
			new SkillRequirement(Skill.CRAFTING, 65),
			new SkillRequirement(Skill.SLAYER, 60),
			new SkillRequirement(Skill.SMITHING, 60),
			new SkillRequirement(Skill.FISHING, 60),
			new SkillRequirement(Skill.RUNECRAFT, 55));

		add(Quest.SINS_OF_THE_FATHER,
			new QuestStatusRequirement(Quest.A_TASTE_OF_HOPE, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.VAMPYRE_SLAYER, QuestState.FINISHED),
			new SkillRequirement(Skill.WOODCUTTING, 62),
			new SkillRequirement(Skill.SLAYER, 60),
			new SkillRequirement(Skill.SMITHING, 56),
			new SkillRequirement(Skill.FISHING, 52),
			new SkillRequirement(Skill.SLAYER, 55),
			new SkillRequirement(Skill.ATTACK, 55),
			new SkillRequirement(Skill.MAGIC, 55));

		add(Quest.GETTING_AHEAD,
			new SkillRequirement(Skill.CRAFTING, 30),
			new SkillRequirement(Skill.CONSTRUCTION, 26));

		// miniquests
		add(Quest.CURSE_OF_THE_EMPTY_LORD,
			new QuestStatusRequirement(Quest.DESERT_TREASURE, QuestState.IN_PROGRESS));

		add(Quest.ARCHITECTURAL_ALLIANCE,
			new FavourRequirement(Favour.LOVAKENGJ, 100),
			new FavourRequirement(Favour.SHAYZIEN, 100),
			new FavourRequirement(Favour.HOSIDIUS, 100),
			new FavourRequirement(Favour.PISCARILIUS, 100),
			new FavourRequirement(Favour.ARCEUUS, 100));

		add(Quest.ENCHANTED_KEY,
			new QuestStatusRequirement(Quest.MAKING_HISTORY, QuestState.FINISHED));

		add(Quest.ENTER_THE_ABYSS,
			new QuestStatusRequirement(Quest.RUNE_MYSTERIES, QuestState.FINISHED));

		add(Quest.FAMILY_PEST,
			new QuestStatusRequirement(Quest.FAMILY_CREST, QuestState.FINISHED));

		add(Quest.THE_GENERALS_SHADOW,
			new QuestStatusRequirement(Quest.FIGHT_ARENA, QuestState.FINISHED),
			new QuestStatusRequirement(Quest.CURSE_OF_THE_EMPTY_LORD, QuestState.FINISHED));

		add(Quest.LAIR_OF_TARN_RAZORLOR,
			new QuestStatusRequirement(Quest.HAUNTED_MINE, QuestState.FINISHED),
			new SkillRequirement(Skill.SLAYER, 40));

		add(Quest.THE_MAGE_ARENA,
			new SkillRequirement(Skill.MAGIC, 60));

		add(Quest.THE_MAGE_ARENA_II,
			new SkillRequirement(Skill.MAGIC, 75),
			new QuestStatusRequirement(Quest.THE_MAGE_ARENA, QuestState.FINISHED));
	}
}