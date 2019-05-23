/*
 * Copyright (c) 2018, Robb <rla@navadrag.com>
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
package net.runelite.client.plugins.fnkeyremapping;

import com.google.common.base.Strings;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

class FnKeyRemappingListener extends MouseAdapter implements KeyListener
{
	@Inject
	private FnKeyRemappingPlugin plugin;

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
			if (one().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F1);
				e.setKeyCode(KeyEvent.VK_F1);
			}
			else if (two().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F2);
				e.setKeyCode(KeyEvent.VK_F2);
			}
			else if (three().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F3);
				e.setKeyCode(KeyEvent.VK_F3);
			}
			else if (four().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F4);
				e.setKeyCode(KeyEvent.VK_F4);
			}
			else if (five().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F5);
				e.setKeyCode(KeyEvent.VK_F5);
			}
			else if (six().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F6);
				e.setKeyCode(KeyEvent.VK_F6);
			}
			else if (seven().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F7);
				e.setKeyCode(KeyEvent.VK_F7);
			}
			else if (eight().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F8);
				e.setKeyCode(KeyEvent.VK_F8);
			}
			else if (nine().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F9);
				e.setKeyCode(KeyEvent.VK_F9);
			}
			else if (ten().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F10);
				e.setKeyCode(KeyEvent.VK_F10);
			}
			else if (eleven().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F11);
				e.setKeyCode(KeyEvent.VK_F11);
			}
			else if (twelve().matches(e))
			{
				modified.put(e.getKeyCode(), KeyEvent.VK_F12);
				e.setKeyCode(KeyEvent.VK_F12);
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
			if (one().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F1);
			}
			else if (two().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F2);
			}
			else if (three().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F3);
			}
			else if (four().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F4);
			}
			else if (five().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F5);
			}
			else if (six().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F6);
			}
			else if (seven().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F7);
			}
			else if (eight().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F8);
			}
			else if (nine().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F9);
			}
			else if (ten().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F10);
			}
			else if (eleven().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F11);
			}
			else if (twelve().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F12);
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


	private ModifierlessKeybind one()
	{
		return new ModifierlessKeybind(KeyEvent.VK_1, 0);
	}
	private ModifierlessKeybind two()
	{
		return new ModifierlessKeybind(KeyEvent.VK_2, 0);
	}
	private ModifierlessKeybind three()
	{
		return new ModifierlessKeybind(KeyEvent.VK_3, 0);
	}
	private ModifierlessKeybind four()
	{
		return new ModifierlessKeybind(KeyEvent.VK_4, 0);
	}
	private ModifierlessKeybind five()
	{
		return new ModifierlessKeybind(KeyEvent.VK_5, 0);
	}
	private ModifierlessKeybind six()
{
	return new ModifierlessKeybind(KeyEvent.VK_6, 0);
}
	private ModifierlessKeybind seven() { return new ModifierlessKeybind(KeyEvent.VK_7, 0); }
	private ModifierlessKeybind eight()
	{
		return new ModifierlessKeybind(KeyEvent.VK_8, 0);
	}
	private ModifierlessKeybind nine()
	{
		return new ModifierlessKeybind(KeyEvent.VK_9, 0);
	}
	private ModifierlessKeybind ten()
	{
		return new ModifierlessKeybind(KeyEvent.VK_0, 0);
	}
	private ModifierlessKeybind eleven()
	{
		return new ModifierlessKeybind(KeyEvent.VK_MINUS, 0);
	}
	private ModifierlessKeybind twelve() { return new ModifierlessKeybind(KeyEvent.VK_EQUALS, 0); }



}
