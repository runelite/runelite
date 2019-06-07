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
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import api.Client;
import api.widgets.Widget;
import api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;

public class InventoryHighlightOverlay extends Overlay
{
	private final InventoryHighlightPlugin plugin;
	private final InventoryHighlightConfig config;
	private final Client client;
	private final ItemManager itemManager;

	// the inventory widget location is slightly off
	private static final int FIXED_MARGIN_X = -10;
	private static final int FIXED_MARGIN_Y = -25;
	private static final int RESIZEABLE_MARGIN_X = -6;
	private static final int RESIZEABLE_MARGIN_Y = -21;

	private static final int ITEM_WIDTH = 32;
	private static final int ITEM_HEIGHT = 32;
	private static final int ITEM_MARGIN_X = 10;
	private static final int ITEM_MARGIN_Y = 4;

	private static final Color HIGHLIGHT = new Color(0, 255, 0, 45);
	private static final Color GRID = new Color(255, 255, 255, 45);

	@Inject
	public InventoryHighlightOverlay(InventoryHighlightPlugin plugin, InventoryHighlightConfig config, Client client, ItemManager itemManager)
	{
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.client = client;
		this.config = config;

		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getDraggingItem() == -1 || !plugin.isDragging())
		{
			return null;
		}

		int marginX, marginY;
		if (client.isResized())
		{
			marginX = RESIZEABLE_MARGIN_X;
			marginY = RESIZEABLE_MARGIN_Y;
		}
		else
		{
			marginX = FIXED_MARGIN_X;
			marginY = FIXED_MARGIN_Y;
		}

		final api.Point mouse = client.getMouseCanvasPosition();
		final Point updatedMouse = new Point(mouse.getX() + marginX, mouse.getY() + marginY);

		// null checks for inventory are checked during dragging events
		final Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);

		final int inventoryX = inventoryWidget.getCanvasLocation().getX() + marginX;
		final int inventoryY = inventoryWidget.getCanvasLocation().getY() + marginY;

		final BufferedImage draggedItemImage = itemManager.getImage(plugin.getDraggingItem());

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				final int x = (ITEM_WIDTH + ITEM_MARGIN_X) * i + inventoryX;
				final int y = (ITEM_HEIGHT + ITEM_MARGIN_Y) * j + inventoryY;
				final Rectangle bounds = new Rectangle(x, y, ITEM_WIDTH, ITEM_HEIGHT);

				if (config.showItem() && bounds.contains(updatedMouse))
				{
					graphics.setComposite(AlphaComposite.SrcOver.derive(0.3f));
					graphics.drawImage(draggedItemImage, x, y, null);
					graphics.setComposite(AlphaComposite.SrcOver);
				}

				if (config.showHighlight() && bounds.contains(updatedMouse))
				{
					graphics.setColor(HIGHLIGHT);
					graphics.fill(bounds);
				}

				if (config.showGrid())
				{
					// don't set color on highlighted slot
					if (!config.showHighlight() || !(config.showHighlight() && bounds.contains(updatedMouse)))
					{
						graphics.setColor(GRID);
						graphics.fill(bounds);
					}
				}
			}
		}

		return null;
	}
}
