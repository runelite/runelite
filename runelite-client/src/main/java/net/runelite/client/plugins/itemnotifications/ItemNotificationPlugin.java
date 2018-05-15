/*
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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

package net.runelite.client.plugins.itemnotifications;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Item Notifications"
)
public class ItemNotificationPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ItemNotificationConfig config;

	@Inject
	private Notifier notifier;

	@Provides
	ItemNotificationConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemNotificationConfig.class);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		ChatMessageType messageType = event.getType();

		if (messageType != ChatMessageType.SERVER && messageType != ChatMessageType.FILTERED)
		{
			return;
		}

		final int notificationDelay = config.notificationDelay() * 1000;

		String chatMessage = event.getMessage();

		switch (chatMessage)
		{
			case "<col=7f007f>Your Ring of Recoil has shattered.</col>":
				if (config.notifyOnRecoilBreak())
					notifier.notify("Your Ring of Recoil has shattered");
				break;

			case "...and the world changes around you.": // ectophial teleported message
				if (config.notifyOnEmptyEctophial())
					notifyIfNotPresent(
						"Ectophial",
						ItemID.ECTOPHIAL,
						notificationDelay,
						"You forgot to refill your Ectophial!"
					);
				break;
		}
	}

	/**
	 * @param itemName name of item that will be used in notification
	 * @param itemId item id to check for
	 * @param waitDelay wait delay before notification appears (if item id is not present)
	 * @param notifyMessage optional message to override default message
	 */
	private void notifyIfNotPresent(String itemName, int itemId, int waitDelay, String... notifyMessage)
	{
		Timer timer = new Timer();

		TimerTask notifyTask = new TimerTask()
		{
			@Override
			public void run()
			{
				ArrayList<Integer> inventory = new ArrayList<>();
				Item[] inventoryItems = client.getItemContainer(InventoryID.INVENTORY).getItems();

				for (Item item : inventoryItems)
				{
					inventory.add(item.getId());
				}

				if (!inventory.contains(itemId))
				{
					if (notifyMessage == null)
					{
						notifier.notify(String.format("Item %s is missing from your inventory.", itemName));
					}
					else
					{
						notifier.notify(String.format(notifyMessage[0], itemName));
					}
				}
			}
		};

		timer.schedule(notifyTask, waitDelay);
	}
}
