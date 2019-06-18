/*
 * Copyright (c) 2019, Tal Cohen <https://github.com/talcohen>
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
package net.runelite.client.plugins.bank;

import lombok.NonNull;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Item;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.StackFormatter;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Comparator;

@Slf4j
class BankItemsOverlay extends Overlay
{
	private static final int ITEM_SIZE = 10;
	private static final int PLACEHOLDER_WIDTH = 36;
	private static final int PLACEHOLDER_HEIGHT = 32;
	private static final int WRAPPING = 2;
	private static final Point GAP = new Point(10, 6);
	private static final ImageComponent PLACEHOLDER_IMAGE = new ImageComponent(new BufferedImage(PLACEHOLDER_WIDTH, PLACEHOLDER_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));

	private final PanelComponent panelComponent = new PanelComponent();

	private final ItemManager itemManager;
	private final BankConfig config;
	private final BankCalculation bankCalculation;


	private ItemPrice[] expensiveItems;

	@Inject
	private BankItemsOverlay(ItemManager itemManager, BankConfig config, BankCalculation bankCalculation)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		panelComponent.setWrapping(WRAPPING);
		panelComponent.setGap(GAP);
		panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		panelComponent.setPreferredSize(new Dimension(PLACEHOLDER_WIDTH + GAP.x, PLACEHOLDER_HEIGHT + GAP.y));

		this.itemManager = itemManager;
		this.config = config;
		this.bankCalculation = bankCalculation;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showMostExpensiveItemsOverlay())
		{
			return null;
		}

		final Item[] bankItems = bankCalculation.getBankItems();

		if (bankItems == null || bankItems.length == 0)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		if (expensiveItems == null || bankCalculation.isBankDifferent(bankItems)) {
			expensiveItems = getExpensiveItems(bankItems);
			Arrays.sort(expensiveItems, Comparator.comparing(ItemPrice::getPrice).reversed());
		}


		for (int i = 0; i < ITEM_SIZE; i++)
		{
			if (i < expensiveItems.length)
			{
				final ItemPrice itemPrice = expensiveItems[i];
				if (itemPrice.getItem().getQuantity() > 0)
				{
					final BufferedImage image = getImage(itemPrice.getItem());

					if (image != null)
					{
						ImageComponent imageComponent = new ImageComponent(image);
						panelComponent.getChildren().add(imageComponent);

						TitleComponent titleComponent = TitleComponent.builder()
								.color(Color.white)
								.text(StackFormatter.quantityToStackSize(itemPrice.getPrice()))
								.build();
						panelComponent.getChildren().add(titleComponent);
						continue;
					}
				}
			}

			// put two placeholder components (one image, one text) so the panel is not resized
			panelComponent.getChildren().add(PLACEHOLDER_IMAGE);
			panelComponent.getChildren().add(TitleComponent.builder().text("").build());
		}

		return panelComponent.render(graphics);

	}

	private BufferedImage getImage(Item item)
	{
		return itemManager.getImage(item.getId(), item.getQuantity(), true);
	}

	private ItemPrice[] getExpensiveItems(Item[] items)
	{
		return Arrays.stream(items)
				.filter(i -> i.getQuantity() > 0)
				.filter(i -> getGePrice(i) > 0)
				.map(i -> new ItemPrice(i, getGePrice(i)))
				.toArray(ItemPrice[]::new);
	}

	private long getGePrice(Item item)
	{
		return (long) itemManager.getItemPrice(item.getId()) * item.getQuantity();
	}

	@Value
	private static class ItemPrice
	{
		@NonNull
		Item item;
		@NonNull
		Long price;
	}
}
