/*
 * Copyright (c) 2020, BegOsrs <https://github.com/begosrs>
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
package net.runelite.client.plugins.barbarianassault;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ItemComposition;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

@Singleton
class HighlightsOverlay extends WidgetItemOverlay
{
	private final ItemManager itemManager;
	private final BarbarianAssaultPlugin plugin;
	private final BarbarianAssaultConfig config;

	@Inject
	private HighlightsOverlay(ItemManager itemManager, BarbarianAssaultPlugin plugin, BarbarianAssaultConfig config)
	{
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.config = config;
		showOnInventory();
		showOnEquipment();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		final Role role = plugin.getRole();
		if (role == null)
		{
			return;
		}

		final int listenItemId = plugin.getLastListenItemId();
		if (listenItemId != itemId)
		{
			return;
		}

		final Color color = plugin.getColorForItemId(itemId);
		switch (role)
		{
			case ATTACKER:
				if (config.highlightArrows())
				{
					highlightItem(graphics, itemId, itemWidget, color);
				}
				break;
			case DEFENDER:
				if (config.highlightBait())
				{
					highlightItem(graphics, itemId, itemWidget, color);
				}
				break;
			case HEALER:
				if (config.highlightPoison())
				{
					highlightItem(graphics, itemId, itemWidget, color);
				}
				break;
		}
	}

	private void highlightItem(Graphics2D graphics, int itemId, WidgetItem itemWidget, Color color)
	{
		final Rectangle bounds = itemWidget.getCanvasBounds();

		final InventoryHighlightMode inventoryHighlightMode = config.inventoryHighlightMode();
		if (inventoryHighlightMode == InventoryHighlightMode.OVERLAY)
		{
			ItemComposition item = itemManager.getItemComposition(itemId);
			final BufferedImage image = itemManager.getImage(itemId, itemWidget.getQuantity(), item.isStackable());
			final BufferedImage overlayedImage = overlay(image, color);
			graphics.drawImage(overlayedImage, (int) bounds.getX(), (int) bounds.getY(), null);
		}
		else if (inventoryHighlightMode == InventoryHighlightMode.OUTLINE)
		{
			final BufferedImage outline = itemManager.getItemOutline(itemId, itemWidget.getQuantity(), color);
			graphics.drawImage(outline, (int) bounds.getX(), (int) bounds.getY(), null);
		}
	}

	private BufferedImage overlay(BufferedImage image, Color color)
	{
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage overlayed = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = overlayed.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.setComposite(AlphaComposite.SrcAtop);
		g.setColor(color);
		g.fillRect(0, 0, w, h);
		g.dispose();
		return overlayed;
	}
}