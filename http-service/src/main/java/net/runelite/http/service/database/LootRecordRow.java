/*
 * Copyright (c) 2018, TheStonedTurtle <http://github.com/TheStonedTurtle>
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
package net.runelite.http.service.database;

import lombok.Getter;
import net.runelite.http.api.database.DropEntry;
import net.runelite.http.api.database.LootRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class LootRecordRow
{
	private final int id;
	private final int npcID;
	private final String npcName;
	private final int killCount;
	private final int itemId;
	private final int itemAmount;

	public LootRecordRow(int id, int npcId, String npcName, int kc, int itemId, int itemAmount)
	{
		this.id = id;
		this.npcID = npcId;
		this.npcName = npcName;
		this.killCount = kc;
		this.itemId = itemId;
		this.itemAmount = itemAmount;
	}

	/**
	 * Consolidates all rows from query and makes unique LootRecords
	 * Converts itemId and itemAmount into DropEntry
	 *
	 * @param list of LootRecordRow (result from sq2lo query)
	 * @return Array of LootRecord's
	 */
	static List<LootRecord> consildateRows(List<LootRecordRow> list)
	{
		HashMap<Integer, LootRecord> lootMap = new HashMap<>();
		for (LootRecordRow r : list)
		{
			DropEntry drop = new DropEntry(r.itemId, r.itemAmount);
			LootRecord record = lootMap.get(r.id);
			if (record == null)
			{
				List<DropEntry> drops = new ArrayList<>();
				drops.add(drop);
				lootMap.put(r.id, new LootRecord(r.npcID, r.npcName, r.killCount, drops));
			}
			else
			{
				record.addDrop(drop);
			}
		}

		List<LootRecord> result = new ArrayList<>();
		for (Map.Entry<Integer, LootRecord> e : lootMap.entrySet())
		{
			result.add(e.getValue());
		}

		return result;
	}
}