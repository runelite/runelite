/*
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
package net.runelite.http.service.kc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class KillCountService
{
	private static final String CREATE = "CREATE TABLE IF NOT EXISTS `kc` (\n" +
		"  `name` varchar(32) NOT NULL,\n" +
		"  `boss` varchar(32) NOT NULL,\n" +
		"  `kc` int(11) NOT NULL,\n" +
		"  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),\n" +
		"   UNIQUE KEY `name` (`name`, `boss`),\n" +
		"   KEY `time` (`time`)\n" +
		") ENGINE=MEMORY;";

	private final Sql2o sql2o;

	@Autowired
	public KillCountService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE)
				.executeUpdate();
		}
	}

	public Integer getKc(String name, String boss)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("select kc from kc where name = :name and boss = :boss")
				.addParameter("name", name)
				.addParameter("boss", boss)
				.executeScalar(Integer.class);
		}
	}

	public void setKc(String name, String boss, int kc)
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("insert into kc (name, boss, kc) values (:name, :boss, :kc) on duplicate key update kc = VALUES(kc)")
				.addParameter("name", name)
				.addParameter("boss", boss)
				.addParameter("kc", kc)
				.executeUpdate();
		}
	}

	public void purge()
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from kc where time < (now() - interval 2 minute);")
				.executeUpdate();
		}
	}

	@Scheduled(fixedDelay = 60_000)
	public void schedPurge()
	{
		purge();
	}
}
