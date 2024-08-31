/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.NullItemID;

@Getter
enum Task
{
	//<editor-fold desc="Enums">
	ABERRANT_SPECTRES("Aberrant spectres", ItemID.ABERRANT_SPECTRE, "Spectre"),
	ABYSSAL_DEMONS("Abyssal demons", ItemID.ABYSSAL_DEMON, "Abyssal Sire"),
	ABYSSAL_SIRE("The Abyssal Sire", ItemID.ABYSSAL_ORPHAN),
	ADAMANT_DRAGONS("Adamant dragons", ItemID.ADAMANT_DRAGON_MASK),
	ALCHEMICAL_HYDRA("The Alchemical Hydra", ItemID.IKKLE_HYDRA),
	ANKOU("Ankou", ItemID.ANKOU_MASK),
	ARAXYTES("Araxytes", ItemID.ARAXYTE_HEAD, "Araxxor"),
	AVIANSIES("Aviansies", ItemID.ENSOULED_AVIANSIE_HEAD, "Kree'arra", "Flight Kilisa", "Flockleader Geerin", "Wingman Skree"),
	BANDITS("Bandits", ItemID.BANDIT, "Bandit", "Black Heather", "Donny the Lad", "Speedy Keith"),
	BANSHEES("Banshees", ItemID.BANSHEE),
	BARROWS_BROTHERS("Barrows Brothers", ItemID.KARILS_COIF),
	BASILISKS("Basilisks", ItemID.BASILISK),
	BATS("Bats", ItemID.GIRAL_BAT_2, "Death wing"),
	BEARS("Bears", ItemID.ENSOULED_BEAR_HEAD, "Callisto", "Artio"),
	BIRDS("Birds", ItemID.FEATHER, "Chicken", "Rooster", "Terrorbird", "Seagull", "Vulture", "Duck", "Penguin", "Baby Roc"),
	BLACK_DEMONS("Black demons", ItemID.BLACK_DEMON_MASK, "Demonic gorilla", "Balfrug Kreeyath", "Skotizo", "Porazdir"),
	BLACK_DRAGONS("Black dragons", ItemID.BLACK_DRAGON_MASK),
	BLACK_KNIGHTS("Black Knights", ItemID.BLACK_FULL_HELM, "Black Knight"),
	BLOODVELD("Bloodveld", ItemID.BLOODVELD),
	BLUE_DRAGONS("Blue dragons", ItemID.BLUE_DRAGON_MASK, "Vorkath"),
	BRINE_RATS("Brine rats", ItemID.BRINE_RAT),
	BRONZE_DRAGONS("Bronze dragons", ItemID.BRONZE_DRAGON_MASK),
	CALLISTO("Callisto", ItemID.CALLISTO_CUB),
	CATABLEPON("Catablepon", ItemID.LEFT_SKULL_HALF),
	CAVE_BUGS("Cave bugs", ItemID.SWAMP_CAVE_BUG),
	CAVE_CRAWLERS("Cave crawlers", ItemID.CAVE_CRAWLER, "Chasm crawler"),
	CAVE_HORRORS("Cave horrors", ItemID.CAVE_HORROR, "Cave abomination"),
	CAVE_KRAKEN("Cave kraken", ItemID.CAVE_KRAKEN, "Kraken"),
	CAVE_SLIMES("Cave slimes", ItemID.SWAMP_CAVE_SLIME),
	CERBERUS("Cerberus", ItemID.HELLPUPPY),
	CHAOS_DRUIDS("Chaos druids", ItemID.ELDER_CHAOS_HOOD),
	CHAOS_ELEMENTAL("The Chaos Elemental", ItemID.PET_CHAOS_ELEMENTAL),
	CHAOS_FANATIC("The Chaos Fanatic", ItemID.ANCIENT_STAFF),
	COCKATRICE("Cockatrice", ItemID.COCKATRICE, "Cockathrice"),
	COWS("Cows", ItemID.COW_MASK),
	CRAWLING_HANDS("Crawling hands", ItemID.CRAWLING_HAND, "Crushing hand"),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologists", ItemID.FEDORA),
	CROCODILES("Crocodiles", ItemID.SWAMP_LIZARD),
	DAGANNOTH("Dagannoth", ItemID.DAGANNOTH),
	DAGANNOTH_KINGS("Dagannoth Kings", ItemID.PET_DAGANNOTH_PRIME),
	DARK_BEASTS("Dark beasts", ItemID.DARK_BEAST, "Night beast"),
	DARK_WARRIORS("Dark warriors", ItemID.BLACK_MED_HELM, "Dark warrior"),
	DERANGED_ARCHAEOLOGIST("Deranged Archaeologist", ItemID.ARCHAEOLOGISTS_DIARY),
	DOGS("Dogs", ItemID.GUARD_DOG, "Jackal", "Temple Guardian"),
	DRAKES("Drakes", ItemID.DRAKE),
	DUKE_SUCELLUS("Duke Sucellus", ItemID.BARON),
	DUST_DEVILS("Dust devils", ItemID.DUST_DEVIL, "Choke devil"),
	DWARVES("Dwarves", ItemID.DWARVEN_HELMET, "Dwarf", "Black Guard"),
	EARTH_WARRIORS("Earth warriors", ItemID.BRONZE_FULL_HELM_T),
	ELVES("Elves", ItemID.ELF, "Elf", "Iorwerth Warrior", "Iorwerth Archer"),
	ENTS("Ents", ItemID.NICE_TREE),
	FEVER_SPIDERS("Fever spiders", ItemID.FEVER_SPIDER),
	FIRE_GIANTS("Fire giants", ItemID.FIRE_BATTLESTAFF),
	FLESH_CRAWLERS("Fleshcrawlers", ItemID.ENSOULED_SCORPION_HEAD, "Flesh crawler"),
	FOSSIL_ISLAND_WYVERNS("Fossil island wyverns", ItemID.FOSSIL_ISLAND_WYVERN, "Ancient wyvern", "Long-tailed wyvern", "Spitting wyvern", "Taloned wyvern"),
	GARGOYLES("Gargoyles", ItemID.GARGOYLE, 9, ItemID.ROCK_HAMMER, "Dusk", "Dawn"),
	GENERAL_GRAARDOR("General Graardor", ItemID.PET_GENERAL_GRAARDOR),
	GHOSTS("Ghosts", ItemID.GHOSTSPEAK_AMULET, "Death wing", "Tortured soul", "Forgotten Soul", "Revenant"),
	GHOULS("Ghouls", ItemID.ZOMBIE_HEAD),
	GIANT_MOLE("The Giant Mole", ItemID.BABY_MOLE),
	GOBLINS("Goblins", ItemID.ENSOULED_GOBLIN_HEAD, "Sergeant Strongstack", "Sergeant Grimspike", "Sergeant Steelwill"),
	GREATER_DEMONS("Greater demons", ItemID.GREATER_DEMON_MASK, "K'ril Tsutsaroth", "Tstanon Karlak", "Skotizo", "Tormented Demon"),
	GREEN_DRAGONS("Green dragons", ItemID.GREEN_DRAGON_MASK, "Elvarg"),
	GROTESQUE_GUARDIANS("The Grotesque Guardians", ItemID.MIDNIGHT, 0, ItemID.ROCK_HAMMER, "Dusk", "Dawn"),
	HARPIE_BUG_SWARMS("Harpie bug swarms", ItemID.SWARM),
	HELLHOUNDS("Hellhounds", ItemID.HELLHOUND, "Cerberus"),
	HILL_GIANTS("Hill giants", ItemID.ENSOULED_GIANT_HEAD, "Cyclops", "Reanimated giant", "Obor"),
	HOBGOBLINS("Hobgoblins", ItemID.HOBGOBLIN_GUARD),
	HYDRAS("Hydras", ItemID.HYDRA),
	ICEFIENDS("Icefiends", ItemID.ICE_DIAMOND),
	ICE_GIANTS("Ice giants", ItemID.ICE_DIAMOND),
	ICE_WARRIORS("Ice warriors", ItemID.MITHRIL_FULL_HELM_T, "Icelord"),
	INFERNAL_MAGES("Infernal mages", ItemID.INFERNAL_MAGE, "Malevolent mage"),
	IRON_DRAGONS("Iron dragons", ItemID.IRON_DRAGON_MASK),
	JAD("TzTok-Jad", ItemID.TZREKJAD),
	JELLIES("Jellies", ItemID.JELLY, "Jelly"),
	JUNGLE_HORROR("Jungle horrors", ItemID.ENSOULED_HORROR_HEAD),
	KALPHITE("Kalphite", ItemID.KALPHITE_SOLDIER),
	KALPHITE_QUEEN("The Kalphite Queen", ItemID.KALPHITE_PRINCESS),
	KILLERWATTS("Killerwatts", ItemID.KILLERWATT),
	KING_BLACK_DRAGON("The King Black Dragon", ItemID.PRINCE_BLACK_DRAGON),
	KRAKEN("The Cave Kraken Boss", ItemID.PET_KRAKEN, "Kraken"),
	KREEARRA("Kree'arra", ItemID.PET_KREEARRA),
	KRIL_TSUTSAROTH("K'ril Tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH),
	KURASK("Kurask", ItemID.KURASK),
	LAVA_DRAGONS("Lava Dragons", ItemID.LAVA_SCALE, "Lava dragon"),
	LESSER_DEMONS("Lesser demons", ItemID.LESSER_DEMON_MASK, "Zakl'n Gritch"),
	LESSER_NAGUA("Lesser Nagua", ItemID.LESSER_NAGUA, "Sulphur Nagua"),
	LIZARDMEN("Lizardmen", ItemID.LIZARDMAN_FANG, "Lizardman"),
	LIZARDS("Lizards", ItemID.DESERT_LIZARD),
	MAGIC_AXES("Magic axes", ItemID.IRON_BATTLEAXE),
	MAMMOTHS("Mammoths", ItemID.ATTACKER_HORN),
	MINIONS_OF_SCABARAS("Minions of scabaras", ItemID.GOLDEN_SCARAB, "Scarab swarm", "Locust rider", "Scarab mage"),
	MINOTAURS("Minotaurs", ItemID.ENSOULED_MINOTAUR_HEAD),
	MITHRIL_DRAGONS("Mithril dragons", ItemID.MITHRIL_DRAGON_MASK),
	MOGRES("Mogres", ItemID.MOGRE),
	MOLANISKS("Molanisks", ItemID.MOLANISK),
	MONKEYS("Monkeys", ItemID.ENSOULED_MONKEY_HEAD, "Tortured gorilla", "Demonic gorilla", "Padulah"),
	MOSS_GIANTS("Moss giants", ItemID.MOSSY_KEY, "Bryophyta"),
	MUTATED_ZYGOMITES("Mutated zygomites", ItemID.MUTATED_ZYGOMITE, 7, ItemID.FUNGICIDE_SPRAY_0, "Zygomite", "Fungi"),
	NECHRYAEL("Nechryael", ItemID.NECHRYAEL, "Nechryarch"),
	OGRES("Ogres", ItemID.ENSOULED_OGRE_HEAD, "Enclave guard", "Mogre", "Ogress", "Skogre", "Zogre"),
	OTHERWORLDLY_BEING("Otherworldly beings", ItemID.GHOSTLY_HOOD),
	PHANTOM_MUSPAH("The Phantom Muspah", ItemID.MUPHIN),
	PIRATES("Pirates", ItemID.PIRATE_HAT, "Pirate"),
	PYREFIENDS("Pyrefiends", ItemID.PYREFIEND, "Flaming pyrelord"),
	RATS("Rats", ItemID.RATS_TAIL),
	RED_DRAGONS("Red dragons", ItemID.BABY_RED_DRAGON),
	REVENANTS("Revenants", ItemID.BRACELET_OF_ETHEREUM),
	ROCKSLUGS("Rockslugs", ItemID.ROCKSLUG, 4, ItemID.BAG_OF_SALT),
	ROGUES("Rogues", ItemID.ROGUE_MASK),
	RUNE_DRAGONS("Rune dragons", ItemID.RUNE_DRAGON_MASK),
	SARACHNIS("Sarachnis", ItemID.SRARACHA),
	SCORPIA("Scorpia", ItemID.SCORPIAS_OFFSPRING),
	SCORPIONS("Scorpions", ItemID.ENSOULED_SCORPION_HEAD, "Scorpia", "Lobstrosity"),
	SEA_SNAKES("Sea snakes", ItemID.SNAKE_CORPSE),
	SHADES("Shades", ItemID.SHADE_ROBE_TOP, "Loar", "Phrin", "Riyl", "Asyn", "Fiyr", "Urium"),
	SHADOW_WARRIORS("Shadow warriors", ItemID.BLACK_FULL_HELM),
	SKELETAL_WYVERNS("Skeletal wyverns", ItemID.SKELETAL_WYVERN),
	SKELETONS("Skeletons", ItemID.SKELETON_GUARD, "Vet'ion", "Calvar'ion", "Skeletal Mystic"),
	SMOKE_DEVILS("Smoke devils", ItemID.SMOKE_DEVIL),
	SOURHOGS("Sourhogs", ItemID.SOURHOG_FOOT),
	SPIDERS("Spiders", ItemID.HUGE_SPIDER, "Kalrag", "Sarachnis", "Venenatis", "Spindel", "Araxxor", "Araxyte"),
	SPIRITUAL_CREATURES("Spiritual creatures", ItemID.DRAGON_BOOTS, "Spiritual ranger", "Spiritual mage", "Spiritual warrior"),
	STEEL_DRAGONS("Steel dragons", ItemID.STEEL_DRAGON),
	SUQAHS("Suqahs", ItemID.SUQAH_TOOTH),
	TERROR_DOGS("Terror dogs", ItemID.TERROR_DOG),
	THE_LEVIATHAN("The Leviathan", ItemID.LILVIATHAN),
	THE_WHISPERER("The Whisperer", ItemID.WISP),
	THERMONUCLEAR_SMOKE_DEVIL("The Thermonuclear Smoke Devil", ItemID.PET_SMOKE_DEVIL),
	TROLLS("Trolls", ItemID.TROLL_GUARD, "Dad", "Arrg", "Stick", "Kraka", "Pee Hat", "Rock", "Twig", "Berry"),
	TUROTH("Turoth", ItemID.TUROTH),
	TZHAAR("Tzhaar", ItemID.ENSOULED_TZHAAR_HEAD, "TzTok-Jad", "TzKal-Zuk"),
	VAMPYRES("Vampyres", ItemID.STAKE, "Vyrewatch"),
	VARDORVIS("Vardorvis", ItemID.BUTCH),
	VENENATIS("Venenatis", ItemID.VENENATIS_SPIDERLING),
	VETION("Vet'ion", ItemID.VETION_JR),
	VORKATH("Vorkath", ItemID.VORKI),
	WALL_BEASTS("Wall beasts", ItemID.SWAMP_WALLBEAST),
	WARPED_CREATURES("Warped Creatures", NullItemID.NULL_28582, "Warped terrorbird", "Warped tortoise", "Mutated terrorbird", "Mutated tortoise"),
	WATERFIENDS("Waterfiends", ItemID.WATER_ORB),
	WEREWOLVES("Werewolves", ItemID.WOLFBANE, "Werewolf"),
	WOLVES("Wolves", ItemID.GREY_WOLF_FUR, "Wolf"),
	WYRMS("Wyrms", ItemID.WYRM),
	ZILYANA("Commander Zilyana", ItemID.PET_ZILYANA),
	ZOMBIES("Zombies", ItemID.ZOMBIE_HEAD, "Undead", "Vorkath", "Zogre"),
	ZUK("TzKal-Zuk", ItemID.TZREKZUK),
	ZULRAH("Zulrah", ItemID.PET_SNAKELING);
	//</editor-fold>

	private static final Map<String, Task> tasks;

	private final String name;
	private final int itemSpriteId;
	private final String[] targetNames;
	private final int weaknessThreshold;
	private final int weaknessItem;

	static
	{
		ImmutableMap.Builder<String, Task> builder = new ImmutableMap.Builder<>();

		for (Task task : values())
		{
			builder.put(task.getName().toLowerCase(), task);
		}

		tasks = builder.build();
	}

	Task(String name, int itemSpriteId, String... targetNames)
	{
		Preconditions.checkArgument(itemSpriteId >= 0);
		this.name = name;
		this.itemSpriteId = itemSpriteId;
		this.weaknessThreshold = -1;
		this.weaknessItem = -1;
		this.targetNames = targetNames;
	}

	Task(String name, int itemSpriteId, int weaknessThreshold, int weaknessItem, String... targetNames)
	{
		Preconditions.checkArgument(itemSpriteId >= 0);
		this.name = name;
		this.itemSpriteId = itemSpriteId;
		this.weaknessThreshold = weaknessThreshold;
		this.weaknessItem = weaknessItem;
		this.targetNames = targetNames;
	}

	@Nullable
	static Task getTask(String taskName)
	{
		return tasks.get(taskName.toLowerCase());
	}
}
