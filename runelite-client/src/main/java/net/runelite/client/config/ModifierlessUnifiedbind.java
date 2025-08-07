/*
 * Copyright (c) 2019 Abex
 * Copyright (c) 2025 Leif
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

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ModifierlessUnifiedbind extends Unifiedbind
{
    /**
     * Constructs a modifierless bind based on type, code, and modifiers for completeness
     */
    public ModifierlessUnifiedbind(Type type, int code, int modifiers)
    {
        super(type, code, modifiers, true);
    }

    /**
     * Constructs a modifierless bind based on type and code to simplify usage
     */
    public ModifierlessUnifiedbind(Type type, int code)
    {
        super(type, code, 0, true);
    }

    /**
     * Constructs a Unifiedbind with that matches the passed KeyEvent
     */
    public ModifierlessUnifiedbind(KeyEvent ke)
    {
        this(Type.KEYBOARD, ke.getExtendedKeyCode(), ke.getModifiersEx());

        assert matches(ke);
    }

    public ModifierlessUnifiedbind(MouseEvent me)
    {
        this(Type.MOUSE, me.getButton());

        assert matches(me);
    }

    /**
     * If the KeyEvent is from a KeyPressed event this returns if the
     * Event is this hotkey being pressed. If the KeyEvent is a
     * KeyReleased event this returns if the event is this hotkey being
     * released
     */
    @Override
    public boolean matches(KeyEvent ke)
    {
        return matches(ke, true);
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