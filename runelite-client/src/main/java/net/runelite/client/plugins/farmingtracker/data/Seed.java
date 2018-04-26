/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingtracker.data;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_10;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_160;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_20;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_320;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_40;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_5;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_560;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_640;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_8;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_80;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.ALLOTMENT;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.BUSH;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.FLOWER;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.FRUIT_TREE;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.HERB;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.HOP;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.SPECIAL;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.TREE;

@Getter
@AllArgsConstructor
public enum Seed
{
	/**
	 * Allotment seeds
	 */
	POTATO("Potato", ALLOTMENT, ItemID.POTATO, TICK_10, 4),
	ONION("Onion", ALLOTMENT, ItemID.ONION, TICK_10, 4),
	CABBAGE("Cabbage", ALLOTMENT, ItemID.CABBAGE, TICK_10, 4),
	TOMATO("Tomato", ALLOTMENT, ItemID.TOMATO, TICK_10, 4),
	SWEETCORN("Sweetcorn", ALLOTMENT, ItemID.SWEETCORN, TICK_10, 5),
	STRAWBERRY("Strawberry", ALLOTMENT, ItemID.STRAWBERRY, TICK_10, 6),
	WATERMELON("Watermelon", ALLOTMENT, ItemID.WATERMELON, TICK_10, 7),

	/**
	 * Flower seeds
	 */
	MARIGOLD("Marigold", FLOWER, ItemID.MARIGOLDS, TICK_5, 4),
	ROSEMARY("Rosemary", FLOWER, ItemID.ROSEMARY, TICK_5, 4),
	NASTURTIUM("Nasturtium", FLOWER, ItemID.NASTURTIUMS, TICK_5, 4),
	WOAD_LEAVES("Woad", FLOWER, ItemID.WOAD_LEAF, TICK_5, 4),
	LIMPWURT_ROOTS("Limpwurt", FLOWER, ItemID.LIMPWURT_ROOT, TICK_5, 5),

	/**
	 * Bush seeds
	 */
	REDBERRY("Redberry", BUSH, ItemID.REDBERRIES, TICK_20, 5),
	CADAVABERRY("Cadavaberry", BUSH, ItemID.CADAVA_BERRIES, TICK_20, 6),
	DWELLBERRY("Dwellberry", BUSH, ItemID.DWELLBERRIES, TICK_20, 7),
	JANGERBERRY("Jangerberry", BUSH, ItemID.JANGERBERRIES, TICK_20, 8),
	WHITEBERRY("Whiteberry", BUSH, ItemID.WHITE_BERRIES, TICK_20, 8),
	POISON_IVY("Poison", BUSH, ItemID.POISON_IVY_BERRIES, TICK_20, 8),

	/**
	 * Hop seeds
	 */
	BARLEY("Barley", HOP, ItemID.BARLEY, TICK_10, 4), //Detected
	HAMMERSTONE("Hammerstone", HOP, ItemID.HAMMERSTONE_HOPS, TICK_10, 4), //Detected
	ASGARNIAN("Asgarnian", HOP, ItemID.ASGARNIAN_HOPS, TICK_10, 5),
	JUTE("Jute", HOP, ItemID.JUTE_FIBRE, TICK_10, 5), //Detected
	YANNILLIAN("Yanillian", HOP, ItemID.YANILLIAN_HOPS, TICK_10, 6),
	KRANDORIAN("Krandorian", HOP, ItemID.KRANDORIAN_HOPS, TICK_10, 7),
	WILDBLOOD("Wildblood", HOP, ItemID.WILDBLOOD_HOPS, TICK_10, 8),

