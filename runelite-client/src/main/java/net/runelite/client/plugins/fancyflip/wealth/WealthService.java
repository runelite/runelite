package net.runelite.client.plugins.fancyflip.wealth;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;

public class WealthService
{
    private static final int COINS_ID = 995;

    private final Client client;

    @Getter private long lastKnownBankCoins = 0L;
    @Getter private long committedGp = 0L; // GP tied up in open GE BUY offers

    public WealthService(Client client)
    {
        this.client = client;
    }

    /** Live count of coins in inventory. */
    public long getInventoryCoins()
    {
        ItemContainer inv = client.getItemContainer(InventoryID.INVENTORY);
        if (inv == null) return 0L;

        long coins = 0L;
        for (Item it : inv.getItems())
        {
            if (it != null && it.getId() == COINS_ID)
            {
                coins += it.getQuantity();
            }
        }
        return coins;
    }

    /** Snapshot coins in bank. Call when bank is opened. */
    public void snapshotBankCoins()
    {
        ItemContainer bank = client.getItemContainer(InventoryID.BANK);
        if (bank == null) return;

        long coins = 0L;
        for (Item it : bank.getItems())
        {
            if (it != null && it.getId() == COINS_ID)
            {
                coins += it.getQuantity();
            }
        }
        lastKnownBankCoins = coins;
    }

    /** Recalculate GP committed in open BUY offers. */
    public void refreshCommittedGp()
    {
        committedGp = 0L;

        GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
        if (offers == null) return;

        for (GrandExchangeOffer o : offers)
        {
            if (o == null) continue;

            GrandExchangeOfferState state = o.getState();
            if (state == GrandExchangeOfferState.BUYING)
            {
                long total = (long) o.getTotalQuantity();
                long sold = (long) o.getQuantitySold();
                long remaining = Math.max(total - sold, 0L);

                if (remaining > 0L)
                {
                    committedGp += remaining * (long) o.getPrice();
                }
            }
        }
    }

    /** Liquid = inventory coins - com**/
