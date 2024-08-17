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
import java.util.List;
import net.runelite.api.MainBufferProvider;
import net.runelite.api.Renderable;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;

/**
 * Interface of callbacks the injected client uses to send events
 */
public interface Callbacks
{
	/**
	 * Post an event. See the events in net.runelite.api.events.
	 *
	 * @param event the event
	 */
	void post(Object event);

	/**
	 * Post a deferred event, which gets delayed until the next cycle.
	 *
	 * @param event the event
	 */
	void postDeferred(Object event);

	/**
	 * Called at the beginning of each tick
	 */
	void tick();

	/**
	 * Called at the end of each tick
	 */
	void tickEnd();

	/**
	 * Called each frame
	 */
	void frame();

	/**
	 * Called each server tick
	 */
	void serverTick();

	/**
	 * Called after the scene is drawn.
	 */
	void drawScene();

	/**
	 * Called after logic that is drawing 2D objects is processed.
	 */
	void drawAboveOverheads();

	/**
	 * Client top-most draw method, rendering over top of most of game interfaces.
	 *
	 * @param mainBufferProvider the main buffer provider
	 * @param graphics           the graphics
	 * @param x                  the x
	 * @param y                  the y
	 */
	void draw(MainBufferProvider mainBufferProvider, Graphics graphics, int x, int y);

	/**
	 * Called after an interface has been drawn
	 * @param interfaceId the interface id
	 * @param widgetItems Widget items within the interface
	 */
	void drawInterface(int interfaceId, List<WidgetItem> widgetItems);

	/**
	 * Called after a widget layer has been drawn
	 * @param layer The layer
	 * @param widgetItems Widget items within the layer
	 */
	void drawLayer(Widget layer, List<WidgetItem> widgetItems);

	/**
	 * Mouse pressed event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param mouseEvent the mouse event
	 * @return the mouse event
	 */
	MouseEvent mousePressed(MouseEvent mouseEvent);

	/**
	 * Mouse released event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param mouseEvent the mouse event
	 * @return the mouse event
	 */
	MouseEvent mouseReleased(MouseEvent mouseEvent);

	/**
	 * Mouse clicked event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param mouseEvent the mouse event
	 * @return the mouse event
	 */
	MouseEvent mouseClicked(MouseEvent mouseEvent);

	/**
	 * Mouse entered event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param mouseEvent the mouse event
	 * @return the mouse event
	 */
	MouseEvent mouseEntered(MouseEvent mouseEvent);

	/**
	 * Mouse exited event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param mouseEvent the mouse event
	 * @return the mouse event
	 */
	MouseEvent mouseExited(MouseEvent mouseEvent);

	/**
	 * Mouse dragged event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param mouseEvent the mouse event
	 * @return the mouse event
	 */
	MouseEvent mouseDragged(MouseEvent mouseEvent);

	/**
	 * Mouse moved event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param mouseEvent the mouse event
	 * @return the mouse event
	 */
	MouseEvent mouseMoved(MouseEvent mouseEvent);

	/**
	 * Mouse wheel moved event. If this event will be consumed it will not be propagated further to client.
	 *
	 * @param event the event
	 * @return the mouse wheel event
	 */
	MouseWheelEvent mouseWheelMoved(MouseWheelEvent event);

	/**
	 * Key pressed event.
	 *
	 * @param keyEvent the key event
	 */
	void keyPressed(KeyEvent keyEvent);

	/**
	 * Key released event.
	 *
	 * @param keyEvent the key event
	 */
	void keyReleased(KeyEvent keyEvent);

	/**
	 * Key typed event.
	 *
	 * @param keyEvent the key event
	 */
	void keyTyped(KeyEvent keyEvent);

	/**
	 * Called to test if a renderable should be drawn this frame
	 * @param renderable the renderable
	 * @param drawingUi if this is the 2d ui, such as hp bars or hitsplats
	 * @return false to prevent drawing
	 */
	boolean draw(Renderable renderable, boolean drawingUi);

	/**
	 * Called when a client error occurs
	 * @param message
	 * @param reason
	 */
	void error(String message, Throwable reason);

	/**
	 * Called when the client wants to open a URL
	 * @param url
	 */
	void openUrl(String url);

	/**
	 * Returns if the current runelite client is outdated or not
	 *
	 * @return
	 */
	boolean isRuneLiteClientOutdated();
}
