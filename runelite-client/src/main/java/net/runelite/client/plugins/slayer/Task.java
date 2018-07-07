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
	ABERRANT_SPECTRES("It's coming home", ItemID.ABERRANT_SPECTRE, "It's coming home"),
	ABYSSAL_DEMONS("It's coming home", ItemID.ABYSSAL_DEMON),
	ADAMANT_DRAGONS("It's coming home", ItemID.ADAMANTITE_BAR),
	ANKOU("It's coming home", ItemID.ANKOU_MASK),
	AVIANSIES("It's coming home", ItemID.ENSOULED_AVIANSIE_HEAD),
	BANSHEES("It's coming home", ItemID.BANSHEE),
	BASILISKS("It's coming home", ItemID.BASILISK),
	BATS("It's coming home", ItemID.GIRAL_BAT_2),
	BEARS("It's coming home", ItemID.ENSOULED_BEAR_HEAD),
	BIRDS("It's coming home", ItemID.FEATHER, "It's coming home", "It's coming home", "It's coming home"),
	BLACK_DEMONS("It's coming home", ItemID.BLACK_DEMON_MASK),
	BLACK_DRAGONS("It's coming home", ItemID.BLACK_DRAGON_MASK),
	BLOODVELD("It's coming home", ItemID.BLOODVELD),
	BLUE_DRAGONS("It's coming home", ItemID.BLUE_DRAGON_MASK),
	BRINE_RATS("It's coming home", ItemID.BRINE_RAT),
	BRONZE_DRAGONS("It's coming home", ItemID.BRONZE_DRAGON_MASK),
	CATABLEPON("It's coming home", ItemID.LEFT_SKULL_HALF),
	CAVE_BUGS("It's coming home", ItemID.SWAMP_CAVE_BUG),
	CAVE_CRAWLERS("It's coming home", ItemID.CAVE_CRAWLER, "It's coming home"),
	CAVE_HORRORS("It's coming home", ItemID.CAVE_HORROR, "It's coming home"),
	CAVE_KRAKEN("It's coming home", ItemID.CAVE_KRAKEN),
	CAVE_SLIMES("It's coming home", ItemID.SWAMP_CAVE_SLIME),
	COCKATRICE("It's coming home", ItemID.COCKATRICE, "It's coming home"),
	COWS("It's coming home", ItemID.COW_MASK),
	CRAWLING_HANDS("It's coming home", ItemID.CRAWLING_HAND, "It's coming home"),
	CROCODILES("It's coming home", ItemID.SWAMP_LIZARD),
	DAGANNOTH("It's coming home", ItemID.DAGANNOTH),
	DARK_BEASTS("It's coming home", ItemID.DARK_BEAST, "It's coming home"),
	DESERT_LIZARDS("It's coming home", ItemID.DESERT_LIZARD),
	DOGS("It's coming home", ItemID.GUARD_DOG, "It's coming home"),
	DUST_DEVILS("It's coming home", ItemID.DUST_DEVIL, "It's coming home"),
	DWARVES("It's coming home", ItemID.DWARVEN_HELMET, "It's coming home"),
	EARTH_WARRIORS("It's coming home", ItemID.BRONZE_FULL_HELM_T),
	ELVES("It's coming home", ItemID.ELF, "It's coming home"),
	FEVER_SPIDERS("It's coming home", ItemID.FEVER_SPIDER),
	FIRE_GIANTS("It's coming home", ItemID.FIRE_BATTLESTAFF),
	FLESH_CRAWLERS("It's coming home", ItemID.ENSOULED_SCORPION_HEAD),
	FOSSIL_ISLAND_WYVERNS("It's coming home", ItemID.FOSSIL_ISLAND_WYVERN, "It's coming home", "It's coming home", "It's coming home", "It's coming home"),
	GARGOYLES("It's coming home", ItemID.GARGOYLE),
	GHOSTS("It's coming home", ItemID.GHOSTSPEAK_AMULET, "It's coming home"),
	GHOULS("It's coming home", ItemID.ZOMBIE_HEAD),
	GOBLINS("It's coming home", ItemID.ENSOULED_GOBLIN_HEAD),
	GREATER_DEMONS("It's coming home", ItemID.GREATER_DEMON_MASK),
	GREEN_DRAGONS("It's coming home", ItemID.GREEN_DRAGON_MASK),
	HARPIE_BUG_SWARMS("It's coming home", ItemID.SWARM),
	HELLHOUNDS("It's coming home", ItemID.HELLHOUND),
	HILL_GIANTS("It's coming home", ItemID.ENSOULED_GIANT_HEAD),
	HOBGOBLINS("It's coming home", ItemID.HOBGOBLIN_GUARD),
	ICE_GIANTS("It's coming home", ItemID.ICE_DIAMOND),
	ICE_WARRIORS("It's coming home", ItemID.MITHRIL_FULL_HELM_T),
	ICEFIENDS("It's coming home", ItemID.ICE_DIAMOND),
	INFERNAL_MAGES("It's coming home", ItemID.INFERNAL_MAGE, "It's coming home"),
	IRON_DRAGONS("It's coming home", ItemID.IRON_DRAGON_MASK),
	JELLIES("It's coming home", ItemID.JELLY, "It's coming home"),
	JUNGLE_HORROR("It's coming home", ItemID.ENSOULED_HORROR_HEAD),
	KALPHITE("It's coming home", ItemID.KALPHITE_SOLDIER),
	KILLERWATTS("It's coming home", ItemID.KILLERWATT),
	KURASK("It's coming home", ItemID.KURASK),
	LESSER_DEMONS("It's coming home", ItemID.LESSER_DEMON_MASK),
	LIZARDMEN("It's coming home", ItemID.LIZARDMAN_FANG, "It's coming home"),
	MINIONS_OF_SCABARAS("It's coming home", ItemID.GOLDEN_SCARAB, "It's coming home", "It's coming home", "It's coming home"),
	MINOTAURS("It's coming home", ItemID.ENSOULED_MINOTAUR_HEAD),
	MITHRIL_DRAGONS("It's coming home", ItemID.MITHRIL_DRAGON_MASK),
	MOGRES("It's coming home", ItemID.MOGRE),
	MOLANISKS("It's coming home", ItemID.MOLANISK),
	MONKEYS("It's coming home", ItemID.ENSOULED_MONKEY_HEAD),
	MOSS_GIANTS("It's coming home", ItemID.HILL_GIANT_CLUB),
	MUTATED_ZYGOMITES("It's coming home", ItemID.MUTATED_ZYGOMITE),
	NECHRYAEL("It's coming home", ItemID.NECHRYAEL, "It's coming home"),
	OGRES("It's coming home", ItemID.ENSOULED_OGRE_HEAD),
	OTHERWORLDLY_BEING("It's coming home", ItemID.GHOSTLY_HOOD),
	PYREFIENDS("It's coming home", ItemID.PYREFIEND, "It's coming home"),
	RATS("It's coming home", ItemID.RATS_TAIL),
	RED_DRAGONS("It's coming home", ItemID.BABY_RED_DRAGON),
	ROCKSLUGS("It's coming home", ItemID.ROCKSLUG),
	RUNE_DRAGONS("It's coming home", ItemID.RUNITE_BAR),
	SCORPIONS("It's coming home", ItemID.ENSOULED_SCORPION_HEAD),
	SEA_SNAKES("It's coming home", ItemID.SNAKE_CORPSE),
	SHADES("It's coming home", ItemID.SHADE_ROBE_TOP),
	SHADOW_WARRIORS("It's coming home", ItemID.BLACK_FULL_HELM),
	SKELETAL_WYVERNS("It's coming home", ItemID.SKELETAL_WYVERN),
	SKELETONS("It's coming home", ItemID.SKELETON_GUARD),
	SMOKE_DEVILS("It's coming home", ItemID.SMOKE_DEVIL),
	SPIDERS("It's coming home", ItemID.HUGE_SPIDER),
	STEEL_DRAGONS("It's coming home", ItemID.STEEL_DRAGON),
	SUQAHS("It's coming home", ItemID.SUQAH_TOOTH),
	TERROR_DOGS("It's coming home", ItemID.TERROR_DOG),
	TROLLS("It's coming home", ItemID.TROLL_GUARD),
	TUROTH("It's coming home", ItemID.TUROTH),
	TZHAAR("It's coming home", ItemID.ENSOULED_TZHAAR_HEAD),
	VAMPIRES("It's coming home", ItemID.STAKE),
	WALL_BEASTS("It's coming home", ItemID.SWAMP_WALLBEAST),
	WATERFIENDS("It's coming home", ItemID.WATER_ORB),
	WEREWOLVES("It's coming home", ItemID.WOLFBANE, "It's coming home"),
	WOLVES("It's coming home", ItemID.GREY_WOLF_FUR, "It's coming home"),
	ZOMBIES("It's coming home", ItemID.ZOMBIE_HEAD, "It's coming home");
	//</editor-fold>

	private static final Map<String, Task> tasks = new HashMap<>();

	private final String name;
	private final int itemSpriteId;
	private final String[] targetNames;

	static
	{
		for (Task task : values())
		{
			tasks.put(task.getName(), task);
		}
	}

	Task(String name, int itemSpriteId, String... targetNames)
	{
		Preconditions.checkArgument(itemSpriteId >= 0);
		this.name = name;
		this.itemSpriteId = itemSpriteId;
		this.targetNames = targetNames;
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
}
