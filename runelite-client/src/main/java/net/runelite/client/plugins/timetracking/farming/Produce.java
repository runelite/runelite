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

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;
import net.runelite.api.NullItemID;

@RequiredArgsConstructor
@Getter
public enum Produce
{
	WEEDS("Weeds", ItemID.WEEDS, 5, 4),
	SCARECROW("Scarecrow", ItemID.SCARECROW, 5, 4),

	// Allotment crops
	POTATO("Potato", ItemID.POTATO, 10, 5, 0, 3),
	ONION("Onion", ItemID.ONION, 10, 5, 0, 3),
	CABBAGE("Cabbage", ItemID.CABBAGE, 10, 5, 0, 3),
	TOMATO("Tomato", ItemID.TOMATO, 10, 5, 0, 3),
	SWEETCORN("Sweetcorn", ItemID.SWEETCORN, 10, 6, 0, 3),
	STRAWBERRY("Strawberry", ItemID.STRAWBERRY, 10, 7, 0, 3),
	WATERMELON("Watermelon", ItemID.WATERMELON, 10, 8, 0, 3),
	SNAPE_GRASS("Snape grass", ItemID.SNAPE_GRASS, 10, 8, 0, 3),

	// Flower crops
	MARIGOLD("Marigold", ItemID.MARIGOLDS, 5, 5),
	ROSEMARY("Rosemary", ItemID.ROSEMARY, 5, 5),
	NASTURTIUM("Nasturtium", ItemID.NASTURTIUMS, 5, 5),
	WOAD("Woad", ItemID.WOAD_LEAF, 5, 5),
	LIMPWURT("Limpwurt", ItemID.LIMPWURT_ROOT, 5, 5),
	WHITE_LILY("While lily", ItemID.WHITE_LILY, 5, 5),

	// Bush crops
	REDBERRIES("Redberry", ItemID.REDBERRIES, 20, 6, 20, 5),
	CADAVABERRIES("Cadavaberry", ItemID.CADAVA_BERRIES, 20, 7, 20, 5),
	DWELLBERRIES("Dwellberry", ItemID.DWELLBERRIES, 20, 8, 20, 5),
	JANGERBERRIES("Jangerberry", ItemID.JANGERBERRIES, 20, 9, 20, 5),
	WHITEBERRIES("Whiteberry", ItemID.WHITE_BERRIES, 20, 9, 20, 5),
	POISON_IVY("Poison", ItemID.POISON_IVY_BERRIES, 20, 9, 20, 5),

	// Hop crops
	BARLEY("Barley", ItemID.BARLEY, 10, 5, 0, 3),
	HAMMERSTONE("Hammerstone", ItemID.HAMMERSTONE_HOPS, 10, 5, 0, 3),
	ASGARNIAN("Asgarnian", ItemID.ASGARNIAN_HOPS, 10, 6, 0, 3),
	JUTE("Jute", ItemID.JUTE_FIBRE, 10, 6, 0, 3),
	YANILLIAN("Yanillian", ItemID.YANILLIAN_HOPS, 10, 7, 0, 3),
	KRANDORIAN("Krandorian", ItemID.KRANDORIAN_HOPS, 10, 8, 0, 3),
	WILDBLOOD("Wildblood", ItemID.WILDBLOOD_HOPS, 10, 9, 0, 3),

