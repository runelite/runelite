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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.loottracker.LootRecord;
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
	private static final String INSERT_KILL_QUERY = "INSERT INTO kills (accountId, type, eventId) VALUES (:accountId, :type, :eventId)";
	private static final String INSERT_DROP_QUERY = "INSERT INTO drops (killId, itemId, itemQuantity) VALUES (LAST_INSERT_ID(), :itemId, :itemQuantity)";

	private final Sql2o sql2o;

	private final AuthFilter auth;

	@Autowired
	public LootDatabaseService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o,
		AuthFilter auth
	)
	{
		this.sql2o = sql2o;
		this.auth = auth;
	}

	/**
	 * Store LootRecord in MySql database
	 * @param record LootRecord to store
	 * @param accountId runelite account id to tie data too
	 */
	void storeLootRecord(LootRecord record, int accountId)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			// Kill Entry Query
			con.createQuery(INSERT_KILL_QUERY)
				.addParameter("accountId", accountId)
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

	SessionEntry handleAuth(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		return auth.handle(request, response);
	}
}
