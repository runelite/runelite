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

import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.VarClientStr;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

class WASDCameraListener extends MouseListener implements KeyListener
{
	@Inject
	private WASDCameraPlugin plugin;

	@Inject
	private WASDCameraConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Override
	public void keyTyped(KeyEvent e)
	{
		handleKey(e);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!plugin.chatboxFocused())
		{
			return;
		}

		if (!plugin.isTyping())
		{
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
			else
			{
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_ENTER:
					case KeyEvent.VK_SLASH:
						// refocus chatbox
						clientThread.invoke(() ->
						{
							plugin.unlockChat();
						});
						break;
					case KeyEvent.VK_F1:
					case KeyEvent.VK_F2:
					case KeyEvent.VK_F3:
					case KeyEvent.VK_F4:
					case KeyEvent.VK_F5:
					case KeyEvent.VK_F6:
					case KeyEvent.VK_F7:
					case KeyEvent.VK_F8:
					case KeyEvent.VK_F9:
					case KeyEvent.VK_F10:
					case KeyEvent.VK_F11:
					case KeyEvent.VK_F12:
					case KeyEvent.VK_UP:
					case KeyEvent.VK_DOWN:
					case KeyEvent.VK_LEFT:
					case KeyEvent.VK_RIGHT:
					case KeyEvent.VK_SHIFT:
					case KeyEvent.VK_ESCAPE:
						break;
					default:
						e.consume();
						break;

				}
			}
		}
		else
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_ENTER:
					clientThread.invoke(() ->
					{
						plugin.lockChat();
					});
					break;
				case KeyEvent.VK_ESCAPE:
					clientThread.invoke(() ->
					{
						client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
						plugin.lockChat();
					});
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		handleKey(e);
	}

	private void handleKey(KeyEvent e)
	{
		if (!plugin.chatboxFocused())
		{
			return;
		}

		if (!plugin.isTyping())
		{
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
			else
			{
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_F1:
					case KeyEvent.VK_F2:
					case KeyEvent.VK_F3:
					case KeyEvent.VK_F4:
					case KeyEvent.VK_F5:
					case KeyEvent.VK_F6:
					case KeyEvent.VK_F7:
					case KeyEvent.VK_F8:
					case KeyEvent.VK_F9:
					case KeyEvent.VK_F10:
					case KeyEvent.VK_F11:
					case KeyEvent.VK_F12:
					case KeyEvent.VK_UP:
					case KeyEvent.VK_DOWN:
					case KeyEvent.VK_LEFT:
					case KeyEvent.VK_RIGHT:
					case KeyEvent.VK_SHIFT:
					case KeyEvent.VK_ESCAPE:
						break;
					default:
						e.consume();
						break;
				}
			}
		}
	}
}
