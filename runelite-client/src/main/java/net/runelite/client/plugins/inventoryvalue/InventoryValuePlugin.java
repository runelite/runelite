package net.runelite.client.plugins.inventoryvalue;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

@PluginDescriptor(name = "Inventory Value Tracker")
@Slf4j
public class InventoryValuePlugin extends Plugin {
    @Inject private Client client;

    @Inject private InventoryValueConfig config;

    @Inject private ItemManager itemManager;

    @Inject private OverlayManager overlayManager;

    @Inject private InventoryValueOverlay overlay;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {}

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event) {
        if (event.getContainerId() == InventoryID.INVENTORY.getId()) {
            long inventoryValue;
            List<String> ignoredItems = buildIgnoredItemsList();

            ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);
            if (container != null) {
                Item[] items = container.getItems();
                inventoryValue = Arrays.stream(items).parallel().flatMapToLong(item ->
                        LongStream.of(calculateItemValue(item, ignoredItems))).sum();

                overlay.updateInventoryValue(inventoryValue);
            }
        }
    }

    public List<String> buildIgnoredItemsList() {
        List<String> ignoredItemsList = Arrays.asList(config.ignoreItems().toLowerCase().split("[,;]"));
        ignoredItemsList.replaceAll(String::trim);
        return ignoredItemsList;
    }

    public long calculateItemValue(Item item, List<String> ignoredItems) {
        int itemId = item.getId();
        ItemComposition itemComposition = itemManager.getItemComposition(itemId);
        String itemName = itemComposition.getName();

        if ((itemId == ItemID.COINS_995 && config.ignoreCoins()) || ignoredItems.contains(itemName.toLowerCase())) return 0;
        return (long) item.getQuantity() * (config.useHighAlchemyValue() ?
                itemComposition.getHaPrice() : itemManager.getItemPrice(item.getId()));
    }

    @Provides
    InventoryValueConfig provideConfig(ConfigManager configManager){
        return configManager.getConfig(InventoryValueConfig.class);
    }
}
