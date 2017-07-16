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
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.client.game.ItemManager;
import net.runelite.client.RuneLite;
import net.runelite.client.events.SetMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PriceCommands extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(PriceCommands.class);

	private final ItemManager itemManager = RuneLite.getRunelite().getItemManager();
	private final ItemClient itemClient = new ItemClient();
	private final RuneLite runelite = RuneLite.getRunelite();
	private final Client client = RuneLite.getClient();

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		switch (setMessage.getType())
		{
			case PUBLIC:
			case CLANCHAT:
			case PRIVATE_MESSAGE_RECEIVED:
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

		if (result != null && result.getItems().size() == 1)
		{
			int itemId = result.getItems().get(0).getId();
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

			int cost = itemPrice.getPrice();
			String response = "Price of " + result.getItems().get(0).getName() + ": GE average " + String.format("%,d", cost);

			logger.debug("Setting response {}", response);
			messageNode.setValue(response);
			client.refreshChat();
		}
	}
}
