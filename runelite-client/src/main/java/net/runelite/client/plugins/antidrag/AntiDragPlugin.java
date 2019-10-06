/*
 * Copyright (c) 2018, DennisDeV <https://github.com/DevDennis>
 * Copyright (c) 2019, ganom <https://github.com/ganom>
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
package net.runelite.client.plugins.antidrag;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;

@PluginDescriptor(
	name = "Anti Drag",
	description = "Prevent dragging an item for a specified delay",
	tags = {"antidrag", "delay", "inventory", "items"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class AntiDragPlugin extends Plugin
{
	private static final int DEFAULT_DELAY = 5;

	@Inject
	private Client client;

	@Inject
	private ClientUI clientUI;

	@Inject
	private AntiDragConfig config;

	@Inject
	private AntiDragOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private EventBus eventBus;

	@Provides
	AntiDragConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AntiDragConfig.class);
	}

	private boolean toggleDrag;
	private boolean configOverlay;
	private boolean changeCursor;
	private CustomCursor selectedCursor;
	private Keybind key;

	@Override
	protected void startUp() throws Exception
	{
		overlay.setColor(config.color());

		addSubscriptions();
		updateConfig();
		updateKeyListeners();

		if (config.alwaysOn())
		{
			client.setInventoryDragDelay(config.dragDelay());
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		client.setInventoryDragDelay(DEFAULT_DELAY);
		keyManager.unregisterKeyListener(holdListener);
		keyManager.unregisterKeyListener(toggleListener);
		toggleDrag = false;
		overlayManager.remove(overlay);
		clientUI.resetCursor();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(FocusChanged.class, this, this::onFocusChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("antiDrag"))
		{
			updateConfig();

			switch (event.getKey())
			{
				case "toggleKeyBind":
				case "holdKeyBind":
					updateKeyListeners();
					break;
				case "alwaysOn":
					client.setInventoryDragDelay(config.alwaysOn() ? config.dragDelay() : DEFAULT_DELAY);
					break;
				case "dragDelay":
					if (config.alwaysOn())
					{
						client.setInventoryDragDelay(config.dragDelay());
					}
					break;
				case ("changeCursor"):
					clientUI.resetCursor();
					break;
				case ("color"):
					overlay.setColor(config.color());
					break;
			}
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			keyManager.unregisterKeyListener(toggleListener);
			keyManager.unregisterKeyListener(holdListener);
		}
		else if (event.getGameState() == GameState.LOGGING_IN)
		{
			updateKeyListeners();
		}
	}

	private void updateConfig()
	{
		this.key = config.key();
		this.configOverlay = config.overlay();
		this.changeCursor = config.changeCursor();
		this.selectedCursor = config.selectedCursor();
	}

	private void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused() && config.reqFocus() && !config.alwaysOn())
		{
			client.setInventoryDragDelay(DEFAULT_DELAY);
			overlayManager.remove(overlay);
		}
	}

	private void updateKeyListeners()
	{
		if (config.holdKeyBind())
		{
			keyManager.registerKeyListener(holdListener);
		}
		else
		{
			keyManager.unregisterKeyListener(holdListener);
		}

		if (config.toggleKeyBind())
		{
			keyManager.registerKeyListener(toggleListener);
		}
		else
		{
			keyManager.unregisterKeyListener(toggleListener);
		}
	}

	private final HotkeyListener toggleListener = new HotkeyListener(() -> this.key)
	{
		@Override
		public void hotkeyPressed()
		{
			toggleDrag = !toggleDrag;
			if (toggleDrag)
			{
				if (configOverlay)
				{
					overlayManager.add(overlay);
				}
				if (changeCursor)
				{
					clientUI.setCursor(selectedCursor.getCursorImage(), selectedCursor.toString());
				}

				client.setInventoryDragDelay(config.dragDelay());
			}
			else
			{
				overlayManager.remove(overlay);
				client.setInventoryDragDelay(DEFAULT_DELAY);
				clientUI.resetCursor();
			}
		}
	};

	private final HotkeyListener holdListener = new HotkeyListener(() -> this.key)
	{
		@Override
		public void hotkeyPressed()
		{
			if (configOverlay)
			{
				overlayManager.add(overlay);
			}
			if (changeCursor)
			{
				clientUI.setCursor(selectedCursor.getCursorImage(), selectedCursor.toString());
			}

			client.setInventoryDragDelay(config.dragDelay());
		}

		@Override
		public void hotkeyReleased()
		{
			overlayManager.remove(overlay);
			client.setInventoryDragDelay(DEFAULT_DELAY);
			clientUI.resetCursor();
		}
	};
}
