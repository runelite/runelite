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
package net.runelite.client.plugins.keyremapping;

import com.google.common.base.Strings;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

@Singleton
class KeyRemappingListener extends MouseAdapter implements KeyListener
{

	@Inject
	private KeyRemappingPlugin plugin;

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
		if (client.getGameState() == GameState.LOGIN_SCREEN || !plugin.chatboxFocused())
		{
			return;
		}

		if (!plugin.isTyping())
		{
			if (plugin.isCameraRemap())
			{
				if (plugin.getUp().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_UP);
					e.setKeyCode(KeyEvent.VK_UP);
				}
				else if (plugin.getDown().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_DOWN);
					e.setKeyCode(KeyEvent.VK_DOWN);
				}
				else if (plugin.getLeft().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_LEFT);
					e.setKeyCode(KeyEvent.VK_LEFT);
				}
				else if (plugin.getRight().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_RIGHT);
					e.setKeyCode(KeyEvent.VK_RIGHT);
				}
			}

			// In addition to the above checks, the F-key remapping shouldn't
			// activate when dialogs are open which listen for number keys
			// to select options
			if (plugin.isFkeyRemap() && !plugin.isDialogOpen())
			{
				if (plugin.getF1().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F1);
					e.setKeyCode(KeyEvent.VK_F1);
				}
				else if (plugin.getF2().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F2);
					e.setKeyCode(KeyEvent.VK_F2);
				}
				else if (plugin.getF3().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F3);
					e.setKeyCode(KeyEvent.VK_F3);
				}
				else if (plugin.getF4().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F4);
					e.setKeyCode(KeyEvent.VK_F4);
				}
				else if (plugin.getF5().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F5);
					e.setKeyCode(KeyEvent.VK_F5);
				}
				else if (plugin.getF6().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F6);
					e.setKeyCode(KeyEvent.VK_F6);
				}
				else if (plugin.getF7().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F7);
					e.setKeyCode(KeyEvent.VK_F7);
				}
				else if (plugin.getF8().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F8);
					e.setKeyCode(KeyEvent.VK_F8);
				}
				else if (plugin.getF9().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F9);
					e.setKeyCode(KeyEvent.VK_F9);
				}
				else if (plugin.getF10().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F10);
					e.setKeyCode(KeyEvent.VK_F10);
				}
				else if (plugin.getF11().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F11);
					e.setKeyCode(KeyEvent.VK_F11);
				}
				else if (plugin.getF12().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F12);
					e.setKeyCode(KeyEvent.VK_F12);
				}
				else if (plugin.getEsc().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_ESCAPE);
					e.setKeyCode(KeyEvent.VK_ESCAPE);
				}
				else if (plugin.getCtrl().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_CONTROL);
					e.setKeyCode(KeyEvent.VK_CONTROL);
				}
				else if (plugin.getAlt().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_ALT);
					e.setKeyCode(KeyEvent.VK_ALT);
				}
				else if (plugin.getShift().matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_SHIFT);
					e.setKeyCode(KeyEvent.VK_SHIFT);
				}
			}

			switch (e.getKeyCode())
			{
				case KeyEvent.VK_ENTER:
				case KeyEvent.VK_SLASH:
				case KeyEvent.VK_COLON:
					// refocus chatbox
					plugin.setTyping(true);
					clientThread.invoke(plugin::unlockChat);
					break;
			}

		}
		else
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_ESCAPE:
					// When exiting typing mode, block the escape key
					// so that it doesn't trigger the in-game hotkeys
					e.consume();
					plugin.setTyping(false);
					clientThread.invoke(() ->
					{
						client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
						plugin.lockChat();
					});
					break;
				case KeyEvent.VK_ENTER:
					plugin.setTyping(false);
					clientThread.invoke(plugin::lockChat);
					break;
				case KeyEvent.VK_BACK_SPACE:
					// Only lock chat on backspace when the typed text is now empty
					if (Strings.isNullOrEmpty(client.getVar(VarClientStr.CHATBOX_TYPED_TEXT)))
					{
						plugin.setTyping(false);
						clientThread.invoke(plugin::lockChat);
					}
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			return;
		}

		if (plugin.chatboxFocused() && !plugin.isTyping())
		{
			modified.remove(e.getKeyCode());

			if (plugin.isCameraRemap())
			{
				if (plugin.getUp().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_UP);
				}
				else if (plugin.getDown().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_DOWN);
				}
				else if (plugin.getLeft().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_LEFT);
				}
				else if (plugin.getRight().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_RIGHT);
				}
			}

			if (plugin.isFkeyRemap())
			{
				if (plugin.getF1().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F1);
				}
				else if (plugin.getF2().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F2);
				}
				else if (plugin.getF3().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F3);
				}
				else if (plugin.getF4().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F4);
				}
				else if (plugin.getF5().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F5);
				}
				else if (plugin.getF6().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F6);
				}
				else if (plugin.getF7().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F7);
				}
				else if (plugin.getF8().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F8);
				}
				else if (plugin.getF9().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F9);
				}
				else if (plugin.getF10().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F10);
				}
				else if (plugin.getF11().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F11);
				}
				else if (plugin.getF12().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F12);
				}
				else if (plugin.getEsc().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_ESCAPE);
				}
				else if (plugin.getCtrl().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_CONTROL);
				}
				else if (plugin.getAlt().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_ALT);
				}
				else if (plugin.getShift().matches(e))
				{
					e.setKeyCode(KeyEvent.VK_SHIFT);
				}
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
