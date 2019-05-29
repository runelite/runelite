/*
 * Copyright (c) 2018, David Jablonski <https://github.com/dayjaby>
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
package net.runelite.client.plugins.gelogger;

import com.google.inject.Provides;
import lombok.extern.java.Log;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

@Log
@PluginDescriptor(
	name = "GE Logger",
	description = "Logs all your activities in GE",
	tags = {"grand", "exchange", "log"}
)
public class GELoggerPlugin extends Plugin
{
	HashMap<Integer, GEHistoryItem> latest_offers = new HashMap<>(8);
	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private GELoggerConfig config;

	@Provides
	GELoggerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GELoggerConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			latest_offers.clear();
		}
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged offerEvent)
	{
		GrandExchangeOffer offer = offerEvent.getOffer();
		ItemComposition offerItem = itemManager.getItemComposition(offer.getItemId());
		boolean buying = offer.getState() == GrandExchangeOfferState.BOUGHT
				|| offer.getState() == GrandExchangeOfferState.BUYING
				|| offer.getState() == GrandExchangeOfferState.CANCELLED_BUY;
		if (offer.getState() == GrandExchangeOfferState.EMPTY)
		{
			logMerch(latest_offers.get(offerEvent.getSlot()));
			latest_offers.remove(offerEvent.getSlot());
		}
		else
		{
			GEHistoryItem history_item = new GEHistoryItem(buying,  offerItem.getName(), offer.getItemId(), offer.getSpent(), offer.getQuantitySold());
			latest_offers.put(offerEvent.getSlot(), history_item);
		}
	}

	public void logMerch(GEHistoryItem item)
	{
		if (item != null && item.amount > 0)
		{
			try
			{
				BufferedWriter logger = new BufferedWriter(new FileWriter(config.logFile(), true));
				logger.write(item.toString());
				logger.newLine();
				logger.close();
				log.info(item.toString());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public class GEHistoryItem
	{
		public Boolean bought;
		public String item;
		public Integer itemid;
		public Integer total_price;
		public Integer amount;

		public GEHistoryItem(boolean bought, String item, int itemid, int total_price, int amount)
		{
			this.bought = bought;
			this.item = item;
			this.itemid = itemid;
			this.total_price = total_price;
			this.amount = amount;
		}

		@Override public String toString()
		{
			String res = Integer.toString(itemid) + "\t";
			res += item + "\t";
			res += (bought ? "1\t" : "0\t");
			res += Integer.toString(amount) + "\t";
			res += Integer.toString(total_price) + "\t";
			res += Long.toString(System.currentTimeMillis());
			return res;
		}
	}
}
