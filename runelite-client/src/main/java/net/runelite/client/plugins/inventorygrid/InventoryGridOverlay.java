/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.inventorygrid;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
class InventoryGridOverlay extends Overlay
{
	private static final int INVENTORY_SIZE = 28;

	private final InventoryGridPlugin plugin;
	private final Client client;
	private final ItemManager itemManager;

	@Inject
	private InventoryGridOverlay(final InventoryGridPlugin plugin, final Client client, final ItemManager itemManager)
	{
		this.itemManager = itemManager;
		this.client = client;
		this.plugin = plugin;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget if1DraggingWidget = client.getIf1DraggedWidget();
		final Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);

		if (if1DraggingWidget == null || if1DraggingWidget != inventoryWidget
			|| client.getItemPressedDuration() < plugin.getDragDelay() / Constants.CLIENT_TICK_LENGTH)
		{
			return null;
		}

		final net.runelite.api.Point mouse = client.getMouseCanvasPosition();
		final Point mousePoint = new Point(mouse.getX(), mouse.getY());
		final int if1DraggedItemIndex = client.getIf1DraggedItemIndex();
		final WidgetItem draggedItem = inventoryWidget.getWidgetItem(if1DraggedItemIndex);
		final int itemId = draggedItem.getId();
		final Rectangle initialBounds = draggedItem.getCanvasBounds();

		if (itemId == -1)
		{
			return null;
		}

		for (int i = 0; i < INVENTORY_SIZE; ++i)
		{
			WidgetItem widgetItem = inventoryWidget.getWidgetItem(i);
			final int targetItemId = widgetItem.getId();

			final Rectangle bounds = widgetItem.getCanvasBounds();
			boolean inBounds = bounds.contains(mousePoint);

			if (plugin.isShowItem() && inBounds)
			{
				drawItem(graphics, bounds, itemId);
				drawItem(graphics, initialBounds, targetItemId);
			}

			if (plugin.isShowHighlight() && inBounds)
			{
				graphics.setColor(plugin.getHighlightColor());
				graphics.fill(bounds);
			}
			else if (plugin.isShowGrid())
			{
				graphics.setColor(plugin.getGridColor());
				graphics.fill(bounds);
			}
		}

		return null;
	}

	private void drawItem(Graphics2D graphics, Rectangle bounds, int itemId)
	{
		if (itemId == -1)
		{
			return;
		}

		final BufferedImage draggedItemImage = itemManager.getImage(itemId);
		final int x = (int) bounds.getX();
		final int y = (int) bounds.getY();

		graphics.setComposite(AlphaComposite.SrcOver.derive(0.3f));
		graphics.drawImage(draggedItemImage, x, y, null);
		graphics.setComposite(AlphaComposite.SrcOver);
	}
}
