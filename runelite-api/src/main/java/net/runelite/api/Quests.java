/*
 * Copyright (c) 2018, RyadaProductions <https://github.com/RyadaProductions>
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
package net.runelite.api;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Enumeration that has all the quests in the game and their completion value.
 * This can be used to check if a quest has been completed/started/not started.
 */
public enum Quests
{
	/**
	 * f2p quests
	 */
	BLACK_KNIGHTS_FORTRESS(VarPlayer.QUEST_BLACK_KNIGHTS_FORTRESS, 4),
	COOKS_ASSISTANT(VarPlayer.QUEST_COOKS_ASSISTANT, 2),
	DEMON_SLAYER(Varbits.QUEST_DEMON_SLAYER, 3),
	DORICS_QUEST(VarPlayer.QUEST_DORICS_QUEST, 100),
	DRAGON_SLAYER(VarPlayer.QUEST_DRAGON_SLAYER, 10),
	ERNEST_THE_CHICKEN(VarPlayer.QUEST_ERNEST_THE_CHICKEN, 3),
	GOBLIN_DIPLOMACY(Varbits.QUEST_GOBLIN_DIPLOMACY, 6),
	IMP_CATCHER(VarPlayer.QUEST_IMP_CATCHER, 2),
	THE_KNIGHTS_SWORD(VarPlayer.QUEST_THE_KNIGHTS_SWORD, 7),
	PIRATES_TREASURE(VarPlayer.QUEST_PIRATES_TREASURE, 4),
	PRINCE_ALI_RESCUE(VarPlayer.QUEST_PRINCE_ALI_RESCUE, 110),
	THE_RESTLESS_GHOST(VarPlayer.QUEST_THE_RESTLESS_GHOST, 5),
	ROMEO_AND_JULIET(VarPlayer.QUEST_ROMEO_AND_JULIET, 100),
	RUNE_MYSTERIES(VarPlayer.QUEST_RUNE_MYSTERIES, 6),
	SHEEP_SHEARER(VarPlayer.QUEST_SHEEP_SHEARER, 21),
	SHIELD_OF_ARRAV(VarPlayer.QUEST_SHIELD_OF_ARRAV, 7),
	VAMPIRE_SLAYER(VarPlayer.QUEST_VAMPIRE_SLAYER, 3),
	WITCHS_POTION(VarPlayer.QUEST_WITCHS_POTION, 3),
	MISTHALIN_MYSTERY(Varbits.QUEST_MISTHALIN_MYSTERY, 135),
	THE_CORSAIR_CURSE(Varbits.QUEST_THE_CORSAIR_CURSE, 60),
	/**
	 * member quests
	 */
	ANIMAL_MAGNETISM(Varbits.QUEST_ANIMAL_MAGNETISM, 240),
	BETWEEN_A_ROCK(Varbits.QUEST_BETWEEN_A_ROCK, 110),
	BIG_CHOMPY_BIRD_HUNTING(VarPlayer.QUEST_BIG_CHOMPY_BIRD_HUNTING, 65),
	BIOHAZARD(VarPlayer.QUEST_BIOHAZARD, 16),
	CABIN_FEVER(VarPlayer.QUEST_CABIN_FEVER, 131),
	CLOCK_TOWER(VarPlayer.QUEST_CLOCK_TOWER, 8),
	CONTACT(Varbits.QUEST_CONTACT, 130),
	ZOGRE_FLESH_EATERS(Varbits.QUEST_ZOGRE_FLESH_EATERS, 13),
	CREATURE_OF_FENKENSTRAIN(VarPlayer.QUEST_CREATURE_OF_FENKENSTRAIN, 7),
	DARKNESS_OF_HALLOWVALE(Varbits.QUEST_DARKNESS_OF_HALLOWVALE, 320),
	DEATH_TO_THE_DORGESHUUN(Varbits.QUEST_DEATH_TO_THE_DORGESHUUN, 13),
	DEATH_PLATEAU(VarPlayer.QUEST_DEATH_PLATEAU, 80),
	DESERT_TREASURE(Varbits.QUEST_DESERT_TREASURE, 15),
	DEVIOUS_MINDS(Varbits.QUEST_DEVIOUS_MINDS, 80),
	THE_DIG_SITE(VarPlayer.QUEST_THE_DIG_SITE, 9),
	DRUIDIC_RITUAL(VarPlayer.QUEST_DRUIDIC_RITUAL, 4),
	DWARF_CANNON(VarPlayer.QUEST_DWARF_CANNON, 11),
	EADGARS_RUSE(VarPlayer.QUEST_EADGARS_RUSE, 110),
	EAGLES_PEAK(Varbits.QUEST_EAGLES_PEAK, 40),
	ELEMENTAL_WORKSHOP_I(VarPlayer.QUEST_ELEMENTAL_WORKSHOP_I, 1048576),
	ELEMENTAL_WORKSHOP_II(Varbits.QUEST_ELEMENTAL_WORKSHOP_II, 11),
	ENAKHRAS_LAMENT(Varbits.QUEST_ENAKHRAS_LAMENT, 70),
	ENLIGHTENED_JOURNEY(Varbits.QUEST_ENLIGHTENED_JOURNEY, 200),
	THE_EYES_OF_GLOUPHRIE(Varbits.QUEST_THE_EYES_OF_GLOUPHRIE, 60),
	FAIRYTALE_I_GROWING_PAINS(Varbits.QUEST_FAIRYTALE_I_GROWING_PAINS, 90),
	FAIRYTALE_II_CURE_A_QUEEN(Varbits.QUEST_FAIRYTALE_II_CURE_A_QUEEN, 81),
	FAMILY_CREST(VarPlayer.QUEST_FAMILY_CREST, 11),
	THE_FEUD(Varbits.QUEST_THE_FEUD, 28),
	FIGHT_ARENA(VarPlayer.QUEST_FIGHT_ARENA, 14),
	FISHING_CONTEST(VarPlayer.QUEST_FISHING_CONTEST, 5),
	FORGETTABLE_TALE(Varbits.QUEST_FORGETTABLE_TALE, 140),
	THE_FREMENNIK_TRIALS(VarPlayer.QUEST_THE_FREMENNIK_TRIALS, 10),
	WATERFALL_QUEST(VarPlayer.QUEST_WATERFALL_QUEST, 10),
	GARDEN_OF_TRANQUILLITY(Varbits.QUEST_GARDEN_OF_TRANQUILLITY, 60),
	GERTRUDES_CAT(VarPlayer.QUEST_GERTRUDES_CAT, 6),
	GHOSTS_AHOY(Varbits.QUEST_GHOSTS_AHOY, 8),
	THE_GIANT_DWARF(Varbits.QUEST_THE_GIANT_DWARF, 50),
	THE_GOLEM(Varbits.QUEST_THE_GOLEM, 10),
	THE_GRAND_TREE(VarPlayer.QUEST_THE_GRAND_TREE, 160),
	THE_HAND_IN_THE_SAND(Varbits.QUEST_THE_HAND_IN_THE_SAND, 160),
	HAUNTED_MINE(VarPlayer.QUEST_HAUNTED_MINE, 11),
	HAZEEL_CULT(VarPlayer.QUEST_HAZEEL_CULT, 9),
	HEROES_QUEST(VarPlayer.QUEST_HEROES_QUEST, 15),
	HOLY_GRAIL(VarPlayer.QUEST_HOLY_GRAIL, 10),
	HORROR_FROM_THE_DEEP(Varbits.QUEST_HORROR_FROM_THE_DEEP, 10),
	ICTHLARINS_LITTLE_HELPER(Varbits.QUEST_ICTHLARINS_LITTLE_HELPER, 26),
	IN_AID_OF_THE_MYREQUE(Varbits.QUEST_IN_AID_OF_THE_MYREQUE, 421),
	IN_SEARCH_OF_THE_MYREQUE(VarPlayer.QUEST_IN_SEARCH_OF_THE_MYREQUE, 101),
	JUNGLE_POTION(VarPlayer.QUEST_JUNGLE_POTION, 12),
	LEGENDS_QUEST(VarPlayer.QUEST_LEGENDS_QUEST, 75),
	LOST_CITY(VarPlayer.QUEST_LOST_CITY, 6),
	THE_LOST_TRIBE(Varbits.QUEST_THE_LOST_TRIBE, 11),
	LUNAR_DIPLOMACY(Varbits.QUEST_LUNAR_DIPLOMACY, 190),
	MAKING_HISTORY(Varbits.QUEST_MAKING_HISTORY, 4),
	MERLINS_CRYSTAL(VarPlayer.QUEST_MERLINS_CRYSTAL, 7),
	MONKEY_MADNESS_I(VarPlayer.QUEST_MONKEY_MADNESS_I, 9),
	MONKS_FRIEND(VarPlayer.QUEST_MONKS_FRIEND, 80),
	MOUNTAIN_DAUGHTER(Varbits.QUEST_MOUNTAIN_DAUGHTER, 70),
	MOURNINGS_ENDS_PART_I(VarPlayer.QUEST_MOURNINGS_ENDS_PART_I, 8),
	MOURNINGS_ENDS_PART_II(Varbits.QUEST_MOURNINGS_ENDS_PART_II, 60),
	MURDER_MYSTERY(VarPlayer.QUEST_MURDER_MYSTERY, 2),
	MY_ARMS_BIG_ADVENTURE(Varbits.QUEST_MY_ARMS_BIG_ADVENTURE, 311),
	NATURE_SPIRIT(VarPlayer.QUEST_NATURE_SPIRIT, 110),
	OBSERVATORY_QUEST(VarPlayer.QUEST_OBSERVATORY_QUEST, 7),
	ONE_SMALL_FAVOUR(VarPlayer.QUEST_ONE_SMALL_FAVOUR, 276),
	PLAGUE_CITY(VarPlayer.QUEST_PLAGUE_CITY, 29),
	PRIEST_IN_PERIL(VarPlayer.QUEST_PRIEST_IN_PERIL, 60),
	RAG_AND_BONE_MAN(VarPlayer.QUEST_RAG_AND_BONE_MAN, 4),
	RATCATCHERS(Varbits.QUEST_RATCATCHERS, 127),
	RECIPE_FOR_DISASTER(Varbits.QUEST_RECIPE_FOR_DISASTER, 5),
	RECRUITMENT_DRIVE(Varbits.QUEST_RECRUITMENT_DRIVE, 2),
	REGICIDE(VarPlayer.QUEST_REGICIDE, 15),
	ROVING_ELVES(VarPlayer.QUEST_ROVING_ELVES, 6),
	ROYAL_TROUBLE(Varbits.QUEST_ROYAL_TROUBLE, 21),
	RUM_DEAL(VarPlayer.QUEST_RUM_DEAL, 19),
	SCORPION_CATCHER(VarPlayer.QUEST_SCORPION_CATCHER, 6),
	SEA_SLUG(VarPlayer.QUEST_SEA_SLUG, 12),
	THE_SLUG_MENACE(Varbits.QUEST_THE_SLUG_MENACE, 14),
	SHADES_OF_MORTTON(VarPlayer.QUEST_SHADES_OF_MORTTON, 85),
	SHADOW_OF_THE_STORM(Varbits.QUEST_SHADOW_OF_THE_STORM, 125),
	SHEEP_HERDER(VarPlayer.QUEST_SHEEP_HERDER, 3),
	SHILO_VILLAGE(VarPlayer.QUEST_SHILO_VILLAGE, 15),
	A_SOULS_BANE(Varbits.QUEST_A_SOULS_BANE, 13),
	SPIRITS_OF_THE_ELID(Varbits.QUEST_SPIRITS_OF_THE_ELID, 60),
	SWAN_SONG(Varbits.QUEST_SWAN_SONG, 200),
	TAI_BWO_WANNAI_TRIO(VarPlayer.QUEST_TAI_BWO_WANNAI_TRIO, 6),
	A_TAIL_OF_TWO_CATS(Varbits.QUEST_A_TAIL_OF_TWO_CATS, 70),
	TEARS_OF_GUTHIX(Varbits.QUEST_TEARS_OF_GUTHIX, 2),
	TEMPLE_OF_IKOV(VarPlayer.QUEST_TEMPLE_OF_IKOV, 80),
	THRONE_OF_MISCELLANIA(VarPlayer.QUEST_THRONE_OF_MISCELLANIA, 100),
	THE_TOURIST_TRAP(VarPlayer.QUEST_THE_TOURIST_TRAP, 30),
	WITCHS_HOUSE(VarPlayer.QUEST_WITCHS_HOUSE, 7),
	TREE_GNOME_VILLAGE(VarPlayer.QUEST_TREE_GNOME_VILLAGE, 9),
	TRIBAL_TOTEM(VarPlayer.QUEST_TRIBAL_TOTEM, 5),
	TROLL_ROMANCE(VarPlayer.QUEST_TROLL_ROMANCE, 45),
	TROLL_STRONGHOLD(VarPlayer.QUEST_TROLL_STRONGHOLD, 50),
	UNDERGROUND_PASS(VarPlayer.QUEST_UNDERGROUND_PASS, 10),
	WANTED(Varbits.QUEST_WANTED, 11),
	WATCHTOWER(VarPlayer.QUEST_WATCHTOWER, 13),
	COLD_WAR(Varbits.QUEST_COLD_WAR, 135),
	THE_FREMENNIK_ISLES(Varbits.QUEST_THE_FREMENNIK_ISLES, 340),
	TOWER_OF_LIFE(Varbits.QUEST_TOWER_OF_LIFE, 18),
	THE_GREAT_BRAIN_ROBBERY(VarPlayer.QUEST_THE_GREAT_BRAIN_ROBBERY, 130),
	WHAT_LIES_BELOW(Varbits.QUEST_WHAT_LIES_BELOW, 150),
	OLAFS_QUEST(Varbits.QUEST_OLAFS_QUEST, 80),
	ANOTHER_SLICE_OF_HAM(Varbits.QUEST_ANOTHER_SLICE_OF_HAM, 11),
	DREAM_MENTOR(Varbits.QUEST_DREAM_MENTOR, 28),
	GRIM_TALES(Varbits.QUEST_GRIM_TALES, 60),
	KINGS_RANSOM(Varbits.QUEST_KINGS_RANSOM, 90),
	MONKEY_MADNESS_II(Varbits.QUEST_MONKEY_MADNESS_II, 191),
	CLIENT_OF_KOUREND(Varbits.QUEST_CLIENT_OF_KOUREND, 7),
	RAG_AND_BONE_MAN_II(VarPlayer.QUEST_RAG_AND_BONE_MAN_II, 6),
	BONE_VOYAGE(Varbits.QUEST_BONE_VOYAGE, 50),
	THE_QUEEN_OF_THIEVES(Varbits.QUEST_THE_QUEEN_OF_THIEVES, 13),
	THE_DEPTHS_OF_DESPAIR(Varbits.QUEST_THE_DEPTHS_OF_DESPAIR, 11),
	DRAGON_SLAYER_II(Varbits.QUEST_DRAGON_SLAYER_II, 215),
	TALE_OF_THE_RIGHTEOUS(Varbits.QUEST_TALE_OF_THE_RIGHTEOUS, 17),
	A_TASTE_OF_HOPE(Varbits.QUEST_A_TASTE_OF_HOPE, 165),
	/**
	 * mini quests
	 */
	ENTER_THE_ABYSS(VarPlayer.QUEST_ENTER_THE_ABYSS, 4),
	ARCHITECTURAL_ALLIANCE(Varbits.QUEST_ARCHITECTURAL_ALLIANCE, 3),
	BEAR_YOUR_SOUL(Varbits.QUEST_BEAR_YOUR_SOUL, 3),
	ALFRED_GRIMHANDS_BARCRAWL(VarPlayer.QUEST_ALFRED_GRIMHANDS_BARCRAWL, 2),
	CURSE_OF_THE_EMPTY_LORD(Varbits.QUEST_CURSE_OF_THE_EMPTY_LORD, 1),
	ENCHANTED_KEY(Varbits.QUEST_ENCHANTED_KEY, 2047),
	THE_GENERALS_SHADOW(Varbits.QUEST_THE_GENERALS_SHADOW, 30),
	SKIPPY_AND_THE_MOGRES(Varbits.QUEST_SKIPPY_AND_THE_MOGRES, 3),
	THE_MAGE_ARENA(VarPlayer.QUEST_THE_MAGE_ARENA, 8),
	LAIR_OF_TARN_RAZORLOR(Varbits.QUEST_LAIR_OF_TARN_RAZORLOR, 3),
	FAMILY_PEST(Varbits.QUEST_FAMILY_PEST, 3),
	THE_MAGE_ARENA_II(Varbits.QUEST_THE_MAGE_ARENA_II, 4);

