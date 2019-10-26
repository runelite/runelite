/*
 * Copyright (c) 2018 AWPH-I
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
package net.runelite.client.plugins.inventoryviewer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

class InventoryViewerOverlay extends Overlay
{
	private static final int INVENTORY_SIZE = 28;
	private static final ImageComponent PLACEHOLDER_IMAGE = new ImageComponent(
		new BufferedImage(Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));

	private final Client client;
	private final ItemManager itemManager;
	private final InventoryViewerConfig config;

	private final PanelComponent panelComponent = new PanelComponent();

	private ImageComponent inventoryIconSprite;

	@Inject
	private InventoryViewerOverlay(Client client, ItemManager itemManager, SpriteManager spriteManager, InventoryViewerConfig config)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		panelComponent.setWrapping(4);
		panelComponent.setGap(new Point(6, 4));
		panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		this.itemManager = itemManager;
		this.client = client;
		this.config = config;

		spriteManager.getSpriteAsync(SpriteID.TAB_INVENTORY, 0, sprite ->
		{
			final BufferedImage img = new BufferedImage(Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			final int centeredY = Constants.ITEM_SPRITE_HEIGHT / 2 - sprite.getHeight() / 2;

			final Graphics2D g = img.createGraphics();
			g.drawImage(sprite, 0, centeredY, null);
			g.dispose();

			inventoryIconSprite = new ImageComponent(img);
		});
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

		if (itemContainer == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		final Item[] items = itemContainer.getItems();

		if (config.groupItems())
		{
			// Store in a LinkedHashMap to preserve inventory ordering
			final Map<Integer, Integer> totals = Arrays.stream(items)
				.filter(p -> p.getId() != -1)
				.collect(groupingBy(Item::getId, LinkedHashMap::new, summingInt(Item::getQuantity)));

			for (Map.Entry<Integer, Integer> cursor : totals.entrySet())
			{
				final BufferedImage image = itemManager.getImage(cursor.getKey(), cursor.getValue(), true);
				if (image != null)
				{
					panelComponent.getChildren().add(new ImageComponent(image));
				}
			}

			// Add a placeholder if the inventory is empty, so the overlay can still be easily seen
			if (totals.entrySet().size() == 0)
			{
				panelComponent.getChildren().add(inventoryIconSprite);
			}

			return panelComponent.render(graphics);
		}

		for (int i = 0; i < INVENTORY_SIZE; i++)
		{
			if (i < items.length)
			{
				final Item item = items[i];
				if (item.getQuantity() > 0)
				{
					final BufferedImage image = getImage(item);
					if (image != null)
					{
						panelComponent.getChildren().add(new ImageComponent(image));
						continue;
					}
				}
			}

			// put a placeholder image so each item is aligned properly and the panel is not resized
			panelComponent.getChildren().add(PLACEHOLDER_IMAGE);
		}

		return panelComponent.render(graphics);
	}

	private BufferedImage getImage(Item item)
	{
		ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
		return itemManager.getImage(item.getId(), item.getQuantity(), itemComposition.isStackable());
	}
}
