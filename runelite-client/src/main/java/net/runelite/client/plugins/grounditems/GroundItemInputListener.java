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

import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

import javax.inject.Inject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map;

public class GroundItemInputListener extends MouseListener implements KeyListener
{
	private static final int HOTKEY_ITEM_OPTIONS = KeyEvent.VK_ALT;
	private static final int HOTKEY_SHOW_HIDDEN = KeyEvent.VK_CONTROL;

	@Inject
	private Client client;

	@Inject
	private GroundItemsPlugin plugin;

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY_ITEM_OPTIONS)
		{
			plugin.setHotKeyPressed(true);
		}
		else if (e.getKeyCode() == HOTKEY_SHOW_HIDDEN)
		{
			plugin.setShowHiddenItems(true);
		}
		else if (e.getKeyCode() == HOTKEY_SHOW_HIDDEN)
		{
			plugin.setShowHiddenItems(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY_ITEM_OPTIONS)
		{
			plugin.setHotKeyPressed(false);
			plugin.getHighlightBoxes().clear();
			plugin.getHiddenBoxes().clear();
		}
		else if (e.getKeyCode() == HOTKEY_SHOW_HIDDEN)
		{
			plugin.setShowHiddenItems(false);
		}
		else if (e.getKeyCode() == HOTKEY_SHOW_HIDDEN)
		{
			plugin.setShowHiddenItems(false);
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent e)
	{
		if (plugin.isHotKeyPressed())
		{
			// Check if left click
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				Point mousePos = client.getMouseCanvasPosition();

				for (Map.Entry<Rectangle, String> entry : plugin.getHiddenBoxes().entrySet())
				{
					if (entry.getKey().contains(mousePos.getX(), mousePos.getY()))
					{
						plugin.updateList(entry.getValue(), true);
						e.consume();
						return e;
					}
				}

				for (Map.Entry<Rectangle, String> entry : plugin.getHighlightBoxes().entrySet())
				{
					if (entry.getKey().contains(mousePos.getX(), mousePos.getY()))
					{
						plugin.updateList(entry.getValue(), false);
						e.consume();
						return e;
					}
				}
			}
		}

		return e;
	}
}

