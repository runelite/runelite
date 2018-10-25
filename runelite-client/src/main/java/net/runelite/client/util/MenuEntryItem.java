/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.util;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;

@Value
public class MenuEntryItem
{
	/**
	 * Matched widget of group and child ID defined in {@link WidgetInfo}, can be {@code null} if no such
	 * {@link WidgetInfo} entry exists for the widget.
	 */
	private WidgetInfo widget;
	private int itemId;
	private int itemQuantity;

	/**
	 * Gets an {@link MenuEntryItem} from an examined widget.
	 *
	 * @param widget      The examined widget
	 * @param type        The menu action type of the examined entry
	 * @param actionParam The action param of the examination (see {@link MenuOptionClicked#getActionParam()} or
	 *                    {@link MenuEntryAdded#getActionParam0()})
	 * @return An {@link MenuEntryItem} of appropriate {@code id} and {@code quantity}. If the passed
	 *         {@code widget} is null, or the item could not be found from the {@link WidgetItem}, null will be
	 *         returned instead.
	 */
	@Nullable
	public static MenuEntryItem find(final Widget widget, final MenuAction type, final int actionParam)
	{
		if (widget == null)
		{
			return null;
		}

		final int widgetId = widget.getId();
		final int widgetGroup = WidgetInfo.TO_GROUP(widgetId);
		int foundItemId = -1;
		int foundItemQuantity = -1;

		if (type == MenuAction.EXAMINE_ITEM)
		{
			WidgetItem widgetItem = widget.getWidgetItem(actionParam);
			if (widgetItem != null)
			{
				foundItemQuantity = widgetItem.getQuantity();
				foundItemId = widgetItem.getId();
			}
		}
		else if (type == MenuAction.EXAMINE_ITEM_BANK_EQ)
		{
			if (WidgetInfo.EQUIPMENT.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(1);
				if (widgetItem != null)
				{
					foundItemQuantity = widgetItem.getItemQuantity();
					foundItemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.SMITHING_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(2);
				if (widgetItem != null)
				{
					foundItemQuantity = widgetItem.getItemQuantity();
					foundItemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup
				|| WidgetInfo.RUNE_POUCH_ITEM_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(actionParam);
				if (widgetItem != null)
				{
					foundItemQuantity = widgetItem.getItemQuantity();
					foundItemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() == widgetGroup
				|| WidgetInfo.SHOP_ITEMS_CONTAINER.getGroupId() == widgetGroup
				|| WidgetInfo.CLUE_SCROLL_REWARD_ITEM_CONTAINER.getGroupId() == widgetGroup
				|| WidgetInfo.LOOTING_BAG_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget[] children = widget.getDynamicChildren();
				if (actionParam < children.length)
				{
					Widget widgetItem = children[actionParam];
					foundItemQuantity = widgetItem.getItemQuantity();
					foundItemId = widgetItem.getItemId();
				}
			}
		}

		if (foundItemId == -1)
		{
			return null;
		}

		return new MenuEntryItem(WidgetInfo.from(widgetGroup, WidgetInfo.TO_CHILD(widgetId)), foundItemId, foundItemQuantity);
	}
}
