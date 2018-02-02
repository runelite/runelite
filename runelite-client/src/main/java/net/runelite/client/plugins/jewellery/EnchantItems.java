/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.jewellery;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static net.runelite.api.ItemID.*;

public enum  EnchantItems
{
	LEVEL_ONE("Lvl-1", SAPPHIRE_RING, SAPPHIRE_AMULET, SAPPHIRE_NECKLACE, SAPPHIRE_BRACELET, OPAL_RING, OPAL_AMULET, OPAL_NECKLACE, OPAL_BRACELET),
	LEVEL_TWO("Lvl-2", EMERALD_RING, EMERALD_AMULET, EMERALD_NECKLACE, EMERALD_BRACELET, JADE_RING, JADE_AMULET, JADE_NECKLACE, JADE_BRACELET),
	LEVEL_THREE("Lvl-3", RUBY_RING, RUBY_AMULET, RUBY_NECKLACE, RUBY_BRACELET, TOPAZ_RING, TOPAZ_AMULET, TOPAZ_NECKLACE, TOPAZ_BRACELET),
	LEVEL_FOUR("Lvl-4", DIAMOND_RING, DIAMOND_AMULET, DIAMOND_NECKLACE, DIAMOND_BRACELET),
	LEVEL_FIVE("Lvl-5", DRAGONSTONE_RING, DRAGONSTONE_AMULET, DRAGONSTONE_BRACELET, DRAGON_NECKLACE ),
	LEVEL_SIX("Lvl-6", ONYX_RING, ONYX_AMULET, ONYX_BRACELET, ONYX_NECKLACE),
	LEVEL_SEVEN("Lvl-7", ZENYTE_RING, ZENYTE_AMULET, ZENYTE_NECKLACE, ZENYTE_BRACELET);

	private static final Map<Integer, EnchantItems> ENCHANT_LVL_IDS = new HashMap<>();

	@Getter
	private String type;

	@Getter
	private int[] ids;

	static
	{
		EnchantItems[] items = values();

		for (EnchantItems item : items)
		{
			for (Integer itemID : item.getIds())
			{
				ENCHANT_LVL_IDS.put(itemID, item);
			}
		}
	}

	EnchantItems(String type, int... ids)
	{
		this.type = type;
		this.ids = ids;
	}

	public static EnchantItems getEnchantLevelIds(int id)
	{
		return ENCHANT_LVL_IDS.get(id);
	}
}
