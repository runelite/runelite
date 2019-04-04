/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.aaautoswitcherbeta;

import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Instant;

public class AutoSwitcherInputListener extends MouseAdapter implements KeyListener {
    private static final int HOTKEY_CORE = KeyEvent.VK_CONTROL;
    private static final int HOTKEY_1 = KeyEvent.VK_1;
    private static final int HOTKEY_2 = KeyEvent.VK_2;
    private static final int HOTKEY_3 = KeyEvent.VK_3;


    private Instant lastPress;

    @Inject
    private AutoSwitcherPlugin plugin;

    @Inject
    private AutoSwitcherConfig config;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == HOTKEY_CORE) {
            {
                plugin.setCoreKeyPressed(true);
                lastPress = Instant.now();
                e.consume();
            }
        }
        if (e.getKeyCode() == HOTKEY_1) {
            if (plugin.isCoreKeyPressed()) {
                plugin.executeScript(e.getKeyCode());
            }
        }
        if (e.getKeyCode() == HOTKEY_2) {
            if (plugin.isCoreKeyPressed()) {
                plugin.executeScript(e.getKeyCode());
            }
        }
        if (e.getKeyCode() == HOTKEY_3) {
            if (plugin.isCoreKeyPressed()) {
                plugin.executeScript(e.getKeyCode());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == HOTKEY_CORE) {
            plugin.setCoreKeyPressed(false);
        }
    }

    @Override
    public MouseEvent mousePressed(MouseEvent e) {
        final Point mousePos = e.getPoint();

        if (plugin.isCoreKeyPressed()) {
            if (SwingUtilities.isLeftMouseButton(e)) {
            } else if (SwingUtilities.isRightMouseButton(e)) {
            }
        }

        return e;
    }
}

