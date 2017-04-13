/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api.widgets;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Point;

public class Widget
{
	private static final int WIDGET_ITEM_WIDTH = 42;
	private static final int WIDGET_ITEM_HEIGHT = 36;

	private final Client client;
	private final net.runelite.rs.api.Widget widget;

	public Widget(Client client, net.runelite.rs.api.Widget widget)
	{
		this.client = client;
		this.widget = widget;
	}

	public Widget getParent()
	{
		net.runelite.rs.api.Widget parent = widget.getParent();

		if (parent == null)
		{
			return null;
		}

		return new Widget(client, parent);
	}

	private int getRelativeX()
	{
		return widget.getRelativeX();
	}

	private int getRelativeY()
	{
		return widget.getRelativeY();
	}

	public Point getCanvasLocation()
	{
		int x = 0;
		int y = 0;

		int boundsIndex = widget.getBoundsIndex();
		if (boundsIndex != -1)
		{
			int[] widgetBoundsWidth = client.getWidgetPositionsX();
			int[] widgetBoundsHeight = client.getWidgetPositionsY();

			x += widgetBoundsWidth[boundsIndex];
			y += widgetBoundsHeight[boundsIndex];
		}

		for (Widget cur = this; cur != null; cur = cur.getParent())
		{
			x += cur.getRelativeX();
			y += cur.getRelativeY();
		}

		return new Point(x, y);
	}

	public int getWidth()
	{
		return widget.getWidth();
	}

	public int getHeight()
	{
		return widget.getHeight();
	}

	public Collection<WidgetItem> getWidgetItems()
	{
		int[] itemIds = widget.getItemIds();
		int[] itemQuantities = widget.getItemQuantities();

		if (itemIds == null || itemQuantities == null)
		{
			return null;
		}

		List<WidgetItem> items = new ArrayList<>(itemIds.length);

		assert itemIds.length == itemQuantities.length;

		int itemsX = getWidth(); // this appears to be the number of items that fit in the width
		Point widgetCanvasLocation = getCanvasLocation();

		for (int i = 0; i < itemIds.length; ++i)
		{
			int itemId = itemIds[i];
			int itemQuantity = itemQuantities[i];

			if (itemId <= 0 || itemQuantity <= 0)
			{
				continue;
			}

			Rectangle bounds = null;

			if (itemsX > 0)
			{
				int itemX = widgetCanvasLocation.getX() + (i % itemsX) * WIDGET_ITEM_WIDTH;
				int itemY = widgetCanvasLocation.getY() + (i / itemsX) * WIDGET_ITEM_HEIGHT;

				bounds = new Rectangle(itemX + 1, itemY - 1, WIDGET_ITEM_WIDTH - 2, WIDGET_ITEM_HEIGHT - 2);
			}

			WidgetItem item = new WidgetItem(itemId - 1, itemQuantity, i, bounds);
			items.add(item);
		}

		return items;
	}
}
