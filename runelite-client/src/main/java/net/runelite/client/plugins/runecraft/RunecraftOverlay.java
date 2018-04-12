/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.runecraft;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.Varbits;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.QueryRunner;

public class RunecraftOverlay extends Overlay
{
	private static final int MEDIUM_POUCH_DAMAGED = ItemID.MEDIUM_POUCH_5511;
	private static final int LARGE_POUCH_DAMAGED = ItemID.LARGE_POUCH_5513;
	private static final int GIANT_POUCH_DAMAGED = ItemID.GIANT_POUCH_5515;

	private final QueryRunner queryRunner;
	private final Client client;

	private final RunecraftConfig config;

	@Inject
	RunecraftOverlay(QueryRunner queryRunner, Client client, RunecraftConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.queryRunner = queryRunner;
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showPouch())
		{
			return null;
		}

		Query query = new InventoryWidgetItemQuery();
		WidgetItem[] widgetItems = queryRunner.runQuery(query);
		graphics.setFont(FontManager.getRunescapeSmallFont());

		for (WidgetItem item : widgetItems)
		{
			Varbits varbits;

			switch (item.getId())
			{
				case ItemID.SMALL_POUCH:
					varbits = Varbits.POUCH_SMALL;
					break;
				case ItemID.MEDIUM_POUCH:
				case MEDIUM_POUCH_DAMAGED:
					varbits = Varbits.POUCH_MEDIUM;
					break;
				case ItemID.LARGE_POUCH:
				case LARGE_POUCH_DAMAGED:
					varbits = Varbits.POUCH_LARGE;
					break;
				case ItemID.GIANT_POUCH:
				case GIANT_POUCH_DAMAGED:
					varbits = Varbits.POUCH_GIANT;
					break;
				default:
					continue;
			}

			final Rectangle bounds = item.getCanvasBounds();
			final TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(bounds.x, bounds.y + 16));
			textComponent.setText(String.valueOf(client.getVar(varbits)));
			textComponent.render(graphics);
		}

		return null;
	}
}
