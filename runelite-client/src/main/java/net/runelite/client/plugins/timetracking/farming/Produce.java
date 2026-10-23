/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.timetracking.farming;

import javax.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.ItemID;

@RequiredArgsConstructor
@Getter
public enum Produce
{
	WEEDS("Weeds", ItemID.WEEDS, 5, 4),
	SCARECROW("Scarecrow", ItemID.SCARECROW_COMPLETE, 5, 4),

	// Allotment crops
	POTATO("Potato", 40, PatchImplementation.ALLOTMENT, ItemID.POTATO, 10, 5, 0, 3),
	ONION("Onion", 41, PatchImplementation.ALLOTMENT, ItemID.ONION, 10, 5, 0, 3),
	CABBAGE("Cabbage", 42, PatchImplementation.ALLOTMENT, ItemID.CABBAGE, 10, 5, 0, 3),
	TOMATO("Tomato", 43, PatchImplementation.ALLOTMENT, ItemID.TOMATO, 10, 5, 0, 3),
	SWEETCORN("Sweetcorn", 44, PatchImplementation.ALLOTMENT, ItemID.SWEETCORN, 10, 7, 0, 3),
	STRAWBERRY("Strawberry", 45, PatchImplementation.ALLOTMENT, ItemID.STRAWBERRY, 10, 7, 0, 3),
	WATERMELON("Watermelon", 46, PatchImplementation.ALLOTMENT, ItemID.WATERMELON, 10, 9, 0, 3),
	SNAPE_GRASS("Snape grass", 47, PatchImplementation.ALLOTMENT, ItemID.SNAPE_GRASS, 10, 8, 0, 3),

	// Flower crops
	MARIGOLD("Marigold", 34, PatchImplementation.FLOWER, ItemID.MARIGOLD, 5, 5),
	ROSEMARY("Rosemary", 35, PatchImplementation.FLOWER, ItemID.ROSEMARY, 5, 5),
	NASTURTIUM("Nasturtium", 36, PatchImplementation.FLOWER, ItemID.NASTURTIUM, 5, 5),
	WOAD("Woad", 37, PatchImplementation.FLOWER, ItemID.WOADLEAF, 5, 5),
	LIMPWURT("Limpwurt", 38, PatchImplementation.FLOWER, ItemID.LIMPWURT_ROOT, 5, 5),
	WHITE_LILY("White lily", 39, PatchImplementation.FLOWER, ItemID.WHITELILLY, 5, 5),

	// Bush crops
	REDBERRIES("Redberry", 1, PatchImplementation.BUSH, ItemID.REDBERRIES, 20, 6, 20, 5),
	CADAVABERRIES("Cadavaberry", 2, PatchImplementation.BUSH, ItemID.CADAVABERRIES, 20, 7, 20, 5),
	DWELLBERRIES("Dwellberry", 3, PatchImplementation.BUSH, ItemID.DWELLBERRIES, 20, 8, 20, 5),
	JANGERBERRIES("Jangerberry", 4, PatchImplementation.BUSH, ItemID.JANGERBERRIES, 20, 9, 20, 5),
	WHITEBERRIES("Whiteberry", 5, PatchImplementation.BUSH, ItemID.WHITE_BERRIES, 20, 9, 20, 5),
	POISON_IVY("Poison ivy", 6, PatchImplementation.BUSH, ItemID.POISONIVY_BERRIES, 20, 9, 20, 5),

	// Hop crops
	BARLEY("Barley", PatchImplementation.HOPS, ItemID.BARLEY, 10, 5, 0, 3),
	HAMMERSTONE("Hammerstone", PatchImplementation.HOPS, ItemID.HAMMERSTONE_HOPS, 10, 5, 0, 3),
	ASGARNIAN("Asgarnian", PatchImplementation.HOPS, ItemID.ASGARNIAN_HOPS, 10, 6, 0, 3),
	JUTE("Jute", PatchImplementation.HOPS, ItemID.JUTE_FIBRE, 10, 6, 0, 3),
	YANILLIAN("Yanillian", PatchImplementation.HOPS, ItemID.YANILLIAN_HOPS, 10, 7, 0, 3),
	FLAX("Flax", PatchImplementation.HOPS, ItemID.FLAX, 20, 4, 0, 3),
	KRANDORIAN("Krandorian", PatchImplementation.HOPS, ItemID.KRANDORIAN_HOPS, 10, 8, 0, 3),
	WILDBLOOD("Wildblood", PatchImplementation.HOPS, ItemID.WILDBLOOD_HOPS, 10, 9, 0, 3),
	HEMP("Hemp", PatchImplementation.HOPS, ItemID.HEMP, 20, 5, 0, 3),
	COTTON("Cotton", PatchImplementation.HOPS, ItemID.COTTON_BOLL, 20, 6, 0, 3),

