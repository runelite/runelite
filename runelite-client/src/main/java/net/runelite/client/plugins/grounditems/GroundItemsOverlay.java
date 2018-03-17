/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.grounditems;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemLayer;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.StackFormatter;

public class GroundItemsOverlay extends Overlay
{
	private static final int REGION_SIZE = 104;
	// We must offset the text on the z-axis such that
	// it doesn't obscure the ground items below it.
	private static final int OFFSET_Z = 20;
	// The game won't send anything higher than this value to the plugin -
	// so we replace any item quantity higher with "Lots" instead.
	private static final int MAX_QUANTITY = 65535;
	// The max distance in tiles between the player and the item.
	private static final int MAX_RANGE = 18;
	// The 15 pixel gap between each drawn ground item.
	private static final int STRING_GAP = 15;

	private final Client client;
	private final GroundItemsConfig config;
	private final StringBuilder itemStringBuilder = new StringBuilder();
	private final GroundItemsService groundItemsService;

	@Inject
	public GroundItemsOverlay(Client client, GroundItemsConfig config, GroundItemsService groundItemsService)
	{
		this.groundItemsService = groundItemsService;
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point parent)
	{
		final Region region = client.getRegion();
		final Tile[][][] tiles = region.getTiles();
		final FontMetrics fm = graphics.getFontMetrics();
		final Player player = client.getLocalPlayer();

		if (player == null || client.getViewportWidget() == null)
		{
			return null;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());

		final int z = client.getPlane();
		final LocalPoint from = player.getLocalLocation();

		final int lowerX = max(0, from.getRegionX() - MAX_RANGE);
		final int lowerY = max(0, from.getRegionY() - MAX_RANGE);

		final int upperX = min(from.getRegionX() + MAX_RANGE, REGION_SIZE - 1);
		final int upperY = min(from.getRegionY() + MAX_RANGE, REGION_SIZE - 1);

		for (int x = lowerX; x <= upperX; ++x)
		{
			for (int y = lowerY; y <= upperY; ++y)
			{
				final Tile tile = tiles[z][x][y];

				if (tile == null)
				{
					continue;
				}

				final ItemLayer itemLayer = tile.getItemLayer();

				if (itemLayer == null)
				{
					continue;
				}

				final AtomicInteger index = new AtomicInteger();

				groundItemsService.filterAndCollect(itemLayer.getBottom()).forEach((name, item) ->
				{
					final Point point = itemLayer.getCanvasLocation(itemLayer.getHeight() + OFFSET_Z);

					// if the item is offscreen, don't bother drawing it
					if (point == null)
					{
						return;
					}

					// Always check first if item is not highlighted and then check for respective prices
					// of item and do not hide it in case it's GE price is 0 but its below threshold or it's
					// HA price is 0 and it's below threshold
					if (!groundItemsService.wildcardMatch(name, false)
						&& ((item.getGePrice() > 0 && item.getGePrice() < config.getHideUnderGeValue())
						|| item.getHaPrice() > 0 && item.getHaPrice() < config.getHideUnderHAValue()))
					{
						return;
					}

					itemStringBuilder.append(name);

					if (item.getQuantity() > 1)
					{
						if (item.getQuantity() >= MAX_QUANTITY)
						{
							itemStringBuilder.append(" (Lots!)");
						}
						else
						{
							itemStringBuilder.append(" (").append(item.getQuantity()).append(")");
						}
					}

					// Color to use when drawing the ground item
					final Color textColor = groundItemsService.getCostColor(name, item.getGePrice());

					if (config.showGEPrice() && item.getGePrice() > 0)
					{
						itemStringBuilder.append(" (EX: ")
							.append(StackFormatter.quantityToStackSize(item.getGePrice()))
							.append(" gp)");
					}

					if (config.showHAValue() && item.getHaPrice() > 0)
					{
						itemStringBuilder.append(" (HA: ")
							.append(item.getHaPrice())
							.append(" gp)");
					}

					final String itemString = itemStringBuilder.toString();
					itemStringBuilder.setLength(0);

					int screenX = point.getX() + 2 - (fm.stringWidth(itemString) / 2);
					int i = index.getAndIncrement();

					// Drawing the shadow for the text, 1px on both x and y
					graphics.setColor(Color.BLACK);
					graphics.drawString(itemString, screenX + 1, point.getY() - (STRING_GAP * i) + 1);

					// Drawing the text itself
					graphics.setColor(textColor);
					graphics.drawString(itemString, screenX, point.getY() - (STRING_GAP * i));

				});
			}
		}

		return null;
	}
}
