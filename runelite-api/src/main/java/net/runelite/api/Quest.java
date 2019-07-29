/*
 * Copyright (c) 2019 Abex
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

import lombok.Getter;

public enum Quest
{
	//Free Quests
	BLACK_KNIGHTS_FORTRESS(299, "Black Knights' Fortress", VarPlayer.QUEST_BLACK_KNIGHTS_FORTRESS),
	COOKS_ASSISTANT(300, "Cook's Assistant", VarPlayer.QUEST_COOKS_ASSISTANT),
	THE_CORSAIR_CURSE(301, "The Corsair Curse", Varbits.QUEST_THE_CORSAIR_CURSE),
	DEMON_SLAYER(302, "Demon Slayer", Varbits.QUEST_DEMON_SLAYER),
	DORICS_QUEST(303, "Doric's Quest", VarPlayer.QUEST_DORICS_QUEST),
	DRAGON_SLAYER(304, "Dragon Slayer", VarPlayer.QUEST_DRAGON_SLAYER),
	ERNEST_THE_CHICKEN(305, "Ernest the Chicken", VarPlayer.QUEST_ERNEST_THE_CHICKEN),
	GOBLIN_DIPLOMACY(306, "Goblin Diplomacy", Varbits.QUEST_GOBLIN_DIPLOMACY),
	IMP_CATCHER(307, "Imp Catcher", VarPlayer.QUEST_IMP_CATCHER),
	THE_KNIGHTS_SWORD(308, "The Knight's Sword", VarPlayer.QUEST_THE_KNIGHTS_SWORD),
	MISTHALIN_MYSTERY(309, "Misthalin Mystery", Varbits.QUEST_MISTHALIN_MYSTERY),
	PIRATES_TREASURE(310, "Pirate's Treasure", VarPlayer.QUEST_PIRATES_TREASURE),
	PRINCE_ALI_RESCUE(311, "Prince Ali Rescue", VarPlayer.QUEST_PRINCE_ALI_RESCUE),
	THE_RESTLESS_GHOST(312, "The Restless Ghost", VarPlayer.QUEST_THE_RESTLESS_GHOST),
	ROMEO__JULIET(313, "Romeo & Juliet", VarPlayer.QUEST_ROMEO_AND_JULIET),
	RUNE_MYSTERIES(314, "Rune Mysteries", VarPlayer.QUEST_RUNE_MYSTERIES),
	SHEEP_SHEARER(315, "Sheep Shearer", VarPlayer.QUEST_SHEEP_SHEARER),
	SHIELD_OF_ARRAV(316, "Shield of Arrav", VarPlayer.QUEST_SHIELD_OF_ARRAV),
	VAMPIRE_SLAYER(317, "Vampire Slayer", VarPlayer.QUEST_VAMPIRE_SLAYER),
	WITCHS_POTION(318, "Witch's Potion", VarPlayer.QUEST_WITCHS_POTION),
	X_MARKS_THE_SPOT(550, "X Marks the Spot", Varbits.QUEST_X_MARKS_THE_SPOT),

	//Members' Quests
	ANIMAL_MAGNETISM(331, "Animal Magnetism", Varbits.QUEST_ANIMAL_MAGNETISM),
	ANOTHER_SLICE_OF_HAM(332, "Another Slice of H.A.M.", Varbits.QUEST_ANOTHER_SLICE_OF_HAM),
	BETWEEN_A_ROCK(333, "Between a Rock...", Varbits.QUEST_BETWEEN_A_ROCK),
	BIG_CHOMPY_BIRD_HUNTING(334, "Big Chompy Bird Hunting", VarPlayer.QUEST_BIG_CHOMPY_BIRD_HUNTING),
	BIOHAZARD(335, "Biohazard", VarPlayer.QUEST_BIOHAZARD),
	CABIN_FEVER(336, "Cabin Fever", VarPlayer.QUEST_CABIN_FEVER),
	CLOCK_TOWER(337, "Clock Tower", VarPlayer.QUEST_CLOCK_TOWER),
	COLD_WAR(338, "Cold War", Varbits.QUEST_COLD_WAR),
	CONTACT(339, "Contact!", Varbits.QUEST_CONTACT),
	CREATURE_OF_FENKENSTRAIN(340, "Creature of Fenkenstrain", VarPlayer.QUEST_CREATURE_OF_FENKENSTRAIN),
	DARKNESS_OF_HALLOWVALE(341, "Darkness of Hallowvale", Varbits.QUEST_DARKNESS_OF_HALLOWVALE),
	DEATH_PLATEAU(342, "Death Plateau", VarPlayer.QUEST_DEATH_PLATEAU),
	DEATH_TO_THE_DORGESHUUN(343, "Death to the Dorgeshuun", Varbits.QUEST_DEATH_TO_THE_DORGESHUUN),
	THE_DEPTHS_OF_DESPAIR(344, "The Depths of Despair", Varbits.QUEST_THE_DEPTHS_OF_DESPAIR),
	DESERT_TREASURE(345, "Desert Treasure", Varbits.QUEST_DESERT_TREASURE),
	DEVIOUS_MINDS(346, "Devious Minds", Varbits.QUEST_DEVIOUS_MINDS),
	THE_DIG_SITE(347, "The Dig Site", VarPlayer.QUEST_THE_DIG_SITE),
	DRAGON_SLAYER_II(348, "Dragon Slayer II", Varbits.QUEST_DRAGON_SLAYER_II),
	DREAM_MENTOR(349, "Dream Mentor", Varbits.QUEST_DREAM_MENTOR),
	DRUIDIC_RITUAL(350, "Druidic Ritual", VarPlayer.QUEST_DRUIDIC_RITUAL),
	DWARF_CANNON(351, "Dwarf Cannon", Varbits.QUEST_THE_GIANT_DWARF),
	EADGARS_RUSE(352, "Eadgar's Ruse", VarPlayer.QUEST_EADGARS_RUSE),
	EAGLES_PEAK(353, "Eagles' Peak", Varbits.QUEST_EAGLES_PEAK),
	ELEMENTAL_WORKSHOP_I(354, "Elemental Workshop I", VarPlayer.QUEST_ELEMENTAL_WORKSHOP_I),
	ELEMENTAL_WORKSHOP_II(355, "Elemental Workshop II", Varbits.QUEST_ELEMENTAL_WORKSHOP_II),
	ENAKHRAS_LAMENT(356, "Enakhra's Lament", Varbits.QUEST_ENAKHRAS_LAMENT),
	ENLIGHTENED_JOURNEY(357, "Enlightened Journey", Varbits.QUEST_ENLIGHTENED_JOURNEY),
	THE_EYES_OF_GLOUPHRIE(358, "The Eyes of Glouphrie", Varbits.QUEST_THE_EYES_OF_GLOUPHRIE),
	FAIRYTALE_I__GROWING_PAINS(359, "Fairytale I - Growing Pains", Varbits.QUEST_FAIRYTALE_I_GROWING_PAINS),
	FAIRYTALE_II__CURE_A_QUEEN(360, "Fairytale II - Cure a Queen", Varbits.QUEST_FAIRYTALE_II_CURE_A_QUEEN),
	FAMILY_CREST(361, "Family Crest", VarPlayer.QUEST_FAMILY_CREST),
	THE_FEUD(362, "The Feud", Varbits.QUEST_THE_FEUD),
	FIGHT_ARENA(363, "Fight Arena", VarPlayer.QUEST_FIGHT_ARENA),
	FISHING_CONTEST(364, "Fishing Contest", VarPlayer.QUEST_FISHING_CONTEST),
	FORGETTABLE_TALE(365, "Forgettable Tale...", Varbits.QUEST_FORGETTABLE_TALE),
	BONE_VOYAGE(366, "Bone Voyage", Varbits.QUEST_BONE_VOYAGE),
	THE_FREMENNIK_ISLES(367, "The Fremennik Isles", Varbits.QUEST_THE_FREMENNIK_ISLES),
	THE_FREMENNIK_TRIALS(368, "The Fremennik Trials", VarPlayer.QUEST_THE_FREMENNIK_TRIALS),
	GARDEN_OF_TRANQUILLITY(369, "Garden of Tranquillity", Varbits.QUEST_GARDEN_OF_TRANQUILLITY),
	GERTRUDES_CAT(370, "Gertrude's Cat", VarPlayer.QUEST_GERTRUDES_CAT),
	GHOSTS_AHOY(371, "Ghosts Ahoy", Varbits.QUEST_GHOSTS_AHOY),
	THE_GIANT_DWARF(372, "The Giant Dwarf", Varbits.QUEST_THE_GIANT_DWARF),
	THE_GOLEM(373, "The Golem", Varbits.QUEST_THE_GOLEM),
	THE_GRAND_TREE(374, "The Grand Tree", VarPlayer.QUEST_THE_GRAND_TREE),
	THE_GREAT_BRAIN_ROBBERY(375, "The Great Brain Robbery", VarPlayer.QUEST_THE_GREAT_BRAIN_ROBBERY),
	GRIM_TALES(376, "Grim Tales", Varbits.QUEST_GRIM_TALES),
	THE_HAND_IN_THE_SAND(377, "The Hand in the Sand", Varbits.QUEST_THE_HAND_IN_THE_SAND),
	HAUNTED_MINE(378, "Haunted Mine", VarPlayer.QUEST_HAUNTED_MINE),
	HAZEEL_CULT(379, "Hazeel Cult", VarPlayer.QUEST_HAZEEL_CULT),
	HEROES_QUEST(380, "Heroes' Quest", VarPlayer.QUEST_HEROES_QUEST),
	HOLY_GRAIL(381, "Holy Grail", VarPlayer.QUEST_HOLY_GRAIL),
	HORROR_FROM_THE_DEEP(382, "Horror from the Deep", Varbits.QUEST_HORROR_FROM_THE_DEEP),
	ICTHLARINS_LITTLE_HELPER(383, "Icthlarin's Little Helper", Varbits.QUEST_ICTHLARINS_LITTLE_HELPER),
	IN_AID_OF_THE_MYREQUE(384, "In Aid of the Myreque", Varbits.QUEST_IN_AID_OF_THE_MYREQUE),
	IN_SEARCH_OF_THE_MYREQUE(385, "In Search of the Myreque", VarPlayer.QUEST_IN_SEARCH_OF_THE_MYREQUE),
	JUNGLE_POTION(386, "Jungle Potion", VarPlayer.QUEST_JUNGLE_POTION),
	KINGS_RANSOM(387, "King's Ransom", Varbits.QUEST_KINGS_RANSOM),
	LEGENDS_QUEST(388, "Legends' Quest", VarPlayer.QUEST_LEGENDS_QUEST),
	LOST_CITY(389, "Lost City", VarPlayer.QUEST_LOST_CITY),
	THE_LOST_TRIBE(390, "The Lost Tribe", Varbits.QUEST_THE_LOST_TRIBE),
	LUNAR_DIPLOMACY(391, "Lunar Diplomacy", Varbits.QUEST_LUNAR_DIPLOMACY),
	MAKING_FRIENDS_WITH_MY_ARM(392, "Making Friends with My Arm", Varbits.QUEST_MAKING_FRIENDS_WITH_MY_ARM),
	MAKING_HISTORY(393, "Making History", Varbits.QUEST_MAKING_HISTORY),
	MERLINS_CRYSTAL(394, "Merlin's Crystal", VarPlayer.QUEST_MERLINS_CRYSTAL),
	MONKEY_MADNESS_I(395, "Monkey Madness I", VarPlayer.QUEST_MONKEY_MADNESS_I),
	MONKEY_MADNESS_II(396, "Monkey Madness II", Varbits.QUEST_MONKEY_MADNESS_II),
	MONKS_FRIEND(397, "Monk's Friend", VarPlayer.QUEST_MONKS_FRIEND),
	MOUNTAIN_DAUGHTER(398, "Mountain Daughter", Varbits.QUEST_MOUNTAIN_DAUGHTER),
	MOURNINGS_END_PART_I(399, "Mourning's End Part I", VarPlayer.QUEST_MOURNINGS_END_PART_I),
	MOURNINGS_END_PART_II(400, "Mourning's End Part II", Varbits.QUEST_MOURNINGS_END_PART_II),
	MURDER_MYSTERY(401, "Murder Mystery", VarPlayer.QUEST_MURDER_MYSTERY),
	MY_ARMS_BIG_ADVENTURE(402, "My Arm's Big Adventure", Varbits.QUEST_MY_ARMS_BIG_ADVENTURE),
	NATURE_SPIRIT(403, "Nature Spirit", VarPlayer.QUEST_NATURE_SPIRIT),
	OBSERVATORY_QUEST(404, "Observatory Quest", VarPlayer.QUEST_OBSERVATORY_QUEST),
	OLAFS_QUEST(405, "Olaf's Quest", Varbits.QUEST_OLAFS_QUEST),
	ONE_SMALL_FAVOUR(406, "One Small Favour", VarPlayer.QUEST_ONE_SMALL_FAVOUR),
	PLAGUE_CITY(407, "Plague City", VarPlayer.QUEST_PLAGUE_CITY),
	PRIEST_IN_PERIL(408, "Priest in Peril", VarPlayer.QUEST_PRIEST_IN_PERIL),
	THE_QUEEN_OF_THIEVES(409, "The Queen of Thieves", Varbits.QUEST_THE_QUEEN_OF_THIEVES),
	RAG_AND_BONE_MAN(410, "Rag and Bone Man", VarPlayer.QUEST_RAG_AND_BONE_MAN),
	RAG_AND_BONE_MAN_II(411, "Rag and Bone Man II", VarPlayer.QUEST_RAG_AND_BONE_MAN_II),
	RATCATCHERS(412, "Ratcatchers", Varbits.QUEST_RATCATCHERS),
	RECIPE_FOR_DISASTER(413, "Recipe for Disaster", Varbits.QUEST_RECIPE_FOR_DISASTER),
	RECRUITMENT_DRIVE(414, "Recruitment Drive", Varbits.QUEST_RECRUITMENT_DRIVE),
	REGICIDE(415, "Regicide", VarPlayer.QUEST_REGICIDE),
	ROVING_ELVES(416, "Roving Elves", VarPlayer.QUEST_ROVING_ELVES),
	ROYAL_TROUBLE(417, "Royal Trouble", Varbits.QUEST_ROYAL_TROUBLE),
	RUM_DEAL(418, "Rum Deal", VarPlayer.QUEST_RUM_DEAL),
	SCORPION_CATCHER(419, "Scorpion Catcher", VarPlayer.QUEST_SCORPION_CATCHER),
	SEA_SLUG(420, "Sea Slug", VarPlayer.QUEST_SEA_SLUG),
	SHADES_OF_MORTTON(421, "Shades of Mort'ton", VarPlayer.QUEST_SHADES_OF_MORTTON),
	SHADOW_OF_THE_STORM(422, "Shadow of the Storm", Varbits.QUEST_SHADOW_OF_THE_STORM),
	SHEEP_HERDER(423, "Sheep Herder", VarPlayer.QUEST_SHEEP_HERDER),
	SHILO_VILLAGE(424, "Shilo Village", VarPlayer.QUEST_SHILO_VILLAGE),
	THE_SLUG_MENACE(425, "The Slug Menace", Varbits.QUEST_THE_SLUG_MENACE),
	A_SOULS_BANE(426, "A Soul's Bane", Varbits.QUEST_A_SOULS_BANE),
	SPIRITS_OF_THE_ELID(427, "Spirits of the Elid", Varbits.QUEST_SPIRITS_OF_THE_ELID),
	SWAN_SONG(428, "Swan Song", Varbits.QUEST_SWAN_SONG),
	TAI_BWO_WANNAI_TRIO(429, "Tai Bwo Wannai Trio", VarPlayer.QUEST_TAI_BWO_WANNAI_TRIO),
	A_TAIL_OF_TWO_CATS(430, "A Tail of Two Cats", Varbits.QUEST_A_TAIL_OF_TWO_CATS),
	TALE_OF_THE_RIGHTEOUS(431, "Tale of the Righteous", Varbits.QUEST_TALE_OF_THE_RIGHTEOUS),
	A_TASTE_OF_HOPE(432, "A Taste of Hope", Varbits.QUEST_A_TASTE_OF_HOPE),
	TEARS_OF_GUTHIX(433, "Tears of Guthix", Varbits.QUEST_TEARS_OF_GUTHIX),
	TEMPLE_OF_IKOV(434, "Temple of Ikov", VarPlayer.QUEST_TEMPLE_OF_IKOV),
	THRONE_OF_MISCELLANIA(435, "Throne of Miscellania", VarPlayer.QUEST_THRONE_OF_MISCELLANIA),
	THE_TOURIST_TRAP(436, "The Tourist Trap", VarPlayer.QUEST_THE_TOURIST_TRAP),
	TOWER_OF_LIFE(437, "Tower of Life", Varbits.QUEST_TOWER_OF_LIFE),
	TREE_GNOME_VILLAGE(438, "Tree Gnome Village", VarPlayer.QUEST_TREE_GNOME_VILLAGE),
	TRIBAL_TOTEM(439, "Tribal Totem", VarPlayer.QUEST_TRIBAL_TOTEM),
	TROLL_ROMANCE(440, "Troll Romance", VarPlayer.QUEST_TROLL_ROMANCE),
	TROLL_STRONGHOLD(441, "Troll Stronghold", VarPlayer.QUEST_TROLL_STRONGHOLD),
	UNDERGROUND_PASS(442, "Underground Pass", VarPlayer.QUEST_UNDERGROUND_PASS),
	CLIENT_OF_KOUREND(443, "Client of Kourend", Varbits.QUEST_CLIENT_OF_KOUREND),
	WANTED(444, "Wanted!", Varbits.QUEST_WANTED),
	WATCHTOWER(445, "Watchtower", VarPlayer.QUEST_WATCHTOWER),
	WATERFALL_QUEST(446, "Waterfall Quest", VarPlayer.QUEST_WATERFALL_QUEST),
	WHAT_LIES_BELOW(447, "What Lies Below", Varbits.QUEST_WHAT_LIES_BELOW),
	WITCHS_HOUSE(448, "Witch's House", VarPlayer.QUEST_WITCHS_HOUSE),
	ZOGRE_FLESH_EATERS(449, "Zogre Flesh Eaters", Varbits.QUEST_ZOGRE_FLESH_EATERS),
	THE_ASCENT_OF_ARCEUUS(542, "The Ascent of Arceuus", Varbits.QUEST_THE_ASCENT_OF_ARCEUUS),
	THE_FORSAKEN_TOWER(543, "The Forsaken Tower", Varbits.QUEST_THE_FORSAKEN_TOWER),
	SONG_OF_THE_ELVES(603, "Song of the Elves", Varbits.QUEST_SONG_OF_THE_ELVES),

	//Miniquests
	ENTER_THE_ABYSS(319, "Enter the Abyss", VarPlayer.QUEST_ENTER_THE_ABYSS),
	ARCHITECTURAL_ALLIANCE(320, "Architectural Alliance", Varbits.QUEST_ARCHITECTURAL_ALLIANCE),
	BEAR_YOUR_SOUL(321, "Bear your Soul", Varbits.QUEST_BEAR_YOUR_SOUL),
	ALFRED_GRIMHANDS_BARCRAWL(322, "Alfred Grimhand's Barcrawl", VarPlayer.QUEST_ALFRED_GRIMHANDS_BARCRAWL),
	CURSE_OF_THE_EMPTY_LORD(323, "Curse of the Empty Lord", Varbits.QUEST_CURSE_OF_THE_EMPTY_LORD),
	ENCHANTED_KEY(324, "Enchanted Key", Varbits.QUEST_ENCHANTED_KEY),
	THE_GENERALS_SHADOW(325, "The General's Shadow", Varbits.QUEST_THE_GENERALS_SHADOW),
	SKIPPY_AND_THE_MOGRES(326, "Skippy and the Mogres", Varbits.QUEST_SKIPPY_AND_THE_MOGRES),
	THE_MAGE_ARENA(327, "The Mage Arena", VarPlayer.QUEST_THE_MAGE_ARENA),
	LAIR_OF_TARN_RAZORLOR(328, "Lair of Tarn Razorlor", Varbits.QUEST_LAIR_OF_TARN_RAZORLOR),
	FAMILY_PEST(329, "Family Pest", Varbits.QUEST_FAMILY_PEST),
	THE_MAGE_ARENA_II(330, "The Mage Arena II", Varbits.QUEST_THE_MAGE_ARENA_II),
	IN_SEARCH_OF_KNOWLEDGE(602, "In Search of Knowledge", Varbits.QUEST_IN_SEARCH_OF_KNOWLEDGE);

	@Getter
	private final int id;

	@Getter
	private final String name;

	private final Varbits varbit;

	private final VarPlayer varPlayer;

	Quest(int id, String name, Varbits varbit)
	{
		this.id = id;
		this.name = name;
		this.varbit = varbit;
		this.varPlayer = null;
	}

	Quest(int id, String name, VarPlayer varPlayer)
	{
		this.id = id;
		this.name = name;
		this.varbit = null;
		this.varPlayer = varPlayer;
	}

	public QuestState getState(Client client)
	{
		client.runScript(ScriptID.QUESTLIST_PROGRESS, id);
		switch (client.getIntStack()[0])
		{
			case 2:
				return QuestState.FINISHED;
			case 1:
				return QuestState.NOT_STARTED;
			default:
				return QuestState.IN_PROGRESS;
		}
	}

	public int getVar(Client client)
	{
		if (varbit != null)
		{
			return client.getVar(varbit);
		}
		else
		{
			return client.getVar(varPlayer);
		}
	}
}
