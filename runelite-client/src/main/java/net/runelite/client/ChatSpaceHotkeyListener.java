/*
 * Copyright (c) 2024, RuneLite
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
package net.runelite.client;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;

/**
 * Remaps a configurable key to Space when a chat dialog (e.g. "Click here to continue") is open.
 * This only activates during dialogs — never while the player is typing in the chatbox.
 */
@Singleton
public class ChatSpaceHotkeyListener implements KeyListener
{
	private final Client client;
	private final RuneLiteConfig config;

	private final Map<Integer, Integer> modified = new HashMap<>();
	private final Set<Character> blockedChars = new HashSet<>();

	@Inject
	ChatSpaceHotkeyListener(Client client, RuneLiteConfig config, KeyManager keyManager)
	{
		this.client = client;
		this.config = config;
		keyManager.registerKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		final char keyChar = e.getKeyChar();
		if (keyChar != KeyEvent.CHAR_UNDEFINED && blockedChars.contains(keyChar))
		{
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!isDialogOpen() || isOptionsDialogOpen())
		{
			return;
		}

		if (config.spaceHotkey().matches(e))
		{
			final int mappedKeyCode = KeyEvent.VK_SPACE;
			if (mappedKeyCode != e.getKeyCode())
			{
				final char keyChar = e.getKeyChar();
				modified.put(e.getKeyCode(), mappedKeyCode);
				e.setKeyCode(mappedKeyCode);
				e.setKeyChar(KeyEvent.CHAR_UNDEFINED);
				if (keyChar != KeyEvent.CHAR_UNDEFINED)
				{
					blockedChars.add(keyChar);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		final int keyCode = e.getKeyCode();
		final char keyChar = e.getKeyChar();

		if (keyChar != KeyEvent.CHAR_UNDEFINED)
		{
			blockedChars.remove(keyChar);
		}

		final Integer mappedKeyCode = modified.remove(keyCode);
		if (mappedKeyCode != null)
		{
			e.setKeyCode(mappedKeyCode);
			e.setKeyChar(KeyEvent.CHAR_UNDEFINED);
		}
	}

	/**
	 * Returns true when a "click here to continue" style chat dialog is open.
	 * This mirrors the logic in KeyRemappingPlugin.isDialogOpen().
	 */
	private boolean isDialogOpen()
	{
		return isHidden(InterfaceID.Chatbox.MES_LAYER_HIDE) || isHidden(InterfaceID.Chatbox.CHATDISPLAY)
			|| !isHidden(InterfaceID.BankpinKeypad.UNIVERSE);
	}

	/**
	 * Returns true when the NPC/player options dialog (choose 1, 2, 3 …) is open.
	 * We skip space-remapping in this state so the configured key can still
	 * select a numeric option normally.
	 */
	private boolean isOptionsDialogOpen()
	{
		return client.getWidget(InterfaceID.Chatmenu.OPTIONS) != null;
	}

	private boolean isHidden(int componentId)
	{
		Widget w = client.getWidget(componentId);
		return w == null || w.isSelfHidden();
	}
}
