package net.runelite.client.plugins.bankwatcher;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.InventoryID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.*;

@Slf4j
public class BankWatcherService
{
    @Inject
    private Client client;

    @Inject
    private ItemManager itemManager;

    @Inject
    private ConfigManager configManager;

    private final OkHttpClient httpClient = new OkHttpClient();
    private final Map<Integer, Integer> previousTotals = new HashMap<>();
    private final Map<Integer, Integer> wikiPrices = new HashMap<>();

    private static final String CONFIG_GROUP = "bankwatcher";
    private static final String PREVIOUS_TOTALS_KEY = "previousTotals";
    private final Gson gson = new Gson();

    /**
     * Fetches the latest prices from the OSRS Wiki API in batches of up to 100 item IDs per request.
     */
    private void fetchWikiPrices()
    {
        wikiPrices.clear();
        String baseUrl = "https://api.weirdgloop.org/exchange/history/osrs/latest";

        try
        {
            ItemContainer bank = client.getItemContainer(InventoryID.BANK);
            if (bank == null)
            {
                log.warn("No bank items found. Skipping price fetch.");
                return;
            }

            List<Integer> allItemIds = new ArrayList<>();
            for (Item item : bank.getItems())
            {
                if (item != null && item.getId() > 0)
                {
                    allItemIds.add(item.getId());
                }
            }

            int batchSize = 100;
            for (int i = 0; i < allItemIds.size(); i += batchSize)
            {
                List<Integer> batch = allItemIds.subList(i, Math.min(i + batchSize, allItemIds.size()));
                String joinedIds = String.join("|", batch.stream().map(String::valueOf).toArray(String[]::new));
                String url = baseUrl + "?id=" + joinedIds;

                Request request = new Request.Builder()
                        .url(url)
                        .header("User-Agent", "bankwatcher-plugin (contact: yourname@example.com)")
                        .build();

                try (Response response = httpClient.newCall(request).execute())
                {
                    if (response.isSuccessful() && response.body() != null)
                    {
                        JSONObject json = new JSONObject(response.body().string());

                        for (String key : json.keySet())
                        {
                            JSONObject item = json.getJSONObject(key);
                            int price = item.optInt("price", -1);
                            if (price > 0)
                            {
                                wikiPrices.put(Integer.parseInt(key), price);
                            }
                        }

                        log.info("Fetched {} items for batch starting at index {}.", batch.size(), i);
                    }
                    else
                    {
                        log.warn("Failed to fetch Wiki prices for batch starting at index {}. Code: {}", i, response.code());
                    }
                }

                Thread.sleep(200);
            }

            log.info("Fetched {} total live prices from WeirdGloop API.", wikiPrices.size());
        }
        catch (Exception e)
        {
            log.warn("Error fetching Wiki prices: ", e);
        }
    }

    /**
     * Loads saved totals from RuneLite config (persistent between sessions).
     */
    private void loadPreviousTotals()
    {
        try
        {
            String json = configManager.getConfiguration(CONFIG_GROUP, PREVIOUS_TOTALS_KEY);
            if (json != null && !json.isEmpty())
            {
                Type type = new TypeToken<Map<Integer, Integer>>(){}.getType();
                Map<Integer, Integer> loaded = gson.fromJson(json, type);
                if (loaded != null)
                {
                    previousTotals.putAll(loaded);
                    log.info("Loaded {} saved totals from config.", loaded.size());
                }
            }
        }
        catch (Exception e)
        {
            log.warn("Failed to load previous totals from config.", e);
        }
    }

    /**
     * Saves current totals to RuneLite config (persists between sessions).
     */
    private void savePreviousTotals()
    {
        try
        {
            String json = gson.toJson(previousTotals);
            configManager.setConfiguration(CONFIG_GROUP, PREVIOUS_TOTALS_KEY, json);
            log.info("Saved {} totals to config.", previousTotals.size());
        }
        catch (Exception e)
        {
            log.warn("Failed to save previous totals to config.", e);
        }
    }

    /**
     * Scans the player's bank and returns a list of tradeable items with live Wiki or GE prices.
     */
    public List<BankItem> scanBank()
    {
        loadPreviousTotals(); // 🔹 Load saved totals first
        ItemContainer bankItems = client.getItemContainer(InventoryID.BANK);

        if (bankItems == null)
        {
            log.info("There are no bank items at this time.");
            return new ArrayList<>();
        }

        fetchWikiPrices();

        List<BankItem> trackedItems = new ArrayList<>();

        for (Item item : bankItems.getItems())
        {
            if (item == null || item.getId() == -1)
            {
                continue;
            }

            ItemComposition comp = itemManager.getItemComposition(item.getId());
            if (!comp.isTradeable())
            {
                continue;
            }

            int itemId = item.getId();
            int gePrice = wikiPrices.getOrDefault(itemId, itemManager.getItemPrice(itemId));
            int quantity = item.getQuantity();
            int totalPrice = gePrice * quantity;

            int previousPrice = previousTotals.getOrDefault(itemId, totalPrice);
            int delta = totalPrice - previousPrice;

            previousTotals.put(itemId, totalPrice);
            String name = comp.getName();

            trackedItems.add(new BankItem(name, gePrice, totalPrice, quantity, delta));
        }

        savePreviousTotals(); // 🔹 Persist totals after scanning

        log.info("Tracked bank items: {}", trackedItems);
        return trackedItems;
    }
}
