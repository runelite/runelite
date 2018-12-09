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

import com.google.api.client.http.HttpStatusCodes;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.loottracker.LootRecord;
import net.runelite.http.service.account.beans.SessionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@RestController
@RequestMapping("/loottracker")
public class LootDatabaseController
{
	// Table for storing individual LootRecords
	private static final String CREATE_KILLS = "CREATE TABLE IF NOT EXISTS `kills` (\n"
		+ "  `id` INT AUTO_INCREMENT UNIQUE,\n"
		+ "  `accountId` INT NOT NULL,\n"
		+ "  `type` VARCHAR(255) NOT NULL,\n"
		+ "  `eventId` VARCHAR(255) NOT NULL,\n"
		+ "  PRIMARY KEY (id),\n"
		+ "  FOREIGN KEY (accountId) REFERENCES sessions(user) ON DELETE CASCADE\n"
		+ ") ENGINE=InnoDB";

	// Table for storing Items received as loot for individual LootRecords
	private static final String CREATE_DROPS = "CREATE TABLE IF NOT EXISTS `drops` (\n"
		+ "  `killId` INT NOT NULL,\n"
		+ "  `itemId` INT NOT NULL,\n"
		+ "  `itemQuantity` INT NOT NULL,\n"
		+ "  FOREIGN KEY (killId) REFERENCES kills(id) ON DELETE CASCADE\n"
		+ ") ENGINE=InnoDB";

	@Autowired
	public LootDatabaseController(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		// Ensure necessary tables exist
		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_KILLS).executeUpdate();
			con.createQuery(CREATE_DROPS).executeUpdate();
		}
	}

	@Autowired
	private LootDatabaseService service;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	public void storeLootRecord(HttpServletRequest request, HttpServletResponse response, @RequestBody LootRecord record) throws IOException
	{
		SessionEntry e = service.handleAuth(request, response);
		if (e == null)
		{
			response.setStatus(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED);
		}
		else
		{
			service.storeLootRecord(record, e.getUser());
			response.setStatus(HttpStatusCodes.STATUS_CODE_OK);
		}
	}
}