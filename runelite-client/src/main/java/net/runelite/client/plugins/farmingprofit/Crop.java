/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.farmingprofit;

import lombok.Getter;
import net.runelite.api.ItemID;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration of crops, containing a display name, seed and possible products.
 */
public enum Crop
{
	UNKNOWN("Unknown", -1, -1),

	// Allotments
	POTATO		("Potatoes", 			3, ItemID.POTATO_SEED, 			ItemID.POTATO),
	ONION		("Onions", 				3, ItemID.ONION_SEED, 			ItemID.ONION),
	CABBAGE		("Cabbages", 			3, ItemID.CABBAGE_SEED, 		ItemID.CABBAGE),
	TOMATO		("Tomatoes", 			3, ItemID.TOMATO_SEED, 			ItemID.TOMATO),
	SWEETCORN	("Sweetcorn", 			3, ItemID.SWEETCORN_SEED, 		ItemID.SWEETCORN),
	STRAWBERRY	("Strawberries", 		3, ItemID.STRAWBERRY_SEED, 		ItemID.STRAWBERRY),
	WATERMELON	("Watermelons", 		3, ItemID.WATERMELON_SEED, 		ItemID.WATERMELON),

	// Flowers
	MARIGOLD	("Marigolds", 			1, ItemID.MARIGOLD_SEED, 		ItemID.MARIGOLDS),
	ROSEMARY	("Rosemaries", 			1, ItemID.ROSEMARY_SEED, 		ItemID.ROSEMARY),
	NASTURTIUM	("Nasturtiums", 		1, ItemID.NASTURTIUM_SEED, 		ItemID.NASTURTIUMS),
	LIMPWURT	("Limpwurt roots", 		1, ItemID.LIMPWURT_SEED, 		ItemID.LIMPWURT_ROOT),

	// Herbs
	GUAM		("Guam", 				1, ItemID.GUAM_SEED, 			ItemID.GUAM_LEAF, 	ItemID.GRIMY_GUAM_LEAF),
	MARRENTIL	("Marrentil", 			1, ItemID.MARRENTILL_SEED, 		ItemID.MARRENTILL, 	ItemID.GRIMY_MARRENTILL),
	TARROMIN	("Tarromin", 			1, ItemID.TARROMIN_SEED, 		ItemID.TARROMIN, 	ItemID.GRIMY_TARROMIN),
	HARRALANDER	("Harralander", 		1, ItemID.HARRALANDER_SEED,		ItemID.HARRALANDER, ItemID.GRIMY_HARRALANDER),
	RANARR		("Ranarr", 				1, ItemID.RANARR_SEED, 			ItemID.RANARR_WEED, ItemID.GRIMY_RANARR_WEED),
	TOADFLAX	("Toadflax", 			1, ItemID.TOADFLAX_SEED, 		ItemID.TOADFLAX, 	ItemID.GRIMY_TOADFLAX),
	IRIT		("Irit", 				1, ItemID.IRIT_SEED, 			ItemID.IRIT_LEAF, 	ItemID.GRIMY_IRIT_LEAF),
	AVANTOE		("Avantoe", 			1, ItemID.AVANTOE_SEED, 		ItemID.AVANTOE, 	ItemID.GRIMY_AVANTOE),
	KWUARM		("Kwuarm", 				1, ItemID.KWUARM_SEED, 			ItemID.KWUARM, 		ItemID.GRIMY_KWUARM),
	SNAPDRAGON	("Snapdragon", 			1, ItemID.SNAPDRAGON_SEED, 		ItemID.SNAPDRAGON, 	ItemID.GRIMY_SNAPDRAGON),
	CADANTINE	("Cadantine", 			1, ItemID.CADANTINE_SEED, 		ItemID.CADANTINE, 	ItemID.GRIMY_CADANTINE),
	LANTADYME	("Lantadyme", 			1, ItemID.LANTADYME_SEED, 		ItemID.LANTADYME, 	ItemID.GRIMY_LANTADYME),
	DWARF_WEED	("Dwarf weed", 			1, ItemID.DWARF_WEED_SEED, 		ItemID.DWARF_WEED, 	ItemID.GRIMY_DWARF_WEED),
	TORSTOL		("Torstol", 			1, ItemID.TORSTOL_SEED, 		ItemID.TORSTOL, 	ItemID.GRIMY_TORSTOL),

	// Hops
	BARLEY		("Barley", 				4, ItemID.BARLEY_SEED, 			ItemID.BARLEY),
	HAMMERSTONE	("Hammerstone hops", 	4, ItemID.HAMMERSTONE_SEED, 	ItemID.HAMMERSTONE_HOPS),
	ASGARNIAN	("Asgarnian hops", 		4, ItemID.ASGARNIAN_SEED, 		ItemID.ASGARNIAN_HOPS),
	JUTE		("Jute fibre", 			3, ItemID.JUTE_SEED, 			ItemID.JUTE_FIBRE),
	YANILLIAN	("Yanillian hops", 		4, ItemID.YANILLIAN_SEED, 		ItemID.YANILLIAN_HOPS),
	KRANDORIAN	("Krandorian hops", 	4, ItemID.KRANDORIAN_SEED, 		ItemID.KRANDORIAN_HOPS),
	WILDBLOOD	("Wildblood hops", 		4, ItemID.WILDBLOOD_SEED, 		ItemID.WILDBLOOD_HOPS),

	// Bushes
	REDBERRY	("Redberries", 			1, ItemID.REDBERRY_SEED, 		ItemID.REDBERRIES),
	CADAVABERRY	("Cadava berries", 		1, ItemID.CADAVABERRY_SEED, 	ItemID.CADAVA_BERRIES),
	DWELLBERRY	("Dwellberries", 		1, ItemID.DWELLBERRY_SEED, 		ItemID.DWELLBERRIES),
	JANGERBERRY	("Jangerberries", 		1, ItemID.JANGERBERRY_SEED, 	ItemID.JANGERBERRIES),
	WHITEBERRY	("White berries", 		1, ItemID.WHITEBERRY_SEED, 		ItemID.WHITE_BERRIES),
	POISON_IVY	("Poison ivy berries", 	1, ItemID.POISON_IVY_SEED, 		ItemID.POISON_IVY_BERRIES),

	// Special
	SEAWEED		("Seaweed", 			1, ItemID.SEAWEED_SPORE, 		ItemID.GIANT_SEAWEED),
	CACTUS		("Cactus", 				1, ItemID.CACTUS_SEED, 			ItemID.CACTUS_SPINE);


	Crop(String displayName, int seedAmount, int seedId, int... products)
	{
		this.seedAmount = seedAmount;
		this.seedId = seedId;
		this.products = products;
		this.displayName = displayName;
	}

	@Getter
	private final int seedAmount;
	@Getter
	private final int seedId;
	@Getter
	private final int[] products;
	@Getter
	private final String displayName;

	private static final Map<Integer, Crop> map = Collections.unmodifiableMap(initializeMapping());

	public int getProductId()
	{
		if (products.length > 0)
		{
			return products[0];
		}
		return -1;
	}

	public static Crop fromProductId(int product)
	{
		if (map.containsKey(product))
		{
			return map.get(product);
		}
		return Crop.UNKNOWN;
	}

	private static Map<Integer, Crop> initializeMapping()
	{
		Map<Integer, Crop> mMap = new HashMap<>();
		for (Crop s : Crop.values())
		{
			for (Integer productId : s.products)
			{
				mMap.put(productId, s);
			}
		}
		return mMap;
	}

}
