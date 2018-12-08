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
package net.runelite.http.api.loottracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import lombok.Value;

/**
 * Since drops are stored on a separate table we must inner join the LootRecord with the
 * drop data. This class represents this data and is then consolidated by id to recreate
 * the original LootRecord
 */
@Value
public class LootRecordRow
{
	private final int id;
	private final String eventId;
	private final LootRecordType type;
	private final int itemId;
	private final int itemQuantity;

	/**
	 * Consolidates all rows from query and makes unique LootRecords
	 * Converts itemId and itemAmount into GameItem
	 *
	 * @param list of LootRecordRow (result from sq2lo query)
	 * @return Array of LootRecord's
	 */
	public static Collection<LootRecord> consolidateRows(Collection<LootRecordRow> list)
	{
		HashMap<Integer, LootRecord> lootMap = new HashMap<>();
		for (LootRecordRow r : list)
		{
			GameItem drop = new GameItem(r.itemId, r.itemQuantity);
			LootRecord record = lootMap.get(r.id);
			if (record == null)
			{
				List<GameItem> drops = new ArrayList<>();
				drops.add(drop);
				lootMap.put(r.id, new LootRecord(r.eventId, r.type, drops));
			}
			else
			{
				record.addDrop(drop);
			}
		}

		return lootMap.values();
	}
}
