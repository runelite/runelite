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
import java.time.LocalDate;

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
    private final Gson gson = new Gson();

    private final Map<Integer, Integer> previousTotals = new HashMap<>();
    private final Map<Integer, Integer> previousQuantities = new HashMap<>();
    private final Map<Integer, Integer> wikiPrices = new HashMap<>();

    private static final String SCAN_COUNT_KEY = "scan_count";
    private static final String LAST_RESET_KEY = "scan_reset_day";
    private static final int MAX_SCANS_PER_DAY = 4;

    private static final String QUANTITY_SNAPSHOT_KEY = "bank_quantities";
    private static final String CONFIG_GROUP = "bankwatcher";
    private static final String SNAPSHOT_KEY = "bank_snapshot";

    private boolean snapshotLoaded = false;

    public boolean canScan()
    {
        String today = LocalDate.now().toString(); // e.g. "2025-11-03"
        String lastResetDay = configManager.getConfiguration(CONFIG_GROUP, LAST_RESET_KEY);
        int scanCount = 0;

        try
        {
            String countStr = configManager.getConfiguration(CONFIG_GROUP, SCAN_COUNT_KEY);
            if (countStr != null)
                scanCount = Integer.parseInt(countStr);
        }
        catch (Exception ignored) {}

        // 🔹 If new day → reset count to 0
        if (lastResetDay == null || !lastResetDay.equals(today))
        {
            scanCount = 0;
            configManager.setConfiguration(CONFIG_GROUP, LAST_RESET_KEY, today);
            configManager.setConfiguration(CONFIG_GROUP, SCAN_COUNT_KEY, "0");
        }

        // 🔹 If user still has scans left today
        if (scanCount < MAX_SCANS_PER_DAY)
        {
            scanCount++;
            configManager.setConfiguration(CONFIG_GROUP, SCAN_COUNT_KEY, String.valueOf(scanCount));
            configManager.sendConfig();
            return true;
        }


        return false;
    }

    public String getScanStatusText()
    {
        String today = LocalDate.now().toString();
        String lastResetDay = configManager.getConfiguration(CONFIG_GROUP, LAST_RESET_KEY);
        int scanCount = 0;

        try
        {
            String countStr = configManager.getConfiguration(CONFIG_GROUP, SCAN_COUNT_KEY);
            if (countStr != null)
                scanCount = Integer.parseInt(countStr);
        }
        catch (Exception ignored) {}


        boolean newDay = (lastResetDay == null || !lastResetDay.equals(today));
        if (newDay)
        {
            return String.format("You’ve used 0/%d scans today. Daily reset active.", MAX_SCANS_PER_DAY);
        }

        return String.format("You have used %d/%d scans today. Next reset at midnight.", scanCount, MAX_SCANS_PER_DAY);
    }

    /**
     * Fetch the latest prices from the OSRS Wiki API (WeirdGloop).
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
                            JSONObject itemJson = json.getJSONObject(key);
                            int price = itemJson.optInt("price", -1);
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
     * Loads the previously saved snapshot from RuneLite config (runs only once).
     */
    private void loadSnapshot()
    {
        if (snapshotLoaded) return;
        snapshotLoaded = true;

        try
        {
            // Load total values
            String totalsJson = configManager.getConfiguration(CONFIG_GROUP, SNAPSHOT_KEY);
            if (totalsJson != null && !totalsJson.isEmpty())
            {
                Type type = new TypeToken<Map<Integer, Integer>>(){}.getType();
                Map<Integer, Integer> loaded = gson.fromJson(totalsJson, type);
                if (loaded != null)
                {
                    previousTotals.clear();
                    previousTotals.putAll(loaded);
                    log.info("Loaded {} saved totals from config.", loaded.size());
                }
            }

            // Load quantities
            String qtyJson = configManager.getConfiguration(CONFIG_GROUP, QUANTITY_SNAPSHOT_KEY);
            if (qtyJson != null && !qtyJson.isEmpty())
            {
                Type type = new TypeToken<Map<Integer, Integer>>(){}.getType();
                Map<Integer, Integer> loadedQty = gson.fromJson(qtyJson, type);
                if (loadedQty != null)
                {
                    previousQuantities.clear();
                    previousQuantities.putAll(loadedQty);
                    log.info("Loaded {} saved quantities from config.", loadedQty.size());
                }
            }

            if (previousTotals.isEmpty() && previousQuantities.isEmpty())
            {
                log.info("No saved snapshot found — starting fresh.");
            }
        }
        catch (Exception e)
        {
            log.warn("Failed to load snapshot from config.", e);
        }
    }

    /**
     * Saves the latest snapshot of total values to RuneLite config.
     */
    private void saveSnapshot()
    {
        try
        {
            String totalsJson = gson.toJson(previousTotals);
            configManager.setConfiguration(CONFIG_GROUP, SNAPSHOT_KEY, totalsJson);

            String qtyJson = gson.toJson(previousQuantities);
            configManager.setConfiguration(CONFIG_GROUP, QUANTITY_SNAPSHOT_KEY, qtyJson);

            log.info("Saved {} totals and {} quantities to config.", previousTotals.size(), previousQuantities.size());
        }
        catch (Exception e)
        {
            log.warn("Failed to save snapshot to config.", e);
        }
    }

    /**
     * Scans the player's bank, calculates deltas, and persists totals.
     */
    public List<BankItem> scanBank()
    {
        loadSnapshot();

        ItemContainer bankItems = client.getItemContainer(InventoryID.BANK);
        if (bankItems == null)
        {
            log.info("No bank items found.");
            return Collections.emptyList();
        }

        fetchWikiPrices();

        List<BankItem> trackedItems = new ArrayList<>();

        for (Item item : bankItems.getItems())
        {
            if (item == null || item.getId() <= 0)
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

            int oldTotal = previousTotals.getOrDefault(itemId, totalPrice);
            int delta = totalPrice - oldTotal;

            int oldQuantity = previousQuantities.getOrDefault(itemId, quantity);
            int quantityDelta = quantity - oldQuantity;

            previousTotals.put(itemId, totalPrice);
            previousQuantities.put(itemId, quantity);

            // You’ll need to update BankItem class to include quantityDelta
            trackedItems.add(new BankItem(
                    itemId,
                    comp.getName(),
                    gePrice,
                    totalPrice,
                    quantity,
                    delta,
                    quantityDelta
            ));
        }

        saveSnapshot();

        log.info("Tracked {} bank items.", trackedItems.size());
        return trackedItems;
    }
}