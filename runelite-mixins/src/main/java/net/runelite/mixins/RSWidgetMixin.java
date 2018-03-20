/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.api.Node;
import net.runelite.api.Point;
import net.runelite.api.WidgetNode;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.api.widgets.WidgetItem;
import static net.runelite.client.callback.Hooks.eventBus;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSHashTable;
import net.runelite.rs.api.RSNode;
import net.runelite.rs.api.RSWidget;

@Mixin(RSWidget.class)
public abstract class RSWidgetMixin implements RSWidget
{
	private static final int ITEM_SLOT_SIZE = 32;

	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	@Override
	public Widget getParent()
	{
		int id = getParentId();
		if (id == -1)
		{
			return null;
		}

		return client.getWidget(TO_GROUP(id), TO_CHILD(id));
	}

	@Inject
	@Override
	public int getParentId()
	{
		int parentId = getRSParentId();
		if (parentId != -1)
		{
			return parentId;
		}

		int groupId = TO_GROUP(getId());
		RSHashTable componentTable = client.getComponentTable();
		RSNode[] buckets = componentTable.getBuckets();
		for (int i = 0; i < buckets.length; ++i)
		{
			Node node = buckets[i];

			// It looks like the first node in the bucket is always
			// a sentinel
			Node cur = node.getNext();
			while (cur != node)
			{
				WidgetNode wn = (WidgetNode) cur;

				if (groupId == wn.getId())
				{
					return (int) wn.getHash();
				}
				cur = cur.getNext();
			}
		}
		return -1;
	}

	@Inject
	@Override
	public String getText()
	{
		return getRSText().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public String getName()
	{
		return getRSName().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public void setName(String name)
	{
		setRSName(name.replace(' ', '\u00A0'));
	}

	@Inject
	@Override
	public boolean isHidden()
	{
		Widget parent = getParent();

		if (parent == null)
		{
			if (TO_GROUP(getId()) != client.getWidgetRoot())
			{
				// Widget has no parent and is not the root widget (which is always visible),
				// so it's not visible.
				return true;
			}
		}
		else if (parent.isHidden())
		{
			// If the parent is hidden, this widget is also hidden.
			return true;
		}

		return isSelfHidden();
	}

	@Inject
	@Override
	public Point getCanvasLocation()
	{
		int x = 0;
		int y = 0;
		RSWidget cur;

		for (cur = this; cur.getParent() != null; cur = (RSWidget) cur.getParent())
		{
			x += cur.getRelativeX();
			y += cur.getRelativeY();

			x -= cur.getScrollX();
			y -= cur.getScrollY();
		}

		// cur is now the root
		int[] widgetBoundsWidth = client.getWidgetPositionsX();
		int[] widgetBoundsHeight = client.getWidgetPositionsY();

		int boundsIndex = cur.getBoundsIndex();
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

	@Inject
	@Override
	public Rectangle getBounds()
	{
		Point canvasLocation = getCanvasLocation();
		return new Rectangle(canvasLocation.getX(), canvasLocation.getY(), getWidth(), getHeight());
	}

	@Inject
	@Override
	public Collection<WidgetItem> getWidgetItems()
	{
		int[] itemIds = getItemIds();

		if (itemIds == null)
		{
			return null;
		}

		List<WidgetItem> items = new ArrayList<WidgetItem>(itemIds.length);

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

	@Inject
	@Override
	public WidgetItem getWidgetItem(int index)
	{
		int[] itemIds = getItemIds();
		int[] itemQuantities = getItemQuantities();

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

	@Inject
	@Override
	public Widget getChild(int index)
	{
		RSWidget[] widgets = getChildren();

		if (widgets == null || widgets[index] == null)
		{
			return null;
		}

		return widgets[index];
	}

	@Inject
	@Override
	public Widget[] getDynamicChildren()
	{
		RSWidget[] children = getChildren();

		if (children == null)
		{
			return new Widget[0];
		}

		List<Widget> widgets = new ArrayList<Widget>();
		for (Widget widget : children)
		{
			if (widget != null && widget.getParentId() == getId())
			{
				widgets.add(widget);
			}
		}
		return widgets.toArray(new Widget[widgets.size()]);
	}

	@Inject
	@Override
	public Widget[] getStaticChildren()
	{
		List<Widget> widgets = new ArrayList<Widget>();
		for (Widget widget : client.getGroup(TO_GROUP(getId())))
		{
			if (widget != null && widget.getParentId() == getId())
			{
				widgets.add(widget);
			}
		}
		return widgets.toArray(new Widget[widgets.size()]);
	}

	@Inject
	@Override
	public Widget[] getNestedChildren()
	{
		RSHashTable componentTable = client.getComponentTable();
		int group = -1;

		// XXX can actually use hashtable lookup instead of table
		// iteration here...
		for (Node node : componentTable.getNodes())
		{
			WidgetNode wn = (WidgetNode) node;

			if (wn.getHash() == getId())
			{
				group = wn.getId();
				break;
			}
		}

		if (group == -1)
		{
			return new Widget[0];
		}

		List<Widget> widgets = new ArrayList<Widget>();
		for (Widget widget : client.getGroup(group))
		{
			if (widget != null && widget.getParentId() == getId())
			{
				widgets.add(widget);
			}
		}
		return widgets.toArray(new Widget[widgets.size()]);
	}

	@Inject
	@Override
	public boolean contains(Point point)
	{
		Rectangle bounds = getBounds();
		return bounds != null && bounds.contains(new java.awt.Point(point.getX(), point.getY()));
	}

	@Inject
	@Override
	public void broadcastHidden(boolean hidden)
	{
		WidgetHiddenChanged event = new WidgetHiddenChanged();
		event.setWidget(this);
		event.setHidden(hidden);

		eventBus.post(event);

		RSWidget[] children = getChildren();

		if (children != null)
		{
			// recursive through children
			for (RSWidget child : children)
			{
				// if the widget is hidden it will not magically unhide from its parent changing
				if (child == null || child.isSelfHidden())
					continue;

				child.broadcastHidden(hidden);
			}
		}

		// make sure we iterate nested children as well
		// cannot be null
		Widget[] nestedChildren = getNestedChildren();

		for (Widget nestedChild : nestedChildren)
		{
			if (nestedChild == null || nestedChild.isSelfHidden())
				continue;

			((RSWidget) nestedChild).broadcastHidden(hidden);
		}
	}

	@FieldHook("isHidden")
	@Inject
	public void onHiddenChanged(int idx)
	{
		int id = getId();

		if (id == -1)
		{
			return;
		}

		Widget parent = getParent();

		// if the parent is hidden then changes in this widget don't have any visual effect
		// so ignore them
		if (parent != null)
		{
			if (parent.isHidden())
			{
				return;
			}
		}
		else if (TO_GROUP(id) != client.getWidgetRoot())
		{
			return;
		}

		broadcastHidden(isSelfHidden());
	}
}
