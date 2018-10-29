/*
 * Copyright (c) 2018, Anthony <cvballa3g0@gmail.com>
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
package net.runelite.client.plugins.coalbag;


import net.runelite.api.ItemID;
import net.runelite.api.Point;
import net.runelite.api.Query;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

import javax.inject.Inject;
import java.awt.*;

public class CoalBagOverlay extends Overlay
{
	private final QueryRunner queryRunner;
	private final CoalBagPlugin plugin;

	@Inject
	CoalBagOverlay(QueryRunner queryRunner, CoalBagPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.queryRunner = queryRunner;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Query query = new InventoryWidgetItemQuery().idEquals(ItemID.COAL_BAG_12019);
		WidgetItem[] items = queryRunner.runQuery(query);
		if (items.length == 0)
		{
			return null;
		}

		WidgetItem coalBag = items[0];
		Point location = coalBag.getCanvasLocation();
		if (location == null)
		{
			return null;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());
		graphics.drawString(plugin.getAmount() + "", location.getX(), location.getY() + 14);
		return null;
	}
}
