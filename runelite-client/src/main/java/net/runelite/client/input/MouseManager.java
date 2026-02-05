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
import java.util.function.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AllArgsConstructor;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.util.Prioritized;

@Singleton
public class MouseManager
{
	// Button numbers greater than BUTTON3 have no constant identifier
	private static final int MOUSE_BUTTON_4 = 4;
	
	private final List<Prioritized<MouseListener>> mouseListeners = new CopyOnWriteArrayList<>();
	private final List<Prioritized<MouseWheelListener>> mouseWheelListeners = new CopyOnWriteArrayList<>();

	private final RuneLiteConfig runeLiteConfig;

	@Inject
	private MouseManager(RuneLiteConfig runeLiteConfig)
	{
		this.runeLiteConfig = runeLiteConfig;
	}

	/**
	 * Registers a mouse listener with default priority (0).
	 * First in first served at priority 0.
	 *
	 * @param mouseListener the mouse listener
	 */
	public void registerMouseListener(MouseListener mouseListener)
	{
		registerMouseListener(mouseListener, 0);
	}

	/**
	 * Registers a mouse listener with the given priority. Lower values indicate higher priority
	 * and will be processed first. Listeners with the same priority are processed in registration order.
	 *
	 * @param mouseListener the mouse listener
	 * @param priority the priority, lower value = higher priority = processed first
	 */
	public void registerMouseListener(MouseListener mouseListener, int priority)
	{
		registerMouseListener(mouseListener, priority, false);
	}

	/**
	 * Registers a mouse listener with the given priority. Lower values indicate higher priority
	 * and will be processed first. Listeners with the same priority are processed in registration order.
	 *
	 * @param mouseListener the mouse listener
	 * @param priority the priority, lower value = higher priority = processed first
	 * @param insertBefore if true, insert before existing listeners with the same priority;
	 */
	public void registerMouseListener(MouseListener mouseListener, int priority, boolean insertBefore)
	{
		if (findMouseEntry(mouseListener) != null)
		{
			return;
		}

		Prioritized<MouseListener> entry = new Prioritized<>(mouseListener, priority);
		int index = findMouseInsertionIndex(priority, insertBefore);
		mouseListeners.add(index, entry);
	}

	/**
	 * @deprecated Use {@link #registerMouseListener(MouseListener, int, boolean)} instead.
	 */
	@Deprecated
	public void registerMouseListener(int position, MouseListener mouseListener)
	{
		// To preserve backwards compatibility, always insert before existing listeners with the same priority
		registerMouseListener(mouseListener, position, true);
	}

	public void unregisterMouseListener(MouseListener mouseListener)
	{
		Prioritized<MouseListener> entry = findMouseEntry(mouseListener);
		if (entry != null)
		{
			mouseListeners.remove(entry);
		}
	}

	/**
	 * Registers a mouse wheel listener with default priority (0).
	 * @param mouseWheelListener the mouse wheel listener
	 */
	public void registerMouseWheelListener(MouseWheelListener mouseWheelListener)
	{
		registerMouseWheelListener(mouseWheelListener, 0);
	}

	/**
	 * Registers a mouse wheel listener with the given priority. Lower values indicate higher priority
	 * and will be processed first. Listeners with the same priority are processed in registration order.
	 *
	 * @param mouseWheelListener the mouse wheel listener
	 * @param priority the priority, lower value = higher priority = processed first
	 */
	public void registerMouseWheelListener(MouseWheelListener mouseWheelListener, int priority)
	{
		registerMouseWheelListener(mouseWheelListener, priority, false);
	}

	/**
	 * Registers a mouse wheel listener with the given priority. Lower values indicate higher priority
	 * and will be processed first.
	 *
	 * @param mouseWheelListener the mouse wheel listener
	 * @param priority the priority, lower value = higher priority = processed first
	 * @param insertBefore if true, insert before existing listeners with the same priority;
	 */
	public void registerMouseWheelListener(MouseWheelListener mouseWheelListener, int priority, boolean insertBefore)
	{
		if (findMouseWheelEntry(mouseWheelListener) != null)
		{
			return;
		}

		Prioritized<MouseWheelListener> entry = new Prioritized<>(mouseWheelListener, priority);
		int index = findMouseWheelInsertionIndex(priority, insertBefore);
		mouseWheelListeners.add(index, entry);
	}

	/**
	 * @deprecated Use {@link #registerMouseWheelListener(MouseWheelListener, int, boolean)} instead.
	 */
	@Deprecated
	public void registerMouseWheelListener(int position, MouseWheelListener mouseWheelListener)
	{
		// To preserve backwards compatibility, always insert before existing listeners with the same priority
		registerMouseWheelListener(mouseWheelListener, position, true);
	}

	public void unregisterMouseWheelListener(MouseWheelListener mouseWheelListener)
	{
		Prioritized<MouseWheelListener> entry = findMouseWheelEntry(mouseWheelListener);
		if (entry != null)
		{
			mouseWheelListeners.remove(entry);
		}
	}

