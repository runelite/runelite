/*
 * Copyright (c) 2018, Drizzy <Admin@DrizzyBot.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.inventorygrid;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class InventoryOverlay extends Overlay
{
	private final Client client;
	private final InventoryGridPlugin plugin;
	private final InventoryGridConfig config;
	private static final int ITEM_WIDTH = 32;
	private static final int ITEM_HEIGHT = 32;
	private static final int ITEM_MARGIN_X = 10;
	private static final int ITEM_MARGIN_Y = 4;

	@Inject
	InventoryOverlay(Client client, InventoryGridPlugin plugin, InventoryGridConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (client.getGameState() != GameState.LOGGED_IN || inventory == null || inventory.isHidden())
		{
			return null;
		}

		final int inventoryX = inventory.getCanvasLocation().getX();
		final int inventoryY = inventory.getCanvasLocation().getY();

		graphics.setColor(config.getGridColor());

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				final int x = (ITEM_WIDTH + ITEM_MARGIN_X) * i + inventoryX;
				final int y = (ITEM_HEIGHT + ITEM_MARGIN_Y) * j + inventoryY;
				final Rectangle bounds = new Rectangle(x, y, ITEM_WIDTH, ITEM_HEIGHT);
				graphics.draw(bounds);
			}
		}

		return null;
	}
}
