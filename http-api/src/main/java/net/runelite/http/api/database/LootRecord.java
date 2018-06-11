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
package net.runelite.http.api.database;

import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import net.runelite.http.api.RuneLiteAPI;

import java.util.ArrayList;
import java.util.List;

public class LootRecord
{
	@Getter
	private final int npcID;
	@Getter
	private final String npcName;
	@Getter
	private final int killCount;
	@Getter
	private ArrayList<DropEntry> drops;
	// Used when pulling data from API, stores JSON string of drops until parsed via parseDrops()
	private String drops2 = null;

	public LootRecord(int npcId, String npcName, int kc, ArrayList<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = npcName;
		this.killCount = kc;
		this.drops = drops;
	}

	public LootRecord(int npcId, String npcName, ArrayList<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = npcName;
		this.killCount = -1;
		this.drops = drops;
	}

	public LootRecord(String npcName, int kc, ArrayList<DropEntry> drops)
	{
		this.npcID = -1;
		this.npcName = npcName;
		this.killCount = kc;
		this.drops = drops;
	}

	public LootRecord(String npcName, ArrayList<DropEntry> drops)
	{
		this.npcID = -1;
		this.npcName = npcName;
		this.killCount = -1;
		this.drops = drops;
	}

	public LootRecord(int npcId, int kc, ArrayList<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = null;
		this.killCount = kc;
		this.drops = drops;
	}

	public LootRecord(int npcId, ArrayList<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = null;
		this.killCount = -1;
		this.drops = drops;
	}

	// Parse drops from JSON string (requesting data from API);
	public void parseDrops()
	{
		if (this.drops2 != null)
		{
			this.drops = RuneLiteAPI.GSON.fromJson(drops2, new TypeToken<List<DropEntry>>()
			{
			}.getType());
			this.drops2 = null;
		}
	}

	@Override
	public String toString()
	{
		StringBuilder m = new StringBuilder();
		m.append("LootRecord{npcID=").append(npcID).append(", npcName=").append(npcName).append(", killCount=").append(killCount).append(", drops=[");
		if (drops != null)
		{
			boolean first = true;
			for (DropEntry d : drops)
			{
				if (!first)
					m.append(", ");

				m.append(d.toString());
				first = false;
			}
			m.append("]");
		}
		else
		{
			m.append("null]");
		}
		m.append("}");

		return m.toString();
	}
}
