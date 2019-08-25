/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.util;

import java.awt.event.KeyEvent;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import net.runelite.client.config.Keybind;
import net.runelite.client.input.KeyListener;

@RequiredArgsConstructor
public abstract class HotkeyListener implements KeyListener
{
	private final Supplier<Keybind> keybind;

	private boolean isPressed = false;

	private boolean isConsumingTyped = false;

	@Override
	public void keyTyped(KeyEvent e)
	{
		if (isConsumingTyped)
		{
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (keybind.get().matches(e))
		{
			boolean wasPressed = isPressed;
			isPressed = true;
			if (!wasPressed)
			{
				hotkeyPressed();
			}
			if (Keybind.getModifierForKeyCode(e.getKeyCode()) == null)
			{
				isConsumingTyped = true;
				// Only consume non modifier keys
				e.consume();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (keybind.get().matches(e))
		{
			if (isPressed)
			{
				hotkeyReleased();
			}
			isPressed = false;
			isConsumingTyped = false;
		}
	}

	public void hotkeyPressed()
	{
	}

	public void hotkeyReleased()
	{
	}
}
