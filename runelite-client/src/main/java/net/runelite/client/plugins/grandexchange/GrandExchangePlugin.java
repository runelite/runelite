/*
 *
 * Copyright (c) 2017, Robbie <https://github.com/rbbi>
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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

package net.runelite.client.plugins.grandexchange;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.ItemComposition;
import net.runelite.api.Point;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.MouseListener;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;

@PluginDescriptor(
	name = "Grand Exchange"
)
public class GrandExchangePlugin extends Plugin
{
	private NavigationButton button;

	private GrandExchangePanel panel;

	private MouseListener itemClick;

	@Inject
	private ItemManager itemManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private Client client;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private GrandExchangeConfig config;

	@Provides
	GrandExchangeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GrandExchangeConfig.class);
	}

	@Override
	protected void startUp() throws IOException
	{
		panel = injector.getInstance(GrandExchangePanel.class);

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("ge_icon.png"));
		}

		button = NavigationButton.builder()
			.name("GE Offers")
			.icon(icon)
			.panel(panel)
			.build();

		pluginToolbar.addNavigation(button);

		itemClick = new MouseListener()
		{
			@Override
			public MouseEvent mouseClicked(MouseEvent e)
			{
				// Check if left click + alt
				if (e.getButton() == MouseEvent.BUTTON1 && e.isAltDown())
				{
					Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
					if (inventoryWidget != null && !inventoryWidget.isHidden())
					{
						if (findAndSearch(inventoryWidget.getWidgetItems().toArray(new WidgetItem[0])))
						{
							e.consume();
							return super.mouseClicked(e);
						}
					}

					// Check the inventory when the bank is open aswell
					Widget bankInventoryWidget = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);
					if (bankInventoryWidget != null && !bankInventoryWidget.isHidden())
					{
						if (findAndSearch(bankInventoryWidget.getDynamicChildren()))
						{
							e.consume();
							return super.mouseClicked(e);
						}
					}

					Widget bankWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
					if (bankWidget != null && !bankWidget.isHidden())
					{
						// Use bank item query for only checking the active tab
						if (findAndSearch(new BankItemQuery().result(client)))
						{
							e.consume();
							return super.mouseClicked(e);
						}
					}
				}

				return super.mouseClicked(e);
			}

			private boolean findAndSearch(Widget[] widgets)
			{
				Point mousePosition = client.getMouseCanvasPosition();
				for (Widget widget : widgets)
				{
					if (widget.getBounds().contains(mousePosition.getX(), mousePosition.getY()))
					{
						ItemComposition itemComposition = itemManager.getItemComposition(widget.getItemId());
						search(itemComposition);
						return true;
					}
				}
				return false;
			}

			/**
			 * Finds the item clicked based on the mouse location
			 * @param items
			 * @return true if an item is found, false otherwise
			 */
			private boolean findAndSearch(WidgetItem[] items)
			{
				Point mousePosition = client.getMouseCanvasPosition();
				for (WidgetItem item : items)
				{
					if (item.getCanvasBounds().contains(mousePosition.getX(), mousePosition.getY()))
					{
						ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
						search(itemComposition);
						return true;
					}
				}
				return false;
			}

			private void search(ItemComposition itemComposition)
			{
				SwingUtilities.invokeLater(() ->
				{
					panel.showSearch();

					if (!button.isSelected())
					{
						button.getOnSelect().run();
					}

					panel.getSearchPanel().priceLookup(itemComposition.getName());
				});
			}
		};

		if (config.quickLookup())
		{
			mouseManager.registerMouseListener(itemClick);
		}
	}

	@Override
	protected void shutDown()
	{
		pluginToolbar.removeNavigation(button);
		mouseManager.unregisterMouseListener(itemClick);
	}

	@Subscribe
	public void onConfigChange(ConfigChanged event)
	{
		if (event.getGroup().equals("grandexchange"))
		{
			if (event.getKey().equals("quickLookup"))
			{
				if (config.quickLookup())
				{
					mouseManager.registerMouseListener(itemClick);
				}
				else
				{
					mouseManager.unregisterMouseListener(itemClick);
				}
			}
		}
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged offerEvent)
	{
		GrandExchangeOffer offer = offerEvent.getOffer();
		ItemComposition offerItem = itemManager.getItemComposition(offer.getItemId());
		boolean shouldStack = offerItem.isStackable() || offer.getTotalQuantity() > 1;
		BufferedImage itemImage = itemManager.getImage(offer.getItemId(), offer.getTotalQuantity(), shouldStack);
		SwingUtilities.invokeLater(() -> panel.updateOffer(offerItem, itemImage, offerEvent.getOffer(), offerEvent.getSlot()));
	}
}
