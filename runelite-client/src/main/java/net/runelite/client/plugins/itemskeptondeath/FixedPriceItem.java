/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
 * Some items have a fixed price that is added to its default value when calculating death prices.
 * These are typically imbued items, such as Berserker ring (i), to help it protect over the non-imbued variants.
 */
@AllArgsConstructor
@Getter
enum FixedPriceItem
{
	IMBUED_BLACK_MASK_I(ItemID.BLACK_MASK_I, 5000),
	IMBUED_BLACK_MASK_1_I(ItemID.BLACK_MASK_1_I, 5000),
	IMBUED_BLACK_MASK_2_I(ItemID.BLACK_MASK_2_I, 5000),
	IMBUED_BLACK_MASK_3_I(ItemID.BLACK_MASK_3_I, 5000),
	IMBUED_BLACK_MASK_4_I(ItemID.BLACK_MASK_4_I, 5000),
	IMBUED_BLACK_MASK_5_I(ItemID.BLACK_MASK_5_I, 5000),
	IMBUED_BLACK_MASK_6_I(ItemID.BLACK_MASK_6_I, 5000),
	IMBUED_BLACK_MASK_7_I(ItemID.BLACK_MASK_7_I, 5000),
	IMBUED_BLACK_MASK_8_I(ItemID.BLACK_MASK_8_I, 5000),
	IMBUED_BLACK_MASK_9_I(ItemID.BLACK_MASK_9_I, 5000),
	IMBUED_BLACK_MASK_10_I(ItemID.BLACK_MASK_10_I, 5000),

	IMBUED_SLAYER_HELMET_I(ItemID.SLAYER_HELMET_I, 1000),
	IMBUED_BLACK_SLAYER_HELMET_I(ItemID.BLACK_SLAYER_HELMET_I, 1000),
	IMBUED_PURPLE_SLAYER_HELMET_I(ItemID.PURPLE_SLAYER_HELMET_I, 1000),
	IMBUED_RED_SLAYER_HELMET_I(ItemID.RED_SLAYER_HELMET_I, 1000),
	IMBUED_GREEN_SLAYER_HELMET_I(ItemID.GREEN_SLAYER_HELMET_I, 1000),
	IMBUED_TURQUOISE_SLAYER_HELMET_I(ItemID.TURQUOISE_SLAYER_HELMET_I, 1000),
	IMBUED_HYDRA_SLAYER_HELMET_I(ItemID.HYDRA_SLAYER_HELMET_I, 1000),

	IMBUED_ARCHERS_RING_I(ItemID.ARCHERS_RING_I, 2000),
	IMBUED_BERSERKER_RING_I(ItemID.BERSERKER_RING_I, 2000),
	IMBUED_SEERS_RING_I(ItemID.SEERS_RING_I, 2000),

	IMBUED_RING_OF_THE_GODS_I(ItemID.RING_OF_THE_GODS_I, 2000),
	IMBUED_TREASONOUS_RING_I(ItemID.TREASONOUS_RING_I, 2000),
	IMBUED_TYRANNICAL_RING_I(ItemID.TYRANNICAL_RING_I, 2000);

	private final int itemId;
	private final int offset;

	private static final Map<Integer, FixedPriceItem> FIXED_ITEMS;

	static
	{
		final ImmutableMap.Builder<Integer, FixedPriceItem> map = ImmutableMap.builder();
		for (final FixedPriceItem p : values())
		{
			map.put(p.itemId, p);
		}
		FIXED_ITEMS = map.build();
	}

	@Nullable
	static FixedPriceItem find(int itemId)
	{
		return FIXED_ITEMS.get(itemId);
	}
}
