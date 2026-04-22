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

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.KeyCode;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.RuneLiteConfig;

/**
 * Tracks whether the configurable "shift hotkey" is currently pressed.
 * By default this is the Shift key, but it can be rebound to Ctrl or Alt
 * via the RuneLite "Shift hotkey" setting under Overlay settings.
 */
@Singleton
public class ShiftHotkeyManager
{
	@Inject
	private Client client;

	@Inject
	private RuneLiteConfig config;

	/**
	 * Returns true if the configured shift hotkey is currently held down.
	 */
	public boolean isPressed()
	{
		final Keybind hotkey = config.shiftHotkey();
		if (hotkey == null)
		{
			return client.isKeyPressed(KeyCode.KC_SHIFT);
		}
		if (Keybind.NOT_SET.equals(hotkey))
		{
			return false;
		}

		// Modifier-only keybinds (Shift, Ctrl, Alt)
		if (hotkey.getKeyCode() == KeyEvent.VK_UNDEFINED)
		{
			final int mods = hotkey.getModifiers();
			if ((mods & InputEvent.SHIFT_DOWN_MASK) != 0)
			{
				return client.isKeyPressed(KeyCode.KC_SHIFT);
			}
			if ((mods & InputEvent.CTRL_DOWN_MASK) != 0)
			{
				return client.isKeyPressed(KeyCode.KC_CONTROL);
			}
			if ((mods & InputEvent.ALT_DOWN_MASK) != 0)
			{
				return client.isKeyPressed(KeyCode.KC_ALT);
			}
		}

		// Fall back to Shift for unrecognised keybinds
		return client.isKeyPressed(KeyCode.KC_SHIFT);
	}
}
