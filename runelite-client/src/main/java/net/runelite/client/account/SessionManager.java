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
package net.runelite.client.account;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.util.LinkBrowser;
import net.runelite.http.api.account.OAuthResponse;
import okhttp3.HttpUrl;

@Singleton
@Slf4j
public class SessionManager
{
	@Getter
	private AccountSession accountSession;

	private final EventBus eventBus;
	private final File sessionFile;
	private final AccountClient accountClient;
	private final Gson gson;
	private final String oauthRedirect;
	private final ScheduledExecutorService scheduledExecutorService;

	private HttpServer server;

	@Inject
	private SessionManager(
		@Named("sessionfile") File sessionfile,
		EventBus eventBus,
		AccountClient accountClient,
		Gson gson,
		@Named("runelite.oauth.redirect") String oauthRedirect,
		ScheduledExecutorService scheduledExecutorService
	)
	{
		this.eventBus = eventBus;
		this.sessionFile = sessionfile;
		this.accountClient = accountClient;
		this.gson = gson;
		this.oauthRedirect = oauthRedirect;
		this.scheduledExecutorService = scheduledExecutorService;

		eventBus.register(this);
	}

	public void loadSession()
	{
		if (!sessionFile.exists())
		{
			log.info("No session file exists");
			return;
		}

		AccountSession session;

		try (FileInputStream in = new FileInputStream(sessionFile))
		{
			session = gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), AccountSession.class);

			log.debug("Loaded session for {}", session.getUsername());
		}
		catch (Exception ex)
		{
			log.warn("Unable to load session file", ex);
			return;
		}

		// Check if session is still valid
		accountClient.setUuid(session.getUuid());
		if (!accountClient.sessionCheck())
		{
			log.debug("Loaded session {} is invalid", session.getUuid());
			return;
		}

		accountSession = session;
	}

	private void saveSession()
	{
		if (accountSession == null)
		{
			return;
		}

		try (Writer fw = new OutputStreamWriter(Files.newOutputStream(sessionFile.toPath()), StandardCharsets.UTF_8))
		{
			gson.toJson(accountSession, fw);

			log.debug("Saved session to {}", sessionFile);
		}
		catch (IOException ex)
		{
			log.warn("Unable to save session file", ex);
		}
	}

	private void deleteSession()
	{
		sessionFile.delete();
	}

	/**
	 * Set the given session as the active session
	 *
	 * @param session session
	 */
	private void openSession(AccountSession session)
	{
		accountSession = session;
		eventBus.post(new SessionOpen());
	}

	private void closeSession()
	{
		if (accountSession == null)
		{
			return;
		}

		log.debug("Logging out of account {}", accountSession.getUsername());

		// Delete session
		accountClient.setUuid(accountSession.getUuid());
		try
		{
			accountClient.logout();
		}
		catch (IOException ex)
		{
			log.warn("Unable to sign out of session", ex);
		}

		accountSession = null; // No more account

		eventBus.post(new SessionClose());
	}

	public void login()
	{
		if (server == null)
		{
			try
			{
				startServer();
			}
			catch (IOException ex)
			{
				log.error("Unable to start http server", ex);
				return;
			}
		}

		final OAuthResponse login;

		try
		{
			login = accountClient.login(server.getAddress().getPort());
		}
		catch (IOException ex)
		{
			log.error("Unable to get oauth url", ex);
			return;
		}

		// Navigate to login link
		LinkBrowser.browse(login.getOauthUrl());
	}

	public void logout()
	{
		closeSession();
		deleteSession();
	}

	private void startServer() throws IOException
	{
		server = HttpServer.create(new InetSocketAddress("localhost", 0), 1);
		server.createContext("/oauth", req ->
		{
			try
			{
				final HttpUrl url = HttpUrl.get("http://localhost" + req.getRequestURI());
				final String username = url.queryParameter("username");
				final UUID sessionId = UUID.fromString(url.queryParameter("sessionId"));

				log.debug("Now signed in as {}", username);

				// open the session, which triggers the sessionopen event
				AccountSession session = new AccountSession(sessionId, Instant.now(), username);
				openSession(session);

				// Save session to disk
				saveSession();

				final HttpUrl redirect = HttpUrl.get(oauthRedirect).newBuilder()
					.addQueryParameter("username", username)
					.addQueryParameter("sessionId", sessionId.toString())
					.build();

				req.getResponseHeaders().set("Location", redirect.toString());
				req.sendResponseHeaders(302, 0);
			}
			catch (Exception e)
			{
				log.warn("failure serving oauth response", e);
				req.sendResponseHeaders(400, 0);
				req.getResponseBody().write(e.getMessage().getBytes(StandardCharsets.UTF_8));
			}
			finally
			{
				req.close();
				scheduledExecutorService.execute(this::stopServer);
			}
		});

		log.debug("Starting server {}", server);
		server.start();
	}

	private void stopServer()
	{
		log.debug("Stopping server {}", server);
		server.stop(0);
		server = null;
	}
}
