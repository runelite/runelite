/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.plugins.grounditems.config.ItemHighlightMode.MENU;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;

public class GroundItemsOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2500;
	// We must offset the text on the z-axis such that
	// it doesn't obscure the ground items below it.
	private static final int OFFSET_Z = 20;
	// The game won't send anything higher than this value to the plugin -
	// so we replace any item quantity higher with "Lots" instead.
	private static final int MAX_QUANTITY = 65535;
	// The 15 pixel gap between each drawn ground item.
	private static final int STRING_GAP = 15;
	// Size of the hidden/highlight boxes
	private static final int RECTANGLE_SIZE = 8;

	private final Client client;
	private final GroundItemsPlugin plugin;
	private final GroundItemsConfig config;
	private final StringBuilder itemStringBuilder = new StringBuilder();
	private final TextComponent textComponent = new TextComponent();
	private final Map<WorldPoint, Integer> offsetMap = new HashMap<>();
	private final ItemManager itemManager;

	@Inject
	public GroundItemsOverlay(Client client, GroundItemsPlugin plugin, GroundItemsConfig config, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isHotKeyPressed() && config.itemHighlightMode() == MENU)
		{
			return null;
		}

		final FontMetrics fm = graphics.getFontMetrics();
		final Player player = client.getLocalPlayer();

		if (player == null || client.getViewportWidget() == null)
		{
			return null;
		}

		plugin.checkItems();

		offsetMap.clear();
		final LocalPoint localLocation = player.getLocalLocation();

		for (GroundItem item : plugin.getCollectedGroundItems().values())
		{
			final LocalPoint groundPoint = LocalPoint.fromWorld(client, item.getLocation());

			if (groundPoint == null || localLocation.distanceTo(groundPoint) > MAX_DISTANCE)
			{
				continue;
			}

			final boolean highlighted = plugin.isHighlighted(item.getName());
			final boolean hidden = plugin.isHidden(item.getName());

			if (!plugin.isHotKeyPressed())
			{
				// Do not display hidden items
				if (hidden)
				{
					continue;
				}

				// Do not display non-highlighted items when only highlighted items should be shown
				if (config.showHighlightedOnly() && !highlighted)
				{
					continue;
				}
			}

			// Update GE price for item
			final ItemPrice itemPrice = itemManager.getItemPriceAsync(item.getItemId());

			if (itemPrice != null && itemPrice.getPrice() > 0)
			{
				item.setGePrice(itemPrice.getPrice() * item.getQuantity());
			}

			// Do not display items that are under HA or GE price and are not highlighted
			if (!plugin.isHotKeyPressed() && !highlighted
				&& ((item.getGePrice() > 0 && item.getGePrice() < config.getHideUnderGeValue())
				|| item.getHaPrice() < config.getHideUnderHAValue()))
			{
				continue;
			}

			final Color color = getCostColor(item.getGePrice() > 0 ? item.getGePrice() : item.getHaPrice(),
				highlighted, hidden);
			itemStringBuilder.append(item.getName());

			if (item.getQuantity() > 1)
			{
				if (item.getQuantity() >= MAX_QUANTITY)
				{
					itemStringBuilder.append(" (Lots!)");
				}
				else
				{
					itemStringBuilder.append(" (")
							.append(StackFormatter.quantityToStackSize(item.getQuantity()))
							.append(")");
				}
			}

			if (config.showGEPrice() && item.getGePrice() > 0)
			{
				itemStringBuilder.append(" (EX: ")
					.append(StackFormatter.quantityToStackSize(item.getGePrice()))
					.append(" gp)");
			}

			if (config.showHAValue() && item.getHaPrice() > 0)
			{
				itemStringBuilder.append(" (HA: ")
					.append(StackFormatter.quantityToStackSize(item.getHaPrice()))
					.append(" gp)");
			}

			final String itemString = itemStringBuilder.toString();
			itemStringBuilder.setLength(0);

			final Point textPoint = Perspective.getCanvasTextLocation(client,
				graphics,
				groundPoint,
				itemString,
				item.getHeight() + OFFSET_Z);

			if (textPoint == null)
			{
				continue;
			}

			final int offset = offsetMap.compute(item.getLocation(), (k, v) -> v != null ? v + 1 : 0);
			final int textX = textPoint.getX();
			final int textY = textPoint.getY() - (STRING_GAP * offset);

			textComponent.setText(itemString);
			textComponent.setColor(color);
			textComponent.setPosition(new java.awt.Point(textX, textY));
			textComponent.render(graphics);

			if (plugin.isHotKeyPressed())
			{
				final int stringWidth = fm.stringWidth(itemString);
				final int stringHeight = fm.getHeight();

				// Hidden box
				final Rectangle itemHiddenBox = new Rectangle(
					textX + stringWidth,
					textY - (RECTANGLE_SIZE + stringHeight) / 2,
					RECTANGLE_SIZE,
					RECTANGLE_SIZE);

				plugin.getHiddenBoxes().put(itemHiddenBox, item.getName());

				// Highlight box
				final Rectangle itemHighlightBox = new Rectangle(
					textX + stringWidth + RECTANGLE_SIZE + 2,
					textY - (RECTANGLE_SIZE + stringHeight) / 2,
					RECTANGLE_SIZE,
					RECTANGLE_SIZE);

				plugin.getHighlightBoxes().put(itemHighlightBox, item.getName());

				final Point mousePos = client.getMouseCanvasPosition();
				boolean mouseInHiddenBox = itemHiddenBox.contains(mousePos.getX(), mousePos.getY());
				boolean mouseInHighlightBox = itemHighlightBox.contains(mousePos.getX(), mousePos.getY());

				// Draw hidden box
				drawRectangle(graphics, itemHiddenBox, mouseInHiddenBox ? Color.RED : color, hidden, true);

				// Draw highlight box
				drawRectangle(graphics, itemHighlightBox, mouseInHighlightBox ? Color.GREEN : color, highlighted, false);
			}
		}

		return null;
	}

	Color getCostColor(int cost, boolean highlighted, boolean hidden)
	{
		if (hidden)
		{
			return Color.GRAY;
		}

		if (highlighted)
		{
			return config.highlightedColor();
		}

		// set the color according to rarity, if possible
		if (cost >= config.insaneValuePrice())
		{
			return config.insaneValueColor();
		}

		if (cost >= config.highValuePrice())
		{
			return config.highValueColor();
		}

		if (cost >= config.mediumValuePrice())
		{
			return config.mediumValueColor();
		}

		if (cost >= config.lowValuePrice())
		{
			return config.lowValueColor();
		}

		return config.defaultColor();
	}

	private void drawRectangle(Graphics2D graphics, Rectangle rect, Color color, boolean inList, boolean hiddenBox)
	{
		graphics.setColor(Color.BLACK);
		graphics.drawRect(rect.x + 1, rect.y + 1, rect.width, rect.height);

		graphics.setColor(color);
		graphics.draw(rect);

		if (inList)
		{
			graphics.fill(rect);
		}

		graphics.setColor(Color.WHITE);
		// Minus symbol
		graphics.drawLine
			(
				rect.x + 2,
				rect.y + (RECTANGLE_SIZE / 2),
				rect.x + RECTANGLE_SIZE - 2,
				rect.y + (RECTANGLE_SIZE / 2)
			);

		if (!hiddenBox)
		{
			// Plus symbol
			graphics.drawLine
				(
					rect.x + (RECTANGLE_SIZE / 2),
					rect.y + 2,
					rect.x + (RECTANGLE_SIZE / 2),
					rect.y + RECTANGLE_SIZE - 2
				);
		}

	}

}
