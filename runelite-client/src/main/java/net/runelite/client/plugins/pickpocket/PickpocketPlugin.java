/*
 * Copyright (c) 2018, John Pettenger
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
package net.runelite.client.plugins.pickpocket;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.ChatMessageType;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import java.util.Arrays;
import java.util.HashMap;

@PluginDescriptor(
	name = "Pickpocketing",
	description = "Show pickpocketing notifications",
	tags = {"coin", "pouch", "pickpocketing"},
	enabledByDefault = false
)
public class PickpocketPlugin extends Plugin
{
	private static final String MAX_COIN_POUCHES_MESSAGE = "You need to empty your coin pouches before you can continue pickpocketing.";

	private static final int MAX_NUM_COIN_POUCHES = 28;

	private static final int[] coinPouchIds = new int[]
	{
		ItemID.COIN_POUCH_22522, ItemID.COIN_POUCH_22523, ItemID.COIN_POUCH_22524,
		ItemID.COIN_POUCH_22525, ItemID.COIN_POUCH_22526, ItemID.COIN_POUCH_22527,
		ItemID.COIN_POUCH_22528, ItemID.COIN_POUCH_22529, ItemID.COIN_POUCH_22530,
		ItemID.COIN_POUCH_22531, ItemID.COIN_POUCH_22532, ItemID.COIN_POUCH_22533,
		ItemID.COIN_POUCH_22534, ItemID.COIN_POUCH_22535, ItemID.COIN_POUCH_22536,
		ItemID.COIN_POUCH_22537, ItemID.COIN_POUCH_22538, ItemID.COIN_POUCH
	};

	@Inject
	private Client client;

	@Inject
	private Notifier notifier;

	@Inject
	private PickpocketConfig config;

	private HashMap<Integer, Integer> prevNumCoinPouches;

	private long lastCoinPouchNotifyTime;

	@Provides
	PickpocketConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PickpocketConfig.class);
	}

	@Override
	public void startUp()
	{
		prevNumCoinPouches = new HashMap<>(coinPouchIds.length);
		Arrays.stream(coinPouchIds).forEach(id -> prevNumCoinPouches.put(id, 0));

		if (config.coinPouchNotify())
		{
			updatePrevNumCoinPouches();
		}
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged event)
	{
		if (event.getGroup().equals("pickpocket"))
		{
			if (event.getKey().equals("coinPouchNotify"))
			{
				if (config.coinPouchNotify())
				{
					updatePrevNumCoinPouches();
				}
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

		if (config.coinPouchNotify() && inventory != null && event.getItemContainer() == inventory)
		{
			checkCoinPouchCounts(inventory);
		}
	}

	@Subscribe
	public void onChatMessage(final ChatMessage event)
	{
		if (config.coinPouchNotify())
		{
			if (event.getType() != ChatMessageType.SERVER)
			{
				return;
			}
			if (event.getMessage().equals(MAX_COIN_POUCHES_MESSAGE))
			{
				notifyMaxPouches();
			}
		}
	}

	private void checkCoinPouchCounts(final ItemContainer inventory)
	{
		boolean shouldNotify = Arrays.stream(inventory.getItems())
			.filter(item -> prevNumCoinPouches.containsKey(item.getId()))
			.anyMatch(item ->
			{
				int prevQuantity = prevNumCoinPouches.get(item.getId());
				int newQuantity = item.getQuantity();
				return newQuantity == MAX_NUM_COIN_POUCHES && newQuantity > prevQuantity && prevQuantity != 0;
			});
		if (shouldNotify)
		{
			notifyMaxPouches();
		}
		updatePrevNumCoinPouches(inventory);
	}

	private void updatePrevNumCoinPouches()
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		updatePrevNumCoinPouches(inventory);
	}

	private void updatePrevNumCoinPouches(final ItemContainer itemContainer)
	{
		if (itemContainer != null)
		{
			Arrays.stream(itemContainer.getItems())
				.filter(item -> prevNumCoinPouches.containsKey(item.getId()))
				.forEach(item -> prevNumCoinPouches.put(item.getId(), item.getQuantity()));
		}
	}

	private void notifyMaxPouches()
	{
		final long wait = 5000L;
		long currentTime = System.currentTimeMillis();

		// Don't spam the user with notifications.
		if (currentTime - lastCoinPouchNotifyTime >= wait)
		{
			notifier.notify(String.format(
				"%s cannot hold anymore coin pouches.",
				client.getLocalPlayer().getName()));
			lastCoinPouchNotifyTime = currentTime;
		}
	}
}
