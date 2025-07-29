/*
 * Copyright (c) 2019 Abex
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

import java.awt.event.MouseEvent;

public class ModifierlessMousebind extends Mousebind
{
	// Modifiers are ignored in this case for matching
	public ModifierlessMousebind(int mouseButton, int modifiers)
	{
		super(mouseButton, modifiers, true);
	}

	/**
	 * Constructs a mousebind that matches the passed MouseEvent
	 */
	public ModifierlessMousebind(MouseEvent me)
	{
		this(me.getButton(), me.getModifiersEx());

		assert matches(me);
	}

	/**
	 * Returns true if the given MouseEvent matches this Mousebind.
	 * Typically used to check if a mouse button (with optional modifiers)
	 * was pressed or released in accordance with this bind.
	 */
	@Override
	public boolean matches(MouseEvent me)
	{
		return matches(me, true);
	}
}
