/*
 * Copyright (c) 2018-2019, Ethan <https://github.com/Wea1thRS/>
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.inventorysetups;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

@Slf4j
public class InventorySetupBankOverlay extends WidgetItemOverlay
{
	private final ItemManager itemManager;
	private final InventorySetupPlugin plugin;

	@Inject
	public InventorySetupBankOverlay(ItemManager itemManager, InventorySetupPlugin plugin)
	{
		this.itemManager = itemManager;
		this.plugin = plugin;
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (plugin.isGetBankHighlight())
		{
			int[] ids = plugin.getCurrentInventorySetupIds();
			if (ids == null)
			{
				return;
			}

			if (IntStream.of(ids).noneMatch(x -> x == itemId))
			{
				return;
			}


			final Color color = plugin.getGetBankHighlightColor();

			if (color != null)
			{
				Rectangle bounds = itemWidget.getCanvasBounds();
				final BufferedImage outline = itemManager.getItemOutline(itemId, itemWidget.getQuantity(), color);
				graphics.drawImage(outline, (int) bounds.getX() + 1, (int) bounds.getY() + 1, null);

				if (itemWidget.getQuantity() > 1)
				{
					drawQuantity(graphics, itemWidget, Color.YELLOW);
				}
				else if (itemWidget.getQuantity() == 0)
				{
					drawQuantity(graphics, itemWidget, Color.YELLOW.darker());
				}
			}
		}
	}

	private void drawQuantity(Graphics2D graphics, WidgetItem item, Color darker)
	{
		graphics.setColor(Color.BLACK);
		graphics.drawString(String.valueOf(item.getQuantity()), item.getCanvasLocation().getX() + 2, item.getCanvasLocation().getY() + 11);
		graphics.setColor(darker);
		graphics.setFont(FontManager.getRunescapeSmallFont());
		graphics.drawString(String.valueOf(item.getQuantity()), item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 10);
	}
}