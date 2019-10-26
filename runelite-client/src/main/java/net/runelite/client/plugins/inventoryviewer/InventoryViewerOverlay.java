/*
 * Copyright (c) 2018 AWPH-I
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import lombok.AccessLevel;
import lombok.Setter;
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
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class InventoryViewerOverlay extends Overlay
{
	private static final int INVENTORY_SIZE = 28;
	private static final int INVENTORY_WIDTH = 4;
	private static final Point SPRITE_PADDING = new Point(6, 4);
	private static final int WRAPPER_MINIMUM_WIDTH = Constants.ITEM_SPRITE_WIDTH + SPRITE_PADDING.x * 2;
	private static final ImageComponent PLACEHOLDER_IMAGE = new ImageComponent(
		new BufferedImage(Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));

	private final Client client;
	private final ItemManager itemManager;
	private final InventoryViewerConfig config;

	private final PanelComponent wrapperComponent = new PanelComponent();
	private final PanelComponent inventoryComponent = new PanelComponent();
	private final TitleComponent freeSlotsComponent = TitleComponent.builder().build();

	@Setter(AccessLevel.PACKAGE)
	private Map<Integer, Integer> groupedItems = null;

	@Setter(AccessLevel.PACKAGE)
	private int remainingSpaces = -1;

	private ImageComponent inventoryIconSprite;

	@Inject
	private InventoryViewerOverlay(Client client, ItemManager itemManager, SpriteManager spriteManager, InventoryViewerConfig config)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		inventoryComponent.setWrapping(INVENTORY_WIDTH);
		inventoryComponent.setGap(SPRITE_PADDING);
		inventoryComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		inventoryComponent.setBackgroundColor(null);
		inventoryComponent.setBorder(new Rectangle(
			ComponentConstants.STANDARD_BORDER,
			0,
			0,
			ComponentConstants.STANDARD_BORDER));

		wrapperComponent.setOrientation(ComponentOrientation.VERTICAL);
		wrapperComponent.setWrapping(2);
		wrapperComponent.setBorder(new Rectangle(
			ComponentConstants.STANDARD_BORDER,
			ComponentConstants.STANDARD_BORDER,
			ComponentConstants.STANDARD_BORDER,
			ComponentConstants.STANDARD_BORDER));

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

		final Item[] items;
		if (itemContainer == null)
		{
			items = new Item[0];
		}
		else
		{
			items = itemContainer.getItems();
		}

		inventoryComponent.getChildren().clear();
		wrapperComponent.getChildren().clear();
		int wrapperWidth;

		if (config.groupItems())
		{
			if (groupedItems == null)
			{
				// Store in a LinkedHashMap to preserve inventory ordering
				groupedItems = Arrays.stream(items)
					.filter(p -> p.getId() != -1)
					.collect(groupingBy(Item::getId, LinkedHashMap::new, summingInt(Item::getQuantity)));
			}

			for (Map.Entry<Integer, Integer> cursor : groupedItems.entrySet())
			{
				final BufferedImage image = itemManager.getImage(cursor.getKey(), cursor.getValue(), true);
				if (image != null)
				{
					inventoryComponent.getChildren().add(new ImageComponent(image));
				}
			}

			// Add a placeholder if the inventory is empty, so the overlay can still be easily seen
			if (groupedItems.entrySet().size() == 0)
			{
				inventoryComponent.getChildren().add(inventoryIconSprite);
				wrapperWidth = WRAPPER_MINIMUM_WIDTH;
			}
			else
			{
				final int widthItems = Math.min(INVENTORY_WIDTH, groupedItems.entrySet().size());
				wrapperWidth = widthItems * Constants.ITEM_SPRITE_WIDTH + (widthItems + 1) * SPRITE_PADDING.x;
			}
		}
		else
		{
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
							inventoryComponent.getChildren().add(new ImageComponent(image));
							continue;
						}
					}
				}

				// put a placeholder image so each item is aligned properly and the panel is not resized
				inventoryComponent.getChildren().add(PLACEHOLDER_IMAGE);
			}
			
			wrapperWidth = INVENTORY_WIDTH * Constants.ITEM_SPRITE_WIDTH + (INVENTORY_WIDTH - 1) * SPRITE_PADDING.x;
		}

		// If the inventoryComponent is empty, the overlay NPEs during rendering
		if (!inventoryComponent.getChildren().isEmpty())
		{
			wrapperComponent.getChildren().add(inventoryComponent);
		}

		if (config.showFreeSlots())
		{
			if (remainingSpaces == -1)
			{
				remainingSpaces = INVENTORY_SIZE - (int) Arrays.stream(items)
					.filter(p -> p.getId() != -1)
					.count();
			}

			// Set the width of the wrapper so the free slots component will have the correct alignment
			wrapperComponent.setPreferredSize(new Dimension(Math.max(wrapperWidth, WRAPPER_MINIMUM_WIDTH), 0));

			freeSlotsComponent.setText(remainingSpaces + " free");
			wrapperComponent.getChildren().add(freeSlotsComponent);

		}

		return wrapperComponent.render(graphics);
	}

	private BufferedImage getImage(Item item)
	{
		ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
		return itemManager.getImage(item.getId(), item.getQuantity(), itemComposition.isStackable());
	}
}
