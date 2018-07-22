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
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "WASD Camera",
		description = "Allows use of WASD keys for camera movement with 'Press Enter to Chat'",
		tags = {"wasd", "camera", "chat"}
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
	private WASDCameraConfig config;

	@Inject
	private WASDCameraListener inputListener;

	private static final int W_KEY = KeyEvent.VK_W;
	private static final int A_KEY = KeyEvent.VK_A;
	private static final int S_KEY = KeyEvent.VK_S;
	private static final int D_KEY = KeyEvent.VK_D;

	private static final int ENTER_KEY = KeyEvent.VK_ENTER;
	private static final int SLASH_KEY = KeyEvent.VK_SLASH;
	private static final int TAB_KEY = KeyEvent.VK_TAB;

	private static final int DELETE_KEY = KeyEvent.VK_BACK_SPACE;

	private static final int DUMMY_KEY = KeyEvent.VK_HOME;

	private Robot robot;

	public boolean canType;
	public boolean typingInChat;
	public boolean showOverlay;
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
		robot = new Robot();
		keyManager.registerKeyListener(inputListener);
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		robot = null;
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
		else
		{
			loggedIn = true;
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged f)
	{
		inFocus = f.isFocused();
	}

	public void handleKeyPress(KeyEvent e)
	{
		// If enter was pressed, toggle canType
		if (e.getKeyCode() == ENTER_KEY && typingInChat)
		{
			canType = !canType;
		}

		// If tab or slash, set canType to true
		if (e.getKeyCode() == TAB_KEY ||
				e.getKeyCode() == SLASH_KEY)
		{
			canType = true;
		}

		// Input locked
		if (!canType && typingInChat)
		{
			// If key is alphabet, digit or whitespace
			if (Character.isAlphabetic(e.getKeyCode()) ||
					(Character.isDigit(e.getKeyCode()) ||
							Character.isWhitespace(e.getKeyCode())))
			{
				pressCameraKey(e);
			}
		}

		if (e.getKeyCode() != DUMMY_KEY)
		{
			// Press dummy key to sync chat states
			pressDummyKey();
		}

		overlay.updateOverlay();
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged e)
	{
		// If chat string changed
		if (e.getIndex() == 1)
		{
			typingInChat = true;

			// If input was added to chat string but can't type, delete it
			// NOTE: This only happens if pressing keys fast
			if (client.getVar(VarClientStr.CHATBOX_TYPED_TEXT) != null &&
					client.getVar(VarClientStr.CHATBOX_TYPED_TEXT).length() > 0 && !canType)
			{
				pressDeleteKey();
			}
		}

		// If not typing in chat
		else if (e.getIndex() != 0)
		{
			typingInChat = false;
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged e)
	{
		// Press dummy key to sync chat states
		pressDummyKey();
	}

	public void pressDeleteKey()
	{
		robot.keyPress(DELETE_KEY);
	}

	public void pressDummyKey()
	{
		if (inFocus)
		{
			robot.keyPress(DUMMY_KEY);
		}
	}

	public void pressCameraKey(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			// Press Camera keys
			case W_KEY:
				robot.keyPress(KeyEvent.VK_UP);
				break;
			case A_KEY:
				robot.keyPress(KeyEvent.VK_LEFT);
				break;
			case S_KEY:
				robot.keyPress(KeyEvent.VK_DOWN);
				break;
			case D_KEY:
				robot.keyPress(KeyEvent.VK_RIGHT);
				break;
		}
	}

	public void releaseCameraKey(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			// Release Camera keys
			case W_KEY:
				robot.keyRelease(KeyEvent.VK_UP);
				break;
			case A_KEY:
				robot.keyRelease(KeyEvent.VK_LEFT);
				break;
			case S_KEY:
				robot.keyRelease(KeyEvent.VK_DOWN);
				break;
			case D_KEY:
				robot.keyRelease(KeyEvent.VK_RIGHT);
				break;
		}
	}
}