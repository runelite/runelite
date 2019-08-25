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

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemContainer;
import net.runelite.api.VarClientInt;
import net.runelite.api.vars.InterfaceTab;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.plugins.lootingbagviewer.LootingBagViewerOverlay.PLACEHOLDER_WIDTH;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Singleton
class InventoryViewerOverlay extends Overlay
{
	private static final int INVENTORY_SIZE = 28;
	private static final ImageComponent PLACEHOLDER_IMAGE = new ImageComponent(
		new BufferedImage(Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));

	private final Client client;
	private final ItemManager itemManager;
	private final InventoryViewerPlugin plugin;

	private final PanelComponent wrapperComponent = new PanelComponent();
	private final PanelComponent inventoryComponent = new PanelComponent();
	private final TitleComponent freeSlotsComponent = TitleComponent.builder().build();

	@Inject
	private InventoryViewerOverlay(final Client client, final ItemManager itemManager, final InventoryViewerPlugin plugin)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);

		inventoryComponent.setWrapping(4);
		inventoryComponent.setGap(new Point(6, 4));
		inventoryComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		inventoryComponent.setBackgroundColor(null);
		inventoryComponent.setBorder(new Rectangle(
			0,
			ComponentConstants.STANDARD_BORDER,
			0,
			ComponentConstants.STANDARD_BORDER));

		wrapperComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		wrapperComponent.setWrapping(2);
		wrapperComponent.setBorder(new Rectangle(
			ComponentConstants.STANDARD_BORDER * 2,
			ComponentConstants.STANDARD_BORDER,
			ComponentConstants.STANDARD_BORDER * 2,
			ComponentConstants.STANDARD_BORDER));

		this.itemManager = itemManager;
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isHideWhenInvOpen()
			&& client.getVar(VarClientInt.INTERFACE_TAB) == InterfaceTab.INVENTORY.getId())
		{
			return null;
		}

		final ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

		if (itemContainer == null)
		{
			return null;
		}

		inventoryComponent.getChildren().clear();
		wrapperComponent.getChildren().clear();

		final Item[] items = itemContainer.getItems();

		if (plugin.getViewerMode() == InventoryViewerMode.GROUPED)
		{
			Multiset<Integer> totals = HashMultiset.create();
			for (Item item : items)
			{
				if (item.getId() != -1)
				{
					totals.add(item.getId(), item.getQuantity());
				}
			}

			final long remaining = INVENTORY_SIZE - totals.size();
			if (remaining == INVENTORY_SIZE)
			{
				return null;
			}

			for (Multiset.Entry<Integer> cursor : totals.entrySet())
			{
				final BufferedImage image = itemManager.getImage(cursor.getElement(), cursor.getCount(), true);
				if (image != null)
				{
					inventoryComponent.getChildren().add(new ImageComponent(image));
				}
			}
			wrapperComponent.getChildren().add(inventoryComponent);

			if (plugin.isShowFreeSlots())
			{
				freeSlotsComponent.setText(remaining + " free");
				wrapperComponent.setPreferredSize(new Dimension(Math.min(totals.elementSet().size(), 4) * (PLACEHOLDER_WIDTH + 6) + ComponentConstants.STANDARD_BORDER * 2, 0));
				wrapperComponent.getChildren().add(freeSlotsComponent);
			}

			return wrapperComponent.render(graphics);
		}

		int remaining = 28;

		for (int i = 0; i < INVENTORY_SIZE; i++)
		{
			if (i < items.length)
			{
				final Item item = items[i];
				if (item.getQuantity() > 0)
				{
					remaining -= 1;
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

		wrapperComponent.getChildren().add(inventoryComponent);

		if (plugin.isShowFreeSlots())
		{
			freeSlotsComponent.setText(remaining + " free");
			wrapperComponent.setPreferredSize(new Dimension(4 * (PLACEHOLDER_WIDTH + 6) + ComponentConstants.STANDARD_BORDER * 2, 0));
			wrapperComponent.getChildren().add(freeSlotsComponent);
		}

		return wrapperComponent.render(graphics);
	}

	private BufferedImage getImage(Item item)
	{
		ItemDefinition itemComposition = itemManager.getItemDefinition(item.getId());
		return itemManager.getImage(item.getId(), item.getQuantity(), itemComposition.isStackable());
	}
}