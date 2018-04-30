/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.runecraft;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.Varbits;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.QueryRunner;

public class RunecraftOverlay extends Overlay
{

	private static final int MEDIUM_POUCH_DAMAGED = ItemID.MEDIUM_POUCH_5511;
	private static final int LARGE_POUCH_DAMAGED = ItemID.LARGE_POUCH_5513;
	private static final int GIANT_POUCH_DAMAGED = ItemID.GIANT_POUCH_5515;

	private static final Color RED = new Color(255, 0, 0, 50);
	private static final Color GREEN = new Color(0, 255, 0, 50);
	private static final Color YELLOW = new Color(255, 255, 0, 50);

	private final QueryRunner queryRunner;
	private final Client client;

	private final RunecraftConfig config;

	private static final Dimension IMAGE_SIZE = new Dimension(16, 16);

	@Inject
	private ItemManager itemManager;

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
			int maxEssence;
			boolean isBroken = false;

			switch (item.getId())
			{
				case ItemID.SMALL_POUCH:
					varbits = Varbits.POUCH_SMALL;
					maxEssence = 3;
					break;
				case ItemID.MEDIUM_POUCH:
					varbits = Varbits.POUCH_MEDIUM;
					maxEssence = 6;
					break;
				case MEDIUM_POUCH_DAMAGED:
					varbits = Varbits.POUCH_MEDIUM;
					isBroken = true;
					maxEssence = 6;
					break;
				case ItemID.LARGE_POUCH:
					varbits = Varbits.POUCH_LARGE;
					maxEssence = 9;
					break;
				case LARGE_POUCH_DAMAGED:
					varbits = Varbits.POUCH_LARGE;
					isBroken = true;
					maxEssence = 9;
					break;
				case ItemID.GIANT_POUCH:
					varbits = Varbits.POUCH_GIANT;
					maxEssence = 12;
					break;
				case GIANT_POUCH_DAMAGED:
					varbits = Varbits.POUCH_GIANT;
					isBroken = true;
					maxEssence = 12;
					break;
				default:
					continue;
			}

			final Rectangle bounds = item.getCanvasBounds();
			final TextComponent textComponent = new TextComponent();
			int essenceInPouch = client.getSetting(varbits);

			if (essenceInPouch == 0)
			{
				graphics.setColor(RED);
			}
			else if (essenceInPouch == maxEssence)
			{
				graphics.setColor(GREEN);
			}
			else
			{
				graphics.setColor(YELLOW);
			}
			graphics.fill(bounds);

			if (isBroken)
			{
				BufferedImage image = itemManager.getImage(ItemID.BANK_FILLER);
				if (image != null)
				{
					BufferedImage resizedImg = new BufferedImage(
							IMAGE_SIZE.width,
							IMAGE_SIZE.height,
							BufferedImage.TYPE_INT_ARGB
					);

					Graphics2D g = resizedImg.createGraphics();
					g.drawImage(image, 0, 0, IMAGE_SIZE.width, IMAGE_SIZE.height, null);
					g.dispose();

					OverlayUtil.renderImageLocation(
							graphics,
							new net.runelite.api.Point(bounds.x + bounds.width - IMAGE_SIZE.width, bounds.y),
							resizedImg
					);
				}
			}

			textComponent.setPosition(new Point(bounds.x + 2, bounds.y + 13));
			textComponent.setText(String.valueOf(essenceInPouch));
			textComponent.render(graphics);
		}

		return null;
	}
}