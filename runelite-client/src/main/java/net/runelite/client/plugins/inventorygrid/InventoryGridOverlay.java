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
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class InventoryGridOverlay extends Overlay
{
	private static final int INVENTORY_SIZE = 28;
	private static final int DISTANCE_TO_ACTIVATE_HOVER = 5;

	private static final Color HIGHLIGHT = new Color(0, 255, 0, 45);
	private static final Color GRID = new Color(255, 255, 255, 45);

	private final InventoryGridConfig config;
	private final Client client;
	private final ItemManager itemManager;

	private Point initialMousePoint;
	private boolean hoverActive = false;

	@Inject
	private InventoryGridOverlay(InventoryGridConfig config, Client client, ItemManager itemManager)
	{
		this.itemManager = itemManager;
		this.client = client;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget if1DraggingWidget = client.getIf1DraggedWidget();
		final Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);

		if (if1DraggingWidget == null || if1DraggingWidget != inventoryWidget)
		{
			initialMousePoint = null;
			hoverActive = false;
			return null;
		}

		final net.runelite.api.Point mouse = client.getMouseCanvasPosition();
		final Point mousePoint = new Point(mouse.getX(), mouse.getY());
		final int if1DraggedItemIndex = client.getIf1DraggedItemIndex();
		final WidgetItem draggedItem = inventoryWidget.getWidgetItem(if1DraggedItemIndex);
		final Rectangle initialBounds = draggedItem.getCanvasBounds();

		if (initialMousePoint == null)
		{
			initialMousePoint = mousePoint;
		}

		if (draggedItem.getId() == -1 || !hoverActive && initialMousePoint.distance(mousePoint) < DISTANCE_TO_ACTIVATE_HOVER)
		{
			return null;
		}

		hoverActive = true;

		for (int i = 0; i < INVENTORY_SIZE; ++i)
		{
			WidgetItem targetWidgetItem = inventoryWidget.getWidgetItem(i);

			final Rectangle bounds = targetWidgetItem.getCanvasBounds(false);
			boolean inBounds = bounds.contains(mousePoint);

			if (config.showItem() && inBounds)
			{
				drawItem(graphics, bounds, draggedItem);
				drawItem(graphics, initialBounds, targetWidgetItem);
			}

			if (config.showHighlight() && inBounds)
			{
				graphics.setColor(HIGHLIGHT);
				graphics.fill(bounds);
			}
			else if (config.showGrid())
			{
				graphics.setColor(GRID);
				graphics.fill(bounds);
			}
		}

		return null;
	}

	private void drawItem(Graphics2D graphics, Rectangle bounds, WidgetItem item)
	{
		if (item.getId() == -1)
		{
			return;
		}

		final BufferedImage draggedItemImage = itemManager.getImage(item.getId(), item.getQuantity(), false);
		final int x = (int) bounds.getX();
		final int y = (int) bounds.getY();

		graphics.setComposite(AlphaComposite.SrcOver.derive(0.3f));
		graphics.drawImage(draggedItemImage, x, y, null);
		graphics.setComposite(AlphaComposite.SrcOver);
	}
}
