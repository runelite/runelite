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
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
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
	private WASDCameraOverlay overlay;

	@Inject
	private WASDCameraConfig config;

	private Robot robot;

	public boolean canType;

	@Provides
	WASDCameraConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WASDCameraConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		//overlayManager.add(overlay);
		canType = true;
	}

	@Override
	protected void shutDown() throws Exception
	{
		robot = null;
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameTick(GameTick gameTick) throws Exception
	{
		if (robot == null)
		{
			initializeCamera();
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		int widgetId = event.getWidgetId();

		// If clicking on friend for private messaging, set canType to true
		if (widgetId == 28114953)
		{
			canType = true;
		}
	}

	/**
	 * Initialize plugin
	 */
	private void initializeCamera() throws Exception
	{
		robot = new Robot();
		canType = false;
		handleCamera();
		overlayManager.add(overlay);
	}

	/**
	 * Handles key listener events
	 */
	private void handleCamera()
	{
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher()
		{
			@Override
			public boolean dispatchKeyEvent(KeyEvent event)
			{
				synchronized (WASDCameraPlugin.class)
				{
					switch (event.getID())
					{
						// On key press
						case KeyEvent.KEY_PRESSED:
							// If chatbox is enabled or at login screen, don't handle camera movement
							if (canType || robot == null)
							{
								break;
							}

							// Delete the last key press from chatbox if alphabet, numeric or whitespace
							if (Character.isAlphabetic(event.getKeyCode()) ||
									(Character.isDigit(event.getKeyCode()) ||
											Character.isWhitespace(event.getKeyCode())))
							{
								robot.keyPress(KeyEvent.VK_BACK_SPACE);
							}
							if (event.getKeyCode() == KeyEvent.VK_W)
							{
								robot.keyPress(KeyEvent.VK_UP);
							}
							if (event.getKeyCode() == KeyEvent.VK_A)
							{
								robot.keyPress(KeyEvent.VK_LEFT);
							}
							if (event.getKeyCode() == KeyEvent.VK_S)
							{
								robot.keyPress(KeyEvent.VK_DOWN);
							}
							if (event.getKeyCode() == KeyEvent.VK_D)
							{
								robot.keyPress(KeyEvent.VK_RIGHT);
							}
							break;

						// On key release
						case KeyEvent.KEY_RELEASED:
							// If enter was pressed, toggle chatbox state
							if (event.getKeyCode() == KeyEvent.VK_ENTER || event.getKeyCode() == KeyEvent.VK_TAB)
							{
								handleEnter();
							}

							// If chatbox is enabled or at login screen, don't handle camera movement
							if (canType || robot == null)
							{
								break;
							}
							if (event.getKeyCode() == KeyEvent.VK_W)
							{
								robot.keyRelease(KeyEvent.VK_UP);
							}
							if (event.getKeyCode() == KeyEvent.VK_A)
							{
								robot.keyRelease(KeyEvent.VK_LEFT);
							}
							if (event.getKeyCode() == KeyEvent.VK_S)
							{
								robot.keyRelease(KeyEvent.VK_DOWN);
							}
							if (event.getKeyCode() == KeyEvent.VK_D)
							{
								robot.keyRelease(KeyEvent.VK_RIGHT);
							}
							break;
					}
					return false;
				}
			}
		});
	}

	/**
	 * Handles what happens when hitting enter
	 */
	private void handleEnter()
	{
		if (robot == null)
		{
			return;
		}
		releaseAllKeys();
		canType = !canType;
	}

	/**
	 * Release any camera keys still left down upon hitting enter to avoid continuous camera movement
	 */
	private void releaseAllKeys()
	{
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}
}