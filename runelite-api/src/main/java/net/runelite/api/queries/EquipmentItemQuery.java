/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.api.queries;

import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class EquipmentItemQuery extends WidgetItemQuery
{
	private static final WidgetInfo[] ALL_EQUIPMENT_WIDGET_INFOS =
	{
		WidgetInfo.EQUIPMENT_HELMET,
		WidgetInfo.EQUIPMENT_CAPE,
		WidgetInfo.EQUIPMENT_AMULET,
		WidgetInfo.EQUIPMENT_WEAPON,
		WidgetInfo.EQUIPMENT_BODY,
		WidgetInfo.EQUIPMENT_SHIELD,
		WidgetInfo.EQUIPMENT_LEGS,
		WidgetInfo.EQUIPMENT_GLOVES,
		WidgetInfo.EQUIPMENT_BOOTS,
		WidgetInfo.EQUIPMENT_RING,
		WidgetInfo.EQUIPMENT_AMMO,
	};

	private final Collection<WidgetInfo> slots = new ArrayList<>();

	public EquipmentItemQuery slotEquals(WidgetInfo... slotWidgetInfo)
	{
		slots.addAll(Arrays.asList(slotWidgetInfo));
		return this;
	}

	@Override
	public WidgetItem[] result(Client client)
	{
		Collection<WidgetItem> widgetItems = getEquippedItems(client);
		if (widgetItems != null)
		{
			return widgetItems.stream()
				.filter(Objects::nonNull)
				.filter(predicate)
				.toArray(WidgetItem[]::new);
		}
		return new WidgetItem[0];
	}

	private Collection<WidgetItem> getEquippedItems(Client client)
	{
		Collection<WidgetItem> widgetItems = new ArrayList<>();
		Widget equipment = client.getWidget(WidgetInfo.EQUIPMENT);
		if (equipment != null && !equipment.isHidden())
		{
			if (slots.isEmpty())
			{
				slots.addAll(Arrays.asList(ALL_EQUIPMENT_WIDGET_INFOS));
			}
			for (WidgetInfo slot : slots)
			{
				Widget parentWidget = client.getWidget(slot);
				Widget itemWidget = parentWidget.getChild(1);
				// Check if background icon is hidden. if hidden, item is equipped.
				boolean equipped = parentWidget.getChild(2).isSelfHidden();
				// set bounds to same size as default inventory
				Rectangle bounds = itemWidget.getBounds();
				bounds.setBounds(bounds.x - 1, bounds.y - 1, 32, 32);
				// Index is set to 0 because there is no set in stone order of equipment slots
				widgetItems.add(new WidgetItem(equipped ? itemWidget.getItemId() : -1, itemWidget.getItemQuantity(), 0, bounds));
			}
		}
		return widgetItems;
	}
}