	// Herb crops
	GUAM("Guam", 20, PatchImplementation.HERB, ItemID.GUAM_LEAF, 20, 5, 0, 3),
	MARRENTILL("Marrentill", 21, PatchImplementation.HERB, ItemID.MARENTILL, 20, 5, 0, 3),
	TARROMIN("Tarromin", 22, PatchImplementation.HERB, ItemID.TARROMIN, 20, 5, 0, 3),
	HARRALANDER("Harralander", 23, PatchImplementation.HERB, ItemID.HARRALANDER, 20, 5, 0, 3),
	RANARR("Ranarr", 24, PatchImplementation.HERB, ItemID.RANARR_WEED, 20, 5, 0, 3),
	TOADFLAX("Toadflax", 25, PatchImplementation.HERB, ItemID.TOADFLAX, 20, 5, 0, 3),
	IRIT("Irit", 26, PatchImplementation.HERB, ItemID.IRIT_LEAF, 20, 5, 0, 3),
	AVANTOE("Avantoe", 27, PatchImplementation.HERB, ItemID.AVANTOE, 20, 5, 0, 3),
	KWUARM("Kwuarm", 28, PatchImplementation.HERB, ItemID.KWUARM, 20, 5, 0, 3),
	HUASCA("Huasca", PatchImplementation.HERB, ItemID.HUASCA, 20, 5, 0, 3),
	SNAPDRAGON("Snapdragon", 29, PatchImplementation.HERB, ItemID.SNAPDRAGON, 20, 5, 0, 3),
	CADANTINE("Cadantine", 30, PatchImplementation.HERB, ItemID.CADANTINE, 20, 5, 0, 3),
	LANTADYME("Lantadyme", 31, PatchImplementation.HERB, ItemID.LANTADYME, 20, 5, 0, 3),
	DWARF_WEED("Dwarf weed", 32, PatchImplementation.HERB, ItemID.DWARF_WEED, 20, 5, 0, 3),
	TORSTOL("Torstol", 33, PatchImplementation.HERB, ItemID.TORSTOL, 20, 5, 0, 3),
	GOUTWEED("Goutweed", PatchImplementation.HERB, ItemID.EADGAR_GOUTWEED_HERB, 20, 5, 0, 2),
	ANYHERB("Any herb", PatchImplementation.HERB, ItemID.GUAM_LEAF, 20, 5, 0, 3),

	// Tree crops
	OAK("Oak", 7, PatchImplementation.TREE, ItemID.OAK_LOGS, 40, 5),
	WILLOW("Willow", 8, PatchImplementation.TREE, ItemID.WILLOW_LOGS, 40, 7),
	MAPLE("Maple", 9, PatchImplementation.TREE, ItemID.MAPLE_LOGS, 40, 9),
	YEW("Yew", 10, PatchImplementation.TREE, ItemID.YEW_LOGS, 40, 11),
	MAGIC("Magic", 11, PatchImplementation.TREE, ItemID.MAGIC_LOGS, 40, 13),

