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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemLayer;
import net.runelite.api.Node;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ItemManager;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.rs.api.ItemComposition;

public class GroundItemsOverlay extends Overlay
{
	private static final int REGION_SIZE = 104;
	// The game won't send anything higher than this value to the plugin -
	// so we replace any item quantity higher with "Lots" instead.
	private static final int MAX_QUANTITY = 65535;
	// The max distance between the player and the item.
	private static final int MAX_RANGE = 2400;
	// The 15 pixel gap between each drawn ground item.
	private static final int STRING_GAP = 15;
	// Threshold for highlighting items as blue.
	private static final int LOW_VALUE = 20_000;
	private static final Color BRIGHT_BLUE = new Color(102, 178, 255);
	// Threshold for highlighting items as green.
	private static final int MEDIUM_VALUE = 100_000;
	private static final Color BRIGHT_GREEN = new Color(153, 255, 153);
	// Threshold for highlighting items as amber.
	private static final int HIGH_VALUE = 1_000_000;
	private static final Color AMBER = new Color(255, 150, 0);
	// Threshold for highlighting items as pink.
	private static final int INSANE_VALUE = 10_000_000;
	private static final Color FADED_PINK = new Color(255, 102, 178);
	// Color to use if an item is highlighted in the config.
	private static final Color PURPLE = new Color(170, 0, 255);
	// Used when getting High Alchemy value - multiplied by general store price.
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	// Regex for splitting the hidden items in the config.
	private static final String DELIMITER_REGEX = "\\s*,\\s*";

	private final Client client = RuneLite.getClient();
	private final GroundItemsConfig config;
	private final ItemManager itemManager = RuneLite.getRunelite().getItemManager();
	private final StringBuilder itemStringBuilder = new StringBuilder();

	public GroundItemsOverlay(GroundItems plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.config = plugin.getConfig();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// won't draw if not logged in
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		//if the player is logged in but viewing the click to play screen exit
		if (client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null)
		{
			return null;
		}

		//Widget bank = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		//if (bank != null && !bank.isHidden())
		//{
		//	return null;
		//}

		// gets the hidden/highlighted items from the text box in the config
		String configItems = config.getHiddenItems();
		List<String> hiddenItems = Arrays.asList(configItems.split(DELIMITER_REGEX));
		// note: both of these lists are immutable
		configItems = config.getHighlightItems();
		List<String> highlightedItems = Arrays.asList(configItems.split(DELIMITER_REGEX));

		Region region = client.getRegion();
		Tile[][][] tiles = region.getTiles();
		FontMetrics fm = graphics.getFontMetrics();

		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		int z = client.getPlane();

		for (int x = 0; x < REGION_SIZE; x++)
		{
			for (int y = 0; y < REGION_SIZE; y++)
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

				if (player.getLocalLocation().distanceTo(itemLayer.getLocalLocation()) >= MAX_RANGE)
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

					Integer currentQuantity = items.get(itemId);
					if (currentQuantity == null)
					{
						items.put(itemId, itemQuantity);
					}
					else
					{
						items.put(itemId, currentQuantity + itemQuantity);
					}

					current = current.getNext();
				}

				// The bottom item is drawn first
				List<Integer> itemIds = new ArrayList<>(items.keySet());
				Collections.reverse(itemIds);

				for (int i = 0; i < itemIds.size(); ++i)
				{
					int itemId = itemIds.get(i);
					int quantity = items.get(itemId);
					ItemComposition item = client.getItemDefinition(itemId);

					if (item == null)
					{
						continue;
					}

					if (hiddenItems.contains(item.getName()))
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

					Color textColor = Color.WHITE; // Color to use when drawing the ground item
					ItemPrice itemPrice = itemManager.get(itemId);
					if (itemPrice != null && config.showGEPrice())
					{
						int cost = itemPrice.getPrice() * quantity;
						// set the color according to rarity, if possible
						if (cost >= INSANE_VALUE) // 10,000,000 gp
						{
							textColor = FADED_PINK;
						}
						else if (cost >= HIGH_VALUE) // 1,000,000 gp
						{
							textColor = AMBER;
						}
						else if (cost >= MEDIUM_VALUE) // 100,000 gp
						{
							textColor = BRIGHT_GREEN;
						}
						else if (cost >= LOW_VALUE) // 20,000 gp
						{
							textColor = BRIGHT_BLUE;
						}

						itemStringBuilder.append(" (EX: ")
							.append(ItemManager.quantityToStackSize(cost))
							.append(" gp)");
					}

					if (config.showHAValue())
					{
						itemStringBuilder.append(" (HA: ")
							.append(Math.round(item.getPrice() * HIGH_ALCHEMY_CONSTANT))
							.append(" gp)");
					}

					if (highlightedItems.contains(item.getName()))
					{
						textColor = PURPLE;
					}

					String itemString = itemStringBuilder.toString();
					itemStringBuilder.setLength(0);

					Point point = itemLayer.getCanvasLocation();
					// if the item is offscreen, don't bother drawing it
					if (point == null)
					{
						continue;
					}

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
}
