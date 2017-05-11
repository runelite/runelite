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
import net.runelite.api.Node;
import net.runelite.api.Point;
import net.runelite.api.WidgetNode;
import net.runelite.api.XHashTable;

public class Widget
{
	private static final int ITEM_SLOT_SIZE = 32;

	private final Client client;
	private final net.runelite.rs.api.Widget widget;

	public Widget(Client client, net.runelite.rs.api.Widget widget)
	{
		this.client = client;
		this.widget = widget;
	}

	public int getId()
	{
		return widget.getId();
	}

	public int getType()
	{
		return widget.getType();
	}

	public int getContentType()
	{
		return widget.getContentType();
	}

	public Widget getParent()
	{
		int id = getParentId();
		if (id == -1)
		{
			return null;
		}

		return client.getWidget(id >>> 16, id & 0xFFFF);
	}

	public int getParentId()
	{
		int parentId = widget.getParentId();
		if (parentId != -1)
		{
			return parentId;
		}

		int i = getId() >>> 16;
		XHashTable componentTable = client.getComponentTable();
		for (Node node : componentTable.getNodes())
		{
			WidgetNode wn = (WidgetNode) node;

			if (i == wn.getId())
			{
				return (int) wn.getHash();
			}
		}

		return -1;
	}

	private int getRelativeX()
	{
		return widget.getRelativeX();
	}

	private int getRelativeY()
	{
		return widget.getRelativeY();
	}

	public String getText()
	{
		return widget.getText().replace('\u00A0', ' ');
	}

	public void setText(String text)
	{
		widget.setText(text);
	}

	public int getTextColor()
	{
		return widget.getTextColor();
	}

	public String getName()
	{
		return widget.getName().replace('\u00A0', ' ');
	}

	public int getModelId()
	{
		return widget.getModelId();
	}

	public int getSpriteId()
	{
		return widget.getSpriteId();
	}

	public boolean isHidden()
	{
		Widget parent = getParent();
		return (parent != null && parent.isHidden()) || widget.isHidden();
	}

	public Point getCanvasLocation()
	{
		int x = 0;
		int y = 0;
		Widget cur;

		for (cur = this; cur.getParent() != null; cur = cur.getParent())
		{
			x += cur.getRelativeX();
			y += cur.getRelativeY();

			x -= cur.widget.getScrollX();
			y -= cur.widget.getScrollY();
		}

		// cur is now the root
		int[] widgetBoundsWidth = client.getWidgetPositionsX();
		int[] widgetBoundsHeight = client.getWidgetPositionsY();

		int boundsIndex = cur.widget.getBoundsIndex();
		if (boundsIndex != -1)
		{
			x += widgetBoundsWidth[boundsIndex];
			y += widgetBoundsHeight[boundsIndex];

			if (cur.getType() > 0)
			{
				x += cur.getRelativeX();
				y += cur.getRelativeY();
			}
		}
		else
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

	public Rectangle getBounds()
	{
		Point canvasLocation = getCanvasLocation();
		return new Rectangle(canvasLocation.getX(), canvasLocation.getY(), getWidth(), getHeight());
	}

	public Collection<WidgetItem> getWidgetItems()
	{
		int[] itemIds = widget.getItemIds();

		if (itemIds == null)
		{
			return null;
		}

		List<WidgetItem> items = new ArrayList<>(itemIds.length);

		for (int i = 0; i < itemIds.length; ++i)
		{
			WidgetItem item = getWidgetItem(i);

			if (item != null)
			{
				items.add(item);
			}
		}

		return items;
	}

	public WidgetItem getWidgetItem(int index)
	{
		int[] itemIds = widget.getItemIds();
		int[] itemQuantities = widget.getItemQuantities();

		if (itemIds == null || itemQuantities == null)
		{
			return null;
		}

		int columns = getWidth(); // the number of item slot columns is stored here
		int paddingX = getPaddingX();
		int paddingY = getPaddingY();
		int itemId = itemIds[index];
		int itemQuantity = itemQuantities[index];

		Point widgetCanvasLocation = getCanvasLocation();

		if (itemId <= 0 || itemQuantity <= 0 || columns <= 0)
		{
			return null;
		}

		int row = index / columns;
		int col = index % columns;
		int itemX = widgetCanvasLocation.getX() + ((ITEM_SLOT_SIZE + paddingX) * col);
		int itemY = widgetCanvasLocation.getY() + ((ITEM_SLOT_SIZE + paddingY) * row);

		Rectangle bounds = new Rectangle(itemX - 1, itemY - 1, ITEM_SLOT_SIZE, ITEM_SLOT_SIZE);
		return new WidgetItem(itemId - 1, itemQuantity, index, bounds);
	}

	private int getPaddingX()
	{
		return widget.getPaddingX();
	}

	private int getPaddingY()
	{
		return widget.getPaddingY();
	}

	public Widget[] getChildren()
	{
		net.runelite.rs.api.Widget[] widgets = widget.getChildren();

		if (widgets == null)
		{
			return null;
		}

		Widget[] children = new Widget[widgets.length];

		int idx = -1;
		for (net.runelite.rs.api.Widget child : widgets)
		{
			idx++;

			if (child == null)
			{
				continue;
			}

			children[idx] = new Widget(client, child);
		}

		return children;
	}

	public Widget getChild(int index)
	{
		net.runelite.rs.api.Widget[] widgets = widget.getChildren();

		if (widgets == null || widgets[index] == null)
		{
			return null;
		}

		return new Widget(client, widgets[index]);
	}

	public int getItemId()
	{
		return widget.getItemId();
	}

	public int getItemQuantity()
	{
		return widget.getItemQuantity();
	}
}
