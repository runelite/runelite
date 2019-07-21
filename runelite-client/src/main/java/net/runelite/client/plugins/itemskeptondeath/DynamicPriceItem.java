/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.itemskeptondeath;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

/**
 * Degradable/Non-rechargeable Jewelry death prices are usually determined by the amount of charges the item has left.
 * The price of each charge is based on the GE price of the fully charged item divided by the maximum item charges
 * Charge price = GE Price / Max Charges
 * Death Price = Charge price * Current Charges
 */
@AllArgsConstructor
@Getter
enum DynamicPriceItem
{
	GAMES_NECKLACE1(ItemID.GAMES_NECKLACE1, 1, 8, ItemID.GAMES_NECKLACE8),
	GAMES_NECKLACE2(ItemID.GAMES_NECKLACE2, 2, 8, ItemID.GAMES_NECKLACE8),
	GAMES_NECKLACE3(ItemID.GAMES_NECKLACE3, 3, 8, ItemID.GAMES_NECKLACE8),
	GAMES_NECKLACE4(ItemID.GAMES_NECKLACE4, 4, 8, ItemID.GAMES_NECKLACE8),
	GAMES_NECKLACE5(ItemID.GAMES_NECKLACE5, 5, 8, ItemID.GAMES_NECKLACE8),
	GAMES_NECKLACE6(ItemID.GAMES_NECKLACE6, 6, 8, ItemID.GAMES_NECKLACE8),
	GAMES_NECKLACE7(ItemID.GAMES_NECKLACE7, 7, 8, ItemID.GAMES_NECKLACE8),

	RING_OF_DUELING1(ItemID.RING_OF_DUELING1, 1, 8, ItemID.RING_OF_DUELING8),
	RING_OF_DUELING2(ItemID.RING_OF_DUELING2, 2, 8, ItemID.RING_OF_DUELING8),
	RING_OF_DUELING3(ItemID.RING_OF_DUELING3, 3, 8, ItemID.RING_OF_DUELING8),
	RING_OF_DUELING4(ItemID.RING_OF_DUELING4, 4, 8, ItemID.RING_OF_DUELING8),
	RING_OF_DUELING5(ItemID.RING_OF_DUELING5, 5, 8, ItemID.RING_OF_DUELING8),
	RING_OF_DUELING6(ItemID.RING_OF_DUELING6, 6, 8, ItemID.RING_OF_DUELING8),
	RING_OF_DUELING7(ItemID.RING_OF_DUELING7, 7, 8, ItemID.RING_OF_DUELING8),

	RING_OF_RETURNING1(ItemID.RING_OF_RETURNING1, 1, 5, ItemID.RING_OF_RETURNING5),
	RING_OF_RETURNING2(ItemID.RING_OF_RETURNING2, 2, 5, ItemID.RING_OF_RETURNING5),
	RING_OF_RETURNING3(ItemID.RING_OF_RETURNING3, 3, 5, ItemID.RING_OF_RETURNING5),
	RING_OF_RETURNING4(ItemID.RING_OF_RETURNING4, 4, 5, ItemID.RING_OF_RETURNING5),

	NECKLACE_OF_PASSAGE1(ItemID.NECKLACE_OF_PASSAGE1, 1, 5, ItemID.NECKLACE_OF_PASSAGE5),
	NECKLACE_OF_PASSAGE2(ItemID.NECKLACE_OF_PASSAGE2, 2, 5, ItemID.NECKLACE_OF_PASSAGE5),
	NECKLACE_OF_PASSAGE3(ItemID.NECKLACE_OF_PASSAGE3, 3, 5, ItemID.NECKLACE_OF_PASSAGE5),
	NECKLACE_OF_PASSAGE4(ItemID.NECKLACE_OF_PASSAGE4, 4, 5, ItemID.NECKLACE_OF_PASSAGE5),

	BURNING_AMULET1(ItemID.BURNING_AMULET1, 1, 5, ItemID.BURNING_AMULET5),
	BURNING_AMULET2(ItemID.BURNING_AMULET2, 2, 5, ItemID.BURNING_AMULET5),
	BURNING_AMULET3(ItemID.BURNING_AMULET3, 3, 5, ItemID.BURNING_AMULET5),
	BURNING_AMULET4(ItemID.BURNING_AMULET4, 4, 5, ItemID.BURNING_AMULET5);

	private final int itemId;
	private final int currentCharges;
	private final int maxCharges;
	private final int chargedId;

	private static final Map<Integer, DynamicPriceItem> DYNAMIC_ITEMS;

	static
	{
		final ImmutableMap.Builder<Integer, DynamicPriceItem> map = ImmutableMap.builder();
		for (final DynamicPriceItem p : values())
		{
			map.put(p.itemId, p);
		}
		DYNAMIC_ITEMS = map.build();
	}

	/**
	 * Calculates the price off the partially charged jewelry based on the base items price
	 * @param basePrice price of the base item, usually the trade-able variant
	 * @return death price of the current DynamicPriceItem
	 */
	int calculateDeathPrice(final int basePrice)
	{
		return (basePrice /  maxCharges) * currentCharges;
	}

	@Nullable
	static DynamicPriceItem find(int itemId)
	{
		return DYNAMIC_ITEMS.get(itemId);
	}
}
