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
package net.runelite.client.plugins.grounditems;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

public class GroundItemInputListener extends MouseListener implements KeyListener
{
	private static final int HOTKEY = KeyEvent.VK_ALT;

	@Inject
	private GroundItemsPlugin plugin;

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY)
		{
			plugin.setHotKeyPressed(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY)
		{
			plugin.setHotKeyPressed(false);
			plugin.getBoxes().clear();
			plugin.getHiddenBoxes().clear();
			plugin.getHighlightBoxes().clear();
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent e)
	{
		if (plugin.isHotKeyPressed())
		{
			if (SwingUtilities.isLeftMouseButton(e))
			{
				// Process both click boxes for hidden and highlighted items
				final Iterator<Map.Entry<Rectangle, String>> highlightIterator = plugin
					.getHighlightBoxes().entrySet().iterator();

				if (findMatchAndProcess(e, highlightIterator, false) != null)
				{
					return e;
				}

				final Iterator<Map.Entry<Rectangle, String>> hiddenIterator = plugin
					.getHiddenBoxes().entrySet().iterator();

				if (findMatchAndProcess(e, hiddenIterator, true) != null)
				{
					return e;
				}

				// There is one name click box for left click and one for right click
				final Iterator<Map.Entry<Rectangle, String>> iterator = plugin.getBoxes().entrySet().iterator();
				if (findMatchAndProcess(e, iterator, false) != null)
				{
					return e;
				}
			}
			else if (SwingUtilities.isRightMouseButton(e))
			{
				final Iterator<Map.Entry<Rectangle, String>> iterator = plugin.getBoxes().entrySet().iterator();
				if (findMatchAndProcess(e, iterator, true) != null)
				{
					return e;
				}
			}
		}

		return e;
	}

	@Nullable
	private MouseEvent findMatchAndProcess(
		final MouseEvent mouseEvent,
		final Iterator<Map.Entry<Rectangle, String>> iterator,
		final boolean hiddenList)
	{
		final Point mousePos = mouseEvent.getPoint();

		while (iterator.hasNext())
		{
			final Map.Entry<Rectangle, String> next = iterator.next();

			if (next.getKey().contains(mousePos))
			{
				plugin.updateList(next.getValue(), hiddenList);
				mouseEvent.consume();
				return mouseEvent;
			}
		}

		return null;
	}
}

