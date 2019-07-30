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
package net.runelite.client.game;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@Getter
@RequiredArgsConstructor
public enum UntradeableItemMapping
{
	MARK_OF_GRACE(ItemID.MARK_OF_GRACE, 10, ItemID.AMYLASE_CRYSTAL),
	GRACEFUL_HOOD(ItemID.GRACEFUL_HOOD, 28, ItemID.MARK_OF_GRACE),
	GRACEFUL_TOP(ItemID.GRACEFUL_TOP, 44, ItemID.MARK_OF_GRACE),
	GRACEFUL_LEGS(ItemID.GRACEFUL_LEGS, 48, ItemID.MARK_OF_GRACE),
	GRACEFUL_GLOVES(ItemID.GRACEFUL_GLOVES, 24, ItemID.MARK_OF_GRACE),
	GRACEFUL_BOOTS(ItemID.GRACEFUL_BOOTS, 32, ItemID.MARK_OF_GRACE),
	GRACEFUL_CAPE(ItemID.GRACEFUL_CAPE, 32, ItemID.MARK_OF_GRACE),

	// 10 golden nuggets = 100 soft clay
	GOLDEN_NUGGET(ItemID.GOLDEN_NUGGET, 10, ItemID.SOFT_CLAY),
	PROSPECTOR_HELMET(ItemID.PROSPECTOR_HELMET, 32, ItemID.GOLDEN_NUGGET),
	PROSPECTOR_JACKET(ItemID.PROSPECTOR_JACKET, 48, ItemID.GOLDEN_NUGGET),
	PROSPECTOR_LEGS(ItemID.PROSPECTOR_LEGS, 40, ItemID.GOLDEN_NUGGET),
	PROSPECTOR_BOOTS(ItemID.PROSPECTOR_BOOTS, 24, ItemID.GOLDEN_NUGGET),

	CRYSTAL_HELMET(ItemID.CRYSTAL_HELM, 1, ItemID.CRYSTAL_ARMOUR_SEED),
	CRYSTAL_HELMET_INACTIVE(ItemID.CRYSTAL_HELM_INACTIVE, 1, ItemID.CRYSTAL_ARMOUR_SEED),
	CRYSTAL_LEGS(ItemID.CRYSTAL_LEGS, 2, ItemID.CRYSTAL_ARMOUR_SEED),
	CRYSTAL_LEGS_INACTIVE(ItemID.CRYSTAL_LEGS_INACTIVE, 2, ItemID.CRYSTAL_ARMOUR_SEED),
	CRYSTAL_BODY(ItemID.CRYSTAL_BODY, 3, ItemID.CRYSTAL_ARMOUR_SEED),
	CRYSTAL_BODY_INACTIVE(ItemID.CRYSTAL_BODY_INACTIVE, 3, ItemID.CRYSTAL_ARMOUR_SEED);

	private static final ImmutableMap<Integer, UntradeableItemMapping> UNTRADEABLE_RECLAIM_MAP;

	private final int itemID;
	private final int quantity;
	private final int priceID;

	static
	{
		ImmutableMap.Builder<Integer, UntradeableItemMapping> map = ImmutableMap.builder();
		for (UntradeableItemMapping p : values())
		{
			map.put(p.getItemID(), p);
		}
		UNTRADEABLE_RECLAIM_MAP = map.build();
	}

	public static UntradeableItemMapping map(int itemId)
	{
		return UNTRADEABLE_RECLAIM_MAP.get(itemId);
	}
}

