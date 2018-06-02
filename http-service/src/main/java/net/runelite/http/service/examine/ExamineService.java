/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
import static net.runelite.http.service.examine.ExamineType.ITEM;
import static net.runelite.http.service.examine.ExamineType.NPC;
import static net.runelite.http.service.examine.ExamineType.OBJECT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@RestController
@RequestMapping("/examine")
public class ExamineService
{
	private static final Logger logger = LoggerFactory.getLogger(ExamineService.class);

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

	@RequestMapping("/npc/{id}")
	public String getNpc(@PathVariable int id)
	{
		return get(NPC, id);
	}

	@RequestMapping("/object/{id}")
	public String getObject(@PathVariable int id)
	{
		return get(OBJECT, id);
	}

	@RequestMapping("/item/{id}")
	public String getItem(@PathVariable int id)
	{
		return get(ITEM, id);
	}

	@RequestMapping(path = "/npc/{id}", method = POST)
	public void submitNpc(@PathVariable int id, @RequestBody String examine)
	{
		insert(NPC, id, examine);
	}

	@RequestMapping(path = "/object/{id}", method = POST)
	public void submitObject(@PathVariable int id, @RequestBody String examine)
	{
		insert(OBJECT, id, examine);
	}

	@RequestMapping(path = "/item/{id}", method = POST)
	public void submitItem(@PathVariable int id, @RequestBody String examine)
	{
		insert(ITEM, id, examine);
	}

	private String get(ExamineType type, int id)
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

	private void insert(ExamineType type, int id, String examine)
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