	/**
	 * the varplayer that is related to the quest.t
	 * If this is null, use the varbit field.
	 */
	@Nullable
	private final VarPlayer varplayer;

	/**
	 * the varbit that is related to the quest.
	 * If this is null, use the varplayer field.
	 */
	@Nullable
	private final Varbits varbit;

	/**
	 * the completion value that the quest needs to have to be considered complete
	 * Some quests check if the state is bigger or equal to the completionValue
	 * Some quests have 2 completion values we need to check against. Currently they are defined as magic numbers
	 */
	private final int completionValue;

	Quests(@Nonnull VarPlayer varplayer, int completionValue)
	{
		this.varplayer = varplayer;
		this.varbit = null;
		this.completionValue = completionValue;
	}

	Quests(@Nonnull Varbits varbit, int completionValue)
	{
		this.varplayer = null;
		this.varbit = varbit;
		this.completionValue = completionValue;
	}

	/**
	 * Gets the var value that stores the quest.
	 *
	 * @return the quest var its currentstate
	 */
	public int getVar(Client client)
	{
		if (varbit != null)
		{
			return client.getVar(varbit);
		}
		else
		{
			return client.getVar(varplayer);
		}
	}

	/**
	 * Gets the completion value of the quest
	 *
	 * @return the completion value
	 */
	public int getCompletionValue()
	{
		return completionValue;
	}

