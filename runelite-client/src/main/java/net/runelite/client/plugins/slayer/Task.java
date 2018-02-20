/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
	ABERRANT_SPECTRES("aberrant spectres", ItemID.ABERRANT_SPECTRE),
	ABYSSAL_DEMONS("abyssal demons", ItemID.ABYSSAL_DEMON),
	ANKOU("ankou", ItemID.ANKOU_MASK),
	AVIANSIES("aviansies", ItemID.ENSOULED_AVIANSIE_HEAD),
	BANSHEES("banshees", ItemID.BANSHEE),
	BASILISKS("basilisks", ItemID.BASILISK),
	BATS("bats", ItemID.GIRAL_BAT_2),
	BEARS("bears", ItemID.ENSOULED_BEAR_HEAD),
	BIRDS("birds", ItemID.FEATHER),
	BLACK_DEMONS("black demons", ItemID.BLACK_DEMON_MASK),
	BLACK_DRAGONS("black dragons", ItemID.BLACK_DRAGON_MASK),
	BLOODVELD("bloodveld", ItemID.BLOODVELD),
	BLUE_DRAGONS("blue dragons", ItemID.BLUE_DRAGON_MASK),
	BRINE_RATS("brine rats", ItemID.BRINE_RAT),
	BRONZE_DRAGONS("bronze dragons", ItemID.BRONZE_DRAGON_MASK),
	CATABLEPON("catablepon", ItemID.LEFT_SKULL_HALF),
	CAVE_BUGS("cave bugs", ItemID.SWAMP_CAVE_BUG),
	CAVE_CRAWLERS("cave crawlers", ItemID.CAVE_CRAWLER),
	CAVE_HORRORS("cave horrors", ItemID.CAVE_HORROR),
	CAVE_KRAKEN("cave kraken", ItemID.CAVE_KRAKEN),
	CAVE_SLIMES("cave slimes", ItemID.SWAMP_CAVE_SLIME),
	COCKATRICE("cockatrice", ItemID.COCKATRICE),
	COWS("cows", ItemID.COW_MASK),
	CRAWLING_HANDS("crawling hands", ItemID.CRAWLING_HAND),
	CROCODILES("crocodiles", ItemID.SWAMP_LIZARD),
	DAGANNOTH("dagannoth", ItemID.DAGANNOTH),
	DARK_BEASTS("dark beasts", ItemID.DARK_BEAST),
	DESERT_LIZARDS("desert lizards", ItemID.DESERT_LIZARD),
	DOGS("dogs", ItemID.GUARD_DOG),
	DUST_DEVILS("dust devils", ItemID.DUST_DEVIL),
	DWARVES("dwarves", ItemID.DWARVEN_HELMET),
	EARTH_WARRIORS("earth warriors", ItemID.BRONZE_FULL_HELM_T),
	ELVES("elves", ItemID.ELF),
	FEVER_SPIDERS("fever spiders", ItemID.FEVER_SPIDER),
	GARGOYLES("gargoyles", ItemID.GARGOYLE),
	GOBLINS("goblins", ItemID.ENSOULED_GOBLIN_HEAD),
	GREATER_DEMONS("greater demons", ItemID.GREATER_DEMON_MASK),
	GREEN_DRAGONS("green dragons", ItemID.GREEN_DRAGON_MASK),
	HARPIE_BUG_SWARMS("harpie bug swarms", ItemID.SWARM),
	HELLHOUNDS("hellhounds", ItemID.HELLHOUND),
	HILL_GIANTS("hill giants", ItemID.ENSOULED_GIANT_HEAD),
	HOBGOBLINS("hobgoblins", ItemID.HOBGOBLIN_GUARD),
	ICE_WARRIORS("ice warriors", ItemID.MITHRIL_FULL_HELM_T),
	INFERNAL_MAGES("infernal mages", ItemID.INFERNAL_MAGE),
	IRON_DRAGONS("iron dragons", ItemID.IRON_DRAGON_MASK),
	JELLIES("jellies", ItemID.JELLY),
	KALPHITE("kalphite", ItemID.KALPHITE_SOLDIER),
	KILLERWATTS("killerwatts", ItemID.KILLERWATT),
	KURASK("kurask", ItemID.KURASK),
	LESSER_DEMONS("lesser demons", ItemID.LESSER_DEMON_MASK),
	LIZARDMEN("lizardmen", ItemID.LIZARDMAN_FANG),
	MINIONS_OF_SCABARAS("minions of scabaras", ItemID.GOLDEN_SCARAB),
	MINOTAURS("minotaurs", ItemID.ENSOULED_MINOTAUR_HEAD),
	MITHRIL_DRAGONS("mithril dragons", ItemID.MITHRIL_DRAGON_MASK),
	MOGRES("mogres", ItemID.MOGRE),
	MOLANISKS("molanisks", ItemID.MOLANISK),
	MONKEYS("monkeys", ItemID.ENSOULED_MONKEY_HEAD),
	MUTATED_ZYGOMITES("mutated zygomites", ItemID.MUTATED_ZYGOMITE),
	NECHRYAEL("nechryael", ItemID.NECHRYAEL),
	OGRES("ogres", ItemID.ENSOULED_OGRE_HEAD),
	OTHERWORLDLY_BEING("otherworldly being", ItemID.GHOSTLY_HOOD),
	PYREFIENDS("pyrefiends", ItemID.PYREFIEND),
	RATS("rats", ItemID.RATS_TAIL),
	RED_DRAGONS("red dragons", ItemID.BABY_RED_DRAGON),
	ROCKSLUGS("rockslugs", ItemID.ROCKSLUG),
	SEA_SNAKES("sea snakes", ItemID.SNAKE_CORPSE),
	SHADES("shades", ItemID.SHADE_ROBE_TOP),
	SKELETAL_WYVERNS("skeletal wyverns", ItemID.SKELETAL_WYVERN),
	SKELETONS("skeletons", ItemID.SKELETON_GUARD),
	SMOKE_DEVILS("smoke devils", ItemID.SMOKE_DEVIL),
	SPIDERS("spiders", ItemID.HUGE_SPIDER),
	STEEL_DRAGONS("steel dragons", ItemID.STEEL_DRAGON),
	SUQAHS("suqahs", ItemID.SUQAH_TOOTH),
	TERROR_DOGS("terror dogs", ItemID.TERROR_DOG),
	TROLLS("trolls", ItemID.TROLL_GUARD),
	TUROTH("turoth", ItemID.TUROTH),
	TZHAAR("tzhaar", ItemID.ENSOULED_TZHAAR_HEAD),
	VAMPIRES("vampires", ItemID.STAKE),
	WALL_BEASTS("wall beasts", ItemID.SWAMP_WALLBEAST),
	WEREWOLVES("werewolves", ItemID.WOLFBANE),
	WOLVES("wolves", ItemID.GREY_WOLF_FUR),
	ZOMBIES("zombies", ItemID.ZOMBIE_HEAD);
	//</editor-fold>

	private static final Map<String, Task> tasks = new HashMap<>();

	private final String name;
	private final int itemSpriteId;

	static
	{
		for (Task task : values())
		{
			tasks.put(task.getName(), task);
		}
	}

	Task(String name, int itemSpriteId)
	{
		Preconditions.checkArgument(itemSpriteId >= 0);
		this.name = name;
		this.itemSpriteId = itemSpriteId;
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
}
