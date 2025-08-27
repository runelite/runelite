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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Quest
{
	ANIMAL_MAGNETISM(0, "Animal Magnetism"),
	ANOTHER_SLICE_OF_HAM(1, "Another Slice of H.A.M."),
	THE_ASCENT_OF_ARCEUUS(3, "The Ascent of Arceuus"),
	ALFRED_GRIMHANDS_BARCRAWL(4, "Alfred Grimhand's Barcrawl"),
	BEAR_YOUR_SOUL(5, "Bear Your Soul"),
	BELOW_ICE_MOUNTAIN(6, "Below Ice Mountain"),
	BETWEEN_A_ROCK(7, "Between a Rock..."),
	BIG_CHOMPY_BIRD_HUNTING(8, "Big Chompy Bird Hunting"),
	BIOHAZARD(9, "Biohazard"),
	BLACK_KNIGHTS_FORTRESS(10, "Black Knights' Fortress"),
	BONE_VOYAGE(11, "Bone Voyage"),
	CABIN_FEVER(12, "Cabin Fever"),
	CLIENT_OF_KOUREND(13, "Client of Kourend"),
	CLOCK_TOWER(14, "Clock Tower"),
	COLD_WAR(15, "Cold War"),
	CONTACT(16, "Contact!"),
	COOKS_ASSISTANT(17, "Cook's Assistant"),
	THE_CORSAIR_CURSE(18, "The Corsair Curse"),
	CREATURE_OF_FENKENSTRAIN(19, "Creature of Fenkenstrain"),
	CURSE_OF_THE_EMPTY_LORD(20, "Curse of the Empty Lord"),
	DADDYS_HOME(21, "Daddy's Home"),
	DARKNESS_OF_HALLOWVALE(22, "Darkness of Hallowvale"),
	DEATH_PLATEAU(23, "Death Plateau"),
	DEATH_TO_THE_DORGESHUUN(24, "Death to the Dorgeshuun"),
	DEMON_SLAYER(25, "Demon Slayer"),
	THE_DEPTHS_OF_DESPAIR(26, "The Depths of Despair"),
	DESERT_TREASURE_I(27, "Desert Treasure I"),
	DEVIOUS_MINDS(28, "Devious Minds"),
	THE_DIG_SITE(29, "The Dig Site"),
	DORICS_QUEST(30, "Doric's Quest"),
	DRAGON_SLAYER_I(31, "Dragon Slayer I"),
	DRAGON_SLAYER_II(32, "Dragon Slayer II"),
	DREAM_MENTOR(33, "Dream Mentor"),
	DRUIDIC_RITUAL(34, "Druidic Ritual"),
	DWARF_CANNON(35, "Dwarf Cannon"),
	EADGARS_RUSE(36, "Eadgar's Ruse"),
	EAGLES_PEAK(37, "Eagles' Peak"),
	ELEMENTAL_WORKSHOP_I(38, "Elemental Workshop I"),
	ELEMENTAL_WORKSHOP_II(39, "Elemental Workshop II"),
	ENAKHRAS_LAMENT(40, "Enakhra's Lament"),
	THE_ENCHANTED_KEY(41, "The Enchanted Key"),
	ENLIGHTENED_JOURNEY(42, "Enlightened Journey"),
	ENTER_THE_ABYSS(43, "Enter the Abyss"),
	ERNEST_THE_CHICKEN(44, "Ernest the Chicken"),
	THE_EYES_OF_GLOUPHRIE(45, "The Eyes of Glouphrie"),
	FAIRYTALE_I__GROWING_PAINS(46, "Fairytale I - Growing Pains"),
	FAIRYTALE_II__CURE_A_QUEEN(47, "Fairytale II - Cure a Queen"),
	FAMILY_CREST(48, "Family Crest"),
	FAMILY_PEST(49, "Family Pest"),
	THE_FEUD(50, "The Feud"),
	FIGHT_ARENA(51, "Fight Arena"),
	FISHING_CONTEST(52, "Fishing Contest"),
	FORGETTABLE_TALE(53, "Forgettable Tale..."),
	THE_FORSAKEN_TOWER(54, "The Forsaken Tower"),
	THE_FREMENNIK_EXILES(55, "The Fremennik Exiles"),
	THE_FREMENNIK_ISLES(56, "The Fremennik Isles"),
	THE_FREMENNIK_TRIALS(57, "The Fremennik Trials"),
	GARDEN_OF_TRANQUILLITY(58, "Garden of Tranquillity"),
	THE_GENERALS_SHADOW(59, "The General's Shadow"),
	GERTRUDES_CAT(60, "Gertrude's Cat"),
	GETTING_AHEAD(61, "Getting Ahead"),
	GHOSTS_AHOY(62, "Ghosts Ahoy"),
	THE_GIANT_DWARF(63, "The Giant Dwarf"),
	GOBLIN_DIPLOMACY(64, "Goblin Diplomacy"),
	THE_GOLEM(65, "The Golem"),
	THE_GRAND_TREE(66, "The Grand Tree"),
	THE_GREAT_BRAIN_ROBBERY(67, "The Great Brain Robbery"),
	GRIM_TALES(68, "Grim Tales"),
	THE_HAND_IN_THE_SAND(69, "The Hand in the Sand"),
	HAUNTED_MINE(70, "Haunted Mine"),
	HAZEEL_CULT(71, "Hazeel Cult"),
	HEROES_QUEST(72, "Heroes' Quest"),
	HOLY_GRAIL(73, "Holy Grail"),
	HORROR_FROM_THE_DEEP(74, "Horror from the Deep"),
	ICTHLARINS_LITTLE_HELPER(75, "Icthlarin's Little Helper"),
	IMP_CATCHER(76, "Imp Catcher"),
	IN_AID_OF_THE_MYREQUE(77, "In Aid of the Myreque"),
	IN_SEARCH_OF_KNOWLEDGE(78, "In Search of Knowledge"),
	IN_SEARCH_OF_THE_MYREQUE(79, "In Search of the Myreque"),
	JUNGLE_POTION(80, "Jungle Potion"),
	A_KINGDOM_DIVIDED(81, "A Kingdom Divided"),
	KINGS_RANSOM(82, "King's Ransom"),
	THE_KNIGHTS_SWORD(83, "The Knight's Sword"),
	LAIR_OF_TARN_RAZORLOR(84, "Lair of Tarn Razorlor"),
	LEGENDS_QUEST(85, "Legends' Quest"),
	LOST_CITY(86, "Lost City"),
	THE_LOST_TRIBE(87, "The Lost Tribe"),
	LUNAR_DIPLOMACY(88, "Lunar Diplomacy"),
	MAGE_ARENA_I(89, "Mage Arena I"),
	MAGE_ARENA_II(90, "Mage Arena II"),
	MAKING_FRIENDS_WITH_MY_ARM(91, "Making Friends with My Arm"),
	MAKING_HISTORY(92, "Making History"),
	MERLINS_CRYSTAL(93, "Merlin's Crystal"),
	MISTHALIN_MYSTERY(94, "Misthalin Mystery"),
	MONKEY_MADNESS_I(95, "Monkey Madness I"),
	MONKEY_MADNESS_II(96, "Monkey Madness II"),
	MONKS_FRIEND(97, "Monk's Friend"),
	MOUNTAIN_DAUGHTER(98, "Mountain Daughter"),
	MOURNINGS_END_PART_I(99, "Mourning's End Part I"),
	MOURNINGS_END_PART_II(100, "Mourning's End Part II"),
	MURDER_MYSTERY(101, "Murder Mystery"),
	MY_ARMS_BIG_ADVENTURE(102, "My Arm's Big Adventure"),
	NATURE_SPIRIT(103, "Nature Spirit"),
	A_NIGHT_AT_THE_THEATRE(104, "A Night at the Theatre"),
	OBSERVATORY_QUEST(105, "Observatory Quest"),
	OLAFS_QUEST(106, "Olaf's Quest"),
	ONE_SMALL_FAVOUR(107, "One Small Favour"),
	PIRATES_TREASURE(108, "Pirate's Treasure"),
	PLAGUE_CITY(109, "Plague City"),
	A_PORCINE_OF_INTEREST(110, "A Porcine of Interest"),
	PRIEST_IN_PERIL(111, "Priest in Peril"),
	PRINCE_ALI_RESCUE(112, "Prince Ali Rescue"),
	THE_QUEEN_OF_THIEVES(113, "The Queen of Thieves"),
	RAG_AND_BONE_MAN_I(114, "Rag and Bone Man I"),
	RAG_AND_BONE_MAN_II(115, "Rag and Bone Man II"),
	RATCATCHERS(116, "Ratcatchers"),
	RECIPE_FOR_DISASTER(117, "Recipe for Disaster"),
	RECRUITMENT_DRIVE(118, "Recruitment Drive"),
	REGICIDE(119, "Regicide"),
	THE_RESTLESS_GHOST(120, "The Restless Ghost"),
	ROMEO__JULIET(121, "Romeo & Juliet"),
	ROVING_ELVES(122, "Roving Elves"),
	ROYAL_TROUBLE(123, "Royal Trouble"),
	RUM_DEAL(124, "Rum Deal"),
	RUNE_MYSTERIES(125, "Rune Mysteries"),
	SCORPION_CATCHER(126, "Scorpion Catcher"),
	SEA_SLUG(127, "Sea Slug"),
	SHADES_OF_MORTTON(128, "Shades of Mort'ton"),
	SHADOW_OF_THE_STORM(129, "Shadow of the Storm"),
	SHEEP_HERDER(130, "Sheep Herder"),
	SHEEP_SHEARER(131, "Sheep Shearer"),
	SHIELD_OF_ARRAV(132, "Shield of Arrav"),
	SHILO_VILLAGE(133, "Shilo Village"),
	SINS_OF_THE_FATHER(134, "Sins of the Father"),
	SKIPPY_AND_THE_MOGRES(135, "Skippy and the Mogres"),
	THE_SLUG_MENACE(136, "The Slug Menace"),
	SONG_OF_THE_ELVES(137, "Song of the Elves"),
	A_SOULS_BANE(138, "A Soul's Bane"),
	SPIRITS_OF_THE_ELID(139, "Spirits of the Elid"),
	SWAN_SONG(140, "Swan Song"),
	TAI_BWO_WANNAI_TRIO(141, "Tai Bwo Wannai Trio"),
	A_TAIL_OF_TWO_CATS(142, "A Tail of Two Cats"),
	TALE_OF_THE_RIGHTEOUS(143, "Tale of the Righteous"),
	A_TASTE_OF_HOPE(144, "A Taste of Hope"),
	TEARS_OF_GUTHIX(145, "Tears of Guthix"),
	TEMPLE_OF_IKOV(146, "Temple of Ikov"),
	THRONE_OF_MISCELLANIA(147, "Throne of Miscellania"),
	THE_TOURIST_TRAP(148, "The Tourist Trap"),
	TOWER_OF_LIFE(149, "Tower of Life"),
	TREE_GNOME_VILLAGE(150, "Tree Gnome Village"),
	TRIBAL_TOTEM(151, "Tribal Totem"),
	TROLL_ROMANCE(152, "Troll Romance"),
	TROLL_STRONGHOLD(153, "Troll Stronghold"),
	UNDERGROUND_PASS(154, "Underground Pass"),
	VAMPYRE_SLAYER(155, "Vampyre Slayer"),
	WANTED(156, "Wanted!"),
	WATCHTOWER(157, "Watchtower"),
	WATERFALL_QUEST(158, "Waterfall Quest"),
	WHAT_LIES_BELOW(159, "What Lies Below"),
	WITCHS_HOUSE(160, "Witch's House"),
	WITCHS_POTION(161, "Witch's Potion"),
	X_MARKS_THE_SPOT(162, "X Marks the Spot"),
	ZOGRE_FLESH_EATERS(163, "Zogre Flesh Eaters"),
	THE_FROZEN_DOOR(164, "The Frozen Door"),
	LAND_OF_THE_GOBLINS(165, "Land of the Goblins"),
	HOPESPEARS_WILL(166, "Hopespear's Will"),
	TEMPLE_OF_THE_EYE(167, "Temple of the Eye"),
	BENEATH_CURSED_SANDS(168, "Beneath Cursed Sands"),
	SLEEPING_GIANTS(169, "Sleeping Giants"),
	THE_GARDEN_OF_DEATH(180, "The Garden of Death"),
	INTO_THE_TOMBS(2306, "Into the Tombs"),
	RECIPE_FOR_DISASTER__ANOTHER_COOKS_QUEST(2307, "Recipe for Disaster - Another Cook's Quest"),
	RECIPE_FOR_DISASTER__MOUNTAIN_DWARF(2308, "Recipe for Disaster - Mountain Dwarf"),
	RECIPE_FOR_DISASTER__WARTFACE__BENTNOZE(2309, "Recipe for Disaster - Wartface & Bentnoze"),
	RECIPE_FOR_DISASTER__PIRATE_PETE(2310, "Recipe for Disaster - Pirate Pete"),
	RECIPE_FOR_DISASTER__LUMBRIDGE_GUIDE(2311, "Recipe for Disaster - Lumbridge Guide"),
	RECIPE_FOR_DISASTER__EVIL_DAVE(2312, "Recipe for Disaster - Evil Dave"),
	RECIPE_FOR_DISASTER__SKRACH_UGLOGWEE(2313, "Recipe for Disaster - Skrach Uglogwee"),
	RECIPE_FOR_DISASTER__SIR_AMIK_VARZE(2314, "Recipe for Disaster - Sir Amik Varze"),
	RECIPE_FOR_DISASTER__KING_AWOWOGEI(2315, "Recipe for Disaster - King Awowogei"),
	RECIPE_FOR_DISASTER__CULINAROMANCER(2316, "Recipe for Disaster - Culinaromancer"),
	SECRETS_OF_THE_NORTH(2338, "Secrets of the North"),
	DESERT_TREASURE_II__THE_FALLEN_EMPIRE(2343, "Desert Treasure II - The Fallen Empire"),
	HIS_FAITHFUL_SERVANTS(3250, "His Faithful Servants"),
	THE_PATH_OF_GLOUPHRIE(3425, "The Path of Glouphrie"),
	CHILDREN_OF_THE_SUN(3450, "Children of the Sun"),
	BARBARIAN_TRAINING(3451, "Barbarian Training"),
	DEFENDER_OF_VARROCK(3466, "Defender of Varrock"),
	WHILE_GUTHIX_SLEEPS(3467, "While Guthix Sleeps"),
	TWILIGHTS_PROMISE(3512, "Twilight's Promise"),
	AT_FIRST_LIGHT(3513, "At First Light"),
	PERILOUS_MOONS(3514, "Perilous Moons"),
	THE_RIBBITING_TALE_OF_A_LILY_PAD_LABOUR_DISPUTE(3515, "The Ribbiting Tale of a Lily Pad Labour Dispute"),
	THE_HEART_OF_DARKNESS(3710, "The Heart of Darkness"),
	DEATH_ON_THE_ISLE(3711, "Death on the Isle"),
	MEAT_AND_GREET(3712, "Meat and Greet"),
	ETHICALLY_ACQUIRED_ANTIQUITIES(3713, "Ethically Acquired Antiquities"),
	THE_CURSE_OF_ARRAV(3937, "The Curse of Arrav"),
	THE_FINAL_DAWN(5189, "The Final Dawn"),
	SHADOWS_OF_CUSTODIA(5190, "Shadows of Custodia"),
	SCRAMBLED(5191, "Scrambled!"),
	AN_EXISTENTIAL_CRISIS(5192, "An Existential Crisis"),
	IMPENDING_CHAOS(5193, "Impending Chaos"),
	VALE_TOTEMS(5194, "Vale Totems"),
	;

	@Getter
	private final int id;

	@Getter
	private final String name;

	public QuestState getState(Client client)
	{
		client.runScript(ScriptID.QUEST_STATUS_GET, id);
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
}
