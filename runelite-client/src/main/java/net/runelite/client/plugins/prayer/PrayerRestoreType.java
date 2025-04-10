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
import net.runelite.api.gameval.ItemID;

enum PrayerRestoreType
{
	RESTOREPOT(ItemID._4DOSE2RESTORE, ItemID._3DOSE2RESTORE, ItemID._2DOSE2RESTORE, ItemID._1DOSE2RESTORE,
		ItemID.BLIGHTED_4DOSE2RESTORE, ItemID.BLIGHTED_3DOSE2RESTORE, ItemID.BLIGHTED_2DOSE2RESTORE,
		ItemID.BLIGHTED_1DOSE2RESTORE),
	PRAYERPOT(ItemID._4DOSEPRAYERRESTORE, ItemID._3DOSEPRAYERRESTORE, ItemID._2DOSEPRAYERRESTORE, ItemID._1DOSEPRAYERRESTORE),
	SANFEWPOT(ItemID.SANFEW_SALVE_4_DOSE, ItemID.SANFEW_SALVE_3_DOSE, ItemID.SANFEW_SALVE_2_DOSE, ItemID.SANFEW_SALVE_1_DOSE),
	HOLYWRENCH(ItemID.SKILLCAPE_PRAYER, ItemID.SKILLCAPE_PRAYER_TRIMMED, ItemID.SKILLCAPE_MAX,
		ItemID.SKILLCAPE_MAX_WORN, ItemID.DEAL_WRENCH_BLESSED, ItemID.NZONE_ROTG);

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
