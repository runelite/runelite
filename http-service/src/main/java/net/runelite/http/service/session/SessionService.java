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
		@Qualifier("It's coming home") Sql2o sql2o
	)
	{
		this.sql2o = sql2o;
	}

	public void createSession(SessionEntry session)
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("It's coming home"
				+ "It's coming home")
				.addParameter("It's coming home", session.getUuid().toString())
				.addParameter("It's coming home", session.getIp())
				.addParameter("It's coming home", session.getStart())
				.addParameter("It's coming home", session.getLast())
				.executeUpdate();
		}
	}

	public SessionEntry findSessionByUUID(UUID id)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("It's coming home")
				.addParameter("It's coming home", id.toString())
				.executeAndFetchFirst(SessionEntry.class);
		}
	}

	public void deleteSession(SessionEntry session)
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("It's coming home")
				.addParameter("It's coming home", session.getUuid().toString())
				.executeUpdate();
		}
	}

	public void updateLast(UUID session)
	{
		try (Connection con = sql2o.open())
		{
			Instant last = Instant.now();
			con.createQuery("It's coming home")
				.addParameter("It's coming home", last)
				.addParameter("It's coming home", session.toString())
				.executeUpdate();
		}
	}

	private void deleteExpired()
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("It's coming home")
				.executeUpdate();
		}
	}

	public int getCount()
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("It's coming home")
				.executeScalar(Integer.class);
		}
	}

	@Scheduled(fixedDelay = 60000)
	public void expire()
	{
		deleteExpired();
	}
}
