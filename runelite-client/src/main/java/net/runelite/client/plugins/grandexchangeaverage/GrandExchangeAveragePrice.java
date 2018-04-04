package net.runelite.client.plugins.grandexchangeaverage;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.ItemPrice;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.inject.Inject;

@Slf4j
public class GrandExchangeAveragePrice
{

	private final Client client;
	private final GrandExchangeAverageConfig config;
	private final ItemManager itemManager;

	private int storedItemId;
	private int storedItemPrice;

	@Inject
	GrandExchangeAveragePrice(Client client, ItemManager itemManager, GrandExchangeAverageConfig config)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.config = config;
	}

	//Gets the price of an item using ItemManager.
	// UNUSED ATM
	public int getPrice(int itemId)
	{

		//If we already checked the price of this item, do not do it again.
		if (storedItemId == itemId)
		{
			return storedItemPrice;
		}

		try
		{
			ItemPrice itemPrice = itemManager.getItemPrice(itemId);
			storedItemPrice = itemPrice.getPrice();
			storedItemId = itemId;
			return storedItemPrice;
		}
		catch (Throwable ex)
		{
			log.debug("Error looking up item prices", ex);
			return -1;
		}
	}

	//Gets the price of an item using OSBuddy Exchange API.
	public int getTradedPrice(int itemId)
	{
		//If we already checked the price of this item, do not do it again.
		if (storedItemId == itemId)
		{
			return storedItemPrice;
		}

		//http://api.rsbuddy.com/grandExchange?a=guidePrice&i=ITEMID
		//Create a new request to OSBuddy API.
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("http://api.rsbuddy.com/grandExchange?a=guidePrice&i=" + itemId)
				.build();

		//Send the request sync.
		Response response;
		try
		{
			response = client.newCall(request).execute();
		}
		catch (Throwable ex)
		{
			log.debug("Error looking up item prices", ex);
			return -1;
		}

		//Parse the JSON.
		JsonObject priceObject;
		try
		{
			priceObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
		}
		catch (Throwable ex)
		{
			log.debug("Couldn't extract JSON.");
			return -1;
		}

		//Grab the overall price.
		int averagePrice = priceObject.get("overall").getAsInt();

		storedItemId = itemId;
		storedItemPrice = averagePrice;


		return averagePrice;

	}
}
