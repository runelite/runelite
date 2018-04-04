package net.runelite.client.plugins.grandexchangeaverage;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;

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

    public int getAveragePrice(int itemId) {

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
}
