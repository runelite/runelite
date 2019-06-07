/*
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
package net.runelite.client.plugins.stonedloottracker.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class LootRecordCustom
{
	private final int id;
	private final String name;
	private final int level;
	private final int killCount;
	final Collection<LootTrackerItemEntry> drops;

	public LootRecordCustom(int id, String name, int level, int kc, Collection<LootTrackerItemEntry> drops)
	{
		this.id = id;
		this.name = name;
		this.level = level;
		this.killCount = kc;
		this.drops = (drops == null ? new ArrayList<>() : drops);
	}

	/**
	 * Add the requested ItemStack to this LootRecord
	 * @param drop ItemStack to add
	 */
	public void addDropEntry(LootTrackerItemEntry drop)
	{
		drops.add(drop);
	}

	public static Map<Integer, LootTrackerItemEntry> consolidateLootTrackerItemEntries(Collection<LootRecordCustom> records)
	{
		// Store LootTrackerItemEntry by ItemID
		Map<Integer, LootTrackerItemEntry> itemMap = new HashMap<>();
		for (LootRecordCustom r : records)
		{
			for (LootTrackerItemEntry e : r.getDrops())
			{
				int old = 0;
				if (itemMap.containsKey(e.getId()))
				{
					old = itemMap.get(e.getId()).getQuantity();
					itemMap.remove(e.getId());
				}
				itemMap.put(e.getId(), new LootTrackerItemEntry(e.getName(), e.getId(), e.getQuantity() + old, e.getPrice(), e.getHaPrice(), e.isStackable()));
			}
		}

		return itemMap;
	}

	@Override
	public String toString()
	{
		StringBuilder m = new StringBuilder();
		m.append("LootRecord{id=")
			.append(id)
			.append(",name=")
			.append(name)
			.append(",level=")
			.append(level)
			.append(",killCount=")
			.append(killCount)
			.append(",drops=[");

		boolean addComma = false;
		for (LootTrackerItemEntry d : drops)
		{
			if (addComma)
			{
				m.append(",");
			}

			m.append(d.toString());
			addComma = true;
		}
		m.append("]}");

		return m.toString();
	}
}