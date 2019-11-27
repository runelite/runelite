/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.lootingbagviewer;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ItemID;
import net.runelite.api.Point;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

@Singleton
public class LootingBagViewerWidgetOverlay extends WidgetItemOverlay
{
	private final LootingBagViewerPlugin plugin;

	@Inject
	LootingBagViewerWidgetOverlay(final LootingBagViewerPlugin plugin)
	{
		this.plugin = plugin;
		showOnInventory();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (plugin.getValueToShow() != -1)
		{
			switch (itemId)
			{
				case ItemID.LOOTING_BAG:
				case ItemID.LOOTING_BAG_22586:
					Point point = new Point(itemWidget.getCanvasLocation().getX() + lineX(plugin.getValueToShow()), itemWidget.getCanvasLocation().getY() + 25);
					OverlayUtil.renderTextLocation(graphics, point, (plugin.getValueToShow() + "K"), Color.WHITE);
					break;
			}
		}
	}

	/**
	 * To align 16k (gp) or 4213k (gp) correctly between the looting bag without looking off
	 *
	 * @return
	 */
	private static int lineX(int lootingBagValue)
	{
		switch ((int) (Math.log10(lootingBagValue) + 1))
		{
			case 3:
			case 4:
				return 6;
			default:
				return 8;
		}
	}
}