	/**
	 * Herb seeds
	 */
	GUAM("Guam", HERB, ItemID.GUAM_LEAF, TICK_20, 4),
	MARRENTILL("Marrentill", HERB, ItemID.MARRENTILL, TICK_20, 4),
	TARROMIN("Tarromin", HERB, ItemID.TARROMIN, TICK_20, 4),
	HARRALANDER("Harralander", HERB, ItemID.HARRALANDER, TICK_20, 4),
	RANARR("Ranarr", HERB, ItemID.RANARR_WEED, TICK_20, 4),
	TOADFLAX("Toadflax", HERB, ItemID.TOADFLAX, TICK_20, 4),
	IRIT("Irit", HERB, ItemID.IRIT_LEAF, TICK_20, 4),
	AVANTOE("Avantoe", HERB, ItemID.AVANTOE, TICK_20, 4),
	KWUARM("Kwuarm", HERB, ItemID.KWUARM, TICK_20, 4),
	SNAPDRAGON("Snapdragon", HERB, ItemID.SNAPDRAGON, TICK_20, 4),
	CADANTINE("Cadantine", HERB, ItemID.CADANTINE, TICK_20, 4),
	LANTADYME("Lantadyme", HERB, ItemID.LANTADYME, TICK_20, 4),
	DWARF("Dwarf", HERB, ItemID.DWARF_WEED, TICK_20, 4),
	TORSTOL("Torstol", HERB, ItemID.TORSTOL, TICK_20, 4),

	/**
	 * Tree seeds
	 */
	OAK("Oak", TREE, ItemID.OAK_LOGS, TICK_40, 4),
	WILLOW("Willow", TREE, ItemID.WILLOW_LOGS, TICK_40, 7),
	MAPLE("Maple", TREE, ItemID.MAPLE_TREE, TICK_40, 7),
	YEW("Yew", TREE, ItemID.YEW_TREE, TICK_40, 10),
	MAGIC("Magic", TREE, ItemID.MAGIC_LOGS, TICK_40, 12),

	/**
	 * Fruit tree seeds
	 */
	APPLE("Apple", FRUIT_TREE, ItemID.COOKING_APPLE, TICK_160, 6),
	BANANA("Banana", FRUIT_TREE, ItemID.BANANA, TICK_160, 6),
	ORANGE("Orange", FRUIT_TREE, ItemID.ORANGE, TICK_160, 6),
	CURRY("Curry", FRUIT_TREE, ItemID.CURRY_LEAF, TICK_160, 6),
	PINEAPPLE("Pineapple", FRUIT_TREE, ItemID.PINEAPPLE, TICK_160, 6),
	PAPAYA("Papaya", FRUIT_TREE, ItemID.PAPAYA_FRUIT, TICK_160, 6),
	PALM("Palm", FRUIT_TREE, ItemID.COCONUT, TICK_160, 6),

	/**
	 * Special seeds
	 */
	SEAWEED("Seaweed", SPECIAL, ItemID.GIANT_SEAWEED, TICK_10, 7),
	TEAK("Teak", SPECIAL, ItemID.TEAK_LOGS, TICK_560, 8),
	GRAPE("Grape", SPECIAL, ItemID.GRAPES, TICK_8, 6),
	BITTERCAP_MUSHROOM("Bittercap", SPECIAL, ItemID.MUSHROOM, TICK_40, 6), //Detected
	MAHOGANY("Mahogany", SPECIAL, ItemID.MAHOGANY_LOGS, TICK_640, 9),
	CACTUS("Cactus", SPECIAL, ItemID.CACTUS_SPINE, TICK_80, 7),
	BELLADONNA("Belladonna", SPECIAL, ItemID.CAVE_NIGHTSHADE, TICK_80, 4), //Detected
	CALQUAT("Calquat", SPECIAL, ItemID.CALQUAT_FRUIT, TICK_160, 8),
	SPIRIT("Spirit", SPECIAL, ItemID.SPIRIT_TREE, TICK_320, 11);

	private final String name;
	private final PatchType patchType;
	private final int spriteId;
	private final FarmingTick farmingTick;
	private final int totalStages;

	public static Seed findByName(String seedName, PatchType patchType)
	{
		Set<Seed> availableSeeds = findSeedForPatchType(patchType);

		for (Seed seed : availableSeeds)
		{
			if (seed.getName().equalsIgnoreCase(seedName))
			{
				return seed;
			}
		}

		return null;
	}

	private static Set<Seed> findSeedForPatchType(PatchType patchType)
	{
		Set<Seed> seeds = new HashSet<>();

		for (Seed seed : Seed.values())
		{
			if (seed.getPatchType().equals(patchType))
			{
				seeds.add(seed);
			}
		}

		return seeds;
	}
}
