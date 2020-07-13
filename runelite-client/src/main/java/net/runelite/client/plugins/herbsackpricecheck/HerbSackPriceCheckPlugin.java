/*
 * Copyright (c) 2017, Aquivers
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
package net.runelite.client.plugins.herbsackpricecheck;

import net.runelite.client.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import net.runelite.client.chat.ChatMessageBuilder;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import static net.runelite.api.ItemID.HERB_SACK;

@PluginDescriptor(
		name = "Herb sack price check",
		description = "Price checks the herbs in herb sack",
		tags = {"herbs", "prices"}
)

@Slf4j
public class HerbSackPriceCheckPlugin extends Plugin
{
	private static boolean gettingHerbs = false;
	private static ArrayList<ChatMessage> herbsInChatMessage = new ArrayList<>();

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private Client client;

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!event.getMenuOption().equals("Check") || event.getId() != HERB_SACK)
		{
			return;
		}
		gettingHerbs = true;
	}

	@Subscribe
	private void onChatMessage(ChatMessage message)
	{
		if (message.getType() != ChatMessageType.GAMEMESSAGE)
			return;

		if (message.getMessage().contains("x Grimy") && gettingHerbs)
		{
			herbsInChatMessage.add(message);
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		if (gettingHerbs && !herbsInChatMessage.isEmpty())
		{
			HashMap<String, Integer> herbsWithQuantity = reformatHerbChatMessages();
			int totalValue = herbPriceLookup(herbsWithQuantity);

			if (totalValue != -1)
			{
				buildValueMessage(totalValue);
			}

			gettingHerbs = false;
			herbsInChatMessage = new ArrayList<>();
		}
	}

	private HashMap<String, Integer> reformatHerbChatMessages()
	{
		HashMap<String, Integer> herbsWithQuantity = new HashMap<>();

		for (ChatMessage message : herbsInChatMessage)
		{
			String[] fullHerbName = message.getMessage().split("x");

			for (int i = 0; i < fullHerbName.length; i += 2)
			{
				herbsWithQuantity.put(fullHerbName[i + 1].trim(), Integer.parseInt(fullHerbName[i].trim()));
			}
		}

		return herbsWithQuantity;
	}

	private int herbPriceLookup(HashMap<String, Integer> herbsWithQuantity)
	{
		int totalValue = 0;
		for (Map.Entry<String, Integer> herbQuant : herbsWithQuantity.entrySet())
		{
			List<ItemPrice> results = itemManager.search(herbQuant.getKey());

			if(results != null && !results.isEmpty())
			{
				for(ItemPrice result : results)
				{
					totalValue += result.getPrice() * herbQuant.getValue();
				}
			}
		}

		return totalValue;
	}

	private Item retrieveFromList(List<Item> items, String herbName)
	{
		for (Item item : items)
		{
			if (item.getName().toLowerCase().equals(herbName.toLowerCase()))
			{
				return item;
			}
		}
		return null;
	}

	private void buildValueMessage(int totalValue)
	{
		final ChatMessageBuilder output = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Total value of herbs in sack: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(StackFormatter.formatNumber(totalValue));

		chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.ITEM_EXAMINE)
				.runeLiteFormattedMessage(output.build())
				.build());
	}
}
