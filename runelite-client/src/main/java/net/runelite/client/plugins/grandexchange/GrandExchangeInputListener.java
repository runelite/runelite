/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.grandexchange;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.Point;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;
import net.runelite.client.util.QueryRunner;

public class GrandExchangeInputListener extends MouseListener implements KeyListener
{
	private final Client client;
	private final GrandExchangePlugin plugin;
	private final ItemManager itemManager;
	private final QueryRunner queryRunner;

	@Inject
	GrandExchangeInputListener(Client client, GrandExchangePlugin plugin, ItemManager itemManager,
		QueryRunner queryRunner)
	{
		this.client = client;
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.queryRunner = queryRunner;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent e)
	{
		// Check if left click + alt
		if (e.getButton() == MouseEvent.BUTTON1 && e.isAltDown())
		{
			Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
			if (inventoryWidget != null && !inventoryWidget.isHidden())
			{
				if (findAndSearch(inventoryWidget.getWidgetItems().toArray(new WidgetItem[0])))
				{
					e.consume();
					return super.mouseClicked(e);
				}
			}

			// Check the inventory when the bank is open aswell
			Widget bankInventoryWidget = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);
			if (bankInventoryWidget != null && !bankInventoryWidget.isHidden())
			{
				if (findAndSearch(bankInventoryWidget.getDynamicChildren()))
				{
					e.consume();
					return super.mouseClicked(e);
				}
			}

			Widget bankWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
			if (bankWidget != null && !bankWidget.isHidden())
			{
				// Use bank item query for only checking the active tab
				WidgetItem[] items = queryRunner.runQuery(new BankItemQuery());
				if (findAndSearch(items))
				{
					e.consume();
					return super.mouseClicked(e);
				}
			}
		}

		return super.mouseClicked(e);
	}

	private boolean findAndSearch(Widget[] widgets)
	{
		Point mousePosition = client.getMouseCanvasPosition();
		for (Widget widget : widgets)
		{
			if (widget.getBounds().contains(mousePosition.getX(), mousePosition.getY()))
			{
				ItemComposition itemComposition = itemManager.getItemComposition(widget.getItemId());
				search(itemComposition);
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds the item clicked based on the mouse location
	 * @param items
	 * @return true if an item is found, false otherwise
	 */
	private boolean findAndSearch(WidgetItem[] items)
	{
		Point mousePosition = client.getMouseCanvasPosition();
		for (WidgetItem item : items)
		{
			if (item.getCanvasBounds().contains(mousePosition.getX(), mousePosition.getY()))
			{
				ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
				search(itemComposition);
				return true;
			}
		}
		return false;
	}

	private void search(ItemComposition itemComposition)
	{
		SwingUtilities.invokeLater(() ->
		{
			plugin.getPanel().showSearch();

			if (!plugin.getButton().isSelected())
			{
				plugin.getButton().getOnSelect().run();
			}

			plugin.getPanel().getSearchPanel().priceLookup(itemComposition.getName());
		});
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.isAltDown())
		{
			plugin.setHotKeyPressed(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (!e.isAltDown())
		{
			plugin.setHotKeyPressed(false);
		}
	}
}
