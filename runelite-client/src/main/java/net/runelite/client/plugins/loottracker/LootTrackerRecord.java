/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.loottracker;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import net.runelite.http.api.loottracker.LootRecordType;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"title", "type"})
class LootTrackerRecord
{
	@NonNull
	private final String title;
	private final String subTitle;
	private final LootRecordType type;
	private LootTrackerItem[] items;
	private int kills;

	/**
	 * Checks if this record matches specified id
	 *
	 * @param id other record id
	 * @return true if match is made
	 */
	boolean matches(final String id, LootRecordType type)
	{
		if (id == null)
		{
			return true;
		}

		return title.equals(id) && this.type == type;
	}

	void merge(LootTrackerRecord record)
	{
		assert title.equals(record.title);
		assert type == record.type;

		outer:
		for (LootTrackerItem item : record.items)
		{
			for (int idx = 0; idx < items.length; ++idx)
			{
				LootTrackerItem r = items[idx];
				if (r.getId() == item.getId())
				{
					int qty = r.getQuantity() + item.getQuantity();
					if (qty < 0)
					{
						qty = Integer.MAX_VALUE;
					}
					items[idx] = new LootTrackerItem(
						r.getId(),
						r.getName(),
						qty,
						r.getGePrice(),
						r.getHaPrice(),
						r.isIgnored()
					);
					continue outer;
				}
			}

			items = Arrays.copyOf(items, items.length + 1);
			items[items.length - 1] = item;
		}

		kills += record.kills;
	}
}