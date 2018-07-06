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

import lombok.Data;
import java.util.List;

@Data
public class LootRecord
{
	private final int npcID;
	private final String npcName;
	private final int killCount;
	private List<DropEntry> drops;

	// Full Kill with Kill Count
	public LootRecord(int npcId, String npcName, int kc, List<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = npcName;
		this.killCount = kc;
		this.drops = drops;
	}

	// Full Kill without Kill Count
	public LootRecord(int npcId, String npcName, List<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = npcName;
		this.killCount = -1;
		this.drops = drops;
	}

	// Name Only Kill with Kill Count
	public LootRecord(String npcName, int kc, List<DropEntry> drops)
	{
		this.npcID = -1;
		this.npcName = npcName;
		this.killCount = kc;
		this.drops = drops;
	}

	// Name Only Kill without Kill Count
	public LootRecord(String npcName, List<DropEntry> drops)
	{
		this.npcID = -1;
		this.npcName = npcName;
		this.killCount = -1;
		this.drops = drops;
	}

	// Npc ID Only Kill with Kill Count
	public LootRecord(int npcId, int kc, List<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = null;
		this.killCount = kc;
		this.drops = drops;
	}

	// Npc ID Only Kill without Kill Count
	public LootRecord(int npcId, List<DropEntry> drops)
	{
		this.npcID = npcId;
		this.npcName = null;
		this.killCount = -1;
		this.drops = drops;
	}

	public void addDrop(DropEntry drop)
	{
		drops.add(drop);
	}

	@Override
	public String toString()
	{
		StringBuilder m = new StringBuilder();
		m.append("LootRecord{npcID=")
				.append(npcID)
				.append(", npcName=")
				.append(npcName)
				.append(", killCount=")
				.append(killCount)
				.append(", drops=");

		if (drops != null)
		{
			m.append("[");
			boolean addComma = false;
			for (DropEntry d : drops)
			{
				if (addComma)
				{
					m.append(", ");
				}

				m.append(d.toString());
				addComma = true;
			}
			m.append("]");
		}
		else
		{
			m.append("null");
		}
		m.append("}");

		return m.toString();
	}
}
