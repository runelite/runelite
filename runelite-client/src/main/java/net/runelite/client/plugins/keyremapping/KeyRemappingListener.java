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
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

class KeyRemappingListener extends MouseAdapter implements KeyListener
{
	private static final Keybind ONE = new ModifierlessKeybind(KeyEvent.VK_1, 0);
	private static final Keybind TWO = new ModifierlessKeybind(KeyEvent.VK_2, 0);
	private static final Keybind THREE = new ModifierlessKeybind(KeyEvent.VK_3, 0);
	private static final Keybind FOUR = new ModifierlessKeybind(KeyEvent.VK_4, 0);
	private static final Keybind FIVE = new ModifierlessKeybind(KeyEvent.VK_5, 0);
	private static final Keybind SIX = new ModifierlessKeybind(KeyEvent.VK_6, 0);
	private static final Keybind SEVEN = new ModifierlessKeybind(KeyEvent.VK_7, 0);
	private static final Keybind EIGHT = new ModifierlessKeybind(KeyEvent.VK_8, 0);
	private static final Keybind NINE = new ModifierlessKeybind(KeyEvent.VK_9, 0);
	private static final Keybind ZERO = new ModifierlessKeybind(KeyEvent.VK_0, 0);
	private static final Keybind MINUS = new ModifierlessKeybind(KeyEvent.VK_MINUS, 0);
	private static final Keybind EQUALS = new ModifierlessKeybind(KeyEvent.VK_EQUALS, 0);

	@Inject
	private KeyRemappingPlugin plugin;

	@Inject
	private KeyRemappingConfig config;

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
			if (config.cameraRemap())
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
			}

			// In addition to the above checks, the F-key remapping shouldn't
			// activate when dialogs are open which listen for number keys
			// to select options
			if (config.fkeyRemap() && !plugin.isDialogOpen())
			{
				if (ONE.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F1);
					e.setKeyCode(KeyEvent.VK_F1);
				}
				else if (TWO.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F2);
					e.setKeyCode(KeyEvent.VK_F2);
				}
				else if (THREE.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F3);
					e.setKeyCode(KeyEvent.VK_F3);
				}
				else if (FOUR.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F4);
					e.setKeyCode(KeyEvent.VK_F4);
				}
				else if (FIVE.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F5);
					e.setKeyCode(KeyEvent.VK_F5);
				}
				else if (SIX.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F6);
					e.setKeyCode(KeyEvent.VK_F6);
				}
				else if (SEVEN.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F7);
					e.setKeyCode(KeyEvent.VK_F7);
				}
				else if (EIGHT.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F8);
					e.setKeyCode(KeyEvent.VK_F8);
				}
				else if (NINE.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F9);
					e.setKeyCode(KeyEvent.VK_F9);
				}
				else if (ZERO.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F10);
					e.setKeyCode(KeyEvent.VK_F10);
				}
				else if (MINUS.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F11);
					e.setKeyCode(KeyEvent.VK_F11);
				}
				else if (EQUALS.matches(e))
				{
					modified.put(e.getKeyCode(), KeyEvent.VK_F12);
					e.setKeyCode(KeyEvent.VK_F12);
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
				case KeyEvent.VK_ENTER:
				case KeyEvent.VK_ESCAPE:
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

			if (config.cameraRemap())
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
			}

			if (config.fkeyRemap())
			{
				if (ONE.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F1);
				}
				else if (TWO.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F2);
				}
				else if (THREE.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F3);
				}
				else if (FOUR.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F4);
				}
				else if (FIVE.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F5);
				}
				else if (SIX.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F6);
				}
				else if (SEVEN.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F7);
				}
				else if (EIGHT.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F8);
				}
				else if (NINE.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F9);
				}
				else if (ZERO.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F10);
				}
				else if (MINUS.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F11);
				}
				else if (EQUALS.matches(e))
				{
					e.setKeyCode(KeyEvent.VK_F12);
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
