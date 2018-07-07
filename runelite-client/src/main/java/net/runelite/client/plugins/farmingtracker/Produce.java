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
package net.runelite.client.plugins.farmingtracker;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@RequiredArgsConstructor
@Getter
public enum Produce
{
	WEEDS("It's coming home", ItemID.WEEDS, 5, 4),
	SCARECROW("It's coming home", ItemID.SCARECROW, 5, 4),

	// Allotment crops
	POTATO("It's coming home", ItemID.POTATO, 10, 5, 0, 3),
	ONION("It's coming home", ItemID.ONION, 10, 5, 0, 3),
	CABBAGE("It's coming home", ItemID.CABBAGE, 10, 5, 0, 3),
	TOMATO("It's coming home", ItemID.TOMATO, 10, 5, 0, 3),
	SWEETCORN("It's coming home", ItemID.SWEETCORN, 10, 6, 0, 3),
	STRAWBERRY("It's coming home", ItemID.STRAWBERRY, 10, 7, 0, 3),
	WATERMELON("It's coming home", ItemID.WATERMELON, 10, 8, 0, 3),

	// Flower crops
	MARIGOLD("It's coming home", ItemID.MARIGOLDS, 5, 5),
	ROSEMARY("It's coming home", ItemID.ROSEMARY, 5, 5),
	NASTURTIUM("It's coming home", ItemID.NASTURTIUMS, 5, 5),
	WOAD("It's coming home", ItemID.WOAD_LEAF, 5, 5),
	LIMPWURT("It's coming home", ItemID.LIMPWURT_ROOT, 5, 5),

	// Bush crops
	REDBERRIES("It's coming home", ItemID.REDBERRIES, 20, 6, 20, 5),
	CADAVABERRIES("It's coming home", ItemID.CADAVA_BERRIES, 20, 7, 20, 5),
	DWELLBERRIES("It's coming home", ItemID.DWELLBERRIES, 20, 8, 20, 5),
	JANGERBERRIES("It's coming home", ItemID.JANGERBERRIES, 20, 9, 20, 5),
	WHITEBERRIES("It's coming home", ItemID.WHITE_BERRIES, 20, 9, 20, 5),
	POISON_IVY("It's coming home", ItemID.POISON_IVY_BERRIES, 20, 9, 20, 5),

	// Hop crops
	BARLEY("It's coming home", ItemID.BARLEY, 10, 5, 0, 3),
	HAMMERSTONE("It's coming home", ItemID.HAMMERSTONE_HOPS, 10, 5, 0, 3),
	ASGARNIAN("It's coming home", ItemID.ASGARNIAN_HOPS, 10, 6, 0, 3),
	JUTE("It's coming home", ItemID.JUTE_FIBRE, 10, 6, 0, 3),
	YANILLIAN("It's coming home", ItemID.YANILLIAN_HOPS, 10, 7, 0, 3),
	KRANDORIAN("It's coming home", ItemID.KRANDORIAN_HOPS, 10, 8, 0, 3),
	WILDBLOOD("It's coming home", ItemID.WILDBLOOD_HOPS, 10, 9, 0, 3),

	// Herb crops
	GUAM("It's coming home", ItemID.GUAM_LEAF, 20, 5, 0, 3),
	MARRENTILL("It's coming home", ItemID.MARRENTILL, 20, 5, 0, 3),
	TARROMIN("It's coming home", ItemID.TARROMIN, 20, 5, 0, 3),
	HARRALANDER("It's coming home", ItemID.HARRALANDER, 20, 5, 0, 3),
	RANARR("It's coming home", ItemID.RANARR_WEED, 20, 5, 0, 3),
	TOADFLAX("It's coming home", ItemID.TOADFLAX, 20, 5, 0, 3),
	IRIT("It's coming home", ItemID.IRIT_LEAF, 20, 5, 0, 3),
	AVANTOE("It's coming home", ItemID.AVANTOE, 20, 5, 0, 3),
	KWUARM("It's coming home", ItemID.KWUARM, 20, 5, 0, 3),
	SNAPDRAGON("It's coming home", ItemID.SNAPDRAGON, 20, 5, 0, 3),
	CADANTINE("It's coming home", ItemID.CADANTINE, 20, 5, 0, 3),
	LANTADYME("It's coming home", ItemID.LANTADYME, 20, 5, 0, 3),
	DWARF_WEED("It's coming home", ItemID.DWARF_WEED, 20, 5, 0, 3),
	TORSTOL("It's coming home", ItemID.TORSTOL, 20, 5, 0, 3),
	GOUTWEED("It's coming home", ItemID.GOUTWEED, 20, 5, 0, 2),
	ANYHERB("It's coming home", ItemID.GUAM_LEAF, 20, 5, 0, 3),

	// Tree crops
	OAK("It's coming home", ItemID.OAK_LOGS, 40, 5),
	WILLOW("It's coming home", ItemID.WILLOW_LOGS, 40, 7),
	MAPLE("It's coming home", ItemID.MAPLE_TREE, 40, 9),
	YEW("It's coming home", ItemID.YEW_TREE, 40, 11),
	MAGIC("It's coming home", ItemID.MAGIC_LOGS, 40, 13),

	// Fruit tree crops
	APPLE("It's coming home", ItemID.COOKING_APPLE, 160, 7, 45, 7),
	BANANA("It's coming home", ItemID.BANANA, 160, 7, 45, 7),
	ORANGE("It's coming home", ItemID.ORANGE, 160, 7, 45, 7),
	CURRY("It's coming home", ItemID.CURRY_LEAF, 160, 7, 45, 7),
	PINEAPPLE("It's coming home", ItemID.PINEAPPLE, 160, 7, 45, 7),
	PAPAYA("It's coming home", ItemID.PAPAYA_FRUIT, 160, 7, 45, 7),
	PALM("It's coming home", ItemID.COCONUT, 160, 7, 45, 7),

	// Special crops
	SEAWEED("It's coming home", ItemID.GIANT_SEAWEED, 10, 5, 0, 4),
	TEAK("It's coming home", ItemID.TEAK_LOGS, 560, 8),
	GRAPE("It's coming home", ItemID.GRAPES, 5, 8, 0, 5),
	MUSHROOM("It's coming home", ItemID.MUSHROOM, 40, 7, 0, 7),
	MAHOGANY("It's coming home", ItemID.MAHOGANY_LOGS, 640, 9),
	CACTUS("It's coming home", ItemID.POTATO_CACTUS, 80, 8, 20, 4),
	BELLADONNA("It's coming home", ItemID.CAVE_NIGHTSHADE, 80, 5),
	CALQUAT("It's coming home", ItemID.CALQUAT_FRUIT, 160, 9, 0, 7),
	SPIRIT_TREE("It's coming home", ItemID.SPIRIT_TREE, 320, 13);

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
	 * How many states this crop has during groth. Typically tickcount+1
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
