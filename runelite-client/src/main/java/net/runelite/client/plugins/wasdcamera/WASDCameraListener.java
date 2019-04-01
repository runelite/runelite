/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.google.common.base.Strings;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

class WASDCameraListener extends MouseAdapter implements KeyListener
{
	@Inject
	private WASDCameraPlugin plugin;

	@Inject
	private WASDCameraConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	private final Map<Integer, Integer> modified = new HashMap<>();

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !plugin.chatboxFocused())
		{
			return;
		}

		if (!plugin.isTyping())
		{
			if (config.up().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_UP);
				e.setKeyCode(KeyEvent.VK_UP);
			}
			else if (config.down().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_DOWN);
				e.setKeyCode(KeyEvent.VK_DOWN);
			}
			else if (config.left().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_LEFT);
				e.setKeyCode(KeyEvent.VK_LEFT);
			}
			else if (config.right().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_RIGHT);
				e.setKeyCode(KeyEvent.VK_RIGHT);
			}
			else
			{
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_ENTER:
					case KeyEvent.VK_SLASH:
					case KeyEvent.VK_COLON:
						// refocus chatbox
						plugin.setTyping(true);
						clientThread.invoke(() ->
						{
							plugin.unlockChat();
						});
						break;
				}
			}
		}
		else
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_ENTER:
					plugin.setTyping(false);
					clientThread.invoke(() ->
					{
						plugin.lockChat();
					});
					break;
				case KeyEvent.VK_ESCAPE:
					plugin.setTyping(false);
					clientThread.invoke(() ->
					{
						client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
						plugin.lockChat();
					});
					break;
				case KeyEvent.VK_BACK_SPACE:
					if (Strings.isNullOrEmpty(client.getVar(VarClientStr.CHATBOX_TYPED_TEXT)))
					{
						plugin.setTyping(false);
						clientThread.invoke(() -> plugin.lockChat());
					}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (plugin.chatboxFocused() && !plugin.isTyping())
		{
			modified.remove(e.getKeyCode());

			if (config.up().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_UP);
			}
			else if (config.down().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_DOWN);
			}
			else if (config.left().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_LEFT);
			}
			else if (config.right().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_RIGHT);
			}
		}
		else
		{
			// press d + enter + release d - causes the right arrow to never be released
			Integer m = modified.get(e.getKeyCode());
			if (m != null)
			{
				modified.remove(e.getKeyCode());
				e.setKeyCode(m);
			}
		}
	}
}