	/**
	 * checks if the current state of the quest is equal to the completion value
	 *
	 * @param client the client that checks the varps
	 * @return true when complete, false if quest has not been completed or not implemented
	 */
	public QuestState getQuestState(Client client)
	{
		if (varbit != null)
		{
			return getQuestStateVarbit(client);
		}
		else
		{
			return getQuestStateVarp(client);
		}
	}

	/**
	 * Checks if a quest that is listed in the varbits has been completed
	 * It routes all the quests to the corresponding method that RS uses themself to check for quest completion
	 *
	 * @param client the client gets used to get the current quest state
	 * @return true when complete, false if quest has not been completed or not implemented
	 */
	private QuestState getQuestStateVarbit(Client client)
	{
		if (varbit == null)
		{
			return QuestState.NOT_STARTED;
		}

		switch (varbit)
		{
			//f2p
			case QUEST_DEMON_SLAYER:
			case QUEST_GOBLIN_DIPLOMACY:
			case QUEST_MISTHALIN_MYSTERY:
				return getStateEqual(client);
			case QUEST_THE_CORSAIR_CURSE:
				return getStateBiggerOrEqual(client);
			// member
			case QUEST_ANIMAL_MAGNETISM:
			case QUEST_CONTACT:
			case QUEST_DARKNESS_OF_HALLOWVALE:
			case QUEST_DEATH_TO_THE_DORGESHUUN:
			case QUEST_DESERT_TREASURE:
			case QUEST_DEVIOUS_MINDS:
			case QUEST_EAGLES_PEAK:
			case QUEST_ELEMENTAL_WORKSHOP_II:
			case QUEST_ENLIGHTENED_JOURNEY:
			case QUEST_THE_EYES_OF_GLOUPHRIE:
			case QUEST_FAIRYTALE_I_GROWING_PAINS:
			case QUEST_GARDEN_OF_TRANQUILLITY:
			case QUEST_LUNAR_DIPLOMACY:
			case QUEST_RECIPE_FOR_DISASTER:
			case QUEST_THE_SLUG_MENACE:
			case QUEST_SWAN_SONG:
			case QUEST_A_TAIL_OF_TWO_CATS:
			case QUEST_WANTED:
			case QUEST_COLD_WAR:
			case QUEST_THE_FREMENNIK_ISLES:
			case QUEST_TOWER_OF_LIFE:
			case QUEST_OLAFS_QUEST:
			case QUEST_ANOTHER_SLICE_OF_HAM:
			case QUEST_DREAM_MENTOR:
			case QUEST_GRIM_TALES:
			case QUEST_KINGS_RANSOM:
				return getStateEqual(client);
			case QUEST_BETWEEN_A_ROCK:
			case QUEST_ZOGRE_FLESH_EATERS:
			case QUEST_ENAKHRAS_LAMENT:
			case QUEST_FAIRYTALE_II_CURE_A_QUEEN:
			case QUEST_THE_FEUD:
			case QUEST_GHOSTS_AHOY:
			case QUEST_THE_GIANT_DWARF:
			case QUEST_THE_GOLEM:
			case QUEST_THE_HAND_IN_THE_SAND:
			case QUEST_HORROR_FROM_THE_DEEP:
			case QUEST_ICTHLARINS_LITTLE_HELPER:
			case QUEST_IN_AID_OF_THE_MYREQUE:
			case QUEST_MAKING_HISTORY:
			case QUEST_MOUNTAIN_DAUGHTER:
			case QUEST_MOURNINGS_ENDS_PART_II:
			case QUEST_MY_ARMS_BIG_ADVENTURE:
			case QUEST_RATCATCHERS:
			case QUEST_RECRUITMENT_DRIVE:
			case QUEST_ROYAL_TROUBLE:
			case QUEST_SHADOW_OF_THE_STORM:
			case QUEST_A_SOULS_BANE:
			case QUEST_SPIRITS_OF_THE_ELID:
			case QUEST_TEARS_OF_GUTHIX:
			case QUEST_WHAT_LIES_BELOW:
			case QUEST_MONKEY_MADNESS_II:
			case QUEST_FORGETTABLE_TALE:
			case QUEST_THE_LOST_TRIBE:
			case QUEST_CLIENT_OF_KOUREND:
			case QUEST_BONE_VOYAGE:
			case QUEST_THE_QUEEN_OF_THIEVES:
			case QUEST_THE_DEPTHS_OF_DESPAIR:
			case QUEST_DRAGON_SLAYER_II:
			case QUEST_TALE_OF_THE_RIGHTEOUS:
			case QUEST_A_TASTE_OF_HOPE:
				return getStateBiggerOrEqual(client);
			//mini-quests
			case QUEST_ARCHITECTURAL_ALLIANCE:
			case QUEST_BEAR_YOUR_SOUL:
			case QUEST_THE_GENERALS_SHADOW:
			case QUEST_SKIPPY_AND_THE_MOGRES:
			case QUEST_FAMILY_PEST:
			case QUEST_THE_MAGE_ARENA_II:
				return getStateBiggerOrEqual(client);
			case QUEST_CURSE_OF_THE_EMPTY_LORD:
			case QUEST_ENCHANTED_KEY:
			case QUEST_LAIR_OF_TARN_RAZORLOR:
				return getStateEqual(client);
			default:
				return QuestState.NOT_STARTED;
		}
	}