	// Fruit tree crops
	APPLE("Apple", 12, PatchImplementation.FRUIT_TREE, ItemID.COOKING_APPLE, 160, 7, 45, 7),
	BANANA("Banana", 13, PatchImplementation.FRUIT_TREE, ItemID.BANANA, 160, 7, 45, 7),
	ORANGE("Orange", 14, PatchImplementation.FRUIT_TREE, ItemID.ORANGE, 160, 7, 45, 7),
	CURRY("Curry", 15, PatchImplementation.FRUIT_TREE, ItemID.CURRY_LEAF, 160, 7, 45, 7),
	PINEAPPLE("Pineapple", 16, PatchImplementation.FRUIT_TREE, ItemID.PINEAPPLE, 160, 7, 45, 7),
	PAPAYA("Papaya", 17, PatchImplementation.FRUIT_TREE, ItemID.PAPAYA, 160, 7, 45, 7),
	PALM("Palm", 18, PatchImplementation.FRUIT_TREE, ItemID.COCONUT, 160, 7, 45, 7),
	DRAGONFRUIT("Dragonfruit", 19, PatchImplementation.FRUIT_TREE, ItemID.DRAGONFRUIT, 160, 7, 45, 7),

	// Cactus
	CACTUS("Cactus", 48, PatchImplementation.CACTUS, ItemID.CACTUS_SPINE, 80, 8, 20, 4),
	POTATO_CACTUS("Potato cactus", 49, PatchImplementation.CACTUS, ItemID.CACTUS_POTATO, 10, 8, 5, 7),

	// Hardwood
	TEAK("Teak", PatchImplementation.HARDWOOD_TREE, ItemID.TEAK_LOGS, 640, 8),
	MAHOGANY("Mahogany", PatchImplementation.HARDWOOD_TREE, ItemID.MAHOGANY_LOGS, 640, 9),
	CAMPHOR("Camphor", PatchImplementation.HARDWOOD_TREE, ItemID.CAMPHOR_LOGS, 640, 9),
	IRONWOOD("Ironwood", PatchImplementation.HARDWOOD_TREE, ItemID.IRONWOOD_LOGS, 640, 9),
	ROSEWOOD("Rosewood", PatchImplementation.HARDWOOD_TREE, ItemID.ROSEWOOD_LOGS, 640, 10),

	// Anima
	ATTAS("Attas", PatchImplementation.ANIMA, ItemID.ANIMA_ATTAS, 640, 9),
	IASOR("Iasor", PatchImplementation.ANIMA, ItemID.ANIMA_IASOR, 640, 9),
	KRONOS("Kronos", PatchImplementation.ANIMA, ItemID.ANIMA_KRONOS, 640, 9),

	// Coral
	ELKHORN_CORAL("Elkhorn", PatchImplementation.CORAL, ItemID.CORAL_ELKHORN, 40, 5),
	PILLAR_CORAL("Pillar", PatchImplementation.CORAL, ItemID.CORAL_PILLAR, 40, 5),
	UMBRAL_CORAL("Umbral", PatchImplementation.CORAL, ItemID.CORAL_UMBRAL, 40, 5),

	// Special crops
	SEAWEED("Seaweed", PatchImplementation.SEAWEED, ItemID.GIANT_SEAWEED, 10, 5, 0, 4),
	GRAPE("Grape", PatchImplementation.GRAPES, ItemID.GRAPES, 5, 8, 0, 5),
	MUSHROOM("Mushroom", PatchImplementation.MUSHROOM, ItemID.BITTERCAP_MUSHROOM, 40, 7, 0, 7),
	BELLADONNA("Belladonna", PatchImplementation.BELLADONNA, ItemID.NIGHTSHADE, 80, 5),
	CALQUAT("Calquat", PatchImplementation.CALQUAT, ItemID.CALQUAT_FRUIT, 160, 9, 0, 7),
	SPIRIT_TREE("Spirit tree", PatchImplementation.SPIRIT_TREE, ItemID.SPIRIT_TREE_DUMMY, 320, 13),
	CELASTRUS("Celastrus", 51, PatchImplementation.CELASTRUS, ItemID.BATTLESTAFF, 160, 6, 0, 4),
	REDWOOD("Redwood", 50, PatchImplementation.REDWOOD, ItemID.REDWOOD_LOGS, 640, 11),
	HESPORI("Hespori", PatchImplementation.HESPORI, ItemID.HESPORI, 640, 4, 0, 2),
	CRYSTAL_TREE("Crystal tree", PatchImplementation.CRYSTAL_TREE, ItemID.GAUNTLET_CRYSTAL_SHARD, 80, 7),

