/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.config;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import lombok.Getter;
import net.runelite.client.config.Mousebind;
import net.runelite.client.config.ModifierlessMousebind;
import net.runelite.client.ui.FontManager;

public class MousebindButton extends JButton
{
    @Getter
    private Mousebind value;

    public MousebindButton(Mousebind value, boolean modifierless)
    {
        // Disable focus traversal keys such as tab to allow tab key to be bound
        setFocusTraversalKeysEnabled(false);
        setFont(FontManager.getDefaultFont().deriveFont(12.f));
        setValue(value);
        // Capture bind on press, reset on left-click release
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                // Mouse buttons other than button1 don't give focus
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    // We have to use a mouse adapter instead of an action listener so the press action key (space) can be bound
                    setValue(Mousebind.NOT_SET);
                }
            }

            @Override
            public void mousePressed(MouseEvent me)
            {
                if (me.getButton() == MouseEvent.BUTTON1)
                {
                    return;
                }
                if (modifierless)
                {
                    setValue(new ModifierlessMousebind(me));
                }
                else
                {
                    setValue(new Mousebind(me));
                }
            }
        });
    }

    public void setValue(Mousebind value)
    {
        if (value == null)
        {
            value = Mousebind.NOT_SET;
        }

        this.value = value;
        setText(value.toString());
    }

}
