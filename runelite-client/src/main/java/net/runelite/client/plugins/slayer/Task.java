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
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ItemID;

enum Task
{
	//<editor-fold desc="Enums">
	ABERRANT_SPECTRES("aberrant spectres", ItemID.ABERRANT_SPECTRE, new String[]{"deviant spectre"}, "abhorrent spectre", "repugnant spectre"),
	ABYSSAL_DEMONS("abyssal demons", ItemID.ABYSSAL_DEMON, new String[]{"abyssal sire"}, "greater abyssal demon"),
	ADAMANT_DRAGONS("adamant dragons", ItemID.ADAMANTITE_BAR, new String[]{}),
	ANKOU("ankou", ItemID.ANKOU_MASK, new String[]{}),
	AVIANSIES("aviansies", ItemID.ENSOULED_AVIANSIE_HEAD, new String[]{}),
	BANSHEES("banshees", ItemID.BANSHEE, new String[]{"twisted banshee"}, "screaming"),
	BASILISKS("basilisks", ItemID.BASILISK, new String[]{}, "monstrous"),
	BATS("bats", ItemID.GIRAL_BAT_2, new String[]{}),
	BEARS("bears", ItemID.ENSOULED_BEAR_HEAD, new String[]{"callisto"}),
	BIRDS("birds", ItemID.FEATHER, new String[]{"chicken", "rooster", "terrorbird", "vulture"}),
	BLACK_DEMONS("black demons", ItemID.BLACK_DEMON_MASK, new String[]{"demonic gorilla", "balfrug kreeyath", "skotizo"}),
	BLACK_DRAGONS("black dragons", ItemID.BLACK_DRAGON_MASK, new String[]{}),
	BLOODVELD("bloodveld", ItemID.BLOODVELD, new String[]{}, "insatiable"),
	BLUE_DRAGONS("blue dragons", ItemID.BLUE_DRAGON_MASK, new String[]{}, "vorkath"),
	BRINE_RATS("brine rats", ItemID.BRINE_RAT, new String[]{}),
	BRONZE_DRAGONS("bronze dragons", ItemID.BRONZE_DRAGON_MASK, new String[]{}),
	CATABLEPON("catablepon", ItemID.LEFT_SKULL_HALF, new String[]{}),
	CAVE_BUGS("cave bugs", ItemID.SWAMP_CAVE_BUG, new String[]{}),
	CAVE_CRAWLERS("cave crawlers", ItemID.CAVE_CRAWLER, new String[]{}, "chasm crawler"),
	CAVE_HORRORS("cave horrors", ItemID.CAVE_HORROR, new String[]{}, "cave abomination"),
	CAVE_KRAKEN("cave kraken", ItemID.CAVE_KRAKEN, new String[]{}),
	CAVE_SLIMES("cave slimes", ItemID.SWAMP_CAVE_SLIME, new String[]{}),
	COCKATRICE("cockatrice", ItemID.COCKATRICE, new String[]{}, "cockathrice"),
	COWS("cows", ItemID.COW_MASK, new String[]{}),
	CRAWLING_HANDS("crawling hands", ItemID.CRAWLING_HAND, new String[]{}, "crushing hand"),
	CROCODILES("crocodiles", ItemID.SWAMP_LIZARD, new String[]{}),
	DAGANNOTH("dagannoth", ItemID.DAGANNOTH, new String[]{}),
	DARK_BEASTS("dark beasts", ItemID.DARK_BEAST, new String[]{}, "night beast"),
	DESERT_LIZARDS("desert lizards", ItemID.DESERT_LIZARD, new String[]{"lizard"}),
	DOGS("dogs", ItemID.GUARD_DOG, new String[]{}, "jackal"),
	DUST_DEVILS("dust devils", ItemID.DUST_DEVIL, new String[]{}, "choke devil"),
	DWARVES("dwarves", ItemID.DWARVEN_HELMET, new String[]{"dwarf", "black guard"}),
	EARTH_WARRIORS("earth warriors", ItemID.BRONZE_FULL_HELM_T, new String[]{}),
	ELVES("elves", ItemID.ELF, new String[]{"elf"}),
	FEVER_SPIDERS("fever spiders", ItemID.FEVER_SPIDER, new String[]{}),
	FIRE_GIANTS("fire giants", ItemID.FIRE_BATTLESTAFF, new String[]{}),
	FLESH_CRAWLERS("flesh crawlers", ItemID.ENSOULED_SCORPION_HEAD, new String[]{}),
	FOSSIL_ISLAND_WYVERNS("fossil island wyverns", ItemID.FOSSIL_ISLAND_WYVERN, new String[]{"ancient wyvern", "long-tailed wyvern", "spitting wyvern", "taloned wyvern"}),
	GARGOYLES("gargoyles", ItemID.GARGOYLE, new String[]{}, "marble gargoyle"),
	GHOSTS("ghosts", ItemID.GHOSTSPEAK_AMULET, new String[]{"tortured soul"}),
	GHOULS("ghouls", ItemID.ZOMBIE_HEAD, new String[]{}),
	GOBLINS("goblins", ItemID.ENSOULED_GOBLIN_HEAD, new String[]{"sergeant strongstack", "sergeant grimspike", "sergeant steelwill"}),
	GREATER_DEMONS("greater demons", ItemID.GREATER_DEMON_MASK, new String[]{"k'ril tsutsaroth", "tstanon karlak", "skotizo"}),
	GREEN_DRAGONS("green dragons", ItemID.GREEN_DRAGON_MASK, new String[]{}),
	HARPIE_BUG_SWARMS("harpie bug swarms", ItemID.SWARM, new String[]{}),
	HELLHOUNDS("hellhounds", ItemID.HELLHOUND, new String[]{"cerberus"}),
	HILL_GIANTS("hill giants", ItemID.ENSOULED_GIANT_HEAD, new String[]{"giant champion"}),
	HOBGOBLINS("hobgoblins", ItemID.HOBGOBLIN_GUARD, new String[]{}),
	ICE_GIANTS("ice giants", ItemID.ICE_DIAMOND, new String[]{}),
	ICE_WARRIORS("ice warriors", ItemID.MITHRIL_FULL_HELM_T, new String[]{}),
	ICEFIENDS("icefiends", ItemID.ICE_DIAMOND, new String[]{}),
	INFERNAL_MAGES("infernal mages", ItemID.INFERNAL_MAGE, new String[]{}, "malevolent mage"),
	IRON_DRAGONS("iron dragons", ItemID.IRON_DRAGON_MASK, new String[]{}),
	JELLIES("jellies", ItemID.JELLY, new String[]{"jelly"}, "vitreous"),
	JUNGLE_HORROR("jungle horrors", ItemID.ENSOULED_HORROR_HEAD, new String[]{}),
	KALPHITE("kalphite", ItemID.KALPHITE_SOLDIER, new String[]{}),
	KILLERWATTS("killerwatts", ItemID.KILLERWATT, new String[]{}),
	KURASK("kurask", ItemID.KURASK, new String[]{}, "king kurask"),
	LESSER_DEMONS("lesser demons", ItemID.LESSER_DEMON_MASK, new String[]{}),
	LIZARDMEN("lizardmen", ItemID.LIZARDMAN_FANG, new String[]{"lizardman"}),
	MINIONS_OF_SCABARAS("minions of scabaras", ItemID.GOLDEN_SCARAB, new String[]{"scarab", "locust rider"}),
	MINOTAURS("minotaurs", ItemID.ENSOULED_MINOTAUR_HEAD, new String[]{}),
	MITHRIL_DRAGONS("mithril dragons", ItemID.MITHRIL_DRAGON_MASK, new String[]{}),
	MOGRES("mogres", ItemID.MOGRE, new String[]{}),
	MOLANISKS("molanisks", ItemID.MOLANISK, new String[]{}),
	MONKEYS("monkeys", ItemID.ENSOULED_MONKEY_HEAD, new String[]{}),
	MOSS_GIANTS("moss giants", ItemID.HILL_GIANT_CLUB, new String[]{}),
	MUTATED_ZYGOMITES("mutated zygomites", ItemID.MUTATED_ZYGOMITE, new String[]{"zygomite"}),
	NECHRYAEL("nechryael", ItemID.NECHRYAEL, new String[]{}, "nechryarch"),
	OGRES("ogres", ItemID.ENSOULED_OGRE_HEAD, new String[]{"enclave guard"}),
	OTHERWORLDLY_BEING("otherworldly being", ItemID.GHOSTLY_HOOD, new String[]{}),
	PYREFIENDS("pyrefiends", ItemID.PYREFIEND, new String[]{}, "flaming pyrelord"),
	RATS("rats", ItemID.RATS_TAIL, new String[]{}),
	RED_DRAGONS("red dragons", ItemID.BABY_RED_DRAGON, new String[]{}),
	ROCKSLUGS("rockslugs", ItemID.ROCKSLUG, new String[]{}, "giant rockslug"),
	RUNE_DRAGONS("rune dragons", ItemID.RUNITE_BAR, new String[]{}),
	SCORPIONS("scorpions", ItemID.ENSOULED_SCORPION_HEAD, new String[]{"scorpia"}),
	SEA_SNAKES("sea snakes", ItemID.SNAKE_CORPSE, new String[]{}),
	SHADES("shades", ItemID.SHADE_ROBE_TOP, new String[]{}),
	SHADOW_WARRIORS("shadow warriors", ItemID.BLACK_FULL_HELM, new String[]{}),
	SKELETAL_WYVERNS("skeletal wyverns", ItemID.SKELETAL_WYVERN, new String[]{}),
	SKELETONS("skeletons", ItemID.SKELETON_GUARD, new String[]{"vet'ion"}),
	SMOKE_DEVILS("smoke devils", ItemID.SMOKE_DEVIL, new String[]{}, "nuclear smoke devil"),
	SPIDERS("spiders", ItemID.HUGE_SPIDER, new String[]{"kalrag"}),
	STEEL_DRAGONS("steel dragons", ItemID.STEEL_DRAGON, new String[]{}),
	SUQAHS("suqahs", ItemID.SUQAH_TOOTH, new String[]{}),
	TERROR_DOGS("terror dogs", ItemID.TERROR_DOG, new String[]{}),
	TROLLS("trolls", ItemID.TROLL_GUARD, new String[]{}),
	TUROTH("turoth", ItemID.TUROTH, new String[]{}),
	TZHAAR("tzhaar", ItemID.ENSOULED_TZHAAR_HEAD, new String[]{}),
	VAMPIRES("vampires", ItemID.STAKE, new String[]{}),
	WALL_BEASTS("wall beasts", ItemID.SWAMP_WALLBEAST, new String[]{}),
	WATERFIENDS("waterfiends", ItemID.WATER_ORB, new String[]{}),
	WEREWOLVES("werewolves", ItemID.WOLFBANE, new String[]{"werewolf"}),
	WOLVES("wolves", ItemID.GREY_WOLF_FUR, new String[]{"wolf"}),
	ZOMBIES("zombies", ItemID.ZOMBIE_HEAD, new String[]{"undead"});
	//</editor-fold>

	private static final Map<String, Task> tasks = new HashMap<>();

	private final String name;
	private final int itemSpriteId;
	private final String[] targetNames;
	private final String[] superiorNames;

	static
	{
		for (Task task : values())
		{
			tasks.put(task.getName(), task);
		}
	}

	Task(String name, int itemSpriteId, String[] targetNames, String... superiorNames)
	{
		Preconditions.checkArgument(itemSpriteId >= 0);
		this.name = name;
		this.itemSpriteId = itemSpriteId;
		this.targetNames = targetNames;
		this.superiorNames = superiorNames;
	}

	public static Task getTask(String taskName)
	{
		return tasks.get(taskName);
	}

	public String getName()
	{
		return this.name;
	}

	public int getItemSpriteId()
	{
		return itemSpriteId;
	}

	public String[] getTargetNames()
	{
		return this.targetNames;
	}

	public String[] getSuperiorNames()
	{
		return this.superiorNames;
	}
}
