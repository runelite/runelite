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
package net.runelite.http.service.account;

import java.io.IOException;
import net.runelite.http.service.account.beans.SessionEntry;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.RuneLiteAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class AuthFilter
{
	private final Sql2o sql2o;

	@Autowired
	public AuthFilter(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;
	}

	public SessionEntry handle(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String runeliteAuth = request.getHeader(RuneLiteAPI.RUNELITE_AUTH);
		if (runeliteAuth == null)
		{
			response.sendError(401, "Access denied");
			return null;
		}

		UUID uuid = UUID.fromString(runeliteAuth);

		try (Connection con = sql2o.open())
		{
			SessionEntry sessionEntry = con.createQuery("select user, uuid, created from sessions where uuid = :uuid")
				.addParameter("uuid", uuid.toString())
				.executeAndFetchFirst(SessionEntry.class);

			if (sessionEntry == null)
			{
				response.sendError(401, "Access denied");
				return null;
			}

			Instant now = Instant.now();

			con.createQuery("update sessions set last_used = :last_used where uuid = :uuid")
				.addParameter("last_used", Timestamp.from(now))
				.addParameter("uuid", uuid.toString())
				.executeUpdate();

			sessionEntry.setLastUsed(now);

			return sessionEntry;
		}
	}

}
