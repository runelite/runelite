package net.runelite.client.config;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.KEY_PRESSED;
import static java.awt.event.KeyEvent.KEY_RELEASED;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_SHIFT;
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

	private KeyEvent createKeyEvent(int id, int modifiersEx, int extendedKeyCode)
	{
		KeyEvent mock = Mockito.mock(KeyEvent.class);
		Mockito.when(mock.getExtendedKeyCode()).thenReturn(extendedKeyCode);
		Mockito.when(mock.getModifiersEx()).thenReturn(modifiersEx);
		Mockito.when(mock.getID()).thenReturn(id);
		return mock;
	}
}
