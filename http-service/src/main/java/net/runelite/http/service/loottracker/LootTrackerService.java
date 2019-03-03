/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.loottracker.LootRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Service
public class LootTrackerService
{
	// Table for storing individual LootRecords
	private static final String CREATE_KILLS = "CREATE TABLE IF NOT EXISTS `kills` (\n"
		+ "  `id` INT AUTO_INCREMENT UNIQUE,\n"
		+ "  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),\n"
		+ "  `accountId` INT NOT NULL,\n"
		+ "  `type` enum('NPC', 'PLAYER', 'EVENT', 'UNKNOWN') NOT NULL,\n"
		+ "  `eventId` VARCHAR(255) NOT NULL,\n"
		+ "  PRIMARY KEY (id),\n"
		+ "  FOREIGN KEY (accountId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,\n"
		+ "  INDEX idx_acc (accountId, time),"
		+ "  INDEX idx_time (time)"
		+ ") ENGINE=InnoDB";

	// Table for storing Items received as loot for individual LootRecords
	private static final String CREATE_DROPS = "CREATE TABLE IF NOT EXISTS `drops` (\n"
		+ "  `killId` INT NOT NULL,\n"
		+ "  `itemId` INT NOT NULL,\n"
		+ "  `itemQuantity` INT NOT NULL,\n"
		+ "  FOREIGN KEY (killId) REFERENCES kills(id) ON DELETE CASCADE\n"
		+ ") ENGINE=InnoDB";

	// Queries for inserting kills
	private static final String INSERT_KILL_QUERY = "INSERT INTO kills (accountId, type, eventId) VALUES (:accountId, :type, :eventId)";
	private static final String INSERT_DROP_QUERY = "INSERT INTO drops (killId, itemId, itemQuantity) VALUES (LAST_INSERT_ID(), :itemId, :itemQuantity)";

	private static final String SELECT_LOOT_QUERY = "SELECT killId,time,type,eventId,itemId,itemQuantity FROM kills JOIN drops ON drops.killId = kills.id WHERE accountId = :accountId ORDER BY TIME DESC LIMIT :limit OFFSET :offset";

	private static final String DELETE_LOOT_ACCOUNT = "DELETE FROM kills WHERE accountId = :accountId";
	private static final String DELETE_LOOT_ACCOUNT_EVENTID = "DELETE FROM kills WHERE accountId = :accountId AND eventId = :eventId";

	private final Sql2o sql2o;

	@Autowired
	public LootTrackerService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;

		// Ensure necessary tables exist
		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_KILLS).executeUpdate();
			con.createQuery(CREATE_DROPS).executeUpdate();
		}
	}

	/**
	 * Store LootRecord
	 *
	 * @param record    LootRecord to store
	 * @param accountId runelite account id to tie data too
	 */
	public void store(LootRecord record, int accountId)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			// Kill Entry Query
			con.createQuery(INSERT_KILL_QUERY, true)
				.addParameter("accountId", accountId)
				.addParameter("type", record.getType())
				.addParameter("eventId", record.getEventId())
				.executeUpdate();

			Query insertDrop = con.createQuery(INSERT_DROP_QUERY);

			// Append all queries for inserting drops
			for (GameItem drop : record.getDrops())
			{
				insertDrop
					.addParameter("itemId", drop.getId())
					.addParameter("itemQuantity", drop.getQty())
					.addToBatch();
			}

			insertDrop.executeBatch();
			con.commit(false);
		}
	}

	public Collection<LootRecord> get(int accountId, int limit, int offset)
	{
		List<LootResult> lootResults;

		try (Connection con = sql2o.open())
		{
			lootResults = con.createQuery(SELECT_LOOT_QUERY)
				.addParameter("accountId", accountId)
				.addParameter("limit", limit)
				.addParameter("offset", offset)
				.executeAndFetch(LootResult.class);
		}

		LootResult current = null;
		List<LootRecord> lootRecords = new ArrayList<>();
		List<GameItem> gameItems = new ArrayList<>();

		for (LootResult lootResult : lootResults)
		{
			if (current == null || current.getKillId() != lootResult.getKillId())
			{
				if (!gameItems.isEmpty())
				{
					LootRecord lootRecord = new LootRecord(current.getEventId(), current.getType(), gameItems, current.getTime());
					lootRecords.add(lootRecord);

					gameItems = new ArrayList<>();
				}

				current = lootResult;
			}

			GameItem gameItem = new GameItem(lootResult.getItemId(), lootResult.getItemQuantity());
			gameItems.add(gameItem);
		}

		if (!gameItems.isEmpty())
		{
			LootRecord lootRecord = new LootRecord(current.getEventId(), current.getType(), gameItems, current.getTime());
			lootRecords.add(lootRecord);
		}

		return lootRecords;
	}

	public void delete(int accountId, String eventId)
	{
		try (Connection con = sql2o.open())
		{
			if (eventId == null)
			{
				con.createQuery(DELETE_LOOT_ACCOUNT)
					.addParameter("accountId", accountId)
					.executeUpdate();
			}
			else
			{
				con.createQuery(DELETE_LOOT_ACCOUNT_EVENTID)
					.addParameter("accountId", accountId)
					.addParameter("eventId", eventId)
					.executeUpdate();
			}
		}
	}

	@Scheduled(fixedDelay = 15 * 60 * 1000)
	public void expire()
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from kills where time < current_timestamp() - interval 30 day")
				.executeUpdate();
		}
	}
}
