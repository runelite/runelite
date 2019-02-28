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

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.api.vars.AccountType;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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
	private static final String CONFIG_GROUP = "account";
	private static final Set<WorldType> DIFFERENT_SAVE_WORLD_TYPES = ImmutableSet.of(WorldType.DEADMAN, WorldType.DEADMAN_TOURNAMENT, WorldType.SEASONAL_DEADMAN, WorldType.TOURNAMENT);

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ScheduledExecutorService executor;

	private NavigationButton loginButton;
	private NavigationButton logoutButton;
	private boolean updateMapping;

	private static final BufferedImage LOGIN_IMAGE, LOGOUT_IMAGE;

	static
	{
		LOGIN_IMAGE = ImageUtil.getResourceStreamFromClass(AccountPlugin.class, "login_icon.png");
		LOGOUT_IMAGE = ImageUtil.getResourceStreamFromClass(AccountPlugin.class, "logout_icon.png");
	}

	@Override
	protected void startUp() throws Exception
	{
		loginButton = NavigationButton.builder()
			.tab(false)
			.icon(LOGIN_IMAGE)
			.tooltip("Login to RuneLite")
			.onClick(this::loginClick)
			.build();

		logoutButton = NavigationButton.builder()
			.tab(false)
			.icon(LOGOUT_IMAGE)
			.tooltip("Logout of RuneLite")
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
		updateMapping = false;
	}

	private void loginClick()
	{
		executor.execute(sessionManager::login);
	}

	private void logoutClick()
	{
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
				"Are you sure you want to logout from RuneLite?", "Logout Confirmation",
				JOptionPane.YES_NO_OPTION))
		{
			sessionManager.logout();
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

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (updateMapping)
		{
			updateMapping = false;

			final Player player = client.getLocalPlayer();

			if (player == null)
			{
				return;
			}

			final String name = player.getName();

			if (Strings.isNullOrEmpty(name))
			{
				return;
			}

			configManager.setConfiguration(CONFIG_GROUP + "." + client.getUsername(), "name", name);

			EnumSet<WorldType> worldTypes = client.getWorldType();
			worldTypes.retainAll(DIFFERENT_SAVE_WORLD_TYPES);
			if (worldTypes.size() == 0)
			{
				AccountType type = client.getAccountType();
				configManager.setConfiguration(CONFIG_GROUP + "." + client.getUsername(), "type", type);
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			updateMapping = true;
		}
	}
}
