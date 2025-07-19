/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemcharges;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.gameval.ItemID;

@AllArgsConstructor
@Getter
enum ItemWithConfig
{
	DODGY_NECKLACE(ItemID.DODGY_NECKLACE, ItemChargeConfig.KEY_DODGY_NECKLACE, ItemChargeType.DODGY_NECKLACE),
	BINDING_NECKLACE(ItemID.MAGIC_EMERALD_NECKLACE, ItemChargeConfig.KEY_BINDING_NECKLACE, ItemChargeType.BINDING_NECKLACE),
	EXPLORERS_RING_1(ItemID.LUMBRIDGE_RING_EASY, ItemChargeConfig.KEY_EXPLORERS_RING, ItemChargeType.EXPLORER_RING),
	EXPLORERS_RING_2(ItemID.LUMBRIDGE_RING_MEDIUM, ItemChargeConfig.KEY_EXPLORERS_RING, ItemChargeType.EXPLORER_RING),
	EXPLORERS_RING_3(ItemID.LUMBRIDGE_RING_HARD, ItemChargeConfig.KEY_EXPLORERS_RING, ItemChargeType.EXPLORER_RING),
	EXPLORERS_RING_4(ItemID.LUMBRIDGE_RING_ELITE, ItemChargeConfig.KEY_EXPLORERS_RING, ItemChargeType.EXPLORER_RING),
	RING_OF_FORGING(ItemID.RING_OF_FORGING, ItemChargeConfig.KEY_RING_OF_FORGING, ItemChargeType.RING_OF_FORGING),
	AMULET_OF_CHEMISTRY(ItemID.AMULET_OF_CHEMISTRY, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, ItemChargeType.AMULET_OF_CHEMISTRY),
	AMULET_OF_BOUNTY(ItemID.AMULET_OF_BOUNTY, ItemChargeConfig.KEY_AMULET_OF_BOUNTY, ItemChargeType.AMULET_OF_BOUNTY),
	BRACELET_OF_SLAUGHTER(ItemID.BRACELET_OF_SLAUGHTER, ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, ItemChargeType.BRACELET_OF_SLAUGHTER),
	EXPEDITIOUS_BRACELET(ItemID.EXPEDITIOUS_BRACELET, ItemChargeConfig.KEY_EXPEDITIOUS_BRACELET, ItemChargeType.EXPEDITIOUS_BRACELET),
	CHRONICLE(ItemID.CHRONICLE, ItemChargeConfig.KEY_CHRONICLE, ItemChargeType.TELEPORT),
	BLOOD_ESSENCE(ItemID.BLOOD_ESSENCE_ACTIVE, ItemChargeConfig.KEY_BLOOD_ESSENCE, ItemChargeType.BLOOD_ESSENCE),
	BRACELET_OF_CLAY(ItemID.JEWL_BRACELET_OF_CLAY, ItemChargeConfig.KEY_BRACELET_OF_CLAY, ItemChargeType.BRACELET_OF_CLAY);

	private final int itemId;
	private final String configKey;
	private final ItemChargeType type;

	private static final Map<Integer, ItemWithConfig> ID_MAP;

	static
	{
		ImmutableMap.Builder<Integer, ItemWithConfig> builder = new ImmutableMap.Builder<>();

		for (ItemWithConfig item : values())
		{
			builder.put(item.getItemId(), item);
		}

		ID_MAP = builder.build();
	}

	@Nullable
	static ItemWithConfig findItem(int itemId)
	{
		return ID_MAP.get(itemId);
	}
}
