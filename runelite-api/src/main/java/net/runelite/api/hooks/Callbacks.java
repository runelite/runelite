/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.api.hooks;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import net.runelite.api.MainBufferProvider;

/**
 * Interface of callbacks the injected client uses to send events
 */
public interface Callbacks
{
	/**
	 * Post an event. See the events in net.runelite.api.events
	 * @param event
	 */
	void post(Object event);

	/**
	 * Post a deferred event, which gets delayed until the next cycle
	 * @param event
	 */
	void postDeferred(Object event);

	/**
	 * Called each client cycle
	 */
	void clientMainLoop();

	void updateNpcs();

	void drawRegion();

	void drawAboveOverheads();

	void draw(MainBufferProvider mainBufferProvider, Graphics graphics, int x, int y);

	MouseEvent mousePressed(MouseEvent mouseEvent);

	MouseEvent mouseReleased(MouseEvent mouseEvent);

	MouseEvent mouseClicked(MouseEvent mouseEvent);

	MouseEvent mouseEntered(MouseEvent mouseEvent);

	MouseEvent mouseExited(MouseEvent mouseEvent);

	MouseEvent mouseDragged(MouseEvent mouseEvent);

	MouseEvent mouseMoved(MouseEvent mouseEvent);

	MouseWheelEvent mouseWheelMoved(MouseWheelEvent event);

	void keyPressed(KeyEvent keyEvent);

	void keyReleased(KeyEvent keyEvent);

	void keyTyped(KeyEvent keyEvent);
}
