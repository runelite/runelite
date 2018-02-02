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
package net.runelite.client.plugins.account;

import com.google.common.eventbus.Subscribe;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.util.RunnableExceptionLogger;
import net.runelite.http.api.account.AccountClient;
import net.runelite.http.api.account.OAuthResponse;
import net.runelite.http.api.ws.messages.LoginResponse;

@PluginDescriptor(
	name = "Account plugin",
	loadWhenOutdated = true
)
@Slf4j
public class AccountPlugin extends Plugin
{
	@Inject
	private SessionManager sessionManager;

	@Inject
	private ClientUI ui;

	@Inject
	private ScheduledExecutorService executor;

	private NavigationButton loginButton;
	private NavigationButton logoutButton;

	private final AccountClient loginClient = new AccountClient();

	@Override
	protected void startUp() throws Exception
	{
		loginButton = new NavigationButton("Login", ImageIO.read(getClass().getResourceAsStream("login_icon.png")));
		logoutButton = new NavigationButton("Logout", ImageIO.read(getClass().getResourceAsStream("logout_icon.png")));
		loginButton.addActionListener(this::loginClick);
		logoutButton.addActionListener(this::logoutClick);
		ui.getPluginToolbar().addNavigation(sessionManager.getAccountSession() != null ? logoutButton : loginButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		ui.getPluginToolbar().removeNavigation(loginButton);
		ui.getPluginToolbar().removeNavigation(logoutButton);
	}

	private void loginClick(ActionEvent ae)
	{
		executor.execute(RunnableExceptionLogger.wrap(this::openLoginPage));
	}

	private void logoutClick(ActionEvent ae)
	{
		// Destroy session
		AccountSession session = sessionManager.getAccountSession();
		if (session != null)
		{
			AccountClient client = new AccountClient(session.getUuid());
			try
			{
				client.logout();
			}
			catch (IOException ex)
			{
				log.warn("Unable to logout of session", ex);
			}
		}

		sessionManager.closeSession(); // remove session from client
		sessionManager.deleteSession(); // delete saved session file

		// Replace logout nav button with login
		PluginToolbar navigationPanel = ui.getPluginToolbar();
		navigationPanel.removeNavigation(logoutButton);
		navigationPanel.addNavigation(loginButton);
	}

	private void openLoginPage()
	{
		OAuthResponse login;

		try
		{
			login = loginClient.login();
		}
		catch (IOException ex)
		{
			log.warn("Unable to get oauth url", ex);
			return;
		}

		// Create new session
		sessionManager.openSession(new AccountSession(login.getUid(), Instant.now()));

		if (!Desktop.isDesktopSupported())
		{
			log.info("Desktop is not supported. Visit {}", login.getOauthUrl());
			return;
		}

		Desktop desktop = Desktop.getDesktop();
		if (!desktop.isSupported(Desktop.Action.BROWSE))
		{
			log.info("Desktop browser is not supported. Visit {}", login.getOauthUrl());
			return;
		}

		try
		{
			desktop.browse(new URI(login.getOauthUrl()));

			log.debug("Opened browser to {}", login.getOauthUrl());
		}
		catch (IOException | URISyntaxException ex)
		{
			log.warn("Unable to open login page", ex);
		}
	}

	@Subscribe
	public void onLogin(LoginResponse loginResponse)
	{
		log.debug("Now logged in as {}", loginResponse.getUsername());

		AccountSession session = sessionManager.getAccountSession();
		session.setUsername(loginResponse.getUsername());

		// Open session, again, now that we have a username
		// This triggers onSessionOpen
		sessionManager.openSession(session);

		// Save session to disk
		sessionManager.saveSession();
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		AccountSession session = sessionManager.getAccountSession();

		if (session.getUsername() == null)
		{
			return; // No username yet
		}

		log.debug("Session opened as {}", session.getUsername());

		replaceLoginWithLogout();
	}

	private void replaceLoginWithLogout()
	{
		// Replace login nav button with logout
		PluginToolbar navigationPanel = ui.getPluginToolbar();
		navigationPanel.removeNavigation(loginButton);
		navigationPanel.addNavigation(logoutButton);
	}

}
