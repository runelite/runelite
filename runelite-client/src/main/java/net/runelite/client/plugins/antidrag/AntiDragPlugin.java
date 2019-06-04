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
import net.runelite.api.Client;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.customcursor.CustomCursorConfig;
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

public class AntiDragPlugin extends Plugin
{
	private static final int DEFAULT_DELAY = 5;
	private boolean toggleDrag;

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

	@Provides
	AntiDragConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AntiDragConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(hotkeyListener);
		toggleDrag = false;

	}

	@Override
	protected void shutDown() throws Exception
	{
		client.setInventoryDragDelay(DEFAULT_DELAY);
		keyManager.unregisterKeyListener(hotkeyListener);
		toggleDrag = false;
		overlayManager.remove(overlay);
	}

	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> config.key())
	{
		@Override
		public void hotkeyPressed()
		{
			toggleDrag = !toggleDrag;
			if (toggleDrag)
			{
				if (config.overlay())
				{
					overlayManager.add(overlay);
				}
				if (config.changeCursor())
				{
					CustomCursor selectedCursor = config.selectedCursor();
					clientUI.setCursor(selectedCursor.getCursorImage(), selectedCursor.toString());
				}

				client.setInventoryDragDelay(config.dragDelay());
			}
			else
			{
				overlayManager.remove(overlay);
				client.setInventoryDragDelay(DEFAULT_DELAY);
				if (config.changeCursor())
				{
					net.runelite.client.plugins.customcursor.CustomCursor selectedCursor = configManager.getConfig(CustomCursorConfig.class).selectedCursor();
					clientUI.setCursor(selectedCursor.getCursorImage(), selectedCursor.toString());
				}
			}
		}
	};

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused() && config.reqfocus())
		{
			client.setInventoryDragDelay(DEFAULT_DELAY);
			overlayManager.remove(overlay);
		}
	}
}
