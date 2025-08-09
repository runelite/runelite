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

/**
 * Computes liquidity and asset totals.
 * Liquidity = coins in inventory (bag only). AssetTotal = bag coins + estimated value of all open GE offers.
 * Asset Total = Liquidity + estimated value of open GE offers (remaining * price).
 */
public class WealthService
{
    // --- Flip tracking (FIFO per item) ---
    private static class Batch {
        final int itemId;
        final long qtyBought;
        final long unitBuyPrice;   // gp per unit
        long qtySold = 0;
        long revenueGp = 0;
        long taxGp = 0;

        Batch(int itemId, long qtyBought, long unitBuyPrice) {
            this.itemId = itemId;
            this.qtyBought = Math.max(0, qtyBought);
            this.unitBuyPrice = Math.max(0, unitBuyPrice);
        }

        long remaining() { return Math.max(0, qtyBought - qtySold); }
        boolean complete() { return remaining() == 0; }
    }

    private final java.util.Map<Integer, java.util.ArrayDeque<Batch>> buyQueues = new java.util.HashMap<>();
    private net.runelite.client.plugins.fancyflip.ledger.LedgerService ledgerRef;

    public void setLedger(net.runelite.client.plugins.fancyflip.ledger.LedgerService ledger) {
        this.ledgerRef = ledger;
        if (ledger != null) this.taxRatePct = ledger.getTaxRatePct();
    }

    private java.util.ArrayDeque<Batch> queueFor(int itemId) {
        return buyQueues.computeIfAbsent(itemId, k -> new java.util.ArrayDeque<>());
    }

    private static final int COINS_ID = 995;
    private final java.util.Map<String,Integer> slotFilled = new java.util.HashMap<>();
    private double taxRatePct = 1.0; // default 1%%


    private final Client client;

    @Getter private long lastKnownBankCoins = 0L;
    @Getter private long committedGp = 0L; // GP tied up in open BUY offers

    public WealthService(Client client)
    {
        this.client = client;
    }

    /** Live count of coins in inventory. Must be called on the client thread. */
    public long getInventoryCoins()
    {
        ItemContainer inv = client.getItemContainer(InventoryID.INVENTORY);
        if (inv == null) return 0L;

        long coins = 0L;
        for (Item it : inv.getItems())
        {
            if (it == null) continue;
            if (it.getId() == COINS_ID) coins += (long) it.getQuantity();
        }
        return coins;
    }

    /** Snapshot bank coins; safe to call only when bank is open (BANK_GROUP_ID loaded). */
    private void snapshotBankCoins()
    {
        ItemContainer bank = client.getItemContainer(InventoryID.BANK);
        if (bank == null) return;
        long coins = 0L;
        for (Item it : bank.getItems())
        {
            if (it == null) continue;
            if (it.getId() == COINS_ID) coins += (long) it.getQuantity();
        }
        lastKnownBankCoins = coins;
    }

    /** Recompute GP currently committed in open BUY offers. */
    public void refreshCommittedGp()
    {
        committedGp = 0L;

        GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
        if (offers == null) return;

        for (GrandExchangeOffer o : offers)
        {
            if (o == null) continue;

            final GrandExchangeOfferState state = o.getState();
            if (state == GrandExchangeOfferState.BUYING)
            {
                long total = (long) o.getTotalQuantity();
                long bought = (long) o.getQuantitySold();
                long remaining = Math.max(total - bought, 0L);

                committedGp += remaining * (long) o.getPrice();
            }
        }
    }

    /** Liquidity = coins in inventory (+ bank, if included) minus committed BUY GP. */
    public long getLiquidity(boolean includeBankCoins)
    {
        // Deprecated param kept for back-compat; ignored.
        return getInventoryCoins();
    }

    /** Convenience: Liquidity including bank coins. */
    public long getLiquidityGp()
    {
        return getInventoryCoins();
    }

    /** Estimated value of all open GE offers (remaining quantity * offered price). */
    public long getOpenPosValueGp()
    {
        long total = 0L;
        GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
        if (offers == null) return 0L;

        for (GrandExchangeOffer o : offers)
        {
            if (o == null) continue;
            GrandExchangeOfferState s = o.getState();
            if (s == GrandExchangeOfferState.EMPTY) continue;

            int remaining = Math.max(0, o.getTotalQuantity() - o.getQuantitySold());
            total += (long) remaining * (long) o.getPrice();
        }
        return total;
    }

    /**
     * Asset total = Liquidity + open position value (estimated).
     * Optionally include bank coins in Liquidity computation.
     */
    public long getAssetTotalGp(long openPosValueGp, boolean includeBankCoins)
    {
        // Ignore flags; compute from inventory and provided open value
        long inv = getInventoryCoins();
        long open = Math.max(openPosValueGp, 0L);
        return inv + open;
    }

    
    /** Asset total = inventory coins + estimated open GE value. */
    public long getAssetTotalGp()
    {
        return getInventoryCoins() + getOpenPosValueGp();
    }
// -----------------------------------------------------------------------
    // Event hooks
    // -----------------------------------------------------------------------

    
public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged e)
    {
        refreshCommittedGp();

        GrandExchangeOffer o = e.getOffer();
        if (o == null) return;
        int itemId = o.getItemId();
        GrandExchangeOfferState state = o.getState();
        int filled = o.getQuantitySold();
        int total = o.getTotalQuantity();
        int price = o.getPrice();

        // Track fills incrementally per slot by remembering last seen filled count
        // Use a simple slot-based key
        int slot = e.getSlot();
        String key = "slot_" + slot + "_filled";
        int prevFilled = slotFilled.getOrDefault(key, 0);
        int delta = Math.max(0, filled - prevFilled);
        slotFilled.put(key, filled);

        if (delta <= 0) return;

        if (state == GrandExchangeOfferState.BUYING || state == GrandExchangeOfferState.BOUGHT)
        {
            // Enqueue a new batch for the delta amount
            queueFor(itemId).addLast(new Batch(itemId, delta, price));
        }
        else if (state == GrandExchangeOfferState.SELLING || state == GrandExchangeOfferState.SOLD)
        {
            // Allocate sold qty across buy batches FIFO
            long remainingToMatch = delta;
            java.util.ArrayDeque<Batch> q = queueFor(itemId);
            while (remainingToMatch > 0 && !q.isEmpty())
            {
                Batch b = q.peekFirst();
                long take = Math.min(remainingToMatch, b.remaining());
                b.qtySold += take;
                long revenue = take * (long) price;
                long tax = (long) Math.floor((revenue * taxRatePct) / 100.0); // using same rate as ledger
                b.revenueGp += revenue;
                b.taxGp += tax;
                remainingToMatch -= take;

                if (b.complete())
                {
                    q.removeFirst();
                    long cost = b.qtyBought * b.unitBuyPrice;
                    long profit = b.revenueGp - b.taxGp - cost;
                    if (ledgerRef != null)
                    {
                        ledgerRef.recordFlip(profit, Math.max(0L, b.taxGp), Math.max(0L, cost));
                    }
                }
            }
        }
    }


    public void onWidgetLoaded(WidgetLoaded e)
    {
        int gid = e.getGroupId();
        if (gid == WidgetID.BANK_GROUP_ID)
        {
            snapshotBankCoins();
        }
        // Inventory sampling is triggered in the plugin.
    }
}
