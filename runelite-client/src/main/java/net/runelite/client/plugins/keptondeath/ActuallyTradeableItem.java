/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.keptondeath;

import java.util.HashSet;
import static net.runelite.api.ItemID.ADAMANT_FIRE_ARROWS;
import static net.runelite.api.ItemID.ADAMANT_FIRE_ARROWS_2539;
import static net.runelite.api.ItemID.AIR_RUNE_PACK;
import static net.runelite.api.ItemID.AMETHYST_FIRE_ARROWS;
import static net.runelite.api.ItemID.AMETHYST_FIRE_ARROWS_21330;
import static net.runelite.api.ItemID.AMULET_OF_GLORY1;
import static net.runelite.api.ItemID.AMULET_OF_GLORY2;
import static net.runelite.api.ItemID.AMULET_OF_GLORY3;
import static net.runelite.api.ItemID.AMULET_OF_GLORY5;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T1;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T2;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T3;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T5;
import static net.runelite.api.ItemID.APPLES1;
import static net.runelite.api.ItemID.APPLES2;
import static net.runelite.api.ItemID.APPLES3;
import static net.runelite.api.ItemID.APPLES4;
import static net.runelite.api.ItemID.BANANAS1;
import static net.runelite.api.ItemID.BANANAS2;
import static net.runelite.api.ItemID.BANANAS3;
import static net.runelite.api.ItemID.BANANAS4;
import static net.runelite.api.ItemID.BASKET_PACK;
import static net.runelite.api.ItemID.BLACK_MASK_1;
import static net.runelite.api.ItemID.BLACK_MASK_2;
import static net.runelite.api.ItemID.BLACK_MASK_3;
import static net.runelite.api.ItemID.BLACK_MASK_4;
import static net.runelite.api.ItemID.BLACK_MASK_5;
import static net.runelite.api.ItemID.BLACK_MASK_6;
import static net.runelite.api.ItemID.BLACK_MASK_7;
import static net.runelite.api.ItemID.BLACK_MASK_8;
import static net.runelite.api.ItemID.BLACK_MASK_9;
import static net.runelite.api.ItemID.BLACK_SATCHEL;
import static net.runelite.api.ItemID.BRONZE_FIRE_ARROWS;
import static net.runelite.api.ItemID.BRONZE_FIRE_ARROWS_942;
import static net.runelite.api.ItemID.BURNING_AMULET1;
import static net.runelite.api.ItemID.BURNING_AMULET2;
import static net.runelite.api.ItemID.BURNING_AMULET3;
import static net.runelite.api.ItemID.BURNING_AMULET4;
import static net.runelite.api.ItemID.CAKE;
import static net.runelite.api.ItemID.CHAOS_RUNE_PACK;
import static net.runelite.api.ItemID.CHOCOLATE_CAKE;
import static net.runelite.api.ItemID.CHOCOLATE_SLICE;
import static net.runelite.api.ItemID.COMBAT_BRACELET1;
import static net.runelite.api.ItemID.COMBAT_BRACELET2;
import static net.runelite.api.ItemID.COMBAT_BRACELET3;
import static net.runelite.api.ItemID.COMBAT_BRACELET5;
import static net.runelite.api.ItemID.DRAGON_FIRE_ARROWS;
import static net.runelite.api.ItemID.DRAGON_FIRE_ARROWS_11222;
import static net.runelite.api.ItemID.EARTH_RUNE_PACK;
import static net.runelite.api.ItemID.FEATHER_PACK;
import static net.runelite.api.ItemID.FIRE_RUNE_PACK;
import static net.runelite.api.ItemID.GAMES_NECKLACE1;
import static net.runelite.api.ItemID.GAMES_NECKLACE2;
import static net.runelite.api.ItemID.GAMES_NECKLACE3;
import static net.runelite.api.ItemID.GAMES_NECKLACE4;
import static net.runelite.api.ItemID.GAMES_NECKLACE5;
import static net.runelite.api.ItemID.GAMES_NECKLACE6;
import static net.runelite.api.ItemID.GAMES_NECKLACE7;
import static net.runelite.api.ItemID.GOLD_SATCHEL;
import static net.runelite.api.ItemID.GREEN_SATCHEL;
import static net.runelite.api.ItemID.HALF_AN_ADMIRAL_PIE;
import static net.runelite.api.ItemID.HALF_AN_APPLE_PIE;
import static net.runelite.api.ItemID.HALF_A_BOTANICAL_PIE;
import static net.runelite.api.ItemID.HALF_A_FISH_PIE;
import static net.runelite.api.ItemID.HALF_A_GARDEN_PIE;
import static net.runelite.api.ItemID.HALF_A_MEAT_PIE;
import static net.runelite.api.ItemID.HALF_A_MUSHROOM_PIE;
import static net.runelite.api.ItemID.HALF_A_REDBERRY_PIE;
import static net.runelite.api.ItemID.HALF_A_SUMMER_PIE;
import static net.runelite.api.ItemID.HALF_A_WILD_PIE;
import static net.runelite.api.ItemID.IRON_FIRE_ARROWS;
import static net.runelite.api.ItemID.IRON_FIRE_ARROWS_2533;
import static net.runelite.api.ItemID.MIND_RUNE_PACK;
import static net.runelite.api.ItemID.MITHRIL_FIRE_ARROWS;
import static net.runelite.api.ItemID.MITHRIL_FIRE_ARROWS_2537;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE1;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE2;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE3;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE4;
import static net.runelite.api.ItemID.ORANGES1;
import static net.runelite.api.ItemID.ORANGES2;
import static net.runelite.api.ItemID.ORANGES3;
import static net.runelite.api.ItemID.ORANGES4;
import static net.runelite.api.ItemID.PLAIN_SATCHEL;
import static net.runelite.api.ItemID.PLANT_POT_PACK;
import static net.runelite.api.ItemID.RED_SATCHEL;
import static net.runelite.api.ItemID.RING_OF_DUELING1;
import static net.runelite.api.ItemID.RING_OF_DUELING2;
import static net.runelite.api.ItemID.RING_OF_DUELING3;
import static net.runelite.api.ItemID.RING_OF_DUELING4;
import static net.runelite.api.ItemID.RING_OF_DUELING5;
import static net.runelite.api.ItemID.RING_OF_DUELING6;
import static net.runelite.api.ItemID.RING_OF_DUELING7;
import static net.runelite.api.ItemID.RING_OF_WEALTH_1;
import static net.runelite.api.ItemID.RING_OF_WEALTH_2;
import static net.runelite.api.ItemID.RING_OF_WEALTH_3;
import static net.runelite.api.ItemID.RING_OF_WEALTH_4;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I1;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I2;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I3;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I4;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I5;
import static net.runelite.api.ItemID.RUNE_FIRE_ARROWS;
import static net.runelite.api.ItemID.RUNE_FIRE_ARROWS_2541;
import static net.runelite.api.ItemID.RUNE_SATCHEL;
import static net.runelite.api.ItemID.SACK_PACK;
import static net.runelite.api.ItemID.SKILLS_NECKLACE1;
import static net.runelite.api.ItemID.SKILLS_NECKLACE2;
import static net.runelite.api.ItemID.SKILLS_NECKLACE3;
import static net.runelite.api.ItemID.SKILLS_NECKLACE5;
import static net.runelite.api.ItemID.SLICE_OF_CAKE;
import static net.runelite.api.ItemID.STEEL_FIRE_ARROWS;
import static net.runelite.api.ItemID.STEEL_FIRE_ARROWS_2535;
import static net.runelite.api.ItemID.STRAWBERRIES1;
import static net.runelite.api.ItemID.STRAWBERRIES2;
import static net.runelite.api.ItemID.STRAWBERRIES3;
import static net.runelite.api.ItemID.STRAWBERRIES4;
import static net.runelite.api.ItemID.TOMATOES1;
import static net.runelite.api.ItemID.TOMATOES2;
import static net.runelite.api.ItemID.TOMATOES3;
import static net.runelite.api.ItemID.TOMATOES4;
import static net.runelite.api.ItemID.TZHAAR_AIR_RUNE_PACK;
import static net.runelite.api.ItemID.TZHAAR_EARTH_RUNE_PACK;
import static net.runelite.api.ItemID.TZHAAR_FIRE_RUNE_PACK;
import static net.runelite.api.ItemID.TZHAAR_WATER_RUNE_PACK;
import static net.runelite.api.ItemID.UNFINISHED_BROAD_BOLT_PACK;
import static net.runelite.api.ItemID.WATER_RUNE_PACK;
import static net.runelite.api.ItemID._12_ANCHOVY_PIZZA;
import static net.runelite.api.ItemID._12_MEAT_PIZZA;
import static net.runelite.api.ItemID._12_PINEAPPLE_PIZZA;
import static net.runelite.api.ItemID._12_PLAIN_PIZZA;
import static net.runelite.api.ItemID._23_CAKE;
import static net.runelite.api.ItemID._23_CHOCOLATE_CAKE;

