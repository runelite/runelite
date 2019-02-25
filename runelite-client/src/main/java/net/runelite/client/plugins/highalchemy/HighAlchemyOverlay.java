/*
 * Copyright (c) 2019 Ahmad Issa
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

package net.runelite.client.plugins.highalchemy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.util.QueryRunner;

public class HighAlchemyOverlay extends Overlay
{
	private Client client;
	private final QueryRunner queryRunner;
	private final ItemManager itemManager;
	private final HighAlchemyConfig config;
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	@Inject
	public HighAlchemyOverlay(QueryRunner queryRunner, ItemManager itemManager, HighAlchemyPlugin plugin, Client client, HighAlchemyConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.queryRunner = queryRunner;
		this.itemManager = itemManager;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showBank())
		{
			final Query bankQuery = new BankItemQuery();
			final WidgetItem[] bankWidgetItems = queryRunner.runQuery(bankQuery);
			highlightWidgetItems(bankWidgetItems, graphics);
		}
		if (config.showInventory())
		{
			final Query inventoryQuery = new InventoryWidgetItemQuery();
			final WidgetItem[] inventoryWidgetItems = queryRunner.runQuery(inventoryQuery);
			highlightWidgetItems(inventoryWidgetItems, graphics);
		}
		/*if (config.showTooltip())
		{

		}
		*/
		return null;
	}

	private void highlightWidgetItems(WidgetItem[] wi, Graphics2D graphics)
	{
		Color color = config.getHighlightColor();
		for (final WidgetItem item : wi)
		{
			int id = getNotedId(item.getId());
			int gePrice = getGEPrice(id);
			int haPrice = getHAPrice(id);
			int materialCost = getAlchCost();
			int desiredProfit = config.minProfit();
			int haProfit = getHAProfit(haPrice, gePrice, materialCost);
			if (gePrice > 0 && haPrice > 0 && haProfit >= desiredProfit)
			{
				Rectangle bankRec = getBankBounds();
				Rectangle bankInvRec = getBankInventoryBounds();
				int itemX = item.getCanvasLocation().getX();
				int itemY = item.getCanvasLocation().getY();
				//Checks if item is within boundaries of the bank widget
				if (bankRec != null)
				{
					if (itemX >= bankRec.getX() && itemX <= bankRec.getX() + bankRec.getWidth() && itemY >= bankRec.getY() - 5 && itemY <= bankRec.getY() + bankRec.getHeight() - 32)
					{
						final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
						graphics.drawImage(outline, itemX + 1, itemY + 1, null);
					}
				}
				if (bankInvRec != null)
				{
					if (itemX >= bankInvRec.getX() && itemX <= bankInvRec.getX() + bankInvRec.getWidth() && itemY >= bankInvRec.getY() && itemY <= bankInvRec.getY() + bankInvRec.getHeight())
					{
						final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
						graphics.drawImage(outline, itemX + 1, itemY + 1, null);
					}
				}
				//Necessary check to highlight inventory items and NOT highlight bank items out of the bank widget boundaries
				else if (bankRec == null)
				{
					BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
					graphics.drawImage(outline, itemX + 1, itemY + 1, null);
				}
			}
		}
	}

	private int getGEPrice(int id)
	{
		return itemManager.getItemPrice(id);
	}

	private int getHAPrice(int id)
	{
		if (id == ItemID.COINS_995)
		{
			return 0;
		}
		ItemComposition itemComp = itemManager.getItemComposition(id);
		float haValue = itemComp.getPrice() * HIGH_ALCHEMY_CONSTANT;
		return Math.round(haValue);
	}

	private int getHAProfit(int haPrice, int gePrice, int alchCost)
	{
		return haPrice - gePrice - alchCost;
	}

	private int getAlchCost()
	{
		int natureRunePrice = itemManager.getItemPrice(ItemID.NATURE_RUNE);
		if (config.usingFireRunes())
		{
			int fireRunePrice = itemManager.getItemPrice(ItemID.FIRE_RUNE) * 5;
			return natureRunePrice + fireRunePrice;
		}
		return natureRunePrice;
	}

	//Checks if item is noted, if not returns id
	private int getNotedId(int id)
	{
		int noteID = id;
		ItemComposition itemComposition = itemManager.getItemComposition(noteID);
		if (itemComposition.getNote() != -1)
		{
			noteID = itemComposition.getLinkedNoteId();
		}
		return noteID;
	}

	private Rectangle getBankBounds()
	{
		Widget bankWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		if (bankWidget != null)
		{
			return bankWidget.getBounds();
		}
		return null;
	}

	private Rectangle getBankInventoryBounds()
	{
		Widget bankInventoryWidget = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);
		if (bankInventoryWidget != null)
		{
			return bankInventoryWidget.getBounds();
		}
		return null;
	}
}