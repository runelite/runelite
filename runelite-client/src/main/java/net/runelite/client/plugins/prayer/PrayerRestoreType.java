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

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ItemID;

enum PrayerRestoreType
{
	RESTOREPOT(ItemID.SUPER_RESTORE4, ItemID.SUPER_RESTORE3, ItemID.SUPER_RESTORE2, ItemID.SUPER_RESTORE1),
	PRAYERPOT(ItemID.PRAYER_POTION4, ItemID.PRAYER_POTION3, ItemID.PRAYER_POTION2, ItemID.PRAYER_POTION1),
	HOLYWRENCH(ItemID.PRAYER_CAPE, ItemID.PRAYER_CAPET, ItemID.PRAYER_CAPE_10643, ItemID.MAX_CAPE, ItemID.MAX_CAPE_13282,
		ItemID.MAX_CAPE_13342, ItemID.HOLY_WRENCH, ItemID.RING_OF_THE_GODS_I);

	private static final Map<Integer, PrayerRestoreType> prayerRestores = new HashMap<>();

	private final int[] items;

	PrayerRestoreType(int... items)
	{
		this.items = items;
	}

	static
	{
		for (PrayerRestoreType prayerRestoreType : values())
		{
			for (int itemId : prayerRestoreType.items)
			{
				prayerRestores.put(itemId, prayerRestoreType);
			}
		}
	}

	static PrayerRestoreType getType(final int itemId)
	{
		return prayerRestores.get(itemId);
	}
}
