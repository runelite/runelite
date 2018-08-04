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
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
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
	public WASDCameraOverlay overlay;

	@Inject
	public WASDCameraConfig config;

	@Inject
	private WASDCameraListener inputListener;

	// Whether or not we should be remapping input
	public boolean handleCam;

	// Whether or not our last input was in the chat var string
	public boolean inChat;

	public boolean inFocus;
	public boolean loggedIn;

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
		handleCam = true;
		inChat = true;
		inFocus = true;
		loggedIn = false;
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(inputListener);
		overlayManager.remove(overlay);
	}

	/**
	 * Returns true if logged in and in focus.
	 * @return
	 */
	public boolean canHandle()
	{
		return loggedIn && inFocus;
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged e)
	{
		if (e.getGameState() == GameState.LOGGED_IN)
		{
			loggedIn = true;
		}
		else
		{
			loggedIn = false;
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged f)
	{
		inFocus = f.isFocused();
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged e)
	{
		if (!canHandle())
		{
			return;
		}

		// If the chatbox input var string has changed and we want to handle the cam, set inChat to true and empty chat
		if (e.getIndex() == VarClientStr.CHATBOX_TYPED_TEXT.getIndex() && handleCam)
		{
			inChat = true;
			client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
		}

		// index 0 seems to be tied to PM chat updating, we don't need to change inChat for it
		else if (e.getIndex() > 0)
		{
			inChat = false;
		}
	}
}
