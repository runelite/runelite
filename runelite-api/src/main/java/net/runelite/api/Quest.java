/*
 * Copyright (c) 2019, Spedwards <http://github.com/Spedwards>
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

public enum Quest
{
	// FREE QUESTS
	BLACK_KNIGHTS_FORTRESS(0, 1357, "Black Knight's Fortress"),
	COOKS_ASSISTANT(1, 1357, "Cook's Assistant"),
	DEMON_SLAYER(2, 1357, "Demon Slayer"),
	DORICS_QUEST(3, 1357, "Doric's Quest"),
	DRAGON_SLAYER(4, 1357, "Dragon Slayer"),
	ERNEST_THE_CHICKEN(5, 1357, "Ernest the Chicken"),
	GOBLIN_DIPLOMACY(6, 1357, "Goblin Diplomacy"),
	IMP_CATCHER(7, 1357, "Imp Catcher"),
	THE_KNIGHTS_SWORD(8, 1357, "The Knight's Sword"),
	PIRATES_TREASURE(9, 1357, "Pirate's Treasure"),
	PRINCE_ALI_RESCUE(10, 1357, "Prince Ali Rescue"),
	THE_RESTLESS_GHOST(11, 1357, "The Restless Ghost"),
	ROMEO_AND_JULIET(12, 1357, "Romeo & Juliet"),
	RUNE_MYSTERIES(13, 1357, "Rune Mysteries"),
	SHEEP_SHEARER(14, 1357, "Sheep Shearer"),
	SHIELD_OF_ARRAV(15, 1357, "Shield of Arrav"),
	VAMPIRE_SLAYER(16, 1357, "Vampire Slayer"),
	WITCHS_POTION(17, 1357, "Witch's Potion"),
	MISTHALIN_MYSTERY(18, 1357, "Misthalin Mystery"),
	THE_CORSAIR_CURSE(19, 1357, "The Corsair Curse"),

	// MEMBERS QUESTS
	ANIMAL_MAGNETISM(0, 1358, "Animal Magnetism"),
	BETWEEN_A_ROCK(1, 1358, "Between a Rock..."),
	BIG_CHOMPY_BIRD_HUNTING(2, 1358, "Big Chompy Bird Hunting"),
	BIOHAZARD(3, 1358, "Biohazard"),
	CABIN_FEVER(4, 1358, "Cabin Fever"),
	CLOCK_TOWER(5, 1358, "Clock Tower"),
	CONTACT(6, 1358, "Contact!"),
	ZOGRE_FLESH_EATERS(7, 1358, "Zogre Flesh Eaters"),
	CREATURE_OF_FENKENSTRAIN(8, 1358, "Creature of Fenkenstrain"),
	DARKNESS_OF_HALLOWVALE(9, 1358, "Darkness of Hallowvale"),
	DEATH_TO_THE_DORGESHUUN(10, 1358, "Death to the Dorgeshuun"),
	DEATH_PLATEAU(11, 1358, "Death Plateau"),
	DESERT_TREASURE(12, 1358, "Desert Treasure"),
	DEVIOUS_MINDS(13, 1358, "Devious Minds"),
	THE_DIG_SITE(14, 1358, "The Dig Site"),
	DRUIDIC_RITUAL(15, 1358, "Druidic Ritual"),
	DWARF_CANNON(16, 1358, "Dwarf Cannon"),
	EADGARS_RUSE(17, 1358, "Eadgar's Ruse"),
	EAGLES_PEAK(18, 1358, "Eagle's Peak"),
	ELEMENTAL_WORKSHOP_I(19, 1358, "Elemental Workshop I"),
	ELEMENTAL_WORKSHOP_II(20, 1358, "Elemental Workshop II"),
	ENAKHRAS_LAMENT(21, 1358, "Enakhra's Lament"),
	ENLIGHTENED_JOURNEY(22, 1358, "Enlightened Journey"),
	THE_EYES_OF_GLOUPHRIE(23, 1358, "The Eyes of Glouphrie"),
	FAIRYTALE_I(24, 1358, "Fairytale I - Growing Pains"),
	FAIRYTALE_II(25, 1358, "Fairytale II - Cure a Queen"),
	FAMILY_CREST(26, 1358, "Family Crest"),
	THE_FEUD(27, 1358, "The Feud"),
	FIGHT_ARENA(28, 1358, "Fight Arena"),
	FISHING_CONTEST(29, 1358, "Fishing Contest"),
	FORGETTABLE_TALE(30, 1358, "Forgettable Tale..."),
	THE_FREMENNIK_TRIALS(31, 1358, "The Fremennik Trials"),
	WATERFALL_QUEST(32, 1358, "Waterfall Quest"),
	GARDEN_OF_TRANQUILLITY(33, 1358, "Garden of Tranquillity"),
	GERTRUDES_CAT(34, 1358, "Gertrude's Cat"),
	GHOSTS_AHOY(35, 1358, "Ghosts Ahoy"),
	THE_GIANT_DWARF(36, 1358, "The Giant Dwarf"),
	THE_GOLEM(37, 1358, "The Golem"),
	THE_GRAND_TREE(38, 1358, "The Grand Tree"),
	THE_HAND_IN_THE_SAND(39, 1358, "The Hand in the Sand"),
	HAUNTED_MINE(40, 1358, "Haunted Mine"),
	HAZEEL_CULT(41, 1358, "Hazeel Cult"),
	HEROES_QUEST(42, 1358, "Heroes' Quest"),
	HOLY_GRAIL(43, 1358, "Holy Grail"),
	HORROR_FROM_THE_DEEP(44, 1358, "Horror from the Deep"),
	ICTHLARINS_LITTLE_HELPER(45, 1358, "Icthlarin's Little Helper"),
	IN_AID_OF_THE_MYREQUE(46, 1358, "In Aid of the Myreque"),
	IN_SEARCH_OF_THE_MYREQUE(47, 1358, "In Search of the Myreque"),
	JUNGLE_POTION(48, 1358, "Jungle Potion"),
	LEGENDS_QUEST(49, 1358, "Legend's Quest"),
	LOST_CITY(50, 1358, "Lost City"),
	THE_LOST_TRIBE(51, 1358, "The Lost Tribe"),
	LUNAR_DIPLOMACY(52, 1358, "Lunar Diplomacy"),
	MAKING_HISTORY(53, 1358, "Making History"),
	MERLINS_CRYSTAL(54, 1358, "Merlin's Crystal"),
	MONKEY_MADNESS_I(55, 1358, "Monkey Madness I"),
	MONKS_FRIEND(56, 1358, "Monk's Friend"),
	MOUNTAIN_DAUGHTER(57, 1358, "Mountain Daughter"),
	MOURNINGS_END_PART_I(58, 1358, "Mourning's End Part I"),
	MOURNINGS_END_PART_II(59, 1358, "Mourning's End Part II"),
	MURDER_MYSTERY(60, 1358, "Murder Mystery"),
	MY_ARMS_BIG_ADVENTURE(61, 1358, "My Arm's Big Adventure"),
	NATURE_SPIRIT(62, 1358, "Nature Spirit"),
	OBSERVATORY_QUEST(63, 1358, "Observatory Quest"),
	ONE_SMALL_FAVOUR(64, 1358, "One Small Favour"),
	PLAGUE_CITY(65, 1358, "Plague City"),
	PRIEST_IN_PERIL(66, 1358, "Priest in Peril"),
	RAG_AND_BONE_MAN(67, 1358, "Rag and Bone Man"),
	RATCATCHERS(68, 1358, "Ratcatchers"),
	RECIPE_FOR_DISASTER(69, 1358, "Recipe for Disaster"),
	RECRUITMENT_DRIVE(70, 1358, "Recruitment Drive"),
	REGICIDE(71, 1358, "Regicide"),
	ROVING_ELVES(72, 1358, "Roving Elves"),
	ROYAL_TROUBLE(73, 1358, "Royal Trouble"),
	RUM_DEAL(74, 1358, "Rum Deal"),
	SCORPION_CATCHER(75, 1358, "Scorpion Catcher"),
	SEA_SLUG(76, 1358, "Sea Slug"),
	THE_SLUG_MENACE(77, 1358, "The Slug Menace"),
	SHADES_OF_MORTTON(78, 1358, "Shades of Mort'ton"),
	SHADOW_OF_THE_STORM(79, 1358, "Shadow of the Storm"),
	SHEEP_HERDER(80, 1358, "Sheep Herder"),
	SHILO_VILLAGE(81, 1358, "Shilo Village"),
	A_SOULS_BANE(82, 1358, "A Soul's Bane"),
	SPIRITS_OF_THE_ELID(83, 1358, "Spirits of the Elid"),
	SWAN_SONG(84, 1358, "Swan Song"),
	TAI_BWO_WANNAI_TRIO(85, 1358, "Tai Bwo Wannai Trio"),
	A_TAIL_OF_TWO_CATS(86, 1358, "A Tail of Two Cats"),
	TEARS_OF_GUTHIX(87, 1358, "Tears of Guthix"),
	TEMPLE_OF_IKOV(88, 1358, "Temple of Ikov"),
	THRONE_OF_MISCELLANIA(89, 1358, "Throne of Miscellania"),
	THE_TOURIST_TRAP(90, 1358, "The Tourist Trap"),
	WITCHS_HOUSE(91, 1358, "Witch's House"),
	TREE_GNOME_VILLAGE(92, 1358, "Tree Gnome Village"),
	TRIBAL_TOTEM(93, 1358, "Tribal Totem"),
	TROLL_ROMANCE(94, 1358, "Troll Romance"),
	TROLL_STRONGHOLD(95, 1358, "Troll Stronghold"),
	UNDERGROUND_PASS(96, 1358, "Underground Pass"),
	WANTED(97, 1358, "Wanted!"),
	WATCHTOWER(98, 1358, "Watchtower"),
	COLD_WAR(99, 1358, "Cold War"),
	THE_FREMENNIK_ISLES(100, 1358, "The Fremennik Isles"),
	TOWER_OF_LIFE(101, 1358, "Tower of Life"),
	THE_GREAT_BRAIN_ROBBERY(102, 1358, "The Great Brain Robbery"),
	WHAT_LIES_BELOW(103, 1358, "What Lies Below"),
	OLAFS_QUEST(104, 1358, "Olaf's Quest"),
	ANOTHER_SLICE_OF_HAM(105, 1358, "Another Slice of H.A.M."),
	DREAM_MENTOR(106, 1358, "Dream Mentor"),
	GRIM_TALES(107, 1358, "Grim Tales"),
	KINGS_RANSOM(108, 1358, "King's Ransom"),
	MONKEY_MADNESS_II(109, 1358, "Monkey Madness II"),
	CLIENT_OF_KOUREND(110, 1358, "Client of Kourend"),
	RAG_AND_BONE_MAN_II(111, 1358, "Rag and Bone Man II"),
	BONE_VOYAGE(112, 1358, "Bone Voyage"),
	THE_QUEEN_OF_THIEVES(113, 1358, "The Queen of Thieves"),
	THE_DEPTHS_OF_DESPAIR(114, 1358, "The Depths of Despair"),
	DRAGON_SLAYER_II(115, 1358, "Dragon Slayer II"),
	TALE_OF_THE_RIGHTEOUS(116, 1358, "Tale of the Righteous"),
	A_TASTE_OF_HOPE(117, 1358, "A Taste of Hope"),
	MAKING_FRIENDS_WITH_MY_ARM(118, 1358, "Making Friends with My Arm"),

	// MINI QUESTS
	ENTER_THE_ABYSS(0, 1359, "Enter the Abyss"),
	ARCHITECTURAL_ALLIANCE(1, 1359, "Architectural Alliance"),
	BEAR_YOUR_SOUL(2, 1359, "Bear your Soul"),
	ALFRED_GRIMHANDS_BARCRAWL(3, 1359, "Alfred Grimhand's Barcrawl"),
	CURSE_OF_THE_EMPTY_LORD(4, 1359, "Curse of the Empty Lord"),
	ENCHANTED_KEY(5, 1359, "Enchanted Key"),
	THE_GENERALS_SHADOW(6, 1359, "The General's Shadow"),
	SKIPPY_AND_THE_MOGRES(7, 1359, "Skippy and the Mogres"),
	THE_MAGE_ARENA(8, 1359, "The Mage Arena"),
	LAIR_OF_TARN_RAZORLOR(9, 1359, "Lair of Tarn Razorlor"),
	FAMILY_PEST(10, 1359, "Family Pest"),
	THE_MAGE_ARENA_II(11, 1359, "The Mage Arena II");

	public static final int FREE_QUEST = 1357;
	public static final int MEMBER_QUEST = 1358;
	public static final int MINI_QUEST = 1359;

	private final int id;
	private final int type;
	private final String name;

	Quest(int id, int type, String name)
	{
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public int getID()
	{
		return id;
	}

	public int getType()
	{
		return type;
	}

	public String getName()
	{
		return name;
	}
}