/**
 * Certain items aren't tradeable via the GE but can be traded between players.
 * The {@link net.runelite.api.ItemDefinition}'s `isTradeable` value is based on GE trade-ability so we need
 * to account for these items. These items should only be kept if protected based on item value.
 */
public enum ActuallyTradeableItem
{
	// Item Packs
	RUNE_PACKS(AIR_RUNE_PACK, WATER_RUNE_PACK, EARTH_RUNE_PACK, FIRE_RUNE_PACK, CHAOS_RUNE_PACK, MIND_RUNE_PACK),
	TZHAAR_PACKS(TZHAAR_AIR_RUNE_PACK, TZHAAR_WATER_RUNE_PACK, TZHAAR_EARTH_RUNE_PACK, TZHAAR_FIRE_RUNE_PACK),
	OTHER_PACKS(BASKET_PACK, FEATHER_PACK, PLANT_POT_PACK, SACK_PACK, UNFINISHED_BROAD_BOLT_PACK),
	// Equipment
	BLACK_MASK(BLACK_MASK_1, BLACK_MASK_2, BLACK_MASK_3, BLACK_MASK_4, BLACK_MASK_5, BLACK_MASK_6, BLACK_MASK_7, BLACK_MASK_8, BLACK_MASK_9),
	SATCHELS(BLACK_SATCHEL, GOLD_SATCHEL, GREEN_SATCHEL, PLAIN_SATCHEL, RED_SATCHEL, RUNE_SATCHEL),
	FIRE_ARROWS(BRONZE_FIRE_ARROWS, IRON_FIRE_ARROWS, STEEL_FIRE_ARROWS, MITHRIL_FIRE_ARROWS, ADAMANT_FIRE_ARROWS, RUNE_FIRE_ARROWS, AMETHYST_FIRE_ARROWS, DRAGON_FIRE_ARROWS),
	FIRE_ARROWS_2(BRONZE_FIRE_ARROWS_942, IRON_FIRE_ARROWS_2533, STEEL_FIRE_ARROWS_2535, MITHRIL_FIRE_ARROWS_2537, ADAMANT_FIRE_ARROWS_2539, RUNE_FIRE_ARROWS_2541, AMETHYST_FIRE_ARROWS_21330, DRAGON_FIRE_ARROWS_11222),
	// Food Items
	HALF_A(HALF_A_GARDEN_PIE, HALF_A_MEAT_PIE, HALF_A_MUSHROOM_PIE, HALF_A_REDBERRY_PIE, HALF_A_BOTANICAL_PIE, HALF_A_FISH_PIE, HALF_A_SUMMER_PIE, HALF_A_WILD_PIE, HALF_AN_ADMIRAL_PIE, HALF_AN_APPLE_PIE),
	PIZZA(_12_ANCHOVY_PIZZA, _12_MEAT_PIZZA, _12_PINEAPPLE_PIZZA, _12_PLAIN_PIZZA),
	CAKES(CAKE, _23_CAKE, SLICE_OF_CAKE, CHOCOLATE_CAKE, _23_CHOCOLATE_CAKE, CHOCOLATE_SLICE),
	BASKETS(APPLES1, APPLES2, APPLES3, APPLES4, BANANAS1, BANANAS2, BANANAS3, BANANAS4, ORANGES1, ORANGES2, ORANGES3, ORANGES4, STRAWBERRIES1, STRAWBERRIES2, STRAWBERRIES3, STRAWBERRIES4, TOMATOES1, TOMATOES2, TOMATOES3, TOMATOES4),
	// Charged Jewelery
	BURNING_AMULET(BURNING_AMULET1, BURNING_AMULET2, BURNING_AMULET3, BURNING_AMULET4),
	NECKLACE_OF_PASSAGE(NECKLACE_OF_PASSAGE1, NECKLACE_OF_PASSAGE2, NECKLACE_OF_PASSAGE3, NECKLACE_OF_PASSAGE4),
	RING_OF_DUELING(RING_OF_DUELING1, RING_OF_DUELING2, RING_OF_DUELING3, RING_OF_DUELING4, RING_OF_DUELING5, RING_OF_DUELING6, RING_OF_DUELING7),
	GAMES_NECKLACE(GAMES_NECKLACE1, GAMES_NECKLACE2, GAMES_NECKLACE3, GAMES_NECKLACE4, GAMES_NECKLACE5, GAMES_NECKLACE6, GAMES_NECKLACE7),
	COMBAT_BRACELET(COMBAT_BRACELET1, COMBAT_BRACELET2, COMBAT_BRACELET3, COMBAT_BRACELET5),
	RING_OF_WEALTH(RING_OF_WEALTH_I, RING_OF_WEALTH_1, RING_OF_WEALTH_I1, RING_OF_WEALTH_2, RING_OF_WEALTH_I2, RING_OF_WEALTH_3, RING_OF_WEALTH_I3, RING_OF_WEALTH_4, RING_OF_WEALTH_I4, RING_OF_WEALTH_I5),
	AMULET_OF_GLORY(AMULET_OF_GLORY1, AMULET_OF_GLORY2, AMULET_OF_GLORY3, AMULET_OF_GLORY5),
	AMULET_OF_GLORY_T(AMULET_OF_GLORY_T1, AMULET_OF_GLORY_T2, AMULET_OF_GLORY_T3, AMULET_OF_GLORY_T5),
	SKILLS_NECKLACE(SKILLS_NECKLACE1, SKILLS_NECKLACE2, SKILLS_NECKLACE3, SKILLS_NECKLACE5),
	;

	private final int[] ids;

	private static final HashSet<Integer> ID_SET;

	static
	{
		ID_SET = new HashSet<>();
		for (ActuallyTradeableItem p : values())
		{
			for (int id : p.ids)
			{
				ID_SET.add(id);
			}
		}
	}

	ActuallyTradeableItem(int... ids)
	{
		this.ids = ids;
	}

	public static Boolean check(int id)
	{
		return ID_SET.contains(id);
	}
}
