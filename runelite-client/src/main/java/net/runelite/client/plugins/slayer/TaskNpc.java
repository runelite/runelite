/*
 * Copyright (c) 2023, Macweese <https://github.com/Macweese>
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
package net.runelite.client.plugins.slayer;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import java.util.Arrays;
import java.util.stream.Collectors;

enum TaskNpc
{
	NULL(0, 0),
	MONKEYS(1, 0, "Monkeys", SlayerNpcVariation.MONKEYS, ItemID.ENSOULED_MONKEY_HEAD),
	GOBLINS(2, 0, "Goblins", SlayerNpcVariation.GOBLINS, ItemID.ENSOULED_GOBLIN_HEAD),
	RATS(3, 0, "Rats", SlayerNpcVariation.RATS, ItemID.RATS_TAIL),
	SPIDERS(4, 0, "Spiders", SlayerNpcVariation.SPIDERS, ItemID.HUGE_SPIDER),
	BIRDS(5, 0, "Birds", SlayerNpcVariation.BIRDS, ItemID.FEATHER),
	COWS(6, 0, "Cows", SlayerNpcVariation.COWS, ItemID.COW_MASK),
	SCORPIONS(7, 0, "Scorpions", SlayerNpcVariation.SCORPIONS, ItemID.ENSOULED_SCORPION_HEAD),
	BATS(8, 0, "Bats", SlayerNpcVariation.BATS, ItemID.GIRAL_BAT_2),
	WOLVES(9, 0, "Wolves", SlayerNpcVariation.WOLVES, ItemID.WOLF_MASK),
	ZOMBIES(10, 0, "Zombies", SlayerNpcVariation.ZOMBIES, ItemID.ZOMBIE_HEAD),
	SKELETONS(11, 0, "Skeletons", SlayerNpcVariation.SKELETONS, ItemID.SKELETON_GUARD),
	GHOSTS(12, 0, "Ghosts", SlayerNpcVariation.GHOSTS, ItemID.GHOSTSPEAK_AMULET),
	BEARS(13, 0, "Bears", SlayerNpcVariation.BEARS, ItemID.ENSOULED_BEAR_HEAD),
	HILL_GIANTS(14, 0, "Hill Giants", SlayerNpcVariation.HILL_GIANTS, ItemID.ENSOULED_GIANT_HEAD),
	ICE_GIANTS(15, 0, "Ice Giants", SlayerNpcVariation.ICE_GIANTS, ItemID.ICE_DIAMOND),
	FIRE_GIANTS(16, 0, "Fire Giants", SlayerNpcVariation.FIRE_GIANTS, ItemID.FIRE_BATTLESTAFF),
	MOSS_GIANTS(17, 0, "Moss Giants", SlayerNpcVariation.MOSS_GIANTS, ItemID.MOSSY_KEY),
	TROLLS(18, 0, "Trolls", SlayerNpcVariation.TROLLS, ItemID.TROLL_GUARD),
	ICE_WARRIORS(19, 0, "Ice Warriors", SlayerNpcVariation.ICE_WARRIORS, ItemID.MITHRIL_FULL_HELM_T),
	OGRES(20, 0, "Ogres", SlayerNpcVariation.OGRES, ItemID.ENSOULED_OGRE_HEAD),
	HOBGOBLINS(21, 0, "Hobgoblins", SlayerNpcVariation.HOBGOBLINS, ItemID.HOBGOBLIN_GUARD),
	DOGS(22, 0, "Dogs", SlayerNpcVariation.DOGS, ItemID.GUARD_DOG),
	GHOULS(23, 0, "Ghouls", SlayerNpcVariation.GHOULS, ItemID.ZOMBIE_HEAD),
	GREEN_DRAGONS(24, 0, "Green Dragons", SlayerNpcVariation.GREEN_DRAGONS, ItemID.GREEN_DRAGON_MASK),
	BLUE_DRAGONS(25, 0, "Blue Dragons", SlayerNpcVariation.BLUE_DRAGONS, ItemID.BLUE_DRAGON_MASK),
	RED_DRAGONS(26, 0, "Red Dragons", SlayerNpcVariation.RED_DRAGONS, ItemID.BABY_RED_DRAGON),
	BLACK_DRAGONS(27, 0, "Black Dragons", SlayerNpcVariation.BLACK_DRAGONS, ItemID.BLACK_DRAGON_MASK),
	LESSER_DEMONS(28, 0, "Lesser Demons", SlayerNpcVariation.LESSER_DEMONS, ItemID.LESSER_DEMON_MASK),
	GREATER_DEMONS(29, 0, "Greater Demons", SlayerNpcVariation.GREATER_DEMONS, ItemID.DEMON),
	BLACK_DEMONS(30, 0, "Black Demons", SlayerNpcVariation.BLACK_DEMONS, ItemID.BLACK_DEMON_MASK),
	HELLHOUNDS(31, 0, "Hellhounds", SlayerNpcVariation.HELLHOUNDS, ItemID.HELLHOUND),
	SHADOW_WARRIORS(32, 0, "Shadow Warriors", SlayerNpcVariation.SHADOW_WARRIORS, ItemID.SHADOW_SWORD),
	WEREWOLVES(33, 0, "Werewolves", SlayerNpcVariation.WEREWOLVES, ItemID.WOLFBANE),
	VAMPYRES(34, 0, "Vampyres", SlayerNpcVariation.VAMPYRES, ItemID.STAKE),
	DAGANNOTH(35, 0, "Dagannoths", SlayerNpcVariation.DAGANNOTH, ItemID.DAGANNOTH),
	TUROTH(36, 0, "Turoths", SlayerNpcVariation.TUROTH, ItemID.TUROTH),
	CAVE_CRAWLERS(37, 0, "Cave Crawlers", SlayerNpcVariation.CAVE_CRAWLERS, ItemID.CAVE_CRAWLER),
	BANSHEES(38, 0, "Banshees", SlayerNpcVariation.BANSHEES, ItemID.BANSHEE),
	CRAWLING_HANDS(39, 0, "Crawling Hands", SlayerNpcVariation.CRAWLING_HANDS, ItemID.CRAWLING_HAND),
	INFERNAL_MAGES(40, 0, "Infernal Mages", SlayerNpcVariation.INFERNAL_MAGES, ItemID.INFERNAL_MAGE),
	ABERRANT_SPECTRES(41, 0, "Aberrant Spectres", SlayerNpcVariation.ABERRANT_SPECTRES, ItemID.ABERRANT_SPECTRE),
	ABYSSAL_DEMONS(42, 0, "Abyssal Demons", SlayerNpcVariation.ABYSSAL_DEMONS, ItemID.ABYSSAL_DEMON),
	BASILISKS(43, 0, "Basilisks", SlayerNpcVariation.BASILISKS, ItemID.BASILISK),
	COCKATRICE(44, 0, "Cockatrice", SlayerNpcVariation.COCKATRICE, ItemID.COCKATRICE),
	KURASK(45, 0, "Kurasks", SlayerNpcVariation.KURASK, ItemID.KURASK),
	GARGOYLES(46, 0, "Gargoyles", SlayerNpcVariation.GARGOYLES, ItemID.GARGOYLE, 9, ItemID.ROCK_HAMMER),
	PYREFIENDS(47, 0, "Pyrefiends", SlayerNpcVariation.PYREFIENDS, ItemID.PYREFIEND),
	BLOODVELD(48, 0, "Bloodvelds", SlayerNpcVariation.BLOODVELD, ItemID.BLOODVELD),
	DUST_DEVILS(49, 0, "Dust Devils", SlayerNpcVariation.DUST_DEVILS, ItemID.DUST_DEVIL),
	JELLIES(50, 0, "Jellies", SlayerNpcVariation.JELLIES, ItemID.JELLY),
	ROCKSLUGS(51, 0, "Rockslugs", SlayerNpcVariation.ROCKSLUGS, ItemID.ROCKSLUG, 4, ItemID.BAG_OF_SALT),
	NECHRYAEL(52, 0, "Nechryaels", SlayerNpcVariation.NECHRYAEL, ItemID.NECHRYAEL),
	KALPHITE(53, 0, "Kalphites", SlayerNpcVariation.KALPHITE, ItemID.KALPHITE_SOLDIER),
	EARTH_WARRIORS(54, 0, "Earth Warriors", SlayerNpcVariation.EARTH_WARRIORS, ItemID.BRONZE_FULL_HELM_T),
	OTHERWORLDLY_BEINGS(55, 0, "Otherworldly Beings", SlayerNpcVariation.OTHERWORLDLY_BEINGS, ItemID.GHOSTLY_HOOD),
	ELVES(56, 0, "Elves", SlayerNpcVariation.ELVES, ItemID.ELF),
	DWARVES(57, 0, "Dwarves", SlayerNpcVariation.DWARVES, ItemID.DWARVEN_HELMET),
	BRONZE_DRAGONS(58, 0, "Bronze Dragons", SlayerNpcVariation.BRONZE_DRAGONS, ItemID.BRONZE_DRAGON_MASK),
	IRON_DRAGONS(59, 0, "Iron Dragons", SlayerNpcVariation.IRON_DRAGONS, ItemID.IRON_DRAGON_MASK),
	STEEL_DRAGONS(60, 0, "Steel Dragons", SlayerNpcVariation.STEEL_DRAGONS, ItemID.STEEL_DRAGON),
	WALL_BEASTS(61, 0, "Wall Beasts", SlayerNpcVariation.WALL_BEASTS, ItemID.SWAMP_WALLBEAST),
	CAVE_SLIMES(62, 0, "Cave Slimes", SlayerNpcVariation.CAVE_SLIMES, ItemID.SWAMP_CAVE_SLIME),
	CAVE_BUGS(63, 0, "Cave Bugs", SlayerNpcVariation.CAVE_BUGS, ItemID.SWAMP_CAVE_BUG),
	SHADES(64, 0, "Shades", SlayerNpcVariation.SHADES, ItemID.SHADE_ROBE_TOP),
	CROCODILES(65, 0, "Crocodiles", SlayerNpcVariation.CROCODILES, ItemID.SWAMP_LIZARD),
	DARK_BEASTS(66, 0, "Dark Beasts", SlayerNpcVariation.DARK_BEASTS, ItemID.DARK_BEAST),
	MOGRES(67, 0, "Mogres", SlayerNpcVariation.MOGRES, ItemID.MOGRE),
	LIZARDS(68, 0, "Lizards", SlayerNpcVariation.LIZARDS, ItemID.DESERT_LIZARD, 4, ItemID.ICE_COOLER),
	FEVER_SPIDERS(69, 0, "Fever Spiders", SlayerNpcVariation.FEVER_SPIDERS, ItemID.NICE_TREE),
	HARPIE_BUG_SWARMS(70, 0, "Harpie Bug Swarms", SlayerNpcVariation.HARPIE_BUG_SWARMS, ItemID.SWARM),
	SEA_SNAKES(71, 0, "Sea Snakes", SlayerNpcVariation.SEA_SNAKES, ItemID.SNAKE_CORPSE),
	SKELETAL_WYVERNS(72, 0, "Skeletal Wyverns", SlayerNpcVariation.SKELETAL_WYVERNS, ItemID.SKELETAL_WYVERN),
	KILLERWATTS(73, 0, "Killerwatts", SlayerNpcVariation.KILLERWATTS, ItemID.KILLERWATT),
	MUTATED_ZYGOMITES(74, 0, "Mutated Zygomites", SlayerNpcVariation.MUTATED_ZYGOMITES, ItemID.MUTATED_ZYGOMITE, 7, ItemID.FUNGICIDE_SPRAY_0),
	ICEFIENDS(75, 0, "Icefiends", SlayerNpcVariation.ICEFIENDS, ItemID.ICE_DIAMOND),
	MINOTAURS(76, 0, "Minotaurs", SlayerNpcVariation.MINOTAURS, ItemID.ENSOULED_MINOTAUR_HEAD),
	FLESHCRAWLERS(77, 0, "Fleshcrawlers", SlayerNpcVariation.FLESHCRAWLERS, ItemID.ENSOULED_SCORPION_HEAD),
	CATABLEPON(78, 0, "Catablepons", SlayerNpcVariation.CATABLEPON, ItemID.LEFT_SKULL_HALF),
	ANKOU(79, 0, "Ankous", SlayerNpcVariation.ANKOU, ItemID.ANKOU_MASK),
	CAVE_HORRORS(80, 0, "Cave Horrors", SlayerNpcVariation.CAVE_HORRORS, ItemID.CAVE_HORROR),
	JUNGLE_HORRORS(81, 0, "Jungle Horrors", SlayerNpcVariation.JUNGLE_HORRORS, ItemID.ENSOULED_HORROR_HEAD),
	GORAKS(82, 0, "Goraks", SlayerNpcVariation.GORAKS, ItemID.GORAK_CLAWS),
	SUQAHS(83, 0, "Suqah", SlayerNpcVariation.SUQAHS, ItemID.SUQAH_TOOTH),
	BRINE_RATS(84, 0, "Brine Rats", SlayerNpcVariation.BRINE_RATS, ItemID.BRINE_RAT),
	MINIONS_OF_SCABARAS(85, 0, "Scabarites", SlayerNpcVariation.MINIONS_OF_SCABARAS, ItemID.GOLDEN_SCARAB),
	TERROR_DOGS(86, 0, "Terror Dogs", SlayerNpcVariation.TERROR_DOGS, ItemID.TERROR_DOG),
	MOLANISKS(87, 0, "Molanisks", SlayerNpcVariation.MOLANISKS, ItemID.MOLANISK),
	WATERFIENDS(88, 0, "Waterfiends", SlayerNpcVariation.WATERFIENDS, ItemID.WATER_ORB),
	SPIRITUAL_CREATURES(89, 0, "Spiritual Creatures", SlayerNpcVariation.SPIRITUAL_CREATURES, ItemID.DRAGON_BOOTS),
	LIZARDMEN(90, 0, "Lizardmen", SlayerNpcVariation.LIZARDMEN, ItemID.LIZARDMAN_FANG),
	MAGIC_AXES(91, 0, "Magic Axes", SlayerNpcVariation.MAGIC_AXES, ItemID.IRON_BATTLEAXE),
	CAVE_KRAKEN(92, 0, "Cave Krakens", SlayerNpcVariation.CAVE_KRAKEN, ItemID.CAVE_KRAKEN),
	MITHRIL_DRAGONS(93, 0, "Mithril Dragons", SlayerNpcVariation.MITHRIL_DRAGONS, ItemID.MITHRIL_DRAGON_MASK),
	AVIANSIES(94, 0, "Aviansies", SlayerNpcVariation.AVIANSIES, ItemID.ENSOULED_AVIANSIE_HEAD),
	SMOKE_DEVILS(95, 0, "Smoke Devils", SlayerNpcVariation.SMOKE_DEVILS, ItemID.SMOKE_DEVIL),
	TZHAAR(96, 0, "TzHaar", SlayerNpcVariation.TZHAAR, ItemID.ENSOULED_TZHAAR_HEAD),
	TZTOK_JAD(97, 0, "TzTok-Jad", SlayerNpcVariation.TZTOK_JAD, ItemID.TZREKJAD),
	NULL_BOSS(98, 0),
	KREE_ARRA(98, 1, "Kree'arra", SlayerNpcVariation.KREE_ARRA, ItemID.PET_KREEARRA),
	COMMANDER_ZILYANA(98, 2, "Commander Zilyana", SlayerNpcVariation.GENERAL_GRAARDOR, ItemID.PET_ZILYANA),
	GENERAL_GRAARDOR(98, 3, "General Graardor", SlayerNpcVariation.COMMANDER_ZILYANA, ItemID.PET_GENERAL_GRAARDOR),
	K_RIL_TSUTSAROTH(98, 4, "K'ril Tsutsaroth", SlayerNpcVariation.KRIL_TRUTSAROTH, ItemID.PET_KRIL_TSUTSAROTH),
	DAGANNOTH_KINGS(98, 5, "Dagannoth Kings", SlayerNpcVariation.DAGANNOTH_KINGS, ItemID.PET_DAGANNOTH_PRIME),
	THE_GIANT_MOLE(98, 6, "The Giant Mole", SlayerNpcVariation.GIANT_MOLE, ItemID.BABY_MOLE),
	THE_KALPHITE_QUEEN(98, 7, "The Kalphite Queen", SlayerNpcVariation.KALPHITE_QUEEN, ItemID.KALPHITE_PRINCESS),
	THE_KING_BLACK_DRAGON(98, 8, "The King Black Dragon", SlayerNpcVariation.KING_BLACK_DRAGON, ItemID.PRINCE_BLACK_DRAGON),
	CALLISTO(98, 9, "Callisto", SlayerNpcVariation.CALLISTO, ItemID.CALLISTO_CUB),
	VENENATIS(98, 10, "Venenatis", SlayerNpcVariation.VENENATIS, ItemID.VENENATIS_SPIDERLING),
	VET_ION(98, 11, "Vet'ion", SlayerNpcVariation.VETION, ItemID.VETION_JR),
	THE_CHAOS_ELEMENTAL(98, 12, "The Chaos Elemental", SlayerNpcVariation.CHAOS_ELEMENTAL, ItemID.PET_CHAOS_ELEMENTAL),
	THE_CHAOS_FANATIC(98, 13, "The Chaos Fanatic", SlayerNpcVariation.CHAOS_FANATIC, ItemID.ANCIENT_STAFF),
	CRAZY_ARCHAEOLOGISTS(98, 14, "Crazy Archaeologists", SlayerNpcVariation.CRAZY_ARCHAEOLOGISTS, ItemID.FEDORA),
	SCORPIA(98, 15, "Scorpia", SlayerNpcVariation.SCORPIA, ItemID.SCORPIAS_OFFSPRING),
	ZULRAH(98, 16, "Zulrah", SlayerNpcVariation.ZULRAH, ItemID.PET_SNAKELING),
	BARROWS_BROTHERS(98, 17, "Barrows Brothers", SlayerNpcVariation.BARROWS_BROTHERS, ItemID.KARILS_COIF),
	THE_CAVE_KRAKEN_BOSS(98, 18, "The Cave Kraken Boss", SlayerNpcVariation.CAVE_KRAKEN_BOSS, ItemID.PET_KRAKEN),
	THE_THERMONUCLEAR_SMOKE_DEVIL(98, 19, "The Thermonuclear Smoke Devil", SlayerNpcVariation.THERMONUCLEAR_SMOKE_DEVIL, ItemID.PET_SMOKE_DEVIL),
	CERBERUS(98, 20, "Cerberus", SlayerNpcVariation.CERBERUS, ItemID.HELLPUPPY),
	THE_ABYSSAL_SIRE(98, 21, "The Abyssal Sire", SlayerNpcVariation.ABYSSAL_SIRE, ItemID.ABYSSAL_ORPHAN),
	THE_GROTESQUE_GUARDIANS(98, 22, "The Grotesque Guardians", SlayerNpcVariation.GROTESQUE_GUARDIANS, ItemID.MIDNIGHT, 0, ItemID.ROCK_HAMMER),
	VORKATH(98, 23, "Vorkath", SlayerNpcVariation.VORKATH, ItemID.VORKI),
	THE_ALCHEMICAL_HYDRA(98, 24, "The Alchemical Hydra", SlayerNpcVariation.ALCHEMICAL_HYDRA, ItemID.IKKLE_HYDRA),
	SARACHNIS(98, 25, "Sarachnis", SlayerNpcVariation.SARACHNIS, ItemID.SRARACHA),
	PHANTOM_MUSPAH(98, 26, "Phantom Muspah", SlayerNpcVariation.PHANTOM_MUSPAH, ItemID.MUPHIN),
	MAMMOTHS(99, 0, "Mammoths", SlayerNpcVariation.MAMMOTHS, ItemID.ATTACKER_HORN),
	ROGUES(100, 0, "Rogues", SlayerNpcVariation.ROGUES, ItemID.ROGUE_MASK),
	ENTS(101, 0, "Ents", SlayerNpcVariation.ENTS, ItemID.NICE_TREE),
	BANDITS(102, 0, "Bandits", SlayerNpcVariation.BANDITS, ItemID.BANDIT),
	DARK_WARRIORS(103, 0, "Dark Warriors", SlayerNpcVariation.DARK_WARRIORS, ItemID.BLACK_MED_HELM),
	LAVA_DRAGONS(104, 0, "Lava Dragons", SlayerNpcVariation.LAVA_DRAGONS, ItemID.LAVA_SCALE),
	TZKAL_ZUK(105, 0, "TzKal-Zuk", SlayerNpcVariation.TZKAL_ZUK, ItemID.TZREKZUK),
	FOSSIL_ISLAND_WYVERNS(106, 0, "Fossil Island Wyverns", SlayerNpcVariation.FOSSIL_ISLAND_WYVERNS, ItemID.FOSSIL_ISLAND_WYVERN),
	REVENANTS(107, 0, "Revenants", SlayerNpcVariation.REVENANTS, ItemID.BRACELET_OF_ETHEREUM),
	ADAMANT_DRAGONS(108, 0, "Adamant Dragons", SlayerNpcVariation.ADAMANT_DRAGONS, ItemID.ADAMANT_DRAGON_MASK),
	RUNE_DRAGONS(109, 0, "Rune Dragons", SlayerNpcVariation.RUNE_DRAGONS, ItemID.RUNE_DRAGON_MASK),
	CHAOS_DRUIDS(110, 0, "Chaos Druids", SlayerNpcVariation.CHAOS_DRUIDS, ItemID.ELDER_CHAOS_HOOD),
	WYRMS(111, 0, "Wyrms", SlayerNpcVariation.WYRMS, ItemID.WYRM),
	DRAKES(112, 0, "Drakes", SlayerNpcVariation.DRAKES, ItemID.DRAKE),
	HYDRAS(113, 0, "Hydras", SlayerNpcVariation.HYDRAS, ItemID.HYDRA),
	TEMPLE_SPIDERS(114, 0, "Temple Spiders", SlayerNpcVariation.TEMPLE_SPIDERS, ItemID.RED_SPIDERS_EGGS),
	UNDEAD_DRUIDS(115, 0, "Undead Druids", SlayerNpcVariation.UNDEAD_DRUIDS, ItemID.MASK_OF_RANUL),
	SULPHUR_LIZARDS(116, 0, "Sulphur Lizards", SlayerNpcVariation.SULPHUR_LIZARDS, ItemID.SULPHUR_LIZARD),
	BRUTAL_BLACK_DRAGONS(117, 0, "Brutal Black Dragons", SlayerNpcVariation.BRUTAL_BLACK_DRAGONS, ItemID.BRUTAL_BLACK_DRAGON),
	SAND_CRABS(118, 0, "Sand Crabs", SlayerNpcVariation.SAND_CRABS, ItemID.CRAB_CLAW),
	BLACK_KNIGHTS(119, 0, "Black Knights", SlayerNpcVariation.BLACK_KNIGHTS, ItemID.BLACK_FULL_HELM),
	PIRATES(120, 0, "Pirates", SlayerNpcVariation.PIRATES, ItemID.PIRATE_HAT),
	SOURHOGS(121, 0, "Sourhogs", SlayerNpcVariation.SOURHOGS, ItemID.SOURHOG_FOOT),
	;

	@Getter
	private final String name;
	@Getter
	private final int index;
	@Getter
	private final int subIndex;
	@Getter
	private final int[] variations;
	@Getter
	private final int itemSpriteId;
	@Getter
	private final int weaknessItem;
	@Getter
	private final int weaknessThreshold;

	TaskNpc(int index, int subIndex)
	{
		this.name = "";
		this.index = index;
		this.subIndex = subIndex;
		this.variations = new int[0];
		this.itemSpriteId = -1;
		this.weaknessThreshold = -1;
		this.weaknessItem = -1;
	}

	TaskNpc(int index, int subIndex, String name, SlayerNpcVariation npcVariations, int itemSpriteId)
	{
		this.name = name;
		this.index = index;
		this.subIndex = subIndex;
		this.variations = npcVariations.getIds();
		this.itemSpriteId = itemSpriteId;
		this.weaknessThreshold = -1;
		this.weaknessItem = -1;
	}

	TaskNpc(int index, int subIndex, String name,
			SlayerNpcVariation npcVariations, int itemSpriteId, int weaknessThreshold, int weaknessItem)
	{
		this.name = name;
		this.index = index;
		this.subIndex = subIndex;
		this.variations = npcVariations.getIds();
		this.itemSpriteId = itemSpriteId;
		this.weaknessThreshold = weaknessThreshold;
		this.weaknessItem = weaknessItem;
	}

	static TaskNpc getTaskNPC(int task, int boss)
	{
		return Arrays.stream(TaskNpc.values())
				.filter(taskNpc -> task == 98 ? taskNpc.subIndex == boss : taskNpc.index == task)
				.collect(Collectors.toList())
				.get(0);
	}

	static TaskNpc getTask(Client client)
	{
		return getTaskNPC(client.getVarpValue(VarPlayer.SLAYER_TASK_CREATURE), client.getVarbitValue(Varbits.SLAYER_TASK_BOSS));
	}
}