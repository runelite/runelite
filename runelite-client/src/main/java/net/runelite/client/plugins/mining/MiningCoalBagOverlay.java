/* Copyright 2019 Jarred Vardy <jarredvardy@gmail.com>
 *
 * This file is part of CORAL.
 *
 * CORAL is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CORAL is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CORAL. If not, see http://www.gnu.org/licenses/.
 */
package net.runelite.client.plugins.mining;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.Point;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

public class MiningCoalBagOverlay extends WidgetItemOverlay
{
	private final MiningPlugin plugin;
	private final MiningConfig config;

	@Inject
	MiningCoalBagOverlay(MiningPlugin plugin, MiningConfig config)
	{
		showOnInventory();
		showOnInterfaces();
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (!config.showCoalBagOverlay())
		{
			return;
		}

		if (itemId != ItemID.COAL_BAG && itemId != ItemID.COAL_BAG_12019)
		{
			return;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());
		graphics.setColor(Color.YELLOW);
		Point location = itemWidget.getCanvasLocation();

		graphics.drawString(plugin.getAmountOfCoalInBag() + "", location.getX(), location.getY() + 14);
	}
}
