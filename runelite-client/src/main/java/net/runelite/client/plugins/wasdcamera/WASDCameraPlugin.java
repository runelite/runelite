/*
 * Copyright (c) 2018, Abexlry <abexlry@gmail.com>
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
package net.runelite.client.plugins.wasdcamera;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "WASD Camera",
		description = "Allows use of WASD keys for camera movement with 'Press Enter to Chat'",
		tags = {"wasd", "camera", "chat"},
		enabledByDefault = false
)

public class WASDCameraPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private WASDCameraOverlay overlay;

	@Inject
	public WASDCameraConfig config;

	@Inject
	private WASDCameraListener inputListener;

	public boolean handleCam = true;
	public boolean inChat = true;
	public boolean inFocus = true;
	public boolean loggedIn = false;

	@Provides
	WASDCameraConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WASDCameraConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(inputListener);
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(inputListener);
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged e)
	{
		if (e.getGameState() == GameState.HOPPING || e.getGameState() == GameState.LOGIN_SCREEN)
		{
			loggedIn = false;
		}
	}

	@Subscribe
	private void onGameTick(GameTick t)
	{
		loggedIn = true;
		overlay.updateOverlay();
	}

	@Subscribe
	public void onFocusChanged(FocusChanged f)
	{
		inFocus = f.isFocused();
		overlay.updateOverlay();
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged e)
	{
		if (canHandle())
		{
			if (e.getIndex() == VarClientStr.CHATBOX_TYPED_TEXT.getIndex() && handleCam)
			{
				inChat = true;
				client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
			}
			else
			{
				inChat = false;
			}
		}
	}

	public boolean canHandle()
	{
		return loggedIn && inFocus;
	}

	public void handleKeyPress(KeyEvent e)
	{
		if (handleCam && inChat)
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_W:
					e.setKeyCode(KeyEvent.VK_UP);
					break;
				case KeyEvent.VK_A:
					e.setKeyCode(KeyEvent.VK_LEFT);
					break;
				case KeyEvent.VK_S:
					e.setKeyCode(KeyEvent.VK_DOWN);
					break;
				case KeyEvent.VK_D:
					e.setKeyCode(KeyEvent.VK_RIGHT);
					break;
				case KeyEvent.VK_ENTER:
				case KeyEvent.VK_SLASH:
					handleCam = false;
					break;
			}
		}
		else
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_ENTER:
					handleCam = true;
					break;
			}
		}

		overlay.updateOverlay();
	}

	public void handleKeyRelease(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_W:
				e.setKeyCode(KeyEvent.VK_UP);
				break;
			case KeyEvent.VK_A:
				e.setKeyCode(KeyEvent.VK_LEFT);
				break;
			case KeyEvent.VK_S:
				e.setKeyCode(KeyEvent.VK_DOWN);
				break;
			case KeyEvent.VK_D:
				e.setKeyCode(KeyEvent.VK_RIGHT);
				break;
		}

		overlay.updateOverlay();
	}
}