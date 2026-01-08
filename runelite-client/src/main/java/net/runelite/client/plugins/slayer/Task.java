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
import net.runelite.api.gameval.ItemID;

@Getter
enum Task
{
	//<editor-fold desc="Enums">
	ABERRANT_SPECTRES("Aberrant spectres", ItemID.SLAYERGUIDE_ABERRANTSPECTER, "Spectre"),
	ABYSSAL_DEMONS("Abyssal demons", ItemID.SLAYERGUIDE_ABYSSALDEMON, "Abyssal Sire"),
	ABYSSAL_SIRE("The Abyssal Sire", ItemID.ABYSSALSIRE_PET),
	ALCHEMICAL_HYDRA("The Alchemical Hydra", ItemID.HYDRAPET),
	ANKOU("Ankou", ItemID.ANKOU_HEAD),
	AQUANITES("Aquanite", ItemID.SLAYERGUIDE_AQUANITE),
	ARAXXOR("Araxxor", ItemID.ARAXXORPET),
	ARAXYTES("Araxytes", ItemID.POH_ARAXYTE_HEAD, "Araxxor"),
	AVIANSIES("Aviansies", ItemID.ARCEUUS_CORPSE_AVIANSIE_INITIAL, "Kree'arra", "Flight Kilisa", "Flockleader Geerin", "Wingman Skree"),
	BANDITS("Bandits", ItemID.PICKPOCKET_GUIDE_DESERT_BANDIT, "Bandit", "Black Heather", "Donny the Lad", "Speedy Keith"),
	BANSHEES("Banshees", ItemID.SLAYERGUIDE_BANSHEE),
	BARROWS_BROTHERS("Barrows Brothers", ItemID.BARROWS_KARIL_HEAD),
	BASILISKS("Basilisks", ItemID.SLAYERGUIDE_BASILISK),
	BATS("Bats", ItemID.RAIDS_BAT2_COOKED, "Death wing"),
	BEARS("Bears", ItemID.ARCEUUS_CORPSE_BEAR_INITIAL, "Callisto", "Artio"),
	BIRDS("Birds", ItemID.FEATHER, "Chicken", "Rooster", "Terrorbird", "Seagull", "Vulture", "Duck", "Penguin", "Baby Roc"),
	BLACK_DEMONS("Black demons", ItemID.BLACK_DEMON_MASK, "Demonic gorilla", "Balfrug Kreeyath", "Skotizo", "Porazdir"),
	BLACK_DRAGONS("Black dragons", ItemID.DRAGONMASK_BLACK),
	BLACK_KNIGHTS("Black Knights", ItemID.BLACK_FULL_HELM, "Black Knight"),
	BLOODVELD("Bloodveld", ItemID.SLAYERGUIDE_BLOODVELD),
	BLUE_DRAGONS("Blue dragons", ItemID.DRAGONMASK_BLUE, "Vorkath"),
	BRINE_RATS("Brine rats", ItemID.OLAF2_BRINE_RAT_INV),
	CALLISTO("Callisto", ItemID.CALLISTO_PET),
	CATABLEPON("Catablepon", ItemID.SOS_HALF_SKULL2),
	CAVE_BUGS("Cave bugs", ItemID.SWAMP_CAVE_BUG),
	CAVE_CRAWLERS("Cave crawlers", ItemID.SLAYERGUIDE_CAVECRAWLER, "Chasm crawler"),
	CAVE_HORRORS("Cave horrors", ItemID.SLAYERGUIDE_HARMLESS_CAVE_HORROR, "Cave abomination"),
	CAVE_KRAKEN("Cave kraken", ItemID.CERT_EADGAR_FADE_TO_BLACK_INV, "Kraken"),
	CAVE_SLIMES("Cave slimes", ItemID.SWAMP_CAVE_SLIME),
	CERBERUS("Cerberus", ItemID.HELL_PET),
	CHAOS_DRUIDS("Chaos druids", ItemID.ELDERCHAOS_HOOD),
	CHAOS_ELEMENTAL("The Chaos Elemental", ItemID.CHAOSELEPET),
	CHAOS_FANATIC("The Chaos Fanatic", ItemID.STAFF_OF_ZAROS),
	COCKATRICE("Cockatrice", ItemID.SLAYERGUIDE_COCKATRICE, "Cockathrice"),
	COWS("Cows", ItemID.COW_MASK, "Buffalo"),
	CRABS("Crabs", ItemID.HUNDRED_PIRATE_CRAB_SHELL_GAUNTLET, "Ammonite Crab", "Frost Crab", "King Sand Crab", "Rock Crab", "Giant Rock Crab", "Sand Crab", "Swamp Crab"),
	CRAWLING_HANDS("Crawling hands", ItemID.SLAYERGUIDE_CRAWLINGHAND, "Crushing hand"),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologists", ItemID.FEDORA),
	CROCODILES("Crocodiles", ItemID.GREEN_SALAMANDER),
	CUSTODIAN_STALKERS("Custodian Stalkers", ItemID.SLAYERGUIDE_CUSTODIAN_STALKER_MATURE, "Ancient Custodian"),
	DAGANNOTH("Dagannoth", ItemID.POH_DAGGANOTH),
	DAGANNOTH_KINGS("Dagannoth Kings", ItemID.PRIMEPET),
	DARK_BEASTS("Dark beasts", ItemID.SLAYERGUIDE_DARK_BEAST, "Night beast"),
	DARK_WARRIORS("Dark warriors", ItemID.BLACK_MED_HELM, "Dark warrior"),
	DERANGED_ARCHAEOLOGIST("Deranged Archaeologist", ItemID.FOSSIL_SWAMP_DIARY),
	DOGS("Dogs", ItemID.POH_GUARD_DOG, "Jackal", "Temple Guardian"),
	DRAKES("Drakes", ItemID.SLAYERGUIDE_DRAKE),
	DUKE_SUCELLUS("Duke Sucellus", ItemID.DUKESUCELLUSPET),
	DUST_DEVILS("Dust devils", ItemID.SLAYERGUIDE_DUSTDEVIL, "Choke devil"),
	DWARVES("Dwarves", ItemID.GRIM_WEAR_HELMET, "Dwarf", "Black Guard"),
	EARTH_WARRIORS("Earth warriors", ItemID.BRONZE_FULL_HELM_TRIM),
	ELVES("Elves", ItemID.PICKPOCKET_GUIDE_WOODELF, "Elf", "Iorwerth Warrior", "Iorwerth Archer"),
	ENTS("Ents", ItemID.POH_TREE_2),
	FEVER_SPIDERS("Fever spiders", ItemID.SLAYERGUIDE_FEVER_SPIDER),
	FIRE_GIANTS("Fire giants", ItemID.RTBRANDAPET, "Branda the Fire Queen"),
	FLESH_CRAWLERS("Fleshcrawlers", ItemID.ARCEUUS_CORPSE_SCORPION_INITIAL, "Flesh crawler"),
	FOSSIL_ISLAND_WYVERNS("Fossil island wyverns", ItemID.SLAYERGUIDE_FOSSILWYVERN, "Ancient wyvern", "Long-tailed wyvern", "Spitting wyvern", "Taloned wyvern"),
	FROST_DRAGONS("Frost dragons", ItemID.FROST_DRAGON_BONES),
	GARGOYLES("Gargoyles", ItemID.SLAYERGUIDE_GARGOYLE, 9, ItemID.SLAYER_ROCK_HAMMER, "Dusk", "Dawn"),
	GENERAL_GRAARDOR("General Graardor", ItemID.BANDOSPET),
	GHOSTS("Ghosts", ItemID.AMULET_OF_GHOSTSPEAK, "Death wing", "Tortured soul", "Forgotten Soul", "Revenant"),
	GHOULS("Ghouls", ItemID.TRICK_OR_TREAT_HEAD),
	GIANT_MOLE("The Giant Mole", ItemID.MOLEPET),
	GOBLINS("Goblins", ItemID.ARCEUUS_CORPSE_GOBLIN_INITIAL, "Sergeant Strongstack", "Sergeant Grimspike", "Sergeant Steelwill"),
	GREATER_DEMONS("Greater demons", ItemID.GREATER_DEMON_MASK, "K'ril Tsutsaroth", "Tstanon Karlak", "Skotizo", "Tormented Demon"),
	GREEN_DRAGONS("Green dragons", ItemID.DRAGONMASK_GREEN, "Elvarg"),
	GROTESQUE_GUARDIANS("The Grotesque Guardians", ItemID.DUSKPET, 0, ItemID.SLAYER_ROCK_HAMMER, "Dusk", "Dawn"),
	GRYPHONS("Gryphons", ItemID.SLAYERGUIDE_GRYPHON),
	HARPIE_BUG_SWARMS("Harpie bug swarms", ItemID.SLAYERGUIDE_SWARM),
	HELLHOUNDS("Hellhounds", ItemID.POH_HELLHOUND, "Cerberus"),
	HILL_GIANTS("Hill giants", ItemID.ARCEUUS_CORPSE_GIANT_INITIAL, "Cyclops", "Reanimated giant", "Obor"),
	HOBGOBLINS("Hobgoblins", ItemID.POH_HOBGOBLIN),
	HYDRAS("Hydras", ItemID.SLAYERGUIDE_HYDRA),
	ICEFIENDS("Icefiends", ItemID.FD_ICEDIAMOND),
	ICE_GIANTS("Ice giants", ItemID.RTELDRICPET, "Eldric the Ice King"),
	ICE_WARRIORS("Ice warriors", ItemID.MITHRIL_FULL_HELM_TRIM, "Icelord"),
	INFERNAL_MAGES("Infernal mages", ItemID.SLAYERGUIDE_INFERNALMAGE, "Malevolent mage"),
	JAD("TzTok-Jad", ItemID.JAD_PET),
	JELLIES("Jellies", ItemID.SLAYERGUIDE_JELLY, "Jelly"),
	JUNGLE_HORROR("Jungle horrors", ItemID.ARCEUUS_CORPSE_HORROR_INITIAL),
	KALPHITE("Kalphites", ItemID.POH_KALPHITE_SOLDIER),
	KALPHITE_QUEEN("The Kalphite Queen", ItemID.KQPET_WALKING),
	KILLERWATTS("Killerwatts", ItemID.SLAYERGUIDE_KILLERWATT),
	KING_BLACK_DRAGON("The King Black Dragon", ItemID.KBDPET),
	KRAKEN("The Cave Kraken Boss", ItemID.KRAKENPET, "Kraken"),
	KREEARRA("Kree'arra", ItemID.ARMADYLPET),
	KRIL_TSUTSAROTH("K'ril Tsutsaroth", ItemID.ZAMORAKPET),
	KURASK("Kurask", ItemID.SLAYERGUIDE_KURASK),
	LAVA_DRAGONS("Lava Dragons", ItemID.LAVA_SCALE, "Lava dragon"),
	LESSER_DEMONS("Lesser demons", ItemID.LESSER_DEMON_MASK, "Zakl'n Gritch"),
	LESSER_NAGUA("Lesser Nagua", ItemID.SLAYERGUIDE_LESSER_NAGUA, "Sulphur Nagua", "Frost Nagua", "Amoxliatl"),
	LIZARDMEN("Lizardmen", ItemID.LIZARDMAN_FANG, "Lizardman"),
	LIZARDS("Lizards", ItemID.SLAYERGUIDE_LIZARD),
	MAGIC_AXES("Magic axes", ItemID.IRON_BATTLEAXE),
	MAMMOTHS("Mammoths", ItemID.BARBASSAULT_ATT_HORN_01),
	METAL_DRAGONS("Metal dragons", ItemID.POH_STEEL_DRAGON, "Bronze dragon", "Iron Dragon", "Steel dragon", "Mithril dragon", "Adamant dragon", "Rune dragon"),
	MINIONS_OF_SCABARAS("Minions of scabaras", ItemID.NTK_SCARAB_GOLD, "Scarab swarm", "Locust rider", "Scarab mage"),
	MINOTAURS("Minotaurs", ItemID.ARCEUUS_CORPSE_MINOTAUR_INITIAL),
	MOGRES("Mogres", ItemID.SLAYERGUIDE_MOGRE),
	MOLANISKS("Molanisks", ItemID.SLAYERGUIDE_MOLANISK),
	MONKEYS("Monkeys", ItemID.ARCEUUS_CORPSE_MONKEY_INITIAL, "Tortured gorilla", "Demonic gorilla", "Padulah"),
	MOSS_GIANTS("Moss giants", ItemID.MOSSY_KEY, "Bryophyta"),
	MUTATED_ZYGOMITES("Mutated zygomites", ItemID.SLAYER_ZYGOMITE_OBJECT, 7, ItemID.SLAYER_SPRAY_PUMP_0, "Zygomite", "Fungi"),
	NECHRYAEL("Nechryael", ItemID.SLAYERGUIDE_NECHRYAEL, "Nechryarch"),
	OGRES("Ogres", ItemID.ARCEUUS_CORPSE_OGRE_INITIAL, "Enclave guard", "Mogre", "Ogress", "Skogre", "Zogre"),
	OTHERWORLDLY_BEING("Otherworldly beings", ItemID.SECRET_GHOST_HAT),
	PHANTOM_MUSPAH("The Phantom Muspah", ItemID.MUSPAHPET),
	PIRATES("Pirates", ItemID.BREW_RED_PIRATE_HAT, "Pirate"),
	PYREFIENDS("Pyrefiends", ItemID.SLAYERGUIDE_PYRFIEND, "Flaming pyrelord"),
	RATS("Rats", ItemID.RATS_TAIL),
	RED_DRAGONS("Red dragons", ItemID.POH_DRAGON),
	REVENANTS("Revenants", ItemID.WILD_CAVE_BRACELET_CHARGED),
	ROCKSLUGS("Rockslugs", ItemID.SLAYERGUIDE_ROCKSLUG, 4, ItemID.SLAYER_BAG_OF_SALT),
	ROGUES("Rogues", ItemID.ROGUESDEN_HELM),
	SARACHNIS("Sarachnis", ItemID.SARACHNISPET),
	SCORPIA("Scorpia", ItemID.SCORPIA_PET),
	SCORPIONS("Scorpions", ItemID.ARCEUUS_CORPSE_SCORPION_INITIAL, "Scorpia", "Lobstrosity"),
	SEA_SNAKES("Sea snakes", ItemID.HUNDRED_ILM_SNAKE_CORPSE),
	SHADES("Shades", ItemID.BLACKROBETOP, "Loar", "Phrin", "Riyl", "Asyn", "Fiyr", "Urium"),
	SHADOW_WARRIORS("Shadow warriors", ItemID.BLACK_FULL_HELM),
	SHELLBANE_GRYPHON("Shellbane Gryphon", ItemID.GRYPHONBOSSPET_ADULT),
	SKELETAL_WYVERNS("Skeletal wyverns", ItemID.SLAYERGUIDE_SKELETALWYVERN),
	SKELETONS("Skeletons", ItemID.POH_SKELETON_GUARD, "Vet'ion", "Calvar'ion", "Skeletal Mystic"),
	SMOKE_DEVILS("Smoke devils", ItemID.CERT_GUIDE_ICON_DUMMY),
	SOURHOGS("Sourhogs", ItemID.PORCINE_SOURHOG_TROPHY),
	SPIDERS("Spiders", ItemID.POH_SPIDER, "Kalrag", "Sarachnis", "Venenatis", "Spindel", "Araxxor", "Araxyte"),
	SPIRITUAL_CREATURES("Spiritual creatures", ItemID.DRAGON_BOOTS, "Spiritual ranger", "Spiritual mage", "Spiritual warrior"),
	SUQAHS("Suqahs", ItemID.SUQKA_TOOTH),
	TERROR_DOGS("Terror dogs", ItemID.SLAYERGUIDE_TERRORDOG),
	THE_LEVIATHAN("The Leviathan", ItemID.LEVIATHANPET),
	THE_WHISPERER("The Whisperer", ItemID.WHISPERERPET),
	THERMONUCLEAR_SMOKE_DEVIL("The Thermonuclear Smoke Devil", ItemID.SMOKEPET),
	TROLLS("Trolls", ItemID.POH_TROLL, "Dad", "Arrg", "Stick", "Kraka", "Pee Hat", "Rock", "Twig", "Berry"),
	TUROTH("Turoth", ItemID.SLAYERGUIDE_TUROTH),
	TZHAAR("Tzhaar", ItemID.ARCEUUS_CORPSE_TZHAAR_INITIAL, "TzTok-Jad", "TzKal-Zuk"),
	VAMPYRES("Vampyres", ItemID.STAKE, "Vyrewatch"),
	VARDORVIS("Vardorvis", ItemID.VARDORVISPET),
	VENENATIS("Venenatis", ItemID.VENENATIS_PET),
	VETION("Vet'ion", ItemID.VETION_PET),
	VORKATH("Vorkath", ItemID.VORKATHPET),
	WALL_BEASTS("Wall beasts", ItemID.SWAMP_WALLBEAST),
	WARPED_CREATURES("Warped Creatures", ItemID.POG_SLAYER_DUMMY_WARPED_TERRORBIRD, "Warped terrorbird", "Warped tortoise", "Mutated terrorbird", "Mutated tortoise"),
	WATERFIENDS("Waterfiends", ItemID.WATER_ORB),
	WEREWOLVES("Werewolves", ItemID.DAGGER_WOLFBANE, "Werewolf"),
	WOLVES("Wolves", ItemID.GREY_WOLF_FUR, "Wolf"),
	WYRMS("Wyrms", ItemID.SLAYERGUIDE_WYRM, "Wyrmling", "Strykewyrm"),
	ZILYANA("Commander Zilyana", ItemID.SARADOMINPET),
	ZOMBIES("Zombies", ItemID.TRICK_OR_TREAT_HEAD, "Undead", "Vorkath", "Zogre"),
	ZUK("TzKal-Zuk", ItemID.INFERNOPET_ZUK),
	ZULRAH("Zulrah", ItemID.SNAKEPET);
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
