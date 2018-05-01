/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.jewellerycount;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.inject.Inject;
import net.runelite.api.Query;
import net.runelite.api.queries.EquipmentItemQuery;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.QueryRunner;

class JewelleryCountOverlay extends Overlay
{
	private final QueryRunner queryRunner;
	private final JewelleryCountConfig config;

	@Inject
	JewelleryCountOverlay(QueryRunner queryRunner, JewelleryCountConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.queryRunner = queryRunner;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showJewelleryCount())
		{
			return null;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());

		for (WidgetItem item : getJewelleryWidgetItems())
		{
			JewelleryCharges charges = JewelleryCharges.getCharges(item.getId());

			if (charges == null)
			{
				continue;
			}

			final Rectangle bounds = item.getCanvasBounds();
			final TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(bounds.x, bounds.y + 16));
			textComponent.setText(String.valueOf(charges.getCharges()));
			textComponent.render(graphics);
		}

		return null;
	}

	private Collection<WidgetItem> getJewelleryWidgetItems()
	{
		Query inventoryQuery = new InventoryWidgetItemQuery();
		WidgetItem[] inventoryWidgetItems = queryRunner.runQuery(inventoryQuery);

		Query equipmentQuery = new EquipmentItemQuery().slotEquals(
			WidgetInfo.EQUIPMENT_AMULET,
			WidgetInfo.EQUIPMENT_RING,
			WidgetInfo.EQUIPMENT_GLOVES,
			WidgetInfo.EQUIPMENT_WEAPON
		);
		WidgetItem[] equipmentWidgetItems = queryRunner.runQuery(equipmentQuery);

		Collection<WidgetItem> jewellery = new ArrayList<>();
		jewellery.addAll(Arrays.asList(inventoryWidgetItems));
		jewellery.addAll(Arrays.asList(equipmentWidgetItems));
		return jewellery;
	}
}
