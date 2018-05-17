package net.runelite.client.plugins.grounditems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class RealTimePrices implements Runnable
{
	private Thread thread;

	private final GroundItem groundItem;
	private final GroundItemsPlugin plugin;

	RealTimePrices(GroundItem groundItem, GroundItemsPlugin plugin)
	{
		this.groundItem = groundItem;
		this.plugin = plugin;
	}

	@Override
	public void run()
	{
		try
		{
			Document document = Jsoup.connect(String.format("https://www.ge-tracker.com/item/%s", groundItem.getName().replace(" ", "-").toLowerCase())).timeout(6000).get();

			String buyPriceString = document.getElementById("item_stat_offer_price").text();
			String sellPriceString = document.getElementById("item_stat_sell_price").text();

			if (buyPriceString != null && sellPriceString != null)
			{
				buyPriceString = buyPriceString.replace(",", "");
				sellPriceString = sellPriceString.replace(",", "");

				Integer buyPrice = Integer.parseInt(buyPriceString);
				Integer sellPrice = Integer.parseInt(sellPriceString);

				if(buyPrice != null && sellPrice != null)
				{
					plugin.addRealTimePrice(new RealTimePrice(groundItem.getName(), buyPrice, sellPrice, System.currentTimeMillis()));

					groundItem.setBuyPrice(buyPrice);
					groundItem.setSellPrice(sellPrice);
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void start()
	{
		thread = new Thread(this);
		thread.start();
	}
}
