/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.menuentryswapper;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

public class ShiftClickInputListener extends MouseListener implements KeyListener
{
	@Inject
	private ClientThread clientThread;

	@Inject
	private Client client;

	@Inject
	private MenuEntrySwapperPlugin plugin;

	@Inject
	private MenuEntrySwapperConfig config;

	private WidgetItem getClickedItem(Point point)
	{
		for (WidgetItem item : plugin.getInventoryItems())
		{
			if (item.getCanvasBounds().contains(point))
			{
				return item;
			}
		}

		return null;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent event)
	{
		if (!config.shiftClickCustomization() || !isValidInventoryClick(event.getPoint()))
		{
			return event;
		}

		final WidgetItem item = getClickedItem(event.getPoint());
		final int button = event.getButton();

		if (item != null)
		{
			clientThread.invokeLater(() -> plugin.cycleItemShiftClickAction(item, button));
			event.consume();
		}

		return event;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent event)
	{
		if (!config.shiftClickCustomization() || !isValidInventoryClick(event.getPoint()))
		{
			return event;
		}

		event.consume();
		return event;
	}

	private boolean isValidInventoryClick(Point point)
	{
		Widget widget = client.getWidget(WidgetInfo.INVENTORY).getParent();
		return !widget.isHidden() && !client.isMenuOpen() && widget.getBounds().contains(point);
	}

	@Override
	public void keyTyped(KeyEvent event)
	{

	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			plugin.setShiftModifier(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			plugin.setShiftModifier(false);
		}
	}
}