	/**
	 * Checks if a quest that is listed in the varbits has been completed
	 * It routes all the quests to the corresponding method that RS uses themself to check for quest completion
	 *
	 * @param client the client gets used to get the current quest state
	 * @return true when complete, false if quest has not been completed or not implemented
	 */
	private QuestState getQuestStateVarp(Client client)
	{
		if (varplayer == null)
		{
			return QuestState.NOT_STARTED;
		}

		switch (varplayer)
		{
			//f2p
			case QUEST_BLACK_KNIGHTS_FORTRESS:
			case QUEST_COOKS_ASSISTANT:
			case QUEST_DORICS_QUEST:
			case QUEST_DRAGON_SLAYER:
			case QUEST_ERNEST_THE_CHICKEN:
			case QUEST_IMP_CATCHER:
			case QUEST_THE_KNIGHTS_SWORD:
			case QUEST_PIRATES_TREASURE:
			case QUEST_PRINCE_ALI_RESCUE:
			case QUEST_THE_RESTLESS_GHOST:
			case QUEST_ROMEO_AND_JULIET:
			case QUEST_RUNE_MYSTERIES:
			case QUEST_SHEEP_SHEARER:
			case QUEST_VAMPIRE_SLAYER:
			case QUEST_WITCHS_POTION:
				return getStateEqual(client);
			case QUEST_SHIELD_OF_ARRAV:
				return getShieldOfArravState(client);
			//member
			case QUEST_BIG_CHOMPY_BIRD_HUNTING:
			case QUEST_BIOHAZARD:
			case QUEST_CLOCK_TOWER:
			case QUEST_DEATH_PLATEAU:
			case QUEST_THE_DIG_SITE:
			case QUEST_DRUIDIC_RITUAL:
			case QUEST_EADGARS_RUSE:
			case QUEST_FAMILY_CREST:
			case QUEST_FISHING_CONTEST:
			case QUEST_WATERFALL_QUEST:
			case QUEST_THE_GRAND_TREE:
			case QUEST_HAUNTED_MINE:
			case QUEST_HAZEEL_CULT:
			case QUEST_HEROES_QUEST:
			case QUEST_HOLY_GRAIL:
			case QUEST_LEGENDS_QUEST:
			case QUEST_LOST_CITY:
			case QUEST_MERLINS_CRYSTAL:
			case QUEST_MONKS_FRIEND:
			case QUEST_MURDER_MYSTERY:
			case QUEST_NATURE_SPIRIT:
			case QUEST_SCORPION_CATCHER:
			case QUEST_SEA_SLUG:
			case QUEST_SHADES_OF_MORTTON:
			case QUEST_SHEEP_HERDER:
			case QUEST_TAI_BWO_WANNAI_TRIO:
			case QUEST_THE_TOURIST_TRAP:
			case QUEST_WITCHS_HOUSE:
			case QUEST_TREE_GNOME_VILLAGE:
			case QUEST_TRIBAL_TOTEM:
			case QUEST_TROLL_STRONGHOLD:
				return getStateEqual(client);
			case QUEST_CABIN_FEVER:
			case QUEST_CREATURE_OF_FENKENSTRAIN:
			case QUEST_DWARF_CANNON:
			case QUEST_FIGHT_ARENA:
			case QUEST_THE_FREMENNIK_TRIALS:
			case QUEST_GERTRUDES_CAT:
			case QUEST_IN_SEARCH_OF_THE_MYREQUE:
			case QUEST_JUNGLE_POTION:
			case QUEST_MONKEY_MADNESS_I:
			case QUEST_MOURNINGS_ENDS_PART_I:
			case QUEST_OBSERVATORY_QUEST:
			case QUEST_ONE_SMALL_FAVOUR:
			case QUEST_PLAGUE_CITY:
			case QUEST_PRIEST_IN_PERIL:
			case QUEST_REGICIDE:
			case QUEST_ROVING_ELVES:
			case QUEST_RUM_DEAL:
			case QUEST_SHILO_VILLAGE:
			case QUEST_THRONE_OF_MISCELLANIA:
			case QUEST_TROLL_ROMANCE:
			case QUEST_WATCHTOWER:
			case QUEST_THE_GREAT_BRAIN_ROBBERY:
			case QUEST_RAG_AND_BONE_MAN:
			case QUEST_RAG_AND_BONE_MAN_II:
				return getStateBiggerOrEqual(client);
			case QUEST_TEMPLE_OF_IKOV:
				return getTempleOfIkovState(client);
			case QUEST_ELEMENTAL_WORKSHOP_I:
				return getElementalWorkshopIState(client);
			case QUEST_UNDERGROUND_PASS:
				return getUndergroundPassState(client);
			//mini-quests
			case QUEST_ENTER_THE_ABYSS:
			case QUEST_THE_MAGE_ARENA:
				return getStateBiggerOrEqual(client);
			case QUEST_ALFRED_GRIMHANDS_BARCRAWL:
				return getBarcrawlState(client);
			default:
				return QuestState.NOT_STARTED;
		}
	}

