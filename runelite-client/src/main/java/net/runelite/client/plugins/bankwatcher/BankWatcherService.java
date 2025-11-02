package net.runelite.client.plugins.bankwatcher;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.game.ItemManager;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BankWatcherService
{
    @Inject
    private Client client;

    @Inject
    private ItemManager itemManager;

    /**
     * Scans the player's bank and returns a list of tradeable items with their GE prices.
     */
    public List<BankItem> scanBank()
    {
        ItemContainer bankItems = client.getItemContainer(InventoryID.BANK);

        if (bankItems == null)
        {
            log.info("There are no bank items at this time.");
            return new ArrayList<>();
        }

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

            int gePrice = itemManager.getItemPrice(item.getId());
            int quantity = item.getQuantity();
            int totalPrice = gePrice * quantity;
            String name = comp.getName();

            trackedItems.add(new BankItem(name, gePrice, totalPrice, quantity));
        }

        log.info("Tracked bank items: {}", trackedItems);
        return trackedItems;
    }
}
