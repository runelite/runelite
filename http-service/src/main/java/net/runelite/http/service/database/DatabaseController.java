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

import net.runelite.http.api.database.LootRecord;
import net.runelite.http.service.account.beans.SessionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/database")
public class DatabaseController
{
	// Storage for LootRecord's
	private static final String CREATE_KILLS = "CREATE TABLE IF NOT EXISTS `kills` (\n"
			+ "  `id` INT AUTO_INCREMENT UNIQUE,\n"
			+ "  `accountId` INT NOT NULL,\n"
			+ "  `username` VARCHAR(255) NOT NULL,\n"
			+ "  `npcName` VARCHAR(255),\n"
			+ "  `npcID` INT NOT NULL,\n"
			+ "  `killCount` INT NOT NULL,\n"
			+ "  PRIMARY KEY (id),\n"
			+ "  FOREIGN KEY (accountId) REFERENCES sessions(user) ON DELETE CASCADE\n"
			+ ") ENGINE=InnoDB";

	// Storage for DropEntry (Tied to LootRecord)
	private static final String CREATE_DROPS = "CREATE TABLE IF NOT EXISTS `drops` (\n"
			+ "  `killId` INT NOT NULL,\n"
			+ "  `itemId` INT NOT NULL,\n"
			+ "  `itemAmount` INT NOT NULL,\n"
			+ "  FOREIGN KEY (killId) REFERENCES kills(id) ON DELETE CASCADE\n"
			+ ") ENGINE=InnoDB";

	@Autowired
	public DatabaseController(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		// Ensure necessary tables exist
		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_KILLS).executeUpdate();
			con.createQuery(CREATE_DROPS).executeUpdate();
		}
	}

	@Autowired
	private DatabaseService service;

	@RequestMapping(value = "/loot", method = RequestMethod.GET)
	public List<LootRecord> getLootRecordsByNpcName(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @RequestParam String id)
	{
		// Auth Check and grab user id
		SessionEntry entry = service.authCheck(request, response);
		if (entry == null)
		{
			return null;
		}
		return service.getLootRecordsByNpcName(username, id, entry.getUser());
	}

	@RequestMapping(value = "/loot", method = RequestMethod.POST)
	public HttpStatus storeLootRecord(HttpServletRequest request, HttpServletResponse response, @RequestBody LootRecord record, @RequestParam String username)
	{
		// Auth Check and grab user id
		SessionEntry entry = service.authCheck(request, response);
		if (entry == null)
		{
			return HttpStatus.UNAUTHORIZED;
		}
		else
		{
			// Actually store the record
			service.storeLootRecord(record, username, entry.getUser());
			return HttpStatus.OK;
		}
	}
}
