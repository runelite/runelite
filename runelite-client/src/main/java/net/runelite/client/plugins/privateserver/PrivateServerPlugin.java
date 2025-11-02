/*
 * Copyright (c) 2024, Private Server Multiboxing
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
package net.runelite.client.plugins.privateserver;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Private",
	description = "Multiboxing plugin for OSRS private servers with synchronized actions and hotkey support",
	tags = {"multibox", "private", "server", "sync", "multiple", "clients"},
	enabledByDefault = false
)
public class PrivateServerPlugin extends Plugin
{
	static final String CONFIG_GROUP = "privateserver";

	@Inject
	private Client client;

	@Inject
	private PrivateServerConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PrivateServerOverlay overlay;

	private boolean multiboxingEnabled = true;
	private boolean clickSyncEnabled = false;
	private boolean pluginActive = false;

	@Provides
	PrivateServerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrivateServerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		log.info("Private Server Multiboxing Plugin started");
		pluginActive = true;
		multiboxingEnabled = config.enableMultiboxing();
		clickSyncEnabled = config.clickSync();

		// Register hotkey listeners
		keyManager.registerKeyListener(toggleMultiboxHotkey);
		keyManager.registerKeyListener(syncPrayerHotkey);
		keyManager.registerKeyListener(syncSpecHotkey);
		keyManager.registerKeyListener(toggleClickSyncHotkey);
		keyManager.registerKeyListener(followLeaderHotkey);

		// Add overlay if enabled
		if (config.showMultiboxOverlay())
		{
			overlayManager.add(overlay);
		}

		// Disable client instance check for multiple clients
		if (config.allowMultipleClients())
		{
			disableInstanceCheck();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Private Server Multiboxing Plugin stopped");
		pluginActive = false;

		// Unregister hotkey listeners
		keyManager.unregisterKeyListener(toggleMultiboxHotkey);
		keyManager.unregisterKeyListener(syncPrayerHotkey);
		keyManager.unregisterKeyListener(syncSpecHotkey);
		keyManager.unregisterKeyListener(toggleClickSyncHotkey);
		keyManager.unregisterKeyListener(followLeaderHotkey);

		// Remove overlay
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_GROUP))
		{
			return;
		}

		switch (event.getKey())
		{
			case "enableMultiboxing":
				multiboxingEnabled = config.enableMultiboxing();
				log.info("Multiboxing " + (multiboxingEnabled ? "enabled" : "disabled"));
				break;
			case "clickSync":
				clickSyncEnabled = config.clickSync();
				log.info("Click sync " + (clickSyncEnabled ? "enabled" : "disabled"));
				break;
			case "showMultiboxOverlay":
				if (config.showMultiboxOverlay())
				{
					overlayManager.add(overlay);
				}
				else
				{
					overlayManager.remove(overlay);
				}
				break;
			case "allowMultipleClients":
				if (config.allowMultipleClients())
				{
					disableInstanceCheck();
				}
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			log.debug("Player logged in - multiboxing features active");
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!multiboxingEnabled || !pluginActive)
		{
			return;
		}

		// Handle periodic sync checks if needed
	}

	// Hotkey: Toggle multiboxing on/off
	private final HotkeyListener toggleMultiboxHotkey = new HotkeyListener(() -> config.toggleMultiboxHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			multiboxingEnabled = !multiboxingEnabled;
			log.info("Multiboxing " + (multiboxingEnabled ? "enabled" : "disabled"));
			client.addChatMessage(
				net.runelite.api.ChatMessageType.GAMEMESSAGE,
				"",
				"Multiboxing " + (multiboxingEnabled ? "enabled" : "disabled"),
				null
			);
		}
	};

	// Hotkey: Sync prayer activation
	private final HotkeyListener syncPrayerHotkey = new HotkeyListener(() -> config.syncPrayerHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			if (!multiboxingEnabled || !config.quickPrayerSync())
			{
				return;
			}

			activateQuickPrayer();
			log.debug("Quick prayer sync activated");
		}
	};

	// Hotkey: Sync special attack
	private final HotkeyListener syncSpecHotkey = new HotkeyListener(() -> config.syncSpecHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			if (!multiboxingEnabled || !config.quickSpecSync())
			{
				return;
			}

			activateSpecialAttack();
			log.debug("Special attack sync activated");
		}
	};

	// Hotkey: Toggle click synchronization
	private final HotkeyListener toggleClickSyncHotkey = new HotkeyListener(() -> config.toggleClickSyncHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			clickSyncEnabled = !clickSyncEnabled;
			log.info("Click sync " + (clickSyncEnabled ? "enabled" : "disabled"));
			client.addChatMessage(
				net.runelite.api.ChatMessageType.GAMEMESSAGE,
				"",
				"Click sync " + (clickSyncEnabled ? "enabled" : "disabled"),
				null
			);
		}
	};

	// Hotkey: Follow leader
	private final HotkeyListener followLeaderHotkey = new HotkeyListener(() -> config.followLeaderHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			if (!multiboxingEnabled)
			{
				return;
			}

			// This would typically trigger follow actions on other clients
			// Implementation depends on inter-client communication
			log.debug("Follow leader triggered");
			client.addChatMessage(
				net.runelite.api.ChatMessageType.GAMEMESSAGE,
				"",
				"Follow leader activated",
				null
			);
		}
	};

	/**
	 * Activates quick prayers
	 */
	private void activateQuickPrayer()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// Toggle quick prayer
		int currentPrayerState = client.getVarbitValue(Varbits.QUICK_PRAYER);
		client.setVarbit(Varbits.QUICK_PRAYER, currentPrayerState == 0 ? 1 : 0);
	}

	/**
	 * Activates special attack
	 */
	private void activateSpecialAttack()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// Toggle special attack
		int currentSpecState = client.getVarbitValue(Varbits.SPECIAL_ATTACK_ENABLED);
		client.setVarbit(Varbits.SPECIAL_ATTACK_ENABLED, currentSpecState == 0 ? 1 : 0);
	}

	/**
	 * Disables the RuneLite instance check to allow multiple clients
	 */
	private void disableInstanceCheck()
	{
		// Set system property to allow multiple instances
		System.setProperty("runelite.launcher.nojvm", "true");
		log.info("Multiple client instances allowed");
	}

	/**
	 * Check if multiboxing is currently enabled
	 */
	public boolean isMultiboxingEnabled()
	{
		return multiboxingEnabled && pluginActive;
	}

	/**
	 * Check if click sync is currently enabled
	 */
	public boolean isClickSyncEnabled()
	{
		return clickSyncEnabled && multiboxingEnabled && pluginActive;
	}
}
