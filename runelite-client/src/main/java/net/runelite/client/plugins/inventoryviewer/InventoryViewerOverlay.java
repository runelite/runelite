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

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.inventorytags.InventoryTagsConfig;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

class InventoryViewerOverlay extends Overlay
{
	private static final String ITEM_KEY_PREFIX = "item_";
	private static final String SETNAME_GROUP_1 = "Group 1";
	private static final String SETNAME_GROUP_2 = "Group 2";
	private static final String SETNAME_GROUP_3 = "Group 3";
	private static final String SETNAME_GROUP_4 = "Group 4";
	private static final int INVENTORY_SIZE = 28;
	private static final ImageComponent PLACEHOLDER_IMAGE = new ImageComponent(
		new BufferedImage(Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));

	private final Client client;
	private final ItemManager itemManager;
	private final InventoryViewerConfig config;
	private final InventoryTagsConfig configTag;
	private final ConfigManager configManager;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private InventoryViewerOverlay(Client client, ConfigManager configManager, InventoryViewerConfig config, InventoryTagsConfig configTag, ItemManager itemManager)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		panelComponent.setWrapping(4);
		panelComponent.setGap(new Point(6, 4));
		panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		this.itemManager = itemManager;
		this.client = client;
		this.config = config;
		this.configTag = configTag;
		this.configManager = configManager;
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

		for (int i = 0; i < INVENTORY_SIZE; i++)
		{
			if (i < items.length)
			{
				final Item item = items[i];
				if (item.getQuantity() > 0)
				{
					addImageToPanel(item);
					continue;
				}
			}

			// put a placeholder image so each item is aligned properly and the panel is not resized
			panelComponent.getChildren().add(PLACEHOLDER_IMAGE);
		}

		return panelComponent.render(graphics);
	}

	private void addImageToPanel(Item item)
	{
		BufferedImage image = getImage(item);

		if (image != null) // if image exists we need to add it
		{
			if (showTags()) // if Inventory Tags is active
			{
				if (getOutline(item) != null) // trying to get the item outline
				{
					ColorModel taggedImageCM = image.getColorModel();
					BufferedImage taggedImage = new BufferedImage(taggedImageCM,
							image.copyData(null),
							taggedImageCM.isAlphaPremultiplied(),
							null);
					Graphics2D graphic = taggedImage.createGraphics();
					graphic.drawImage(getOutline(item), 0, 0, null); // drawing the outline over the sprite
					graphic.dispose();
					image = taggedImage;
				}
			}

			panelComponent.getChildren().add(new ImageComponent(image));
		}
	}

	private BufferedImage getImage(Item item)
	{
		ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
		return itemManager.getImage(item.getId(), item.getQuantity(), itemComposition.isStackable());
	}

	private BufferedImage getOutline(Item item)
	{
		Color color = getBoundColor(item.getId());
		if (color != null)
		{
			return itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
		}

		return null;
	}

	private Color getBoundColor(int itemId)
	{
		final String group = getTag(itemId);
		Color color = null;

		if (group != null)
		{
			color = getGroupNameColor(group);
		}

		return color;
	}

	Color getGroupNameColor(final String name)
	{
		switch (name)
		{
			case SETNAME_GROUP_1:
				return configTag.getGroup1Color();
			case SETNAME_GROUP_2:
				return configTag.getGroup2Color();
			case SETNAME_GROUP_3:
				return configTag.getGroup3Color();
			case SETNAME_GROUP_4:
				return configTag.getGroup4Color();
		}

		return null;
	}

	private String getTag(int itemId)
	{
		String tag = configManager.getConfiguration(InventoryTagsConfig.GROUP, ITEM_KEY_PREFIX + itemId);
		if (tag == null || tag.isEmpty())
		{
			return null;
		}

		return tag;
	}

	private boolean showTags()
	{
		return config.getMarkViewer();
	}
}
