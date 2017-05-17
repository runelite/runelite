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
import javax.swing.ImageIcon;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.NavigationPanel;
import net.runelite.client.util.RunnableExceptionLogger;
import net.runelite.http.api.account.AccountClient;
import net.runelite.http.api.account.OAuthResponse;
import net.runelite.http.api.ws.messages.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountPlugin extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(AccountPlugin.class);

	private final RuneLite runelite = RuneLite.getRunelite();
	private final ClientUI ui = runelite.getGui();
	private final NavigationButton loginButton = new NavigationButton("Login");
	private final NavigationButton logoutButton = new NavigationButton("Logout");

	private final AccountClient loginClient = new AccountClient();

	@Override
	protected void startUp() throws Exception
	{
		ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("login_icon.png")));
		loginButton.getButton().setIcon(icon);

		icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("logout_icon.png")));
		logoutButton.getButton().setIcon(icon);

		loginButton.getButton().addActionListener(this::loginClick);
		logoutButton.getButton().addActionListener(this::logoutClick);

		ui.getNavigationPanel().addNavigation(loginButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
	}

	private void loginClick(ActionEvent ae)
	{
		ScheduledExecutorService executor = runelite.getExecutor();
		executor.execute(RunnableExceptionLogger.wrap(this::openLoginPage));
	}

	private void logoutClick(ActionEvent ae)
	{
		// Destroy session
		AccountSession session = runelite.getAccountSession();
		if (session != null)
		{
			AccountClient client = new AccountClient(session.getUuid());
			try
			{
				client.logout();
			}
			catch (IOException ex)
			{
				logger.warn("Unable to logout of session", ex);
			}
		}

		runelite.closeSession(); // remove session from client
		runelite.deleteSession(); // delete saved session file

		// Replace logout nav button with login
		NavigationPanel navigationPanel = ui.getNavigationPanel();
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
			logger.warn("Unable to get oauth url", ex);
			return;
		}

		// Create new session
		AccountSession session = new AccountSession();
		session.setUuid(login.getUid());
		session.setCreated(Instant.now());

		runelite.openSession(session);

		if (!Desktop.isDesktopSupported())
		{
			logger.info("Desktop is not supported. Visit {}", login.getOauthUrl());
			return;
		}

		Desktop desktop = Desktop.getDesktop();
		if (!desktop.isSupported(Desktop.Action.BROWSE))
		{
			logger.info("Desktop browser is not supported. Visit {}", login.getOauthUrl());
			return;
		}

		try
		{
			desktop.browse(new URI(login.getOauthUrl()));

			logger.debug("Opened browser to {}", login.getOauthUrl());
		}
		catch (IOException | URISyntaxException ex)
		{
			logger.warn("Unable to open login page", ex);
		}
	}

	@Subscribe
	public void onLogin(LoginResponse loginResponse)
	{
		logger.debug("Now logged in as {}", loginResponse.getUsername());

		//runelite.getGui().setTitle("RuneLite (" + loginResponse.getUsername() + ")");
		AccountSession session = runelite.getAccountSession();
		session.setUsername(loginResponse.getUsername());

		// Open session, again, now that we have a username
		// This triggers onSessionOpen
		runelite.openSession(session);

		// Save session to disk
		runelite.saveSession();
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		AccountSession session = runelite.getAccountSession();

		if (session.getUsername() == null)
		{
			return; // No username yet
		}

		logger.debug("Session opened as {}", session.getUsername());

		runelite.getGui().setTitle("RuneLite (" + session.getUsername() + ")");

		replaceLoginWithLogout();
	}

	private void replaceLoginWithLogout()
	{
		// Replace login nav button with logout
		NavigationPanel navigationPanel = ui.getNavigationPanel();
		navigationPanel.removeNavigation(loginButton);
		navigationPanel.addNavigation(logoutButton);
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose)
	{
		runelite.getGui().setTitle("RuneLite");
	}

}
