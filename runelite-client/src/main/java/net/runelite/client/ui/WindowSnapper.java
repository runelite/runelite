/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WindowSnapper extends ComponentAdapter {

    private boolean locked = false;
    int frameX = 0;
    int frameY = 0;

    public void componentMoved(ComponentEvent evt) {
        if (locked)
            return;

        Component gameFrame = evt.getComponent();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        frameX = evt.getComponent().getX();
        frameY = evt.getComponent().getY();

        // top
        if (mousePos.y == 0) {
            frameX = 0;
            frameY = 0;
            gameFrame.setSize(screenSize.width, screenSize.height/2);
        }

        // left
        if (mousePos.x == 0) {
            frameX = 0;
            frameY = 0;
            gameFrame.setSize(screenSize.width/2, screenSize.height);
        }

        // right
        if (mousePos.x == screenSize.width-1) {
            frameX = screenSize.width/2;
            frameY = 0;
            gameFrame.setSize(screenSize.width/2, screenSize.height);
        }

        // bottom
        if (mousePos.y == screenSize.height-1) {
            frameX = 0;
            frameY = screenSize.height/2;
            gameFrame.setSize(screenSize.width, screenSize.height/2);
        }

        // make sure we don't get into a recursive loop when the
        // set location generates more events
        locked = true;
        evt.getComponent().setLocation(frameX, frameY);
        locked = false;
    }
}
