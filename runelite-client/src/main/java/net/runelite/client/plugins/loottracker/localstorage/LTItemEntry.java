/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.loottracker.localstorage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LTItemEntry
{
	private final String name;
	private final int id;
	private int quantity;
	private long price;

	public long getTotal()
	{
		return this.quantity * this.price;
	}

	public static Map<Integer, LTItemEntry> consolidateItemEntires(final Collection<LTItemEntry> drops)
	{
		// Store LootTrackerItemEntry by ItemID
		final Map<Integer, LTItemEntry> itemMap = new HashMap<>();
		for (final LTItemEntry e : drops)
		{
			final LTItemEntry oldEntry = itemMap.get(e.getId());
			if (oldEntry != null)
			{
				// Use the most recent price
				oldEntry.setPrice(e.getPrice());
				oldEntry.setQuantity(oldEntry.getQuantity() + e.getQuantity());
			}
			else
			{
				// Create a new instance for consolidated records
				itemMap.put(e.getId(), new LTItemEntry(e.getName(), e.getId(), e.getQuantity(), e.getPrice()));
			}
		}

		return itemMap;
	}
}