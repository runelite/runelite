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

import net.runelite.http.service.account.beans.SessionEntry;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import net.runelite.http.api.RuneliteAPI;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Session;
import static spark.Spark.halt;

public class AuthFilter implements Filter
{
	private final Sql2o sql2o;

	@Inject
	public AuthFilter(@Named("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;
	}

	@Override
	public void handle(Request request, Response response) throws Exception
	{
		String runeliteAuth = request.headers(RuneliteAPI.RUNELITE_AUTH);
		if (runeliteAuth == null)
		{
			halt(401, "Access denied");
			return;
		}

		UUID uuid = UUID.fromString(runeliteAuth);

		try (Connection con = sql2o.open())
		{
			SessionEntry sessionEntry = con.createQuery("select user, uuid, created from sessions where uuid = :uuid")
				.addParameter("uuid", uuid.toString())
				.executeAndFetchFirst(SessionEntry.class);

			if (sessionEntry == null)
			{
				halt(401, "Access denied");
				return;
			}

			Instant now = Instant.now();

			con.createQuery("update sessions set last_used = :last_used where uuid = :uuid")
				.addParameter("last_used", Timestamp.from(now))
				.addParameter("uuid", uuid.toString())
				.executeUpdate();

			sessionEntry.setLastUsed(now);

			Session session = request.session();
			session.attribute("session", sessionEntry);
		}
	}

}
