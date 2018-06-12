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

import net.runelite.http.api.database.DatabaseEndpoint;
import net.runelite.http.api.database.DropEntry;
import net.runelite.http.api.database.LootRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService
{
	private final Sql2o sql2o;

	@Autowired
	public DatabaseService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o
	)
	{
		this.sql2o = sql2o;
	}

	public ArrayList<LootRecord> lookupBoss(DatabaseEndpoint endpoint, String username, int boss) throws IOException
	{
		return lookupBoss(endpoint, username, String.valueOf(boss));
	}

	public ArrayList<LootRecord> lookupBoss(DatabaseEndpoint endpoint, String username, String boss) throws IOException
	{
		String queryText = "SELECT kills.*, CONCAT(\"[\", group_concat( CONCAT(\"{'itemId':\", drops.itemId,\",'itemAmount':\",drops.itemAmount,\"}\")), \"]\") as drops2 " +
				"FROM kills JOIN " +
				"drops " +
				"on drops.killId = kills.killId " +
				"WHERE (username = :username AND npcID = :id) OR (username = :username AND npcName = :id) " +
				"group by kills.killId";

		try (Connection con = sql2o.open())
		{
			ArrayList<LootRecord> result = new ArrayList<>();
			List<LootRecord> records = con.createQuery(queryText)
					.addParameter("username", username)
					.addParameter("id", boss)
					.throwOnMappingFailure(false)		// Ignores entry_id mapping error
					.executeAndFetch(LootRecord.class);

			if (records != null)
			{
				result = new ArrayList<>(records);
				for (LootRecord r : result)
				{
					r.parseDrops();
				}
			}

			return result;
		}
	}

	// Insert loot record into mysql database
	public void storeLootRecord(LootRecord record, String username)
	{
		String killQuery = "INSERT INTO kills (username, npcName, npcID, killCount) VALUES(:username, :npcName, :npcID, :killCount)";
		String dropQuery = "INSERT INTO drops (killId, itemId, itemAmount) VALUES(LAST_INSERT_ID(), :itemId, :itemAmount)";
		try (Connection con = sql2o.beginTransaction())
		{
			// Kill Entry Query
			con.createQuery(killQuery)
					.addParameter("username", username)
					.addParameter("npcName", record.getNpcName())
					.addParameter("npcID", record.getNpcID())
					.addParameter("killCount", record.getKillCount())
					.executeUpdate();

			// Append all queries for inserting drops
			for (DropEntry drop : record.getDrops())
			{
				con.createQuery(dropQuery)
					.addParameter("itemId", drop.getItemId())
					.addParameter("itemAmount", drop.getItemAmount())
					.executeUpdate();
			}
			con.commit();
		}
	}
}