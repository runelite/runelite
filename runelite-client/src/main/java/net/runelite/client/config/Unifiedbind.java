/*
 * Copyright (c) 2018 Abex
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

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.annotation.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * A combination of zero or more modifier keys (Ctrl, alt, shift, meta)
 * and an optional non-modifier key
 */
@Getter
@EqualsAndHashCode
public class Unifiedbind
{
    public enum Type
    {
        KEYBOARD,
        MOUSE
    }

    private static final BiMap<Integer, Integer> MODIFIER_TO_KEY_CODE = new ImmutableBiMap.Builder<Integer, Integer>()
            .put(InputEvent.CTRL_DOWN_MASK, KeyEvent.VK_CONTROL)
            .put(InputEvent.ALT_DOWN_MASK, KeyEvent.VK_ALT)
            .put(InputEvent.SHIFT_DOWN_MASK, KeyEvent.VK_SHIFT)
            .put(InputEvent.META_DOWN_MASK, KeyEvent.VK_META)
            .build();

    // Bitmask of all supported modifiers
    private static final int KEYBOARD_MODIFIER_MASK = MODIFIER_TO_KEY_CODE.keySet().stream()
            .reduce((a, b) -> a | b).get();

    // Static modifier variants for key binds
    public static final Unifiedbind NOT_SET = new Unifiedbind(KeyEvent.VK_UNDEFINED, 0);

    public static final Unifiedbind CTRL = new Unifiedbind(KeyEvent.VK_UNDEFINED, InputEvent.CTRL_DOWN_MASK);
    public static final Unifiedbind ALT = new Unifiedbind(KeyEvent.VK_UNDEFINED, InputEvent.ALT_DOWN_MASK);
    public static final Unifiedbind SHIFT = new Unifiedbind(KeyEvent.VK_UNDEFINED, InputEvent.SHIFT_DOWN_MASK);

    private final Type type;
    private final int code;
    private final int modifiers;

    protected Unifiedbind(Type type, int code, int modifiers, boolean ignoreModifiers)
    {
        modifiers &= KEYBOARD_MODIFIER_MASK;

        // If the Unifiedbind is just modifiers we don't want the keyCode to contain the modifier too,
        // because this breaks if you do the keycode backwards
        if (type == Type.KEYBOARD)
        {
            Integer mf = getModifierForKeyCode(code);
            if (mf != null)
            {
                assert (modifiers & mf) != 0;
                code = KeyEvent.VK_UNDEFINED;
            }

            if (ignoreModifiers && (code != KeyEvent.VK_UNDEFINED))
            {
                modifiers = 0;
            }
        }
        else if (type == Type.MOUSE)
        {
            if (ignoreModifiers && code != MouseEvent.NOBUTTON)
            {
                modifiers = 0;
            }
        }

        this.type = type;
        this.code = code;
        this.modifiers = modifiers;
    }

    /**
     * Legacy constructor for Unifiedbinds without a type declaration
     */
    public Unifiedbind(int keyCode, int modifiers)
    {
        this(Type.KEYBOARD, keyCode, modifiers, false);
    }

    /**
     * Constructor for binds with type declaration (for mouse binds)
     */
    public Unifiedbind(Type type, int code, int modifiers)
    {
        this(type, code, modifiers, false);
    }

    /**
     * Constructs a Unifiedbind that matches the passed KeyEvent
     */
    public Unifiedbind(KeyEvent e)
    {
        this(Type.KEYBOARD, e.getExtendedKeyCode(), e.getModifiersEx(), false);

        assert matches(e);
    }

    /**
     * Constructs a Unifiedbind that matches the passed MouseEvent
     */
    public Unifiedbind(MouseEvent me)
    {
        this(Type.MOUSE, me.getButton(), me.getModifiersEx(), false);

        assert matches(me);
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
                return this.code == keyCode;
            }
            else if (mf != null)
            {
                return this.code == keyCode && (this.modifiers & modifiers) == this.modifiers && ((mf & this.modifiers) == mf);
            }
        }

        if (ignoreModifiers && keyCode != KeyEvent.VK_UNDEFINED)
        {
            return this.code == keyCode;
        }

        return this.code == keyCode && this.modifiers == modifiers;
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
            return this.code == mouseButton;
        }

        return this.code == mouseButton && this.modifiers == modifiers;
    }

    @Override
    public String toString()
    {
        boolean undefined = (type == Type.KEYBOARD && code == KeyEvent.VK_UNDEFINED) || (type == Type.MOUSE && code == MouseEvent.NOBUTTON);

        if (undefined && modifiers == 0)
        {
            return "Not set";
        }

        String input;
        if (undefined)
        {
            input = "";
        }
        else if (type == Type.KEYBOARD)
        {
            input = KeyEvent.getKeyText(code);
        }
        else
        {
            input = getMouseButtonText(code);
        }

        String mod = "";
        if (modifiers != 0)
        {
            mod = InputEvent.getModifiersExText(modifiers);
        }

        if (mod.isEmpty() && input.isEmpty())
        {
            return "Not set";
        }
        if (!mod.isEmpty() && !input.isEmpty())
        {
            return mod + "+" + input;
        }
        if (mod.isEmpty())
        {
            return input;
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
        {
            return "Middle Click";
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

    @Nullable
    public static Integer getModifierForKeyCode(int keyCode)
    {
        return MODIFIER_TO_KEY_CODE.inverse().get(keyCode);
    }
}