	// Herb crops
	GUAM("Guam", ItemID.GUAM_LEAF, 20, 5, 0, 3),
	MARRENTILL("Marrentill", ItemID.MARRENTILL, 20, 5, 0, 3),
	TARROMIN("Tarromin", ItemID.TARROMIN, 20, 5, 0, 3),
	HARRALANDER("Harralander", ItemID.HARRALANDER, 20, 5, 0, 3),
	RANARR("Ranarr", ItemID.RANARR_WEED, 20, 5, 0, 3),
	TOADFLAX("Toadflax", ItemID.TOADFLAX, 20, 5, 0, 3),
	IRIT("Irit", ItemID.IRIT_LEAF, 20, 5, 0, 3),
	AVANTOE("Avantoe", ItemID.AVANTOE, 20, 5, 0, 3),
	KWUARM("Kwuarm", ItemID.KWUARM, 20, 5, 0, 3),
	SNAPDRAGON("Snapdragon", ItemID.SNAPDRAGON, 20, 5, 0, 3),
	CADANTINE("Cadantine", ItemID.CADANTINE, 20, 5, 0, 3),
	LANTADYME("Lantadyme", ItemID.LANTADYME, 20, 5, 0, 3),
	DWARF_WEED("Dwarf Weed", ItemID.DWARF_WEED, 20, 5, 0, 3),
	TORSTOL("Torstol", ItemID.TORSTOL, 20, 5, 0, 3),
	GOUTWEED("Goutweed", ItemID.GOUTWEED, 20, 5, 0, 2),
	ANYHERB("Any herb", ItemID.GUAM_LEAF, 20, 5, 0, 3),

	// Tree crops
	OAK("Oak", ItemID.OAK_LOGS, 40, 5),
	WILLOW("Willow", ItemID.WILLOW_LOGS, 40, 7),
	MAPLE("Maple", ItemID.MAPLE_TREE, 40, 9),
	YEW("Yew", ItemID.YEW_TREE, 40, 11),
	MAGIC("Magic", ItemID.MAGIC_LOGS, 40, 13),

	// Fruit tree crops
	APPLE("Apple", ItemID.COOKING_APPLE, 160, 7, 45, 7),
	BANANA("Banana", ItemID.BANANA, 160, 7, 45, 7),
	ORANGE("Orange", ItemID.ORANGE, 160, 7, 45, 7),
	CURRY("Curry", ItemID.CURRY_LEAF, 160, 7, 45, 7),
	PINEAPPLE("Pineapple", ItemID.PINEAPPLE, 160, 7, 45, 7),
	PAPAYA("Papaya", ItemID.PAPAYA_FRUIT, 160, 7, 45, 7),
	PALM("Palm", ItemID.COCONUT, 160, 7, 45, 7),
	DRAGONFRUIT("Dragonfruit", ItemID.DRAGONFRUIT, 160, 7, 45, 7),

	// Cactus
	CACTUS("Cactus", ItemID.CACTUS_SPINE, 80, 8, 20, 4),
	POTATO_CACTUS("Potato cactus", ItemID.POTATO_CACTUS, 10, 8, 5, 7),

	// Hardwood
	TEAK("Teak", ItemID.TEAK_LOGS, 560, 8),
	MAHOGANY("Mahogany", ItemID.MAHOGANY_LOGS, 640, 9),

	// Anima
	ATTAS("Attas", NullItemID.NULL_22940, 640, 9),
	IASOR("Iasro", NullItemID.NULL_22939, 640, 9),
	KRONOS("Kronos", NullItemID.NULL_22938, 640, 9),

	// Special crops
	SEAWEED("Seaweed", ItemID.GIANT_SEAWEED, 10, 5, 0, 4),
	GRAPE("Grape", ItemID.GRAPES, 5, 8, 0, 5),
	MUSHROOM("Mushroom", ItemID.MUSHROOM, 40, 7, 0, 7),
	BELLADONNA("Belladonna", ItemID.CAVE_NIGHTSHADE, 80, 5),
	CALQUAT("Calquat", ItemID.CALQUAT_FRUIT, 160, 9, 0, 7),
	SPIRIT_TREE("Spirit tree", ItemID.SPIRIT_TREE, 320, 13),
	CELASTRUS("Celastrus", ItemID.BATTLESTAFF, 160, 6, 0, 4),
	REDWOOD("Redwood", ItemID.REDWOOD_LOGS, 640, 11),
	HESPORI("Hespori", NullItemID.NULL_23044, 640, 4, 0, 2);

	/**
	 * User-visible name
	 */
	private final String name;
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

	Produce(String name, int itemID, int tickrate, int stages)
	{
		this(name, itemID, tickrate, stages, 0, 1);
	}
}
