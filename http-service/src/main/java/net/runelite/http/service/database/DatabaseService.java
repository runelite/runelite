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

import net.runelite.http.api.database.ItemStack;
import net.runelite.http.api.database.LootRecord;
import net.runelite.http.service.account.AuthFilter;
import net.runelite.http.service.account.beans.SessionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService
{
	// MySql queries
	private static final String insertKillQuery = "INSERT INTO kills (accountId, username, eventType, eventId, killCount) VALUES (:accountId, :username, :eventType, :eventId, :killCount)";
	private static final String insertDropQuery = "INSERT INTO drops (killId, id, quantity) VALUES (LAST_INSERT_ID(), :id, :quantity)";
	private static final String getAllRecordsQuery = "SELECT * FROM kills JOIN drops ON kills.id = drops.killId " +
			"WHERE (kills.accountId = :accountId AND kills.username = :username)";
	private static final String getRecordsByEventIdQuery = getAllRecordsQuery + " AND (kills.eventID = :eventId)";
	private static final String getRecordsByEventTypeQuery = getAllRecordsQuery + " AND (kills.eventType = :eventType)";
	private static final String getRecordsByEventIdOrTypeQuery = getAllRecordsQuery + " AND (kills.eventID = :id OR kills.eventType = :id)";

	private final Sql2o sql2o;

	@Autowired
	public DatabaseService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;
	}

	/**
	 * Check header for RUNELITE-AUTH and validate the session via AuthFilter
	 * @param request HttpServletRequest to pass to AuthFilter
	 * @param response HttpServletResponse to pass to AuthFilter
	 * @return SessionEntry if validated, null if not
	 */
	public SessionEntry authCheck(HttpServletRequest request, HttpServletResponse response)
	{
		// User Authentication
		AuthFilter filter = new AuthFilter(sql2o);
		try
		{
			return filter.handle(request, response);
		}
		catch (IOException e)
		{
			return null;
		}
	}

	/**
	 * Retrieve all loot records from the MySql database
	 * @param username in-game username
	 * @param accountId runelite account id
	 */
	public List<LootRecord> getAllLootRecords(String username, int accountId)
	{
		try (Connection con = sql2o.open())
		{
			List<LootRecord> result = new ArrayList<>();

			List<LootRecordRow> records = con.createQuery(getAllRecordsQuery)
					.addParameter("accountId", accountId)
					.addParameter("username", username)
					.throwOnMappingFailure(false)
					.executeAndFetch(LootRecordRow.class);

			if (records != null)
			{
				result = LootRecordRow.consolidateRows(records);
			}

			return result;
		}
	}

	/**
	 * Retrieve LootRecords in MySql database with matching EventId or EventType
	 * @param username in-game username
	 * @param id eventId or eventType to match
	 * @param accountId runelite account id
	 */
	public List<LootRecord> getLootRecordsByEventIdOrType(String username, String id, int accountId)
	{
		try (Connection con = sql2o.open())
		{
			List<LootRecord> result = new ArrayList<>();

			List<LootRecordRow> records = con.createQuery(getRecordsByEventIdOrTypeQuery)
					.addParameter("accountId", accountId)
					.addParameter("username", username)
					.addParameter("id", id)
					.throwOnMappingFailure(false)
					.executeAndFetch(LootRecordRow.class);

			if (records != null)
			{
				result = LootRecordRow.consolidateRows(records);
			}

			return result;
		}
	}

	/**
	 * Retrieve LootRecords in MySql database with matching EventId
	 * @param username in-game username
	 * @param id eventId value to match
	 * @param accountId runelite account id
	 */
	public List<LootRecord> getLootRecordsByEventId(String username, int id, int accountId)
	{
		try (Connection con = sql2o.open())
		{
			List<LootRecord> result = new ArrayList<>();

			List<LootRecordRow> records = con.createQuery(getRecordsByEventIdQuery)
					.addParameter("accountId", accountId)
					.addParameter("username", username)
					.addParameter("eventId", id)
					.throwOnMappingFailure(false)
					.executeAndFetch(LootRecordRow.class);

			if (records != null)
			{
				result = LootRecordRow.consolidateRows(records);
			}

			return result;
		}
	}

	/**
	 * Retrieve LootRecords in MySql database with matching EventType
	 * @param username in-game username
	 * @param type eventType value to match
	 * @param accountId runelite account id
	 */
	public List<LootRecord> getLootRecordsByEventType(String username, String type, int accountId)
	{
		try (Connection con = sql2o.open())
		{
			List<LootRecord> result = new ArrayList<>();

			List<LootRecordRow> records = con.createQuery(getRecordsByEventTypeQuery)
					.addParameter("accountId", accountId)
					.addParameter("username", username)
					.addParameter("eventType", type)
					.throwOnMappingFailure(false)
					.executeAndFetch(LootRecordRow.class);

			if (records != null)
			{
				result = LootRecordRow.consolidateRows(records);
			}

			return result;
		}
	}

	/**
	 * Store LootRecord in MySql database
	 * @param record LootRecord to store
	 * @param username in-game username to tie data too
	 * @param accountId runelite account id to tie data too
	 */
	public void storeLootRecord(LootRecord record, String username, int accountId)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			// Kill Entry Query
			con.createQuery(insertKillQuery)
					.addParameter("accountId", accountId)
					.addParameter("username", username)
					.addParameter("eventType", record.getEventType())
					.addParameter("eventId", record.getEventId())
					.addParameter("killCount", record.getKillCount())
					.executeUpdate();

			// Append all queries for inserting drops
			for (ItemStack drop : record.getDrops())
			{
				con.createQuery(insertDropQuery)
					.addParameter("itemId", drop.getId())
					.addParameter("itemQuantity", drop.getQuantity())
					.executeUpdate();
			}
			con.commit();
		}
	}
}