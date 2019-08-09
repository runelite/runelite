/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.examine;

import java.sql.Timestamp;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class ExamineService
{
	private static final String CREATE_EXAMINE = "CREATE TABLE IF NOT EXISTS `examine` (\n"
		+ "  `type` enum('OBJECT','NPC','ITEM') NOT NULL,\n"
		+ "  `id` int(11) NOT NULL,\n"
		+ "  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n"
		+ "  `count` int(11) NOT NULL,\n"
		+ "  `text` tinytext NOT NULL,\n"
		+ "  UNIQUE KEY `type` (`type`,`id`,`text`(64))\n"
		+ ") ENGINE=InnoDB";

	private final Sql2o sql2o;

	@Autowired
	public ExamineService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_EXAMINE)
				.executeUpdate();
		}
	}

	public String get(ExamineType type, int id)
	{
		try (Connection con = sql2o.open())
		{
			ExamineEntry entry = con.createQuery("select text from examine where type = :type and id = :id "
				+ "order by count desc limit 1")
				.addParameter("type", type.toString())
				.addParameter("id", id)
				.executeAndFetchFirst(ExamineEntry.class);

			if (entry != null)
			{
				return entry.getText();
			}
		}

		return null;
	}

	public void insert(ExamineType type, int id, String examine)
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("insert into examine (type, id, time, count, text) values "
				+ "(:type, :id, :time, :count, :text) on duplicate key update count = count + 1")
				.addParameter("type", type.toString())
				.addParameter("id", id)
				.addParameter("time", Timestamp.from(Instant.now()))
				.addParameter("count", 1)
				.addParameter("text", examine)
				.executeUpdate();
		}
	}
}
