/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.loginscreen;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.OSType;

@PluginDescriptor(
	name = "Login Screen",
	description = "Provides various enhancements for login screen"
)
@Slf4j
@Singleton
public class LoginScreenPlugin extends Plugin implements KeyListener
{
	private static final int MAX_USERNAME_LENGTH = 254;
	private static final int MAX_PASSWORD_LENGTH = 20;
	private static final int MAX_PIN_LENGTH = 6;

	@Inject
	private Client client;

	@Inject
	private LoginScreenConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private EventBus eventBus;

	private String usernameCache;

	private boolean syncUsername;
	private boolean pasteEnabled;
	private String username;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		client.setHideDisconnect(config.hideDisconnected());

		applyUsername();
		keyManager.registerKeyListener(this);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		if (this.syncUsername)
		{
			client.getPreferences().setRememberedUsername(usernameCache);
		}

		client.setHideDisconnect(false);

		keyManager.unregisterKeyListener(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(SessionOpen.class, this, this::onSessionOpen);
	}

	@Provides
	LoginScreenConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LoginScreenConfig.class);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (!this.syncUsername)
		{
			return;
		}

		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			applyUsername();
		}
		else if (event.getGameState() == GameState.LOGGED_IN)
		{
			String username = "";

			if (client.getPreferences().getRememberedUsername() != null)
			{
				username = client.getUsername();
			}

			if (this.username.equals(username))
			{
				return;
			}

			log.debug("Saving username: {}", username);
			config.username(username);
			this.username = username;
		}
	}

	private void onSessionOpen(SessionOpen event)
	{
		// configuation for the account is available now, so update the username
		applyUsername();
	}

	private void applyUsername()
	{
		if (!this.syncUsername)
		{
			return;
		}

		GameState gameState = client.getGameState();
		if (gameState == GameState.LOGIN_SCREEN)
		{
			String username = this.username;

			if (Strings.isNullOrEmpty(username))
			{
				return;
			}

			// Save it only once
			if (usernameCache == null)
			{
				usernameCache = client.getPreferences().getRememberedUsername();
			}

			client.getPreferences().setRememberedUsername(username);
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!this.pasteEnabled || (
			client.getGameState() != GameState.LOGIN_SCREEN &&
				client.getGameState() != GameState.LOGIN_SCREEN_AUTHENTICATOR))
		{
			return;
		}

		// enable pasting on macOS with the Command (meta) key
		boolean isModifierDown = OSType.getOSType() == OSType.MacOS ? e.isMetaDown() : e.isControlDown();

		if (e.getKeyCode() == KeyEvent.VK_V && isModifierDown)
		{
			try
			{
				final String data = Toolkit
					.getDefaultToolkit()
					.getSystemClipboard()
					.getData(DataFlavor.stringFlavor)
					.toString()
					.trim();

				switch (client.getLoginIndex())
				{
					// Username/password form
					case 2:
						if (client.getCurrentLoginField() == 0)
						{
							// Truncate data to maximum username length if necessary
							client.setUsername(data.substring(0, Math.min(data.length(), MAX_USERNAME_LENGTH)));
						}
						else
						{
							// Truncate data to maximum password length if necessary
							client.setPassword(data.substring(0, Math.min(data.length(), MAX_PASSWORD_LENGTH)));
						}

						break;
					// Authenticator form
					case 4:
						// Truncate data to maximum OTP code length if necessary
						client.setOtp(data.substring(0, Math.min(data.length(), MAX_PIN_LENGTH)));
						break;
				}
			}
			catch (UnsupportedFlavorException | IOException ex)
			{
				log.warn("failed to fetch clipboard data", ex);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("loginscreen"))
		{
			return;
		}

		if (event.getKey().equals("hideDisconnect"))
		{
			client.setHideDisconnect(config.hideDisconnected());
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.syncUsername = config.syncUsername();
		this.pasteEnabled = config.pasteEnabled();
		this.username = config.username();
	}
}
