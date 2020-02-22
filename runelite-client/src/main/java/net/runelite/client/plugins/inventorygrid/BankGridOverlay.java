/*
 * Copyright (c) 2019, gregg1494 <https://github.com/gregg1494>
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

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import java.awt.image.BufferedImage;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class BankGridOverlay extends Overlay
{
	private static final int INVENTORY_SIZE = 28;

	private static final Color HIGHLIGHT = new Color(0, 255, 0, 45);
	private static final Color GRID = new Color(255, 255, 255, 45);

	private final InventoryGridConfig config;
	private final Client client;
	private final ItemManager itemManager;
	private final InventoryGridPlugin plugin;

	private static final ImmutableList<Varbits> TAB_VARBITS = ImmutableList.of(
			Varbits.BANK_TAB_ONE_COUNT,
			Varbits.BANK_TAB_TWO_COUNT,
			Varbits.BANK_TAB_THREE_COUNT,
			Varbits.BANK_TAB_FOUR_COUNT,
			Varbits.BANK_TAB_FIVE_COUNT,
			Varbits.BANK_TAB_SIX_COUNT,
			Varbits.BANK_TAB_SEVEN_COUNT,
			Varbits.BANK_TAB_EIGHT_COUNT,
			Varbits.BANK_TAB_NINE_COUNT
	);

	@Inject
	private BankGridOverlay(InventoryGridConfig config, Client client, ItemManager itemManager, InventoryGridPlugin plugin)
	{
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.client = client;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget if3draggingWidget = client.getDraggedWidget();
		final Widget bankWidget = plugin.getBankWidget();
		final Widget bankInventoryWidget = plugin.getBankInventoryWidget();

		final net.runelite.api.Point mouse = client.getMouseCanvasPosition();
		final Point mousePoint = new Point(mouse.getX(), mouse.getY());


		if (!client.isDraggingWidget() || client.getDraggedWidget() == null)
		{
			return null;
		}

		if (config.showBankGrid() && bankWidget != null && if3draggingWidget != null && if3draggingWidget.getParent() == bankWidget)
		{

			ItemContainer bankInventory = client.getItemContainer(InventoryID.BANK);

			if (bankInventory == null)
			{
				return null;
			}

			int numItems = bankInventory.getItems().length;
			if (numItems == 0)
			{
				return null;
			}

			int currentTab = client.getVar(Varbits.CURRENT_BANK_TAB);
			int startIndex = 0;

			if (currentTab > 0)
			{
				for (int i = currentTab - 1; i > 0; i--)
				{
					startIndex += client.getVar(TAB_VARBITS.get(i - 1));
				}

				int itemCount = client.getVar(TAB_VARBITS.get(currentTab - 1));
				numItems = startIndex + itemCount;
			}

			for (; startIndex < numItems; ++startIndex)
			{
				Widget widget = bankWidget.getChild(startIndex);

				Point bottomLeftPoint = new Point(widget.getCanvasLocation().getX(), widget.getCanvasLocation().getY() + widget.getHeight());
				Point upperLeftPoint = new Point(widget.getCanvasLocation().getX(), widget.getCanvasLocation().getY());

				final Rectangle bounds = widget.getBounds();
				Rectangle intersection;

				if (!bankWidget.getBounds().contains(bottomLeftPoint))
				{
					// set to the bottom of bank widget
					intersection = bankWidget.getBounds().intersection(widget.getBounds());
					bounds.setBounds(intersection);
				}

				if (!bankWidget.getBounds().contains(upperLeftPoint))
				{
					// set to top of bank widget
					intersection = bankWidget.getBounds().intersection(widget.getBounds());
					bounds.setBounds(intersection);
				}

				boolean inBounds = bounds.contains(mousePoint);

				if (config.showItem() && inBounds)
				{
					final Widget draggedItem = findDraggedWidgetIndex(client, bankWidget, numItems);
					if (draggedItem == null)
					{
						return null;
					}
					final BufferedImage draggedItemImage = itemManager.getImage(draggedItem.getItemId());
					final int x = (int) bounds.getX();
					final int y = (int) bounds.getY();

					graphics.setComposite(AlphaComposite.SrcOver.derive(0.3f));
					graphics.drawImage(draggedItemImage, x, y, null);
					graphics.setComposite(AlphaComposite.SrcOver);
				}

				if (config.showHighlight() && inBounds)
				{
					graphics.setColor(HIGHLIGHT);
					graphics.fill(bounds);
				}
				else
				{
					graphics.setColor(GRID);
					graphics.fill(bounds);
				}
			}
		}


		if (config.showInventoryGrid() && bankInventoryWidget != null && if3draggingWidget != null
				&& if3draggingWidget.getParent() == bankInventoryWidget)
		{
			for (int i = 0; i < INVENTORY_SIZE; ++i)
			{
				Widget widget = bankInventoryWidget.getChild(i);

				final Rectangle bounds = widget.getBounds();
				boolean inBounds = bounds.contains(mousePoint);

				if (config.showItem() && inBounds)
				{
					final Widget draggedItem = findDraggedWidgetIndex(client, bankInventoryWidget, INVENTORY_SIZE);
					if (draggedItem == null)
					{
						return null;
					}
					final BufferedImage draggedItemImage = itemManager.getImage(draggedItem.getItemId());
					final int x = (int) bounds.getX();
					final int y = (int) bounds.getY();

					graphics.setComposite(AlphaComposite.SrcOver.derive(0.3f));
					graphics.drawImage(draggedItemImage, x, y, null);
					graphics.setComposite(AlphaComposite.SrcOver);
				}

				if (config.showHighlight() && inBounds)
				{
					graphics.setColor(HIGHLIGHT);
					graphics.fill(bounds);
				}
				else
				{
					graphics.setColor(GRID);
					graphics.fill(bounds);
				}
			}
		}

		return null;
	}

	private static Widget findDraggedWidgetIndex(Client client, Widget widget, int size)
	{
		for (int i = 0; i < size; i++)
		{
			if (client.getDraggedWidget() == widget.getChild(i))
			{
				return widget.getChild(i);
			}
		}

		return null;
	}

}