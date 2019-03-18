/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, Trevor <https://github.com/15987632>
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
package net.runelite.http.service.raidtracker;

import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.raidtracker.RaidRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Service
public class RaidTrackerService
{
	// Table for storing individual LootRecords
	private static final String CREATE_KILLS = "CREATE TABLE IF NOT EXISTS `raids` (\n"
		+ "  `id` INT AUTO_INCREMENT UNIQUE,\n"
		+ "  `accountId` INT NOT NULL,\n"
		+ "  `username` VARCHAR(255) NOT NULL,\n"
		+ "  `kc` INT NOT NULL,\n"
		+ "  `cm` TINYINT NOT NULL,\n"
		+ "  `upperTime` INT NOT NULL,\n"
		+ "  `middleTime` INT NOT NULL,\n"
		+ "  `lowerTime` INT NOT NULL,\n"
		+ "  `raidTime` INT NOT NULL,\n"
		+ "  `points` INT NOT NULL,\n"
		+ "  `teamPoints` INT NOT NULL,\n"
		+ "  `teamSize` INT NOT NULL,\n"
		+ "  `rotation` VARCHAR(255) NOT NULL,\n"
		+ "  `prep` TINYINT NOT NULL,\n"
		+ "  PRIMARY KEY (id),\n"	//TODO: these definitely need to be changed
		+ "  FOREIGN KEY (accountId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,\n"
		+ "  INDEX idx_acc (accountId, time),"
		+ "  INDEX idx_time (time)"
		+ ") ENGINE=InnoDB";

	// Table for storing Items received as loot for individual LootRecords
	private static final String CREATE_DROPS = "CREATE TABLE IF NOT EXISTS `raidDrops` (\n"
		+ "  `raidId` INT NOT NULL,\n"
		+ "  `itemId` INT NOT NULL,\n"
		+ "  `itemQuantity` INT NOT NULL,\n"
		+ "  FOREIGN KEY (raidId) REFERENCES raids(id) ON DELETE CASCADE\n"	//TODO: should be looked at cause idk what these are
		+ ") ENGINE=InnoDB";

	// Queries for inserting raids
	private static final String INSERT_RAID_QUERY = "INSERT INTO raids (accountId, username, kc, cm, upperTime, middleTime, lowerTime, raidTime, points, teamPoints, teamSize, rotation, prep) "
		+ "VALUES (:accountId, :username, :kc, :cm, :upperTime, :middleTime, :lowerTime, :raidTime, :points, :teamPoints, :teamSize, :rotation, :prep)";
	private static final String INSERT_DROP_QUERY = "INSERT INTO raidDrops (raidId, itemId, itemQuantity) VALUES (LAST_INSERT_ID(), :itemId, :itemQuantity)";

	private final Sql2o sql2o;

	@Autowired
	public RaidTrackerService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
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
	 * Store RaidRecord
	 *
	 * @param record    RaidRecord to store
	 * @param accountId runelite account id to tie data too
	 */
	public void store(RaidRecord record, int accountId)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			// Kill Entry Query
			con.createQuery(INSERT_RAID_QUERY, true)
				.addParameter("accountId", accountId)
				.addParameter("username", record.getUsername())
				.addParameter("kc", record.getKc())
				.addParameter("cm", record.isCM())
				.addParameter("upperTime", record.getUpperTime())
				.addParameter("middleTime", record.getMiddleTime())
				.addParameter("lowerTime", record.getLowerTime())
				.addParameter("raidTime", record.getRaidTime())
				.addParameter("points", record.getPersonalPoints())
				.addParameter("teamPoints", record.getTeamPoints())
				.addParameter("teamSize", record.getTeamSize())
				.addParameter("rotation", record.getRotation())
				.addParameter("prep", record.isPrep())
				.executeUpdate();

			Query insertDrop = con.createQuery(INSERT_DROP_QUERY);

			// Append all queries for inserting drops
			for (GameItem drop : record.getDrops())
			{
				insertDrop
					.addParameter("raidId", drop.getId())
					.addParameter("itemQuantity", drop.getQty())
					.addToBatch();
			}

			insertDrop.executeBatch();
			con.commit(false);
		}
	}
}