	/**
	 * Checks if the current quest state is equal to the completionValue of the quest
	 *
	 * @param client the client gets used to get the current quest state
	 * @return QuestState enum value that tells the current state
	 */
	private QuestState getStateEqual(Client client)
	{
		int varValue = getVar(client);

		if (varValue == completionValue)
		{
			return QuestState.COMPLETED;
		}
		else if (varValue == 0)
		{
			return QuestState.NOT_STARTED;
		}
		else
		{
			return QuestState.STARTED;
		}
	}

	/**
	 * Checks if the current quest state is equal to or bigger than the completionValue of the quest
	 *
	 * @param client the client gets used to get the current quest state
	 * @return QuestState enum value that tells the current state
	 */
	private QuestState getStateBiggerOrEqual(Client client)
	{
		int varValue = getVar(client);

		if (varValue >= completionValue)
		{
			return QuestState.COMPLETED;
		}
		else if (varValue == 0)
		{
			return QuestState.NOT_STARTED;
		}
		else
		{
			return QuestState.STARTED;
		}
	}

	/**
	 * Checks if Shield of Arrav has been completed
	 * This quest has 2 different varps to check as well as 2 different completion values.
	 * The reason is that this quest has 2 different routes a player can take.
	 *
	 * @param client the client gets used to get the current quest state
	 * @return true if completed, false if not
	 */
	private QuestState getShieldOfArravState(Client client)
	{
		final int extraCompletionValue = 4;
		int varValue = getVar(client);
		int extraVarpValue = client.getVar(VarPlayer.QUEST_SHIELD_OF_ARRAV_STATE_146);

		if (varValue == completionValue || extraVarpValue == extraCompletionValue)
		{
			return QuestState.COMPLETED;
		}
		else if (varValue == 0 && extraVarpValue == 0)
		{
			return QuestState.NOT_STARTED;
		}
		else
		{
			return QuestState.STARTED;
		}
	}

