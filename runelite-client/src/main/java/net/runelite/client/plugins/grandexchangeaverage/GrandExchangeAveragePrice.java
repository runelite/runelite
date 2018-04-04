package net.runelite.client.plugins.grandexchangeaverage;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
public class GrandExchangeAveragePrice {

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

    public int getPrice(int itemId) {

        if(storedItemId == itemId)
        {
            return storedItemPrice;
        }

        try {
            ItemPrice itemPrice = itemManager.getItemPrice(itemId);
            storedItemPrice = itemPrice.getPrice();
            storedItemId = itemId;
            return storedItemPrice;
        } catch (Throwable ex) {
            log.debug("Error looking up item prices", ex);
            return -1;
        }
    }

    public int getTradedPrice(int itemId)
    {
        if(storedItemId == itemId)
        {
            return storedItemPrice;
        }

        //http://api.rsbuddy.com/grandExchange?a=guidePrice&i=12625
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.rsbuddy.com/grandExchange?a=guidePrice&i=" + itemId)
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
        } catch (Throwable ex) {
            log.debug("Error looking up item prices", ex);
            return -1;
        }

        JsonObject priceObject;
        try {
            priceObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
        } catch (Throwable ex) {
            log.debug("Couldn't extract JSON.");
            return -1;
        }

        int averagePrice = priceObject.get("overall").getAsInt();

        storedItemId = itemId;
        storedItemPrice = averagePrice;


        return averagePrice;

    }
}
