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
package net.runelite.client.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Singleton;

@Singleton
public class MouseManager
{
	private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();
	private final List<MouseWheelListener> mouseWheelListeners = new CopyOnWriteArrayList<>();

	public void registerMouseListener(MouseListener mouseListener)
	{
		if (!mouseListeners.contains(mouseListener))
		{
			mouseListeners.add(mouseListener);
		}
	}

	public void registerMouseListener(int position, MouseListener mouseListener)
	{
		mouseListeners.add(position, mouseListener);
	}

	public void unregisterMouseListener(MouseListener mouseListener)
	{
		mouseListeners.remove(mouseListener);
	}

	public void registerMouseWheelListener(MouseWheelListener mouseWheelListener)
	{
		if (!mouseWheelListeners.contains(mouseWheelListener))
		{
			mouseWheelListeners.add(mouseWheelListener);
		}
	}

	public void registerMouseWheelListener(int position, MouseWheelListener mouseWheelListener)
	{
		mouseWheelListeners.add(position, mouseWheelListener);
	}

	public void unregisterMouseWheelListener(MouseWheelListener mouseWheelListener)
	{
		mouseWheelListeners.remove(mouseWheelListener);
	}

	public MouseEvent processMousePressed(MouseEvent mouseEvent)
	{
		for (MouseListener mouseListener : mouseListeners)
		{
			mouseEvent = mouseListener.mousePressed(mouseEvent);
		}
		return mouseEvent;
	}

	public MouseEvent processMouseReleased(MouseEvent mouseEvent)
	{
		for (MouseListener mouseListener : mouseListeners)
		{
			mouseEvent = mouseListener.mouseReleased(mouseEvent);
		}
		return mouseEvent;
	}

	public MouseEvent processMouseClicked(MouseEvent mouseEvent)
	{
		for (MouseListener mouseListener : mouseListeners)
		{
			mouseEvent = mouseListener.mouseClicked(mouseEvent);
		}
		return mouseEvent;
	}

	public MouseEvent processMouseEntered(MouseEvent mouseEvent)
	{
		for (MouseListener mouseListener : mouseListeners)
		{
			mouseEvent = mouseListener.mouseEntered(mouseEvent);
		}
		return mouseEvent;
	}

	public MouseEvent processMouseExited(MouseEvent mouseEvent)
	{
		for (MouseListener mouseListener : mouseListeners)
		{
			mouseEvent = mouseListener.mouseExited(mouseEvent);
		}
		return mouseEvent;
	}

	public MouseEvent processMouseDragged(MouseEvent mouseEvent)
	{
		for (MouseListener mouseListener : mouseListeners)
		{
			mouseEvent = mouseListener.mouseDragged(mouseEvent);
		}
		return mouseEvent;
	}

	public MouseEvent processMouseMoved(MouseEvent mouseEvent)
	{
		for (MouseListener mouseListener : mouseListeners)
		{
			mouseEvent = mouseListener.mouseMoved(mouseEvent);
		}
		return mouseEvent;
	}

	public MouseWheelEvent processMouseWheelMoved(MouseWheelEvent mouseWheelEvent)
	{
		for (MouseWheelListener mouseWheelListener : mouseWheelListeners)
		{
			mouseWheelEvent = mouseWheelListener.mouseWheelMoved(mouseWheelEvent);
		}
		return mouseWheelEvent;
	}
}