	/**
	 * Checks if Temple of Ikov has been completed
	 * This quest has 2 completionvalues
	 *
	 * @param client the client gets used to get the current quest state
	 * @return true if completed, false if not
	 */
	private QuestState getTempleOfIkovState(Client client)
	{
		final int extraCompletionValue = 90;
		int varpValue = getVar(client);

		if (varpValue == completionValue || varpValue == extraCompletionValue)
		{
			return QuestState.COMPLETED;
		}
		else if (varpValue == 0)
		{
			return QuestState.NOT_STARTED;
		}
		else
		{
			return QuestState.STARTED;
		}
	}

	/**
	 * Checks if the barcrawl has been completed
	 * This mini-quest has 2 different varps and completionvalues
	 *
	 * @param client the client gets used to get the current quest state
	 * @return true if completed, false if not
	 */
	private QuestState getBarcrawlState(Client client)
	{
		final int extraCompletionValue = 6;
		int varpValue = getVar(client);
		int extraVarpValue = client.getVar(VarPlayer.QUEST_ALFRED_GRIMHANDS_BARCRAWL_STATE_76);

		if (varpValue == completionValue || extraVarpValue >= extraCompletionValue)
		{
			return QuestState.COMPLETED;
		}
		else if (varpValue == 0)
		{
			return QuestState.NOT_STARTED;
		}
		else
		{
			return QuestState.STARTED;
		}
	}

