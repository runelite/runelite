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
package net.runelite.http.service.loottracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.loottracker.LootRecord;
import net.runelite.http.api.loottracker.LootRecordRow;
import net.runelite.http.api.loottracker.LootRecordType;
import net.runelite.http.service.account.AuthFilter;
import net.runelite.http.service.account.beans.SessionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class LootDatabaseService
{
	// MySql queries
	private static final String INSERT_KILL_QUERY = "INSERT INTO kills (accountId, username, type, eventId) VALUES (:accountId, :username, :type, :eventId)";
	private static final String INSERT_DROP_QUERY = "INSERT INTO drops (killId, id, quantity) VALUES (LAST_INSERT_ID(), :id, :quantity)";
	private static final String GET_ALL_RECORD_QUERY = "SELECT * FROM kills JOIN drops ON kills.id = drops.killId " +
		"WHERE (kills.accountId = :accountId AND kills.username = :username)";
	private static final String GET_RECORDS_BY_EVENT_ID_QUERY = GET_ALL_RECORD_QUERY + " AND (kills.eventID = :eventId)";
	private static final String GET_RECORDS_BY_EVENT_TYPE_QUERY = GET_ALL_RECORD_QUERY + " AND (kills.type = :type)";

	private final Sql2o sql2o;

	@Autowired
	public LootDatabaseService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;
	}

	/**
	 * Check header for RUNELITE-AUTH and validate the session via AuthFilter
	 * @param request HttpServletRequest to pass to AuthFilter
	 * @param response HttpServletResponse to pass to AuthFilter
	 * @return SessionEntry if validated, null if not
	 */
	SessionEntry authCheck(HttpServletRequest request, HttpServletResponse response)
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
	Collection<LootRecord> getAllLootRecords(String username, int accountId)
	{
		try (Connection con = sql2o.open())
		{
			Collection<LootRecord> result = new ArrayList<>();
			Collection<LootRecordRow> records = con.createQuery(GET_ALL_RECORD_QUERY)
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
	 * @param eventId event identifier (npc id, or activity name)
	 * @param accountId runelite account id
	 */
	Collection<LootRecord> getLootRecordsByEvent(String username, String eventId, int accountId)
	{
		try (Connection con = sql2o.open())
		{
			Collection<LootRecord> result = new ArrayList<>();
			Collection<LootRecordRow> records = con.createQuery(GET_RECORDS_BY_EVENT_ID_QUERY)
				.addParameter("accountId", accountId)
				.addParameter("username", username)
				.addParameter("eventId", eventId)
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
	 * @param type Type of LootRecords to return
	 * @param accountId runelite account id
	 */
	Collection<LootRecord> getLootRecordsByType(String username, LootRecordType type, int accountId)
	{
		try (Connection con = sql2o.open())
		{
			Collection<LootRecord> result = new ArrayList<>();
			Collection<LootRecordRow> records = con.createQuery(GET_RECORDS_BY_EVENT_TYPE_QUERY)
				.addParameter("accountId", accountId)
				.addParameter("username", username)
				.addParameter("type", type)
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
	void storeLootRecord(LootRecord record, String username, int accountId)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			// Kill Entry Query
			con.createQuery(INSERT_KILL_QUERY)
				.addParameter("accountId", accountId)
				.addParameter("username", username)
				.addParameter("type", record.getType())
				.addParameter("eventId", record.getEventId())
				.executeUpdate();
			// Append all queries for inserting drops
			for (GameItem drop : record.getDrops())
			{
				con.createQuery(INSERT_DROP_QUERY)
					.addParameter("itemId", drop.getId())
					.addParameter("itemQuantity", drop.getQty())
					.executeUpdate();
			}
			con.commit();
		}
	}
}