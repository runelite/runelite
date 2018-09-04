/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.http.service.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class ChatDataService
{
	private static final String CREATE = "CREATE TABLE IF NOT EXISTS `chat` (\n" +
		"  `name` varchar(32) NOT NULL,\n" +
		"  `type` varchar(32) NOT NULL,\n" +
		"  `subtype` varchar(32) NOT NULL DEFAULT '',\n" +
		"  `data` varchar(100) NOT NULL,\n" +
		"  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),\n" +
		"   UNIQUE KEY `name` (`name`, `type`, `subtype`),\n" +
		"   KEY `time` (`time`)\n" +
		") ENGINE=InnoDB;";

	private final Sql2o sql2o;

	@Autowired
	public ChatDataService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;

		try (final Connection con = sql2o.open())
		{
			con.createQuery(CREATE).executeUpdate();
		}
	}

	String getData(final String name, final String type, final String subtype)
	{
		try (final Connection con = sql2o.open())
		{
			return con.createQuery("select data from chat where name = :name and type = :type and subtype = :subtype")
				.addParameter("name", name)
				.addParameter("type", type)
				.addParameter("subtype", subtype)
				.executeScalar(String.class);
		}
	}

	void setData(final String name, final String type, final String subtype, final String data)
	{
		try (final Connection con = sql2o.open())
		{
			con.createQuery("insert into chat (name, type, subtype, data) values (:name, :type, :subtype, :data) on duplicate key update data = VALUES(data)")
				.addParameter("name", name)
				.addParameter("type", type)
				.addParameter("subtype", subtype)
				.addParameter("data", data)
				.executeUpdate();
		}
	}

	@Scheduled(fixedDelay = 60_000)
	public void purge()
	{
		try (final Connection con = sql2o.open())
		{
			con.createQuery("delete from chat where time < (now() - interval 2 minute);").executeUpdate();
		}
	}
}
