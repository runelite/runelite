package net.runelite.client.plugins.fancyflip.wealth;

import com.google.inject.Inject;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.game.ItemManager;
import net.runelite.client.util.QuantityFormatter;

import static net.runelite.api.widgets.WidgetID.BANK_GROUP_ID;

@Singleton
public class WealthService
{
    private final Client client;
    private final ItemManager itemManager;

    @Getter
    private long bankCoins = 0;

    @Getter
    private long invCoins = 0;

    @Getter
    private long geCommittedCoins = 0;

    @Getter
    private long lastSampledTotalWealth = 0;

    @Getter
    private final Map<Instant, Long> wealthSamples = new HashMap<>();

    @Inject
    public WealthService(Client client, ItemManager itemManager)
    {
        this.client = client;
        this.itemManager = itemManager;
    }

    public void refreshInventoryCoins()
    {
        ItemContainer inv = client.getItemContainer(InventoryID.INVENTORY);
        if (inv != null)
        {
            invCoins = inv.count(995); // coin item ID
        }
    }

    public void snapshotBankCoins()
    {
        ItemContainer bank = client.getItemContainer(InventoryID.BANK);
        if (bank != null)
        {
            bankCoins = bank.count(995);
        }
    }

    public void refreshCommittedGp()
    {
        geCommittedCoins = 0;
        for (int slot = 0; slot < 8; slot++)
        {
            GrandExchangeOffer offer = client.getGrandExchangeOffers()[slot];
            if (offer == null) continue;

            switch (offer.getState())
            {
                case BUYING:
                case BOUGHT:
                    geCommittedCoins += offer.getTotalPrice() - offer.getSpent();
                    break;
                default:
                    break;
            }
        }
    }

    public long getTotalWealth()
    {
        return invCoins + bankCoins + geCommittedCoins;
    }

    public void sampleWealth()
    {
        long total = getTotalWealth();
        lastSampledTotalWealth = total;
        wealthSamples.put(Instant.now(), total);
    }

    public String formatCoins(long coins)
    {
        return QuantityFormatter.formatNumber(coins);
    }

    // ---- Event helpers ----

    public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged e)
    {
        refreshCommittedGp();
    }

    public void onWidgetLoaded(WidgetLoaded e)
    {
        int groupId = e.getGroupId();
        if (groupId == BANK_GROUP_ID)
        {
            snapshotBankCoins();
        }
        else if (groupId == InventoryID.INVENTORY.getId())
        {
            refreshInventoryCoins();
        }
    }
}
