/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.inventoryhighlight;

import com.google.inject.Inject;
import java.awt.event.MouseEvent;
import api.Client;
import api.GameState;
import api.Point;
import api.widgets.Widget;
import api.widgets.WidgetInfo;
import api.widgets.WidgetItem;
import net.runelite.client.input.MouseListener;

public class InventoryHighlightInputListener implements MouseListener
{
	private final InventoryHighlightPlugin plugin;
	private final Client client;

	@Inject
	public InventoryHighlightInputListener(InventoryHighlightPlugin plugin, Client client)
	{
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		plugin.setDragging(true);
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return mouseEvent;
		}

		final Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
		final Widget bankInventoryWidget = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);

		if ((inventoryWidget == null || inventoryWidget.isSelfHidden()) &&
			(inventoryWidget == null || bankInventoryWidget == null || bankInventoryWidget.isSelfHidden()))
		{
			return mouseEvent;
		}

		final Point mouse = client.getMouseCanvasPosition();

		for (WidgetItem item : inventoryWidget.getWidgetItems())
		{
			if (item.getCanvasBounds().contains(mouse.getX(), mouse.getY()))
			{
				plugin.setDraggingItem(item.getId());
				break;
			}
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		plugin.setDragging(false);
		plugin.setDraggingItem(-1);

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseEntered(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseExited(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}
}
