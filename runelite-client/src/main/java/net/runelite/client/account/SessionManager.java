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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.ws.WSClient;
import net.runelite.http.api.account.AccountClient;
import net.runelite.http.api.account.OAuthResponse;
import net.runelite.http.api.ws.messages.LoginResponse;
import okhttp3.OkHttpClient;

@Singleton
@Slf4j
public class SessionManager
{
	@Getter
	private AccountSession accountSession;

	private final EventBus eventBus;
	private final ConfigManager configManager;
	private final WSClient wsClient;
	private final File sessionFile;
	private final AccountClient accountClient;
	private final Gson gson;

	@Inject
	private SessionManager(
		@Named("sessionfile") File sessionfile,
		ConfigManager configManager,
		EventBus eventBus,
		WSClient wsClient,
		OkHttpClient okHttpClient,
		Gson gson)
	{
		this.configManager = configManager;
		this.eventBus = eventBus;
		this.wsClient = wsClient;
		this.sessionFile = sessionfile;
		this.accountClient = new AccountClient(okHttpClient);
		this.gson = gson;

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

		openSession(session, false);
	}

	private void saveSession()
	{
		if (accountSession == null)
		{
			return;
		}

		try (Writer fw = new OutputStreamWriter(new FileOutputStream(sessionFile), StandardCharsets.UTF_8))
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
	 * Set the given session as the active session and open a socket to the
	 * server with the given session
	 *
	 * @param session session
	 */
	private void openSession(AccountSession session, boolean openSocket)
	{
		// Change session on the websocket
		if (openSocket)
		{
			wsClient.changeSession(session.getUuid());
		}

		accountSession = session;

		if (session.getUsername() != null)
		{
			// Initialize config for new session
			// If the session isn't logged in yet, don't switch to the new config
			configManager.switchSession(session);
		}

		eventBus.post(new SessionOpen());
	}

	private void closeSession()
	{
		wsClient.changeSession(null);

		if (accountSession == null)
		{
			return;
		}

		log.debug("Logging out of account {}", accountSession.getUsername());

		accountClient.setUuid(accountSession.getUuid());
		try
		{
			accountClient.logout();
		}
		catch (IOException ex)
		{
			log.warn("Unable to logout of session", ex);
		}

		accountSession = null; // No more account

		// Restore config
		configManager.switchSession(null);

		eventBus.post(new SessionClose());
	}

	public void login()
	{
		// If a session is already open, use that id. Otherwise generate a new id.
		UUID uuid = wsClient.getSessionId() != null ? wsClient.getSessionId() : UUID.randomUUID();
		accountClient.setUuid(uuid);

		final OAuthResponse login;

		try
		{
			login = accountClient.login();
		}
		catch (IOException ex)
		{
			log.warn("Unable to get oauth url", ex);
			return;
		}

		// Create new session
		openSession(new AccountSession(login.getUid(), Instant.now()), true);

		// Navigate to login link
		LinkBrowser.browse(login.getOauthUrl());
	}

	@Subscribe
	public void onLoginResponse(LoginResponse loginResponse)
	{
		log.debug("Now logged in as {}", loginResponse.getUsername());

		AccountSession session = getAccountSession();
		session.setUsername(loginResponse.getUsername());

		// Open session, again, now that we have a username
		// This triggers onSessionOpen
		// The socket is already opened here anyway so we pass true for openSocket
		openSession(session, true);

		// Save session to disk
		saveSession();
	}

	public void logout()
	{
		closeSession();
		deleteSession();
	}
}
