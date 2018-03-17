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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.ItemLayer;
import net.runelite.api.Node;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;

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
	// Threshold for highlighting items as blue.
	static final int LOW_VALUE = 20_000;
	// Threshold for highlighting items as green.
	private static final int MEDIUM_VALUE = 100_000;
	// Threshold for highlighting items as amber.
	private static final int HIGH_VALUE = 1_000_000;
	// Threshold for highlighting items as pink.
	private static final int INSANE_VALUE = 10_000_000;
	// Used when getting High Alchemy value - multiplied by general store price.
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	// ItemID for coins
	private static final int COINS = ItemID.COINS_995;

	private final Client client;
	private final GroundItemsPlugin plugin;
	private final GroundItemsConfig config;
	private final StringBuilder itemStringBuilder = new StringBuilder();

	@Inject
	private ItemManager itemManager;

	@Inject
	public GroundItemsOverlay(Client client, GroundItemsPlugin plugin, GroundItemsConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point parent)
	{
		Region region = client.getRegion();
		Tile[][][] tiles = region.getTiles();
		FontMetrics fm = graphics.getFontMetrics();

		Player player = client.getLocalPlayer();
		if (player == null || client.getViewportWidget() == null)
		{
			return null;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());

		int z = client.getPlane();
		LocalPoint from = player.getLocalLocation();

		int lowerX = max(0, from.getRegionX() - MAX_RANGE);
		int lowerY = max(0, from.getRegionY() - MAX_RANGE);

		int upperX = min(from.getRegionX() + MAX_RANGE, REGION_SIZE - 1);
		int upperY = min(from.getRegionY() + MAX_RANGE, REGION_SIZE - 1);

		for (int x = lowerX; x <= upperX; ++x)
		{
			for (int y = lowerY; y <= upperY; ++y)
			{
				Tile tile = tiles[z][x][y];
				if (tile == null)
				{
					continue;
				}

				ItemLayer itemLayer = tile.getItemLayer();
				if (itemLayer == null)
				{
					continue;
				}

				Node current = itemLayer.getBottom();
				Map<Integer, Integer> items = new LinkedHashMap<>();
				// adds the items on the ground to the ArrayList to be drawn
				while (current instanceof Item)
				{
					Item item = (Item) current;
					int itemId = item.getId();
					int itemQuantity = item.getQuantity();
					ItemComposition itemDefinition = itemManager.getItemComposition(itemId);

					Integer currentQuantity = items.get(itemId);

					if (config.showHighlightedOnly() ? plugin.isHighlighted(itemDefinition.getName()) : !plugin.isHidden(itemDefinition.getName()))
					{
						if (itemDefinition.getNote() != -1)
						{
							itemId = itemDefinition.getLinkedNoteId();
						}

						int quantity = currentQuantity == null
							? itemQuantity
							: currentQuantity + itemQuantity;

						ItemPrice itemPrice = itemManager.getItemPriceAsync(itemId);

						int gePrice, alchPrice;

						if (itemId == COINS)
						{
							gePrice = quantity;
							alchPrice = quantity;
						}
						else
						{
							gePrice = itemPrice == null ? 0 : itemPrice.getPrice() * quantity;
							alchPrice = Math.round(itemDefinition.getPrice() * HIGH_ALCHEMY_CONSTANT) * quantity;
						}
						if (plugin.isHighlighted(itemDefinition.getName()) ||
							gePrice == 0 || ((gePrice >= config.getHideUnderGeValue()) &&
							(alchPrice >= config.getHideUnderHAValue())))
						{
							items.put(itemId, quantity);
						}
					}

					current = current.getNext();
				}

				// The bottom item is drawn first
				List<Integer> itemIds = new ArrayList<>(items.keySet());
				Collections.reverse(itemIds);

				for (int i = 0; i < itemIds.size(); ++i)
				{
					Point point = itemLayer.getCanvasLocation(itemLayer.getHeight() + OFFSET_Z);
					// if the item is offscreen, don't bother drawing it
					if (point == null)
					{
						continue;
					}

					int itemId = itemIds.get(i);
					int quantity = items.get(itemId);
					ItemComposition item = itemManager.getItemComposition(itemId);

					if (item == null)
					{
						continue;
					}

					itemStringBuilder.append(item.getName());
					if (quantity > 1)
					{
						if (quantity >= MAX_QUANTITY)
						{
							itemStringBuilder.append(" (Lots!)");
						}
						else
						{
							itemStringBuilder.append(" (").append(quantity).append(")");
						}
					}

					// sets item ID to unnoted version, if noted
					if (item.getNote() != -1)
					{
						itemId = item.getLinkedNoteId();
					}

					Color textColor = config.defaultColor(); // Color to use when drawing the ground item
					ItemPrice itemPrice = itemManager.getItemPriceAsync(itemId);
					if (itemPrice != null && config.showGEPrice())
					{
						int cost = itemPrice.getPrice() * quantity;

						textColor = getCostColor(cost);

						itemStringBuilder.append(" (EX: ")
							.append(StackFormatter.quantityToStackSize(cost))
							.append(" gp)");
					}

					if (config.showHAValue())
					{
						itemStringBuilder.append(" (HA: ")
							.append(Math.round(item.getPrice() * HIGH_ALCHEMY_CONSTANT) * quantity)
							.append(" gp)");
					}

					if (plugin.isHighlighted(item.getName()))
					{
						textColor = config.highlightedColor();
					}

					String itemString = itemStringBuilder.toString();
					itemStringBuilder.setLength(0);

					int screenX = point.getX() + 2 - (fm.stringWidth(itemString) / 2);

					// Drawing the shadow for the text, 1px on both x and y
					graphics.setColor(Color.BLACK);
					graphics.drawString(itemString, screenX + 1, point.getY() - (STRING_GAP * i) + 1);
					// Drawing the text itself
					graphics.setColor(textColor);
					graphics.drawString(itemString, screenX, point.getY() - (STRING_GAP * i));
				}
			}
		}

		return null;
	}

	Color getCostColor(int cost)
	{
		// set the color according to rarity, if possible
		if (cost >= INSANE_VALUE) // 10,000,000 gp
		{
			return config.insaneValueColor();
		}
		else if (cost >= HIGH_VALUE) // 1,000,000 gp
		{
			return config.highValueColor();
		}
		else if (cost >= MEDIUM_VALUE) // 100,000 gp
		{
			return config.mediumValueColor();
		}
		else if (cost >= LOW_VALUE) // 20,000 gp
		{
			return config.lowValueColor();
		}
		else
		{
			return config.defaultColor();
		}
	}

}
