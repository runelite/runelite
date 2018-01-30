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

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigManager;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.http.api.account.AccountClient;

@Singleton
@Slf4j
public class SessionManager
{
	private static final File SESSION_FILE = new File(RuneLite.RUNELITE_DIR, "session");
	private WSClient wsclient;

	@Getter
	private AccountSession accountSession;

	@Inject
	private EventBus eventBus;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ScheduledExecutorService executor;

	public void loadSession()
	{
		if (!SESSION_FILE.exists())
		{
			log.info("No session file exists");
			return;
		}

		AccountSession session;

		try (FileInputStream in = new FileInputStream(SESSION_FILE))
		{
			session = new Gson().fromJson(new InputStreamReader(in), AccountSession.class);

			log.debug("Loaded session for {}", session.getUsername());
		}
		catch (Exception ex)
		{
			log.warn("Unable to load session file", ex);
			return;
		}

		// Check if session is still valid
		AccountClient accountClient = new AccountClient(session.getUuid());
		if (!accountClient.sesssionCheck())
		{
			log.debug("Loaded session {} is invalid", session.getUuid());
			return;
		}

		openSession(session);
	}

	public void saveSession()
	{
		if (accountSession == null)
		{
			return;
		}

		try (FileWriter fw = new FileWriter(SESSION_FILE))
		{
			new Gson().toJson(accountSession, fw);

			log.debug("Saved session to {}", SESSION_FILE);
		}
		catch (IOException ex)
		{
			log.warn("Unable to save session file", ex);
		}
	}

	public void deleteSession()
	{
		SESSION_FILE.delete();
	}

	/**
	 * Set the given session as the active session and open a socket to the
	 * server with the given session
	 *
	 * @param session
	 */
	public void openSession(AccountSession session)
	{
		// If the ws session already exists, don't need to do anything
		if (wsclient == null || !wsclient.checkSession(session))
		{
			if (wsclient != null)
			{
				wsclient.close();
			}

			wsclient = new WSClient(eventBus, executor, session);
			wsclient.connect();
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

	public void closeSession()
	{
		if (wsclient != null)
		{
			wsclient.close();
			wsclient = null;
		}

		if (accountSession == null)
		{
			return;
		}

		log.debug("Logging out of account {}", accountSession.getUsername());

		accountSession = null; // No more account

		// Restore config
		configManager.switchSession(null);

		eventBus.post(new SessionClose());
	}
}