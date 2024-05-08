/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.client.config;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.KEY_PRESSED;
import static java.awt.event.KeyEvent.KEY_RELEASED;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_SHIFT;
import static java.awt.event.KeyEvent.VK_UNDEFINED;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class KeybindTest
{
	/**
	 * Regression test for a bug where a modifier key keybind will not match key release if other modifiers are held down.
	 */
	@Test
	public void testModifierOnlyKeybindReleaseWithOtherModifierKeyHeldDown()
	{
		Keybind keybind = new Keybind(VK_CONTROL, CTRL_DOWN_MASK);

		// when a modifier key is pressed, the keyevent will have the modifier in the modifiers field and in the keyCode field.
		// when it is released, it will only be in the keyCode field.
		Assert.assertTrue(keybind.matches(createKeyEvent(KEY_PRESSED, CTRL_DOWN_MASK, VK_CONTROL)));
		Assert.assertFalse(keybind.matches(createKeyEvent(KEY_PRESSED, SHIFT_DOWN_MASK | CTRL_DOWN_MASK, VK_SHIFT)));
		Assert.assertTrue(keybind.matches(createKeyEvent(KEY_RELEASED, SHIFT_DOWN_MASK, VK_CONTROL)));
		Assert.assertFalse(keybind.matches(createKeyEvent(KEY_RELEASED, 0, VK_SHIFT)));
	}

	@Test
	public void testUnknownKey()
	{
		Keybind keybind = new Keybind(VK_UNDEFINED, CTRL_DOWN_MASK);
		keybind.matches(createKeyEvent(KEY_RELEASED, 0, VK_UNDEFINED));
	}

	private KeyEvent createKeyEvent(int id, int modifiersEx, int extendedKeyCode)
	{
		KeyEvent mock = Mockito.mock(KeyEvent.class);
		Mockito.when(mock.getExtendedKeyCode()).thenReturn(extendedKeyCode);
		Mockito.when(mock.getModifiersEx()).thenReturn(modifiersEx);
		Mockito.when(mock.getID()).thenReturn(id);
		return mock;
	}
}
