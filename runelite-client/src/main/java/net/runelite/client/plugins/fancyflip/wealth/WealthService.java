/*
 * Copyright (c) 2025, Codex <codex@openai.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.fancyflip.wealth;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;

public class WealthService
{
    private static final int COINS_ID = 995;

    private final Client client;
    @Getter private long lastKnownBankCoins = 0;
    @Getter private long committedGp = 0; // GP tied in open GE buy offers

    public WealthService(Client client) { this.client = client; }

    public long getInventoryCoins()
    {
        ItemContainer inv = client.getItemContainer(InventoryID.INVENTORY);
        if (inv == null) return 0;
        long coins = 0;
        for (Item it : inv.getItems()) if (it != null && it.getId() == COINS_ID) coins += it.getQuantity();
        return coins;
    }

    /** Call when bank is opened to snapshot coins. */
    public void snapshotBankCoins()
    {
        ItemContainer bank = client.getItemContainer(InventoryID.BANK);
        if (bank == null) return;
        long coins = 0;
        for (Item it : bank.getItems()) if (it != null && it.getId() == COINS_ID) coins += it.getQuantity();
        lastKnownBankCoins = coins;
    }

    /** Recalculate committed GP from current GE offers. */
    public void refreshCommittedGp()
    {
        committedGp = 0;
        GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
        if (offers == null) return;
        for (GrandExchangeOffer o : offers)
        {
            if (o == null) continue;
            // For BUY offers, remaining quantity * price per item = committed GP
            if (o.getState() == GrandExchangeOfferState.BUYING)
            {
                long remaining = (long)o.getTotalQuantity() - o.getQuantitySold();
                committedGp += remaining * o.getPrice();
            }
        }
    }

    public long getLiquidGp()
    {
        // Liquid = inventory coins - committed buys (cannot spend twice)
        long inv = getInventoryCoins();
        long liquid = inv - committedGp;
        return Math.max(liquid, 0);
    }

    public long getTotalWealth(boolean includeBank, long openPosValueGp)
    {
        long total = getInventoryCoins() + committedGp + openPosValueGp;
        if (includeBank)
        {
            total += lastKnownBankCoins;
        }
        return total;
    }
}
