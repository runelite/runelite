/*
 * Copyright (c) 2025, Peter Grønbæk Andersen <peter@grnbk.io>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.droppartychest;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.QuantityFormatter;
import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Drop Party Chest",
	description = "Display value of the party room and clan hall chests.",
	tags = {"party", "room", "clan", "hall", "chest", "value"}
)
public class DropPartyChestPlugin extends Plugin
{
	private static final int CLANHALL_CHEST_ITEMS_CONTAINER_ID = 33684;
	private static final int CLANHALL_CHEST_TITLE_WIDGET_ID = 51314689;
	private static final String CLANHALL_CHEST_TITLE = "Clan Party Drop Chest";
	private static final int PARTYROOM_CHEST_ITEMS_CONTAINER_ID = 91;
	private static final int PARTYROOM_CHEST_TITLE_WIDGET_ID = 17367041;
	private static final String PARTYROOM_CHEST_TITLE = "Party Drop Chest";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ItemManager itemManager;

	@Inject
	private DropPartyChestConfig config;

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		int containerId = event.getContainerId();

		if (containerId == PARTYROOM_CHEST_ITEMS_CONTAINER_ID)
		{
			updateChestItemsValue(containerId, PARTYROOM_CHEST_TITLE_WIDGET_ID, PARTYROOM_CHEST_TITLE);
		}
		else if (containerId == CLANHALL_CHEST_ITEMS_CONTAINER_ID)
		{
			updateChestItemsValue(containerId, CLANHALL_CHEST_TITLE_WIDGET_ID, CLANHALL_CHEST_TITLE);
		}
	}

	private void updateChestItemsValue(int containerId, int widgetId, String title)
	{
		final Widget titleContainer = client.getWidget(widgetId);
		if (titleContainer == null)
		{
			return;
		}

		final Widget titleWidget = titleContainer.getChild(1);
		if (titleWidget == null)
		{
			return;
		}

		ItemContainer itemContainer = client.getItemContainer(containerId);
		if (itemContainer != null)
		{
			final long totalChestItemsValue = getTotalGrandExchangeValue(itemContainer.getItems());
			if (totalChestItemsValue > 0)
			{
				final String totalChestValueText = createValueText(totalChestItemsValue);
				titleWidget.setText(title + totalChestValueText);
			}
			else
			{
				titleWidget.setText(title);
			}
		}
	}

	long getTotalGrandExchangeValue(Item[] items)
	{
		long grandExchangeValue = 0;

		for (Item item : items)
		{
			if (item != null)
			{
				grandExchangeValue += (long) itemManager.getItemPrice(item.getId()) * item.getQuantity();
			}
		}

		return grandExchangeValue;
	}

	private String createValueText(long grandExchangeValue)
	{
		StringBuilder stringBuilder = new StringBuilder();
		if (grandExchangeValue != 0)
		{
			stringBuilder.append(" (");

			if (config.showExact())
			{
				stringBuilder.append(QuantityFormatter.formatNumber(grandExchangeValue));
			}
			else
			{
				stringBuilder.append(QuantityFormatter.quantityToStackSize(grandExchangeValue));
			}
			stringBuilder.append(')');
		}

		return stringBuilder.toString();
	}

	@Provides
	DropPartyChestConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DropPartyChestConfig.class);
	}
}
