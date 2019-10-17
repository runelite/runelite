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
import java.awt.Polygon;
import java.awt.Rectangle;
import java.time.Duration;
import java.time.Instant;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.grounditems.config.ItemHighlightMode.MENU;
import net.runelite.client.plugins.grounditems.config.PriceDisplayMode;
import net.runelite.client.plugins.grounditems.config.TimerDisplayMode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.QuantityFormatter;

@Singleton
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

	private static final int TIMER_OVERLAY_DIAMETER = 10;
	private static final int PUBLIC_ITEM_DURATION_MILLIS = 60000;
	private static final float WARNING_THRESHOLD = 0.25f;
	private static final Color PUBLIC_TIMER_COLOR = Color.YELLOW;
	private static final Color PRIVATE_TIMER_COLOR = Color.GREEN;
	private static final Color PUBLIC_WARNING_TIMER_COLOR = Color.RED;

	private final Client client;
	private final GroundItemsPlugin plugin;
	private final StringBuilder itemStringBuilder = new StringBuilder();
	private final BackgroundComponent backgroundComponent = new BackgroundComponent();
	private final TextComponent textComponent = new TextComponent();
	private final ProgressPieComponent progressPieComponent = new ProgressPieComponent();
	private final Map<WorldPoint, Integer> offsetMap = new HashMap<>();

	@Inject
	private GroundItemsOverlay(final Client client, final GroundItemsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final boolean dontShowOverlay = (plugin.getItemHighlightMode() == MENU || plugin.isHideAll()) && !plugin.isHotKeyPressed();

		if (dontShowOverlay && !plugin.isHighlightTiles())
		{
			return null;
		}

		final FontMetrics fm = graphics.getFontMetrics();
		final Player player = client.getLocalPlayer();

		if (player == null || client.getViewportWidget() == null)
		{
			return null;
		}

		offsetMap.clear();
		final LocalPoint localLocation = player.getLocalLocation();
		final Point mousePos = client.getMouseCanvasPosition();
		Collection<GroundItem> groundItemList = GroundItemsPlugin.getCollectedGroundItems().values();
		GroundItem topGroundItem = null;

		if (plugin.isHotKeyPressed())
		{
			// Make copy of ground items because we are going to modify them here, and the array list supports our
			// desired behaviour here
			groundItemList = new ArrayList<>(groundItemList);
			final java.awt.Point awtMousePos = new java.awt.Point(mousePos.getX(), mousePos.getY());
			GroundItem groundItem = null;

			for (GroundItem item : groundItemList)
			{
				item.setOffset(offsetMap.compute(item.getLocation(), (k, v) -> v != null ? v + 1 : 0));

				if (groundItem != null)
				{
					continue;
				}

				if (plugin.getTextBoxBounds() != null
					&& item.equals(plugin.getTextBoxBounds().getValue())
					&& plugin.getTextBoxBounds().getKey().contains(awtMousePos))
				{
					groundItem = item;
					continue;
				}

				if (plugin.getHiddenBoxBounds() != null
					&& item.equals(plugin.getHiddenBoxBounds().getValue())
					&& plugin.getHiddenBoxBounds().getKey().contains(awtMousePos))
				{
					groundItem = item;
					continue;
				}

				if (plugin.getHighlightBoxBounds() != null
					&& item.equals(plugin.getHighlightBoxBounds().getValue())
					&& plugin.getHighlightBoxBounds().getKey().contains(awtMousePos))
				{
					groundItem = item;
				}
			}

			if (groundItem != null)
			{
				groundItemList.remove(groundItem);
				groundItemList.add(groundItem);
				topGroundItem = groundItem;
			}
		}

		plugin.setTextBoxBounds(null);
		plugin.setHiddenBoxBounds(null);
		plugin.setHighlightBoxBounds(null);

		final boolean onlyShowLoot = plugin.isOnlyShowLoot();

		List<GroundItem> groundItemListAsList = new ArrayList<>(groundItemList);  // make a copy so we can non-destructively modify the list

		Comparator<GroundItem> compareByHaPrice = Comparator.comparingInt(GroundItem::getHaPrice);
		Comparator<GroundItem> compareByGePrice = Comparator.comparingInt(GroundItem::getGePrice);
		groundItemListAsList.sort(plugin.isSortByGEPrice() ? compareByGePrice : compareByHaPrice);

		for (GroundItem item : groundItemListAsList)
		{
			final LocalPoint groundPoint = LocalPoint.fromWorld(client, item.getLocation());

			if (groundPoint == null || localLocation.distanceTo(groundPoint) > MAX_DISTANCE
				|| (onlyShowLoot && !item.isMine()))
			{
				continue;
			}

			Color highlighted = plugin.getHighlighted(item.getName(), item.getGePrice(), item.getHaPrice());

			//Process skill items
			if (!plugin.hiddenItems.getUnchecked(item.getName()))
			{
				if (plugin.highlightHerblore)
				{
					if (GroundItemsPlugin.herbloreItems.contains(item.getId()))
					{
						highlighted = plugin.getHerbloreColor();
					}
				}
				if (plugin.highlightPrayer)
				{
					if (GroundItemsPlugin.prayerItems.contains(item.getId()))
					{
						highlighted = plugin.getPrayerColor();
					}
				}
			}

			// Value overrides skill
			if (plugin.getHighlighted(item.getName(), item.getGePrice(), item.getHaPrice()) != null)
			{
				if (plugin.getHighlighted(item.getName(), item.getGePrice(), item.getHaPrice()).getRGB() != highlighted.getRGB())
				{
					highlighted = plugin.getHighlighted(item.getName(), item.getGePrice(), item.getHaPrice());
				}
			}

			final Color hidden = plugin.getHidden(item.getName(), item.getGePrice(), item.getHaPrice(), item.isTradeable());

			if (highlighted == null && !plugin.isHotKeyPressed())
			{
				// Do not display hidden items
				if (hidden != null)
				{
					continue;
				}

				// Do not display non-highlighted items
				if (plugin.isShowHighlightedOnly())
				{
					continue;
				}
			}

			final Color color = plugin.getItemColor(highlighted, hidden);

			if (plugin.isHighlightTiles())
			{
				final Polygon poly = Perspective.getCanvasTilePoly(client, groundPoint);

				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, color);
				}
			}

			if (dontShowOverlay)
			{
				continue;
			}

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
						.append(QuantityFormatter.quantityToStackSize(item.getQuantity()))
						.append(")");
				}
			}

			if (plugin.getPriceDisplayMode() == PriceDisplayMode.BOTH)
			{
				if (item.getGePrice() > 0)
				{
					itemStringBuilder.append(" (EX: ")
						.append(QuantityFormatter.quantityToStackSize(item.getGePrice()))
						.append(" gp)");
				}

				if (item.getHaPrice() > 0)
				{
					itemStringBuilder.append(" (HA: ")
						.append(QuantityFormatter.quantityToStackSize(item.getHaPrice()))
						.append(" gp)");
				}
			}
			else if (plugin.getPriceDisplayMode() != PriceDisplayMode.OFF)
			{
				final int price = plugin.getPriceDisplayMode() == PriceDisplayMode.GE
					? item.getGePrice()
					: item.getHaPrice();

				if (price > 0)
				{
					itemStringBuilder
						.append(" (")
						.append(QuantityFormatter.quantityToStackSize(price))
						.append(" gp)");
				}
			}

			if (item.getTicks() > 0 && plugin.isShowTimer())
			{
				itemStringBuilder
					.append(" - ")
					.append(item.getTicks());
			}

			final String itemString = itemStringBuilder.toString();
			itemStringBuilder.setLength(0);

			if (item.getHeight() == -1)
			{
				final Tile[][][] sceneTiles = client.getScene().getTiles();
				final Tile itemTile = sceneTiles[client.getPlane()][groundPoint.getSceneX()][groundPoint.getSceneY()];
				item.setHeight(itemTile.getItemLayer().getHeight());
			}

			final Point textPoint = Perspective.getCanvasTextLocation(client,
				graphics,
				groundPoint,
				itemString,
				item.getHeight() + OFFSET_Z);

			if (textPoint == null)
			{
				continue;
			}

			final int offset = plugin.isHotKeyPressed()
				? item.getOffset()
				: offsetMap.compute(item.getLocation(), (k, v) -> v != null ? v + 1 : 0);

			final int textX = textPoint.getX();
			final int textY = textPoint.getY() - (STRING_GAP * offset);

			if (plugin.isHotKeyPressed())
			{
				final int stringWidth = fm.stringWidth(itemString);
				final int stringHeight = fm.getHeight();

				// Item bounds
				int x = textX - 2;
				int y = textY - stringHeight - 2;
				int width = stringWidth + 4;
				int height = stringHeight + 4;
				final Rectangle itemBounds = new Rectangle(x, y, width, height);

				// Hidden box
				x += width + 2;
				y = textY - (RECTANGLE_SIZE + stringHeight) / 2;
				width = height = RECTANGLE_SIZE;
				final Rectangle itemHiddenBox = new Rectangle(x, y, width, height);

				// Highlight box
				x += width + 2;
				final Rectangle itemHighlightBox = new Rectangle(x, y, width, height);

				boolean mouseInBox = itemBounds.contains(mousePos.getX(), mousePos.getY());
				boolean mouseInHiddenBox = itemHiddenBox.contains(mousePos.getX(), mousePos.getY());
				boolean mouseInHighlightBox = itemHighlightBox.contains(mousePos.getX(), mousePos.getY());

				if (mouseInBox)
				{
					plugin.setTextBoxBounds(new SimpleEntry<>(itemBounds, item));
				}
				else if (mouseInHiddenBox)
				{
					plugin.setHiddenBoxBounds(new SimpleEntry<>(itemHiddenBox, item));

				}
				else if (mouseInHighlightBox)
				{
					plugin.setHighlightBoxBounds(new SimpleEntry<>(itemHighlightBox, item));
				}

				boolean topItem = false;
				if (topGroundItem != null)
				{
					topItem = topGroundItem.equals(item);
				}

				// Draw background if hovering
				if (topItem && (mouseInBox || mouseInHiddenBox || mouseInHighlightBox))
				{
					backgroundComponent.setRectangle(itemBounds);
					backgroundComponent.render(graphics);
				}

				// Draw hidden box
				drawRectangle(graphics, itemHiddenBox, topItem && mouseInHiddenBox ? Color.RED : color, hidden != null, true);

				// Draw highlight box
				drawRectangle(graphics, itemHighlightBox, topItem && mouseInHighlightBox ? Color.GREEN : color, highlighted != null, false);
			}

			if (plugin.getShowGroundItemDuration() == TimerDisplayMode.ALWAYS
				|| (plugin.getShowGroundItemDuration() == TimerDisplayMode.HOTKEY_PRESSED && plugin.isHotKeyPressed()))
			{
				drawTimerOverlay(graphics, new java.awt.Point(textX, textY), item);
			}

			if (plugin.isToggleOutline())
			{
				final Color bordercolor = plugin.getBordercolor();
				graphics.setColor(bordercolor);
				graphics.drawString(itemString, textX + 1, textY + 1);
				graphics.drawString(itemString, textX - 1, textY - 1);
				graphics.drawString(itemString, textX - 1, textY + 1);
				graphics.drawString(itemString, textX + 1, textY - 1);
			}

			textComponent.setText(itemString);
			textComponent.setColor(color);
			textComponent.setPosition(new java.awt.Point(textX, textY));
			textComponent.render(graphics);
		}
		return null;
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
				rect.y + (rect.height / 2),
				rect.x + rect.width - 2,
				rect.y + (rect.height / 2)
			);

		if (!hiddenBox)
		{
			// Plus symbol
			graphics.drawLine
				(
					rect.x + (rect.width / 2),
					rect.y + 2,
					rect.x + (rect.width / 2),
					rect.y + rect.height - 2
				);
		}

	}

	private void drawTimerOverlay(Graphics2D graphics, java.awt.Point location, GroundItem item)
	{
		progressPieComponent.setDiameter(TIMER_OVERLAY_DIAMETER);

		int x = (int) location.getX() - TIMER_OVERLAY_DIAMETER;
		int y = (int) location.getY() - TIMER_OVERLAY_DIAMETER / 2;

		progressPieComponent.setPosition(new Point(x, y));

		double millisOnGround = Duration.between(item.getDroppedInstant(), Instant.now()).toMillis();
		boolean isPubliclyVisible = !item.isAlwaysPrivate() && millisOnGround > item.getDurationMillis();
		double timeLeftRelative;
		Color fillColor;

		if (isPubliclyVisible || !item.isOwnedByPlayer())
		{
			if (item.isOwnedByPlayer())
			{
				timeLeftRelative = getTimeLeftRelative(millisOnGround - PUBLIC_ITEM_DURATION_MILLIS, PUBLIC_ITEM_DURATION_MILLIS);

			}
			else
			{
				timeLeftRelative = getTimeLeftRelative(millisOnGround, PUBLIC_ITEM_DURATION_MILLIS);
			}

			if (timeLeftRelative < WARNING_THRESHOLD)
			{
				fillColor = PUBLIC_WARNING_TIMER_COLOR;
			}
			else
			{
				fillColor = PUBLIC_TIMER_COLOR;
			}
		}
		else
		{
			timeLeftRelative = getTimeLeftRelative(millisOnGround, item.getDurationMillis());
			fillColor = PRIVATE_TIMER_COLOR;

		}

		// don't draw timer for any permanently spawned items or broken edge cases
		if (timeLeftRelative > 1 || timeLeftRelative < 0)
		{
			return;
		}

		progressPieComponent.setFill(fillColor);
		progressPieComponent.setBorderColor(fillColor);
		progressPieComponent.setProgress(timeLeftRelative);
		progressPieComponent.render(graphics);
	}

	private double getTimeLeftRelative(double millisOnGround, int duration)
	{
		return (duration - millisOnGround) / duration;
	}
}
