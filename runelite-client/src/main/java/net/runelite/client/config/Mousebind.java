/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2025, Leif
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
import java.awt.event.MouseEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Mousebind
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

	public static final Mousebind NOT_SET = new Mousebind(MouseEvent.NOBUTTON, 0);

	public static final Mousebind CTRL = new Mousebind(MouseEvent.NOBUTTON, InputEvent.CTRL_DOWN_MASK);
	public static final Mousebind ALT = new Mousebind(MouseEvent.NOBUTTON, InputEvent.ALT_DOWN_MASK);
	public static final Mousebind SHIFT = new Mousebind(MouseEvent.NOBUTTON, InputEvent.SHIFT_DOWN_MASK);

	private final int mouseButton;
	private final int modifiers;

	protected Mousebind(int mouseButton, int modifiers, boolean ignoreModifiers)
	{
		modifiers &= KEYBOARD_MODIFIER_MASK;

		if (ignoreModifiers && mouseButton != MouseEvent.NOBUTTON)
		{
			modifiers = 0;
		}

		this.mouseButton = mouseButton;
		this.modifiers = modifiers;
	}

	public Mousebind(int mouseButton, int modifiers)
	{
		this(mouseButton, modifiers, false);
	}

	/**
	 * Constructs a mousebind that matches the passed MouseEvent
	 */
	public Mousebind(MouseEvent me)
	{
		this(me.getButton(), me.getModifiersEx());

		assert matches(me);
	}

	/**
	 * Returns true if the given MouseEvent matches this Mousebind.
	 * Typically used to check if a mouse button (with optional modifiers)
	 * was pressed or released in accordance with this bind.
	 */
	public boolean matches(MouseEvent me)
	{
		return matches(me, false);
	}

	protected boolean matches(MouseEvent me, boolean ignoreModifiers)
	{
		if (NOT_SET.equals(this))
		{
			return false;
		}

		int mouseButton = me.getButton();
		int modifiers = me.getModifiersEx() & KEYBOARD_MODIFIER_MASK;

		if (ignoreModifiers && mouseButton != MouseEvent.NOBUTTON)
		{
			return this.mouseButton == mouseButton;
		}

		return this.mouseButton == mouseButton && this.modifiers == modifiers;
	}

	@Override
	public String toString()
	{
		if (mouseButton == MouseEvent.NOBUTTON && modifiers == 0)
		{
			return "Not set";
		}

		String button;
		if (mouseButton == MouseEvent.NOBUTTON)
		{
			button = "";
		}
		else
		{
			button = getMouseButtonText(mouseButton);
		}

		String mod = "";
		if (modifiers != 0)
		{
			mod = InputEvent.getModifiersExText(modifiers);
		}

		if (mod.isEmpty() && button.isEmpty())
		{
			return "Not set";
		}
		if (!mod.isEmpty() && !button.isEmpty())
		{
			return mod + "+" + button;
		}
		if (mod.isEmpty())
		{
			return button;
		}
		return mod;
	}

	private static String getMouseButtonText(int button)
	{
		if (button == MouseEvent.BUTTON1)
		{
			return "Left Click";
		}
		else if (button == MouseEvent.BUTTON2)
		{ return "Middle Click";
		}
		else if (button == MouseEvent.BUTTON3)
		{
			return "Right Click";
		}
		else
		{
			return "Button " + button;
		}
	}

}
