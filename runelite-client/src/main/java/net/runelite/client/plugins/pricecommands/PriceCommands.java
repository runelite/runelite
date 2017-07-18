/*
 * Copyright (c) 2017. l2-
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.pricecommands;

import com.google.common.eventbus.Subscribe;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.http.api.item.Item;
import net.runelite.api.MessageNode;
import net.runelite.client.game.ItemManager;
import net.runelite.client.RuneLite;
import net.runelite.client.events.SetMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import net.runelite.rs.api.ItemComposition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PriceCommands extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(PriceCommands.class);

	private final PriceCommandsConfig config = RuneLite.getRunelite().getConfigManager().getConfig(PriceCommandsConfig.class);
	private final ItemManager itemManager = RuneLite.getRunelite().getItemManager();
	private final ItemClient itemClient = new ItemClient();
	private final RuneLite runelite = RuneLite.getRunelite();
	private final Client client = RuneLite.getClient();

	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{
	}

	/**
	 * Checks if the chat message is a command.
	 * @param setMessage The chat message
	 */
	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return;
		}

		switch (setMessage.getType())
		{
			case PUBLIC:
			case CLANCHAT:
			case PRIVATE_MESSAGE_RECEIVED:
			case PRIVATE_MESSAGE_SENT:
				break;
			default:
				return;
		}

		String message = setMessage.getValue();

		if (message.toLowerCase().startsWith("!price") && message.length() > 7)
		{
			String search = message.substring(7);

			logger.debug("Running lookup for {}", search);

			ScheduledExecutorService executor = runelite.getExecutor();
			executor.submit(() -> lookup(setMessage.getMessageNode(), search));
		}
	}

	/**
	 * Looks up the item price and changes the original message to the reponse.
	 * @param messageNode The chat message containing the command.
	 * @param search The item given with the command.
	 */
	private void lookup(MessageNode messageNode, String search)
	{
		SearchResult result;

		try
		{
			result = itemClient.search(search);
		}
		catch (IOException ex)
		{
			logger.warn("Unable to search for item {}", search, ex);
			return;
		}

		if (result != null && result.getItems().size() > 0)
		{
			Item tempItem = retrieveFromList(result.getItems(), search);
			if (tempItem == null)
			{
				logger.warn("Unable to fetch item price for {}", search);
				return;
			}
			int itemId = tempItem.getId();
			ItemPrice itemPrice;

			try
			{
				itemPrice = itemManager.getItemPrice(itemId);
			}
			catch (IOException ex)
			{
				logger.warn("Unable to fetch item price for {}", itemId, ex);
				return;
			}

			ItemComposition itemComposition = client.getItemDefinition(itemId);
			int HaPrice = -1;
			if (itemComposition != null)
			{
				HaPrice = Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT);
			}
			int GePrice = itemPrice.getPrice();
			String response = "Price of " + result.getItems().get(0).getName() + ": GE average " + String.format("%,d", GePrice) + " HA value " + String.format("%,d", HaPrice);

			logger.debug("Setting response {}", response);

			// XXX hopefully messageNode hasn't been reused yet?
			messageNode.setValue(response);
			client.refreshChat();
		}
	}

	/**
	 * Compares the names of the items in the list with the original input. returns the item if its name is equal to the original input or null if it can't find the item.
	 * @param items List of items.
	 * @param originalInput String with the original input.
	 * @return Item which has a name equal to the original input.
	 */
	private Item retrieveFromList(List<Item> items, String originalInput)
	{
		for (Item item : items)
		{
			if (item.getName().toLowerCase().equals(originalInput.toLowerCase()))
			{
				return item;
			}
		}
		return null;
	}
}
