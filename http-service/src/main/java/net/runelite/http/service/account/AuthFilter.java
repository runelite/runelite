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

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalNotification;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.service.account.beans.SessionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class AuthFilter
{
	private final Sql2o sql2o;

	private final Cache<UUID, SessionEntry> sessionCache = CacheBuilder.newBuilder()
		.maximumSize(10000L)
		.expireAfterAccess(30, TimeUnit.MINUTES)
		.removalListener(this::removalListener)
		.build();

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
		SessionEntry sessionEntry = sessionCache.getIfPresent(uuid);
		if (sessionEntry != null)
		{
			return sessionEntry;
		}

		try (Connection con = sql2o.open())
		{
			sessionEntry = con.createQuery("select user, uuid, created, last_used as lastUsed from sessions where uuid = :uuid")
				.addParameter("uuid", uuid.toString())
				.executeAndFetchFirst(SessionEntry.class);
		}

		if (sessionEntry == null)
		{
			response.sendError(401, "Access denied");
			return null;
		}

		sessionCache.put(uuid, sessionEntry);

		return sessionEntry;
	}

	private void removalListener(RemovalNotification<UUID, SessionEntry> notification)
	{
		UUID uuid = notification.getKey();
		Instant now = Instant.now();

		try (Connection con = sql2o.open())
		{
			con.createQuery("update sessions set last_used = :last_used where uuid = :uuid")
				.addParameter("last_used", Timestamp.from(now))
				.addParameter("uuid", uuid.toString())
				.executeUpdate();
		}
	}

	public void invalidate(UUID uuid)
	{
		// If we ever run multiple services, may need to publish something here to invalidate...
		sessionCache.invalidate(uuid);
	}

}
