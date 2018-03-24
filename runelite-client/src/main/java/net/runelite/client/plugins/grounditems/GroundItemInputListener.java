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

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

public class GroundItemInputListener extends MouseListener implements KeyListener
{
	private static final int HOTKEY = KeyEvent.VK_ALT;

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
			plugin.getHighlightBoxes().clear();
			plugin.getHiddenBoxes().clear();
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

