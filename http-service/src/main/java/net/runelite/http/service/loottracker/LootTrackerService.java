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
import net.runelite.http.api.loottracker.LootAggregate;
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
	private static final String CREATE_KILLS = "CREATE TABLE IF NOT EXISTS `loottracker_kills` (\n" +
		"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
		"  `first_time` timestamp NOT NULL DEFAULT current_timestamp(),\n" +
		"  `last_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),\n" +
		"  `accountId` int(11) NOT NULL,\n" +
		"  `type` enum('NPC','PLAYER','EVENT','PICKPOCKET','UNKNOWN') NOT NULL,\n" +
		"  `eventId` varchar(255) NOT NULL,\n" +
		"  `amount` int(11) NOT NULL,\n" +
		"  PRIMARY KEY (`id`),\n" +
		"  FOREIGN KEY (accountId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
		"  INDEX idx_acc_lasttime (`accountId` ,`last_time`),\n" +
		"  UNIQUE INDEX idx_acc_type_event (`accountId`, `type`, `eventId`),\n" +
		"  INDEX idx_time (last_time)" +
		") ENGINE=InnoDB;";

	private static final String CREATE_DROPS = "CREATE TABLE IF NOT EXISTS `loottracker_drops` (\n" +
		"  `killId` int(11),\n" +
		"  `itemId` int(11) NOT NULL,\n" +
		"  `itemQuantity` int(11) NOT NULL,\n" +
		"  UNIQUE INDEX idx_kill_item (`killId`, `itemId`),\n" +
		"  FOREIGN KEY (killId) REFERENCES loottracker_kills(id) ON DELETE CASCADE\n" +
		") ENGINE=InnoDB;\n";

	// Queries for inserting kills
	private static final String INSERT_KILL_QUERY = "INSERT INTO loottracker_kills (accountId, type, eventId, amount) VALUES (:accountId, :type, :eventId, 1) ON DUPLICATE KEY UPDATE amount = amount + 1";
	private static final String INSERT_DROP_QUERY = "INSERT INTO loottracker_drops (killId, itemId, itemQuantity) VALUES (:killId, :itemId, :itemQuantity) ON DUPLICATE KEY UPDATE itemQuantity = itemQuantity + :itemQuantity";

	private static final String SELECT_LOOT_QUERY = "SELECT killId,first_time,last_time,type,eventId,amount,itemId,itemQuantity FROM loottracker_kills JOIN loottracker_drops ON loottracker_drops.killId = loottracker_kills.id WHERE accountId = :accountId ORDER BY last_time DESC LIMIT :limit OFFSET :offset";

	private static final String DELETE_LOOT_ACCOUNT = "DELETE FROM loottracker_kills WHERE accountId = :accountId";
	private static final String DELETE_LOOT_ACCOUNT_EVENTID = "DELETE FROM loottracker_kills WHERE accountId = :accountId AND eventId = :eventId";

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
	 * @param records   LootRecords to store
	 * @param accountId runelite account id to tie data too
	 */
	public void store(Collection<LootRecord> records, int accountId)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			Query killQuery = con.createQuery(INSERT_KILL_QUERY, true);
			Query insertDrop = con.createQuery(INSERT_DROP_QUERY);

			for (LootRecord record : records)
			{
				killQuery
					.addParameter("accountId", accountId)
					.addParameter("type", record.getType())
					.addParameter("eventId", record.getEventId())
					.executeUpdate();
				Object[] keys = con.getKeys();

				for (GameItem drop : record.getDrops())
				{
					insertDrop
						.addParameter("killId", keys[0])
						.addParameter("itemId", drop.getId())
						.addParameter("itemQuantity", drop.getQty())
						.addToBatch();
				}

				insertDrop.executeBatch();
			}

			con.commit(false);
		}
	}

	public Collection<LootAggregate> get(int accountId, int limit, int offset)
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
		List<LootAggregate> lootRecords = new ArrayList<>();
		List<GameItem> gameItems = new ArrayList<>();

		for (LootResult lootResult : lootResults)
		{
			if (current == null || current.getKillId() != lootResult.getKillId())
			{
				if (!gameItems.isEmpty())
				{
					LootAggregate lootRecord = new LootAggregate(current.getEventId(), current.getType(), gameItems, current.getFirst_time(), current.getLast_time(), current.getAmount());
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
			LootAggregate lootRecord = new LootAggregate(current.getEventId(), current.getType(), gameItems, current.getFirst_time(), current.getLast_time(), current.getAmount());
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

	@Scheduled(fixedDelay = 60 * 60 * 1000)
	public void expire()
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from loottracker_kills where last_time < current_timestamp() - interval 30 day")
				.executeUpdate();
		}
	}
}