	// Compost bins
	EMPTY_COMPOST_BIN("Compost Bin", PatchImplementation.COMPOST, ItemID.EADGAR_FADE_TO_BLACK_INV, 0, 1, 0, 0), // Dummy produce for the empty state
	COMPOST("Compost", PatchImplementation.COMPOST, ItemID.BUCKET_COMPOST, 40, 3, 0, 15),
	SUPERCOMPOST("Supercompost", PatchImplementation.COMPOST, ItemID.BUCKET_SUPERCOMPOST, 40, 3, 0, 15),
	ULTRACOMPOST("Ultracompost", PatchImplementation.COMPOST, ItemID.BUCKET_ULTRACOMPOST, 0, 3, 0, 15), // Ultra doesn't compost,
	ROTTEN_TOMATO("Rotten Tomato", PatchImplementation.COMPOST, ItemID.ROTTEN_TOMATO, 40, 3, 0, 15),
	EMPTY_BIG_COMPOST_BIN("Big Compost Bin", PatchImplementation.COMPOST, ItemID.EADGAR_FADE_TO_BLACK_INV, 0, 1, 0, 0), // Dummy produce for the empty state
	BIG_COMPOST("Compost", PatchImplementation.BIG_COMPOST, ItemID.BUCKET_COMPOST, 40, 3, 0, 30),
	BIG_SUPERCOMPOST("Supercompost", PatchImplementation.BIG_COMPOST, ItemID.BUCKET_SUPERCOMPOST, 40, 3, 0, 30),
	BIG_ULTRACOMPOST("Ultracompost", PatchImplementation.BIG_COMPOST, ItemID.BUCKET_ULTRACOMPOST, 0, 3, 0, 30), // Ultra doesn't compost
	BIG_ROTTEN_TOMATO("Rotten Tomato", PatchImplementation.BIG_COMPOST, ItemID.ROTTEN_TOMATO, 40, 3, 0, 30);

	/**
	 * User-visible name
	 */
	private final String name;
	/**
	 * Value of VarbitID.FARMGUILD_CONTRACT_TYPE for this crop
	 */
	private final int contractVarbitValue;
	/**
	 * Patch type for the crop
	 */
	private final PatchImplementation patchImplementation;
	/**
	 * User-visible item icon
	 */
	private final int itemID;
	/**
	 * How many minutes per growth tick
	 */
	private final int tickrate;
	/**
	 * How many states this crop has during growth. Typically tickcount+1
	 */
	private final int stages;
	/**
	 * How many minutes to regrow crops, or zero if it doesn't regrow
	 */
	private final int regrowTickrate;
	/**
	 * How many states this crop has during harvest.
	 * This is often called lives.
	 */
	private final int harvestStages;

	Produce(String name, PatchImplementation patchImplementation, int itemID, int tickrate, int stages, int regrowTickrate, int harvestStages)
	{
		this(name, -1, patchImplementation, itemID, tickrate, stages, regrowTickrate, harvestStages);
	}

	Produce(String name, int contractVarbitValue, PatchImplementation patchImplementation, int itemID, int tickrate, int stages)
	{
		this(name, contractVarbitValue, patchImplementation, itemID, tickrate, stages, 0, 1);
	}

	Produce(String name, PatchImplementation patchImplementation, int itemID, int tickrate, int stages)
	{
		this(name, -1, patchImplementation, itemID, tickrate, stages, 0, 1);
	}

	Produce(String name, int itemID, int tickrate, int stages)
	{
		this(name, -1, null, itemID, tickrate, stages, 0, 1);
	}

	@Nullable
	static Produce getByItemID(int itemId)
	{
		for (Produce produce : Produce.values())
		{
			if (produce.getItemID() == itemId)
			{
				return produce;
			}
		}
		return null;
	}

	@Nullable
	static Produce getByContractVarbitValue(int contractVarbitValue)
	{
		for (Produce produce : Produce.values())
		{
			if (produce.getContractVarbitValue() == contractVarbitValue)
			{
				return produce;
			}
		}
		return null;
	}
}
