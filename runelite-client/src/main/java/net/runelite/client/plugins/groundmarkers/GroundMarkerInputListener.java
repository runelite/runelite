/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
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

package net.runelite.client.plugins.groundmarkers;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

public class GroundMarkerInputListener extends MouseListener implements KeyListener
{
	private static final int HOTKEY = KeyEvent.VK_ALT;
	private static final int HOTKEYR = KeyEvent.VK_SHIFT;

	private Client client;
	private GroundMarkerPlugin plugin;

	@Inject
	private GroundMarkerInputListener(Client client, GroundMarkerPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
	}

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
		else if (e.getKeyCode() == HOTKEYR)
		{
			plugin.setResetHotkeyPressed(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY)
		{
			plugin.setHotKeyPressed(false);
		}
		else if (e.getKeyCode() == HOTKEYR)
		{
			plugin.setResetHotkeyPressed(false);
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent e)
	{
		if (plugin.isHotKeyPressed())
		{
			if (e.getButton() == MouseEvent.BUTTON3)
			{
				if (plugin.isResetHotkeyPressed())
				{
					plugin.clearPoints();
				}
				else
				{
					plugin.markTile(client.getMouseCanvasPosition());
				}
			}
		}

		return e;
	}
}