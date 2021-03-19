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

import java.awt.image.BufferedImage;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Account",
	description = "Sync RuneLite config settings with your Google account",
	tags = {"external", "google", "integration"},
	loadWhenOutdated = true
)
@Slf4j
public class AccountPlugin extends Plugin
{
	@Inject
	private SessionManager sessionManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ScheduledExecutorService executor;

	private NavigationButton loginButton;
	private NavigationButton logoutButton;

	private static final BufferedImage LOGIN_IMAGE, LOGOUT_IMAGE;

	static
	{
		LOGIN_IMAGE = ImageUtil.loadImageResource(AccountPlugin.class, "login_icon.png");
		LOGOUT_IMAGE = ImageUtil.loadImageResource(AccountPlugin.class, "logout_icon.png");
	}

	@Override
	protected void startUp() throws Exception
	{
		loginButton = NavigationButton.builder()
			.tab(false)
			.icon(LOGIN_IMAGE)
			.tooltip("Log in to RuneLite")
			.onClick(this::loginClick)
			.build();

		logoutButton = NavigationButton.builder()
			.tab(false)
			.icon(LOGOUT_IMAGE)
			.tooltip("Log out of RuneLite")
			.onClick(this::logoutClick)
			.build();

		addAndRemoveButtons();
	}

	private void addAndRemoveButtons()
	{
		clientToolbar.removeNavigation(loginButton);
		clientToolbar.removeNavigation(logoutButton);
		clientToolbar.addNavigation(sessionManager.getAccountSession() == null
			? loginButton
			: logoutButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(loginButton);
		clientToolbar.removeNavigation(logoutButton);
	}

	private void loginClick()
	{
		executor.execute(sessionManager::login);
	}

	private void logoutClick()
	{
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
			"Are you sure you want to log out from RuneLite?", "Logout Confirmation",
			JOptionPane.YES_NO_OPTION))
		{
			executor.execute(sessionManager::logout);
		}
	}

	@Subscribe
	public void onSessionClose(SessionClose e)
	{
		addAndRemoveButtons();
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

		addAndRemoveButtons();
	}

}