	public MouseEvent processMousePressed(MouseEvent mouseEvent)
	{
		if (mouseEvent.isConsumed())
		{
			return mouseEvent;
		}

		checkExtraMouseButtons(mouseEvent);
		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			mouseEvent = entry.getObject().mousePressed(mouseEvent);
			if (mouseEvent.isConsumed())
			{
				break;
			}
		}
		return mouseEvent;
	}

	public MouseEvent processMouseReleased(MouseEvent mouseEvent)
	{
		if (mouseEvent.isConsumed())
		{
			return mouseEvent;
		}

		checkExtraMouseButtons(mouseEvent);
		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			mouseEvent = entry.getObject().mouseReleased(mouseEvent);
			if (mouseEvent.isConsumed())
			{
				break;
			}
		}
		return mouseEvent;
	}

	public MouseEvent processMouseClicked(MouseEvent mouseEvent)
	{
		if (mouseEvent.isConsumed())
		{
			return mouseEvent;
		}

		checkExtraMouseButtons(mouseEvent);
		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			mouseEvent = entry.getObject().mouseClicked(mouseEvent);
			if (mouseEvent.isConsumed())
			{
				break;
			}
		}
		return mouseEvent;
	}

	private void checkExtraMouseButtons(MouseEvent mouseEvent)
	{
		// Prevent extra mouse buttons from being passed into the client,
		// as it treats them all as left click
		int button = mouseEvent.getButton();
		if (button >= MOUSE_BUTTON_4 && runeLiteConfig.blockExtraMouseButtons())
		{
			mouseEvent.consume();
		}
	}

	public MouseEvent processMouseEntered(MouseEvent mouseEvent)
	{
		if (mouseEvent.isConsumed())
		{
			return mouseEvent;
		}

		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			mouseEvent = entry.getObject().mouseEntered(mouseEvent);
			if (mouseEvent.isConsumed())
			{
				break;
			}
		}
		return mouseEvent;
	}

	public MouseEvent processMouseExited(MouseEvent mouseEvent)
	{
		if (mouseEvent.isConsumed())
		{
			return mouseEvent;
		}

		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			mouseEvent = entry.getObject().mouseExited(mouseEvent);
			if (mouseEvent.isConsumed())
			{
				break;
			}
		}
		return mouseEvent;
	}

	public MouseEvent processMouseDragged(MouseEvent mouseEvent)
	{
		if (mouseEvent.isConsumed())
		{
			return mouseEvent;
		}

		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			mouseEvent = entry.getObject().mouseDragged(mouseEvent);
			if (mouseEvent.isConsumed())
			{
				break;
			}
		}
		return mouseEvent;
	}

	public MouseEvent processMouseMoved(MouseEvent mouseEvent)
	{
		if (mouseEvent.isConsumed())
		{
			return mouseEvent;
		}

		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			mouseEvent = entry.getObject().mouseMoved(mouseEvent);
			if (mouseEvent.isConsumed())
			{
				break;
			}
		}
		return mouseEvent;
	}

	public MouseWheelEvent processMouseWheelMoved(MouseWheelEvent mouseWheelEvent)
	{
		if (mouseWheelEvent.isConsumed())
		{
			return mouseWheelEvent;
		}

		for (Prioritized<MouseWheelListener> entry : mouseWheelListeners)
		{
			mouseWheelEvent = entry.getObject().mouseWheelMoved(mouseWheelEvent);
			if (mouseWheelEvent.isConsumed())
			{
				break;
			}
		}
		return mouseWheelEvent;
	}

	private Prioritized<MouseListener> findMouseEntry(MouseListener mouseListener)
	{
		for (Prioritized<MouseListener> entry : mouseListeners)
		{
			if (entry.getObject() == mouseListener)
			{
				return entry;
			}
		}
		return null;
	}

	private Prioritized<MouseWheelListener> findMouseWheelEntry(MouseWheelListener mouseWheelListener)
	{
		for (Prioritized<MouseWheelListener> entry : mouseWheelListeners)
		{
			if (entry.getObject() == mouseWheelListener)
			{
				return entry;
			}
		}
		return null;
	}

	private int findMouseInsertionIndex(int priority, boolean insertBefore)
	{
		return findInsertionIndex(mouseListeners, priority, Prioritized::getPriority, insertBefore);
	}

	private int findMouseWheelInsertionIndex(int priority, boolean insertBefore)
	{
		return findInsertionIndex(mouseWheelListeners, priority, Prioritized::getPriority, insertBefore);
	}

	private <T> int findInsertionIndex(List<T> list, int priority, Function<T, Integer> priorityProvider, boolean insertBefore)
	{
		int lo = 0, hi = list.size();
		while (lo < hi)
		{
			int mid = (lo + hi) >>> 1;
			if (insertBefore
				? priorityProvider.apply(list.get(mid)) < priority
				: priorityProvider.apply(list.get(mid)) <= priority)
			{
				lo = mid + 1;
			}
			else
			{
				hi = mid;
			}
		}
		return lo;
	}
}
