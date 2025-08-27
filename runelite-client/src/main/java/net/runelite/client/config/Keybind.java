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
package net.runelite.client.config;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.annotation.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * A combination of zero or more modifier keys (Ctrl, alt, shift, meta)
 * and an optional non-modifier key
 */
@Getter
@EqualsAndHashCode
public class Keybind
{
	private static final BiMap<Integer, Integer> MODIFIER_TO_KEY_CODE = new ImmutableBiMap.Builder<Integer, Integer>()
		.put(InputEvent.CTRL_DOWN_MASK, KeyEvent.VK_CONTROL)
		.put(InputEvent.ALT_DOWN_MASK, KeyEvent.VK_ALT)
		.put(InputEvent.SHIFT_DOWN_MASK, KeyEvent.VK_SHIFT)
		.put(InputEvent.META_DOWN_MASK, KeyEvent.VK_META)
		.build();

	// Bitmask of all supported modifiers
	private static final int KEYBOARD_MODIFIER_MASK = MODIFIER_TO_KEY_CODE.keySet().stream()
		.reduce((a, b) -> a | b).get();

	public static final Keybind NOT_SET = new Keybind(KeyEvent.VK_UNDEFINED, 0);

	public static final Keybind CTRL = new Keybind(KeyEvent.VK_UNDEFINED, InputEvent.CTRL_DOWN_MASK);
	public static final Keybind ALT = new Keybind(KeyEvent.VK_UNDEFINED, InputEvent.ALT_DOWN_MASK);
	public static final Keybind SHIFT = new Keybind(KeyEvent.VK_UNDEFINED, InputEvent.SHIFT_DOWN_MASK);

	private final int keyCode;
	private final int modifiers;

	protected Keybind(int keyCode, int modifiers, boolean ignoreModifiers)
	{
		modifiers &= KEYBOARD_MODIFIER_MASK;

		// If the keybind is just modifiers we don't want the keyCode to contain the modifier too,
		// because this breaks if you do the keycode backwards
		Integer mf = getModifierForKeyCode(keyCode);
		if (mf != null)
		{
			assert (modifiers & mf) != 0;
			keyCode = KeyEvent.VK_UNDEFINED;
		}

		if (ignoreModifiers && keyCode != KeyEvent.VK_UNDEFINED)
		{
			modifiers = 0;
		}

		this.keyCode = keyCode;
		this.modifiers = modifiers;
	}

	public Keybind(int keyCode, int modifiers)
	{
		this(keyCode, modifiers, false);
	}

	/**
	 * Constructs a keybind with that matches the passed KeyEvent
	 */
	public Keybind(KeyEvent e)
	{
		this(e.getExtendedKeyCode(), e.getModifiersEx());

		assert matches(e);
	}

	/**
	 * If the KeyEvent is from a KeyPressed event this returns if the
	 * Event is this hotkey being pressed. If the KeyEvent is a
	 * KeyReleased event this returns if the event is this hotkey being
	 * released
	 */
	public boolean matches(KeyEvent e)
	{
		return matches(e, false);
	}

	protected boolean matches(KeyEvent e, boolean ignoreModifiers)
	{
		if (NOT_SET.equals(this))
		{
			return false;
		}

		int keyCode = e.getExtendedKeyCode();
		int modifiers = e.getModifiersEx() & KEYBOARD_MODIFIER_MASK;

		Integer mf = getModifierForKeyCode(keyCode);
		if (mf != null)
		{
			modifiers |= mf;
			keyCode = KeyEvent.VK_UNDEFINED;
		}

		if (e.getID() == KeyEvent.KEY_RELEASED)
		{
			if (keyCode != KeyEvent.VK_UNDEFINED)
			{
				return this.keyCode == keyCode;
			}
			else if (mf != null)
			{
				return this.keyCode == keyCode && (this.modifiers & modifiers) == this.modifiers && ((mf & this.modifiers) == mf);
			}
		}

		if (ignoreModifiers && keyCode != KeyEvent.VK_UNDEFINED)
		{
			return this.keyCode == keyCode;
		}

		return this.keyCode == keyCode && this.modifiers == modifiers;
	}

	@Override
	public String toString()
	{
		if (keyCode == KeyEvent.VK_UNDEFINED && modifiers == 0)
		{
			return "Not set";
		}

		String key;
		if (keyCode == KeyEvent.VK_UNDEFINED)
		{
			key = "";
		}
		else
		{
			key = KeyEvent.getKeyText(keyCode);
		}

		String mod = "";
		if (modifiers != 0)
		{
			mod = InputEvent.getModifiersExText(modifiers);
		}

		if (mod.isEmpty() && key.isEmpty())
		{
			return "Not set";
		}
		if (!mod.isEmpty() && !key.isEmpty())
		{
			return mod + "+" + key;
		}
		if (mod.isEmpty())
		{
			return key;
		}
		return mod;
	}

	@Nullable
	public static Integer getModifierForKeyCode(int keyCode)
	{
		return MODIFIER_TO_KEY_CODE.inverse().get(keyCode);
	}
}
