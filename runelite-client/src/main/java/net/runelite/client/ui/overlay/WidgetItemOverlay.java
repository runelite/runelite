/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collection;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;

public abstract class WidgetItemOverlay extends Overlay
{
	@Setter(AccessLevel.PACKAGE)
	private OverlayManager overlayManager;

	protected WidgetItemOverlay()
	{
		super.setPosition(OverlayPosition.DYNAMIC);
		super.setPriority(PRIORITY_LOW);
		super.setLayer(OverlayLayer.MANUAL);
	}

	public abstract void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem);

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Collection<WidgetItem> widgetItems = overlayManager.getWidgetItems();
		final Rectangle originalClipBounds = graphics.getClipBounds();
		Widget curClipParent = null;
		for (WidgetItem widgetItem : widgetItems)
		{
			Widget widget = widgetItem.getWidget();
			Widget parent = widget.getParent();
			Rectangle parentBounds = parent.getBounds();
			Rectangle itemCanvasBounds = widgetItem.getCanvasBounds();
			boolean dragging = widgetItem.getDraggingCanvasBounds() != null;

			boolean shouldClip;
			if (dragging)
			{
				// If dragging, clip if the dragged item is outside of the parent bounds
				shouldClip = itemCanvasBounds.x < parentBounds.x;
				shouldClip |= itemCanvasBounds.x + itemCanvasBounds.width >= parentBounds.x + parentBounds.width;
				shouldClip |= itemCanvasBounds.y < parentBounds.y;
				shouldClip |= itemCanvasBounds.y + itemCanvasBounds.height >= parentBounds.y + parentBounds.height;
			}
			else
			{
				// Otherwise, we only need to clip the overlay if it intersects the parent bounds,
				// since items completely outside of the parent bounds are not drawn
				shouldClip = itemCanvasBounds.y < parentBounds.y && itemCanvasBounds.y + itemCanvasBounds.height >= parentBounds.y;
				shouldClip |= itemCanvasBounds.y < parentBounds.y + parentBounds.height && itemCanvasBounds.y + itemCanvasBounds.height >= parentBounds.y + parentBounds.height;
				shouldClip |= itemCanvasBounds.x < parentBounds.x && itemCanvasBounds.x + itemCanvasBounds.width >= parentBounds.x;
				shouldClip |= itemCanvasBounds.x < parentBounds.x + parentBounds.width && itemCanvasBounds.x + itemCanvasBounds.width >= parentBounds.x + parentBounds.width;
			}
			if (shouldClip)
			{
				if (curClipParent != parent)
				{
					graphics.setClip(parentBounds);
					curClipParent = parent;
				}
			}
			else if (curClipParent != null && curClipParent != parent)
			{
				graphics.setClip(originalClipBounds);
				curClipParent = null;
			}

			renderItemOverlay(graphics, widgetItem.getId(), widgetItem);
		}
		return null;
	}

	protected void showOnInventory()
	{
		showOnInterfaces(
			InterfaceID.DEPOSIT_BOX,
			InterfaceID.BANK_INVENTORY,
			InterfaceID.SHOP_INVENTORY,
			InterfaceID.GRAND_EXCHANGE_INVENTORY,
			InterfaceID.GUIDE_PRICES_INVENTORY,
			InterfaceID.EQUIPMENT_INVENTORY,
			InterfaceID.INVENTORY,
			InterfaceID.SEED_VAULT_INVENTORY,
			InterfaceID.TRADE,
			InterfaceID.TRADE_INVENTORY,
			InterfaceID.POH_TREASURE_CHEST_INV);
	}

	protected void showOnBank()
	{
		drawAfterLayer(ComponentID.BANK_ITEM_CONTAINER);
		drawAfterLayer(ComponentID.GROUP_STORAGE_ITEM_CONTAINER);
	}

	protected void showOnEquipment()
	{
		showOnInterfaces(InterfaceID.EQUIPMENT);
	}

	protected void showOnInterfaces(int... ids)
	{
		Arrays.stream(ids).forEach(this::drawAfterInterface);
	}

	// Don't allow setting position or layer

	@Override
	public void setPosition(OverlayPosition position)
	{
		throw new IllegalStateException();
	}

	@Override
	public void setLayer(OverlayLayer layer)
	{
		throw new IllegalStateException();
	}
}