	/**
	 * Checks if Elemental Workshop I has been completed
	 * This quest state is an unsigned int, and only jagex knows why.
	 * This quest currently does not use its completion value (internally jagex doesnt either)
	 *
	 * @param client the client gets used to get the current quest state
	 * @return QuestState enum value that tells the current state
	 */
	private QuestState getElementalWorkshopIState(Client client)
	{
		int varpValue = getVar(client);

		if (testBit(varpValue, 20) == 1)
		{
			return QuestState.COMPLETED;
		}
		else if (testBit(varpValue, 1) == 0)
		{
			return QuestState.NOT_STARTED;
		}
		else
		{
			return QuestState.STARTED;
		}
	}

	/**
	 * Checks if Underground Pass has been completed
	 * This quest uses 2 states where 1 is an unsigned int, and only jagex knows why
	 *
	 * @param client the client gets used to get the current quest state
	 * @return QuestState enum value that tells the current state
	 */
	private QuestState getUndergroundPassState(Client client)
	{
		int varpValue = getVar(client);
		int startedVarp = client.getVar(VarPlayer.QUEST_UNDERGROUND_PASS_STATE_162);

		if (varpValue == completionValue)
		{
			return QuestState.COMPLETED;
		}
		else if (testBit(startedVarp, 11) == 0)
		{
			return QuestState.NOT_STARTED;
		}
		else
		{
			return QuestState.STARTED;
		}
	}

	/**
	 * This is specific logic used to determine if:
	 * - Elemental Workshop I has been completed or started.
	 * - Underground pass has been started.
	 * The method is a copy of how osrs has this internally as well
	 *
	 * @param varpValue the varp value that needs to be shifted (expected to be an unsigned int)
	 * @param testbit the bit that is used to shift to the right
	 * @return 1 if true, 0 if false
	 */
	private int testBit(int varpValue, int testbit)
	{
		return (varpValue >>> testbit) & 1;
	}
}
