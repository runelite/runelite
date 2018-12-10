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
package net.runelite.http.service.session;

import java.time.Instant;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class SessionService
{
	private final Sql2o sql2o;

	@Autowired
	public SessionService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o
	)
	{
		this.sql2o = sql2o;
	}

	public void createSession(SessionEntry session)
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("insert into session (uuid, ip, start, last) "
				+ "values (:uuid, :ip, :start, :last)")
				.addParameter("uuid", session.getUuid().toString())
				.addParameter("ip", session.getIp())
				.addParameter("start", session.getStart())
				.addParameter("last", session.getLast())
				.executeUpdate();
		}
	}

	public SessionEntry findSessionByUUID(UUID id)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("select uuid, ip, start, last from session where uuid = :uuid")
				.addParameter("uuid", id.toString())
				.executeAndFetchFirst(SessionEntry.class);
		}
	}

	public int deleteSession(UUID id)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("delete from session where uuid = :uuid")
				.addParameter("uuid", id.toString())
				.executeUpdate()
				.getResult();
		}
	}

	public int updateLast(UUID session)
	{
		try (Connection con = sql2o.open())
		{
			Instant last = Instant.now();
			return con.createQuery("update session set last = :last where uuid = :uuid")
				.addParameter("last", last)
				.addParameter("uuid", session.toString())
				.executeUpdate()
				.getResult();
		}
	}

	private void deleteExpired()
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from session where last + interval 11 minute < current_timestamp()")
				.executeUpdate();
		}
	}

	public int getCount()
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("select count(*) from session")
				.executeScalar(Integer.class);
		}
	}

	@Scheduled(fixedDelay = 60000)
	public void expire()
	{
		deleteExpired();
	}
}
