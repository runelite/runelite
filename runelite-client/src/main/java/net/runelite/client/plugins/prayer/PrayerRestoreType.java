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
package net.runelite.client.plugins.prayer;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.runelite.api.ItemID;

enum PrayerRestoreType
{
	RESTOREPOT(ItemID.SUPER_RESTORE4, ItemID.SUPER_RESTORE3, ItemID.SUPER_RESTORE2, ItemID.SUPER_RESTORE1,
		ItemID.BLIGHTED_SUPER_RESTORE4, ItemID.BLIGHTED_SUPER_RESTORE3, ItemID.BLIGHTED_SUPER_RESTORE2,
		ItemID.BLIGHTED_SUPER_RESTORE1),
	PRAYERPOT(ItemID.PRAYER_POTION4, ItemID.PRAYER_POTION3, ItemID.PRAYER_POTION2, ItemID.PRAYER_POTION1),
	SANFEWPOT(ItemID.SANFEW_SERUM4, ItemID.SANFEW_SERUM3, ItemID.SANFEW_SERUM2, ItemID.SANFEW_SERUM1),
	HOLYWRENCH(ItemID.PRAYER_CAPE, ItemID.PRAYER_CAPET, ItemID.MAX_CAPE,
		ItemID.MAX_CAPE_13342, ItemID.HOLY_WRENCH, ItemID.RING_OF_THE_GODS_I);

	private static final Map<Integer, PrayerRestoreType> prayerRestores;

	private final int[] items;

	PrayerRestoreType(int... items)
	{
		this.items = items;
	}

	static
	{
		ImmutableMap.Builder<Integer, PrayerRestoreType> builder = new ImmutableMap.Builder<>();
		for (PrayerRestoreType prayerRestoreType : values())
		{
			for (int itemId : prayerRestoreType.items)
			{
				builder.put(itemId, prayerRestoreType);
			}
		}
		prayerRestores = builder.build();
	}

	static PrayerRestoreType getType(final int itemId)
	{
		return prayerRestores.get(itemId);
	}
}
